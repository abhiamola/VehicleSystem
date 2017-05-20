package com.catp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.catp.business.VehicleBO;
import com.catp.exception.VRSException;
import com.catp.model.AddRequestAdmin;

public class ShowRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowRequestController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doPost method of ShowRequestController");
		ArrayList<AddRequestAdmin> list = new ArrayList<AddRequestAdmin>();
		int count=0;
		VehicleBO vbo = new VehicleBO();
		try {
			list = vbo.showAdminTable();
		} catch (VRSException e) {
			request.setAttribute("result", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
			rd.forward(request, response);
		}
		request.setAttribute("list", list);
		for(AddRequestAdmin ara : list){
			count++;
		}
		request.setAttribute("count", count);
		RequestDispatcher rd = request.getRequestDispatcher("ShowRequestTable.jsp");
		rd.forward(request, response);
	}

}
