<%--
  Created by IntelliJ IDEA.
  User: stavr
  Date: 6/10/2019
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%

    session.invalidate();
 response.sendRedirect("Home.jsp");
    %>
</body>
</html>
