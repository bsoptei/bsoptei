package sample;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

class ToDoItem {
    private ArrayList<String> data;

    ToDoItem(String line) {
        String[] lineToArray = line.split(",");
        this.data = new ArrayList<>(Arrays.asList(lineToArray));
    }

    String dateToString() {
        return data.get(0);
    }

    String tasksToString() {
        StringBuilder output = new StringBuilder();
        for (int index = 1; index < data.size(); index++) {
            output.append(data.get(index)).append(",");
        }
        return output.toString();
    }

    void addTask(String task) {
        this.data.add(task);
    }

    void removeTask(String task) {
        try {
            if (data.contains(task)) {
                this.data.remove(task);
            } else if (Integer.parseInt(task) < data.size()) {
                this.data.remove(Integer.parseInt(task));
            }
        } catch (Exception e) {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            toolkit.beep();
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

    ArrayList<String> getData() {
        return data;
    }
}
