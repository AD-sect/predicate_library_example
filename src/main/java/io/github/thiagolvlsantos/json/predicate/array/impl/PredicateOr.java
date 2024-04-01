package io.github.thiagolvlsantos.json.predicate.array.impl;

import io.github.thiagolvlsantos.json.predicate.IPredicate;
import io.github.thiagolvlsantos.json.predicate.array.AbstractPredicateArray;

import java.util.List;

public class PredicateOr extends AbstractPredicateArray {

	public PredicateOr(List<IPredicate> conditions) {
		super(conditions);
	}

	@Override
	public boolean test(Object obj) {
		return conditions.stream().anyMatch(p -> p.test(obj));
	}
}