package com.catp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.catp.business.VehicleBO;
import com.catp.exception.VException;

/**
 * Servlet implementation class UpdateApproval
 */
public class UpdateApproval extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateApproval() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    	try {
		String value=request.getParameter("changeStatus");
		System.out.println("in update approval"+value);

		String[] str = value.split(",");
		System.out.println("in update approval string array= "+str[0]);
		System.out.println("in update approval string array= "+str[1]);
	  	
					
				
				try {
					VehicleBO.updateData(str[0],str[1]);
	        		RequestDispatcher rd=request.getRequestDispatcher("UpdatedPendingRequest.jsp");
	    			
	    		request.setAttribute("status",str[0]);
						rd.include(request, response);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch (VException e) {
						RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			    		request.setAttribute("errorOb","Server Issue");
			    		try {
							rd.forward(request, response);
						} catch (ServletException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
    	}catch(NullPointerException e1){
    		RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
    		request.setAttribute("errorOb","No values Added pls check a radio button<br> <a href=\"admin.jsp\">Click Here</a> to goto Approval Request Page");
    		try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    			
	    		
	    		
	    		
	    		
	        	}
	    		
	        
	
 }

		
			

			
			
	


