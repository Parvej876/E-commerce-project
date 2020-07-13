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
import onlineshopping.dao.UserDao;
import onlineshopping.model.User;
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
     static Connection connection;
     static Statement statement;
     HttpSession session;
    public Login() {
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
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		try{
			// fetching the details from login page
		    User user=new User();
		    // fetching name from user and by use set method we can give its value
		    user.setName(request.getParameter("uname"));
		    user.setPassword(request.getParameter("pswd"));
		    // calling getUserByNamePassword from UserDao class
		   user=UserDao.getUserByNamePassword(user);
		    if(user.isValid())
		    {   
		   	   session=request.getSession(true);
	    	   session.setAttribute("current-user",user);
	    	   if(user.getUserType().equals("admin")){
	    		// opens admin page
	    	    response.sendRedirect("admin.jsp");
	    	}
	    	else if(user.getUserType().equals("normal")){
	    		// opens normal page
	    		response.sendRedirect("normal.jsp");
	    	}
	    	else{
	    		System.out.println("user cannot be identified");
	    	}
		  }          
		    else
			{     
		    	session=request.getSession();
		        session.setAttribute("message","Invalid Username/Password");
		        response.sendRedirect("login.jsp");
			}
		    
		}catch(Exception e){
			e.printStackTrace();
		}
		    
	}	
}
