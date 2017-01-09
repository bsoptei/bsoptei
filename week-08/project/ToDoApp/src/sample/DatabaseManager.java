package sample;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

class DatabaseManager {
    private Dao<ToDoItem, Integer> toDoItemDao;
    private ConnectionSource connectionSource;
    private StringBuilder databaseUrl = new StringBuilder();

    void connectToDatabase(String passWord) {
        databaseUrl.append("jdbc:mysql://127.0.0.1:3306/todoapp?user=root&password=")
                .append(passWord);
        try {
            connectionSource = new JdbcConnectionSource(databaseUrl.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void createUser(User actualUser) {
        try {
            Dao<User, String> userDao = DaoManager.createDao(connectionSource, User.class);
            toDoItemDao = DaoManager.createDao(connectionSource, ToDoItem.class);
            TableUtils.createTableIfNotExists(connectionSource, User.class);
            TableUtils.createTableIfNotExists(connectionSource, ToDoItem.class);
            createAccountIfNotExists(userDao, actualUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createAccountIfNotExists(Dao<User, String> accountDao, User user) throws SQLException {
        if (accountDao.queryForId(user.getName()) == null) {
            accountDao.create(user);
        }
    }

    String queryShowList(String user, String currentDate) {
        List<ToDoItem> toDoList = null;
        try {
            toDoList = toDoItemDao.queryBuilder()
                    .selectColumns("description", "date")
                    .where()
                    .eq("name", user)
                    .and()
                    .eq("date", currentDate)
                    .query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (toDoList.size() == 0) {
            return "No tasks for today.";
        } else {
            StringBuilder taskList = new StringBuilder();
            for (ToDoItem toDo : toDoList) {
                taskList.append(toDo.toString()).append("\n");
            }
            return taskList.toString();
        }
    }

    void queryAddTask(ToDoItem myTodo, String description) {
        try {
            if (toDoItemDao.queryForEq("description", description).size() == 0) {
                toDoItemDao.create(myTodo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void queryRemoveTask(String user, String currentDate, String description) {
        try {
            DeleteBuilder<ToDoItem, Integer> deleteBuilder = toDoItemDao.deleteBuilder();
            deleteBuilder
                    .where()
                    .eq("name", user)
                    .and()
                    .eq("date", currentDate)
                    .and()
                    .eq("description", description);
            PreparedDelete<ToDoItem> preparedDeleteQuery = deleteBuilder.prepare();
            toDoItemDao.delete(preparedDeleteQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
