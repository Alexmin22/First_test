package dao;

import model.BD;
import model.User;

import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {


    @Override
    public void saveUser(User user) {
        try {
            BD.list.add(user);
        } catch (NullPointerException ex) {
            createTable();
            saveUser(user);
        }
    }

    public void removeUserID(User user) {
        try {
        BD.list.remove(user);
            System.out.println("Удалили "+ user);
        } catch (NullPointerException ex) {
            System.out.println("User not found!");
        }
    }

    @Override
    public void createTable() {
        BD.list = new ArrayList<>();
    }

    @Override
    public void dropTable() {
        BD.list = null;
        System.out.println("Таблица удалена");
    }

    @Override
    public void cleanUserTable() {
        try {
        BD.list.clear();
        } catch (NullPointerException ex) {
        System.out.println("Таблица пуста");
        }
    }

    @Override
    public void getAllUsers() {
        System.out.println(BD.list);
    }
}
