/**
 * @author Ryan Sevidal
 * @version December 20, 2022
 * <p>
 * Description
 * <p>
 */

public class User {
    private String username;
    private String password;
    String listName;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        String listName;
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

    public void createList() {
        List list = new List(listName);
    }
}