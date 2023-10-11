package chat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Logger {
    public static void writeToFile(String path, String msg) {
        try {
            if (!Files.exists(Paths.get(path))) {
                Files.createFile(Paths.get("bc.txt"));
                path = "bc.txt";
            }
            Files.write(Paths.get(path), msg.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }


    public static String readFromFile(String path) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            System.err.println("Error while reading file: " + e.getMessage());
        }

        return content;
    }
}
