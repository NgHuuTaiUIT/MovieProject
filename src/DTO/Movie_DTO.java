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
import java.util.Vector;
import java.sql.PreparedStatement;

/**
 *
 * @author vnngu
 */
public class Movie_DTO extends  DBConnection {
//    DBConnection conn = new DBConnection();
    public  int ID;
    public String movie_name;
    public String movie_type;
    public int duration_min;
    public String movie_age;

    public Movie_DTO() {
    }

    public Movie_DTO( int id,String movie_name, String movie_type, int movie_hour, String movie_age) {
        this.movie_name = movie_name;
        this.ID = id;
        this.duration_min = movie_hour;
        //this.movie_languae = movie_languae;
        this.movie_type = movie_type;
        this.movie_age = movie_age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
     
    public String getMovie_age() {
        return movie_age;
    }

    public void setMovie_age(String movie_age) {
        this.movie_age = movie_age;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public int getDuration_min() {
        return duration_min;
    }


    public String getMovie_type() {
        return movie_type;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }


    public void setDuration_min(int movie_hour) {
        this.duration_min = movie_hour;
    }


    public void setMovie_type(String movie_type) {
        this.movie_type = movie_type;
    }

    
    public Vector<Movie_DTO> Display(String sql){
        Vector<Movie_DTO> vector = new Vector<>();
        ResultSet rs = null;
       try {
            Connection conn = getConnectionManager();
            Statement stmt =  conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Movie_DTO mvDTO = new Movie_DTO();
                mvDTO.ID = rs.getInt(1);
                mvDTO.movie_name = rs.getString(2);
                mvDTO.movie_type = rs.getString(3);
                mvDTO.movie_age = rs.getString(5);
                mvDTO.duration_min = rs.getInt(4);
                vector.add(mvDTO);
            }
            System.out.println("Ket noi thanh cong");
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            new Error("Loi Ket noi");  
        }
        return  vector;
    }
    
        public boolean insertMovie(int id, String mv_name, String mv_type, int duration, String mv_age){
//        String sql = "INSERT INTO movie(ID, MOVIE_NAME, MOVIE_TYPE, MOVIE_DURATION, MOVIE_AGE) "
//                + "VALUES(?,?,?,?,?)";
         Connection conn = getConnectionManager();
        try{
           
             CallableStatement ps  = conn.prepareCall("{call InsertMovie(?,?,?,?,?)}");
            ps.setInt(1,id);
            ps.setString(2, mv_name);
            ps.setString(3, mv_type);
            ps.setInt(4, duration);
            ps.setString(5, mv_age);
            if(ps.executeUpdate()>0){
                conn.close();
                new Success("Insert Success!");
                return true;
            }
        }catch(Exception e){
            new ErrorGUI("Insert Fail!");
            e.printStackTrace();
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Movie_DTO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    
    public boolean deleteMovie(int id){
        String sql = "{call DeleteMovie(?)}";
        Connection conn = getConnectionManager();
        try{
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            conn.close();
            new Success("Delete Success!");
            return true;
        }catch(Exception e){
            new ErrorGUI("Delete Fail!");
            e.printStackTrace();
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Movie_DTO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    
    public boolean updateMovie(int id, String mv_name, String mv_type, int duration, String mv_age){
        String sql = "{call UpdateMovie(?,?,?,?,?)}";
        Connection conn = getConnectionManager();
        try{
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2, mv_name);
            ps.setString(3, mv_type);
            ps.setInt(4, duration);
            ps.setString(5, mv_age);
            
            if( ps.executeUpdate()>0){
                new Success("Update Success!");
                conn.close();
                return true;
            }
        }catch(Exception e){
            new ErrorGUI("Upadte Fail!");
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Movie_DTO.class.getName()).log(Level.SEVERE, null, ex);
            }
            e.printStackTrace();
        }
        return false;
    }
    
}

    
