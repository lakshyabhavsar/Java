
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Forget_Password"})
public class Forget_Password extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();

        String email = request.getParameter("email");

        pw.println("<body>");
        pw.println("<div class = 'form-container'>");
        pw.println("<form action='Password_Update' method='post'>");
        pw.println("<h2>Enter Details</h2>");

        pw.println("<input type='mail' name='email' value ='" + email + "' hidden>");

        pw.println("<label for='new_password'>New Password:</label>");
        pw.println("<input type='password' id='new_password' name='new_password' required />");

        pw.println("<label for='confirm_password'>Confirm Password:</label>");
        pw.println("<input type='password' id='confirm_password' name='confirm_password' required/>");

        pw.println("<button type='submit' onclick='return check()'>Submit</button>");

        pw.println("</form>");
        pw.println("</div>");

        pw.println("<style>\n"
                + "      * {\n"
                + "        margin: 0;\n"
                + "        padding: 0;\n"
                + "        box-sizing: border-box;\n"
                + "      }\n"
                + "\n"
                + "      body {\n"
                + "        font-family: Arial, sans-serif;\n"
                + "        background-color: #f4f4f4;\n"
                + "        display: flex;\n"
                + "        justify-content: center;\n"
                + "        align-items: center;\n"
                + "        height: 100vh;\n"
                + "      }\n"
                + "\n"
                + "      .form-container {\n"
                + "        background-color: white;\n"
                + "        padding: 20px;\n"
                + "        border-radius: 8px;\n"
                + "        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n"
                + "        width: 300px;\n"
                + "      }\n"
                + "\n"
                + "      h2 {\n"
                + "        text-align: center;\n"
                + "        margin-bottom: 20px;\n"
                + "        font-size: 1.5em;\n"
                + "      }\n"
                + "\n"
                + "      label {\n"
                + "        display: block;\n"
                + "        margin-bottom: 5px;\n"
                + "        font-size: 1em;\n"
                + "      }\n"
                + "\n"
                + "      input[type=\"password\"] {\n"
                + "        width: 100%;\n"
                + "        padding: 8px;\n"
                + "        margin-bottom: 15px;\n"
                + "        border: 1px solid #ccc;\n"
                + "        border-radius: 4px;\n"
                + "        font-size: 1em;\n"
                + "      }\n"
                + "\n"
                + "      button {\n"
                + "        width: 100%;\n"
                + "        padding: 10px;\n"
                + "        background-color: #007bff;\n"
                + "        color: white;\n"
                + "        border: none;\n"
                + "        border-radius: 4px;\n"
                + "        font-size: 1.1em;\n"
                + "        cursor: pointer;\n"
                + "      }\n"
                + "\n"
                + "      button:hover {\n"
                + "        background-color: #0056b3;\n"
                + "      }\n"
                + "    </style>");

        pw.println("<script>\n"
                + "      function check() {\n"
                + "        pwd = document.getElementById('new_password').value;\n"
                + "        pwd2 = document.getElementById('confirm_password').value;\n"
                + "\n"
                + "        if (pwd === pwd2) {\n"
                + "          return true;\n"
                + "        } else {\n"
                + "          window.alert('password or confirm password not match');\n"
                + "          return false;\n"
                + "        }\n"
                + "      }\n"
                + "    </script>");

        pw.println("</body>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
