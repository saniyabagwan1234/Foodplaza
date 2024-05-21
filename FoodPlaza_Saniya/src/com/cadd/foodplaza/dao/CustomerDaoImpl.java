package com.cadd.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cadd.foodplaza.pojo.Customer;
import com.cadd.foodplaza.pojo.Food;
import com.cadd.foodplaza.utility.DBUtility;

public class CustomerDaoImpl implements CustomerDao {

	Customer c=new Customer();
	Connection conn;
	String query;
	PreparedStatement ps;
	public boolean addCustomer(Customer c) {
		query="insert into customerInfo(CustomerName,CustomerAddress,CustomerContact,CustomerEmailId,CustomerPassword)values(?,?,?,?,?)";
		try {
			conn=DBUtility.establishConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, c.getCustomerName());
			ps.setString(2, c.getCustomerAddress());
			ps.setLong(3, c.getCustomerContact());
			ps.setString(4, c.getCustomerEmailId());
			ps.setString(5, c.getCustomerPassword());
			
			int CustSuccess=ps.executeUpdate();
			if(CustSuccess>0) 
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return true;
	}
	
	@Override
	public boolean updateCustomer(Customer c) {
		
		query="update customerinfo set CustomerName=?,CustomerAddress=?,CustomerContact=?,CustomerEmailId=?,CustomerPassword=? where CustomerId=?";
		try {
			conn=DBUtility.establishConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, c.getCustomerName());
			ps.setString(2, c.getCustomerAddress());
			ps.setLong(3, c.getCustomerContact());
			ps.setString(4, c.getCustomerEmailId());
			ps.setString(5, c.getCustomerPassword());
			ps.setInt(6, c.getCustomerID());
			
			int CustSuccess=ps.executeUpdate();
			if(CustSuccess>0) {
				return true;
			}else {
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		
		query="delete from customerinfo where customerId=?";
		
		try {
			conn=DBUtility.establishConnection();
			ps=conn.prepareStatement(query);
			
			ps.setInt(1, customerId);
			int CustSuccess=ps.executeUpdate();
			if(CustSuccess>0){
				return true;
			}else {
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			
			
			
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public  Customer displayCustomerById(int customerId) {
		query="select * from customerinfo where CustomerId=?";
		try {
			conn=DBUtility.establishConnection();
		     
			ps=conn.prepareStatement(query);
			ps.setInt(1, customerId);
		     ResultSet rs=ps.executeQuery();
		     while(rs.next()) {
		    	 
		    	 c.setCustomerName(rs.getString(2));
		    	 c.setCustomerAddress(rs.getString(3));
		    	 c.setCustomerContact(rs.getLong(4));
		    	 c.setCustomerEmailId(rs.getString(5));
		    	 c.setCustomerPassword(rs.getString(6));
		    	 
		    	
		     }
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public ArrayList<Customer> displayAllCustomer() {
		
    	
		query="Select * from customerinfo";
		ArrayList<Customer> af= new ArrayList<Customer>();
		try {
			conn=DBUtility.establishConnection();
			ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				Customer c=new Customer();
				c.setCustomerID(rs.getInt(1));
				c.setCustomerName(rs.getString(2));
		    	c.setCustomerAddress(rs.getString(3));
		    	c.setCustomerContact(rs.getLong(4));
		    	c.setCustomerEmailId(rs.getString(5));
		    	c.setCustomerPassword(rs.getString(6));
		    	
		    	af.add(c);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return af;
	}

}
