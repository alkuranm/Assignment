package org.example;

import java.util.HashMap;
import java.util.Set;

public interface Classifier {
    public void foundDomainsSetFill(Set<String> foundDomainsSet, HashMap<String, String> indicatorsToDomain, String[] wordsReadLine);
}
