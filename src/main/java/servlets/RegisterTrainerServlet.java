package servlets;

import manager.TrainerManager;
import model.Gander;
import model.SportType;
import model.Trainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/registerTrainer")
public class RegisterTrainerServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));
        String ganderType = req.getParameter("ganderType");
        String sportType = req.getParameter("sportType");

        TrainerManager trainerManager = new TrainerManager();
        trainerManager.add(Trainer.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .age(age)
                .gander(Gander.valueOf(ganderType))
                .sportType(SportType.valueOf(sportType))
                .build());


        resp.sendRedirect("/login");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registerTrainer.jsp").forward(req, resp);
    }
}
