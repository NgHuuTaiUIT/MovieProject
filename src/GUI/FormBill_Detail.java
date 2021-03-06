/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.DBConnection;
import java.sql.ResultSet;

/**
 *
 * @author vnngu
 */
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
public class FormBill_Detail extends javax.swing.JFrame {

    /**
     * Creates new form FormBill_Detail
     */
    private  DefaultTableModel tableModel;
    public FormBill_Detail() {
        initComponents();
    }
    
    public FormBill_Detail(int idbill) {
        initComponents();
        LoadDataBillDetail(idbill);
        jLabel1.setText(jLabel1.getText() + idbill);
    }
    private void LoadDataBillDetail(int idbill){
        tableModel = new DefaultTableModel();
        tblTransaction.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,18));
        tblTransaction.getTableHeader().setOpaque(false);
        tblTransaction.getTableHeader().setBackground(Color.red);
        tblTransaction.getTableHeader().setForeground(new Color(255,255,255));
        String columnName[] = {"Bill_Detail","Ticket Type","Seat","Price"};
        tableModel.setColumnIdentifiers(columnName);
        tblTransaction.setModel(tableModel);
        DBConnection con = new DBConnection();
        String sql = "Select distinct bds.bill_detail_id,s.row_seat,s.number_seat,tk.ticket_type,bds.price\n" +
                "from Bill_detail_seat bds, Ticket tk, Seat_status ss, Seat s\n" +
                "where tk.ticket_id = bds.ticket_id and ss.id_seat = s.idseat " +
                "and ss.idseat_status = bds.seat_status_id and bds.bill_id = " + idbill;
        System.out.println(sql);
         ResultSet rs = con.getData(sql);
        
        try {
            while(rs.next()) {
                String value[] = new String[4];
                value[0] = ""+rs.getInt("bill_detail_id");
                value[1] = rs.getString("ticket_type");
                value[2] = rs.getString("row_seat") + rs.getString("number_seat");
                value[3] = "" + rs.getInt("Price");

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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransaction = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblTransaction.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblTransaction.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTransaction.setFocusable(false);
        tblTransaction.setGridColor(new java.awt.Color(51, 51, 51));
        tblTransaction.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblTransaction.setName(""); // NOI18N
        tblTransaction.setRowHeight(25);
        tblTransaction.setSelectionBackground(new java.awt.Color(224, 78, 72));
        tblTransaction.setShowGrid(false);
        tblTransaction.setShowHorizontalLines(true);
        tblTransaction.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblTransaction);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 650, 420));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Bill Detail of Bill ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 290, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FormBill_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBill_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBill_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBill_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBill_Detail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTransaction;
    // End of variables declaration//GEN-END:variables
}
