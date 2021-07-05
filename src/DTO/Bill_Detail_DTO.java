/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vnngu
 */
public class Bill_Detail_DTO {
    int ID;
    int Seat_Status_ID;
    int ShowTime_ID;
    int Ticket_id;
    int Price;

    public Bill_Detail_DTO() {
    }

    public Bill_Detail_DTO(int ID, int Seat_Status_ID, int ShowTime_ID, int Price) {
        this.ID = ID;
        this.Seat_Status_ID = Seat_Status_ID;
        this.ShowTime_ID = ShowTime_ID;
        this.Price = Price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSeat_Status_ID() {
        return Seat_Status_ID;
    }

    public void setSeat_Status_ID(int Seat_Status_ID) {
        this.Seat_Status_ID = Seat_Status_ID;
    }

    public int getShowTime_ID() {
        return ShowTime_ID;
    }

    public void setShowTime_ID(int ShowTime_ID) {
        this.ShowTime_ID = ShowTime_ID;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getTicket_id() {
        return Ticket_id;
    }

    public void setTicket_id(int Ticket_id) {
        this.Ticket_id = Ticket_id;
    }
    
    public boolean insertBill_Detail(int Bill_id,int Seat_Status_id,int PRICE,int Ticket_ID){

        String sql = "INSERT INTO Bill_detail_seat(Bill_id,Seat_Status_id,PRICE,Ticket_ID) "
                + "VALUES(?,?,?,?)";
        Connection conn = new DBConnection().getConnectionManager();
        try{
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Bill_id);
            ps.setInt(2,Seat_Status_id);
            ps.setInt(3, PRICE);
            ps.setInt(4, Ticket_ID);
            if(ps.executeUpdate()>0){
                conn.close();
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return false;
    }
}
