package org.example;

import java.util.HashMap;
import java.util.Set;

public class SetFiller implements Classifier {
    @Override
    public void SetFill(Set<String> foundDomainsSet, HashMap<String, String> indicators2Domain, String[] wordsLine) {
        for (String word : wordsLine) {
            if (indicators2Domain.containsKey(word) || (word.length() > 0 && word.charAt(word.length() - 1) == ',' && indicators2Domain.containsKey(word.substring(0,word.length() - 1)))) {
                foundDomainsSet.add(indicators2Domain.get(word));
            }
        }    

    }
}
