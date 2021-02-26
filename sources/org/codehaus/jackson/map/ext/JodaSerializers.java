package org.codehaus.jackson.map.ext;

import com.lowagie.text.ElementTags;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.SerializerBase;
import org.codehaus.jackson.map.util.Provider;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class JodaSerializers implements Provider<Map.Entry<Class<?>, JsonSerializer<?>>> {
    static final HashMap<Class<?>, JsonSerializer<?>> _serializers = new HashMap<>();

    static {
        _serializers.put(DateTime.class, new DateTimeSerializer());
        _serializers.put(LocalDateTime.class, new LocalDateTimeSerializer());
        _serializers.put(LocalDate.class, new LocalDateSerializer());
        _serializers.put(DateMidnight.class, new DateMidnightSerializer());
    }

    public Collection<Map.Entry<Class<?>, JsonSerializer<?>>> provide() {
        return _serializers.entrySet();
    }

    protected static abstract class JodaSerializer<T> extends SerializerBase<T> {
        static final DateTimeFormatter _localDateFormat = ISODateTimeFormat.date();
        static final DateTimeFormatter _localDateTimeFormat = ISODateTimeFormat.dateTime();

        protected JodaSerializer(Class<T> cls) {
            super(cls);
        }

        /* access modifiers changed from: protected */
        public String printLocalDateTime(ReadablePartial readablePartial) throws IOException, JsonProcessingException {
            return _localDateTimeFormat.print(readablePartial);
        }

        /* access modifiers changed from: protected */
        public String printLocalDate(ReadablePartial readablePartial) throws IOException, JsonProcessingException {
            return _localDateFormat.print(readablePartial);
        }

        /* access modifiers changed from: protected */
        public String printLocalDate(ReadableInstant readableInstant) throws IOException, JsonProcessingException {
            return _localDateFormat.print(readableInstant);
        }
    }

    public static final class DateTimeSerializer extends JodaSerializer<DateTime> {
        public DateTimeSerializer() {
            super(DateTime.class);
        }

        public void serialize(DateTime dateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            if (serializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS)) {
                jsonGenerator.writeNumber(dateTime.getMillis());
            } else {
                jsonGenerator.writeString(dateTime.toString());
            }
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode(serializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS) ? ElementTags.NUMBER : "string", true);
        }
    }

    public static final class LocalDateTimeSerializer extends JodaSerializer<LocalDateTime> {
        public LocalDateTimeSerializer() {
            super(LocalDateTime.class);
        }

        public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            if (serializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS)) {
                jsonGenerator.writeStartArray();
                jsonGenerator.writeNumber(localDateTime.year().get());
                jsonGenerator.writeNumber(localDateTime.monthOfYear().get());
                jsonGenerator.writeNumber(localDateTime.dayOfMonth().get());
                jsonGenerator.writeNumber(localDateTime.hourOfDay().get());
                jsonGenerator.writeNumber(localDateTime.minuteOfHour().get());
                jsonGenerator.writeNumber(localDateTime.secondOfMinute().get());
                jsonGenerator.writeNumber(localDateTime.millisOfSecond().get());
                jsonGenerator.writeEndArray();
                return;
            }
            jsonGenerator.writeString(printLocalDateTime(localDateTime));
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode(serializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS) ? "array" : "string", true);
        }
    }

    public static final class LocalDateSerializer extends JodaSerializer<LocalDate> {
        public LocalDateSerializer() {
            super(LocalDate.class);
        }

        public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            if (serializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS)) {
                jsonGenerator.writeStartArray();
                jsonGenerator.writeNumber(localDate.year().get());
                jsonGenerator.writeNumber(localDate.monthOfYear().get());
                jsonGenerator.writeNumber(localDate.dayOfMonth().get());
                jsonGenerator.writeEndArray();
                return;
            }
            jsonGenerator.writeString(printLocalDate((ReadablePartial) localDate));
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode(serializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS) ? "array" : "string", true);
        }
    }

    public static final class DateMidnightSerializer extends JodaSerializer<DateMidnight> {
        public DateMidnightSerializer() {
            super(DateMidnight.class);
        }

        public void serialize(DateMidnight dateMidnight, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            if (serializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS)) {
                jsonGenerator.writeStartArray();
                jsonGenerator.writeNumber(dateMidnight.year().get());
                jsonGenerator.writeNumber(dateMidnight.monthOfYear().get());
                jsonGenerator.writeNumber(dateMidnight.dayOfMonth().get());
                jsonGenerator.writeEndArray();
                return;
            }
            jsonGenerator.writeString(printLocalDate((ReadableInstant) dateMidnight));
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode(serializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS) ? "array" : "string", true);
        }
    }
}
