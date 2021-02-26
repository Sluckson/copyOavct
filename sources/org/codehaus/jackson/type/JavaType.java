package org.codehaus.jackson.type;

import com.wowza.gocoder.sdk.support.wse.jni.wmstransport.WMSTransport;
import java.lang.reflect.Modifier;

public abstract class JavaType {
    protected final Class<?> _class;
    protected final int _hashCode;
    protected Object _typeHandler;
    protected Object _valueHandler;

    /* access modifiers changed from: protected */
    public abstract JavaType _narrow(Class<?> cls);

    public JavaType containedType(int i) {
        return null;
    }

    public int containedTypeCount() {
        return 0;
    }

    public String containedTypeName(int i) {
        return null;
    }

    public abstract boolean equals(Object obj);

    public JavaType getContentType() {
        return null;
    }

    public abstract StringBuilder getErasedSignature(StringBuilder sb);

    public abstract StringBuilder getGenericSignature(StringBuilder sb);

    public JavaType getKeyType() {
        return null;
    }

    public boolean isArrayType() {
        return false;
    }

    public boolean isCollectionLikeType() {
        return false;
    }

    public abstract boolean isContainerType();

    public boolean isMapLikeType() {
        return false;
    }

    public abstract JavaType narrowContentsBy(Class<?> cls);

    public abstract String toCanonical();

    public abstract String toString();

    public abstract JavaType widenContentsBy(Class<?> cls);

    public abstract JavaType withContentTypeHandler(Object obj);

    public abstract JavaType withTypeHandler(Object obj);

    protected JavaType(Class<?> cls, int i) {
        this._class = cls;
        this._hashCode = cls.getName().hashCode() + i;
    }

    public final JavaType narrowBy(Class<?> cls) {
        Class<?> cls2 = this._class;
        if (cls == cls2) {
            return this;
        }
        _assertSubclass(cls, cls2);
        JavaType _narrow = _narrow(cls);
        Object obj = this._valueHandler;
        if (obj != null) {
            _narrow.setValueHandler(obj);
        }
        Object obj2 = this._typeHandler;
        return obj2 != null ? _narrow.withTypeHandler(obj2) : _narrow;
    }

    public final JavaType forcedNarrowBy(Class<?> cls) {
        if (cls == this._class) {
            return this;
        }
        JavaType _narrow = _narrow(cls);
        Object obj = this._valueHandler;
        if (obj != null) {
            _narrow.setValueHandler(obj);
        }
        Object obj2 = this._typeHandler;
        return obj2 != null ? _narrow.withTypeHandler(obj2) : _narrow;
    }

    public final JavaType widenBy(Class<?> cls) {
        Class<?> cls2 = this._class;
        if (cls == cls2) {
            return this;
        }
        _assertSubclass(cls2, cls);
        return _widen(cls);
    }

    /* access modifiers changed from: protected */
    public JavaType _widen(Class<?> cls) {
        return _narrow(cls);
    }

    public void setValueHandler(Object obj) {
        if (obj == null || this._valueHandler == null) {
            this._valueHandler = obj;
            return;
        }
        throw new IllegalStateException("Trying to reset value handler for type [" + toString() + "]; old handler of type " + this._valueHandler.getClass().getName() + ", new handler of type " + obj.getClass().getName());
    }

    @Deprecated
    public void setTypeHandler(Object obj) {
        if (obj == null || this._typeHandler == null) {
            this._typeHandler = obj;
            return;
        }
        throw new IllegalStateException("Trying to reset type handler for type [" + toString() + "]; old handler of type " + this._typeHandler.getClass().getName() + ", new handler of type " + obj.getClass().getName());
    }

    public final Class<?> getRawClass() {
        return this._class;
    }

    public final boolean hasRawClass(Class<?> cls) {
        return this._class == cls;
    }

    public boolean isAbstract() {
        return Modifier.isAbstract(this._class.getModifiers());
    }

    public boolean isConcrete() {
        if ((this._class.getModifiers() & WMSTransport.PUSHPUBLISHSESSIONWOWZ_HANDSHAKESIZE_CLIENT1) != 0 && !this._class.isPrimitive()) {
            return false;
        }
        return true;
    }

    public boolean isThrowable() {
        return Throwable.class.isAssignableFrom(this._class);
    }

    public final boolean isEnumType() {
        return this._class.isEnum();
    }

    public final boolean isInterface() {
        return this._class.isInterface();
    }

    public final boolean isPrimitive() {
        return this._class.isPrimitive();
    }

    public final boolean isFinal() {
        return Modifier.isFinal(this._class.getModifiers());
    }

    public boolean hasGenericTypes() {
        return containedTypeCount() > 0;
    }

    public <T> T getValueHandler() {
        return this._valueHandler;
    }

    public <T> T getTypeHandler() {
        return this._typeHandler;
    }

    public String getGenericSignature() {
        StringBuilder sb = new StringBuilder(40);
        getGenericSignature(sb);
        return sb.toString();
    }

    public String getErasedSignature() {
        StringBuilder sb = new StringBuilder(40);
        getErasedSignature(sb);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void _assertSubclass(Class<?> cls, Class<?> cls2) {
        if (!this._class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Class " + cls.getName() + " is not assignable to " + this._class.getName());
        }
    }

    public final int hashCode() {
        return this._hashCode;
    }
}
