package Control_BD;

import BD_Cliente.CliList;
import BD_Cliente.CliAdd;
import consultas.ConsultarFacturas;
import static consultas.ConsultarFacturas.jTableListarFacturas;
import static consultas.ConsultarFacturas.listadecompras;
import consultas.ConsultarVentas;
import static consultas.ConsultarVentas.jTableListarVentas;
import textileria.Ventas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * En esta clase se exponen todos los métodos para ejercer control sobre los
 * datos que van desde y hacia la tabla clientes. En esta clase se hace la
 * validación y organizacion de los datos.
 *
 * @author Sergio
 */


public class Control_Consultas {

    //modelo para la tabla
    DefaultTableModel modelo;
    //vector con los titulos de cada columna
    
    //matriz donde se almacena los datos de cada celda de la tabla
    String info[][] = {};
    // Conectar Base de Datos
    ConexionConBaseDatos conectar = new ConexionConBaseDatos();
    
    
    

     
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    
    public void listarTodosFacturas() {
        
        String[] titulosColumnas = {"No_Facturas", "CLIENTE", "RAZÓN SOCIAL", "FECHA","TOTAL"};

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
        ConsultarFacturas.jTableListarFacturas.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabladeFacturas();

    }//cierra metodo listarTodosFacturas
    
        

     /**
     * Metodo para consultar todos los regsitros de la base de datos de clientes
     * y luego ser mostrados en una tabla.
     */
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;

    public void ejecutarConsultaTodaTabladeFacturas() {

        try {
            conexion = ConexionConBaseDatos.getConexion();

            sentencia = conexion.createStatement();
            String consultaSQL = "SELECT * FROM table_Facturas f inner join  table_Cliente c on f.cliente=c.idCliente ORDER BY fecha ASC";
            resultado = sentencia.executeQuery(consultaSQL);


            //mientras haya datos en la BD ejecutar eso...
            while (resultado.next()) {


             int fact = resultado.getInt("No_Facturas");
                String cliente = resultado.getString("c.Nombre_Cliente")+resultado.getString("c.Apellido_Cliente");
                String razons = resultado.getString("c.razon_s_Cliente");
                String fecha = resultado.getString("fecha");
                String total = resultado.getString("totals");



                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {fact,cliente,razons,fecha,total};

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
    
  
    public void buscarFacturas(String parametroBusqueda, boolean buscarPorFacturas, boolean buscarPorCliente, boolean buscarPorFecha) {

        String[] titulosColumnas = {"No_Facturas", "CLIENTE","RAZÓN SOCIAL", "FECHA","TOTAL"};
        if ((parametroBusqueda.trim().length() == 0)) {
            JOptionPane.showMessageDialog(null,"Error, datos incorrectos");
        } else {

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

          

            //le asigna el modelo al jtable
            ConsultarFacturas.jTableListarFacturas.setModel(modelo);
            //ejecuta una consulta a la BD
            buscarFacturasporBusqueda(parametroBusqueda, buscarPorFacturas, buscarPorCliente, buscarPorFecha);

        }

    }//cierra metodo buscarCliente
    
    /**
     * Método para buscar un registro en la base de datos dentro de la tabla
     * clientes, se puede buscar por la cedula o por el nombre.
     */
    public void buscarFacturasporBusqueda(String parametroBusqueda, boolean buscarPorFacturas, boolean buscarPorCliente, boolean buscarPorFecha) {

        try {

            
            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
            if (buscarPorFacturas == true) {     
                System.out.print("buscando por facturas");
                selectSQL = "SELECT * FROM table_Facturas WHERE No_Facturas LIKE ? ORDER BY fecha ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
            } 
            else if(buscarPorCliente== true){
                System.out.print("buscando por cliente");
                selectSQL = "SELECT * FROM table_Facturas f inner join  table_Cliente c on f.cliente=c.idCliente WHERE   c.ruc_Cliente LIKE ? or  c.razon_s_Cliente LIKE ? or c.Nombre_Cliente LIKE ? ORDER BY fecha ASC";
                ps = conexion.prepareStatement(selectSQL);

                 ps.setString(1, "%" + parametroBusqueda + "%");
                  ps.setString(2, "%" + parametroBusqueda + "%");
                        ps.setString(3, "%" + parametroBusqueda + "%");
            }
            else if(buscarPorFecha== true){

                System.out.print("buscando por fecha -->"+parametroBusqueda);
                selectSQL = "SELECT * FROM table_Facturas f inner join  table_Cliente c on f.cliente=c.idCliente WHERE f.fecha LIKE ?  ORDER BY fecha ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
            }
            resultado = ps.executeQuery();

            while (resultado.next()) {
                int fact = resultado.getInt("No_Facturas");
                String cliente = resultado.getString("c.Nombre_Cliente")+resultado.getString("c.Apellido_Cliente");
                String fecha = resultado.getString("fecha");
                String total = resultado.getString("totals");
                String razons = resultado.getString("razon_s_Cliente");   

                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {fact,cliente,razons, fecha,total};
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
    
    
    //esta es la parte de mostar detalle de facturas por la tabla venta
    
    //metodo para buscar un producto
    public void buscarFacturas ( String number){
        
        String[] titulosColumnas = {"ID-VENTAS", "PRODUCTOS", "CANTIDAD", "IMPORTE"};
        if( (number.trim().length()==0)){
            JOptionPane.showMessageDialog(null,"Error, Seleccione la Facturas");
        }
        else{
            
            modelo = new DefaultTableModel(info,titulosColumnas){
                public boolean isCellEditable(int row, int column)
                {
                return false;
                }
                
            };
         
         
         
        //le asigna el modelo al jtable
       ConsultarFacturas.listadecompras.setModel(modelo);
       
        int[] anchos = {80, 200,50,145};
        for(int i = 0; i < listadecompras.getColumnCount(); i++) {
        listadecompras.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
       //ejecuta una consulta a la BD   
        buscarFacturasDetall(number);         
        }
        
    }//cierra metodo buscarCliente
    
      public void buscarFacturasDetall(String number) {

        try {
            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
           
                selectSQL = "SELECT * FROM table_ventas WHERE No_Facturas LIKE ? ORDER BY idVentas ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + number + "%");
            
            resultado = ps.executeQuery();

            while (resultado.next()) {
                String id = resultado.getString("idVentas");
                String product = resultado.getString("productos");
                String cant = resultado.getString("cantidad");
                String imp = resultado.getString("importe");
                //crea un vector donde los está la informacion (se crea una fila)
                
                //buscar producto
                String name="";
                Statement comando = conexion.createStatement();
                 ResultSet registro = comando.executeQuery("select idProductos,nombreProductos from table_productos where idProductos=" +product);
            
                 if (registro.next() == true) {
                     name = registro.getString("nombreProductos");
                    }
            // cierdda de buscar productos
                Object[] info = {id,name,cant,imp};
                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error\n " + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }


    }//cierra metodo buscarRegistro
      
      
      
      // parte de todo consultas en ventas--------------------------------------------------------------
      //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    
    public void listarTodosVentas() {
        
        String[] titulosColumnas = {"id-Ventas","Fecha", "Producto", "cantidad", "Importe"};

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
        ConsultarVentas.jTableListarVentas.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabladeVentas();

    }//cierra metodo listarTodosFacturas
    
        

     /**
     * Metodo para consultar todos los regsitros de la base de datos de clientes
     * y luego ser mostrados en una tabla.
     */


    public void ejecutarConsultaTodaTabladeVentas() {

        try {
            conexion = ConexionConBaseDatos.getConexion();

            sentencia = conexion.createStatement();
            String consultaSQL = "SELECT * FROM table_Facturas f inner join  table_Ventas v on f.No_Facturas=v.No_Facturas inner join  table_Productos p on v.Productos=p.idProductos ORDER BY v.idVentas ASC";
            resultado = sentencia.executeQuery(consultaSQL);


            //mientras haya datos en la BD ejecutar eso...
            while (resultado.next()) {


                int num = resultado.getInt("idVentas");
                String fact = resultado.getString("f.fecha");
                String prod = resultado.getString("p.nombreProductos");
                String cant = resultado.getString("cantidad");
                String importe = resultado.getString("importe");



                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {num,fact,prod,cant,importe};

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
      
    
            
                public void buscarFacturasdeVentasFecha(String parametroBusqueda,String parametroBusqued2) {

        String[] titulosColumnas = {"id-Ventas","Fecha", "Producto", "cantidad", "Importe"};
        if ((parametroBusqueda.trim().length() == 0)) {
            JOptionPane.showMessageDialog(null,"Error, datos incorrectos");
        } else {

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            //le asigna el modelo al jtable
            
            
            ConsultarVentas.jTableListarVentas.setModel(modelo);
            //ejecuta una consulta a la BD
            buscarFacturasporBusquedaenVentasFecha(parametroBusqueda,parametroBusqued2);

        }

    }//cierra metodo buscarCliente
    public void buscarFacturasdeVentas(String parametroBusqueda) {

        String[] titulosColumnas = {"id-Ventas","Fecha", "Producto", "cantidad", "Importe"};
        if ((parametroBusqueda.trim().length() == 0)) {
            JOptionPane.showMessageDialog(null,"Error, datos incorrectos");
        } else {

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            


            //le asigna el modelo al jtable
            ConsultarVentas.jTableListarVentas.setModel(modelo);
            //ejecuta una consulta a la BD
            buscarFacturasporBusquedaenVentas(parametroBusqueda);

        }

    }//cierra metodo buscarCliente
    
    /**
     * Método para buscar un registro en la base de datos dentro de la tabla
     * clientes, se puede buscar por la cedula o por el nombre.
     */
    public void buscarFacturasporBusquedaenVentasFecha(String parametroBusqueda,String parametroBusqueda2) {

        try {

        
            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
                System.err.println(parametroBusqueda2+"    "+parametroBusqueda);
                System.out.print("buscando por facturas en Ventas");
               selectSQL = "SELECT * FROM table_Facturas f inner join  table_Ventas v on f.No_Facturas=v.No_Facturas inner join  table_Productos p on v.Productos=p.idProductos WHERE " +"  fecha<= '" +parametroBusqueda2+"' AND  fecha>= '"+parametroBusqueda+"'";
               
                      Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(selectSQL);
            
             
float total=0;
float ganancia=0;
//Difererencia
            while (rs.next()) {
                int num = rs.getInt("idVentas");
                String fact = rs.getString("f.fecha");
                String prod = rs.getString("p.nombreProductos");
                String cant = rs.getString("v.cantidad");
                String importe = rs.getString("v.importe");
                total=total+rs.getFloat("v.importe");
                //ganancia=ganancia+rs.getFloat("p.Difererencia");
                ganancia=ganancia+(rs.getInt("p.Difererencia"))*(rs.getInt("v.cantidad"));

                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {num,fact,prod,cant,importe};
                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);

            }
ConsultarVentas.label_total.setText(total+"  Soles");
ConsultarVentas.label_ganancia.setText(ganancia+"  Soles");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error\n Por la Causa" + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }


    }
    
    public void buscarFacturasporBusquedaenVentas(String parametroBusqueda) {

        try {

        
            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
                
                System.out.print("buscando por facturas en Ventas");
               selectSQL = "SELECT * FROM table_Facturas f inner join  table_Ventas v on f.No_Facturas=v.No_Facturas inner join  table_Productos p on v.Productos=p.idProductos WHERE p.nombreProductos LIKE ? ORDER BY v.idVentas ASC";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
            
            resultado = ps.executeQuery();
float total=0;
float ganancia=0;
            while (resultado.next()) {
                int num = resultado.getInt("idVentas");
                String fact = resultado.getString("f.fecha");
                String prod = resultado.getString("p.nombreProductos");
                String cant = resultado.getString("v.cantidad");
                String importe = resultado.getString("v.importe");
                
total=total+resultado.getInt("v.importe");
ganancia=ganancia+(resultado.getInt("p.Difererencia"))*(resultado.getInt("v.cantidad"));
                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {num,fact,prod,cant,importe};
                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);

            }
ConsultarVentas.label_total.setText(total+"  Soles");
ConsultarVentas.label_ganancia.setText(ganancia+"  Soles");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error\n Por la Causa" + e);
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }


    }//cierra metodo buscarRegistro
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
      
      
      
}//cierra class
