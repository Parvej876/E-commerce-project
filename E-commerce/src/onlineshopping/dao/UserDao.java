package onlineshopping.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





import java.sql.Statement;

import onlineshopping.model.User;


public class UserDao {
  static Connection connection=null;
    static Statement statement=null;
    static ResultSet rs=null;
    
    public static User getUserByNamePassword(User user){
    	  //getting name from user and creating local variable
    	   String name=user.getName();
    	   String password=user.getPassword();
          String query="select * from user where name='"+name+"' and password='"+password+"'";
		try {
			connection=JDBCDaoImpl.getCon();
			statement=connection.createStatement();
            rs=statement.executeQuery(query);
                boolean dataPresent =rs.next();
                // checking the user is valid or not if user exits then set the valid to true
                if(dataPresent){
                	String userType=rs.getString("userType");
                	user.setUserType(userType);
                	user.setValid(true);
                } else{
                	 user.setValid(false);
                }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return user;
		
    }
}
