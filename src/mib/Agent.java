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
public class Agent {

    private final InfDB idb;
    private String id;
    private String admin;
    private String losenord;
    private String namn;
    private String telefon;

    public Agent(InfDB idb, String id) {

        this.idb = idb;
        this.id = id;
        try {
            admin = idb.fetchSingle("select ADMINISTRATOR from AGENT where AGENT_ID = " + id);
            losenord = idb.fetchSingle("select LOSENORD from AGENT where AGENT_ID = " + id);
            namn = idb.fetchSingle("select NAMN from AGENT where AGENT_ID = " + id);
            telefon = idb.fetchSingle("select TELEFON from AGENT where AGENT_ID = " + id);

        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Något gick fel.");
        }
    }

    public String getNamn() {
        return namn;
    }
    
   
}
