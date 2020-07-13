package onlineshoping.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import onlineshopping.dao.JDBCDaoImpl;
/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       static Connection connection;
       static Statement statement;
       HttpSession session;
       
    public Registration() {
        super();
    }
    public void init(ServletConfig config) throws ServletException {
    	
    	try {
    		connection=JDBCDaoImpl.getCon();
			statement=connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// fetching the value from registration page
		String name=request.getParameter("uname");
		String email=request.getParameter("email");
		String password=request.getParameter("pswd");
		String phone=request.getParameter("phone");
		String address=request.getParameter("add");
		String country=request.getParameter("country");
	// inserting the value to the database	
	try {
		statement.executeUpdate("insert into user(name,email,password,phone,address,country,userType) "
		+ " values('"+name+"','"+email+"','"+password+"','"+phone+"','"+address+"','"+country+"','normal')");
		
		// Creating session to display message when user register successfully
		session=request.getSession();
		session.setAttribute("message","Registration Successful!!");
		RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
		rd.include(request, response);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	}

}
