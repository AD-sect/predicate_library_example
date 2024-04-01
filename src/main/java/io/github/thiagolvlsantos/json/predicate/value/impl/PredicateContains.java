package io.github.thiagolvlsantos.json.predicate.value.impl;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.thiagolvlsantos.json.predicate.value.AbstractPredicateValue;
import io.github.thiagolvlsantos.json.predicate.value.IAccess;
import io.github.thiagolvlsantos.json.predicate.value.IConverter;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class PredicateContains extends AbstractPredicateValue {

	public PredicateContains(String key, IAccess access, JsonNode value, IConverter converter) {
		super(key, access, value, converter);
	}

	@Override
	public boolean test(Object t) {
		Object left = left(t);
		return check(left, left);
	}

	protected boolean check(Object base, Object tmp) {
		if (tmp instanceof Collection<?>) {
			for (Iterator<?> iterator = ((Collection<?>) tmp).iterator(); iterator.hasNext();) {
				Object obj = iterator.next();
				if (check(base, obj)) {
					return true;
				}
			}
			return false;
		}
		if (tmp != null && tmp.getClass().isArray()) {
			for (int i = 0; i < Array.getLength(tmp); i++) {
				Object obj = Array.get(tmp, i);
				if (check(base, obj)) {
					return true;
				}
			}
			return false;
		}
		return innerCheck(base, tmp);
	}

	protected boolean innerCheck(Object base, Object tmp) {
		if (tmp instanceof String) {
			return String.valueOf(tmp).contains(String.valueOf(right(base, tmp)));
		} else {
			return Objects.equals(tmp, right(base, tmp));
		}
	}
}