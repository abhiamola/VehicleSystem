package com.catp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import com.catp.exception.VException;
import com.catp.exception.VException1;
import com.catp.exception.VException2;
import com.catp.exception.VExceptionSearch;
import com.catp.exception.VRSBusinessException;
import com.catp.exception.VRSException;
import com.catp.model.AddRequestAdmin;
import com.catp.model.Booking;
import com.catp.model.BookingVO;
import com.catp.model.BranchAdmin;
import com.catp.model.Customer;
import com.catp.model.User;
import com.catp.model.User_Approval;
import com.catp.model.Vehicle;
import com.catp.dao.DBConnection;



public class VehicleDAO {
	public boolean register(User u,String un,String em) throws VException, VException1
	{
		try
		{
		Connection con = DBConnection.getConnection();
		Statement s = con.createStatement();
		ResultSet rs =s.executeQuery("select user_id from user_details");
		while(rs.next())
		{
			if(rs.getInt(1)==u.getUserId())
			{
				throw new VException1();
			}
		}
		PreparedStatement ps = con.prepareStatement("insert into user_details values (?, ?, ?)");
		ps.setInt(1, u.getUserId());
		ps.setString(2, u.getPassword());
		ps.setString(3, u.getRole());
		ps.execute();
		PreparedStatement ps1 = con.prepareStatement("insert into user_approval values (?, ?, ?, ?)");
		ps1.setInt(1,u.getUserId());
		ps1.setString(2, u.getRole());
		Date d = new Date(u.getCreatedDate().getTime());
		ps1.setDate(3, d);
		ps1.setString(4, u.getStatus());
		ps1.execute();
		if(u.getRole().equalsIgnoreCase("Customer"))
		{
			PreparedStatement ps2 = con.prepareStatement("insert into customer_detail(login_id,customer_name,email) values (?,?,?)");
			ps2.setInt(1, u.getUserId());
			System.out.println("1");
			ps2.setString(2, un);
			ps2.setString(3, em);
			ps2.execute();
		}
		else if(u.getRole().equalsIgnoreCase("Branch Admin"))
		{
			PreparedStatement ps2 = con.prepareStatement("insert into branchadmin_details(login_id,email,name) values (?,?,?)");
			ps2.setInt(1, u.getUserId());
			
			ps2.setString(2, em);
			ps2.setString(3, un);
			ps2.execute();
		}
		return true;
		}
		catch(SQLException e)
		{
			throw new VException();
		}
	}
	public String login(int us, String pass) throws VException, VException1, VException2
	{
		try
		{
			Connection con = DBConnection.getConnection();
			Statement s = con.createStatement();
			ResultSet rs= s.executeQuery("select ud.user_id, ud.password, ud.role, ua.status from user_details ud, user_approval ua where ud.user_id=ua.user_id");
			String role = "no";
			while(rs.next())
			{
				if(rs.getInt(1)==us && rs.getString(2).equalsIgnoreCase(pass))
				{
					if(rs.getString(4).equalsIgnoreCase("Approve"))
					{
						role = rs.getString(3);
					}
					else if(rs.getString(4).equalsIgnoreCase("Reject"))
					{
						throw new VException1();
					}
					else if(rs.getString(4).equalsIgnoreCase("Pending"))
					{
						throw new VException2();
					}
				}
			}
			return role;
			
		}
		catch(SQLException e)
		{
			throw new VException();
		}
	}
	
	public boolean infoUpdate(Customer c) throws VException
	{
		try
		{
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE customer_detail SET customer_name = ?, date_of_birth =?, address=?, phone_number=?, email=?, occupation=? where login_id = ?");
			
			ps.setString(1, c.getCusName());
			//System.out.println("1");
			Calendar ca = Calendar.getInstance();
			Date d = new Date(c.getDob().getTime());
			ps.setDate(2,d);
			//System.out.println("2");
			ps.setString(3, c.getAddress());
			ps.setString(4, c.getPhone());
			ps.setString(5, c.getEmail());
			ps.setString(6, c.getOcc());
			ps.setInt(7, c.getLogin_id());
			//System.out.println(d);
			ps.executeUpdate();
			//System.out.println("4");
			return true;
		}
		catch(SQLException e)
		{
			//System.out.println("dao");
			throw new VException();
		}
		
	}
	
	public boolean infoBranchUpdate(BranchAdmin c) throws VException
	{
		try
		{
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE branchadmin_details SET branch_location = ?, address=?, phone_number=?, email=? where login_id = ?");
			
			ps.setString(1, c.getbLoc());
			ps.setString(2, c.getAddress());
			ps.setString(3, c.getPhone());
			ps.setString(4, c.getEmail());
			ps.setInt(5, c.getLogin_id());
			
			ps.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			//System.out.println("dao");
			throw new VException();
		}
		
	}
	
	public ResultSet accountApprove() throws VException
	{
		try
		{
			Connection con = DBConnection.getConnection();
			Statement s = con.createStatement();
			ResultSet rs=s.executeQuery("select * from user_approval where status='Pending'");
			return rs;
		}
		catch(SQLException e)
		{
			throw new VException();
		}
		
	}
	public ResultSet accountApproveView1(String r,String o) throws VException
	{
		try
		{
			Connection con = DBConnection.getConnection();
			String q= "select * from user_approval where role= ? order by "+o;
			PreparedStatement s = con.prepareStatement(q);
			s.setString(1, r);
			
			ResultSet rs=s.executeQuery();
			return rs;
		}
		catch(SQLException e)
		{
			throw new VException();
		}
		
	}
	public ResultSet accountApproveView2(String st,String o) throws VException
	{
		try
		{
			Connection con = DBConnection.getConnection();
			String q= "select * from user_approval where status= ? order by "+o;
			PreparedStatement s = con.prepareStatement(q);
			s.setString(1, st);
		
			ResultSet rs=s.executeQuery();
			return rs;
		}
		catch(SQLException e)
		{
			throw new VException();
		}
		
	}
	
	public ResultSet changeStatus() throws VException
	{
		try
		{
			Connection con = DBConnection.getConnection();
			Statement s = con.createStatement();
			ResultSet rs=s.executeQuery("select * from user_approval where status='Pending'");
			return rs;
		}
		catch(SQLException e)
		{
			throw new VException();
		}
	}
	public boolean changeStatus1(ArrayList<User> al) throws VException
	{
		try
		{
			Connection con = DBConnection.getConnection();
			for(User u:al)
			{
				String q = "update user_approval set status=? where user_id="+ u.getUserId();
				PreparedStatement ps = con.prepareStatement(q);
				ps.setString(1, u.getStatus());
				ps.executeUpdate();
			}
			return true;
		}
		catch(SQLException e)
		{
			throw new VException();
		}
		
	}
	
	
	
	
	
	
	
	
	
	//Umang
	public static ArrayList<Booking> getBookingDetails(int id) throws VException
	{
		ArrayList<Booking> al = new ArrayList<Booking>();
		try{	
		Connection con=null;
		con= DBConnection.getConnection();
	
	String sql1="Select branch_location from branchadmin_details where login_id ="+id;
	
	PreparedStatement pt1=con.prepareStatement(sql1);
	ResultSet rs1=pt1.executeQuery();
	if(rs1.next()){
		System.out.println(rs1.getString(1));
		
		//PreparedStatement pt4=con.prepareStatement("select outer.* from ( select rownum rn, inner.* from (select b.customername, b.vehiclecode, b.manufacturename, v.stockno from booking b join vehicle v on v.vehiclecode = b.vehiclecode where b.branch=? and b.status!='approve') inner) outer where outer.rn>='"+pageid+"' and outer.rn<='"+total+"'");
	//PreparedStatement pt4=con.prepareStatement("select b.user_id, b.vehicle_code, b.manufacturer_name, v.vehicles_available from booking b join vehicles v on v.vehicle_code = b.vehicle_code where b.branch=? and b.status!='Y'");
		PreparedStatement pt4=con.prepareStatement("select b.user_id, b.vehicle_code, b.manufacturer_name from booking b where b.branch=? and b.status!='Y'");
	PreparedStatement st = con.prepareStatement("select v.vehicles_available from vehicles v where v.branch=? and v.vehicle_code=?");
	
	
	System.out.println("jjj"+rs1.getString(1));
	pt4.setString(1, rs1.getString(1));
	
	
    ResultSet rs4=pt4.executeQuery();
    
    while(rs4.next())
    {
    	
    	Booking c=new Booking();
    	c.setCustomerName(rs4.getString(1));
    	System.out.println("customername "+c.getCustomerName());
    	c.setVehicleCode(rs4.getString(2));
    	System.out.println("veh code "+c.getVehicleCode());
    	c.setManufactureName(rs4.getString(3));
    	System.out.println("manufacture "+c.getManufactureName());
    	st.setString(1, rs1.getString(1));
    	st.setString(2, c.getVehicleCode());
    	ResultSet rs5=st.executeQuery();
    	while(rs5.next()){
    		
    		c.setStockNo(rs5.getInt(1));
        	System.out.println("sockno "+c.getStockNo());
    	}
    	
    	al.add(c);
    }
   
	}
	 return al;   
		 }catch(SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("out DAO");
				throw new VException();
			}
		
	}
	public static Booking getVehRetDetails(String ccode,int id) throws VException
	{
		
		Connection con=null;
		con= DBConnection.getConnection();
	Booking c=new Booking();
	
	try{
		
	String sql1="Select branch_location from branchadmin_details where login_id ="+id;
	
	PreparedStatement pt1=con.prepareStatement(sql1);
	
	ResultSet rs1=pt1.executeQuery();
	if(rs1.next()){
	
	
		String sql="Select v.vehicle_code, v.manufacturer_name, v.color, v.exshowroom_price, v.lasts_till from vehicles v where v.vehicle_code=? and v.branch=?";
		
			PreparedStatement pt=con.prepareStatement(sql);
			pt.setString(1, ccode);
			pt.setString(2, rs1.getString(1));
	        //pt.execute();
	        ResultSet rs=pt.executeQuery();
	        while(rs.next())
	        {
	        	c.setVehicleCode(rs.getString(1));
	        	c.setManufactureName(rs.getString(2));
	        	c.setColor(rs.getString(3));
	        	c.setExShowroomPrice(rs.getInt(4));
	        	c.setStockLastTill(rs.getDate(5));
	        	
	        
	        }
	} 	
	    	
	}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("IN DAO");
			throw new VException();
		}
		 return c;
	}
	
	public static ArrayList<Booking> getReqVehDetails(int id) throws VException
	{
		ArrayList<Booking> al = new ArrayList<Booking>();
		try{	
		Connection con=null;
		con= DBConnection.getConnection();
	
	/*Edit */
	String sql1="Select branch_location from branchadmin_details where login_id ="+id;
	
	PreparedStatement pt1=con.prepareStatement(sql1);
	ResultSet rs1=pt1.executeQuery();
	if(rs1.next()){
		System.out.println(rs1.getString(1));	
	PreparedStatement pt4=con.prepareStatement("select v.vehicle_code , v.vehicles_available from vehicles v where v.branch=?");
	System.out.println("yyy"+rs1.getString(1));
	pt4.setString(1, rs1.getString(1));
	
    ResultSet rs4=pt4.executeQuery();
    while(rs4.next())
    {
    	Booking c=new Booking();
    	c.setVehicleCode(rs4.getString(1));
    	System.out.println(c.getVehicleCode());
    	c.setStockNo(rs4.getInt(2));
    	al.add(c);
    }
   
	}
	 return al;   
		 }catch(SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("out DAO");
				throw new VException();
			}
		
	}
	
	public static Booking getVehDetailReq(String ccode, int id) throws VException
	{
		
		Connection con=null;
		con= DBConnection.getConnection();
	Booking c=new Booking();
	try{
		String sql1="Select branch_location from branchadmin_details where login_id ="+id;
		
		PreparedStatement pt1=con.prepareStatement(sql1);
		ResultSet rs1=pt1.executeQuery();
		if(rs1.next()){
			System.out.println(rs1.getString(1));
		String sql="Select v.vehicle_code, v.manufacturer_name, v.color, v.exshowroom_price, v.vehicles_available, v.branch from vehicles v where v.vehicle_code=? and v.branch=?";
		
			PreparedStatement pt=con.prepareStatement(sql);
			
			pt.setString(1, ccode);
			pt.setString(2, rs1.getString(1));
	        //pt.execute();
	        ResultSet rs=pt.executeQuery();
	        while(rs.next())
	        {
	        	c.setVehicleCode(rs.getString(1));
	        	c.setManufactureName(rs.getString(2));
	        	c.setColor(rs.getString(3));
	        	c.setExShowroomPrice(rs.getInt(4));
	        	c.setStockNo(rs.getInt(5));
	        	c.setBranch(rs.getString(6));
	        	
	        
	        }
		}
	    	}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("IN DAO");
			throw new VException();
		}
		 return c;
	}
	
	public static  boolean addRequestDetails(Booking c) throws VException
	{
	try{	
	 Connection con=null;
	con= DBConnection.getConnection();
	con.setAutoCommit(false);
	System.out.println(c.getVehicleCode());
	int c1;
	 String sql="Insert into branchadminrequest values(?,?,?,?)";
	 //String s2="Insert into COURSE_FEES_606001 values(?,?,?,?)";

		PreparedStatement pt=con.prepareStatement(sql);
		pt.setString(1,c.getVehicleCode());
		pt.setString(2,c.getBranch());
		pt.setString(3,c.getColor());
		pt.setInt(4,c.getReqno());
		c1=pt.executeUpdate();

		/*PreparedStatement ps=con.prepareStatement(s2);
       ps.setString(1,c.getCourseCode() );
       ps.setString(2, c.getCourseType());
       ps.setString(3, c.getCourseDuration());
       ps.setFloat(4, c.getCourseFees());
      c2= ps.executeUpdate();*/
      System.out.println(c1);
      if(c1>0)
      {
    	  con.commit();
      }
      
      return true;
	 
	  
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("in dao");
		throw new VException();
	}

	}
	
	public static void updateData(String string, String string2, String string3, String string4,String value2,java.util.Date d, int id) throws VException, ParseException {
		// TODO Auto-generated method stub
		//Booking a=new Booking();
		Connection con=null;
		PreparedStatement stmt = null;
		PreparedStatement ps = null;
		System.out.println("in updateDAO");
		try {
			 
				con = com.catp.dao.DBConnection.getConnection();
				System.out.println("back from database");
				java.sql.Date cdate = new java.sql.Date(d.getTime());
				System.out.println("adasd1@ "+cdate);
                 String sql1="Select branch_location from branchadmin_details where login_id ="+id;
				
				PreparedStatement pt1=con.prepareStatement(sql1);
				ResultSet rs1=pt1.executeQuery();
				if(rs1.next()){
					System.out.println(rs1.getString(1));
				String sql = "Update booking set status=?, comments=?, confirm_date=? where user_id=? and branch=? and vehicle_code=?";
				stmt = con.prepareStatement(sql);
				//System.out.println("d-"+d);
				//SimpleDateFormat sdf= new SimpleDateFormat("DD-MMM-yyyy"); 
				//String d1= sdf.format(d);
				//System.out.println(d1);
				//java.util.Date d2 = sdf.parse(d1);
				//System.out.println("Baad waali date : "+d2);
				stmt.setString(1, string);
				stmt.setString(2, value2);
				stmt.setDate(3, cdate);
				stmt.setString(4, string2);
				stmt.setString(5,rs1.getString(1));
				stmt.setString(6,string3);
			      stmt.executeUpdate();
				}
			   int newStockNo=0;
			   newStockNo= Integer.parseInt(string4)-1;
			   System.out.println("New StockNo"+newStockNo);
			   String sql11="Select branch_location from branchadmin_details where login_id ="+id;
				
				PreparedStatement pt11=con.prepareStatement(sql11);
				ResultSet rs11=pt11.executeQuery();
				if(rs11.next()){
					System.out.println(rs11.getString(1));
			   String sql2 = "Update vehicles set vehicles_available=? where vehicle_code=? and branch=?";
			   ps = con.prepareStatement(sql2);
			   ps.setInt(1, newStockNo);
			   ps.setString(2, string3);
			   ps.setString(3, rs11.getString(1));
			   ps.executeUpdate();
				}
           }catch(SQLException e){
        	   e.printStackTrace();
        	   System.out.println("in dao");
       		throw new VException();
           }
	}
	
	
	
	
	
	
	
	
	//Bhugra
	public static ArrayList<User_Approval> getData() throws ClassNotFoundException,VException{
		 ArrayList<User_Approval> uA=new ArrayList<User_Approval>();
			Connection con=null;
			Statement stmt = null;
			try {
				 
					con = DBConnection.getConnection();
					stmt = con.createStatement();
					String sql = "SELECT * FROM User_Approval where role!='Admin' order by 3,4";
				      ResultSet rs = stmt.executeQuery(sql);
				      
				    while(rs.next()){
				    	 User_Approval u=new User_Approval();
				    	u.setUserId(rs.getInt("user_id"));	
				    	u.setStatus(rs.getString("status"));
				    	u.setRole(rs.getString("role"));
				    	u.setCreatedDate(rs.getDate("created_date"));
				    	uA.add(u);
				    	}
				 
				    return uA;
				    
	           }catch(SQLException e){
	        	   
	             throw new VException();
	           }
			
		}

	public static ArrayList<User_Approval> getCustomerData(String role) throws ClassNotFoundException, VException {
		Connection con=null;
		Statement stmt = null;
		try {
			ArrayList<User_Approval> uA=new ArrayList<User_Approval>();
			System.out.println("in userApproval role"+role);
				con = DBConnection.getConnection();
				stmt = con.createStatement();
				String sql = "SELECT * FROM User_Approval where role='"+role+"' order by 3,4,2";
			      ResultSet rs = stmt.executeQuery(sql);
			      while(rs.next()){
				    	 User_Approval u=new User_Approval();
				    	u.setUserId(rs.getInt("user_id"));	
				    	u.setStatus(rs.getString("status"));
				    	u.setRole(rs.getString("role"));
				    	u.setCreatedDate(rs.getDate("created_date"));
				    	
						uA.add(u);
				    	}
			      System.out.println("in approval dao 2nd mthd");
			      return uA;
		  }catch(SQLException e){
	          throw new VException();
	        }
		
	}

	public static ArrayList<User_Approval> getCustomerStatusData(String status) throws ClassNotFoundException, VException {
		Connection con=null;
		Statement stmt = null;
		try {
			ArrayList<User_Approval> uA=new ArrayList<User_Approval>();
			System.out.println("in userApproval status"+status);
				con = DBConnection.getConnection();
				stmt = con.createStatement();
				String sql = "SELECT * FROM User_Approval where status='"+status+"' order by 3,4,2";
			      ResultSet rs = stmt.executeQuery(sql);
			      while(rs.next()){
				    	 User_Approval u=new User_Approval();
				    	u.setUserId(rs.getInt("user_id"));	
				    	u.setStatus(rs.getString("status"));
				    	u.setRole(rs.getString("role"));
				    	u.setCreatedDate(rs.getDate("created_date"));
						uA.add(u);
				    	}
			      System.out.println("in approval dao 3rd mthd");
			      return uA;
		  }catch(SQLException e){
	          throw new VException();
	      }
	}

	public static void updateData(String value,String userid) throws ClassNotFoundException, VException {
		
			Connection con=null;
			Statement stmt = null;
			System.out.println("in updateDAO"+userid);
			try {
				 
					con = DBConnection.getConnection();
					System.out.println("back from database");
					stmt = con.createStatement();
					String sql = "Update User_Approval set status='"+value+"' where user_id='"+userid+"' ";
				      stmt.executeUpdate(sql);
				
				
	           }catch(SQLException e){
	               throw new VException();
	           }
			
			
		}
	
	
	
	
	//AAkash
	
	
	
	
	public boolean updateChanges(String bname, String vcode, int req, int main) throws ClassNotFoundException, SQLException, VRSException{
		boolean a = false,b = false,c = false;
		try{
			System.out.println("In updateChanges() of VehicleDAO");
			Connection con  = DBConnection.getConnection();
			String querya = "update vehicles set vehicles_available=?-? where vehicle_code=? and branch=?";
			PreparedStatement ps = con.prepareStatement(querya);
			ps.setInt(1, main);
			ps.setInt(2, req);
			ps.setString(3, vcode);
			ps.setString(4, "Main");
			a = ps.execute();
			
			String selectQuery = "select vehicles_available from vehicles where vehicle_code=? and branch=?";
			PreparedStatement ps1 = con.prepareStatement(selectQuery);
			ps1.setString(1, vcode);
			ps1.setString(2, bname);
			ResultSet rs = ps1.executeQuery();
			int exist = 0;
			while(rs.next()){
				exist = rs.getInt("vehicles_available");
			}
			
			String queryb = "update vehicles set vehicles_available=?+? where vehicle_code=? and branch=?";
			PreparedStatement ps2 = con.prepareStatement(queryb);
			ps2.setInt(1, exist);
			ps2.setInt(2, req);
			ps2.setString(3, vcode);
			ps2.setString(4, bname);
			b = ps2.execute();
			
			String queryc = "delete from branchadminrequest where vehicle_code=? and branch=?";
            PreparedStatement ps3 = con.prepareStatement(queryc);
            ps3.setString(1, vcode);
            ps3.setString(2, bname);
            c = ps3.execute();

		}
		catch(Exception e){
			throw new VRSException();
		}
		
		return a && b && c;	
	}
	
	public boolean approveRequest(AddRequestAdmin ara) throws ClassNotFoundException, SQLException, VRSException, VRSBusinessException, VException{
		System.out.println("In approveRequest() of VehicleDAO");
		boolean a = false;
		try{
			if(ara.getMainStock()<Integer.parseInt(ara.getVehiclesApproved())){
				throw new VRSBusinessException();
			}
			Connection con = DBConnection.getConnection();
			String query = "insert into addOnAdmin values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, ara.getbName());
			ps.setString(2, ara.getvCode());
			ps.setInt(3, ara.getRequested());
			ps.setString(4, ara.getColor());
			ps.setInt(5, ara.getMainStock());
			ps.setString(6, ara.getApproveRequest());
			ps.setString(7, ara.getVehiclesApproved());
			ps.setString(8, ara.getComments());
			a = ps.execute();
		}
		catch(SQLException e){
			throw new VRSException();
		}
		return a;
	}
	
	public boolean insertVehicle(Vehicle v) throws ClassNotFoundException, SQLException, VRSException{
		boolean a = false;
		try{
			Connection con = DBConnection.getConnection();
			String query = "insert into vehicles values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, v.getmName());
			ps.setString(2, v.getvCode());
			ps.setInt(3, v.getExPrice());
			ps.setString(4, v.getColour());
			ps.setInt(5, v.getvAvailable());
			ps.setInt(6, v.getsCapacity());
			System.out.println("vehicle dao insert");
			java.util.Date dt=v.getStockDate();
			
			java.sql.Date ds=new java.sql.Date(dt.getTime());
			System.out.println("SQL waali date:  "+ds);
			ps.setDate(7,ds);
			System.out.println("after date waali line  "+v.getStockDate());
			ps.setString(8, v.getbLocation());
			System.out.println("after setstring blocation");
			a = ps.execute();
			System.out.println("after execute");
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("in catch block");
			throw new VRSException();
		}
		
		return a;
	}
	public ArrayList<AddRequestAdmin> showAdminTable() throws VRSException{
	    ArrayList<AddRequestAdmin> list = new ArrayList<AddRequestAdmin>();
		Connection con= null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try{
			con = com.catp.dao.DBConnection.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from branchadminrequest");
			String query = "select vehicles_available from vehicles where vehicle_code=? and branch=?";
			pstmt = con.prepareStatement(query);
			
			while(rs.next()){
				AddRequestAdmin ara = new AddRequestAdmin();
				ara.setbName(rs.getString(2));
				ara.setvCode(rs.getString(1));
				ara.setRequested(rs.getInt(4));
				ara.setColor(rs.getString(3));
				
				pstmt.setString(1,ara.getvCode());
				pstmt.setString(2,"Main");
				ResultSet rs1 = pstmt.executeQuery();
				while(rs1.next()){
					ara.setMainStock(rs1.getInt(1));
				}
				ara.setComments("");//for setting comments
				ara.setVehiclesApproved("");//for textbox which is taking input
				ara.setApproveRequest("");//for checkbox
				list.add(ara);
			}
		}
		catch(Exception e){
			System.out.println("Exception Occured in showAdminTable() of VehicleDAO");
			throw new VRSException();
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	//dera
	public static ArrayList getVEhicles(String manufacturer_name,int lprice,int hprice,String color,int seating,String branchlocation) throws ClassNotFoundException,VExceptionSearch, VException
	{

		Connection con = null;
		
		//System.out.println(""+con.toString());
		ArrayList<BookingVO> abv0 = new ArrayList<BookingVO>();
		
		System.out.println(manufacturer_name+"=DAO");
		System.out.println(lprice);
		System.out.println(hprice);
		System.out.println(color);
		System.out.println(seating);
		System.out.println(branchlocation);
		
//		 String q1 = "select * from VEHICLE v where v.MANUFACTURER='"+manufacturer_name+"'" +
//		 		"and v.EXPRICE between"+lprice+"and "+hprice+"and v.COLOR='"+color+"'" +
//	 				"and v.SEATING_CAPACITY="+seating+"and v.location='"+branchlocation+"';";
//		 
//String q1 = "select * from VEHICLES where MANUFACTURER_NAME='"+manufacturer_name+"' and color= '"+color+"' and " +
//		"SEATING_CAPACITY="+seating+" and BRANCH ='"+branchlocation+"' and EXSHOWROOM_PRICE between "+lprice+" and "+hprice;
		
		
String q1 = "select * from VEHICLES WHERE MANUFACTURER_NAME='"+manufacturer_name+"' and color= '"+color+"' and " +
		"SEATING_CAPACITY="+seating+" and BRANCH ='"+branchlocation+"' and EXSHOWROOM_PRICE BETWEEN "+lprice+" and "+hprice;		
		

		
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
		 java.util.Date d = null;
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
		 
		 try {
			 System.out.println("Inside DAO try");
			 con = DBConnection.getConnection();
			 System.out.println("GOT CONNECTED");
			PreparedStatement st = con.prepareStatement(q1);
			System.out.println("Query Executed");
			//st.setString(1, manufacturer_name);
		//st.executeUpdate();
		ResultSet rs = st.executeQuery();
		System.out.println("ResultSetExecuted");
			while(rs.next())
			{
				BookingVO bvo = new BookingVO();
				
				bvo.setVehicle_id(rs.getString(2));
				bvo.setManufacturer_name(rs.getString(1));
				bvo.setExprice(rs.getInt(3));
				bvo.setColor(rs.getString(4));
				bvo.setSeating(rs.getInt(6));
				System.out.println(bvo.getVehicle_id());
				bvo.setVehicle_in_stock(rs.getInt(5));
				d = sdf.parse(rs.getString(7));
  java.sql.Date dd1 = new java.sql.Date(d.getTime());
      bvo.setStock_lasts_till(sdf1.format(dd1));
				
				
				System.out.println("inside loop"+bvo.getStock_lasts_till());
				bvo.setBranch_location(rs.getString(8));
				
				//abv0.add(new BookingVO("1001",bvo.getVehicle_id(),bvo.getManufacturer_name(),bvo.getExprice(),bvo.getBranch_location(),bvo.getColor(),bvo.getSeating(),"N",bvo.getVehicle_in_stock(),bvo.getStock_lasts_till(),"NILL"));
				abv0.add(bvo);
				
				
				
			
				
			
			
			}
			
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	throw new VExceptionSearch();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 System.out.println("fro DAO");
//		 BookingVO bvo = new BookingVO();
//			
//		 System.out.println(bvo.getVehicle_id());
//		 System.out.println(bvo.getManufacturer_name());
//		 System.out.println(bvo.getColor());
//		 System.out.println(bvo.getExprice());
//		 System.out.println(bvo.getColor());
//		 System.out.println(bvo.getSeating());
//		 bvo.getVehicle_in_stock();
//		 System.out.println(bvo.getBranch_location());
//		 System.out.println("now arraylist");
		 
		 
		 //Iterator itr = abv0.iterator();
		 ArrayList new1= new ArrayList(); 
		 
		 for(int i=0;i<abv0.size();i++)
		 {
			
			 new1.add(abv0.get(i));
		 }
		 System.out.println("DAO end");
		 
		
		for(int j=0;j<new1.size();j++)
		{
			System.out.println(new1.get(j)+"DAO");
		}
		 
		 
		
		return new1;
		
	}
	
	
	public static boolean AddBooking(String userid,String vehicle_id,String manufacture,int exprice,String color,String status,java.sql.Date cdate,String branch,String comments,java.sql.Date datid) throws VExceptionSearch, VException 
	{
		
		int uid = Integer.parseInt(userid);
		Connection  con = DBConnection.getConnection();
		String q1="Insert into Booking values(?,?,?,?,?,?,?,?,?,?)";
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
	
		try
		{
//			BookingVO bvo = new BookingVO();
			
			int c1;
			PreparedStatement pt = con.prepareStatement(q1);
			pt.setInt(1, uid);
			pt.setString(2, vehicle_id);
			pt.setString(3, manufacture);
			pt.setInt(4, exprice);
			pt.setString(5,color);
			pt.setString(6, status);
		
			pt.setDate(7, (java.sql.Date) cdate);
			pt.setString(8, branch);
			pt.setString(9, comments);
			System.out.println("before date");
		
			pt.setDate(10, datid);
			System.out.println("after date");
//			
			c1=pt.executeUpdate();
			
			if(c1>0)
			{
				con.commit();
			}
			
			return true;
			
			
		}catch(SQLException e)
		{
			throw new VExceptionSearch();
		}
		
		
	
		
		
	}
	
	
	public static ArrayList allbooking(String username) throws VException,VExceptionSearch
	{
		int uid = Integer.parseInt(username);
		Connection con = DBConnection.getConnection();
		
		ArrayList<BookingVO> abv0 = new ArrayList<BookingVO>();
		
String q1 = "select * from BOOKING where USER_ID='"+uid+"' order by CONFIRM_DATE";

try{
	
	PreparedStatement pt = con.prepareStatement(q1);
	
	System.out.println("All booking query executed");
	
	ResultSet rs = pt.executeQuery();
	
	
	while(rs.next())
	{
		BookingVO bvo = new BookingVO();
		bvo.setVehicle_id(rs.getString(2));
		bvo.setManufacturer_name(rs.getString(3));
		bvo.setExprice(rs.getInt(4));
		bvo.setColor(rs.getString(5));
		bvo.setStatus(rs.getString(6));
		bvo.setBookingconfirmdate(rs.getString(7));
		bvo.setBranch_location(rs.getString(8));
		bvo.setComments(rs.getString(9));
		
		
		abv0.add(bvo);
		
		
		
	}
	
	
	
}
catch(SQLException e)
{
	throw new VExceptionSearch();
}
		
ArrayList new1 = new ArrayList();

for(int i=0;i<abv0.size();i++)
{
	new1.add(abv0.get(i));
}
		

		
		
		
		
		return new1;
		
	}
	
}
