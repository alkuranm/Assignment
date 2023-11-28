package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileFactory {
    public Reader getInstance(String pathFile){

        Path path = Paths.get(pathFile);
        String extractedFileName = path.getFileName().toString();

        int lastDotIndex = extractedFileName.lastIndexOf('.');
        if (lastDotIndex > 0) {
            String fileExtension = extractedFileName.substring(lastDotIndex + 1).toLowerCase();
            switch (fileExtension) {
                case "txt":
                    return new TxtFileReader();
                case "csv":
                    return new CsvFileReader() ;
                default:
                    return null;
            }
        } else {
            return null;
        }
    }
}
