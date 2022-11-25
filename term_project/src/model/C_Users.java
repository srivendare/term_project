package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class C_Users {


    Connection connection;
    
    private Integer id;
    private String username;
    private String password;
    private String user_type;
    private String fullname;
    private String tel;
    private String email;
    private String enterprise;
    private String organization;
    private String role;

    
   public C_Users(){}
    
    
    public C_Users(Integer ID, String UNAME, String PASW,String UTYP, String FNAME, String TEL, String EMAIL, String ENTR, String ORG, String ROLE)
    {
        this.id = ID;
        this.username = UNAME;
        this.password = PASW;
        this.fullname = FNAME;
        this.user_type = UTYP;
        this.tel = TEL;
        this.email = EMAIL;
        this.enterprise = ENTR;
        this.organization = ORG;
        this.role = ROLE;
    }
    


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
       
    
    // get users list
    public ArrayList<C_Users> UsersList(){
        
        ArrayList<C_Users> user_list = new ArrayList<>();
        connection = DB_INFO.getConnection();

        ResultSet rs;
        PreparedStatement ps;

               String query = "SELECT `id`, `username`, `password`, `user_type`, `fullname`, `tel`, `email`, `enterprise`, `organization`, `role` FROM `users` WHERE `user_type` = 'user'";
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
           
            C_Users user;
            while(rs.next()){
                user = new C_Users(rs.getInt("id"), 
                                 rs.getString("username"),
                                 rs.getString("password"),
                                 rs.getString("user_type"),
                                 rs.getString("fullname"),
                                 rs.getString("tel"),
                                 rs.getString("email"),
                                 rs.getString("enterprise"),
                                 rs.getString("organization"),
                                 rs.getString("role")
                                 );
                user_list.add(user);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(C_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user_list;
        
    }
    
    
    
    
    // insert a new user
     public static void insertUser(C_Users user)
    {
        Connection con = DB_INFO.getConnection();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("INSERT INTO `users`(`username`, `password`, `user_type`, `fullname`, `tel`, `email`, `enterprise`, `organization`, `role`) VALUES (?,?,?,?,?,?,?,?)");

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, "user");// the admin will add a user
            ps.setString(4, user.getFullname());
            ps.setString(5, user.getTel());
            ps.setString(6, user.getEmail());
            ps.setString(7, user.getEnterprise());
            ps.setString(8, user.getOrganization());
            ps.setString(9, user.getRole());
            

            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "New User Added");
                
                }
                else{
                    JOptionPane.showMessageDialog(null, "Something Wrong");
                    
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(C_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     // update user
    public static void updateUser(C_Users user)
    {
        Connection con = DB_INFO.getConnection();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("UPDATE `users` SET `username`=?,`password`=?,`fullname`=?,`tel`=?,`email`=?, `enterprise`=?, `organization`=?, `role`=? WHERE `id`=?");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFullname());
            ps.setString(4, user.getTel());
            ps.setString(5, user.getEmail());
            ps.setInt(6, user.getId());
            ps.setString(7, user.getEnterprise());
            ps.setString(8, user.getOrganization());
            ps.setString(9, user.getRole());

            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "User Updated");
                
                }
                else{
                    JOptionPane.showMessageDialog(null, "Something Wrong");
                    
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(C_Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    // delete user
    public static void deleteUser(Integer userId)
    {
        
        Connection con = DB_INFO.getConnection();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("DELETE FROM `users` WHERE `id` = ?");

            ps.setInt(1, userId);

            // show a confirmation message before deleting the User
            int YesOrNo = JOptionPane.showConfirmDialog(null,"Do You Really Want To Delete This User","Delete User", JOptionPane.YES_NO_OPTION);
            if(YesOrNo == 0){
               
                if(ps.executeUpdate() != 0){
                   
                    JOptionPane.showMessageDialog(null, "User Deleted");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Something Wrong");
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(C_Users.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
}