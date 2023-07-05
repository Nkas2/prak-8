/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.praktikum8;
import java.sql.*;
import java.text.Format;
import javax.swing.*;
import javax.swing.table.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author nayandra
 */
public class FormDenganCalender extends javax.swing.JFrame {
    /**
     * deklarasi variabel
     */
    public Connection conn;
    public Statement cn;
    String inputFormat = "MMM dd, yyyy";
    String outputFormat = "yyyy-MM-dd";

    DateFormat inputFormatter = new SimpleDateFormat(inputFormat);
    DateFormat outputFormatter = new SimpleDateFormat(outputFormat);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form FormDenganCalender
     */
    public FormDenganCalender() {
        initComponents();
        /**
         * Menampilkan data pada combobox
         */
        jComboBox1.removeAllItems();
        jComboBox1.addItem("-");
        jComboBox1.addItem("Avanza");
        jComboBox1.addItem("Alphard");
        jComboBox1.addItem("Ferari");
        jComboBox1.addItem("Xenia");
        jComboBox1.addItem("Innova");
        jComboBox1.addItem("Truk");
        tampil();
    } 
    

    
    /**
     * koneksi ke data 
     */
    public void koneksi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/praktikum_8","root", "");
            cn = conn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"koneksi gagal..");
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * bersih
     */
    void bersih() {
        jTextField1.setText("");
        jDateChooser1.setDate(null);
        jTextField2.setText("");
        jComboBox1.setSelectedItem("-");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
    }
    
    /**
     * tampil
     */
    public void tampil() {
        DefaultTableModel tabelnyo = new DefaultTableModel();
        tabelnyo.addColumn("No Pinjam");
        tabelnyo.addColumn("Tanggal Pinjam");
        tabelnyo.addColumn("Nama Peminjam");
        tabelnyo.addColumn("Jenis Mobil");
        tabelnyo.addColumn("Sewa/hari");
        tabelnyo.addColumn("No Polisi");
        tabelnyo.addColumn("Lama Pinjam");
        tabelnyo.addColumn("Total Bayar");
        
        try {
            koneksi();
            String sql = "SELECT * FROM pinjam_mobil";
            ResultSet rs = cn.executeQuery(sql);
            while (rs.next()) {                
                tabelnyo.addRow(new Object[] {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                });
                jTable1.setModel(tabelnyo);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan " + e);
        }
    }
    
    public void cari(){
        var a = new String(jTextField7.getText());
        if(a.equals("")){
            JOptionPane.showConfirmDialog(null, "Field masih kosong..", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
            jTextField7.requestFocus();
        }else{
            var tabelnyo = new DefaultTableModel();
            tabelnyo.addColumn("No Pinjam");
            tabelnyo.addColumn("Tanggal Pinjam");
            tabelnyo.addColumn("Nama Peminjam");
            tabelnyo.addColumn("Jenis Mobil");
            tabelnyo.addColumn("Sewa/hari");
            tabelnyo.addColumn("No Polisi");
            tabelnyo.addColumn("Lama Pinjam");
            tabelnyo.addColumn("Total Bayar");
            
            try{
               koneksi();
               var sql = "SELECT * FROM pinjam_mobil WHERE no_pinjam LIKE '%" +  jTextField7.getText() + "%'";
               ResultSet rs = cn.executeQuery(sql);
               while (rs.next()) {                      
                   tabelnyo.addRow(new Object[] {
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                   });
               }
               jTable1.setModel(tabelnyo);
           }catch(Exception e) {
               JOptionPane.showMessageDialog(null, "Data tidakditemukan..","INFORMASI",JOptionPane.INFORMATION_MESSAGE);
           }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("No Pinjam");

        jLabel2.setText("Tanggal Pinjam");

        jLabel3.setText("Nama Peminjam");

        jLabel4.setText("Jenis Mobil");

        jLabel5.setText("Sewa/Hari");

        jLabel6.setText("No Polisi");

        jLabel7.setText("Lama Pinjam");

        jLabel8.setText("Total Bayar");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Avanza", "Alphard", "Ferari", "Xenia", "Innova", "Truk" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Keluar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setText("Cari No.Pinjam");

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField2)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField4)
                                    .addComponent(jTextField5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
            koneksi();
            Date date = inputFormatter.parse(((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText());
            String formattedDate = outputFormatter.format(date);
            var sql = "update pinjam_mobil set tanggal_pinjam='"+ formattedDate+"',nama_peminjam='"+ jTextField2.getText()+"',jenis_mobil='"+ jComboBox1.getSelectedItem()+"',lama_sewa='"+ jTextField3.getText()+"',no_polisi='"+ jTextField4.getText()+"',lama_pinjam='"+jTextField5.getText()+"',total_bayar='"+ jTextField6.getText()+"' where no_pinjam='"+ jTextField1.getText()+"'";
            cn.executeUpdate(sql);
            conn.close();
            tampil();
            bersih();
            jButton1.setEnabled(true);
            JOptionPane.showMessageDialog(null,"Data Berhasil Di Update");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Proses Update Gagal" + e.getMessage()); 
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{
            koneksi();
            var sql = "delete from pinjam_mobil where no_pinjam ='"+ jTextField1.getText()+"'";
            cn.executeUpdate(sql);
            conn.close();
            tampil();
            bersih();
            JOptionPane.showMessageDialog(null,"Data Berhasil Di Hapus");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Succes To Delete");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        try {
            koneksi();
            String sql = "SELECT * FROM pinjam_mobil WHERE no_pinjam='"+jTextField1.getText()+"'";
            ResultSet rs = cn.executeQuery(sql);
            if(rs.next()) {
                jDateChooser1.setDate(rs.getDate(2));
                jTextField2.setText(rs.getString(3));
                jComboBox1.setSelectedItem(rs.getString(4));
                jTextField3.setText(rs.getString(5));
                jTextField4.setText(rs.getString(6));
                jTextField5.setText(rs.getString(7));
                jTextField6.setText(rs.getString(8));
                jButton1.setEnabled(false);
            }else {
                jButton1.setEnabled(true);
            }
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan " + e);
        }
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            koneksi();
            Date date = inputFormatter.parse(((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText());
            String formattedDate = outputFormatter.format(date);
            String sql =   "insert    into    pinjam_mobil    values('"+    jTextField1.getText()    +"','"    + formattedDate +"','"+  jTextField2.getText()   +"','"+   jComboBox1.getSelectedItem()   +"','"+   jTextField3.getText() +"','"+ jTextField4.getText() +"','"+ jTextField5.getText()+"','"+ jTextField6.getText() +"')";
            cn.executeUpdate(sql);
            conn.close();
            tampil();
            bersih();
            JOptionPane.showMessageDialog(null,"Data berhasil di simpan"); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Proses penyimpanan gagal" + e);   
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int tabel = jTable1.getSelectedRow();
        var a = jTable1.getValueAt(tabel, 0).toString();
        var b = jTable1.getValueAt(tabel, 1).toString();
        var c = jTable1.getValueAt(tabel, 2).toString();
        var d = jTable1.getValueAt(tabel, 3).toString();
        var e = jTable1.getValueAt(tabel, 4).toString();
        var f = jTable1.getValueAt(tabel, 5).toString();
        var g = jTable1.getValueAt(tabel, 6).toString();
        var h = jTable1.getValueAt(tabel, 7).toString();
        
        jTextField1.setText(a);
        try{
            jDateChooser1.setDate(dateFormat.parse(b));
        }catch(Exception er){
            
        }
        jTextField2.setText(c);
        jComboBox1.setSelectedItem(d);
        jTextField3.setText(e);
        jTextField4.setText(f);
        jTextField5.setText(g);
        jTextField6.setText(h);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
        var harga = jTextField3.getText();
        var lama = jTextField5.getText();
        
        var total = Integer.parseInt(harga) * Integer.parseInt(lama);
        
        jTextField6.setText(Integer.toString(total));
    }//GEN-LAST:event_jTextField5ActionPerformed

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
            java.util.logging.Logger.getLogger(FormDenganCalender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDenganCalender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDenganCalender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDenganCalender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDenganCalender().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
