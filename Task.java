public class Task {
    // name, date and time, description
    String name;
    int date;
    int time; 
    String description;

    // name getter
    public String getName() {
        return name;
    }

    // name setter
    public void setName(String newName) {
        this.name = newName;
    }

    // date getter
    public int getDate() {
        return date;
    }

    // date setter
    public void setDate(int newDate) {
        this.date = newDate;
    }

    // time getter
    public int getTime() {
        return time;
    }

    // time setter
    public void setTime(int newTime) {
        this.time = newTime;
    }

    // description getter
    public String getDescription() {
        return description;
    }

    // description setter
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }
}