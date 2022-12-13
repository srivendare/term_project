/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.DB_INFO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ruishang
 */
public class OrderDetails extends Order {
    
     private Integer productId;
     private Integer orderId;
     private Integer qt;
     private String price;
     private String totalAmount;

    public OrderDetails(Integer productId, Integer orderId, Integer qt, String price, String totalAmount) {
        this.productId = productId;
        this.orderId = super.getId();
        this.qt = qt;
        this.price = price;
        this.totalAmount = totalAmount;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getQt() {
        return qt;
    }

    public void setQt(Integer qt) {
        this.qt = qt;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
     
     
     
     
    
    
    
    // insert order details
     public synchronized static void insertOrderDetails(Integer productId, Integer orderId, Integer qt, String price, String totalAmount)
    {
        Connection con = DB_INFO.getConnection();
        PreparedStatement InsertPs;
        PreparedStatement UpdatePs;
        
        try {
            InsertPs = con.prepareStatement("INSERT INTO order_detail (product_id, order_id, quantity, price, total) VALUES (?, ?, ?, ?, ?)");

            InsertPs.setInt(1, productId);
            InsertPs.setInt(2, orderId);
            InsertPs.setInt(3, qt);
            InsertPs.setString(4, price);
            InsertPs.setString(5, totalAmount);

            if(InsertPs.executeUpdate() != 0){
                //JOptionPane.showMessageDialog(null, "Order Details Added");
                
                UpdatePs = con.prepareStatement("update PRODUCT set quantity = quantity - ? where id = ?");
                UpdatePs.setInt(1, qt);
                UpdatePs.setInt(2, productId);
                UpdatePs.executeUpdate();
                
            }
                else{
                    JOptionPane.showMessageDialog(null, "Something Wrong","Add Details",2);
                    
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
