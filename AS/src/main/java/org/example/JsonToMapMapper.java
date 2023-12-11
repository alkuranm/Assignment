package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;

public class JsonToMapMapper implements Mapper {
    @Override
    public HashMap<String, String> mapJsonFileToHashMap(String jsonFilePath) {
        HashMap<String, String> indicators2Domain = new HashMap<String,String>();
        try (Reader reader = new FileReader(jsonFilePath)) {
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            JsonArray classesArray = jsonObject.getAsJsonArray("classificationRules");
            for (int  i = 0; i < classesArray.size(); i++) {
                JsonObject classObject = classesArray.get(i).getAsJsonObject();

                String domain = classObject.getAsJsonPrimitive("domain").getAsString();

                JsonArray indicators = classObject.getAsJsonArray("indicators");

                for (int j = 0; j < indicators.size(); j++) {
                    JsonPrimitive indicator = indicators.get(j).getAsJsonPrimitive();
                    indicators2Domain.put(indicator.getAsString(), domain);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return indicators2Domain;
    }
}
