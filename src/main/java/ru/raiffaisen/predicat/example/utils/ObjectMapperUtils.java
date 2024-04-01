package ru.raiffaisen.predicat.example.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class ObjectMapperUtils {
    private static final ObjectMapper objectMapper = createObjectMapper(JsonInclude.Include.NON_NULL);

    private static ObjectMapper createObjectMapper(JsonInclude.Include inclusionStrategy) {
        return new ObjectMapper()
//                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setSerializationInclusion(inclusionStrategy)
                .registerModule(new JavaTimeModule());
    }

    private ObjectMapperUtils() {
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public static <T> T deserializeObject(String objectasString, Class<T> className) {
        try {
            return getObjectMapper().readValue(objectasString, className);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String serializeObject(Object object) {
        try {
            return getObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
