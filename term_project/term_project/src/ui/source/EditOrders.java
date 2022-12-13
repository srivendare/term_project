/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.source;

import com.mysql.jdbc.Blob;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import controller.DB_INFO;
import model.Order;

/**
 *
 * @author ruishang
 */
public class EditOrders extends javax.swing.JPanel {

    /**
     * Creates new form AllOrders
     */
    public EditOrders() {
        initComponents();
        populateOrderJtable();
        
        jTable_ORDERS.setShowGrid(true);
        
        jTable_ORDERS.setGridColor(Color.gray);
        
        jTable_ORDERS.setSelectionBackground(Color.gray);
        
        JTableHeader th = jTable_ORDERS.getTableHeader();

        th.setFont(new Font("Tahoma", Font.PLAIN, 16));
    }
    
    public void populateOrderJtable(){
        
        Order ord = new Order();
        ArrayList<Order> OrderList = ord.ordersList();
        
        String[] colNames = {"Id","Date","Customer"};
        Object[][] rows = new Object[OrderList.size()][3];
        DefaultTableModel model = (DefaultTableModel) jTable_ORDERS.getModel();
        
        for(int i = 0; i < OrderList.size(); i++){
            rows[i][0] = OrderList.get(i).getId();
            rows[i][1] = OrderList.get(i).getOrderDate();
            rows[i][2] = OrderList.get(i).getCustomerId();
        }
        
        model.setDataVector(rows, colNames);

        jTable_ORDERS.setModel(model);
        jTable_ORDERS.setRowHeight(45);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ORDERS = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        panel1 = new java.awt.Panel();
        txtID = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        txtCate = new javax.swing.JLabel();
        txtLog = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        txtLoc = new javax.swing.JLabel();
        txtPrice = new javax.swing.JLabel();
        txtQuan = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        lblDetail = new javax.swing.JLabel();
        imgPro = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jTable_ORDERS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable_ORDERS);

        btnView.setBackground(new java.awt.Color(62, 109, 156));
        btnView.setForeground(new java.awt.Color(255, 255, 255));
        btnView.setText("View Detials");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnDel.setBackground(new java.awt.Color(62, 109, 156));
        btnDel.setForeground(new java.awt.Color(255, 255, 255));
        btnDel.setText("Delete");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(204, 204, 204));

        txtID.setForeground(new java.awt.Color(204, 204, 204));
        txtID.setText("XXXXXX");

        txtName.setForeground(new java.awt.Color(204, 204, 204));
        txtName.setText("jLabel1");

        txtCate.setForeground(new java.awt.Color(204, 204, 204));
        txtCate.setText("jLabel1");

        txtLog.setForeground(new java.awt.Color(204, 204, 204));
        txtLog.setText("jLabel1");

        txtDate.setForeground(new java.awt.Color(204, 204, 204));
        txtDate.setText("jLabel1");

        txtLoc.setForeground(new java.awt.Color(204, 204, 204));
        txtLoc.setText("jLabel1");

        txtPrice.setForeground(new java.awt.Color(204, 204, 204));
        txtPrice.setText("jLabel1");

        txtQuan.setForeground(new java.awt.Color(204, 204, 204));
        txtQuan.setText("jLabel1");

        txtTotal.setForeground(new java.awt.Color(204, 204, 204));
        txtTotal.setText("jLabel1");

        lblDetail.setText("Order Details");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID)
                    .addComponent(txtLoc)
                    .addComponent(txtName)
                    .addComponent(txtPrice)
                    .addComponent(txtTotal))
                .addGap(68, 68, 68)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLog)
                    .addComponent(txtCate)
                    .addComponent(txtQuan)
                    .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(161, 161, 161))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(lblDetail))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(imgPro, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDetail)
                .addGap(12, 12, 12)
                .addComponent(imgPro, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName)
                    .addComponent(txtCate))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLoc)
                    .addComponent(txtLog))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice)
                    .addComponent(txtQuan))
                .addGap(26, 26, 26)
                .addComponent(txtTotal)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Order Info");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnView)
                                .addGap(27, 27, 27)
                                .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, Short.MAX_VALUE))
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnView)
                            .addComponent(btnDel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        // TODO add your handling code here:
        Connection con = DB_INFO.getConnection();
        Integer index = jTable_ORDERS.getSelectedRow();
        String selID = jTable_ORDERS.getValueAt(index, 0).toString();
        System.out.println(selID);
        String delOrd = "DELETE FROM `order_tbl` WHERE `id` =" + selID;
        String delDetail = "DELETE FROM `order_detail` WHERE `order_id` =" + selID;

        Statement st;
        try{
            st = con.createStatement();
            if((st.executeUpdate(delDetail)) == 1 && (st.executeUpdate(delOrd)) == 1 )
            {

                JOptionPane.showMessageDialog(null, "Order " + selID+ " Deleted");
            }else{
                JOptionPane.showMessageDialog(null, "Something Wrong, try again");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        populateOrderJtable();

    }//GEN-LAST:event_btnDelActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        
        Connection connection = DB_INFO.getConnection();
        Integer index = jTable_ORDERS.getSelectedRow();
        String selID = jTable_ORDERS.getValueAt(index, 0).toString();
        String query = "SELECT A.`id`, A.`order_date` AS order_date, C.`name` AS product_name , C.`picture` AS pic, D.`name` AS category, E.company_name AS losgitic, E.location AS location, B.`quantity` AS quantity, B.`price` AS price, B.`total`\n" +
                        "FROM \n" +
                        "`order_tbl` A\n" +
                        "LEFT JOIN `order_detail` B\n" +
                        "ON  A.id = B.order_id\n" +
                        "LEFT JOIN product C\n" +
                        "ON B.product_id = C.id\n" +
                        "LEFT JOIN category D\n" +
                        "ON C.category_id = D.id\n" +
                        "LEFT JOIN customer E\n" +
                        "ON A.customer_id = E.id\n" +
                        "WHERE A.`id` = " + selID;
        ResultSet rs;
        PreparedStatement ps;
        String total = "";
        
        try {
            
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            if(rs.next())
            {   
                txtID.setText(String.valueOf("ID: " + rs.getString("id")));  
                txtID.setForeground(Color.DARK_GRAY);
                txtName.setText(String.valueOf("Product " + rs.getString("product_name")));
                txtName.setForeground(Color.DARK_GRAY);
                txtCate.setText(String.valueOf("Category: " + rs.getString("category")));
                txtCate.setForeground(Color.DARK_GRAY);
                txtLog.setText(String.valueOf("Logsitic: " + rs.getString("losgitic")));
                txtLog.setForeground(Color.DARK_GRAY);
                txtDate.setText(String.valueOf("Date: " + rs.getString("order_date")));
                txtDate.setForeground(Color.DARK_GRAY);
                txtLoc.setText(String.valueOf("Location: " + rs.getString("location")));
                txtLoc.setForeground(Color.DARK_GRAY);
                txtPrice.setText(String.valueOf("Unit Price: " + rs.getString("price")));
                txtPrice.setForeground(Color.DARK_GRAY);
                txtQuan.setText(String.valueOf("Quantity: " +rs.getString("quantity")));
                txtQuan.setForeground(Color.DARK_GRAY);
                txtTotal.setText(String.valueOf("Total" +rs.getString("total")));
                txtTotal.setForeground(Color.DARK_GRAY);
                
                Blob blob = (Blob) rs.getBlob("pic");
                byte[] image1 = blob.getBytes(1L,(int)blob.length());
                ImageIcon image = new ImageIcon(image1);
                Image img = image.getImage();
                Image resizeImg = img.getScaledInstance(120, 100, java.awt.Image.SCALE_SMOOTH);
                image = new ImageIcon(resizeImg);
                imgPro.setIcon(image);
//                Blob blob = rs.getBlob("pic");
//                ImageIcon pic = new ImageIcon(new ImageIcon
//                                          (rs.getString("pic"))
//                                           .getImage()
//                                           .getScaledInstance(30, 20, Image.SCALE_SMOOTH));
                 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
         
        }
        
        
        

        
        
    }//GEN-LAST:event_btnViewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel imgPro;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_ORDERS;
    private javax.swing.JLabel lblDetail;
    private java.awt.Panel panel1;
    private javax.swing.JLabel txtCate;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtID;
    private javax.swing.JLabel txtLoc;
    private javax.swing.JLabel txtLog;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtPrice;
    private javax.swing.JLabel txtQuan;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
