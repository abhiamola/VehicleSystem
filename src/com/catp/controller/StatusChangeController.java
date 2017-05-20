package com.catp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.catp.business.VehicleBO;
import com.catp.exception.VBusinessException;
import com.catp.exception.VException;
import com.catp.model.User;


public class StatusChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public StatusChangeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			VehicleBO vb = new VehicleBO();
			//PrintWriter out = response.getWriter();
			//out.println("<html><body>");
			ArrayList<User> al = vb.changeStatus();
			ArrayList<User> al1 = new ArrayList<User>();
			for(User u:al)
			{
				u.setStatus(request.getParameter(u.getUserId()+""));
				//out.println(u.getUserId()+" "+u.getStatus()+"<br>");
				al1.add(u);
			}
			vb.changeStatus1(al1);
			//out.println("hi</body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			request.setAttribute("sOb", "Status successfully changed");
			rd.forward(request,response);
		}
		catch(VException e)
		{
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("errorOb", e.getMessage());
			rd.forward(request,response);
		}
		catch(VBusinessException e)
		{
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("errorOb", e.getMessage());
			rd.forward(request,response);
		}
		
	}

}
