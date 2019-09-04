/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mu_pet_coba;

import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

/**
 *
 * @author resky
 */
public class pembayaran extends javax.swing.JFrame {
    Connection conn = new koneksi_db().koneksi();
    ResultSet res;
    Statement stat;
    DefaultTableModel tb;
    int x,y;
    /**
     * Creates new form pembayaran
     */
    public pembayaran() {
        initComponents();
        setLocation(400, 100);
        showTable();
        randomNumber();
        showDate();
    }
    public void showTable() {
        try {
            stat = conn.createStatement();
            tb = new DefaultTableModel();
            tb.addColumn("ID Pelanggan");
            tb.addColumn("Nama");
            tb.addColumn("No Penitipan");
            tb.addColumn("ID kucing");
            tb.addColumn("Jeda Hari");
            tb_pelanggan.setModel(tb);
        
            tb_pelanggan.setModel(tb);
            String sqljoin = "select pemilik.id_pelanggan,pemilik.nama,penitipan.no_penitipan,penitipan.selisih,kucing.id_kucing from pemilik,penitipan,kucing where "
                    + "pemilik.id_pelanggan = penitipan.id_pelanggan and pemilik.id_pelanggan = kucing.id_pelanggan";
            res = stat.executeQuery(sqljoin);
            while (res.next()) {                
                tb.addRow(new Object[] {
                    res.getString("id_pelanggan"),
                    res.getString("nama"),
                    res.getString("no_penitipan"),
                    res.getString("id_kucing"),
                    res.getString("selisih")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Terjadi Kesalahan !!! " +e.getMessage());
        }        
    }
    public void tableClicked() {
        try {
            int i = tb_pelanggan.getSelectedRow();
            int k;
            String a, b, c, d;
            
            a = tb.getValueAt(i, 0).toString();
            b = tb.getValueAt(i, 2).toString();
            c = tb.getValueAt(i, 3).toString();
            d = tb.getValueAt(i, 4).toString();
            
            txt_idpel.setText(a);
            txt_notitip.setText(b);
            txt_idkoceng.setText(c);
            int x = Integer.parseInt(d);
            k = x * 20000;
            String hasil = Integer.toString(k);
            lbl_total.setText(hasil);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Terjadi Kesalahan" +e.getMessage());
        }    
    }
    
    public void saveData() {
        try {
            String sql = "Insert into pembayaran (tgl_transaksi,id_karyawan,id_pelanggan,no_penitipan,id_kucing,no_transaksi,total) values ('"
                    +lbl_date.getText()+"','"
                    +txt_idkar.getText()+"','"
                    +txt_idpel.getText()+"','"
                    +txt_notitip.getText()+"','"
                    +txt_idkoceng.getText()+"','"
                    +lbl_notransaksi.getText()+"','"
                    +lbl_total.getText()+"')";
            stat = conn.createStatement();
            stat.execute(sql);
            JOptionPane.showMessageDialog(rootPane, "Pembayaran Berhasil ! ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "terjadi kesalahan saat menyimpan " +e.getMessage());
        }
    }
    
    public void bayar() {
        try {
            int a,b,c;
            a = Integer.parseInt(lbl_total.getText());
            b = Integer.parseInt(txt_bayar.getText());
            
            c = b - a ;
            String hasil = Integer.toString(c);
            txt_kembali.setText(hasil);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Terjadi Kesalahan " +e.getMessage());
        }
    }
    
    public void showDate() {
        Date tanggal = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd - MMMM - yyyy");
        lbl_date.setText(format.format(tanggal));
    }
    
    public void randomNumber() {
        try {
            String tgl;
            java.util.Date date = new java.util.Date();
            SimpleDateFormat s = new SimpleDateFormat("ddMMyyyy");
            
            tgl = s.format(date);
            
            String sql = "select max(right(no_transaksi,1)) from pembayaran";
            stat = conn.createStatement();
            res = stat.executeQuery(sql);
            while (res.next()) {                
                int a = res.getInt(1);
                lbl_notransaksi.setText("0"+tgl +Integer.toString(a +4));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "terjadi kesalahan pada random " +e.getMessage());
        }
    }
    
    public void deleteKandang() {
        try {
            String sql = "truncate table kandang_sementara";
            stat = conn.createStatement();
            stat.execute(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Delete kandang bermasalah" +e.getMessage());
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

        jPanel3 = new javax.swing.JPanel();
        txt_bayar = new javax.swing.JTextField();
        txt_kembali = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_selesai = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_notransaksi = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_idkar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_idpel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_notitip = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_idkoceng = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_pelanggan = new javax.swing.JTable();
        mouse_area = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(194, 206, 251));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bayarActionPerformed(evt);
            }
        });
        jPanel3.add(txt_bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 526, 160, 30));
        jPanel3.add(txt_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 526, 160, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Bayar");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 505, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Kembali");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 505, -1, -1));

        btn_selesai.setBackground(new java.awt.Color(255, 102, 102));
        btn_selesai.setForeground(new java.awt.Color(255, 255, 255));
        btn_selesai.setText("Selesai");
        btn_selesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selesaiActionPerformed(evt);
            }
        });
        jPanel3.add(btn_selesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(637, 574, 90, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        jLabel1.setText("No. Transaksi");

        lbl_notransaksi.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        lbl_notransaksi.setText("00000000");

        jLabel2.setText("ID Karyawan");

        jLabel5.setText("ID Pelanggan");

        jLabel6.setText("No.Penitipan");

        jLabel7.setText("ID Kucing");

        jLabel8.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel8.setText("Total");

        lbl_total.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        lbl_total.setText("00000000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(38, 38, 38)
                        .addComponent(lbl_total)
                        .addGap(76, 76, 76))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(37, 37, 37)
                                .addComponent(lbl_notransaksi))
                            .addComponent(txt_idkar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_idpel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_notitip, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_idkoceng, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_notransaksi))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_idkar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_idpel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_notitip, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_idkoceng, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbl_total))
                .addGap(36, 36, 36))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 136, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_pelanggan.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_pelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_pelangganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_pelanggan);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 360, 270));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(486, 136, 430, 360));

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

        jLabel9.setFont(new java.awt.Font("Helvetica", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Pembayaran");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banner/close.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mouse_areaLayout = new javax.swing.GroupLayout(mouse_area);
        mouse_area.setLayout(mouse_areaLayout);
        mouse_areaLayout.setHorizontalGroup(
            mouse_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mouse_areaLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(53, 53, 53))
        );
        mouse_areaLayout.setVerticalGroup(
            mouse_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mouse_areaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(mouse_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addContainerGap(172, Short.MAX_VALUE))
        );

        jPanel3.add(mouse_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 220));

        lbl_date.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        lbl_date.setText("jLabel11");
        jPanel3.add(lbl_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(778, 90, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 650));

        setBounds(0, 0, 968, 643);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_selesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selesaiActionPerformed
        // TODO add your handling code here:
        saveData();
        randomNumber();
        //deleteKandang();
    }//GEN-LAST:event_btn_selesaiActionPerformed

    private void tb_pelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_pelangganMouseClicked
        // TODO add your handling code here:
        tableClicked();
    }//GEN-LAST:event_tb_pelangganMouseClicked

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

    private void txt_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bayarActionPerformed
        // TODO add your handling code here:
        bayar();
    }//GEN-LAST:event_txt_bayarActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

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
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pembayaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_selesai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_notransaksi;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JPanel mouse_area;
    private javax.swing.JTable tb_pelanggan;
    private javax.swing.JTextField txt_bayar;
    public static javax.swing.JTextField txt_idkar;
    private javax.swing.JTextField txt_idkoceng;
    private javax.swing.JTextField txt_idpel;
    private javax.swing.JTextField txt_kembali;
    private javax.swing.JTextField txt_notitip;
    // End of variables declaration//GEN-END:variables
}
