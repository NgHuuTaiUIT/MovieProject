/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import DTO.Employee_DTO;
import java.awt.Color;
import java.util.HashSet;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.plaf.IconUIResource;

/**
 *
 * @author vnngu
 */
public class LOGIN1 extends javax.swing.JFrame {
    private Vector<Employee_DTO> emp = new Employee_DTO().Display();
   static public Employee_DTO emp_login;
    boolean checkHide = false;
    private boolean checkLogin = false;
    /**
     * Creates new form LOGIN1
     */
    public LOGIN1() {
        initComponents();
        setVisible(true);
    }
   
    public LOGIN1(Vector<Employee_DTO> emp) {
        initComponents();
        this.emp = emp;
        setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtPassword = new javax.swing.JPasswordField();
        txtHide = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        UserName = new javax.swing.JPanel();
        password = new javax.swing.JPanel();
        btnUnHide = new javax.swing.JButton();
        btnHide = new javax.swing.JButton();
        txtUserName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setForeground(new java.awt.Color(51, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPassword.setBackground(new java.awt.Color(255, 153, 0));
        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setText("PassWord");
        txtPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPasswordMouseClicked(evt);
            }
        });
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 210, 20));

        txtHide.setBackground(new java.awt.Color(255, 153, 0));
        txtHide.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtHide.setForeground(new java.awt.Color(255, 255, 255));
        txtHide.setText("PassWord");
        txtHide.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtHide.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHideFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHideFocusLost(evt);
            }
        });
        txtHide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHideMouseClicked(evt);
            }
        });
        jPanel1.add(txtHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 210, 20));

        btnLogin.setBackground(new java.awt.Color(153, 153, 153));
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Sign In");
        btnLogin.setBorder(null);
        btnLogin.setBorderPainted(false);
        btnLogin.setFocusPainted(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 100, 40));

        btnExit.setBackground(new java.awt.Color(255, 153, 0));
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnExit.setText("X");
        btnExit.setBorder(null);
        btnExit.setBorderPainted(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 40, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("LOGIN");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 90, 50));

        javax.swing.GroupLayout UserNameLayout = new javax.swing.GroupLayout(UserName);
        UserName.setLayout(UserNameLayout);
        UserNameLayout.setHorizontalGroup(
            UserNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        UserNameLayout.setVerticalGroup(
            UserNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 240, 2));

        javax.swing.GroupLayout passwordLayout = new javax.swing.GroupLayout(password);
        password.setLayout(passwordLayout);
        passwordLayout.setHorizontalGroup(
            passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        passwordLayout.setVerticalGroup(
            passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 203, 240, 2));

        btnUnHide.setBackground(new java.awt.Color(255, 153, 0));
        btnUnHide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/undide.png"))); // NOI18N
        btnUnHide.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnUnHide.setBorderPainted(false);
        btnUnHide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUnHideMouseClicked(evt);
            }
        });
        jPanel1.add(btnUnHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 19, 15));

        btnHide.setBackground(new java.awt.Color(255, 153, 0));
        btnHide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/hid.png"))); // NOI18N
        btnHide.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnHide.setBorderPainted(false);
        btnHide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHideMouseClicked(evt);
            }
        });
        jPanel1.add(btnHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 19, 15));

        txtUserName.setBackground(new java.awt.Color(255, 153, 0));
        txtUserName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(255, 255, 255));
        txtUserName.setText("UserName");
        txtUserName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserNameFocusLost(evt);
            }
        });
        txtUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUserNameMouseClicked(evt);
            }
        });
        jPanel1.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 122, 240, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/pngwave (1).png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/username.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 20, 30));

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/pngfuel.com (1).png"))); // NOI18N
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public Employee_DTO getEmp_login() {
        return emp_login;
    }

    public void setEmp_login(Employee_DTO emp_login) {
        this.emp_login = emp_login;
    }

    public boolean isCheckLogin() {
        return checkLogin;
    }

    
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String username=txtHide.getText();
        String password=txtPassword.getText();
        int check=1;
        if(username.length()==0)
        {
            this.UserName.setBackground(Color.red);
            check=0;
        }
        if(password.length()==0)
        {
            this.UserName.setBackground(Color.red);
            check=0;
        }
        if(check==1)
        {
            this.UserName.setBackground(Color.white);
            this.password.setBackground(Color.white);
          
        }
        //gan du lieu
        if(checkHide) txtPassword.setText(txtHide.getText());
        //bien kiem tra da nhan ok chua
        
        for(int i = 0; i < emp.size(); i++){
            if(txtUserName.getText().compareTo(emp.get(i).getEmp_username()) == 0 
                    && txtPassword.getText().compareTo(emp.get(i).getEmp_pass()) == 0)
           {
               Success sc= new Success();
               setVisible(false);
               //if(sc.check()){
                    emp_login = emp.get(i);
                    Options opt = new Options(emp_login);
                    opt.setVisible(true);
                    //GUIMovie gui = new GUIMovie(emp_login);
               //}
               checkLogin = true;
               break;
           }
        }
        if(!checkLogin) new ErrorGUI();
         
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtHideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHideMouseClicked
        // TODO add your handling code here:
//       
        if(txtHide.getText().equals("PassWord"))
        {
            txtHide.setText("");
        }
            
    }//GEN-LAST:event_txtHideMouseClicked

    private void txtHideFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHideFocusGained
        // TODO add your handling code here:
//        if(txtUserName.getText().equals(""))
//        {
//            UserName.setBackground(Color.white);
//        }
    }//GEN-LAST:event_txtHideFocusGained

    private void txtHideFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHideFocusLost
        // TODO add your handling code here:
        if(txtHide.getText().equals("")){
            txtHide.setText("PassWord");
            this.UserName.setBackground(Color.red);
           
        }
        else if(!txtHide.getText().equals(""))
       {
            UserName.setBackground(Color.white);
       }
    }//GEN-LAST:event_txtHideFocusLost

    private void txtPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseClicked
        // TODO add your handling code here:
        if(txtPassword.getText().equals("PassWord"))
        {
            txtPassword.setText("");
        }
    }//GEN-LAST:event_txtPasswordMouseClicked

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
        // TODO add your handling code here:
         if(txtPassword.getText().equals("")){
            txtPassword.setText("PassWord");
            this.password.setBackground(Color.red);
        } else if(!txtPassword.getText().equals(""))
       {
            password.setBackground(Color.white);
       }
    }//GEN-LAST:event_txtPasswordFocusLost

    private void txtUserNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameFocusGained

    private void txtUserNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNameFocusLost
        // TODO add your handling code here:
           if(txtUserName.getText().equals("")){
            txtUserName.setText("UserName");
            this.UserName.setBackground(Color.red);
        } else if(!txtUserName.getText().equals(""))
       {
            UserName.setBackground(Color.white);
       }
    }//GEN-LAST:event_txtUserNameFocusLost

    private void txtUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserNameMouseClicked
        // TODO add your handling code here:
        if(txtUserName.getText().equals("UserName"))
            txtUserName.setText("");
    }//GEN-LAST:event_txtUserNameMouseClicked

    private void btnUnHideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUnHideMouseClicked
        // TODO add your handling code here:
        
        this.txtHide.setText(this.txtPassword.getText());
        this.txtPassword.setVisible(false);
        btnUnHide.setVisible(false);
        checkHide =true;
    }//GEN-LAST:event_btnUnHideMouseClicked

    private void btnHideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHideMouseClicked
        // TODO add your handling code here:
        this.txtPassword.setText(this.txtHide.getText());
        this.txtPassword.setVisible(true);
        btnUnHide.setVisible(true);
        checkHide = false;
    }//GEN-LAST:event_btnHideMouseClicked

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordFocusGained

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel UserName;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHide;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnUnHide;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel password;
    private javax.swing.JTextField txtHide;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
