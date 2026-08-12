<%--
  Created by IntelliJ IDEA.
  User: jaysu_84yqwhz
  Date: 12-Aug-26
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success</title>
</head>
<body>
    <%
        String name = (String)session.getAttribute("name");
    %>
    <h2>Heyy <%= name %>, Welcome to our app</h2>
</body>
</html>
