package com.catp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.catp.business.VehicleBO;
import com.catp.exception.VRSException;
import com.catp.model.Vehicle;

public class AddNewVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddNewVehicle() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("In doPost of AddNewVehicle");
		
		Vehicle v = new Vehicle();
		v.setmName(request.getParameter("mName"));
		v.setvCode(request.getParameter("vCode"));
		v.setColour(request.getParameter("colour"));
		//v.setStockDate(request.getParameter("stockDate"));
		System.out.println(request.getParameter("stockDate"));
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yy");
		String d=request.getParameter("stockDate");
		try {
			java.util.Date dt = sdf.parse(d);
			v.setStockDate(dt);
			System.out.println(v.getStockDate());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		v.setbLocation(request.getParameter("bLocation"));
		
		try{
			v.setExPrice(Integer.parseInt(request.getParameter("exPrice")));
			v.setvAvailable(Integer.parseInt(request.getParameter("vAvailable")));
			v.setsCapacity(Integer.parseInt(request.getParameter("sCapacity")));
		}
		catch(NumberFormatException e){
			System.out.println("Number Format Exception occured in AddNewVehicle");
		}
		VehicleBO vbo = new VehicleBO();
		try {
			if(!vbo.getVehicle(v)){
				System.out.println("Successfully Added to the database");
				request.setAttribute("result", "Successfully Added to the Database");
				RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
				dispatcher.forward(request, response);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException occured in AddNewVehicle");
		} catch (SQLException e) {
			System.out.println("SQLException occured in AddNewVehicle");
		} catch (VRSException e) {
			request.setAttribute("result", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
			rd.forward(request, response);
		}
	}

}
