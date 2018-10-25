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
public class AlmacenarBean {
    
    private int idalmacenar;
    private String fecha;
    private int cantidad;
    private int idproducto;
    private int idalmacen;

    public AlmacenarBean() {
    }

    public AlmacenarBean(int idalmacenar, String fecha, int cantidad, int idproducto, int idalmacen) {
        this.idalmacenar = idalmacenar;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.idproducto = idproducto;
        this.idalmacen = idalmacen;
    }

    public int getIdalmacenar() {
        return idalmacenar;
    }

    public void setIdalmacenar(int idalmacenar) {
        this.idalmacenar = idalmacenar;
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

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getIdalmacen() {
        return idalmacen;
    }

    public void setIdalmacen(int idalmacen) {
        this.idalmacen = idalmacen;
    }
    
    
}
