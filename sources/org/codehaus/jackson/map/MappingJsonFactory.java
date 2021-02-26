package org.codehaus.jackson.map;

import java.io.IOException;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.format.InputAccessor;
import org.codehaus.jackson.format.MatchStrength;

public class MappingJsonFactory extends JsonFactory {
    public String getFormatName() {
        return JsonFactory.FORMAT_NAME_JSON;
    }

    public MappingJsonFactory() {
        this((ObjectMapper) null);
    }

    public MappingJsonFactory(ObjectMapper objectMapper) {
        super(objectMapper);
        if (objectMapper == null) {
            setCodec(new ObjectMapper((JsonFactory) this));
        }
    }

    public final ObjectMapper getCodec() {
        return (ObjectMapper) this._objectCodec;
    }

    public MatchStrength hasFormat(InputAccessor inputAccessor) throws IOException {
        return hasJSONFormat(inputAccessor);
    }
}
