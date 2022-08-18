/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.capitan;

import modelo.transporte.TransporteDTO;

/**
 *
 * @author afprietoa
 */
public class CapitanDTO {
    private Integer licencia;
    private String nombre;
    private String especie;
    private TransporteDTO transporte;

    public Integer getLicencia() {
        return licencia;
    }

    public void setLicencia(Integer licencia) {
        this.licencia = licencia;
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

    public TransporteDTO getTransporte() {
        return transporte;
    }

    public void setTransporte(TransporteDTO transporte) {
        this.transporte = transporte;
    }
    
    
}
