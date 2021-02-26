package org.codehaus.jackson.map.ser;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.util.Provider;

public class JdkSerializers implements Provider<Map.Entry<Class<?>, Object>> {
    public Collection<Map.Entry<Class<?>, Object>> provide() {
        HashMap hashMap = new HashMap();
        ToStringSerializer toStringSerializer = ToStringSerializer.instance;
        hashMap.put(URL.class, toStringSerializer);
        hashMap.put(URI.class, toStringSerializer);
        hashMap.put(Currency.class, toStringSerializer);
        hashMap.put(UUID.class, toStringSerializer);
        hashMap.put(Pattern.class, toStringSerializer);
        hashMap.put(Locale.class, toStringSerializer);
        hashMap.put(Locale.class, toStringSerializer);
        hashMap.put(AtomicReference.class, AtomicReferenceSerializer.class);
        hashMap.put(AtomicBoolean.class, AtomicBooleanSerializer.class);
        hashMap.put(AtomicInteger.class, AtomicIntegerSerializer.class);
        hashMap.put(AtomicLong.class, AtomicLongSerializer.class);
        hashMap.put(File.class, FileSerializer.class);
        hashMap.put(Class.class, ClassSerializer.class);
        hashMap.put(Void.TYPE, NullSerializer.class);
        return hashMap.entrySet();
    }

    public static final class AtomicBooleanSerializer extends ScalarSerializerBase<AtomicBoolean> {
        public AtomicBooleanSerializer() {
            super(AtomicBoolean.class, false);
        }

        public void serialize(AtomicBoolean atomicBoolean, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            jsonGenerator.writeBoolean(atomicBoolean.get());
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("boolean", true);
        }
    }

    public static final class AtomicIntegerSerializer extends ScalarSerializerBase<AtomicInteger> {
        public AtomicIntegerSerializer() {
            super(AtomicInteger.class, false);
        }

        public void serialize(AtomicInteger atomicInteger, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            jsonGenerator.writeNumber(atomicInteger.get());
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("integer", true);
        }
    }

    public static final class AtomicLongSerializer extends ScalarSerializerBase<AtomicLong> {
        public AtomicLongSerializer() {
            super(AtomicLong.class, false);
        }

        public void serialize(AtomicLong atomicLong, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            jsonGenerator.writeNumber(atomicLong.get());
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("integer", true);
        }
    }

    public static final class AtomicReferenceSerializer extends SerializerBase<AtomicReference<?>> {
        public AtomicReferenceSerializer() {
            super(AtomicReference.class, false);
        }

        public void serialize(AtomicReference<?> atomicReference, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            serializerProvider.defaultSerializeValue(atomicReference.get(), jsonGenerator);
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("any", true);
        }
    }

    public static final class FileSerializer extends ScalarSerializerBase<File> {
        public FileSerializer() {
            super(File.class);
        }

        public void serialize(File file, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            jsonGenerator.writeString(file.getAbsolutePath());
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("string", true);
        }
    }

    public static final class ClassSerializer extends ScalarSerializerBase<Class> {
        public ClassSerializer() {
            super(Class.class);
        }

        public void serialize(Class cls, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
            jsonGenerator.writeString(cls.getName());
        }

        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("string", true);
        }
    }
}
