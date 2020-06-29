
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arancha
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_Principal = new javax.swing.JLabel();
        label_Indicacion = new javax.swing.JLabel();
        button_Rojo = new javax.swing.JButton();
        button_Azul = new javax.swing.JButton();
        textField_Elegido = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_Principal.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label_Principal.setForeground(new java.awt.Color(0, 153, 153));
        label_Principal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_Principal.setText("PANTALLA PRINCIPAL");

        label_Indicacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_Indicacion.setText("Pulsa uno de los botones");

        button_Rojo.setBackground(new java.awt.Color(255, 0, 51));
        button_Rojo.setForeground(new java.awt.Color(102, 102, 102));
        button_Rojo.setText("ROJO");
        button_Rojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_RojoActionPerformed(evt);
            }
        });

        button_Azul.setBackground(new java.awt.Color(0, 153, 255));
        button_Azul.setForeground(new java.awt.Color(102, 102, 102));
        button_Azul.setText("AZUL");
        button_Azul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_AzulActionPerformed(evt);
            }
        });

        textField_Elegido.setBackground(new java.awt.Color(255, 255, 204));
        textField_Elegido.setForeground(new java.awt.Color(0, 0, 0));
        textField_Elegido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textField_Elegido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_ElegidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_Indicacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label_Principal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(textField_Elegido, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(button_Rojo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_Azul)
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(label_Principal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_Indicacion)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_Rojo)
                    .addComponent(button_Azul))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(textField_Elegido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textField_ElegidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_ElegidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_ElegidoActionPerformed

    private void button_RojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_RojoActionPerformed
        textField_Elegido.setBackground(Color.red);
        textField_Elegido.setText("Has pulsado ROJO");
        textField_Elegido.setForeground(Color.white);
    }//GEN-LAST:event_button_RojoActionPerformed

    private void button_AzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_AzulActionPerformed
        textField_Elegido.setBackground(Color.blue);
        textField_Elegido.setText("Has pulsado AZUL");
        textField_Elegido.setForeground(Color.white);
    }//GEN-LAST:event_button_AzulActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Azul;
    private javax.swing.JButton button_Rojo;
    private javax.swing.JLabel label_Indicacion;
    private javax.swing.JLabel label_Principal;
    private javax.swing.JTextField textField_Elegido;
    // End of variables declaration//GEN-END:variables
}
