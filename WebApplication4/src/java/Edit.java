
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(urlPatterns = {"/Edit"})
public class Edit extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();

        try {
            String roll = request.getParameter("roll");

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/College", "root", "Mysql@123");

            PreparedStatement ps = cn.prepareStatement("select * from Student where Roll_No = ?");
            ps.setString(1, roll);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String name = rs.getString(2);
                String percent = rs.getString(3);

//                pw.println("Roll no=" + roll);
//                pw.println("Name=" + name);
//                pw.println("Percentage=" + percent);
                pw.println("<form action='Update'>");
                pw.println("<h1>Update Details</h1>");
                pw.println("<br>");
                pw.println("<input type='text' name='roll' value = '" + roll + "' readonly/>");
                pw.println("<br>");
                pw.println("<label for='name'>Name</label>");
                pw.println("<input type='text' name='name' value = '" + name + "' />");
                pw.println("<br>");
                pw.println("<label for='percent'>Percentage</label>");
                pw.println("<input type='text' name='percent' value = '" + percent + "' />");
                pw.println("<br>");
                pw.println("<button type='submit'>Update</button>");
                pw.println("</form>");
            }

            cn.close();

        } catch (Exception e) {
            pw.println(e.toString());
        }

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
