package com.mycompany.user;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import java.io.PrintWriter;

@WebFilter("/update_password.jsp")
public class CheckUserOTP implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        String one = request.getParameter("one");
        String two = request.getParameter("two");
        String three = request.getParameter("three");
        String four = request.getParameter("four");
        
        String userOTP = one + two +three + four;

        String defaultOTP = request.getParameter("defaultOTP");

        if (userOTP.equals(defaultOTP)) {
            fc.doFilter(request, response);

        } else {
            out.println("Invalid OTP");
        }
    }

}
