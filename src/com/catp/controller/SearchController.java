package com.catp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.catp.business.VehicleBO;
import com.catp.exception.VException;
import com.catp.exception.VExceptionSearch;
import com.catp.model.BookingVO;



/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SearchController() {
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
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String manf_name= request.getParameter("manufacturer");
	int lprice = Integer.parseInt(request.getParameter("lower_price"));
	int hprice = Integer.parseInt(request.getParameter("upper_price"));
	String color = request.getParameter("color");
	int seating = Integer.parseInt(request.getParameter("seating"));
	String location = request.getParameter("location");
	BookingVO bvo = new BookingVO();
	 ArrayList brc = new ArrayList();
	 try
	 {
		
	 brc = VehicleBO.get_VEhicles(manf_name, lprice, hprice, color, seating, location);
	
	 if(brc.size()!=0)
	 {
		 System.out.println("size is not zero");
		 RequestDispatcher rd = request.getRequestDispatcher("SearchResults.jsp");
	request.setAttribute("searchob", brc);
	rd.forward(request, response);
	 }
	 else
	 {
		 RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
	 		request.setAttribute("errorOb","No Search Result found <br> Contact System Administrator for further assistance <br>" +
					"<a href =\"Search_Page.jsp\">Search a Vehicle</a>");
		    rd.forward(request, response);	
	 }
	 }catch(VExceptionSearch e)
	 {
		 RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
	 		request.setAttribute("errorOb","No Search Result found <br> Contact System Administrator for further assistance <br>" +
					"<a href =\"Search_Page.jsp\">Search a Vehicle</a>");
		rd.forward(request, response);
	 }
	 catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (VException e) {
		// TODO Auto-generated catch block
		RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
 		request.setAttribute("errorOb","No Search Result found <br> Contact System Administrator for further assistance <br>" +
				"<a href =\"Search_Page.jsp\">Search a Vehicle</a>");
	rd.forward(request, response);
		e.printStackTrace();
	}
	 
	 out.println(bvo.getVehicle_id());
	 out.println(bvo.getManufacturer_name());
	 
	 
	 
	 
	 
	
	
	
	
		
		
		
		
		
		
		
		
		
		
	}

}
