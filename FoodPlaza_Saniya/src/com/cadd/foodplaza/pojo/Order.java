package com.cadd.foodplaza.pojo;

public class Order {

	private int orderId;
	private String custEmail_id,OrderDate,foodName;
	private double totalBill;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustEmail_id() {
		return custEmail_id;
	}
	public void setCustEmail_id(String custEmail_id) {
		this.custEmail_id = custEmail_id;
	}
	public String getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	
}
