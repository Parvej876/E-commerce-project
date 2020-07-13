<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
    <%@ include file="navbar.jsp" %>
      <div class="container-fluid">
             <div class="row mt-3">
        <div class="col-md-4 offset-md-4">
              <div class="card " >         
            <%@ include file="message.jsp" %>
              <div class="container text-center">
               <img src="image/sign-up.png" Style="max-width:100px" class="img-fluid" alt="imageIcon">
              </div>
                    <h5 class="text-center my-3">Create new account</h5>
                <div class="card-body px-5">
                    <form action="Registration" method="post">
                       <div class="form-group">
                            <label for="exampleInputName">UserName</label>
                            <input type="text" class="form-control" id="uname" name="uname" placeholder="enter name" required>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Email address</label>
                            <input type="email" class="form-control" id="email"
                                aria-describedby="emailHelp" placeholder="enter email" name="email" required>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword">Password</label>
                            <input type="password" class="form-control" id="pswd" name="pswd" placeholder="password" required>
                        </div>
                     <div class="form-group">
                            <label for="exampleInputPhone">Phone no.</label>
                            <input type="number" class="form-control" id="phone" name="phone" placeholder="phone number" required>
                        </div>
                        <div class="form-group">
                           <label for="exampleFormControlTextarea1">Address</label>
                           <textarea class="form-control" id="adress" name="add" rows="2"></textarea>
                      </div>
                        <div class="form-group">
                            <label for="exampleInputCountry">Country</label>
                            <input type="text" class="form-control" id="country" name="country" placeholder="country" required>
                        </div>
                    <div class="container text-center">
                        <button type="submit" class="btn btn-primary">Register</button>
                        <button type="reset" class="btn btn-success">Reset</button>
                           </div>
                    </form>
             </div>
           </div>
         </div>
      </div>
      </div>
</body>
</html>