package com.student.quizapplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Questions extends Question{
	static Scanner scan = new Scanner(System.in);
	  Connection con = null;
	  PreparedStatement ps = null;
	  
	public void getquestions() throws SQLException {
		int score =0;
		int x = 1;
		int correctAnswers =0;
		int wrongAnswers = 0;
	try
	{
		 ConnectionTest ct = new ConnectionTest();
		 con=ct.getConnectionDetails();
		 ps = con.prepareStatement("select * from question ORDER BY RAND()");
		 ResultSet rs = ps.executeQuery();
		 System.out.println("Enter your id");
		 int stdid =scan.nextInt();
		 System.out.println("Enter student Name");
	     String stdName = scan.next();
		//Retriving questions from database
		while(rs.next()) {
	   // System.out.println("Question no :"+rs.getInt(1));
			System.out.println("Question "+ x  + " :"+rs.getString(1));
			System.out.println("Option 1 : "+rs.getString(2));
			System.out.println("Option 2 : "+rs.getString(3));
			System.out.println("Option 3 : "+rs.getString(4));
			System.out.println("Option 4 : "+rs.getString(5));
	       //Taking answer from user
			System.out.println("Enter answer");
			int userAnswer = scan.nextInt()	;
			if(userAnswer==rs.getInt(6)) {
			System.out.println("Correct answer");
			score++;
			x++;
			correctAnswers++;
			}
			else {
				System.out.println("Incorrect answer,correct answer is :"+rs.getInt(6));
				wrongAnswers++;
				System.out.println("..............................................................................................................................................................................");
		}
			}
		System.out.println("Total correct answers are>>"+correctAnswers);
		System.out.println("Total wrong answers are>>"+wrongAnswers);
		System.out.println("Score of student out of 10 is >>"+score);
		//Prepare statement
		 ps = con.prepareStatement("insert into student(studentid,studentname,studentscore)values(?,?,?)");
		 ps.setInt(1,stdid );
		 ps.setString(2, stdName);
		 ps.setInt(3, score);
         int b = ps.executeUpdate();
    	
    	 rs.close();
	
	        if((score <=10)&&(score>=8) ){
				  System.out.println("Your grade class is A");
		      }
			  else if((score<=8)&&(score>=6)){
				System.out.println("Your grade class is B");
			}
			else if(score==5){
				System.out.println("Your grade class is C");
			}
				else {
				   System.out.println("Sorry you are fail");
			
		} 
	        System.out.println("................................................................................................................................................................................................");
			}catch(Exception e)	 {
		System.out.println(e);
	}finally {
		ps.close();
		con.close();
	}
	}
	
	
	
		
	}



		

	
	
	
