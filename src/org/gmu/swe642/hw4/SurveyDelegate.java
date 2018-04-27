package org.gmu.swe642.hw4;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * this is the delegate object that forwards the requests to proper dao or processor class
 * 
 * @author saurav bhattacharyya
 *
 */
public class SurveyDelegate {

	DataProcessor processor = new DataProcessor();
	StudentDAO dao=new StudentDAO();
	
	public SurveyDelegate() {
		// TODO Auto-generated constructor stub
	}
	
public DataBean calculate(HttpServletRequest request) throws Exception {
		
	
	//store student
	storeStudent( request);
	
		String field = request.getParameter("field");
		request.getSession().setAttribute("field", field);
		System.out.println("field=" + field);
		String[] arr = null;
		if(field !=null) {
			arr = field.split(",");
			
		}
		System.out.println("arr=" + arr);
		DataBean dataBean = processor.calculate(arr);
		request.getSession().setAttribute("meanBean", dataBean);
		
		//get all the student ids and stor in session
		List<String> list = dao.getStudentIds();
		request.getSession().setAttribute("studentList", list);
		
		return dataBean;
	}
	
public void getStudent(HttpServletRequest request) throws Exception{
	
	String studentID= request.getParameter("studentID");
	StudentBean bean = dao.getStudent(studentID);
	if(bean.getStudentID()==null)
		throw new Exception();
	System.out.println("retrieved cmpus = " + bean.getCampus());
	request.getSession().setAttribute("studentDetails", bean);
}

	public StudentBean storeStudent(HttpServletRequest request) throws Exception{
		StudentBean bean =new StudentBean();
		String studentID= request.getParameter("studentID");
		System.out.println("studentID=" + studentID);
		bean.setStudentID(studentID);
	 	 String fullname= request.getParameter("fullname");
	 	System.out.println("fullname=" + fullname);
	 	 bean.setFullname(fullname);
		 String address= request.getParameter("address");
		 System.out.println("address=" + address);
		 bean.setAddress(address);
		 String zip= request.getParameter("zip");
		 System.out.println("zip=" + zip); 
		 bean.setZip(zip);
		 String city= request.getParameter("city");
		 System.out.println("city=" + city); 
		 bean.setCity(city);
		 String state= request.getParameter("state");
		 System.out.println("state=" + state); 
		 bean.setState(state);
		 String phone= request.getParameter("phone");
		 System.out.println("phone=" + phone); 
		 bean.setPhone(phone);
		 String email= request.getParameter("email");
		 System.out.println("email=" + email); 
		 bean.setEmail(email);
		 String url= request.getParameter("url");
		 System.out.println("url=" + url); 
		 bean.setUrl(url);
		 String dateofsurvey= request.getParameter("dateofsurvey");
		 System.out.println("dateofsurvey=" + dateofsurvey); 
		bean.setDateofsurvey(dateofsurvey);
		 String addcomment= request.getParameter("addcomment");
		 System.out.println("addcomment=" + addcomment); 
		 bean.setAddcomment(addcomment);;
		 String months= request.getParameter("months");
		 System.out.println("month="+ months); 
		 bean.setMonths(months);
		 String userid= request.getParameter("userid");
		 System.out.println("userid=" + userid); 
		 bean.setUserid(userid);
		 String movieid= request.getParameter("movieid");
		 System.out.println("movieid=" + movieid); 
		 bean.setMovieid(movieid);
	 String movierating= request.getParameter("movierating");
	 System.out.println("movierating=" + movierating); 
	 bean.setMovierating(movierating);
		 String ts= request.getParameter("ts");
		 System.out.println("ts="+ ts); 
		 bean.setTs(ts);
	 String recommend= request.getParameter("recommend");
	 System.out.println("recommend=" + recommend); 
	 bean.setRecommend(recommend);
	 String year= request.getParameter("year");
	 System.out.println("year=" + year); 
bean.setYear(year);
	 String campus= "";
	 
	 String[] outerArray=request.getParameterValues("campus");
	 for (int i = 0; i < outerArray.length; i++) {
		 campus+= outerArray[i] + ",";
	}
	 if(campus.lastIndexOf(",") !=-1)
		 campus = campus.substring(0,campus.length()-1);
	System.out.println("campus="+ campus); 
	 bean.setCampus(campus);
	 
	 String interest= request.getParameter("interest");
	 System.out.println("interest=" + interest); 
	 bean.setInterest(interest);
	 dao.storeStudent(bean);
		
		return bean;
	}
	
}
