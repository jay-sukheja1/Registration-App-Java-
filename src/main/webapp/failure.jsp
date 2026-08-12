<%--
  Created by IntelliJ IDEA.
  User: jaysu_84yqwhz
  Date: 11-Aug-26
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Failure</title>
</head>
<body>
<h1><marquee>Registration Failure</marquee></h1>
<%
    String name = (String)session.getAttribute("name");
%>
<h2>Sorry <%= name %>, you fail to register to this web app</h2>
</html>
