package org.codehaus.jackson.map.jsontype.impl;

import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

public class ClassNameIdResolver extends TypeIdResolverBase {
    public void registerSubtype(Class<?> cls, String str) {
    }

    public ClassNameIdResolver(JavaType javaType, TypeFactory typeFactory) {
        super(javaType, typeFactory);
    }

    public JsonTypeInfo.C4904Id getMechanism() {
        return JsonTypeInfo.C4904Id.CLASS;
    }

    public String idFromValue(Object obj) {
        return _idFrom(obj, obj.getClass());
    }

    public String idFromValueAndType(Object obj, Class<?> cls) {
        return _idFrom(obj, cls);
    }

    public JavaType typeFromId(String str) {
        if (str.indexOf(60) > 0) {
            return TypeFactory.fromCanonical(str);
        }
        try {
            return this._typeFactory.constructSpecializedType(this._baseType, Class.forName(str, true, Thread.currentThread().getContextClassLoader()));
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("Invalid type id '" + str + "' (for id type 'Id.class'): no such class found");
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid type id '" + str + "' (for id type 'Id.class'): " + e.getMessage(), e);
        }
    }

    /* access modifiers changed from: protected */
    public final String _idFrom(Object obj, Class<?> cls) {
        boolean isAssignableFrom = Enum.class.isAssignableFrom(cls);
        Class<? super Object> cls2 = cls;
        if (isAssignableFrom) {
            boolean isEnum = cls.isEnum();
            cls2 = cls;
            if (!isEnum) {
                cls2 = cls.getSuperclass();
            }
        }
        String name = cls2.getName();
        if (!name.startsWith("java.util")) {
            return name;
        }
        if (obj instanceof EnumSet) {
            return TypeFactory.defaultInstance().constructCollectionType((Class<? extends Collection>) EnumSet.class, (Class<?>) ClassUtil.findEnumType((EnumSet<?>) (EnumSet) obj)).toCanonical();
        } else if (obj instanceof EnumMap) {
            return TypeFactory.defaultInstance().constructMapType((Class<? extends Map>) EnumMap.class, (Class<?>) ClassUtil.findEnumType((EnumMap<?, ?>) (EnumMap) obj), (Class<?>) Object.class).toCanonical();
        } else {
            String substring = name.substring(9);
            return ((substring.startsWith(".Arrays$") || substring.startsWith(".Collections$")) && name.indexOf("List") >= 0) ? "java.util.ArrayList" : name;
        }
    }
}
