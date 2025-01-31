<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Password Reset</title>

    <style>
      * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
      }

      body {
        font-family: Arial, sans-serif;
        background-color: #121212; /* Dark background */
        color: #ffffff;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
      }

      .container {
        width: 100%;
        max-width: 400px;
        background-color: #1e1e1e;
        padding: 30px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        text-align: center;
        transition: transform 0.3s ease; /* Transition for scaling */
      }

      .container:hover {
        transform: scale(1.02); /* Slightly scale up on hover */
      }

      h1 {
        margin-bottom: 20px;
      }

      .input-group {
        margin-bottom: 15px;
        text-align: left;
      }

      label {
        display: block;
        margin-bottom: 5px;
      }

      input[type="password"] {
        width: 100%;
        padding: 10px;
        font-size: 16px;
        border: 1px solid #ccc;
        border-radius: 4px;
      }

      input[type="password"]:focus {
        border-color: #007bff;
        outline: none;
      }

      button {
        padding: 10px 20px;
        font-size: 16px;
        color: white;
        background-color: #007bff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
      }

      button:hover {
        background-color: #0056b3;
      }

      #message {
        margin-top: 15px;
        color: red;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <h1>Change Password</h1>

      <% String e = request.getParameter("email"); %>

      <form action="Update_Password" id="passwordForm" method="post">
        <div class="input-group">
          <input type="text" name="email" value="<%=e%>" hidden />
          
          <label for="newPassword">New Password</label>
          <input
            type="password"
            name="new_password"
            id="newPassword"
            required
          />
        </div>

        <div class="input-group">
          <label for="confirmPassword">Confirm Password</label>

          <input
            type="password"
            name="confirm_password"
            id="confirmPassword"
            required
          />
        </div>

        <button type="submit" onclick="return check()">Submit</button>

        <p id="message"></p>
      </form>
    </div>

    <script>
      function check() {
        pwd = document.getElementById("newPassword").value;
        pwd2 = document.getElementById("confirmPassword").value;
        if (pwd === pwd2) {
          message.style.color = "green";
          message.textContent = "Password changed successfully!";

          return true;
        } else {
          //   window.alert("password or confirm password not match");
          message.style.color = "red";
          message.textContent = "Passwords do not match. Please try again.";

          return false;
        }
      }
    </script>
  </body>
</html>
