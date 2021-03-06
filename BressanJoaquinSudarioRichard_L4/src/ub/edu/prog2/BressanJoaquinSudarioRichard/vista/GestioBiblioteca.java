/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.edu.prog2.BressanJoaquinSudarioRichard.vista;

import edu.ub.prog2.utils.AplicacioException;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import ub.edu.prog2.BressanJoaquinSudarioRichard.controlador.Controlador;

/**
 *
 * @author rsudarbe117.alumnes
 */
public class GestioBiblioteca extends javax.swing.JFrame {

    /**
     * Creates new form GestioBiblioteca
     */
    Controlador ctrl;

    //Set controlador
    public GestioBiblioteca(Controlador ctrl) {
        this.ctrl = ctrl;
        this.setResizable(false);
        initComponents();
        this.setFiles();
        if (this.ctrl.isEmpty()) {
            this.removeFileBtn.setEnabled(false);
        }
    }

    public void setFiles() {
        this.filesList.setModel(new AbstractListModel<String>() {
            List<String> l = ctrl.mostrarBibliotecaNames();

            @Override
            public int getSize() {
                return l.size();
            }

            @Override
            public String getElementAt(int index) {
                return l.get(index);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        filesList = new javax.swing.JList<>();
        backBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        addFileBtn = new javax.swing.JButton();
        removeFileBtn = new javax.swing.JButton();
        playBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(filesList);

        backBtn.setText("Go Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        addFileBtn.setText("Add File");
        addFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFileBtnActionPerformed(evt);
            }
        });

        removeFileBtn.setText("Remove File");
        removeFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFileBtnActionPerformed(evt);
            }
        });

        playBtn.setText("▶");
        playBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(addFileBtn)
                .addGap(29, 29, 29)
                .addComponent(removeFileBtn)
                .addGap(40, 40, 40)
                .addComponent(playBtn)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addFileBtn)
                    .addComponent(removeFileBtn)
                    .addComponent(playBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(backBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        AplicacioUB4 mView = new AplicacioUB4(ctrl);
        mView.setLocationRelativeTo(null);
        mView.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void addFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFileBtnActionPerformed
        // TODO add your handling code here:
        //PONER FILE FORM
        dispose();
        AddFileLib addFile = new AddFileLib(this.ctrl);
        addFile.setVisible(true);

    }//GEN-LAST:event_addFileBtnActionPerformed

    private void playBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playBtnActionPerformed
        // TODO add your handling code here:
        //OPEN CONTROLLER 
        if (ctrl.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "0 files", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            GestioReproducció gRep = new GestioReproducció(ctrl, true);
            try {
                if (this.filesList.isSelectionEmpty()) {
                    ctrl.reproduirCarpeta();

                } else {
                    String selected = filesList.getSelectedValue();
                    selected = selected.substring(selected.indexOf("[") + 1);
                    selected = selected.substring(0, selected.indexOf("]"));
                    int index = Integer.parseInt(selected);
                    ctrl.reproduirFitxer(index - 1);
                }
            } catch (AplicacioException ex) {
                JOptionPane.showMessageDialog(this,
                        ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            gRep.setLocationRelativeTo(null);
            gRep.setVisible(true);
        }
    }//GEN-LAST:event_playBtnActionPerformed

    private void removeFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFileBtnActionPerformed
        // TODO add your handling code here:
        if (ctrl.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "0 files", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String selected = filesList.getSelectedValue();
            selected = selected.substring(selected.indexOf("[") + 1);
            selected = selected.substring(0, selected.indexOf("]"));
            int index = Integer.parseInt(selected);
            try {
                ctrl.esborrarFitxer(index - 1);
            } catch (AplicacioException ex) {
                JOptionPane.showMessageDialog(this,
                        ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (ctrl.isEmpty()) {
                this.removeFileBtn.setEnabled(false);
            }
            this.setFiles();
        }
    }//GEN-LAST:event_removeFileBtnActionPerformed

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
            java.util.logging.Logger.getLogger(GestioBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestioBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestioBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestioBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new GestioBiblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFileBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JList<String> filesList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton playBtn;
    private javax.swing.JButton removeFileBtn;
    // End of variables declaration//GEN-END:variables
}
