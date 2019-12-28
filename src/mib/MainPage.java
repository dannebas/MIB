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
public class MainPage extends javax.swing.JFrame {

    private InfDB idb;

    /**
     * Creates new form MainPage
     * @param idb databaskopplingen
     */
    public MainPage(InfDB idb) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.idb = idb;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblAgentInlog = new javax.swing.JLabel();
        lblAlienInlog = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 475));
        setPreferredSize(new java.awt.Dimension(400, 450));
        setResizable(false);
        getContentPane().setLayout(null);

        lblTitle.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(204, 204, 204));
        lblTitle.setText("MIB SEKTOR SKANDINAVIEN");
        getContentPane().add(lblTitle);
        lblTitle.setBounds(120, 260, 160, 22);

        lblAgentInlog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mib/images/headicon.png"))); // NOI18N
        lblAgentInlog.setText("Agent");
        lblAgentInlog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgentInlogMouseClicked(evt);
            }
        });
        getContentPane().add(lblAgentInlog);
        lblAgentInlog.setBounds(80, 320, 80, 80);

        lblAlienInlog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mib/images/alienicon.png"))); // NOI18N
        lblAlienInlog.setText("Alien");
        lblAlienInlog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAlienInlogMouseClicked(evt);
            }
        });
        getContentPane().add(lblAlienInlog);
        lblAlienInlog.setBounds(220, 320, 100, 80);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mib/images/bg2.png"))); // NOI18N
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, 0, 400, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblAgentInlogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgentInlogMouseClicked
        // TODO add your handling code here:
        new LoginForm(idb, "AGENT").setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_lblAgentInlogMouseClicked

    private void lblAlienInlogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAlienInlogMouseClicked
        // TODO add your handling code here:
        new LoginForm(idb, "ALIEN").setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_lblAlienInlogMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAgentInlog;
    private javax.swing.JLabel lblAlienInlog;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}