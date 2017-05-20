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
import com.catp.exception.VException;
import com.catp.model.User_Approval;

/**
 * Servlet implementation class Role
 */
public class RoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleController() {
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
		String role=request.getParameter("role");
		response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
		System.out.println("RoleController ="+role);
		ArrayList<User_Approval> uA=new ArrayList<User_Approval>();
		try {
			uA=VehicleBO.getCustomerData(role);
			if(uA.size()==0){
				RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
	    		request.setAttribute("errorOb","No Data Found");
	    		rd.forward(request, response);
			}
			if(uA.size()!=0){
				RequestDispatcher rd=request.getRequestDispatcher("RoleData.jsp");
				request.setAttribute("UserList",uA);
				rd.forward(request, response);
				}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (VException e) {
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
    		request.setAttribute("errorOb","Server Issue");
    		rd.forward(request, response);
		}
	

	
	}

}
