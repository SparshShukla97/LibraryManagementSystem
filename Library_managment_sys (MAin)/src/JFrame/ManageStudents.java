/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;



import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author lenovo
 */
public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    
    String studentName,course,branch;
    int studentId;
    DefaultTableModel model;
    public ManageStudents() {
        initComponents();
        setStudentDetailsToTable();
    }
    
    //Book Details into the table
    public void setStudentDetailsToTable(){
    
    try{
     Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("select * from student_details");
   
    while(rs.next()){
     
           int studentId = rs.getInt("student_id");
          String studentName = rs.getString("name");
         String course = rs.getString("course");
         String branch = rs.getString("branch");
         
         Object[] obj = {studentId,studentName,course,branch};
          model = (DefaultTableModel) tbl_studentDetails.getModel();
         model.addRow(obj);
         
         
       }
    }catch(Exception e){
        e.getMessage();
    
    }
                                                                                                                                                                                                                                                                                                                                                       
    
    
    }
    // to add Student Details to the Table
    public boolean addStudent(){
        
        boolean isAdded = false;
        
        studentId =Integer.parseInt( txt_studentId.getText());
        studentName = txt_studentName.getText();
        course = combo_CourseName.getSelectedItem().toString();
        branch = combo_branch.getSelectedItem().toString();
        
        
        try{
        Connection con = DBConnection.getConnection();
        String sql = "insert into student_details values(?,?,?,?)";
             
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, studentId);
        pst.setString(2, studentName);
        pst.setString(3, course);
        pst.setString(4, branch);
        
        
        int rowCount = pst.executeUpdate();
        if(rowCount >0){
            isAdded= true ;
            
        
            
        }else{
        isAdded= false;
        }
                
        
        }catch(Exception e){
        e.getMessage();}
        
    return isAdded;
    
    }
     //Method to  Clear Table
     public void clearTable(){
     DefaultTableModel model = (DefaultTableModel) tbl_studentDetails.getModel();
     model.setRowCount(0);
     
    } 
     
     // to update Student details
      public boolean updateStudent(){
          
          boolean isUpdated = false;
        
       studentId =Integer.parseInt( txt_studentId.getText());
        studentName = txt_studentName.getText();
        course = combo_CourseName.getSelectedItem().toString();
        branch = combo_branch.getSelectedItem().toString();
        
        
          try{
              Connection con = DBConnection.getConnection();
          String sql = "update student_details set name = ?,course = ?, branch = ? where student_id = ?";
          PreparedStatement pst = con.prepareStatement(sql);
          
        pst.setString(1, studentName);
        pst.setString(2, course);
        pst.setString(3, branch);
         pst.setInt(4, studentId);
         
        int rowCount = pst.executeUpdate();
        if(rowCount >0){
        isUpdated = true ;
        }else{
        
        isUpdated = false;
        }
          
          
          
          
          
          }catch(Exception e){
          
          e.getMessage();
          }
      return isUpdated ;
      
      
      
      }
      
      // to Delete The Student Row
      public boolean deleteStudent(){
      boolean isDeleted = false;
      studentId =Integer.parseInt( txt_studentId.getText());
      
      try{
      Connection con = DBConnection.getConnection();
          String sql = "delete from student_details where student_id = ?";
          PreparedStatement pst = con.prepareStatement(sql);
          pst.setInt(1,studentId);
          
          
          int rowCount = pst.executeUpdate();
          if(rowCount >0){
          isDeleted = true;
          }else {
          isDeleted = false;
          
          }
      
      }
      
      catch(Exception e){
      e.getMessage();
      }
      return isDeleted;
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_username1 = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_password = new app.bolivia.swing.JCTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_email = new app.bolivia.swing.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_contact = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle2 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_username2 = new app.bolivia.swing.JCTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_password1 = new app.bolivia.swing.JCTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txt_email1 = new app.bolivia.swing.JCTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt_contact1 = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle3 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new necesario.RSMaterialButtonCircle();
        jLabel28 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txt_username3 = new app.bolivia.swing.JCTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txt_password2 = new app.bolivia.swing.JCTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txt_email2 = new app.bolivia.swing.JCTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txt_contact2 = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle5 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle6 = new necesario.RSMaterialButtonCircle();
        jLabel39 = new javax.swing.JLabel();
        txt_studentName = new app.bolivia.swing.JCTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txt_sturdentid = new app.bolivia.swing.JCTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        txt_username5 = new app.bolivia.swing.JCTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txt_password6 = new app.bolivia.swing.JCTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        txt_email3 = new app.bolivia.swing.JCTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        txt_contact3 = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle7 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle8 = new necesario.RSMaterialButtonCircle();
        jLabel58 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        txt_username6 = new app.bolivia.swing.JCTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        txt_password7 = new app.bolivia.swing.JCTextField();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        txt_email4 = new app.bolivia.swing.JCTextField();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        txt_contact4 = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle9 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle10 = new necesario.RSMaterialButtonCircle();
        jLabel69 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        txt_username7 = new app.bolivia.swing.JCTextField();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        txt_password8 = new app.bolivia.swing.JCTextField();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        txt_email5 = new app.bolivia.swing.JCTextField();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        txt_contact5 = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle11 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle12 = new necesario.RSMaterialButtonCircle();
        jLabel80 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        txt_studentname = new app.bolivia.swing.JCTextField();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        rSMaterialButtonCircle13 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle14 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle15 = new necesario.RSMaterialButtonCircle();
        jLabel43 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        combo_branch = new javax.swing.JComboBox<>();
        combo_CourseName = new javax.swing.JComboBox<>();
        jPanel12 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojerusan.RSTableMetro();
        jLabel45 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("B A C K");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        txt_studentId.setBackground(new java.awt.Color(0, 102, 204));
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_studentId.setPhColor(new java.awt.Color(255, 255, 255));
        txt_studentId.setPlaceholder("Enter Student id ..");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        jPanel2.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 310, 40));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(" X");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 40, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Create New Account Here");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 370, 30));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Username");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 370, 30));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 50, 60));

        txt_username1.setBackground(new java.awt.Color(51, 51, 51));
        txt_username1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_username1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_username1.setPhColor(new java.awt.Color(204, 204, 204));
        txt_username1.setPlaceholder("Enter Username");
        txt_username1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_username1FocusLost(evt);
            }
        });
        txt_username1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_username1ActionPerformed(evt);
            }
        });
        jPanel4.add(txt_username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 380, 40));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Password");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 370, 30));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secure_50px.png"))); // NOI18N
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 60, 60));

        txt_password.setBackground(new java.awt.Color(51, 51, 51));
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_password.setPhColor(new java.awt.Color(204, 204, 204));
        txt_password.setPlaceholder("Enter Password ..");
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        jPanel4.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 380, 40));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Email");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 370, 30));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secured_Letter_50px.png"))); // NOI18N
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 60, 50));

        txt_email.setBackground(new java.awt.Color(51, 51, 51));
        txt_email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_email.setPhColor(new java.awt.Color(204, 204, 204));
        txt_email.setPlaceholder("Enter Email ..");
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        jPanel4.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 380, 40));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contact No.");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 370, 30));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Google_Mobile_50px.png"))); // NOI18N
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 50, 70));

        txt_contact.setBackground(new java.awt.Color(51, 51, 51));
        txt_contact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_contact.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_contact.setPhColor(new java.awt.Color(204, 204, 204));
        txt_contact.setPlaceholder("Enter phone no.");
        txt_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contactActionPerformed(evt);
            }
        });
        jPanel4.add(txt_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 570, 380, 40));

        rSMaterialButtonCircle2.setText("SIGN UP");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel4.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 670, 180, 80));

        rSMaterialButtonCircle1.setText("LOG IN");
        jPanel4.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 670, 180, 80));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("SIGNUP PAGE");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 260, 30));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 540, 830));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText(" X");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 40, 30));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Create New Account Here");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 370, 30));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Username");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 370, 30));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 50, 60));

        txt_username2.setBackground(new java.awt.Color(51, 51, 51));
        txt_username2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_username2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_username2.setPhColor(new java.awt.Color(204, 204, 204));
        txt_username2.setPlaceholder("Enter Username");
        txt_username2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_username2FocusLost(evt);
            }
        });
        txt_username2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_username2ActionPerformed(evt);
            }
        });
        jPanel5.add(txt_username2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 380, 40));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Password");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 370, 30));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secure_50px.png"))); // NOI18N
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 60, 60));

        txt_password1.setBackground(new java.awt.Color(51, 51, 51));
        txt_password1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_password1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_password1.setPhColor(new java.awt.Color(204, 204, 204));
        txt_password1.setPlaceholder("Enter Password ..");
        txt_password1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_password1ActionPerformed(evt);
            }
        });
        jPanel5.add(txt_password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 380, 40));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Email");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 370, 30));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secured_Letter_50px.png"))); // NOI18N
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 60, 50));

        txt_email1.setBackground(new java.awt.Color(51, 51, 51));
        txt_email1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_email1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_email1.setPhColor(new java.awt.Color(204, 204, 204));
        txt_email1.setPlaceholder("Enter Email ..");
        txt_email1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_email1ActionPerformed(evt);
            }
        });
        jPanel5.add(txt_email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 380, 40));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Contact No.");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 370, 30));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Google_Mobile_50px.png"))); // NOI18N
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 50, 70));

        txt_contact1.setBackground(new java.awt.Color(51, 51, 51));
        txt_contact1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_contact1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_contact1.setPhColor(new java.awt.Color(204, 204, 204));
        txt_contact1.setPlaceholder("Enter phone no.");
        txt_contact1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contact1ActionPerformed(evt);
            }
        });
        jPanel5.add(txt_contact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 570, 380, 40));

        rSMaterialButtonCircle3.setText("SIGN UP");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel5.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 670, 180, 80));

        rSMaterialButtonCircle4.setText("LOG IN");
        jPanel5.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 670, 180, 80));

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("SIGNUP PAGE");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 260, 30));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 540, 830));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText(" X");
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 40, 30));

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setText("Create New Account Here");
        jPanel6.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 370, 30));

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Username");
        jPanel6.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 370, 30));

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 50, 60));

        txt_username3.setBackground(new java.awt.Color(51, 51, 51));
        txt_username3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_username3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_username3.setPhColor(new java.awt.Color(204, 204, 204));
        txt_username3.setPlaceholder("Enter Username");
        txt_username3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_username3FocusLost(evt);
            }
        });
        txt_username3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_username3ActionPerformed(evt);
            }
        });
        jPanel6.add(txt_username3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 380, 40));

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Password");
        jPanel6.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 370, 30));

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secure_50px.png"))); // NOI18N
        jPanel6.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 60, 60));

        txt_password2.setBackground(new java.awt.Color(51, 51, 51));
        txt_password2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_password2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_password2.setPhColor(new java.awt.Color(204, 204, 204));
        txt_password2.setPlaceholder("Enter Password ..");
        txt_password2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_password2ActionPerformed(evt);
            }
        });
        jPanel6.add(txt_password2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 380, 40));

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Email");
        jPanel6.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 370, 30));

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secured_Letter_50px.png"))); // NOI18N
        jPanel6.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 60, 50));

        txt_email2.setBackground(new java.awt.Color(51, 51, 51));
        txt_email2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_email2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_email2.setPhColor(new java.awt.Color(204, 204, 204));
        txt_email2.setPlaceholder("Enter Email ..");
        txt_email2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_email2ActionPerformed(evt);
            }
        });
        jPanel6.add(txt_email2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 380, 40));

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Contact No.");
        jPanel6.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 370, 30));

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Google_Mobile_50px.png"))); // NOI18N
        jPanel6.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 50, 70));

        txt_contact2.setBackground(new java.awt.Color(51, 51, 51));
        txt_contact2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_contact2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_contact2.setPhColor(new java.awt.Color(204, 204, 204));
        txt_contact2.setPlaceholder("Enter phone no.");
        txt_contact2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contact2ActionPerformed(evt);
            }
        });
        jPanel6.add(txt_contact2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 570, 380, 40));

        rSMaterialButtonCircle5.setText("SIGN UP");
        rSMaterialButtonCircle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle5ActionPerformed(evt);
            }
        });
        jPanel6.add(rSMaterialButtonCircle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 670, 180, 80));

        rSMaterialButtonCircle6.setText("LOG IN");
        jPanel6.add(rSMaterialButtonCircle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 670, 180, 80));

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("SIGNUP PAGE");
        jPanel6.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 260, 30));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 540, 830));

        txt_studentName.setBackground(new java.awt.Color(0, 102, 204));
        txt_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_studentName.setPhColor(new java.awt.Color(255, 255, 255));
        txt_studentName.setPlaceholder("Enter Student Name");
        txt_studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentNameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 310, 40));

        jPanel7.setBackground(new java.awt.Color(0, 102, 204));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("B A C K");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        jLabel47.setBackground(new java.awt.Color(255, 255, 255));
        jLabel47.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel7.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 40, 60));

        txt_sturdentid.setBackground(new java.awt.Color(0, 102, 204));
        txt_sturdentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_sturdentid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_sturdentid.setPhColor(new java.awt.Color(204, 204, 204));
        txt_sturdentid.setPlaceholder("Enter Username");
        txt_sturdentid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_sturdentidFocusLost(evt);
            }
        });
        txt_sturdentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sturdentidActionPerformed(evt);
            }
        });
        jPanel7.add(txt_sturdentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 310, 40));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setBackground(new java.awt.Color(255, 255, 255));
        jLabel48.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText(" X");
        jLabel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel48MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 40, 30));

        jLabel49.setBackground(new java.awt.Color(255, 255, 255));
        jLabel49.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(102, 102, 102));
        jLabel49.setText("Create New Account Here");
        jPanel9.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 370, 30));

        jLabel50.setBackground(new java.awt.Color(255, 255, 255));
        jLabel50.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Username");
        jPanel9.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 370, 30));

        jLabel51.setBackground(new java.awt.Color(255, 255, 255));
        jLabel51.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel9.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 50, 60));

        txt_username5.setBackground(new java.awt.Color(51, 51, 51));
        txt_username5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_username5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_username5.setPhColor(new java.awt.Color(204, 204, 204));
        txt_username5.setPlaceholder("Enter Username");
        txt_username5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_username5FocusLost(evt);
            }
        });
        txt_username5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_username5ActionPerformed(evt);
            }
        });
        jPanel9.add(txt_username5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 380, 40));

        jLabel52.setBackground(new java.awt.Color(255, 255, 255));
        jLabel52.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Password");
        jPanel9.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 370, 30));

        jLabel53.setBackground(new java.awt.Color(255, 255, 255));
        jLabel53.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secure_50px.png"))); // NOI18N
        jPanel9.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 60, 60));

        txt_password6.setBackground(new java.awt.Color(51, 51, 51));
        txt_password6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_password6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_password6.setPhColor(new java.awt.Color(204, 204, 204));
        txt_password6.setPlaceholder("Enter Password ..");
        txt_password6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_password6ActionPerformed(evt);
            }
        });
        jPanel9.add(txt_password6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 380, 40));

        jLabel54.setBackground(new java.awt.Color(255, 255, 255));
        jLabel54.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Email");
        jPanel9.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 370, 30));

        jLabel55.setBackground(new java.awt.Color(255, 255, 255));
        jLabel55.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secured_Letter_50px.png"))); // NOI18N
        jPanel9.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 60, 50));

        txt_email3.setBackground(new java.awt.Color(51, 51, 51));
        txt_email3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_email3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_email3.setPhColor(new java.awt.Color(204, 204, 204));
        txt_email3.setPlaceholder("Enter Email ..");
        txt_email3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_email3ActionPerformed(evt);
            }
        });
        jPanel9.add(txt_email3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 380, 40));

        jLabel56.setBackground(new java.awt.Color(255, 255, 255));
        jLabel56.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Contact No.");
        jPanel9.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 370, 30));

        jLabel57.setBackground(new java.awt.Color(255, 255, 255));
        jLabel57.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Google_Mobile_50px.png"))); // NOI18N
        jPanel9.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 50, 70));

        txt_contact3.setBackground(new java.awt.Color(51, 51, 51));
        txt_contact3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_contact3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_contact3.setPhColor(new java.awt.Color(204, 204, 204));
        txt_contact3.setPlaceholder("Enter phone no.");
        txt_contact3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contact3ActionPerformed(evt);
            }
        });
        jPanel9.add(txt_contact3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 570, 380, 40));

        rSMaterialButtonCircle7.setText("SIGN UP");
        rSMaterialButtonCircle7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle7ActionPerformed(evt);
            }
        });
        jPanel9.add(rSMaterialButtonCircle7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 670, 180, 80));

        rSMaterialButtonCircle8.setText("LOG IN");
        jPanel9.add(rSMaterialButtonCircle8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 670, 180, 80));

        jLabel58.setBackground(new java.awt.Color(255, 255, 255));
        jLabel58.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("SIGNUP PAGE");
        jPanel9.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 260, 30));

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 540, 830));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));
        jPanel10.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel59.setBackground(new java.awt.Color(255, 255, 255));
        jLabel59.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText(" X");
        jLabel59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel59MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 40, 30));

        jLabel60.setBackground(new java.awt.Color(255, 255, 255));
        jLabel60.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(102, 102, 102));
        jLabel60.setText("Create New Account Here");
        jPanel10.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 370, 30));

        jLabel61.setBackground(new java.awt.Color(255, 255, 255));
        jLabel61.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Username");
        jPanel10.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 370, 30));

        jLabel62.setBackground(new java.awt.Color(255, 255, 255));
        jLabel62.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel10.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 50, 60));

        txt_username6.setBackground(new java.awt.Color(51, 51, 51));
        txt_username6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_username6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_username6.setPhColor(new java.awt.Color(204, 204, 204));
        txt_username6.setPlaceholder("Enter Username");
        txt_username6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_username6FocusLost(evt);
            }
        });
        txt_username6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_username6ActionPerformed(evt);
            }
        });
        jPanel10.add(txt_username6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 380, 40));

        jLabel63.setBackground(new java.awt.Color(255, 255, 255));
        jLabel63.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Password");
        jPanel10.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 370, 30));

        jLabel64.setBackground(new java.awt.Color(255, 255, 255));
        jLabel64.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secure_50px.png"))); // NOI18N
        jPanel10.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 60, 60));

        txt_password7.setBackground(new java.awt.Color(51, 51, 51));
        txt_password7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_password7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_password7.setPhColor(new java.awt.Color(204, 204, 204));
        txt_password7.setPlaceholder("Enter Password ..");
        txt_password7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_password7ActionPerformed(evt);
            }
        });
        jPanel10.add(txt_password7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 380, 40));

        jLabel65.setBackground(new java.awt.Color(255, 255, 255));
        jLabel65.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Email");
        jPanel10.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 370, 30));

        jLabel66.setBackground(new java.awt.Color(255, 255, 255));
        jLabel66.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secured_Letter_50px.png"))); // NOI18N
        jPanel10.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 60, 50));

        txt_email4.setBackground(new java.awt.Color(51, 51, 51));
        txt_email4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_email4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_email4.setPhColor(new java.awt.Color(204, 204, 204));
        txt_email4.setPlaceholder("Enter Email ..");
        txt_email4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_email4ActionPerformed(evt);
            }
        });
        jPanel10.add(txt_email4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 380, 40));

        jLabel67.setBackground(new java.awt.Color(255, 255, 255));
        jLabel67.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("Contact No.");
        jPanel10.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 370, 30));

        jLabel68.setBackground(new java.awt.Color(255, 255, 255));
        jLabel68.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Google_Mobile_50px.png"))); // NOI18N
        jPanel10.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 50, 70));

        txt_contact4.setBackground(new java.awt.Color(51, 51, 51));
        txt_contact4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_contact4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_contact4.setPhColor(new java.awt.Color(204, 204, 204));
        txt_contact4.setPlaceholder("Enter phone no.");
        txt_contact4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contact4ActionPerformed(evt);
            }
        });
        jPanel10.add(txt_contact4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 570, 380, 40));

        rSMaterialButtonCircle9.setText("SIGN UP");
        rSMaterialButtonCircle9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle9ActionPerformed(evt);
            }
        });
        jPanel10.add(rSMaterialButtonCircle9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 670, 180, 80));

        rSMaterialButtonCircle10.setText("LOG IN");
        jPanel10.add(rSMaterialButtonCircle10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 670, 180, 80));

        jLabel69.setBackground(new java.awt.Color(255, 255, 255));
        jLabel69.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("SIGNUP PAGE");
        jPanel10.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 260, 30));

        jPanel7.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 540, 830));

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));
        jPanel11.setForeground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel70.setBackground(new java.awt.Color(255, 255, 255));
        jLabel70.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText(" X");
        jLabel70.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel70MouseClicked(evt);
            }
        });
        jPanel11.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 40, 30));

        jLabel71.setBackground(new java.awt.Color(255, 255, 255));
        jLabel71.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(102, 102, 102));
        jLabel71.setText("Create New Account Here");
        jPanel11.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 370, 30));

        jLabel72.setBackground(new java.awt.Color(255, 255, 255));
        jLabel72.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("Username");
        jPanel11.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 370, 30));

        jLabel73.setBackground(new java.awt.Color(255, 255, 255));
        jLabel73.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel11.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 50, 60));

        txt_username7.setBackground(new java.awt.Color(51, 51, 51));
        txt_username7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_username7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_username7.setPhColor(new java.awt.Color(204, 204, 204));
        txt_username7.setPlaceholder("Enter Username");
        txt_username7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_username7FocusLost(evt);
            }
        });
        txt_username7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_username7ActionPerformed(evt);
            }
        });
        jPanel11.add(txt_username7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 380, 40));

        jLabel74.setBackground(new java.awt.Color(255, 255, 255));
        jLabel74.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("Password");
        jPanel11.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 370, 30));

        jLabel75.setBackground(new java.awt.Color(255, 255, 255));
        jLabel75.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secure_50px.png"))); // NOI18N
        jPanel11.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 60, 60));

        txt_password8.setBackground(new java.awt.Color(51, 51, 51));
        txt_password8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_password8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_password8.setPhColor(new java.awt.Color(204, 204, 204));
        txt_password8.setPlaceholder("Enter Password ..");
        txt_password8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_password8ActionPerformed(evt);
            }
        });
        jPanel11.add(txt_password8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 380, 40));

        jLabel76.setBackground(new java.awt.Color(255, 255, 255));
        jLabel76.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("Email");
        jPanel11.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 370, 30));

        jLabel77.setBackground(new java.awt.Color(255, 255, 255));
        jLabel77.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secured_Letter_50px.png"))); // NOI18N
        jPanel11.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 60, 50));

        txt_email5.setBackground(new java.awt.Color(51, 51, 51));
        txt_email5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_email5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_email5.setPhColor(new java.awt.Color(204, 204, 204));
        txt_email5.setPlaceholder("Enter Email ..");
        txt_email5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_email5ActionPerformed(evt);
            }
        });
        jPanel11.add(txt_email5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 380, 40));

        jLabel78.setBackground(new java.awt.Color(255, 255, 255));
        jLabel78.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("Contact No.");
        jPanel11.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 370, 30));

        jLabel79.setBackground(new java.awt.Color(255, 255, 255));
        jLabel79.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Google_Mobile_50px.png"))); // NOI18N
        jPanel11.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 50, 70));

        txt_contact5.setBackground(new java.awt.Color(51, 51, 51));
        txt_contact5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_contact5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_contact5.setPhColor(new java.awt.Color(204, 204, 204));
        txt_contact5.setPlaceholder("Enter phone no.");
        txt_contact5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contact5ActionPerformed(evt);
            }
        });
        jPanel11.add(txt_contact5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 570, 380, 40));

        rSMaterialButtonCircle11.setText("SIGN UP");
        rSMaterialButtonCircle11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle11ActionPerformed(evt);
            }
        });
        jPanel11.add(rSMaterialButtonCircle11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 670, 180, 80));

        rSMaterialButtonCircle12.setText("LOG IN");
        jPanel11.add(rSMaterialButtonCircle12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 670, 180, 80));

        jLabel80.setBackground(new java.awt.Color(255, 255, 255));
        jLabel80.setFont(new java.awt.Font("Segoe UI Historic", 1, 32)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setText("SIGNUP PAGE");
        jPanel11.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 260, 30));

        jPanel7.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 540, 830));

        jLabel82.setBackground(new java.awt.Color(255, 255, 255));
        jLabel82.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel7.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, 60));

        txt_studentname.setBackground(new java.awt.Color(0, 102, 204));
        txt_studentname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_studentname.setPhColor(new java.awt.Color(204, 204, 204));
        txt_studentname.setPlaceholder("Enter Password ..");
        txt_studentname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentnameActionPerformed(evt);
            }
        });
        jPanel7.add(txt_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 310, 40));

        jLabel85.setBackground(new java.awt.Color(255, 255, 255));
        jLabel85.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setText("Select Branch");
        jPanel7.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 290, 30));

        jLabel86.setBackground(new java.awt.Color(255, 255, 255));
        jLabel86.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel7.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, 60));

        rSMaterialButtonCircle13.setBackground(new java.awt.Color(255, 255, 255));
        rSMaterialButtonCircle13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        rSMaterialButtonCircle13.setForeground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonCircle13.setText("DELETE");
        rSMaterialButtonCircle13.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        rSMaterialButtonCircle13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle13ActionPerformed(evt);
            }
        });
        jPanel7.add(rSMaterialButtonCircle13, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 640, 90, 80));

        rSMaterialButtonCircle14.setBackground(new java.awt.Color(255, 255, 255));
        rSMaterialButtonCircle14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        rSMaterialButtonCircle14.setForeground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonCircle14.setText("ADD");
        rSMaterialButtonCircle14.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        rSMaterialButtonCircle14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle14ActionPerformed(evt);
            }
        });
        jPanel7.add(rSMaterialButtonCircle14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, 90, 80));

        rSMaterialButtonCircle15.setBackground(new java.awt.Color(255, 255, 255));
        rSMaterialButtonCircle15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        rSMaterialButtonCircle15.setForeground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonCircle15.setText("UPDATE");
        rSMaterialButtonCircle15.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        rSMaterialButtonCircle15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle15ActionPerformed(evt);
            }
        });
        jPanel7.add(rSMaterialButtonCircle15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 640, 90, 80));

        jLabel43.setBackground(new java.awt.Color(255, 255, 255));
        jLabel43.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel7.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, 60));

        jLabel42.setBackground(new java.awt.Color(255, 255, 255));
        jLabel42.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Select Course");
        jPanel7.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 290, 30));

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Enter Student Name");
        jPanel7.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 290, 30));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Swis721 BT", 0, 25)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Enter Student ID");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 240, 30));

        combo_branch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        combo_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Computer sCIENCE", "Mechanical ", "Electronics", "BBA", "MBA", "Bio-Tech" }));
        combo_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_branchActionPerformed(evt);
            }
        });
        jPanel7.add(combo_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, 320, 30));

        combo_CourseName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        combo_CourseName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Engineering", "Medical", "Bio-Tech", "Business Studies" }));
        combo_CourseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_CourseNameActionPerformed(evt);
            }
        });
        jPanel7.add(combo_CourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 442, 320, 30));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 800));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 800));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 35)); // NOI18N
        jLabel4.setText(" X");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(0, 0, 0)));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 10, 50, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 35)); // NOI18N
        jLabel8.setText(" X");
        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(0, 0, 0)));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 10, 50, 40));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 35)); // NOI18N
        jLabel41.setText(" X");
        jLabel41.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(0, 0, 0)));
        jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel41MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 10, 50, 40));

        jPanel13.setBackground(new java.awt.Color(0, 0, 0));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel13.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 40, 60));

        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 40, 40));

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(0, 112, 192));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_studentDetails.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_studentDetails.setFont(new java.awt.Font("Segoe UI Emoji", 0, 36)); // NOI18N
        tbl_studentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        tbl_studentDetails.setRowHeight(30);
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_studentDetails);

        jPanel12.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 590, 250));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel45.setText(" Manage Students");
        jPanel12.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 350, -1));

        getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 850, 760));

        setSize(new java.awt.Dimension(1300, 760));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

        
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
        
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
       
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void txt_username1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_username1FocusLost
        
    }//GEN-LAST:event_txt_username1FocusLost

    private void txt_username1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_username1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_username1ActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
          // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseClicked

    private void txt_username2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_username2FocusLost
       
    }//GEN-LAST:event_txt_username2FocusLost

    private void txt_username2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_username2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_username2ActionPerformed

    private void txt_password1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_password1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_password1ActionPerformed

    private void txt_email1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_email1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_email1ActionPerformed

    private void txt_contact1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contact1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contact1ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseClicked

    private void txt_username3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_username3FocusLost
      
    }//GEN-LAST:event_txt_username3FocusLost

    private void txt_username3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_username3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_username3ActionPerformed

    private void txt_password2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_password2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_password2ActionPerformed

    private void txt_email2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_email2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_email2ActionPerformed

    private void txt_contact2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contact2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contact2ActionPerformed

    private void rSMaterialButtonCircle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle5ActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle5ActionPerformed

    private void txt_studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txt_sturdentidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_sturdentidFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sturdentidFocusLost

    private void txt_sturdentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sturdentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sturdentidActionPerformed

    private void jLabel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel48MouseClicked

    private void txt_username5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_username5FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_username5FocusLost

    private void txt_username5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_username5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_username5ActionPerformed

    private void txt_password6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_password6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_password6ActionPerformed

    private void txt_email3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_email3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_email3ActionPerformed

    private void txt_contact3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contact3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contact3ActionPerformed

    private void rSMaterialButtonCircle7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle7ActionPerformed

    private void jLabel59MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel59MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel59MouseClicked

    private void txt_username6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_username6FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_username6FocusLost

    private void txt_username6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_username6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_username6ActionPerformed

    private void txt_password7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_password7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_password7ActionPerformed

    private void txt_email4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_email4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_email4ActionPerformed

    private void txt_contact4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contact4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contact4ActionPerformed

    private void rSMaterialButtonCircle9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle9ActionPerformed

    private void jLabel70MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel70MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel70MouseClicked

    private void txt_username7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_username7FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_username7FocusLost

    private void txt_username7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_username7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_username7ActionPerformed

    private void txt_password8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_password8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_password8ActionPerformed

    private void txt_email5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_email5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_email5ActionPerformed

    private void txt_contact5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contact5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contact5ActionPerformed

    private void rSMaterialButtonCircle11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle11ActionPerformed

    private void txt_studentnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentnameActionPerformed

    private void rSMaterialButtonCircle13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle13ActionPerformed
          if(deleteStudent()==true){
      JOptionPane.showMessageDialog(this,"Student Details Deleted");
      clearTable();
      setStudentDetailsToTable();
      
      
      }else{
      JOptionPane.showMessageDialog(this, "Student Details Deletion Failed");
      }// TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle13ActionPerformed

    private void rSMaterialButtonCircle14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle14ActionPerformed
      if(addStudent()==true){
      JOptionPane.showMessageDialog(this,"Student Details Added");
      clearTable();
      setStudentDetailsToTable();
      
      
      }else{
      JOptionPane.showMessageDialog(this, "Student details Addition Failed");
      }
    }//GEN-LAST:event_rSMaterialButtonCircle14ActionPerformed

    private void rSMaterialButtonCircle15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle15ActionPerformed
     if(updateStudent()==true){
      JOptionPane.showMessageDialog(this,"Student Details Updated");
      clearTable();
      setStudentDetailsToTable();
      
      
      }else{
      JOptionPane.showMessageDialog(this, "Student Details Updation Failed");
      }        
    }//GEN-LAST:event_rSMaterialButtonCircle15ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel41MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
   System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked

     int rowNo= tbl_studentDetails.getSelectedRow();
     TableModel model = tbl_studentDetails.getModel();
     
     txt_studentId.setText(model.getValueAt(rowNo, 0).toString());
     txt_studentName.setText(model.getValueAt(rowNo, 1).toString());
     combo_CourseName.setSelectedItem(model.getValueAt(rowNo,2).toString());
     combo_branch.setSelectedItem(model.getValueAt(rowNo,3).toString());
    
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

    private void combo_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_branchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_branchActionPerformed

    private void combo_CourseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_CourseNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_CourseNameActionPerformed

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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_CourseName;
    private javax.swing.JComboBox<String> combo_branch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle10;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle11;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle12;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle13;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle14;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle15;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle5;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle6;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle7;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle8;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle9;
    private rojerusan.RSTableMetro tbl_studentDetails;
    private app.bolivia.swing.JCTextField txt_contact;
    private app.bolivia.swing.JCTextField txt_contact1;
    private app.bolivia.swing.JCTextField txt_contact2;
    private app.bolivia.swing.JCTextField txt_contact3;
    private app.bolivia.swing.JCTextField txt_contact4;
    private app.bolivia.swing.JCTextField txt_contact5;
    private app.bolivia.swing.JCTextField txt_email;
    private app.bolivia.swing.JCTextField txt_email1;
    private app.bolivia.swing.JCTextField txt_email2;
    private app.bolivia.swing.JCTextField txt_email3;
    private app.bolivia.swing.JCTextField txt_email4;
    private app.bolivia.swing.JCTextField txt_email5;
    private app.bolivia.swing.JCTextField txt_password;
    private app.bolivia.swing.JCTextField txt_password1;
    private app.bolivia.swing.JCTextField txt_password2;
    private app.bolivia.swing.JCTextField txt_password6;
    private app.bolivia.swing.JCTextField txt_password7;
    private app.bolivia.swing.JCTextField txt_password8;
    private app.bolivia.swing.JCTextField txt_studentId;
    private app.bolivia.swing.JCTextField txt_studentName;
    private app.bolivia.swing.JCTextField txt_studentname;
    private app.bolivia.swing.JCTextField txt_sturdentid;
    private app.bolivia.swing.JCTextField txt_username1;
    private app.bolivia.swing.JCTextField txt_username2;
    private app.bolivia.swing.JCTextField txt_username3;
    private app.bolivia.swing.JCTextField txt_username5;
    private app.bolivia.swing.JCTextField txt_username6;
    private app.bolivia.swing.JCTextField txt_username7;
    // End of variables declaration//GEN-END:variables
}
