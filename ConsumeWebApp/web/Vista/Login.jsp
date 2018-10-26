<%-- 
    Document   : Login
    Created on : 24/10/2018, 07:46:52 PM
    Author     : ANDRES
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/css/login.css" rel="stylesheet">
        <script src="<%=request.getContextPath()%>/js/javascript.js" type="text/javascript"></script>
    <body>
        
        <div class="bg-1" style="border-color: black" >
  
            <form name="form" action="<%=request.getContextPath()%>/LoginServlet" method="post">
    
      
    <div class="container" role='form'>
      <label for="usuario"><b>Usuario</b></label>
      <input type="text" placeholder="Enter Username" name="usuario" id="txtusu">

      <label for="clave"><b>Contraseña</b></label>
      <input type="password" placeholder="Enter Password" name="password" id="txtcla">
        
      <button type="submit">Entrar</button>
      
    </div>

    
  </form>
</div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
