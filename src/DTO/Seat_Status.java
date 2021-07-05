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

/**
 *
 * @author vnngu
 */
public class Seat_Status extends DBConnection{
    private int IDRoom;
    private int IDSeat;
    private String rowString;
    private int number;
    private int Status;
    public Seat_Status() {
    }
    public Seat_Status(Seat_Status ss) {
        this.IDRoom = ss.IDRoom;
        this.IDSeat = ss.IDSeat;
        this.rowString = ss.rowString;
        this.number = ss.number;
        this.Status = ss.Status;
    }
    public Seat_Status(int IDRoom,int IDSeat, String rowString, int number, int Status) {
        this.IDRoom = IDRoom;
        this.IDSeat = IDSeat;
        this.rowString = rowString;
        this.number = number;
        this.Status = Status;
    }
    
    public int getIDSeat() {
        return IDSeat;
    }

    public void setIDSeat(int IDSeat) {
        this.IDSeat = IDSeat;
    }
    
    public int getIDRoom() {
        return IDRoom;
    }

    public void setIDRoom(int IDRoom) {
        this.IDRoom = IDRoom;
    }

    public String getRowString() {
        return rowString;
    }

    public void setRowString(String rowString) {
        this.rowString = rowString;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
    
   
    
    public boolean updateMovie(int idseat,int i){
        Status = i;
        String sql = "UPDATE SEAT_STATUS set "
                + "Status = ? where IDSEAT_STATUS=?";
        try{
            Connection conn = getConnectionManager();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,IDSeat);
            ps.setInt(2, Status);
            
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
