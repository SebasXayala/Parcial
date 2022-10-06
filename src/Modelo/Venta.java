/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author juans
 */
public class Venta {
    
    private String codProducto;
    private String nombreprod;
    private String CantidadVent;
    private String fechaVent;
    private int valorTotal;
    

    public Venta(String codProducto, String nombreprod, String CantidadVent, String fechaVent, int valorTotal) {
        this.codProducto = codProducto;
        this.nombreprod = nombreprod;
        this.CantidadVent = CantidadVent;
        this.fechaVent = fechaVent;
        this.valorTotal = valorTotal;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombreprod() {
        return nombreprod;
    }

    public void setNombreprod(String nombreprod) {
        this.nombreprod = nombreprod;
    }

    public String getCantidadVent() {
        return CantidadVent;
    }

    public void setCantidadVent(String CantidadVent) {
        this.CantidadVent = CantidadVent;
    }

    public String getFechaVent() {
        return fechaVent;
    }

    public void setFechaVent(String fechaVent) {
        this.fechaVent = fechaVent;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
    
    
    
}
