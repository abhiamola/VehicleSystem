package com.catp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.catp.business.VehicleBO;
import com.catp.exception.VException;
import com.catp.model.Booking;

/**
 * Servlet implementation class RequestVehicleController
 */
public class RequestVehicleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestVehicleController() {
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
		System.out.println("in dopost method yyy");
		ArrayList<Booking> al2 = new ArrayList<Booking>();
		try {
			HttpSession session = request.getSession(false);
			int id = Integer.parseInt(session.getAttribute("bOb").toString());
			al2=VehicleBO.getReqVehDetails(id);
			if(al2.size()!=0){
		RequestDispatcher rd=request.getRequestDispatcher("ShowVehicleDetails.jsp");
		request.setAttribute("bookingob",al2);
		rd.forward(request, response);
			}
		} catch (VException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//request.setAttribute("errMessage", "Fatal Error");
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			request.setAttribute("errorOb", "Fatal Error. Contact System Adminstrator.");
			rd.forward(request, response);
		}
	}

}
