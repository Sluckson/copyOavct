package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializationProblemHandler;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.exc.UnrecognizedPropertyException;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.map.util.LinkedNode;
import org.codehaus.jackson.map.util.ObjectBuffer;
import org.codehaus.jackson.type.JavaType;

public class StdDeserializationContext extends DeserializationContext {
    static final int MAX_ERROR_STR_LEN = 500;
    protected ArrayBuilders _arrayBuilders;
    protected DateFormat _dateFormat;
    protected final DeserializerProvider _deserProvider;
    protected ObjectBuffer _objectBuffer;
    protected JsonParser _parser;

    public StdDeserializationContext(DeserializationConfig deserializationConfig, JsonParser jsonParser, DeserializerProvider deserializerProvider) {
        super(deserializationConfig);
        this._parser = jsonParser;
        this._deserProvider = deserializerProvider;
    }

    public DeserializerProvider getDeserializerProvider() {
        return this._deserProvider;
    }

    public JsonParser getParser() {
        return this._parser;
    }

    public final ObjectBuffer leaseObjectBuffer() {
        ObjectBuffer objectBuffer = this._objectBuffer;
        if (objectBuffer == null) {
            return new ObjectBuffer();
        }
        this._objectBuffer = null;
        return objectBuffer;
    }

    public final void returnObjectBuffer(ObjectBuffer objectBuffer) {
        if (this._objectBuffer == null || objectBuffer.initialCapacity() >= this._objectBuffer.initialCapacity()) {
            this._objectBuffer = objectBuffer;
        }
    }

    public final ArrayBuilders getArrayBuilders() {
        if (this._arrayBuilders == null) {
            this._arrayBuilders = new ArrayBuilders();
        }
        return this._arrayBuilders;
    }

    public Date parseDate(String str) throws IllegalArgumentException {
        try {
            return getDateFormat().parse(str);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Calendar constructCalendar(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance;
    }

    public boolean handleUnknownProperty(JsonParser jsonParser, JsonDeserializer<?> jsonDeserializer, Object obj, String str) throws IOException, JsonProcessingException {
        LinkedNode<DeserializationProblemHandler> problemHandlers = this._config.getProblemHandlers();
        if (problemHandlers == null) {
            return false;
        }
        JsonParser jsonParser2 = this._parser;
        this._parser = jsonParser;
        while (problemHandlers != null) {
            try {
                if (problemHandlers.value().handleUnknownProperty(this, jsonDeserializer, obj, str)) {
                    return true;
                }
                problemHandlers = problemHandlers.next();
            } finally {
                this._parser = jsonParser2;
            }
        }
        this._parser = jsonParser2;
        return false;
    }

    public JsonMappingException mappingException(Class<?> cls) {
        String _calcName = _calcName(cls);
        JsonParser jsonParser = this._parser;
        return JsonMappingException.from(jsonParser, "Can not deserialize instance of " + _calcName + " out of " + this._parser.getCurrentToken() + " token");
    }

    public JsonMappingException instantiationException(Class<?> cls, Throwable th) {
        JsonParser jsonParser = this._parser;
        return JsonMappingException.from(jsonParser, "Can not construct instance of " + cls.getName() + ", problem: " + th.getMessage(), th);
    }

    public JsonMappingException instantiationException(Class<?> cls, String str) {
        JsonParser jsonParser = this._parser;
        return JsonMappingException.from(jsonParser, "Can not construct instance of " + cls.getName() + ", problem: " + str);
    }

    public JsonMappingException weirdStringException(Class<?> cls, String str) {
        JsonParser jsonParser = this._parser;
        return JsonMappingException.from(jsonParser, "Can not construct instance of " + cls.getName() + " from String value '" + _valueDesc() + "': " + str);
    }

    public JsonMappingException weirdNumberException(Class<?> cls, String str) {
        JsonParser jsonParser = this._parser;
        return JsonMappingException.from(jsonParser, "Can not construct instance of " + cls.getName() + " from number value (" + _valueDesc() + "): " + str);
    }

    public JsonMappingException weirdKeyException(Class<?> cls, String str, String str2) {
        JsonParser jsonParser = this._parser;
        return JsonMappingException.from(jsonParser, "Can not construct Map key of type " + cls.getName() + " from String \"" + _desc(str) + "\": " + str2);
    }

    public JsonMappingException wrongTokenException(JsonParser jsonParser, JsonToken jsonToken, String str) {
        return JsonMappingException.from(jsonParser, "Unexpected token (" + jsonParser.getCurrentToken() + "), expected " + jsonToken + ": " + str);
    }

    public JsonMappingException unknownFieldException(Object obj, String str) {
        return UnrecognizedPropertyException.from(this._parser, obj, str);
    }

    public JsonMappingException unknownTypeException(JavaType javaType, String str) {
        JsonParser jsonParser = this._parser;
        return JsonMappingException.from(jsonParser, "Could not resolve type id '" + str + "' into a subtype of " + javaType);
    }

    /* access modifiers changed from: protected */
    public DateFormat getDateFormat() {
        if (this._dateFormat == null) {
            this._dateFormat = (DateFormat) this._config.getDateFormat().clone();
        }
        return this._dateFormat;
    }

    /* access modifiers changed from: protected */
    public String determineClassName(Object obj) {
        return ClassUtil.getClassDescription(obj);
    }

    /* access modifiers changed from: protected */
    public String _calcName(Class<?> cls) {
        if (!cls.isArray()) {
            return cls.getName();
        }
        return _calcName(cls.getComponentType()) + "[]";
    }

    /* access modifiers changed from: protected */
    public String _valueDesc() {
        try {
            return _desc(this._parser.getText());
        } catch (Exception unused) {
            return "[N/A]";
        }
    }

    /* access modifiers changed from: protected */
    public String _desc(String str) {
        if (str.length() <= 500) {
            return str;
        }
        return str.substring(0, 500) + "]...[" + str.substring(str.length() - 500);
    }
}
