/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa06;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author wbpat
 */
@Entity(name="DetVenta")
public class DetVenta {
    @Id
    @Column(name="claveproducto")
    private int claveproducto;
    
    @Column(name="cantidad")
    private float cantidad;
    
    @Column(name="precio")
    private float precio;
    
    @Column(name="subtotal")
    private float subtotal;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="clave")
    private Venta venta;

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getClaveproducto() {
        return claveproducto;
    }

    public void setClaveproducto(int claveproducto) {
        this.claveproducto = claveproducto;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
}
}
