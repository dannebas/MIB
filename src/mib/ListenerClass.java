/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mib;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Daniel
 */
public class ListenerClass implements ListSelectionListener {

    private String val;
    
    @Override
    public void valueChanged(ListSelectionEvent listener) {
        if (!listener.getValueIsAdjusting()) {
            JList<String> list = (JList<String>) listener.getSource();
            String val = list.getSelectedValue();
            if (val != null) {
                
                this.val = val;
            }
        }
    }
    
    public String getListVal(){
    
        return val;
    }
}
