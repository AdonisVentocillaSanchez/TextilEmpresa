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
public class EmpleadoBean {
    
    private int idempleado;
    private String nombres;
    private String apellidopaterno;
    private String apellidomaterno;
    private char sexo;
    private String estadocivil1;
    private String fechanacimiento;
    private String nacionalidad;
    private String direccion;
    private String telefono;
    private String dni;
    private String cargo;

    public EmpleadoBean() {
    }

    public EmpleadoBean(int idempleado, String nombres, String apellidopaterno, String apellidomaterno, char sexo, String estadocivil1, String fechanacimiento, String nacionalidad, String direccion, String telefono, String dni, String cargo) {
        this.idempleado = idempleado;
        this.nombres = nombres;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.sexo = sexo;
        this.estadocivil1 = estadocivil1;
        this.fechanacimiento = fechanacimiento;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.dni = dni;
        this.cargo = cargo;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEstadocivil1() {
        return estadocivil1;
    }

    public void setEstadocivil1(String estadocivil1) {
        this.estadocivil1 = estadocivil1;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
}
