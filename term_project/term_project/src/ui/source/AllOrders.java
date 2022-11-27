/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.source;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.DB_INFO;
import model.SourceOrder;

/**
 *
 * @author ruishang
 */
public class AllOrders extends javax.swing.JPanel {

    /**
     * Creates new form AllOrders
     */
    public AllOrders() {
        initComponents();
        populateOrderJtable();
        
        jTable_ORDERS.setShowGrid(true);
        
        jTable_ORDERS.setGridColor(Color.gray);
        
        jTable_ORDERS.setSelectionBackground(Color.gray);
        
        JTableHeader th = jTable_ORDERS.getTableHeader();

        th.setFont(new Font("Tahoma", Font.PLAIN, 16));
    }
    
    public void populateOrderJtable(){
        
        SourceOrder ord = new SourceOrder();
        ArrayList<SourceOrder> OrderList = ord.ordersList();
        
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

        jTable_ORDERS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable_ORDERS);

        btnView.setText("View Detials");

        btnDel.setText("Delete");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(btnView)
                .addGap(27, 27, 27)
                .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnView)
                    .addComponent(btnDel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnView;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_ORDERS;
    // End of variables declaration//GEN-END:variables
}
