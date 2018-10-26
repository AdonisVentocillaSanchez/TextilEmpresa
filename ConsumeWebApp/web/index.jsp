
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>:: ALPACA S.A.C ::</title>

    <!-- Bootstrap -->
    <link href="<%request.getContextPath();%>css/talvar.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">
    

    </head>
    <body>    
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#myPage">Alpaca</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
          <li><a href="index.jsp">Inicio</a></li>
        <li><a href="">Contacto</a></li>
        <li><a href="">Ofertas</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">MORE
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
              <li><a href="Vista/Login.jsp">Iniciar Sesión</a></li>
              <li><a href="Vista/Mantenimientos/Signup.jsp" >Registrarse</a></li>
            
          </ul>
        </li>
        <li><a href="#"><span class="glyphicon glyphicon-search"></span></a></li>
      </ul>
    </div>
  </div>
</nav>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
          <img src="image/tela-roja.jpg" alt="Rojo" width="1200" height="500">
        <div class="carousel-caption">
          <h2>Tela de carmís roja</h2>
          <p>Desde la selva peruana se extraen los más intensos colores.</p>
        </div>      
      </div>

      <div class="item">
          <img src="image/tela-beish.jpg" alt="Beish" width="1200" height="500">
        <div class="carousel-caption">
          <h3>Tela de asemejanza andina</h3>
          <p>Como los colores naturales de nuestras estepas más extensas.</p>
        </div>      
      </div>
    
      <div class="item">
          <img src="image/tela-verde-a-azul.jpg" alt="Azul" width="1200" height="500">
        <div class="carousel-caption">
          <h3>Telas de aqua azul</h3>
          <p>Los colores más vivos de nuestros andes peruanos nos revelan los colores de nuestro hermoso mar.</p>
        </div>      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>

<div class="container text-center">
  <h3>Alpaca S.A.C</h3>
  <p><em>Empresa peruana símbolo de calidad internacional</em></p>
  <p>¿Acaso puede ser más perfecta ella?</p>
  <br>
</div>

<!-- Container (TOUR Section) -->
<div class="bg-1">
  <div class="container">
    <h3 class="text-center">Telas especiales de hoy</h3>
    <p class="text-center">Esto es solo una prueba de valor.<br> Recuerda comprar todo lo que hay disponible!</p>
    <ul class="list-group">
      <li class="list-group-item">September <span class="label label-danger">Proximamente!</span></li>
      <li class="list-group-item">October <span class="label label-danger">Proximamente!</span></li> 
      <li class="list-group-item">November <span class="label label-danger">Proximamente!</span></li> 
    </ul>
    
    <div class="row text-center">
      <div class="col-sm-4">
        <div class="thumbnail">
            <img src="image/telas/tela-bull-crudo.jpg" alt="bull-crudo" width="400" height="300">
          <p><strong>Tela Bull Crudo</strong></p>
          <p>Viernes 25 de noviembre 2015</p>
          <button class="btn">Comprar</button>
        </div>
      </div>
      <div class="col-sm-4">
        <div class="thumbnail">
            <img src="image/telas/tela-corsat.jpg" alt="corsat" width="400" height="300">
          <p><strong>Tela Corsat</strong></p>
          <p>Sábado 28 de Noviembre de 2015</p>
          <button class="btn">Comprar</button>
        </div>
      </div>
      <div class="col-sm-4">
        <div class="thumbnail">
            <img src="image/telas/tela-grisa.jpg" alt="grisa" width="400" height="300">
          <p><strong>Tela Grisa</strong></p>
          <p>Sun. 29 November 2015</p>
          <button class="btn">Comprar</button>
        </div>
      </div>
        <div class="col-sm-4">
        <div class="thumbnail">
            <img src="image/telas/tela-port.jpg" alt="port" width="400" height="300">
          <p><strong>Tela Port</strong></p>
          <p>Sun. 29 November 2015</p>
          <button class="btn">Comprar</button>
        </div>
      </div>
    </div>
  </div>
</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>

    </body>
</html>
