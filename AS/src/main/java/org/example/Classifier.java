package org.example;

import java.util.HashMap;
import java.util.Set;

public interface Classifier {
    public void identifyAndCollectDomains(Set<String> foundDomains, HashMap<String, String> indicatorsToDomain, String[] wordsArray);
}
