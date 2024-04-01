package ru.raiffaisen.predicat.example.checker;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.raiffaisen.predicat.example.entity.CheckEntity;
import ru.raiffaisen.predicat.example.entity.Rule;
import ru.raiffaisen.predicat.example.utils.ObjectMapperUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

import static ru.raiffaisen.predicat.example.utils.ObjectMapperUtils.getObjectMapper;

@Component
public class EntityChecker {

    public List<Rule> checkObjectAgainstPredicate(String entityAsString, String ruleAsString) {
        Rule rule = ObjectMapperUtils.deserializeObject(ruleAsString, Rule.class);
        CheckEntity checkEntity = ObjectMapperUtils.deserializeObject(entityAsString, CheckEntity.class);

        return getSuitablePredicate(rule, checkEntity);
    }

    public List<Rule> getSuitablePredicate(Rule rule, CheckEntity checkEntity) {
        return List.of(rule).stream()
                .filter(currenctRule -> currenctRule.getCondition().test(checkEntity))
                .toList();
    }

}


