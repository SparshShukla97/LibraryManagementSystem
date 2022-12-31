/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;
import java.sql.*;

import java.util.Date;

import javax.swing.JOptionPane;


/**
 *
 * @author lenovo
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    
    //to fetch data of book from database
    
    public void getBookDetails(){
    int bookId = Integer.parseInt(txt_bookId.getText());
      
    try{
    
    Connection con = DBConnection.getConnection();
    PreparedStatement pst = con.prepareStatement("select * from book_details where book_id = ? ");
    pst.setInt(1,bookId);
    ResultSet rs = pst.executeQuery();
    
    if(rs.next()){
    lbl_bookId.setText(rs.getString("book_id"));
    lbl_bookName.setText(rs.getString("book_name"));
    lbl_author.setText(rs.getString("author"));
    lbl_quantity.setText(rs.getString("quantity"));
    
    }
    else{
        lbl_bookId.setText("");
    lbl_bookName.setText("");
    lbl_author.setText("");
    lbl_quantity.setText("");
    lbl_bookError.setText("Invalid Book Details");
    
    }
    
    
    }catch(Exception e){
        e.getMessage();
    }
    
    
    
    }
    
    //to Fetch data fro students from Database
    public void getStudentDetails(){
    int studentId = Integer.parseInt(txt_studentId.getText());
      
    try{
    
    Connection con = DBConnection.getConnection();
    PreparedStatement pst = con.prepareStatement("select * from student_details where student_id = ? ");
    pst.setInt(1,studentId);
    ResultSet rs = pst.executeQuery();
    
    if(rs.next()){
    lbl_studentId.setText(rs.getString("student_id"));
    lbl_studentName.setText(rs.getString("name"));
    lbl_course.setText(rs.getString("course"));
    lbl_branch.setText(rs.getString("branch"));
    
    }else{
        lbl_studentId.setText("");
    lbl_studentName.setText("");
    lbl_course.setText("");
    lbl_branch.setText("");
    lbl_studentError.setText("Invalid Student Details");
    }
    
    
    
    }catch(Exception e){
        e.getMessage();
    }
    
    
    
    }
    
    
    
    //insert issue book details to database 
    public boolean issueBook(){ 
        
      boolean isIssued = false;
    int bookId = Integer.parseInt(txt_bookId.getText());
    int studentId = Integer.parseInt(txt_studentId.getText());
    String bookName = lbl_bookName.getText();
    String studentName = lbl_studentName.getText();
    
    Date uIssueDate =   date_issueDate.getDatoFecha();
    Date uDueDate =   date_dueDate.getDatoFecha();
    
        long l1 = uIssueDate.getTime();
    long l2 = uDueDate.getTime();
    
    java.sql.Date sIssueDate = new java.sql.Date(l1);
    java.sql.Date sDueDate = new java.sql.Date(l2);
    
    try{
    
    Connection con = DBConnection.getConnection();
    String sql = "insert into issue_book_details(book_id,book_name,student_id,student_name,issue_date,due_date,status) values(?,?,?,?,?,?,?)";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setInt(1,bookId);
    pst.setString(2,bookName);
    pst.setInt(3,studentId);
    pst.setString(4,studentName);
    pst.setDate(5, sIssueDate);
    pst.setDate(6,sDueDate);
    pst.setString(7,"pending");
    
    int rowCount = pst.executeUpdate();
     
     if(rowCount > 0){
       isIssued = true ;
     }else{
     
     isIssued = false ;
     }
    
    
    }catch(Exception e){
    
    e.getMessage();
    }
    
    
    
    return isIssued;
    
    
    }
    
    // updating count of the book
     public void updateBookCount(){
     int bookId = Integer.parseInt(txt_bookId.getText());
     try{
     Connection con = DBConnection.getConnection();
     String sql = "update book_details set quantity = quantity -1 where book_id = ?  ";
     PreparedStatement pst = con.prepareStatement(sql);
     pst.setInt(1, bookId);
     
     int rowCount = pst.executeUpdate();
     
     if(rowCount > 0){
       JOptionPane.showMessageDialog(this,"Book Count Updated");
       int initialCount = Integer.parseInt(lbl_quantity.getText());
       lbl_quantity.setText(Integer.toString(initialCount-1));
     }else{
     
     JOptionPane.showMessageDialog(this,"Book Count cannot be Updated");
     }
    
     
     }catch(Exception e){
         
         
         e.getMessage();}
     
     }      
     
     //to check whether book is already allocated is already issued
     
     public boolean isAlreadyIssued(){
     
     
      boolean isAlreadyIssued = false;
    int bookId = Integer.parseInt(txt_bookId.getText());
    int studentId = Integer.parseInt(txt_studentId.getText());
    
    try{
    Connection con = DBConnection.getConnection();
    String sql ="select * from issue_book_details where book_id = ? and student_id = ? and status = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setInt(1,bookId);
    pst.setInt(2,studentId);
    pst.setString(3,"pending");
    
    ResultSet rs = pst.executeQuery();
    if(rs.next()){
    isAlreadyIssued = true ;
    
    }else{isAlreadyIssued = false ;}
    
    
    }catch(Exception e){e.getMessage();}
     
     
     
     return isAlreadyIssued ;
     
     
     }
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        panel_main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbl_course = new javax.swing.JLabel();
        lbl_studentId = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_studentError = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel37 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        date_dueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel39 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        date_issueDate = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle15 = new necesario.RSMaterialButtonCircle();

        jPanel2.setBackground(new java.awt.Color(204, 0, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel12.setText("B A C K");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("    Book Details");
        jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 250, 50));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 180, 50));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 180, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, -1, 40));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 180, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Book Id :");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Book Name :");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Author :");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, 40));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Quantity :");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 90, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 170, 50));

        jPanel5.setBackground(new java.awt.Color(204, 0, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel23.setText("B A C K");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("    Book Details");
        jLabel24.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 250, 50));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 180, 50));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 180, 30));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, -1, 40));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 180, 40));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Book Id :");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Book Name :");
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Author :");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, 40));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Quantity :");
        jPanel5.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 90, 30));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel5.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 170, 50));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(51, 51, 51));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_course.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 190, 50));

        lbl_studentId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_studentId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 190, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, -1, 40));

        lbl_studentName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 190, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Student Id :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Student Name");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Course :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, 40));

        lbl_studentError.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_studentError.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 250, 30));

        lbl_branch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, 190, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("  Student Details");
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 260, 50));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Branch :");
        jPanel1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 90, 30));

        panel_main.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 360, 740));

        jPanel7.setBackground(new java.awt.Color(204, 0, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel34.setText("B A C K");
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("    Book Details");
        jLabel35.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel7.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 250, 50));

        lbl_author.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 180, 50));

        lbl_bookId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_bookId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 180, 30));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel7.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, -1, 40));

        lbl_bookName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 180, 40));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Book Id :");
        jPanel7.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Book Name :");
        jPanel7.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Author :");
        jPanel7.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, 40));

        lbl_bookError.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 51));
        jPanel7.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 210, 30));

        lbl_quantity.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, 170, 50));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Quantity :");
        jPanel7.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 90, 30));

        panel_main.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 740));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("  Student Details");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        panel_main.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 260, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("  Student Details");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        panel_main.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 260, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 31)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Book_50px_1.png"))); // NOI18N
        jLabel2.setText("  Issue Book");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        panel_main.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, 270, 50));

        jPanel13.setBackground(new java.awt.Color(0, 0, 0));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 0, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText(" X");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel13.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 40, 60));

        panel_main.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 0, 40, 40));

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setFont(new java.awt.Font("Swis721 BT", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Book Id :");
        panel_main.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 230, 110, 30));

        txt_bookId.setBackground(new java.awt.Color(51, 51, 51));
        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_bookId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_bookId.setPhColor(new java.awt.Color(255, 255, 255));
        txt_bookId.setPlaceholder("Enter Book id ..");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        panel_main.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 210, 240, 40));

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Swis721 BT", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Due Date :");
        panel_main.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 500, 110, 30));

        txt_studentId.setBackground(new java.awt.Color(51, 51, 51));
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
        panel_main.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 300, 240, 40));

        date_dueDate.setPlaceholder("Select Due date");
        panel_main.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 490, 240, -1));

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setFont(new java.awt.Font("Swis721 BT", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Student Id :");
        panel_main.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 310, 110, 30));

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setFont(new java.awt.Font("Swis721 BT", 0, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Issue Date :");
        panel_main.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 410, 110, 30));

        date_issueDate.setPlaceholder("Select Issue Date");
        panel_main.add(date_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 400, 240, -1));

        rSMaterialButtonCircle15.setBackground(new java.awt.Color(255, 255, 0));
        rSMaterialButtonCircle15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        rSMaterialButtonCircle15.setForeground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonCircle15.setText("ISSUE BOOK");
        rSMaterialButtonCircle15.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        rSMaterialButtonCircle15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle15ActionPerformed(evt);
            }
        });
        panel_main.add(rSMaterialButtonCircle15, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 580, 140, 80));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 740));

        setSize(new java.awt.Dimension(1130, 740));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked
    HomePage home = new HomePage();
    home.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel34MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
      if(!txt_bookId.getText().equals("")){
        
        getBookDetails();}
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
if(!txt_studentId.getText().equals("")){
        
        getStudentDetails();}        
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void rSMaterialButtonCircle15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle15ActionPerformed
        
        if(lbl_quantity.getText().equals("0")){
        JOptionPane.showMessageDialog(this,"Book Is Not Available");
        
        }else{
           if(isAlreadyIssued()== false){              
        
        
        if(issueBook() == true){
                     JOptionPane.showMessageDialog(this,"Book Issued Successfully");
                       updateBookCount();
                      }  else{
                         JOptionPane.showMessageDialog(this ,"Book Issue Failed");
                      
                      }
    }else{
               JOptionPane.showMessageDialog(this ,"this Student has book already");}
        }
        
        
     
    }//GEN-LAST:event_rSMaterialButtonCircle15ActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_dueDate;
    private rojeru_san.componentes.RSDateChooser date_issueDate;
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
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JLabel lbl_studentId;
    private javax.swing.JLabel lbl_studentName;
    private javax.swing.JPanel panel_main;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle15;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
