<%@ page import="onlineshopping.model.User" %>
 <%@ page import="onlineshopping.dao.CategoryDao" %>
 <%@ page import="onlineshopping.model.Category" %>
 <%@ page import="helperclass.Helper" %>
 <%@ page import="java.util.List" %>
 <%@ page import="java.util.Map" %>
<%
   User user=(User)session.getAttribute("current-user");
if(user==null){
	  session.setAttribute("message","you are not logged in !! Login first");
	  response.sendRedirect("login.jsp");
	  return;
}
else{
	  if(user.getUserType().equals("normal")){
		  session.setAttribute("message","you are not admin do not acces this page!!");
		  response.sendRedirect("login.jsp");
		  return;
	  }
}
%>

   <%   
   
      Map<String,Long> u=Helper.countUser();
      Map<String,Long> p=Helper.countProduct();
    
   List<Category>list=CategoryDao.getCategoryList();
   
   %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>
<body>
   <%@ include file="navbar.jsp" %>
     <div class="container admin">
        <div class="container-fluid mt-3">
           <%@ include file="message.jsp" %>
        </div>
      <!-- first row --> 
        <div class="row">
          <!-- first column -->
             <div class="col-md-4">
                     <div class="card mt-2"> 
                        <div class="card-body text-center">
                           <img src="image/users.png" style="max-width:125px"class="img-fluid rounded-circle" alt="usericon">
                             <h1><%=u.get("userCount") %></h1>
                             <h1 class="text-uppercase text-muted">Users</h1>                 
                        </div>
                  </div> 
             </div>   
             <!-- second column -->
             <div class="col-md-4">
                     <div class="card mt-2"> 
                        <div class="card-body text-center">
                           <img src="image/category.png" style="max-width:125px"class="img-fluid rounded-circle" alt="usericon">
                             <h1><%=list.size() %></h1>
                             <h1 class="text-uppercase text-muted">Categories</h1>                 
                        </div>
                  </div> 
             </div>  
            <!-- third column -->
             <div class="col-md-4">
                     <div class="card mt-2"> 
                        <div class="card-body text-center">
                           <img src="image/product.png" style="max-width:125px"class="img-fluid rounded-circle" alt="usericon">
                             <h1><%=p.get("productCount") %></h1>
                             <h1 class="text-uppercase text-muted">Products</h1>                 
                        </div>
                  </div> 
             </div>       
         </div>
          <!-- second row -->
           <div class="row">
                <div class="col-md-6 ">
                     <div class="card mt-2  " data-toggle="modal" data-target="#add-category-modal"> 
                        <div class="card-body text-center">
                           <img src="image/add categories.png" style="max-width:125px"class="img-fluid rounded-circle" alt="usericon">
                               <p class="mt-2"> click here to add category</p>
                             <h1 class="text-uppercase text-muted">Add Category</h1>                 
                        </div>
                  </div> 
             </div>
                  <div class="col-md-6">
                     <div class="card mt-2" data-toggle="modal" data-target="#product-form"> 
                        <div class="card-body text-center">
                           <img src="image/add product.png" style="max-width:125px"class="img-fluid rounded-circle" alt="usericon">
                              <p class="mt-2"> click here to add new product</p>
                             <h1 class="text-uppercase text-muted">Add Product</h1>                 
                        </div>
                  </div> 
             </div>
           </div>  
     </div>
   <!-- +++++++++++++++++++++++++ start of category modal body +++++++++++++++++++++++++++++++++++++++++++++++ -->

<!-- Modal -->
<div class="modal fade" id="add-category-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header bg-primary">
        <h5 class="modal-title" id="categorydetails">Fill Category Details</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
           <form action="ProductOperationServlet" method="post">
              <input type="hidden" name="operation" value="addCategory">
              <div class="form-group">
                <label>Category Title</label>
                 <input type="text" class="form-control" name="categoryTitle"  placeholder=" enter categoryTitle" required >
              </div>
        <div class="form-group">
             <label>Category Details</label>
          <textarea class="form-control" id="categoryDescription" name="categoryDescription" rows="2"></textarea>
         </div> 
              <div class="container">
                  <button type="submit" class="btn btn-primary">Add Category</button>
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
              </div>
           </form>
      </div>
    </div>
  </div>
</div>
           <!--  end of modal body -->
  <!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
        <!-- start of product form --> 

<!-- Modal -->
<div class="modal fade" id="product-form" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header  bg-primary">
        <h5 class="modal-title" id="exampleModalLabel">Fill Product Details</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="ProductOperationServlet" method="post" enctype="multipart/form-data">
        <input type="hidden" name="operation" value="addProduct">
             <div class="form-group">
               <label for="pTitle">Product Title</label>
                 <input type="text" class="form-control" name="pTitle" id="pTitle" placeholder="enter product title here" required>
             </div>   
               <div class="form-group">
               <label for="pDescription">Product Description</label>
                 <textarea class="form-control" name="pDescription" rows="3" placeholder="write projet description"></textarea>
             </div>  
             <div class="form-group">
               <label for="pPrice">Price</label>
                 <input type="number" class="form-control" name="pPrice" id="pPrice" placeholder="Rs. price here" required>
             </div> 
               <div class="form-group">
               <label for="pDiscount">Discount</label>
                 <input type="number" class="form-control" name="pDiscount" id="pDiscount" placeholder="give discount in %" required>
             </div>   
              <div class="form-group">
               <label for="pQuantity">Quantity</label>
                 <input type="number" class="form-control" name="pQuantity" id="pQuantity" placeholder="number of quantity" required>
             </div>  
               
             <div class="form-group">
               <label for="cId">Product Type</label>
                 <select class="form-control" name="cId" id="cId">
                     <% for(Category c:list)
                     { 
                    	 %>
                       	<option value="<%=c.getcId() %>"><%=c.getCategoryTitle() %></option>  
                  <% 
                     }
                        %>
                        </select>
             </div>
              
            <div class="form-group">
              <label for="pPic">Select Picture for Product</label>
             <input type="file" class="form-control" name="pPhoto" id="pPhoto" required>
            </div>  
            <div class="container">
              <button type="submit" class="btn btn-primary">Add Product</button>
            </div>  
        </form>
      </div>
        <!-- start of product form -->   
</body>
</html>