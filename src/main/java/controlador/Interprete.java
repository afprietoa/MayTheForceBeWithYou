package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.fasterxml.jackson.databind.ObjectMapper;

import comun.Entidad;
import comun.Operacion;
import comun.RetoException;
import modelo.alquiler.AlquilerDTO;
import modelo.alquiler.GestorAlquiler;
import modelo.capitan.CapitanDTO;
import modelo.capitan.GestorCapitan;
import modelo.cliente.ClienteDTO;
import modelo.cliente.GestorCliente;
import modelo.ligero.GestorLigero;
import modelo.ligero.LigeroDTO;
import modelo.transporte.GestorTransporte;
import modelo.transporte.TransporteDTO;

public class Interprete {

    private static String RESPUESTA_EXITOSA = "{\"respuesta\": \"Operación Exitosa\"}";

    private static String RESPUESTA_FALLIDA = "{\"respuesta\": \"Operación Fallida\"}";

    private Connection conexion;

    private ObjectMapper mapeador;

    private GestorTransporte gestorTransporte;
    
    private GestorLigero gestorLigero;
    
    private GestorCapitan gestorCapitan;
    
    private GestorCliente gestorCliente;
    
    private GestorAlquiler gestorAlquiler;

    public Interprete(String nombre) throws RetoException {
        try {
            //conexion = DriverManager.getConnection("jdbc:sqlite:" + nombre);
            String dbURL = "jdbc:mysql://127.0.0.1:3306/" + nombre;
            String username = "root";
            String password = "8746554201";
            conexion = DriverManager.getConnection(dbURL, username, password);
            mapeador = new ObjectMapper();
            gestorTransporte = new GestorTransporte(conexion);
            gestorLigero = new GestorLigero(conexion);
            gestorCapitan = new GestorCapitan(conexion, gestorTransporte);
            gestorCliente = new GestorCliente(conexion);
            gestorAlquiler = new GestorAlquiler(conexion, gestorCliente);
        } catch (SQLException ex) {
            throw new RetoException("No se puede establecer conexión", ex);
        }
    }

    public String procesarComando(Operacion operacion, Entidad entidad, String json) throws RetoException {
        switch (entidad) {
            case TRANSPORTE:
                return procesarTransporte(operacion, json);
            case LIGERO:
                return procesarLigero(operacion, json);
            case CAPITAN:
                return procesarCapitan(operacion, json);
            case CLIENTE:
                return procesarCliente(operacion, json);
            case ALQUILER:
                return procesarAlquiler(operacion, json);
            default:
                throw new RetoException("No Existe la tabla",
                        new UnsupportedOperationException("Operación No Implementada"));
        }
    }

    private String procesarTransporte(Operacion operacion, String json) throws RetoException {
        try {
            TransporteDTO dto = mapeador.readValue(json, TransporteDTO.class);
            switch (operacion) {
                case CREAR:
                    return gestorTransporte.registrarTransporte(dto) ? RESPUESTA_EXITOSA : RESPUESTA_FALLIDA;

                case ACTUALIZAR:
                    return gestorTransporte.actualizarTransporte(dto) ? RESPUESTA_EXITOSA
                            : RESPUESTA_FALLIDA;

                case ELIMINAR:
                    return gestorTransporte.eliminarTransporte(dto.getMatricula()) ? RESPUESTA_EXITOSA
                            : RESPUESTA_FALLIDA;
                default:
                    // Si tiene ID
                    if (dto.getMatricula() != null) {
                        TransporteDTO transporteDTO = gestorTransporte
                                .recuperarTransporte(dto.getMatricula());
                        if (transporteDTO != null) {
                            return mapeador.writeValueAsString(transporteDTO);
                        }
                        return RESPUESTA_FALLIDA;
                    } else {
                        return mapeador.writeValueAsString(gestorTransporte.recuperarTransportes());
                    }
            }
        } catch (Exception ex) {
            throw new RetoException("No es posible procesar la petición", ex);
        }
    }

    private String procesarLigero(Operacion operacion, String json) throws RetoException{
        try{
            LigeroDTO dto = mapeador.readValue(json, LigeroDTO.class);
            switch(operacion){
                case CREAR:
                    return gestorLigero.registrarLigero(dto) ? RESPUESTA_EXITOSA : RESPUESTA_FALLIDA;
                case ACTUALIZAR:
                    return gestorLigero.actualizarLigero(dto) ? RESPUESTA_EXITOSA : RESPUESTA_FALLIDA;
                case ELIMINAR:
                    return gestorLigero.eliminarLigero(dto.getMatricula()) ? RESPUESTA_EXITOSA : RESPUESTA_FALLIDA;
                default:
                    if(dto.getMatricula() != null){
                        LigeroDTO ligeroDTO = gestorLigero.recuperarLigero(dto.getMatricula());
                        if(ligeroDTO != null){
                           return mapeador.writeValueAsString(ligeroDTO);
                        }
                        return RESPUESTA_FALLIDA;
                    }else{
                       return mapeador.writeValueAsString(gestorLigero.recuperarLigeros());
                    }
                    
            }
        }catch(Exception ex){
            throw new RetoException("No es posible procesar la peticiión", ex);
        }
    }

    private String procesarCapitan(Operacion operacion, String json) throws RetoException{
        try{
            CapitanDTO dto = mapeador.readValue(json, CapitanDTO.class);
            switch(operacion){
                case CREAR:
                    return gestorCapitan.registrarCapitan(dto) ? RESPUESTA_EXITOSA : RESPUESTA_FALLIDA;
                case ACTUALIZAR:
                    return gestorCapitan.actualizarCapitan(dto) ? RESPUESTA_EXITOSA : RESPUESTA_FALLIDA;
                case ELIMINAR:
                    return gestorCapitan.eliminarCapitan(dto.getLicencia()) ? RESPUESTA_EXITOSA : RESPUESTA_FALLIDA;
                default:
                    if(dto.getLicencia() != null){
                        CapitanDTO capitanDTO = gestorCapitan.recuperarCapitan(dto.getLicencia());
                        if(capitanDTO != null){
                            return mapeador.writeValueAsString(capitanDTO);
                        }
                        return RESPUESTA_FALLIDA;
                    }else{
                        return mapeador.writeValueAsString(gestorCapitan.recuperarCapitanes());
                    }
                    
                    
            }
        }catch(Exception ex){
            
            throw new RetoException("No es posible procesar la petición", ex);
        }
    }
    
    private String procesarCliente(Operacion operacion, String json) throws RetoException{
            try {
            ClienteDTO dto = mapeador.readValue(json, ClienteDTO.class);
            switch (operacion) {
                case CREAR:
                    return gestorCliente.registrarCliente(dto) ? RESPUESTA_EXITOSA : RESPUESTA_FALLIDA;

                case ACTUALIZAR:
                    return gestorCliente.actualizarCliente(dto) ? RESPUESTA_EXITOSA
                            : RESPUESTA_FALLIDA;

                case ELIMINAR:
                    return gestorCliente.eliminarCliente(dto.getIdentidad()) ? RESPUESTA_EXITOSA
                            : RESPUESTA_FALLIDA;
                default:
                    // Si tiene ID
                    if (dto.getIdentidad() != null) {
                        ClienteDTO clienteDTO = gestorCliente
                                .recuperarCliente(dto.getIdentidad());
                        if (clienteDTO != null) {
                            return mapeador.writeValueAsString(clienteDTO);
                        }
                        return RESPUESTA_FALLIDA;
                    } else {
                        return mapeador.writeValueAsString(gestorCliente.recuperarClientes());
                    }
            }
        } catch (Exception ex) {
            throw new RetoException("No es posible procesar la petición", ex);
        }
    }
    
    private String procesarAlquiler(Operacion operacion, String json) throws RetoException {
            try {
                AlquilerDTO dto = mapeador.readValue(json, AlquilerDTO.class);
            switch (operacion) {
                case CREAR:
                    return gestorAlquiler.registrarAlquiler(dto) ? RESPUESTA_EXITOSA : RESPUESTA_FALLIDA;

                case ACTUALIZAR:
                    return gestorAlquiler.actualizarAlquiler(dto) ? RESPUESTA_EXITOSA
                            : RESPUESTA_FALLIDA;

                case ELIMINAR:
                    return gestorAlquiler.eliminarAlquiler(dto.getId()) ? RESPUESTA_EXITOSA
                            : RESPUESTA_FALLIDA;
                default:
                    // Si tiene ID
                    if (dto.getId() != null) {
                        AlquilerDTO alquilerDTO = gestorAlquiler
                                .recuperarAlquiler(dto.getId());
                        if (alquilerDTO != null) {
                            return mapeador.writeValueAsString(alquilerDTO);
                        }
                        return RESPUESTA_FALLIDA;
                    } else {
                        return mapeador.writeValueAsString(gestorAlquiler.recuperarAlquileres());
                    }
            }
        } catch (Exception ex) {
            throw new RetoException("No es posible procesar la petición", ex);
        }
    }
    
    public void listo() {
        try {
            if (conexion != null)
                conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }






}
