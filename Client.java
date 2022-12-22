import java.io.*;
import java.net.*;
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
            Socket socket = new Socket("localHost", Integer.parseInt("2025"));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
                } 
            catch (NullPointerException e) {
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
                } 
                catch (NullPointerException e) {
                    return;
                }
            br.close();
            pw.close();
        } 
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Connection was not established.",
                "To-Do List Client", JOptionPane.ERROR_MESSAGE);
            return;
        }    
    }
}
