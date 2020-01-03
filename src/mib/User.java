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
public class User {

    private final InfDB idb;
    private String id;
    private String admin;
    private String namn;
    private String anvandarTyp;

    public User(InfDB idb, String id, String anvandarTyp) {

        this.idb = idb;
        this.id = id;
        this.anvandarTyp = anvandarTyp;

        try {
            switch (anvandarTyp) {
                case "AGENT":
                    admin = idb.fetchSingle("select ADMINISTRATOR from AGENT where AGENT_ID = " + id);
                    namn = idb.fetchSingle("select NAMN from AGENT where AGENT_ID = " + id);
                    break;
                case "ALIEN":
                    namn = idb.fetchSingle("select NAMN from ALIEN where ALIEN_ID = " + id);
                    break;
            }
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Något gick fel.");
        }
    }

    public String getNamn() {
        return namn;
    }

    public String getId() {
        return id;
    }
    
    public String getAdmin(){
        return admin;
    }
    
    public String getTyp(){
        return anvandarTyp;
    }

}
