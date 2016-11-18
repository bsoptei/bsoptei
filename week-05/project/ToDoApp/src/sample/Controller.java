package sample;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private DatePicker myDatePicker;
    @FXML
    private TextField userName;
    @FXML
    private Text thingsToDo;
    @FXML
    private TextArea myTextArea;
    @FXML
    private Text titleText;

    private String user = null;
    private ToDoList myToDo = null;
    private String currentDate = null;

    public void submitUser() {
        if (userName.getText().length() > 0) {
            user = userName.getText();
            User currentUser = new User(user);
            myToDo = currentUser.getUserToDoList();
            myDatePicker.setValue(null);
            currentDate = null;
            thingsToDo.setText("Hello, " + user + "! Let's get started!");
            titleText.setText("To Do! Currently used by " + user + ".");
        } else {
            thingsToDo.setText("Enter user name!");
        }
    }

    @FXML
    private void showList() {
        if (user != null && myDatePicker.getValue() != null) {
            currentDate = myDatePicker.getValue().toString();
            getContents();
        } else {
            thingsToDo.setText("Submit your user name first!");
        }
    }

    private void getContents() {
        if (searchForDate() == -1) {
            thingsToDo.setText("No tasks for this date.");
        } else {
            StringBuilder displayData = new StringBuilder();
            int index = 0;
            for (String dataElement : myToDo.getItemByDate(currentDate).getData()) {
                if (index > 0) {
                    displayData.append(Integer.toString(index)).append(". ");
                }
                displayData.append(dataElement).append("\n");
                index++;
            }
            thingsToDo.setText(displayData.toString());
        }
    }


    private int searchForDate() {
        return myToDo.findDate(currentDate);
    }

    @FXML
    private void addTask() {
        if (myToDo != null && currentDate != null) {
            if (myTextArea.getText().length() > 0) {
                if (searchForDate() == -1) {
                    myToDo.addItem(new ToDoItem(currentDate));
                }
                myToDo.getItemByDate(currentDate).addTask(myTextArea.getText());
            }
            saveData();
            getContents();
        } else {
            thingsToDo.setText("Submit user name and select date first.");
        }
    }

    @FXML
    private void removeTask() {
        if (myToDo != null && currentDate != null) {
            if (searchForDate() != -1) {
                myToDo.getItemByDate(currentDate).removeTask(myTextArea.getText());
                if (myToDo.getItemByDate(currentDate).tasksToString().length() < 1) {
                    myToDo.removeItem(myToDo.getItemByDate(currentDate));
                }
                saveData();
                getContents();
            }
        } else {
            thingsToDo.setText("Submit user name and select date first.");
        }
    }

    private void saveData() {
        myToDo.generateOutputContent();
        myToDo.save();
    }

    @FXML
    private void showHelp() {
        thingsToDo.setText("Hi, welcome to the To Do! \n" +
                "How to use: \n 1. Submit your user name \n 2. Select date \n" +
                "3. Use the box below to enter tasks, finish by hitting \"Add\" \n" +
                "4. You can remove tasks by entering their description " +
                "\n(without the numbering) and pressing \"Remove\" " +
                "\n \n Version 1.0.1 beta (Needs bugFix!) \n" +
                "Created by Balázs Söptei 2016.11.17.");
    }
}
