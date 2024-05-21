package com.cadd.foodplaza.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cadd.foodplaza.dao.OrderDaoImpl;
import com.cadd.foodplaza.pojo.Order;

public class OrderTest {
public static void main(String[] args) {
	
	int id,choice;
	String emailId,date,name;
	double totalBill;
	boolean flag;
	
	Order or=new Order();
	OrderDaoImpl od=new OrderDaoImpl();
	Scanner sc = new Scanner(System.in);
	System.out.println("*******************Welcome To Food Plaza(ORDER MODULE)********************");
	System.out.println("1.Place Order");
	System.out.println("2.Show Order");
	System.out.println("Enter Your Choice: ");
	choice=sc.nextInt();
	

		switch(choice) {
		case 1 :
			System.out.println("--------------------Place Order---------------------------");
			System.out.println("Enter Customer EmailId: ");
			emailId=sc.next();
			
            
			or.setCustEmail_id(emailId);
			
			flag=od.placeOrder(emailId);
           
            if(flag==true) {
            	System.out.println("Place order Successfully....");
            }
            else {
            	System.out.println("Place order Failed...");
            }
			break;
			
		case 2:
			System.out.println("--------------------Show Order---------------------------");
			
			List<Order> af= new ArrayList<Order>();
			af=od.showOrders();
			
			for(Order i:af) {
				System.out.println("Order Id: "+i.getOrderId());
				System.out.println("Customer EmailId: "+i.getCustEmail_id());
				System.out.println("Food Name: "+i.getFoodName());
				System.out.println("Order Date: "+i.getOrderDate());
				System.out.println("Total Bill: "+i.getTotalBill());
			}
			break;
			
			default:
				System.out.println("Invalid");
		}
		}
}
