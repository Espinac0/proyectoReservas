/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bbdd;

/**
 *
 * @author David
 */
public class ConsutasEmpleados extends Conexion {
    
    public static String recuperarDatosUser (String user) {
        String usuario = null;
        
        String consultaRecuperaTipo=
                "SELECT CONCAT(nombre, ' ', apellidos) FROM empleados WHERE usuario='" +user+"'";
        
        
        
        return usuario;
    }
    
}
