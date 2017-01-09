package sample;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.SQLException;

public class Controller {
    @FXML
    private DatePicker myDatePicker;
    @FXML
    private TextField userNameField;
    @FXML
    private Text thingsToDo;
    @FXML
    private TextArea myTextArea;
    @FXML
    private Text titleText;
    @FXML
    private PasswordField passwordField;
    private String user = null;
    private String currentDate = null;
    private DatabaseManager databaseManager = new DatabaseManager();
    
    @FXML
    public void submitUser() {
        if (userNameField.getText().length() > 0 && passwordField.getText().length() > 0) {
            user = userNameField.getText();
            databaseManager.connectToDatabase(passwordField.getText());
            User actualUser = new User(user);
            databaseManager.createUser(actualUser);
            myDatePicker.setValue(null);
            currentDate = null;
            thingsToDo.setText("Hello, " + user + "! Let's get started!");
            titleText.setText("To Do! Currently used by " + user + ".");
        } else {
            thingsToDo.setText("Enter user name and password!");
        }
    }

    @FXML
    private void showList() {
        if (user != null && myDatePicker.getValue() != null) {
            currentDate = myDatePicker.getValue().toString();
            thingsToDo.setText(databaseManager.queryShowList(user, currentDate));
        }
    }

    @FXML
    private void addTask() throws SQLException {
        String description = myTextArea.getText();
        if (currentDate != null && myTextArea.getText().length() > 0) {
            ToDoItem myTodo = new ToDoItem(userNameField.getText(), description, currentDate);
            databaseManager.queryAddTask(myTodo, description);
            showList();
        }
    }

    @FXML
    private void removeTask() {
        String description = myTextArea.getText();
        if (currentDate != null && myTextArea.getText().length() > 0) {
            databaseManager.queryRemoveTask(user, currentDate, description);
            showList();
        }
    }

    @FXML
    private void showHelp() {
        thingsToDo.setText("Hi, welcome to the ToDo! \n" +
                "How to use: \n 1. Submit your user name and password \n 2. Select date \n" +
                "3. Use the box below to enter tasks, finish by hitting \"Add\" \n" +
                "4. You can remove tasks by entering their description " +
                "\n(without the date) and pressing \"Remove\" " +
                "\n \n Version 1.1.1 SNAPSHOT \n" +
                "Created by Balázs Söptei 2016.12.16.");
    }

}
