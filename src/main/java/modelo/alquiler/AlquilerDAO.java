/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.alquiler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.AbstractDAO;
import modelo.VehiculoDTO;
import modelo.cliente.ClienteDTO;

/**
 *
 * @author afprietoa
 */
public class AlquilerDAO extends AbstractDAO<AlquilerDTO> {

    public AlquilerDAO(Connection conexion) {
        super(conexion, "alquiler", "a_id", new String[]{
              "a_cliente", "a_vehiculo", "a_fecha", "a_ocasion", "a_duracion", "a_costo"});
    }
    
    
    @Override
    protected AlquilerDTO ensamblar(ResultSet result) throws SQLException {
        AlquilerDTO dto = new AlquilerDTO();
        dto.setId(result.getInt(1));
        
        ClienteDTO cliente = new ClienteDTO();
        cliente.setIdentidad(result.getInt(2));
        dto.setCliente(cliente);
        
        VehiculoDTO vehiculo = new VehiculoDTO();
        vehiculo.setMatricula(result.getInt(3));
        dto.setVehiculo(vehiculo);
        
        dto.setFecha(result.getString(4));
        dto.setOcasion(result.getString(5));
        dto.setDuracion(result.getInt(6));
        dto.setCosto(result.getDouble(7));


        return dto;
    }

    @Override
    protected void fijarColumnas(PreparedStatement statement, AlquilerDTO dto) throws SQLException {
        statement.setInt(1, dto.getId());
        statement.setInt(2, dto.getCliente().getIdentidad());
        statement.setInt(3, dto.getVehiculo().getMatricula());
        statement.setString(4, dto.getFecha());
        statement.setString(5, dto.getOcasion());
        statement.setInt(6, dto.getDuracion());
        statement.setDouble(7, dto.getCosto());
    }

    @Override
    protected List<String> camposActualizacion(AlquilerDTO dto) {
        List<String> campos = new ArrayList<>();
        if(dto.getCliente() != null){
            campos.add("a_cliente = " + dto.getCliente());
        }
        if(dto.getVehiculo() != null){
            campos.add("a_vehiculo = " + dto.getVehiculo());
        }
        if(dto.getFecha() != null){
            campos.add("a_fecha = " + dto.getFecha());
        }
        if(dto.getOcasion() != null){
            campos.add("a_ocasion = " + dto.getOcasion());
        }
        if(dto.getDuracion() != null){
            campos.add("a_duracion = " + dto.getDuracion());
        }
        if(dto.getCosto() != null){
            campos.add("a_costo = " + dto.getCosto());
        }
        return campos;
    }
    
}
