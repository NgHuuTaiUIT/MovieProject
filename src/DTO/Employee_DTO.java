/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import  java.sql.CallableStatement;
import java.sql.Date;
/**
 *
 * @author vnngu
 */
public class Employee_DTO extends DBConnection{
    private int emp_id;
    private String emp_name;
    private Date emp_date;
    private String emp_username;
    private String emp_pass;
    private String emp_role;

    public Employee_DTO() {
    }

    public Employee_DTO(int emp_id, String emp_name, Date emp_date, String emp_username, String emp_pass, String emp_role) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_date = emp_date;
        this.emp_username = emp_username;
        this.emp_pass = emp_pass;
        this.emp_role = emp_role;
    }

    public String getEmp_role() {
        return emp_role;
    }

    public void setEmp_role(String emp_role) {
        this.emp_role = emp_role;
    }
    
    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public Date getEmp_date() {
        return emp_date;
    }

    public void setEmp_date(Date emp_date) {
        this.emp_date = emp_date;
    }



    public String getEmp_name() {
        return emp_name;
    }

    public String getEmp_username() {
        return emp_username;
    }

    public String getEmp_pass() {
        return emp_pass;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public void setEmp_username(String emp_username) {
        this.emp_username = emp_username;
    }

    public void setEmp_pass(String emp_pass) {
        this.emp_pass = emp_pass;
    }
    public Vector<Employee_DTO> Display(){
        Vector<Employee_DTO> vector = new Vector<>();
        ResultSet rs = null;
        DBConnection conn = new DBConnection();
       try {
            //Connection conn = getConnectionManager();
            Statement stmt =  conn.con.createStatement();
            //rs = stmt.executeQuery("Select * from Staff");
            rs = conn.getData("Select * from Staff");
            while (rs.next()) {
                Employee_DTO emp = new Employee_DTO();
                emp.emp_id = rs.getInt(1);
                emp.emp_name = rs.getString(2);
                emp.emp_date = rs.getDate(3);
                emp.emp_username = rs.getString(4);
                emp.emp_pass = rs.getString(5);
                emp.emp_role = rs.getString(6);
                vector.add(emp);
            }
            System.out.println("Ket noi thanh cong");
            conn.con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Loi Ket noi");
            
        }
        return  vector;
    }
    
            public boolean insertStaff(){
        String sql = "{call InsertStaff(?,?,?,?,?,?)}";
        
        try{
            Connection conn = getConnectionManager();
            CallableStatement ps = conn.prepareCall(sql);
            ps.setInt(1,emp_id);
            ps.setString(2, emp_name);
            ps.setDate(3, emp_date);
            ps.setString(4, emp_username);
            ps.setString(5, emp_pass);
            ps.setString(6, emp_role);
            if(ps.executeUpdate()>0){
                conn.close();
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    
    public boolean deleteStaff(){
        String sql = "{call DeleteStaff(?)}";
        try{
            Connection conn = getConnectionManager();
            CallableStatement ps = conn.prepareCall(sql);
            ps.setInt(1, emp_id);
            ps.executeUpdate();
            conn.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    
    public boolean updateStaff(){
        String sql = "{call UpdateStaff(?,?,?,?,?,?)}";
        try{
            Connection conn = getConnectionManager();
            CallableStatement ps = conn.prepareCall(sql);
            ps.setInt(1,emp_id);
            ps.setString(2, emp_name);
            ps.setDate(3, emp_date);
            ps.setString(4, emp_username);
            ps.setString(5, emp_pass);
            ps.setString(6, emp_role);
            if( ps.executeUpdate()>0){
                conn.close();
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
