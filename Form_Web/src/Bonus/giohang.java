/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Bonus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tuyet Anh
 */
public class giohang extends javax.swing.JFrame {
    Vector head = new Vector();
    Vector data = new Vector();
    Vector data2 = new Vector();
    Vector data3 = new Vector();
    Vector data4 = new Vector();
    Vector head2 = new Vector();
    ArrayList <String> gio = new ArrayList<String> ();
    private static String accountidd ;
    private static String CusID;
    public String getaccountid(){
        return accountidd;
    }
    public void setaccountid(String id){
        this.accountidd = id;
    }

    /**
     * Creates new form orderlist
     */
    public giohang(String id) {
        this.accountidd = id;
        initComponents();
        setLocationRelativeTo(null);
        
        head.add("ID");
        head.add("Name");
        head.add("Type");
        head.add("Quantity");
        head.add("Material");
        head.add("Price");
        head.add("Condition");
        head2.add("OrderID");
        head2.add("Order_Date");
        String connectionUr1 = "jdbc:sqlserver://localhost:1433;databaseName=FinalSourceDatabase;user=sa;password=123456789;encrypt=false";
        try {
            Connection con = DriverManager.getConnection(connectionUr1);
            Statement stmt = (Statement) con.createStatement();
                String SQL = "Select CusID From Customers where AccountID = '"+accountidd+"'; ";
                ResultSet rs = stmt.executeQuery(SQL);
                StringBuilder results = new StringBuilder();
                ResultSetMetaData metaData = rs.getMetaData();
                int numberOfColumns = metaData.getColumnCount();
                CusID = "A";
                

                while (rs.next()){
                for (int i = 1; i<= numberOfColumns;i++){
                    results.append (rs.getObject(i)).append(",");
                }
                }
                String str = results.toString();
                String [] words = str.split(",");
                CusID = words[0];
                
            String sql1 = "Select P.Product1ID, Product1Name, ProductType, Quantity, Material, Price, Condition From Product1 as P, Search as S Where P.Product1ID = S.Product1ID AND S.CusID ='"+CusID+"'";

            Statement s1 = (Statement) con.createStatement();
            ResultSet r1 = s1.executeQuery(sql1);

            ResultSetMetaData metaData1 = r1.getMetaData();
            int numberOfColumns1 = metaData1.getColumnCount();

            while (r1.next()){
                Vector v = new Vector();
                for (int i = 1; i<= numberOfColumns1;i++){
                    v.add(r1.getObject(i));

                }
                data.add(v);
   
            }     
        jTable1.setModel(new DefaultTableModel(data, head));
            Statement sta = (Statement) con.createStatement();
            String SQL2 = "Select OrderID, Order_Date From Order_ Where Status = 'Waitting'AND CusID ='"+CusID+"'";

            ResultSet re = sta.executeQuery(SQL2);
            ResultSetMetaData metaDataa = re.getMetaData();
            int numberOfColumnss = metaDataa.getColumnCount();
              
            while (re.next()){
                Vector v = new Vector();
                for (int i = 1; i<= numberOfColumnss;i++){
                    v.add(re.getObject(i));

                }
                data2.add(v);
            }
            jTable2.setModel(new DefaultTableModel(data2, head2));
                System.out.println("COnnect");
            Statement stat = (Statement) con.createStatement();
            String SQL3 = "Select OrderID, Order_Date From Order_ Where Status = 'Delivering'AND CusID ='"+CusID+"'";

            ResultSet res = stat.executeQuery(SQL3);

            ResultSetMetaData metaDataaa = res.getMetaData();
            int numberOfColumnsss = metaDataaa.getColumnCount();
            
            while (res.next()){
                Vector v = new Vector();
                for (int i = 1; i<= numberOfColumnsss;i++){
                    v.add(res.getObject(i));

                }
                data3.add(v);
            }
            jTable3.setModel(new DefaultTableModel(data3, head2));
            
            Statement s4 = (Statement) con.createStatement();
            String SQL4 = "Select OrderID, Order_Date From Order_ Where Status = 'Done'AND CusID ='"+CusID+"'";

            ResultSet r4 = stat.executeQuery(SQL4);

            ResultSetMetaData metaData4 = r4.getMetaData();
            int numberOfColumns4 = metaData4.getColumnCount();
            
            while (r4.next()){
                Vector v = new Vector();
                for (int i = 1; i<= numberOfColumns4;i++){
                    v.add(r4.getObject(i));

                }
                data4.add(v);
            }
        
            jTable4.setModel(new DefaultTableModel(data4, head2));
            

    }
        catch (SQLException e){
               JOptionPane.showConfirmDialog(this, "Failed connect");
               e.printStackTrace();
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
        process = new javax.swing.JTabbedPane();
        waitting = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        accept = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        process2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("YOUR CART & ORDER");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 230, 30));

        waitting.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        waitting.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 6, 242, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ProductID", "Name", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        waitting.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 12, 990, 200));

        accept.setText("Accept");
        accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptActionPerformed(evt);
            }
        });
        waitting.add(accept, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 220, -1, 30));
        waitting.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 99, -1, -1));

        jButton2.setText("Buy");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        waitting.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 220, -1, 30));

        jButton1.setText("Order");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        waitting.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 220, -1, 30));

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        waitting.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 80, 30));

        process.addTab("Cart", waitting);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "OrderID", "Order Date"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout process2Layout = new javax.swing.GroupLayout(process2);
        process2.setLayout(process2Layout);
        process2Layout.setHorizontalGroup(
            process2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(process2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
                .addContainerGap())
        );
        process2Layout.setVerticalGroup(
            process2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, process2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        process.addTab("Waitting", process2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "OrderID", "Order Date"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        process.addTab("Delivering", jPanel3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        process.addTab("Done", jPanel1);

        getContentPane().add(process, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 53, 1020, 300));

        jLabel5.setText("Back to dashboard");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 123, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptActionPerformed
//        // TODO add your handling code here:
//        int n = jTable1.getSelectedRow();
//        String a = data.get(n).toString();
//        data.remove(n);
//        a= a.replace("[", "");
//        a= a.replace("]", "");
//        String [] group = a.split(",");
//        String orderid = group[0];
//        
//        String connectionUr1 = "jdbc:sqlserver://localhost:1433;databaseName=FinalSourceDatabase;user=sa;password=123456789;encrypt=false";
//        try {
//            Connection con = DriverManager.getConnection(connectionUr1);
//            if (txttime.getText().length() == 0 ){
//                JOptionPane.showMessageDialog(null,"Please fill expected time for order","Message", JOptionPane.WARNING_MESSAGE);
//                
//            }
//            else {                
//                String sql = "UPDATE Order_ SET Status = 'Delivering' WHERE OrderID = ? ";
//                PreparedStatement ps = con.prepareStatement(sql);
//                ps.setString(1,orderid );
//                ps.execute();
//                 
//                String sql2 = "UPDATE Order_ SET Status = ? WHERE OrderID = ? ";
//                PreparedStatement ps2 = con.prepareStatement(sql);
//                ps2.setString(1,txttime.getText());
//                ps2.setString(2,orderid );
//                ps2.execute();
//                
//                JOptionPane.showMessageDialog(null," This order is already acceptted");
//            
//           
//                jTable1.setModel(new DefaultTableModel(data, head));
//           
//                
//            }
//            
//            
//           
//            
//        
//            
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        
//        
    }//GEN-LAST:event_acceptActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
 
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        Buy_Sell e = new Buy_Sell(accountidd);
        e.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        //AAAAAAAAAAAAAAA
        int n = jTable2.getSelectedRow();
        System.out.println(n);
        String a = data2.get(n).toString();
        a= a.replace("[", "");
        a= a.replace("]", "");
        String [] group = a.split(",");
        String or = group[0];
        orderconfirm o = new orderconfirm(accountidd,or, "Cus");
        o.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        int n = jTable3.getSelectedRow();
        String a = data3.get(n).toString();
        System.out.println(n);
        a= a.replace("[", "");
        a= a.replace("]", "");
        String [] group = a.split(",");
        String or = group[0];
        cusconfirm o = new cusconfirm(accountidd, or);
        o.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(gio.size()==0){
            JOptionPane.showMessageDialog(null,"Please click the product that you want to buy","Message", JOptionPane.WARNING_MESSAGE);
        }
        else{
            cusorder o = new cusorder(accountidd,gio, "Giohang");
            o.setVisible(true);
            this.dispose();
        }

        
       

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        int column = 0;
        int row = jTable1.getSelectedRow();
        String value = jTable1.getModel().getValueAt(row, column).toString();
       gio.add(value);
       System.out.println(gio);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int column = 0;
        int row = jTable1.getSelectedRow();
        String productid = jTable1.getModel().getValueAt(row, column).toString();
        data.remove(row);
        jTable1.setModel(new DefaultTableModel(data, head));
        String connectionUr1 = "jdbc:sqlserver://localhost:1433;databaseName=FinalSourceDatabase;user=sa;password=123456789;encrypt=false";
        try {
            Connection con = DriverManager.getConnection(connectionUr1);
        
            String sql = "DELETE  FROM Search WHERE Product1ID = ? AND CusID = ? ";
            PreparedStatement ps1 = con.prepareStatement(sql);
                ps1.setString(1,productid );
                ps1.setString(2,CusID );
                ps1.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, "Delete Successful");
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(giohang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(giohang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(giohang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(giohang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new giohang(accountidd).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accept;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTabbedPane process;
    private javax.swing.JPanel process2;
    private javax.swing.JPanel waitting;
    // End of variables declaration//GEN-END:variables
}
