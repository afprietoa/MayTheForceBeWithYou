/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.AbstractDAO;

/**
 *
 * @author afprietoa
 */
public class ClienteDAO extends AbstractDAO<ClienteDTO> {

    public ClienteDAO(Connection conexion) {
        super(conexion, "cliente", "c_identidad", new String[]{
                "c_nombre", "c_especie", "c_genero"});
    }

    @Override
    protected ClienteDTO ensamblar(ResultSet result) throws SQLException {
        ClienteDTO dto = new ClienteDTO();
        dto.setIdentidad(result.getInt(1));
        dto.setNombre(result.getString(2));
        dto.setEspecie(result.getString(3));
        dto.setGenero(result.getString(4));
        return dto;
    }
    
    @Override
    protected void fijarColumnas(PreparedStatement statement, ClienteDTO dto) throws SQLException {
        statement.setInt(1, dto.getIdentidad());
        statement.setString(2, dto.getNombre());
        statement.setString(3, dto.getEspecie());
        statement.setString(4, dto.getGenero());
    }

    @Override
    protected List<String> camposActualizacion(ClienteDTO dto) {
       List<String> campos = new ArrayList<>();
       if(dto.getNombre()!= null){
           campos.add("c_nombre = " + dto.getNombre());
       }
       if(dto.getEspecie() != null){
           campos.add("c_especie = " + dto.getEspecie());           
       }
       if(dto.getGenero() != null){
           campos.add("c_genero = " + dto.getGenero());           
       }
       return campos;
    }
    
}
