<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Something goes wrong</h1>
<%
    out.print(request.getAttribute("Ex"));
    out.print("<br>");
    out.print("<br>");
    StackTraceElement[] stackTrace = (StackTraceElement[]) request.getAttribute("Message");
    for (StackTraceElement ex : stackTrace) {
        out.print(ex);
        out.print("<br>");

    }%>
</body>
</html>
