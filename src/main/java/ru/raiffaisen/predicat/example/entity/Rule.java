package ru.raiffaisen.predicat.example.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import io.github.thiagolvlsantos.json.predicate.impl.PredicateDeserializer;

import java.util.function.Predicate;

@Data
public class Rule {

    private String name;

    @JsonDeserialize(using = PredicateDeserializer.class)
    private Predicate<Object> condition;
}
