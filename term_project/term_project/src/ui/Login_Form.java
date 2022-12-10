package ui;

import ui.sysadmin.SysMenu;
import ui.supply.SupMenu;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.font.TextAttribute;
import static java.lang.annotation.RetentionPolicy.CLASS;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.DB_INFO;
import ui.analyse.AnalyseMenu;
import ui.source.orgpenal.CateMenu;
import ui.source.orgpenal.PurMenu;
import ui.source.orgpenal.SouMenu;
import ui.supply.SupQAMenu;
import ui.supply.SupSpMenu;



public class Login_Form extends javax.swing.JFrame {

    /**
     * Creates new form Login_Form
     */
    public Login_Form() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        // UNDERLINE the form title
        Font font = lblTitle.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        lblTitle.setFont(font.deriveFont(attributes));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginPane = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblPw = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtPw = new javax.swing.JPasswordField();
        jButton_LOGIN = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblPw1 = new javax.swing.JLabel();
        comboEntr = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        LoginPane.setBackground(new java.awt.Color(255, 255, 255));

        lblName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(51, 51, 51));
        lblName.setText("Username:");

        lblPw.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPw.setForeground(new java.awt.Color(51, 51, 51));
        lblPw.setText("Password:");

        lblTitle.setBackground(new java.awt.Color(51, 51, 51));
        lblTitle.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(51, 51, 51));
        lblTitle.setText("Account Login");
        lblTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtName.setText("admin");

        txtPw.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPw.setText("adminpass");

        jButton_LOGIN.setBackground(new java.awt.Color(95, 111, 148));
        jButton_LOGIN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_LOGIN.setForeground(new java.awt.Color(255, 255, 255));
        jButton_LOGIN.setText("Login");
        jButton_LOGIN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_LOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LOGINActionPerformed(evt);
            }
        });

        jButton1.setText("Become a member?");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusCycleRoot(true);
        jButton1.setFocusTraversalKeysEnabled(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblPw1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPw1.setForeground(new java.awt.Color(51, 51, 51));
        lblPw1.setText("Enterprise:");

        comboEntr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "supply", "source", "finance", "data", "system" }));
        comboEntr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEntrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginPaneLayout = new javax.swing.GroupLayout(LoginPane);
        LoginPane.setLayout(LoginPaneLayout);
        LoginPaneLayout.setHorizontalGroup(
            LoginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPaneLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addGroup(LoginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_LOGIN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPaneLayout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addGroup(LoginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginPaneLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lblTitle))
                    .addGroup(LoginPaneLayout.createSequentialGroup()
                        .addComponent(lblName)
                        .addGap(18, 18, 18)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LoginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(LoginPaneLayout.createSequentialGroup()
                            .addComponent(lblPw1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(comboEntr, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(LoginPaneLayout.createSequentialGroup()
                            .addComponent(lblPw)
                            .addGap(21, 21, 21)
                            .addComponent(txtPw, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(124, 124, 124))
        );
        LoginPaneLayout.setVerticalGroup(
            LoginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPaneLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(lblTitle)
                .addGap(35, 35, 35)
                .addGroup(LoginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LoginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPw)
                    .addComponent(txtPw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LoginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPw1)
                    .addComponent(comboEntr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jButton_LOGIN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/static/login_img.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(500, 300));
        jLabel1.setMinimumSize(new java.awt.Dimension(1027, 638));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(LoginPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoginPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // button login form
    private void jButton_LOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LOGINActionPerformed
        
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = DB_INFO.getConnection().prepareStatement("SELECT `username`, `password` , `user_type`, `enterprise`, `organization`, `role` FROM `users` WHERE `username` = ? AND `password` = ?");
            ps.setString(1, txtName.getText());
            ps.setString(2, String.valueOf(txtPw.getPassword()));
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                
                if(rs.getString("user_type").equals("admin"))
                {   
                    
                    if (comboEntr.getSelectedItem().toString().equals("system")){
                        SysMenu sysAdmin = new SysMenu();
                        //homeForm.jMenu5_USER_.setVisible(false);
                        System.out.println("user is admin");
                        //splitPane.setRightComponent(updateJPanel);
                        sysAdmin.pack();
                        sysAdmin.setExtendedState(sysAdmin.getExtendedState()); //| JFrame.MAXIMIZED_BOTH)
                        Dimension r = sysAdmin.getBounds().getSize();
                        //homeForm.jLabel_BackgroundImage.setPreferredSize(r);
                        sysAdmin.setVisible(true);

                        sysAdmin.setLocationRelativeTo(null);
                        sysAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        //homeForm.getSplitPane().setLeftComponent(adminNav); // set nav bar
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter correct user info","Login Error",2);
                    };

                } else {
                     String selectEntr = comboEntr.getSelectedItem().toString();
                     if(rs.getString("enterprise").equals("supply")&& rs.getString("enterprise").equals(selectEntr)){
                         if(rs.getString("organization").equals("management")){
                            SupMenu supAdmin = new SupMenu();
                            supAdmin.pack();
                            supAdmin.setExtendedState(supAdmin.getExtendedState()); //| JFrame.MAXIMIZED_BOTH)
                            Dimension r = supAdmin.getBounds().getSize();
                            supAdmin.setVisible(true);
                            supAdmin.setLocationRelativeTo(null);
                            supAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            System.out.println("supply Manager Here");
                         } else if (rs.getString("organization").equals("specialist")){
                             SupSpMenu supSp = new SupSpMenu();
                             supSp.pack();
                             supSp.setExtendedState(supSp.getExtendedState()); //| JFrame.MAXIMIZED_BOTH)
                             Dimension r = supSp.getBounds().getSize();
                             supSp.setVisible(true);
                             supSp.setLocationRelativeTo(null);
                             supSp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                             System.out.println("supply Specialist Here");
                         } else if (rs.getString("organization").equals("quality")){
                             SupQAMenu supQA = new SupQAMenu();
                             supQA.pack();
                             supQA.setExtendedState(supQA.getExtendedState()); //| JFrame.MAXIMIZED_BOTH)
                             Dimension r = supQA.getBounds().getSize();
                             supQA.setVisible(true);
                             supQA.setLocationRelativeTo(null);
                             supQA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                             System.out.println("supply QA Here");
                         } else {
                         JOptionPane.showMessageDialog(null, "Please enter correct user info","Login Error",2);
                         };
                     } else if(rs.getString("enterprise").equals("source")&& rs.getString("enterprise").equals(selectEntr)){
                         if(rs.getString("organization").equals("management")){
                            setVisible(false);
                            SouMenu souAdmin = new SouMenu();
                            souAdmin.pack();
                            souAdmin.setExtendedState(souAdmin.getExtendedState()); //| JFrame.MAXIMIZED_BOTH)
                            Dimension r = souAdmin.getBounds().getSize();
                            souAdmin.setVisible(true);
                            souAdmin.setLocationRelativeTo(null);
                            souAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
                         
                         } else if (rs.getString("organization").equals("purchasing")){
                             setVisible(false);
                             PurMenu purAdmin = new PurMenu();
                             purAdmin.pack();
                             purAdmin.setExtendedState(purAdmin.getExtendedState()); //| JFrame.MAXIMIZED_BOTH)
                             Dimension r = purAdmin.getBounds().getSize();
                             purAdmin.setVisible(true);
                             purAdmin.setLocationRelativeTo(null);
                             purAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                             System.out.println("SOURCE BUT pruchasing");
                         } else if (rs.getString("organization").equals("category")){
                             setVisible(false);
                             CateMenu cateAdmin = new CateMenu();
                             cateAdmin.pack();
                             cateAdmin.setExtendedState(cateAdmin.getExtendedState()); //| JFrame.MAXIMIZED_BOTH)
                             Dimension r = cateAdmin.getBounds().getSize();
                             cateAdmin.setVisible(true);
                             cateAdmin.setLocationRelativeTo(null);
                             cateAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                             System.out.println("SOURCE BUT categoy");
                         }       
                         else {
                             JOptionPane.showMessageDialog(null, "Please enter correct user info","Login Error",2);
                         };
                         
                     } else if (rs.getString("enterprise").equals("data")){
                         AnalyseMenu dataAdmin = new AnalyseMenu();
                         dataAdmin.pack();
                         dataAdmin.setExtendedState(dataAdmin.getExtendedState()); //| JFrame.MAXIMIZED_BOTH)
                         Dimension r = dataAdmin.getBounds().getSize();
                         dataAdmin.setVisible(true);
                         dataAdmin.setLocationRelativeTo(null);
                         dataAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                     } else {
                         JOptionPane.showMessageDialog(null, "Please enter correct user info","Login Error",2);
                     }
                
                }
                
                

        }else {
                JOptionPane.showMessageDialog(null, "Invalid username or password","Login Error",2);
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login_Form.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }//GEN-LAST:event_jButton_LOGINActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Comming Soon!", "Warning", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboEntrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEntrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEntrActionPerformed

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
            java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LoginPane;
    private javax.swing.JComboBox<String> comboEntr;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_LOGIN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPw;
    private javax.swing.JLabel lblPw1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPw;
    // End of variables declaration//GEN-END:variables
}
