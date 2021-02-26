package org.codehaus.jackson.map.type;

import org.codehaus.jackson.type.JavaType;

public final class CollectionType extends CollectionLikeType {
    private CollectionType(Class<?> cls, JavaType javaType) {
        super(cls, javaType);
    }

    /* access modifiers changed from: protected */
    public JavaType _narrow(Class<?> cls) {
        return new CollectionType(cls, this._elementType);
    }

    public JavaType narrowContentsBy(Class<?> cls) {
        if (cls == this._elementType.getRawClass()) {
            return this;
        }
        return new CollectionType(this._class, this._elementType.narrowBy(cls)).copyHandlers(this);
    }

    public JavaType widenContentsBy(Class<?> cls) {
        if (cls == this._elementType.getRawClass()) {
            return this;
        }
        return new CollectionType(this._class, this._elementType.widenBy(cls)).copyHandlers(this);
    }

    public static CollectionType construct(Class<?> cls, JavaType javaType) {
        return new CollectionType(cls, javaType);
    }

    public CollectionType withTypeHandler(Object obj) {
        CollectionType collectionType = new CollectionType(this._class, this._elementType);
        collectionType._typeHandler = obj;
        return collectionType;
    }

    public CollectionType withContentTypeHandler(Object obj) {
        return new CollectionType(this._class, this._elementType.withTypeHandler(obj));
    }

    public String toString() {
        return "[collection type; class " + this._class.getName() + ", contains " + this._elementType + "]";
    }
}
