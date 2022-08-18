/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.alquiler;

import java.sql.Connection;
import modelo.VehiculoDAO;
import modelo.cliente.GestorCliente;
import java.sql.SQLException;
import java.util.List;
import modelo.VehiculoDTO;
import modelo.cliente.ClienteDTO;

/**
 *
 * @author afprietoa
 */
public class GestorAlquiler {
    private GestorCliente gestorCliente;
    private VehiculoDAO vehiculoDAO;
    private AlquilerDAO alquilerDAO;

    public GestorAlquiler(Connection conexion, GestorCliente gestorCliente) {
        this.gestorCliente = gestorCliente;
        vehiculoDAO = new VehiculoDAO(conexion);
        alquilerDAO = new AlquilerDAO(conexion);
    }
    
    public boolean registrarAlquiler(AlquilerDTO dto) throws SQLException{
        if(alquilerDAO.crear(dto)){
            return alquilerDAO.crear(dto);
        }
        return false;
    }
    
    public boolean eliminarAlquiler(Integer id) throws SQLException{
         if (alquilerDAO.remover(id)){
             return alquilerDAO.remover(id);
         }
         return false;
    }
    
    public boolean actualizarAlquiler(AlquilerDTO dto) throws SQLException{
        
        if(dto.getCliente() != null ||
           dto.getVehiculo() != null ||
           dto.getFecha() != null ||
           dto.getOcasion() != null ||
           dto.getDuracion() != null ||
           dto.getCosto() != null){
            return alquilerDAO.actualizar(dto.getId(), dto);
        }
        return false;
    }
    
    public AlquilerDTO recuperarAlquiler(Integer id) throws SQLException{
        AlquilerDTO respuesta =alquilerDAO.recuperar(id);
        
        if(respuesta != null && respuesta.getCliente() != null && respuesta.getVehiculo() != null){
            ClienteDTO cliente = gestorCliente.recuperarCliente(respuesta.getCliente().getIdentidad());
            respuesta.setCliente(cliente);
            
            VehiculoDTO vehiculoDTO = vehiculoDAO.recuperar(respuesta.getVehiculo().getMatricula());
            respuesta.setVehiculo(vehiculoDTO);
        }
        return respuesta;
    }
    
    public List<AlquilerDTO> recuperarAlquileres() throws SQLException{
        List<AlquilerDTO> respuesta = alquilerDAO.recuperarTodo();
        for(AlquilerDTO alquilerDTO : respuesta){
            if(alquilerDTO != null && alquilerDTO.getCliente() != null && alquilerDTO.getVehiculo() != null){
               alquilerDTO.setCliente(gestorCliente.recuperarCliente(alquilerDTO.getCliente().getIdentidad()));
               alquilerDTO.setVehiculo(vehiculoDAO.recuperar(alquilerDTO.getVehiculo().getMatricula()));
            }
            
        }
        return respuesta;
    }
    
}
