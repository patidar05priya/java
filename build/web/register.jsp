<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.*"%>

<html>
<head>
<title> Online shopping </title>
<%@include file="header.html" %>
		<!-- registration-form -->
<div class="registration-form">
	<div class="container">
	<div class="dreamcrub">
			   	 <ul class="breadcrumbs">
                    <li class="home">
                       <a href="index.html" title="Go to Home Page">Home</a>&nbsp;
                       <span>&gt;</span>
                    </li>
                    <li class="women">
                       Registration
                    </li>
                </ul>
                <ul class="previous">
                	<li><a href="index.html">Back to Previous Page</a></li>
                </ul>
                <div class="clearfix"></div>
			   </div>
		<h2>Registration</h2>
		<div class="registration-grids">
			<div class="reg-form">
				<div class="reg">
					 <p>Welcome, please enter the following details to continue.</p>
					 <p>If you have previously registered with us, <a href="account.jsp">click here</a></p>
                                          ${message}
                                          ${msg }
					 <form action="LoginServlet?action=add" method = "post">
						 <ul>
							 <li class="text-info">First Name: </li>
							 <li><input type="text" value="" name = "firstname"></li>
						 </ul>
						 <ul>
							 <li class="text-info">Last Name: </li>
							 <li><input type="text" value="" name = "lastname"></li>
						 </ul>				 
						<ul>
							 <li class="text-info">Email: </li>
							 <li><input type="text" value="" name = "email"></li>
						 </ul>
                                             <ul>
							 <li class="text-info">User Name:</li>
							 <li><input type="text" value="" name = "username"></li>
						 </ul>	
						 <ul>
                                                           
							 <li class="text-info">Password: </li>
							 <li><input type="password" value="" name = "password"></li>
						 </ul>
						 <ul>
                                                           
							 <li class="text-info">Re-enter Password:</li>
							 <li><input type="password" value="" name = "confirm"></li>
						 </ul>
						 					
						 <input type="submit" value="REGISTER NOW">
						 <p class="click">By clicking this button, you are agree to my  <a href="">Policy Terms and Conditions.</a></p> 
					 </form>
				 </div>
			</div>
			<div class="reg-right">
				 <h3>Completely Free Account</h3>
				 <div class="strip"></div>
				
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!-- registration-form -->

		<%@include file="footer.html" %>
</body>
</html>