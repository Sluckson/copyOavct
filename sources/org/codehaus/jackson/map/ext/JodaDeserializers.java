package org.codehaus.jackson.map.ext;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.StdDeserializer;
import org.codehaus.jackson.map.deser.StdScalarDeserializer;
import org.codehaus.jackson.map.util.Provider;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.ReadableDateTime;
import org.joda.time.ReadableInstant;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class JodaDeserializers implements Provider<StdDeserializer<?>> {
    public Collection<StdDeserializer<?>> provide() {
        return Arrays.asList(new StdDeserializer[]{new DateTimeDeserializer(DateTime.class), new DateTimeDeserializer(ReadableDateTime.class), new DateTimeDeserializer(ReadableInstant.class), new LocalDateDeserializer(), new LocalDateTimeDeserializer(), new DateMidnightDeserializer()});
    }

    static abstract class JodaDeserializer<T> extends StdScalarDeserializer<T> {
        static final DateTimeFormatter _localDateTimeFormat = ISODateTimeFormat.localDateOptionalTimeParser();

        protected JodaDeserializer(Class<T> cls) {
            super(cls);
        }

        /* access modifiers changed from: protected */
        public DateTime parseLocal(JsonParser jsonParser) throws IOException, JsonProcessingException {
            String trim = jsonParser.getText().trim();
            if (trim.length() == 0) {
                return null;
            }
            return _localDateTimeFormat.parseDateTime(trim);
        }
    }

    public static class DateTimeDeserializer<T extends ReadableInstant> extends JodaDeserializer<T> {
        public DateTimeDeserializer(Class<T> cls) {
            super(cls);
        }

        public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            JsonToken currentToken = jsonParser.getCurrentToken();
            if (currentToken == JsonToken.VALUE_NUMBER_INT) {
                return new DateTime(jsonParser.getLongValue(), DateTimeZone.UTC);
            }
            if (currentToken == JsonToken.VALUE_STRING) {
                String trim = jsonParser.getText().trim();
                if (trim.length() == 0) {
                    return null;
                }
                return new DateTime(trim, DateTimeZone.UTC);
            }
            throw deserializationContext.mappingException(getValueClass());
        }
    }

    public static class LocalDateDeserializer extends JodaDeserializer<LocalDate> {
        public LocalDateDeserializer() {
            super(LocalDate.class);
        }

        public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (jsonParser.isExpectedStartArrayToken()) {
                jsonParser.nextToken();
                int intValue = jsonParser.getIntValue();
                jsonParser.nextToken();
                int intValue2 = jsonParser.getIntValue();
                jsonParser.nextToken();
                int intValue3 = jsonParser.getIntValue();
                if (jsonParser.nextToken() == JsonToken.END_ARRAY) {
                    return new LocalDate(intValue, intValue2, intValue3);
                }
                throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "after LocalDate ints");
            }
            int i = C49181.$SwitchMap$org$codehaus$jackson$JsonToken[jsonParser.getCurrentToken().ordinal()];
            if (i == 1) {
                return new LocalDate(jsonParser.getLongValue());
            }
            if (i == 2) {
                DateTime parseLocal = parseLocal(jsonParser);
                if (parseLocal == null) {
                    return null;
                }
                return parseLocal.toLocalDate();
            }
            throw deserializationContext.wrongTokenException(jsonParser, JsonToken.START_ARRAY, "expected JSON Array, String or Number");
        }
    }

    /* renamed from: org.codehaus.jackson.map.ext.JodaDeserializers$1 */
    static /* synthetic */ class C49181 {
        static final /* synthetic */ int[] $SwitchMap$org$codehaus$jackson$JsonToken = new int[JsonToken.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                org.codehaus.jackson.JsonToken[] r0 = org.codehaus.jackson.JsonToken.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$codehaus$jackson$JsonToken = r0
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0014 }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.VALUE_NUMBER_INT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x001f }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.VALUE_STRING     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.ext.JodaDeserializers.C49181.<clinit>():void");
        }
    }

    public static class LocalDateTimeDeserializer extends JodaDeserializer<LocalDateTime> {
        public LocalDateTimeDeserializer() {
            super(LocalDateTime.class);
        }

        public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            int i;
            if (jsonParser.isExpectedStartArrayToken()) {
                jsonParser.nextToken();
                int intValue = jsonParser.getIntValue();
                jsonParser.nextToken();
                int intValue2 = jsonParser.getIntValue();
                jsonParser.nextToken();
                int intValue3 = jsonParser.getIntValue();
                jsonParser.nextToken();
                int intValue4 = jsonParser.getIntValue();
                jsonParser.nextToken();
                int intValue5 = jsonParser.getIntValue();
                jsonParser.nextToken();
                int intValue6 = jsonParser.getIntValue();
                if (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                    int intValue7 = jsonParser.getIntValue();
                    jsonParser.nextToken();
                    i = intValue7;
                } else {
                    i = 0;
                }
                if (jsonParser.getCurrentToken() == JsonToken.END_ARRAY) {
                    return new LocalDateTime(intValue, intValue2, intValue3, intValue4, intValue5, intValue6, i);
                }
                throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "after LocalDateTime ints");
            }
            int i2 = C49181.$SwitchMap$org$codehaus$jackson$JsonToken[jsonParser.getCurrentToken().ordinal()];
            if (i2 == 1) {
                return new LocalDateTime(jsonParser.getLongValue());
            }
            if (i2 == 2) {
                DateTime parseLocal = parseLocal(jsonParser);
                if (parseLocal == null) {
                    return null;
                }
                return parseLocal.toLocalDateTime();
            }
            throw deserializationContext.wrongTokenException(jsonParser, JsonToken.START_ARRAY, "expected JSON Array or Number");
        }
    }

    public static class DateMidnightDeserializer extends JodaDeserializer<DateMidnight> {
        public DateMidnightDeserializer() {
            super(DateMidnight.class);
        }

        public DateMidnight deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (jsonParser.isExpectedStartArrayToken()) {
                jsonParser.nextToken();
                int intValue = jsonParser.getIntValue();
                jsonParser.nextToken();
                int intValue2 = jsonParser.getIntValue();
                jsonParser.nextToken();
                int intValue3 = jsonParser.getIntValue();
                if (jsonParser.nextToken() == JsonToken.END_ARRAY) {
                    return new DateMidnight(intValue, intValue2, intValue3);
                }
                throw deserializationContext.wrongTokenException(jsonParser, JsonToken.END_ARRAY, "after DateMidnight ints");
            }
            int i = C49181.$SwitchMap$org$codehaus$jackson$JsonToken[jsonParser.getCurrentToken().ordinal()];
            if (i == 1) {
                return new DateMidnight(jsonParser.getLongValue());
            }
            if (i == 2) {
                DateTime parseLocal = parseLocal(jsonParser);
                if (parseLocal == null) {
                    return null;
                }
                return parseLocal.toDateMidnight();
            }
            throw deserializationContext.wrongTokenException(jsonParser, JsonToken.START_ARRAY, "expected JSON Array, Number or String");
        }
    }
}
