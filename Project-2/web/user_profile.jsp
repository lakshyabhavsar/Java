<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Profile</title>

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

      .nav-buttons {
        display: flex;
      }

      .home-button,
      .logout-button {
        text-decoration: none;
        color: #ffffff;
        padding: 10px 15px;
        border: 1px solid #ffffff;
        border-radius: 5px;
        margin: 0 5px;
        transition: background-color 0.3s, color 0.3s;
      }

      .home-button:hover,
      .logout-button:hover {
        background-color: #ffffff;
        color: #121212;
      }

      main {
        padding: 20px;
      }

      .profile-container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: calc(100vh - 120px);
        /* Adjust height based on header/footer */
      }

      .profile-card {
        background-color: #1e1e1e;
        border-radius: 10px;
        padding: 20px;
        width: 300px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.5);
        text-align: center;
      }

      .profile-header {
        margin-bottom: 20px;
      }

      .profile-picture {
        border-radius: 50%;
        width: 100px;
        height: 100px;
        margin-bottom: 10px;
      }

      .username {
        font-size: 20px;
        margin: 10px 0;
      }

      .email {
        font-size: 14px;
        color: #bbb;
      }

      .profile-details h3 {
        margin-top: 20px;
        margin-bottom: 10px;
      }

      .profile-details p,span {
        margin-bottom: 10px;
      }

      .profile-details ul {
        list-style-type: none;
        padding: 0;
      }

      .profile-details li {
        background-color: #333;
        margin: 5px 0;
        padding: 5px;
        border-radius: 5px;
      }

      #password {
        display: none; /* Initially hide the text */
        margin-top: 10px;
        color: #ffffff;

      }

      #toggleButton {
        cursor: pointer;
        color: white;
        background-color: #007BFF;
        padding: 10px 15px;
        border: none;
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
    <% HttpSession hs = request.getSession(false); String name = (String)
    hs.getAttribute("name"); String email = (String) hs.getAttribute("email");
    String mobile = (String) hs.getAttribute("mobile"); String password =
    (String) hs.getAttribute("password");%>

    <header>
      <div class="container">
        <div class="nav-buttons">
          <a href="user_home.jsp" class="home-button">Home</a>
        </div>

        <div class="profile-tab">
          <h1>User Profile</h1>
        </div>

        <div class="nav-buttons">
          <a href="Logout" class="logout-button">Logout</a>
        </div>
      </div>
    </header>

    <main>
      <section class="profile-container">
        <div class="profile-card">
          <div class="profile-header">
            <img
              src="images/istockphoto-1300845620-612x612.jpg"
              alt="Profile Picture"
              class="profile-picture"
            />

            <h2 class="username"><%=name%></h2>
          </div>
          <div class="profile-details">
            <p class="email"><strong>Email:</strong> <%=email%></p>

            <p class="mobile">
              <strong>Mobile:</strong>
              <%=mobile%>
            </p>
            
            <p class="user-password">
              <strong>Password:</strong>
              <span id="password"> <%=password%> </span>
              <button id="toggleButton">Show Text</button>
            </p>
          </div>
        </div>
      </section>
    </main>

    <footer>
      <p>&copy; 2023 Your Company. All rights reserved.</p>
    </footer>

    <script>

      const button = document.getElementById('toggleButton');
      const hiddenText = document.getElementById('password');

      button.onclick = function() {
          if (hiddenText.style.display === 'none' || hiddenText.style.display === '') {

              hiddenText.style.display = 'block'; // Show the text
              button.textContent = 'Hide Text'; // Change button text

          } else {

              hiddenText.style.display = 'none'; // Hide the text
              button.textContent = 'Show Text'; // Change button text back
          }
      };

  </script>
  </body>
</html>
