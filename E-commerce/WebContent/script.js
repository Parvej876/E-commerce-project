
  function add_to_cart(pId,pTitle,pPrice){
	  
	  let cart=localStorage.getItem("cart");
	   if(cart==null){
		   //cart is empty
		  let products=[];
		  let product={productId:pId,productName:pTitle,productQuantity:1,productPrice:pPrice};
		  products.push(product);
		  
		  localStorage.setItem("cart",JSON.stringify(products));
		 //	 console.log("new product is added");
		  showToastMessage(" product is added to cart");
	   }
	   else{
		//there is some item in a cart   
		    
		   pcart=JSON.parse(cart);
		     //checking id is present in cart or not
		  let oldProduct=pcart.find((item)=> item.productId==pId);
		    
		  if(oldProduct){
			  // id matched then we have to increase the productQuantity
			  oldProduct.productQuantity=oldProduct.productQuantity+1;
              pcart.map((item)=>{
            	if(item.productId==oldProduct.productId){
            		item.productQuantity=oldProduct.productQuantity;
            	}  
              })
                localStorage.setItem("cart",JSON.stringify(pcart));
             //console.log("product quantity is increased");
              showToastMessage(" product quantity is increased ");
		  }
		  else{
			  //we have to add the item 
			  let product={productId:pId,productName:pTitle,productQuantity:1,productPrice:pPrice};
			  pcart.push(product);
			  localStorage.setItem("cart",JSON.stringify(pcart));
			 //console.log("product is added");
			  showToastMessage(" product is added to cart");
		  }
		   
	   }
	   
	  updateCart();    
  }
  
                       //update cart
    function updateCart(){
    	let cartString=localStorage.getItem("cart");
    	 let cart=JSON.parse(cartString);
    	 if(cart==null || cart.length==0){
    		   
    		 console.log("cart is empty!!");
    		 $(".cart-items").html("( 0 )"); 
    		 $(".cart-body").html("<h3>Cart does not have any item</h3>");
    		 $(".checkOut-btn").attr('disabled',true);   //when there is no item in cart making the checkout button in visible
    		
    	 }else{
    		 //there is something in cart
    		 //console.log(cart);
    		 $(".cart-items").html(`(${cart.length})`);	
    		 
    		 let table= ` 
    		     <table class="table">
    		     <thead class="thead-light">
    		     <tr>
    		     <th>Item Name</th>
    		     <th>Price</th>
    		     <th>Quantity</th>
    		     <th>Total Price</th>
    		     <th>Action</th>
    		 
    		 </tr>
    		 </thead>
    		 
    		 `;
    		  
    		 let totalPrice=0;
    		 cart.map((item)=>{
    		
    			 table+= `
    			   <tr>
    			   <td>${item.productName}</td>
     			    <td>${item.productPrice}</td>
    			    <td>${item.productQuantity}</td>
    			    <td>${item.productQuantity*item.productPrice}</td>
    			    <td><button onclick='removeItemFromCart(${item.productId})' class="btn btn-danger btn-sm">Remove</button></td>
    			 </tr>
    			 `
    				 totalPrice+=item.productPrice*item.productQuantity;
    		 })
    		 
    		 table=table + `<tr><td colspan='5' class='text-right font-weight-bold m-5'>TotalPrice:${totalPrice}</tr></td></table>`;
    		 $(".cart-body").html(table);
    		 // when there is item in cart making the checkout button visible
    		 $(".checkOut-btn").attr('disabled',false);
    		 
    	 }
    	
    }
    
    //remove or delete item form cart
    function removeItemFromCart(pId){
      let cart=JSON.parse(localStorage.getItem('cart'));
          let newcart=cart.filter((item) => item.productId != pId);
         localStorage.setItem('cart',JSON.stringify(newcart));
          updateCart();
          showToastMessage(" product is removed from cart");
    }
    
    // displaying toast message for adding,deleting product from cart
    function showToastMessage(content){
    	$("#toast").addClass("display");
    	$("#toast").html(content);
    	
    	setTimeout(() => {
    		$("#toast").removeClass("display");
    	},2000);
    }
    
    //creating checkout function to send it to checkout .jsp page 
    function goToCheckOut(){
    	window.location="checkOut.jsp";
    }
    
    $(document).ready(function(){
  	  updateCart(); 
    })
     
 
  