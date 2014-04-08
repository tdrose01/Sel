    package insert;

import javax.swing.*;
import java.sql.*;

public class mysql {

    private static String sql;


    public static void main(String[] args) {

        Student s1 = new Student();

        Student s2 = new Student();
        s2.setStudentId(Integer.parseInt(JOptionPane.showInputDialog("Enter ID for Student 2: [0001]")));
        s2.setFname(JOptionPane.showInputDialog("Enter first name of Student 2: "));
        s2.setLname(JOptionPane.showInputDialog("Enter last name of Student 2: "));
        s2.setAddress(JOptionPane.showInputDialog("Enter address for Student 2: "));
        s2.setPhoneNo(JOptionPane.showInputDialog("Enter phone number for Student 2: "));
        s2.setOtherDetails(JOptionPane.showInputDialog("Enter other details for Student 2: "));

        JOptionPane.showMessageDialog(null,"Student One: \n" + s1.toString() + "\n\nStudent Two: \n" + s2.toString());

        String strConn = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull"; 
   String strUser = "*"; 
   String strPassword = "*"; 

   try { 
    Class.forName("oracle.jdbc.driver.OracleDriver"); 
    Connection conn = DriverManager.getConnection(strConn, strUser, strPassword); 
    //code to execute commands... 

    String query = "INSERT INTO Student(STUDENTID, FNAME, LNAME, ADDRESS, " + 
    "PHONENO, OTHERDETAILS) VALUES (?, ?, ?, ?, ?, ?)"; 

    PreparedStatement pstmt = conn.prepareStatement(sql); 
    pstmt.setInt(1, s2.getStudentId()); 
    pstmt.setString(2, s2.getFname()); 
    pstmt.setString(3, s2.getLname()); 
    pstmt.setString(4, s2.getAddress()); 
    pstmt.setString(5, s2.getPhoneNo()); 
    pstmt.setString(6, s2.getOtherDetails()); 
    pstmt.executeUpdate(); 
    } 

   catch(SQLException e) {
    System.out.println(" A SQL error: " + e.getMessage());
}    
}