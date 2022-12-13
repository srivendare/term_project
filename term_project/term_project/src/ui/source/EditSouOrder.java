/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.source;

import java.sql.Connection;
import controller.DB_INFO;
import java.awt.HeadlessException;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Category;
import model.Pay;
import controller.TableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;
import model.Order;
import model.Warehouse;

/**
 *
 * @author ruishang
 */
public class EditSouOrder extends javax.swing.JPanel {

    /**
     * Creates new form EditSouPane
     */
    public EditSouOrder() {
        initComponents();
        BindCombo();
        populateCustomerJtable();
        
        jComboBox_CATEGORIES_ActionPerformed(null);
        
        Order ord = new Order();
        
        jTextField_CUSTOMER_ID.setEnabled(false);
        jTextField_ORDER_ID.setEnabled(false);
        
        // display the new order id in textfield
        try{
            jTextField_ORDER_ID.setText(String.valueOf(ord.getMaxOrderId() + 1));
        }catch(Exception ex){
            jTextField_ORDER_ID.setText(String.valueOf(1));
        }
    }
    
    
    // populate the categories combobox
    public void BindCombo(){

        Category category = new Category();

        HashMap<String, Integer> map = category.populateCombo();

        for(String s : map.keySet()){
            jComboBox_CATEGORIES_.addItem(s);
        }
    }
    
    // populate the customers jtable
    public void populateCustomerJtable(){
        
        Warehouse customer = new Warehouse();
        ArrayList<Warehouse> CustomerList = customer.warehouseList();
        
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
    
    // populate the products jtable by selected category from combobox
    public void populateProductJtable(Integer categoryId){
        
        Product prd = new Product();
        ArrayList<Product> ProductList = prd.productsInCategoryList(categoryId);
        
        String[] colNames = {"Id","Name","Price","Quantity","Image","QA Result"};
        Object[][] rows = new Object[ProductList.size()][7];
        
        for(int i = 0; i < ProductList.size(); i++){
            rows[i][0] = ProductList.get(i).getId();
            rows[i][1] = ProductList.get(i).getName();
            rows[i][2] = ProductList.get(i).getPrice();
            rows[i][3] = ProductList.get(i).getQuantity();
            
                        ImageIcon pic = new ImageIcon(new ImageIcon
                                          (ProductList.get(i).getPicture())
                                           .getImage()
                                           .getScaledInstance(120, 80, Image.SCALE_SMOOTH));
            
            rows[i][4] = pic;
            
            rows[i][5] = ProductList.get(i).getDescription();

        }
        
        TableModel mmd = new TableModel(rows, colNames);
        jTable_PRODUCTS_.setModel(mmd);
        jTable_PRODUCTS_.setRowHeight(80);
        jTable_PRODUCTS_.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable_PRODUCTS_.getColumnModel().getColumn(5).setPreferredWidth(120);
        jTable_PRODUCTS_.getColumnModel().getColumn(4).setPreferredWidth(120);
    }
    
    
    
    // get total amount of the product added to the order table
    // and display the value into jlabel
    public void getTotal()
    {
        double total = 0;
        for(int i = 0; i < jTable_PRODUCTS_IN_ORDER_.getModel().getRowCount(); i++)
               {
                   total = total + Double.valueOf(jTable_PRODUCTS_IN_ORDER_.getValueAt(i, 4).toString());
               }
        //jLabel_TOTAL.setText("Total: " + String.valueOf(total));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_CUSTOMERS_ = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField_CUSTOMER_ID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField_ORDER_ID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_PRODUCTS_ = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_PRODUCTS_IN_ORDER_ = new javax.swing.JTable();
        jComboBox_CATEGORIES_ = new javax.swing.JComboBox<>();
        jButton_INSERT_ORDER_ = new javax.swing.JButton();
        jButton_REMOVE_PRODUCT_FROM_ORDER_TABLEè = new javax.swing.JButton();
        jButton_CLEAR_ORDER_TABLE_ = new javax.swing.JButton();
        jButton_TRANSFER_FROM_PRODUCT_TO_ORDER_ = new javax.swing.JButton();
        lblPar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblCate1 = new javax.swing.JLabel();
        lblPar1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Order ID:");

        jTextField_CUSTOMER_ID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_CUSTOMER_ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_CUSTOMER_IDKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Warehouse:");

        jTextField_ORDER_ID.setEditable(false);
        jTextField_ORDER_ID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Order Date:");

        jTable_PRODUCTS_.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable_PRODUCTS_);

        jTable_PRODUCTS_IN_ORDER_.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Price", "Quantity", "Total"
            }
        ));
        jScrollPane3.setViewportView(jTable_PRODUCTS_IN_ORDER_);

        jComboBox_CATEGORIES_.setBackground(new java.awt.Color(111, 78, 55));
        jComboBox_CATEGORIES_.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox_CATEGORIES_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_CATEGORIES_ActionPerformed(evt);
            }
        });

        jButton_INSERT_ORDER_.setBackground(new java.awt.Color(30, 130, 76));
        jButton_INSERT_ORDER_.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_INSERT_ORDER_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_INSERT_ORDER_.setText("Insert Order");
        jButton_INSERT_ORDER_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_INSERT_ORDER_ActionPerformed(evt);
            }
        });

        jButton_REMOVE_PRODUCT_FROM_ORDER_TABLEè.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_REMOVE_PRODUCT_FROM_ORDER_TABLEè.setText("Remove Product");
        jButton_REMOVE_PRODUCT_FROM_ORDER_TABLEè.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_REMOVE_PRODUCT_FROM_ORDER_TABLEèActionPerformed(evt);
            }
        });

        jButton_CLEAR_ORDER_TABLE_.setBackground(new java.awt.Color(220, 53, 53));
        jButton_CLEAR_ORDER_TABLE_.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_CLEAR_ORDER_TABLE_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_CLEAR_ORDER_TABLE_.setText("Clear");
        jButton_CLEAR_ORDER_TABLE_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CLEAR_ORDER_TABLE_ActionPerformed(evt);
            }
        });

        jButton_TRANSFER_FROM_PRODUCT_TO_ORDER_.setText(">");
        jButton_TRANSFER_FROM_PRODUCT_TO_ORDER_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TRANSFER_FROM_PRODUCT_TO_ORDER_ActionPerformed(evt);
            }
        });

        lblPar.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblPar.setForeground(new java.awt.Color(51, 51, 51));
        lblPar.setText("Current Order Info:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Place A Order");

        lblCate1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblCate1.setForeground(new java.awt.Color(51, 51, 51));
        lblCate1.setText("Category:");

        lblPar1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblPar1.setForeground(new java.awt.Color(51, 51, 51));
        lblPar1.setText("Warehouse:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPar1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCate1)
                                .addGap(26, 26, 26)
                                .addComponent(jComboBox_CATEGORIES_, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton_TRANSFER_FROM_PRODUCT_TO_ORDER_, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(116, 116, 116)
                                        .addComponent(jButton_INSERT_ORDER_, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton_CLEAR_ORDER_TABLE_, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextField_CUSTOMER_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField_ORDER_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(151, 151, 151)
                                .addComponent(jButton_REMOVE_PRODUCT_FROM_ORDER_TABLEè, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblPar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(jButton_REMOVE_PRODUCT_FROM_ORDER_TABLEè)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox_CATEGORIES_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCate1))
                    .addComponent(lblPar))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jButton_TRANSFER_FROM_PRODUCT_TO_ORDER_))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_CUSTOMER_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField_ORDER_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_INSERT_ORDER_)
                            .addComponent(jButton_CLEAR_ORDER_TABLE_))
                        .addGap(54, 54, 54))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 972, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_CUSTOMERS_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_CUSTOMERS_MouseClicked

        Integer selectedRowIndex = jTable_CUSTOMERS_.getSelectedRow();
        jTextField_CUSTOMER_ID.setText(jTable_CUSTOMERS_.getValueAt(selectedRowIndex, 0).toString());

    }//GEN-LAST:event_jTable_CUSTOMERS_MouseClicked

    private void jTextField_CUSTOMER_IDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CUSTOMER_IDKeyTyped

        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }

    }//GEN-LAST:event_jTextField_CUSTOMER_IDKeyTyped

    private void jComboBox_CATEGORIES_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_CATEGORIES_ActionPerformed

        Category category = new Category();
        HashMap<String, Integer> map = category.populateCombo();
        populateProductJtable(Integer.valueOf(map.get(jComboBox_CATEGORIES_.getSelectedItem().toString()).toString()));

    }//GEN-LAST:event_jComboBox_CATEGORIES_ActionPerformed

    private void jButton_INSERT_ORDER_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_INSERT_ORDER_ActionPerformed

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String orderDate = "";

        if(jDateChooser1.getDate() != null){
            orderDate = dateFormat.format(jDateChooser1.getDate());

        } else{
            Date date = new Date();
            orderDate = dateFormat.format(date);
        }

        if(jTextField_CUSTOMER_ID.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Select A Warehouse To Store The Order", "No Warehouse Selected", 1);
        }

        else if(jTable_PRODUCTS_IN_ORDER_.getRowCount() > 0)
        {

            Integer productId;
            Integer orderId = Integer.valueOf(jTextField_ORDER_ID.getText());
            Integer qty;
            String price;
            String total;
            String taxTotal;
            
            

            // insert the order
            Order.insertOrder(orderId, orderDate, Integer.valueOf(jTextField_CUSTOMER_ID.getText()));

            // get the product data
            for(int i = 0; i < jTable_PRODUCTS_IN_ORDER_.getRowCount(); i++)
            {
                productId = Integer.valueOf(jTable_PRODUCTS_IN_ORDER_.getValueAt(i, 0).toString());
                price = jTable_PRODUCTS_IN_ORDER_.getValueAt(i, 2).toString();
                qty = Integer.valueOf(jTable_PRODUCTS_IN_ORDER_.getValueAt(i, 3).toString());
                total = jTable_PRODUCTS_IN_ORDER_.getValueAt(i, 4).toString();
                
                // get tax rate
                
                Connection con = DB_INFO.getConnection();
                
                String tax_ratio = null;
                ResultSet rs;
                PreparedStatement ps;
                
                try {
                    ps = con.prepareStatement("SELECT category.tax_rate \n" +
                            "FROM product \n" +
                            "LEFT JOIN category ON product.category_id = category.id\n" +
                            "WHERE product.id = ?");
                    ps.setString(1, productId.toString());
                    rs = ps.executeQuery();
                    while(rs.next()){
                       tax_ratio = rs.getString("category.tax_rate");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(EditSouOrder.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                Integer totax = (int) Math.round(Double.valueOf(jTable_PRODUCTS_IN_ORDER_.getValueAt(i, 4).toString()) * (1+ Double.valueOf(tax_ratio)/100)); //(1+ Double.valueOf(tax_ratio)/100)
                taxTotal = totax.toString();
                
                // insert payment 
                Pay pay = new Pay(orderId+100, orderId, 0, price, tax_ratio, taxTotal,"","","","", "");           
                Pay.insertPay(pay);

                // insert the order details
                Order.insertOrderDetails(productId, orderId, qty, price, total);

                // display the new order id in textfield
                Order ord = new Order();
                jTextField_ORDER_ID.setText(String.valueOf(ord.getMaxOrderId() + 1));
            }

            jComboBox_CATEGORIES_ActionPerformed(null);

        }
        else{

            JOptionPane.showMessageDialog(null, "You Must Add At Least 1 Product To The Order", "No Product Added", 1);

        }
        
        
        

    }//GEN-LAST:event_jButton_INSERT_ORDER_ActionPerformed

    private void jButton_REMOVE_PRODUCT_FROM_ORDER_TABLEèActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_REMOVE_PRODUCT_FROM_ORDER_TABLEèActionPerformed

        try{
            Integer selectedRowIndex = jTable_PRODUCTS_IN_ORDER_.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel)jTable_PRODUCTS_IN_ORDER_.getModel();
            model.removeRow(selectedRowIndex);
            getTotal();
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Select A Product From The Order Table", "No Product Selected", 1);
        }

    }//GEN-LAST:event_jButton_REMOVE_PRODUCT_FROM_ORDER_TABLEèActionPerformed

    private void jButton_CLEAR_ORDER_TABLE_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CLEAR_ORDER_TABLE_ActionPerformed

        DefaultTableModel model = (DefaultTableModel) jTable_PRODUCTS_IN_ORDER_.getModel();
        model.setRowCount(0);
        getTotal();
    }//GEN-LAST:event_jButton_CLEAR_ORDER_TABLE_ActionPerformed

    private void jButton_TRANSFER_FROM_PRODUCT_TO_ORDER_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TRANSFER_FROM_PRODUCT_TO_ORDER_ActionPerformed

        Integer quantity ;
        int rowindex;

        try{

            // get the quantity from InputDialog
            quantity = Integer.valueOf(JOptionPane.showInputDialog("Enter The Quantity You Want","1"));

            rowindex = jTable_PRODUCTS_.getSelectedRow();

            boolean isExist = false;// a variable to check if the product already exist in the table order
            int index = 0;

            Object rowData[] = new Object[5];

            rowData[0] = jTable_PRODUCTS_.getValueAt(rowindex, 0);
            rowData[1] = jTable_PRODUCTS_.getValueAt(rowindex, 1);
            rowData[2] = jTable_PRODUCTS_.getValueAt(rowindex, 2);
            rowData[3] = quantity;

            Double price = Double.valueOf(jTable_PRODUCTS_.getValueAt(rowindex, 2).toString());

            rowData[4] = quantity * price;

            DefaultTableModel model = (DefaultTableModel)jTable_PRODUCTS_IN_ORDER_.getModel();

            // if the quantity you entred is heigher than the one in the jtable products
            if(quantity > Integer.valueOf(jTable_PRODUCTS_.getValueAt(rowindex, 3).toString()))
            {
                JOptionPane.showMessageDialog(null, "Unavailable Quantity","Invalid Value",2);
            }
            // if the quantity you entred is 0
            else if(quantity == 0)
            {
                JOptionPane.showMessageDialog(null, "Quantity Can't Be 0","Invalid Value",2);
            }
            else
            {
                if(jTable_PRODUCTS_IN_ORDER_.getModel().getRowCount() == 0)
                {

                    model.addRow(rowData);
                    getTotal();
                }
                else
                {
                    // check if the product you want to add already exisit in the table ( using the product id )
                    for(int i = 0; i < jTable_PRODUCTS_IN_ORDER_.getModel().getRowCount(); i++)
                    {
                        if(rowData[0] == jTable_PRODUCTS_IN_ORDER_.getValueAt(i, 0))
                        {
                            isExist = true;
                            index = i;
                        }
                    }
                    if(isExist)
                    {
                        // if the product already exisit
                        // claculate the new quantity
                        // new quantity = quantity(the current quantity you entred) + ( the quantity in the jtable order )
                        Integer newQuantity = quantity + Integer.valueOf(jTable_PRODUCTS_IN_ORDER_.getValueAt(index, 3).toString());

                        // if the new quantity is heigher than the one in the jtable products
                        if(newQuantity > Integer.valueOf(jTable_PRODUCTS_.getValueAt(rowindex, 3).toString()))
                        {
                            JOptionPane.showMessageDialog(null, "Unavailable Quantity","Invalid Value",2);
                        }else{
                            jTable_PRODUCTS_IN_ORDER_.setValueAt(newQuantity, index, 3);
                            jTable_PRODUCTS_IN_ORDER_.setValueAt(newQuantity * price, index, 4);
                            getTotal();
                        }
                    }
                    else{
                        model.addRow(rowData);
                        getTotal();
                    }

                }

            }

        }catch(HeadlessException | NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 1);
        }

    }//GEN-LAST:event_jButton_TRANSFER_FROM_PRODUCT_TO_ORDER_ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_CLEAR_ORDER_TABLE_;
    private javax.swing.JButton jButton_INSERT_ORDER_;
    private javax.swing.JButton jButton_REMOVE_PRODUCT_FROM_ORDER_TABLEè;
    private javax.swing.JButton jButton_TRANSFER_FROM_PRODUCT_TO_ORDER_;
    private javax.swing.JComboBox<String> jComboBox_CATEGORIES_;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable_CUSTOMERS_;
    private javax.swing.JTable jTable_PRODUCTS_;
    private javax.swing.JTable jTable_PRODUCTS_IN_ORDER_;
    private javax.swing.JTextField jTextField_CUSTOMER_ID;
    private javax.swing.JTextField jTextField_ORDER_ID;
    private javax.swing.JLabel lblCate1;
    private javax.swing.JLabel lblPar;
    private javax.swing.JLabel lblPar1;
    // End of variables declaration//GEN-END:variables
}
