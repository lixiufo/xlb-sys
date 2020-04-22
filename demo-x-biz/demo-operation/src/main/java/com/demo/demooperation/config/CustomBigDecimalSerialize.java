package com.demo.demooperation.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author WPF
 * @version distribution
 * @date 2019-04-28.
 */

public class CustomBigDecimalSerialize extends JsonSerializer<BigDecimal> {

    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value != null) {

            gen.writeString(value.toString());
        } else {
            gen.writeString("0.00");
        }
    }
}
