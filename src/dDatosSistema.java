

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sylar
 */
public class dDatosSistema extends javax.swing.JDialog {
public static final String url = "https://www.previred.com/web/previred/indicadores-previsionales";

    public static int getStatusConnectionCode(String url) {

        Response response = null;

        try {
            response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
        }
        return response.statusCode();
    }
    
    	public static Document getHtmlDocument(String url) {

		Document doc = null;

		try {
			doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
		} catch (IOException ex) {
			System.out.println("Excepción al obtener el HTML de la página" + ex.getMessage());
		}

		return doc;

	}
    /**
     * Creates new form dDatosSistema
     */
    public dDatosSistema(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtValorUF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnRefrescar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Valor UF");

        btnRefrescar.setText("Refrescar");
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtValorUF, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(180, Short.MAX_VALUE)
                .addComponent(btnRefrescar)
                .addGap(141, 141, 141))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addComponent(btnRefrescar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        
    try {
        
        if (getStatusConnectionCode(url) == 200) {
			
			// Obtengo el HTML de la web en un objeto Document
			Document document = getHtmlDocument(url);
			
			// Busco todas las historias de meneame que estan dentro de: 
			//Elements entradas = document.select("div.col-md-4.col-xs-12").not("div.col-md-offset-2.col-md-4.col-xs-12");
                        Elements entradas = document.select("journal-content-article");//.not("div.col-md-offset-2.col-md-4.col-xs-12");
			System.out.println("Número de entradas en la página inicial de Jarroba: "+entradas.size()+"\n");
			
			// Paseo cada una de las entradas
			for (Element elem : entradas) {
				String titulo = elem.getElementsByClass("ind_odd").text();
				String autor = elem.getElementsByClass("autor").toString();
				String fecha = elem.getElementsByClass("fecha").text();
				
                                txtValorUF.setText(titulo);
				System.out.println(titulo+"\n"+autor+"\n"+fecha+"\n\n");
				
				// Con el método "text()" obtengo el contenido que hay dentro de las etiquetas HTML
				// Con el método "toString()" obtengo todo el HTML con etiquetas incluidas
			}
				
		}else
			System.out.println("El Status Code no es OK es: "+getStatusConnectionCode(url));
        
        } catch (Exception e) {
            e.printStackTrace();     
        } 
    }//GEN-LAST:event_btnRefrescarActionPerformed

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
            java.util.logging.Logger.getLogger(dDatosSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dDatosSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dDatosSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dDatosSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dDatosSistema dialog = new dDatosSistema(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtValorUF;
    // End of variables declaration//GEN-END:variables
}
