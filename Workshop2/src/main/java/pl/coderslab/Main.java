package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        UserDao userDao = new UserDao();

//        user.setUserName("Krzysztof");
//        user.setEmail("onet@onet.pl");
//        user.setPassword("haslo123");

//        userDao.create(user);
        User user1 = userDao.read(1);

      //  System.out.println(user1.getId() + " " + user1.getUserName() + user1.getEmail() + user1.getPassword());


    }
}