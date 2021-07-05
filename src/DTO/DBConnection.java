/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vnngu
 */
public class DBConnection {
    public Connection con;
    public DBConnection() {
            con = getConnectionStaff();
    }
    
//    public static Connection getConnectionManager() {
//       
//        
//        try {
//            Connection conn = null;
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=SQLCinema;instance=SQLEXPRESS;encrypt=true;TrustServerCertificate=true;";
//            String user = "sa";
//            String pass = "12345";
//            conn = DriverManager.getConnectionManager(URL ,user,pass);
////            System.out.println("connect successfully!");
//            System.out.println(" Ket noi thanh cong");
//            return conn;
//        } catch (Exception ex) {
////            System.out.println("connect failure!");
////            ex.printStackTrace();
//            System.out.println(" Ket noi k cong");
//        }
//        return null;
//    } 
    public Connection getConnectionManager() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            String dbURL = "jdbc:oracle:thin:@localhost:1521/orcl";
            String username = "C##usersql";
            String password = "userpass";
            con = DriverManager.getConnection(dbURL, username, password);
            System.out.println("Connection Success!");
            return con;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public Connection getConnectionStaff() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            String dbURL = "jdbc:oracle:thin:@localhost:1521/week3";
            String username = "studentdb";
            String password = "1";
            con = DriverManager.getConnection(dbURL, username, password);
            System.out.println("Connection Success!");
            return con;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public ResultSet getData(String sql){
        try{
        Statement stat = con.createStatement();
        ResultSet rs = stat.executeQuery(sql);
            System.out.println("Get Data Success!");
        return rs;
        }catch(SQLException e){
            System.out.println("Loi ket noi");
            e.printStackTrace();
        }
        return null;
    }
    
    public void CloseConnection(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
//    public ResultSet getData(String sql){
//        ResultSet rs = null;
//         try {
//             sql = "Select * from Movie";
//             getConnectionManager();
//            Statement stmt = conn.createStatement();
//            rs = stmt.executeQuery(sql);
//            return rs;
//            //System.out.println(" Ket noi thanh cong");
//            conn.close();
//        } catch (Exception ex) {
//            System.out.println("Loi Ket noi");
//            
//        }final() {
//        conn.close();
//        }
//        return null;
//    }
    
    
//    
//    public static void main(String[] args) {
//        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=SQLCinema;instance=SQLEXPRESS;encrypt=true;TrustServerCertificate=true;";
//        String user = "sa";
//        String pass = "12345";
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Connection conn = DriverManager.getConnectionManager(dbURL ,user,pass);
//            System.out.println("connect successfully!");
//        } catch (Exception ex) {
//            System.out.println("connect failure!");
//            ex.printStackTrace();
//        }
//    }
}
