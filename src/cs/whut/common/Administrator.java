package cs.whut.common;

import java.util.Enumeration;
import java.util.Scanner;

public class Administrator extends User {

    static final String infos = "****Welcome to menu of Administrator****\n\t" +
            "1.Edit user\n\t" + "2.Delete user\n\t" + "3.Create user\n\t" +
            "4.List all users\n\t" +
            "5.Download document\n\t" + "6.Files list\n\t" + "7.Change password\n\t" + "8.Exit\n" +
            "**********************************";
    static final String tip_menu = "Please select menu:";
    private Scanner scanner = new Scanner(System.in);

    public Administrator(String name, String password, String role) {
        super(name, password, role);
    }

    @Override
    public void showMenu() {
        System.out.println(infos);
        System.out.print(tip_menu);
        this.run();
    }

    public void run() {
        String order;
        while ((order = scanner.nextLine()) != null) {
            switch (order) {
                case "1":                                                                                           //administrator option 1
                    changeUserInfo();
                    break;
                case "2":                                                                                           //administrator option 2
                    delUser();
                    break;
                case "3":                                                                                           //administrator option 3
                    addUser();
                    break;
                case "4":                                                                                           //administrator option 4
                    listUser();
                    break;
                case "5":                                                                                           //administrator option 5
                    downloadFile();
                    break;
                case "6":                                                                                           //administrator option 6
                    showFileList();
                    break;
                case "7":                                                                                           //administrator option 7
                    changeSelfInfo();
                    break;
                case "8":                                                                                           //administrator option 8
                    exitSystem();
                    break;
                default:
                    System.out.println("No such option!");
                    break;
            }
            showMenu();
        }
    }

    private void downloadFile() {
        System.out.print("Please input the number of document:");
        String fileName = scanner.nextLine();
        if (super.downloadFile(fileName)) {
            System.out.println("Download succeed!");
        } else {
            System.out.println("Something wrong happened when downloading document." +
                    fileName + ".");
        }
    }

    private void changeUserInfo() {
        System.out.println("Edit user");
        System.out.print("Input username:");
        String username = scanner.nextLine();
        System.out.print("Input password:");
        String password = scanner.nextLine();
        System.out.print("Input role:");
        String role = scanner.nextLine();
        if (DataProcessing.update(username, password, role)) {
            System.out.println("Succeed!");
        } else {
            System.err.println("Something wrong happened when changing " + username + ".");
        }
    }

    public void delUser() {
        System.out.println("Delete user");
        System.out.print("Input username:");
        String username = scanner.nextLine();
        if (DataProcessing.delete(username)) {
            System.out.println("Succeed!");
        } else {
            System.err.println("Something wrong happened when deleting " + username + ".");
        }
    }

    private void changeSelfInfo() {
        System.out.println("Change your own password.");
        System.out.print("Please input new password:");
        String newPassword = scanner.nextLine();
        if (super.changeSelfInfo(newPassword)) {
            System.out.println("Password change succeed!");
        } else {
            System.err.println("Something wrong happened when changing password.");
        }
    }

    private void addUser() {
        System.out.println("Create user");
        System.out.print("Input username:");
        String username = scanner.nextLine();
        System.out.print("Input password:");
        String password = scanner.nextLine();
        System.out.print("Input role");
        String role = scanner.nextLine();
        if (DataProcessing.insert(username, password, role)) {
            System.out.println("Succeed!");
        } else {
            System.err.println("Something wrong happened when creating " + username + ".");
        }
    }

    private void listUser() {
        System.out.println("List all users.");
        Enumeration<User> users = DataProcessing.getAllUser();
        while (users.hasMoreElements()) {
            User temp = users.nextElement();
            System.out.println("Name: " + temp.getName() + "\t\tPassword: " + temp.getPassword() +
                    "\t\tRole: " + temp.getRole());
        }
    }
}