package com.mycompany.songs;

import jakarta.servlet.RequestDispatcher;
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

@WebServlet(name = "Add_Song", urlPatterns = {"/Add_Song"})
public class Add_Song extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String name = request.getParameter("name");
            String album_movie = request.getParameter("album-movie");
            String singer = request.getParameter("singer");
            String language = request.getParameter("language");
            String year = request.getParameter("year");

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Web", "root", "Mysql@123");

            PreparedStatement ps = cn.prepareStatement("Insert into Song_Details(Name,Album_Movie,Singer,Language,Year) values(?,?,?,?,?)");

            ps.setString(1, name);
            ps.setString(2, album_movie);
            ps.setString(3, singer);
            ps.setString(4, language);
            ps.setString(5, year);

            boolean b = ps.execute();
            if (b == false) {

                RequestDispatcher rd = request.getRequestDispatcher("upload_song.html");
                rd.include(request, response);
//                out.println("<script>window.alert('Song Added') </script>");
            }

            cn.close();

        } catch (Exception e) {
            out.println(e.toString());
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
