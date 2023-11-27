package org.example;

import java.util.HashMap;
import java.util.Set;

public interface Classifier {
    public void SetFill(Set<String> set, HashMap<String, String> map, String[] wordsLine);
}
