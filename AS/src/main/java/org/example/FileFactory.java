package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileFactory {
    public Reader getInstance(String filePath) {

        String fileExtension = getFileExtension(filePath);
        switch (fileExtension) {
                case "txt":
                    return new TxtFileReader();
                case "csv":
                    return new CsvFileReader() ;
                default:
                    throw new RuntimeException("Unsupported file type: " + fileExtension);
        }
    }
    private String getFileExtension(String filePath) {
        Path path = Paths.get(filePath);
        String extractedFileName = path.getFileName().toString();

        int lastDotIndex = extractedFileName.lastIndexOf('.');
        if (lastDotIndex > 0) {
            return extractedFileName.substring(lastDotIndex + 1).toLowerCase();
        } else {
            throw new RuntimeException("File has no extension: " + filePath);
        }
    }
}
