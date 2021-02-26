package org.codehaus.jackson.map;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import org.codehaus.jackson.FormatSchema;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.PrettyPrinter;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.Versioned;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.p063io.SegmentedStringWriter;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.util.ByteArrayBuilder;
import org.codehaus.jackson.util.DefaultPrettyPrinter;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.codehaus.jackson.util.VersionUtil;

public class ObjectWriter implements Versioned {
    protected static final PrettyPrinter NULL_PRETTY_PRINTER = new MinimalPrettyPrinter();
    protected final SerializationConfig _config;
    protected final JsonFactory _jsonFactory;
    protected final PrettyPrinter _prettyPrinter;
    protected final SerializerProvider _provider;
    protected final JavaType _rootType;
    protected final FormatSchema _schema;
    protected final SerializerFactory _serializerFactory;

    protected ObjectWriter(ObjectMapper objectMapper, SerializationConfig serializationConfig, JavaType javaType, PrettyPrinter prettyPrinter) {
        this._config = serializationConfig;
        this._provider = objectMapper._serializerProvider;
        this._serializerFactory = objectMapper._serializerFactory;
        this._jsonFactory = objectMapper._jsonFactory;
        this._rootType = javaType;
        this._prettyPrinter = prettyPrinter;
        this._schema = null;
    }

    protected ObjectWriter(ObjectMapper objectMapper, SerializationConfig serializationConfig) {
        this._config = serializationConfig;
        this._provider = objectMapper._serializerProvider;
        this._serializerFactory = objectMapper._serializerFactory;
        this._jsonFactory = objectMapper._jsonFactory;
        this._rootType = null;
        this._prettyPrinter = null;
        this._schema = null;
    }

    protected ObjectWriter(ObjectMapper objectMapper, SerializationConfig serializationConfig, FormatSchema formatSchema) {
        this._config = serializationConfig;
        this._provider = objectMapper._serializerProvider;
        this._serializerFactory = objectMapper._serializerFactory;
        this._jsonFactory = objectMapper._jsonFactory;
        this._rootType = null;
        this._prettyPrinter = null;
        this._schema = formatSchema;
    }

    protected ObjectWriter(ObjectWriter objectWriter, SerializationConfig serializationConfig, JavaType javaType, PrettyPrinter prettyPrinter, FormatSchema formatSchema) {
        this._config = serializationConfig;
        this._provider = objectWriter._provider;
        this._serializerFactory = objectWriter._serializerFactory;
        this._jsonFactory = objectWriter._jsonFactory;
        this._rootType = javaType;
        this._prettyPrinter = prettyPrinter;
        this._schema = formatSchema;
    }

    protected ObjectWriter(ObjectWriter objectWriter, SerializationConfig serializationConfig) {
        this._config = serializationConfig;
        this._provider = objectWriter._provider;
        this._serializerFactory = objectWriter._serializerFactory;
        this._jsonFactory = objectWriter._jsonFactory;
        this._schema = objectWriter._schema;
        this._rootType = objectWriter._rootType;
        this._prettyPrinter = objectWriter._prettyPrinter;
    }

    public Version version() {
        return VersionUtil.versionFor(getClass());
    }

    public ObjectWriter withView(Class<?> cls) {
        if (cls == this._config.getSerializationView()) {
            return this;
        }
        return new ObjectWriter(this, this._config.withView(cls));
    }

    public ObjectWriter withType(JavaType javaType) {
        if (javaType == this._rootType) {
            return this;
        }
        return new ObjectWriter(this, this._config, javaType, this._prettyPrinter, this._schema);
    }

    public ObjectWriter withType(Class<?> cls) {
        return withType(this._config.constructType(cls));
    }

    public ObjectWriter withType(TypeReference<?> typeReference) {
        return withType(this._config.getTypeFactory().constructType(typeReference.getType()));
    }

    public ObjectWriter withPrettyPrinter(PrettyPrinter prettyPrinter) {
        if (prettyPrinter == this._prettyPrinter) {
            return this;
        }
        if (prettyPrinter == null) {
            prettyPrinter = NULL_PRETTY_PRINTER;
        }
        return new ObjectWriter(this, this._config, this._rootType, prettyPrinter, this._schema);
    }

    public ObjectWriter withDefaultPrettyPrinter() {
        return withPrettyPrinter(new DefaultPrettyPrinter());
    }

    public ObjectWriter withFilters(FilterProvider filterProvider) {
        if (filterProvider == this._config.getFilterProvider()) {
            return this;
        }
        return new ObjectWriter(this, this._config.withFilters(filterProvider));
    }

    public ObjectWriter withSchema(FormatSchema formatSchema) {
        if (this._schema == formatSchema) {
            return this;
        }
        return new ObjectWriter(this, this._config, this._rootType, this._prettyPrinter, formatSchema);
    }

    public void writeValue(JsonGenerator jsonGenerator, Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        if (!this._config.isEnabled(SerializationConfig.Feature.CLOSE_CLOSEABLE) || !(obj instanceof Closeable)) {
            JavaType javaType = this._rootType;
            if (javaType == null) {
                this._provider.serializeValue(this._config, jsonGenerator, obj, this._serializerFactory);
            } else {
                this._provider.serializeValue(this._config, jsonGenerator, obj, javaType, this._serializerFactory);
            }
            if (this._config.isEnabled(SerializationConfig.Feature.FLUSH_AFTER_WRITE_VALUE)) {
                jsonGenerator.flush();
                return;
            }
            return;
        }
        _writeCloseableValue(jsonGenerator, obj, this._config);
    }

    public void writeValue(File file, Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        _configAndWriteValue(this._jsonFactory.createJsonGenerator(file, JsonEncoding.UTF8), obj);
    }

    public void writeValue(OutputStream outputStream, Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        _configAndWriteValue(this._jsonFactory.createJsonGenerator(outputStream, JsonEncoding.UTF8), obj);
    }

    public void writeValue(Writer writer, Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        _configAndWriteValue(this._jsonFactory.createJsonGenerator(writer), obj);
    }

    public String writeValueAsString(Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        SegmentedStringWriter segmentedStringWriter = new SegmentedStringWriter(this._jsonFactory._getBufferRecycler());
        _configAndWriteValue(this._jsonFactory.createJsonGenerator((Writer) segmentedStringWriter), obj);
        return segmentedStringWriter.getAndClear();
    }

    public byte[] writeValueAsBytes(Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder(this._jsonFactory._getBufferRecycler());
        _configAndWriteValue(this._jsonFactory.createJsonGenerator((OutputStream) byteArrayBuilder, JsonEncoding.UTF8), obj);
        byte[] byteArray = byteArrayBuilder.toByteArray();
        byteArrayBuilder.release();
        return byteArray;
    }

    public boolean canSerialize(Class<?> cls) {
        return this._provider.hasSerializerFor(this._config, cls, this._serializerFactory);
    }

    /* access modifiers changed from: protected */
    public final void _configAndWriteValue(JsonGenerator jsonGenerator, Object obj) throws IOException, JsonGenerationException, JsonMappingException {
        PrettyPrinter prettyPrinter = this._prettyPrinter;
        if (prettyPrinter != null) {
            if (prettyPrinter == NULL_PRETTY_PRINTER) {
                prettyPrinter = null;
            }
            jsonGenerator.setPrettyPrinter(prettyPrinter);
        } else if (this._config.isEnabled(SerializationConfig.Feature.INDENT_OUTPUT)) {
            jsonGenerator.useDefaultPrettyPrinter();
        }
        FormatSchema formatSchema = this._schema;
        if (formatSchema != null) {
            jsonGenerator.setSchema(formatSchema);
        }
        if (!this._config.isEnabled(SerializationConfig.Feature.CLOSE_CLOSEABLE) || !(obj instanceof Closeable)) {
            try {
                if (this._rootType == null) {
                    this._provider.serializeValue(this._config, jsonGenerator, obj, this._serializerFactory);
                } else {
                    this._provider.serializeValue(this._config, jsonGenerator, obj, this._rootType, this._serializerFactory);
                }
                jsonGenerator.close();
            } catch (Throwable th) {
                if (0 == 0) {
                    try {
                        jsonGenerator.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
        } else {
            _configAndWriteCloseable(jsonGenerator, obj, this._config);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0036 A[SYNTHETIC, Splitter:B:20:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003d A[SYNTHETIC, Splitter:B:24:0x003d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void _configAndWriteCloseable(org.codehaus.jackson.JsonGenerator r9, java.lang.Object r10, org.codehaus.jackson.map.SerializationConfig r11) throws java.io.IOException, org.codehaus.jackson.JsonGenerationException, org.codehaus.jackson.map.JsonMappingException {
        /*
            r8 = this;
            r0 = r10
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = 0
            org.codehaus.jackson.type.JavaType r2 = r8._rootType     // Catch:{ all -> 0x0033 }
            if (r2 != 0) goto L_0x0010
            org.codehaus.jackson.map.SerializerProvider r2 = r8._provider     // Catch:{ all -> 0x0033 }
            org.codehaus.jackson.map.SerializerFactory r3 = r8._serializerFactory     // Catch:{ all -> 0x0033 }
            r2.serializeValue(r11, r9, r10, r3)     // Catch:{ all -> 0x0033 }
            goto L_0x001c
        L_0x0010:
            org.codehaus.jackson.map.SerializerProvider r2 = r8._provider     // Catch:{ all -> 0x0033 }
            org.codehaus.jackson.type.JavaType r6 = r8._rootType     // Catch:{ all -> 0x0033 }
            org.codehaus.jackson.map.SerializerFactory r7 = r8._serializerFactory     // Catch:{ all -> 0x0033 }
            r3 = r11
            r4 = r9
            r5 = r10
            r2.serializeValue(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0033 }
        L_0x001c:
            org.codehaus.jackson.FormatSchema r10 = r8._schema     // Catch:{ all -> 0x0033 }
            if (r10 == 0) goto L_0x0025
            org.codehaus.jackson.FormatSchema r10 = r8._schema     // Catch:{ all -> 0x0033 }
            r9.setSchema(r10)     // Catch:{ all -> 0x0033 }
        L_0x0025:
            r9.close()     // Catch:{ all -> 0x0030 }
            r0.close()     // Catch:{ all -> 0x002c }
            return
        L_0x002c:
            r10 = move-exception
            r9 = r1
            r0 = r9
            goto L_0x0034
        L_0x0030:
            r10 = move-exception
            r9 = r1
            goto L_0x0034
        L_0x0033:
            r10 = move-exception
        L_0x0034:
            if (r9 == 0) goto L_0x003b
            r9.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x003b
        L_0x003a:
        L_0x003b:
            if (r0 == 0) goto L_0x0040
            r0.close()     // Catch:{ IOException -> 0x0040 }
        L_0x0040:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.ObjectWriter._configAndWriteCloseable(org.codehaus.jackson.JsonGenerator, java.lang.Object, org.codehaus.jackson.map.SerializationConfig):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0034 A[SYNTHETIC, Splitter:B:17:0x0034] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void _writeCloseableValue(org.codehaus.jackson.JsonGenerator r8, java.lang.Object r9, org.codehaus.jackson.map.SerializationConfig r10) throws java.io.IOException, org.codehaus.jackson.JsonGenerationException, org.codehaus.jackson.map.JsonMappingException {
        /*
            r7 = this;
            r0 = r9
            java.io.Closeable r0 = (java.io.Closeable) r0
            org.codehaus.jackson.type.JavaType r1 = r7._rootType     // Catch:{ all -> 0x0031 }
            if (r1 != 0) goto L_0x000f
            org.codehaus.jackson.map.SerializerProvider r1 = r7._provider     // Catch:{ all -> 0x0031 }
            org.codehaus.jackson.map.SerializerFactory r2 = r7._serializerFactory     // Catch:{ all -> 0x0031 }
            r1.serializeValue(r10, r8, r9, r2)     // Catch:{ all -> 0x0031 }
            goto L_0x001b
        L_0x000f:
            org.codehaus.jackson.map.SerializerProvider r1 = r7._provider     // Catch:{ all -> 0x0031 }
            org.codehaus.jackson.type.JavaType r5 = r7._rootType     // Catch:{ all -> 0x0031 }
            org.codehaus.jackson.map.SerializerFactory r6 = r7._serializerFactory     // Catch:{ all -> 0x0031 }
            r2 = r10
            r3 = r8
            r4 = r9
            r1.serializeValue(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0031 }
        L_0x001b:
            org.codehaus.jackson.map.SerializationConfig r9 = r7._config     // Catch:{ all -> 0x0031 }
            org.codehaus.jackson.map.SerializationConfig$Feature r10 = org.codehaus.jackson.map.SerializationConfig.Feature.FLUSH_AFTER_WRITE_VALUE     // Catch:{ all -> 0x0031 }
            boolean r9 = r9.isEnabled(r10)     // Catch:{ all -> 0x0031 }
            if (r9 == 0) goto L_0x0028
            r8.flush()     // Catch:{ all -> 0x0031 }
        L_0x0028:
            r8 = 0
            r0.close()     // Catch:{ all -> 0x002d }
            return
        L_0x002d:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto L_0x0032
        L_0x0031:
            r8 = move-exception
        L_0x0032:
            if (r0 == 0) goto L_0x0037
            r0.close()     // Catch:{ IOException -> 0x0037 }
        L_0x0037:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.ObjectWriter._writeCloseableValue(org.codehaus.jackson.JsonGenerator, java.lang.Object, org.codehaus.jackson.map.SerializationConfig):void");
    }
}
