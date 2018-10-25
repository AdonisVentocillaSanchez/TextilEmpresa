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
public class ClienteBean {
    
    private int idcliente;
    private String nombre;
    private String dni;
    private String nombre_empresa;
    private String celular;
    private String telefono;
    private String usuario_cliente;
    private String contraseña_cliente;

    public ClienteBean() {
    }

    public ClienteBean(int idcliente, String nombre, String dni, String nombre_empresa, String celular, String telefono, String usuario_cliente, String contraseña_cliente) {
        this.idcliente = idcliente;
        this.nombre = nombre;
        this.dni = dni;
        this.nombre_empresa = nombre_empresa;
        this.celular = celular;
        this.telefono = telefono;
        this.usuario_cliente = usuario_cliente;
        this.contraseña_cliente = contraseña_cliente;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario_cliente() {
        return usuario_cliente;
    }

    public void setUsuario_cliente(String usuario_cliente) {
        this.usuario_cliente = usuario_cliente;
    }

    public String getContraseña_cliente() {
        return contraseña_cliente;
    }

    public void setContraseña_cliente(String contraseña_cliente) {
        this.contraseña_cliente = contraseña_cliente;
    }
    
}
