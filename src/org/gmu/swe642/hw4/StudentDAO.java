package org.gmu.swe642.hw4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * the dao object that interacts with database.
 * 
 * @author saurav bhattacharyya
 *
 */
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
	
public void storeStudent(StudentBean bean) throws Exception{
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
		throw new Exception();
	}
}
	
public 	StudentBean getStudent(String id) throws Exception{
	String query="select * from Student where studentID='" + id + "'";
	Statement statement;
	StudentBean bean =new StudentBean();
	try {
		statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(query);
		while (rs.next())
		{
		
		String studentID= rs.getString("studentID");
		System.out.println("studentID=" + studentID);
		bean.setStudentID(studentID);
	 	 String fullname= rs.getString("fullname");
	 	System.out.println("fullname=" + fullname);
	 	 bean.setFullname(fullname);
		 String address= rs.getString("address");
		 System.out.println("address=" + address);
		 bean.setAddress(address);
		 String zip= rs.getString("zip");
		 System.out.println("zip=" + zip); 
		 bean.setZip(zip);
		 String city= rs.getString("city");
		 System.out.println("city=" + city); 
		 bean.setCity(city);
		 String state= rs.getString("state");
		 System.out.println("state=" + state); 
		 bean.setState(state);
		 String phone= rs.getString("phone");
		 System.out.println("phone=" + phone); 
		 bean.setPhone(phone);
		 String email= rs.getString("email");
		 System.out.println("email=" + email); 
		 bean.setEmail(email);
		 String url= rs.getString("url");
		 System.out.println("url=" + url); 
		 bean.setUrl(url);
		 String dateofsurvey= rs.getString("dateofsurvey");
		 System.out.println("dateofsurvey=" + dateofsurvey); 
		bean.setDateofsurvey(dateofsurvey);
		 String addcomment= rs.getString("addcomment");
		 System.out.println("addcomment=" + addcomment); 
		 bean.setAddcomment(addcomment);;
		 String months= rs.getString("month");
		 System.out.println("month="+ months); 
		 bean.setMonths(months);
		 String userid= rs.getString("userid");
		 System.out.println("userid=" + userid); 
		 bean.setUserid(userid);
		 String movieid= rs.getString("movieid");
		 System.out.println("movieid=" + movieid); 
		 bean.setMovieid(movieid);
	 String movierating= rs.getString("movierating");
	 System.out.println("movierating=" + movierating); 
	 bean.setMovierating(movierating);
		 String ts= rs.getString("ts");
		 System.out.println("ts="+ ts); 
		 bean.setTs(ts);
	 String recommend= rs.getString("recommend");
	 System.out.println("recommend=" + recommend); 
	 bean.setRecommend(recommend);
	 String year= rs.getString("year");
	 System.out.println("year=" + year); 
bean.setYear(year);

	 
	 String campus=rs.getString("campus");
	 
	System.out.println("campus="+ campus); 
	 bean.setCampus(campus);
	 
	 String interest= rs.getString("interest");
	 System.out.println("interest=" + interest); 
	 bean.setInterest(interest);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new Exception();
	}
	
	
	return bean;
}

public List<String> getStudentIds() throws Exception {
	
	String query="select distinct studentID from Student" ;
	Statement statement;
	List<String> list  = new ArrayList<String>();
	try {
		statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(query);
		while (rs.next())
		{
		String s = rs.getString ("studentID");
		list.add(s);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new Exception();
	}
	
	
	return list;
}


}
