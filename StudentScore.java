package com.student.quizapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentScore implements ScoreRetrival {
	Connection con =null;
	PreparedStatement pstmnt = null;
@Override
public void retriveScore() throws SQLException {
	try {
		ConnectionTest test = new ConnectionTest();
		con = test.getConnectionDetails();
		//Create statement
		pstmnt =con.prepareStatement("select * from student");
		//submit the SQL statement to database
		ResultSet rset = pstmnt.executeQuery();
		System.out.println("Record of quiz attended students.....................");
		while(rset.next()) {
			System.out.println("Student Id is :"+rset.getInt(1));
			System.out.println("Student Name is :"+rset.getString(2));
			System.out.println("Student score is :"+rset.getInt(3));
			System.out.println("................................................................................................................................................................");
		}
		//Retriving student information from database using id
		System.out.println("To fetch record of particular student from the student Id.........");
		     Scanner scan = new Scanner(System.in);
		     System.out.println("Enter Studentid");
		    int  stdId = scan.nextInt();
		     pstmnt= con.prepareStatement("select * from student where studentid=?");
		     pstmnt.setInt(1, stdId);
		     //Submit statement to database
		     ResultSet rs =pstmnt.executeQuery();
		     while(rs.next()) {
		   System.out.println("Student Name is :"+rs.getString(2));
		   System.out.println("Student Score is :"+rs.getInt(3));
		     }
		rset.close();
	}catch(Exception e) {
	System.out.println(e);
	}finally {
		con.close();
		pstmnt.close();
		
	}
}
	
	
}
