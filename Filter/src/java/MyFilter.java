
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {
        PrintWriter pw = response.getWriter();

        String name = request.getParameter("name");
        String age = request.getParameter("age");

        RequestDispatcher rd = request.getRequestDispatcher("index.html");

        if (name.equals("") && age.equals("")) {

            pw.println("<script>window.alert('Enter Name and Age'); </script>");
            rd.include(request, response);

        } else if (name.equals("")) {

            pw.println("<script>window.alert('Name is Required'); </script>");
            rd.include(request, response);

        } else if (age.equals("")) {

            pw.println("<script>window.alert('Age is Required'); </script>");
            rd.include(request, response);

        } else {

            pw.println("<body bgcolor=red>");
            fc.doFilter(request, response);
            pw.println("</body>");

        }
    }
}
