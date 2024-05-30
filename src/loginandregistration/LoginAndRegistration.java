/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginandregistration;

/**
 *
 * @author donav
 * 
 */
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class LoginAndRegistration {

    private static Map<String, String> registeredUsers = new HashMap<>();
    private static boolean loggedIn = false;
    private static String currentUser;

    public static void main(String[] args) {
        while (true) {
            String option = JOptionPane.showInputDialog("Choose an option:\n1. Register\n2. Login\n3. Exit");

            if (option == null) {
                break;
            }

            switch (option) {
                case "1":
                    String newUsername = JOptionPane.showInputDialog("Please Enter a new username:");
                    String newPassword = JOptionPane.showInputDialog("Please Enter a new password:");
                    if (isValidUsername(newUsername) && validatePassword(newPassword)) {
                        registeredUsers.put(newUsername, newPassword);
                        JOptionPane.showMessageDialog(null, "Registration successful!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password format was entered by the user. Please make sure:\n- The Username entered by the user is not longer than 5 characters and contains an underscore.\n- Password must have at least 8 characters, a capital letter, a number, and a special character to be successful.");
                    }
                    break;

                case "2":
                    String inputUsername = JOptionPane.showInputDialog("Enter the username:");
                    String inputPassword = JOptionPane.showInputDialog("Enter the password:");

                    if (registeredUsers.containsKey(inputUsername) && registeredUsers.get(inputUsername).equals(inputPassword)) {
                        loggedIn = true;
                        currentUser = inputUsername;
                        JOptionPane.showMessageDialog(null, "Your Login was successful!");
                        new KanbanApp(currentUser).setVisible(true);  
                        return;  
                    } else {
                        JOptionPane.showMessageDialog(null, "Username or Password is Incorrect!");
                    }
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Exiting the application...");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Wrong option!");
                    break;
            }
        }
    }

    private static boolean isValidUsername(String username) {
        return username.length() <= 5 && username.contains("_");
    }

    private static boolean validatePassword(String password) {
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*") && password.matches(".*[!@#$%^&*()].*");
    }
}
