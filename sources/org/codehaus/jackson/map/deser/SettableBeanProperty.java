package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import org.codehaus.jackson.JsonLocation;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.AnnotatedParameter;
import org.codehaus.jackson.map.util.Annotations;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.util.InternCache;

public abstract class SettableBeanProperty implements BeanProperty {
    protected final Annotations _contextAnnotations;
    protected String _managedReferenceName;
    protected NullProvider _nullProvider;
    protected final String _propName;
    protected int _propertyIndex = -1;
    protected final JavaType _type;
    protected JsonDeserializer<Object> _valueDeserializer;
    protected TypeDeserializer _valueTypeDeserializer;

    public abstract void deserializeAndSet(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException, JsonProcessingException;

    public abstract <A extends Annotation> A getAnnotation(Class<A> cls);

    public int getCreatorIndex() {
        return -1;
    }

    public abstract AnnotatedMember getMember();

    public abstract void set(Object obj, Object obj2) throws IOException;

    protected SettableBeanProperty(String str, JavaType javaType, TypeDeserializer typeDeserializer, Annotations annotations) {
        if (str == null || str.length() == 0) {
            this._propName = "";
        } else {
            this._propName = InternCache.instance.intern(str);
        }
        this._type = javaType;
        this._contextAnnotations = annotations;
        this._valueTypeDeserializer = typeDeserializer;
    }

    protected SettableBeanProperty(SettableBeanProperty settableBeanProperty) {
        this._propName = settableBeanProperty._propName;
        this._type = settableBeanProperty._type;
        this._contextAnnotations = settableBeanProperty._contextAnnotations;
        this._valueDeserializer = settableBeanProperty._valueDeserializer;
        this._valueTypeDeserializer = settableBeanProperty._valueTypeDeserializer;
        this._nullProvider = settableBeanProperty._nullProvider;
        this._managedReferenceName = settableBeanProperty._managedReferenceName;
        this._propertyIndex = settableBeanProperty._propertyIndex;
    }

    public void setValueDeserializer(JsonDeserializer<Object> jsonDeserializer) {
        NullProvider nullProvider;
        if (this._valueDeserializer == null) {
            this._valueDeserializer = jsonDeserializer;
            Object nullValue = this._valueDeserializer.getNullValue();
            if (nullValue == null) {
                nullProvider = null;
            } else {
                nullProvider = new NullProvider(this._type, nullValue);
            }
            this._nullProvider = nullProvider;
            return;
        }
        throw new IllegalStateException("Already had assigned deserializer for property '" + getName() + "' (class " + getDeclaringClass().getName() + ")");
    }

    public void setManagedReferenceName(String str) {
        this._managedReferenceName = str;
    }

    public void assignIndex(int i) {
        if (this._propertyIndex == -1) {
            this._propertyIndex = i;
            return;
        }
        throw new IllegalStateException("Property '" + getName() + "' already had index (" + this._propertyIndex + "), trying to assign " + i);
    }

    public final String getName() {
        return this._propName;
    }

    public JavaType getType() {
        return this._type;
    }

    public <A extends Annotation> A getContextAnnotation(Class<A> cls) {
        return this._contextAnnotations.get(cls);
    }

    /* access modifiers changed from: protected */
    public final Class<?> getDeclaringClass() {
        return getMember().getDeclaringClass();
    }

    @Deprecated
    public String getPropertyName() {
        return this._propName;
    }

    public String getManagedReferenceName() {
        return this._managedReferenceName;
    }

    public boolean hasValueDeserializer() {
        return this._valueDeserializer != null;
    }

    public JsonDeserializer<Object> getValueDeserializer() {
        return this._valueDeserializer;
    }

    public int getProperytIndex() {
        return this._propertyIndex;
    }

    public final Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if (jsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {
            NullProvider nullProvider = this._nullProvider;
            if (nullProvider == null) {
                return null;
            }
            return nullProvider.nullValue(deserializationContext);
        }
        TypeDeserializer typeDeserializer = this._valueTypeDeserializer;
        if (typeDeserializer != null) {
            return this._valueDeserializer.deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
        }
        return this._valueDeserializer.deserialize(jsonParser, deserializationContext);
    }

    /* access modifiers changed from: protected */
    public void _throwAsIOE(Exception exc, Object obj) throws IOException {
        String str;
        if (exc instanceof IllegalArgumentException) {
            if (obj == null) {
                str = "[NULL]";
            } else {
                str = obj.getClass().getName();
            }
            StringBuilder sb = new StringBuilder("Problem deserializing property '");
            sb.append(getPropertyName());
            sb.append("' (expected type: ");
            sb.append(getType());
            sb.append("; actual type: ");
            sb.append(str);
            sb.append(")");
            String message = exc.getMessage();
            if (message != null) {
                sb.append(", problem: ");
                sb.append(message);
            } else {
                sb.append(" (no error message provided)");
            }
            throw new JsonMappingException(sb.toString(), (JsonLocation) null, exc);
        }
        _throwAsIOE(exc);
    }

    /* access modifiers changed from: protected */
    public IOException _throwAsIOE(Exception exc) throws IOException {
        if (!(exc instanceof IOException)) {
            boolean z = exc instanceof RuntimeException;
            Throwable th = exc;
            if (!z) {
                while (th.getCause() != null) {
                    th = th.getCause();
                }
                throw new JsonMappingException(th.getMessage(), (JsonLocation) null, th);
            }
            throw ((RuntimeException) exc);
        }
        throw ((IOException) exc);
    }

    public String toString() {
        return "[property '" + getName() + "']";
    }

    public static final class MethodProperty extends SettableBeanProperty {
        protected final AnnotatedMethod _annotated;
        protected final Method _setter;

        public MethodProperty(String str, JavaType javaType, TypeDeserializer typeDeserializer, Annotations annotations, AnnotatedMethod annotatedMethod) {
            super(str, javaType, typeDeserializer, annotations);
            this._annotated = annotatedMethod;
            this._setter = annotatedMethod.getAnnotated();
        }

        public <A extends Annotation> A getAnnotation(Class<A> cls) {
            return this._annotated.getAnnotation(cls);
        }

        public AnnotatedMember getMember() {
            return this._annotated;
        }

        public void deserializeAndSet(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException, JsonProcessingException {
            set(obj, deserialize(jsonParser, deserializationContext));
        }

        public final void set(Object obj, Object obj2) throws IOException {
            try {
                this._setter.invoke(obj, new Object[]{obj2});
            } catch (Exception e) {
                _throwAsIOE(e, obj2);
            }
        }
    }

    public static final class SetterlessProperty extends SettableBeanProperty {
        protected final AnnotatedMethod _annotated;
        protected final Method _getter;

        public SetterlessProperty(String str, JavaType javaType, TypeDeserializer typeDeserializer, Annotations annotations, AnnotatedMethod annotatedMethod) {
            super(str, javaType, typeDeserializer, annotations);
            this._annotated = annotatedMethod;
            this._getter = annotatedMethod.getAnnotated();
        }

        public <A extends Annotation> A getAnnotation(Class<A> cls) {
            return this._annotated.getAnnotation(cls);
        }

        public AnnotatedMember getMember() {
            return this._annotated;
        }

        public final void deserializeAndSet(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException, JsonProcessingException {
            if (jsonParser.getCurrentToken() != JsonToken.VALUE_NULL) {
                try {
                    Object invoke = this._getter.invoke(obj, new Object[0]);
                    if (invoke != null) {
                        this._valueDeserializer.deserialize(jsonParser, deserializationContext, invoke);
                        return;
                    }
                    throw new JsonMappingException("Problem deserializing 'setterless' property '" + getName() + "': get method returned null");
                } catch (Exception e) {
                    _throwAsIOE(e);
                }
            }
        }

        public final void set(Object obj, Object obj2) throws IOException {
            throw new UnsupportedOperationException("Should never call 'set' on setterless property");
        }
    }

    public static final class FieldProperty extends SettableBeanProperty {
        protected final AnnotatedField _annotated;
        protected final Field _field;

        public FieldProperty(String str, JavaType javaType, TypeDeserializer typeDeserializer, Annotations annotations, AnnotatedField annotatedField) {
            super(str, javaType, typeDeserializer, annotations);
            this._annotated = annotatedField;
            this._field = annotatedField.getAnnotated();
        }

        public <A extends Annotation> A getAnnotation(Class<A> cls) {
            return this._annotated.getAnnotation(cls);
        }

        public AnnotatedMember getMember() {
            return this._annotated;
        }

        public void deserializeAndSet(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException, JsonProcessingException {
            set(obj, deserialize(jsonParser, deserializationContext));
        }

        public final void set(Object obj, Object obj2) throws IOException {
            try {
                this._field.set(obj, obj2);
            } catch (Exception e) {
                _throwAsIOE(e, obj2);
            }
        }
    }

    public static final class CreatorProperty extends SettableBeanProperty {
        protected final AnnotatedParameter _annotated;
        protected final int _index;

        public void set(Object obj, Object obj2) throws IOException {
        }

        public CreatorProperty(String str, JavaType javaType, TypeDeserializer typeDeserializer, Annotations annotations, AnnotatedParameter annotatedParameter, int i) {
            super(str, javaType, typeDeserializer, annotations);
            this._annotated = annotatedParameter;
            this._index = i;
        }

        public <A extends Annotation> A getAnnotation(Class<A> cls) {
            return this._annotated.getAnnotation(cls);
        }

        public AnnotatedMember getMember() {
            return this._annotated;
        }

        public int getCreatorIndex() {
            return this._index;
        }

        public void deserializeAndSet(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException, JsonProcessingException {
            set(obj, deserialize(jsonParser, deserializationContext));
        }
    }

    public static final class ManagedReferenceProperty extends SettableBeanProperty {
        protected final SettableBeanProperty _backProperty;
        protected final boolean _isContainer;
        protected final SettableBeanProperty _managedProperty;
        protected final String _referenceName;

        public ManagedReferenceProperty(String str, SettableBeanProperty settableBeanProperty, SettableBeanProperty settableBeanProperty2, Annotations annotations, boolean z) {
            super(settableBeanProperty.getName(), settableBeanProperty.getType(), settableBeanProperty._valueTypeDeserializer, annotations);
            this._referenceName = str;
            this._managedProperty = settableBeanProperty;
            this._backProperty = settableBeanProperty2;
            this._isContainer = z;
        }

        public <A extends Annotation> A getAnnotation(Class<A> cls) {
            return this._managedProperty.getAnnotation(cls);
        }

        public AnnotatedMember getMember() {
            return this._managedProperty.getMember();
        }

        public void deserializeAndSet(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException, JsonProcessingException {
            set(obj, this._managedProperty.deserialize(jsonParser, deserializationContext));
        }

        public final void set(Object obj, Object obj2) throws IOException {
            this._managedProperty.set(obj, obj2);
            if (obj2 == null) {
                return;
            }
            if (!this._isContainer) {
                this._backProperty.set(obj2, obj);
            } else if (obj2 instanceof Object[]) {
                for (Object obj3 : (Object[]) obj2) {
                    if (obj3 != null) {
                        this._backProperty.set(obj3, obj);
                    }
                }
            } else if (obj2 instanceof Collection) {
                for (Object next : (Collection) obj2) {
                    if (next != null) {
                        this._backProperty.set(next, obj);
                    }
                }
            } else if (obj2 instanceof Map) {
                for (Object next2 : ((Map) obj2).values()) {
                    if (next2 != null) {
                        this._backProperty.set(next2, obj);
                    }
                }
            } else {
                throw new IllegalStateException("Unsupported container type (" + obj2.getClass().getName() + ") when resolving reference '" + this._referenceName + "'");
            }
        }
    }

    protected static final class NullProvider {
        private final boolean _isPrimitive;
        private final Object _nullValue;
        private final Class<?> _rawType;

        protected NullProvider(JavaType javaType, Object obj) {
            this._nullValue = obj;
            this._isPrimitive = javaType.isPrimitive();
            this._rawType = javaType.getRawClass();
        }

        public Object nullValue(DeserializationContext deserializationContext) throws JsonProcessingException {
            if (!this._isPrimitive || !deserializationContext.isEnabled(DeserializationConfig.Feature.FAIL_ON_NULL_FOR_PRIMITIVES)) {
                return this._nullValue;
            }
            throw deserializationContext.mappingException("Can not map JSON null into type " + this._rawType.getName() + " (set DeserializationConfig.Feature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)");
        }
    }
}
