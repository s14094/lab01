<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title></head>
<body><% String name = request.getParameter("name");
    String password = request.getParameter("password");
    if ((name.equals("admin") && password.equals("admin1"))) {
        session.setAttribute("name", name);
        response.sendRedirect("hello");
    } else response.sendRedirect("error.jsp"); %></body>
</html>