package com.catp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.log4j.Logger;

import com.catp.business.VehicleBO;
import com.catp.exception.VException;


public class AccountApprovalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//Logger log = Logger.getLogger(AccountApprovalController.class);
	
    
    public AccountApprovalController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String role=request.getParameter("uRole");
			String stat=request.getParameter("stat");
			String sort=request.getParameter("sort");
			/*PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println(role+"<br>"+stat+"<br>"+sort);
			out.println("</html></body>");*/
			VehicleBO vb = new VehicleBO();
			if(stat==null && role==null && sort==null)
			{
				//log.debug("in if 1");
				ResultSet rs = vb.accountApprove();
				RequestDispatcher rd = request.getRequestDispatcher("PendingApproval.jsp");
				request.setAttribute("rs",rs);
				rd.forward(request, response);
			}
			else if(stat==null)
			{
				ResultSet rs = vb.accountApproveView1(role,sort);
				RequestDispatcher rd = request.getRequestDispatcher("ViewStatus.jsp");
				request.setAttribute("rs",rs);
				rd.forward(request, response);
			}
			else if(role==null)
			{
				ResultSet rs = vb.accountApproveView2(stat,sort);
				RequestDispatcher rd = request.getRequestDispatcher("ViewStatus.jsp");
				request.setAttribute("rs",rs);
				rd.forward(request, response);
			}
		}
		catch(VException e)
		{
			//log.error("error msg" +e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("errorOb", e.getMessage());
			rd.forward(request, response);
		}
		
	}

}
