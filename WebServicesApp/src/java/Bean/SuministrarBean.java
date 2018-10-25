/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author Erika Sanchez
 */
public class SuministrarBean {
    
    private int idSuministrar;
    private String fecha;
    private int cantidad;
    private double preciocompra;
    private int idproducto;
    private int idproveedor;

    public SuministrarBean() {
    }

    public SuministrarBean(int idSuministrar, String fecha, int cantidad, double preciocompra, int idproducto, int idproveedor) {
        this.idSuministrar = idSuministrar;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.preciocompra = preciocompra;
        this.idproducto = idproducto;
        this.idproveedor = idproveedor;
    }

    public int getIdSuministrar() {
        return idSuministrar;
    }

    public void setIdSuministrar(int idSuministrar) {
        this.idSuministrar = idSuministrar;
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

    public double getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(double preciocompra) {
        this.preciocompra = preciocompra;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }
    
    
    
}
