package ui.sysadmin;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.Users;


public class ManageUser extends javax.swing.JFrame {

    /**
     * Creates new form MANAGE_USERS_FORM
     */
    public ManageUser() {
        initComponents();
        
        populateJtable();
        jTextField_ID.setEditable(false);
        jTextField_ID.setEnabled(false);
        
        jTable_USERS.setShowGrid(true);
        
        jTable_USERS.setGridColor(Color.gray);
        
        jTable_USERS.setSelectionBackground(Color.gray);
        
        JTableHeader th = jTable_USERS.getTableHeader();

        th.setFont(new Font("Tahoma", Font.PLAIN, 12));
    }
    
    public JPanel getEditPane() {
        return this.editPane;
    }

    
    
    // function to populate the jtable with users data
    public void populateJtable(){
        
        Users user = new Users();
        ArrayList<Users> userList = user.UsersList();
        
        String[] colNames = {"Id","username","password","fullname","Tel","Email", "Enterpirse", "Org", "Role"};
        Object[][] rows = new Object[userList.size()][9];

        for(int i = 0; i < userList.size(); i++){
          
            rows[i][0] = userList.get(i).getId();
            rows[i][1] = userList.get(i).getUsername();
            rows[i][2] = userList.get(i).getPassword();
            rows[i][3] = userList.get(i).getFullname();
            
            rows[i][4] = userList.get(i).getTel();
            rows[i][5] = userList.get(i).getEmail();
            rows[i][6] = userList.get(i).getEnterprise();
            rows[i][7] = userList.get(i).getOrganization();
            rows[i][8] = userList.get(i).getRole();
          
        }
        
        DefaultTableModel mmodel = new DefaultTableModel(rows, colNames);
        jTable_USERS.setModel(mmodel);
        jTable_USERS.setRowHeight(45);
    }
    
    
    // 
    public void getSelections(){
        if (comboEntr.getSelectedItem().toString().equals("source")){
            comboOrg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "management", "purchasing", "category"}));
            comboRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "manager", "purchaser", "demander"}));
        } else if (comboEntr.getSelectedItem().toString().equals("supply")) {
            comboOrg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "quality", "supplier", "management"}));
            comboRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "manager", "specialist"}));
        } else if (comboEntr.getSelectedItem().toString().equals("system")) {
            comboOrg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "system"}));
            comboRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin"}));
        } else if (comboEntr.getSelectedItem().toString().equals("data")){
            comboOrg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "strategydepartment", "analysisdepartment"}));
            comboRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "manager", "chief"}));
        } else if (comboEntr.getSelectedItem().toString().equals("finance")){
            comboOrg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "taxoffice", "accounting"}));
            comboRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "taxofficer", "cashier"}));
        } 
        
    };
    
    
    // comboEntr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "supply", "source", "finance", "data", "system" }));
    
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
        jTextField_USERNAME = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_PASSWORD = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_TEL = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_EMAIL = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_USERS = new javax.swing.JTable();
        jButton_INSERT_ = new javax.swing.JButton();
        jButton_UPDATE_ = new javax.swing.JButton();
        jButton_DELETE_ = new javax.swing.JButton();
        jButton_CLEAR_ = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField_FULLNAME = new javax.swing.JTextField();
        lblEntr = new javax.swing.JLabel();
        lblOrg = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboEntr = new javax.swing.JComboBox<>();
        comboRole = new javax.swing.JComboBox<>();
        comboOrg = new javax.swing.JComboBox<>();
        btnView = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        editPane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("ID:");

        jTextField_ID.setEditable(false);
        jTextField_ID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Username:");

        jTextField_USERNAME.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Password:");

        jTextField_PASSWORD.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Tel:");

        jTextField_TEL.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Email:");

        jTextField_EMAIL.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jTable_USERS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_USERS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_USERSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_USERS);

        jButton_INSERT_.setBackground(new java.awt.Color(0, 153, 153));
        jButton_INSERT_.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_INSERT_.setForeground(new java.awt.Color(51, 51, 51));
        jButton_INSERT_.setText("Insert");
        jButton_INSERT_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_INSERT_ActionPerformed(evt);
            }
        });

        jButton_UPDATE_.setBackground(new java.awt.Color(65, 131, 215));
        jButton_UPDATE_.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_UPDATE_.setForeground(new java.awt.Color(51, 51, 51));
        jButton_UPDATE_.setText("Edit");
        jButton_UPDATE_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UPDATE_ActionPerformed(evt);
            }
        });

        jButton_DELETE_.setBackground(new java.awt.Color(246, 36, 89));
        jButton_DELETE_.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_DELETE_.setForeground(new java.awt.Color(51, 51, 51));
        jButton_DELETE_.setText("Remove");
        jButton_DELETE_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DELETE_ActionPerformed(evt);
            }
        });

        jButton_CLEAR_.setBackground(new java.awt.Color(192, 57, 43));
        jButton_CLEAR_.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton_CLEAR_.setForeground(new java.awt.Color(51, 51, 51));
        jButton_CLEAR_.setText("clear");
        jButton_CLEAR_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CLEAR_ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("FullName:");

        jTextField_FULLNAME.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblEntr.setText("Entr");

        lblOrg.setText("Org");

        lblRole.setText("Role");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("User Info");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Manage Users");

        comboEntr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "supply", "source", "finance", "data", "system" }));
        comboEntr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEntrActionPerformed(evt);
            }
        });

        comboRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRoleActionPerformed(evt);
            }
        });

        comboOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOrgActionPerformed(evt);
            }
        });

        btnView.setBackground(new java.awt.Color(62, 109, 156));
        btnView.setForeground(new java.awt.Color(255, 255, 255));
        btnView.setText("Go");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editPaneLayout = new javax.swing.GroupLayout(editPane);
        editPane.setLayout(editPaneLayout);
        editPaneLayout.setHorizontalGroup(
            editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editPaneLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editPaneLayout.createSequentialGroup()
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEntr)
                            .addComponent(jLabel5)
                            .addComponent(lblOrg)
                            .addComponent(lblRole))
                        .addGap(49, 49, 49)
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField_EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(editPaneLayout.createSequentialGroup()
                                        .addComponent(comboEntr, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(comboOrg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboRole, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editPaneLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField_TEL, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(editPaneLayout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField_FULLNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(editPaneLayout.createSequentialGroup()
                                .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField_USERNAME)
                                    .addComponent(jTextField_ID)
                                    .addComponent(jTextField_PASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editPaneLayout.createSequentialGroup()
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editPaneLayout.createSequentialGroup()
                        .addComponent(jButton_INSERT_, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_UPDATE_, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton_DELETE_, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138))))
            .addGroup(editPaneLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jButton_CLEAR_, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editPaneLayout.setVerticalGroup(
            editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPaneLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addGap(26, 26, 26)
                .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editPaneLayout.createSequentialGroup()
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField_USERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField_PASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField_FULLNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField_TEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField_EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEntr)
                            .addComponent(comboEntr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnView))
                        .addGap(21, 21, 21)
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOrg)
                            .addComponent(comboOrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRole)
                            .addComponent(comboRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(jButton_CLEAR_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editPaneLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_DELETE_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_UPDATE_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_INSERT_, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // get selected user data from jtable to textfields
    private void jTable_USERSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_USERSMouseClicked

        Integer rowIndex = jTable_USERS.getSelectedRow();
        jTextField_ID.setText(jTable_USERS.getValueAt(rowIndex, 0).toString());
        jTextField_USERNAME.setText(jTable_USERS.getValueAt(rowIndex, 1).toString());
        jTextField_PASSWORD.setText(jTable_USERS.getValueAt(rowIndex, 2).toString());
        jTextField_FULLNAME.setText(jTable_USERS.getValueAt(rowIndex, 3).toString());
        jTextField_TEL.setText(jTable_USERS.getValueAt(rowIndex, 4).toString());
        jTextField_EMAIL.setText(jTable_USERS.getValueAt(rowIndex, 5).toString());
        comboEntr.setSelectedItem(jTable_USERS.getValueAt(rowIndex, 6).toString()); // comboEntr.getSelectedItem().toString();
        getSelections();
        
        comboOrg.setSelectedItem(jTable_USERS.getValueAt(rowIndex, 7).toString());
        comboRole.setSelectedItem(jTable_USERS.getValueAt(rowIndex, 8).toString());
    }//GEN-LAST:event_jTable_USERSMouseClicked

    
    // button add a new user
    private void jButton_INSERT_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_INSERT_ActionPerformed

        if(verifFields())
        {
            Pattern patternTel = Pattern.compile("[0-9]{6}");
            
            String uname = jTextField_USERNAME.getText();
            String pass = jTextField_PASSWORD.getText();
            String fname = jTextField_FULLNAME.getText();
            String tel = jTextField_TEL.getText();
            String email = jTextField_EMAIL.getText();
            String enterprise = comboEntr.getSelectedItem().toString();
            String organization = comboOrg.getSelectedItem().toString(); //txtOrg.getText();
            String role = comboRole.getSelectedItem().toString();// txtRole.getText();
            
            
            if (!patternTel.matcher(tel).matches()){
                JOptionPane.showMessageDialog(null, "Please Enter a vialid Tele Number!", "Warning", 1);
            } else if (!email.contains("@")||email.length()<7){
                JOptionPane.showMessageDialog(null, "Please Enter a vialid Email!", "Warning", 1);
            } else if (uname.length()<4 ){
                JOptionPane.showMessageDialog(null, "Username should be longer than 4 digis!", "Warning", 1);
            }  else if (pass.length()<6){
                JOptionPane.showMessageDialog(null, "Password should be longer than 6 digis!", "Warning", 1);
            } else {
                Users user = new Users(null,uname,pass,null,fname,tel,email,enterprise,organization,role);
                Users.insertUser(user);
                populateJtable();     
            }
            
        }
        
    }//GEN-LAST:event_jButton_INSERT_ActionPerformed

    
    // button update user
    private void jButton_UPDATE_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UPDATE_ActionPerformed

        try{
            
            if(verifFields())
            {
                Integer id = Integer.valueOf(jTextField_ID.getText());
                String uname = jTextField_USERNAME.getText();
                String pass = jTextField_PASSWORD.getText();
                String fname = jTextField_FULLNAME.getText();
                String tel = jTextField_TEL.getText();
                String email = jTextField_EMAIL.getText();
                String enterprise = comboEntr.getSelectedItem().toString();
                String organization = comboOrg.getSelectedItem().toString();
                String role = comboRole.getSelectedItem().toString();
                

                // username`, `password`, `user_type`, `fullname`, `tel`, `email
                Users user = new Users(id,uname,pass,null,fname,tel,email,enterprise,organization,role);
                Users.updateUser(user);
                populateJtable();
            }
            
        }
        catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Select a User Before Editing", "No User Selected", 1);
                }
        
    }//GEN-LAST:event_jButton_UPDATE_ActionPerformed

    // button delete user
    private void jButton_DELETE_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DELETE_ActionPerformed

        try{
            Integer id = Integer.valueOf(jTextField_ID.getText());
            Users.deleteUser(id);
            populateJtable(); 
            jButton_CLEAR_ActionPerformed(null);
        }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Select a User Before Removing", "No User Selected", 1);
                }
        
    }//GEN-LAST:event_jButton_DELETE_ActionPerformed

    // button clear all textfields
    private void jButton_CLEAR_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CLEAR_ActionPerformed
       
           jTextField_ID.setText("");
           jTextField_USERNAME.setText("");
           jTextField_PASSWORD.setText("");
           jTextField_FULLNAME.setText("");
           jTextField_TEL.setText("");
           jTextField_EMAIL.setText("");
           //txtEntr.setText("");
           //txtOrg.setText("");
           //txtRole.setText("");
        
    }//GEN-LAST:event_jButton_CLEAR_ActionPerformed

    private void comboEntrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEntrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEntrActionPerformed

    private void comboRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboRoleActionPerformed

    private void comboOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboOrgActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        getSelections();
  
    }//GEN-LAST:event_btnViewActionPerformed


    
    // function to check empty fields
    public boolean verifFields()
    {
        if(jTextField_USERNAME.getText().equals("") || jTextField_PASSWORD.getText().equals("") || jTextField_FULLNAME.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty", "Empty Fields", 0);
            return false;
        }else{
            return true;
        }
    }
    
    
    
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
            java.util.logging.Logger.getLogger(ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> comboEntr;
    private javax.swing.JComboBox<String> comboOrg;
    private javax.swing.JComboBox<String> comboRole;
    private javax.swing.JPanel editPane;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_USERS;
    private javax.swing.JTextField jTextField_EMAIL;
    private javax.swing.JTextField jTextField_FULLNAME;
    private javax.swing.JTextField jTextField_ID;
    private javax.swing.JTextField jTextField_PASSWORD;
    private javax.swing.JTextField jTextField_TEL;
    private javax.swing.JTextField jTextField_USERNAME;
    private javax.swing.JLabel lblEntr;
    private javax.swing.JLabel lblOrg;
    private javax.swing.JLabel lblRole;
    // End of variables declaration//GEN-END:variables
}
