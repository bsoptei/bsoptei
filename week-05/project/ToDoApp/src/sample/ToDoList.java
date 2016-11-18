package sample;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

class ToDoList {
    private ArrayList<ToDoItem> myList;
    private FileManager listManager;

    private String source;
    private ArrayList<String> rawContents = new ArrayList<>();
    private File data;
    private ArrayList<String> outputContent;

    ToDoList(String source) {
        this.myList = new ArrayList<>();
        this.source = source;
        this.data = new File(source);
        this.listManager = new FileManager();
        checkData();
        this.rawContents = listManager.readFile(source);
        updateList();
    }

    void generateOutputContent() {
        this.outputContent = new ArrayList<>();
        for (ToDoItem item: myList) {
            outputContent.add(item.toString());
        }
        Collections.sort(outputContent);
    }

    private void checkData() {
        if (!data.exists()) {
            listManager.createUserFile(data);
        }
        listManager.readFile(source);
    }


    int findDate(String date) {
        int indexOfDate = -1;
        for (ToDoItem item : myList) {
            if (date.equals(item.dateToString())) {
                indexOfDate = myList.indexOf(item);
            }}
        return indexOfDate;
    }

    void addItem(ToDoItem item) {
        this.myList.add(item);
    }

    void removeItem(ToDoItem item) {
        this.myList.remove(item);
    }

    public void save() {
        listManager.writeFile(outputContent, data);
    }

    void updateList() {
        for (String line : rawContents) {
            myList.add(new ToDoItem(line));
        }
    }

    public String toString() {
        return myList.toString();
    }

    ArrayList<ToDoItem> getMyList() {
        return myList;
    }


    ToDoItem getItemByDate(String date) {
        return myList.get(findDate(date));
    }
}