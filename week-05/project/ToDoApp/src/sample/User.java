package sample;

class User {
    private String userName;
    private ToDoList userToDoList;
    private String sourceFile;

    User(String userName) {
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
}
