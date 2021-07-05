    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import GUI.ErrorGUI;
import GUI.Success;
import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Vector;

/**
 *
 * @author vnngu
 */
public class ShowTime_DTO extends  DBConnection {
//    DBConnection conn = new DBConnection();
    public  int ID;
    public  int ID_Movie;
    public  int ID_Room;
//    public  Timestamp Time_Start;
//    public Timestamp Time_End;
    private String Time_Start;
    private String Time_End;
    public int Cost;
    private Date ST_Date;
  
    public  ShowTime_DTO(){
        
    }

    public ShowTime_DTO(int ID, int ID_Movie, int ID_Room, String Time_Start,String Time_End,int cost, Date date) {
        this.ID = ID;
        this.ID_Movie = ID_Movie;
        this.ID_Room = ID_Room;
//       this.Time_Start = Time_Start;
//        this.Time_End = Time_End;
        this.Time_Start = Time_Start;
        this.Time_End = Time_End;
        this.Cost = cost;
        this.ST_Date = date;
    }

    public ShowTime_DTO(ShowTime_DTO emp) {
        this.ID = emp.ID;
        this.ID_Movie = emp.ID_Movie;
        this.ID_Room = emp.ID_Room;
//       this.Time_Start = Time_Start;
//        this.Time_End = Time_End;
        this.Time_Start = emp.Time_Start;
        this.Time_End = emp.Time_End;
        this.Cost = emp.Cost;
        this.ST_Date = emp.ST_Date;
    }

    public Date getST_Date() {
        return ST_Date;
    }

    public void setST_Date(Date ST_Date) {
        this.ST_Date = ST_Date;
    }
    
    public int getCost() {
        return Cost;
    }

    public void setCost(int Cost) {
        this.Cost = Cost;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_Movie() {
        return ID_Movie;
    }

    public void setID_Movie(int ID_Movie) {
        this.ID_Movie = ID_Movie;
    }

    public int getID_Room() {
        return ID_Room;
    }

    public void setID_Room(int ID_Room) {
        this.ID_Room = ID_Room;
    }

    public String getTime_Start() {
        return Time_Start;
    }

    public void setTime_Start(String Time_Start) {
        this.Time_Start = Time_Start;
    }

    public void setTime_End(String Time_End) {
        this.Time_End = Time_End;
    }

    public String getTime_End() {
        return Time_End;
    }


    
  
    public Vector<ShowTime_DTO> Display(String sql){
        Vector<ShowTime_DTO> vector = new Vector<>();
        ResultSet rs = null;
        Connection conn = getConnectionManager();
       try {
            
            Statement stmt =  conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                ShowTime_DTO st = new ShowTime_DTO();
                st.ID = rs.getInt(1);
                st.ID_Movie = rs.getInt(2);
                st.ID_Room = rs.getInt(3);
//                st.Time_Start = rs.getTimestamp(4);
//                st.Time_End = rs.getTimestamp(6);
                st.Time_Start = rs.getString(4);
                st.Time_End = rs.getString(6);
                st.Cost = rs.getInt(5);
                st.ST_Date = rs.getDate(7);
                vector.add(st);
            }
            System.out.println("Ket noi thanh cong");
            conn.close();
        } catch (SQLException ex) {
            try {
                conn.close();
            } catch (SQLException ex1) {
                Logger.getLogger(ShowTime_DTO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            ex.printStackTrace();
            System.out.println("Loi Ket noi");
            
        }
        return  vector;
    }
    
     public ResultSet Data(String sql){
                ResultSet rs = null;
                Connection conn = getConnectionManager();
       try {
            //Connection conn = getConnectionManager();
            Statement stmt =  conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println("Ket noi thanh cong");
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Loi Ket noi"); 
        }
        return  null;
     }
    public boolean insertShowtime(int id, int movie_id, int room_id, String time_start, String time_end, int cost, Date datest){
        Connection conn = getConnectionManager();
        try{
            
            CallableStatement ps  = conn.prepareCall("{call InsertShowtime(?,?,?,?,?,?,?)}");
            ps.setInt(1, id);
            ps.setInt(2, movie_id);
            ps.setInt(3, room_id);
           // ps.setTimestamp(4, time_start);
           ps.setString(4, time_start);
            
            ps.setString(5, time_end);
            ps.setDate(6, datest);
            ps.setInt(7, cost);
            if(ps.executeUpdate()>0){
                new Success("Insert Success!");
                conn.close();
                return true;
            }else conn.close();
        }catch(Exception e){
            new ErrorGUI("Insert Fail!");
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ShowTime_DTO.class.getName()).log(Level.SEVERE, null, ex);
            }
            e.printStackTrace();
        }
        return false;
    }
    
    
    public boolean deleteShowtime(int id){
        String sql = "{call DeleteShowtime(?)}";
        Connection conn = getConnectionManager();
        try{
            
            CallableStatement ps = conn.prepareCall(sql);
            ps.setInt(1, id);
            if(ps.executeUpdate()>0){
                new Success("Delete Success!");
                conn.close();
                return true;
            }else conn.close();
        }catch(Exception e){
            new ErrorGUI("Delete Fail!");
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ShowTime_DTO.class.getName()).log(Level.SEVERE, null, ex);
            }
            e.printStackTrace();
        }
        return false;
    }
    
    
    public boolean updateShowtime(int id, int movie_id, int room_id, String time_start, String time_end, int cost, Date datest){
        String sql = "{call UpdateShowtime(?,?,?,?,?,?,?)}";
        Connection conn = getConnectionManager();
        try{
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setInt(2, movie_id);
            ps.setInt(3, room_id);
            ps.setString(4, time_start);
            ps.setInt(7, cost);
            ps.setDate(6, datest);
            ps.setString(5, time_end);
            if( ps.executeUpdate()>0){
                new Success("Update Success!");
                conn.close();
                return true;
            }
        }catch(Exception e){
            new ErrorGUI("Update Fail!");
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ShowTime_DTO.class.getName()).log(Level.SEVERE, null, ex);
            }
            e.printStackTrace();
        }
        return false;
    }
}

    
