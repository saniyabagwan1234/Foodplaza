package com.cadd.foodplaza.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.cadd.foodplaza.dao.FoodDaoImpl;
import com.cadd.foodplaza.pojo.Food;

public class FoodTest {

	public static void main(String[] args) {
		
		int choice,foodId;
		String foodName,foodType,foodCategory;
		double foodPrice;
		boolean flag;
		Scanner sc=new Scanner(System.in);
		Food f=new Food();
		 FoodDaoImpl fd=new FoodDaoImpl();
//         boolean flag=fd.addFood(f);
		
		do 
		{
			System.out.println("****************************Welcome To Cadd FoodPlaza*******************************\n1.Add Food\n2.Update Food\n3.Delete Food\n4.Display Food By Id\n5.Display All Food\n6.Exit");
			System.out.println("Enter Your Choice: ");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1 :
				System.out.println("--------------------ENTER BELOW DETAILS TO ADD FOOD---------------------------");
				System.out.println("Enter Food Name, Food Type, Food Category, Food Price");
				foodName=sc.next();
				foodType=sc.next();
				foodCategory=sc.next();
				foodPrice=sc.nextDouble();
				
				//important(turning point)
				//Food f=new Food();
                f.setFoodName(foodName);
                f.setFoodType(foodType);
                f.setFoodCategory(foodCategory);
                f.setFoodPrice(foodPrice);
                
               // FoodDaoImpl fd=new FoodDaoImpl();
                flag=fd.addFood(f);
                if(flag==true) {
                	System.out.println("Food added Successfully....");
                }
                else {
                	System.out.println("Food added Failed...");
                }
				break;
			case 2 :
				System.out.println("--------------------ENTER ID TO UPDATE DETAILS OF YOUR CHOICE---------------------------");
				System.out.println("Enter Food id: ");
		    	foodId=sc.nextInt();
		    	
		    	System.out.println("Enter Food name: ");
		    	foodName=sc.next();
		    	
		    	System.out.println("Enter Food Type: ");
		    	foodType=sc.next();
		    	
		    	System.out.println("Enter Food Category: ");
		    	foodCategory=sc.next();
		    	
		    	System.out.println("Enter Food Price: ");
		    	foodPrice=sc.nextLong();
		    	
		    	//Food f=new Food();
		    	f.setFoodId(foodId);
		    	f.setFoodName(foodName);
                f.setFoodType(foodType);
                f.setFoodCategory(foodCategory);
                f.setFoodPrice(foodPrice);
                
//                FoodDaoImpl f=new FoodDaoImpl();
               flag=fd.updateFood(f);
               System.out.println(flag);
                if(flag==true) {
                	System.out.println("Food Update Successfully....");
                }
                else {
                	System.out.println("Food Update Failed...");
                }
				break;
			case 3 :
				System.out.println("--------------------ENTER ID TO DELETE FOOD---------------------------");
				System.out.println("Enter Food Id: ");
				foodId=sc.nextInt();
				
				
				flag=fd.deleteFood(foodId);
				
				if(flag==true) {
					System.out.println("Food Delete Successfully");
				}else {
					System.out.println("Food Delete Failed..");
				}
				break;
			case 4 :
				System.out.println("--------------------ENTER ID TO DISPLAY SPECIFIC FOOD---------------------------");
				System.out.println("Enter Food Id: ");
				foodId=sc.nextInt();
				
				f=fd.displayFoodById(foodId);
			System.out.println("***********Food Details**************");
			System.out.println(f.getFoodName()+" "+f.getFoodType()+" "+f.getFoodCategory()+" "+f.getFoodPrice());
				
				break;
			case 5 :
				System.out.println("--------------------EXISTING FOOD DETAILS---------------------------");
				
				ArrayList<Food> af=new ArrayList<Food>();
				af=fd.displayAllFood();
				
				for(Food i:af) {
					System.out.println("Food ID: "+i.getFoodId());
					System.out.println("Food Name: "+i.getFoodName());
					System.out.println("Food Type: "+i.getFoodType());
					System.out.println("Food Category: "+i.getFoodCategory());
					System.out.println("Food Price: "+i.getFoodPrice());
					System.out.println();
				}
				
				break;
			case 6:
				System.out.println("Khatam Tata bye bye....Ghari jaa.....");
				break;
			default:
				System.out.println("Invalid choice...Please Enter Correct Choice...");
			}
			
		}while(choice<6);
	}
}
