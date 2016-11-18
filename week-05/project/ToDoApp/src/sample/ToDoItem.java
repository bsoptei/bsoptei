package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.util.Arrays.*;

public class ToDoItem {
    private ArrayList<String> data;

    public ToDoItem(String line) {
        String[] lineToArray = line.split(",");
        this.data = new ArrayList<>(Arrays.asList(lineToArray));
    }

    String dataToString() {
        StringBuilder output = new StringBuilder();
        output.append(data.toString());
        output.delete(0,1);
        output.delete(output.length() - 1, output.length());

        return output.toString().replaceAll(", ", ",");
    }

    String dateToString() {
        return data.get(0);
    }

    String tasksToString() {
        StringBuilder output = new StringBuilder();
        for (int index = 1; index < data.size(); index++) {
            output.append(data.get(index)).append(",");
        }
//        output.deleteCharAt(output.length() - 1);
        return output.toString();
    }

    void addTask(String task) {
        this.data.add(task);
    }

    void removeTask(String task) {
        if (data.contains(task)) {
            this.data.remove(task);
        }
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        for (String element: data) {
            output.append(element).append(",");
        }
        output.deleteCharAt(output.length() - 1);
        return output.toString();
    }

    public ArrayList<String> getData() {
        return data;
    }
}
