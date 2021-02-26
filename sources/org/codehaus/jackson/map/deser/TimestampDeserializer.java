package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.sql.Timestamp;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;

public class TimestampDeserializer extends StdScalarDeserializer<Timestamp> {
    public TimestampDeserializer() {
        super(Timestamp.class);
    }

    public Timestamp deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return new Timestamp(_parseDate(jsonParser, deserializationContext).getTime());
    }
}
