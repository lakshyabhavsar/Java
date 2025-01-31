
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>two</title>
    </head>
    <body>
        <h1>Age Checker</h1>

        <%
            String a = request.getParameter("age");

            int age = Integer.parseInt(a);

            if (age < 18) {
        %>
        <h3>Invalid Age..!</h3>
        <%
        } else {
        %>
        <h3>Valid Age.</h3>
        <%
            }
        %>

    </body>
</html>
