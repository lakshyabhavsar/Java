
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>

        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }
            
            body {
                font-family: Arial, sans-serif;
                background-color: #121212;
                color: #ffffff;
            }

            main {
                padding: 20px;
            }

            .songs {
                background-color: #1e1e1e;
                padding: 20px;
                border-radius: 5px;
            }
        </style>
    </head>
    <body>
        <main>
            <section class="content">
                <div class="songs">
                    <% try {
                    
                        String name = request.getParameter("search-bar");
                        
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Web", "root", "Mysql@123");

                        Statement smt = cn.createStatement();
                        
                        ResultSet rs = smt.executeQuery("select * from Song_Details where Name like'"+name+"%'");

                        while (rs.next()) {
                            String id = rs.getString("ID");
                            String songName = rs.getString("Name");
                            String song = rs.getString("FileName");%>


                <ul id="songs">

                    <!-- Songs will be dynamically inserted here -->
                    
                    <li>
                        <span class="name"><%=songName%></span>
                        
                        <audio controls>
                        <source src="<%=song%>" type="audio/mpeg">
                        Your browser does not support the audio element.
                        </audio>
                    
                    </li>

                </ul>

                <% }
                        cn.close();
                    } catch (Exception e) {
                        out.println(e.toString());
                    }%>
                </div>
            </section>
        </main>
    </body>
</html>
