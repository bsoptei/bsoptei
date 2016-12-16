package sample;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;

import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.SQLException;
import java.util.List;

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
    private Dao<ToDoItem, String> toDoItemDao;
    private ConnectionSource connectionSource;
    private StringBuilder databaseUrl = new StringBuilder();
    @FXML
    public void submitUser() {
        if (userNameField.getText().length() > 0 && passwordField.getText().length() > 0) {
            user = userNameField.getText();
            connectToDatabase(passwordField.getText());
            myDatePicker.setValue(null);
            currentDate = null;
            thingsToDo.setText("Hello, " + user + "! Let's get started!");
            titleText.setText("To Do! Currently used by " + user + ".");
        } else {
            thingsToDo.setText("Enter user name and password!");
        }
    }

    private void connectToDatabase(String passWord) {
        databaseUrl.append("jdbc:mysql://127.0.0.1:3306/todoapp?user=root&password=")
                .append(passWord);
        SQLHandler("connect");
    }

    private void createUser() throws SQLException {
        Dao<User, String> userDao = DaoManager.createDao(connectionSource, User.class);
        toDoItemDao = DaoManager.createDao(connectionSource, ToDoItem.class);
        TableUtils.createTableIfNotExists(connectionSource, User.class);
        User actualUser = new User(user);
        createAccountIfNotExists(userDao, actualUser);
    }

    @FXML
    private void showList() {
        if (user != null && myDatePicker.getValue() != null) {
            currentDate = myDatePicker.getValue().toString();
            SQLHandler("show");
        } else {
            thingsToDo.setText("Submit user first!");
        }
    }

    private void queryShowList() throws SQLException {
        List<ToDoItem> toDoList = toDoItemDao.queryBuilder()
                .selectColumns("description", "date")
                .where()
                .eq("name", user)
                .and()
                .eq("date", currentDate)
                .query();
        if (toDoList.size() == 0) {
            thingsToDo.setText("No tasks for today.");
        } else {
            StringBuilder taskList = new StringBuilder();
            for (ToDoItem toDo : toDoList) {
                taskList.append(toDo.toString()).append("\n");
            }
            thingsToDo.setText(taskList.toString());
        }
    }

    @FXML
    private void addTask() throws SQLException {
       SQLHandler("add");
    }

    private void queryAddTask() throws SQLException {
        String description = myTextArea.getText();
        if (currentDate != null && myTextArea.getText().length() > 0) {
            ToDoItem myTodo = new ToDoItem(userNameField.getText(), description, currentDate);
            toDoItemDao = DaoManager.createDao(connectionSource, ToDoItem.class);
            TableUtils.createTableIfNotExists(connectionSource, ToDoItem.class);
            if (toDoItemDao.queryForEq("description", description).size() == 0) {
                toDoItemDao.create(myTodo);
            }
            queryShowList();
        } else {
            thingsToDo.setText("Submit user and select date first.");
        }
    }

    @FXML
    private void removeTask() {
        SQLHandler("remove");
    }

    private void queryRemoveTask() throws SQLException {
        String description = myTextArea.getText();
        if (currentDate != null && myTextArea.getText().length() > 0) {
            toDoItemDao = DaoManager.createDao(connectionSource, ToDoItem.class);
            DeleteBuilder<ToDoItem, String> deleteBuilder = toDoItemDao.deleteBuilder();
            deleteBuilder
                    .where()
                    .eq("name", user)
                    .and()
                    .eq("date", currentDate)
                    .and()
                    .eq("description", description);
            PreparedDelete<ToDoItem> preparedDeleteQuery = deleteBuilder.prepare();
            toDoItemDao.delete(preparedDeleteQuery);
            queryShowList();
        } else {
            thingsToDo.setText("Submit user name and select date first.");
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

    private void createAccountIfNotExists(Dao<User, String> accountDao, User user) throws SQLException {
        if (accountDao.queryForId(user.getName()) == null) {
            accountDao.create(user);
        }
    }

    private void SQLHandler(String option) {
        try {
            if (option.equals("connect")) {
                connectionSource = new JdbcConnectionSource(databaseUrl.toString());
                createUser();
            } else if (option.equals("remove")) {
                queryRemoveTask();
            } else if (option.equals("add")) {
                queryAddTask();
            } else if (option.equals("show")) {
                queryShowList();
            }
        } catch (SQLException e) {
            informUserAboutSQLError();
        }
    }

    private void informUserAboutSQLError() {
        thingsToDo.setText("Database error!");
    }
}
