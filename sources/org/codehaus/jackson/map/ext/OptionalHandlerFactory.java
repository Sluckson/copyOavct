package org.codehaus.jackson.map.ext;

import java.util.Collection;
import java.util.Map;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.deser.StdDeserializer;
import org.codehaus.jackson.map.util.Provider;
import org.codehaus.jackson.type.JavaType;

public class OptionalHandlerFactory {
    private static final String CLASS_NAME_DOM_DOCUMENT = "org.w3c.dom.Node";
    private static final String CLASS_NAME_DOM_NODE = "org.w3c.dom.Node";
    private static final String DESERIALIZERS_FOR_JAVAX_XML = "org.codehaus.jackson.map.ext.CoreXMLDeserializers";
    private static final String DESERIALIZERS_FOR_JODA_DATETIME = "org.codehaus.jackson.map.ext.JodaDeserializers";
    private static final String DESERIALIZER_FOR_DOM_DOCUMENT = "org.codehaus.jackson.map.ext.DOMDeserializer$DocumentDeserializer";
    private static final String DESERIALIZER_FOR_DOM_NODE = "org.codehaus.jackson.map.ext.DOMDeserializer$NodeDeserializer";
    private static final String PACKAGE_PREFIX_JAVAX_XML = "javax.xml.";
    private static final String PACKAGE_PREFIX_JODA_DATETIME = "org.joda.time.";
    private static final String SERIALIZERS_FOR_JAVAX_XML = "org.codehaus.jackson.map.ext.CoreXMLSerializers";
    private static final String SERIALIZERS_FOR_JODA_DATETIME = "org.codehaus.jackson.map.ext.JodaSerializers";
    private static final String SERIALIZER_FOR_DOM_NODE = "org.codehaus.jackson.map.ext.DOMSerializer";
    public static final OptionalHandlerFactory instance = new OptionalHandlerFactory();

    protected OptionalHandlerFactory() {
    }

    public JsonSerializer<?> findSerializer(SerializationConfig serializationConfig, JavaType javaType) {
        String str;
        Class<?> rawClass = javaType.getRawClass();
        String name = rawClass.getName();
        if (name.startsWith(PACKAGE_PREFIX_JODA_DATETIME)) {
            str = SERIALIZERS_FOR_JODA_DATETIME;
        } else if (name.startsWith(PACKAGE_PREFIX_JAVAX_XML) || hasSupertypeStartingWith(rawClass, PACKAGE_PREFIX_JAVAX_XML)) {
            str = SERIALIZERS_FOR_JAVAX_XML;
        } else if (doesImplement(rawClass, "org.w3c.dom.Node")) {
            return (JsonSerializer) instantiate(SERIALIZER_FOR_DOM_NODE);
        } else {
            return null;
        }
        Object instantiate = instantiate(str);
        if (instantiate == null) {
            return null;
        }
        Collection<Map.Entry> provide = ((Provider) instantiate).provide();
        for (Map.Entry entry : provide) {
            if (rawClass == entry.getKey()) {
                return (JsonSerializer) entry.getValue();
            }
        }
        for (Map.Entry entry2 : provide) {
            if (((Class) entry2.getKey()).isAssignableFrom(rawClass)) {
                return (JsonSerializer) entry2.getValue();
            }
        }
        return null;
    }

    public JsonDeserializer<?> findDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider) {
        String str;
        Class<?> rawClass = javaType.getRawClass();
        String name = rawClass.getName();
        if (name.startsWith(PACKAGE_PREFIX_JODA_DATETIME)) {
            str = DESERIALIZERS_FOR_JODA_DATETIME;
        } else if (name.startsWith(PACKAGE_PREFIX_JAVAX_XML) || hasSupertypeStartingWith(rawClass, PACKAGE_PREFIX_JAVAX_XML)) {
            str = DESERIALIZERS_FOR_JAVAX_XML;
        } else if (doesImplement(rawClass, "org.w3c.dom.Node")) {
            return (JsonDeserializer) instantiate(DESERIALIZER_FOR_DOM_DOCUMENT);
        } else {
            if (doesImplement(rawClass, "org.w3c.dom.Node")) {
                return (JsonDeserializer) instantiate(DESERIALIZER_FOR_DOM_NODE);
            }
            return null;
        }
        Object instantiate = instantiate(str);
        if (instantiate == null) {
            return null;
        }
        Collection<StdDeserializer> provide = ((Provider) instantiate).provide();
        for (StdDeserializer stdDeserializer : provide) {
            if (rawClass == stdDeserializer.getValueClass()) {
                return stdDeserializer;
            }
        }
        for (StdDeserializer stdDeserializer2 : provide) {
            if (stdDeserializer2.getValueClass().isAssignableFrom(rawClass)) {
                return stdDeserializer2;
            }
        }
        return null;
    }

    private Object instantiate(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Exception | LinkageError unused) {
            return null;
        }
    }

    private boolean doesImplement(Class<?> cls, String str) {
        Class<? super Object> cls2;
        while (cls2 != null) {
            if (cls2.getName().equals(str) || hasInterface(cls2, str)) {
                return true;
            }
            Class<? super Object> superclass = cls2.getSuperclass();
            cls2 = cls;
            cls2 = superclass;
        }
        return false;
    }

    private boolean hasInterface(Class<?> cls, String str) {
        Class[] interfaces = cls.getInterfaces();
        for (Class name : interfaces) {
            if (name.getName().equals(str)) {
                return true;
            }
        }
        for (Class hasInterface : interfaces) {
            if (hasInterface(hasInterface, str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean hasSupertypeStartingWith(java.lang.Class<?> r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.Class r0 = r4.getSuperclass()
        L_0x0004:
            r1 = 1
            if (r0 == 0) goto L_0x0017
            java.lang.String r2 = r0.getName()
            boolean r2 = r2.startsWith(r5)
            if (r2 == 0) goto L_0x0012
            return r1
        L_0x0012:
            java.lang.Class r0 = r0.getSuperclass()
            goto L_0x0004
        L_0x0017:
            if (r4 == 0) goto L_0x0025
            boolean r0 = r3.hasInterfaceStartingWith(r4, r5)
            if (r0 == 0) goto L_0x0020
            return r1
        L_0x0020:
            java.lang.Class r4 = r4.getSuperclass()
            goto L_0x0017
        L_0x0025:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.ext.OptionalHandlerFactory.hasSupertypeStartingWith(java.lang.Class, java.lang.String):boolean");
    }

    private boolean hasInterfaceStartingWith(Class<?> cls, String str) {
        Class[] interfaces = cls.getInterfaces();
        for (Class name : interfaces) {
            if (name.getName().startsWith(str)) {
                return true;
            }
        }
        for (Class hasInterfaceStartingWith : interfaces) {
            if (hasInterfaceStartingWith(hasInterfaceStartingWith, str)) {
                return true;
            }
        }
        return false;
    }
}
