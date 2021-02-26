package org.codehaus.jackson.map.deser;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;

public abstract class FromStringDeserializer<T> extends StdScalarDeserializer<T> {
    /* access modifiers changed from: protected */
    public abstract T _deserialize(String str, DeserializationContext deserializationContext) throws IOException, JsonProcessingException;

    protected FromStringDeserializer(Class<?> cls) {
        super(cls);
    }

    public static Iterable<FromStringDeserializer<?>> all() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UUIDDeserializer());
        arrayList.add(new URLDeserializer());
        arrayList.add(new URIDeserializer());
        arrayList.add(new CurrencyDeserializer());
        arrayList.add(new PatternDeserializer());
        arrayList.add(new LocaleDeserializer());
        arrayList.add(new InetAddressDeserializer());
        arrayList.add(new TimeZoneDeserializer());
        return arrayList;
    }

    public final T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
            String trim = jsonParser.getText().trim();
            if (trim.length() == 0) {
                return null;
            }
            try {
                T _deserialize = _deserialize(trim, deserializationContext);
                if (_deserialize != null) {
                    return _deserialize;
                }
            } catch (IllegalArgumentException unused) {
            }
            throw deserializationContext.weirdStringException(this._valueClass, "not a valid textual representation");
        } else if (jsonParser.getCurrentToken() == JsonToken.VALUE_EMBEDDED_OBJECT) {
            T embeddedObject = jsonParser.getEmbeddedObject();
            if (embeddedObject == null) {
                return null;
            }
            if (this._valueClass.isAssignableFrom(embeddedObject.getClass())) {
                return embeddedObject;
            }
            return _deserializeEmbedded(embeddedObject, deserializationContext);
        } else {
            throw deserializationContext.mappingException((Class<?>) this._valueClass);
        }
    }

    /* access modifiers changed from: protected */
    public T _deserializeEmbedded(Object obj, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        throw deserializationContext.mappingException("Don't know how to convert embedded Object of type " + obj.getClass().getName() + " into " + this._valueClass.getName());
    }

    public static class UUIDDeserializer extends FromStringDeserializer<UUID> {
        public UUIDDeserializer() {
            super(UUID.class);
        }

        /* access modifiers changed from: protected */
        public UUID _deserialize(String str, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return UUID.fromString(str);
        }

        /* access modifiers changed from: protected */
        public UUID _deserializeEmbedded(Object obj, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                if (bArr.length != 16) {
                    deserializationContext.mappingException("Can only construct UUIDs from 16 byte arrays; got " + bArr.length + " bytes");
                }
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
                return new UUID(dataInputStream.readLong(), dataInputStream.readLong());
            }
            FromStringDeserializer.super._deserializeEmbedded(obj, deserializationContext);
            return null;
        }
    }

    public static class URLDeserializer extends FromStringDeserializer<URL> {
        public URLDeserializer() {
            super(URL.class);
        }

        /* access modifiers changed from: protected */
        public URL _deserialize(String str, DeserializationContext deserializationContext) throws IOException {
            return new URL(str);
        }
    }

    public static class URIDeserializer extends FromStringDeserializer<URI> {
        public URIDeserializer() {
            super(URI.class);
        }

        /* access modifiers changed from: protected */
        public URI _deserialize(String str, DeserializationContext deserializationContext) throws IllegalArgumentException {
            return URI.create(str);
        }
    }

    public static class CurrencyDeserializer extends FromStringDeserializer<Currency> {
        public CurrencyDeserializer() {
            super(Currency.class);
        }

        /* access modifiers changed from: protected */
        public Currency _deserialize(String str, DeserializationContext deserializationContext) throws IllegalArgumentException {
            return Currency.getInstance(str);
        }
    }

    public static class PatternDeserializer extends FromStringDeserializer<Pattern> {
        public PatternDeserializer() {
            super(Pattern.class);
        }

        /* access modifiers changed from: protected */
        public Pattern _deserialize(String str, DeserializationContext deserializationContext) throws IllegalArgumentException {
            return Pattern.compile(str);
        }
    }

    protected static class LocaleDeserializer extends FromStringDeserializer<Locale> {
        public LocaleDeserializer() {
            super(Locale.class);
        }

        /* access modifiers changed from: protected */
        public Locale _deserialize(String str, DeserializationContext deserializationContext) throws IOException {
            int indexOf = str.indexOf(95);
            if (indexOf < 0) {
                return new Locale(str);
            }
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + 1);
            int indexOf2 = substring2.indexOf(95);
            if (indexOf2 < 0) {
                return new Locale(substring, substring2);
            }
            return new Locale(substring, substring2.substring(0, indexOf2), substring2.substring(indexOf2 + 1));
        }
    }

    protected static class InetAddressDeserializer extends FromStringDeserializer<InetAddress> {
        public InetAddressDeserializer() {
            super(InetAddress.class);
        }

        /* access modifiers changed from: protected */
        public InetAddress _deserialize(String str, DeserializationContext deserializationContext) throws IOException {
            return InetAddress.getByName(str);
        }
    }

    protected static class TimeZoneDeserializer extends FromStringDeserializer<TimeZone> {
        public TimeZoneDeserializer() {
            super(TimeZone.class);
        }

        /* access modifiers changed from: protected */
        public TimeZone _deserialize(String str, DeserializationContext deserializationContext) throws IOException {
            return TimeZone.getTimeZone(str);
        }
    }
}
