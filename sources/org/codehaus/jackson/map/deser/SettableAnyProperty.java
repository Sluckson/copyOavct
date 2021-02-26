package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.lang.reflect.Method;
import org.codehaus.jackson.JsonLocation;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.type.JavaType;

public final class SettableAnyProperty {
    protected final BeanProperty _property;
    protected final Method _setter;
    protected final JavaType _type;
    protected JsonDeserializer<Object> _valueDeserializer;

    public SettableAnyProperty(BeanProperty beanProperty, AnnotatedMethod annotatedMethod, JavaType javaType) {
        this._property = beanProperty;
        this._type = javaType;
        this._setter = annotatedMethod.getAnnotated();
    }

    public void setValueDeserializer(JsonDeserializer<Object> jsonDeserializer) {
        if (this._valueDeserializer == null) {
            this._valueDeserializer = jsonDeserializer;
            return;
        }
        throw new IllegalStateException("Already had assigned deserializer for SettableAnyProperty");
    }

    public BeanProperty getProperty() {
        return this._property;
    }

    public boolean hasValueDeserializer() {
        return this._valueDeserializer != null;
    }

    public JavaType getType() {
        return this._type;
    }

    public final void deserializeAndSet(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws IOException, JsonProcessingException {
        set(obj, str, deserialize(jsonParser, deserializationContext));
    }

    public final Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (jsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {
            return null;
        }
        return this._valueDeserializer.deserialize(jsonParser, deserializationContext);
    }

    public final void set(Object obj, String str, Object obj2) throws IOException {
        try {
            this._setter.invoke(obj, new Object[]{str, obj2});
        } catch (Exception e) {
            _throwAsIOE(e, str, obj2);
        }
    }

    /* access modifiers changed from: protected */
    public void _throwAsIOE(Exception exc, String str, Object obj) throws IOException {
        String str2;
        if (exc instanceof IllegalArgumentException) {
            if (obj == null) {
                str2 = "[NULL]";
            } else {
                str2 = obj.getClass().getName();
            }
            StringBuilder sb = new StringBuilder("Problem deserializing \"any\" property '");
            sb.append(str);
            sb.append("' of class " + getClassName() + " (expected type: ");
            sb.append(this._type);
            sb.append("; actual type: ");
            sb.append(str2);
            sb.append(")");
            String message = exc.getMessage();
            if (message != null) {
                sb.append(", problem: ");
                sb.append(message);
            } else {
                sb.append(" (no error message provided)");
            }
            throw new JsonMappingException(sb.toString(), (JsonLocation) null, exc);
        } else if (!(exc instanceof IOException)) {
            boolean z = exc instanceof RuntimeException;
            Throwable th = exc;
            if (!z) {
                while (th.getCause() != null) {
                    th = th.getCause();
                }
                throw new JsonMappingException(th.getMessage(), (JsonLocation) null, th);
            }
            throw ((RuntimeException) exc);
        } else {
            throw ((IOException) exc);
        }
    }

    private String getClassName() {
        return this._setter.getDeclaringClass().getName();
    }

    public String toString() {
        return "[any property on class " + getClassName() + "]";
    }
}
