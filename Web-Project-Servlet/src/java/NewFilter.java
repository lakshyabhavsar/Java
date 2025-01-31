
import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(servletNames = "Registration")
public class NewFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {

        String password = request.getParameter("password");
        String confirm_password = request.getParameter("confirm_password");

        RequestDispatcher rd = request.getRequestDispatcher("Registration");

        if (password.equals(confirm_password)) {
            rd.include(request, response);
        } else {

            fc.doFilter(request, response);
        }
    }

}
