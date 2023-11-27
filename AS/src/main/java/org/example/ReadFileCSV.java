package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class ReadFileCSV implements ReadFile{

    @Override
    public String[] read(String path2File, int lineNumberToRead) {
        try (CSVReader CSVreader  = new CSVReader(new FileReader(path2File))) {
            String[] line;
            int currentLineNumber = 0;
            while ((line = CSVreader.readNext()) != null && currentLineNumber <= lineNumberToRead) {

                if (currentLineNumber == lineNumberToRead) {
                    return line;
                }
                currentLineNumber++;

            }
        } catch (CsvValidationException | IOException e) {
            // Handle file reading exception
            e.printStackTrace();
        }
        return null;
    }
}
