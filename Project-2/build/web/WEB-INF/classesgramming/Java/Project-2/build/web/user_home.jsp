<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Home</title>

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

            header {
                background-color: #1e1e1e;
                padding: 20px;
            }

            .container {
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

            h1 {
                font-size: 24px;
            }

            .profile-tab {
                position: relative;
            }

            .profile-link {
                text-decoration: none;
                color: #ffffff;
                padding: 10px 15px;
                border: 1px solid #ffffff;
                border-radius: 5px;
                transition: background-color 0.3s, color 0.3s;
            }

            .profile-link:hover {
                background-color: #ffffff;

                color: #121212;
            }

            .search-bar {
                text-decoration: none;
                background-color: #313030;
                color: #ffffff;
                padding: 10px 15px;
                border: 1px solid #ffffff;
                border-radius: 5px;
                transition: background-color 0.3s, color 0.3s;
                float: right; /* Moves this div to the right */
                
            }

            .search-icon {
                cursor: pointer;
                width: 30px; /* Adjust size as needed */
                height: 30px; /* Adjust size as needed */
                float: right; /* Moves this div to the right */

            }

            main {
                padding: 20px;
            }

            .content {
                background-color: #1e1e1e;
                padding: 20px;
                border-radius: 5px;
            }

            footer {
                text-align: center;
                padding: 10px;
                background-color: #1e1e1e;
                position: relative;
                bottom: 0;
                width: 100%;
            }
        </style>
    </head>
    <body>
        <% HttpSession hs = request.getSession(false);
            
            if (hs != null) {
            String name = (String) hs.getAttribute("name");
            String email = (String) hs.getAttribute("email");
            String mobile = (String) hs.getAttribute("mobile");
            String password  = (String) hs.getAttribute("password");
        %>

        <header>
            <div class="container">
                <h1>Welcome to Your Dashboard</h1>
                
                
                <div class="profile-tab">
                    <a href="user_profile.jsp" class="profile-link">Profile</a>
                    <!-- <a href="Logout" class="profile-link">Logout</a> -->
                </div>
                
            </div>
        </header>

        <main>
            <section class="content">
                <div class="songs">
                     <section class="song-list">

                <h2>Song List</h2>
                <!-- <a href="search.jsp" class="search-link">Search</a> -->
                <!-- <input type="text" id="search-bar" name="search-bar" placeholder="Search for songs" >  -->
                 
                <div class="search-container">
                    
                    <form action="search.jsp">

                    <input type="text" id="search-bar" name="search-bar" class="search-bar" placeholder="Search...">
                    <button type="submit" class="search-icon" id="search-icon">
                    <img src="images/search.png" alt="Search" width="30px">
                    </button>
                </form>
                </div>

                <br>

                <% try {
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        //make connection
                        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Web", "root", "Mysql@123");

                        //make statement object 
                        PreparedStatement ps = cn.prepareStatement("select * from Song_Details ");

                        ResultSet rs = ps.executeQuery();

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
            </section>
                </div>
            </section>
        </main>

        <footer>
            <p>&copy; 2025 Your Company. All rights reserved.</p>
        </footer>

        <% } else {
                out.println("<h2 style='margin:10px padding:10px' >Please login first</h2>");

                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.forward(request, response);
            }%>

    </body>
</html>
