 function  entrar(ruta,controlador)
  {
         var  usuario=document.getElementById("txtusu").value;
         var  clave= document.getElementById("txtcla").value;
      
    if(controlador=="PersonalServlet") 
    {       
         var tiposuario=document.getElementById("tipousu").value;
         
      if(tiposuario=="0")
      {
          alert("Seleccione el  Tipo de Usuario");
          document.getElementById("tipousu").focus();
          return;
      }
      else if( usuario=="")
      {
          alert("Ingrese  Usuario !!!");
          document.getElementById("txtusu").focus();
          return;
      }else if(clave=="")
      {
          alert("Ingrese  Clave !!!");
          document.getElementById("txtcla").focus();
          return;          
      }else
      {
      
     document.form.action=ruta+"/"+controlador;
     document.form.method="POST";
     document.form.submit();  
      }
      
    }else
    {
               if( usuario=="")
              {
                  alert("Ingrese  Usuario !!!");
                  document.getElementById("txtusu").focus();
                  return;
              }else if(clave=="")
              {
                  alert("Ingrese  Clave !!!");
                  document.getElementById("txtcla").focus();
                  return;          
              }else
              {

             document.form.action=ruta+"/"+controlador;
             document.form.method="GET";
             document.form.op.value=op;
             document.form.submit();  
              }     
    }
      
 }