package com.catp.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.catp.dao.VehicleDAO;
import com.catp.exception.VBusinessException;
import com.catp.exception.VException;
import com.catp.exception.VException1;
import com.catp.exception.VException2;
import com.catp.exception.VExceptionSearch;
import com.catp.exception.VRSBusinessException;
import com.catp.exception.VRSException;
import com.catp.model.AddRequestAdmin;
import com.catp.model.Booking;
import com.catp.model.BranchAdmin;
import com.catp.model.Customer;
import com.catp.model.User;
import com.catp.model.User_Approval;
import com.catp.model.Vehicle;



public class VehicleBO {
	public boolean register(User u,String un,String e) throws VException, VException1
	{
		Calendar c = Calendar.getInstance();
		u.setCreatedDate(c.getTime());
		u.setStatus("Pending");
		VehicleDAO vd = new VehicleDAO();
		vd.register(u,un,e);
		return true;
	}
	public String login(String u, String p) throws VBusinessException, VException, VException1, VException2
	{
		try
		{
			int us = Integer.parseInt(u);
			VehicleDAO vd = new VehicleDAO();
			String role = vd.login(us, p);
			return role;
		}
		catch(NumberFormatException e)
		{
			throw new VBusinessException();
		}
	}
	
	public boolean infoUpdate(Customer c) throws VException
	{
		VehicleDAO vd = new VehicleDAO();
		vd.infoUpdate(c);
		//System.out.println("bo");
		return true;
		
	}
	
	public boolean infoBranchUpdate(BranchAdmin b)throws VException
	{
		VehicleDAO vd = new VehicleDAO();
		vd.infoBranchUpdate(b);
		//System.out.println("bo");
		return true;
		
	}
	
	public ResultSet accountApprove() throws VException
	{
		VehicleDAO vd = new VehicleDAO();
		ResultSet rs = vd.accountApprove();
		return rs;
	}
	public ResultSet accountApproveView1(String r,String o) throws VException
	{
		VehicleDAO vd = new VehicleDAO();
		ResultSet rs = vd.accountApproveView1(r,o);
		return rs;
	}
	public ResultSet accountApproveView2(String s,String o) throws VException
	{
		VehicleDAO vd = new VehicleDAO();
		ResultSet rs = vd.accountApproveView2(s,o);
		return rs;
	}
	
	public ArrayList<User> changeStatus() throws VException, VBusinessException
	{
		try
		{
			VehicleDAO vd = new VehicleDAO();
			ResultSet rs = vd.changeStatus();
			ArrayList<User> al= new ArrayList<User>();
			while(rs.next())
			{
				User u = new User(rs.getInt(1),"",rs.getString(2),new Date(rs.getDate(3).getTime()),rs.getString(4));
				al.add(u);
			}
			return al;
		}
		catch(SQLException e)
		{
			throw new VBusinessException();
		}
		
	}
	public boolean changeStatus1(ArrayList<User> al) throws VException, VBusinessException
	{
			VehicleDAO vd = new VehicleDAO();
			vd.changeStatus1(al);
			return true;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Umang
	public static ArrayList<Booking> getBookingDetails(int id) throws VException
	{
		ArrayList<Booking> al1 = new ArrayList<Booking>();
		al1 = VehicleDAO.getBookingDetails(id);
		//System.out.println("in bo");
		//System.out.println(c.getCustomerName());
		/*if(c.getCourseCode()==null)
			throw new VException();
		else
		 	*/			
		
		return al1;
		
	}
	
	public static Booking getVehRetDetails(String ccode,int id) throws VException
	{
		
		Booking c=VehicleDAO.getVehRetDetails(ccode,id);
		/*if(c.getCourseCode()==null)
			throw new CMSBusinessException();
		else
			*/
		
		return c;
		
	}

	public static ArrayList<Booking> getReqVehDetails(int id) throws VException
	{
		ArrayList<Booking> al1 = new ArrayList<Booking>();
		al1 = VehicleDAO.getReqVehDetails(id);
		//System.out.println(c.getCustomerName());
		/*if(c.getCourseCode()==null)
			throw new VException();
		else
		 	*/			
		
		return al1;
		
	}
	
	public static Booking getVehDetailReq(String ccode,int id) throws VException
	{
		
		Booking c=VehicleDAO.getVehDetailReq(ccode,id);
		/*if(c.getCourseCode()==null)
			throw new CMSBusinessException();
		else
			*/
		
		return c;
		
	}
	
	public boolean addRequest(Booking c) throws VException
	{
		
		return VehicleDAO.addRequestDetails(c);
		
}

	public static void updateData(String string, String string2, String string3, String string4,String value2,java.util.Date d, int id) throws VException {
		// TODO Auto-generated method stub
		try{
			VehicleDAO.updateData(string, string2, string3, string4, value2, d, id);
		}	catch(Exception e){
				throw new VException();
			}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//bhugri
	public static ArrayList<User_Approval> getCustomerData(String role) throws ClassNotFoundException, VException{
		ArrayList<User_Approval> uA=new ArrayList<User_Approval>();
		System.out.println("in ApprovalBO role");
		uA=VehicleDAO.getCustomerData(role);
		
		return uA;
	}

	public static ArrayList<User_Approval> getCustomerStatusData(String status) throws ClassNotFoundException, VException {
		ArrayList<User_Approval> uA=new ArrayList<User_Approval>();
		System.out.println("in ApprovalBO role");
		uA=VehicleDAO.getCustomerStatusData(status);
		
		return uA;
	}

	public static ArrayList<User_Approval> getData() throws ClassNotFoundException, VException {
		ArrayList<User_Approval> uA=new ArrayList<User_Approval>();
		System.out.println("in ApprovalBO role");
		uA=VehicleDAO.getData();
		
		return uA;
	}

	public static void updateData(String value, String userid) throws ClassNotFoundException, VException {
		ArrayList<User_Approval> uA=new ArrayList<User_Approval>();
		System.out.println("in ApprovalBO role");
		VehicleDAO.updateData(value,userid);
		
		
	}
	
	
	
	
	//aakash
	
	public boolean getVehicle(Vehicle v) throws ClassNotFoundException, SQLException, VRSException{
		VehicleDAO vdao = new VehicleDAO();
		 return vdao.insertVehicle(v);
	}
	public ArrayList<AddRequestAdmin> showAdminTable() throws VRSException{
		ArrayList<AddRequestAdmin> list = new ArrayList<AddRequestAdmin>();
		VehicleDAO vdao = new VehicleDAO();
		list = vdao.showAdminTable();
		return list;
	}
	public boolean approveRequest(AddRequestAdmin ara) throws ClassNotFoundException, SQLException, VRSException, VRSBusinessException, VException{
		System.out.println("In approveRequest() of VehicleBO");
		VehicleDAO vdao = new VehicleDAO();
		return vdao.approveRequest(ara);
	}
	public boolean upadateChanges(String bname, String vcode, int req, int main) throws ClassNotFoundException, SQLException, VRSException{
		VehicleDAO vdao = new VehicleDAO();
		return vdao.updateChanges(bname, vcode, req, main);
	}
	
	
	
	
	
	
	
	
//dera
	
	public static ArrayList get_VEhicles(String manufacturer_name,int lprice,int hprice,String color,int seating,String branchlocation)throws ClassNotFoundException, VExceptionSearch, VException 
	{
		ArrayList bvo = new ArrayList();
		
		
			bvo = VehicleDAO.getVEhicles(manufacturer_name, lprice, hprice, color, seating, branchlocation) ;
		  
		
		 
		
		
		
		
		
		return bvo;
		
		
	}
	
	
	

	public static ArrayList allbooking(String username) throws VException,VException, VExceptionSearch
	{
		ArrayList ret = new ArrayList();
		
			ret= VehicleDAO.allbooking(username);
			
		
		
		return ret;
	}
	public static boolean addBooing(String username,String vehicle_id,String manufacture,int exprice,String color,String status,java.sql.Date cdate,String branch,String commnets,java.sql.Date datid) throws VExceptionSearch, VException
	{
	boolean b = false;
	
	
	b = VehicleDAO.AddBooking(username, vehicle_id, manufacture, exprice, color, status, cdate, branch, commnets,datid);
		System.out.println(b+"BOOking BO");
	
	
		return b;
	}
}
