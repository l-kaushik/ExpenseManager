package in.lokeshkaushik.expensemanager.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dashboard")
public class DashboardController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false); // do not create new session if missing
        String page = request.getParameter("page");
        // verify is already log in, has a session data else send back to login page
        if(session == null || !session.getAttribute("login-key").equals("valid")){
            System.out.println("dashboard: redirecting to login");
            response.sendRedirect("/login");
            return;
        }
        else if(page == null || page.isEmpty()){
            request.getRequestDispatcher("WEB-INF/views/dashboard.jsp").forward(request,response);
            return;
        }

        // send relevant page data
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        switch (page) {
            case "dashboard":
                out.println("<h2>Dashboard</h2><p>Dashboard content here...</p>");
                break;
            case "expenses":
                out.println("<h2>Expenses</h2><p>Expenses content here...</p>");
                break;
            case "report":
                out.println("<h2>Report</h2><p>Report content here...</p>");
                break;
                case "export":
                out.println("<h2>Export</h2><p>Export content here...</p>");
                break;
                case "settings":
                out.println("<h2>Settings</h2><p>Settings content here...</p>");
                break;
            default:
                out.println("<h2>Welcome</h2><p>Select a section</p>");
        }

        // disable caching so back button won't show stale page
    }
}
