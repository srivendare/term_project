/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.source;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Agency;
import model.SourceOrder;

/**
 *
 * @author ruishang
 */
public class EditSpPane extends javax.swing.JPanel {

    /**
     * Creates new form EditSpPane
     */
    public EditSpPane() {
        
        initComponents();
        populateJtable();
    }
    
        // function to populate the jtable with customers data
    public void populateJtable(){
        
        Agency customer = new Agency();
        ArrayList<Agency> CustomerList = customer.customersList();
        
        String[] colNames = {"Id","Name","Location","Tel","Email"};
        Object[][] rows = new Object[CustomerList.size()][5];
        DefaultTableModel model = (DefaultTableModel) jTable_CUSTOMERS_.getModel();
        
        for(int i = 0; i < CustomerList.size(); i++){
            rows[i][0] = CustomerList.get(i).getId();
            rows[i][1] = CustomerList.get(i).getcompany_name();
            rows[i][2] = CustomerList.get(i).getlocation();
            rows[i][3] = CustomerList.get(i).getTel();
            rows[i][4] = CustomerList.get(i).getEmail();
        }
        
        model.setDataVector(rows, colNames);

        jTable_CUSTOMERS_.setModel(model);
        jTable_CUSTOMERS_.setRowHeight(45);
    }
    
    // function to check empty fields
    public boolean verifFields()
    {
        if(jTextField_FNAME.getText().equals("") || jTextField_LNAME.getText().equals("") || jTextField_TEL.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty", "Empty Fields", 0);
            return false;
        }else{
            return true;
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
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_EMAIL = new javax.swing.JTextField();
        jTextField_TEL = new javax.swing.JTextField();
        jTextField_LNAME = new javax.swing.JTextField();
        jTextField_FNAME = new javax.swing.JTextField();
        jTextField_ID = new javax.swing.JTextField();
        jButton_CLEAR_ = new javax.swing.JButton();
        jButton_INSERT_ = new javax.swing.JButton();
        jButton_UPDATE_ = new javax.swing.JButton();
        jButton_DELETE_ = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_CUSTOMERS_ = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("ID:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Location:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Tel:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Email:");

        jTextField_EMAIL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField_TEL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField_LNAME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField_FNAME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField_ID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton_CLEAR_.setBackground(new java.awt.Color(34, 49, 63));
        jButton_CLEAR_.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton_CLEAR_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_CLEAR_.setText("clear");
        jButton_CLEAR_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CLEAR_ActionPerformed(evt);
            }
        });

        jButton_INSERT_.setBackground(new java.awt.Color(30, 130, 76));
        jButton_INSERT_.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton_INSERT_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_INSERT_.setText("Insert");
        jButton_INSERT_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_INSERT_ActionPerformed(evt);
            }
        });

        jButton_UPDATE_.setBackground(new java.awt.Color(34, 49, 63));
        jButton_UPDATE_.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton_UPDATE_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_UPDATE_.setText("Edit");
        jButton_UPDATE_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UPDATE_ActionPerformed(evt);
            }
        });

        jButton_DELETE_.setBackground(new java.awt.Color(246, 36, 89));
        jButton_DELETE_.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton_DELETE_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_DELETE_.setText("Remove");
        jButton_DELETE_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DELETE_ActionPerformed(evt);
            }
        });

        jTable_CUSTOMERS_.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_CUSTOMERS_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_CUSTOMERS_MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_CUSTOMERS_);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Edit Warehouse Info");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField_FNAME)
                                    .addComponent(jTextField_ID)
                                    .addComponent(jTextField_LNAME)
                                    .addComponent(jTextField_TEL)
                                    .addComponent(jTextField_EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton_CLEAR_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_UPDATE_, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(jButton_INSERT_, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jButton_DELETE_, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel2)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField_FNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField_LNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField_TEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField_EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_CLEAR_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_UPDATE_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_DELETE_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_INSERT_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_CLEAR_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CLEAR_ActionPerformed

        // textfields
        jTextField_ID.setText("");
        jTextField_FNAME.setText("");
        jTextField_LNAME.setText("");
        jTextField_EMAIL.setText("");
        jTextField_TEL.setText("");

        // labels
//        jLabel_ORDERS_COUNT.setText("###");
//        jLabel_TOTAL_AMOUNT.setText("###");
//        jLabel_LAST_ORDER_DATE.setText("###");
    }//GEN-LAST:event_jButton_CLEAR_ActionPerformed

    private void jButton_INSERT_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_INSERT_ActionPerformed

        if(verifFields())
        {
            String fname = jTextField_FNAME.getText();
            String lname = jTextField_LNAME.getText();
            String tel = jTextField_TEL.getText();
            String email = jTextField_EMAIL.getText();

            Agency customer = new Agency(null, fname, lname, tel, email);
            Agency.insertCustomer(customer);
            populateJtable();
        }
    }//GEN-LAST:event_jButton_INSERT_ActionPerformed

    private void jButton_UPDATE_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UPDATE_ActionPerformed

        try{
            if(verifFields())
            {
                String fname = jTextField_FNAME.getText();
                String lname = jTextField_LNAME.getText();
                String tel = jTextField_TEL.getText();
                String email = jTextField_EMAIL.getText();
                Integer id = Integer.valueOf(jTextField_ID.getText());

                Agency customer = new Agency(id, fname, lname, tel, email);
                Agency.updateCustomer(customer);
                populateJtable();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Select an Agency Before Editing", "No Customer Selected", 1);
        }

    }//GEN-LAST:event_jButton_UPDATE_ActionPerformed

    private void jButton_DELETE_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DELETE_ActionPerformed

        try{
            Integer id = Integer.valueOf(jTextField_ID.getText());
            Agency.deleteCustomer(id);
            populateJtable();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Select an Agency Before Removing", "No Customer Selected", 1);
        }

    }//GEN-LAST:event_jButton_DELETE_ActionPerformed

    private void jTable_CUSTOMERS_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_CUSTOMERS_MouseClicked

        try{

            Integer rowIndex = jTable_CUSTOMERS_.getSelectedRow();
            jTextField_ID.setText(jTable_CUSTOMERS_.getValueAt(rowIndex, 0).toString());
            jTextField_FNAME.setText(jTable_CUSTOMERS_.getValueAt(rowIndex, 1).toString());
            jTextField_LNAME.setText(jTable_CUSTOMERS_.getValueAt(rowIndex, 2).toString());
            jTextField_TEL.setText(jTable_CUSTOMERS_.getValueAt(rowIndex, 3).toString());
            jTextField_EMAIL.setText(jTable_CUSTOMERS_.getValueAt(rowIndex, 4).toString());

//            SourceOrder order = new SourceOrder();
//            jLabel_ORDERS_COUNT.setText(order.getCustomerOrdersCount(Integer.valueOf(jTable_CUSTOMERS_.getValueAt(rowIndex, 0).toString())));
//            jLabel_TOTAL_AMOUNT.setText(order.getCustomerOrdersTotalAmount(Integer.valueOf(jTable_CUSTOMERS_.getValueAt(rowIndex, 0).toString())));
//            jLabel_LAST_ORDER_DATE.setText(order.getCustomerLastOrderDate(Integer.valueOf(jTable_CUSTOMERS_.getValueAt(rowIndex, 0).toString())));

        }catch(Exception ex){

        }

    }//GEN-LAST:event_jTable_CUSTOMERS_MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_CLEAR_;
    private javax.swing.JButton jButton_DELETE_;
    private javax.swing.JButton jButton_INSERT_;
    private javax.swing.JButton jButton_UPDATE_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_CUSTOMERS_;
    private javax.swing.JTextField jTextField_EMAIL;
    private javax.swing.JTextField jTextField_FNAME;
    private javax.swing.JTextField jTextField_ID;
    private javax.swing.JTextField jTextField_LNAME;
    private javax.swing.JTextField jTextField_TEL;
    // End of variables declaration//GEN-END:variables
}
