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
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tuyet Anh
 */
public class Productsell extends javax.swing.JFrame {
    Vector head = new Vector();
    Vector data = new Vector();
    Vector data2 = new Vector();
    Vector data3 = new Vector();
    Vector data4 = new Vector();
    Vector data5 = new Vector();
    Vector data6 = new Vector();
    Vector head2 = new Vector();
    private static String accountidd ;
    public String getaccountid(){
        return accountidd;
    }
    public void setaccountid(String id){
        this.accountidd = id;
    }

    /**
     * Creates new form orderlist
     */
    public Productsell(String id) {
        this.accountidd = id;
        initComponents();
        setLocationRelativeTo(null);
        
        head.add("ID");
        head.add("NAME");
        head.add("QUANTITY");
        head.add("PRICE-SUGGEST");
        head2.add("ProductI2ID");
            head2.add("ProductI2Name");
            head2.add("Quantity");
            head2.add("Price");
            head2.add("Sum");
        String connectionUr1 = "jdbc:sqlserver://localhost:1433;databaseName=FinalSourceDatabase;user=sa;password=123456789;encrypt=false";
        try (Connection con = DriverManager.getConnection(connectionUr1);
            Statement stmt = (Statement) con.createStatement();){
            
            String SQL = "Select Product2ID, Product2Name, Quantity, PriceSuggest From Product2 as P, Customers as C Where P.CusID = C.CusID AND Status = 'Waitting' AND AccountID = '"+accountidd+"'";
            ResultSet rs = stmt.executeQuery(SQL);
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            
            while (rs.next()){
                Vector v = new Vector();
                for (int i = 1; i<= numberOfColumns;i++){
                    v.add(rs.getObject(i));

                }
                data.add(v);
   
            }
            
            jTable1.setModel(new DefaultTableModel(data, head));
            Statement sta = (Statement) con.createStatement();
            String SQL2 = "Select Product2ID, Product2Name, Quantity, PriceSuggest From Product2 as P, Customers as C Where P.CusID = C.CusID AND Status = 'Discuss'AND AccountID = '"+accountidd+"'";

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
           
            jTable2.setModel(new DefaultTableModel(data2, head));
            
            Statement stat = (Statement) con.createStatement();
            String SQL3 = "Select Product2ID, Product2Name, Quantity, PriceSuggest From Product2 as P, Customers as C Where P.CusID = C.CusID AND Status = 'Buy' AND AccountID = '"+accountidd+"'";
            

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
          
            jTable3.setModel(new DefaultTableModel(data3, head));
            
            Statement s4 = (Statement) con.createStatement();
            String SQL4 = "Select Product2ID, Product2Name, Quantity, PriceSuggest From Product2 as P, Customers as C Where P.CusID = C.CusID AND Status = 'Process'AND AccountID = '"+accountidd+"'";
            

            ResultSet rs4 = s4.executeQuery(SQL4);

            ResultSetMetaData metaData4 = rs4.getMetaData();
            int numberOfColumns4 = metaData4.getColumnCount();
             
            while (rs4.next()){
                Vector v = new Vector();
                for (int i = 1; i<= numberOfColumns4;i++){
                    v.add(rs4.getObject(i));

                }
                data4.add(v);
            }
            
            jTable4.setModel(new DefaultTableModel(data4, head));
             System.out.println("Connect");
            
            Statement s = (Statement) con.createStatement();
            String sql = "Select CusID From Customers where AccountID = '"+accountidd+"';";
            ResultSet r = s.executeQuery(sql);
            StringBuilder results = new StringBuilder();
                ResultSetMetaData metaData1 = r.getMetaData();
                int numberOfColumns1 = metaData1.getColumnCount();
                String CusID = "A";
               while (r.next()){
                for (int i = 1; i<= numberOfColumns1;i++){
                    results.append (r.getObject(i)).append(",");
                }
                String str = results.toString();
                String [] words = str.split(",");
                CusID = words[0];   
            }
            Statement s5 = (Statement) con.createStatement();
            String SQL5 = "Select Date_, P.Product2ID, Product2Name, I.Quantity, PriceSuggest, (I.Quantity * PriceSuggest) as Sum From Product2 as P, Invoice as I WHERE P.Product2ID = I.Product2ID AND Status = 'Done' AND P.CusID = '"+CusID+"';";
            ResultSet rs5 = s5.executeQuery(SQL5);
            
            ResultSetMetaData metaData5 = rs5.getMetaData();
            int numberOfColumns5 = metaData5.getColumnCount();
             
            while (rs5.next()){
                Vector v = new Vector();
                for (int i = 1; i<= numberOfColumns5;i++){
                    v.add(rs5.getObject(i));

                }
                data5.add(v);
            }
            jTable5.setModel(new DefaultTableModel(data5, head2));
             
            Statement s6 = (Statement) con.createStatement();
            String SQL6 = "Select Product2ID, PRoduct2Name, Quantity, PriceSuggest From Product2 as P, Customers as C Where P.CusID = C.CusID AND Status = 'Refuse'AND AccountID = '"+accountidd+"'";
            

            ResultSet rs6 = s6.executeQuery(SQL6);

            ResultSetMetaData metaData6 = rs6.getMetaData();
            int numberOfColumns6 = metaData6.getColumnCount();
             
            while (rs6.next()){
                Vector v = new Vector();
                for (int i = 1; i<= numberOfColumns6;i++){
                    v.add(rs6.getObject(i));

                }
                data6.add(v);
            }
            jTable6.setModel(new DefaultTableModel(data6, head));
            
        }
        
        catch (SQLException e){
            e.printStackTrace();
               //JOptionPane.showMessageDialog(this, "Failed connect");
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
        process2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("MANAGE YOUR WAITING PRODUCT");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 320, -1));

        waitting.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        waitting.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 6, 242, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "QUANTITY", "PRICE-SUGGEST"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        waitting.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -3, 970, 280));

        accept.setText("Accept");
        accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptActionPerformed(evt);
            }
        });
        waitting.add(accept, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 237, -1, -1));
        waitting.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(977, 99, -1, -1));

        process.addTab("Waitting", waitting);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "QUANTITY", "PRICE - SUGGEST"
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE))
        );
        process2Layout.setVerticalGroup(
            process2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, process2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        process.addTab("Discuss", process2);

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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        process.addTab("Buy", jPanel3);

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
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
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

        process.addTab("Process", jPanel1);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        process.addTab("Done", jPanel2);

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable6);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        process.addTab("Refuse", jPanel4);

        getContentPane().add(process, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 980, 262));

        jLabel5.setText("Back to dashboard");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 123, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        Buy_Sell e = new Buy_Sell(accountidd);
        e.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:
        //hhhhh'
        int n = jTable4.getSelectedRow();

        String a = data4.get(n).toString();
        a= a.replace("[", "");
        a= a.replace("]", "");
        String [] group = a.split(",");
        String id = group[0];
        String name = group[1];
        String quantity = group[2];
        String pricesuggest = group[3];

        invoicediscuss o = new invoicediscuss(accountidd,id,name,quantity,pricesuggest, "Processcus");
        o.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        //AAAAAAAAAAAAAAA
        int n = jTable2.getSelectedRow();
        System.out.println(n);
        String a = data2.get(n).toString();
        a= a.replace("[", "");
        a= a.replace("]", "");
        String [] group = a.split(",");
        String id = group[0];
        String name = group[1];
        String quantity = group[2];
        String pricesuggest = group[3];

        invoicediscussofcus o = new invoicediscussofcus(accountidd,id,name,quantity,pricesuggest, "Discuss");
        o.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTable2MouseClicked

    private void acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptActionPerformed

    }//GEN-LAST:event_acceptActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int n = jTable1.getSelectedRow();
        System.out.println(n);
        String a = data.get(n).toString();
        a= a.replace("[", "");
        a= a.replace("]", "");
        String [] group = a.split(",");
        String id = group[0];
        String name = group[1];
        String quantity = group[2];
        String pricesuggest = group[3];

        invoicediscuss o = new invoicediscuss(accountidd,id,name,quantity,pricesuggest, "Waittingcus");
        o.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        int n = jTable3.getSelectedRow();

        String a = data3.get(n).toString();
        a= a.replace("[", "");
        a= a.replace("]", "");
        String [] group = a.split(",");
        String id = group[0];
        String name = group[1];
        String quantity = group[2];
        String pricesuggest = group[3];

        invoicediscuss o = new invoicediscuss(accountidd,id,name,quantity,pricesuggest, "Buycus");
        o.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        // TODO add your handling code here:
        int n = jTable3.getSelectedRow();

        String a = data3.get(n).toString();
        a= a.replace("[", "");
        a= a.replace("]", "");
        String [] group = a.split(",");
        String id = group[0];
        String name = group[1];
        String quantity = group[2];
        String pricesuggest = group[3];

        invoicediscuss o = new invoicediscuss(accountidd,id,name,quantity,pricesuggest, "Donecus");
        o.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTable5MouseClicked

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        // TODO add your handling code here:
        int n = jTable3.getSelectedRow();

        String a = data3.get(n).toString();
        a= a.replace("[", "");
        a= a.replace("]", "");
        String [] group = a.split(",");
        String id = group[0];
        String name = group[1];
        String quantity = group[2];
        String pricesuggest = group[3];

        invoicediscuss o = new invoicediscuss(accountidd,id,name,quantity,pricesuggest, "Refusecus");
        o.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jTable6MouseClicked

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
            java.util.logging.Logger.getLogger(Productsell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productsell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productsell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productsell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Productsell(accountidd).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accept;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTabbedPane process;
    private javax.swing.JPanel process2;
    private javax.swing.JPanel waitting;
    // End of variables declaration//GEN-END:variables
}
