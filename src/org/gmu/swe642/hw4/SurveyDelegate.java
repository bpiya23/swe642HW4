package org.gmu.swe642.hw4;

import javax.servlet.http.HttpServletRequest;

public class SurveyDelegate {

	DataProcessor processor = new DataProcessor();
	StudentDAO dao=new StudentDAO();
	
	public SurveyDelegate() {
		// TODO Auto-generated constructor stub
	}
	
public DataBean calculate(HttpServletRequest request) {
		
		String field = request.getParameter("field");
		
		String[] arr = null;
		if(field !=null) {
			arr = field.split(",");
			
		}
	
		return processor.calculate(arr);
	}
	

	public StudentBean storeStudent(HttpServletRequest request) {
		StudentBean bean =new StudentBean();
		String studentID= request.getParameter("studentID");
		bean.setStudentID(studentID);
	 	 String fullname= request.getParameter("fullname");
	 	 bean.setFullname(fullname);
		 String address= request.getParameter("address");
		 bean.setAddress(address);
		 String zip= request.getParameter("zip");
		 bean.setZip(zip);
		 String city= request.getParameter("city");
		 bean.setCity(city);
		 String state= request.getParameter("state");
		 bean.setState(state);
		 String phone= request.getParameter("phone");
		 bean.setPhone(phone);
		 String email= request.getParameter("email");
		 bean.setEmail(email);
		 String url= request.getParameter("url");
		 bean.setUrl(url);
		 String dateofsurvey= request.getParameter("dateofsurvey");
		bean.setDateofsurvey(dateofsurvey);
		 String addcomment= request.getParameter("addcomment");
		 bean.setAddcomment(addcomment);;
		 int months= Integer.parseInt(request.getParameter("month"));	
		 bean.setMonths(months);
		 String userid= request.getParameter("userid");
		 bean.setUserid(userid);
		 String movieid= request.getParameter("movieid");
		 bean.setMovieid(movieid);
	 String movierating= request.getParameter("movierating");
	 bean.setMovierating(movierating);
		 String ts= request.getParameter("ts");
		 bean.setTs(ts);
	 int recommend= Integer.parseInt(request.getParameter("recommend"));
bean.setRecommend(recommend);
	 String year= request.getParameter("year");
bean.setYear(year);
	 String campus= request.getParameter("campus");
	 bean.setCampus(campus);
	 String interest= request.getParameter("interest");
	 bean.setInterest(interest);
	 dao.storeStudent(bean);
		
		return bean;
	}
	
}
