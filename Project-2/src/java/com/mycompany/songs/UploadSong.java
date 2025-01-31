package com.mycompany.songs;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/UploadSong")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 50, // 50MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class UploadSong extends HttpServlet {

    private static final String UPLOAD_DIR = "songs";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Get form data
        String name = request.getParameter("name");
        String album_movie = request.getParameter("album-movie");
        String singer = request.getParameter("singer");
        String language = request.getParameter("language");
        String year = request.getParameter("year");

        // Handle file upload
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs(); // Create directory if not exists
        }

        String fileName = null;
        for (Part part : request.getParts()) {
            if (part.getName().equals("fileName")) {
                fileName = extractFileName(part);
                String filePath = uploadPath + File.separator + fileName;
                part.write(filePath); // Save file
            }
        }

        try {
            // Save data to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Web", "root", "Mysql@123");

            String sql = "INSERT INTO Song_Details(Name, Album_Movie, Singer, FileName, Language, Year) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, album_movie);
            ps.setString(3, singer);
            ps.setString(4, UPLOAD_DIR + "/" + fileName);
            ps.setString(5, language);
            ps.setString(6, year);

            // Save relative path in DB
            int rows = ps.executeUpdate();
            if (rows > 0) {
                response.getWriter().println("<p style='color:green;'>Song Uploaded Successfully!</p>");
                response.getWriter().println("Uploaded to: " + uploadPath);

            } else {
                response.getWriter().println("<p style='color:red;'>Failed to Upload Song.</p>");
            }

            cn.close();
        } catch (Exception e) {
            response.getWriter().println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        }
    }

    // Utility method to get file name from Part header
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        for (String content : contentDisp.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return null;
    }
}
