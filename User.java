import java.io.*;
import java.util.ArrayList;

/**
 * @author Ryan Sevidal
 * @version December 20, 2022
 * <p>
 * Description
 * <p>
 */

public class User implements Serializable {
    private String username;
    private String password;
    private ArrayList<List> lists;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        lists = new ArrayList<>();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}