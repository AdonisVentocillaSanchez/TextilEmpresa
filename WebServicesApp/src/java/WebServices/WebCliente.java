/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import Modelo.Bean.ClienteBean;
import Modelo.DAO.ClienteDAO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author AUTONOMA
 */
@WebService(serviceName = "WebCliente")
@Stateless()
public class WebCliente {
    ClienteBean Cliente;
    ClienteDAO clientedao=new ClienteDAO();
    String rs="";
    /**
     * Web service operation
     */
    @WebMethod(operationName = "Agregar")
    public String Agregar(@WebParam(name = "id") int id, @WebParam(name = "name") String name, @WebParam(name = "dni") String dni, @WebParam(name = "nameemp") String nameemp, @WebParam(name = "cel") String cel, @WebParam(name = "tel") String tel, @WebParam(name = "user") String user, @WebParam(name = "pass") String pass, @WebParam(name = "email") String email) {
        //TODO write your implementation code here:
        Cliente=new ClienteBean(id, name, dni, nameemp, cel, tel, user, pass, email);
        System.out.println("Llego al Web Service "+Cliente.getIdcliente()+" "+Cliente.getNombre());
        if(clientedao.registrar(Cliente)){
            rs="Registrado";
            
        }else{
            rs="No registrado";
        }
        return rs;
    }
}
