/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.source;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.Category;
import model.TableModel;
import model.Product;

/**
 *
 * @author ruishang
 */
public class EditCate extends javax.swing.JPanel {

    /**
     * Creates new form EditCate
     */
    Integer position = 0;
    Category category = new Category();
    public EditCate() {
        initComponents();
        populateJtable();
        
        try{
            navigation(position);
            jTable_CATEGORIES_MouseClicked(null);
        }catch(Exception ex){
            
        }
            
        
        
        jTable_CATEGORIES_.setShowGrid(true);
        
        jTable_CATEGORIES_.setGridColor(Color.gray);
        
        jTable_CATEGORIES_.setSelectionBackground(Color.gray);
        
        JTableHeader th = jTable_CATEGORIES_.getTableHeader();

        th.setFont(new Font("Tahoma", Font.PLAIN, 12));
    }
    
        // populate the jtable with categories 'id' & 'name' from database
    public void populateJtable(){
        
        ArrayList<Category> CategoryList = category.categoriesList();
        
        String[] colNames = {"Id","Name"};
        Object[][] rows = new Object[CategoryList.size()][2];
        DefaultTableModel model = (DefaultTableModel) jTable_CATEGORIES_.getModel();
        
        for(int i = 0; i < CategoryList.size(); i++){
            rows[i][0] = CategoryList.get(i).getId();
            rows[i][1] = CategoryList.get(i).getName();
        }
        
        model.setDataVector(rows, colNames);

        jTable_CATEGORIES_.setModel(model);
        jTable_CATEGORIES_.setRowHeight(45);
    }
    
    
        // populate list with products in the selected category
    public void populateProductsList(Integer categoryId){
        
        Product prd = new Product();

        ArrayList<Product> ProductList = prd.productsInCategoryList(categoryId);
          DefaultListModel model = new DefaultListModel(); 
        
        for(int i = 0; i < ProductList.size(); i++){
            
          model.addElement(ProductList.get(i).getName());

        }
        jList_PRODUCTS_IN_CATEGORY.setModel(model);

    }
    
    
    
    
    // create a navigation function    
    public void navigation(int pos)
    {

        try{
                ArrayList<Category> CategoryList = category.categoriesList();
                jTextField_CATEGORY_ID.setText(CategoryList.get(pos).getId().toString());
                jTextField_CATEGORY_NAME.setText(CategoryList.get(pos).getName());
                jTable_CATEGORIES_.setRowSelectionInterval(pos,pos);
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error" , 2);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_CATEGORIES_ = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList_PRODUCTS_IN_CATEGORY = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jTextField_CATEGORY_ID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField_CATEGORY_NAME = new javax.swing.JTextField();
        jButton_INSERT_CATEGORY_ = new javax.swing.JButton();
        jButton_UPDATE_CATEGORY_ = new javax.swing.JButton();
        jButton_DELETE_CATEGORY_ = new javax.swing.JButton();
        jButton_NEXT_ = new javax.swing.JButton();
        jButton_PREVIOUS_ = new javax.swing.JButton();
        jButton_SHOW_PRODUCTS_IN_CATEGORY = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable_CATEGORIES_.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_CATEGORIES_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_CATEGORIES_MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_CATEGORIES_);

        jScrollPane2.setViewportView(jList_PRODUCTS_IN_CATEGORY);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("ID:");

        jTextField_CATEGORY_ID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_CATEGORY_ID.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Name:");

        jTextField_CATEGORY_NAME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton_INSERT_CATEGORY_.setBackground(new java.awt.Color(30, 130, 76));
        jButton_INSERT_CATEGORY_.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_INSERT_CATEGORY_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_INSERT_CATEGORY_.setText("Insert New Category");
        jButton_INSERT_CATEGORY_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_INSERT_CATEGORY_ActionPerformed(evt);
            }
        });

        jButton_UPDATE_CATEGORY_.setBackground(new java.awt.Color(65, 131, 215));
        jButton_UPDATE_CATEGORY_.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_UPDATE_CATEGORY_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_UPDATE_CATEGORY_.setText("Update Selected Category");
        jButton_UPDATE_CATEGORY_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UPDATE_CATEGORY_ActionPerformed(evt);
            }
        });

        jButton_DELETE_CATEGORY_.setBackground(new java.awt.Color(246, 36, 89));
        jButton_DELETE_CATEGORY_.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_DELETE_CATEGORY_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_DELETE_CATEGORY_.setText("Delete Selected Category");
        jButton_DELETE_CATEGORY_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DELETE_CATEGORY_ActionPerformed(evt);
            }
        });

        jButton_NEXT_.setBackground(new java.awt.Color(34, 49, 63));
        jButton_NEXT_.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_NEXT_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_NEXT_.setText("Next");
        jButton_NEXT_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NEXT_ActionPerformed(evt);
            }
        });

        jButton_PREVIOUS_.setBackground(new java.awt.Color(34, 49, 63));
        jButton_PREVIOUS_.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_PREVIOUS_.setForeground(new java.awt.Color(255, 255, 255));
        jButton_PREVIOUS_.setText("Previous");
        jButton_PREVIOUS_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PREVIOUS_ActionPerformed(evt);
            }
        });

        jButton_SHOW_PRODUCTS_IN_CATEGORY.setBackground(new java.awt.Color(62, 109, 156));
        jButton_SHOW_PRODUCTS_IN_CATEGORY.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_SHOW_PRODUCTS_IN_CATEGORY.setForeground(new java.awt.Color(255, 255, 255));
        jButton_SHOW_PRODUCTS_IN_CATEGORY.setText("All products in the category");
        jButton_SHOW_PRODUCTS_IN_CATEGORY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SHOW_PRODUCTS_IN_CATEGORYActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("< Products In The Selected Category >");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Category Info");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField_CATEGORY_ID)
                                    .addComponent(jTextField_CATEGORY_NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton_NEXT_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37)
                                    .addComponent(jButton_PREVIOUS_, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton_DELETE_CATEGORY_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_UPDATE_CATEGORY_, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton_INSERT_CATEGORY_, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jButton_SHOW_PRODUCTS_IN_CATEGORY, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jLabel5))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(196, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField_CATEGORY_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField_CATEGORY_NAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_NEXT_)
                            .addComponent(jButton_PREVIOUS_))
                        .addGap(18, 18, 18)
                        .addComponent(jButton_INSERT_CATEGORY_, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_UPDATE_CATEGORY_, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_DELETE_CATEGORY_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_SHOW_PRODUCTS_IN_CATEGORY)))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_CATEGORIES_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_CATEGORIES_MouseClicked

        Integer rowIndex = jTable_CATEGORIES_.getSelectedRow();
        jTextField_CATEGORY_ID.setText(jTable_CATEGORIES_.getValueAt(rowIndex, 0).toString());
        jTextField_CATEGORY_NAME.setText(jTable_CATEGORIES_.getValueAt(rowIndex, 1).toString());

        populateProductsList(Integer.valueOf(jTable_CATEGORIES_.getValueAt(rowIndex, 0).toString()));

        position = rowIndex;

    }//GEN-LAST:event_jTable_CATEGORIES_MouseClicked

    private void jButton_INSERT_CATEGORY_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_INSERT_CATEGORY_ActionPerformed

        try{
            if(!jTextField_CATEGORY_NAME.getText().equals(""))
            {
                Category category = new Category(null,jTextField_CATEGORY_NAME.getText(), 0);
                Category.insertCategory(category);
                populateJtable();
            }else{
                JOptionPane.showMessageDialog(null, "Enter The Category Name", "Enter Name", 2);
            }

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", 2);
        }
    }//GEN-LAST:event_jButton_INSERT_CATEGORY_ActionPerformed

    private void jButton_UPDATE_CATEGORY_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UPDATE_CATEGORY_ActionPerformed

        try{

            if(!jTextField_CATEGORY_NAME.getText().equals(""))
            {
                Category category = new Category(Integer.valueOf(jTextField_CATEGORY_ID.getText()),jTextField_CATEGORY_NAME.getText(), 0);
                Category.updateCategory(category);
                populateJtable();
            }
            else{
                JOptionPane.showMessageDialog(null, "Enter The Category Name", "Enter Name", 2);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "No Category Selected", "Error", 2);
        }

    }//GEN-LAST:event_jButton_UPDATE_CATEGORY_ActionPerformed

    private void jButton_DELETE_CATEGORY_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DELETE_CATEGORY_ActionPerformed

        try{
            Category.deleteCategory(Integer.valueOf(jTextField_CATEGORY_ID.getText()));
            jTextField_CATEGORY_ID.setText("");
            jTextField_CATEGORY_NAME.setText("");
            position = 0;
            populateJtable();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "No Category Selected", "Error", 2);
        }

    }//GEN-LAST:event_jButton_DELETE_CATEGORY_ActionPerformed

    private void jButton_NEXT_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NEXT_ActionPerformed

        if(position == category.categoriesList().size() - 1)
        {
            return;
        }

        position ++;
        navigation(position);
        jTable_CATEGORIES_MouseClicked(null);
        //System.out.println(position.toString());
    }//GEN-LAST:event_jButton_NEXT_ActionPerformed

    private void jButton_PREVIOUS_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PREVIOUS_ActionPerformed

        if(position == 0)
        {
            return;
        }

        position --;
        navigation(position);
        jTable_CATEGORIES_MouseClicked(null);
    }//GEN-LAST:event_jButton_PREVIOUS_ActionPerformed

    private void jButton_SHOW_PRODUCTS_IN_CATEGORYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SHOW_PRODUCTS_IN_CATEGORYActionPerformed

        try{

            CateProducts productsInCategoryForm = new CateProducts();
            Product prd = new Product();
            Integer categoryId = Integer.valueOf(jTable_CATEGORIES_.getValueAt(jTable_CATEGORIES_.getSelectedRow(),0).toString());
            ArrayList<Product> ProductList = prd.productsInCategoryList(categoryId);

            String[] colNames = {"Id","Name","Category","Price","Quantity","Image","Description"};
            Object[][] rows = new Object[ProductList.size()][7];

            for(int i = 0; i < ProductList.size(); i++){
                rows[i][0] = ProductList.get(i).getId();
                rows[i][1] = ProductList.get(i).getName();
                rows[i][6] = ProductList.get(i).getCategory_id();
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
            productsInCategoryForm.jTable_PRODUCTS_IN_CATEGORY.setModel(mmd);
            productsInCategoryForm.jTable_PRODUCTS_IN_CATEGORY.setRowHeight(80);
            productsInCategoryForm.jTable_PRODUCTS_IN_CATEGORY.getColumnModel().getColumn(5).setPreferredWidth(150);
            productsInCategoryForm.jTable_PRODUCTS_IN_CATEGORY.getColumnModel().getColumn(4).setPreferredWidth(120);
            productsInCategoryForm.jLabel_CATEGORY_NAME.setText(" Products In The Category :  " + jTable_CATEGORIES_.getValueAt(jTable_CATEGORIES_.getSelectedRow(),1).toString());
            productsInCategoryForm.setVisible(true);
            productsInCategoryForm.pack();
            productsInCategoryForm.setLocationRelativeTo(null);
            productsInCategoryForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "You Must Select A Category From The Table", "No Category Selected", 2);
        }

    }//GEN-LAST:event_jButton_SHOW_PRODUCTS_IN_CATEGORYActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_DELETE_CATEGORY_;
    private javax.swing.JButton jButton_INSERT_CATEGORY_;
    private javax.swing.JButton jButton_NEXT_;
    private javax.swing.JButton jButton_PREVIOUS_;
    private javax.swing.JButton jButton_SHOW_PRODUCTS_IN_CATEGORY;
    private javax.swing.JButton jButton_UPDATE_CATEGORY_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList_PRODUCTS_IN_CATEGORY;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_CATEGORIES_;
    private javax.swing.JTextField jTextField_CATEGORY_ID;
    private javax.swing.JTextField jTextField_CATEGORY_NAME;
    // End of variables declaration//GEN-END:variables
}
