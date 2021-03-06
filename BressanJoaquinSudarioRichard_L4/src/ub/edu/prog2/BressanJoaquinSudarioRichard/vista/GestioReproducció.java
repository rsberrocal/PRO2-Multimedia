/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.vista;

import edu.ub.prog2.utils.AplicacioException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ub.edu.prog2.BressanJoaquinSudarioRichard.controlador.Controlador;
 
/**
 *
 * @author joaqu
 */
public class GestioReproducció extends javax.swing.JFrame {
    Controlador ctrl;
    boolean isLib;
    /**
     * Creates new form GestioReproducció
     */
    public GestioReproducció(Controlador ctrl, boolean b) {
        initComponents();
        this.isLib = b;
        this.ctrl = ctrl;
        this.setLocation(0,472);
        this.ctrl.obrirFinestraReproductor();
        this.ctrl.setRandom(false);
        this.ctrl.setContinu(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mediaControlPanel = new javax.swing.JPanel();
        btnPlay = new javax.swing.JButton();
        btnGoForward = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnRandom = new javax.swing.JButton();
        btnContinue = new javax.swing.JButton();
        checkRandom = new javax.swing.JCheckBox();
        checkContinue = new javax.swing.JCheckBox();
        btnGoBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPlay.setText("❚❚");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        btnGoForward.setText("⏭");
        btnGoForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoForwardActionPerformed(evt);
            }
        });

        btnStop.setText("⏹");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        btnRandom.setText("🔀");
        btnRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRandomActionPerformed(evt);
            }
        });

        btnContinue.setText("🔁");
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });

        checkRandom.setText("Reproduccio Aleatoria");
        checkRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkRandomActionPerformed(evt);
            }
        });

        checkContinue.setText("Reproduccio Continua");
        checkContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkContinueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mediaControlPanelLayout = new javax.swing.GroupLayout(mediaControlPanel);
        mediaControlPanel.setLayout(mediaControlPanelLayout);
        mediaControlPanelLayout.setHorizontalGroup(
            mediaControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mediaControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPlay)
                .addGap(18, 18, 18)
                .addComponent(btnStop)
                .addGap(18, 18, 18)
                .addComponent(btnGoForward)
                .addGap(18, 18, 18)
                .addComponent(btnRandom)
                .addGap(18, 18, 18)
                .addComponent(btnContinue)
                .addGap(18, 18, 18)
                .addGroup(mediaControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkRandom)
                    .addComponent(checkContinue))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        mediaControlPanelLayout.setVerticalGroup(
            mediaControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mediaControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mediaControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPlay)
                    .addComponent(btnStop)
                    .addComponent(btnGoForward)
                    .addComponent(btnRandom)
                    .addComponent(btnContinue))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mediaControlPanelLayout.createSequentialGroup()
                .addComponent(checkRandom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnGoBack.setText("Go Back");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGoBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(mediaControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mediaControlPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGoBack)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        if(this.btnPlay.getText().equals("❚❚")){
            try {
                this.ctrl.pausaReproduccio();
            } catch (AplicacioException ex) {
                JOptionPane.showMessageDialog(this,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            this.btnPlay.setText("▶");
        }else{
            try {
                this.ctrl.reemprenReproduccio();
            } catch (AplicacioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            this.btnPlay.setText("❚❚");
        }
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueActionPerformed
        if (this.checkContinue.isSelected()){
            this.checkContinue.setSelected(false);
        }else{
            this.checkContinue.setSelected(true);
        }
    }//GEN-LAST:event_btnContinueActionPerformed

    private void checkRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkRandomActionPerformed
        this.ctrl.setRandom(this.checkRandom.isSelected());
    }//GEN-LAST:event_checkRandomActionPerformed

    private void checkContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkContinueActionPerformed
        this.ctrl.setContinu(this.checkContinue.isSelected());
    }//GEN-LAST:event_checkContinueActionPerformed

    private void btnRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRandomActionPerformed
        if (this.checkRandom.isSelected()){
            this.checkRandom.setSelected(false);
        }else{
            this.checkRandom.setSelected(true);
        }
    }//GEN-LAST:event_btnRandomActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        if(this.isLib){
            try {
                this.ctrl.aturaReproduccio();
            } catch (AplicacioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            dispose();
            GestioBiblioteca gestioLib = new GestioBiblioteca(this.ctrl);
            gestioLib.setLocationRelativeTo(null);
            gestioLib.setVisible(true);
        }else{
            try {
                this.ctrl.aturaReproduccio();
            } catch (AplicacioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            dispose();
            GestioAlbums gestioAlb = new GestioAlbums(this.ctrl);
            gestioAlb.setLocationRelativeTo(null);
            gestioAlb.setVisible(true);
        }
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnGoForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoForwardActionPerformed
        try {
            this.ctrl.saltaReproduccio();
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGoForwardActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        if(this.isLib){
            try {
                this.ctrl.aturaReproduccio();
            } catch (AplicacioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            dispose();
            GestioBiblioteca gestioLib = new GestioBiblioteca(this.ctrl);
            gestioLib.setLocationRelativeTo(null);
            gestioLib.setVisible(true);
        }else{
            try {
                this.ctrl.aturaReproduccio();
            } catch (AplicacioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            dispose();
            GestioAlbums gestioAlb = new GestioAlbums(this.ctrl);
            gestioAlb.setLocationRelativeTo(null);
            gestioAlb.setVisible(true);
        }
    }//GEN-LAST:event_btnGoBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestioReproducció.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestioReproducció.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestioReproducció.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestioReproducció.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new GestioReproducció().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinue;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnGoForward;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnRandom;
    private javax.swing.JButton btnStop;
    private javax.swing.JCheckBox checkContinue;
    private javax.swing.JCheckBox checkRandom;
    private javax.swing.JPanel mediaControlPanel;
    // End of variables declaration//GEN-END:variables
}
