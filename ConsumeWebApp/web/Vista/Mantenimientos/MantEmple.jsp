<%-- 
    Document   : MantEmple
    Created on : 24/10/2018, 10:43:18 PM
    Author     : ANDRES
--%>

<%--<%@page import="Entidades.Paciente"%>--%>
<%@page import ="java.util.ArrayList"%>

<%--!
    	ArrayList<Paciente>  listReg;
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/jquery-3.3.1.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/BuscadorTabla.js" type="text/javascript"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.3.1.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script>
            function actualizar(){
                        var dni1 = document.getElementById("DNI").value ;
                        var nom1 = document.getElementById("nombre").value;
                        var ape1 = document.getElementById("apellido").value;
                        var seg1 = document.getElementById("seguro").value;
                        var ecivil1 = document.getElementById("ecivil").value;
                        var tel1 = document.getElementById("telefono").value;
                        var sex1 = document.getElementById("sexo").value;
                        var  fechanac1 = document.getElementById("fechanac").value;
                        var dir1 = document.getElementById("direccion").value;
                        var nhistmed1 = document.getElementById("nhistmed").value;
                    
                        document.formR.action = "<%=request.getContextPath()%>/AdminPaciente?opcion=4&DNI="+dni1+
                    "&nombre="+nom1+"&apellido="+ape1+"&seguro="+seg1+"&ecivil="+ecivil1+"&telefono="+tel1+"&sexo="+sex1+
                    "&fechanac="+fechanac1+"&direccion="+dir1+"&nhistmed="+nhistmed1;
                    
                        
                        alert("Sé está pidiendo actualizar al usuario "+dni1);
                        document.formR.submit();
                }
            
        </script>
        <script>
             function ver(dni,nom,ape,sex,ecivil,fechanac,seg,tel,dir,nhistmed){
             alert("entra a ver"+dni+nom+ape+seg+ecivil+tel+sex+fechanac+dir+nhistmed);
                document.getElementById("DNI").value =dni;
                document.getElementById("nombre").value =nom;
                document.getElementById("apellido").value=ape;
                document.getElementById("seguro").value=seg;
                document.getElementById("ecivil").value=ecivil;
                document.getElementById("telefono").value=tel;
                document.getElementById("sexo").value=sex;
                document.getElementById("fechanac").value=fechanac;
                document.getElementById("direccion").value=dir;
                document.getElementById("nhistmed").value=nhistmed;
                
            }
        </script>
        <script> 
        
        function eliminar(dni)
        {
            
            document.formu.action="<%=request.getContextPath()%>/AdminPaciente?opcion=5&DNI="+dni;
            document.formu.submit();
            alert("Has eliminado al usuario "+dni);
        }
        </script>
    </head>
    <body>
        <div class="text-success text-center bg-warning col-lg-push-10"><h1>Mantenimiento de Pacientes</h1></div>
        
<!--         Aquí empieza la tabla de ingresar datos --->

<div class="container">
    <br>    
    <form  input type="submit" name="formR" action="<%=request.getContextPath()%>/AdminPaciente" method="post">
        <div class="container">
            <br>
            <div class="form-inline has-error text-center">
            <label class="control-label " for="inputError" >DNI:</label>
            <input class="form-control text-center" type="text" id="DNI" name="DNI" value="" placeholder="Ingrese el DNI">
            <label class="control-label ">Nombre:</label>            
            <input class="form-control text-center" type="text" id="nombre" name="nombre" value="" placeholder="Nombres">
            <label class="control-label ">Apellido:</label>            
            <input class="form-control text-center" type="text" id="apellido" name="apellido" value="" placeholder="Apellidos" >
            </div>
            <br>
            <div class="form-inline has-warning text-center">
            <label class="control-label">Seguro:</label> 
            <input class="form-control text-center" type="text" id="seguro" name="seguro" value="" placeholder="Seguro">
            <label class="control-label">Estado civil:</label>    
            <input class="form-control text-center" type="text" id="ecivil" name="ecivil" value="" placeholder="Estado Civil" >
            <label class="control-label">Telefono:</label>            
            <input class="form-control text-center" type="text" id="telefono" name="telefono" value="" placeholder="Telefono/Cel" >
            </div>
            <br>
            <div class="form-inline has-success text-center ">
            <label class="control-label">Sexo:</label>            
            <input class="form-control text-center" type="radio" id="sexo" name="sexo" value="Masculino"> Masculino 
            <input class="form-control text-center" type="radio" id="sexo" name="sexo" value="femenino"> Femenino<br>          
            </div>
            <br>
            <div class="form-inline has-error text-center">
            <label class="control-label">Fecha de nacimiento:</label>            
            <input class="form-control text-center" type="date" id="fechanac" name="fechanac" value="" placeholder="Fecha Nac." >
            <label class="control-label">Direccion:</label>            
            <input class="form-control text-center" type="text" id="direccion" name="direccion" value="" placeholder="Direccion">
            <label class="control-label">Nro Historial Medico:</label>            
            <input class="form-control text-center" type="text" id="nhistmed" name="nhistmed" value="" placeholder="Nro.Historial">
            </div>
            <br>
            <div class="container text-center">
                        <input type="hidden" name="opcion" value="1">
                    <tr><td><input class="btn-success" type="submit" value="Registrar" /></td>
                        <td><input class="btn-info" type="button" value="Modificar" onclick="actualizar()"></td>
                        <td><input class="btn-warning" type="reset" value="Limpiar Campos"/></td>
                    </tr>
            </div>        
        </div>
           
                       
        </form>
</div>
               
<!--              Aquí empieza la tabla de mostrar                       -->            
        

<div class="container">
            <form name="formu" method="post">
            <!--<input type="hidden" name= "opcion" value="3">-->
            <br>
            <label>Buscar: </label>
            <input class="form-control" id="TerminoXbusqueda" type="text" onkeyup="doSearch()" />
            <br>
            <br>
            <table class="table table-bordered table-hover table-condensed" id="datos">
                <thead>
                    <tr class="success">
                    <th class="text-center" >DNI</th>
                    <th class="text-center">Nombre</th>
                    <th class="text-center">Apellido</th>
                    <th class="text-center">Sexo</th>
                    <th class="text-center">Estado civil</th>
                    <th class="text-center">Fecha de nacimiento</th>
                    <th class="text-center">Tipo de Seguro</th>
                    <th class="text-center">Dirección</th>
                    <th class="text-center">Teléfono</th>
                    <th class="text-center">Historial médico</th>
                    <th class="text-center">Seleccionar</th>
                    <th class="text-center">Eliminar</th>
                    </tr>
                </thead>    
                <tbody>
                <%--if((listReg= (ArrayList<Paciente>)request.getAttribute("lista"))!=null){
                    for(Paciente u:listReg)
                    {
                %>
                    <tr>
                    <td><%=u.getDni_pac()%></td>
                    <td><%=u.getNom_pac()%></td>
                    <td><%=u.getApe_pac()%></td>
                    <td><%=u.getSex_pac()%></td>
                    <td><%=u.getEstci_pac()%></td>
                    <td><%=u.getFechanac_pac()%></td>
                    <td><%=u.getSeg_pac()%></td>
                    <td><%=u.getDir_pac()%></td>
                    <td><%=u.getTel_pac()%></td>
                    <td><%=u.getNhistmed_pac()%></td>
                    
                    
          
                    <td align="center"><input type="button" class="btn-info btn-sm" value="Ver" onclick="ver('<%=u.getDni_pac()%>','<%=u.getNom_pac()%>',
                                '<%=u.getApe_pac()%>','<%=u.getSex_pac()%>','<%=u.getEstci_pac()%>','<%=u.getFechanac_pac()%>',
                                '<%=u.getSeg_pac()%>','<%=u.getTel_pac()%>','<%=u.getDir_pac()%>','<%=u.getNhistmed_pac()%>')" ></td>
                    <td align="center"><input  type="button" class="btn-danger btn-sm" value="Eliminar" onclick="eliminar('<%=u.getDni_pac()%>')" ></td>        
                    </tr>
                </tbody>
                <%
                    }

                
                }--%>
                    
            </table>
        
        </form>
                    
                    
    </center>
</div>
    </body>
</html>
