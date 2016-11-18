package sample;

public class User {
    private String userName;
    private ToDoList userToDoList;
    private String sourceFile;

    public User(String userName) {
        this.userName = userName;
        setSourceFile();
        this.userToDoList = new ToDoList(sourceFile);
    }

    private void setSourceFile() {
        this.sourceFile = "src/sample/data/" + userName + ".txt";
    }

    ToDoList getUserToDoList() {
        return userToDoList;
    }

    void addDate (){
        this.userToDoList.addItem(new ToDoItem(""));
    }

    public String getSourceFile() {
        return sourceFile;
    }
}
