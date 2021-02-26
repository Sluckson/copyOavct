package org.codehaus.jackson.map.deser;

import java.io.IOException;
import org.codehaus.jackson.JsonProcessingException;

abstract class PropertyValue {
    public final PropertyValue next;
    public final Object value;

    public abstract void assign(Object obj) throws IOException, JsonProcessingException;

    protected PropertyValue(PropertyValue propertyValue, Object obj) {
        this.next = propertyValue;
        this.value = obj;
    }

    static final class Regular extends PropertyValue {
        final SettableBeanProperty _property;

        public Regular(PropertyValue propertyValue, Object obj, SettableBeanProperty settableBeanProperty) {
            super(propertyValue, obj);
            this._property = settableBeanProperty;
        }

        public void assign(Object obj) throws IOException, JsonProcessingException {
            this._property.set(obj, this.value);
        }
    }

    static final class Any extends PropertyValue {
        final SettableAnyProperty _property;
        final String _propertyName;

        public Any(PropertyValue propertyValue, Object obj, SettableAnyProperty settableAnyProperty, String str) {
            super(propertyValue, obj);
            this._property = settableAnyProperty;
            this._propertyName = str;
        }

        public void assign(Object obj) throws IOException, JsonProcessingException {
            this._property.set(obj, this._propertyName, this.value);
        }
    }

    static final class Map extends PropertyValue {
        final Object _key;

        public Map(PropertyValue propertyValue, Object obj, Object obj2) {
            super(propertyValue, obj);
            this._key = obj2;
        }

        public void assign(Object obj) throws IOException, JsonProcessingException {
            ((java.util.Map) obj).put(this._key, this.value);
        }
    }
}