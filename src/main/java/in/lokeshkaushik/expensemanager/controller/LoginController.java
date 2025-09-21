package in.lokeshkaushik.expensemanager.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println(request.getParameter("uname") + " " + request.getParameter("pass"));


        // hack to authenticate validation
        HttpSession session = request.getSession();
        session.setAttribute("login-key", "valid");

        response.sendRedirect(request.getContextPath() + "/dashboard");
//        request.getRequestDispatcher("/dashboard").forward(request, response);
    }
}
