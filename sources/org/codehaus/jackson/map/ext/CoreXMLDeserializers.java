package org.codehaus.jackson.map.ext;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.FromStringDeserializer;
import org.codehaus.jackson.map.deser.StdDeserializer;
import org.codehaus.jackson.map.deser.StdScalarDeserializer;
import org.codehaus.jackson.map.util.Provider;

public class CoreXMLDeserializers implements Provider<StdDeserializer<?>> {
    static final DatatypeFactory _dataTypeFactory;

    static {
        try {
            _dataTypeFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public Collection<StdDeserializer<?>> provide() {
        return Arrays.asList(new StdDeserializer[]{new DurationDeserializer(), new GregorianCalendarDeserializer(), new QNameDeserializer()});
    }

    public static class DurationDeserializer extends FromStringDeserializer<Duration> {
        public DurationDeserializer() {
            super(Duration.class);
        }

        /* access modifiers changed from: protected */
        public Duration _deserialize(String str, DeserializationContext deserializationContext) throws IllegalArgumentException {
            return CoreXMLDeserializers._dataTypeFactory.newDuration(str);
        }
    }

    public static class GregorianCalendarDeserializer extends StdScalarDeserializer<XMLGregorianCalendar> {
        public GregorianCalendarDeserializer() {
            super(XMLGregorianCalendar.class);
        }

        public XMLGregorianCalendar deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Date _parseDate = _parseDate(jsonParser, deserializationContext);
            if (_parseDate == null) {
                return null;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(_parseDate);
            return CoreXMLDeserializers._dataTypeFactory.newXMLGregorianCalendar(gregorianCalendar);
        }
    }

    public static class QNameDeserializer extends FromStringDeserializer<QName> {
        public QNameDeserializer() {
            super(QName.class);
        }

        /* access modifiers changed from: protected */
        public QName _deserialize(String str, DeserializationContext deserializationContext) throws IllegalArgumentException {
            return QName.valueOf(str);
        }
    }
}
