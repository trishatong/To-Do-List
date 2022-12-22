import java.io.*;
import java.util.ArrayList;

public class UserData implements Serializable {
    public static ArrayList<User> users = new ArrayList<>();

    public static void addUser(User user) {
        users.add(user);
    }
}
