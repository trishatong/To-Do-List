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
        String hostName;
        String portNumber = "";
        String text;
        int loop = 0;

        JOptionPane.showMessageDialog(null, "Welcome!",
                "To-Do List Client", JOptionPane.INFORMATION_MESSAGE);

        hostName = JOptionPane.showInputDialog(null, "What is the host name?",
                    "To-Do List Client", JOptionPane.QUESTION_MESSAGE);
        if (hostName != null) {
            portNumber = JOptionPane.showInputDialog(null, "What is the port number?",
                    "To-Do List Client", JOptionPane.QUESTION_MESSAGE);
        }
        if (hostName == null || portNumber == null) {
            JOptionPane.showMessageDialog(null, "Connection was not established.",
                    "To-Do List Client", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (hostName.isBlank() || portNumber.isBlank()) {
            JOptionPane.showMessageDialog(null, "Connection was not established.",
                    "To-Do List Client", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // buttons to create task or quit
        String[] options = {"Create Task", "Quit"};
        int popup = JOptionPane.showOptionDialog(null, "Question ?", "Confirmation",
        JOptionPane.WARNING_MESSAGE, 0, null, options, options[2]);
        System.out.println(popup);
        
// username passowrd x2

        try {
            Socket socket = new Socket(hostName, Integer.parseInt(portNumber));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            do {
                    text = JOptionPane.showInputDialog(null, "What is your username?",
                            "To-Do List Client", JOptionPane.QUESTION_MESSAGE);
                    if (text == null)
                        return;

                    else if (text.isBlank()) {
                        JOptionPane.showMessageDialog(null,
                                "String cannot be empty! Please re-enter", "To-Do List Client",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } while (text.isBlank());

            do {
                    text = JOptionPane.showInputDialog(null, "What is your password?",
                            "To-Do List Client", JOptionPane.QUESTION_MESSAGE);
                    if (text == null)
                        return;

                    else if (text.isBlank()) {
                        JOptionPane.showMessageDialog(null,
                                "String cannot be empty! Please re-enter", "To-Do List Client",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } while (text.isBlank());

                try {
                    pw.write(text);
                    pw.println();
                    pw.flush();
                } 
                catch (NullPointerException e) {
                    return;
                }

                String textLength = br.readLine();
                String spaces = br.readLine();
                String numPunctuation = br.readLine();
                String charCount = br.readLine();
                ArrayList<String> numDigitsArr = new ArrayList<>();
                ArrayList<String> numLetterArr = new ArrayList<>();
                String numDigits = "";
                String numLetter = "";
                String line = br.readLine();

                while (!line.equals("end of digits")) {
                    numDigitsArr.add(line);
                    line = br.readLine();
                }

                for (int i = 0; i < numDigitsArr.size(); i++) {
                    numDigits += numDigitsArr.get(i);

                }

                String line2 = br.readLine();
                while (!line2.equals("end of letters")) {
                    numLetterArr.add(line2);
                    line2 = br.readLine();
                }

                for (int i = 0; i < numLetterArr.size(); i++) {
                    numLetter += numLetterArr.get(i);

                }
                if (numDigits.length() != 0) {
                    numDigits = numDigits.substring(0, numDigits.length() - 2);

                } else {
                    numDigits = "No digits";

                }

                if (numLetter.length() != 0) {
                    numLetter = numLetter.substring(0, numLetter.length() - 2);

                } else {
                    numLetter = "No letters";

                }

                String endOfLetters = br.readLine();

                JOptionPane.showMessageDialog(null, "Length of string: " + textLength,
                        "To-Do List Client", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Number of spaces: " + spaces,
                        "To-Do List Client", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Number of punctuation: " + numPunctuation,
                        "To-Do List Client", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Character count (no spaces): " + charCount,
                        "To-Do List Client", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Frequency of digits: " + numDigits,
                        "To-Do List Client", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Frequency of letters: " + numLetter,
                        "To-Do List Client", JOptionPane.INFORMATION_MESSAGE);
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
