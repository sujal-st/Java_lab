import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
@WebServlet("/demo")
public class CookieSessionDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Cookie + Session Demo</h2>");
        HttpSession session = request.getSession();
        session.setAttribute("username", "admin");
        session.setAttribute("course", "Java Servlet");
        out.println("<h3>Session Data Set</h3>");
        out.println("Session ID: " + session.getId() + "<br>");
        out.println("Username stored in session<br><br>");
        Cookie userCookie = new Cookie("username", "admin");
        Cookie roleCookie = new Cookie("role", "student");
        userCookie.setMaxAge(60 * 60);
        roleCookie.setMaxAge(60 * 60);
        response.addCookie(userCookie);
        response.addCookie(roleCookie);
        out.println("<h3>Cookies Set</h3>");
        out.println("username cookie = admin<br>");
        out.println("role cookie = student<br><br>");
        out.println("<h3>Reading Cookies</h3>");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println(c.getName() + " = " + c.getValue() + "<br>");
            }
        }
        out.println("<h3>Reading Session</h3>");
        HttpSession existingSession = request.getSession(false);
        if (existingSession != null) {
            out.println("Username: " + existingSession.getAttribute("username") + "<br>");
            out.println("Course: " + existingSession.getAttribute("course") + "<br>");
        } else {
            out.println("No session found");
        }
    }
}