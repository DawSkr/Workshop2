package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        showMenu();
        chooseMenuOption();
    }

    private static void showMenu() {
        System.out.println("Proszę wybierz opcję:");
        String[] menu = {"Create", "Delete", "Update", "Find", "Exit"};
        for (String element : menu) {
            System.out.println(element);
        }
    }

    private static void chooseMenuOption() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String option = scanner.nextLine();
            switch (option) {
                case "Create":
                    createUser();
                    break;
                case "Delete":
                    removeUser();
                    break;
                case "Update":
                    updateUser();
                    break;
                case "Find":
                    findAll();
                    break;
                case "Exit":
                    System.out.println("Wybrano opcje wyjdź");
                    exit();
                    break;
                default:
                    System.out.println("Wpisz poprawną opcje");
            }
        }
    }

    private static void exit() {
        System.out.print("Bye bye");
        System.exit(0);
    }

    private static void removeUser(){
        Scanner scanner = new Scanner(System.in);
        UserDao userDao = new UserDao();
        userDao.read(1);
        userDao.delete(1);
        showMenu();
        chooseMenuOption();
    }

    private static void createUser() {
        Scanner scanner = new Scanner(System.in);
        UserDao userDao = new UserDao();
        User user = new User();
        System.out.println("Podaj imię użytkownika");
        user.setUserName(scanner.nextLine());
        System.out.println("Podaj email użytkownika");
        user.setEmail(scanner.nextLine());
        System.out.println("Podaj hasło użytkownika");
        user.setPassword(scanner.nextLine());
        userDao.create(user);
        showMenu();
        chooseMenuOption();
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
            System.out.println();
            System.out.print(users[i]);
        }
    }
}