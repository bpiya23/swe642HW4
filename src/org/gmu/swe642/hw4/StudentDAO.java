package org.gmu.swe642.hw4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class StudentDAO {
	
private Connection conn =null;
	
public StudentDAO() {
	try {
		System.out.println("class for name");
		Class.forName ("oracle.jdbc.driver.OracleDriver");
	
		System.out.println("establishing connection class for name");
		 conn = DriverManager.getConnection (
		"jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g",
		"sbhatta7", "kajyss");
		 System.out.println("conn established");
		 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
public void storeStudent(StudentBean bean) {
	try {
		
		
	
		String query = "insert into Student values ('"  
				+ bean.getStudentID()
				+ "','" + bean.getFullname()
				+ "','" + bean.getAddress()
				+ "','" + bean.getZip()
				+ "','" + bean.getCity()
				+ "','" + bean.getState()
				+ "','" + bean.getPhone()
				+ "','" + bean.getEmail()
				+ "','" + bean.getUrl()
				+ "','" + bean.getDateofsurvey()
				+ "','" + bean.getAddcomment()
				+ "','" + bean.getMonths()
				+ "','" + bean.getUserid()
				+ "','" + bean.getMovieid()
				+ "','" + bean.getMovierating()
				+ "','" + bean.getTs()
				+ "','" + bean.getRecommend()
				+ "','" + bean.getYear()
				+ "','" + bean.getCampus()
				+ "','" + bean.getInterest()
				+ "','0','0')" 
				
				;
		System.out.println(query);
		Statement statement = conn.createStatement();
		int status = statement.executeUpdate(query);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
public 	StudentBean getStudent(String id) {
	String query="select * from Student where studentID='" + id + "'";
	Statement statement;
	try {
		statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(query);
		while (rs.next())
		{
		String s = rs.getString ("COF_NAME");
		float n = rs.getFloat ("PRICE");
		System.out.println (s + " " + n);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return null;
}

public List<String> getStudentIds(){
	return null;
}


}
