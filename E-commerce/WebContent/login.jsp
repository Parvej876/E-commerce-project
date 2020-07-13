<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>   
     <%@ include file="navbar.jsp" %>
        <div class="row mt-4">
          <div class="col-md-4 offset-md-4">           
            <div class="card ">
                <div class="card-header bg-primary">
                    <h5 class="title " >Login </h5>
                </div>
                <div class="card-body">
                    <form action="Login" method="post">
                    <%@ include file="message.jsp" %>
                        <div class="form-group">
                            <label for="name">UserName</label>
                            <input type="text" class="form-control" id="uname" name="uname" placeholder="enter name" required>
                        </div>
                        <div class="form-group mb-3">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="pswd" name="pswd" placeholder="password" required>
                         <a href="registration.jsp" class="text-center d-block mb-2 mt-2"> if not registered click here</a>
                        </div>
                        <div class="container text-center">
                        <button type="submit" class="btn btn-primary border-0">Submit</button>
                        <button type="reset" class="btn btn-success border-0">Reset</button>
                        </div>
                    </form>
                </div>
            </div>
           </div>    
      </div>
</body>
</html>