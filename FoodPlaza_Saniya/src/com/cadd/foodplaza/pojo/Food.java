package com.cadd.foodplaza.pojo;
/*pojo or bean is same.
 * pojo class include
*/
public class Food {
	
	private int foodId;//encapsulation
private String foodName,foodType,foodCategory;
private double foodPrice;
public int getFoodId() {
	return foodId;
}
public void setFoodId(int foodId) {
	this.foodId = foodId;
}
public String getFoodName() {
	return foodName;
}
public void setFoodName(String foodName) {
	this.foodName = foodName;
}
public String getFoodType() {
	return foodType;
}
public void setFoodType(String foodType) {
	this.foodType = foodType;
}
public String getFoodCategory() {
	return foodCategory;
}
public void setFoodCategory(String foodCategory) {
	this.foodCategory = foodCategory;
}
public double getFoodPrice() {
	return foodPrice;
}
public void setFoodPrice(double foodPrice) {
	this.foodPrice = foodPrice;
}

}
