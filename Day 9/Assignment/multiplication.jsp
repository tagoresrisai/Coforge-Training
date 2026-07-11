<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<body>
<h2>Multiplication Table</h2>
<%
    int n = 5;
    for (int i = 1; i <= 10; i++) {
        out.println(n + " x " + i + " = " + (n * i) + "<br>");
    }
%>
</body>
</html>
