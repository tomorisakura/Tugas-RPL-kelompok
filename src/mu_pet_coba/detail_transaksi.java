/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mu_pet_coba;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author resky
 */
public class detail_transaksi extends javax.swing.JFrame {
    public static int x,y;
    Connection conn = new koneksi_db().koneksi();
    Statement stat;
    ResultSet res;
    DefaultTableModel tb;
    /**
     * Creates new form detail_transaksi
     */
    public detail_transaksi() {
        initComponents();
        showData();
        setLocation(500, 200);
    }
    
    public void showData() {
        try {
            stat = conn.createStatement();
            tb = new DefaultTableModel();
            tb.addColumn("Tgl. Transaksi");
            tb.addColumn("No. Transaksi");
            tb.addColumn("ID Pelanggan");
            tb.addColumn("ID Kucing");
            tb.addColumn("Total Harga");
            tb.addColumn("ID Karyawan");
            jTable1.setModel(tb);
            
            jTable1.setModel(tb);
            String sql ="select * from pembayaran";
            res = stat.executeQuery(sql);
            while (res.next()) {                
                tb.addRow(new Object[]{
                res.getString("tgl_transaksi"),
                res.getString("no_transaksi"),
                res.getString("id_pelanggan"),
                res.getString("id_kucing"),
                res.getString("total"),
                res.getString("id_karyawan")});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "terjadi  kesalahan " +e.getMessage());
        }
    }
    
    public void xxkyoko() {
        try {
            stat = conn.createStatement();
            tb = new DefaultTableModel();
            tb.addColumn("Tgl. Transaksi");
            tb.addColumn("No. Transaksi");
            tb.addColumn("ID Pelanggan");
            tb.addColumn(conn);
        } catch (Exception e) {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        mouse_area = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_selesai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(194, 206, 251));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 920, 500));

        mouse_area.setBackground(new java.awt.Color(98, 147, 245));
        mouse_area.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mouse_areaMouseDragged(evt);
            }
        });
        mouse_area.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mouse_areaMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Helvetica", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Detail Transaksi");

        javax.swing.GroupLayout mouse_areaLayout = new javax.swing.GroupLayout(mouse_area);
        mouse_area.setLayout(mouse_areaLayout);
        mouse_areaLayout.setHorizontalGroup(
            mouse_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mouse_areaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mouse_areaLayout.setVerticalGroup(
            mouse_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mouse_areaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        jPanel1.add(mouse_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 210));

        btn_selesai.setBackground(new java.awt.Color(255, 102, 102));
        btn_selesai.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        btn_selesai.setForeground(new java.awt.Color(255, 255, 255));
        btn_selesai.setText("Selesai");
        btn_selesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selesaiActionPerformed(evt);
            }
        });
        jPanel1.add(btn_selesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 590, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mouse_areaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouse_areaMousePressed
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_mouse_areaMousePressed

    private void mouse_areaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouse_areaMouseDragged
        // TODO add your handling code here:
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        
        this.setLocation(xx-x, yy-y);
    }//GEN-LAST:event_mouse_areaMouseDragged

    private void btn_selesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selesaiActionPerformed
        // TODO add your handling code here:
        dispose();
        master_men men = new master_men();
        men.setVisible(true);
    }//GEN-LAST:event_btn_selesaiActionPerformed

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
            java.util.logging.Logger.getLogger(detail_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detail_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detail_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detail_transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new detail_transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_selesai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel mouse_area;
    // End of variables declaration//GEN-END:variables
}
