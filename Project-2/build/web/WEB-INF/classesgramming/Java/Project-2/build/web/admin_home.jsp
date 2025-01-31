<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

      main {
        padding: 20px;
      }

      .content {
        background-color: #1e1e1e;
        padding: 20px;
        border-radius: 5px;
        text-align: center;
      }

      footer {
        text-align: center;
        padding: 10px;
        background-color: #1e1e1e;
        position: relative;
        bottom: 0;
        width: 100%;
      }

      .dark-button {
        padding: 15px 30px; /* Button padding */
        background-color: #6200ea; /* Button background color */
        color: #ffffff; /* Button text color */
        border: none; /* Remove border */
        border-radius: 5px; /* Rounded corners */
        font-size: 16px; /* Font size */
        cursor: pointer; /* Pointer cursor on hover */
        transition: background-color 0.3s; /* Smooth background color transition */
      }

      .dark-button:hover {
        background-color: #3700b3; /* Darker shade on hover */
      }

      .songs_list {
        padding: 15px 30px; /* Button padding */
        background-color: #6200ea; /* Button background color */
        color: #ffffff; /* Button text color */
        border: none; /* Remove border */
        border-radius: 5px; /* Rounded corners */
        font-size: 16px; /* Font size */
        cursor: pointer; /* Pointer cursor on hover */
        transition: background-color 0.3s; /* Smooth background color transition */
      }

      .songs_list:hover {
        background-color: #3700b3; /* Darker shade on hover */
      }
    </style>
  </head>
  <body>
    <% HttpSession hs = request.getSession(false); if (hs == null) {
    
    out.println("<h2 style='margin: 10px'>Please login first</h2>"); 
    
    RequestDispatcher rd = request.getRequestDispatcher("index.html");
    rd.include(request, response); } else { %>

    <header>
      <div class="container">
        <h1>Welcome to Admin Dashboard</h1>

        <div class="profile-tab">
          <a href="admin_profile.jsp" class="profile-link">Profile</a>
        </div>
      </div>
    </header>

    <main>
      <div class="content">
        <h2>Welcome Admin</h2>

        <form action="add_song.html">
          <button class="dark-button">Add Song</button>
        </form>

        <br>

        <form action="songs_list.jsp" method="post">
          <button class="songs_list" name="songs_list">List Songs</button>
        </form>
      </div>

    </main>

    <footer>
      <p>&copy; 2025 My Website. All Rights Reserved.</p>
    </footer>
    <%}%>
  </body>
</html>
