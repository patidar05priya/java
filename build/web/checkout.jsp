<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.*"%>
<%@page import="business.Product"%>
<html>
<head>
<%@include file="header.html" %> 
		<!-- checkout -->
<div class="cart-items">
	<div class="container">
	<div class="dreamcrub">
			   	 <ul class="breadcrumbs">
                    <li class="home">
                       <a href="index.jsp" title="Go to Home Page">Home</a>&nbsp;
                       <span>&gt;</span>
                    </li>
                    <li class="women">
                       Cart
                    </li>
                </ul>
                <ul class="previous">
                	<li><a href="Products.jsp">Back to Previous Page</a></li>
                </ul>
                <div class="clearfix"></div>
			   </div>
			 <h2>MY SHOPPING BAG</h2>
                         <c:forEach var ="carts" items = "${carts}">
		<div class="cart-gd">
				<script>$(document).ready(function(c) {
					$('.close1').on('click', function(c){
						$('.cart-header').fadeOut('slow', function(c){
							$('.cart-header').remove();
						});
						});	  
					});
			   </script>
			 <div class="cart-header">
                             
				 <div class="close1">
                                  <a href="SelectImages?action=updateQty">
                                 </div>
				 <div class="cart-sec simpleCart_shelfItem">
						<div class="cart-item cyc">
                                                    ${message}
							 <img src="images/${carts.imageName}" class="img-responsive" alt="">
						</div>
					   <div class="cart-item-info">
						<h3><a href="#"> Lorem Ipsum is not simply </a><span>Pickup time:</span></h3>
						<ul class="qty">
                                                    
							
                                                        <li><p>
                                                                <form action =" SelectImages?action=updateQty" method="post">
                                                    <input type ="hidden" name ="imageName" value ="${carts.imageName}">
                                                    <input type ="hidden" name ="price" value ="${carts.price}">
                                                    <input type ="hidden" name ="size" value ="${carts.size}">
                                                    
                                                     
                                                     <li><p>Price: $${carts.price} </p></li>
                                                        <li><p>Qty: <input type="text" name="qty" value="${carts.qty}" id="codeBox"/> </p></li>
							<li><p>FREE delivery</p></li>
                                                        <li> <input type="submit" value="Edit"  /></li>
                                                     </form> 
                                                      <a href="SelectImages?imageName=${carts.imageName}&action=deleteQty">Remove</a>
                                                     
                                                     
                                                
                                                     
                                                
                                                </p></li>
						</ul>
							 <div class="delivery">
							 <p>Service Charges : $10.00</p>
							 <span>Price       = ${carts.price*carts.qty} </span>
                                                        
                                                                
							 <div class="clearfix"></div>
				        </div>	
					   </div>
					   <div class="clearfix"></div>
											
				  </div>
			 </div>
			 
			
		</div>
                         </c:forEach>
	</div>
                         
</div>

<!-- //checkout -->	
		<div class="news-letter">
			<div class="container">
				<div class="join">
					<h6>JOIN OUR MAILING LIST</h6>
					<div class="sub-left-right">
						<form>
							<input type="text" value="Enter Your Email Here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter Your Email Here';}" />
							<input type="submit" value="SUBSCRIBE" />
						</form>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
		<div class="footer">
		<div class="container">
		 <div class="footer_top">
			<div class="span_of_4">
				<div class="col-md-3 span1_of_4">
					<h4>Shop</h4>
					<ul class="f_nav">
						<li><a href="#">new arrivals</a></li>
						<li><a href="#">men</a></li>
						<li><a href="#">women</a></li>
						<li><a href="#">accessories</a></li>
						<li><a href="#">kids</a></li>
						<li><a href="#">brands</a></li>
						<li><a href="#">trends</a></li>
						<li><a href="#">sale</a></li>
						<li><a href="#">style videos</a></li>
					</ul>	
				</div>
				<div class="col-md-3 span1_of_4">
					<h4>help</h4>
					<ul class="f_nav">
						<li><a href="#">frequently asked  questions</a></li>
						<li><a href="#">men</a></li>
						<li><a href="#">women</a></li>
						<li><a href="#">accessories</a></li>
						<li><a href="#">kids</a></li>
						<li><a href="#">brands</a></li>
					</ul>	
				</div>
				<div class="col-md-3 span1_of_4">
					<h4>account</h4>
					<ul class="f_nav">
						<li><a href="account.html">login</a></li>
						<li><a href="register.html">create an account</a></li>
						<li><a href="#">create wishlist</a></li>
						<li><a href="checkout.html">my shopping bag</a></li>
						<li><a href="#">brands</a></li>
						<li><a href="#">create wishlist</a></li>
					</ul>					
				</div>
				<div class="col-md-3 span1_of_4">
					<h4>popular</h4>
					<ul class="f_nav">
						<li><a href="#">new arrivals</a></li>
						<li><a href="#">men</a></li>
						<li><a href="#">women</a></li>
						<li><a href="#">accessories</a></li>
						<li><a href="#">kids</a></li>
						<li><a href="#">brands</a></li>
						<li><a href="#">trends</a></li>
						<li><a href="#">sale</a></li>
						<li><a href="#">style videos</a></li>
						<li><a href="#">login</a></li>
						<li><a href="#">brands</a></li>
					</ul>			
				</div>
				<div class="clearfix"></div>
				</div>
		  </div>
		  <div class="cards text-center">
				<img src="images/cards.jpg" alt="" />
		  </div>
		  <div class="copyright text-center">
				<p>© 2015 Eshop. All Rights Reserved | Design by   <a href="http://w3layouts.com">  W3layouts</a></p>
		  </div>
		</div>
		</div>
</body>
</html>