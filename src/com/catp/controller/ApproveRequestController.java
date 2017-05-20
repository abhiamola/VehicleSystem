package com.catp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.catp.business.VehicleBO;
import com.catp.exception.VException;
import com.catp.exception.VRSBusinessException;
import com.catp.exception.VRSException;
import com.catp.model.AddRequestAdmin;

public class ApproveRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ApproveRequestController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doPost of ApproveRequestController");
		System.out.println(request.getParameter("approveRequest"));
		String[] ab = request.getParameterValues("vehiclesApproved");
		int j=0;
		for(int i=0; i<ab.length; i++){
			if(!ab[i].equals("")){
				j = i;
			}
		}
		//int toApprove = Integer.parseInt(ab[j]);
		
		String[] comments = request.getParameterValues("comments");
		int k=0;
		for(int i=0; i<comments.length; i++){
			if(!comments[i].equals("")){
				k=i;
			}
		}

		String arr[] = request.getParameter("approveRequest").split(",");
		AddRequestAdmin ara = new AddRequestAdmin();
		ara.setbName(arr[1]);// arr[1] is branch name
		ara.setvCode(arr[2]);// arr[2] is vehicle code
		ara.setRequested(Integer.parseInt(arr[3]));// arr[3] is requested number of vehicles
		ara.setColor(arr[4]);// arr[4] is color of the vehicle
		
		ara.setApproveRequest(arr[0]);// arr[0] is the value of the radio button which is selected 
		ara.setVehiclesApproved(ab[j]);// ab[j] is the number of vehicles approved by admin
		ara.setComments(comments[k]);// comments[k] is the comments given by the admin
		
		int main = Integer.parseInt(arr[5]);
		int req = Integer.parseInt(ara.getVehiclesApproved());
		ara.setMainStock(Integer.parseInt(arr[5])-req);// arr[5] is vehicles in main stock
		//int req = Integer.parseInt(arr[3]);
		
		String vcode = arr[2];
		String bname = arr[1];
		
		VehicleBO vbo = new VehicleBO();
		try {
			boolean a = vbo.approveRequest(ara);
			if(!a){
				System.out.println("Successfully Added");
				boolean b = vbo.upadateChanges(bname, vcode, req, main);
				if(!b){
					//System.out.println("Changes Updated in Vehicles Table");
					request.setAttribute("result", "Successfully Approved....  Changes Updated in Vehicles Table");
					RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
					dispatcher.forward(request, response);
				}
			}
			else{
				System.out.println("Not Added");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Exception Occured : In SQL Exception");
			e.printStackTrace();
		} catch (VRSException e) {
			request.setAttribute("result", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
			rd.forward(request, response);
		} catch (VRSBusinessException e) {
			request.setAttribute("result", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
			rd.forward(request, response);
		} catch (VException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
