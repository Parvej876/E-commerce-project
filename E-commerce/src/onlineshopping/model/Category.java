package onlineshopping.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
  private int cId;
  private String categoryTitle;
  private String categoryDetails;
   List<Product> product=new ArrayList<Product>();
   
   
public Category() {
	super();
}

public Category(int cId, String categoryTitle, String categoryDetails) {
	super();
	this.cId = cId;
	this.categoryTitle = categoryTitle;
	this.categoryDetails = categoryDetails;
}

public Category(int cId, String categoryTitle, String categoryDetails,
		List<Product> product) {
	super();
	this.cId = cId;
	this.categoryTitle = categoryTitle;
	this.categoryDetails = categoryDetails;
	this.product = product;
}

public int getcId() {
	return cId;
}

public void setcId(int cId) {
	this.cId = cId;
}

public String getCategoryTitle() {
	return categoryTitle;
}

public void setCategoryTitle(String categoryTitle) {
	this.categoryTitle = categoryTitle;
}

public String getCategoryDetails() {
	return categoryDetails;
}

public void setCategoryDetails(String categoryDetails) {
	this.categoryDetails = categoryDetails;
}

public List<Product> getProduct() {
	return product;
}

public void setProduct(List<Product> product) {
	this.product = product;
}

@Override
public String toString() {
	return "Category [cId=" + cId + ", categoryTitle=" + categoryTitle
			+ ", categoryDetails=" + categoryDetails + ", product=" + product
			+ "]";
}
    
	
    
}
