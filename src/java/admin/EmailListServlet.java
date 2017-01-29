package admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.MessagingException;

import business.User;
import data.UserDB;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import util.MailUtilGmail;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // get current action
        String action = request.getParameter("action");
        String url = "";
        if (action.equals("send")) {
            // get parameters from the request
            String message = "";
            String em = request.getParameter("email");
            boolean emailExists = UserDB.EmaiExists(em);
            if (emailExists == true) {

                HttpSession session = request.getSession();
                String uuid = UUID.randomUUID().toString();

                User user = UserDB.selectEmail(em);
                String email = user.getEmail();
                session.setAttribute("email", email);
                String firstName = user.getFirstName();
                String password = user.getPassword();
                System.out.println(password);
                String to = email;
                String from = "email_list@murach.com";

                String ur = "/reset.jsp";
                String link = "http://localhost:8080/Priya_Project/LoginServlet?action=resetpwd&value=" + uuid + "&value=" + email;
                String subject = "Regarding Password Recovery";
                String body = "Dear " + firstName + ",\n\n"
                        + "Your password Recovery Link is below. Click on that..."
                        + link;

                boolean isBodyHTML = false;

                try {
                    System.out.println("indise try");
                    //MailUtilLocal.sendMail(to, from, subject, body, isBodyHTML);
                    MailUtilGmail.sendMail(to, from, subject, body, isBodyHTML);

                } catch (MessagingException e) {
                    String errorMessage
                            = "ERROR: Unable to send email. "
                            + "Check Tomcat logs for details.<br>"
                            + "NOTE: You may need to configure your system "
                            + "as described in chapter 14.<br>"
                            + "ERROR MESSAGE: " + e.getMessage();
                    request.setAttribute("errorMessage", errorMessage);
                    this.log(
                            "Unable to send email. \n"
                            + "Here is the email you tried to send: \n"
                            + "=====================================\n"
                            + "TO: " + email + "\n"
                            + "FROM: " + from + "\n"
                            + "SUBJECT: " + subject + "\n"
                            + "\n"
                            + body + "\n\n");
                }
                message = "password has been sent to your email ";

            } else {
                message = "Email doesn't exists in our database";

            }
            request.setAttribute("message", message);
            url = "/forget.jsp";

        }
        if (action.equals("subscribe")) {

            String message = "";
            String em = request.getParameter("email");
            HttpSession session = request.getSession();
            String to = em;
            String from = "email_list@murach.com";

            String subject = "Subscription";
            String body = "Dear " + em + ",\n\n"
                    + "You are subscribe to new updates";

            boolean isBodyHTML = false;

            try {
                System.out.println("indise try");
                //MailUtilLocal.sendMail(to, from, subject, body, isBodyHTML);
                MailUtilGmail.sendMail(to, from, subject, body, isBodyHTML);

            } catch (MessagingException e) {
                String errorMessage
                        = "ERROR: Unable to send email. "
                        + "Check Tomcat logs for details.<br>"
                        + "NOTE: You may need to configure your system "
                        + "as described in chapter 14.<br>"
                        + "ERROR MESSAGE: " + e.getMessage();
                request.setAttribute("errorMessage", errorMessage);
                this.log(
                        "Unable to send email. \n"
                        + "Here is the email you tried to send: \n"
                        + "=====================================\n"
                        + "TO: " + em + "\n"
                        + "FROM: " + from + "\n"
                        + "SUBJECT: " + subject + "\n"
                        + "\n"
                        + body + "\n\n");
            }

            String uri = request.getRequestURI();
            String pageName = uri.substring(uri.lastIndexOf("/") + 1);
            System.out.println("pagename" + pageName + "and URL" + uri);
            url = "/home.jsp";
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
