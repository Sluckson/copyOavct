package org.codehaus.jackson.util;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.PrettyPrinter;

public class MinimalPrettyPrinter implements PrettyPrinter {
    public static final String DEFAULT_ROOT_VALUE_SEPARATOR = " ";
    protected String _rootValueSeparator = DEFAULT_ROOT_VALUE_SEPARATOR;

    public void beforeArrayValues(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
    }

    public void beforeObjectEntries(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
    }

    public void setRootValueSeparator(String str) {
        this._rootValueSeparator = str;
    }

    public void writeRootValueSeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        String str = this._rootValueSeparator;
        if (str != null) {
            jsonGenerator.writeRaw(str);
        }
    }

    public void writeStartObject(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.writeRaw('{');
    }

    public void writeObjectFieldValueSeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.writeRaw(':');
    }

    public void writeObjectEntrySeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.writeRaw(',');
    }

    public void writeEndObject(JsonGenerator jsonGenerator, int i) throws IOException, JsonGenerationException {
        jsonGenerator.writeRaw('}');
    }

    public void writeStartArray(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.writeRaw('[');
    }

    public void writeArrayValueSeparator(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        jsonGenerator.writeRaw(',');
    }

    public void writeEndArray(JsonGenerator jsonGenerator, int i) throws IOException, JsonGenerationException {
        jsonGenerator.writeRaw(']');
    }
}
