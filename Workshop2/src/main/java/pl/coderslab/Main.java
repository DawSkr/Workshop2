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
        String[] menu = {"Create ", "Delete ", "Update ", "Find ", "FindEmail ", "Exit "};
        for (String element : menu) {
            System.out.print(element);
        }
        System.out.println();
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
                    showMenu();
                    chooseMenuOption();
                    break;
                case "Update":
                    updateUser();
                    showMenu();
                    chooseMenuOption();
                    break;
                case "Find":
                    findAll();
                    break;
                case "FindEmail":
                    UserDao userDao = new UserDao();
                    User[] users = userDao.findEmail();
                    if (users.length > 0) {
                        System.out.println(Arrays.toString(users));
                    } else {
                        System.out.println("Nie znaleziono użytkowników o podanym emailu");
                    }
                    showMenu();
                    chooseMenuOption();
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

    private static void removeUser() {
        UserDao userDao = new UserDao();
        userDao.delete(0);
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
        Scanner scanner = new Scanner(System.in);
        UserDao userDao = new UserDao();
        System.out.println("Podaj ID które będziemy zmieniać: ");
        User user = userDao.read(scanner.nextInt());
        System.out.println("Na jakie imie zmieniamy:");
        scanner.nextLine();
        String newName = scanner.nextLine();
        user.setUserName(newName);
        userDao.update(user);
//        User userUpdated = userDao.read(1);
//        System.out.println(userUpdated.getId() + " " + userUpdated.getUserName() + userUpdated.getEmail() + userUpdated.getPassword());
    }

    private static void findAll() {
        UserDao userDao = new UserDao();
        User[] users = userDao.findAll();
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i]);
        }
        System.out.println();
        showMenu();
        chooseMenuOption();
    }
}