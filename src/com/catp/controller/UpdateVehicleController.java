package com.catp.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.catp.business.VehicleBO;
import com.catp.exception.VException;

/**
 * Servlet implementation class UpdateVehicleController
 */
public class UpdateVehicleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVehicleController() {
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
		java.sql.Date cdate = null;
		try {
			HttpSession session = request.getSession(false);
			int id = Integer.parseInt(session.getAttribute("bOb").toString());
		String value = request.getParameter("approval");
		String value2 = request.getParameter("cmmnt");
		String[] arr = value.split(",");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(value2);
		Calendar c= Calendar.getInstance();
		java.util.Date d = c.getTime();
		cdate = new java.sql.Date(d.getTime());
			VehicleBO.updateData(arr[0],arr[1],arr[2],arr[3],value2,d,id);
		 /*catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
			String s="Request Successfully updated in the system<br> <br><br><a href=\"BAdminHome.jsp\">Click Here</a>  to goto Branch Admin Home Page";
			request.setAttribute("sOb",s);
    		RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			
		request.setAttribute("status",arr[0]);
		try{
				rd.include(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}/*catch(NullPointerException e){
			e.printStackTrace();
			//request.setAttribute("errMessage", "Fatal Error");
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			request.setAttribute("msg", "nalle");
			rd.forward(request, response);
		}*/
		catch(VException e){
			e.printStackTrace();
			//request.setAttribute("errMessage", "Fatal Error");
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			request.setAttribute("errorOb", "Fatal Error. Contact System Adminstrator.");
			rd.forward(request, response);
		}
	}

}
