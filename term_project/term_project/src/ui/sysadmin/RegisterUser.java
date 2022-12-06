package ui.sysadmin;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.Users;


public class RegisterUser extends javax.swing.JFrame {

    /**
     * Creates new form MANAGE_USERS_FORM
     */
    public RegisterUser() {
        initComponents();
        
    }
    
    public JPanel getEditPane() {
        return editPane;
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
  
    }
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboEntr = new javax.swing.JComboBox<>();
        editPane = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_USERNAME = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_PASSWORD = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_TEL = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_EMAIL = new javax.swing.JTextField();
        jButton_INSERT_ = new javax.swing.JButton();
        jButton_CLEAR_ = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField_FULLNAME = new javax.swing.JTextField();
        lblEntr = new javax.swing.JLabel();
        lblOrg = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        txtOrg = new javax.swing.JTextField();
        txtRole = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboEntr1 = new javax.swing.JComboBox<>();

        comboEntr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "supply", "source", "finance", "data", "system" }));
        comboEntr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEntrActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        editPane.setBackground(new java.awt.Color(255, 255, 255));

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

        jButton_INSERT_.setBackground(new java.awt.Color(0, 153, 153));
        jButton_INSERT_.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_INSERT_.setForeground(new java.awt.Color(51, 51, 51));
        jButton_INSERT_.setText("Submit");
        jButton_INSERT_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_INSERT_ActionPerformed(evt);
            }
        });

        jButton_CLEAR_.setBackground(new java.awt.Color(192, 57, 43));
        jButton_CLEAR_.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton_CLEAR_.setForeground(new java.awt.Color(51, 51, 51));
        jButton_CLEAR_.setText("Clear");
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

        txtOrg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtRole.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Create a New User");

        comboEntr1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "supply", "source", "finance", "data", "system" }));
        comboEntr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEntr1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editPaneLayout = new javax.swing.GroupLayout(editPane);
        editPane.setLayout(editPaneLayout);
        editPaneLayout.setHorizontalGroup(
            editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPaneLayout.createSequentialGroup()
                .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editPaneLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField_FULLNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField_TEL, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(editPaneLayout.createSequentialGroup()
                                    .addComponent(lblRole)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(editPaneLayout.createSequentialGroup()
                                    .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3))
                                    .addGap(45, 45, 45)
                                    .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField_USERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField_PASSWORD, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(editPaneLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField_EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(editPaneLayout.createSequentialGroup()
                                    .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblOrg)
                                        .addComponent(lblEntr))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtOrg, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                        .addComponent(comboEntr1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(editPaneLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jButton_CLEAR_, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_INSERT_, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(editPaneLayout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(jLabel2)))
                .addContainerGap(301, Short.MAX_VALUE))
        );
        editPaneLayout.setVerticalGroup(
            editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editPaneLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
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
                    .addComponent(comboEntr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrg))
                .addGap(18, 18, 18)
                .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRole))
                .addGap(41, 41, 41)
                .addGroup(editPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_CLEAR_)
                    .addComponent(jButton_INSERT_))
                .addGap(36, 36, 36))
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

    
    // button add a new user
    private void jButton_INSERT_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_INSERT_ActionPerformed

        if(verifFields())
        {
            String uname = jTextField_USERNAME.getText();
            String pass = jTextField_PASSWORD.getText();
            String fname = jTextField_FULLNAME.getText();
            String tel = jTextField_TEL.getText();
            String email = jTextField_EMAIL.getText();
            String selectEntr = comboEntr.getSelectedItem().toString();
            String enterprise = selectEntr;
            String organization = txtOrg.getText();
            String role = txtRole.getText();
            
           if (selectEntr.equals("supply")){
                System.out.println("supply");
                if (!organization.equals("management") && !organization.equals("purchasing") && !organization.equals("Category")){
                    JOptionPane.showMessageDialog(null, "Please enter correct orgranization","Login Error",2);
                }
            } else if (selectEntr.equals("source")){
                System.out.println("source");
            } else if (selectEntr.equals("finance")){
                System.out.println("finance");
            } else if (selectEntr.equals("data")){
                System.out.println("data");
            } else if (selectEntr.equals("system")){
                System.out.println("system");
            }
            else {
                System.out.println("Please enter a valid Enterprise");
            };

            Users user = new Users(null,uname,pass,null,fname,tel,email,enterprise,organization,role);
            Users.insertUser(user);
           
        }
        
    }//GEN-LAST:event_jButton_INSERT_ActionPerformed

    
    // button clear all textfields
    private void jButton_CLEAR_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CLEAR_ActionPerformed
       
           
           jTextField_USERNAME.setText("");
           jTextField_PASSWORD.setText("");
           jTextField_FULLNAME.setText("");
           jTextField_TEL.setText("");
           jTextField_EMAIL.setText("");
           // txtEntr.setText("");
           txtOrg.setText("");
           txtRole.setText("");
        
    }//GEN-LAST:event_jButton_CLEAR_ActionPerformed

    private void comboEntrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEntrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEntrActionPerformed

    private void comboEntr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEntr1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEntr1ActionPerformed


    
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
            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new RegisterUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboEntr;
    private javax.swing.JComboBox<String> comboEntr1;
    private javax.swing.JPanel editPane;
    private javax.swing.JButton jButton_CLEAR_;
    private javax.swing.JButton jButton_INSERT_;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField_EMAIL;
    private javax.swing.JTextField jTextField_FULLNAME;
    private javax.swing.JTextField jTextField_PASSWORD;
    private javax.swing.JTextField jTextField_TEL;
    private javax.swing.JTextField jTextField_USERNAME;
    private javax.swing.JLabel lblEntr;
    private javax.swing.JLabel lblOrg;
    private javax.swing.JLabel lblRole;
    private javax.swing.JTextField txtOrg;
    private javax.swing.JTextField txtRole;
    // End of variables declaration//GEN-END:variables
}
