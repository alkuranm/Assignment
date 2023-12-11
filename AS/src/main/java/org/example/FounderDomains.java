package org.example;

import java.util.HashMap;
import java.util.Set;

public class FounderDomains implements Classifier {
    @Override
    public void identifyAndCollectDomains(Set<String> foundDomains, HashMap<String, String> indicators2Domain, String[] wordsArray) {
        for (String currentWord : wordsArray) {
            if (indicators2Domain.containsKey(currentWord) || (currentWord.length() > 0 && currentWord.charAt(currentWord.length() - 1) == ',' && indicators2Domain.containsKey(currentWord.substring(0,currentWord.length() - 1)))) {
                foundDomains.add(indicators2Domain.get(currentWord));
            }
        }    

    }
}
