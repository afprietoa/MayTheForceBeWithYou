/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.cliente;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author afprietoa
 */
public class GestorCliente {
    private ClienteDAO clienteDAO;

    public GestorCliente(Connection conexion) {
        clienteDAO = new ClienteDAO(conexion);
    }
    
    public boolean registrarCliente(ClienteDTO dto) throws SQLException{
        if(clienteDAO.crear(dto)){
            return clienteDAO.crear(dto);
        }
        return false;
    }
    
    public boolean eliminarCliente(Integer identidad) throws SQLException{
         if (clienteDAO.remover(identidad)){
             return clienteDAO.remover(identidad);
         }
         return false;
    }
    
    public boolean actualizarCliente(ClienteDTO dto) throws SQLException{
        
        if(dto.getNombre() != null ||
           dto.getEspecie() != null ||
           dto.getGenero() != null){
            return clienteDAO.actualizar(dto.getIdentidad(), dto);
        }
        return false;
    }
    
    public ClienteDTO recuperarCliente(Integer identidad) throws SQLException{
        ClienteDTO respuesta =clienteDAO.recuperar(identidad);       
        return respuesta;
    }
    
    public List<ClienteDTO> recuperarClientes() throws SQLException{
        List<ClienteDTO> respuesta = clienteDAO.recuperarTodo();
        return respuesta;
    }
    
}
