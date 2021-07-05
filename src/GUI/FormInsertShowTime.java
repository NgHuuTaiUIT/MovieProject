/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Movie_DTO;
import DTO.Room_DTO;
import DTO.ShowTime_DTO;
import java.util.Date;
import java.util.Vector;
import java.sql.Time;

/**
 *
 * @author vnngu
 */
public class FormInsertShowTime extends javax.swing.JFrame {

    /**
     * Creates new form FormInsertShowTime
     */
    Vector<Movie_DTO> listMovie = new Movie_DTO().Display("Select * from Movie");
    Vector<Room_DTO> listRoom = new Room_DTO().Display("Select * from Room");
    ShowTime st;
    public FormInsertShowTime() {
        initComponents();
        for (Movie_DTO item : listMovie) {
            cbMovie.addItem(item.getMovie_name());
        }
        for (Room_DTO item : listRoom) {
            cbRoom.addItem("" + item.getRoom_ID());
        }
    }
    public FormInsertShowTime(ShowTime st) {
        initComponents();
        this.st = st;
        for (Movie_DTO item : listMovie) {
            cbMovie.addItem(item.getMovie_name());
        }
        for (Room_DTO item : listRoom) {
            cbRoom.addItem("" + item.getRoom_ID());
        }
    }    
    
    private boolean CheckShowtime(Date d1,Date d2,int r1, int r2,Time tst1, Time tst2, Time tend1, Time tend2){
        String str1 = d1.toString();
        String str2 = d2.toString();
        if(r1 == r2 && str1.compareTo(str2) == 0){
            if(tst1.after(tst2) && tst1.after(tend2) && tend1.after(tst2) && tend1.after(tend2)){
                return true;
            }
            else if(tst1.before(tst2) && tst1.before(tend2) && tend1.before(tst2) && tend1.before(tend2)){
                return true; 
            }
//        if((tst1.getTime() > tst2.getTime() && tst1.getTime()>tend2.getTime()) 
//               || (tst1.getTime() < tst2.getTime() && tend1.getTime()<tend2.getTime()))
//            return true;
//        else  if((tst1.getTime() > tst2.getTime() && tend1.getTime()>tend2.getTime()) 
//               || (tst1.getTime() < tst2.getTime() && tend1.getTime()<tend2.getTime()))
//            }

        }
        else
            return true;
        return false;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        txtShowtimeID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        cbMovie = new javax.swing.JComboBox<>();
        cbRoom = new javax.swing.JComboBox<>();
        txtTimeStart = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        txtTimeEnd = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        txtCost = new javax.swing.JTextField();
        btnAccept = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        cbtimestarhour = new javax.swing.JComboBox<>();
        cbtimestartminus = new javax.swing.JComboBox<>();
        cbtimeendhour = new javax.swing.JComboBox<>();
        cbtimeendminus = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(36, 47, 65));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Insert Movie");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("ShowTime ID");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Movie");

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));

        txtShowtimeID.setBackground(new java.awt.Color(36, 47, 65));
        txtShowtimeID.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtShowtimeID.setForeground(new java.awt.Color(255, 255, 255));
        txtShowtimeID.setText("Enter  showtime id");
        txtShowtimeID.setBorder(null);
        txtShowtimeID.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtShowtimeID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtShowtimeIDMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("Room");

        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));

        cbMovie.setBackground(new java.awt.Color(36, 47, 65));
        cbMovie.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cbMovie.setForeground(new java.awt.Color(255, 255, 255));
        cbMovie.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cbMovie.setOpaque(false);

        cbRoom.setBackground(new java.awt.Color(36, 47, 65));
        cbRoom.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        txtTimeStart.setBackground(new java.awt.Color(36, 47, 65));
        txtTimeStart.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtTimeStart.setForeground(new java.awt.Color(255, 255, 255));
        txtTimeStart.setText("Enter time to start");
        txtTimeStart.setBorder(null);
        txtTimeStart.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtTimeStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimeStartMouseClicked(evt);
            }
        });

        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("Time to start");

        txtTimeEnd.setBackground(new java.awt.Color(36, 47, 65));
        txtTimeEnd.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtTimeEnd.setForeground(new java.awt.Color(255, 255, 255));
        txtTimeEnd.setText("Enter time to end");
        txtTimeEnd.setBorder(null);
        txtTimeEnd.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtTimeEnd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimeEndMouseClicked(evt);
            }
        });

        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("Time to end");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("Date");

        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator10.setForeground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("Cost");

        txtCost.setBackground(new java.awt.Color(36, 47, 65));
        txtCost.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtCost.setForeground(new java.awt.Color(255, 255, 255));
        txtCost.setText("Enter cost");
        txtCost.setBorder(null);
        txtCost.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtCost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCostMouseClicked(evt);
            }
        });

        btnAccept.setBackground(new java.awt.Color(0, 153, 153));
        btnAccept.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnAccept.setForeground(new java.awt.Color(255, 255, 255));
        btnAccept.setText("Comfirm");
        btnAccept.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAccept.setBorderPainted(false);
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancel");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cbtimestarhour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22" }));

        cbtimestartminus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", " ", " " }));

        cbtimeendhour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22" }));

        cbtimeendminus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 100, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(cbtimestarhour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbtimestartminus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel16)
                        .addComponent(jSeparator8)
                        .addComponent(jLabel15)
                        .addComponent(txtTimeStart)
                        .addComponent(jSeparator7)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)
                        .addComponent(txtShowtimeID, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                        .addComponent(jSeparator4)
                        .addComponent(jLabel10)
                        .addComponent(jLabel13)
                        .addComponent(cbMovie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator5)
                        .addComponent(cbRoom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator6)
                        .addComponent(jLabel17)
                        .addComponent(jSeparator9)
                        .addComponent(jSeparator10)
                        .addComponent(jLabel18)
                        .addComponent(txtCost)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(cbtimeendhour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(67, 67, 67)
                                    .addComponent(txtTimeEnd))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(cbtimeendminus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))))
                .addGap(0, 100, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(23, 23, 23)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtShowtimeID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimeStart, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbtimestarhour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbtimestartminus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(txtTimeEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbtimeendminus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbtimeendhour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addGap(1, 1, 1)
                .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 470, 680));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
       // TODO add your handling code here:
        int sl = 0;
        txtTimeStart.setText(cbtimestarhour.getSelectedItem() + ":" + cbtimestartminus.getSelectedItem());
        txtTimeEnd.setText(cbtimeendhour.getSelectedItem() + ":" + cbtimeendminus.getSelectedItem());
        int hourstar = Integer.valueOf(txtTimeStart.getText().substring(0, 2));
        int minustar = Integer.valueOf(txtTimeStart.getText().substring(3, 5));
        int hourend = Integer.valueOf(txtTimeEnd.getText().substring(0, 2));
        int minusend = Integer.valueOf(txtTimeEnd.getText().substring(3, 5));
        Time tst1 = new Time(hourstar, minustar, 0);
        Time tend1 =new Time(hourend,minusend,0);
        if(hourstar >= hourend){
            new ErrorGUI("Thoi gian khong hop le!");
        }else{
            for (ShowTime_DTO item : ShowTime.listst) {
                int hourstaritem = Integer.valueOf(item.getTime_Start().substring(0, 2));
                int minustaritem = Integer.valueOf(item.getTime_Start().substring(3, 5));
                int hourenditem = Integer.valueOf(item.getTime_End().substring(0, 2));
                int minusenditem = Integer.valueOf(item.getTime_End().substring(3, 5));
                Time tst2 = new Time(hourstaritem, minustaritem, 0);
                Time tend2 =new Time(hourenditem,minusenditem,0);
                java.sql.Date d1 = new java.sql.Date(jDateChooser1.getDate().getTime());
                if(!CheckShowtime(d1, item.getST_Date(),
                            Integer.parseInt(cbRoom.getSelectedItem().toString()),
                            item.getID_Room(), tst1, tst2, tend1, tend2)){
                    sl++;
                    break;
                }       
            }
            if(sl!=0) new  ErrorGUI("Trung Suat Chieu!");
            if(sl == 0){
            if(txtShowtimeID.getText().compareTo("Enter showtime id") != 0 
                    && txtTimeStart.getText().compareTo("Enter time to start") !=0
                    && txtTimeEnd.getText().compareTo("Enter time to end") !=0
                    && txtCost.getText().compareTo("Enter cost") !=0)
            {

                if(!txtCost.getText().isEmpty() && !jDateChooser1.getDateFormatString().isEmpty()
                    && !txtShowtimeID.getText().isEmpty()
                    && !txtTimeStart.getText().isEmpty()
                    && !txtTimeEnd.getText().isEmpty()
                    && cbMovie.getSelectedIndex() != -1
                    && cbRoom.getSelectedIndex() != -1){
                    int id = Integer.parseInt(txtShowtimeID.getText());
                    int movie_id = listMovie.get(cbMovie.getSelectedIndex()).getID();
                    int room_id = listRoom.get(cbRoom.getSelectedIndex()).getRoom_ID();
                    String time_start = txtTimeStart.getText();
                    String time_end  = txtTimeEnd.getText();
                    java.sql.Date date = new java.sql.Date(jDateChooser1.getDate().getTime());
                    System.out.println(date);
                    int cost =Integer.parseInt(txtCost.getText());
                    if(new ShowTime_DTO().insertShowtime(id,movie_id,room_id,time_start,time_end,cost,date)){
                        st.LoadDataShowTime();
                        st.setVisible(false);
                        st.setVisible(true);
                    }
                }else{
                    new ErrorGUI("Xin nhập đầy đủ thông tin!");
                }
            }else
                new ErrorGUI("Xin nhập đầy đủ thông tin!");
            this.dispose();
            }
        }
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void txtShowtimeIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtShowtimeIDMouseClicked
        // TODO add your handling code here:
        txtShowtimeID.setText("");

    }//GEN-LAST:event_txtShowtimeIDMouseClicked

    private void txtTimeStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimeStartMouseClicked
        // TODO add your handling code here:
        txtTimeStart.setText("");
    }//GEN-LAST:event_txtTimeStartMouseClicked

    private void txtTimeEndMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimeEndMouseClicked
        // TODO add your handling code here:
        txtTimeEnd.setText("");
    }//GEN-LAST:event_txtTimeEndMouseClicked

    private void txtCostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCostMouseClicked
        // TODO add your handling code here:
        txtCost.setText("");
    }//GEN-LAST:event_txtCostMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(FormInsertShowTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormInsertShowTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormInsertShowTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormInsertShowTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormInsertShowTime().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JComboBox<String> cbMovie;
    private javax.swing.JComboBox<String> cbRoom;
    private javax.swing.JComboBox<String> cbtimeendhour;
    private javax.swing.JComboBox<String> cbtimeendminus;
    private javax.swing.JComboBox<String> cbtimestarhour;
    private javax.swing.JComboBox<String> cbtimestartminus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextField txtShowtimeID;
    private javax.swing.JTextField txtTimeEnd;
    private javax.swing.JTextField txtTimeStart;
    // End of variables declaration//GEN-END:variables
}