/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.CallableStatement;
import java.sql.Connection;

/**
 *
 * @author vnngu
 */
public class Customer_DTO extends DBConnection{
    private int id;
    private String name;
    private int member;
    private int point;

    public Customer_DTO() {
    }

    public Customer_DTO(int id, String name, int member,int point) {
        this.id = id;
        this.name = name;
        this.member = member;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    
    public boolean insertCus(){
        String sql = "{call InsertCustomer(?,?,?,?)}";
        
        try{
            Connection conn = getConnectionManager();
            CallableStatement ps = conn.prepareCall(sql);
            ps.setInt(1,id);
            ps.setString(2, name);
            ps.setInt(3, 0);
            ps.setInt(4,0 );
            if(ps.executeUpdate()>0){
                conn.close();
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    
    public boolean deleteCus(){
        String sql = "{call DeleteCustomer(?)}";
        try{
            Connection conn = getConnectionManager();
            CallableStatement ps = conn.prepareCall(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            conn.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    
    public boolean updateCus(){
        String sql = "{call UpdateCustomer(?,?,?,?)}";
        try{
            Connection conn = getConnectionManager();
            CallableStatement ps = conn.prepareCall(sql);
            ps.setInt(1,id);
            ps.setString(2, name);
            ps.setInt(3, member);
            ps.setInt(4, point);
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
