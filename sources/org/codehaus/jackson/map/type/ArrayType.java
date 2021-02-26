package org.codehaus.jackson.map.type;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import org.codehaus.jackson.type.JavaType;

public final class ArrayType extends TypeBase {
    final JavaType _componentType;
    final Object _emptyArray;

    public int containedTypeCount() {
        return 1;
    }

    public String containedTypeName(int i) {
        if (i == 0) {
            return ExifInterface.LONGITUDE_EAST;
        }
        return null;
    }

    public boolean isAbstract() {
        return false;
    }

    public boolean isArrayType() {
        return true;
    }

    public boolean isConcrete() {
        return true;
    }

    public boolean isContainerType() {
        return true;
    }

    private ArrayType(JavaType javaType, Object obj) {
        super(obj.getClass(), javaType.hashCode());
        this._componentType = javaType;
        this._emptyArray = obj;
    }

    public static ArrayType construct(JavaType javaType) {
        return new ArrayType(javaType, Array.newInstance(javaType.getRawClass(), 0));
    }

    public ArrayType withTypeHandler(Object obj) {
        ArrayType arrayType = new ArrayType(this._componentType, this._emptyArray);
        arrayType._typeHandler = obj;
        return arrayType;
    }

    public ArrayType withContentTypeHandler(Object obj) {
        return new ArrayType(this._componentType.withTypeHandler(obj), this._emptyArray);
    }

    /* access modifiers changed from: protected */
    public String buildCanonicalName() {
        return this._class.getName();
    }

    /* access modifiers changed from: protected */
    public JavaType _narrow(Class<?> cls) {
        if (cls.isArray()) {
            return construct(TypeFactory.defaultInstance().constructType((Type) cls.getComponentType()));
        }
        throw new IllegalArgumentException("Incompatible narrowing operation: trying to narrow " + toString() + " to class " + cls.getName());
    }

    public JavaType narrowContentsBy(Class<?> cls) {
        if (cls == this._componentType.getRawClass()) {
            return this;
        }
        return construct(this._componentType.narrowBy(cls)).copyHandlers(this);
    }

    public JavaType widenContentsBy(Class<?> cls) {
        if (cls == this._componentType.getRawClass()) {
            return this;
        }
        return construct(this._componentType.widenBy(cls)).copyHandlers(this);
    }

    public boolean hasGenericTypes() {
        return this._componentType.hasGenericTypes();
    }

    public JavaType getContentType() {
        return this._componentType;
    }

    public JavaType containedType(int i) {
        if (i == 0) {
            return this._componentType;
        }
        return null;
    }

    public StringBuilder getGenericSignature(StringBuilder sb) {
        sb.append('[');
        return this._componentType.getGenericSignature(sb);
    }

    public StringBuilder getErasedSignature(StringBuilder sb) {
        sb.append('[');
        return this._componentType.getErasedSignature(sb);
    }

    public String toString() {
        return "[array type, component type: " + this._componentType + "]";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            return this._componentType.equals(((ArrayType) obj)._componentType);
        }
        return false;
    }
}
