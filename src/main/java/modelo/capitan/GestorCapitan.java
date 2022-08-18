/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.capitan;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import modelo.transporte.GestorTransporte;
import modelo.transporte.TransporteDTO;

/**
 *
 * @author afprietoa
 */
public class GestorCapitan {
    private GestorTransporte gestorTransporte;
    private CapitanDAO capitanDAO;

    public GestorCapitan(Connection conexion, GestorTransporte gestorTransporte) {
        this.gestorTransporte = gestorTransporte;
        capitanDAO = new CapitanDAO(conexion);
    }
    
    public boolean registrarCapitan(CapitanDTO dto) throws SQLException{
        if(capitanDAO.crear(dto)){
            return capitanDAO.crear(dto);
        }
        return false;
    }
    
    public boolean eliminarCapitan(Integer matricula) throws SQLException{
         if (capitanDAO.remover(matricula)){
             return capitanDAO.remover(matricula);
         }
         return false;
    }
    
    public boolean actualizarCapitan(CapitanDTO dto) throws SQLException{
        
        if(dto.getNombre() != null ||
           dto.getEspecie() != null ||
           dto.getTransporte() != null){
            return capitanDAO.actualizar(dto.getLicencia(), dto);
        }
        return false;
    }
    
    public CapitanDTO recuperarCapitan(Integer licencia) throws SQLException{
        CapitanDTO respuesta =capitanDAO.recuperar(licencia);
        
        if(respuesta != null && respuesta.getTransporte() != null){
            TransporteDTO transporte = gestorTransporte.recuperarTransporte(respuesta.getTransporte().getMatricula());
            respuesta.setTransporte(transporte);
        }
        return respuesta;
    }
    
    public List<CapitanDTO> recuperarCapitanes() throws SQLException{
        List<CapitanDTO> respuesta = capitanDAO.recuperarTodo();
        for(CapitanDTO capitanDTO : respuesta){
            if(capitanDTO != null && capitanDTO.getTransporte() != null){
               capitanDTO.setTransporte(gestorTransporte.recuperarTransporte(capitanDTO.getTransporte().getMatricula()));
            }
            
        }
        return respuesta;
    }
    
}
