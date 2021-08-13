<%@ page import="model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="manager.StudentManager" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.08.2021
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Students</title>
</head>
<body>
<%List<Student> myStudents = (List<Student>)request.getAttribute("allStudentsByTrainerId");


%>
<div>
    all trainers<br>
    <table>

        <tr>
            <th>name</th>
            <th>surname</th>
            <th>age</th>
            <th>gander</th>

        </tr>

        <%
            for (Student myStudent : myStudents) {%>
        <tr>
            <td><%=myStudent.getName()%></td>
            <td><%=myStudent.getSurname()%></td>
            <td><%=myStudent.getAge()%></td>
            <td><%=myStudent.getGander()%></td>

            <td><a href="/myStudents?id=<%=myStudent.getId()%>">delete</a></td>
        </tr>
        <% }%>


    </table>
</div>

</body>
</html>
