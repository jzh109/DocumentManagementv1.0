package cs.whut.common;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        welcomeMenu();
    }

    private static void welcomeMenu() {
        String tip_system = "Document System";
        String tip_menu = "Please select menu:";
        String tip_exit = "System has exited, thanks for utilizing!";
        String infos = "****Welcome to " + tip_system + "****\n\t" +
                "1.Login\n\t2.Exit\n" +
                "**************************";
        System.out.println(infos);
        System.out.print(tip_menu);
        String order = scanner.nextLine();
        if (order.equals("2")) {
            System.out.println(tip_exit);
            System.exit(0);
        } else if (order.equals("1")) {
            login();
        } else {
            System.out.println("User does NOT have such option!");
        }
    }

    public static void run(User user) {
        user.showMenu();
    }

    private static void login() {
        System.out.print("Please input username:");
        String name = scanner.nextLine().trim();
        System.out.print("Please input password:");
        String password = scanner.nextLine();
        if (!DataProcessing.users.containsKey(name)) {
            System.out.println("User doesn't exist.");
            welcomeMenu();
        } else {
            if (DataProcessing.search(name, password) != null) {
                run(Objects.requireNonNull(DataProcessing.search(name, password)));
            } else {
                System.out.println("Username or password is incorrect.");
                welcomeMenu();
            }
        }
    }
}