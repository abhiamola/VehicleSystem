package com.catp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.catp.business.VehicleBO;
import com.catp.exception.VException;
import com.catp.exception.VException1;
import com.catp.model.User;

public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterController() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter out = response.getWriter();
		//out.println("<html><body>");
		try
		{
			int uid=Integer.parseInt(request.getParameter("uId"));
			String pass = request.getParameter("pass");
			String role = request.getParameter("uRole");
			String uName = request.getParameter("uName");
			String email = request.getParameter("email");
			User u = new User(uid, pass, role, null, null);
			VehicleBO vb = new VehicleBO();
			vb.register(u,uName,email);
			RequestDispatcher rd = request.getRequestDispatcher("success1.jsp");
			String s = "Your account has been created successfully! Your account will be activated once the system administrator approves your account";
			
			request.setAttribute("sOb",s);
			rd.forward(request, response);
		}
		catch(VException e)
		{
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("errorOb",e.getMessage());
			rd.forward(request, response);
		}
		catch(VException1 e)
		{
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("errorOb","User Already Present<br><br> Go back to <a href=\"Register.jsp\"> New User Registration </a>");
			rd.forward(request, response);
		}
		
		
		//out.println(uid+"<br>"+pass+"<br>"+role+"<br>");
		//out.println("hi</body></html>");
	}

}
