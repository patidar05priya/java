package admin;

import business.Product;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import business.User;
import data.UserDB;
import java.security.NoSuchAlgorithmException;
//import java.sql.Date;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import util.PasswordUtil;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String url = "";
        String action = request.getParameter("action");
        if (action.equals("login")) {
            User user = new User();
            String userName = request.getParameter("username");
            String password = request.getParameter("password");

            String saltedAndHashedPassword;
            String hashedPassword = "";
            String salt = "";
            try {
                hashedPassword = PasswordUtil.hashPassword(password);
                salt = PasswordUtil.getSalt();
                saltedAndHashedPassword = PasswordUtil.hashAndSaltPassword(password);

            } catch (NoSuchAlgorithmException ex) {

                saltedAndHashedPassword = ex.getMessage();
            }

            System.err.println(saltedAndHashedPassword);

            User u = UserDB.loginCheck(userName, hashedPassword);
            if (u.getRole().equals("admin")) {

                String msg = "Admin Login";
                request.setAttribute("message", msg);
                url = "/productAdd.jsp";
            } else if (u.getRole().equals("user")) {
                String name = u.getFirstName();
                session.setAttribute("name", "Wlcome  " + name);
                String msg = "Successfull";
                request.setAttribute("message", msg);
                url = "/products.jsp";

            } else {

                String msg = "Email/Password doen't match or doen't exist";
                request.setAttribute("message", msg);
                url = "/account.jsp";
            }
        }
        if (action.equals("add")) {
            String msg = "";
            boolean emailExists;
            String email = request.getParameter("email");
            emailExists = UserDB.EmaiExists(email);
            if (emailExists == false) {

                String firstName = request.getParameter("firstname");
                String lastName = request.getParameter("lastname");

                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String confirm = request.getParameter("confirm");
                if (password.equals(confirm)) {
                    String message;
                    try {
                        PasswordUtil.checkPasswordStrength(password);
                        message = "";
                    } catch (Exception e) {
                        message = e.getMessage();
                    }
                    request.setAttribute("message", message);

                    // hash and salt password
                    String hashedPassword;
                    String salt = "";
                    String saltedAndHashedPassword;
                    try {
                        hashedPassword = PasswordUtil.hashPassword(password);
                        salt = PasswordUtil.getSalt();
                        saltedAndHashedPassword = PasswordUtil.hashAndSaltPassword(password);

                    } catch (NoSuchAlgorithmException ex) {
                        hashedPassword = ex.getMessage();
                        saltedAndHashedPassword = ex.getMessage();
                    }
                    User user = new User();
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setEmail(email);
                    user.setPassword(hashedPassword);
                    user.setUserName(username);
                    UserDB.insertUser(user);

                    msg = "Signup done";
                    request.setAttribute("message", msg);
                } else {
                    msg = "password doesn't match..!";
                    request.setAttribute("msg", msg);
                }
            } else {
                msg = "Email Already exixts";
                request.setAttribute("message", msg);
            }
            url = "/register.jsp";

        }
        if (action.equals("addProduct")) {

            String imageName = (String) session.getAttribute("fileName");
            String path = (String) session.getAttribute("filePath");
            String price = request.getParameter("price");
            double priceF = Double.parseDouble(request.getParameter("price"));
            String color = request.getParameter("color");

            String discription = request.getParameter("discription");
            String size = request.getParameter("size");
            String fabric = request.getParameter("fabric");
            String made = request.getParameter("made");
            String date = request.getParameter("date");
            String gender = request.getParameter("gender");
            String type = request.getParameter("type");

            Product product = new Product();
            product.setImageName(imageName);
            product.setPath(path);
            product.setPrice(priceF);
            product.setColor(color);
            product.setDiscription(discription);
            product.setSize(size);
            product.setFabric(fabric);
            product.setMade(made);
            product.setGender(gender);
            product.setType(type);
            product.setDate(date);

            UserDB.insertProduct(product);

            url = "/productAdd.jsp";

        }
        if (action.equals("forgot")) {
            String message = "Enter your email adress for which you want password";
            request.setAttribute("mess", message);
            url = "/forgot.jsp";
        }
        if (action.equals("resetpwd")) {
            url = "/reset.jsp";
        }
        if (action.equals("resetPass")) {
            String confirm = request.getParameter("confirm");
            String pass = request.getParameter("password");
            String saltedAndHashedPassword;
            String hashedPassword = "";
            String salt = "";
            try {
                hashedPassword = PasswordUtil.hashPassword(pass);
                salt = PasswordUtil.getSalt();
                saltedAndHashedPassword = PasswordUtil.hashAndSaltPassword(pass);

            } catch (NoSuchAlgorithmException ex) {

                saltedAndHashedPassword = ex.getMessage();
            }
            if (pass.equals(confirm)) {
                String email = request.getParameter("email");
                User u = new User();
                u.setPassword(hashedPassword);
                u.setEmail(email);
                UserDB.updatePass(u);
                String mesage = "Password has been reset";
                request.setAttribute("msg", mesage);
            } else {
                String mesage = "Password doesnt matcht";
                request.setAttribute("msg", mesage);
            }
            url = "/reset.jsp";

        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}
