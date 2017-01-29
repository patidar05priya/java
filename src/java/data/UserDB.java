package data;

import business.Cart;
import business.Product;
import java.sql.*;
import java.util.ArrayList;

import business.User;

public class UserDB {

    public static int insertUser(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO usersignup(Firstname,Lastname,EmailAddress,Username,Password,Role) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getUserName());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getRole());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int insertProduct(Product product) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO Image(ImageName,Path,Price,Color,Dicription,size,Fabric,MadeIn,Gender,Type,dateofEntry) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getImageName());
            ps.setString(2, product.getPath());
            ps.setString(3, Double.toString(product.getPrice()));
            ps.setString(4, product.getColor());
            ps.setString(5, product.getDiscription());
            ps.setString(6, product.getSize());
            ps.setString(7, product.getFabric());
            ps.setString(8, product.getMade());
            ps.setString(9, product.getGender());
            ps.setString(10, product.getType());
            ps.setString(11, product.getDate());

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static User loginCheck(String userName, String password) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM UserSignup "
                + "WHERE Username = ? and Password = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, password);

            rs = ps.executeQuery();
            User user = new User();
            if (rs.next()) {
                user.setRole(rs.getString("Role"));
                user.setFirstName(rs.getString("Firstname"));

            }
            return user;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static User selectEmail(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM UserSignup "
                + "WHERE EmailAddress = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            User user = new User();
            if (rs.next()) {
                //user = new User();
                user.setFirstName(rs.getString("Firstname"));
                user.setEmail(rs.getString("EmailAddress"));
                user.setPassword(rs.getString("password"));

            }
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int updatePass(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE usersignup SET "
                + "password = ? "
                + "WHERE EmailAddress = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getEmail());

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static boolean EmaiExists(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT EmailAddress FROM UserSignup "
                + "WHERE EmailAddress = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            } else {
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
}
