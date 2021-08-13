<%@ page import="model.Trainer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.08.2021
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Register as Student<br>
<form action="/registerStudent" method="post">
    name:<input type="text" name="name" placeholder="name"><br>
    surname:<input type="text" name="surname" placeholder="surname"><br>
    age:<input type="text" name="age" placeholder="age"><br>
    <select name="ganderType"><br>
        <option value="boy">BOY</option>
        <option value="girl">GIRL</option>
    </select><br>
    password:<input type="password" name="password" placeholder="password"><br>
<% int id = Integer.parseInt(request.getParameter("id"));%>
  <input type="hidden" name="trainer_id" value="<%=id%>"><br>

    <input type="submit" value="Register">

</form>
</body>
</html>
