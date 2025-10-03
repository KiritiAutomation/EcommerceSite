package org.example.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class JsonUtils {

    private static final String FILE_PATH = System.getProperty("user.dir") + "//src//test//resources//testdata.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    // Add/update simple key:value under parent
    public static void writeNestedData(String parentKey, String childKey, String value) {
        try {
            File file = new File(FILE_PATH);
            ObjectNode root;

            if (file.exists() && file.length() > 0) {
                root = (ObjectNode) mapper.readTree(file);
            } else {
                root = mapper.createObjectNode();
            }

            ObjectNode parentNode;
            if (root.has(parentKey)) {
                parentNode = (ObjectNode) root.get(parentKey);
            } else {
                parentNode = mapper.createObjectNode();
            }

            parentNode.put(childKey, value);
            root.set(parentKey, parentNode);

            mapper.writerWithDefaultPrettyPrinter().writeValue(file, root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add values into an array under parent
    public static void writeArrayData(String parentKey, String arrayKey, String value) {
        try {
            File file = new File(FILE_PATH);
            ObjectNode root;

            if (file.exists() && file.length() > 0) {
                root = (ObjectNode) mapper.readTree(file);
            } else {
                root = mapper.createObjectNode();
            }

            ObjectNode parentNode;
            if (root.has(parentKey)) {
                parentNode = (ObjectNode) root.get(parentKey);
            } else {
                parentNode = mapper.createObjectNode();
            }

            ArrayNode arrayNode;
            if (parentNode.has(arrayKey)) {
                arrayNode = (ArrayNode) parentNode.get(arrayKey);
            } else {
                arrayNode = mapper.createArrayNode();
            }

            boolean alreadyPresent = false;
            for(int i=0; i<arrayNode.size(); i++){
                if(arrayNode.get(i).asText().equals(value)){
                    alreadyPresent = true;
                    break;
                }
            }

            if(!alreadyPresent){
                arrayNode.add(value);
            }


            parentNode.set(arrayKey, arrayNode);
            root.set(parentKey, parentNode);

            mapper.writerWithDefaultPrettyPrinter().writeValue(file, root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read simple key:value
    public static String readNestedData(String parentKey, String childKey) {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists() || file.length() == 0) return null;

            ObjectNode root = (ObjectNode) mapper.readTree(file);

            if (root.has(parentKey)) {
                ObjectNode parentNode = (ObjectNode) root.get(parentKey);
                if(parentNode != null && parentNode.has(childKey)){
                    ArrayNode childNode = (ArrayNode) parentNode.get(childKey);
                    if(childNode.isArray() && !childNode.isEmpty()){
                        return childNode.get(0).asText();
                    }
                    else{
                        return childNode.asText();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Read array values
    public static String[] readArrayData(String parentKey, String arrayKey) {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists() || file.length() == 0) return new String[0];

            ObjectNode root = (ObjectNode) mapper.readTree(file);

            if (root.has(parentKey)) {
                ObjectNode parentNode = (ObjectNode) root.get(parentKey);
                if (parentNode.has(arrayKey)) {
                    ArrayNode arrayNode = (ArrayNode) parentNode.get(arrayKey);
                    String[] values = new String[arrayNode.size()];
                    for (int i = 0; i < arrayNode.size(); i++) {
                        values[i] = arrayNode.get(i).asText();
                    }
                    return values;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[0];
    }



}
