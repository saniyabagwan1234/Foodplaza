package com.cadd.foodplaza.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.cadd.foodplaza.dao.CartDaoImpl;
import com.cadd.foodplaza.pojo.Cart;
import com.cadd.foodplaza.pojo.Food;

public class CartTest {
	public static void main(String[] args) {
		
	int choice , foodQty,cartId = 0;
	String customerEmailId, foodName;
	boolean flag;
	Cart c=new Cart();
	CartDaoImpl cd=new CartDaoImpl();
	Scanner sc=new Scanner(System.in);
	
	do {
		System.out.println("===============Welcome to Cadd FoodPlaza(Cart Module)====================\n"
				+ "1.add to cart\n2.Delete Cart\n3.Display Cart\n4.Exit");
		System.out.println("Enter your Choice");
		choice=sc.nextInt();
		
	switch(choice){
	case 1 :
		System.out.println("************Enter Below Details to add to cart*************");
		//System.out.println("Enter Food Name: ");
		
		System.out.println("Enter Cart Details(customerEmailId,foodName,foodQty)for adding into cart");
		
		customerEmailId =  sc.next();
		foodName = sc.next();
		foodQty = sc.nextInt();
		
		
		c.setCustomerEmailId(customerEmailId);
		c.setFoodName(foodName);
		c.setFoodQty(foodQty);
		
		flag = cd.addToCart(c);
		
//		if(flag == true)
//		{
//			System.out.println("Cart Added Successfully");
//		}
//		else
//		{
//			System.out.println("Cart Adding Failed");
//		}
		if(flag)
		{
			System.out.println("Cart Added Successfully");
		}
		else
		{
			System.out.println("Cart Adding Failed");
		}
		
		break;
	case 2:
		System.out.println("************Enter Id to Delete cart*************");
		System.out.println("Enter Cart Id: ");
		cartId=sc.nextInt();
		
		
		flag=cd.deleteCart(cartId);
		
		if(flag==true) {
			System.out.println("cart Delete Successfully");
		}else {
			System.out.println("cart Delete Failed..");
		}
		break;
	case 3:
		System.out.println("**********Display Details of cart***************");
		ArrayList<Cart> af=new ArrayList<Cart>();
		af=cd.showCart();
		
		for(Cart i:af) {
			System.out.println("Cart ID: "+i.getCartId());
			System.out.println("Food Qty: "+i.getFoodQty());
			System.out.println("Customer Email Id: "+i.getCustomerEmailId());
			System.out.println("Food Id : "+i.getFoodId());
			System.out.println("Food Name: "+i.getFoodName());
			
		}
		
		break;
	case 4:
		System.out.println("Bye Bye....");
	System.exit(cartId);
	default:
		System.out.println("Invalid choice.... Please Enter Current Choice...");
		
	}
	}while(choice<5);
	}
}
