
package admin;

import business.*;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import data.ProductDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class SelectImagesServlet extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        String url = "";
         HttpSession session = request.getSession();
          ArrayList<Product> products = new ArrayList();
          
          if(request.getParameter("action").equals("inserCart"))
          {
              
              String imagename = request.getParameter("imageName");
              if(imagename==null)
              {
                  url="/checkout.jsp";
              }
              else
              {
               Double price = 0.0;
                  try{     
                     price =  Double.parseDouble(request.getParameter("price"));
                  }
                   catch(Exception e)
                   {
                       String message = "price Problem";
                       request.setAttribute("mge", message);
                  }
               String size = request.getParameter("size");
              Cart cart= new Cart();
              boolean imageExist;
              imageExist = ProductDB.imageExists(imagename);
              if(imageExist==true)
              {
                   int qty = ProductDB.selectQty(imagename);
                   cart.setQty(qty);
                 
                   cart.setImagename(imagename);
              cart.setPrice(price);
              cart.setSize(size);
              
                    ProductDB.updateCart(cart);
                
              }
              
              else{
              int qty = 0;
              qty++;
               cart.setQty(qty);
              
              cart.setImagename(imagename);
              cart.setPrice(price);
              cart.setSize(size);
               ProductDB.insertCart(cart);
              }
                ArrayList<Cart> carts = ProductDB.selectCartItems();
                int total = carts.size();
              
                session.setAttribute("total", total);
                   
               session.setAttribute("carts",carts);
               
               
               url = "/checkout.jsp";
              }
               
          }
          String action = request.getParameter("action");
          int count = action.length();
          if(count>15)
          {
          Product pro = new Product(action);
          String i = pro.getImageName();
          System.out.println(i);
          if(action.equals(i))
                  {
              Product product = ProductDB.selectNewProduct(action);
             
              session.setAttribute("product",product);
                    
             url = "/single.jsp";
          }
          }
      
        
        if (action.equals("updateQty"))
        {
           
             String imagename = request.getParameter("imageName");
            Double price = 0.0;
            int qty = 0;
                  try{     
                     price =  Double.parseDouble(request.getParameter("price"));
                      qty = Integer.parseInt(request.getParameter("qty"));
                  }
                   catch(Exception e)
                   {
                       String message = "price Problem";
                       request.setAttribute("mge", message);
                  }
                 
               String size = request.getParameter("size");
                Cart cart= new Cart();
                
               cart.setImagename(imagename);
               cart.setQty(qty);
              cart.setPrice(price);
              cart.setSize(size);
               if(qty!=0)
               {
              
                    ProductDB.updateCart(cart);
               }
               else{
                  
                    ProductDB.deleteCart(imagename);
                    }
               
                            ArrayList<Cart> carts = ProductDB.selectCartItems();
                int total = carts.size();
               
                session.setAttribute("total", total);
                   
               session.setAttribute("carts",carts);
               
               
               url = "/checkout.jsp";
               
        }
        if(action.equals("deleteQty"))
        {
         int qty = 0;
         double price =  0.0;
          String imagename = request.getParameter("imageName");
             
                  Cart cart= new Cart();
                  cart.setImagename(imagename);
              
                  ProductDB.deleteCart(imagename);
                
                   ArrayList<Cart> carts = ProductDB.selectCartItems();
               
               session.setAttribute("carts",carts);
               
               
               url = "/checkout.jsp";
        
        }
        if(action.equals("truncateCart"))
        {
            ProductDB.truncateCart();
            url= "/checkout.jsp";
                    }
        if(action.equals("showCart"))
        {
             ArrayList<Cart> carts = ProductDB.selectCartItems();
                int total = carts.size();
                
                session.setAttribute("total", total);
                   
               session.setAttribute("carts",carts);
               
               
               url = "/checkout.jsp";
            
        }
        
          getServletContext().getRequestDispatcher(url)
                .forward(request,response);
        
    }
   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
        doPost(request , response);
        
    }
    }

  


