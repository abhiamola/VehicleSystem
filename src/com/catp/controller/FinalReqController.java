package com.catp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.catp.business.VehicleBO;
import com.catp.exception.VException;
import com.catp.model.Booking;

/**
 * Servlet implementation class FinalReqController
 */
public class FinalReqController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalReqController() {
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
		
		try{
			//System.out.println("colornew"+request.getParameter("colorveh"));
			HttpSession session = request.getSession(false);
		// TODO Auto-generated method stub
		Booking c= (Booking)session.getAttribute("vehicleob");
		System.out.print("umgg"+c.getVehicleCode());
		
			Booking b1=new Booking();
			b1.setVehicleCode(c.getVehicleCode());
			System.out.println(b1.getVehicleCode());
			b1.setBranch(c.getBranch());
			System.out.println(b1.getBranch());
			b1.setColor(c.getColor());
			System.out.println(b1.getColor());
			b1.setReqno(Integer.parseInt(request.getParameter("numberreq")));
			System.out.println(b1.getReqno());
		
			VehicleBO cb=new VehicleBO();
			
				if(cb.addRequest(b1)){
					String s="Request Successfully added in the system<br> <br><br><a href=\"BAdminHome.jsp\">Click Here</a>  to goto Branch Admin Home Page";
					request.setAttribute("sOb",s);
					RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
					rd.forward(request, response);
				
				}
				
				
			
			
		}catch(VException e){
			e.printStackTrace();
			//request.setAttribute("errMessage", "Fatal Error");
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			request.setAttribute("errorOb", "Fatal Error. Contact System Adminstrator.");
			rd.forward(request, response);
		}
	}

}
  