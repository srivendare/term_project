package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Warehouse {
    
    Connection connection;
    
    private Integer id;
    private String company_name;
    private String location;
    private String tel;
    private String email;

    
    public Warehouse(){}
    
    
    public Warehouse(Integer ID, String FNAME, String LNAME, String TEL, String EMAIL)
    {
        this.id = ID;
        this.company_name = FNAME;
        this.location = LNAME;
        this.tel = TEL;
        this.email = EMAIL;
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getcompany_name() {
        return company_name;
    }

    public void setcompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getlocation() {
        return location;
    }

    public void setlocation(String location) {
        this.location = location;
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
    

    public ArrayList<Warehouse> warehouseList(){
        
        ArrayList<Warehouse> customer_list = new ArrayList<>();
        connection = DB_INFO.getConnection();
        Statement st;
        ResultSet rs;
        PreparedStatement ps;

               String query = "SELECT `id`, `company_name`, `location`, `tel`, `email` FROM `customer`";
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
           
            Warehouse customer;
            // Integer ID, String NAME, Integer CATEGORY_ID, String PRICE, byte[] PICTURE, Integer QUANTITY, String DESCRIPTION
            while(rs.next()){
                customer = new Warehouse(rs.getInt("id"), 
                                 rs.getString("company_name"),
                                 rs.getString("location"),
                                 rs.getString("tel"),
                                 rs.getString("email")
                                 );
                
                customer_list.add(customer);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Warehouse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer_list;
        
    }
    
    
    
    // insert a new customer
     public static void insertCustomer(Warehouse customer)
    {
        Connection con = DB_INFO.getConnection();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("INSERT INTO `customer`(`company_name`, `location`, `tel`, `email`) VALUES (?,?,?,?)");

            ps.setString(1, customer.getcompany_name());
            ps.setString(2, customer.getlocation());
            ps.setString(3, customer.getTel());
            ps.setString(4, customer.getEmail());
            

            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "New Customer Added");
                
                }
                else{
                    JOptionPane.showMessageDialog(null, "Something Wrong");
                    
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(Warehouse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     // update customer data
    public synchronized static void updateCustomer(Warehouse customer)
    {
        Connection con = DB_INFO.getConnection();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("UPDATE `customer` SET `company_name`=?,`location`=?,`tel`=?,`email`=? WHERE `id`=?");

            ps.setString(1, customer.getcompany_name());
            ps.setString(2, customer.getlocation());
            ps.setString(3, customer.getTel());
            ps.setString(4, customer.getEmail());
            ps.setInt(5, customer.getId());

            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Customer Updated");
                
                }
                else{
                    JOptionPane.showMessageDialog(null, "Something Wrong");
                    
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(Warehouse.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    // delete customer by id
    public synchronized static void deleteCustomer(Integer customerId)
    {
        
        Connection con = DB_INFO.getConnection();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("DELETE FROM `customer` WHERE `id` = ?");

            ps.setInt(1, customerId);

            // show a confirmation message before deleting the Warehouse
            int YesOrNo = JOptionPane.showConfirmDialog(null,"Do You Really Want To Delete This Customer","Delete Customer", JOptionPane.YES_NO_OPTION);
            if(YesOrNo == 0){
                
                if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Customer Deleted");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Something Wrong");
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Warehouse.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
    
    
    
}
