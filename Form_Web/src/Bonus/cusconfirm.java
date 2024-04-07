/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Bonus;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Tuyet Anh
 */
public class cusconfirm extends javax.swing.JFrame {
    Vector head = new Vector();
    Vector data = new Vector();
    private static String accountid ;
    private static String orderid ;
    private static String type ;
    
    


    public String getaccountid(){
        return orderid;
    }
    public void setaccountid(String id){
        this.orderid = id;
    }

    /**
     * Creates new form orderinformation
     */
    public cusconfirm(String account, String order) {
        this.orderid = order;
        this.accountid = account;
        this.type = type;
        this.setLocationRelativeTo(null);
        initComponents();
        head.add("No");
        head.add("ID");
        head.add("Name");
        head.add("Quantity");
        head.add("UnitPrice");
        head.add("Sum");
        
        
        String connectionUr1 = "jdbc:sqlserver://localhost:1433;databaseName=FinalSourceDatabase;user=sa;password=123456789;encrypt=false";
        try (Connection con = DriverManager.getConnection(connectionUr1);
            Statement stmt = (Statement) con.createStatement();){
            String SQL = "Select C.Accountid, C.CusID, CusName, CusPhone, CusAddress, DeliveryFee, ExpectedDelivery From Order_ as O, Customers as C Where O.CusID = C.CusID AND OrderID = '"+orderid+"'";
            
            ResultSet rs = stmt.executeQuery(SQL);
             StringBuilder results = new StringBuilder();
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();  
            String[] a ;
            while (rs.next()){
                for (int i = 1; i<= numberOfColumns;i++){
                    results.append(rs.getObject(i)).append("\n");
                    System.out.println(results.toString());
                 }  
                
                a = results.toString().split("\n");
                txtcusid.setText(a[0]);
                txtname.setText(a[2]);
                txtphone.setText(a[3]);
                txtaddress.setText(a[4]);
                txtsumfee.setText(a[5]);
            }
            
           
            
            Statement s = (Statement) con.createStatement();
            String sql = "Select SequenceNo, P.Product1ID, Product1Name, O.Quantity, Price, (O.Quantity * Price) as Sum  From OrderDetails as O, Product1 as P Where O.Product1ID = P.Product1ID AND O.OrderID = '"+orderid+"' Group by P.Product1ID, SequenceNo, Product1Name, O.Quantity, Price Order By SequenceNo ASC;";
            
            ResultSet resu = s.executeQuery(sql);
            ResultSetMetaData metaData1 = resu.getMetaData();
            int numberOfColumns1 = metaData1.getColumnCount();  
           
 

            while (resu.next()){
                Vector add = new Vector ();
                for (int i = 1; i<= numberOfColumns1;i++){
                add.add(resu.getObject(i));
                  
                      
                
            }
                data.add(add);
            }
            
            jTable1.setModel(new DefaultTableModel(data, head));

        
            String tong = "A";
            //System.out.println(in);
                Statement s2 = (Statement) con.createStatement();
                String sql2 = "Select Sum(O.Quantity * Price) as Sum From OrderDetails as O, Product1 as P Where O.Product1ID = P.Product1ID AND O.OrderID = '"+orderid+"' Group by OrderID;";
            
                ResultSet res = s2.executeQuery(sql2);
                ResultSetMetaData metaData2 = res.getMetaData();
                int numberOfColumns2 = metaData2.getColumnCount();
                
                while (res.next()){
                
                for (int i = 1; i<= numberOfColumns2;i++){
                    tong = res.getObject(i).toString();
                    
                
            }
                
            }
                txtsum1.setText(tong);
                Double soluong =  Double.valueOf(txtsum1.getText());
		Double fee = Double.valueOf(txtsumfee.getText());
                Double tich = soluong + fee;
		txtsum.setText(String.valueOf(tich));

            
        }
        catch (SQLException e){
            e.printStackTrace();
  //             JOptionPane.showConfirmDialog(this, "Connect?");
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
        txtcusid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtphone = new javax.swing.JTextField();
        txtaddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtsum1 = new javax.swing.JTextField();
        txtsumfee = new javax.swing.JTextField();
        txtsum = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INFORMATION OF CUSTOMER");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 13, 236, -1));

        jLabel2.setText("NAME:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 44, 52, -1));

        jLabel3.setText("ACCOUNT ID:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 44, 81, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("PHONE:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 78, 71, -1));

        jLabel5.setText("ADDRESS: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 78, 65, -1));
        getContentPane().add(txtcusid, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 41, 288, -1));
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(696, 41, 333, -1));
        getContentPane().add(txtphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 75, 288, -1));
        getContentPane().add(txtaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(696, 75, 333, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 102, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("LIST PRODUCT");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 127, 321, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No", "ID", "Name", "Quantity", "Unitprice", "Sum"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 155, 1037, 199));

        jLabel7.setText("Back to list order ");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, 123, 20));

        jLabel8.setText("Sum price of products :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(748, 375, -1, -1));

        jLabel9.setText("Delivery Fee:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 400, 122, -1));

        jLabel10.setText("Sum price of invoice");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 430, -1, -1));

        txtsum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsum1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtsum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 370, 150, -1));
        getContentPane().add(txtsumfee, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 430, 150, -1));
        getContentPane().add(txtsum, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 400, 150, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Confirm ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 470, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtsum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsum1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsum1ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:

   
            giohang g = new giohang(accountid);
        g.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          String connectionUr1 = "jdbc:sqlserver://localhost:1433;databaseName=FinalSourceDatabase;user=sa;password=123456789;encrypt=false";
        try {
            Connection con = DriverManager.getConnection(connectionUr1);
            
                          
                String sql = "UPDATE Order_ SET Status = 'Done' WHERE OrderID = ? ";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1,orderid );
                ps.execute();
                JOptionPane.showMessageDialog(this,"Thanks for your order");
            
            } catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(cusconfirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cusconfirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cusconfirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cusconfirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cusconfirm(accountid,orderid).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtcusid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtsum;
    private javax.swing.JTextField txtsum1;
    private javax.swing.JTextField txtsumfee;
    // End of variables declaration//GEN-END:variables


}
