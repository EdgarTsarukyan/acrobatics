package servlets;

import manager.StudentManager;

import manager.TrainerManager;
import model.Gander;
import model.SportType;
import model.Student;
import model.Trainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@WebServlet(urlPatterns = "/registerStudent")
public class RegisterStudentServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        int trainerId = Integer.parseInt(req.getParameter("trainer_id"));
        int age = Integer.parseInt(req.getParameter("age"));
        String ganderType = req.getParameter("ganderType");
        String password = req.getParameter("password");

        StudentManager studentManager = new StudentManager();


        studentManager.addStudent(Student.builder()
                .name(name)
                .surname(surname)
                .age(age)
                .gander(Gander.valueOf(ganderType.toUpperCase()))
                .password(password)
                .trainerId(trainerId)
                .build());
        resp.sendRedirect("/login");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TrainerManager trainerManager = new TrainerManager();
        List<Trainer> allTrainers = trainerManager.getAllTrainers();
        req.setAttribute("allTrainers", allTrainers);
        req.getRequestDispatcher("registerStudent.jsp").forward(req, resp);

    }


}
