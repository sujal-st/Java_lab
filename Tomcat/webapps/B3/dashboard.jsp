<%@ page language="java" %>

<%
String user = (String)session.getAttribute("username");

if(user == null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<html>
<head>
<title>Dashboard</title>
</head>

<body>

<h2>Welcome <%= user %></h2>

<a href="LogoutServlet">Logout</a>

</body>
</html>