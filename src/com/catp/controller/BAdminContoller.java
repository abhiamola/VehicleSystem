package com.catp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.catp.business.VehicleBO;
import com.catp.exception.VException;
import com.catp.model.BranchAdmin;
import com.catp.model.Customer;

public class BAdminContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BAdminContoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			String name=request.getParameter("bLoc");
			
			String add=request.getParameter("add");
			String ph=request.getParameter("phNo");
			String mail=request.getParameter("email");
			
			HttpSession session = request.getSession(false);
			
			int id =Integer.parseInt(session.getAttribute("bOb").toString());
			BranchAdmin c = new BranchAdmin(id,name,add,mail,ph);
			VehicleBO vb = new VehicleBO();
			vb.infoBranchUpdate(c);
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			String s="Successfully updated Information<br> <br><br><a href=\"BAdminHome.jsp\">Click Here</a>  to goto Branch Admin Home Page";
			
			request.setAttribute("sOb",s );
			rd.forward(request, response);
		}
		catch(VException e)
		{
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("errorOb", e.getMessage());
			rd.forward(request, response);
		} 
		catch(NumberFormatException e)
		{
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("errorOb", "UserID is not a number");
			rd.forward(request, response);
		}
		catch(NullPointerException e)
		{
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("errorOb", "UserID is null");
			rd.forward(request, response);
		}
		
		
	}
	}


