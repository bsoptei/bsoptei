package sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

class FileManager {
    private AESEncrp enkryptor = new AESEncrp();

    ArrayList<String> getDataFromFile(Path path, boolean shouldIDecrypt) {
        ArrayList<String> wordList = new ArrayList<>();
        try (
                BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (shouldIDecrypt) {
                    line = enkryptor.decrypt(line);
                }
                wordList.add(line);
            }
        } catch (
                IOException x) {
            System.err.format("IOException: %s%n", x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wordList;
    }

    void writeGameDataToFile(ArrayList<String> data, boolean shouldIEncrypt) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/sample/docs/stored.txt"), Charset.forName("UTF-8"));
            for (String line : data) {
                if (shouldIEncrypt) {
                    line = enkryptor.encrypt(line);
                }
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
