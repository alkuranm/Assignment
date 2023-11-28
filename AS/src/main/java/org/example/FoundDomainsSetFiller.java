package org.example;

import java.util.HashMap;
import java.util.Set;

public class FoundDomainsSetFiller implements Classifier {
    @Override
    public void foundDomainsSetFill(Set<String> foundDomainsSet, HashMap<String, String> indicators2Domain, String[] wordsReadLine) {
        for (String currentWord : wordsReadLine) {
            if (indicators2Domain.containsKey(currentWord) || (currentWord.length() > 0 && currentWord.charAt(currentWord.length() - 1) == ',' && indicators2Domain.containsKey(currentWord.substring(0,currentWord.length() - 1)))) {
                foundDomainsSet.add(indicators2Domain.get(currentWord));
            }
        }    

    }
}
