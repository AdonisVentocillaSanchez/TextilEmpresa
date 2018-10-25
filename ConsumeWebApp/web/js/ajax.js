//REUTILIZABLES CON JQUERY

function Ajax(tipoparametro,ruta,servlet,op,parametros,div){
  $.ajax(
  {
    type: "POST",
    dataType: 'html',
    url: ruta+"/"+servlet+"Servlet",
    data: "op="+op+"&"+parametros,
    beforeSend: function() {
     
    },
    success: function (datos) {
      $(div).html(datos);
    }
  }
  
  );
  
}

  //loadin en ajax 
  $(document).ajaxStart(function(){
    //const pre = Prelodr()
    //pre.show('Cargando...')
    mostrar()
    $(document).ajaxStop(function(){
      //pre.hide()   
        cerrar()
    });
  });
 function mostrar() {
            div = document.getElementById('barra_material_design');
            div.style.display = '';
        }

        function cerrar() {
            div = document.getElementById('barra_material_design');
            div.style.display = 'none';
        }

  function cargarinactividad (){
     var device = navigator.userAgent
      if (device.match(/Iphone/i)|| 
              device.match(/Ipod/i)|| 
              device.match(/Android/i)|| 
              device.match(/J2ME/i)||
              device.match(/BlackBerry/i)||
              device.match(/iPhone|iPad|iPod/i)|| 
              device.match(/Opera Mini/i)||
              device.match(/IEMobile/i)|| 
              device.match(/Mobile/i)||
              device.match(/Windows Phone/i)||
              device.match(/windows mobile/i)||
              device.match(/windows ce/i)||
              device.match(/webOS/i)|| 
              device.match(/palm/i)|| 
              device.match(/bada/i)||
              device.match(/series60/i)|| 
              device.match(/nokia/i)|| 
              device.match(/symbian/i)||
              device.match(/HTC/i)){}
else
{
var temp = setTimeout(redireccion, 30000);

    document.addEventListener("click", function() {
      clearTimeout(temp);
      temp = setTimeout(redireccion, 30000);
    })
}}

      
      
      
    
  
  function redireccion() {
    swal({
      title: "Deseas salir del Menu por Inactividad?",
      text: "Tendras que iniciar sesion nuevamente ",
      type: "warning",
      showCancelButton: true,
      confirmButtonColor: "#DD6B55",
      confirmButtonText: "SALIR",
      cancelButtonText: "CANCELAR",
      closeOnConfirm: true,
      closeOnCancel: false
    },
    function(isConfirm){
      if (isConfirm) {
       window.location = "index.jsp";
       
     } else {
      swal("Cancelado", "No se grabo ningun dato", "error");
    }
  });
    
  }


//accion teclado con javascript
function validar(e,ruta) {
  tecla = (document.all) ? e.keyCode : e.which;
  if (tecla==13) enter(ruta)
}


function grabar(ruta, tabla, op, parametros)
{
 swal({
  title: "Desea grabar el registro?",
  text: "Los datos seran registrados en la base de datos",
  type: "warning",
  showCancelButton: true,
  confirmButtonColor: "#DD6B55",
  confirmButtonText: "GRABAR",
  cancelButtonText: "CANCELAR",
  closeOnConfirm: true,
  closeOnCancel: false
},
function(isConfirm){
  if (isConfirm) {
   Ajax("GET",ruta,tabla,op,parametros,"#carrusel");
   
 } else {
  swal("Cancelado", "No se grabo ningun dato", "error");
}
});
}

function eliminar(ruta, tabla, op, parametros)
{
  
  swal({
    title: "Desea eliminar el registro?",
    text: "Los datos seran eliminados permanentemente",
    type: "warning",
    showCancelButton: true,
    confirmButtonColor: "#DD6B55",
    confirmButtonText: "ELIMINAR",
    cancelButtonText: "CANCELAR",
    closeOnConfirm: true,
    closeOnCancel: false
  },
  function(isConfirm){
    if (isConfirm) {
      Ajax("GET",ruta,tabla,op,parametros,"#carrusel");  
      
    } else {
      swal("Cancelado", "No se elimino ningun dato", "error");
    }
  });
}



function modificar(ruta, tabla, op, parametros)
{
 swal({
  title: "Desea modificar el registro?",
  text: "Los datos seran modificados en la base de datos",
  type: "warning",
  showCancelButton: true,//se muestre el boton cancelar
  confirmButtonColor: "#DD6B55",
  confirmButtonText: "MODIFICAR",
  cancelButtonText: "CANCELAR",
  closeOnConfirm: true,//al confirmar el boton modificar se cierre la alerta
  closeOnCancel: false//al  cancelar me envia a la funcion
},
function(isConfirm){
  if (isConfirm) {
   Ajax("GET",ruta,tabla,op,parametros,"#carrusel");  
   
 } else {
  swal("Cancelado", "No se modifico ningun dato", "error");
}
});
}


function cargar(ruta, tabla, op, parametros)
{
  Ajax("GET",ruta,tabla,op,parametros,"#carrusel")
}

//LOGIN
 //funcion para no  retroceder despues de cerrar sesion
 function bloqueo(){
  window.location.hash="no-back-button";
                window.location.hash="Again-No-back-button" //chrome
                window.onhashchange=function(){window.location.hash="no-back-button";}
                
                //NOTIFICACION
                Push.create("INICIE SESION PORFAVOR", {
                  body: "Gestion de proyecto ",
                  icon:"./imagenes/link1.jpg",
                  timeout: 4000,
                  onClick: function () {
                    window.focus();
                    this.close();
                  }
                });
              } 
              function netflix(ruta){
               var rutat=ruta+"/ProyectoServlet?op=22";
               document.form.action=rutat;
               document.form.method="POST";
               document.form.submit();
             }   
//login
function enter(ruta){
  var rutatotal, usuario,clave,seleccion;
  rutatotal=ruta+"/JefeServlet?op=23";
  usuario=document.form.txtnombre.value;
  clave=document.form.txtcontra.value;
  seleccion=document.getElementById('txtseleccion').value;
  
  if(seleccion=='0'){
    alertify.warning("SELECCIONAR CATEGORIA PARA INGRESAR");
    
    document.form.txtseleccion.focus();
    return ;
  }else
  if(usuario==''){
                //alert("Ingrese el usuario por favor!!");
                alertify.warning("Ingrese el usuario por favor!!");
                document.form.txtnombre.focus();
                return;
              }else if(clave==''){
               //alert("Ingrese la clave por favor!!");
               alertify.warning("Ingrese la clave por favor!!");
               document.form.txtcontra.focus();
               return;
             }else{
              document.form.action=rutatotal;
              document.form.method="POST";
              document.form.submit();
             swal({ //alerta
              title: "Iniciando sesion",
              text: "Espere por favor ......",
              timer: 6000,
              showConfirmButton: false
            });
           }
         }
        //netflix login
        function login2(ruta){
          var rutatotal, usuario,clave,seleccion;
          rutatotal=ruta+"/JefeServlet?op=26";
          
          document.form.txtproy.focus();
          document.form.action=rutatotal;
          document.form.method="POST";
          document.form.submit();
        }
        
        //cerrar sesion del menu 
        function cerrarsesion(ruta){
          swal({
            title: "Desea cerrar sesion?",
            text: "Elija por favor ",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "Cerrar Sesion",
            cancelButtonText: "Cancelar",
            closeOnConfirm: false,
            closeOnCancel: false
          },
          function(isConfirm){
            if (isConfirm) {
   //$(location).attr('href',""+ruta+ "/inicio/menu3ajax.jsp"); 
   $(location).attr('href',""+ruta+ "/index.jsp"); 
 } else {
  swal("CERRAR SESION CANCELADO", "ISAGEN", "error");
}
});
        }
        
        
 //bienvenido al ingresar al menu
 function bienvenido(ruta){
   window.location.hash="no-back-button";
               window.location.hash="Again-No-back-button" //chrome
               window.onhashchange=function(){window.location.hash="no-back-button";}
               swal({
                title: "Bienvenido :<small>"+ruta+" </small>",

                html: true
              });
               
               Push.create("Bienvenido:"+ruta+"", {
                body: "Gestion de proyecto ",
                icon:"./imagenes/link1.jpg",
                timeout: 4000,
                onClick: function () {
                  window.focus();
                  this.close();
                }
              });
               
             }
             

//cargar en orden para onload
function  ingresarmenu(ruta){
     show2();//reloj
     bienvenido(ruta);//bienvenido al ingresar menu
     
   }

//salir del login a menu principal 
function SALIRDELLOGIN(ruta){
 document.form.action=""+ruta+"/inicio/menu3ajax.jsp";
 document.form.method="POST";
 document.form.submit();
}





//boton para grabar
function MenuOpciones(ruta,tabla,op)
{  
 $.ajax(
  {   type:"GET",
  dataType: 'html',
  url:ruta+"/"+tabla+"Servlet",
  data:"op="+op,
  success:function(datos)
  {   $("#carrusel").html(datos);
  
  $(document).ready(function()
    {   $("#menu").click(function()
    {
      
    });
  });
}
});
 
}

function paginacion(){
 $(document).ready(function()
  {$('#tabla').DataTable(
    {   "language":
    {   "sProcessing": "Procesando...",
    "sLengthMenu": "Mostrar _MENU_ registros",
    "sZeroRecords": "No se encontraron resultados",
    "sEmptyTable": "Ningun dato disponible en esta tabla",
    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
    "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
    "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
    "sInfoPostFix": "",
    "sSearch": "Buscar:",
    "sUrl": "",
    "sInfoThousands": ",",
    "sLoadingRecords": "Cargando...",
    "oPaginate": 
    {   "sFirst": "Primero",
    "sLast": "Utimo",
    "sNext": "Siguiente",
    "sPrevious": "Anterior"
  },
  "oAria":
  {   "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
  "sSortDescending": ": Activar para ordenar la columna de manera descendente"
}
}
});
});
 
}

function login(ruta,tabla,op)
{  
 $.ajax(
  {   type:"GET",
  dataType: 'html',
  url:ruta+"/"+tabla+"Servlet",
  data:"op="+op,
  success:function(datos)
  {   $("#carrusel").html(datos);
}
});
 
 
 
}
        //salir de un formulario
        function salir(ruta,tabla,op)
        {  
         $.ajax(
          {   type:"GET",
          dataType: 'html',
          url:ruta+"/"+tabla+"Servlet",
          data:"op="+op,
          success:function(datos)
          {   $("#carrusel").html(datos);
        }
      });
         
         
         
       }
//SEGURIDAD PERSONAL
function modificarLoginPersonal(ruta)
{    var codigo,nombre,correo,telefono,horas,dias,id,pass,numproy;
  
  
  codigo=document.form.txtcod.value;
  nombre=document.form.txtnom.value;
  correo=document.form.txtema.value;
  telefono=document.form.txttel.value;
  horas=document.form.txthoras.value;
  dias=document.form.txtdias.value;
  
  id=document.form.txtid.value;
  pass=document.form.txtpass.value;
  numproy=document.form.txtnumproy.value;

  var parametros = '';
  
  parametros = "txtcod=" + codigo + "&";
  parametros += "txtnom=" + nombre + "&";
  parametros += "txtema=" + correo+ "&";
  parametros += "txttel=" + telefono + "&";
  parametros += "txthoras=" + horas + "&";
  parametros += "txtdias=" + dias+ "&";

  parametros += "txtid=" + id + "&";
  parametros += "txtpass=" + pass + "&";
  parametros+="txtnumproy="+numproy+"&";
  
  if(numproy=='0'){
    alertify.warning("Elija proyecto para incluir al personal");
    document.form.txtnumproy.focus();
    return;
  }else
  if(codigo==''){
    alertify.warning("Ingrese el Codigo del Personal");
    document.form.txtcod.focus();
    return;
  }else if(nombre==''){
    alertify.warning("Ingrese el Nombre del Personal");
    document.form.txtnom.focus();
    return;
  }else if(correo==''){
    alertify.warning("Ingrese el correo");
    document.form.txtema.focus();
    return;
  }else if(telefono==''){
    alertify.warning("Ingrese el telefono");
    document.form.txttel.focus();
    return;
  }else if(horas==''){
    alertify.warning("Ingrese las horas laborales");
    document.form.txthoras.focus();
    return;
  }else if(dias==''){
    alertify.warning("Ingrese los dias laborales");
    document.form.txtdia.focus();
    return;
    
  }else if(id==''){
    alertify.warning("Ingrese el id del personal");
    document.form.txtid.focus();
    return;
    
  }else if(pass==''){
    alertify.warning("Ingrese el password del personal");
    document.form.txtpass.focus();
    return;
  }else{
   modificar(ruta,'Personal',11, parametros);
 }
 
 
 
 
}
function modificarLoginClavePersonal(ruta)
{    var codigo,nombre,correo,telefono,horas,dias,id,pass,nuevo,actual,numproy;
  
  codigo=document.form.txtcod.value;
  nombre=document.form.txtnom.value;
  correo=document.form.txtema.value;
  telefono=document.form.txttel.value;
  horas=document.form.txthoras.value;
  dias=document.form.txtdias.value;
  id=document.form.txtid.value;
  pass=document.form.txtpass.value;
  numproy=document.form.txtnumproy.value;
  nuevo=document.form.txtnuevo.value;
  actual=document.form.txtactual.value;

  var parametros = '';
  
  parametros = "txtcod=" + codigo + "&";
  parametros += "txtnom=" + nombre + "&";
  parametros += "txtema=" + correo+ "&";
  parametros += "txttel=" + telefono + "&";
  parametros += "txthoras=" + horas + "&";
  parametros += "txtdias=" + dias+ "&";
  parametros += "txtid=" + id + "&";
  parametros += "txtpass=" + pass + "&";
  parametros += "txtactual=" + actual + "&";
  parametros += "txtnuevo=" + nuevo + "&";
  parametros+="txtnumproy="+numproy+"&";


  if(actual==''){
    alertify.warning("Ingrese la contraseña actual ");
    document.form.txtactual.focus();
    return;
  }else if(nuevo==''){
    alertify.warning("Ingrese la nueva contraseña ");
    document.form.txtnuevo.focus();
    return;
  }else{
   
   modificar(ruta,'Personal',13, parametros);
 }
 
}


//SEGURIDAD JEFE
function modificarLoginJefe(ruta)
{    var codigo,nombre,correo,telefono,area,id,pass;
  
  
 codigo=document.form.txtcod.value;
 nombre=document.form.txtnom.value;
 correo=document.form.txtema.value;
 telefono=document.form.txttel.value;
 area=document.form.txtare.value;
 id=document.form.txtid.value;
 pass=document.form.txtpass.value;
 

 var parametros = '';
 
 parametros = "txtcod=" + codigo + "&";
 parametros += "txtnom=" + nombre + "&";
 parametros += "txtema=" + correo+ "&";
 parametros += "txttel=" + telefono + "&";
 parametros += "txtare=" + area + "&";
 parametros += "txtid=" + id + "&";
 parametros += "txtpass=" + pass + "&";
 
 
 if(codigo==''){
  alertify.warning("Ingrese el Codigo del Personal");
  document.form.txtcod.focus();
  return;
}else if(nombre==''){
  alertify.warning("Ingrese el Nombre del Personal");
  document.form.txtnom.focus();
  return;
}else if(correo==''){
  alertify.warning("Ingrese el correo");
  document.form.txtema.focus();
  return;
}else if(telefono=''){
  alertify.warning("Ingrese el telefono");
  document.form.txttel.focus();
  return;
}else if(area==''){
  alertify.warning("Ingrese las horas laborales");
  document.form.txtare.focus();
  return;
  
}else if(id==''){
  alertify.warning("Ingrese el id del personal");
  document.form.txtid.focus();
  return;
  
}else if(pass==''){
  alertify.warning("Ingrese el password del personal");
  document.form.txtpass.focus();
  return;
}else{
 modificar(ruta,'Jefe',11, parametros);                }
}

function modificarLoginClaveJefe(ruta)
{    var codigo,nombre,correo,telefono,area,id,pass,nuevo,actual;
  
  
 codigo=document.form.txtcod.value;
 nombre=document.form.txtnom.value;
 correo=document.form.txtema.value;
 telefono=document.form.txttel.value;
 area=document.form.txtare.value;
 
 id=document.form.txtid.value;
 pass=document.form.txtpass.value;
 nuevo=document.form.txtnuevo.value;
 actual=document.form.txtactual.value;

 var parametros = '';
 
 parametros = "txtcod=" + codigo + "&";
 parametros += "txtnom=" + nombre + "&";
 parametros += "txtema=" + correo+ "&";
 parametros += "txttel=" + telefono + "&";
 parametros += "txtare=" + area + "&";
 parametros += "txtid=" + id + "&";
 parametros += "txtpass=" + pass + "&";
 parametros += "txtactual=" + actual + "&";
 parametros += "txtnuevo=" + nuevo + "&";
 
 
 
 
 if(actual==''){
  alertify.warning("Ingrese la contraseña actual ");
  document.form.txtactual.focus();
  return;
}else if(nuevo==''){
  alertify.warning("Ingrese la nueva contraseña ");
  document.form.txtnuevo.focus();
  return;
}else{
 
  modificar(ruta,'Jefe',13, parametros);
}



}
function correojefe(ruta)
{   var codigo,nombre,correo,telefono,area,id,pass;
  
  
 codigo=document.form.txtcod.value;
 nombre=document.form.txtnom.value;
 correo=document.form.txtema.value;
 telefono=document.form.txttel.value;
 area=document.form.txtare.value;
 
 id=document.form.txtid.value;
 pass=document.form.txtpass.value;
 

 var parametros = '';
 
 parametros = "txtcod=" + codigo + "&";
 parametros += "txtnom=" + nombre + "&";
 parametros += "txtema=" + correo+ "&";
 parametros += "txttel=" + telefono + "&";
 parametros += "txtare=" + area + "&";
 parametros += "txtid=" + id + "&";
 parametros += "txtpass=" + pass + "&";
 
 
 
 
 
 cargar(ruta,'Jefe',18, parametros);
}
function correoperso(ruta)
{  var codigo,nombre,correo,telefono,horas,dias,id,pass,numproy;
  
  codigo=document.form.txtcod.value;
  nombre=document.form.txtnom.value;
  correo=document.form.txtema.value;
  telefono=document.form.txttel.value;
  horas=document.form.txthoras.value;
  dias=document.form.txtdias.value;
  id=document.form.txtid.value;
  pass=document.form.txtpass.value;
  numproy=document.form.txtnumproy.value;
  

  var parametros = '';
  
  parametros = "txtcod=" + codigo + "&";
  parametros += "txtnom=" + nombre + "&";
  parametros += "txtema=" + correo+ "&";
  parametros += "txttel=" + telefono + "&";
  parametros += "txthoras=" + horas + "&";
  parametros += "txtdias=" + dias+ "&";
  parametros += "txtid=" + id + "&";
  parametros += "txtpass=" + pass + "&";
  
  parametros+="txtnumproy="+numproy+"&";
  
  cargar(ruta,'Personal',19, parametros);
}           



//PROYECTO
function grabarProyecto(ruta){
  var num,tit,dur,des,tipo,fases,inicio,fin,gasto,codjefe;
  num=document.form.txtnum.value;
  tit=document.form.txttit.value;
  dur=document.form.txtdur.value;
  des=document.form.txtdes.value;
                //tipo=document.form.txttip.value;
                fases=document.form.txtcan.value;
                inicio=document.form.txtini.value;
                fin=document.form.txtfin.value;
                gasto=document.form.txtpre.value;
                
                tipo=document.getElementById('txttip').value;
                codjefe=document.getElementById('txtcodjefe').value;
                var parametros = '';
                
                parametros = "txtnum=" + num + "&";
                parametros += "txttit=" + tit + "&";
                parametros += "txtdur=" + dur + "&";
                parametros += "txtdes=" + des + "&";
                parametros += "txttip=" + tipo + "&";
                parametros += "txtcan=" + fases + "&";
                parametros += "txtini=" + inicio + "&";
                parametros += "txtfin=" + fin + "&";
                parametros += "txtpre=" + gasto + "&";
                parametros +="txtcodjefe="+ codjefe+"&";
                if(num==''){
                  alertify.warning("Ingrese el Numero del proyecto");
                  document.form.txtnum.focus();
                  return;
                }else if(tit==''){
                  alertify.warning("Ingrese el titulo del proyecto");
                  document.form.txttit.focus();
                  return;
                }else if(dur==''){
                  alertify.warning("Ingrese la duracion del proyecto completo");
                  document.form.txtdur.focus();
                  return;
                }else if(des==''){
                  alertify.warning("Ingrese la descripcion");
                  document.form.txtdes.focus();
                  return;
                }else if(tipo=='0'){
                  alertify.warning("Ingrese el tipo del proyecto");
                  document.form.txttip.focus();
                  return;
                }else if(fases==''){
                  alertify.warning("Ingrese la cantidad de fases del proyecto");
                  document.form.txtcan.focus();
                  return;
                }else if(inicio==''){
                  alertify.warning("Ingrese la fecha de inicio  del proyecto");
                  document.form.txtini.focus();
                  return;
                }else if(fin==''){
                  alertify.warning("Ingrese la finalizacion del proyecto");
                  document.form.txtfin.focus();
                  return;
                }else if(gasto==''){
                  alertify.warning("Ingrese los gastos previstos del proyecto");
                  document.form.txtpre.focus();
                  return;
                }else if(codjefe=='0'){
                  alertify.warning(" Elije el nombre del jefe encargado");
                  document.form.txtcodjefe.focus();
                  return;
                }else{
                  grabar(ruta,'Proyecto', 3, parametros);
                }
              }
              function modificarProyecto(ruta){
                var num,tit,dur,des,tipo,fases,inicio,fin,gasto,codjefe;
                num=document.form.txtnum.value;
                tit=document.form.txttit.value;
                dur=document.form.txtdur.value;
                des=document.form.txtdes.value;
                //tipo=document.form.txttip.value;
                tipo=document.getElementById('txttip').value; 
                fases=document.form.txtcan.value;
                inicio=document.form.txtini.value;
                fin=document.form.txtfin.value;
                gasto=document.form.txtpre.value;
                codjefe=document.getElementById('txtcodjefe').value;

                var parametros = '';
                
                parametros = "txtnum=" + num + "&";
                parametros += "txttit=" + tit + "&";
                parametros += "txtdur=" + dur + "&";
                parametros += "txtdes=" + des + "&";
                parametros += "txttip=" + tipo + "&";
                parametros += "txtcan=" + fases + "&";
                parametros += "txtini=" + inicio + "&";
                parametros += "txtfin=" + fin + "&";
                parametros += "txtpre=" + gasto + "&";
                parametros +="txtcodjefe="+ codjefe+"&";
                if(num==''){
                 alertify.warning("Ingrese el Numero del proyecto");
                 document.form.txtnum.focus();
                 return;
               }else if(tit==''){
                 alertify.warning("Ingrese el titulo del proyecto");
                 document.form.txttit.focus();
                 return;
               }else if(dur==''){
                 alertify.warning("Ingrese la duracion del proyecto completo");
                 document.form.txtdur.focus();
                 return;
               }else if(des==''){
                 alertify.warning("Ingrese la descripcion");
                 document.form.txtdes.focus();
                 return;
               }else if(tipo=='0'){
                 alertify.warning("Ingrese el tipo del proyecto");
                 document.form.txttip.focus();
                 return;
               }else if(fases==''){
                 alertify.warning("Ingrese la cantidad de fases del proyecto");
                 document.form.txtcan.focus();
                 return;
               }else if(inicio==''){
                 alertify.warning("Ingrese la fecha de inicio  del proyecto");
                 document.form.txtini.focus();
                 return;
               }else if(fin==''){
                 alertify.warning("Ingrese la finalizacion del proyecto");
                 document.form.txtfin.focus();
                 return;
               }else if(gasto==''){
                 alertify.warning("Ingrese los gastos previstos del proyecto");
                 document.form.txtpre.focus();
                 return;
               }else if(codjefe=='0'){
                 alertify.warning(" Elije el nombre del jefe encargado");
                 document.form.txtcodjefe.focus();
                 return;
               }else{
                modificar(ruta,'Proyecto', 6, parametros);
              }
            }
 //REQUISITO           
 function grabarRequisito(ruta){
  var num,alc,pers,reu,des,numproy;
  num=document.form.txtnum.value;
  alc=document.form.txtalc.value;
  pers=document.form.txtper.value;
  reu=document.form.txtreu.value;
  des=document.form.txtdes.value;
  numproy=document.getElementById('txtnumproy').value;
  var parametros = '';
  
  parametros = "txtnum=" + num + "&";
  parametros += "txtalc=" + alc + "&";
  parametros += "txtper=" + pers + "&";
  parametros += "txtreu=" + reu + "&";
  parametros += "txtdes=" + des + "&";
  parametros +="txtnumproy=" +numproy+ "&";
  if(numproy=='0'){
    alertify.warning("Elije el nombre del proyecto ");
    document.form.txtnumproy.focus();
    return;
    
  }else
  if(num==''){
    alertify.warning("Ingrese el Numero del proyecto");
    document.form.txtnum.focus();
    return;
  }else if(alc==''){
    alertify.warning("Ingrese el alcance del proyecto");
    document.form.txtalc.focus();
    return;
  }else if(pers==''){
    alertify.warning("Ingrese la cantidad del personal");
    document.form.txtper.focus();
    return;
  }else if(reu==''){
    alertify.warning("Ingrese la cantidad de reuniones");
    document.form.txtreu.focus();
    return;
  }else if(des==''){
    alertify.warning("Ingrese la descripcion  del proyecto");
    document.form.txtdes.focus();
    return;
  }else{
    grabar(ruta,'Requisito', 3, parametros);

  }
}
function modificarRequisito(ruta){
  var num,alc,pers,reu,des,numproy;
  num=document.form.txtnum.value;
  alc=document.form.txtalc.value;
  pers=document.form.txtper.value;
  reu=document.form.txtreu.value;
  des=document.form.txtdes.value;
  numproy=document.getElementById('txtnumproy').value;
  var parametros = '';
  
  parametros = "txtnum=" + num + "&";
  parametros += "txtalc=" + alc + "&";
  parametros += "txtper=" + pers + "&";
  parametros += "txtreu=" + reu + "&";
  parametros += "txtdes=" + des + "&";
  parametros +="txtnumproy=" +numproy+ "&";
  if(numproy=='0'){
    alertify.warning("Elije el nombre del proyecto ");
    document.form.txtnumproy.focus();
    return;
  }else
  
  if(num==''){
    alertify.warning("Ingrese el Numero del proyecto");
    document.form.txtnum.focus();
    return;
  }else if(alc==''){
    alertify.warning("Ingrese el alcance del proyecto");
    document.form.txtalc.focus();
    return;
  }else if(pers==''){
    alertify.warning("Ingrese la cantidad del personal ");
    document.form.txtper.focus();
    return;
  }else if(reu==''){
    alertify.warning("Ingrese la cantidad de reuniones ");
    document.form.txtreu.focus();
    return;
  }else if(des==''){
    alertify.warning("Ingrese la descripcion del proyecto");
    document.form.txtdes.focus();
    return;
    
  }else{
    modificar(ruta,'Requisito', 6, parametros);

  }
}

  //PROBLEMA          
  function grabarProblema(ruta)
  {    var num,nivel,des,per,numproy;
    num=document.getElementById('txtnum').value;
    nivel=document.getElementById('txtnivel').value;
    des=document.getElementById('txtdes').value;
    per=document.getElementById('txtper').value;
    numproy=document.getElementById('txtnumproy').value;
    var parametros = '';
    
    parametros = "txtnum=" + num + "&";
    parametros += "txtnivel=" + nivel + "&";
    parametros += "txtdes=" + des + "&";
    parametros += "txtper=" + per + "&";
    parametros += "txtnumproy=" + numproy + "&";


    if(numproy=='0'){
     alertify.warning("Elija el nombre del proyecto ");
     document.form.txtnumproy.focus();
     return;
   }else
   if(num==''){
    alertify.warning("Ingrese el Numero del proyecto");
    document.form.txtnum.focus();
    return;
  }else if(nivel=='0'){
    alertify.warning("Ingrese el nivel del problema");
    document.form.txtnivel.focus();
    return;
  }else if(des==''){
    alertify.warning("Ingrese la descripcion del problema");
    document.form.txtdes.focus();
    return;
  }else if(per==''){
    alertify.warning("Ingrese  a los perjudicados del problema mencionado");
    document.form.txtper.focus();
    return;
    
  }else{
   grabar(ruta,'Problema', 3, parametros);
   
 }
}

function modificarProblema(ruta)
{    var num,nivel,des,per,numproy;
  num=document.getElementById('txtnum').value;
  nivel=document.getElementById('txtnivel').value;
  des=document.getElementById('txtdes').value;
  per=document.getElementById('txtper').value;
  numproy=document.getElementById('txtnumproy').value;
  var parametros = '';
  
  parametros = "txtnum=" + num + "&";
  parametros += "txtnivel=" + nivel + "&";
  parametros += "txtdes=" + des + "&";
  parametros += "txtper=" + per + "&";
  parametros += "txtnumproy=" + numproy + "&";
  
  if(numproy=='0'){
   alertify.warning("Elija el nombre del proyecto ");
   document.form.txtnumproy.focus();
   return;
 }else
 if(num==''){
  alertify.warning("Ingrese el Numero del proyecto");
  document.form.txtnum.focus();
  return;
}else if(nivel=='0'){
  alertify.warning("Ingrese el nivel del problema");
  document.form.txtnivel.focus();
  return;
}else if(des==''){
  alertify.warning("Ingrese la descripcion del problema");
  document.form.txtdes.focus();
  return;
}else if(per==''){
  alertify.warning("Ingrese  a los perjudicados del problema mencionado");
  document.form.txtper.focus();
  return;
  
}else{
 modificar(ruta,'Problema', 6, parametros);
 
}
}
//OBJETIVOS
function grabarObjetivo(ruta){
  var num,nivel,des,fin,numproy;
  num=document.form.txtnum.value;
               // nivel=document.form.txtnivel.value;
               des=document.form.txtdes.value;
               fin=document.form.txtfin.value;
               nivel=document.getElementById("txtnivel").value;
               numproy=document.getElementById("txtnumproy").value;
               var parametros = '';
               
               parametros = "txtnum=" + num + "&";
               parametros += "txtnivel=" + nivel + "&";
               parametros += "txtdes=" + des + "&";
               parametros += "txtfin=" + fin + "&";
               parametros += "txtnumproy=" + numproy + "&";
               
               if(numproy=='0'){
                alertify.warning("Elija el nombre del proyecto");
                document.form.txtnumproy.focus();
                return;
              }else
              if(num==''){
                alertify.warning("Ingrese el Numero del objetivo");
                document.form.txtnum.focus();
                return;
              }else if(nivel=='0'){
                alertify.warning("Ingrese el nivel del objetivo");
                document.form.txtnivel.focus();
                return;
              }else if(des==''){
                alertify.warning("Ingrese la descripcion del objetivo");
                document.form.txtdes.focus();
                return;
              }else if(fin==''){
                alertify.warning("Ingrese  la finalidad del objetivo");
                document.form.txtfin.focus();
                return;
                
              }else{
                grabar(ruta,'Objetivo', 3, parametros);
              }
            }
            function modificarObjetivo(ruta){
              var num,nivel,des,fin,numproy;
              num=document.form.txtnum.value;
                //nivel=document.form.txtnivel.value;
                nivel=document.getElementById("txtnivel").value;
                des=document.form.txtdes.value;
                fin=document.form.txtfin.value;
                numproy=document.getElementById("txtnumproy").value;

                var parametros = '';
                
                parametros = "txtnum=" + num + "&";
                parametros += "txtnivel=" + nivel + "&";
                parametros += "txtdes=" + des + "&";
                parametros += "txtfin=" + fin + "&";
                parametros +="txtnumproy=" +numproy+ "&";

                
                if(numproy=='0'){
                  alertify.warning("Elija el nombre del proyecto");
                  document.form.txtnumproy.focus();
                  return;
                }else
                if(num==''){
                  alertify.warning("Ingrese el Numero del objetivo");
                  document.form.txtnum.focus();
                  return;
                }else if(nivel=='0'){
                  alertify.warning("Ingrese el nivel del objetivo");
                  document.form.txtnivel.focus();
                  return;
                }else if(des==''){
                  alertify.warning("Ingrese la descripcion del objetivo");
                  document.form.txtdes.focus();
                  return;
                }else if(fin==''){
                  alertify.warning("Ingrese  la finalidad del objetivo");
                  document.form.txtfin.focus();
                  return;
                  
                }else{
                  modificar(ruta,'Objetivo', 6, parametros);
                }
              }
              
            //JEFE
            function grabarJefe(ruta){
              
              var cod,nom,ema,tel,are,id,pass;
              cod=document.form.txtcod.value;
              nom=document.form.txtnom.value;
              ema=document.form.txtema.value;
              tel=document.form.txttel.value;
                //are=document.form.txtare.value;
                are=document.getElementById('txtare').value;
                id=document.form.txtid.value;
                pass= document.form.txtpass.value;
                var parametros = '';
                
                parametros = "txtcod=" + cod + "&";
                parametros += "txtnom=" + nom + "&";
                parametros += "txtema=" + ema + "&";
                parametros += "txttel=" + tel + "&";
                parametros += "txtare=" + are + "&";
                parametros += "txtid=" + id + "&";
                parametros += "txtpass=" + pass + "&";
                
                
                
                if(cod==''){
                  alertify.warning("Ingrese el Codigo del Jefe");
                  document.form.txtcod.focus();
                  return;
                }else if(nom==''){
                  alertify.warning("Ingrese el Nombre del Jefe");
                  document.form.txtnom.focus();
                  return;
                }else if(ema==''){
                  alertify.warning("Ingrese el correo");
                  document.form.txtema.focus();
                  return;
                }else if(tel==''){
                  alertify.warning("Ingrese el telefono");
                  document.form.txttel.focus();
                  return;
                }else if(are=='0'){
                  alertify.warning("Ingrese el area del Jefe");
                  document.form.txtare.focus();
                  return;
                  
                }else if(id==''){
                  alertify.warning("Ingrese el id del jefe");
                  document.form.txtid.focus();
                  return;
                }else if(pass==''){
                  alertify.warning("Ingrese el password del jefe");
                  document.form.txtpass.focus();
                  return;
                }
                
                
                
                else{
                  grabar(ruta,'Jefe', 3, parametros);
                }
              }
              function modificarJefe(ruta){
                
               var cod,nom,ema,tel,are,id,pass;
               cod=document.form.txtcod.value;
               nom=document.form.txtnom.value;
               ema=document.form.txtema.value;
               tel=document.form.txttel.value;
                //are=document.form.txtare.value;
                are=document.getElementById('txtare').value;
                id=document.form.txtid.value;
                pass=document.form.txtpass.value;
                
                var parametros = '';
                
                parametros = "txtcod=" + cod + "&";
                parametros += "txtnom=" + nom + "&";
                parametros += "txtema=" + ema + "&";
                parametros += "txttel=" + tel + "&";
                parametros += "txtare=" + are + "&";
                
                parametros += "txtid=" + id + "&";
                parametros += "txtpass=" + pass + "&";
                
                if(cod==''){
                  alertify.warning("Ingrese el Codigo del Jefe");
                  document.form.txtcod.focus();
                  return;
                }else if(nom==''){
                  alertify.warning("Ingrese el Nombre del Jefe");
                  document.form.txtnom.focus();
                  return;
                }else if(ema==''){
                  alertify.warning("Ingrese el correo");
                  document.form.txtema.focus();
                  return;
                }else if(tel==''){
                  alertify.warning("Ingrese el telefono");
                  document.form.txttel.focus();
                  return;
                }else if(are=='0'){
                  alertify.warning("Ingrese el area del Jefe");
                  document.form.txtare.focus();
                  return;
                  
                }else if(id==''){
                  alertify.warning("Ingrese el id del jefe");
                  document.form.txtid.focus();
                  return;
                }else if(pass==''){
                  alertify.warning("Ingrese el password del jefe");
                  document.form.txtpass.focus();
                  return;
                }
                
                
                
                else{
                  modificar(ruta,'Jefe', 6, parametros);
                }
              }


              
//PERSONAL    
function grabarPersonal(ruta){
  var cod,nom,ema,tel,hor,dia,id,pass,numproy;
  cod=document.form.txtcod.value;
  nom=document.form.txtnom.value;
  ema=document.form.txtema.value;
  tel=document.form.txttel.value;
  hor=document.form.txthor.value;
  dia=document.form.txtdia.value;
  id=document.form.txtid.value;
  pass=document.form.txtpass.value;
  numproy=document.getElementById("txtnumproy").value;
  
  
  var parametros = '';
  
  parametros = "txtcod=" + cod + "&";
  parametros += "txtnom=" + nom + "&";
  parametros += "txtema=" + ema + "&";
  parametros += "txttel=" + tel + "&";
  parametros += "txthor=" + hor + "&";
  parametros += "txtdia=" + dia + "&";
  
  parametros += "txtid=" + id + "&";
  parametros += "txtpass=" + pass + "&";
  parametros+="txtnumproy="+numproy+"&";
  
  if(numproy=='0'){
    alert("Elija el proyecto para incluir al personal");
    document.form.txtnumproy.focus();
    return;
  }else 
  if(cod==''){
    alertify.warning("Ingrese el Codigo del Personal");
    document.form.txtcod.focus();
    return;
  }else if(nom==''){
    alertify.warning("Ingrese el Nombre del Personal");
    document.form.txtnom.focus();
    return;
  }else if(ema==''){
    alertify.warning("Ingrese el correo");
    document.form.txtema.focus();
    return;
  }else if(tel==''){
    alertify.warning("Ingrese el telefono");
    document.form.txttel.focus();
    return;
  }else if(hor==''){
    alertify.warning("Ingrese las horas laborales");
    document.form.txthor.focus();
    return;
  }else if(dia==''){
    alertify.warning("Ingrese los dias laborales");
    document.form.txtdia.focus();
    return;
    
  }else if(id==''){
    alertify.warning("Ingrese el id del personal");
    document.form.txtid.focus();
    return;
    
  }else if(pass==''){
    alertify.warning("Ingrese el password del personal");
    document.form.txtpass.focus();
    return;
    
  }
  
  
  else{
    grabar(ruta,'Personal', 3, parametros);
  }
}

function modificarPersonal(ruta){
  var cod,nom,ema,tel,hor,dia,id,pass,numproy;
  cod=document.form.txtcod.value;
  nom=document.form.txtnom.value;
  ema=document.form.txtema.value;
  tel=document.form.txttel.value;
  hor=document.form.txthor.value;
  dia=document.form.txtdia.value;
  
  id=document.form.txtid.value;
  pass=document.form.txtpass.value;
  numproy=document.getElementById("txtnumproy").value;
  var parametros = '';
  
  parametros = "txtcod=" + cod + "&";
  parametros += "txtnom=" + nom + "&";
  parametros += "txtema=" + ema + "&";
  parametros += "txttel=" + tel + "&";
  parametros += "txthor=" + hor + "&";
  parametros += "txtdia=" + dia + "&";
  parametros += "txtid=" + id + "&";
  parametros += "txtpass=" + pass + "&";
  parametros +="txtnumproy="+numproy+"&";
  
  if(numproy=='0'){
    alertify.warning("Elija proyecto para incluir al personal");
    document.form.txtnumproy.focus();
    return;
  }else
  if(cod==''){
    alertify.warning("Ingrese el Codigo del Personal");
    document.form.txtcod.focus();
    return;
  }else if(nom==''){
    alertify.warning("Ingrese el Nombre del Personal");
    document.form.txtnom.focus();
    return;
  }else if(ema==''){
    alertify.warning("Ingrese el correo");
    document.form.txtema.focus();
    return;
  }else if(tel==''){
    alertify.warning("Ingrese el telefono");
    document.form.txttel.focus();
    return;
  }else if(hor==''){
    alertify.warning("Ingrese las horas laborales");
    document.form.txthor.focus();
    return;
  }else if(dia==''){
    alertify.warning("Ingrese los dias laborales");
    document.form.txtdia.focus();
    return;
    
  }else if(id==''){
    alertify.warning("Ingrese el id del personal");
    document.form.txtid.focus();
    return;
    
  }else if(pass==''){
    alertify.warning("Ingrese el password del personal");
    document.form.txtpass.focus();
    return;
  }else{
    modificar(ruta,'Personal', 6, parametros);
  }
}    

//REUNIONES
function grabarReunion(ruta){
  var num,per,fec,acu,reu,dur,numproy;
  num=document.form.txtnum.value;
  per=document.form.txtper.value;
  fec=document.form.txtfec.value;
  acu=document.form.txtacu.value;
  reu=document.form.txtreu.value;
  dur=document.form.txtdur.value;
  numproy=document.getElementById("txtnumproy").value;

  var parametros = '';
  
  parametros = "txtnum=" + num + "&";
  parametros += "txtper=" + per + "&";
  parametros += "txtfec=" + fec + "&";
  parametros += "txtacu=" + acu + "&";
  parametros += "txtreu=" + reu + "&";
  parametros += "txtdur=" + dur + "&";
  parametros +="txtnumproy=" +numproy+ "&";
  
  if(numproy=='0'){
    alert("Elija el nombre del proyecto");
    document.form.txtnumproy.focus();
    return;
  }else
  
  if(num==''){
    alertify.warning("Ingrese el Numero de la Reunion");
    document.form.txtnum.focus();
    return;
  }else if(per==''){
    alertify.warning("Ingrese el Personal de la Reunion");
    document.form.txtper.focus();
    return;    
  }else if(fec==''){
    alertify.warning("Ingrese la fecha de la Reunion");
    document.form.txtfec.focus();
    return;
  }else if(acu==''){
    alertify.warning("Ingrese el acuerdo");
    document.form.txtacu.focus();
    return;
  }else if(reu==''){
    alertify.warning("Ingrese la proxima reunion");
    document.form.txtreu.focus();
    return;
  }else if(dur==''){
    alertify.warning("Ingrese la duracion de la reunion");
    document.form.txtdur.focus();
    return;
  }else{
    grabar(ruta,'Reuniones', 3, parametros);
  }
}
function modificarReunion(ruta){
  var num,per,fec,acu,reu,dur,numproy;
  num=document.form.txtnum.value;
  per=document.form.txtper.value;
  fec=document.form.txtfec.value;
  acu=document.form.txtacu.value;
  reu=document.form.txtreu.value;
  dur=document.form.txtdur.value;
  numproy=document.getElementById("txtnumproy").value;

  
  var parametros = '';
  
  parametros = "txtnum=" + num + "&";
  parametros += "txtper=" + per + "&";
  parametros += "txtfec=" + fec + "&";
  parametros += "txtacu=" + acu + "&";
  parametros += "txtreu=" + reu + "&";
  parametros += "txtdur=" + dur + "&";
  parametros +="txtnumproy=" +numproy+ "&";
  if(numproy=='0'){
    alertify.warning("Elija el nombre del proyecto");
    document.form.txtnumproy.focus();
    return;
  }else
  if(num==''){
    alertify.warning("Ingrese el Numero de la Reunion");
    document.form.txtnum.focus();
    return;
  }else if(fec==''){
    alertify.warning("Ingrese la fecha de la Reunion");
    document.form.txtfec.focus();
    return;
  }else if(acu==''){
    alertify.warning("Ingrese el acuerdo");
    document.form.txtacu.focus();
    return;
  }else if(reu==''){
    alertify.warning("Ingrese la proxima reunion");
    document.form.txtreu.focus();
    return;
  }else if(dur==''){
    alertify.warning("Ingrese la duracion de la reunion");
    document.form.txtdur.focus();
    return;
  }else{
    modificar(ruta,'Reuniones', 6, parametros);
  }
}
function grabarReunionPersonal(ruta){
  var num,per,fec,acu,reu,dur,numproy;
  num=document.form.txtnum.value;
  per=document.form.txtper.value;
  fec=document.form.txtfec.value;
  acu=document.form.txtacu.value;
  reu=document.form.txtreu.value;
  dur=document.form.txtdur.value;
  numproy=document.form.txtnumproy.value;

  var parametros = '';
  
  parametros = "txtnum=" + num + "&";
  parametros += "txtper=" + per + "&";
  parametros += "txtfec=" + fec + "&";
  parametros += "txtacu=" + acu + "&";
  parametros += "txtreu=" + reu + "&";
  parametros += "txtdur=" + dur + "&";
  parametros +="txtnumproy=" +numproy+ "&";
  
  
  
  if(num==''){
    alertify.warning("Ingrese el Numero de la Reunion");
    document.form.txtnum.focus();
    return;
  }else if(per==''){
    alertify.warning("Ingrese el Personal de la Reunion");
    document.form.txtper.focus();
    return;    
  }else if(fec==''){
    alertify.warning("Ingrese la fecha de la Reunion");
    document.form.txtfec.focus();
    return;
  }else if(acu==''){
    alertify.warning("Ingrese el acuerdo");
    document.form.txtacu.focus();
    return;
  }else if(reu==''){
    alertify.warning("Ingrese la proxima reunion");
    document.form.txtreu.focus();
    return;
  }else if(dur==''){
    alertify.warning("Ingrese la duracion de la reunion");
    document.form.txtdur.focus();
    return;
  }else{
    grabar(ruta,'Reuniones', 10, parametros);
  }
}
function modificarReunionPersonal(ruta){
  var num,per,fec,acu,reu,dur,numproy;
  num=document.form.txtnum.value;
  per=document.form.txtper.value;
  fec=document.form.txtfec.value;
  acu=document.form.txtacu.value;
  reu=document.form.txtreu.value;
  dur=document.form.txtdur.value;
  numproy=document.form.txtnumproy.value;

  
  var parametros = '';
  
  parametros = "txtnum=" + num + "&";
  parametros += "txtper=" + per + "&";
  parametros += "txtfec=" + fec + "&";
  parametros += "txtacu=" + acu + "&";
  parametros += "txtreu=" + reu + "&";
  parametros += "txtdur=" + dur + "&";
  parametros +="txtnumproy=" +numproy+ "&";
  if(num==''){
    alertify.warning("Ingrese el Numero de la Reunion");
    document.form.txtnum.focus();
    return;
  }else if(per==''){
    alertify.warning("Ingrese el Personal de la Reunion");
    document.form.txtper.focus();
    return;    
  }else if(fec==''){
    alertify.warning("Ingrese la fecha de la Reunion");
    document.form.txtfec.focus();
    return;
  }else if(acu==''){
    alertify.warning("Ingrese el acuerdo");
    document.form.txtacu.focus();
    return;
  }else if(reu==''){
    alertify.warning("Ingrese la proxima reunion");
    document.form.txtreu.focus();
    return;
  }else if(dur==''){
    alertify.warning("Ingrese la duracion de la reunion");
    document.form.txtdur.focus();
    return;
  }else{
    modificar(ruta,'Reuniones', 11, parametros);
  }
}





//CAMBIOS
function grabarCambio(ruta){
  var num,fec,pro,imp,numproy;
  num=document.form.txtnum.value;
  fec=document.form.txtfec.value;
  pro=document.form.txtpro.value;
  imp=document.form.txtimp.value;
  numproy=document.getElementById("txtnumproy").value;

  var parametros = '';
  
  parametros = "txtnum=" + num + "&";
  parametros += "txtfec=" + fec + "&";
  parametros += "txtpro=" + pro + "&";
  parametros += "txtimp=" + imp + "&";
  parametros +="txtnumproy=" +numproy+ "&";

  if(numproy=='0'){
    alertify.warning("Elija el nombre del proyecto");
    document.form.txtnumproy.focus();
    return;
  }else
  if(num==''){
    alertify.warning("Ingrese el Numero del Cambio");
    document.form.txtnum.focus();
    return;
  }else if(fec==''){
    alertify.warning("Ingrese la fecha  de los  Cambios");
    document.form.txtfec.focus();
    return;
  }else if(pro==''){
    alertify.warning("Ingrese el proposito");
    document.form.txtpro.focus();
    return;
  }else if(imp==''){
    alertify.warning("Ingrese la importancia");
    document.form.txtimp.focus();
    return;
    
  }else{
   grabar(ruta,'Cambios', 3, parametros);
 }
}
function modificarCambio(ruta){
  var num,fec,pro,imp,numproy;
  num=document.form.txtnum.value;
  fec=document.form.txtfec.value;
  pro=document.form.txtpro.value;
  imp=document.form.txtimp.value;
  numproy=document.getElementById("txtnumproy").value;

  var parametros = '';
  
  parametros = "txtnum=" + num + "&";
  parametros += "txtfec=" + fec + "&";
  parametros += "txtpro=" + pro + "&";
  parametros += "txtimp=" + imp + "&";
  parametros +="txtnumproy=" +numproy+ "&";

  if(numproy=='0'){
    alertify.warning("Elija el nombre del proyecto");
    document.form.txtnumproy.focus();
    return;
  }else 
  if(num==''){
    alertify.warning("Ingrese el Numero del Cambio");
    document.form.txtnum.focus();
    return;
  }else if(fec==''){
    alertify.warning("Ingrese la fecha del Cambio");
    document.form.txtfec.focus();
    return;
  }else if(pro==''){
    alertify.warning("Ingrese el proposito");
    document.form.txtpro.focus();
    return;
  }else if(imp==''){
    alertify.warning("Ingrese la importancia");
    document.form.txtimp.focus();
    return;
    
  }else{
   modificar(ruta,'Cambios', 6, parametros);
 }
}
function grabarCambioPersonal(ruta){
  var num,fec,pro,imp,numproy;
  num=document.form.txtnum.value;
  fec=document.form.txtfec.value;
  pro=document.form.txtpro.value;
  imp=document.form.txtimp.value;
  numproy=document.form.txtnumproy.value;

  var parametros = '';
  
  parametros = "txtnum=" + num + "&";
  parametros += "txtfec=" + fec + "&";
  parametros += "txtpro=" + pro + "&";
  parametros += "txtimp=" + imp + "&";
  parametros +="txtnumproy=" +numproy+ "&";

  
  if(num==''){
    alertify.warning("Ingrese el Numero del Cambio");
    document.form.txtnum.focus();
    return;
  }else if(fec==''){
    alertify.warning("Ingrese la fecha de los  Cambios");
    document.form.txtfec.focus();
    return;
  }else if(pro==''){
    alertify.warning("Ingrese el proposito");
    document.form.txtpro.focus();
    return;
  }else if(imp==''){
    alertify.warning("Ingrese la importancia");
    document.form.txtimp.focus();
    return;
    
  }else{
   grabar(ruta,'Cambios', 10, parametros);
 }
}
function modificarCambioPersonal(ruta){
  var num,fec,pro,imp,numproy;
  num=document.form.txtnum.value;
  fec=document.form.txtfec.value;
  pro=document.form.txtpro.value;
  imp=document.form.txtimp.value;
  numproy=document.form.txtnumproy.value;
  var parametros = '';
  
  parametros = "txtnum=" + num + "&";
  parametros += "txtfec=" + fec + "&";
  parametros += "txtpro=" + pro + "&";
  parametros += "txtimp=" + imp + "&";
  parametros +="txtnumproy=" +numproy+ "&";

  
  if(num==''){
    alertify.warning("Ingrese el Numero del Cambio");
    document.form.txtnum.focus();
    return;
  }else if(fec==''){
    alertify.warning("Ingrese la fecha de los Cambios");
    document.form.txtfec.focus();
    return;
  }else if(pro==''){
    alertify.warning("Ingrese el proposito");
    document.form.txtpro.focus();
    return;
  }else if(imp==''){
    alertify.warning("Ingrese la importancia");
    document.form.txtimp.focus();
    return;
    
  }else{
   modificar(ruta,'Cambios', 11, parametros);
 }
}




//INTERESADOS
function grabarInteresado(ruta){
  var num,nom,imp,nec,inte,numproy;
  num=document.form.txtnum.value;
  nom=document.form.txtnom.value;
  imp=document.form.txtimp.value;
  nec=document.form.txtnec.value;
  inte=document.form.txtinte.value;
  numproy=document.getElementById("txtnumproy").value;

  var parametros = '';
  
  parametros = "txtnum=" + num + "&";
  parametros += "txtnom=" + nom + "&";
  parametros += "txtimp=" + imp + "&";
  parametros += "txtnec=" + nec + "&";  
  parametros += "txtinte=" + inte + "&";
  parametros +="txtnumproy=" +numproy+ "&";
  
  if(numproy=='0'){
    alertify.warning("Elija el nombre del proyecto");
    document.form.txtnumproy.focus();
    return;
  }else 
  if(num==''){
    alertify.warning("Ingrese el Numero del Interesado");
    document.form.txtnum.focus();
    return;
  }else if(nom==''){
    alertify.warning("Ingrese el Nombre del Interesado");
    document.form.txtnom.focus();
    return;
  }else if(imp==''){
    alertify.warning("Ingrese el importe");
    document.form.txtimp.focus();
    return;
  }else if(nec==''){
    alertify.warning("Ingrese la necesidad");
    document.form.txtnec.focus();
    return;
  }else if(inte==''){
    alertify.warning("Ingrese el interes");
    document.form.txtinte.focus();
    return;
    
  }else{
    grabar(ruta,'Interesados', 3, parametros);
  }
}
function modificarInteresado(ruta){
  var num,nom,imp,nec,inte,numproy;
  num=document.form.txtnum.value;
  nom=document.form.txtnom.value;
  imp=document.form.txtimp.value;
  nec=document.form.txtnec.value;
  inte=document.form.txtinte.value;
  numproy=document.getElementById("txtnumproy").value;

  var parametros = '';
  
  parametros = "txtnum=" + num + "&";
  parametros += "txtnom=" + nom + "&";
  parametros += "txtimp=" + imp + "&";
  parametros += "txtnec=" + nec + "&";  
  parametros += "txtinte=" + inte + "&";
  parametros +="txtnumproy=" +numproy+ "&";
  
  if(numproy=='0'){
    alertify.warning("Elija el nombre del proyecto");
    document.form.txtnumproy.focus();
    return;
  }else 
  if(num==''){
    alertify.warning("Ingrese el Numero del Interesado");
    document.form.txtnum.focus();
    return;
  }else if(nom==''){
    alertify.warning("Ingrese el Nombre del Interesado");
    document.form.txtnom.focus();
    return;
  }else if(imp==''){
    alertify.warning("Ingrese el importe");
    document.form.txtimp.focus();
    return;
  }else if(nec==''){
    alertify.warning("Ingrese la necesidad");
    document.form.txtnec.focus();
    return;
  }else if(inte==''){
    alertify.warning("Ingrese el interes");
    document.form.txtinte.focus();
    return;
    
  }else{
    modificar(ruta,'Interesados', 6, parametros);
  }
}
function grabarInteresadoPersonal(ruta){
  var num,nom,imp,nec,inte,numproy;
  num=document.form.txtnum.value;
  nom=document.form.txtnom.value;
  imp=document.form.txtimp.value;
  nec=document.form.txtnec.value;
  inte=document.form.txtinte.value;
  numproy=document.form.txtnumproy.value;

  var parametros = '';
  
  parametros = "txtnum=" + num + "&";
  parametros += "txtnom=" + nom + "&";
  parametros += "txtimp=" + imp + "&";
  parametros += "txtnec=" + nec + "&";  
  parametros += "txtinte=" + inte + "&";
  parametros +="txtnumproy=" +numproy+ "&";
  
  
  if(num==''){
    alertify.warning("Ingrese el Numero del Interesado");
    document.form.txtnum.focus();
    return;
  }else if(nom==''){
    alertify.warning("Ingrese el Nombre del Interesado");
    document.form.txtnom.focus();
    return;
  }else if(imp==''){
    alertify.warning("Ingrese el importe");
    document.form.txtimp.focus();
    return;
  }else if(nec==''){
    alertify.warning("Ingrese la necesidad");
    document.form.txtnec.focus();
    return;
  }else if(inte==''){
    alertify.warning("Ingrese el interes");
    document.form.txtinte.focus();
    return;
    
  }else{
    grabar(ruta,'Interesados', 10, parametros);
  }
}
function modificarInteresadoPersonal(ruta){
  var num,nom,imp,nec,inte,numproy;
  num=document.form.txtnum.value;
  nom=document.form.txtnom.value;
  imp=document.form.txtimp.value;
  nec=document.form.txtnec.value;
  inte=document.form.txtinte.value;
  numproy=document.form.txtnumproy.value;

  var parametros = '';
  
  parametros = "txtnum=" + num + "&";
  parametros += "txtnom=" + nom + "&";
  parametros += "txtimp=" + imp + "&";
  parametros += "txtnec=" + nec + "&";  
  parametros += "txtinte=" + inte + "&";
  parametros +="txtnumproy=" +numproy+ "&";
  
  
  if(num==''){
    alertify.warning("Ingrese el Numero del Interesado");
    document.form.txtnum.focus();
    return;
  }else if(nom==''){
    alertify.warning("Ingrese el Nombre del Interesado");
    document.form.txtnom.focus();
    return;
  }else if(imp==''){
    alertify.warning("Ingrese el importe");
    document.form.txtimp.focus();
    return;
  }else if(nec==''){
    alertify.warning("Ingrese la necesidad");
    document.form.txtnec.focus();
    return;
  }else if(inte==''){
    alertify.warning("Ingrese el interes");
    document.form.txtinte.focus();
    return;
    
  }else{
    modificar(ruta,'Interesados', 11, parametros);
  }
}


//RIESGO

function grabarRiesgo(ruta){
  var num,niv,des,numproy;
  num=document.form.txtnum.value;
                //niv=document.form.txtniv.value;
                des=document.form.txtdes.value;
                niv=document.getElementById('txtniv').value;
                numproy=document.getElementById("txtnumproy").value;

                var parametros = '';
                
                parametros = "txtnum=" + num + "&";
                parametros += "txtniv=" + niv + "&";
                parametros += "txtdes=" + des + "&";
                parametros +="txtnumproy=" +numproy+ "&"; 
                
                if(numproy=='0'){
                  alertify.warning("Elija el nombre del proyecto");
                  document.form.txtnumproy.focus();
                  return;
                }else 
                if(num==''){
                  alertify.warning("Ingrese el Numero de Riesgos");
                  document.form.txtnum.focus();
                  return;
                }else if(niv=='0'){
                  alertify.warning("Ingrese el Nivel de Riesgos");
                  document.form.txtniv.focus();
                  return;
                }else if(des==''){
                  alertify.warning("Ingrese la descripcion");
                  document.form.txtdes.focus();
                  return;
                  
                }else{
                  grabar(ruta,'Riesgos', 3, parametros);
                }
              }
              function modificarRiesgo(ruta){
                var num,niv,des,numproy;
                num=document.form.txtnum.value;
                //niv=document.form.txtniv.value;
                niv=document.getElementById('txtniv').value;
                des=document.form.txtdes.value;
                numproy=document.getElementById("txtnumproy").value;

                var parametros = '';
                
                parametros = "txtnum=" + num + "&";
                parametros += "txtniv=" + niv + "&";
                parametros += "txtdes=" + des + "&";
                parametros+="txtnumproy="+numproy+"&";
                if(numproy=='0'){
                  alertify.warning("Elija el nombre del proyecto");
                  document.form.txtnumproy.focus();
                  return;
                }else     
                if(num==''){
                  alertify.warning("Ingrese el Numero de Riesgos");
                  document.form.txtnum.focus();
                  return;
                }else if(niv=='0'){
                  alertify.warning("Ingrese el Nivel de Riesgos");
                  document.form.txtniv.focus();
                  return;
                }else if(des==''){
                  alertify.warning("Ingrese la descripcion");
                  document.form.txtdes.focus();
                  return;
                  
                }else{
                  modificar(ruta,'Riesgos', 6, parametros);
                }
              }
              function grabarRiesgoPersonal(ruta){
                var num,niv,des,numproy;
                num=document.form.txtnum.value;
                //niv=document.form.txtniv.value;
                des=document.form.txtdes.value;
                niv=document.getElementById('txtniv').value;
                numproy=document.form.txtnumproy.value;

                var parametros = '';
                
                parametros = "txtnum=" + num + "&";
                parametros += "txtniv=" + niv + "&";
                parametros += "txtdes=" + des + "&";
                parametros +="txtnumproy=" +numproy+ "&"; 
                
                
                if(num==''){
                  alertify.warning("Ingrese el Numero de Riesgos");
                  document.form.txtnum.focus();
                  return;
                }else if(niv=='0'){
                  alertify.warning("Ingrese el Nivel de Riesgos");
                  document.form.txtniv.focus();
                  return;
                }else if(des==''){
                  alertify.warning("Ingrese la descripcion");
                  document.form.txtdes.focus();
                  return;
                  
                }else{
                  grabar(ruta,'Riesgos', 10, parametros);
                }
              }
              function modificarRiesgoPersonal(ruta){
                var num,niv,des,numproy;
                num=document.form.txtnum.value;
                //niv=document.form.txtniv.value;
                niv=document.getElementById('txtniv').value;
                des=document.form.txtdes.value;
                numproy=document.form.txtnumproy.value;

                var parametros = '';
                
                parametros = "txtnum=" + num + "&";
                parametros += "txtniv=" + niv + "&";
                parametros += "txtdes=" + des + "&";
                parametros+="txtnumproy="+numproy+"&";
                
                if(num==''){
                  alertify.warning("Ingrese el Numero de Riesgos");
                  document.form.txtnum.focus();
                  return;
                }else if(niv=='0'){
                  alertify.warning("Ingrese el Nivel de Riesgos");
                  document.form.txtniv.focus();
                  return;
                }else if(des==''){
                  alertify.warning("Ingrese la descripcion");
                  document.form.txtdes.focus();
                  return;
                  
                }else{
                  modificar(ruta,'Riesgos', 11, parametros);
                }
              }




//SOLUCION
function grabarSolucion(ruta){
  var num,niv,des,numriesgo;
  num=document.form.txtnum.value;
                //niv=document.form.txtniv.value;
                des=document.form.txtdes.value;
                niv=document.getElementById('txtniv').value;
                numriesgo=document.getElementById("txtnumriesgo").value;
                var parametros = '';
                
                parametros = "txtnum=" + num + "&";
                parametros += "txtniv=" + niv + "&";
                parametros += "txtdes=" + des + "&";
                parametros+="txtnumriesgo="+numriesgo+"&";
                
                if(numriesgo=='0'){
                  alertify.warning("Elija el riesgo del proyecto");
                  document.form.txtnumriesgo.focus();
                  return;
                }else 
                if(num==''){
                  alertify.warning("Ingrese el Numero de Solucion");
                  document.form.txtnum.focus();
                  return;
                }else if(niv=='0'){
                  alertify.warning("Ingrese el Nivel de Solucion");
                  document.form.txtniv.focus();
                  return;
                }else if(des==''){
                  alertify.warning("Ingrese la descripcion");
                  document.form.txtdes.focus();
                  return;
                  
                }else{
                  grabar(ruta,'Solucion', 3, parametros);
                }
              }
              function modificarSolucion(ruta){
                var num,niv,des,numriesgo;
                num=document.form.txtnum.value;
                //niv=document.form.txtniv.value;
                des=document.form.txtdes.value;
                niv=document.getElementById('txtniv').value;
                
                numriesgo=document.getElementById("txtnumriesgo").value;
                var parametros = '';
                
                parametros = "txtnum=" + num + "&";
                parametros += "txtniv=" + niv + "&";
                parametros += "txtdes=" + des + "&";
                
                parametros+="txtnumriesgo="+numriesgo+"&";
                
                if(numriesgo=='0'){
                  alertify.warning("Elija el riesgo del proyecto");
                  document.form.txtnumriesgo.focus();
                  return;
                }else 
                if(num==''){
                  alertify.warning("Ingrese el Numero de Solucion");
                  document.form.txtnum.focus();
                  return;
                }else if(niv=='0'){
                  alertify.warning("Ingrese el Nivel de Solucion");
                  document.form.txtniv.focus();
                  return;
                }else if(des==''){
                  alertify.warning("Ingrese la descripcion");
                  document.form.txtdes.focus();
                  return;
                  
                }else{
                  modificar(ruta,'Solucion', 6, parametros);
                }
              }
              
              
              
              
//ACTIVIDADES
function grabarActividad(ruta){
  var num,act,dur,res,numproy;
  num=document.form.txtnum.value;
  act=document.form.txtact.value;
  dur=document.form.txtdur.value;
  res=document.form.txtres.value;
  numproy=document.getElementById('txtnumproy').value;
  var parametros = '';
  
  parametros = "txtnum=" + num + "&";
  parametros += "txtact=" + act + "&";
  parametros += "txtdur=" + dur + "&";
  parametros += "txtres=" + res + "&";
  parametros +="txtnumproy="+numproy+"&";
  
  if(numproy=='0'){
    alertify.warning("Elija el nombre del Proyecto");
    document.form.txtnumproy.focus();
    return;
  }else
  if(num==''){
    alertify.warning("Ingrese el Numero de la Actividad");
    document.form.txtnum.focus();
    return;
  }else if(act==''){
    alertify.warning("Ingrese la Actividad");
    document.form.txtact.focus();
    return;
  }else if(dur==''){
    alertify.warning("Ingrese la duracion");
    document.form.txtdur.focus();
    return;
  }else if(res==''){
    alertify.warning("Ingrese si es o no responsable");
    document.form.txtres.focus();
    return;
    
  }else{
    grabar(ruta,'Actividades', 3, parametros);
  }
}

function modificarActividad(ruta){
  var num,act,dur,res,numproy;
  num=document.form.txtnum.value;
  act=document.form.txtact.value;
  dur=document.form.txtdur.value;
  res=document.form.txtres.value;
  numproy=document.getElementById('txtnumproy').value;
  var parametros = '';
  
  parametros = "txtnum=" + num + "&";
  parametros += "txtact=" + act + "&";
  parametros += "txtdur=" + dur + "&";
  parametros += "txtres=" + res + "&";
  parametros +="txtnumproy="+numproy+"&";
  
  if(numproy=='0'){
    alertify.warning("Elija el nombre del Proyecto");
    document.form.txtnumproy.focus();
    return;
  }else
  if(num==''){
    alertify.warning("Ingrese el Numero de la Actividad");
    document.form.txtnum.focus();
    return;
  }else if(act==''){
    alertify.warning("Ingrese la Actividad");
    document.form.txtact.focus();
    return;
  }else if(dur==''){
    alertify.warning("Ingrese la duracion");
    document.form.txtdur.focus();
    return;
  }else if(res==''){
    alertify.warning("Ingrese si es o no responsable");
    document.form.txtres.focus();
    return;
    
  }else{
    modificar(ruta,'Actividades', 6, parametros);
  }
}

function grabarActividadPersonal(ruta){
  var num,act,dur,res,numproy;
  num=document.form.txtnum.value;
  act=document.form.txtact.value;
  dur=document.form.txtdur.value;
  res=document.form.txtres.value;
  numproy=document.form.txtnumproy.value;
  var parametros = '';
  
  parametros = "txtnum=" + num + "&";
  parametros += "txtact=" + act + "&";
  parametros += "txtdur=" + dur + "&";
  parametros += "txtres=" + res + "&";
  parametros +="txtnumproy="+numproy+"&";
  
  if(num==''){
    alertify.warning("Ingrese el Numero de la Actividad");
    document.form.txtnum.focus();
    return;
  }else if(act==''){
    alertify.warning("Ingrese la Actividad");
    document.form.txtact.focus();
    return;
  }else if(dur==''){
    alertify.warning("Ingrese la duracion");
    document.form.txtdur.focus();
    return;
  }else if(res==''){
    alertify.warning("Ingrese si es o no responsable");
    document.form.txtres.focus();
    return;
    
  }else{
    grabar(ruta,'Actividades', 10, parametros);
  }
}

function modificarActividadPersonal(ruta){
  var num,act,dur,res,numproy;
  num=document.form.txtnum.value;
  act=document.form.txtact.value;
  dur=document.form.txtdur.value;
  res=document.form.txtres.value;
  numproy=document.form.txtnumproy.value;
  var parametros = '';
  
  parametros = "txtnum=" + num + "&";
  parametros += "txtact=" + act + "&";
  parametros += "txtdur=" + dur + "&";
  parametros += "txtres=" + res + "&";
  parametros +="txtnumproy="+numproy+"&";
  
  
  if(num==''){
    alertify.warning("Ingrese el Numero de la Actividad");
    document.form.txtnum.focus();
    return;
  }else if(act==''){
    alertify.warning("Ingrese la Actividad");
    document.form.txtact.focus();
    return;
  }else if(dur==''){
    alertify.warning("Ingrese la duracion");
    document.form.txtdur.focus();
    return;
  }else if(res==''){
    alertify.warning("Ingrese si es o no responsable");
    document.form.txtres.focus();
    return;
    
  }else{
    modificar(ruta,'Actividades', 11, parametros);
  }
}







 //CONTROL DE CALIDAD           
 function grabarControl(ruta){
  var num,plge,plca,meca,acdo,numproy;
  num=document.form.txtcod.value;
  plge=document.form.txtplge.value;
  plca=document.form.txtplca.value;
               // meca=document.form.txtmeca.value;
               acdo=document.form.txtacdo.value;
               meca=document.getElementById('txtmeca').value;
               numproy=document.getElementById('txtnumproy').value;
               var parametros = '';
               
               parametros = "txtcod=" + num + "&";
               parametros += "txtplge=" + plge + "&";
               parametros += "txtplca=" + plca + "&";
               parametros += "txtmeca=" + meca + "&";
               parametros += "txtacdo=" + acdo + "&";
               parametros += "txtnumproy=" + numproy + "&";
               
               if(numproy=='0'){
                alertify.warning("Elija el nombre del proyecto");
                document.form.txtnumproy.focus();
                return;
              }else 
              if(num==''){
                alertify.warning("Ingrese el Numero del Control de calidad");
                document.form.txtcod.focus();
                return;
              }else if(plge==''){
                alertify.warning("Ingrese el plan de gestion");
                document.form.txtplge.focus();
                return;
              }else if(plca==''){
                alertify.warning("Ingrese el plan de mejora de calidad");
                document.form.txtplca.focus();
                return;
              }else if(meca=='0'){
                alertify.warning("Ingrese las metricas de calidad");
                document.form.txtmeca.focus();
                return;
              }else if(acdo==''){
                alertify.warning("Ingrese las actualizaciones del documento");
                document.form.txtacdo.focus();
                return;
                
              }else{
               grabar(ruta,'ControldeCalidad', 3, parametros);
             }
           }
           function modificarControl(ruta){
            var num,plge,plca,meca,acdo,numproy;
            num=document.form.txtcod.value;
            plge=document.form.txtplge.value;
            plca=document.form.txtplca.value;
                //meca=document.form.txtmeca.value;
                acdo=document.form.txtacdo.value;
                meca=document.getElementById('txtmeca').value;
                numproy=document.getElementById('txtnumproy').value;
                var parametros = '';
                
                parametros = "txtcod=" + num + "&";
                parametros += "txtplge=" + plge + "&";
                parametros += "txtplca=" + plca + "&";
                parametros += "txtmeca=" + meca + "&";
                parametros += "txtacdo=" + acdo + "&";
                parametros += "txtnumproy=" + numproy + "&";
                if(numproy=='0'){
                  alertify.warning("Elija el nombre del proyecto");
                  document.form.txtnumproy.focus();
                  return;
                }else
                if(num==''){
                  alertify.warning("Ingrese el Numero del Control de calidad");
                  document.form.txtnum.focus();
                  return;
                }else if(plge==''){
                  alertify.warning("Ingrese el plan de gestion");
                  document.form.txtplge.focus();
                  return;
                }else if(plca==''){
                  alertify.warning("Ingrese el plan de mejora de calidad");
                  document.form.txtplca.focus();
                  return;
                }else if(meca=='0'){
                  alertify.warning("Ingrese las metricas de calidad");
                  document.form.txtmeca.focus();
                  return;
                }else if(acdo==''){
                  alertify.warning("Ingrese las actualizaciones del documento");
                  document.form.txtacdo.focus();
                  return;
                  
                }else{
                 modificar(ruta,'ControldeCalidad', 6, parametros);
               }
             }
            //PERSONAL
            function grabarControlPersonal(ruta){
              var num,plge,plca,meca,acdo,numproy;
              num=document.form.txtcod.value;
              plge=document.form.txtplge.value;
              plca=document.form.txtplca.value;
               // meca=document.form.txtmeca.value;
               acdo=document.form.txtacdo.value;
               meca=document.form.txtmeca.value;
               numproy=document.form.txtnumproy.value;
               var parametros = '';
               
               parametros = "txtcod=" + num + "&";
               parametros += "txtplge=" + plge + "&";
               parametros += "txtplca=" + plca + "&";
               parametros += "txtmeca=" + meca + "&";
               parametros += "txtacdo=" + acdo + "&";
               parametros += "txtnumproy=" + numproy + "&";
               
               
               if(num==''){
                alertify.warning("Ingrese el Numero del Control de calidad");
                document.form.txtcod.focus();
                return;
              }else if(plge==''){
                alertify.warning("Ingrese el plan de gestion");
                document.form.txtplge.focus();
                return;
              }else if(plca==''){
                alertify.warning("Ingrese el plan de mejora de calidad");
                document.form.txtplca.focus();
                return;
              }else if(meca=='0'){
                alertify.warning("Ingrese las metricas de calidad");
                document.form.txtmeca.focus();
                return;
              }else if(acdo==''){
                alertify.warning("Ingrese las actualizaciones del documento");
                document.form.txtacdo.focus();
                return;
                
              }else{
               grabar(ruta,'ControldeCalidad', 10, parametros);
             }
           }
           function modificarControlPersonal(ruta){
            var num,plge,plca,meca,acdo,numproy;
            num=document.form.txtcod.value;
            plge=document.form.txtplge.value;
            plca=document.form.txtplca.value;
                //meca=document.form.txtmeca.value;
                acdo=document.form.txtacdo.value;
                meca=document.form.txtmeca.value;
                numproy=document.form.txtnumproy.value;
                var parametros = '';
                
                parametros = "txtcod=" + num + "&";
                parametros += "txtplge=" + plge + "&";
                parametros += "txtplca=" + plca + "&";
                parametros += "txtmeca=" + meca + "&";
                parametros += "txtacdo=" + acdo + "&";
                parametros += "txtnumproy=" + numproy + "&";
                
                if(num==''){
                  alertify.warning("Ingrese el Numero del Control de calidad");
                  document.form.txtcod.focus();
                  return;
                }else if(plge==''){
                  alertify.warning("Ingrese el plan de gestion");
                  document.form.txtplge.focus();
                  return;
                }else if(plca==''){
                  alertify.warning("Ingrese el plan de mejora de calidad");
                  document.form.txtplca.focus();
                  return;
                }else if(meca==''){
                  alertify.warning("Ingrese las metricas de calidad");
                  document.form.txtmeca.focus();
                  return;
                }else if(acdo==''){
                  alertify.warning("Ingrese las actualizaciones del documento");
                  document.form.txtacdo.focus();
                  return;
                  
                }else{
                 modificar(ruta,'ControldeCalidad', 11, parametros);
               }
             }
