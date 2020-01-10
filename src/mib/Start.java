/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mib;

import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Daniel
 */
public class Start {

    private static InfDB idb;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            String aktuellMapp = System.getProperty("user.dir");
            String os = System.getProperty("os.name").toLowerCase();
            String sokvagDatabas;
            if (os.contains("mac")) {
                sokvagDatabas = aktuellMapp + ("/db/MIBDB.FDB");
            } else {
                sokvagDatabas = aktuellMapp + ("\\db\\MIBDB.FDB");
            }
            idb = new InfDB(sokvagDatabas);
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel!");
        }
        new MainPage(idb).setVisible(true);

    }

}
