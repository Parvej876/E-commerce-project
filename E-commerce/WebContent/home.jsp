<%@ page import="onlineshopping.dao.CategoryDao" %>
 <%@ page import="onlineshopping.model.Category" %>
 <%@ page import="onlineshopping.dao.ProductDao" %>	
 <%@ page import="onlineshopping.model.Product" %>
 <%@ page import="helperclass.Helper" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
  <%@ include file="navbar.jsp" %>
 <div class="container-fluid">
   <div class="row mt-4 mx-2">
       <%    //fetching index value
            String cat=request.getParameter("category");
            //out.println(cat);
             //it will check that if all product field is selected it will send to home.js page along with all the product items!!
            List<Product> plist=null;
           if(cat==null || cat.trim().equals("all")){
        	    plist=ProductDao.getProductList();  
        	}else{    //if anyother field is selected beside all product option it will send to the home.jsp along with particular type of products!!!
        		int cId=Integer.parseInt(cat.trim());
        		plist=ProductDao.getAllProductById(cId);
        	}
        	   
        	   
        	   List<Category>list=CategoryDao.getCategoryList(); 
       %>
   
   <!-- for category list -->
    <div class="col-md-2  ">
    
      <div class="list-group">
      <!-- it will send to home.jsp page when all product is selected -->
      <a href="home.jsp?category=all" class="list-group-item list-group-item-action active bg-success">
      All Products
     </a>
     <% 
          for(Category c:list)
          {  %>
        	 
        <!-- it will send the request to home.jsp page along with category id when any of the the product type is clicked-->
     <a href="home.jsp?category=<%=c.getcId() %>" class="list-group-item list-group-item-action"><%=c.getCategoryTitle() %></a>	 
     <%    	 
          }
     %>
      </div>
    </div>
                <!-- for product list -->
     
    <div class="col-md-10">
      <!-- row -->
      <div class="row ">
       <!-- column-12 -->
       <div class="col-md-12">
          <div class="card-columns">
             <!-- traversing products -->
             <%   for(Product p:plist) 
             {  %>
                 
               <div class="card">
                 <div class="container text-center">
                   <img src="image/products/<%=p.getpPhoto() %>" style="max-height:180px;max-width:100%;width:auto;" class="card-img-top m-2" alt="...">
                    </div>
                   <div class="card-body">
                    <h5 class="card-title font-weight-bold"><%=p.getpTitle() %></h5>
                      <p class="card-text"><%=Helper.get10Word(p.getpDescription()) %></p>  
                       </div>
 <div class="card-footer text-center">
  <button class="btn btn-primary" onclick="add_to_cart(<%=p.getpId() %> , '<%=p.getpTitle() %>' , <%=p.getPriceAfterApplyingDiscount() %>)">Add to Cart</button>
      <button class="btn btn-outline-success">&#8377;<%=p.getPriceAfterApplyingDiscount()%>/-<span class="text-secondary discount-label">&#8377;<%=p.getpPrice()%>, <%=p.getpDiscount() %>% off</span></button>
                     
                     </div>
                     
                   </div>
                
             <%
             } 
               // if item is not present!!!
              if(plist.size()==0){
            	  out.println("<h3>No item is available!!!</h3>");
              }
             %>
                     </div>
                    </div>
          
                </div>
       
            </div>     
          </div>
       </div>   
    </nav> 
   
</body>
</html>