package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // usuwanie użytkownika po usename
        // wyszukiwanie użytkowników w domenie gmail.com

    }

    private static void removeUser(){
        UserDao userDao = new UserDao();
        userDao.delete(1);
    }

    private static void createUser() {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUserName("Krzysztof");
        user.setEmail("onet@onet.pl");
        user.setPassword("haslo123");
        userDao.create(user);
    }
    private static void updateUser() {
        UserDao userDao = new UserDao();
        User user = userDao.read(1);
        user.setUserName("Michał");
        userDao.update(user);
        User userUpdated = userDao.read(1);
        System.out.println(userUpdated.getId() + " " + userUpdated.getUserName() + userUpdated.getEmail() + userUpdated.getPassword());
    }

    private static void findAll(){
        UserDao userDao = new UserDao();
        User[] users = userDao.findAll();
        for (int i = 0; i < users.length; i++){
            System.out.print(users[i]);
        }
    }
}