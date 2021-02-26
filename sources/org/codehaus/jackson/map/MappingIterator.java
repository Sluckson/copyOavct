package org.codehaus.jackson.map;

import java.io.IOException;
import java.util.Iterator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.type.JavaType;

public class MappingIterator<T> implements Iterator<T> {
    protected static final MappingIterator<?> EMPTY_ITERATOR = new MappingIterator<>((JavaType) null, (JsonParser) null, (DeserializationContext) null, (JsonDeserializer<?>) null);
    protected final DeserializationContext _context;
    protected final JsonDeserializer<T> _deserializer;
    protected final JsonParser _parser;
    protected final JavaType _type;

    protected MappingIterator(JavaType javaType, JsonParser jsonParser, DeserializationContext deserializationContext, JsonDeserializer<?> jsonDeserializer) {
        this._type = javaType;
        this._parser = jsonParser;
        this._context = deserializationContext;
        this._deserializer = jsonDeserializer;
        if (jsonParser != null && jsonParser.getCurrentToken() == JsonToken.START_ARRAY && !jsonParser.getParsingContext().inRoot()) {
            jsonParser.clearCurrentToken();
        }
    }

    protected static <T> MappingIterator<T> emptyIterator() {
        return EMPTY_ITERATOR;
    }

    public boolean hasNext() {
        try {
            return hasNextValue();
        } catch (JsonMappingException e) {
            throw new RuntimeJsonMappingException(e.getMessage(), e);
        } catch (IOException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        }
    }

    public T next() {
        try {
            return nextValue();
        } catch (JsonMappingException e) {
            throw new RuntimeJsonMappingException(e.getMessage(), e);
        } catch (IOException e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        }
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public boolean hasNextValue() throws IOException {
        JsonParser jsonParser = this._parser;
        if (jsonParser == null) {
            return false;
        }
        if (jsonParser.getCurrentToken() != null) {
            return true;
        }
        JsonToken nextToken = this._parser.nextToken();
        if (nextToken == null) {
            this._parser.close();
            return false;
        } else if (nextToken == JsonToken.END_ARRAY) {
            return false;
        } else {
            return true;
        }
    }

    public T nextValue() throws IOException {
        T deserialize = this._deserializer.deserialize(this._parser, this._context);
        this._parser.clearCurrentToken();
        return deserialize;
    }
}
