
import jakarta.servlet.GenericServlet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/Add")
public class Add extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        PrintWriter pw = res.getWriter();
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");

        int num_1 = Integer.parseInt(num1);
        int num_2 = Integer.parseInt(num2);

        int num_3 = num_1 + num_2;
        pw.println("Addition = " + num_3);
    }

}
