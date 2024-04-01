package ru.raiffaisen.predicat.example.utils;

import lombok.SneakyThrows;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class ResourceUtils {

    @SneakyThrows
    public static String getResourceAsString(String resourceFilePath) {
        URL resource = ResourceUtils.class.getClassLoader().getResource(resourceFilePath);
        Objects.requireNonNull(resource);
        return Files.readString(Paths.get(resource.toURI()), StandardCharsets.UTF_8);
    }

}
