package com.student.quizapplication;

import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.Scanner;

public class MainController   {
   public static void main(String[] args) throws SQLException {
	   try {
		     
			 //the address of file to be opened for reading  
			 FileInputStream fis=new FileInputStream("C:\\Users\\asus\\Desktop\\Quiz Rules.txt");       
			 Scanner sc=new Scanner(fis);    //file to be scanned  
			 //returns true if there is another line to read  
			 while(sc.hasNextLine())  
			 {  
			 System.out.println(sc.nextLine());      
			 }  
			 sc.close();     //closes the scanner  
		   
	   }catch(Exception e) {
		   System.out.println(e);
	   }
	      //Calling method which contains questions
			Questions que = new Questions();
		    que.getquestions();
		    //Calling method which has score retrival 
		    StudentScore score = new StudentScore();
		    score.retriveScore();
		    
			}
	}


