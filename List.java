import java.io.Serializable;
import java.util.ArrayList;
/**
 * @author Ryan Sevidal
 * @version December 20, 2022
 * <p>
 * Description
 * <p>
 */
public class List implements Serializable {
    private String authorName;
    private ArrayList<Task> taskList;
    private String listName;

    public List(String listName) {
        this.listName = listName;
        taskList = new ArrayList<>();
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}