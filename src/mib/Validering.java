/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mib;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
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

    public static boolean kollaLosenOrd(JPasswordField tf) {
        boolean svar = true;

        if (tf.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Du måste fylla i ett lösenord");
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

    public static boolean kollaUtloggning() {
        boolean svar = false;
        String[] val = {"Ja", "Nej"};
        int n = JOptionPane.showOptionDialog(null,
                "Är du säker på att du vill logga ut?",
                "Logga ut",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, val, val[0]);
        if (n == JOptionPane.YES_OPTION) {
            svar = true;
        } else if (n == JOptionPane.NO_OPTION) {
            svar = false;
        }
        return svar;
    }

    public static boolean kollaRadering() {
        boolean svar = false;
        String[] val = {"Ja", "Nej"};
        int n = JOptionPane.showOptionDialog(null,
                "Är du säker på att du vill radera?",
                "Radera",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, val, val[0]);
        if (n == JOptionPane.YES_OPTION) {
            svar = true;
        } else if (n == JOptionPane.NO_OPTION) {
            svar = false;
        }
        return svar;
    }

}
