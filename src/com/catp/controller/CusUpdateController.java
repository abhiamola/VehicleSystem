package com.catp.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.catp.model.Customer;


public class CusUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CusUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			String name=request.getParameter("cName");
			String db=request.getParameter("dob");
			String add=request.getParameter("add");
			String ph=request.getParameter("phNo");
			String mail=request.getParameter("email");
			String occ=request.getParameter("occ");
			HttpSession session = request.getSession(false);
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			
			int id =Integer.parseInt(session.getAttribute("cOb").toString());
			Date dob =null;
			dob = sdf.parse(db);
			Customer c = new Customer(id,name,dob,add,mail,ph,occ);
			VehicleBO vb = new VehicleBO();
			vb.infoUpdate(c);
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			String s="Successfully updated Information<br> <br><br><a href=\"CustomerHome.jsp\">Click Here</a>  to goto Customer Home Page";
			
			request.setAttribute("sOb",s );
			rd.forward(request, response);
		}
		catch(VException e)
		{
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("errorOb", e.getMessage());
			rd.forward(request, response);
		} catch (ParseException e) {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("errorOb", "Date format not correct");
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
		
		
		
		/*PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println(session.getAttribute("cOb").toString());
		out.println("hi</body></html>");*/
	}

}
