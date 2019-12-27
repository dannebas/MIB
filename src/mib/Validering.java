/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mib;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Daniel
 */
public class Validering {

    public static boolean kollaTextRutaTom(JTextField tf) {
        boolean svar = true;

        if (tf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Du måste fylla i alla fält");
            tf.requestFocus();
            svar = false;
        }
        return svar;
    }

    public static boolean kollaHeltal(JTextField tf) {
        boolean svar = true;

        try {
            Integer.parseInt(tf.getText());
            tf.requestFocus();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Vänligen ange ett heltal");
            svar = false;
        }
        return svar;
    }
}