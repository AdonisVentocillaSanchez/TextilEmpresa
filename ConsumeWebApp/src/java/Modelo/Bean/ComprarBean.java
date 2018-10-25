/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Bean;

/**
 *
 * @author Erika Sanchez
 */
public class ComprarBean {
    
    private int idcomprar;
    private String fecha;
    private int cantidad;
    private double precioventa;
    private int idcliente;
    private int idproducto;

    public ComprarBean() {
    }

    public ComprarBean(int idcomprar, String fecha, int cantidad, double precioventa, int idcliente, int idproducto) {
        this.idcomprar = idcomprar;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.precioventa = precioventa;
        this.idcliente = idcliente;
        this.idproducto = idproducto;
    }

    public int getIdcomprar() {
        return idcomprar;
    }

    public void setIdcomprar(int idcomprar) {
        this.idcomprar = idcomprar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }
    
    
}
