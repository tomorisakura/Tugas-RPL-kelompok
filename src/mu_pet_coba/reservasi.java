/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mu_pet_coba;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author resky
 */
public class reservasi extends javax.swing.JFrame {
    public static int x,y;
    Connection conn = new koneksi_db().koneksi();
    Statement stat;
    ResultSet res;
    DefaultTableModel tb,tb1,tb2,tb3;
    /**
     * Creates new form reservasi
     */
    public reservasi() {
        initComponents();
        showTable();
        dateX();
        randomNumber();
        txt_idplgn.setEditable(false);
        setLocation(500, 200);
    }
    
    public void showTable() {
        try {
            stat = conn.createStatement();
            tb = new DefaultTableModel();
            tb.addColumn("ID Pelanggan");
            tb.addColumn("Nama");
            tb.addColumn("ID Empus");
            tb.addColumn("Nama Kucing");
            tbl_koceng.setModel(tb);
        
            tbl_koceng.setModel(tb);
            String koceng = "select pemilik.id_pelanggan,pemilik.nama,kucing.id_kucing,kucing.nama_kucing from pemilik,kucing where pemilik.id_pelanggan = kucing.id_pelanggan";
            res = stat.executeQuery(koceng);
            while (res.next()) {                
                tb.addRow(new Object[] {
                    res.getString("id_pelanggan"),
                    res.getString("nama"),
                    res.getString("id_kucing"),
                    res.getString("nama_kucing")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "kucing eroerr " +e.getMessage());
        }
        
        try {
            stat = conn.createStatement();
            tb2 = new DefaultTableModel();
            tb2.addColumn("Kandang Terisi");
            tbl_kandang.setModel(tb2);
            
            tbl_kandang.setModel(tb2);
            String kandang = "select * from kandang_sementara";
            res = stat.executeQuery(kandang);
            while (res.next()) {                
                tb2.addRow(new Object[]{
                res.getString("no_kandang")});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Gagal menampilkan kandang " +e.getMessage());
        }
    }

    public void simpanData() {
        try {
            String sql = "insert into penitipan (id_pelanggan,no_penitipan,tgl_masuk,tgl_keluar,id_karyawan,selisih) values ('"
                    +txt_idplgn.getText()+"','"
                    +txt_nopenitip.getText()+"','"
                    +date_masuk.getDate()+"','"
                    +date_keluar.getDate()+"','"
                    +txt_idkar.getText()+"','"
                    +txt_selisih.getText()+"')";
            stat = conn.createStatement();
            stat.execute(sql);
            JOptionPane.showMessageDialog(rootPane, "berhasil di simpan !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "terjadi kesalahan " +e.getMessage());
        }
    }
    public void simpanKandang() {
        try {
            String sql = "insert into kandang (no_kandang,id_kucing) values ('"+cb_nokandang.getSelectedItem()+"','"
                    +lbl_idkoceng.getText()+"')";
            stat = conn.createStatement();
            stat.execute(sql);

            if(0==(int)cb_nokandang.getSelectedIndex()){
                JOptionPane.showMessageDialog(null, "Naruh Kucingnya Dimanaaaaa  ??? !!");
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "terjadi kesalahan di kandang " +e.getMessage());
        }
    }

    public void simpanKandang2() {
        try {
            String sql = "insert into kandang_sementara (id_kucing,no_kandang) values ('"+lbl_idkoceng.getText()+"','"
                    +cb_nokandang.getSelectedItem()+"')";
            stat = conn.createStatement();
            stat.execute(sql);
            
            if(0==(int)cb_nokandang.getSelectedIndex()){
                JOptionPane.showMessageDialog(null, "Naruh Kucingnya Dimanaaaaa  ??? !!");
            }        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "terjadi kesalahan di kandang sementara " +e.getMessage());
        }
    }    

    public void dateX() {
        try {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            date_masuk.setDateFormatString("dd/MM/yyyy");
            date_keluar.setDateFormatString("dd/MM/yyyy");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "terjadi kesalahan " +e.getMessage());
        }
    }
    public void selisih() {
        try {
            SimpleDateFormat date = new SimpleDateFormat();
            String tgl_masuk = String.valueOf(date.format(date_masuk.getDate()));
            Date tgl_awal = (Date) date.parse(tgl_masuk);
            
            String tgl_keluar = String.valueOf(date.format(date_keluar.getDate()));
            Date tgl_akhir = (Date) date.parse(tgl_keluar);
            long opra = Math.abs(tgl_akhir.getTime() - tgl_awal.getTime());
            txt_selisih.setText("" +TimeUnit.MILLISECONDS.toDays(opra));           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "terjadi kesalahan " +e.getMessage());
        }
    }
    
    public void showKaryawan() {
        try {
            String sql = "select * from karyawan";
            stat = conn.createStatement();
            res = stat.executeQuery(sql);
            while (res.next()) {                
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "terjadi kesalahan " +e.getMessage());
        }
    }
    
    public void randomNumber() {
        try {
            Random rand = new Random();
            int tgl = rand.nextInt(2000) + 1;
            
            String sql = "select max(right(no_penitipan,1)) from penitipan";
            stat = conn.createStatement();
            res = stat.executeQuery(sql);
            while (res.next()) {                
                int a = res.getInt(1);
                txt_nopenitip.setText("0" +(tgl + a));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "terjadi kesalahan pada random " +e.getMessage());
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cb_nokandang = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txt_nopenitip = new javax.swing.JTextField();
        lbl_idkoceng = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_idplgn = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_kandang = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_selisih = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        date_masuk = new com.toedter.calendar.JDateChooser();
        date_keluar = new com.toedter.calendar.JDateChooser();
        mouse_area = new javax.swing.JLabel();
        btn_selesai = new javax.swing.JToggleButton();
        btn_batal = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_koceng = new javax.swing.JTable();
        lbl_idkar = new javax.swing.JLabel();
        txt_idkar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(194, 206, 251));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jLabel3.setText("No. Penitipan");

        jLabel4.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jLabel4.setText("Tgl. Masuk");

        jLabel5.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jLabel5.setText("Tgl. Keluar");

        jLabel6.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jLabel6.setText("No. Kandang");

        cb_nokandang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih No kandang--", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cb_nokandang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_nokandangActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jLabel2.setText("ID Kucing");

        lbl_idkoceng.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        lbl_idkoceng.setText("00000000000");

        jLabel8.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jLabel8.setText("ID Pelanggan");

        tbl_kandang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Kandang Terisi"
            }
        ));
        jScrollPane3.setViewportView(tbl_kandang);

        jLabel9.setText("Kandang ");

        jLabel10.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jLabel10.setText("Selisih");

        jLabel12.setFont(new java.awt.Font("Helvetica", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 255));
        jLabel12.setText("Hitung");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_nopenitip, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(lbl_idkoceng)
                    .addComponent(txt_idplgn)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cb_nokandang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_selisih)
                    .addComponent(date_masuk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(date_keluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_idkoceng))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_idplgn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nopenitip, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_masuk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(9, 9, 9)))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(8, 8, 8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_selisih, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_nokandang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(42, 42, 42))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 114, 460, 590));

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
        jPanel1.add(mouse_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 68));

        btn_selesai.setBackground(new java.awt.Color(153, 204, 255));
        btn_selesai.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        btn_selesai.setForeground(new java.awt.Color(255, 255, 255));
        btn_selesai.setText("Selesai");
        btn_selesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selesaiActionPerformed(evt);
            }
        });
        jPanel1.add(btn_selesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 660, -1, 38));

        btn_batal.setBackground(new java.awt.Color(255, 102, 102));
        btn_batal.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        btn_batal.setForeground(new java.awt.Color(255, 255, 255));
        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });
        jPanel1.add(btn_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 660, 78, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        jLabel7.setText("Tabel Pelanggan");

        tbl_koceng.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_koceng.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_kocengMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_koceng);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 114, -1, 410));

        lbl_idkar.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        lbl_idkar.setText("ID Karyawan");
        jPanel1.add(lbl_idkar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 570, -1, -1));

        txt_idkar.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        txt_idkar.setText("000000000");
        jPanel1.add(txt_idkar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 570, -1, -1));

        jLabel1.setFont(new java.awt.Font("Helvetica", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Reservasi");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        jPanel4.setBackground(new java.awt.Color(98, 147, 245));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1180, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 200));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_selesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selesaiActionPerformed
        // TODO add your handling code here:
        simpanData();
        simpanKandang();
        simpanKandang2();
        randomNumber();
    }//GEN-LAST:event_btn_selesaiActionPerformed

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

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void cb_nokandangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_nokandangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_nokandangActionPerformed

    private void tbl_kocengMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_kocengMouseClicked
        // TODO add your handling code here:
        try {
            int i = tbl_koceng.getSelectedRow();
            String a,b;
        
            a = tb.getValueAt(i, 2).toString();
            b = tb.getValueAt(i, 0).toString();
            lbl_idkoceng.setText(a);
            txt_idplgn.setText(b);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Terjadi Kesalahan" +e.getMessage());
        }        
    }//GEN-LAST:event_tbl_kocengMouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        selisih();
    }//GEN-LAST:event_jLabel12MouseClicked

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
            java.util.logging.Logger.getLogger(reservasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reservasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reservasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reservasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reservasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JToggleButton btn_selesai;
    private javax.swing.JComboBox<String> cb_nokandang;
    private com.toedter.calendar.JDateChooser date_keluar;
    private com.toedter.calendar.JDateChooser date_masuk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_idkar;
    private javax.swing.JLabel lbl_idkoceng;
    private javax.swing.JLabel mouse_area;
    private javax.swing.JTable tbl_kandang;
    private javax.swing.JTable tbl_koceng;
    public javax.swing.JLabel txt_idkar;
    private javax.swing.JTextField txt_idplgn;
    private javax.swing.JTextField txt_nopenitip;
    private javax.swing.JTextField txt_selisih;
    // End of variables declaration//GEN-END:variables
}
