/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ruishang
 */
public class DB_INFO {
    private static String dbname = "INFO5100";
    private static String username = "root";
    private static String password = "INFO5100@group";
    
    static Connection con=null;
    public static Connection getConnection()
    {
        if (con != null) return con;
        // get db, user, pass from settings file
        return getConnection(dbname, username, password);
    }

    private static Connection getConnection(String db_name,String user_name,String password)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://47.116.141.178:3306/"+db_name+"?useSSL=false", user_name, password);
            System.out.println("connected");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return con; 
    }
}
