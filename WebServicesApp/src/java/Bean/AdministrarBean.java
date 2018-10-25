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
public class AdministrarBean {
    
    private int idproducto;
    private int idempleado;

    public AdministrarBean() {
    }

    public AdministrarBean(int idproducto, int idempleado) {
        this.idproducto = idproducto;
        this.idempleado = idempleado;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }
    
}
