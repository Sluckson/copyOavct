package org.codehaus.jackson.map.deser;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonMappingException;

public class ThrowableDeserializer extends BeanDeserializer {
    protected static final String PROP_NAME_MESSAGE = "message";

    public ThrowableDeserializer(BeanDeserializer beanDeserializer) {
        super(beanDeserializer);
    }

    public Object deserializeFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (this._propertyBasedCreator != null) {
            return _deserializeUsingPropertyBased(jsonParser, deserializationContext);
        }
        if (this._delegatingCreator != null) {
            return this._delegatingCreator.deserialize(jsonParser, deserializationContext);
        }
        if (this._beanType.isAbstract()) {
            throw JsonMappingException.from(jsonParser, "Can not instantiate abstract type " + this._beanType + " (need to add/enable type information?)");
        } else if (this._stringCreator != null) {
            Object obj = null;
            Object[] objArr = null;
            int i = 0;
            while (jsonParser.getCurrentToken() != JsonToken.END_OBJECT) {
                String currentName = jsonParser.getCurrentName();
                SettableBeanProperty find = this._beanProperties.find(currentName);
                jsonParser.nextToken();
                if (find != null) {
                    if (obj != null) {
                        find.deserializeAndSet(jsonParser, deserializationContext, obj);
                    } else {
                        if (objArr == null) {
                            int size = this._beanProperties.size();
                            objArr = new Object[(size + size)];
                        }
                        int i2 = i + 1;
                        objArr[i] = find;
                        i = i2 + 1;
                        objArr[i2] = find.deserialize(jsonParser, deserializationContext);
                    }
                } else if ("message".equals(currentName)) {
                    obj = this._stringCreator.construct(jsonParser.getText());
                    if (objArr != null) {
                        for (int i3 = 0; i3 < i; i3 += 2) {
                            ((SettableBeanProperty) objArr[i3]).set(obj, objArr[i3 + 1]);
                        }
                        objArr = null;
                    }
                } else if (this._ignorableProps != null && this._ignorableProps.contains(currentName)) {
                    jsonParser.skipChildren();
                } else if (this._anySetter != null) {
                    this._anySetter.deserializeAndSet(jsonParser, deserializationContext, obj, currentName);
                } else {
                    handleUnknownProperty(jsonParser, deserializationContext, obj, currentName);
                }
                jsonParser.nextToken();
            }
            if (obj == null) {
                obj = this._stringCreator.construct((String) null);
                if (objArr != null) {
                    for (int i4 = 0; i4 < i; i4 += 2) {
                        ((SettableBeanProperty) objArr[i4]).set(obj, objArr[i4 + 1]);
                    }
                }
            }
            return obj;
        } else {
            throw new JsonMappingException("Can not deserialize Throwable of type " + this._beanType + " without having either single-String-arg constructor; or explicit @JsonCreator");
        }
    }
}
