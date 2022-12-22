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

            User user = new User(username, password);
            String fileName = "userData.ser";
            if (!UserData.users.contains(user)) {
                UserData.addUser(user);
                try {
                    FileOutputStream file = new FileOutputStream(fileName);
                    ObjectOutputStream out = new ObjectOutputStream(file);

                    out.writeObject(user);

                    out.close();
                    file.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            br.close();
            pw.close();


        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Connection was not established.",
                    "Statistics Server", JOptionPane.ERROR_MESSAGE);
        }
    }
}
