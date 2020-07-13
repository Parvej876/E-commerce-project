package onlineshopping.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import onlineshopping.model.Category;
public class CategoryDao {
        static Connection connection=null;
        static Statement statement=null;
        static ResultSet rs=null;
        
         public static void addCategory(Category category){
    	 String title=category.getCategoryTitle();
    	 String details=category.getCategoryDetails();
      String insert="insert into category(categoryTitle,categoryDetails)values('"+title+"','"+details+"')";
      try {
    	  connection=JDBCDaoImpl.getCon();
    	  statement=connection.createStatement();
		  statement.executeUpdate(insert);
	} catch (SQLException e) {
		e.printStackTrace();
	}
     }
	public static List<Category> getCategoryList(){
     List<Category>list=new ArrayList<Category>();
      
	 try {
		connection=JDBCDaoImpl.getCon();
		statement=connection.createStatement();
		rs=statement.executeQuery("select * from category"); 
	    	while(rs.next()){
				int cId=rs.getInt("cId");
				String categoryTitle=rs.getString("categorytitle");
				String categoryDetails=rs.getString("categoryDetails");

		       Category	category=new Category();
				category.setcId(cId);
				category.setCategoryTitle(categoryTitle);
				category.setCategoryDetails(categoryDetails);
				list.add(category);
		
	   }
	 } catch (SQLException e) {
		e.printStackTrace();
		
	}
	return list;   
}
	
}