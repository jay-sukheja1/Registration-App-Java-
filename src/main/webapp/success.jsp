<%--
  Created by IntelliJ IDEA.
  User: jaysu_84yqwhz
  Date: 11-Aug-26
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
    <h1>Registration Success</h1>
<%
    String name = (String)session.getAttribute("name");
%>
<h2>Heyyy <%= name %>, you have registered to this web app</h2>
<h3>Click <a href="login.html">here</a> to login</h3>
</body>
</html>
