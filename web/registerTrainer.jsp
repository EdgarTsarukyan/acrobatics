<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.08.2021
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Register as Trainer<br>
<form action="/registerTrainer" method="post">
    name:<input type="text" name="name" placeholder="name"><br>
    surname:<input type="text" name="surname" placeholder="surname"><br>
    email:<input type="text" name="email" placeholder="email"><br>
    password:<input type="password" name="password" placeholder="password"><br>
    age:<input type="text" name="age" placeholder="age"><br>
    <select name="ganderType"><br>
        <option value="BOY">BOY</option>
        <option value="GIRL">GIRL</option>
    </select><br>
    <select name="sportType">
        <option value="ACROBATICS">ACROBATICS</option>
        <option value="ART_GYMNASTICS">ART_GYMNASTICS</option>
        <option value="BOYS_GYMNASTICS">BOYS_GYMNASTICS</option>
        <option value="GIRLS_GYMNASTICS">GIRLS_GYMNASTICS</option>
        <option value="JUMPERS">JUMPERS</option>
    </select>
    <input type="submit" value="Register">

</form>
</body>
</html>
