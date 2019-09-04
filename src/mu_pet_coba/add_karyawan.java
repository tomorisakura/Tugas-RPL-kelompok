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
import java.util.Random;

/**
 *
 * @author resky
 */
public class add_karyawan extends javax.swing.JFrame {
    int x,y;
    Connection conn = new koneksi_db().koneksi();
    Statement stat;
    ResultSet res;
    DefaultTableModel tb;
    /**
     * Creates new form add_karyawan
     */
    public add_karyawan() {
        initComponents();
        showTable();
        randomNumber();
        setLocation(500, 200);
    }
    public void showTable(){
        try {
            stat = conn.createStatement();
            tb = new DefaultTableModel();
            tb.addColumn("ID Karyawan");
            tb.addColumn("Nama");
            tb.addColumn("NIK");
            tb.addColumn("Alamat");
            tb.addColumn("No. Hp");
            tb.addColumn("Username");
            tb.addColumn("Password");
            tb.addColumn("Status");
            tabel_karyawan.setModel(tb);
            
            String sql = "select * from karyawan";
            stat = conn.createStatement();
            res = stat.executeQuery(sql);
            while (res.next()) {                
                tb.addRow(new Object[]{
                res.getString("id_karyawan"),
                res.getString("nama"),
                res.getString("nik"),
                res.getString("alamat"),
                res.getString("no_telp"),
                res.getString("username"),
                res.getString("password"),
                res.getString("status")});
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Terjadi kesalahan" +e.getMessage());
        }
    }

    public void simpanData() {
        try {
            String sql = "insert into karyawan (id_karyawan,nama,nik,alamat,no_telp,username,password,status) values ('"
                    +txt_idkar.getText()+"','"
                    +txt_nama.getText()+"','"
                    +txt_nik.getText()+"','"
                    +txt_alamat.getText()+"','"
                    +txt_notlp.getText()+"','"
                    +txt_username.getText()+"','"
                    +txt_pass.getText()+"','"
                    +cbb_status.getSelectedItem()+"')";
            stat = conn.createStatement();
            stat.execute(sql);
            showTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "terjadi kesalahan" +e.getMessage());
        }
    }
    
    public void editData() {
        try {
            String sql = "UPDATE karyawan SET " +"nama= '"+ txt_nama.getText()
                                            + "', alamat= '" + txt_alamat.getText()
                                            + "', status= '" + cbb_status.getSelectedItem()
                                            + "', username= '" + txt_username.getText() 
                                            + "', password= '" + txt_pass.getText()
                                            + "', nik = '" +txt_nik.getText()
                                            + "',no_telp = '" +txt_notlp.getText()+"' WHERE id_karyawan= '" +txt_idkar.getText()+ "'" ;
            stat = conn.createStatement();
            stat.execute(sql);
            showTable();
            JOptionPane.showMessageDialog(rootPane, "berhasil Terubah");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "gagal simpan " +e.getMessage());
        }        
    }

    public void hapusData() {
        try {
            String sql = "DELETE FROM karyawan WHERE id_karyawan='"+txt_idkar.getText()+"'";
            stat = conn.createStatement();
            stat.executeUpdate(sql);
            JOptionPane.showMessageDialog(rootPane, "berhasil dihapus");
            showTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "terjadi kesalahan " + e.getMessage());
        }    
    }
    public void randomNumber() {
        try {
            Random rand = new Random();
            int tgl = rand.nextInt(1000) + 1;
            
            String sql = "select max(right(id_karyawan,1)) from karyawan";
            stat = conn.createStatement();
            res = stat.executeQuery(sql);
            while (res.next()) {                
                int a = res.getInt(1);
                txt_idkar.setText("0" +(tgl + a));
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();
        txt_idkar = new javax.swing.JTextField();
        txt_nik = new javax.swing.JTextField();
        txt_alamat = new javax.swing.JTextField();
        txt_notlp = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        txt_pass = new javax.swing.JTextField();
        cbb_status = new javax.swing.JComboBox<>();
        mouse_area = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_karyawan = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        bol_edit = new javax.swing.JLabel();
        bol_hapus = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        btn_simpan = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jLabel2.setText("Nama");

        jLabel3.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jLabel3.setText("ID Karyawan");

        jLabel4.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jLabel4.setText("NIK");

        jLabel5.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jLabel5.setText("Alamat");

        jLabel6.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        jLabel6.setText("No. Telp");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_nama)
                    .addComponent(txt_idkar)
                    .addComponent(txt_nik)
                    .addComponent(txt_alamat)
                    .addComponent(txt_notlp, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_idkar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_nik, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_notlp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 440, 330));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        jLabel7.setText("Username");

        jLabel8.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        jLabel8.setText("Password");

        jLabel9.setFont(new java.awt.Font("Helvetica", 1, 12)); // NOI18N
        jLabel9.setText("Status ");

        cbb_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--sebagai--", "admin", "karyawan" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_username)
                    .addComponent(txt_pass)
                    .addComponent(cbb_status, 0, 175, Short.MAX_VALUE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbb_status, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, 440, 180));

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
        getContentPane().add(mouse_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 60));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tabel_karyawan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel_karyawan);

        jLabel10.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel10.setText("Tabel Karyawan");

        bol_edit.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        bol_edit.setIcon(new javax.swing.ImageIcon("A:\\Nasi Padang\\Projek\\interface_mu_pet\\icon\\edit_he.png")); // NOI18N
        bol_edit.setText("Edit");
        bol_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bol_editMouseClicked(evt);
            }
        });

        bol_hapus.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        bol_hapus.setIcon(new javax.swing.ImageIcon("A:\\Nasi Padang\\Projek\\interface_mu_pet\\icon\\trash.png")); // NOI18N
        bol_hapus.setText("Hapus");
        bol_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bol_hapusMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel10))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bol_hapus)
                        .addGap(43, 43, 43)
                        .addComponent(bol_edit)))
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel10)
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bol_edit)
                    .addComponent(bol_hapus))
                .addGap(42, 42, 42))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 710, 540));

        panel.setBackground(new java.awt.Color(194, 206, 251));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_simpan.setBackground(new java.awt.Color(102, 153, 255));
        btn_simpan.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        btn_simpan.setForeground(new java.awt.Color(255, 255, 255));
        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        panel.add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 740, 100, 30));

        btn_batal.setBackground(new java.awt.Color(255, 102, 102));
        btn_batal.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        btn_batal.setForeground(new java.awt.Color(255, 255, 255));
        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });
        panel.add(btn_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 740, 90, 30));

        jPanel4.setBackground(new java.awt.Color(98, 147, 245));

        jLabel11.setFont(new java.awt.Font("Helvetica", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Tambah Karyawan");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel11)
                .addContainerGap(1239, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel11)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        panel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -14, -1, 220));

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mouse_areaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouse_areaMouseDragged
        // TODO add your handling code here:
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        
        this.setLocation(xx-x, yy-y);
    }//GEN-LAST:event_mouse_areaMouseDragged

    private void mouse_areaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouse_areaMousePressed
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_mouse_areaMousePressed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        dispose();
        menu men = new menu();
        men.setVisible(true);
    }//GEN-LAST:event_btn_batalActionPerformed

    private void bol_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bol_editMouseClicked
        // TODO add your handling code here:
        editData();
    }//GEN-LAST:event_bol_editMouseClicked

    private void bol_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bol_hapusMouseClicked
        // TODO add your handling code here:
        hapusData();
    }//GEN-LAST:event_bol_hapusMouseClicked

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        simpanData();
        randomNumber();
    }//GEN-LAST:event_btn_simpanActionPerformed

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
            java.util.logging.Logger.getLogger(add_karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add_karyawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bol_edit;
    private javax.swing.JLabel bol_hapus;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JComboBox<String> cbb_status;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel mouse_area;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tabel_karyawan;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JTextField txt_idkar;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_nik;
    private javax.swing.JTextField txt_notlp;
    private javax.swing.JTextField txt_pass;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
