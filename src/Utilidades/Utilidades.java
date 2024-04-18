/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author David
 */
public class Utilidades {
public static boolean formatoDniCorrecto(JTextField campo) {

        String modeloDni = "^[0-9]{8}[A-HJ-NP-Z]{1}$";

        return campo.getText().toUpperCase().matches(modeloDni);
    }

    /**
     * Lanza alerta si el formato indicado arriba no es correcto.
     *
     * @param c
     * @param campo
     */
    public static void lanzaAlertaDni(Component c, JTextField campo) {

        JOptionPane.showMessageDialog(c, "El formato del DNI no es correcto.");
    }

    /**
     * Comprueba que la letra del dni sea la correspondiente.
     *
     * @param campo
     * @return
     */
    public static boolean letraDniCorrecta(JTextField campo) {

        int dni = Integer.parseInt(campo.getText().substring(0, 8));

        int resto = dni % 23;

        char letra = campo.getText().toUpperCase().charAt(8);

        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

        return letra == letras.charAt(resto);
    }

    /**
     * Lanza alerta en caso de que el dni no tenga la letra que corresponde.
     *
     * @param c
     * @param campo
     */
    public static void lanzaAlertaLetraDni(Component c, JTextField campo) {

        JOptionPane.showMessageDialog(c, "La letra no corresponde al DNI.");
    }
    
    
    
}
