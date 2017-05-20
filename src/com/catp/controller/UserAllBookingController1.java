package com.catp.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.catp.business.VehicleBO;
import com.catp.exception.VException;
import com.catp.exception.VExceptionSearch;

//import com.vehicle.business.AllBookingBO;


/**
 * Servlet implementation class AllBookingController
 */
public class UserAllBookingController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAllBookingController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
String id = request.getParameter("allbookinguid");
		
System.out.println("all booking user id="+id);
		VehicleBO bb = new VehicleBO();
	
	ArrayList show = new ArrayList();
	
	try{
		
		
		show = bb.allbooking(id);
		
		if(show.size()!=0)
		{
		RequestDispatcher rd = request.getRequestDispatcher("AllBooking.jsp");
		request.setAttribute("allbooking", show);
		rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			request.setAttribute("errorOb","No Previous Booking found <br> Contact System Administrator for further assistance <br>" +
					"<a href =\"Search_Page.jsp\">Search a Vehicle</a>");
	rd.forward(request, response);	
		}
		
	}catch(VException e)
	{
		RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
		request.setAttribute("errorOb","NO Previous Booking found <br> Contact System Administrator for further assistance <br>" +
				"<a href =\"Search_page.jsp\">Search a Vehicle</a>");
rd.forward(request, response);		
	} catch (VExceptionSearch e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
		request.setAttribute("errorOb","Contact System Administrator for further assistance");
rd.forward(request, response);		
	}
	
	
	
	
	}

}
