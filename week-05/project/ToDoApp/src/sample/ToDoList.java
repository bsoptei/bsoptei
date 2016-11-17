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
    private String source;
    private ArrayList<String> rawContents = new ArrayList<>();
    private ArrayList<String[]> processedContents = new ArrayList<>();
    private File data;
    private ArrayList<String> outputContent;

    ToDoList(String userName) {
        this.setSource(userName);
        this.data = new File(source);
        checkData();
        processContents();
    }

    private void setSource(String userName) {
        this.source = "src/sample/data/" + userName + ".txt";
    }

    private void readFile() {
        Charset charset = Charset.forName("UTF-8");
        try (
                BufferedReader reader = Files.newBufferedReader(Paths.get(source), charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                rawContents.add(line);
            }
        } catch (
                IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    private void processContents() {
        for (String line : rawContents) {
            processedContents.add(line.trim().split(","));
        }
    }

    ArrayList<String[]> getProcessedContents() {
        return processedContents;
    }

    private void addToProcessedContents(String[] dataToAdd) {
        this.processedContents.add(dataToAdd);
    }

    void generateOutputContent() {
        this.outputContent = new ArrayList<>();
        for (String [] line: processedContents) {
            this.outputContent.add(Arrays.toString(line).trim());
        }
//        this.outputContent.addAll(processedContents.stream().map(Arrays::toString).collect(Collectors.toList()));
        Collections.sort(outputContent);
    }

    private void checkData() {
        if (data.exists()) {
            readFile();
        } else try {
            data.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }




    void writeFile() {
        try {
            FileWriter fw = new FileWriter(data.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            for (String line : outputContent) {
                line = line.substring(1, line.length() - 1);
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int findDate(String date) {
        int indexOfDate = -1;
        for (int index = 0; index < processedContents.size(); index++) {
            if (processedContents.get(index)[0].equals(date)) {
                indexOfDate = index;
            }
        }
        return indexOfDate;
    }

    void addTaskToDate(String date, String task) {
        // Add thing to the to do list to an existing date
        String taskToAdd = "," + task.trim();
        String[] a = processedContents.get(findDate(date));
        this.processedContents.remove(findDate(date));
        String temp = Arrays.toString(a).substring(1, Arrays.toString(a).length() - 1).concat(taskToAdd);
        addToProcessedContents(temp.split(","));
    }

    void removeTaskFromDate(String date, String task) {
        // Remove a task
        String[] a = processedContents.get(findDate(date));
        this.processedContents.remove(findDate(date));
        ArrayList<String> temp = new ArrayList<>(Arrays.asList(a));
        for (int index = 0; index < temp.size(); index++) {
            if (temp.get(index).trim().equalsIgnoreCase(task.trim())) {
                temp.remove(index);
            }
        }
        String[] b = temp.toArray(new String[temp.size()]);
        addToProcessedContents(temp.toArray(b));
    }


    void addDateToCalendar(String date) {
        String[] appendWith = {date};
        addToProcessedContents(appendWith);
    }

    void removeDateFromCalendar(String date) {
        this.processedContents.remove(findDate(date));
    }

}
