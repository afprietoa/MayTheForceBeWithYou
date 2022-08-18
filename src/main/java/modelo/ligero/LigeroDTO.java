/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.ligero;

import modelo.VehiculoDTO;

/**
 *
 * @author afprietoa
 */
public class LigeroDTO {
    private VehiculoDTO vehiculo;
    private String color;
    private String androide;

    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAndroide() {
        return androide;
    }

    public void setAndroide(String androide) {
        this.androide = androide;
    }
    
    public Integer getMatricula(){
        if(vehiculo!=null){
            return vehiculo.getMatricula();
        }
        return null;
    }
    
    public void setMatricula(Integer matricula){
        if(vehiculo == null){
            vehiculo = new VehiculoDTO();
        }
        vehiculo.setMatricula(matricula);
    }
}
