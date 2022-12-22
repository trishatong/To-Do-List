import java.io.*;
import java.net.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author Trisha Tong
 * @version December 21, 2022
 * <p>
 * Description
 * <p>
 */
public class Client {

    public static void main(String[] args) {
        String username;
        String password;

        try {
            Socket socket = new Socket("localHost", 2025);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            FileInputStream file = new FileInputStream("userData.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            do {
                username = JOptionPane.showInputDialog(null, "What is your username?",
                        "To-Do List Client", JOptionPane.QUESTION_MESSAGE);
                if (username == null)
                    return;

                else if (username.isBlank()) {
                    JOptionPane.showMessageDialog(null,
                            "String cannot be empty! Please re-enter", "To-Do List Client",
                            JOptionPane.ERROR_MESSAGE);
                }
            } while (username.isBlank());

            try {
                pw.write(username);
                pw.println();
                pw.flush();
            } catch (NullPointerException e) {
                return;
            }

            do {
                password = JOptionPane.showInputDialog(null, "What is your password?",
                        "To-Do List Client", JOptionPane.QUESTION_MESSAGE);
                if (password == null)
                    return;

                else if (password.isBlank()) {
                    JOptionPane.showMessageDialog(null,
                            "String cannot be empty! Please re-enter", "To-Do List Client",
                            JOptionPane.ERROR_MESSAGE);
                }
            } while (password.isBlank());

            try {
                pw.write(password);
                pw.println();
                pw.flush();
            } catch (NullPointerException e) {
                return;
            }


            User user = (User) in.readObject();
            System.out.printf("Username: %s \\Password %s", user.getUsername(), user.getPassword());
            in.close();
            file.close();
            pw.close();
            br.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Connection was not established.",
                    "To-Do List Client", JOptionPane.ERROR_MESSAGE);
        }

    
        /*
        // message if user selects Create Task
        String[] options = {"Create Task", "Quit"};
        int res = JOptionPane.showOptionDialog(new JFrame(), "What would you like to do?", "Adding tasks",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
        new Object[] { "Yes", "No" }, JOptionPane.YES_OPTION);
        if (res == JOptionPane.YES_OPTION) {
        System.out.println("Selected Yes!");
}
        int popup = JOptionPane.showOptionDialog(null, "Question ?", "Confirmation",
        JOptionPane.WARNING_MESSAGE, 0, null, options, options[2]);
        System.out.println(popup);
        */


    }
}
