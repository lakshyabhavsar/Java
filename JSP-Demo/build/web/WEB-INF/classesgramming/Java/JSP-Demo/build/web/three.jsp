
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>three</title>
    </head>
    <body>
        <h1>Declaration Tag</h1>

        <%!
//        Diclaration Tag
            int n = 100;

            int m(int a, int b) {
                return a + b;
            }
        %>

        <h4><% out.println(n); %></h4>

        <h4><% out.println("Add -> " + m(15, 20));%></h4>
    </body>
</html>
