
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

@WebServlet(urlPatterns = {"/Fetch"})
public class Fetch extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/College", "root", "Mysql@123");

            PreparedStatement ps = cn.prepareStatement("select * from Student");

            ResultSet rs = ps.executeQuery();

            pw.println("<table border = '2vh' width = '70%'>");
            pw.println("<caption><h2>Student Detail</h2></caption>");
            pw.println("      <tr>");
            pw.println("        <th>Roll Number</th>");
            pw.println("        <th>Name</th>");
            pw.println("        <th>Percentage</th>");
            pw.println("        <th>Edit</th>");
            pw.println("        <th>Delete</th>");
            pw.println("</tr>");

            while (rs.next()) {
                String roll = rs.getString(1);
                String name = rs.getString(2);
                String percent = rs.getString(3);

                pw.println("<tr><td>" + roll + "</td><td>" + name + "</td><td>" + percent + "</td><td><a href='Edit?roll=" + roll + "'><img src='image/Edit.png' height='80px' width='80px'></a></td><td><a href='Delete?roll=" + roll + "'><img src='image/delete.png' height='80px' width='80px'></a></td></tr>");

            }

            pw.println("</table>");
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
