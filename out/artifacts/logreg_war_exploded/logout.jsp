<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 5/3/20
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    session.setAttribute("userid", null);
    session.invalidate();
    response.sendRedirect("index.jsp");
%>

</body>
</html>
