
<%@ page import="onlineshopping.model.User" %>
<%
    User user1=(User)session.getAttribute("current-user");
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>navbar</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
  <%@ include file="bootstrap.jsp" %>
     <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container">
       <a class="navbar-brand" href="home.jsp">Online Shopping</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item ">
        <a class="nav-link" href="home.jsp">Home <span class="sr-only">(current)</span></a>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         Category List
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#"></a>
          <a class="dropdown-item" href="#"></a>
          <a class="dropdown-item" href="#"></a>
        </div>
      </li>
    </ul>
      <!--we are doing conditional rendering over here -->
      
          <ul class="navbar-nav ml-auto">
          <!-- design for cart -->
           <li class="nav-item ">
        <a class="nav-link" href="#!" data-toggle="modal" data-target="#cart"><i class="fa fa-cart-plus" style="font-size:20px;"><span class="ml-1 cart-items">( 0 )</span></i></a>
        </li>
          
          <%
            if(user1==null)
            {  
            	%>
       <li class="nav-item ">
        <a class="nav-link" href="login.jsp">Login</a>
        </li>
        <li class="nav-item ">
          <a class="nav-link" href="registration.jsp">Register</a>
        </li>
        </ul>
          <%   }
            else{
            %>
       <li class="nav-item ">
        <a class="nav-link" href="#!"><% out.println(user1.getName()+"("+user1.getUserType()+")"); %></a>
        </li>
        <li class="nav-item ">
          <a class="nav-link" href="LogoutServlet">LogOut</a>
        </li>
        </ul>
        <%     	
            }
          %>
     
                </div>
           </div>
       </nav> 
       
       <%@ include file="common-modal.jsp" %>
       
</body>
</html>