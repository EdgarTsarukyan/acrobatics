package servlets;

import manager.TrainerManager;
import model.Trainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/allTrainers")
public class AllTrainersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TrainerManager trainerManager = new TrainerManager();
        List<Trainer> allTrainers = trainerManager.getAllTrainers();
        req.setAttribute("allTrainers", allTrainers);
        req.getRequestDispatcher("allTrainers.jsp").forward(req,resp);
    }
}
