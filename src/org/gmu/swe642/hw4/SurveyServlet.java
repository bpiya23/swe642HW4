package org.gmu.swe642.hw4;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * the front controller that handles the http request from presentation layer.
 * 
 * @author saurav bhattacharyya
 *
 */
@WebServlet("/SurveyServlet")
public class SurveyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SurveyDelegate delegate = new SurveyDelegate();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SurveyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String address;
		try {
		System.out.println("here 1");
		
		
		String operation = request.getParameter("operation");
		System.out.println("here 2  " + operation);
		if (operation == null) {
		operation = "unknown";
		}
		if (operation.equals("calcMean")) {
			address = "/SimpleAcknowledgement.jsp";
			
			DataBean bean = delegate.calculate(request);
			
			
			if(bean!=null) {
				if(bean.getMean()>90)
					address = "/WinnerAcknowledgement.jsp";
			}
			
		} else if (operation.equals("studentDetails")) {
			address = "/Student.jsp";
			delegate.getStudent(request);
		} else {
			address = "/NoSuchStudentJSP.jsp";
		}
		} catch(Exception e) {
			address = "/NoSuchStudentJSP.jsp";
		}
		RequestDispatcher dispatcher =
		request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
