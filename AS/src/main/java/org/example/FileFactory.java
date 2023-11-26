package org.example;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileFactory {
    public ReadFile getInstance(String pathFile){

        Path path = Paths.get(pathFile);
        String fileName = path.getFileName().toString();

        // Get the file extension
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex > 0) {
            String fileExtension = fileName.substring(lastDotIndex + 1).toLowerCase();

            // Map file extensions to file types
            switch (fileExtension) {
                case "txt":
                    return new ReadFileTxt();
                case "csv":
                    return new ReadFileCSV() ;
                // Add more file types as needed
                default:
                    return null;
            }
        } else {
            return null;
        }
    }
}
