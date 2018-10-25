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
public class ProveedorBean {
    
    private int idproveedor;
    private String nombre;
    private String telefono;
    private String direccion;
    private String celular;

    public ProveedorBean() {
    }

    public ProveedorBean(int idproveedor, String nombre, String telefono, String direccion, String celular) {
        this.idproveedor = idproveedor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.celular = celular;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
}
