package Control_BD;

import BD_Cliente.CliDelete;
import BD_Cliente.CliList;
import BD_Cliente.CliModify;
import BD_Cliente.CliAdd;
import textileria.Guia_de_remision;
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
 * @author Richard
 */


public class Control_Cliente {

    //modelo para la tabla
    DefaultTableModel modelo;
    //vector con los titulos de cada columna
    String[] titulosColumnas = {"DNI", "NOMBRES", "APELLIDOS","DIRECCIÓN", "TELÉFONO"};
    //matriz donde se almacena los datos de cada celda de la tabla
    String info[][] = {};
    // Conectar Base de Datos
    ConexionConBaseDatos conectar = new ConexionConBaseDatos();
    
    
    

     public void agregarCliente(String dni,String nombre, String apellido,String direccion,String telefono) {

         Connection reg = ConexionConBaseDatos.getConexion();
        
         String sql = "exec SP_NUEVOCLIENTE ?,?,?,?,?";
            
         try {
            PreparedStatement pst= reg.prepareStatement(sql);
            pst.setString(1,dni);
            pst.setString(2,nombre);
            pst.setString(3,apellido);
            pst.setString(4, direccion);
            pst.setString(5, telefono);
            int n = pst.executeUpdate();
            if (n>0){
                JOptionPane.showMessageDialog(null,"Regristado Exitosamente de Cliente");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error - "+ex);
            Logger.getLogger(CliAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//cierra metodo agregarCliente

    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    /**
     * Metodo para listar todos los registros de la tabla
     * de clientes, los muestra en un jtable.
     */
    public void listarTodosClientes() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
        CliList.jTableListarCliente.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabla();

    }//cierra metodo listarTodosClientes
        public void CargarModificarClientes() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
            CliModify.jTable_clientes.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabla();

    }    
              public void CargarEliminarClientes() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
                  CliDelete.jTable_clientes.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabla();

    } 
        public void CargarClientes() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
            Guia_de_remision.SeleccionarCliente.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabla();

    }//cierra metodo cargarTodosClientes
    public void CargarClientesVentas() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
            Ventas.SeleccionarCliente.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTabla();

    }//cierra metodo cargarTodosClientes
     /**
     * Metodo para consultar todos los regsitros de la base de datos de clientes
     * y luego ser mostrados en una tabla.
     */
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;

    public void ejecutarConsultaTodaTabla() {

        try {
            conexion = ConexionConBaseDatos.getConexion();

            sentencia = conexion.createStatement();
            String consultaSQL = "exec SP_CLIENTE";
            resultado = sentencia.executeQuery(consultaSQL);


            //mientras haya datos en la BD ejecutar eso...
            while (resultado.next()) {


                String codigo = resultado.getString("dni_clie");
                String nombre = resultado.getString("nom_clie");
                String apellido = resultado.getString("ape_clie");
                String direccion = resultado.getString("dir_clie");
                String telefono = resultado.getString("telef_clie");
                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {codigo, nombre, apellido, direccion,telefono};

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
    
  
    public void buscarCliente(String parametroBusqueda, boolean buscarPorCedula, boolean buscarPorNombre, boolean buscarPorApellido) {

        

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;

            //le asigna el modelo al jtable
            CliList.jTableListarCliente.setModel(modelo);
            //ejecuta una consulta a la BD
            buscarRegistroCedulaONombreOapellido(parametroBusqueda, buscarPorCedula, buscarPorNombre, buscarPorApellido);

        

    }//cierra metodo buscarCliente
    public void buscarListaCliente(String parametroBusqueda) {

        

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;

            //le asigna el modelo al jtable
            CliList.jTableListarCliente.setModel(modelo);
            //ejecuta una consulta a la BD
            buscarRegistrodniOnombreOapellido(parametroBusqueda);

        

    }//cierra metodo buscarCliente  
    public void buscarModificarCliente(String parametroBusqueda) {

        

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;

            //le asigna el modelo al jtable
            CliModify.jTable_clientes.setModel(modelo);
            //ejecuta una consulta a la BD
            buscarRegistrodniOnombreOapellido(parametroBusqueda);

        

    }//cierra metodo buscarCliente    
    public void buscarEliminarCliente(String parametroBusqueda) {

        

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;

            //le asigna el modelo al jtable
            CliDelete.jTable_clientes.setModel(modelo);
            //ejecuta una consulta a la BD
            buscarRegistrodniOnombreOapellido(parametroBusqueda);

        

    }//cierra metodo buscarCliente
    /**
     * Método para buscar un registro en la base de datos dentro de la tabla
     * clientes, se puede buscar por la cedula o por el nombre.
     */
        public void buscarRegistrodniOnombreOapellido(String parametroBusqueda) {

        try {

            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;

                selectSQL = "exec SP_BUSCARCLIENTE ?";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");

            resultado = ps.executeQuery();

            while (resultado.next()) {
           
                String dni = resultado.getString("dni_clie");
                String nombre = resultado.getString("nom_clie");
                String apellido = resultado.getString("ape_clie");
                String direccion = resultado.getString("dir_clie");
                String telefono = resultado.getString("telef_clie");
                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {dni, nombre, apellido, direccion,telefono};;                

             
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
    public void buscarRegistroCedulaONombreOapellido(String parametroBusqueda, boolean buscarPordni, boolean buscarPorNombre, boolean buscarPorApellido) {

        try {

            conexion = ConexionConBaseDatos.getConexion();
            String selectSQL;
            resultado = null;
       
             if(buscarPorNombre== true){
                selectSQL = "exec SP_BUSCARCLIENTEXNOMBRE ?";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
            }
            else if(buscarPorApellido== true){

                selectSQL = "exec SP_BUSCARCLIENTEXAPELLIDO ?";
                ps = conexion.prepareStatement(selectSQL);
                ps.setString(1, "%" + parametroBusqueda + "%");
            }
            resultado = ps.executeQuery();

            while (resultado.next()) {
                String codigo = resultado.getString("dni_clie");
                String nombre = resultado.getString("nom_clie");
                String apellido = resultado.getString("ape_clie");
                 String direccion = resultado.getString("dir_clie");
                String telefono = resultado.getString("telef_clie");              

                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {codigo,nombre, apellido, direccion,telefono};
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
    public void EliminarCliente(String code) {

        try {            
     Connection conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();
            int cantidad = comando.executeUpdate("exec SP_ELIMINARCLIENTE " + code);
            if (cantidad == 1) {
   
                JOptionPane.showMessageDialog(null,"Eliminado");
            } else {
                JOptionPane.showMessageDialog(null,"No existe Cliente de Codigo "+code);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error "+ex);
        }

    }//cierra metodo eliminarCliente

    
    
    public void ModificarCliente(String dni,String nombre, String apellido,String direccion,String telefono) {

    
        try {
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=BDCondor", "sa", "123");
      
            Statement comando = conexion.createStatement();

            // linea de codigo de mysql que actualiza regristos que va modificar
            int cantidad = comando.executeUpdate("exec SP_MODIFICARCLIENTE '"+dni+"', '"+nombre+"', '"+apellido+"', '"+direccion+"', '"+telefono+"'");
            if (cantidad == 1) {
                JOptionPane.showMessageDialog(null," Modifico con Exito");
            } else {
                JOptionPane.showMessageDialog(null,"No existe Vendedor de DNI "+dni);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Error -->"+ex);
        }
    }//cierra metodo modificarCliente
    
    
    
    
    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 



}//cierra class
