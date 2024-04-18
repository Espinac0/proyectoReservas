/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author David
 */
public class Cliente {
    String DNI , nombre , apellidos , direccion;
    int codpostal;
    String localidad;
    int tlefono_contacto;
    String email;

    public Cliente(String DNI, String nombre, String apellidos, String direccion, int codpostal, String localidad, int tlefono_contacto, String email) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.codpostal = codpostal;
        this.localidad = localidad;
        this.tlefono_contacto = tlefono_contacto;
        this.email = email;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(int codpostal) {
        this.codpostal = codpostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getTlefono_contacto() {
        return tlefono_contacto;
    }

    public void setTlefono_contacto(int tlefono_contacto) {
        this.tlefono_contacto = tlefono_contacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
