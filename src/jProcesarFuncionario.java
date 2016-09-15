/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sylar
 */

import Clases.*;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class jProcesarFuncionario extends javax.swing.JFrame {
clsConceptosFuncionario conFun=new clsConceptosFuncionario();
    /**
     * Creates new form jProcesarFuncionario
     */
    public jProcesarFuncionario() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void CargaPagina(){ //Funcion para realizar la carga inicial del formulario
        
        tblHaberes.setModel(new DefaultTableModel());
        tblDescuentos.setModel(new DefaultTableModel());
        
        conFun.ListarConceptosFuncionario(tblHaberes, "H");
        conFun.ListarConceptosFuncionario(tblDescuentos, "D");
        
        if (conFun.RevisaLiquidada()){
            tblHaberes.setBackground(Color.LIGHT_GRAY);
            tblDescuentos.setBackground(Color.LIGHT_GRAY);
            btnLiquidar.setText("Reliquidar");
            tblHaberes.setEnabled(false);
        }else{
            tblHaberes.setBackground(Color.white);
            tblDescuentos.setBackground(Color.white);
            btnLiquidar.setText("Liquidar");
            tblHaberes.setEnabled(true);
        }
        
        lblTotalHaberes.setText(Integer.toString(conFun.SumaConceptos("H",0)));
        lblTotalImponible.setText(Integer.toString(conFun.SumaConceptos("H",1)));
        lblTotalTributable.setText(Integer.toString(conFun.SumaConceptos("H",2)));
        lblTotalDescuentos.setText(Integer.toString(conFun.SumaConceptos("D",0)));
        lblLiquidoAPagar.setText(Integer.toString(conFun.SumaConceptos("H",0)-conFun.SumaConceptos("D",0)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        popMenuHaberes = new javax.swing.JPopupMenu();
        mnuEliminarHaber = new javax.swing.JMenuItem();
        popMenuDescuentos = new javax.swing.JPopupMenu();
        mnuEliminarDescuento = new javax.swing.JMenuItem();
        javax.swing.JPanel pnlHaberes = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblHaberes = new javax.swing.JTable();
        pnlDescuentos = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDescuentos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAgregarConcepto = new javax.swing.JButton();
        btnAgregarPersonas = new javax.swing.JButton();
        btnLiquidar = new javax.swing.JButton();
        lblTotalHaberes = new javax.swing.JLabel();
        lblTotalImponible = new javax.swing.JLabel();
        lblTotalTributable = new javax.swing.JLabel();
        lblTotalDescuentos = new javax.swing.JLabel();
        lblLiquidoAPagar = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        popMenuHaberes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                popMenuHaberesMouseClicked(evt);
            }
        });

        mnuEliminarHaber.setText("Eliminar");
        mnuEliminarHaber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEliminarHaberActionPerformed(evt);
            }
        });
        popMenuHaberes.add(mnuEliminarHaber);

        mnuEliminarDescuento.setText("Eliminar");
        mnuEliminarDescuento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuEliminarDescuentoMouseClicked(evt);
            }
        });
        mnuEliminarDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEliminarDescuentoActionPerformed(evt);
            }
        });
        popMenuDescuentos.add(mnuEliminarDescuento);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Procesar Funcionarios");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlHaberes.setBorder(javax.swing.BorderFactory.createTitledBorder("HABERES"));

        tblHaberes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblHaberes.setToolTipText("");
        tblHaberes.setComponentPopupMenu(popMenuHaberes);
        tblHaberes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHaberesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblHaberes);

        javax.swing.GroupLayout pnlHaberesLayout = new javax.swing.GroupLayout(pnlHaberes);
        pnlHaberes.setLayout(pnlHaberesLayout);
        pnlHaberesLayout.setHorizontalGroup(
            pnlHaberesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHaberesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlHaberesLayout.setVerticalGroup(
            pnlHaberesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHaberesLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pnlDescuentos.setBorder(javax.swing.BorderFactory.createTitledBorder("DESCUENTOS"));

        tblDescuentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDescuentos.setColumnSelectionAllowed(true);
        tblDescuentos.setComponentPopupMenu(popMenuDescuentos);
        jScrollPane4.setViewportView(tblDescuentos);

        javax.swing.GroupLayout pnlDescuentosLayout = new javax.swing.GroupLayout(pnlDescuentos);
        pnlDescuentos.setLayout(pnlDescuentosLayout);
        pnlDescuentosLayout.setHorizontalGroup(
            pnlDescuentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDescuentosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlDescuentosLayout.setVerticalGroup(
            pnlDescuentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDescuentosLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel1.setText("Total Haberes");

        jLabel2.setText("Total Imponible");

        jLabel3.setText("Total Tributable");

        jLabel4.setText("Total Descuentos");

        jLabel5.setText("Liquido a Pagar");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAgregarConcepto.setText("Agregar Concepto ");
        btnAgregarConcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarConceptoActionPerformed(evt);
            }
        });

        btnAgregarPersonas.setText("AgregarFuncionario");
        btnAgregarPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPersonasActionPerformed(evt);
            }
        });

        btnLiquidar.setText("Liquidar");
        btnLiquidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLiquidarActionPerformed(evt);
            }
        });

        lblTotalHaberes.setText("lblTotalHaberes");

        lblTotalImponible.setText("lblTotalImponible");

        lblTotalTributable.setText("lblTotalTributable");

        lblTotalDescuentos.setText("lblTotalDescuentos");

        lblLiquidoAPagar.setText("lblLiquidoAPagar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(btnLiquidar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTotalTributable)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTotalImponible)
                                            .addComponent(lblTotalHaberes))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(133, 133, 133)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblTotalDescuentos)
                                                    .addComponent(lblLiquidoAPagar)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel4))
                                                .addGap(140, 140, 140))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlHaberes, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pnlDescuentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregarConcepto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregarPersonas, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(pnlHaberes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlDescuentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addComponent(btnAgregarConcepto)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnAgregarPersonas))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblTotalHaberes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblTotalImponible)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalDescuentos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblLiquidoAPagar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTotalTributable))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLiquidar)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnAgregarPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPersonasActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnAgregarPersonasActionPerformed

    private void btnAgregarConceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarConceptoActionPerformed
        /*jSeleccionConcepto SeleccionConcepto=new jSeleccionConcepto();
        SeleccionConcepto.Load();
        SeleccionConcepto.setVisible(true);*/
        
        if (conFun.RevisaLiquidada()){
            JOptionPane.showMessageDialog(this, "No se pueden ingresar conceptos porque la persona se encuentra liquidada!", "Información!", JOptionPane.INFORMATION_MESSAGE);
        }else{
            new dSeleccionConcepto( this, true).setVisible(true);
            this.CargaPagina();
        }
    }//GEN-LAST:event_btnAgregarConceptoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.CargaPagina();
        
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_formWindowOpened

    private void btnLiquidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLiquidarActionPerformed
        if (conFun.RevisaLiquidada()){
            conFun.Reliquidar();
        }else{
            conFun.CalculaMonto();
        }
        this.CargaPagina();
    }//GEN-LAST:event_btnLiquidarActionPerformed

    private void popMenuHaberesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_popMenuHaberesMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_popMenuHaberesMouseClicked

    private void mnuEliminarHaberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEliminarHaberActionPerformed
        conFun.setCodigo(String.valueOf(tblHaberes.getValueAt(tblHaberes.getSelectedRow(),0)));
        conFun.EliminaConceptoFuncionario();
        this.CargaPagina();
    }//GEN-LAST:event_mnuEliminarHaberActionPerformed

    private void tblHaberesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHaberesMouseClicked
        
    }//GEN-LAST:event_tblHaberesMouseClicked

    private void mnuEliminarDescuentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuEliminarDescuentoMouseClicked

    }//GEN-LAST:event_mnuEliminarDescuentoMouseClicked

    private void mnuEliminarDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEliminarDescuentoActionPerformed
        conFun.setCodigo(String.valueOf(tblDescuentos.getValueAt(tblDescuentos.getSelectedRow(),0)));
        conFun.EliminaConceptoFuncionario();
        this.CargaPagina();
    }//GEN-LAST:event_mnuEliminarDescuentoActionPerformed

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
            java.util.logging.Logger.getLogger(jProcesarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jProcesarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jProcesarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jProcesarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jProcesarFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregarConcepto;
    private javax.swing.JButton btnAgregarPersonas;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLiquidar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblLiquidoAPagar;
    private javax.swing.JLabel lblTotalDescuentos;
    private javax.swing.JLabel lblTotalHaberes;
    private javax.swing.JLabel lblTotalImponible;
    private javax.swing.JLabel lblTotalTributable;
    private javax.swing.JMenuItem mnuEliminarDescuento;
    private javax.swing.JMenuItem mnuEliminarHaber;
    private javax.swing.JPanel pnlDescuentos;
    private javax.swing.JPopupMenu popMenuDescuentos;
    private javax.swing.JPopupMenu popMenuHaberes;
    private javax.swing.JTable tblDescuentos;
    private javax.swing.JTable tblHaberes;
    // End of variables declaration//GEN-END:variables
}
