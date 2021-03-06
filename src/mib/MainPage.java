/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mib;

import oru.inf.InfDB;

/**
 *
 * @author Daniel
 */
public class MainPage extends javax.swing.JFrame {

    private final InfDB idb;

    /**
     * Creates new form MainPage
     *
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

        pnlBackground = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblLogoHolder = new javax.swing.JLabel();
        pnlAlienButton = new javax.swing.JPanel();
        lblAlienInlog = new javax.swing.JLabel();
        pnlAgentButton = new javax.swing.JPanel();
        lblAgentInlog = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 475));
        setPreferredSize(new java.awt.Dimension(400, 450));
        setResizable(false);

        pnlBackground.setBackground(new java.awt.Color(29, 29, 48));
        pnlBackground.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlBackground.setLayout(null);

        lblTitle.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(204, 204, 204));
        lblTitle.setText("MIB SEKTOR SKANDINAVIEN");
        pnlBackground.add(lblTitle);
        lblTitle.setBounds(120, 180, 160, 22);

        lblLogoHolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mib/images/miblogo.png"))); // NOI18N
        pnlBackground.add(lblLogoHolder);
        lblLogoHolder.setBounds(100, 30, 210, 130);

        pnlAlienButton.setBackground(new java.awt.Color(29, 29, 48));
        pnlAlienButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlAlienButton.setLayout(new java.awt.BorderLayout());

        lblAlienInlog.setForeground(new java.awt.Color(204, 204, 204));
        lblAlienInlog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAlienInlog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mib/images/alienicon.png"))); // NOI18N
        lblAlienInlog.setText("Alien");
        lblAlienInlog.setPreferredSize(new java.awt.Dimension(78, 80));
        lblAlienInlog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAlienInlogMouseClicked(evt);
            }
        });
        pnlAlienButton.add(lblAlienInlog, java.awt.BorderLayout.CENTER);

        pnlBackground.add(pnlAlienButton);
        pnlAlienButton.setBounds(220, 310, 120, 100);

        pnlAgentButton.setBackground(new java.awt.Color(29, 29, 48));
        pnlAgentButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlAgentButton.setLayout(new java.awt.BorderLayout());

        lblAgentInlog.setForeground(new java.awt.Color(204, 204, 204));
        lblAgentInlog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAgentInlog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mib/images/headicon.png"))); // NOI18N
        lblAgentInlog.setText("Agent");
        lblAgentInlog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgentInlogMouseClicked(evt);
            }
        });
        pnlAgentButton.add(lblAgentInlog, java.awt.BorderLayout.CENTER);

        pnlBackground.add(pnlAgentButton);
        pnlAgentButton.setBounds(70, 310, 120, 100);

        getContentPane().add(pnlBackground, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblAgentInlogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgentInlogMouseClicked
        new LoginForm(idb, "AGENT").setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblAgentInlogMouseClicked

    private void lblAlienInlogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAlienInlogMouseClicked
        new LoginForm(idb, "ALIEN").setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblAlienInlogMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAgentInlog;
    private javax.swing.JLabel lblAlienInlog;
    private javax.swing.JLabel lblLogoHolder;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlAgentButton;
    private javax.swing.JPanel pnlAlienButton;
    private javax.swing.JPanel pnlBackground;
    // End of variables declaration//GEN-END:variables
}
