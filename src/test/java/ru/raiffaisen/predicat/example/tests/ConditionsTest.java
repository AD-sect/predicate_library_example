package ru.raiffaisen.predicat.example.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.raiffaisen.predicat.example.checker.EntityChecker;
import ru.raiffaisen.predicat.example.entity.Rule;
import ru.raiffaisen.predicat.example.utils.ObjectMapperUtils;
import ru.raiffaisen.predicat.example.utils.ResourceUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class ConditionsTest {

    private final String ENTITY = ResourceUtils.getResourceAsString("json/entity_json.json");


    @InjectMocks
    private EntityChecker entityChecker;


    @Test
    public void andOrRuleTest() {
        String rulePath = "rules/and_or_rule.json";
        var checkingRule = ObjectMapperUtils.deserializeObject(ResourceUtils.getResourceAsString(rulePath), Rule.class);


        var returnedRule = entityChecker.checkObjectAgainstPredicate(
                ENTITY, ResourceUtils.getResourceAsString(rulePath)
        ).get(0);


        assertEquals(returnedRule.getName(), checkingRule.getName());
    }

    @Test
    public void datesRuleTest() {
        String rulePath = "rules/dates_rule.json";
        var checkingRule = ObjectMapperUtils.deserializeObject(ResourceUtils.getResourceAsString(rulePath), Rule.class);


        var returnedRule = entityChecker.checkObjectAgainstPredicate(
                ENTITY, ResourceUtils.getResourceAsString(rulePath)
        ).get(0);


        assertEquals(returnedRule.getName(), checkingRule.getName());
    }

    @Test
    public void bigDecimalRuleTest() {
        String rulePath = "rules/big_decimal_rule.json";
        var checkingRule = ObjectMapperUtils.deserializeObject(ResourceUtils.getResourceAsString(rulePath), Rule.class);


        var returnedRule = entityChecker.checkObjectAgainstPredicate(
                ENTITY, ResourceUtils.getResourceAsString(rulePath)
        ).get(0);


        assertEquals(returnedRule.getName(), checkingRule.getName());
    }

    @Test
    public void stringRuleTest() {
        String rulePath = "rules/string_rule.json";
        var checkingRule = ObjectMapperUtils.deserializeObject(ResourceUtils.getResourceAsString(rulePath), Rule.class);


        var returnedRule = entityChecker.checkObjectAgainstPredicate(
                ENTITY, ResourceUtils.getResourceAsString(rulePath)
        ).get(0);


        assertEquals(returnedRule.getName(), checkingRule.getName());
    }

    @Test
    public void subentityRuleTest() {
        String rulePath = "rules/subentity_rule.json";
        var checkingRule = ObjectMapperUtils.deserializeObject(ResourceUtils.getResourceAsString(rulePath), Rule.class);


        var returnedRule = entityChecker.checkObjectAgainstPredicate(
                ENTITY, ResourceUtils.getResourceAsString(rulePath)
        ).get(0);


        assertEquals(returnedRule.getName(), checkingRule.getName());
    }

    @Test
    public void collectionRuleTest() {
        String rulePath = "rules/collection_rule.json";
        var checkingRule = ObjectMapperUtils.deserializeObject(ResourceUtils.getResourceAsString(rulePath), Rule.class);


        var returnedRule = entityChecker.checkObjectAgainstPredicate(
                ENTITY, ResourceUtils.getResourceAsString(rulePath)
        ).get(0);


        assertEquals(returnedRule.getName(), checkingRule.getName());
    }

    @Test
    public void compareFieldsRuleTest() {
        String rulePath = "rules/collection_rule.json";
        var checkingRule = ObjectMapperUtils.deserializeObject(ResourceUtils.getResourceAsString(rulePath), Rule.class);


        var returnedRule = entityChecker.checkObjectAgainstPredicate(
                ENTITY, ResourceUtils.getResourceAsString(rulePath)
        ).get(0);


        assertEquals(returnedRule.getName(), checkingRule.getName());
    }


}
