import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {
    public Server() {
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2025);
            Socket socket = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream());

            String username = br.readLine();
            String password = br.readLine();

            FileWriter fw = new FileWriter("userData.txt");
            PrintWriter pw2 = new PrintWriter(fw);
            pw2.printf("%s\\%s", username, password);

            br.close();
            pw.close();
            pw2.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Connection was not established.",
                    "Statistics Server", JOptionPane.ERROR_MESSAGE);
        }
    }
}
