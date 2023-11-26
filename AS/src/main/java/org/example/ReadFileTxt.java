package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileTxt implements ReadFile{
    @Override
    public String[] read(String path2File, int lineNumberToRead) {
        try (BufferedReader br = new BufferedReader(new FileReader(path2File))) {
            String line;
            int currentLineNumber = 0;

            while ((line = br.readLine()) != null) {

                if (currentLineNumber == lineNumberToRead) {
                    return line.split(" ");
                }
                currentLineNumber++;
            }
        } catch (IOException e) {
            // Handle file reading exception
            e.printStackTrace();
        }
        // if we finsh the file
        return null;
    }
}
