package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        //If we test the JSON file 'json1' with either 'txt1' or 'csv1', we expect to retrieve words such as education, financial, technology, and healthcare.
        //If we test the JSON file 'json2' with either 'txt2' or 'csv2', we expect to retrieve words such as automotive, food,real estate
        String jsonFilePath = "C:\\Users\\t-malkoran\\Desktop\\Assignment\\AS\\src\\main\\java\\org\\example\\jsonTotest2.json";
        String txtOrCsvFilePath = "C:\\Users\\t-malkoran\\Desktop\\Assignment\\AS\\src\\main\\java\\org\\example\\txtTotest2.txt";

        //Class JSON
        Mapper jsonMapper = new JsonToMapMapper();
        HashMap<String, String> Indicators2Domain= jsonMapper.mapJsonFileToHashMap(jsonFilePath);
        FileFactory fileFactory  = new FileFactory();
        Reader fileReader  = fileFactory.getInstance(txtOrCsvFilePath);

        //
        Classifier classify = new FoundDomainsSetFiller();
        Set<String> foundDomainsSet = new HashSet<>();

        boolean isTextFinished = false;
        int i = 0;
        while (!isTextFinished) {
            String[] wordsFromReadLine = fileReader.ReadFile(txtOrCsvFilePath, i);
            if (wordsFromReadLine == null) {
                isTextFinished = true;
            } else {
                classify.foundDomainsSetFill(foundDomainsSet, Indicators2Domain, wordsFromReadLine);
            }
            i++;
        }

        for (String item : foundDomainsSet) {
            System.out.println(item );
        }
    }
}