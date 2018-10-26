<%-- 
    Document   : Signup
    Created on : 25-oct-2018, 13:37:22
    Author     : AUTONOMA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link  href="<%=request.getContextPath()%>/css/signup.css" rel="stylesheet">
        <script>
             function agregar(){
                
                var id =document.getElementById("id").value;
                var nom=document.getElementById("name").value;
                alert("Entro2");
                var dni = document.getElementById("dni").value;
                var nameemp = document.getElementById("nameemp").value;
                var cel=document.getElementById("cel").value;
                var tel=document.getElementById("tel").value;
                var usu=document.getElementById("user").value;
                var pass=document.getElementById("password").value;
                var email=document.getElementById("email").value;
                //document.formS.action ="<%=request.getContextPath()%>/SignUpServlet?name="+nom;
               alert("entra a ver"+id+nom+dni+nameemp+cel+tel+usu+pass+email);
                
                
                
                document.formS.submit();
                
            }
        </script>
    </head>
    <body>
        <h2>Modal Signup Form</h2>
<%-- 
    private int idcliente;
    private String nombre;
    private String dni;
    private String nombre_empresa;
    private String celular;
    private String telefono;
    private String usuario_cliente;
    private String contraseña_cliente;
    private String email;
--%>

<form name="formS" class="modal-content" method="post" action ="<%=request.getContextPath()%>/SignUpServlet">
    <div class="container">
      <h1>Sign Up</h1>
      <p>Please fill in this form to create an account.</p>
      <hr>
      <label for=""><b>ID</b></label>
      <input type="text" placeholder="Enter ID" id="id" name="id" required>

      <label for="name"><b>Nombre</b></label>
      <input type="text" placeholder="Enter Password" id="name" name="name" required>

      <label for="dni"><b>Dni</b></label>
      <input type="text" placeholder="Enter Dni" id="dni" name="dni" required>
      
      <label for=""><b>Nombre de Empresa</b></label>
      <input type="text" placeholder="Enter Nombre de Empresa" id="nameemp" name="nameemp">
      
      <label for="cel"><b>Celular</b></label>
      <input type="tel" placeholder="Enter Celular" id="cel" name="cel" required>
      
      <label for=""><b>Teléfono</b></label>
      <input type="tel" placeholder="Enter Telefono" id="tel" name="tel" required>
      
      <label for="usu"><b>Usuario</b></label>
      <input type="text" placeholder="Enter Tel" id="user" name="user" required>
      
      <label for="email"><b>Email</b></label>
      <input type="email" placeholder="Enter Tel" id="email" name="email" required>
      
      <label for="cel"><b>Contraseña</b></label>
      <input type="password" placeholder="Enter Password" id="password" name="password" required>
      
      <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

      <div class="clearfix">
        <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
        <button type="button" class="signupbtn" onclick="agregar()">Sign Up</button>
      </div>
    </div>
  </form>
</div>

<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
    </body>
</html>
