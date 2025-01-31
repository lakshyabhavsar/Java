<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>JSP Page</title>

        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #121212;

            }

            header {
                background: #333;
                color: #fff;
                padding: 10px 0;
                text-align: center;
            }

            main {
                padding: 20px;
            }

            .song-list {
                background: #1f1e1e;
                color: #fff;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                padding: 20px;
            }

            .song-list1 {
                width: 100%;
                border-collapse: separate;
                border-spacing: 0 10px;
            }

            .song-list h2 {
                margin-top: 0;
            }

            ul {
                list-style-type: none;
                padding: 0;
            }

            li {
                padding: 10px;
                border-bottom: 1px solid #ddd;
            }

            li:last-child {
                border-bottom: none;
            }

            footer {
                text-align: center;
                padding: 10px 0;
                background: #333;
                color: #fff;
                position: relative;
                bottom: 0;
                width: 100%;
            }
        </style>
    </head>
    <body>

        <header>
            <h1>Songs</h1>

        </header>

        <main>

            <section class="song-list">

                <h2>Song List</h2>

                <% try {
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        //make connection
                        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Web", "root", "Mysql@123");

                        //make statement object 
                        PreparedStatement ps = cn.prepareStatement("select * from Song_Details ");

                        ResultSet rs = ps.executeQuery();

                        while (rs.next()) {
                            String id = rs.getString("ID");
                            String name = rs.getString("Name");
                            String song = rs.getString("FileName");%>


                <div class="songs list">
                <ul id="songs">

                    <!-- Songs will be dynamically inserted here -->
                    
                        <li>
                            <span class="name"><%=name%></span>
                        
                            <audio controls>
                            <source src="<%=song%>" type="audio/mpeg">
                            Your browser does not support the audio element.
                            </audio>
                    
                        </li>
                    </ul>
                </div>

                <% }
                        cn.close();
                    } catch (Exception e) {
                        out.println(e.toString());
                    }%>
            </section>

        </main>

        <footer>

            <p>&copy; 2025 My WebSite</p>

        </footer>
    </body>
</html>
