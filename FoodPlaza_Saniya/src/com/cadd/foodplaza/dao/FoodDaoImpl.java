package com.cadd.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.cadd.foodplaza.pojo.Food;
import com.cadd.foodplaza.utility.DBUtility;

public class FoodDaoImpl implements FoodDao {
	
	Connection conn;
	PreparedStatement ps;
	String query;
	Scanner sc=new Scanner(System.in);
	Food f=new Food();
	@Override
	
	public boolean addFood(Food f) {
		
		query="insert into Food(foodName,foodType,foodCategory,foodPrice)values(?,?,?,?)";
		try {
			conn = DBUtility.establishConnection();
			ps=conn.prepareStatement(query);
			ps.setString(1, f.getFoodName());
			ps.setString(2, f.getFoodType());
			ps.setString(3, f.getFoodCategory());
			ps.setDouble(4, f.getFoodPrice());
			
			int success=ps.executeUpdate();
			
			if(success > 0) {
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
	}
	
		return true;
			
	}

	@Override
	public boolean updateFood(Food f) {
		
		query="update Food set foodName=? ,foodType=? ,foodCategory=? ,foodPrice=? where foodId=?";
		try {
			conn = DBUtility.establishConnection();
			ps=conn.prepareStatement(query);
			
			ps.setString(1, f.getFoodName());
			ps.setString(2, f.getFoodType());
			ps.setString(3, f.getFoodCategory());
			ps.setDouble(4, f.getFoodPrice());
			ps.setInt(5, f.getFoodId());
			
			int success=ps.executeUpdate();
			
			if(success > 0) {
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
	}
	
		return true;
	}

	@Override
	public boolean deleteFood(int foodId) {
		
		query="delete from Food where foodId=?";
		try {
			conn=DBUtility.establishConnection();
			ps=conn.prepareStatement(query);
			
			ps.setInt(1,foodId);
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
	public  Food displayFoodById(int foodId) {
		
		query="select * from Food where foodid=?";
		try {
			conn=DBUtility.establishConnection();
		     
			ps=conn.prepareStatement(query);
			ps.setInt(1, foodId);
		     ResultSet rs=ps.executeQuery();
		     while(rs.next()) {
		    	 f.setFoodName(rs.getString(2));
		    	 f.setFoodType(rs.getString(3));
		    	 f.setFoodCategory(rs.getString(4));
		    	 f.setFoodPrice(rs.getDouble(5));
		     }
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public ArrayList<Food> displayAllFood() {
		query="Select * from Food";
		ArrayList<Food> af= new ArrayList<Food>();
		try {
			conn=DBUtility.establishConnection();
			ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				Food f=new Food();
				f.setFoodId(rs.getInt(1));
				f.setFoodName(rs.getString(2));
		    	f.setFoodType(rs.getString(3));
		    	f.setFoodCategory(rs.getString(4));
		    	f.setFoodPrice(rs.getDouble(5));
		    	
		    	af.add(f);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return af;
	}

}
