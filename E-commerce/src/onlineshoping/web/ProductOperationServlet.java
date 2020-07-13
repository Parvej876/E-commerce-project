package onlineshoping.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import onlineshopping.dao.CategoryDao;
import onlineshopping.dao.ProductDao;
import onlineshopping.model.Category;
import onlineshopping.model.Product;

@MultipartConfig
public class ProductOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static HttpSession session=null;
      
    public ProductOperationServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // here we are using single servlet for two jsp file and fetching its value based on hidden operation value
		String op=request.getParameter("operation");
		 //fetching the addCategory values
		 if(op.trim().equals("addCategory")){
			   
			 Category category=new Category();
			 category.setCategoryTitle(request.getParameter("categoryTitle"));
			 category.setCategoryDetails(request.getParameter("categoryDetails"));
			 //calling addCategory method from Categorydao layer to insert the values
			 CategoryDao.addCategory(category);
			 
			 session=request.getSession();
			 session.setAttribute("message","category added successfully!!");
			 response.sendRedirect("admin.jsp");
			 return;
			 
		 }
		//fetching the addProduct values
		 else if(op.trim().equals("addProduct")){
			 String pTitle=request.getParameter("pTitle");
			 String pDescription=request.getParameter("pDescription");
			 int pPrice=Integer.parseInt(request.getParameter("pPrice"));
			 int pDiscount=Integer.parseInt(request.getParameter("pDiscount"));
			 int pQuantity=Integer.parseInt(request.getParameter("pQuantity"));
			 int cId=Integer.parseInt(request.getParameter("cId"));
			 Part part=request.getPart("pPhoto");
			 
			 Product p=new Product();
			 p.setpTitle(pTitle);
			 p.setpDescription(pDescription);
			 p.setpPrice(pPrice);
			 p.setpDiscount(pDiscount);
			 p.setpQuantity(pQuantity);
			 p.setpPhoto(part.getSubmittedFileName());
			 p.setcId(cId);
	         
			 //product save
			  ProductDao.saveProduct(p);
			 
			 // uploading photo
	String path=request.getRealPath("image")+File.separator+"products"+File.separator+part.getSubmittedFileName();
	System.out.println(path);
	     
	   try{
		   // upload code
			  FileOutputStream fos=new FileOutputStream(path);
			  
			  InputStream is=part.getInputStream();//getting the content of file and storing it in is coz content is present in part
			  
			    //reading data
			    byte[]data=new byte[is.available()]; // creating array to store content of file n getting its size through available method
			    is.read(data);
			    
			    //writing data
			    fos.write(data);
			    fos.close();
	   }catch(Exception e){
		   e.printStackTrace();
	   }
			 
			 session=request.getSession();
			 session.setAttribute("message","product added successfully!!");
			 response.sendRedirect("admin.jsp");
			 return;
			 
			 
		 }
	}

}
