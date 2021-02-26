package org.codehaus.jackson.map.type;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.text.Typography;
import org.codehaus.jackson.type.JavaType;

public class MapLikeType extends TypeBase {
    protected final JavaType _keyType;
    protected final JavaType _valueType;

    public int containedTypeCount() {
        return 2;
    }

    public String containedTypeName(int i) {
        if (i == 0) {
            return "K";
        }
        if (i == 1) {
            return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        }
        return null;
    }

    public boolean isContainerType() {
        return true;
    }

    public boolean isMapLikeType() {
        return true;
    }

    protected MapLikeType(Class<?> cls, JavaType javaType, JavaType javaType2) {
        super(cls, javaType.hashCode() ^ javaType2.hashCode());
        this._keyType = javaType;
        this._valueType = javaType2;
    }

    public static MapLikeType construct(Class<?> cls, JavaType javaType, JavaType javaType2) {
        return new MapLikeType(cls, javaType, javaType2);
    }

    /* access modifiers changed from: protected */
    public JavaType _narrow(Class<?> cls) {
        return new MapLikeType(cls, this._keyType, this._valueType);
    }

    public JavaType narrowContentsBy(Class<?> cls) {
        if (cls == this._valueType.getRawClass()) {
            return this;
        }
        return new MapLikeType(this._class, this._keyType, this._valueType.narrowBy(cls)).copyHandlers(this);
    }

    public JavaType widenContentsBy(Class<?> cls) {
        if (cls == this._valueType.getRawClass()) {
            return this;
        }
        return new MapLikeType(this._class, this._keyType, this._valueType.widenBy(cls)).copyHandlers(this);
    }

    public JavaType narrowKey(Class<?> cls) {
        if (cls == this._keyType.getRawClass()) {
            return this;
        }
        return new MapLikeType(this._class, this._keyType.narrowBy(cls), this._valueType).copyHandlers(this);
    }

    public JavaType widenKey(Class<?> cls) {
        if (cls == this._keyType.getRawClass()) {
            return this;
        }
        return new MapLikeType(this._class, this._keyType.widenBy(cls), this._valueType).copyHandlers(this);
    }

    public MapLikeType withTypeHandler(Object obj) {
        MapLikeType mapLikeType = new MapLikeType(this._class, this._keyType, this._valueType);
        mapLikeType._typeHandler = obj;
        return mapLikeType;
    }

    public MapLikeType withContentTypeHandler(Object obj) {
        return new MapLikeType(this._class, this._keyType, this._valueType.withTypeHandler(obj));
    }

    /* access modifiers changed from: protected */
    public String buildCanonicalName() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._class.getName());
        if (this._keyType != null) {
            sb.append(Typography.less);
            sb.append(this._keyType.toCanonical());
            sb.append(',');
            sb.append(this._valueType.toCanonical());
            sb.append(Typography.greater);
        }
        return sb.toString();
    }

    public JavaType getKeyType() {
        return this._keyType;
    }

    public JavaType getContentType() {
        return this._valueType;
    }

    public JavaType containedType(int i) {
        if (i == 0) {
            return this._keyType;
        }
        if (i == 1) {
            return this._valueType;
        }
        return null;
    }

    public StringBuilder getErasedSignature(StringBuilder sb) {
        return _classSignature(this._class, sb, true);
    }

    public StringBuilder getGenericSignature(StringBuilder sb) {
        _classSignature(this._class, sb, false);
        sb.append(Typography.less);
        this._keyType.getGenericSignature(sb);
        this._valueType.getGenericSignature(sb);
        sb.append(">;");
        return sb;
    }

    public boolean isTrueMapType() {
        return Map.class.isAssignableFrom(this._class);
    }

    public String toString() {
        return "[map-like type; class " + this._class.getName() + ", " + this._keyType + " -> " + this._valueType + "]";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        MapLikeType mapLikeType = (MapLikeType) obj;
        if (this._class != mapLikeType._class || !this._keyType.equals(mapLikeType._keyType) || !this._valueType.equals(mapLikeType._valueType)) {
            return false;
        }
        return true;
    }
}
