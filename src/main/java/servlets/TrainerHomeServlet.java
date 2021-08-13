package servlets;

import manager.StudentManager;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/trainerHome")
public class TrainerHomeServlet extends HttpServlet {

    StudentManager studentManager = new StudentManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var id = req.getParameter("id");
        var i = Integer.parseInt(id);
        List<Student> myStudents = studentManager.getAllStudentsByTrainerId(i);
        req.setAttribute("myStudents", myStudents);
        req.getRequestDispatcher("myStudents.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("trainerHome.jsp").forward(req, resp);
    }
}
