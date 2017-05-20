package com.catp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.catp.business.VehicleBO;
import com.catp.exception.VBusinessException;
import com.catp.exception.VException;
import com.catp.exception.VException1;
import com.catp.exception.VException2;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	final Logger LOG=Logger.getLogger("LoginController.class");
     //	PropertyConfigurator.configure("/VehicleSystem/WebContent/WEB-INF/log4j.properties");
		// LOG.info(" Login Controller Entered");
		try
		{
			String user=request.getParameter("uId");
			String pass=request.getParameter("pass");
			VehicleBO vb = new VehicleBO();
			String role=vb.login(user, pass);
			int u=Integer.parseInt(user);
			HttpSession session=request.getSession();  
	        
			if(role.equalsIgnoreCase("Admin"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
				session.setAttribute("AOB",u);
				rd.forward(request, response);
			}
			if(role.equalsIgnoreCase("Branch Admin"))
			{
				RequestDispatcher rd1 = request.getRequestDispatcher("BAdminHome.jsp");
				session.setAttribute("bOb",u);
				rd1.forward(request, response);
			}
			if(role.equalsIgnoreCase("Customer"))
			{
				RequestDispatcher rd2 = request.getRequestDispatcher("CustomerHome.jsp");
				session.setAttribute("cOb",u);
				rd2.forward(request, response);
			}
			if(role.equalsIgnoreCase("no"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				request.setAttribute("errorOb", "User ID or password didn't match");
				rd.forward(request, response);
			}
		}
		catch(VBusinessException e)
		{
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("errorOb", e.getMessage());
			rd.forward(request, response);
		}
		catch(VException e)
		{
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("errorOb", e.getMessage());
			rd.forward(request, response);
		}
		catch(VException1 e)
		{
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("errorOb", e.getMessage());
			rd.forward(request, response);
		}
		catch(VException2 e)
		{
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("errorOb", e.getMessage());
			rd.forward(request, response);
		}
	}

}
