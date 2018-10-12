<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ohm
  Date: 10/11/18
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<jsp:include page="partials/navbar.jsp"/>
<form id ="form" action="login.jsp" method="POST">
    <input name="username" type="text" placeholder="Username">
    <input name="password" type="password" placeholder="Password">
    <button id="login">Login</button>
</form>
<%--<%! HttpServletRequest res;%>--%>
<%
    if (request.getMethod().equalsIgnoreCase("post")) {
        String user = request.getParameter("username");
        String password = request.getParameter("password");
        if (user.equals("admin") && password.equals("password")) {
            response.sendRedirect("/profile.jsp");
        }
    }
%>
</body>
</html>
