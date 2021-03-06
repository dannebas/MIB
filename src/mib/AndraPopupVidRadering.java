/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mib;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Daniel
 */
public class AndraPopupVidRadering extends javax.swing.JFrame {

    private final InfDB idb;
    private final String id;

    /**
     * Creates new form bytOmradesChef
     */
    public AndraPopupVidRadering(InfDB idb, String id) {

        initComponents();
        this.idb = idb;
        this.id = id;
        this.setLocationRelativeTo(null);
        String kontorsChefAgentId;
        ArrayList<String> omradesChefAgentId;
        ArrayList<String> alienAgentId;
        fyllComboBoxar();
        pnlBytOmradesChef.setVisible(false);
        pnlBytKontorsChef.setVisible(false);
        pnlBytAnsvarigAgent.setVisible(false);

        try {
            kontorsChefAgentId = idb.fetchSingle("select agent_id from kontorschef");
            omradesChefAgentId = idb.fetchColumn("select agent_id from omradeschef");
            alienAgentId = idb.fetchColumn("select ansvarig_agent from alien");

            if (omradesChefAgentId.contains(id)) {
                pnlBytOmradesChef.setVisible(true);
            }
            if (kontorsChefAgentId.equals(id)) {
                pnlBytKontorsChef.setVisible(true);
            }
            if (alienAgentId.contains(id)) {
                pnlBytAnsvarigAgent.setVisible(true);
            }
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "N�got gick fel.");
        }
    }

    private void fyllComboBoxar() {

        try {
            /* Omr�deschefer */
            String omrade = idb.fetchSingle("select BENAMNING from OMRADE where OMRADES_ID like (select OMRADE from OMRADESCHEF where AGENT_ID =" + id + ")");

            lblValjNyOmradesChef.setText("Agenten �r omr�deschef f�r " + omrade + ", v�lj en ny omr�deschef.");
            ArrayList<HashMap<String, String>> allaTillgangligaAgenterForOmradesChef;
            allaTillgangligaAgenterForOmradesChef = idb.fetchRows("select AGENT_ID, NAMN from AGENT where AGENT_ID not in(select AGENT_ID from OMRADESCHEF)");
            for (HashMap<String, String> enAgent : allaTillgangligaAgenterForOmradesChef) {
                jcbNyOmradesChef.addItem(enAgent.get("AGENT_ID") + " " + enAgent.get("NAMN"));
            }

            /* Kontorschefer    */
            ArrayList<HashMap<String, String>> allaTillgangligaAgenterForKontorsChef;
            allaTillgangligaAgenterForKontorsChef = idb.fetchRows("select AGENT_ID, NAMN from AGENT where AGENT_ID not in (select AGENT_ID from KONTORSCHEF)");
            for (HashMap<String, String> enAgent : allaTillgangligaAgenterForKontorsChef) {
                jcbNyKontorsChef.addItem(enAgent.get("AGENT_ID") + " " + enAgent.get("NAMN"));
            }

            /* Ansvariga agenter*/
            ArrayList<HashMap<String, String>> allaAgenter = idb.fetchRows("select AGENT_ID, NAMN from AGENT where AGENT_ID != " + id);
            for (HashMap<String, String> enAgent : allaAgenter) {
                jcbNyAnsvarigAgent.addItem(enAgent.get("AGENT_ID") + " " + enAgent.get("NAMN"));
            }
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Kunde inte h�mta till comboboxar.");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBytOmradesChefBG = new javax.swing.JPanel();
        pnlBytAnsvarigAgent = new javax.swing.JPanel();
        lblAnsvar = new javax.swing.JLabel();
        lblOvertaAnsvar = new javax.swing.JLabel();
        lblTillgangligaAnsvarigaAgenter = new javax.swing.JLabel();
        jcbNyAnsvarigAgent = new javax.swing.JComboBox<>();
        pnlBytOmradesChef = new javax.swing.JPanel();
        lblValjNyOmradesChef = new javax.swing.JLabel();
        lblValjNy = new javax.swing.JLabel();
        lblTillgangligaOmradesChefer = new javax.swing.JLabel();
        jcbNyOmradesChef = new javax.swing.JComboBox<>();
        pnlBytKontorsChef = new javax.swing.JPanel();
        lblValjNyKontorsChef = new javax.swing.JLabel();
        lblNyKontorsChef = new javax.swing.JLabel();
        lblTillgangligaKontorsChefer = new javax.swing.JLabel();
        jcbNyKontorsChef = new javax.swing.JComboBox<>();
        btnTillbaka = new javax.swing.JButton();
        btnBytOmradesChef = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(776, 287));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(776, 287));
        setResizable(false);

        pnlBytOmradesChefBG.setBackground(new java.awt.Color(29, 29, 48));
        pnlBytOmradesChefBG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlBytOmradesChefBG.setLayout(null);

        pnlBytAnsvarigAgent.setBackground(new java.awt.Color(29, 29, 48));
        pnlBytAnsvarigAgent.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pnlBytAnsvarigAgent.setLayout(null);

        lblAnsvar.setForeground(new java.awt.Color(204, 204, 204));
        lblAnsvar.setText("Agenten ansvarar f�r minst en alien.");
        pnlBytAnsvarigAgent.add(lblAnsvar);
        lblAnsvar.setBounds(10, 10, 220, 16);

        lblOvertaAnsvar.setForeground(new java.awt.Color(204, 204, 204));
        lblOvertaAnsvar.setText("V�lj vem som ska �verta ansvaret.");
        pnlBytAnsvarigAgent.add(lblOvertaAnsvar);
        lblOvertaAnsvar.setBounds(10, 30, 200, 16);

        lblTillgangligaAnsvarigaAgenter.setForeground(new java.awt.Color(204, 204, 204));
        lblTillgangligaAnsvarigaAgenter.setText("Tillg�ngliga agenter:");
        pnlBytAnsvarigAgent.add(lblTillgangligaAnsvarigaAgenter);
        lblTillgangligaAnsvarigaAgenter.setBounds(20, 80, 130, 24);

        pnlBytAnsvarigAgent.add(jcbNyAnsvarigAgent);
        jcbNyAnsvarigAgent.setBounds(20, 110, 190, 30);

        pnlBytOmradesChefBG.add(pnlBytAnsvarigAgent);
        pnlBytAnsvarigAgent.setBounds(270, 20, 240, 160);

        pnlBytOmradesChef.setBackground(new java.awt.Color(29, 29, 48));
        pnlBytOmradesChef.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pnlBytOmradesChef.setLayout(null);

        lblValjNyOmradesChef.setForeground(new java.awt.Color(204, 204, 204));
        lblValjNyOmradesChef.setText("Agenten �r omr�deschef f�r Svealand.");
        pnlBytOmradesChef.add(lblValjNyOmradesChef);
        lblValjNyOmradesChef.setBounds(10, 10, 220, 16);

        lblValjNy.setForeground(new java.awt.Color(204, 204, 204));
        lblValjNy.setText("V�lj en ny omr�deschef.");
        pnlBytOmradesChef.add(lblValjNy);
        lblValjNy.setBounds(10, 30, 140, 16);

        lblTillgangligaOmradesChefer.setForeground(new java.awt.Color(204, 204, 204));
        lblTillgangligaOmradesChefer.setText("Tillg�ngliga agenter:");
        pnlBytOmradesChef.add(lblTillgangligaOmradesChefer);
        lblTillgangligaOmradesChefer.setBounds(20, 80, 130, 24);

        pnlBytOmradesChef.add(jcbNyOmradesChef);
        jcbNyOmradesChef.setBounds(20, 110, 190, 30);

        pnlBytOmradesChefBG.add(pnlBytOmradesChef);
        pnlBytOmradesChef.setBounds(20, 20, 240, 160);

        pnlBytKontorsChef.setBackground(new java.awt.Color(29, 29, 48));
        pnlBytKontorsChef.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pnlBytKontorsChef.setLayout(null);

        lblValjNyKontorsChef.setForeground(new java.awt.Color(204, 204, 204));
        lblValjNyKontorsChef.setText("Agenten �r kontorschef.");
        pnlBytKontorsChef.add(lblValjNyKontorsChef);
        lblValjNyKontorsChef.setBounds(10, 10, 220, 16);

        lblNyKontorsChef.setForeground(new java.awt.Color(204, 204, 204));
        lblNyKontorsChef.setText("V�lj en ny kontorschef.");
        pnlBytKontorsChef.add(lblNyKontorsChef);
        lblNyKontorsChef.setBounds(10, 30, 140, 16);

        lblTillgangligaKontorsChefer.setForeground(new java.awt.Color(204, 204, 204));
        lblTillgangligaKontorsChefer.setText("Tillg�ngliga agenter:");
        pnlBytKontorsChef.add(lblTillgangligaKontorsChefer);
        lblTillgangligaKontorsChefer.setBounds(20, 80, 130, 24);

        pnlBytKontorsChef.add(jcbNyKontorsChef);
        jcbNyKontorsChef.setBounds(20, 110, 190, 30);

        pnlBytOmradesChefBG.add(pnlBytKontorsChef);
        pnlBytKontorsChef.setBounds(520, 20, 240, 160);

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });
        pnlBytOmradesChefBG.add(btnTillbaka);
        btnTillbaka.setBounds(40, 200, 100, 32);

        btnBytOmradesChef.setText("OK");
        btnBytOmradesChef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBytOmradesChefActionPerformed(evt);
            }
        });
        pnlBytOmradesChefBG.add(btnBytOmradesChef);
        btnBytOmradesChef.setBounds(160, 200, 77, 32);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBytOmradesChefBG, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBytOmradesChefBG, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBytOmradesChefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBytOmradesChefActionPerformed
        String nyOmradesChef = jcbNyOmradesChef.getSelectedItem().toString().split(" ")[0];
        String nyKontorsChef = jcbNyKontorsChef.getSelectedItem().toString().split(" ")[0];
        String nyAnsvarigAgent = jcbNyAnsvarigAgent.getSelectedItem().toString().split(" ")[0];

        try {

            idb.update("update OMRADESCHEF set AGENT_ID = " + nyOmradesChef + " where AGENT_ID = " + id);
            idb.update("update KONTORSCHEF set AGENT_ID = " + nyKontorsChef + " where AGENT_ID = " + id);
            idb.update("update ALIEN set ANSVARIG_AGENT = " + nyAnsvarigAgent + " where ANSVARIG_AGENT = " + id);
            idb.delete("delete from FALTAGENT where AGENT_ID = " + id);
            idb.delete("delete from INNEHAR_UTRUSTNING where AGENT_ID =" + id);
            idb.delete("delete from INNEHAR_FORDON where AGENT_ID =" + id);
            idb.delete("delete from AGENT where AGENT_ID = " + id);

            JOptionPane.showMessageDialog(null, "Informationen �ndrad, agenten raderad.");
            this.dispose();

        } catch (InfException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Kunde inte radera agenten.()");
        }
    }//GEN-LAST:event_btnBytOmradesChefActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnTillbakaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBytOmradesChef;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JComboBox<String> jcbNyAnsvarigAgent;
    private javax.swing.JComboBox<String> jcbNyKontorsChef;
    private javax.swing.JComboBox<String> jcbNyOmradesChef;
    private javax.swing.JLabel lblAnsvar;
    private javax.swing.JLabel lblNyKontorsChef;
    private javax.swing.JLabel lblOvertaAnsvar;
    private javax.swing.JLabel lblTillgangligaAnsvarigaAgenter;
    private javax.swing.JLabel lblTillgangligaKontorsChefer;
    private javax.swing.JLabel lblTillgangligaOmradesChefer;
    private javax.swing.JLabel lblValjNy;
    private javax.swing.JLabel lblValjNyKontorsChef;
    private javax.swing.JLabel lblValjNyOmradesChef;
    private javax.swing.JPanel pnlBytAnsvarigAgent;
    private javax.swing.JPanel pnlBytKontorsChef;
    private javax.swing.JPanel pnlBytOmradesChef;
    private javax.swing.JPanel pnlBytOmradesChefBG;
    // End of variables declaration//GEN-END:variables
}
