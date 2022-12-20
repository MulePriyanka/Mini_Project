package com.student.quizapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Question {
	Connection con = null;
	PreparedStatement pstmnt = null;
	
	@SuppressWarnings("unused")
	private void insertQuestionData() throws SQLException  {
		
		try {
			 //Create an Object of ConnectionTest Class
			ConnectionTest ct = new ConnectionTest();
			con =ct.getConnectionDetails();
			//prepare statement
			PreparedStatement pstmt = con.prepareStatement("insert into question(questionid,question,option1,option2,option3,option4)values(?,?,?,?,?,?)");
			pstmt.setInt(1,1);
			pstmt.setString(2, "Arrays in java are");
			pstmt.setString(3,"Object referance");
			pstmt.setString(4,"Object");
			pstmt.setString(5,"Premitive data types");
			pstmt.setString(6,"None");
			pstmt.setInt(1,2);
			pstmt.setString(2, "Identify the modifier which cannot be used for constructor");
			pstmt.setString(3,"Public");
			pstmt.setString(4,"Protected");
			pstmt.setString(5,"Private");
			pstmt.setString(6,"Static");
			pstmt.setInt(1,3);
			pstmt.setString(2, "Exception created by try block is caught in which block");
			pstmt.setString(3,"Catch");
			pstmt.setString(4,"Throw");
			pstmt.setString(5,"Final");
			pstmt.setString(6,"None");
			pstmt.setInt(1,4);
			pstmt.setString(2, "Identify the incorrect java feature");
			pstmt.setString(3,"Object oriented");
			pstmt.setString(4,"Use of pointers");
			pstmt.setString(5,"Dynamic");
			pstmt.setString(6,"Architectural neutral");
			pstmt.setInt(1,5);
			pstmt.setString(2, "An Interface with no fields or methods is known as");
			pstmt.setString(3,"Runnable interface");
			pstmt.setString(4,"marker interfcae");
			pstmt.setString(5,"Abstract interfcae");
			pstmt.setString(6,"CharSequence interfcae");
			pstmt.setInt(1,6);
			pstmt.setString(2, "What is the entry point of a program in java");
			pstmt.setString(3,"Main method");
			pstmt.setString(4,"The first line of code");
			pstmt.setString(5,"Last line of code");
			pstmt.setString(6,"Main class");
			pstmt.setInt(1,7);
			pstmt.setString(2, "Which keyword in java is used for exception handling");
			pstmt.setString(3,"excep");
			pstmt.setString(4,"excephand");
			pstmt.setString(5,"throw");
			pstmt.setString(6,"All of the above");
			pstmt.setInt(1,8);
			pstmt.setString(2, "Which class in java is used to take input from the user");
			pstmt.setString(3,"Scanner");
			pstmt.setString(4,"Input");
			pstmt.setString(5,"Applier");
			pstmt.setString(6,"None of these");
			pstmt.setInt(1,9);
			pstmt.setString(2, "Which of these is a type of variable in java");
			pstmt.setString(3,"Instance variable");
			pstmt.setString(4,"Local variable");
			pstmt.setString(5,"Static variable");
			pstmt.setString(6,"all of these");
			pstmt.setInt(1,10);
			pstmt.setString(2, "Object in java are.....");
			pstmt.setString(3,"Classes");
			pstmt.setString(4,"Referances");
			pstmt.setString(5,"Iterators");
			pstmt.setString(6,"None of these");
			int i = pstmt.executeUpdate();
		   System.out.println("Record is inserted");
		
			} finally {
		
		con.close();
		pstmnt.close();
		
			}
	}
}



