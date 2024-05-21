package com.cadd.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.cadd.foodplaza.pojo.Food;
import com.cadd.foodplaza.pojo.Order;
import com.cadd.foodplaza.utility.DBUtility;



public class OrderDaoImpl implements OrderDao {

	PreparedStatement ps;
	Connection con;
	
	String query;
	Scanner sc=new Scanner(System.in);
	Food f=new Food();
	@Override
	public boolean placeOrder(String custEmailId) {
		double totalBill=0;//why 0 after that calculation 
		String OrderDate=new Date().toString();//current date show build util pacakge Date().
		
		try(Connection con=DBUtility.establishConnection()){
			
			String foodNameQuery= "Select foodName from Cart where custEmailId=?";
			
			//Calculate TotalBill
			String queryTotalBill="select sum(f.foodPrice*c.foodQty)as totalBill from Food as f inner join Cart as c ON f.foodId=c.foodId where custEmailId=?";
			
			ps=con.prepareStatement(foodNameQuery);
			ps.setString(1, custEmailId);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				String foodName=rs.getString(1);
				
				try(PreparedStatement psTotalBill=con.prepareStatement(queryTotalBill)){
					psTotalBill.setString(1,custEmailId);
					try(ResultSet rsTotalBill=psTotalBill.executeQuery()){
						if(rsTotalBill.next()) {
							totalBill=rsTotalBill.getDouble("totalBill");
						}
						
					}
				}
				//Insert order
				String queryInsertOrder="INSERT INTO Orders(totalBill,custEmailId,orderDate,foodName)VALUES(?,?,?,?)";
				try(PreparedStatement psInsertOrder=con.prepareStatement(queryInsertOrder)){
					psInsertOrder.setDouble(1, totalBill);
					psInsertOrder.setString(2, custEmailId);
					psInsertOrder.setString(3, OrderDate);
					psInsertOrder.setString(4, foodName);
					
					int row=psInsertOrder.executeUpdate();
					return row>0;
					
			}
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Order> showOrders() {
		
		String query = "Select * from Orders";
		ArrayList<Order> af= new ArrayList<Order>();
		try {
			con=DBUtility.establishConnection();
			ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				Order or=new Order();
				or.setOrderId(rs.getInt(1));
				or.setCustEmail_id(rs.getString(2));
				or.setFoodName(rs.getString(3));
				or.setOrderDate(rs.getString(4));
				or.setTotalBill(rs.getDouble(5));
				
		    	af.add(or);
		    	
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return af;
	}

}
