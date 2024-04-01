package io.github.thiagolvlsantos.json.predicate.value.impl;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.thiagolvlsantos.json.predicate.value.AbstractPredicateValue;
import io.github.thiagolvlsantos.json.predicate.value.IAccess;
import io.github.thiagolvlsantos.json.predicate.value.IConverter;

import java.util.Objects;

public class PredicateEquals extends AbstractPredicateValue {

	public PredicateEquals(String key, IAccess access, JsonNode value, IConverter converter) {
		super(key, access, value, converter);
	}

	@Override
	public boolean test(Object t) {
		Object left = left(t);
		return Objects.equals(left, right(t, left));
	}
}