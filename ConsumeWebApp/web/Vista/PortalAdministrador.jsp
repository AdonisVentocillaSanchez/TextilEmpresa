<%-- 
    Document   : PortalAdministrador
    Created on : 24-oct-2018, 16:50:59
    Author     : AUTONOMA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
        
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
           <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Portal</a>
    </div>
    <ul class="nav navbar-nav">
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Mantenimientos<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Empleados</a></li>
          <li><a href="#">Productos</a></li>
          <li><a href="#">Proximamente</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Procesos<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Comprar</a></li>
          <li><a href="#">Suministrar</a></li>
          <li><a href="#">Almacenar</a></li>
        </ul>
      </li>
      <li><a href="#">En proceso</a></li>
    </ul>
  </div>
</nav>
        <%----------Tablas ----%>
        
        <%@include  file="Mantenimientos/MantEmple.jsp"%>
    </body>
</html>
