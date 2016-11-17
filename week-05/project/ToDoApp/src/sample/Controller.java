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

    private String user = null;
    private ToDoList myToDo = null;
    private int myIndex = -1;
    private String currentDate = null;

    public void submitUser() {
        if (userName.getText().length() > 0) {
            user = userName.getText();
            myToDo = new ToDoList(user);
            myDatePicker.setValue(null);
            currentDate = null;
            thingsToDo.setText("Hello, " + user + "! Let's get started!");
        } else {
            thingsToDo.setText("Enter user name!");
        }
    }

    @FXML
    private void showList() {
        if (user != null && myDatePicker.getValue() != null) {
            currentDate = myDatePicker.getValue().toString();
            showContents();
        } else {
            thingsToDo.setText("Submit your user name first!");
        }
    }

    private void showContents() {
        searchForDate();
        if (myIndex == -1) {
            thingsToDo.setText("No tasks for this date.");
        } else {
            StringBuilder currentList = new StringBuilder();
            for (String s : myToDo.getProcessedContents().get(myIndex)) {
                if (findIndex(s, myToDo.getProcessedContents().get(myIndex)) > 0) {
                    currentList.append(" ").append(findIndex(s, myToDo.getProcessedContents().get(myIndex))).append(". ");
                }
                currentList.append(s);
                currentList.append("\n");
            }
            thingsToDo.setText(currentList.toString());
        }
    }

    private void searchForDate() {
        myIndex = myToDo.findDate(currentDate);
    }

    private int findIndex(String s, String[] list) {
        int indexFound = 0;
        for (int index = 0; index < list.length; index++) {
            if (s.trim().equals(list[index].trim())) {
                indexFound = index;
            }
        }
        return indexFound;
    }

    @FXML
    private void addTask() {
        if (myToDo != null && currentDate != null) {
            searchForDate();
            if (myTextArea.getText().length() > 0) {
                if (myIndex == -1) {
                    myToDo.addDateToCalendar(currentDate.trim());
                }
                searchForDate();
                if (!search(myTextArea.getText().trim(), myToDo.getProcessedContents().get(myIndex))) {
                    myToDo.addTaskToDate(currentDate, myTextArea.getText().trim());
                }
            }
            saveData();
            showContents();
        } else {
            thingsToDo.setText("Submit user name and select date first.");
        }
    }

    @FXML
    private void removeTask() {
        if (myToDo != null && currentDate != null) {
            searchForDate();
            if (myIndex != -1) {
                if (search(myTextArea.getText().trim(), myToDo.getProcessedContents().get(myIndex))) {
                    myToDo.removeTaskFromDate(currentDate, myTextArea.getText());
                }
                if (myToDo.getProcessedContents().get(myIndex).length == 1) {
                    myToDo.removeDateFromCalendar(currentDate);
                }
                saveData();
                showContents();
            }
        } else {
            thingsToDo.setText("Submit user name and select date first.");
        }
    }

    private void saveData() {
        myToDo.generateOutputContent();
        myToDo.writeFile();
    }

    private boolean search(String searchFor, String[] searchIn) {
        boolean contains = false;
        for (String s : searchIn) {
            if (s.trim().equals(searchFor)) {
                contains = true;
            }
        }
        return contains;
    }

}
