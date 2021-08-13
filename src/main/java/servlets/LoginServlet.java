package servlets;

import manager.StudentManager;
import manager.TrainerManager;
import model.Student;
import model.Trainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        TrainerManager trainerManager = new TrainerManager();

        HttpSession session = req.getSession();

            Trainer trainer = trainerManager.getTrainerByEmailAndPassword(email, password);
            if (trainer == null) {

                req.getRequestDispatcher("login.jsp").forward(req, resp);
            } else {

                session.setAttribute("trainer", trainer);
                resp.sendRedirect("/trainerHome");
            }




    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }
}
