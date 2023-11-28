package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TxtFileReader implements Reader {
    @Override
    public String[] ReadFile(String filePath, int lineNumberToRead) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int currentLineNumber = 0;

            while ((line = bufferedReader.readLine()) != null) {

                if (currentLineNumber == lineNumberToRead) {
                    return line.split(" ");
                }
                currentLineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
