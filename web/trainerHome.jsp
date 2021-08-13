<%@ page import="model.Trainer" %><%--<%@ page import="model.Trainer" %>
<%@ page import="javax.persistence.Id" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
my students:
<%Trainer trainer = (Trainer) session.getAttribute("trainer");%>
<a href="/myStudents?id=<%=trainer.getId()%>"><input type="submit" value="allMyStudents"></a>
</body>
</html>
