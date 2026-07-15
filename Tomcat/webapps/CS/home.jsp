<%@ page import="javax.servlet.http.Cookie"%>
<html>
    <body>
        <h2>Session & cookie</h2>

        <%
            String userSession = (String) session.getAttribute("user");

            String userCookie - "Not found";
            Cookie[] cookies - request.getCookies();

            i(cookies!= null)
            {
                for(Cookie c: cookies)
                {
                    if(c.getName().equals("username"))
                    {
                        userCookie = c.getValue();
                    }
                }
            }
        %>

        <p><b>Session:</b><%=userSession%></p>
        <p><b>Cookie:</b><%=userCookie%></p>
    </body>
</html>