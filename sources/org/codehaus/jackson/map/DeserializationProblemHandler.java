package org.codehaus.jackson.map;

import java.io.IOException;
import org.codehaus.jackson.JsonProcessingException;

public abstract class DeserializationProblemHandler {
    public boolean handleUnknownProperty(DeserializationContext deserializationContext, JsonDeserializer<?> jsonDeserializer, Object obj, String str) throws IOException, JsonProcessingException {
        return false;
    }
}
