<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<body>
<%!
    int add(int a, int b) {
        return a + b;
    }
%>
<h2>JSP Scripting Elements</h2>
<p>Declaration Example: <%= add(5, 7) %></p>
<%
    int number = 10;
    out.println("Scriptlet Example: " + number);
%>
<p>Expression Example: <%= "Hello from JSP" %></p>
</body>
</html>
