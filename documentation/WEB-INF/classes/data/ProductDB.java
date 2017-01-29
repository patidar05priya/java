
package data;
import business.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

public class ProductDB {
     public static Product selectNewProduct(String imageName) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Image "
                + "WHERE ImageName = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, imageName);
            rs = ps.executeQuery();
            Product product = null;
              int count =0;
            while (rs.next()) {
              
                product = new Product();
                product.setImageName(rs.getString("ImageName"));
                product.setPrice(rs.getDouble("Price"));
                product.setColor(rs.getString("color"));
                product.setDiscription(rs.getString("Dicription"));
                product.setSize(rs.getString("Size"));
                product.setFabric(rs.getString("Fabric"));
                product.setMade(rs.getString("MadeIn"));
                product.setGender(rs.getString("Gender"));
                product.setType(rs.getString("Type"));
                product.setDate(rs.getString("dateofEntry"));
                count++;
                
            }
            System.out.println(count);
            return product;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
     public static ArrayList<Product> selectProducts(String type) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
         ArrayList<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Image "
                + "WHERE Type = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, type);
            rs = ps.executeQuery();
            Product product = null;
              int count =0;
            while (rs.next()) {
              
                product = new Product();
                product.setImageName(rs.getString("ImageName"));
                product.setPrice(rs.getDouble("Price"));
                product.setColor(rs.getString("color"));
                product.setDiscription(rs.getString("Dicription"));
                product.setSize(rs.getString("Size"));
                product.setFabric(rs.getString("Fabric"));
                product.setMade(rs.getString("MadeIn"));
                product.setGender(rs.getString("Gender"));
                product.setType(rs.getString("Type"));
                product.setDate(rs.getString("dateofEntry"));
                count++;
                products.add(product);
                
            }
            System.out.println(count);
            return products;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
      public static int insertCart(Cart cart) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO Cart (ImageName, Price, size, Qty) "
                + "VALUES (?, ?, ?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, cart.getImageName());
            ps.setDouble(2, cart.getPrice());
            ps.setString(3, cart.getSize());
            ps.setInt(4,cart.getQty());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
      public static ArrayList<Cart> selectCartItems() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Cart";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Cart> carts = new ArrayList<>();
            
           while(rs.next()) {
              Cart cart = new Cart();
               
                cart.setImagename(rs.getString("ImageName"));
                cart.setPrice(rs.getDouble("Price"));
                cart.setSize(rs.getString("size"));
                cart.setQty(rs.getInt("Qty"));
                carts.add(cart);
            }
            return carts;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        // add code that returns an ArrayList<User> object of all users in the User table
       
    } 
      public static boolean imageExists(String imageName) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT ImageName  FROM cart "
                + "WHERE ImageName = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, imageName);
            rs = ps.executeQuery();
           
            if(rs.next())
            {
                return true;
            }
            else{
                return false;
            }
           
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
       public static int selectQty(String imageName) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT Qty FROM cart "
                + "WHERE ImageName = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, imageName);
            rs = ps.executeQuery();
            Cart cart = new Cart();
            int qty=0;
            if (rs.next()) {
                //user = new User();
               qty = rs.getInt("Qty");
               qty++;
               cart.setQty(qty);
            }
            System.out.println("qty"+qty);
            return qty;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
       public static int updateCart(Cart cart) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE Cart SET "
                +"Price = ?, "
                + "size = ?,"
                + "Qty = ? "
                + "WHERE ImageName = ?";
        try {
            ps = connection.prepareStatement(query);
             ps.setDouble(1, cart.getPrice());
             ps.setString(2, cart.getSize());
            ps.setInt(3, cart.getQty());
           
            
            ps.setString(4, cart.getImageName());
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
        public static int deleteCart(String imageName) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM Cart "
                + "WHERE ImageName = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,imageName);

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
        public static int truncateCart() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "truncate table Cart; ";
               
        try {
            ps = connection.prepareStatement(query);
          

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
}
