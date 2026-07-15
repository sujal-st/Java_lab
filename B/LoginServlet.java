import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;


// javac -cp "lib\servlet-api.jar;webapps\CompanyApp\WEB-INF\lib\*" -d webapps\CompanyApp\WEB-INF\classes SaveCompany.java

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username.equals("admin") && password.equals("java@123")){

            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            RequestDispatcher rd =
                    request.getRequestDispatcher("dashboard.jsp");
            rd.forward(request, response);

        }else{

            request.setAttribute("error", "Invalid Username or Password");

            RequestDispatcher rd =
                    request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }
}