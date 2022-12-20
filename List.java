import java.util.Arraylist;

public class List {
    private Arraylist<Task> taskList;
    private String listName;

    public List(String listName) {
        this.listName = listName;
        taskList = new Arraylist<>;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
}