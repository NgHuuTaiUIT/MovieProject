/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import java.sql.Connection;
import  java.sql.Date;
import java.sql.PreparedStatement;
import  java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.CallableStatement;
import static oracle.jdbc.OracleTypes.NULL;
import oracle.jdbc.internal.OracleTypes;
/**
 *
 * @author vnngu
 */
public class Bill {
   private int Bill_id;
    private int Staff_id;
    private int Cus_id;
    private Date date;
    private int Price;
    private int ShowTime_id;

    public Bill() {

    }

    public Bill(int Bill_id, int Staff_id, Date date, int Price, int ShowTime_id) {
        this.Bill_id = Bill_id;
        this.Staff_id = Staff_id;
        this.date = date;
        this.Price = Price;
        this.ShowTime_id = ShowTime_id;
    }

    public int getBill_id() {
        return Bill_id;
    }

    public void setBill_id(int Bill_id) {
        this.Bill_id = Bill_id;
    }

    public int getStaff_id() {
        return Staff_id;
    }

    public void setStaff_id(int Staff_id) {
        this.Staff_id = Staff_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getShowTime_id() {
        return ShowTime_id;
    }

    public void setShowTime_id(int ShowTime_id) {
        this.ShowTime_id = ShowTime_id;
    }

    public int getCus_id() {
        return Cus_id;
    }

    public void setCus_id(int Cus_id) {
        this.Cus_id = Cus_id;
    }
    
      public boolean insertBill(int Staff_id,int cus_id, Date date, int Price, int ShowTime_id){
          
//        String sql = "INSERT INTO Bill(Bill_id,STAFF_ID,CUS_ID,DATE_BILL,PRICE,SHOWTIME_ID) "
//                + "VALUES(?,?,?,?,?,?)";
        Connection conn = new DBConnection().getConnectionManager();
       
             CallableStatement ps;
        try {
            ps = conn.prepareCall("{call InsertBill (?,?,?,?,?)}");
            //ps.setInt(1, bill_id);
            ps.setInt(1, ShowTime_id);
            ps.setInt(2, Staff_id);
            if(cus_id!=0)
                ps.setInt(3,cus_id);
            else
                ps.setNull(3, OracleTypes.NULL);
            ps.setDate(4, date);
            ps.setInt(5, Price);
            if(ps.executeUpdate()>0){
                conn.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);           
            try {
                conn.close();
            } catch (SQLException ex1) {
                Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
            //PreparedStatement ps = conn.prepareStatement(sql);
        return false;
    }
    
}
