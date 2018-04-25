package org.gmu.swe642.hw4;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SurveyServlet
 */
@WebServlet("/SurveyServlet")
public class SurveyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		SurveyDelegate delegate = new SurveyDelegate();
		String operation = request.getParameter("operation");
		if (operation == null) {
		operation = "unknown";
		}
		if (operation.equals("calcMean")) {
			address = "/WEB-INF/SimpleAcknowledgement.jsp";
			
			DataBean bean = delegate.calculate(request);
			request.setAttribute("meanBean", bean);
			
			if(bean!=null) {
				if(bean.getMean()>90)
					address = "/WEB-INF/WinnerAcknowledgement.jsp";
			}
			
		} else if (operation.equals("cancel")) {
			address = "/WEB-INF/SimpleAcknowledgement.jsp";
		} else {
			address = "/WEB-INF/UnknownOperation.jsp";
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
