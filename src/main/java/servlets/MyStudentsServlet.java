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
import java.awt.*;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/myStudents")
public class MyStudentsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentManager studentManager = new StudentManager();
        int id = Integer.parseInt(req.getParameter("id"));
        var allStudentsByTrainerId = studentManager.getAllStudentsByTrainerId(id);
        req.setAttribute("allStudentsByTrainerId", allStudentsByTrainerId);
        req.getRequestDispatcher("myStudents.jsp").forward(req, resp);
    }
}
