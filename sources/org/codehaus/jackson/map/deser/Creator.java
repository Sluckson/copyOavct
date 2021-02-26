package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.type.TypeBindings;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

abstract class Creator {
    private Creator() {
    }

    static final class StringBased {
        protected final Constructor<?> _ctor;
        protected final Method _factoryMethod;
        protected final Class<?> _valueClass;

        public StringBased(Class<?> cls, AnnotatedConstructor annotatedConstructor, AnnotatedMethod annotatedMethod) {
            Constructor<?> constructor;
            this._valueClass = cls;
            Method method = null;
            if (annotatedConstructor == null) {
                constructor = null;
            } else {
                constructor = annotatedConstructor.getAnnotated();
            }
            this._ctor = constructor;
            this._factoryMethod = annotatedMethod != null ? annotatedMethod.getAnnotated() : method;
        }

        public Object construct(String str) {
            try {
                if (this._ctor != null) {
                    return this._ctor.newInstance(new Object[]{str});
                } else if (this._factoryMethod == null) {
                    return null;
                } else {
                    return this._factoryMethod.invoke(this._valueClass, new Object[]{str});
                }
            } catch (Exception e) {
                ClassUtil.unwrapAndThrowAsIAE(e);
                return null;
            }
        }
    }

    static final class NumberBased {
        protected final Constructor<?> _intCtor;
        protected final Method _intFactoryMethod;
        protected final Constructor<?> _longCtor;
        protected final Method _longFactoryMethod;
        protected final Class<?> _valueClass;

        public NumberBased(Class<?> cls, AnnotatedConstructor annotatedConstructor, AnnotatedMethod annotatedMethod, AnnotatedConstructor annotatedConstructor2, AnnotatedMethod annotatedMethod2) {
            Constructor<?> constructor;
            Constructor<?> constructor2;
            Method method;
            this._valueClass = cls;
            Method method2 = null;
            if (annotatedConstructor == null) {
                constructor = null;
            } else {
                constructor = annotatedConstructor.getAnnotated();
            }
            this._intCtor = constructor;
            if (annotatedConstructor2 == null) {
                constructor2 = null;
            } else {
                constructor2 = annotatedConstructor2.getAnnotated();
            }
            this._longCtor = constructor2;
            if (annotatedMethod == null) {
                method = null;
            } else {
                method = annotatedMethod.getAnnotated();
            }
            this._intFactoryMethod = method;
            this._longFactoryMethod = annotatedMethod2 != null ? annotatedMethod2.getAnnotated() : method2;
        }

        public Object construct(int i) {
            try {
                if (this._intCtor != null) {
                    return this._intCtor.newInstance(new Object[]{Integer.valueOf(i)});
                }
                if (this._intFactoryMethod != null) {
                    return this._intFactoryMethod.invoke(this._valueClass, new Object[]{Integer.valueOf(i)});
                }
                return construct((long) i);
            } catch (Exception e) {
                ClassUtil.unwrapAndThrowAsIAE(e);
            }
        }

        public Object construct(long j) {
            try {
                if (this._longCtor != null) {
                    return this._longCtor.newInstance(new Object[]{Long.valueOf(j)});
                } else if (this._longFactoryMethod == null) {
                    return null;
                } else {
                    return this._longFactoryMethod.invoke(this._valueClass, new Object[]{Long.valueOf(j)});
                }
            } catch (Exception e) {
                ClassUtil.unwrapAndThrowAsIAE(e);
                return null;
            }
        }
    }

    static final class Delegating {
        protected final AnnotatedMember _creator;
        protected final Constructor<?> _ctor;
        protected JsonDeserializer<Object> _deserializer;
        protected final Method _factoryMethod;
        protected final JavaType _valueType;

        public Delegating(BasicBeanDescription basicBeanDescription, AnnotatedConstructor annotatedConstructor, AnnotatedMethod annotatedMethod) {
            TypeBindings bindingsForBeanType = basicBeanDescription.bindingsForBeanType();
            if (annotatedConstructor != null) {
                this._creator = annotatedConstructor;
                this._ctor = annotatedConstructor.getAnnotated();
                this._factoryMethod = null;
                this._valueType = bindingsForBeanType.resolveType(annotatedConstructor.getParameterType(0));
            } else if (annotatedMethod != null) {
                this._creator = annotatedMethod;
                this._ctor = null;
                this._factoryMethod = annotatedMethod.getAnnotated();
                this._valueType = bindingsForBeanType.resolveType(annotatedMethod.getParameterType(0));
            } else {
                throw new IllegalArgumentException("Internal error: neither delegating constructor nor factory method passed");
            }
        }

        public JavaType getValueType() {
            return this._valueType;
        }

        public AnnotatedMember getCreator() {
            return this._creator;
        }

        public void setDeserializer(JsonDeserializer<Object> jsonDeserializer) {
            this._deserializer = jsonDeserializer;
        }

        public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            Object deserialize = this._deserializer.deserialize(jsonParser, deserializationContext);
            try {
                if (this._ctor != null) {
                    return this._ctor.newInstance(new Object[]{deserialize});
                }
                return this._factoryMethod.invoke((Object) null, new Object[]{deserialize});
            } catch (Exception e) {
                ClassUtil.unwrapAndThrowAsIAE(e);
                return null;
            }
        }
    }

    static final class PropertyBased {
        protected final Constructor<?> _ctor;
        protected final Object[] _defaultValues;
        protected final Method _factoryMethod;
        protected final HashMap<String, SettableBeanProperty> _properties;

        public PropertyBased(AnnotatedConstructor annotatedConstructor, SettableBeanProperty[] settableBeanPropertyArr, AnnotatedMethod annotatedMethod, SettableBeanProperty[] settableBeanPropertyArr2) {
            Object[] objArr = null;
            if (annotatedConstructor != null) {
                this._ctor = annotatedConstructor.getAnnotated();
                this._factoryMethod = null;
            } else if (annotatedMethod != null) {
                this._ctor = null;
                this._factoryMethod = annotatedMethod.getAnnotated();
                settableBeanPropertyArr = settableBeanPropertyArr2;
            } else {
                throw new IllegalArgumentException("Internal error: neither delegating constructor nor factory method passed");
            }
            this._properties = new HashMap<>();
            int length = settableBeanPropertyArr.length;
            for (int i = 0; i < length; i++) {
                SettableBeanProperty settableBeanProperty = settableBeanPropertyArr[i];
                this._properties.put(settableBeanProperty.getName(), settableBeanProperty);
                if (settableBeanProperty.getType().isPrimitive()) {
                    objArr = objArr == null ? new Object[length] : objArr;
                    objArr[i] = ClassUtil.defaultValue(settableBeanProperty.getType().getRawClass());
                }
            }
            this._defaultValues = objArr;
        }

        public Collection<SettableBeanProperty> properties() {
            return this._properties.values();
        }

        public SettableBeanProperty findCreatorProperty(String str) {
            return this._properties.get(str);
        }

        public PropertyValueBuffer startBuilding(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return new PropertyValueBuffer(jsonParser, deserializationContext, this._properties.size());
        }

        public Object build(PropertyValueBuffer propertyValueBuffer) throws Exception {
            Object obj;
            try {
                if (this._ctor != null) {
                    obj = this._ctor.newInstance(propertyValueBuffer.getParameters(this._defaultValues));
                } else {
                    obj = this._factoryMethod.invoke((Object) null, propertyValueBuffer.getParameters(this._defaultValues));
                }
                for (PropertyValue buffered = propertyValueBuffer.buffered(); buffered != null; buffered = buffered.next) {
                    buffered.assign(obj);
                }
                return obj;
            } catch (Exception e) {
                ClassUtil.throwRootCause(e);
                return null;
            }
        }
    }
}
