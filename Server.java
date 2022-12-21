import java.io.*;
import java.net.*;

public class Server {
    private static final int PORT_NUM = 2025;
    private static UserData userData;
    public Server() {
    }

    public static void main(String[] var0) {
        Socket var1 = null;
        ServerSocket var2 = null;

        try {
            var2 = new ServerSocket(PORT_NUM);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Server error");
        }
    }

    static {
        FileIO.setFileName("discussionBoard.ser");
        userData = FileIO.readUserData();
        if (userData == null) {
            userData = new UserData();
        }

    }
}
