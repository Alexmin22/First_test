package dao;

import model.User;
import util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class UserDAOImpl implements UserDAO {


    @Override
    public void saveUser(User user) {
       try (PreparedStatement preparedStatement = Util.getConnection()
               .prepareStatement("INSERT INTO users (name, age) VALUES (?,?)")) {
           preparedStatement.setString(1, user.getName());
           preparedStatement.setInt(2, user.getAge());
           preparedStatement.execute();
           System.out.println("Пользователь создан");
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }

    public void removeUserID(User user) {
        try(PreparedStatement prst = Util.getConnection()
                .prepareStatement("DELETE FROM users WHERE id =?")){
            prst.setInt(1, user.getId());
            prst.execute();
            System.out.println("Пользователь удален");
        } catch (SQLException e) {
            throw new RuntimeException("Похоже такого пользователя нет в БД");
        }
    }

    @Override
    public void createTable() {
        try (Statement statement = Util.getConnection().createStatement()) {
            statement.execute(
                    " CREATE TABLE IF NOT EXISTS Users (" +
                    "id INT NOT NULL AUTO_INCREMENT," +
                    "name VARCHAR(55) NOT NULL," +
                    "age int NOT NULL," +
                    "PRIMARY KEY (id)" +
                    ")");
            System.out.println("Таблица создана");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dropTable() {
        try(Statement statement = Util.getConnection().createStatement()) {
            statement.execute("DROP TABLE IF EXISTS Users");
            System.out.println("Таблица удалена");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cleanUserTable() {
       try(Statement statement = Util.getConnection().createStatement()) {
           statement.execute("DELETE FROM users");
           System.out.println("Таблица очищена");
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }

    @Override
    public void getAllUsers() {
        try(Statement statement = Util.getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                User user = new User(999, rs.getString("name"), rs.getInt("age"));
                user.setId(rs.getInt("id"));
                System.out.println(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
