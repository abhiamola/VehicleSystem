package com.catp.controller;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.catp.business.VehicleBO;
import com.catp.exception.VException;
import com.catp.exception.VExceptionSearch;

//import com.vehicle.business.BookingBO;


/**
 * Servlet implementation class BookingController
 */
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingController() {
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
//		String unsme="10002";
//		String vid = request.getParameter("vid");
//		String mid = request.getParameter("mid");
//		int exid = Integer.parseInt(request.getParameter("exid"));
//		String colid = request.getParameter("colid");
//		//String insid = request.getParameter("insid");
//		String datid = request.getParameter("datid");
//		String branchid = request.getParameter("bid");
		
		String value = request.getParameter("book");
		String[] val = value.split(",");
		String status = val[0];
		String uname= val[1];
		String vid = val[2];
		String mid = val[3];
		int  exid = Integer.parseInt(val[4]);
		String colid = val[5];
		String datid = val[6];
		String branchid= val[7];
		
		
		
		
		
		ArrayList show = new ArrayList();
		show.add(vid);
		show.add(mid);
		show.add(exid);
		show.add(colid);
		show.add("N");
		show.add("-");
		show.add(branchid);
		show.add("Wait till confirmation");
		java.sql.Date stockDate = null;
	
		
		java.sql.Date cdate = null;
		
		try{
			VehicleBO bb = new VehicleBO();
		
			
			
			java.util.Date lasttilldate= new SimpleDateFormat("dd-MMM-YYYy").parse(datid);
		
		stockDate = new java.sql.Date(lasttilldate.getTime());
		
		System.out.println("stockDate="+stockDate.toString());
		
		boolean b = bb.addBooing(uname, vid, mid, exid, colid, "N", cdate, branchid, "",stockDate);
		if(b)
		{
			RequestDispatcher rd = request.getRequestDispatcher("BookingSuccess.jsp");
			request.setAttribute("booking", show);
			rd.forward(request, response);
		}
		
		else
		{
			
			
		}
		
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (VExceptionSearch e) {
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
    		request.setAttribute("errorOb","Booking Not Successfull <br> Contact System Administrator for further assistance <br>" +
					"<a href =\"Search_Page.jsp\">Search a Vehicle</a>");
	rd.forward(request, response);		
			
		} catch (VException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
