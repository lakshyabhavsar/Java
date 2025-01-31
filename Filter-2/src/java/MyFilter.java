
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(servletNames = "Serv")
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {
        PrintWriter pw = response.getWriter();

        String name = request.getParameter("name");
        String age = request.getParameter("age");

        RequestDispatcher rd = request.getRequestDispatcher("index.html");

        if (name.equals("")) {
            pw.println("<script>window.alert('Name is Required'); </script>");
            rd.include(request, response);
        } else if (age.equals("")) {
            pw.println("<script>window.alert('Age is Required'); </script>");
            rd.include(request, response);

        } else {

            fc.doFilter(request, response);
        }
    }
}
