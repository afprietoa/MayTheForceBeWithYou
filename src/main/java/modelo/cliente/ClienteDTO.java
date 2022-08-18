/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.cliente;

import modelo.capitan.*;
import modelo.transporte.TransporteDTO;

/**
 *
 * @author afprietoa
 */
public class ClienteDTO {
    private Integer identidad;
    private String nombre;
    private String especie;
    private String genero;

    public Integer getIdentidad() {
        return identidad;
    }

    public void setIdentidad(Integer identidad) {
        this.identidad = identidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
    
}
