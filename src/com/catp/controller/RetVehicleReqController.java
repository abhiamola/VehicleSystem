package com.catp.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class RetVehicleReqController
 */
public class RetVehicleReqController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetVehicleReqController() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String vcode=request.getParameter("vehcode");
		System.out.println(vcode);
		try {
			HttpSession session = request.getSession(false);
			int id = Integer.parseInt(session.getAttribute("bOb").toString());
			Booking c=VehicleBO.getVehDetailReq(vcode,id);
		RequestDispatcher rd=request.getRequestDispatcher("VehicleDetailsReq.jsp");
		request.setAttribute("vehicleob",c);
		rd.forward(request, response);
		
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
