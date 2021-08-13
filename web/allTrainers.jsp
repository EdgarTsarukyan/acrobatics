<%@ page import="model.Trainer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.Writer" %>
<%@ page import="manager.TrainerManager" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.08.2021
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%Trainer trainer = new Trainer();%>
<%TrainerManager trainerManager = new TrainerManager();
%>

<% List<Trainer> allTrainers = (List<Trainer>) request.getAttribute("allTrainers");%>


<div>
    all trainers<br>
    <table>

        <tr>
            <th>name</th>
            <th>surname</th>
            <th>sportType</th>
        </tr>
<%
    for (Trainer allTrainer : allTrainers) {%>
        <tr>
             <td><a href="/registerTrainer"><%=allTrainer.getName()%></a>
            </td>
            <td><a href="/login"> <%=allTrainer.getSurname()%>
           </a></td>
            <td><%=allTrainer.getSportType()%></td>

           <td><a href="/registerStudent?id=<%=allTrainer.getId()%>">choose</a></td>
        </tr>
   <% }%>


    </table>
</div>


</body>
</html>
