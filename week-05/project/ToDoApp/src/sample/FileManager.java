package sample;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

class FileManager {

    ArrayList<String> readFile(String source) {
        ArrayList<String> contents = new ArrayList<>();
        Charset charset = Charset.forName("UTF-8");
        try (
                BufferedReader reader = Files.newBufferedReader(Paths.get(source), charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                contents.add(line);
            }
        } catch (
                IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return contents;
    }

    void createUserFile(File data) {
        try {
            data.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeFile(ArrayList<String> content, File data) {
        try {
            FileWriter fw = new FileWriter(data.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (String line : content) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
