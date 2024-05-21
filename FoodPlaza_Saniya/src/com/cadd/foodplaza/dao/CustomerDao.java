package com.cadd.foodplaza.dao;

import java.util.ArrayList;

import com.cadd.foodplaza.pojo.Customer;

public interface CustomerDao   {
          
	boolean addCustomer(Customer c);
	boolean updateCustomer(Customer c);
	boolean deleteCustomer(int customerId);
	Customer displayCustomerById(int customerId);
	ArrayList<Customer>displayAllCustomer();
	
}
