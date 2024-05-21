package com.cadd.foodplaza.pojo;

public class Customer {
 
	private int CustomerID;
	private String CustomerName;
	private String CustomerAddress;
	private long CustomerContact;
	private String CustomerEmailId;
	private String CustomerPassword;
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerAddress() {
		return CustomerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		CustomerAddress = customerAddress;
	}
	public long getCustomerContact() {
		return CustomerContact;
	}
	public void setCustomerContact(long customerContact) {
		CustomerContact = customerContact;
	}
	public String getCustomerEmailId() {
		return CustomerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		CustomerEmailId = customerEmailId;
	}
	public String getCustomerPassword() {
		return CustomerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		CustomerPassword = customerPassword;
	}
	
}
