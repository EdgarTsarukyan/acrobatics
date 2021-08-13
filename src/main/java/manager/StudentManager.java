package manager;

import db.DBConnectionProvider;
import model.Gander;
import model.Student;


import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentManager {

    private Connection connection;

    public StudentManager() {
        connection = DBConnectionProvider.getInstance().getConnection();
    }

    public void addStudent(Student student) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("Insert into student(name,surname,age,gander,password,trainer_id) VALUES (?,?,?,?,?,?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getGander().name());
            preparedStatement.setString(5, student.getPassword());
            preparedStatement.setInt(6, student.getTrainerId());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                student.setId(id);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Student> getAllStudents() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM student");
            List<Student> students = getStudentsFromResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Student> getAllStudentsByTrainerId(int Id) {
        List<Student> myStudents = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM student where id = ?");
            statement.setInt(1, Id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setSurname(resultSet.getString(3));
                student.setAge(resultSet.getInt(4));
                student.setGander(Gander.valueOf(resultSet.getString(5)));
                student.setPassword(resultSet.getString(6));
                student.setTrainerId(resultSet.getInt(7));
                myStudents.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return myStudents;
    }

    private List<Student> getStudentsFromResultSet(ResultSet resultSet) throws SQLException {
        List<Student> students = new LinkedList<>();
        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setSurname(resultSet.getString("surname"));
            student.setAge(resultSet.getInt("age"));
            student.setGander(Gander.valueOf(resultSet.getString("status")));
            student.setPassword(resultSet.getString("password"));

            student.setTrainerId(resultSet.getInt("trainer_id"));
            students.add(student);
        }
        return students;

    }

    public Student getStudentByEmailAndPassword(String email, String password) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from student where email = ? and password = ? ");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("Surname"));
                student.setAge(resultSet.getInt("age"));
                student.setPassword(resultSet.getString("password"));
                student.setTrainerId(resultSet.getInt("trainerId"));

                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return null;
    }
    public void deleteStudentById(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE * FROM student WHERE id = 'id'");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}