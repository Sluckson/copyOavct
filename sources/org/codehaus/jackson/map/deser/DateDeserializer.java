package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.util.Date;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;

public class DateDeserializer extends StdScalarDeserializer<Date> {
    public DateDeserializer() {
        super(Date.class);
    }

    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return _parseDate(jsonParser, deserializationContext);
    }
}
