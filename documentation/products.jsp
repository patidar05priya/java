<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.*"%>
<%@page import="business.Product"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="header.html" %> 
   
        <!-- content-section-starts -->
    <div class="container">
        <div class="products-page">
            <div class="products">
                <div class="product-listy">
                    <h2>our Products</h2>
                    <ul class="product-list">
                        <li><a href="">New Products</a></li>
                        <li><a href="">Old Products</a></li>
                        <li><a href="">T-shirts</a></li>
                        <li><a href="">pants</a></li>
                        <li><a href="">Dress</a></li>
                        <li><a href="">Shorts</a></li>
                        <li><a href="#">Shirts</a></li>
                        <li><a href="register.html">Register</a></li>
                    </ul>
                </div>
                <div class="latest-bis">
                    <img src="images/l4.jpg" class="img-responsive" alt="" />
                    <div class="offer">
                        <p>40%</p>
                        <small>Top Offer</small>
                    </div>
                </div> 	
                <div class="tags">
                    <h4 class="tag_head">Tags Widget</h4>
                    <ul class="tags_links">
                        <li><a href="#">Kitesurf</a></li>
                        <li><a href="#">Super</a></li>
                        <li><a href="#">Duper</a></li>
                        <li><a href="#">Theme</a></li>
                        <li><a href="#">Men</a></li>
                        <li><a href="#">Women</a></li>
                        <li><a href="#">Equipment</a></li>
                        <li><a href="#">Best</a></li>
                        <li><a href="#">Accessories</a></li>
                        <li><a href="#">Men</a></li>
                        <li><a href="#">Apparel</a></li>
                        <li><a href="#">Super</a></li>
                        <li><a href="#">Duper</a></li>
                        <li><a href="#">Theme</a></li>
                        <li><a href="#">Responsive</a></li>
                        <li><a href="#">Women</a></li>
                        <li><a href="#">Equipment</a></li>
                    </ul>

                </div>

            </div>
            <div class="new-product">
                <div class="new-product-top">
                    <ul class="product-top-list">
                        <li><a href="index.jsp">Home</a>&nbsp;<span>&gt;</span></li>
                        <li><span class="act">Best Sales</span>&nbsp;</li>
                    </ul>
                    <p class="back"><a href="index.jsp">Back to Previous</a></p>
                    <div class="clearfix"></div>
                </div>
                <div class="mens-toolbar">
                    <div class="sort">
                        <div class="sort-by">
                            <label>Sort By</label>
                            <select>
                                <option value="">
                                    Position                </option>
                                <option value="">
                                    Name                </option>
                                <option value="">
                                    Price                </option>
                            </select>
                            <a href=""><img src="images/arrow2.gif" alt="" class="v-middle"></a>
                        </div>
                    </div>
                    <ul class="women_pagenation">
                        <li>Page:</li>
                        <li class="active"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                    </ul>
                    <div class="clearfix"></div>		
                </div>
                <div id="cbp-vm" class="cbp-vm-switcher cbp-vm-view-grid">
                    <div class="cbp-vm-options">
                        <a href="#" class="cbp-vm-icon cbp-vm-grid cbp-vm-selected" data-view="cbp-vm-view-grid" title="grid">Grid View</a>
                        <a href="#" class="cbp-vm-icon cbp-vm-list" data-view="cbp-vm-view-list" title="list">List View</a>
                    </div>
                    <div class="pages">   
                        <div class="limiter visible-desktop">
                            <label>Show</label>
                            <select>
                                <option value="" selected="selected">
                                    9                </option>
                                <option value="">
                                    15                </option>
                                <option value="">
                                    30                </option>
                            </select> per page        
                        </div>
                    </div>

                    <div class="clearfix" ></div>
                    
                        <ul>
                            <c:forEach var = "products" items = "${products}">
                           <li class="col-xs-4" id="first_element">
                                    <a class="cbp-vm-image" href="SelectImages?action=${products.imageName}" >
                                        <div class="simpleCart_shelfItem">
                                            <div class="view view-first">
                                                <div class="inner_content clearfix">
                                                    <div class="product_image">

                                                        <img src="images/${products.imageName}" class="img-responsive" alt="">
                                                        <div class="mask">
                                                            <div class="info">Quick View</div>
                                                        </div>
                                                        <div class="product_container">
                                                            <div class="cart-left">
                                                                <p class="title">${products.discription}</p>
                                                            </div>
                                                            <div class="pricey"><span class="item_price">${products.price}</span></div>
                                                            <div class="clearfix"></div>
                                                        </div>		
                                                    </div>
                                                </div>
                                            </div>
                                    </a>
                                    <div class="cbp-vm-details">

                         
                                </li> 
                            </c:forEach>
                         </ul>
                

                <script src="js/cbpViewModeSwitch.js" type="text/javascript"></script>
                <script src="js/classie.js" type="text/javascript"></script>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="clearfix"></div>
    </div>
    <!-- content-section-ends -->
    <div class="other-products">
        <div class="container">
            <h3 class="like text-center">Featured Collection</h3>        			
            <ul id="flexiselDemo3">
                <li><a href="single.html"><img src="images/l1.jpg" class="img-responsive"/></a>
                    <div class="product liked-product simpleCart_shelfItem">
                        <a class="like_name" href="single.html">Perfectly simple</a>
                        <p><a class="item_add" href="#"><i></i> <span class=" item_price">$759</span></a></p>
                    </div>
                </li>
                <li><a href="single.html"><img src="images/l2.jpg" class="img-responsive"/></a>						
                    <div class="product liked-product simpleCart_shelfItem">
                        <a class="like_name" href="single.html">Praising pain</a>
                        <p><a class="item_add" href="#"><i></i> <span class=" item_price">$699</span></a></p>
                    </div>
                </li>
                <li><a href="single.html"><img src="images/l3.jpg" class="img-responsive"/></a>
                    <div class="product liked-product simpleCart_shelfItem">
                        <a class="like_name" href="single.html">Neque porro</a>
                        <p><a class="item_add" href="#"><i></i> <span class=" item_price">$329</span></a></p>
                    </div>
                </li>
                <li><a href="single.html"><img src="images/l4.jpg" class="img-responsive"/></a>
                    <div class="product liked-product simpleCart_shelfItem">
                        <a class="like_name" href="single.html">Equal blame</a>
                        <p><a class="item_add" href="#"><i></i> <span class=" item_price">$499</span></a></p>
                    </div>
                </li>
                <li><a href="single.html"><img src="images/l5.jpg" class="img-responsive"/></a>
                    <div class="product liked-product simpleCart_shelfItem">
                        <a class="like_name" href="single.html">Perfectly simple</a>
                        <p><a class="item_add" href="#"><i></i> <span class=" item_price">$649</span></a></p>
                    </div>
                </li>
            </ul>
            <script type="text/javascript">
                $(window).load(function () {
                    $("#flexiselDemo3").flexisel({
                        visibleItems: 4,
                        animationSpeed: 1000,
                        autoPlay: true,
                        autoPlaySpeed: 3000,
                        pauseOnHover: true,
                        enableResponsiveBreakpoints: true,
                        responsiveBreakpoints: {
                            portrait: {
                                changePoint: 480,
                                visibleItems: 1
                            },
                            landscape: {
                                changePoint: 640,
                                visibleItems: 2
                            },
                            tablet: {
                                changePoint: 768,
                                visibleItems: 3
                            }
                        }
                    });

                });
            </script>
            <script type="text/javascript" src="js/jquery.flexisel.js"></script>
        </div>
    </div>
    <!-- content-section-ends-here -->
  <%@include file="footer.html" %>
</body>
</html>