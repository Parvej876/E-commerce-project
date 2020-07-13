package onlineshopping.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDaoImpl {
	public static Connection connection=null;
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost/onlineShopping","root", "Mysql20@19");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	public static Connection getCon() {
		return connection;
	}
}
