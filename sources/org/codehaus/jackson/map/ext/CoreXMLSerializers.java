package org.codehaus.jackson.map.ext;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.SerializerBase;
import org.codehaus.jackson.map.ser.StdSerializers;
import org.codehaus.jackson.map.ser.ToStringSerializer;
import org.codehaus.jackson.map.util.Provider;

public class CoreXMLSerializers implements Provider<Map.Entry<Class<?>, JsonSerializer<?>>> {
    static final HashMap<Class<?>, JsonSerializer<?>> _serializers = new HashMap<>();

    static {
        ToStringSerializer toStringSerializer = ToStringSerializer.instance;
        _serializers.put(Duration.class, toStringSerializer);
        _serializers.put(XMLGregorianCalendar.class, new XMLGregorianCalendarSerializer());
        _serializers.put(QName.class, toStringSerializer);
    }

    public Collection<Map.Entry<Class<?>, JsonSerializer<?>>> provide() {
        return _serializers.entrySet();
    }

    public static class XMLGregorianCalendarSerializer extends SerializerBase<XMLGregorianCalendar> {
        public XMLGregorianCalendarSerializer() {
            super(XMLGregorianCalendar.class);
        }

        public void serialize(XMLGregorianCalendar xMLGregorianCalendar, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            StdSerializers.CalendarSerializer.instance.serialize((Calendar) xMLGregorianCalendar.toGregorianCalendar(), jsonGenerator, serializerProvider);
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) throws JsonMappingException {
            return StdSerializers.CalendarSerializer.instance.getSchema(serializerProvider, type);
        }
    }
}
