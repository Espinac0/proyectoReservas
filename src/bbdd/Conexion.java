/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**import modelo.Usuario;
import modelo.Utilidades; */

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
            String consulta = "SELECT usuario, contrasenya FROM usuarios WHERE usuario=? AND contrasenya=?";

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
        String SSQL = "SELECT dni FROM usuarios WHERE dni =?";

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
    /**public static boolean registrarPersona(Usuario i) {
        try {
            String consulta = "INSERT  INTO usuarios(dni,nombre,"
                    + "apellidos, telefono, usuario, contrasenya)"
                    + "values (?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(consulta);

            pst.setString(1, i.getDni());
            pst.setString(2, i.getNombre());
            pst.setString(3, i.getApellidos());
            pst.setInt(4, i.getTelefono());
            pst.setString(5, i.getUsuario());
            pst.setString(6, i.getContrasenya());

            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
*/
    
    
    
}
