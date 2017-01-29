<%@page import="java.sql.Date"%>
<%@page import= "admin.UploadServlet"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.*"%>
<%@page import="java.util.*"%>

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
                       <a href="index.jsp" title="Go to Home Page">Home</a>&nbsp;
                        
                       <span>&gt;</span>
                    </li>
                    <li class="women">
                       Add Product
                    </li>
                </ul>
                <ul class="previous">
                	<li><a href="LogoutServlet">Logout</a></li>
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
                                          <form action="UploadServlet" method="post"
                                           enctype="multipart/form-data">
                                            <input type="file" name="file"  />
                                            <br />
                                            <input type="submit" value="Upload File"/>
                                          </form>

                                           <form action="LoginServlet?action=addProduct" method = "post">
                                              <ul>
							 <li class="text-info">ImageName </li>
							 <li><input type="text" value="${fileName}" name = "imageName"></li>
						 </ul>
                                               <ul>
							 <li class="text-info">Price </li>
							 <li><input type="text" value="" name = "price"></li>
						 </ul>
						 <ul>
							 <li class="text-info">Color : </li>
							 <li><input type="text" value="" name = "color"></li>
						 </ul>				 
						<ul>
							 <li class="text-info">Discription </li>
							 <li><input type="text" value="" name = "discription"></li>
						 </ul>
                                             <ul>
							 <li class="text-info">Size</li>
							 <li><input type="text" value="" name = "size"></li>
						 </ul>	
						 <ul>
                                                           
							 <li class="text-info">fabric </li>
							 <li><input type="text" value="" name = "fabric"></li>
						 </ul>
						 <ul>
                                                           
							 <li class="text-info">Made In</li>
							 <li><input type="text" value="" name = "made"></li>
						 </ul>
                                              <ul>
                                                           
							 <li class="text-info">Gender</li>
							 <li><input type="text" value="" name = "gender"></li>
						 </ul>
                                                <ul>
                                                           
							 <li class="text-info">Type</li>
							 <li><input type="text" value="" name = "type"></li>
						 </ul>
                                              <ul>
                                                           
							 <li class="text-info">Date</li>
							 <li><input type="text"  value="${Currentdate}" name = "date"></li>
						 </ul>
                                              
						 					
						 <input type="submit" value="Add Product">
						 <p class="click">By clicking this button, you are agree to my  <a href="">Policy Terms and Conditions.</a></p> 
					 </form>
				 </div>
			</div>
			<div class="reg-right">
                            
                            <img src="images/${fileName}"/>
                            <div class="strip">
                                
                            </div>
				
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!-- registration-form -->

		<%@include file="footer.html" %>
</body>
</html>