package org.codehaus.jackson.map.type;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import kotlin.text.Typography;
import org.codehaus.jackson.type.JavaType;

public class CollectionLikeType extends TypeBase {
    protected final JavaType _elementType;

    public int containedTypeCount() {
        return 1;
    }

    public String containedTypeName(int i) {
        if (i == 0) {
            return ExifInterface.LONGITUDE_EAST;
        }
        return null;
    }

    public boolean isCollectionLikeType() {
        return true;
    }

    public boolean isContainerType() {
        return true;
    }

    protected CollectionLikeType(Class<?> cls, JavaType javaType) {
        super(cls, javaType.hashCode());
        this._elementType = javaType;
    }

    /* access modifiers changed from: protected */
    public JavaType _narrow(Class<?> cls) {
        return new CollectionLikeType(cls, this._elementType);
    }

    public JavaType narrowContentsBy(Class<?> cls) {
        if (cls == this._elementType.getRawClass()) {
            return this;
        }
        return new CollectionLikeType(this._class, this._elementType.narrowBy(cls)).copyHandlers(this);
    }

    public JavaType widenContentsBy(Class<?> cls) {
        if (cls == this._elementType.getRawClass()) {
            return this;
        }
        return new CollectionLikeType(this._class, this._elementType.widenBy(cls)).copyHandlers(this);
    }

    public static CollectionLikeType construct(Class<?> cls, JavaType javaType) {
        return new CollectionLikeType(cls, javaType);
    }

    public CollectionLikeType withTypeHandler(Object obj) {
        CollectionLikeType collectionLikeType = new CollectionLikeType(this._class, this._elementType);
        collectionLikeType._typeHandler = obj;
        return collectionLikeType;
    }

    public CollectionLikeType withContentTypeHandler(Object obj) {
        return new CollectionLikeType(this._class, this._elementType.withTypeHandler(obj));
    }

    public JavaType getContentType() {
        return this._elementType;
    }

    public JavaType containedType(int i) {
        if (i == 0) {
            return this._elementType;
        }
        return null;
    }

    public StringBuilder getErasedSignature(StringBuilder sb) {
        return _classSignature(this._class, sb, true);
    }

    public StringBuilder getGenericSignature(StringBuilder sb) {
        _classSignature(this._class, sb, false);
        sb.append(Typography.less);
        this._elementType.getGenericSignature(sb);
        sb.append(">;");
        return sb;
    }

    /* access modifiers changed from: protected */
    public String buildCanonicalName() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._class.getName());
        if (this._elementType != null) {
            sb.append(Typography.less);
            sb.append(this._elementType.toCanonical());
            sb.append(Typography.greater);
        }
        return sb.toString();
    }

    public boolean isTrueCollectionType() {
        return Collection.class.isAssignableFrom(this._class);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        CollectionLikeType collectionLikeType = (CollectionLikeType) obj;
        if (this._class != collectionLikeType._class || !this._elementType.equals(collectionLikeType._elementType)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "[collection-like type; class " + this._class.getName() + ", contains " + this._elementType + "]";
    }
}
