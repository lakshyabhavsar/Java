<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page import=" com.mycompany.user.Forget_Password_Link_Send" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Verify OTP</title>

    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #121212;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
      }

      .container {
        /* background: white; */
        background: #1e1e1e;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center;
      }

      h1 {
        margin-bottom: 20px;
        color: #999898;
      }

      .otp-inputs {
        display: flex;
        justify-content: space-between;
        margin-bottom: 20px;
      }

      .otp {
        width: 40px;
        height: 40px;
        font-size: 24px;
        text-align: center;
        border: 1px solid #797878;
        border-radius: 4px;
        margin: 0 5px;
      }

      .otp:focus {
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
    </style>
  </head>
  <body>
    <div class="container">
      <h1>Enter OTP</h1>

      <% String e = request.getParameter("email"); 
      String otp = request.getParameter("otp");
      %>

      <form action="update_password.jsp" id="otpForm" method="post">
        <input type="email" name="email" value="<%=e%>" hidden />

        <input type="text" name="defaultOTP" id="defaultOTP" value="<%=otp%>" hidden/>
        
        <div class="otp-inputs">
          <input
            type="text"
            maxlength="4"
            class="otp"
            name="one"
            id="1"
            required
          />

          <input
            type="text"
            maxlength="1"
            class="otp"
            name="two"
            id="2"
            required
          />

          <input
            type="text"
            maxlength="1"
            class="otp"
            name="three"
            id="3"
            required
          />

          <input
            type="text"
            maxlength="1"
            class="otp"
            name="four"
            id="4"
            required
          />
        </div>
        
        <button type="submit" onchange="userOTP()">Submit</button>
      </form> 
    </div>

    <script>
      const otpInputs = document.querySelectorAll(".otp");

      otpInputs.forEach((input, index) => {
          input.addEventListener("input", (e) => {
              if (e.target.value.length === 1 && index < otpInputs.length - 1) {
                  otpInputs[index + 1].focus();
              } else if (e.target.value.length === 0 && index > 0) {
                  otpInputs[index - 1].focus();
              }
          });
      });
    </script>
  </body>
</html>
