package org.example;

import java.util.HashMap;

public interface Mapper {
    public HashMap<String, String> mapJsonFileToHashMap(String jsonFilePath);
}
