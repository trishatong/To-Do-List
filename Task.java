import java.io.Serializable;

/**
 * @author Trisha Tong
 * @version December 20, 2022
 * <p>
 * Description
 * <p>
 */
public class Task implements Serializable {
    private String name;
    private String date;
    private String description;

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

}