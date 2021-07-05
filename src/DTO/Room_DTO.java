/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author vnngu
 */
public class Room_DTO extends DBConnection{
    private int Room_ID;
    private int Seats;

    public Room_DTO(int Room_ID, int Seats) {
        this.Room_ID = Room_ID;
        this.Seats = Seats;
    }

    public Room_DTO() {
    }

    public int getRoom_ID() {
        return Room_ID;
    }

    public void setRoom_ID(int Room_ID) {
        this.Room_ID = Room_ID;
    }

    public int getSeats() {
        return Seats;
    }

    public void setSeats(int Seats) {
        this.Seats = Seats;
    }
        public Vector<Room_DTO> Display(String sql){
        Vector<Room_DTO> vector = new Vector<>();
        ResultSet rs = null;
       try {
            Connection conn = getConnectionManager();
            Statement stmt =  conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Room_DTO room = new Room_DTO();
                room.setRoom_ID(rs.getInt(1));
                room.setSeats(rs.getInt(2));  
                vector.add(room);
            }
            System.out.println("Ket noi thanh cong");
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Loi Ket noi");
            
        }
        return  vector;
    }
}
