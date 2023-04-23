/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa06;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author wbpat
 */
@Entity(name="Venta")
public class Venta {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name="clave")
    private int clave;
    
    @Column(name="fecha")
    private String fecha;
    
    @Column(name="monto")
    private double monto;
    
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)    
    private List<DetVenta> detVentas= new ArrayList<>();

    public List<DetVenta> getDetVentas() {
        return detVentas;
    }
    
     public void setDetVentas(List<DetVenta> detVentas) {
        this.detVentas = detVentas;
    }

     public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
 
}
