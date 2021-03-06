/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cachitodelivery;

import Excepciones.DataAccessException;
import Ventana_clases.Fondo_menu_cajero;
import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import modelos.CajaDAO;
import modelos.Fecha;
import modelos.Usuario;



/**
 *
 * @author Cusipuma
 */
public class Menu_cajero extends javax.swing.JFrame implements Runnable{

    /**
     * Creates new form Menu_cajero
     */
    
    protected Usuario user = new Usuario();
    Fecha fecha = new Fecha();
    Thread h1;
    
    public Menu_cajero(Usuario user) throws DataAccessException {
        initComponents();
        h1= new Thread(this);
        h1.start();
        setIconImage (new ImageIcon(getClass().getResource("/Ventanas/Icono.png")).getImage());
        Fondo_menu_cajero fondo = new Fondo_menu_cajero(673,260);
        setSize(673,285);
        setResizable(false);
        setVisible(false);
        setLocationRelativeTo(null);
        setTitle("Opciones de cajero");
        setIconImage (new ImageIcon(getClass().getResource("/Ventanas/Icono.png")).getImage());
        
        
        this.user=user;
        
        JL_Usuario_admin.setText("USUARIO:"+" "+user.getApellido()+" "+user.getNombre());
        
        
        this.add(fondo, BorderLayout.CENTER);
        
        comprobarCaja();
    }
    
    public void comprobarCaja() throws DataAccessException{
        CajaDAO caja = new CajaDAO();
        if(caja.primera())
            if(caja.seba()){
                JB_Caja.setIcon(new ImageIcon(getClass().getResource("/Botones/Sebas.png")));
                JB_Caja.setRolloverIcon(new ImageIcon(getClass().getResource("/Botones/Sebas_hover.png")));
            }else{
                JB_Caja.setIcon(new ImageIcon(getClass().getResource("/Botones/Cerrado.png")));
                JB_Caja.setRolloverIcon(new ImageIcon(getClass().getResource("/Botones/Cerrado_hover.png")));
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

        JB_Caja = new javax.swing.JButton();
        JB_Personal = new javax.swing.JButton();
        JB_Clientes = new javax.swing.JButton();
        JB_Pedidos = new javax.swing.JButton();
        JB_Estadisticas = new javax.swing.JButton();
        JB_Zonas = new javax.swing.JButton();
        JB_Comidas = new javax.swing.JButton();
        JB_Cerrar_sesion = new javax.swing.JButton();
        JL_Usuario_admin = new javax.swing.JLabel();
        JL_Fecha_Admin = new javax.swing.JLabel();
        JL_Hora_Admin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JB_Caja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Cerrado.png"))); // NOI18N
        JB_Caja.setBorder(null);
        JB_Caja.setBorderPainted(false);
        JB_Caja.setContentAreaFilled(false);
        JB_Caja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_Caja.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Cerrado_hover.png"))); // NOI18N
        JB_Caja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_CajaActionPerformed(evt);
            }
        });

        JB_Personal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Clientes_M.png"))); // NOI18N
        JB_Personal.setBorder(null);
        JB_Personal.setBorderPainted(false);
        JB_Personal.setContentAreaFilled(false);
        JB_Personal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_Personal.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Clientes_M_hover.png"))); // NOI18N
        JB_Personal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_PersonalActionPerformed(evt);
            }
        });

        JB_Clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Pedidos_M.png"))); // NOI18N
        JB_Clientes.setBorder(null);
        JB_Clientes.setBorderPainted(false);
        JB_Clientes.setContentAreaFilled(false);
        JB_Clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_Clientes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Pedidos_M_hover.png"))); // NOI18N
        JB_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_ClientesActionPerformed(evt);
            }
        });

        JB_Pedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Comidas_M.png"))); // NOI18N
        JB_Pedidos.setBorder(null);
        JB_Pedidos.setBorderPainted(false);
        JB_Pedidos.setContentAreaFilled(false);
        JB_Pedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_Pedidos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Comidas_M_hover.png"))); // NOI18N

        JB_Estadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Cadetes_M.png"))); // NOI18N
        JB_Estadisticas.setBorder(null);
        JB_Estadisticas.setBorderPainted(false);
        JB_Estadisticas.setContentAreaFilled(false);
        JB_Estadisticas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_Estadisticas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Cadetes_M_hover.png"))); // NOI18N

        JB_Zonas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Zonas.png"))); // NOI18N
        JB_Zonas.setBorder(null);
        JB_Zonas.setBorderPainted(false);
        JB_Zonas.setContentAreaFilled(false);
        JB_Zonas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_Zonas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Zonas_hover.png"))); // NOI18N

        JB_Comidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Color_M.png"))); // NOI18N
        JB_Comidas.setBorder(null);
        JB_Comidas.setBorderPainted(false);
        JB_Comidas.setContentAreaFilled(false);
        JB_Comidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_Comidas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Color_M_hover.png"))); // NOI18N

        JB_Cerrar_sesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Salir.png"))); // NOI18N
        JB_Cerrar_sesion.setBorder(null);
        JB_Cerrar_sesion.setBorderPainted(false);
        JB_Cerrar_sesion.setContentAreaFilled(false);
        JB_Cerrar_sesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JB_Cerrar_sesion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Botones/Salir_hover.png"))); // NOI18N
        JB_Cerrar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_Cerrar_sesionActionPerformed(evt);
            }
        });

        JL_Usuario_admin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JL_Usuario_admin.setForeground(new java.awt.Color(255, 255, 255));
        JL_Usuario_admin.setText("USUARIO:");

        JL_Fecha_Admin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JL_Fecha_Admin.setForeground(new java.awt.Color(255, 255, 255));
        JL_Fecha_Admin.setText("FF/FF/FFFF");

        JL_Hora_Admin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JL_Hora_Admin.setForeground(new java.awt.Color(255, 255, 255));
        JL_Hora_Admin.setText("HH:HH");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_Usuario_admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(214, 214, 214))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JB_Personal)
                            .addComponent(JB_Clientes)
                            .addComponent(JB_Pedidos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JB_Caja, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JB_Comidas)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(JB_Estadisticas)
                                .addComponent(JB_Zonas)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JB_Cerrar_sesion)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JL_Fecha_Admin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JL_Hora_Admin)
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(JL_Usuario_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JB_Personal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JB_Clientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JB_Pedidos))
                    .addComponent(JB_Caja)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JB_Estadisticas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JB_Zonas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JB_Comidas))
                    .addComponent(JB_Cerrar_sesion, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Fecha_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_Hora_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_PersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_PersonalActionPerformed
        Orden_cadetes vent = new Orden_cadetes(user);
        vent.mostrar(true);
        this.dispose();
        return;
    }//GEN-LAST:event_JB_PersonalActionPerformed

    private void JB_Cerrar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_Cerrar_sesionActionPerformed
        Principal p;
        try {
            this.h1.stop();
            p = new Principal();
            p.setSize(399,629);
            p.setTitle("Cachito Delivery");
            p.setResizable(false);
            p.setVisible(true);
            this.dispose();
        } catch (DataAccessException ex) {
            Logger.getLogger(Menu_cajero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JB_Cerrar_sesionActionPerformed

    private void JB_CajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_CajaActionPerformed
        try {
            CajaDAO caja = new CajaDAO();
            this.h1.stop();
            if(!caja.primera()){
                Abrir_caja ventana;
                ventana = new Abrir_caja(user);
                setVisible(false);
                ventana.setVisible(true);
            }else{
                if(!caja.seba()){
                    Abrir_caja ventana;
                    ventana = new Abrir_caja(user);
                    setVisible(false);
                    ventana.setVisible(true);
                }else{
                    Cierre_liquidacion ventana;
                    ventana = new Cierre_liquidacion(user);
                    setVisible(false);
                    ventana.setVisible(true);
                }
            }
            
        
        } catch (DataAccessException ex) {
          Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JB_CajaActionPerformed

    private void JB_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ClientesActionPerformed
        setVisible(false);
        this.h1.stop();
        Listado_pedidos_cajero vent = new Listado_pedidos_cajero(user);
        vent.mostrar(true);
    }//GEN-LAST:event_JB_ClientesActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_cajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_cajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_cajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_cajero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Menu_cajero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_Caja;
    private javax.swing.JButton JB_Cerrar_sesion;
    private javax.swing.JButton JB_Clientes;
    private javax.swing.JButton JB_Comidas;
    private javax.swing.JButton JB_Estadisticas;
    private javax.swing.JButton JB_Pedidos;
    private javax.swing.JButton JB_Personal;
    private javax.swing.JButton JB_Zonas;
    private javax.swing.JLabel JL_Fecha_Admin;
    private javax.swing.JLabel JL_Hora_Admin;
    private javax.swing.JLabel JL_Usuario_admin;
    // End of variables declaration//GEN-END:variables
 @Override
    public void run() {
        Fecha f = new Fecha();
        fecha=f;
        Thread ct = Thread.currentThread();
        while(ct==h1){
            JL_Fecha_Admin.setText(fecha.getFecha());
            JL_Hora_Admin.setText(fecha.getHora());
        }
    }
}
