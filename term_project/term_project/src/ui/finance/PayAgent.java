package ui.finance;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.Pay;
import model.Users;

public class PayAgent extends javax.swing.JFrame {

    /**
     * Creates new form MANAGE_USERS_FORM
     */
    public PayAgent() {
        initComponents();
        
//        Pay pay = new Pay();
//        pay.generatePayRecord();
        
        populateJtable();
        
        jTable_Pay.setShowGrid(true);
        
        jTable_Pay.setGridColor(Color.gray);
        
        jTable_Pay.setSelectionBackground(Color.gray);
        
        JTableHeader th = jTable_Pay.getTableHeader();

        th.setFont(new Font("Tahoma", Font.PLAIN, 14));
    }
    
    public JPanel getPayPanel() {
        return editPane;
    }

    // function to populate the jtable with users data
    public void populateJtable(){
        
        Pay pay = new Pay();
        ArrayList<Pay> payList = pay.payList();
        List<Pay> filterList = payList.stream().filter(a -> a.getStatus() == 0).collect(Collectors.toList());
            
        String[] colNames = {"Id","originalPrice","tax","totalPrice"};
        Object[][] rows = new Object[filterList.size()][4];

        for(int i = 0; i < filterList.size(); i++){

            rows[i][0] = filterList.get(i).getId();
            rows[i][1] = filterList.get(i).getOriginalPrice();
            rows[i][2] = filterList.get(i).getTax();
            rows[i][3] = filterList.get(i).getTotalPrice();
            
        }
        
        DefaultTableModel mmodel = new DefaultTableModel(rows, colNames);
        jTable_Pay.setModel(mmodel);
        jTable_Pay.setRowHeight(45);
    }
    
    public void populateJtable(List<Pay> filterList){
        
        
        String[] colNames = {"Id","originalPrice","tax","totalPrice"};
        Object[][] rows = new Object[filterList.size()][4];

        for(int i = 0; i < filterList.size(); i++){

            rows[i][0] = filterList.get(i).getId();
            rows[i][1] = filterList.get(i).getOriginalPrice();
            rows[i][2] = filterList.get(i).getTax();
            rows[i][3] = filterList.get(i).getTotalPrice();
            
        }
        
        DefaultTableModel mmodel = new DefaultTableModel(rows, colNames);
        jTable_Pay.setModel(mmodel);
        jTable_Pay.setRowHeight(45);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editPane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_ID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField_ORIGINALPRICE = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_TAX = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_CARDNUMBER = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_VERIFICATIONCODE = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Pay = new javax.swing.JTable();
        jButton_Paid = new javax.swing.JButton();
        jButton_Unpaid = new javax.swing.JButton();
        jButton_Pay = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField_TOTALPRICE = new javax.swing.JTextField();
        lblEntr = new javax.swing.JLabel();
        lblOrg = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        txtOWNERNAME = new javax.swing.JTextField();
        txtADDRESS = new javax.swing.JTextField();
        txtREMARK = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        editPane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("ID:");

        jTextField_ID.setEditable(false);
        jTextField_ID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));

        jTextField_ORIGINALPRICE.setEditable(false);
        jTextField_ORIGINALPRICE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Tax:");

        jTextField_TAX.setEditable(false);
        jTextField_TAX.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField_TAX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TAXActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Card Number:");

        jTextField_CARDNUMBER.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Verification Code:");

        jTextField_VERIFICATIONCODE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jTable_Pay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_Pay.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jTable_Pay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_PayMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Pay);

        jButton_Paid.setBackground(new java.awt.Color(65, 131, 215));
        jButton_Paid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_Paid.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Paid.setText("Paid Order");
        jButton_Paid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PaidActionPerformed(evt);
            }
        });

        jButton_Unpaid.setBackground(new java.awt.Color(246, 36, 89));
        jButton_Unpaid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_Unpaid.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Unpaid.setText("Unpaid Order");
        jButton_Unpaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UnpaidActionPerformed(evt);
            }
        });

        jButton_Pay.setBackground(new java.awt.Color(192, 57, 43));
        jButton_Pay.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton_Pay.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Pay.setText("Pay");
        jButton_Pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PayActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Total Price:");

        jTextField_TOTALPRICE.setEditable(false);
        jTextField_TOTALPRICE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblEntr.setText("Owner Name:");

        lblOrg.setText("Address:");

        lblRole.setText("Remark:");

        txtOWNERNAME.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtADDRESS.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtREMARK.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Original Price:");

        jLabel7.setBackground(new java.awt.Color(102, 102, 255));
        jLabel7.setText("Order Record");

        javax.swing.GroupLayout editPaneLayout = new javax.swing.GroupLayout(editPane);
        editPane.setLayout(editPaneLayout);
        editPaneLayout.setHorizontalGroup(
            editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPaneLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jButton_Pay, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editPaneLayout.createSequentialGroup()
                .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField_TOTALPRICE, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(editPaneLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(103, 103, 103)
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField_ORIGINALPRICE)
                            .addComponent(jTextField_ID)
                            .addComponent(jTextField_TAX, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextField_CARDNUMBER, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(editPaneLayout.createSequentialGroup()
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addGap(202, 202, 202))
                    .addGroup(editPaneLayout.createSequentialGroup()
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEntr)
                            .addComponent(lblOrg)
                            .addComponent(lblRole)
                            .addComponent(jLabel5))
                        .addGap(38, 38, 38)
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField_VERIFICATIONCODE, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOWNERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtADDRESS, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtREMARK, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editPaneLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editPaneLayout.createSequentialGroup()
                        .addComponent(jButton_Paid, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(jButton_Unpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(224, 224, 224))
        );
        editPaneLayout.setVerticalGroup(
            editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPaneLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editPaneLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_Unpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Paid, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Pay, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editPaneLayout.createSequentialGroup()
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField_ORIGINALPRICE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField_TAX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField_TOTALPRICE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField_CARDNUMBER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField_VERIFICATIONCODE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEntr)
                            .addComponent(txtOWNERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtADDRESS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOrg))
                        .addGap(18, 18, 18)
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtREMARK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRole))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // get selected user data from jtable to textfields
    private void jTable_PayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_PayMouseClicked

        Integer rowIndex = jTable_Pay.getSelectedRow();

        Pay pay = new Pay();
        ArrayList<Pay> payList = pay.payList();
        Integer id = (Integer)jTable_Pay.getValueAt(rowIndex, 0);
        
        payList.forEach((t) -> {
            if(id == t.getId()){
                jTextField_ID.setText(t.getId().toString());
                jTextField_ORIGINALPRICE.setText(t.getOriginalPrice());
                jTextField_TAX.setText(t.getTax());
                jTextField_TOTALPRICE.setText(t.getTotalPrice());
                jTextField_CARDNUMBER.setText(t.getCardNumber());
                jTextField_VERIFICATIONCODE.setText(t.getVerificationCode());
                txtOWNERNAME.setText(t.getOwnerName());
                txtADDRESS.setText(t.getAddress());
                txtREMARK.setText(t.getRemark());
            }
        });
        
        
    }//GEN-LAST:event_jTable_PayMouseClicked

    // button update user
    private void jButton_PaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PaidActionPerformed

        try{
            
            Pay pay = new Pay();
            ArrayList<Pay> payList = pay.payList();
            List<Pay> filterList = payList.stream().filter(a -> a.getStatus() == 1).collect(Collectors.toList());
            populateJtable(filterList);
            
        }
        catch(Exception ex){
        }
        
    }//GEN-LAST:event_jButton_PaidActionPerformed

    // button delete user
    private void jButton_UnpaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UnpaidActionPerformed
        try{
            
            Pay pay = new Pay();
            ArrayList<Pay> payList = pay.payList();
            List<Pay> filterList = payList.stream().filter(a -> a.getStatus() == 0).collect(Collectors.toList());
            populateJtable(filterList);
            
        }
        catch(Exception ex){
        }
    }//GEN-LAST:event_jButton_UnpaidActionPerformed

    // button clear all textfields
    private void jButton_PayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PayActionPerformed

        if(verifFields()){

            Pay pay = new Pay();
            ArrayList<Pay> payList = pay.payList();
            
            Integer id = Integer.parseInt(jTextField_ID.getText());
            String originalPrice = jTextField_ORIGINALPRICE.getText();
            String tax = jTextField_TAX.getText();
            String totalPrice = jTextField_TOTALPRICE.getText();
            String verificationCode = jTextField_VERIFICATIONCODE.getText();
            String card = jTextField_CARDNUMBER.getText();
            String ownerName = txtOWNERNAME.getText();
            String address = txtADDRESS.getText();
            String remark = txtREMARK.getText();
            
            
            
            Pattern patternCode = Pattern.compile("[0-9]{3}");
            Pattern patternCard = Pattern.compile("[0-9]{7}");
            
             if (!patternCard.matcher(card.toString()).matches()){
                 JOptionPane.showMessageDialog(null, "Please Enter a vialid Card Number!", "Warning", 1);
             }else if (!patternCode.matcher(verificationCode.toString()).matches()){
                 JOptionPane.showMessageDialog(null, "Please Enter a vialid Code!", "Warning", 1);
             } 
             else {
                List<Pay> filter = payList.stream().filter(a -> id == a.getId()).collect(Collectors.toList());
                Pay updatePay = filter.get(0);
                if(updatePay.getStatus() == 1){
                    JOptionPane.showMessageDialog(null, "The order has been paid!", "Paid Order", 1);
                    clear();
                    return;
                }

                updatePay.setStatus(1);
                updatePay.setOriginalPrice(originalPrice);
                updatePay.setTax(tax);
                updatePay.setTotalPrice(totalPrice);
                updatePay.setVerificationCode(verificationCode);
                updatePay.setOwnerName(ownerName);
                updatePay.setAddress(address);
                updatePay.setRemark(remark);

                Pay.updatePay(updatePay);
                populateJtable();

                JOptionPane.showMessageDialog(null, "Successful payment!", "Successful Payment", 1);

                clear();
            };
            
            
            
           
            
        }else{
            JOptionPane.showMessageDialog(null, "Please check if there is any missing information or if a payment record is selected", "Missing Information", 1);
            clear();
        }

    }//GEN-LAST:event_jButton_PayActionPerformed

    private void jTextField_TAXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TAXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_TAXActionPerformed

    // function to clear pay info
    private void clear(){
           jTextField_ID.setText("");
           jTextField_ORIGINALPRICE.setText("");
           jTextField_TAX.setText("");
           jTextField_TOTALPRICE.setText("");
           jTextField_CARDNUMBER.setText("");
           jTextField_VERIFICATIONCODE.setText("");
           txtOWNERNAME.setText("");
           txtADDRESS.setText("");
           txtREMARK.setText("");
    }
    
    // function to check empty fields
    public boolean verifFields()
    {
        if(jTextField_ID.getText().equals("") || jTextField_ORIGINALPRICE.getText().equals("") || jTextField_TAX.getText().equals("") || jTextField_TOTALPRICE.getText().equals("") || jTextField_CARDNUMBER.getText().equals("") || jTextField_VERIFICATIONCODE.getText().equals("") || txtOWNERNAME.getText().equals("") || txtADDRESS.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty", "Empty Fields", 0);
            return false;
        }else{
            return true;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel editPane;
    private javax.swing.JButton jButton_Paid;
    private javax.swing.JButton jButton_Pay;
    private javax.swing.JButton jButton_Unpaid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Pay;
    private javax.swing.JTextField jTextField_CARDNUMBER;
    private javax.swing.JTextField jTextField_ID;
    private javax.swing.JTextField jTextField_ORIGINALPRICE;
    private javax.swing.JTextField jTextField_TAX;
    private javax.swing.JTextField jTextField_TOTALPRICE;
    private javax.swing.JTextField jTextField_VERIFICATIONCODE;
    private javax.swing.JLabel lblEntr;
    private javax.swing.JLabel lblOrg;
    private javax.swing.JLabel lblRole;
    private javax.swing.JTextField txtADDRESS;
    private javax.swing.JTextField txtOWNERNAME;
    private javax.swing.JTextField txtREMARK;
    // End of variables declaration//GEN-END:variables
}
