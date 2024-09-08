package com.example.music_album.util;

import com.example.music_album.entity.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToObjectConverterUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // Generic method to convert JSON string to object of any type
    public static <T> T convertJsonStringToObject(String jsonString, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonString, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // or throw a custom exception
        }
    }

}
