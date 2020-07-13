package onlineshopping.model;

public class Product {
 private int pId;
 private String pTitle;
 private String pDescription;
 private String pPhoto;
 private int pPrice;
 private int pDiscount;
 private int pQuantity;
 private int cId;
 
public Product() {
	super();
}

public Product(String pTitle, String pDescription, String pPhoto,
		int pPrice, int pDiscount,int pQuantity,int cId) {
	super();
	this.pTitle = pTitle;
	this.pDescription = pDescription;
	this.pPhoto = pPhoto;
	this.pPrice = pPrice;
	this.pDiscount = pDiscount;
	this.pQuantity = pQuantity;
	this.cId=cId;
}

public Product(int pId, String pTitle, String pDescription, String pPhoto,
		int pPrice, int pDiscount, int pQuantity) {
	super();
	this.pId = pId;
	this.pTitle = pTitle;
	this.pDescription = pDescription;
	this.pPhoto = pPhoto;
	this.pPrice = pPrice;
	this.pDiscount = pDiscount;
	this.pQuantity = pQuantity;
	this.cId=cId;
}


public int getpId() {
	return pId;
}

public void setpId(int pId) {
	this.pId = pId;
}

public String getpTitle() {
	return pTitle;
}

public void setpTitle(String pTitle) {
	this.pTitle = pTitle;
}

public String getpDescription() {
	return pDescription;
}

public void setpDescription(String pDescription) {
	this.pDescription = pDescription;
}

public String getpPhoto() {
	return pPhoto;
}

public void setpPhoto(String pPhoto) {
	this.pPhoto = pPhoto;
}

public int getpPrice() {
	return pPrice;
}

public void setpPrice(int pPrice) {
	this.pPrice = pPrice;
}

public int getpDiscount() {
	return pDiscount;
}

public void setpDiscount(int pDiscount) {
	this.pDiscount = pDiscount;
}

public int getpQuantity() {
	return pQuantity;
}

public void setpQuantity(int pQuantity) {
	this.pQuantity = pQuantity;
}

public int getcId() {
	return cId;
}

public void setcId(int cId) {
	this.cId = cId;
}

@Override
public String toString() {
	return "Product [pId=" + pId + ", pTitle=" + pTitle + ", pDescription="
			+ pDescription + ", pPhoto=" + pPhoto + ", pPrice=" + pPrice
			+ ", pDiscount=" + pDiscount + ", pQuantity=" + pQuantity
			+ ", cId=" + cId + "]";
}
  // function to calculate Discount!!!
public int getPriceAfterApplyingDiscount(){
	int d=(int) ((this.getpDiscount()/100.0)* this.getpPrice());
	return this.getpPrice()-d;
}
}


 
 

