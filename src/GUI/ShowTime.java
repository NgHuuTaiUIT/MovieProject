/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.DBConnection;
import DTO.Movie_DTO;
import DTO.ShowTime_DTO;
import java.awt.Color;
import java.awt.Font;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Time;
import java.sql.Date;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author vnngu
 */
public class ShowTime extends javax.swing.JFrame {

    /**
     * Creates new form ShowTime
     */
    private TableRowSorter<TableModel> rowSorter = null;
    private DefaultTableModel tableModel;
    private ShowTime_DTO st_DTO = new ShowTime_DTO();
    static public Vector<ShowTime_DTO> listst = new Vector<>();
    private Vector<Movie_DTO> listmv = new Vector<>();
    public Management management;
    public ShowTime() {
        initComponents();
        LoadDataShowTime();
    }
    public ShowTime(Management management) {
        initComponents();
        LoadDataShowTime();
        this.management = management;
    }
    public void LoadDataShowTime(){
        tableModel = new DefaultTableModel();
        tblShowtime.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,18));
        tblShowtime.getTableHeader().setOpaque(false);
        tblShowtime.getTableHeader().setBackground(Color.red);
        tblShowtime.getTableHeader().setForeground(new Color(255,255,255));
        String columnName[] = {"Mã","Tên Phim","Phòng","TGBĐ","TGKT","Giá","Date"};
        tableModel.setColumnIdentifiers(columnName);
        tblShowtime.setModel(tableModel);
        rowSorter = new TableRowSorter<>(tblShowtime.getModel());
        tblShowtime.setRowSorter(rowSorter);

        txttim.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txttim.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txttim.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        DBConnection con = new DBConnection();
        String sql = "Select st.*,mv.*\n" +
                    "from Movie mv , Showtime st\n" +
                    "where mv.id = st.movie_id order by st.id asc";
         ResultSet rs = con.getData(sql);
        
        try {
            listst.clear();
            listmv.clear();
            while(rs.next()) {
                
                String value[] = new String[7];
                value[0] = rs.getString("ID");
                value[1] = rs.getString("Movie_Name");
                value[2] = rs.getString("Room_ID");
                //Time timestart = new Time(rs.getTimestamp("TIME_START").getTime());
                //value[3] = timestart.toString().substring(0, 5);
                //Time timeend = new Time(rs.getTimestamp("TIME_END").getTime());
                //value[4] = timeend.toString().substring(0, 5);
                value[3] = rs.getString("TIME_START");
                value[4] = rs.getString("TIME_END");
                value[5] = rs.getString("COST");
                value[6] = rs.getDate("date_st").toString();
                listst.add(new ShowTime_DTO( Integer.parseInt(value[0]),
                        rs.getInt("movie_id"),
                        rs.getInt("room_id"),
                        rs.getString("time_start"),
                        rs.getString("time_end"),
                        rs.getInt("cost"),
                        rs.getDate("Date_St")));
                listmv.add(new Movie_DTO(rs.getInt("ID")
                        ,rs.getString("Movie_name")
                        ,rs.getString("Movie_type")
                        ,rs.getInt("Movie_Duration")
                        ,rs.getString("Movie_Age")));
                tableModel.addRow(value);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowTime.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.CloseConnection();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblShowtime = new javax.swing.JTable();
        lblDelete = new javax.swing.JLabel();
        lblInsert = new javax.swing.JLabel();
        lblEdit = new javax.swing.JLabel();
        txttim = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/icons8-back-arrow-64.png"))); // NOI18N
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 500, 90, 90));

        tblShowtime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblShowtime.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tblShowtime.setFocusable(false);
        tblShowtime.setGridColor(new java.awt.Color(51, 51, 51));
        tblShowtime.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblShowtime.setRowHeight(25);
        tblShowtime.setSelectionBackground(new java.awt.Color(224, 78, 72));
        tblShowtime.setShowGrid(false);
        tblShowtime.setShowHorizontalLines(true);
        tblShowtime.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblShowtime);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 990, 390));

        lblDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/rubber (1)90x90.png"))); // NOI18N
        lblDelete.setText("jLabel2");
        lblDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDeleteMouseClicked(evt);
            }
        });
        jPanel3.add(lblDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, 90, 90));

        lblInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/mathematics90x90.png"))); // NOI18N
        lblInsert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInsertMouseClicked(evt);
            }
        });
        jPanel3.add(lblInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 90, 90));

        lblEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/registe90x90.png"))); // NOI18N
        lblEdit.setText("jLabel2");
        lblEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditMouseClicked(evt);
            }
        });
        jPanel3.add(lblEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, 90, 90));
        jPanel3.add(txttim, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 290, 40));

        jLabel5.setText("Tìm");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 30, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1040, 620));

        jPanel2.setBackground(new java.awt.Color(36, 47, 65));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 48)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(13, 23, 45));
        jLabel21.setText("Show Time");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, -1, -1));
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 49, -1, -1));

        jLabel13.setBackground(new java.awt.Color(255, 153, 0));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/CG4.png"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 450, 200));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/icons8-jdownloader-96.png"))); // NOI18N
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 110, 200));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 1040, 200));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblInsertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInsertMouseClicked
            new FormInsertShowTime(this).setVisible(true);
    }//GEN-LAST:event_lblInsertMouseClicked

    private void lblDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeleteMouseClicked
            
        int index = tblShowtime.getSelectedRow();
        int idShowtime =Integer.parseInt(tableModel.getValueAt(index,0).toString());
        st_DTO.deleteShowtime(idShowtime);
        LoadDataShowTime();
    }//GEN-LAST:event_lblDeleteMouseClicked

    private void lblEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditMouseClicked
        // TODO add your handling code here:
        int index = tblShowtime.getSelectedRow();
        int idShowtime = Integer.parseInt(tableModel.getValueAt(index,0).toString()); 
        int idMovie = 0;
        for (Movie_DTO movie_DTO : Management.listMovie) {
            if(tableModel.getValueAt(index,1).toString().equalsIgnoreCase(movie_DTO.getMovie_name())){
                idMovie = movie_DTO.getID();
                break;
            }
        }
        int idRoom = Integer.parseInt(tableModel.getValueAt(index,2).toString());
        String timeStart = tableModel.getValueAt(index,3).toString();
        String timeEnd = tableModel.getValueAt(index,4).toString();
        int cost = Integer.parseInt(tableModel.getValueAt(index,5).toString());
        Date date = new Date(0);
        for (ShowTime_DTO showTime_DTO : listst) {
            if(showTime_DTO.getID() == idShowtime)
                date = showTime_DTO.getST_Date();
        }
        if(idMovie != 0){
            st_DTO.updateShowtime(idShowtime, idMovie, idRoom, timeStart, timeEnd, cost, date);
        LoadDataShowTime();
        }else
            new ErrorGUI("Phim Khong Ton Tai!");
    }//GEN-LAST:event_lblEditMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        management.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(ShowTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowTime().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDelete;
    private javax.swing.JLabel lblEdit;
    private javax.swing.JLabel lblInsert;
    private javax.swing.JTable tblShowtime;
    private javax.swing.JTextField txttim;
    // End of variables declaration//GEN-END:variables
}
