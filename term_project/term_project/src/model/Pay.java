/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.DB_INFO;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author qiaotong
 */
public class Pay extends Order {
    Connection connection;

    private Integer id;
    private Integer orderId ;
    private Integer status ;
    private String originalPrice ;
    private String tax;
    private String totalPrice;
    private String cardNumber ;
    private String verificationCode;
    private String ownerName;
    private String Address;
    private String remark;

    public Pay() {
    }

    public Pay(Integer id, Integer orderId, Integer status, String originalPrice, String tax, String totalPrice, String cardNumber, String verificationCode, String ownerName, String Address, String remark) {
        this.id = id;
        this.orderId = orderId;
        this.status = status;
        this.originalPrice = originalPrice;
        this.tax = tax;
        this.totalPrice = totalPrice;
        this.cardNumber = cardNumber;
        this.verificationCode = verificationCode;
        this.ownerName = ownerName;
        this.Address = Address;
        this.remark = remark;
    }

    // get all the categories
    public ArrayList<Pay> payList(){

        ArrayList<Pay> pay_list = new ArrayList<>();
        connection = DB_INFO.getConnection();
        ResultSet rs;
        PreparedStatement ps;                              
        String query = "SELECT `id`, `order_id`, `status`, `original_price`, `tax`, `total_price`, `card_number`, `verification_code`, `owner_name`, `address`, `remark` FROM `pay`";

        try {

                ps = (PreparedStatement) connection.prepareStatement(query);
                rs = ps.executeQuery();

                Pay pay;

                while(rs.next()){
                    pay = new Pay(rs.getInt("id"),
                                  rs.getInt("order_id"),
                                  rs.getInt("status"),
                                  rs.getString("original_price"),
                                  rs.getString("tax"),
                                  rs.getString("total_price"),
                                  rs.getString("card_number"),
                                  rs.getString("verification_code"),
                                  rs.getString("owner_name"),
                                  rs.getString("address"),
                                  rs.getString("remark")
                                  );

                    pay_list.add(pay);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Pay.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pay_list;

    }

    // insert a new category function
    public static void insertPay(Pay pay)
    {
        Connection con = DB_INFO.getConnection();
        PreparedStatement ps;

        try {
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO `pay`(`order_id`, `status`, `original_price`, `tax`, `total_price`, `card_number`, `verification_code`, `owner_name`, `address`, `remark`) VALUES (?,?,?,?,?,?,?,?,?,?)");

            ps.setInt(1, pay.getOrderId());
            ps.setInt(2, pay.getStatus());
            ps.setString(3, pay.getOriginalPrice());
            ps.setString(4, pay.getTax());
            ps.setString(5, pay.getTotalPrice());
            ps.setString(6, pay.getCardNumber());
            ps.setString(7, pay.getVerificationCode());
            ps.setString(8, pay.getOwnerName());
            ps.setString(9, pay.getAddress());
            ps.setString(10, pay.getRemark());

            if(ps.executeUpdate() != 0){
                //JOptionPane.showMessageDialog(null, "Order Payment status Inserted");
            }
            else{
                JOptionPane.showMessageDialog(null, "Something Wrong");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Pay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // update a category function
    public static void updatePay(Pay pay)
    {
        Connection con = DB_INFO.getConnection();
        PreparedStatement ps;

        try {
            ps = (PreparedStatement) con.prepareStatement("UPDATE `pay` SET `order_id` = ?, `status` = ?, `original_price` = ?, `tax` = ?, `total_price` = ?, `card_number` = ?, `verification_code` = ?, `owner_name` = ?, `address` = ?, `remark` = ? WHERE `id` = ?");

            ps.setInt(1, pay.getOrderId());
            ps.setInt(2, pay.getStatus());
            ps.setString(3, pay.getOriginalPrice());
            ps.setString(4, pay.getTax());
            ps.setString(5, pay.getTotalPrice());
            ps.setString(6, pay.getCardNumber());
            ps.setString(7, pay.getVerificationCode());
            ps.setString(8, pay.getOwnerName());
            ps.setString(9, pay.getAddress());
            ps.setString(10, pay.getRemark());
            ps.setInt(11, pay.getId());

            if(ps.executeUpdate() != 0){
                //JOptionPane.showMessageDialog(null, "pay Updated");

                }
                else{
                    JOptionPane.showMessageDialog(null, "Something Wrong");

                }

        } catch (SQLException ex) {
            Logger.getLogger(Pay.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // delete category function
    public static void deletePay(Integer payId)
    {

        Connection con = DB_INFO.getConnection();
        PreparedStatement ps;

        try {
            ps = (PreparedStatement) con.prepareStatement("DELETE FROM `pay` WHERE `id` = ?");

            ps.setInt(1, payId);

            // show a confirmation message before deleting the Category
            int YesOrNo = JOptionPane.showConfirmDialog(null,"Do You Really Want To Delete This PayRecord","Delete PayRecord", JOptionPane.YES_NO_OPTION);
            if(YesOrNo == 0){

               if(ps.executeUpdate() != 0){
                  JOptionPane.showMessageDialog(null, "Pay Deleted");
                }

                else{
                    JOptionPane.showMessageDialog(null, "Something Wrong");
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(Pay.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void deletePay(Integer payId,String s)
    {

        Connection con = DB_INFO.getConnection();
        PreparedStatement ps;

        try {
            ps = (PreparedStatement) con.prepareStatement("DELETE FROM `pay` WHERE `id` = ?");

            ps.setInt(1, payId);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Pay.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void generatePayRecord(){
        
        ArrayList<Pay> payList = payList();
        ArrayList<Integer> orderInPay = new ArrayList<>();
        payList.forEach((t) -> {
            orderInPay.add(t.getOrderId());
        });
        Order order = new Order();
        ArrayList<Order> orderList = order.ordersList();
        try {
            for (Order order1 : orderList) {
                if (orderInPay.contains(order1.getId())) {
                    for (Pay pay : payList()) {
                        if (order1.getId() == pay.getOrderId() && 0 == pay.getStatus()) {
                            ResultSet rs = queryTax(pay.getOrderId());
                            while(rs.next()){
                                pay.setOriginalPrice(rs.getString("original_price"));
                                pay.setTax(rs.getString("tax"));
                                pay.setTotalPrice(rs.getString("total_price"));
                            }
                            updatePay(pay);
                        }
                        if(pay.getOriginalPrice().equals("0")){
                            deletePay(pay.getId(),"");
                        }
                    }
                }else{
                    Pay newPay = new Pay();
                    ResultSet rs = queryTax(order1.getId());
                    while(rs.next()){
                        newPay.setOriginalPrice(rs.getString("original_price"));
                        newPay.setTax(rs.getString("tax"));
                        newPay.setTotalPrice(rs.getString("total_price"));
                    }
                    newPay.setStatus(0);
                    newPay.setOrderId(order1.getId());
                    newPay.setCardNumber("");
                    newPay.setOwnerName("");
                    newPay.setVerificationCode("");
                    newPay.setAddress("");
                    insertPay(newPay);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Pay.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private ResultSet queryTax(Integer orderId){
    
        connection = DB_INFO.getConnection();
        ResultSet rs = null;
        PreparedStatement ps;                              
        String query = "SELECT IFNULL(SUM(d.total),0) as original_price, IFNULL(SUM(d.total*IFNULL(c.tax_rate,0))/100,0) as tax, IFNULL(SUM(d.total)+SUM(d.total*IFNULL(c.tax_rate,0))/100,0) as total_price\n" +
"FROM order_detail d \n" +
"LEFT JOIN product p ON p.id = d.product_id\n" +
"LEFT JOIN category c ON c.id = p.category_id\n" +
"WHERE d.order_id = ?;";

        try {
            ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setInt(1, orderId);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Pay.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    } 
    
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


}
