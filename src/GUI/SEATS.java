/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.DBConnection;
import DTO.Movie_DTO;
import DTO.Seat_Status;
import DTO.ShowTime_DTO;
import DTO.Ticket_DTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author nguyenphu
 */
public class SEATS extends javax.swing.JFrame {

    /**
     * Creates new form SEATS
     */
    ShowTime_DTO st;
    Movie_DTO mv;
    Vector<Seat_Status> liSeat_Statuses = new Vector<>();
    Vector<Seat_Status> Cacnutvuamoichon = new Vector<>();
    Vector<Seat_Status> listSeatChooseAdult = new Vector<>();
    Vector<Seat_Status> listSeatChooseChild = new Vector<>();
    Vector<Seat_Status> listSeatBooked = new Vector<>();
    Vector<JLabel> listlabelseatschooseAdult = new Vector<>();
    Vector<JLabel> listlabelseatschooseChild = new Vector<>();
    boolean check = false;
    JLabel lblTotalPrice;
    JPanel guimv ;
    Vector<Seat_Status> listSeatChooseReturn;
    public SEATS() {
        initComponents();
        //setVisible(true);
    }
    public SEATS(JPanel pnCart,JLabel lb,ShowTime_DTO st,Movie_DTO Movie, Vector<Seat_Status> listseatchoose) {
        this.listSeatChooseReturn = listseatchoose;
        this.st =st;
        this.mv = Movie;
        this.guimv= pnCart;
        this.lblTotalPrice =lb;
        System.out.println(st.ID);
        initComponents();
        LoadSeats();
    }
    Ticket_DTO tkc;
    public SEATS(JPanel pnCart,JLabel lb,ShowTime_DTO st,Ticket_DTO tkc,Movie_DTO Movie, Vector<Seat_Status> listseatchoose) {
        this.listSeatChooseReturn = listseatchoose;
        this.st =st;
        this.mv = Movie;
        this.guimv= pnCart;
        this.lblTotalPrice =lb;
        this.tkc = new Ticket_DTO(tkc);
        if(tkc.getTicket_Type().compareTo("Adult") == 0)
            adultprice = tkc.getPrice();
        else
            childprice = tkc.getPrice();
        System.out.println(st.ID);
        initComponents();
        LoadSeats();
    }
    int adultprice = 0, childprice = 0;

    public Vector<Seat_Status> getListSeatChooseAdult() {
        return listSeatChooseAdult;
    }

    public void setListSeatChooseAdult(Vector<Seat_Status> listSeatChooseAdult) {
        this.listSeatChooseAdult = listSeatChooseAdult;
    }

    public Vector<Seat_Status> getListSeatChooseChild() {
        return listSeatChooseChild;
    }

    public void setListSeatChooseChild(Vector<Seat_Status> listSeatChooseChild) {
        this.listSeatChooseChild = listSeatChooseChild;
    }
    
    public void setTkc(Ticket_DTO tkc) {
        this.tkc = new Ticket_DTO(tkc);
        if(tkc.getTicket_Type().compareTo("Adult") == 0)
            adultprice = tkc.getPrice();
        else
            childprice = tkc.getPrice();
    }
    
    
    Vector<JButton> listbtn = new Vector<>();
    Vector<JButton> Cacghehuy = new Vector<>();
    Vector<Seat_Status> thongtincacghehuy = new Vector<>();
    Vector<Integer> vitricacghedachon = new Vector<>();
    public void LoadSeats(){
        DBConnection con = new DBConnection();
        String sql = "Select r.idroom,ss.idseat_status,s.row_seat,"
                    + "s.number_seat,ss.status\n" 
                    + "from Showtime st, Room r, seat s, seat_status ss\n" 
                    + "where st.room_id = r.idroom "
                    + "and s.idroom = r.idroom and ss.id_showtime = st.id "
                    + "and ss.id_seat = s.idseat and st.id = "+ st.getID();
        System.out.println(sql);
        ResultSet rs = con.getData(sql);

        try {
            while(rs.next()){
                Seat_Status ss = new Seat_Status(rs.getInt("IDRoom"),
                        rs.getInt("IDSeat_status"), rs.getString("Row_Seat"),
                        rs.getInt("Number_seat"),rs.getInt("Status"));
                liSeat_Statuses.add(ss);
                String name_seat = rs.getString("Row_Seat")
                        + rs.getString("Number_seat");
                JButton btn = new JButton(name_seat);
                btn.setFont(new Font("Tahoma", 1, 18));
                btn.setForeground(new Color(240, 240, 240));
                btn.setIcon(new ImageIcon(getClass().getResource("/GUI/Image/Seat.png")));
                btn.setHorizontalTextPosition((int)CENTER_ALIGNMENT);
                //btn.setOpaque(false);
                if(rs.getInt("Status") == 1)
                    btn.setBackground(Color.RED);
                else if(rs.getInt("Status") == -1)
                    btn.setBackground(Color.DARK_GRAY);
                else
                    btn.setBackground(Color.GRAY);
                listbtn.add(btn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SEATS.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.CloseConnection();
            if(listbtn.isEmpty()) System.out.println("Khong co nut nao!");
            
            for (int i = 0; i < listbtn.size(); i++) {
                int index = i;
                listbtn.get(i).addActionListener((ActionEvent e)->{
//                    for (ActionListener act : listbtn.get(index).getActionListeners()) {
//                        listbtn.get(index).removeActionListener(act);
//                    }
                    if(listbtn.get(index).getBackground() == Color.RED)
                        new ErrorGUI("Ghe da co nguoi chon");
                    else if(listbtn.get(index).getBackground() == Color.BLUE){
                        Cacghehuy.add(listbtn.get(index));
                        
                            listSeatChooseAdult.remove(liSeat_Statuses.get(index));
                            listSeatChooseChild.remove(liSeat_Statuses.get(index));
                            if(!Cacnutvuamoichon.isEmpty()){
                                Cacnutvuamoichon.remove(liSeat_Statuses.get(index));
                            }
                        listbtn.get(index).setBackground(Color.GRAY);
                    }else{
//                        if(tkc.getTicket_Type().compareTo("ADULT") == 0)
//                            listSeatChooseAdult.add(liSeat_Statuses.get(index));
//                        else 
//                            listSeatChooseChild.add(liSeat_Statuses.get(index));
                        vitricacghedachon.add(index);
                        Cacnutvuamoichon.add(liSeat_Statuses.get(index));
                        listbtn.get(index).setBackground(Color.BLUE);
                    }
                });
            pnlSeat.add(listbtn.get(i));  
            }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnlSeat = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnAccept = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(102, 121, 125));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlSeat.setBackground(new java.awt.Color(102, 121, 125));
        pnlSeat.setLayout(new java.awt.GridLayout(6, 5, 5, 5));
        jPanel1.add(pnlSeat, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 590, 410));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Screen");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 210, 40));

        btnCancel.setBackground(new java.awt.Color(102, 121, 125));
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/Error.png"))); // NOI18N
        btnCancel.setBorderPainted(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 490, 120, 80));

        btnAccept.setBackground(new java.awt.Color(102, 121, 125));
        btnAccept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/5ed0950282001_1.png"))); // NOI18N
        btnAccept.setBorderPainted(false);
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });
        jPanel1.add(btnAccept, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 130, 80));

        jLabel1.setBackground(new java.awt.Color(255, 153, 0));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 290, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
       int y =125;
       static int gety = 0;
        JLabel btnMovie;

    public JLabel getBtnMovie() {
        return btnMovie;
    }
    JLabel lbRoom;

    public JLabel getLbRoom() {
        return lbRoom;
    }
    

    public Vector<JLabel> getListlabelseatschoose() {
        return listlabelseatschooseAdult;
    }
    private void LoadSeatsAdult(){
        listlabelseatschooseAdult.clear();    
        if(!listSeatChooseAdult.isEmpty()){
                           
            for (Seat_Status i : listSeatChooseAdult) {
                String str = "Adult Seat: " + i.getRowString()+i.getNumber();
                System.out.println(str);
                JLabel lb1 = new JLabel(str);
                   lb1.setFont(new Font("Tahoma", 1, 18));
                   lb1.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                   lb1.setForeground(new Color(255,255,255));
                   lb1.setOpaque(true);
                   lb1.setBackground(new Color(255, 133, 10));
                   listlabelseatschooseAdult.add(lb1);
                   Seat_Status sstemp = new Seat_Status(i);
                   listSeatChooseReturn.add(sstemp);
            }
        }
            
    }
    private void LoadSeatsChild(){
        listlabelseatschooseChild.clear();     
        if(!listSeatChooseChild.isEmpty()){
                          
            for (Seat_Status i : listSeatChooseChild) {
                String str = "Child Seat: " + i.getRowString()+i.getNumber();
                System.out.println(str);
                JLabel lb1 = new JLabel(str);
                   lb1.setFont(new Font("Tahoma", 1, 18));
                   lb1.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                   lb1.setForeground(new Color(255,255,255));
                   lb1.setOpaque(true);
                   lb1.setBackground(new Color(53, 216, 147));
                   listlabelseatschooseChild.add(lb1);
                   Seat_Status sstemp = new Seat_Status(i);
                   listSeatChooseReturn.add(sstemp);
            }

        }
            
    }
    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed

        //set label
//        if(!listSeatChooseAdult.isEmpty()){
//                   btnMovie = new JLabel(mv.getMovie_name());
//                   btnMovie.setFont(new Font("Tahoma", 1, 18));
//                   btnMovie.setForeground(new Color(95,95,95));
//                   btnMovie.setBackground(new Color(233, 233, 233));
//                   guimv.add(btnMovie, new AbsoluteConstraints(0, 0, 310, 100));
////                   Timestamp timestamp = st.getTime_Start();
////                    Time timestart = new Time(st.getTime_Start().getTime());
////                    Time timeend = new Time(st.getTime_End().getTime());
//                    //timeend.setMinutes(timeend.getMinutes()+ mv.getDuration_min());
////                    String timeEnd = timeend.toString();
////                    String timeStart = timestart.toString();
////                   String nameroom = "Room: " + String.valueOf(st.getID_Room()) 
////                           +"    Time:" + timeStart.substring(0,5) 
////                           + "-" + timeEnd.substring(0,5);
//                    String nameroom= "Room: " + String.valueOf(st.getID_Room()) 
//                           +"    Time:" + st.getTime_Start()
//                           + "-" + st.getTime_End();
//                   lbRoom = new JLabel(nameroom, (int) CENTER_ALIGNMENT);
//                   lbRoom.setFont(new Font("Tahoma", 1, 18));
//                   lbRoom.setForeground(new Color(95,95,95));
//                   lbRoom.setBackground(new Color(34, 34, 34));
//                   lbRoom.setOpaque(true);
//                guimv.add(lbRoom, new AbsoluteConstraints(0, 105, 310, 70));
//                listlabelseatschooseAdult.clear();               
//            for (Seat_Status i : listSeatChooseAdult) {
//                //listSeatBooked.add(i);
//                    
//                //String str = "Adutl Seat: " + i.getRowString()+i.getNumber();
//                String str = tkc.getTicket_Type() + " Seat: " + i.getRowString()+i.getNumber();
//                System.out.println(str);
//                JLabel lb1 = new JLabel(str);
//                   lb1.setFont(new Font("Tahoma", 1, 18));
//                   lb1.setHorizontalAlignment((int) CENTER_ALIGNMENT);
//                   lb1.setForeground(new Color(95,95,95));
//                   lb1.setOpaque(true);
//                   lb1.setBackground(new Color(255, 153, 31));
//                   listlabelseatschooseAdult.add(lb1);
//                   Seat_Status sstemp = new Seat_Status(i);
//                   listSeatChooseReturn.add(sstemp);
//            }
//
//            //them label vao panel cart
//            int total= 0;
//            for (int i = 0; i < listlabelseatschooseAdult.size(); i++) {
//                if(i >= 12) guimv.setPreferredSize(new Dimension(guimv.getPreferredSize().width, guimv.getPreferredSize().width+50));
////                    total+=st.getCost();
//                    total+=tkc.getPrice();
//                    guimv.add(listlabelseatschooseAdult.get(i),new AbsoluteConstraints(20, y+(i+1)*55, 270, 50));
//            }
//            String totalstr = String.valueOf(total);
//            lblTotalPrice.setText(totalstr);
//            Success sc = new Success("Đặt ghế thành công");
//        }
        
        int countseats = 0,total = 0;
        if(tkc.getTicket_Type().compareTo("Adult") == 0){
            for (Seat_Status item : Cacnutvuamoichon) {
                listSeatChooseAdult.add(item);
            }
        }        
        else{ 
            for (Seat_Status item : Cacnutvuamoichon) {
                listSeatChooseChild.add(item);
            }
        }
        
        if(!listSeatChooseAdult.isEmpty() || !listSeatChooseChild.isEmpty()){
                               btnMovie = new JLabel("    "+mv.getMovie_name());
                   btnMovie.setFont(new Font("Tahoma", 1, 30));
                   btnMovie.setForeground(new Color(255, 133, 10));
                   btnMovie.setOpaque(true);
                   btnMovie.setBackground(new Color(22, 25, 26));
                   guimv.add(btnMovie, new AbsoluteConstraints(0, 0, 310, 100));
//                   Timestamp timestamp = st.getTime_Start();
//                    Time timestart = new Time(st.getTime_Start().getTime());
//                    Time timeend = new Time(st.getTime_End().getTime());
                    //timeend.setMinutes(timeend.getMinutes()+ mv.getDuration_min());
//                    String timeEnd = timeend.toString();
//                    String timeStart = timestart.toString();
//                   String nameroom = "Room: " + String.valueOf(st.getID_Room()) 
//                           +"    Time:" + timeStart.substring(0,5) 
//                           + "-" + timeEnd.substring(0,5);
                    String nameroom= "Room: " + String.valueOf(st.getID_Room()) 
                           +"    Time:" + st.getTime_Start()
                           + "-" + st.getTime_End();
                   lbRoom = new JLabel(nameroom, (int) CENTER_ALIGNMENT);
                   lbRoom.setFont(new Font("Tahoma", 1, 18));
                   lbRoom.setForeground(new Color(255,255,255));
                   lbRoom.setBackground(new Color(22, 25, 26));
                   lbRoom.setOpaque(true);
                guimv.add(lbRoom, new AbsoluteConstraints(0, 105, 310, 70));
                gety = countseats;
                LoadSeatsAdult();
                for (int i = 0; i < listlabelseatschooseAdult.size(); i++) {
                    countseats++;
                    if(countseats >= 12) guimv.setPreferredSize(new Dimension(guimv.getPreferredSize().width, guimv.getPreferredSize().width+50));
    //                    total+=st.getCost();
                        total += adultprice;
                        guimv.add(listlabelseatschooseAdult.get(i),new AbsoluteConstraints(20, y+(countseats)*55, 270, 50));
                }
                LoadSeatsChild();
                for (int i = 0; i < listlabelseatschooseChild.size(); i++) {
                    countseats++;
                    if(countseats >= 12) guimv.setPreferredSize(new Dimension(guimv.getPreferredSize().width, guimv.getPreferredSize().width+50));
    //                    total+=st.getCost();
                        total += childprice;
                        guimv.add(listlabelseatschooseChild.get(i),new AbsoluteConstraints(20, y+(countseats)*55, 270, 50));
                }
                String totalstr = String.valueOf(total);
            lblTotalPrice.setText(totalstr);
            Success sc = new Success("Đặt ghế thành công");
        }else  lblTotalPrice.setText("0");
        
        Cacnutvuamoichon.clear();
        vitricacghedachon.clear();
        Cacghehuy.clear();
        guimv.setVisible(false);
        guimv.setVisible(true);
        //listSeatChoose.clear();
        this.setVisible(false);
        
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        for (int item : vitricacghedachon) {
            listbtn.get(item).setBackground(Color.GRAY);
        }
        for (JButton item : Cacghehuy) {
            item.setBackground(Color.BLUE);
        }
        vitricacghedachon.clear();
        Cacnutvuamoichon.clear();
        Cacghehuy.clear();
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed
    public boolean isBookingComplete(){
        return check;
    }
    public Vector<Seat_Status> getListSeatChoose(){
        return listSeatBooked;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SEATS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SEATS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SEATS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SEATS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SEATS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel pnlSeat;
    // End of variables declaration//GEN-END:variables
}
