package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBconnect {
    
    private static final String URL = "jdbc:mysql://localhost:3306/banco_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "";
    
    
    public static Connection conectar(){
        
        try{
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            return con;       
        }catch(Exception e){      
        } 
        return (null);        
    }       
}