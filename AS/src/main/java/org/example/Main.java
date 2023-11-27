package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        // the pathe of file and json
        String Path2Json = "C:\\Users\\t-malkoran\\Desktop\\Assignment\\AS\\src\\main\\java\\org\\example\\tester.json";
        String Path2File = "C:\\Users\\t-malkoran\\Desktop\\Assignment\\AS\\src\\main\\java\\org\\example\\moade.txt";

        //Class JSON
        Mapper json2Map = new Json2Map();
        HashMap<String, String> Indicators2Domain= json2Map.mapper(Path2Json);
        // GIT THE TYPEOFFILE
        FileFactory file = new FileFactory();
        ReadFile reader = file.getInstance(Path2File);

        //
        Classifier classify = new SetFiller();
        Set<String> foundDomainsSet = new HashSet<>();

        boolean isTextFinished = false;
        int i = 0;
        while (!isTextFinished) {
            String[] words = reader.read(Path2File, i);
            if (words == null) {
                isTextFinished = true;
            } else {
                classify.SetFill(foundDomainsSet, Indicators2Domain, words);
            }
            i++;
        }

        for (String item : foundDomainsSet) {
            System.out.print(item + "  ");
        }
    }
}