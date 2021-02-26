package org.codehaus.jackson.map.ser.impl;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Type;
import java.util.Collection;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.SerializerBase;
import org.codehaus.jackson.node.ObjectNode;

public abstract class StaticListSerializerBase<T extends Collection<?>> extends SerializerBase<T> {
    protected final BeanProperty _property;

    /* access modifiers changed from: protected */
    public abstract JsonNode contentSchema();

    protected StaticListSerializerBase(Class<?> cls, BeanProperty beanProperty) {
        super(cls, false);
        this._property = beanProperty;
    }

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        ObjectNode createSchemaNode = createSchemaNode("array", true);
        createSchemaNode.put(FirebaseAnalytics.Param.ITEMS, contentSchema());
        return createSchemaNode;
    }
}
