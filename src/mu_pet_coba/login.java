/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mu_pet_coba;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author resky
 */
public class login extends javax.swing.JFrame {
    public static int x,y;
    Connection conn = new koneksi_db().koneksi();
    reservasi resv = new reservasi();
    regs_menu menu2 = new regs_menu();
    Statement stat;
    ResultSet res;

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
        jPasswordField1.setEchoChar('\u25CF');
        setLocation(400, 100);
    }
    public void loginmen() {
        try {
            String sqlsearch = "select * from karyawan where username='" +jTextField1.getText()+ "'";
            stat = conn.createStatement();
            res = stat.executeQuery(sqlsearch);
            
            if (res.next()) {
                if (jPasswordField1.getText().equals(res.getString("password"))) {
                    String akses = res.getString("status");
                    String id_kar = res.getString("id_karyawan");
                    if (akses.equals("admin")) {
                        JOptionPane.showMessageDialog(null, "Login Sebagai Admin");
                        menu dash = new menu();
                        dash.setVisible(true);
                        dash.lbl_stst.setText(akses);
                        dash.lbl_id.setText(id_kar);
                        resv.txt_idkar.setText(id_kar);
                        this.hide();
                    } else if (akses.equals("karyawan")){
                        JOptionPane.showMessageDialog(null, "Login Sebagai Karyawan");
                        menu2.setVisible(true);
                        menu2.lbl_status.setText(akses);
                        menu2.label_apaan.setText(id_kar);
                        resv.txt_idkar.setText(id_kar);
                        this.hide();
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "username atau password tidak sesuai !");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Ada yang salah ! ");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        btn_login = new javax.swing.JButton();
        btn_close = new javax.swing.JLabel();
        btn_mini = new javax.swing.JLabel();
        mouse_space = new javax.swing.JLabel();
        cek_bok = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Helvetica", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(60, 60, 60));
        jLabel3.setText("made with love 💕");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 700, -1, -1));

        jTextField1.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jTextField1.setAlignmentX(1.0F);
        jTextField1.setAlignmentY(1.0F);
        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "USERNAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica", 3, 12))); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 210, 40));

        jPasswordField1.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jPasswordField1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "PASSWORD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica", 3, 12))); // NOI18N
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 210, 40));

        btn_login.setBackground(new java.awt.Color(102, 102, 255));
        btn_login.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setText("Log In !");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        getContentPane().add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 620, -1, 30));

        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banner/close.png"))); // NOI18N
        btn_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_closeMouseClicked(evt);
            }
        });
        getContentPane().add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, -1, -1));

        btn_mini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banner/minimize.png"))); // NOI18N
        btn_mini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_miniMouseClicked(evt);
            }
        });
        getContentPane().add(btn_mini, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, -1, -1));

        mouse_space.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mouse_spaceMouseDragged(evt);
            }
        });
        mouse_space.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mouse_spaceMousePressed(evt);
            }
        });
        getContentPane().add(mouse_space, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 910, 60));

        cek_bok.setBackground(new java.awt.Color(255, 255, 255));
        cek_bok.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        cek_bok.setText("Lihat Password");
        cek_bok.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        cek_bok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cek_bokActionPerformed(evt);
            }
        });
        getContentPane().add(cek_bok, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 530, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 900, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banner/login2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 900, 760));

        setBounds(0, 0, 900, 734);
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // TODO add your handling code here:
        loginmen();
    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_closeMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btn_closeMouseClicked

    private void mouse_spaceMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouse_spaceMouseDragged
        // TODO add your handling code here:
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        
        this.setLocation( xx-x, yy-y);
    }//GEN-LAST:event_mouse_spaceMouseDragged

    private void mouse_spaceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouse_spaceMousePressed
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_mouse_spaceMousePressed

    private void cek_bokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cek_bokActionPerformed
        // TODO add your handling code here:
        if (cek_bok.isSelected()) {
            jPasswordField1.setEchoChar((char)0);
        } else {
            jPasswordField1.setEchoChar('\u25CF');
        }
    }//GEN-LAST:event_cek_bokActionPerformed

    private void btn_miniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_miniMouseClicked
        // TODO add your handling code here:
        this.setState(login.ICONIFIED);
    }//GEN-LAST:event_btn_miniMouseClicked

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_close;
    private javax.swing.JButton btn_login;
    private javax.swing.JLabel btn_mini;
    private javax.swing.JCheckBox cek_bok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel mouse_space;
    // End of variables declaration//GEN-END:variables
}
