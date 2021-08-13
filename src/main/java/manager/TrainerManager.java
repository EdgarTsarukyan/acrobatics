package manager;

import db.DBConnectionProvider;
import model.Gander;
import model.SportType;
import model.Trainer;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class TrainerManager {

    private Connection connection;

    public TrainerManager() {
        connection = DBConnectionProvider.getInstance().getConnection();
    }

    public void add(Trainer trainer) {
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = connection.prepareStatement("Insert into trainer(name,surname,email,password,age,gander,sport_type) VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setString(1, trainer.getName());
            preparedStatement.setString(2, trainer.getSurname());
            preparedStatement.setString(3, trainer.getEmail());
            preparedStatement.setString(4, trainer.getPassword());
            preparedStatement.setInt(5, trainer.getAge());
            preparedStatement.setString(6, trainer.getGander().name());
            preparedStatement.setString(7, trainer.getSportType().name());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                trainer.setId(id);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Trainer> getAllTrainers() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM trainer");
            List<Trainer> trainers = new LinkedList<>();
            while (resultSet.next()) {
                Trainer trainer = new Trainer();
                trainer.setId(resultSet.getInt(1));
                trainer.setName(resultSet.getString(2));
                trainer.setSurname(resultSet.getString(3));
                trainer.setEmail(resultSet.getString(4));
                trainer.setPassword(resultSet.getString(5));
                trainer.setAge(resultSet.getInt(6));
                trainer.setGander(Gander.valueOf(resultSet.getString(7)));
                trainer.setSportType(SportType.valueOf(resultSet.getString(8)));
                trainers.add(trainer);
            }
            return trainers;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Trainer getTrainerByEmailAndPassword(String email, String password) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from trainer where email = ? and password = ? ");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Trainer trainer = new Trainer();
                trainer.setId(resultSet.getInt("id"));
                trainer.setName(resultSet.getString("name"));
                trainer.setSurname(resultSet.getString("surname"));
                trainer.setEmail(resultSet.getString("email"));
                trainer.setPassword(resultSet.getString("password"));
                trainer.setAge(resultSet.getInt("age"));
                trainer.setGander(Gander.valueOf(resultSet.getString("gander")));
                trainer.setSportType(SportType.valueOf(resultSet.getString("sport_type")));
                return trainer;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return null;
    }

    public Trainer getTrainerById(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from trainer where id = ? ");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Trainer trainer = new Trainer();
                trainer.setId(resultSet.getInt("id"));
                trainer.setName(resultSet.getString("name"));
                trainer.setSurname(resultSet.getString("Surname"));
                trainer.setEmail(resultSet.getString("email"));
                trainer.setPassword(resultSet.getString("password"));
                trainer.setAge(resultSet.getInt("age"));
                trainer.setGander(Gander.valueOf(resultSet.getString("gander")));
                trainer.setSportType(SportType.valueOf(resultSet.getString("sportType")));
                return trainer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void deleteTrainerById(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE * FROM trainer WHERE id = 'id'");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}


