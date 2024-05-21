package com.cadd.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cadd.foodplaza.pojo.Cart;
import com.cadd.foodplaza.pojo.Customer;
import com.cadd.foodplaza.pojo.Food;
import com.cadd.foodplaza.utility.DBUtility;

public class CartDaoImpl implements CartDao{
	
	Cart c=new Cart();
	Connection conn;
	String query;
	PreparedStatement ps;

	@Override
	public boolean addToCart(Cart ct) {
		
		 String foodIdQuery = "select foodId from Food where foodName = ?";//*****
		
		query = "insert into Cart(foodQty,custEmailId,foodId,foodName)values(?,?,?,?)";
		
			try {
				conn = DBUtility.establishConnection();
				
				
				ps = conn.prepareStatement(foodIdQuery);//*****
				
				ps.setString(1, ct.getFoodName());//*****
				
				ResultSet rs =  ps.executeQuery();//*****
				
				if(rs.next())//*****
				{
					int foodId = rs.getInt(1);//*****
				
					ps = conn.prepareStatement(query);
				
					ps.setInt(1, ct.getFoodQty());
					ps.setString(2, ct.getCustomerEmailId());
					ps.setInt(3, foodId);//*****
					ps.setString(4, ct.getFoodName());
				
					int row = ps.executeUpdate();
					if(row>0)
					{
						return true;
					}
					else
					{
						return false;
					}
				}
				else
				{
					System.out.println("Entered Food not available");
				}
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		return true;
	}

	public boolean deleteCart(int cartId) {
		query="delete from Cart where cartId=?";
		try {
			conn=DBUtility.establishConnection();
			ps=conn.prepareStatement(query);
			
			ps.setInt(1,cartId);
			int success=ps.executeUpdate();
			
			if(success>0) {
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
	public ArrayList<Cart> showCart() {
		query="Select * from Cart";
		ArrayList<Cart> af= new ArrayList<Cart>();
		try {
			conn=DBUtility.establishConnection();
			ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				Cart c =new Cart();
				c.setCartId(rs.getInt(1));
				c.setFoodQty(rs.getInt(2));
				c.setCustomerEmailId(rs.getString(3));
				c.setFoodId(rs.getInt(4));
		    	c.setFoodName(rs.getString(5));
		    	af.add(c);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return af;
	}	
}
