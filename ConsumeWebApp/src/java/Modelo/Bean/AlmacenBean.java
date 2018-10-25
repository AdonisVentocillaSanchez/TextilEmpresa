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
public class AlmacenBean {
    
    private int idalmacen;
    private int capacidadtotal;
    private int capacidadocupada;

    public AlmacenBean() {
    }

    public AlmacenBean(int idalmacen, int capacidadtotal, int capacidadocupada) {
        this.idalmacen = idalmacen;
        this.capacidadtotal = capacidadtotal;
        this.capacidadocupada = capacidadocupada;
    }

    public int getIdalmacen() {
        return idalmacen;
    }

    public void setIdalmacen(int idalmacen) {
        this.idalmacen = idalmacen;
    }

    public int getCapacidadtotal() {
        return capacidadtotal;
    }

    public void setCapacidadtotal(int capacidadtotal) {
        this.capacidadtotal = capacidadtotal;
    }

    public int getCapacidadocupada() {
        return capacidadocupada;
    }

    public void setCapacidadocupada(int capacidadocupada) {
        this.capacidadocupada = capacidadocupada;
    }
    
    
}
