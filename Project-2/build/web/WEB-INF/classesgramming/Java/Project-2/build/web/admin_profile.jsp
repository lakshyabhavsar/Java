
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>

        <style>
            body {
                background-color: #121212;
                color: #ffffff;
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }

            .container {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }

            .profile-card {
                background-color: #1e1e1e;
                border-radius: 10px;
                box-shadow: 0 4px 20px rgba(0, 0, 0, 0.5);
                padding: 20px;
                width: 300px;
                text-align: center;
            }

            .profile-header {
                margin-bottom: 20px;
            }

            .profile-pic {
                border-radius: 50%;
                width: 100px;
                height: 100px;
                margin-bottom: 15px;
            }

            .role {
                font-size: 14px;
                color: #b0b0b0;
            }

            .email, .phone {
                font-size: 16px;
                margin: 5px 0;
            }

            .profile-actions {
                margin-top: 20px;
            }

            .btn {
                background-color: #007bff;
                color: #ffffff;
                border: none;
                border-radius: 5px;
                padding: 10px 15px;
                cursor: pointer;
                transition: background-color 0.3s;
            }

            .btn:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>

        <% HttpSession hs = request.getSession(false);
            String name = (String) hs.getAttribute("name");
            String email = (String) hs.getAttribute("email");
            String mobile = (String) hs.getAttribute("mobile");
            
            if(hs != null){
        %>

        <div class="container">

            <div class="profile-card">

                <div class="profile-header">

                    <h1>Admin Profile</h1>

                </div>

                <div class="profile-info">

                    <img src="images/istockphoto-1300845620-612x612.jpg" alt="Profile Picture" class="profile-pic">

                    <h2><%=name%></h2>

                    <p class="role">Administrator</p>

                    <p class="email"><%=email%></p>

                    <p class="phone"><%=mobile%></p>

                </div>

                <div class="profile-actions">

                    
                        <form action="Admin_Edit" method="post" >
                            <button type="submit" class="btn">Edit Profile</button>
                        </form>
                    
                    <br>
                    
                        <form action="Admin_Logout" method ="post" >
                            <button ype="submit" class="btn">Logout</button>
                        </form>
                    

                </div>

            </div>

        </div>

                    <%} else{
                                out.println("<h2 style='margin:10px padding:10px' >Please login first</h2>");
                                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                                rd.forward(request, response);}
                    %>

    </body>
</html>
