package io.github.thiagolvlsantos.json.predicate.value.impl;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.thiagolvlsantos.json.predicate.value.AbstractPredicateValue;
import io.github.thiagolvlsantos.json.predicate.value.IAccess;
import io.github.thiagolvlsantos.json.predicate.value.IConverter;

import java.util.Objects;

public class PredicateNull extends AbstractPredicateValue {

    public PredicateNull(String key, IAccess access, JsonNode value, IConverter converter) {
        super(key, access, value, converter);
    }

    @Override
    public boolean test(Object t) {
        Object left = left(t);
        return Objects.isNull(left);
    }
}
