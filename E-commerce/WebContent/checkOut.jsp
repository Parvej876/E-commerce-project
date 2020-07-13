<%@ page import="onlineshopping.model.User" %>
<%
User user=(User)session.getAttribute("current-user");
if(user==null){
	  session.setAttribute("message","you are not logged in !! Login first to place order");
	  response.sendRedirect("login.jsp");
	  return;
}

%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <%@ include file="navbar.jsp" %>
     <div class="container-fluid">
        <div class="row mt-5">
           <div class="col-md-6">
                <div class="card">
                        <div class="card-header bg-info">
                           <h5 class="card-title text-center " > Your Cart </h5>
                       </div>
                              <div class="card-body">
                                     <div class="cart-body">
                                     </div>
                              </div>
                </div>
           </div>
  <div class="col-md-6">
      <div class="card">
                        <div class="card-header bg-primary">
                           <h5 class="card-title text-center " > Your Order Details </h5>
                       </div>
 <div class="card-body">
                                     
 <form action="#!">
  <div class="form-group">
    <label for="exampleFormControlInput1">Email address</label>
    <input type="email" value="<%=user.getEmail() %>" class="form-control" id="exampleFormControlInput1" placeholder="enter your email" required>
  </div>
     <div class="form-group">
      <label for="uname">UserName</label>
      <input type="text" value="<%=user.getName() %>" class="form-control" name="uname" id="uname" placeholder="enter your name" required>
     </div>
         <div class="form-group">
      <label for="phone">Phone no.</label>
      <input type="text" value="<%=user.getPhone() %>" class="form-control" name="phone" id="phone" placeholder="enter your number" required>
     </div>
     
  <div class="form-group">
    <label for="exampleFormControlTextarea1">Enter your Shipping Address</label>
    <textarea class="form-control" value="<%=user.getAddress() %>" id="exampleFormControlTextarea1" rows="3" placeholder="enter shipping address" required></textarea>
  </div>
        <div class="form-row">
    <div class="form-group col-md-4">
      <label for="inputCity">City</label>
      <input type="text" class="form-control" id="inputCity" placeholder="enter your city" required>
    </div>
    <div class="form-group col-md-4">
      <label for="inputState">State</label>
      <select id="inputState" class="form-control" name="inputState">
        <option value="Karnataka">Bangalore</option>
        <option value="West Bengal">West Bengal</option>
        <option value="Bihar">Bihar</option>
        <option value="Hyderabad">Hyderabad</option>
        <option value="Uttar Pradesh">Uttar Pradesh</option>
      </select>
    </div>
    <div class="form-group col-md-4">
      <label for="inputZip">Zip</label>
      <input type="number" class="form-control" id="inputZip" placeholder="pin number" required>
      </div>
       </div>
               <div class="container text-center">
                        <button type="submit" class="btn btn-success ">Place Order</button>
                        <button type="button" class="btn btn-primary border-0">Continue Shopping</button>
                        </div>
  </form>
                                     
             </div> 
         </div>
        </div>
      </div>  
   </div>
</body>
</html>