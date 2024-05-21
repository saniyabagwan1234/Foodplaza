package com.cadd.foodplaza.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.cadd.foodplaza.dao.CustomerDaoImpl;
import com.cadd.foodplaza.pojo.Customer;
import com.cadd.foodplaza.pojo.Food;

public class CustomerTest {
public static void main(String[] args) {
	
	int choice,CustomerId;
	String CustomerName,CustomerAddress,CustomerEmailId,CustomerPassword;
	long CustomerContact;
	Customer c=new Customer();
	CustomerDaoImpl cd= new CustomerDaoImpl();
	boolean flag;
	Scanner sc=new Scanner(System.in);
	
	do {
		
		System.out.println("************************Customer Information******************************\n1.Add Customer\n2.Update Customer\n3.Delete Customer\n4.Display Customer By Id\n5.Display All Customer\n6.Exit");
	    System.out.println("Enter Your Choice: ");
	    choice=sc.nextInt();
	    
	    switch(choice) {
	    case 1:
	    	System.out.println("==================Enter Customer Details===================");
	    	System.out.println("1.Customer Name: \n2.Customer Address\n3.Customer Contact\n4.Customer email_id:\n5.Customer Password");
	    	CustomerName=sc.next();
	    	CustomerAddress=sc.next();
	    	CustomerContact=sc.nextLong();
	    	CustomerEmailId=sc.next();
	    	CustomerPassword=sc.next();
	    	
	    	c.setCustomerName(CustomerName);
	    	c.setCustomerAddress(CustomerAddress);
	    	c.setCustomerContact(CustomerContact);
	    	c.setCustomerEmailId(CustomerEmailId);
	    	c.setCustomerPassword(CustomerPassword);
	    	
	    	 flag=cd.addCustomer(c);
	    	if(flag==true) {
	    		System.out.println("Customer Added Successfully");
	    	}else {
	    		System.out.println("Customer Added Failed");
	    	}
	    	break;
	    case 2:
	    	System.out.println("==================ENTER ID TO UPDATE DETAILS OF YOUR CHOICE===================");
	    	System.out.println("Enter Customer id: ");
	    	CustomerId=sc.nextInt();
	    	
	    	System.out.println("Enter Customer Name: ");
	    	CustomerName=sc.next();
	    	
	    	System.out.println("Enter Customer Address: ");
	    	CustomerAddress=sc.next();
	    	
	    	System.out.println("Enter Customer Contact: ");
	    	CustomerContact=sc.nextLong();
	    	
	    	System.out.println("Enter Customer Email_Id: ");
	    	CustomerEmailId=sc.next();
	    	
	    	System.out.println("Enter Customer Password: ");
	    	CustomerPassword=sc.next();
	    	
	    	c.setCustomerID(CustomerId);
	    	c.setCustomerName(CustomerName);
	    	c.setCustomerAddress(CustomerAddress);
	    	c.setCustomerContact(CustomerContact);
	    	c.setCustomerEmailId(CustomerEmailId);
	    	c.setCustomerPassword(CustomerPassword);
	    	
	    	flag=cd.updateCustomer(c);
	    	if(flag==true) {
	    		System.out.println("Customer Update Successfully....");
	    	}else {
	    		System.out.println("Customer Update Failed....");
	    	}
	    	break;
	    	
	    case 3:
	    	System.out.println("==================ENTER ID TO DELETE Customer===================");
	    	
	    	System.out.println("Enter Customer ID: ");
	    	CustomerId=sc.nextInt();
	    	
	    	flag=cd.deleteCustomer(CustomerId);
	    	if(flag==true) {
	    		System.out.println("Delete Successfully...");
	    	}else {
	    		System.out.println("Delete Failed....");
	    	}
	    	break;
	    case 4:
	    	System.out.println("==================ENTER ID TO DISPLAY SPECIFIC Customer===================");
	    	System.out.println("Enter Customer ID: ");
	    	CustomerId=sc.nextInt();
	    	
	    	c=cd.displayCustomerById(CustomerId);
	    	System.out.println("*************Customer Details****************");
	    	System.out.println(c.getCustomerName()+" "+c.getCustomerAddress()+" "+c.getCustomerContact()+" "+c.getCustomerEmailId()+" "+c.getCustomerPassword());
	    	break;
	    case 5:
	    	System.out.println("==================EXISTING Customer DETAILS===================");
	    	
	    	ArrayList<Customer> af=new ArrayList<Customer>();
			af=cd.displayAllCustomer();
			
			for(Customer i:af) {
				System.out.println("Customer ID: "+i.getCustomerID());
				System.out.println("Customer Name: "+i.getCustomerName());
				System.out.println("Customer Address: "+i.getCustomerAddress());
				System.out.println("Customer Contact: "+i.getCustomerContact());
				System.out.println("Customer EmailId: "+i.getCustomerEmailId());
				System.out.println("Customer Password: "+i.getCustomerPassword());
				System.out.println();
				
			}
			
	    	break;
	    case 6:
	    	System.out.println("===================Exit=======================");
	    	break;
	    default:
			System.out.println("Invalid choice...Please Enter Correct Choice...");
	    }
	}while(choice<6);
	}}
