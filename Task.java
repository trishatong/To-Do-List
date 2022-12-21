/**
 * @author Trisha Tong
 * @version December 20, 2022
 * <p>
 * Description
 * <p>
 */
public class Task {
    String authorName;
    String name;
    String date;
    String description;

    // getters and setters
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

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