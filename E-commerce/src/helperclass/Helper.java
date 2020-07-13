package helperclass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import onlineshopping.dao.JDBCDaoImpl;
import onlineshopping.model.Category;

public class Helper {
  
	public static String get10Word(String pDescription){
		
		String[] strs=pDescription.split(" ");
		  String res="";
		if(strs.length>10)
		{
			 for(int i=0;i<10;i++){
				 res=res+strs[i]+" ";
			 }
			 return (res+"....");
		}
		else{
			return (pDescription+"....");
		}	
	}
	
	public static Map<String,Long> countUser(){
		Map<String,Long> map=new HashMap<String, Long>();
		
   	    try {
   	    	long userCount=0L;
   	    	Connection connection=JDBCDaoImpl.getCon();
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select count(id) from user");
			while(rs.next()){
				//System.out.println("hello i m user");
				userCount=(long)(rs.getInt("count(id)"));
				//System.out.println(userCount);
			}
	
		 map.put("userCount", userCount); 
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return map;
		
	}
	public static Map<String,Long> countProduct(){
		Map<String,Long> map=new HashMap<String, Long>();
		
		try {
			
			long productCount=0L;
	    	Connection connection=JDBCDaoImpl.getCon();
			Statement statement=connection.createStatement();
			ResultSet rs2=statement.executeQuery("select count(pId) from product");
			while(rs2.next()){
			//	System.out.println("i am product");
				productCount=(long)rs2.getInt("count(pId)");
				// System.out.println(productCount);
			}
			
			 map.put("productCount", productCount);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return map;
		
	}
}
