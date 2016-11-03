/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Sylar
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        mnuSistema = new javax.swing.JMenu();
        mnuSalir = new javax.swing.JMenuItem();
        mnuFuncionario = new javax.swing.JMenu();
        mnuFicha = new javax.swing.JMenuItem();
        mnuPeriodo = new javax.swing.JMenu();
        mnuProcesar = new javax.swing.JMenuItem();
        mnuMantencion = new javax.swing.JMenu();
        mnuDatosSistema = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SisRemu");
        setName("Principal"); // NOI18N

        mnuSistema.setText("Sistema");

        mnuSalir.setText("Salir");
        mnuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSalirMouseClicked(evt);
            }
        });
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        mnuSistema.add(mnuSalir);

        jMenuBar2.add(mnuSistema);

        mnuFuncionario.setText("Funcionario");

        mnuFicha.setText("Ficha");
        mnuFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFichaActionPerformed(evt);
            }
        });
        mnuFuncionario.add(mnuFicha);

        jMenuBar2.add(mnuFuncionario);

        mnuPeriodo.setText("Periodo");

        mnuProcesar.setText("Procesar");
        mnuProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProcesarActionPerformed(evt);
            }
        });
        mnuPeriodo.add(mnuProcesar);

        jMenuBar2.add(mnuPeriodo);

        mnuMantencion.setText("Mantencion");

        mnuDatosSistema.setText("Datos Sistema");
        mnuDatosSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDatosSistemaActionPerformed(evt);
            }
        });
        mnuMantencion.add(mnuDatosSistema);

        jMenuBar2.add(mnuMantencion);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("Principal");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        
          System.exit(0);
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSalirMouseClicked
        // TODO add your handling code here:
     
    }//GEN-LAST:event_mnuSalirMouseClicked

    private void mnuFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFichaActionPerformed
        jListadoFuncionarios ListadoFuncionarios=new jListadoFuncionarios();
        ListadoFuncionarios.setVisible(true);
    }//GEN-LAST:event_mnuFichaActionPerformed

    private void mnuProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProcesarActionPerformed
        jProcesarFuncionario ProcesarFuncionario=new jProcesarFuncionario();
        //ListadoFuncionarios.Load();
        ProcesarFuncionario.setVisible(true);
        //ProcesarFuncionario.CargaPagina();
    }//GEN-LAST:event_mnuProcesarActionPerformed

    private void mnuDatosSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDatosSistemaActionPerformed
            new dDatosSistema( this, true).setVisible(true);
            //this.CargaPagina();
    }//GEN-LAST:event_mnuDatosSistemaActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem mnuDatosSistema;
    private javax.swing.JMenuItem mnuFicha;
    private javax.swing.JMenu mnuFuncionario;
    private javax.swing.JMenu mnuMantencion;
    private javax.swing.JMenu mnuPeriodo;
    private javax.swing.JMenuItem mnuProcesar;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JMenu mnuSistema;
    // End of variables declaration//GEN-END:variables
}
