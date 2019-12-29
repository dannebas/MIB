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
public class Alien {

    private final InfDB idb;
    private String id;
    private String namn;
    private String losenord;

    public Alien(InfDB idb, String id) {

        this.idb = idb;
        this.id = id;
        try {
            losenord = idb.fetchSingle("select LOSENORD from ALIEN where ALIEN_ID = " + id);
            namn = idb.fetchSingle("select NAMN from ALIEN where ALIEN_ID = " + id);
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Något gick fel.");
        }

    }

    public String getNamn() {

        return namn;
    }

}
