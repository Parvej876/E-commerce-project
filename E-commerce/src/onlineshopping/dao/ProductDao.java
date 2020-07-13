package onlineshopping.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import onlineshopping.model.Category;
import onlineshopping.model.Product;

public class ProductDao {
    static Connection connection=null;
    static Statement statement=null;
    static ResultSet rs=null;
    
     public static boolean saveProduct(Product p){
    	 boolean f=false;
	      String pTitle=p.getpTitle();
	      String pDescription=p.getpDescription();
	      int pPrice= p.getpPrice();
	      int pDiscount=p.getpDiscount();
	      int pQuantity=p.getpQuantity();
	      int cId=p.getcId();
	      String pPhoto= p.getpPhoto();
	      
  String insert="insert into product(pTitle,pdescription,pPhoto,pPrice,pDiscount,pQuantity,cId)values"
  		+ "('"+pTitle+"','"+pDescription+"','"+pPhoto+"','"+pPrice+"','"+pDiscount+"','"+pQuantity+"','"+cId+"')";
        f=true;
  try {
	  connection=JDBCDaoImpl.getCon();
	  statement=connection.createStatement();
	  statement.executeUpdate(insert);
} catch (SQLException e) {
	e.printStackTrace();
	f=false;
}
   return f;
}
 	public static List<Product> getProductList(){
 	     List<Product>list=new ArrayList<Product>();
 	      
 		 try {
 			connection=JDBCDaoImpl.getCon();
 			statement=connection.createStatement();
 			rs=statement.executeQuery("select * from product"); 
 		    	while(rs.next()){
 					int pId=rs.getInt("pId");
 					String pTitle=rs.getString("pTitle");
 					String pDescription=rs.getString("pDescription");	
 					int pPrice=rs.getInt("pPrice");
 					int pDiscount=rs.getInt("pDiscount");
 					int pQuantity=rs.getInt("pQuantity");
 					int cId=rs.getInt("cId");
 					String pPhoto=rs.getString("pPhoto");

 			       Product product=new Product();
 				     product.setpId(pId);
 				     product.setpTitle(pTitle);
 				     product.setpDescription(pDescription);
 				     product.setpPrice(pPrice);
 				     product.setpDiscount(pDiscount);
 				     product.setpQuantity(pQuantity);
 				     product.setcId(cId);
 				     product.setpPhoto(pPhoto);
 					list.add(product);
 			
 		   }
 		 } catch (SQLException e) {
 			e.printStackTrace();
 			
 		}
 		return list;   
 	}
	public static List<Product> getAllProductById(int cId){
	     List<Product>list=new ArrayList<Product>();
	      
		 try {
			connection=JDBCDaoImpl.getCon();
			statement=connection.createStatement();
			rs=statement.executeQuery("select * from product as p where p.cId='"+cId+"' "); 
		    	while(rs.next()){
					int pId=rs.getInt("pId");
					String pTitle=rs.getString("pTitle");
					String pDescription=rs.getString("pDescription");	
					int pPrice=rs.getInt("pPrice");
					int pDiscount=rs.getInt("pDiscount");
					int pQuantity=rs.getInt("pQuantity");
					int cid=rs.getInt("cId");
					String pPhoto=rs.getString("pPhoto");

			       Product product=new Product();
				     product.setpId(pId);
				     product.setpTitle(pTitle);
				     product.setpDescription(pDescription);
				     product.setpPrice(pPrice);
				     product.setpDiscount(pDiscount);
				     product.setpQuantity(pQuantity);
				     product.setcId(cid);
				     product.setpPhoto(pPhoto);
					list.add(product);
			
		   }
		 } catch (SQLException e) {
			e.printStackTrace();
			
		}
		return list;   
	}
}