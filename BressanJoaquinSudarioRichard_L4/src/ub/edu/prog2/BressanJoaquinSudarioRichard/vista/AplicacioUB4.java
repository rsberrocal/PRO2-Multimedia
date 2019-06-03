/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.vista;

import ub.edu.prog2.BressanJoaquinSudarioRichard.controlador.Controlador;
import edu.ub.prog2.utils.AplicacioException;
import java.awt.Container;
import javax.swing.JOptionPane;
/**
 *
 * @author joaqu
 */
public class AplicacioUB4 extends javax.swing.JFrame{
    Controlador ctrl = new Controlador();    
    String path, nom, codec, pathFile, nomAlbum, camiImatge, vlcPath;
    float durada, fps;
    int alcada, amplada, kbps, idBFM;
    Container content = this.getContentPane();
    
    /**
     * Creates new form AplicacioUB4
     */
    public AplicacioUB4(Controlador ctrl) {
        this.ctrl = ctrl;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(800, 600);
        this.filesProgress.setValue(this.ctrl.getSizeLib());
        this.albumsProgress.setValue(this.ctrl.getNumAlbums());
        this.lblNumFiles.setText(Integer.toString(this.ctrl.getSizeLib())+"%");
        this.lblNumAlbums.setText(Integer.toString(this.ctrl.getNumAlbums())+"%");
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gestio = new javax.swing.JPanel();
        btnGestioLib = new javax.swing.JButton();
        filesProgress = new javax.swing.JProgressBar();
        btnGestioAlbums = new javax.swing.JButton();
        albumsProgress = new javax.swing.JProgressBar();
        lblNumFiles = new javax.swing.JLabel();
        lblNumAlbums = new javax.swing.JLabel();
        lblMainMenu = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnLoadData = new javax.swing.JButton();
        btnSaveData = new javax.swing.JButton();
        txtDataPath = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(162, 145, 50));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        gestio.setForeground(new java.awt.Color(182, 159, 74));

        btnGestioLib.setText("Gestio Biblioteca");
        btnGestioLib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestioLibActionPerformed(evt);
            }
        });

        btnGestioAlbums.setText("Gestio Albums");
        btnGestioAlbums.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestioAlbumsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gestioLayout = new javax.swing.GroupLayout(gestio);
        gestio.setLayout(gestioLayout);
        gestioLayout.setHorizontalGroup(
            gestioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gestioLayout.createSequentialGroup()
                .addGroup(gestioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gestioLayout.createSequentialGroup()
                        .addComponent(btnGestioLib)
                        .addGap(28, 28, 28)
                        .addComponent(filesProgress, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
                    .addGroup(gestioLayout.createSequentialGroup()
                        .addComponent(btnGestioAlbums)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(albumsProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gestioLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(gestioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumFiles, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNumAlbums, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        gestioLayout.setVerticalGroup(
            gestioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gestioLayout.createSequentialGroup()
                .addComponent(lblNumFiles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gestioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGestioLib, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filesProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(lblNumAlbums)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gestioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGestioAlbums, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(gestioLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(albumsProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        lblMainMenu.setText("Main Menu");

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnLoadData.setText("Carregar Dades");
        btnLoadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDataActionPerformed(evt);
            }
        });

        btnSaveData.setText("Guardar Dades");
        btnSaveData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDataActionPerformed(evt);
            }
        });

        txtDataPath.setText("Insert file's path...");
        txtDataPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataPathActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(gestio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(690, Short.MAX_VALUE)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDataPath, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(284, 284, 284)
                                    .addComponent(lblMainMenu))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(120, 120, 120)
                                    .addComponent(btnSaveData)
                                    .addGap(66, 66, 66)
                                    .addComponent(btnLoadData))))
                        .addGap(0, 390, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gestio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 315, Short.MAX_VALUE)
                .addComponent(txtDataPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveData)
                    .addComponent(btnLoadData))
                .addGap(26, 26, 26)
                .addComponent(btnExit)
                .addContainerGap())
        );

        gestio.getAccessibleContext().setAccessibleName("");
        gestio.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGestioLibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestioLibActionPerformed
        dispose();
        GestioBiblioteca gestioLib = new GestioBiblioteca(this.ctrl);
        gestioLib.setLocationRelativeTo(null);
        gestioLib.setVisible(true);        
    }//GEN-LAST:event_btnGestioLibActionPerformed

    private void btnGestioAlbumsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestioAlbumsActionPerformed
        dispose();
        GestioAlbums gestioAlb = new GestioAlbums(this.ctrl);
        gestioAlb.setLocationRelativeTo(null);
        gestioAlb.setVisible(true);
    }//GEN-LAST:event_btnGestioAlbumsActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnLoadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDataActionPerformed
       try {
            ctrl.carregarDadesDisc(this.txtDataPath.getText());
            JOptionPane.showMessageDialog(this, "Data Loaded!", "Confirm", JOptionPane.PLAIN_MESSAGE);
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
       this.txtDataPath.setText("Insert file's path...");
    }//GEN-LAST:event_btnLoadDataActionPerformed

    private void btnSaveDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDataActionPerformed
        try {
            ctrl.guardarDadesDisc(this.txtDataPath.getText());
            JOptionPane.showMessageDialog(this, "Data Saved!", "Confirm", JOptionPane.PLAIN_MESSAGE);
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.txtDataPath.setText("Insert file's path...");
    }//GEN-LAST:event_btnSaveDataActionPerformed

    private void txtDataPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataPathActionPerformed
        
    }//GEN-LAST:event_txtDataPathActionPerformed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden

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
            java.util.logging.Logger.getLogger(AplicacioUB4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplicacioUB4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplicacioUB4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplicacioUB4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new AplicacioUB4(this.ctrl).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar albumsProgress;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGestioAlbums;
    private javax.swing.JButton btnGestioLib;
    private javax.swing.JButton btnLoadData;
    private javax.swing.JButton btnSaveData;
    private javax.swing.JProgressBar filesProgress;
    private javax.swing.JPanel gestio;
    private javax.swing.JLabel lblMainMenu;
    private javax.swing.JLabel lblNumAlbums;
    private javax.swing.JLabel lblNumFiles;
    private javax.swing.JTextField txtDataPath;
    // End of variables declaration//GEN-END:variables
}
