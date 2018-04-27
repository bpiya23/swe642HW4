<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- author: saurav bhattacharyya -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>winnder acknowledgement</title>
 <style>
        #container {
            border-style: solid;
            height: 1000px;
            width: 1500px;
            margin: auto;
            padding-left: 50px;
            padding-right: 70px;
        }
        
        .top {
            border-style: hidden;
            background-color: #336600;
            padding-top: 10px;
            padding-bottom: 10px;
            margin-left: 50px;
            margin-right: 15px;
        }
        
        .firstcolumn {
            float: left;
            padding-left: 35px;
        }
        
        .secondcolumn {
            float: left;
            padding-left: 35px;
        }
        
        .address {
            float: right;
            font-style: bold;
            margin-bottom: 50px;
            font-size: 1.25em;
        }
        
        .logo {
            float: left;
            height: 130px;
            width: 300px;
        }
        
        .thirdcolumn {
            float: left;
            padding-left: 35px;
        }
    </style>
</head>
<body>
<div class="top ">
<div style="float:right; " class="tooltip">
        <img src="black-logo.png " height="90px " ; width="250px " />
       
    </div>
            <h1 style="margin-left:100px " ; "margin-right: 50px "; "float:top ";>
                Computer Science & Information Technology
            </h1>
        </div>
        
  <div>
  <h2> Thanks for Filling up the survey form. You are the raffle winner of two movie tickets</h2>
  
  
  
  <p>
  here is the mean:${meanBean.mean}  and standard deviation ${meanBean.standardDeviation}
  </p>
  
  <p>
  <h4> The following is the list of students</h4>
  
 <% List eList = (List)session.getAttribute("studentList");%>
  <ul>

    <%
    for(int i=0; i<eList.size();i++){ 
    	
    %>
        
            
            <li><a href="#" onclick="window.open('/swe642HW4/SurveyServlet?studentID=<%= eList.get(i) %>&operation=studentDetails')">
            <%= eList.get(i) %></a></li> 
        
      <%
      
    
    }%>

  </ul>
  
  
  </p>
  
  <input type="button" name="goback" value="go back to home page" onclick="location.href='jqueryHW4.html'"/>
  
  </div>      
        
</body>
</html>