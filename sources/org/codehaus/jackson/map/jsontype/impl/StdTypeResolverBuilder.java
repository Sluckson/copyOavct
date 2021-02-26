package org.codehaus.jackson.map.jsontype.impl;

import java.util.Collection;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.jsontype.NamedType;
import org.codehaus.jackson.map.jsontype.TypeIdResolver;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.type.JavaType;

public class StdTypeResolverBuilder implements TypeResolverBuilder<StdTypeResolverBuilder> {
    protected TypeIdResolver _customIdResolver;
    protected JsonTypeInfo.C4904Id _idType;
    protected JsonTypeInfo.C4903As _includeAs;
    protected String _typeProperty;

    public StdTypeResolverBuilder init(JsonTypeInfo.C4904Id id, TypeIdResolver typeIdResolver) {
        if (id != null) {
            this._idType = id;
            this._customIdResolver = typeIdResolver;
            this._typeProperty = id.getDefaultPropertyName();
            return this;
        }
        throw new IllegalArgumentException("idType can not be null");
    }

    public TypeSerializer buildTypeSerializer(SerializationConfig serializationConfig, JavaType javaType, Collection<NamedType> collection, BeanProperty beanProperty) {
        TypeIdResolver idResolver = idResolver(serializationConfig, javaType, collection, true, false);
        int i = C49201.$SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$As[this._includeAs.ordinal()];
        if (i == 1) {
            return new AsArrayTypeSerializer(idResolver, beanProperty);
        }
        if (i == 2) {
            return new AsPropertyTypeSerializer(idResolver, beanProperty, this._typeProperty);
        }
        if (i == 3) {
            return new AsWrapperTypeSerializer(idResolver, beanProperty);
        }
        throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this._includeAs);
    }

    public TypeDeserializer buildTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, Collection<NamedType> collection, BeanProperty beanProperty) {
        TypeIdResolver idResolver = idResolver(deserializationConfig, javaType, collection, false, true);
        int i = C49201.$SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$As[this._includeAs.ordinal()];
        if (i == 1) {
            return new AsArrayTypeDeserializer(javaType, idResolver, beanProperty);
        }
        if (i == 2) {
            return new AsPropertyTypeDeserializer(javaType, idResolver, beanProperty, this._typeProperty);
        }
        if (i == 3) {
            return new AsWrapperTypeDeserializer(javaType, idResolver, beanProperty);
        }
        throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this._includeAs);
    }

    public StdTypeResolverBuilder inclusion(JsonTypeInfo.C4903As as) {
        if (as != null) {
            this._includeAs = as;
            return this;
        }
        throw new IllegalArgumentException("includeAs can not be null");
    }

    public StdTypeResolverBuilder typeProperty(String str) {
        if (str == null || str.length() == 0) {
            str = this._idType.getDefaultPropertyName();
        }
        this._typeProperty = str;
        return this;
    }

    public String getTypeProperty() {
        return this._typeProperty;
    }

    /* access modifiers changed from: protected */
    public TypeIdResolver idResolver(MapperConfig<?> mapperConfig, JavaType javaType, Collection<NamedType> collection, boolean z, boolean z2) {
        TypeIdResolver typeIdResolver = this._customIdResolver;
        if (typeIdResolver != null) {
            return typeIdResolver;
        }
        if (this._idType != null) {
            int i = C49201.$SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$Id[this._idType.ordinal()];
            if (i == 1) {
                return new ClassNameIdResolver(javaType, mapperConfig.getTypeFactory());
            }
            if (i == 2) {
                return new MinimalClassNameIdResolver(javaType, mapperConfig.getTypeFactory());
            }
            if (i == 3) {
                return TypeNameIdResolver.construct(mapperConfig, javaType, collection, z, z2);
            }
            throw new IllegalStateException("Do not know how to construct standard type id resolver for idType: " + this._idType);
        }
        throw new IllegalStateException("Can not build, 'init()' not yet called");
    }

    /* renamed from: org.codehaus.jackson.map.jsontype.impl.StdTypeResolverBuilder$1 */
    static /* synthetic */ class C49201 {
        static final /* synthetic */ int[] $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$As = new int[JsonTypeInfo.C4903As.values().length];
        static final /* synthetic */ int[] $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$Id = new int[JsonTypeInfo.C4904Id.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|17|18|19|20|21|22|24) */
        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|17|18|19|20|21|22|24) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|5|6|7|9|10|11|12|13|14|15|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0035 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005d */
        static {
            /*
                org.codehaus.jackson.annotate.JsonTypeInfo$Id[] r0 = org.codehaus.jackson.annotate.JsonTypeInfo.C4904Id.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$Id = r0
                r0 = 1
                int[] r1 = $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$Id     // Catch:{ NoSuchFieldError -> 0x0014 }
                org.codehaus.jackson.annotate.JsonTypeInfo$Id r2 = org.codehaus.jackson.annotate.JsonTypeInfo.C4904Id.CLASS     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$Id     // Catch:{ NoSuchFieldError -> 0x001f }
                org.codehaus.jackson.annotate.JsonTypeInfo$Id r3 = org.codehaus.jackson.annotate.JsonTypeInfo.C4904Id.MINIMAL_CLASS     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$Id     // Catch:{ NoSuchFieldError -> 0x002a }
                org.codehaus.jackson.annotate.JsonTypeInfo$Id r4 = org.codehaus.jackson.annotate.JsonTypeInfo.C4904Id.NAME     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r3 = $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$Id     // Catch:{ NoSuchFieldError -> 0x0035 }
                org.codehaus.jackson.annotate.JsonTypeInfo$Id r4 = org.codehaus.jackson.annotate.JsonTypeInfo.C4904Id.CUSTOM     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r3 = $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$Id     // Catch:{ NoSuchFieldError -> 0x0040 }
                org.codehaus.jackson.annotate.JsonTypeInfo$Id r4 = org.codehaus.jackson.annotate.JsonTypeInfo.C4904Id.NONE     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                org.codehaus.jackson.annotate.JsonTypeInfo$As[] r3 = org.codehaus.jackson.annotate.JsonTypeInfo.C4903As.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$As = r3
                int[] r3 = $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$As     // Catch:{ NoSuchFieldError -> 0x0053 }
                org.codehaus.jackson.annotate.JsonTypeInfo$As r4 = org.codehaus.jackson.annotate.JsonTypeInfo.C4903As.WRAPPER_ARRAY     // Catch:{ NoSuchFieldError -> 0x0053 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0053 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0053 }
            L_0x0053:
                int[] r0 = $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$As     // Catch:{ NoSuchFieldError -> 0x005d }
                org.codehaus.jackson.annotate.JsonTypeInfo$As r3 = org.codehaus.jackson.annotate.JsonTypeInfo.C4903As.PROPERTY     // Catch:{ NoSuchFieldError -> 0x005d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                int[] r0 = $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$As     // Catch:{ NoSuchFieldError -> 0x0067 }
                org.codehaus.jackson.annotate.JsonTypeInfo$As r1 = org.codehaus.jackson.annotate.JsonTypeInfo.C4903As.WRAPPER_OBJECT     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.jsontype.impl.StdTypeResolverBuilder.C49201.<clinit>():void");
        }
    }
}
