import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.*;

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
    
        // public void createTaskOption() {

        // DELETE
        public static void main(String[] args) {
            Object[] options = {"Create a Task", "Quit"};
            JPanel panel = new JPanel();
            panel.add(new JLabel("What would you like to do?"));
            JTextField textField = new JTextField(10);
            panel.add(textField);

            int result = JOptionPane.showOptionDialog(null, "What would you like to do?", "Adding Tasks",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
            null, options, options[0]);
            if (result == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, textField.getText());
            }
        }
    //  }
}