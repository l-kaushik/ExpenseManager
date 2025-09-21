package in.lokeshkaushik.expensemanager.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false); // do not create new session if missing

        // verify is already log in, has a session data else send back to login page
        if(session == null || !session.getAttribute("login-key").equals("valid")){
            response.sendRedirect("/login");
            return;
        }

        request.getRequestDispatcher("WEB-INF/views/dashboard.jsp").forward(request,response);
        // disable caching so back button won't show stale page
    }
}
