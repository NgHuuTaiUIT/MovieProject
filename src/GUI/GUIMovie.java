/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Bill;
import DTO.Bill_Detail_DTO;
import DTO.DBConnection;
import DTO.Employee_DTO;
import DTO.Food_DTO;
import DTO.Movie_DTO;
import DTO.Seat_Status;
import DTO.ShowTime_DTO;
import DTO.Ticket_DTO;
import GUI.LOGIN1;
import GUI.Payment;
import GUI.SEATS;
import java.sql.Connection;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.Statement;
import java.nio.channels.FileChannel;
import java.util.Vector;
import javax.swing.DefaultListModel;
import static javax.swing.GroupLayout.Alignment.CENTER;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.swing.JList;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 *
 * @author vnngu
 */
public class GUIMovie extends javax.swing.JFrame {
    private Employee_DTO emp = new Employee_DTO();
    private Vector<ShowTime_DTO> lstst = new Vector<ShowTime_DTO>();
    private Vector<JLabel> ListLabeShowtime= new Vector<>();
    private Vector<JLabel> listLabelRoom= new Vector<>();
    private Vector<Movie_DTO> listmv = new Vector<>();
    private long millis=System.currentTimeMillis();
    public Options opt = new Options();
    public GUIMovie() {
        initComponents();
        LoadFood();
        setVisible(true);
    }
    public GUIMovie(Employee_DTO emp,Options opt){
        initComponents();
        LoadFood();
        this.setVisible(true);
        this.emp = emp;
        this.opt = opt;
        lbNhanVien.setText(emp.getEmp_name());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnPay = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblTotalPrice = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlCart = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnCost_Child = new javax.swing.JButton();
        btnCost_Adult = new javax.swing.JButton();
        btnBooking = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        lbNhanVien = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Movie");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(51, 51, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusable(false);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(22, 25, 26));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(22, 25, 26));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/unnamed (1).png"))); // NOI18N
        jLabel3.setText("CART");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 27, 297, 50));

        btnPay.setBackground(new java.awt.Color(255, 153, 0));
        btnPay.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/Payment.png"))); // NOI18N
        btnPay.setText("Pay");
        btnPay.setBorderPainted(false);
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });
        jPanel1.add(btnPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 820, 146, 60));

        jButton2.setBackground(new java.awt.Color(255, 153, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/trash.png"))); // NOI18N
        jButton2.setText("Delete");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 820, 150, 60));

        jPanel6.setBackground(new java.awt.Color(45, 50, 53));

        jLabel4.setBackground(new java.awt.Color(45, 50, 53));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("PRICE");
        jLabel4.setOpaque(true);

        lblTotalPrice.setBackground(new java.awt.Color(45, 50, 53));
        lblTotalPrice.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblTotalPrice.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalPrice.setText("1200000");
        lblTotalPrice.setOpaque(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
            .addComponent(lblTotalPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 730, 310, 70));

        pnlCart.setBackground(new java.awt.Color(255, 255, 255));
        pnlCart.setAutoscrolls(true);
        pnlCart.setPreferredSize(new java.awt.Dimension(300, 770));
        pnlCart.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane1.setViewportView(pnlCart);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 330, 630));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 24, 330, 4));

        jLabel8.setBackground(new java.awt.Color(102, 121, 125));
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 340, 25));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(796, 41, 330, 920));

        jTabbedPane1.setBackground(new java.awt.Color(102, 121, 125));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTabbedPane1.setDoubleBuffered(true);
        jTabbedPane1.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(22, 25, 26));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/pngwing.com.png"))); // NOI18N
        jLabel1.setText("MOVIE");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setDoubleBuffered(true);
        jLabel1.setOpaque(true);
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 505, 54));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel5.setBackground(new java.awt.Color(22, 25, 26));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 180, 5));

        jLabel2.setBackground(new java.awt.Color(34, 34, 34));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/pngwing.com (1).png"))); // NOI18N
        jLabel2.setText("Ticket Type");
        jLabel2.setOpaque(true);
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 260, 61));

        jPanel14.setBackground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 190, 5));

        jLabel13.setBackground(new java.awt.Color(22, 25, 26));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/Capture.PNG"))); // NOI18N
        jLabel13.setText("Show Time");
        jLabel13.setOpaque(true);
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 240, 61));

        btnCost_Child.setBackground(new java.awt.Color(255, 55, 46));
        btnCost_Child.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCost_Child.setForeground(new java.awt.Color(255, 255, 255));
        btnCost_Child.setText("Child");
        btnCost_Child.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCost_Child.setBorderPainted(false);
        jPanel5.add(btnCost_Child, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 130, 60));

        btnCost_Adult.setBackground(new java.awt.Color(255, 55, 46));
        btnCost_Adult.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCost_Adult.setForeground(new java.awt.Color(255, 255, 255));
        btnCost_Adult.setText("Adult");
        btnCost_Adult.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCost_Adult.setBorderPainted(false);
        jPanel5.add(btnCost_Adult, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 130, 60));

        btnBooking.setBackground(new java.awt.Color(255, 153, 0));
        btnBooking.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnBooking.setForeground(new java.awt.Color(255, 255, 255));
        btnBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/cinema.png"))); // NOI18N
        btnBooking.setText("Booking");
        btnBooking.setBorderPainted(false);
        jPanel5.add(btnBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 740, 224, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/ttttt.PNG"))); // NOI18N
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 260, 250));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 55, 287, 840));

        jPanel9.setBackground(new java.awt.Color(34, 34, 34));
        jPanel9.setPreferredSize(new java.awt.Dimension(350, 50));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/PikPng.com_calendar-icon-png_1014353 (1).png"))); // NOI18N
        jLabel19.setOpaque(true);
        jPanel9.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, 50));

        jLabel5.setBackground(new java.awt.Color(34, 34, 34));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText(">");
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("<");
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 50));

        jDateChooser2.setBackground(new java.awt.Color(255, 102, 0));
        jDateChooser2.setAutoscrolls(true);
        jDateChooser2.setDate(new Date(millis)
        );
        jDateChooser2.setDateFormatString("dd,MM,yyyy");
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jDateChooser2.setInheritsPopupMenu(true);
        jDateChooser2.setOpaque(false);
        jDateChooser2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser2MouseClicked(evt);
            }
        });
        jDateChooser2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser2PropertyChange(evt);
            }
        });
        jPanel9.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, 50));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 0, 286, 54));

        jScrollPane3.setBackground(new java.awt.Color(51, 51, 51));

        jPanel7.setBackground(new java.awt.Color(102, 121, 125));
        jPanel7.setAutoscrolls(true);
        jPanel7.setPreferredSize(new java.awt.Dimension(450, 945));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 945, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel7);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 55, 504, 945));

        jTabbedPane1.addTab("MOVIE", jPanel2);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new java.awt.GridLayout(5, 5, 2, 2));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);

        jButton3.setBackground(new java.awt.Color(153, 153, 153));
        jButton3.setBorderPainted(false);
        jPanel4.add(jButton3);

        jButton4.setBackground(new java.awt.Color(153, 153, 153));
        jButton4.setBorderPainted(false);
        jPanel4.add(jButton4);

        jButton5.setBackground(new java.awt.Color(153, 153, 153));
        jButton5.setBorderPainted(false);
        jPanel4.add(jButton5);

        jButton6.setBackground(new java.awt.Color(153, 153, 153));
        jButton6.setBorderPainted(false);
        jPanel4.add(jButton6);

        jButton7.setBackground(new java.awt.Color(153, 153, 153));
        jButton7.setBorderPainted(false);
        jPanel4.add(jButton7);

        jButton8.setBackground(new java.awt.Color(153, 153, 153));
        jButton8.setBorderPainted(false);
        jPanel4.add(jButton8);

        jButton9.setBackground(new java.awt.Color(153, 153, 153));
        jButton9.setBorderPainted(false);
        jPanel4.add(jButton9);

        jButton10.setBackground(new java.awt.Color(153, 153, 153));
        jButton10.setBorderPainted(false);
        jPanel4.add(jButton10);

        jButton11.setBackground(new java.awt.Color(153, 153, 153));
        jButton11.setBorderPainted(false);
        jPanel4.add(jButton11);

        jButton12.setBackground(new java.awt.Color(153, 153, 153));
        jButton12.setBorderPainted(false);
        jPanel4.add(jButton12);

        jButton13.setBackground(new java.awt.Color(153, 153, 153));
        jButton13.setBorderPainted(false);
        jPanel4.add(jButton13);

        jButton14.setBackground(new java.awt.Color(153, 153, 153));
        jButton14.setBorderPainted(false);
        jPanel4.add(jButton14);

        jButton15.setBackground(new java.awt.Color(153, 153, 153));
        jButton15.setBorderPainted(false);
        jPanel4.add(jButton15);

        jButton16.setBackground(new java.awt.Color(153, 153, 153));
        jButton16.setBorderPainted(false);
        jPanel4.add(jButton16);

        jButton17.setBackground(new java.awt.Color(153, 153, 153));
        jButton17.setBorderPainted(false);
        jPanel4.add(jButton17);

        jButton18.setBackground(new java.awt.Color(153, 153, 153));
        jButton18.setBorderPainted(false);
        jPanel4.add(jButton18);

        jButton19.setBackground(new java.awt.Color(153, 153, 153));
        jButton19.setBorderPainted(false);
        jPanel4.add(jButton19);

        jButton20.setBackground(new java.awt.Color(153, 153, 153));
        jButton20.setBorderPainted(false);
        jPanel4.add(jButton20);

        jButton21.setBackground(new java.awt.Color(153, 153, 153));
        jButton21.setBorderPainted(false);
        jPanel4.add(jButton21);

        jButton22.setBackground(new java.awt.Color(153, 153, 153));
        jButton22.setBorderPainted(false);
        jPanel4.add(jButton22);

        jButton23.setBackground(new java.awt.Color(153, 153, 153));
        jButton23.setBorderPainted(false);
        jPanel4.add(jButton23);

        jButton24.setBackground(new java.awt.Color(153, 153, 153));
        jButton24.setBorderPainted(false);
        jPanel4.add(jButton24);

        jButton25.setBackground(new java.awt.Color(153, 153, 153));
        jButton25.setBorderPainted(false);
        jPanel4.add(jButton25);

        jButton26.setBackground(new java.awt.Color(153, 153, 153));
        jButton26.setBorderPainted(false);
        jPanel4.add(jButton26);

        jPanel13.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 663, 690));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/101000591_245147083583621_315859166327472128_n (1).png"))); // NOI18N
        jLabel10.setText("FOOD");
        jPanel13.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 766, 136));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("FOOD", jPanel12);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, 920));

        jPanel8.setBackground(new java.awt.Color(102, 121, 125));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogout.setBackground(new java.awt.Color(102, 121, 125));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/pngbarn.png"))); // NOI18N
        btnLogout.setBorderPainted(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel8.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1098, 0, 30, 34));

        lbNhanVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lbNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNhanVien.setText("Tên nhân viên");
        jPanel8.add(lbNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(868, 1, 212, 34));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("CG4 UIT");
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 241, 37));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1125, 70));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public Employee_DTO getEmp() {
        return emp;
    }
    Vector<Food_DTO> listfood = new Vector<>();
    Vector<JButton> listfoodbtn = new Vector<>();
    private void LoadFood(){
//        DBConnection con = new DBConnection();
//        ResultSet rs = con.getData("Select * from Food");        
//        try {
//            int i = 0;
//            while(rs.next()){
//                listfood.add(new Food_DTO(rs.getInt("food_id"),rs.getString("food_name"),rs.getInt("price")));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(GUIMovie.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        con.CloseConnection();
//        int j = 0;
//        for (int i = 0; i < 25; i++) {
//            JButton btnfood = new JButton();
//            btnfood.setBackground(new Color(102, 102, 102));
//            
//            if(j < listfood.size() && !listfood.isEmpty()){
//                btnfood.setText(listfood.get(j).getName());
//                
//                j++;
//            }
//            listfoodbtn.add(btnfood);
//            jPanel4.add(btnfood);
//        }
//        for (JButton btnfood : listfoodbtn) {
//            btnfood.addActionListener((e) -> {
//                    JLabel lb1 = new JLabel(btnfood.getText());
//                    lb1.setFont(new Font("Tahoma", 1, 18));
//                   lb1.setHorizontalAlignment((int) CENTER_ALIGNMENT);
//                   lb1.setForeground(new Color(95,95,95));
//                   lb1.setOpaque(true);
//                   lb1.setBackground(new Color(255, 153, 31));
//                    Point p = new Point(pnlCart.getComponent(pnlCart.getComponentCount()).getLocation());
//                    pnlCart.add(lb1,new AbsoluteConstraints(20, p.y+50, 270, 50));
//                });
//        }

    }
    Date date1 = new Date(0);
    private  void LoadLabelShowTimeTemp(int idmv){
        DBConnection con = new DBConnection();
        int y = -105;
        Date date = new Date(jDateChooser2.getDate().getTime());
        String sql ="Select st.* from ShowTime st where st.Movie_ID = " + idmv +  " and st.date_st = TO_DATE('" + date.toString() + "','YYYY-MM-DD')";
        System.out.println(sql);
//        Vector<ShowTime_DTO> datashowtime = new ShowTime_DTO().Display(sql);
        ResultSet dataShowtime = con.getData(sql);
        try {

            while(dataShowtime.next()){
                ShowTime_DTO st = new ShowTime_DTO(dataShowtime.getInt(1), dataShowtime.getInt(2), dataShowtime.getInt(3), dataShowtime.getString(4),dataShowtime.getString(6),dataShowtime.getInt(5),dataShowtime.getDate("DATE_ST"));
                lstst.add(st);
            }           
        }catch (SQLException ex) {
                //new ErrorGUI("Ngày này chưa có suất chiếu!");
                Logger.getLogger(GUIMovie.class.getName()).log(Level.SEVERE, null, ex);
                this.setVisible(true);

            }
        con.CloseConnection();
            for (ShowTime_DTO item : lstst) {
            
        
                String timestart = item.getTime_Start();
                JLabel lbshowtime = new JLabel(timestart);
                lbshowtime.setFont(new Font("Tahoma", 1, 14));
                lbshowtime.setForeground(new Color(255,255,255));
                lbshowtime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbshowtime.setSize(90, 90);
                lbshowtime.setOpaque(true);
                lbshowtime.setBackground(new Color(102, 121, 125));
                
                String roomname = "Room: " + item.getID_Room();
                JLabel lbRoom = new JLabel(roomname);
                lbRoom.setFont(new Font("Tahoma", 1, 14));
                lbRoom.setForeground(new Color(255,255,255));
                lbRoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbRoom.setSize(90, 90);
                //lbRoom.setOpaque(true);
                lbRoom.setBackground(new Color(95,95,95));
                listLabelRoom.add(lbRoom);
                ListLabeShowtime.add(lbshowtime);
            }

//        con.CloseConnection(); 
    }
    
    public void LoadMovieTemp(){
        DBConnection con = new DBConnection();
        int  y = -270;
        Date date = new Date(jDateChooser2.getDate().getTime());
        date1 = date;
        try {
            String sql = "Select Distinct mv.* from Movie mv , ShowTime st where st.date_st = TO_DATE('" + date.toString() + "','YYYY-MM-DD') ORDER BY mv.ID ASC";
            ResultSet dataMv = con.getData(sql);          
            while(dataMv.next()){
                listmv.add(new Movie_DTO(dataMv.getInt("ID")
                        ,dataMv.getString("Movie_name")
                        ,dataMv.getString("Movie_type")
                        ,dataMv.getInt("Movie_Duration")
                        ,dataMv.getString("Movie_Age")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GUIMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.CloseConnection();
        for ( Movie_DTO item: listmv) {
                LoadLabelShowTimeTemp(item.getID());
                if(!lstst.isEmpty()){
                    JPanel pn = new JPanel(new AbsoluteLayout());
                    pn.setSize(481, 260);
                    pn.setBackground(new Color(22, 25, 26));
                    JLabel lb1 = new JLabel(item.getMovie_name());
                    lb1.setFont(new Font("Tahoma", 1, 30));
                    lb1.setForeground(new Color(255, 133, 10));
                    JLabel lb2 =new JLabel(item.getMovie_age()
                            + "   | " + item.getMovie_type()
                            + "   | " + item.getDuration_min());
                    lb2.setFont(new Font("Tahoma", 1, 14));
                    lb2.setForeground(new Color(240, 240, 240));
                    JPanel pnchild = new JPanel(new AbsoluteLayout());
                    pnchild.setBackground(pn.getBackground());
                    Date d = new Date(millis);
                    java.sql.Date d1 = new java.sql.Date(jDateChooser2.getDate().getTime());
                    lb2.setText(lb2.getText() + "   | " 
                            + d1);

                    int x = -100;
                    int index = 0;
                    for (JLabel i : ListLabeShowtime) {
                        pnchild.add(i,new AbsoluteConstraints(x+=100, 30, 90, 90));
                        pnchild.add(listLabelRoom.get(index),new AbsoluteConstraints(x, 0, 90, 20));
                        index++;
                    }
                    pn.add(lb1,new AbsoluteConstraints(0, 0, 481, 80));
                    pn.add(lb2,new AbsoluteConstraints(10, 60, 470, 40));
                    pn.add(pnchild,new AbsoluteConstraints(10, 130, 400, 120));
                    //LoadShowTime();
                    AddActionClickLabelShowtime();
                    ListLabeShowtime.clear();
                    lstst.clear();
                    listLabelRoom.clear();
                    jPanel7.add(pn).setLocation(0, y+=270);
                    if(jPanel7.getPreferredSize().height < y);
                        jPanel7.setPreferredSize(new Dimension(jPanel7.getPreferredSize().width,jPanel7.getPreferredSize().height+50));
                }
        }
        
         
    }
    
    private  void LoadLabelShowTime(int idmv) throws SQLException{
        DBConnection con = new DBConnection();
        int y = -105;
        Date date = new Date(jDateChooser2.getDate().getTime());
        String sql ="Select st.* from ShowTime st where st.Movie_ID = " + idmv +  " and st.date_st = TO_DATE('" + date.toString() + "','YYYY-MM-DD')";
        System.out.println(sql);
//        Vector<ShowTime_DTO> datashowtime = new ShowTime_DTO().Display(sql);
        ResultSet dataShowtime = con.getData(sql);
        try {
            

            while(dataShowtime.next()){
                ShowTime_DTO st = new ShowTime_DTO(dataShowtime.getInt(1), dataShowtime.getInt(2), dataShowtime.getInt(3), dataShowtime.getString(4),dataShowtime.getString(6),dataShowtime.getInt(5),dataShowtime.getDate("DATE_ST"));
                lstst.add(st);
//                Timestamp timestamp = dataShowtime.getTimestamp("Time_Start");
//                Time timestart = new Time(timestamp.getTime());
//                String timeStart = timestart.toString();
//                JLabel lbshowtime = new JLabel(timeStart.substring(0, 5));
                String timestart = dataShowtime.getString("Time_Start");
                JLabel lbshowtime = new JLabel(timestart);
                lbshowtime.setFont(new Font("Tahoma", 1, 14));
                lbshowtime.setForeground(new Color(240, 240, 240));
                lbshowtime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbshowtime.setSize(90, 90);
                lbshowtime.setOpaque(true);
                lbshowtime.setBackground(new Color(95,95,95));
                
                String roomname = "Room: " + dataShowtime.getInt("Room_ID");
                JLabel lbRoom = new JLabel(roomname);
                lbRoom.setFont(new Font("Tahoma", 1, 14));
                lbRoom.setForeground(new Color(33, 48, 69));
                lbRoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                lbRoom.setSize(90, 90);
                //lbRoom.setOpaque(true);
                lbRoom.setBackground(new Color(95,95,95));
                listLabelRoom.add(lbRoom);
                ListLabeShowtime.add(lbshowtime);
            }           
        } catch (SQLException ex) {
            //new ErrorGUI("Ngày này chưa có suất chiếu!");
            Logger.getLogger(GUIMovie.class.getName()).log(Level.SEVERE, null, ex);
            this.setVisible(true);
            
        }
        con.CloseConnection(); 
    }
    public void LoadMovie(){
        DBConnection con = new DBConnection();
        int  y = -270;
        Date date = new Date(jDateChooser2.getDate().getTime());
        date1 = date;
        try {
            String sql = "Select Distinct mv.* from Movie mv , ShowTime st where st.date_st = TO_DATE('" + date.toString() + "','YYYY-MM-DD') ORDER BY mv.ID ASC";
            ResultSet dataMv = con.getData(sql);          
            while(dataMv.next()){
                listmv.add(new Movie_DTO(dataMv.getInt("ID")
                        ,dataMv.getString("Movie_name")
                        ,dataMv.getString("Movie_type")
                        ,dataMv.getInt("Movie_Duration")
                        ,dataMv.getString("Movie_Age")));
                JPanel pn = new JPanel(new AbsoluteLayout());
                pn.setSize(481, 260);
                pn.setBackground(new Color(255,153,0));
                JLabel lb1 = new JLabel(dataMv.getString("Movie_Name"));
                lb1.setFont(new Font("Tahoma", 1, 30));
                lb1.setForeground(new Color(240, 240, 240));
                JLabel lb2 =new JLabel(dataMv.getString("Movie_Age") 
                        + "   | " + dataMv.getString("Movie_Type")
                        + "   | " + dataMv.getString("Movie_Duration"));
                lb2.setFont(new Font("Tahoma", 1, 14));
                lb2.setForeground(new Color(240, 240, 240));
                JPanel pnchild = new JPanel(new AbsoluteLayout());
                pnchild.setBackground(pn.getBackground());
                LoadLabelShowTime(dataMv.getInt("ID"));
                lb2.setText(lb2.getText() + "   | " 
                        + lstst.get(0).getST_Date().toString());
                
                int x = -100;
                int index = 0;
                for (JLabel i : ListLabeShowtime) {
                    pnchild.add(i,new AbsoluteConstraints(x+=100, 30, 90, 90));
                    pnchild.add(listLabelRoom.get(index),new AbsoluteConstraints(x, 0, 90, 20));
                    index++;
                }
                pn.add(lb1,new AbsoluteConstraints(0, 0, 481, 80));
                pn.add(lb2,new AbsoluteConstraints(10, 60, 470, 40));
                pn.add(pnchild,new AbsoluteConstraints(10, 130, 400, 120));
                //LoadShowTime();
                AddActionClickLabelShowtime();
                ListLabeShowtime.clear();
                
                listLabelRoom.clear();
                jPanel7.add(pn).setLocation(0, y+=270);
            }           
        } catch (SQLException ex) {
            Logger.getLogger(GUIMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
        lstst.clear();
        con.CloseConnection(); 
    }
    
    
    static ShowTime_DTO stChoose;
    static Vector<Seat_Status> listSeatChoose = new Vector<>();
    Vector<Ticket_DTO> listTicket = new Vector<>();
    Movie_DTO movieChoose; 
    SEATS s;
    Vector<JLabel> listlabelshowtimeclick = new Vector<>();
    //JLabel labelclick;
    Vector<Ticket_DTO> dataticket = new Vector<>();
    public  void AddActionClickLabelShowtime(){
        int y = -105;
        DBConnection con = new DBConnection();
        String sql = "Select * from Ticket";
                            System.out.println(sql);
                            ResultSet rs = con.getData(sql);
        
        try {
      while(rs.next())
             dataticket.add(new Ticket_DTO(rs.getInt("Ticket_ID"),rs.getInt("Showtime_ID"), rs.getString("Ticket_Type"), rs.getInt("Price")));
      } catch (SQLException ex) {
           Logger.getLogger(GUIMovie.class.getName()).log(Level.SEVERE, null, ex);
       }
      con.CloseConnection();
        for (int i=0; i < ListLabeShowtime.size();i++) {
                int cost = lstst.get(i).getCost();
                int idshowtime = lstst.get(i).getID();
                ShowTime_DTO st = new ShowTime_DTO(lstst.get(i));
                JLabel lbtemp = ListLabeShowtime.get(i);
                ListLabeShowtime.get(i).addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent evt){
                            for (int t = 0; t < listlabelshowtimeclick.size();t++) {
                                listlabelshowtimeclick.get(t).setBackground(new Color(102, 121, 125));
                                listlabelshowtimeclick.get(t).setForeground(new Color(255,255,255));
                                listlabelshowtimeclick.remove(t);
                            }
                            lbtemp.setBackground(Color.WHITE);
                            lbtemp.setForeground(Color.BLACK);
                            listlabelshowtimeclick.add(lbtemp);
                            //labelclick.setBackground(new Color(240, 240, 240));
                            ////labelclick = lbtemp;
                            //DBConnection con = new DBConnection();
                            
                            int index = 0;
                            while (listmv.get(index).getID() != st.getID_Movie()) {                
                                index++;
                            }               
                            movieChoose = listmv.get(index);
//                            String sql = "Select * from Ticket where Showtime_ID = " + idshowtime;
//                            System.out.println(sql);
//                            ResultSet rs = con.getData(sql);
                            listTicket.clear();
                            //Add vao listTicket
                            for (Ticket_DTO item : dataticket) {
                                if(item.getShowtimeID() == idshowtime)
                                    listTicket.add(item);
                            }
//                            try {
//                                while(rs.next())
//                                    listTicket.add(new Ticket_DTO(rs.getInt("Ticket_ID"),rs.getInt("Showtime_ID"), rs.getString("Ticket_Type"), rs.getInt("Price")));
//                            } catch (SQLException ex) {
//                                Logger.getLogger(GUIMovie.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                            con.CloseConnection();
                    
                            stChoose = new ShowTime_DTO(st);
                            for( ActionListener al : btnBooking.getActionListeners() ) {
                                btnBooking.removeActionListener( al );
                            }
                            //SEATS s = new SEATS(pnlCart,lblTotalPrice,st,movieChoose,listSeatChoose);      
                             s = new SEATS(pnlCart,lblTotalPrice,st,listTicket.get(0),movieChoose,listSeatChoose); 
                            btnBooking.addActionListener((ActionEvent e) -> {
                                //System.out.println(movieChoose.getMovie_name());   
                                s.setVisible(true);
                                pnlCart.removeAll();
                                pnlCart.setVisible(true);                            
                            });
                            
                             //Button btnCost_Adult
                            btnCost_Adult.setText(listTicket.get(0).getTicket_Type() + ": " + listTicket.get(0).getPrice());
                            for( ActionListener al : btnCost_Adult.getActionListeners() ) {
                                btnCost_Adult.removeActionListener( al );
                            }
//                            for( ActionListener al : btnCost_Adult.getActionListeners() ) {
//                                btnCost_Child.removeActionListener( al );
//                            }
                            btnCost_Adult.addActionListener((ActionEvent e) ->{
                                for( ActionListener al : btnBooking.getActionListeners() ) {
                                    btnBooking.removeActionListener( al );
                                }
                                btnCost_Adult.setBackground(new Color(53, 216, 147));
                                btnCost_Child.setBackground(new Color(255,55,46));
                                s.setTkc(listTicket.get(0));
                                System.out.println(movieChoose.getMovie_name());    
                                btnBooking.addActionListener((ActionEvent ex) -> {
                                    
                                    s.setVisible(true);
                                    pnlCart.removeAll();
                                    pnlCart.setVisible(true);
                                                               
                                });
                            });
                            
                            //Button btnCost_child
                            btnCost_Child.setText(listTicket.get(1).getTicket_Type() + ": " + listTicket.get(1).getPrice());
                            for( ActionListener al : btnCost_Child.getActionListeners() ) {
                                btnCost_Child.removeActionListener( al );
                            }
                            btnCost_Child.addActionListener((ActionEvent e) ->{
                                for( ActionListener al : btnBooking.getActionListeners() ) {
                                    btnBooking.removeActionListener( al );
                                }
                                btnCost_Child.setBackground(new Color(53, 216, 147));
                                btnCost_Adult.setBackground(new Color(255,55,46));
                                s.setTkc(listTicket.get(1));
                                System.out.println(movieChoose.getMovie_name());  
                                btnBooking.addActionListener((ActionEvent ex) -> {
                                    
                                    s.setVisible(true);
                                    pnlCart.removeAll();
                                    pnlCart.setVisible(true);
                                                                 
                                });
                            });
                               
                    }     
                });
        }
    }

    private void btnCost_AdultActionPerformed(ActionEvent event,ShowTime_DTO st,Ticket_DTO tkc){
        stChoose = new ShowTime_DTO(st);
                            for( ActionListener al : btnBooking.getActionListeners() ) {
                                btnBooking.removeActionListener( al );
                            }
                            SEATS s = new SEATS(pnlCart,lblTotalPrice,st,tkc,movieChoose,listSeatChoose);      
                            btnBooking.addActionListener((ActionEvent e) -> {
                                System.out.println(movieChoose.getMovie_name());   
                                s.setVisible(true);
                                pnlCart.removeAll();
                                pnlCart.setVisible(true);
                                System.out.println(movieChoose.getMovie_name());                               
                            });
    }
    private void btnCost_ChildActionPerformed(ActionEvent event,ShowTime_DTO st,Ticket_DTO tkc){
        stChoose = new ShowTime_DTO(st);
                            for( ActionListener al : btnBooking.getActionListeners() ) {
                                btnBooking.removeActionListener( al );
                            }
                            SEATS s = new SEATS(pnlCart,lblTotalPrice,st,tkc,movieChoose,listSeatChoose);      
                            btnBooking.addActionListener((ActionEvent e) -> {
                                System.out.println(movieChoose.getMovie_name());   
                                s.setVisible(true);
                                pnlCart.removeAll();
                                pnlCart.setVisible(true);
                                System.out.println(movieChoose.getMovie_name());                               
                            });
    }
    public void LoadCart(JLabel lbMovieJLabel,JLabel lbRoomJLabel, Vector<?> listlbSeat){
        
    }
    
    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        // TODO add your handling code here:
//        ResultSet rs = new DBConnection().getData("Select * from Bill");
//        int count = 1;
//        try {
//            while(rs.next()) count++;
//        } catch (SQLException ex) {
//            Logger.getLogger(GUIMovie.class.getName()).log(Level.SEVERE, null, ex);
//        }
        if(!s.getListSeatChooseAdult().isEmpty()||!s.getListSeatChooseChild().isEmpty() ){
            Bill bill = new Bill();
            //bill.setBill_id(count);
            bill.setStaff_id(emp.getEmp_id());
            bill.setDate(date1);
            bill.setPrice(Integer.parseInt(lblTotalPrice.getText()));
            bill.setShowTime_id(stChoose.getID());
            Vector<Bill_Detail_DTO> listbill_detail = new Vector<>();
            for (var item : s.getListSeatChooseAdult()) {
                Bill_Detail_DTO b = new Bill_Detail_DTO();
                b.setTicket_id(listTicket.get(0).getID());
                b.setSeat_Status_ID(item.getIDSeat());
                b.setShowTime_ID(stChoose.getID());
                b.setPrice(listTicket.get(0).getPrice());
                listbill_detail.add(b);
            }
            for (var item : s.getListSeatChooseChild()) {
                Bill_Detail_DTO b = new Bill_Detail_DTO();
                b.setTicket_id(listTicket.get(1).getID());
                b.setSeat_Status_ID(item.getIDSeat());
                b.setShowTime_ID(stChoose.getID());
                b.setPrice(listTicket.get(1).getPrice());
                listbill_detail.add(b);
            }
            //new Payment(lblTotalPrice.getText(),bill,listbill_detail).setVisible(true);
            new Payment(lblTotalPrice.getText(), bill, listbill_detail, s, stChoose, movieChoose, listTicket,this).setVisible(true);
        }else
            new ErrorGUI("Nothing Payment!");
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
            opt.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
//        listSeatChoose.clear();
//        listTicket.clear();
//         
//        pnlCart.removeAll();
//        pnlCart.setPreferredSize(new Dimension(300,760));
//        pnlCart.setVisible(false);
//        pnlCart.setVisible(true);
           this.dispose();
           new GUIMovie();
        
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void jDateChooser2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser2PropertyChange
        // TODO add your handling code here:
        Date date = new Date(jDateChooser2.getDate().getTime());
        if(date.toString().compareTo(date1.toString()) != 0)
       {   
            System.out.println(date);
            System.out.println(date1);
            pnlCart.removeAll();
            jPanel7.removeAll();
            ListLabeShowtime.clear();
            listLabelRoom.clear();
            lstst.clear();
            listSeatChoose.clear();
            listTicket.clear();
            listmv.clear();
            LoadMovieTemp();  
            //LoadMovie();
            jPanel7.setVisible(false);
            jPanel7.setVisible(true);
        }

    }//GEN-LAST:event_jDateChooser2PropertyChange

    private void jDateChooser2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser2MouseClicked

    }//GEN-LAST:event_jDateChooser2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         JLabel lb1 = new JLabel("Coca");
                   lb1.setFont(new Font("Tahoma", 1, 18));
                   lb1.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                   lb1.setForeground(new Color(255,255,255));
                   lb1.setOpaque(true);
                   lb1.setBackground(new Color(53, 216, 147));
                   pnlCart.add(lb1,new AbsoluteConstraints(20, SEATS.gety+55, 270, 50));
                   pnlCart.setVisible(false);
                   pnlCart.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(GUIMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIMovie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBooking;
    private javax.swing.JButton btnCost_Adult;
    private javax.swing.JButton btnCost_Child;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPay;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbNhanVien;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JPanel pnlCart;
    // End of variables declaration//GEN-END:variables
}
