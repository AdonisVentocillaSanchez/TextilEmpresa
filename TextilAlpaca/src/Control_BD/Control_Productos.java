package Control_BD;

import BD_Productos.ProdConsult;
import static BD_Productos.ProdConsult.jTableListarCliente;
import BD_Productos.ProdDelete;
import BD_Productos.ProdModify;
import textileria.Guia_de_remision;
import textileria.Ventas;
import static textileria.Ventas.JTableProduct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * En esta clase se exponen todos los métodos para ejercer control sobre los
 * datos que van desde y hacia la tabla clientes. En esta clase se hace la
 * validación y organizacion de los datos.
 *
 * @author Sergio
 */


public class Control_Productos {

    //modelo para la tabla
    DefaultTableModel modelo;
       private String sSQL = "";
    //vector con los titulos de cada columna
    String[] titulosColumnas = {"COD", "NOMBRE", "PRECIO VENTA","DESCRIPCION"};
    //matriz donde se almacena los datos de cada celda de la tabla
    String info[][] = {};
    
    
    
    

     public void agregarProductos(String cedula, String nombre, String apellido, String direccion, String telefono) {


         
    }//cierra metodo agregarCliente
     
     
     public void CargarProductos(){
         
         modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
        Ventas.SeleccionarProductos.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabla();
        
                               /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
     }
          public void CargarProductosVentas(){
         
         modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
        Ventas.SeleccionarProductos.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTablaventas();
        
                               /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
     }
     public void CargarProductosGuiaReimsion(){
         
         modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
         Guia_de_remision.SeleccionarProductos.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTablaventas();
        
                               /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
     }
     
     
     
          public void CargarProductos2(){
         
         modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
        ProdModify.jTable_productos.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabla();
         
     }
    
          public void CargarProductos_eliminar(){
         
         modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
              ProdDelete.jTable_productos.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabla();
         
     }    
     
      public DefaultTableModel mostrar_inicial() {
        //cargar tabla plan sin parametros
            // conexion = ConexionConBaseDatos.getConexion();
          
          int totalregistros;
     //   DefaultTableModel modelo1;

        String[] titulos = {"id", "nombre", "precio", "descripcion"};

        String[] registro = new String[14];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

            sSQL = "exec SP_MOSTRARPRODUCTO";

        try {
            conexion = ConexionConBaseDatos.getConexion();

//              conexion = DriverManager.getConnection("jdbc:mysql://localhost/Ultimate_FerreteriaAndres", "root", "");
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
            
                 registro[0]  = resultado.getString("cod_prod");
                registro[1] = resultado.getString("nom_prod");
                registro[2] = resultado.getString("prec_prod");
                registro[3] = resultado.getString("desc_prod");
                //crea un vector donde los está la informacion (se crea una fila)
               // Object[] info = {codigo, nombre, precioventa,descripcion,cantidad,preciocompra};
                

                
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
    
    
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    /**
     * Metodo para listar todos los registros de la tabla
     * de clientes, los muestra en un jtable.
     */
      
//      public void listarTodosProductos_por_agotar() {
//
//        modelo = new DefaultTableModel(info, titulosColumnas) {
//            public boolean isCellEditable(int row, int column) {
//                return false;
//            }
//        };
//      //le asigna el modelo al jtable
//        ProdConsult.jTableListarCliente.setModel(modelo);
//
//
//        //ejecuta una consulta a la BD
//        ejecutarConsultaTodaTabla_por_agotar();
//        
//
//    }
      
      
    public void listarTodosProductos() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
        ProdConsult.jTableListarCliente.setModel(modelo);


        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabla();
        

    }//cierra metodo listarTodosClientes
    
     /**
     * Metodo para consultar todos los regsitros de la base de datos de clientes
     * y luego ser mostrados en una tabla.
     */
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;

//        public void ejecutarConsultaTodaTabla_por_agotar() {
//
//        try {
//            conexion = ConexionConBaseDatos.getConexion();
//
//            sentencia = conexion.createStatement();
//            //ORDER BY idProductos
//            String consultaSQL = "select * from table_productos where cantidadProductos<=4";
//                          Statement st = conexion.createStatement();
//            ResultSet rs = st.executeQuery(consultaSQL);
//
//
//            //mientras haya datos en la BD ejecutar eso...
//            while (rs.next()) {
//
//
//                String codigo = rs.getString("idProductos");
//                String nombre = rs.getString("nombreProductos");
//                String precioventa = rs.getString("preciosProductos");
//                String descripcion = rs.getString("descripcionProductos");
//                String cantidad = rs.getString("cantidadProductos");
//                   String preciocompraProductos = rs.getString("preciocompraProductos");
//
//                //crea un vector donde los está la informacion (se crea una fila)
//                Object[] info = {codigo, nombre, precioventa,descripcion,cantidad,preciocompraProductos};
//
//                //al modelo de la tabla le agrega una fila
//                //con los datos que están en info
//                modelo.addRow(info);
//
//            }//cierra while (porque no hay mas datos en la BD)
//
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null,"Error SQL:\n" + e);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,e);
//            conexion = null;
//        } finally {
//            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
//        }
//
//    }//cierra metodo ejecutarConsulta
//        
//        
            public void ejecutarConsultaTodaTablaventas() {

        try {
            conexion = ConexionConBaseDatos.getConexion();

            sentencia = conexion.createStatement();
            String consultaSQL = "exec SP_MOSTRARPRODUCTO";
            resultado = sentencia.executeQuery(consultaSQL);


            //mientras haya datos en la BD ejecutar eso...
            while (resultado.next()) {


                String codigo = resultado.getString("cod_prod");
                String nombre = resultado.getString("nom_prod");
                String precioventa = resultado.getString("prec_prod");
                String descripcion = resultado.getString("desc_prod");

                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {codigo, nombre, precioventa,descripcion};

                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);

            }//cierra while (porque no hay mas datos en la BD)


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }

    }//cierra metodo ejecutarConsulta
        
    public void ejecutarConsultaTodaTabla() {

        try {
            conexion = ConexionConBaseDatos.getConexion();

            sentencia = conexion.createStatement();
            String consultaSQL = "exec SP_MOSTRARPRODUCTO";
            resultado = sentencia.executeQuery(consultaSQL);


            //mientras haya datos en la BD ejecutar eso...
            while (resultado.next()) {


                String codigo = resultado.getString("cod_prod");
                String nombre = resultado.getString("nom_prod");
                String precioventa = resultado.getString("prec_prod");
                String descripcion = resultado.getString("desc_prod");

                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {codigo, nombre, precioventa,descripcion};

                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);

            }//cierra while (porque no hay mas datos en la BD)


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }

    }//cierra metodo ejecutarConsulta
    
  
    public void buscarProductos(String parametroBusqueda) {

        

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;
            //le asigna el modelo al jtable
            ProdConsult.jTableListarCliente.setModel(modelo);
            //ejecuta una consulta a la BD
            buscarRegistroProductos(parametroBusqueda);

    }
    
//    
    
    public void buscarRegistroProductos(String parametroBusqueda) {

        try {

            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
                            
                selectSQL = "exec SP_BUSCARPRODUCTO ?";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
    
            resultado = ps.executeQuery();

            while (resultado.next()) {
                String codigo = resultado.getString("cod_prod");
                String nombre = resultado.getString("nom_prod");
                String precioventa = resultado.getString("prec_prod");
                String descripcion = resultado.getString("desc_prod");
                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {codigo, nombre, precioventa,descripcion};
                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error\n Por la Causa" + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }


    }//cierra metodo buscarRegistro
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    /**
     * Método para validar la entrada del usuario
     * que ingresa para eliminar un cliente
     */
    public void EliminarProductos(String code) {

        try {            
             conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();
            int cantidad = comando.executeUpdate("exec SP_ELIMINARPRODUCTO " + code);
            if (cantidad == 1) {
   
                JOptionPane.showMessageDialog(null,"Eliminado");
            } else {
                JOptionPane.showMessageDialog(null,"No existe Producto de Codigo "+code);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error "+ex);
        }

    }//cierra metodo eliminarCliente

    
    /**
     * Método para validar y modificar la 
     * información de un cliente.
     */
    public void ModificarProductos(String code,String nombre,float precios,String descripcion) {

    
        try {
             conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();
            
            // linea de codigo de mysql que actualiza regristos que va modificar
            int cantidad = comando.executeUpdate("exec SP_MODIFICARPRODUCTO '"+code+"', '"+nombre+"', "+precios+" , '"+descripcion+"'");
            if (cantidad == 1) {
                JOptionPane.showMessageDialog(null," Modifico con Exito");
            } else {
                JOptionPane.showMessageDialog(null,"No existe Producto de un codigo "+code);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Error -->"+ex);
        }
    }//cierra metodo modificarCliente
    
    
    
    
    //es para buscar productos de compras en ventas- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    public void buscarProductosparaGuia(String parametroBusqueda) {

        

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;
            //le asigna el modelo al jtable
            Guia_de_remision.SeleccionarProductos.setModel(modelo);
            //ejecuta una consulta a la BD
            buscarRegistroProductoss(parametroBusqueda);

    }   
    public void buscarProductosparaVentas(String parametroBusqueda) {

        

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;
            //le asigna el modelo al jtable
            Ventas.SeleccionarProductos.setModel(modelo);
            //ejecuta una consulta a la BD
            buscarRegistroProductoss(parametroBusqueda);

    }
        public void buscarProductosparaProductos(String parametroBusqueda) {

        

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;
            //le asigna el modelo al jtable
            ProdModify.jTable_productos.setModel(modelo);
            //ejecuta una consulta a la BD
            buscarRegistroProductoss(parametroBusqueda);

    }
        
             public void buscarProductosparaEliminarProductos(String parametroBusqueda) {

        

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;
            //le asigna el modelo al jtable
                 ProdDelete.jTable_productos.setModel(modelo);
            //ejecuta una consulta a la BD
            buscarRegistroProductoss(parametroBusqueda);

    } 
    
    
    public void buscarRegistroProductoss(String parametroBusqueda) {

        try {

            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
//  + " nombres like '%"
  //              + buscar + "%'                            
                selectSQL = "exec SP_BUSCARPRODUCTO ?";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
    
            resultado = ps.executeQuery();

            while (resultado.next()) {
                String codigo = resultado.getString("cod_prod");
                String nombre = resultado.getString("nom_prod");
                String precioventa = resultado.getString("prec_prod");
                String descripcion = resultado.getString("desc_prod");
                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {codigo, nombre, precioventa,descripcion};
                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error\n Por la Causa" + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }


    }


}//cierra class
