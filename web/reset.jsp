<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.*"%>
<html>
<head>
<title>Online shopping</title>
<%@include file="header.html" %> 
		<!-- content-section-starts -->
	<div class="content">
	<div class="container">
		<div class="login-page">
			    <div class="dreamcrub">
			   	 <ul class="breadcrumbs">
                    <li class="home">
                       <a href="index.html" title="Go to Home Page">Home</a>&nbsp;
                       <span>&gt;</span>
                    </li>
                    <li class="women">
                       Login
                    </li>
                </ul>
                <ul class="previous">
                	<li><a href="index.html">Back to Previous Page</a></li>
                </ul>
                <div class="clearfix"></div>
			   </div>
			   <div class="account_grid">
			   <div class="col-md-6 login-left wow fadeInLeft" data-wow-delay="0.4s">
			  	 <h2>NEW CUSTOMERS</h2>
				 <p>By creating an account with our store, you will be able to move through the checkout process faster, store multiple shipping addresses, view and track your orders in your account and more.</p>
				 <a class="acount-btn" href="register.jsp">Create an Account</a>
			   </div>
			   <div class="col-md-6 login-right wow fadeInRight" data-wow-delay="0.4s">
			  	<h3>Password Recovery</h3>
				
                                <p>${msg} </p>
				<form action="LoginServlet?action=resetPass" method="post">
				  <div>
                                     <span>Password<label>*</label></span>
                                     <input type="hidden" name="email" value = "${email}"> 
					<input type="password" name="password"> 
                                        <span>Confirm Password<label>*</label></span>
					<input type="password" name="confirm"> 
				  </div>
				<input type="submit" value="Reset">
                                  
			    </form>
                                
			   </div>	
			   <div class="clearfix"> </div>
			 </div>
		   </div>
</div>
<%@include file="footer.html" %>		
</body>
</html>