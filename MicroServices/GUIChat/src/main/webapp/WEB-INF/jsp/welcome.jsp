<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% out.print(request.getSession().getAttribute("result"));%>
<% out.print(request.getSession().getAttribute("name"));%>
<% out.print(request.getSession().getAttribute("secondName"));%>
<% out.print(request.getSession().getAttribute("groups"));%>
<h1>Success!!!</h1>
</body>
</html>
