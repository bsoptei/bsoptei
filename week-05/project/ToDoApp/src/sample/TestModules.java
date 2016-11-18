package sample;

/**
 * Created by Söp on 2016.11.18..
 */
public class TestModules {
    public static void main(String[] args) {
        // yeah!

//        ToDoItem x = new ToDoItem("2016-11-17, write To DoApp, debug, prepare for presentation");
//        System.out.println(x.tasksToString());
//        System.out.println(x.toString());
//        System.out.println(x.dateToString());
//
//        ToDoItem y = new ToDoItem("2016-11-18");
//        System.out.println(y.toString());
//        System.out.println(y.tasksToString());
//        System.out.println(y.dateToString());
//
//        y.addTask("u");
//        System.out.println(y.toString());
//        System.out.println(y.tasksToString());
//        System.out.println(y.dateToString());

//        y.removeTask("");
//        System.out.println(y.toString());
//        System.out.println(y.tasksToString());
//        System.out.println(y.dateToString());
//        y.removeTask("u");
//        System.out.println(y.toString());
//        System.out.println(y.dataToString());
//        System.out.println(y.dateToString());
//        System.out.println(y.tasksToString());
//
//        y.addTask("barf");
//        System.out.println(y.tasksToString());
//
//        ToDoList bucketList = new ToDoList("mmm");
//        bucketList.addItem(x);
//        bucketList.addItem(y);
//
//        System.out.println(bucketList.toString());
//        System.out.println(bucketList.findDate("2016-11-18"));
//        System.out.println(bucketList.findDate("2016-11-11"));

//        ToDoList bucketList = new ToDoList("mmm");
//        User bela = new User("bela");
//        User x = new User("x");
//        User bsoptei = new User("bsoptei");
//        ToDoList myToDo = bsoptei.getUserToDoList();
//
//        System.out.println(myToDo.toString());
//        System.out.println(myToDo.findDate("2016-11-18"));
        ToDoItem x = new ToDoItem("2014-11-24,lgjaeg");
        System.out.println(x.toString());
        System.out.println(x.tasksToString());
        x.removeTask("lgjaeg");
        System.out.println(x.toString());
        System.out.println(x.tasksToString());
    }
}
