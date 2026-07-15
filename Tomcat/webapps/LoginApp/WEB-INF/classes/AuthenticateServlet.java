import java.io.IOException;
import jakarta.servlet.*;

@WebServlet("/authenticate")
public class AuthenticateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("admin".equals(username) &&"nccs#123".equals(password)) {
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        } else {
            request.setAttribute("error","Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);}}}