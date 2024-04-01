package ru.raiffaisen.predicat.example.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.val;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

public class BigDecimalSerializer extends JsonSerializer<BigDecimal> {

    public static final int DEFAULT_BIG_DECIMAL_SCALE = 2;

    @Override
    public void serialize(BigDecimal value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        val valueString = Optional.ofNullable(value)
                .filter(this::isScaleLessThanDefault)
                .map(val -> val.setScale(DEFAULT_BIG_DECIMAL_SCALE).toString())
                .orElse(Optional.ofNullable(value)
                        .map(Objects::toString)
                        .orElse(null)
                );

        jgen.writeString(valueString);
    }

    private boolean isScaleLessThanDefault(final BigDecimal bigDecimal) {
        return bigDecimal.scale() < DEFAULT_BIG_DECIMAL_SCALE;
    }
}