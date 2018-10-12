<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ohm
  Date: 10/12/18
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../partials/head.jsp"/>
<body>
<h1 class="ad">Posts</h1>
<c:forEach var="ads" items="${ads}">
    <div class="ad">
        <h2>${ads.title}</h2>
        <p>${ads.description}</p>
    </div>
</c:forEach>

</body>
</html>
