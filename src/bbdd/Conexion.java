/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Cliente;


/**
 * clase donde guardo metodos para establecer conexion y otras cosa que requieran coinsultas
 * @author David
 */
public class Conexion {

    static Connection conn;

    /**
     * parametro de la url para entrar a la base de datos
     */
    public static final String URL = "jdbc:mysql://145.14.151.1/u812167471_reservasDG";

    /**
     * parametro de el nombre para entrar a la base de datos
     */
    public static final String USERNAME = "u812167471_reservasDG";

    /**
     * parametro de la contraseña para entrar a la base de datos
     */
    public static final String PASSWORD = "2024-DavidReservas";

    /**
     * metodo para ebtrar a la base de datos
     * @return
     */
    public static Connection conectar() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    /**
     * metodo para cerrar conexion de la base de datos
     */
    public static void cerrarConexion() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * metodo para acceder a otra pestaña poniendo un nombre y contraseña que este en la base de datos
     * @param user
     * @param pass
     * @return
     */
    public static boolean acceder(String user, String pass) {
        try {
            String consulta = "SELECT Usuario, Contraseña FROM reservas_empleados WHERE Usuario=? AND Contraseña=?";

            PreparedStatement pst = conn.prepareCall(consulta);
            ResultSet rs;

            pst.setString(1, user);
            pst.setString(2, pass);

            rs = pst.executeQuery();

            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * metodo apra comprobar si loq ue consultamos enta en la tabla dni
     * @param dni
     * @return
     */
    public static boolean comprobarDniUsuario(String dni) {
        String SSQL = "SELECT dni FROM reservas_clientes WHERE dni =?";

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement(SSQL);

            pst.setString(1, dni);
            rs = pst.executeQuery();
             if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * metodo apra comprobar si loq ue consultamos enta en la tabla usuario
     * @param usuario
     * @return
     */
    public static boolean comprobarUsuario(String usuario) {
        String SSQL = "SELECT usuario FROM usuarios WHERE usuario =?";

        PreparedStatement pst = null;
        ResultSet rs = null;
         
        try {
            pst = conn.prepareStatement(SSQL);

            pst.setString(1, usuario);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * metodo para insertar en la tabla los datos que ponemos
     * @param i
     * @return
     */
    
    
    public static boolean registrarCliente(Cliente i) {
        try {
            String consulta = "INSERT  INTO reservas_clientes(DNI,nombre,"
                    + "apellidos, direccion, codigo postal, localidad, telefono_contacto, email)"
                    + "values (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(consulta);

            pst.setString(1, i.getDNI());
            pst.setString(2, i.getNombre());
            pst.setString(3, i.getApellidos());
            pst.setString(4, i.getDireccion());
            pst.setInt(5, i.getCodpostal());
            pst.setString(6, i.getLocalidad());
            pst.setInt(7, i.getTlefono_contacto());
            pst.setString(8, i.getEmail());

            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean verificarDniEnBaseDeDatos(String dni) throws SQLException {
        

            // Consulta SQL para comprobar si el DNI está en la base de datos
            String sql = "SELECT COUNT(*) FROM reservas_clientes WHERE DNI = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, dni);

            // Ejecutar la consulta
            ResultSet rs = stmt.executeQuery();

            // Verificar si hay algún resultado
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Devuelve true si el DNI está en la base de datos
            }
        return false;
        } 
        
    

    /**
     * Método para recuperar los datos del cliente si el DNI está en la base de datos.
     * @param dni El DNI del cliente
     * @return Un objeto Cliente si se encuentra en la base de datos, null en caso contrario
     * @throws java.sql.SQLException
     */
    public static Cliente obtenerDatosCliente(String dni) throws SQLException {
    // Consulta SQL para obtener los datos del cliente
    String sql = "SELECT * FROM reservas_clientes WHERE DNI = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, dni);

    // Ejecutar la consulta
    ResultSet rs = stmt.executeQuery();

    // Verificar si hay algún resultado
    if (rs.next()) {
        // Crear un objeto Cliente con los datos obtenidos de la base de datos
        Cliente cliente = new Cliente(
            rs.getString("DNI"),
            rs.getString("nombre"),
            rs.getString("apellidos"),
            rs.getString("direccion"),
            rs.getInt("codigo postal"),
            rs.getString("localidad"),
            rs.getInt("telefono_contacto"),
            rs.getString("email")
        );

        return cliente;
    }

    return null; // Si no se encuentra el cliente, se devuelve null
}




    
    
}
