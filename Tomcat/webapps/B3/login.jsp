<%@ page language="java" %>

<html>
<head>
    <title>Login Page</title>
</head>
<body>

<h2>Login</h2>

<%
String error = (String)request.getAttribute("error");
if(error != null){
%>
<p style="color:red;"><%= error %></p>
<%
}
%>

<form action="LoginServlet" method="post">

Username:
<input type="text" name="username"><br><br>

Password:
<input type="password" name="password"><br><br>

<input type="submit" value="Login">

</form>

</body>
</html>