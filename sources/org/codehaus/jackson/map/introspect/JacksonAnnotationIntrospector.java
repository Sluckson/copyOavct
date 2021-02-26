package org.codehaus.jackson.map.introspect;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.annotate.JacksonAnnotation;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonClass;
import org.codehaus.jackson.annotate.JsonContentClass;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonGetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonIgnoreType;
import org.codehaus.jackson.annotate.JsonKeyClass;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.annotate.JsonRawValue;
import org.codehaus.jackson.annotate.JsonSetter;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeName;
import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.annotate.JsonWriteNullProperties;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.annotate.JsonCachable;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonFilter;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonView;
import org.codehaus.jackson.map.annotate.NoClass;
import org.codehaus.jackson.map.jsontype.NamedType;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.map.jsontype.impl.StdTypeResolverBuilder;
import org.codehaus.jackson.map.ser.impl.RawSerializer;
import org.codehaus.jackson.type.JavaType;

public class JacksonAnnotationIntrospector extends AnnotationIntrospector {
    public String findRootName(AnnotatedClass annotatedClass) {
        return null;
    }

    public boolean isHandled(Annotation annotation) {
        return annotation.annotationType().getAnnotation(JacksonAnnotation.class) != null;
    }

    public String findEnumValue(Enum<?> enumR) {
        return enumR.name();
    }

    public Boolean findCachability(AnnotatedClass annotatedClass) {
        JsonCachable jsonCachable = (JsonCachable) annotatedClass.getAnnotation(JsonCachable.class);
        if (jsonCachable == null) {
            return null;
        }
        return jsonCachable.value() ? Boolean.TRUE : Boolean.FALSE;
    }

    public String[] findPropertiesToIgnore(AnnotatedClass annotatedClass) {
        JsonIgnoreProperties jsonIgnoreProperties = (JsonIgnoreProperties) annotatedClass.getAnnotation(JsonIgnoreProperties.class);
        if (jsonIgnoreProperties == null) {
            return null;
        }
        return jsonIgnoreProperties.value();
    }

    public Boolean findIgnoreUnknownProperties(AnnotatedClass annotatedClass) {
        JsonIgnoreProperties jsonIgnoreProperties = (JsonIgnoreProperties) annotatedClass.getAnnotation(JsonIgnoreProperties.class);
        if (jsonIgnoreProperties == null) {
            return null;
        }
        return Boolean.valueOf(jsonIgnoreProperties.ignoreUnknown());
    }

    public Boolean isIgnorableType(AnnotatedClass annotatedClass) {
        JsonIgnoreType jsonIgnoreType = (JsonIgnoreType) annotatedClass.getAnnotation(JsonIgnoreType.class);
        if (jsonIgnoreType == null) {
            return null;
        }
        return Boolean.valueOf(jsonIgnoreType.value());
    }

    public Object findFilterId(AnnotatedClass annotatedClass) {
        JsonFilter jsonFilter = (JsonFilter) annotatedClass.getAnnotation(JsonFilter.class);
        if (jsonFilter == null) {
            return null;
        }
        String value = jsonFilter.value();
        if (value.length() > 0) {
            return value;
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [org.codehaus.jackson.map.introspect.VisibilityChecker<?>, org.codehaus.jackson.map.introspect.VisibilityChecker] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.codehaus.jackson.map.introspect.VisibilityChecker<?> findAutoDetectVisibility(org.codehaus.jackson.map.introspect.AnnotatedClass r2, org.codehaus.jackson.map.introspect.VisibilityChecker<?> r3) {
        /*
            r1 = this;
            java.lang.Class<org.codehaus.jackson.annotate.JsonAutoDetect> r0 = org.codehaus.jackson.annotate.JsonAutoDetect.class
            java.lang.annotation.Annotation r2 = r2.getAnnotation(r0)
            org.codehaus.jackson.annotate.JsonAutoDetect r2 = (org.codehaus.jackson.annotate.JsonAutoDetect) r2
            if (r2 != 0) goto L_0x000b
            goto L_0x000f
        L_0x000b:
            org.codehaus.jackson.map.introspect.VisibilityChecker r3 = r3.with(r2)
        L_0x000f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector.findAutoDetectVisibility(org.codehaus.jackson.map.introspect.AnnotatedClass, org.codehaus.jackson.map.introspect.VisibilityChecker):org.codehaus.jackson.map.introspect.VisibilityChecker");
    }

    public AnnotationIntrospector.ReferenceProperty findReferenceType(AnnotatedMember annotatedMember) {
        JsonManagedReference jsonManagedReference = (JsonManagedReference) annotatedMember.getAnnotation(JsonManagedReference.class);
        if (jsonManagedReference != null) {
            return AnnotationIntrospector.ReferenceProperty.managed(jsonManagedReference.value());
        }
        JsonBackReference jsonBackReference = (JsonBackReference) annotatedMember.getAnnotation(JsonBackReference.class);
        if (jsonBackReference != null) {
            return AnnotationIntrospector.ReferenceProperty.back(jsonBackReference.value());
        }
        return null;
    }

    public TypeResolverBuilder<?> findTypeResolver(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, JavaType javaType) {
        return _findTypeResolver(mapperConfig, annotatedClass, javaType);
    }

    public TypeResolverBuilder<?> findPropertyTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        if (javaType.isContainerType()) {
            return null;
        }
        return _findTypeResolver(mapperConfig, annotatedMember, javaType);
    }

    public TypeResolverBuilder<?> findPropertyContentTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        if (javaType.isContainerType()) {
            return _findTypeResolver(mapperConfig, annotatedMember, javaType);
        }
        throw new IllegalArgumentException("Must call method with a container type (got " + javaType + ")");
    }

    public List<NamedType> findSubtypes(Annotated annotated) {
        JsonSubTypes jsonSubTypes = (JsonSubTypes) annotated.getAnnotation(JsonSubTypes.class);
        if (jsonSubTypes == null) {
            return null;
        }
        JsonSubTypes.Type[] value = jsonSubTypes.value();
        ArrayList arrayList = new ArrayList(value.length);
        for (JsonSubTypes.Type type : value) {
            arrayList.add(new NamedType(type.value(), type.name()));
        }
        return arrayList;
    }

    public String findTypeName(AnnotatedClass annotatedClass) {
        JsonTypeName jsonTypeName = (JsonTypeName) annotatedClass.getAnnotation(JsonTypeName.class);
        if (jsonTypeName == null) {
            return null;
        }
        return jsonTypeName.value();
    }

    public boolean isIgnorableMethod(AnnotatedMethod annotatedMethod) {
        return _isIgnorable(annotatedMethod);
    }

    public boolean isIgnorableConstructor(AnnotatedConstructor annotatedConstructor) {
        return _isIgnorable(annotatedConstructor);
    }

    public boolean isIgnorableField(AnnotatedField annotatedField) {
        return _isIgnorable(annotatedField);
    }

    public Object findSerializer(Annotated annotated, BeanProperty beanProperty) {
        Class<? extends JsonSerializer<?>> using;
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.getAnnotation(JsonSerialize.class);
        if (jsonSerialize != null && (using = jsonSerialize.using()) != JsonSerializer.None.class) {
            return using;
        }
        JsonRawValue jsonRawValue = (JsonRawValue) annotated.getAnnotation(JsonRawValue.class);
        if (jsonRawValue == null || !jsonRawValue.value()) {
            return null;
        }
        return new RawSerializer(annotated.getRawType());
    }

    public Class<? extends JsonSerializer<?>> findKeySerializer(Annotated annotated) {
        Class<? extends JsonSerializer<?>> keyUsing;
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.getAnnotation(JsonSerialize.class);
        if (jsonSerialize == null || (keyUsing = jsonSerialize.keyUsing()) == JsonSerializer.None.class) {
            return null;
        }
        return keyUsing;
    }

    public Class<? extends JsonSerializer<?>> findContentSerializer(Annotated annotated) {
        Class<? extends JsonSerializer<?>> contentUsing;
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.getAnnotation(JsonSerialize.class);
        if (jsonSerialize == null || (contentUsing = jsonSerialize.contentUsing()) == JsonSerializer.None.class) {
            return null;
        }
        return contentUsing;
    }

    public JsonSerialize.Inclusion findSerializationInclusion(Annotated annotated, JsonSerialize.Inclusion inclusion) {
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.getAnnotation(JsonSerialize.class);
        if (jsonSerialize != null) {
            return jsonSerialize.include();
        }
        JsonWriteNullProperties jsonWriteNullProperties = (JsonWriteNullProperties) annotated.getAnnotation(JsonWriteNullProperties.class);
        if (jsonWriteNullProperties != null) {
            return jsonWriteNullProperties.value() ? JsonSerialize.Inclusion.ALWAYS : JsonSerialize.Inclusion.NON_NULL;
        }
        return inclusion;
    }

    public Class<?> findSerializationType(Annotated annotated) {
        Class<?> as;
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.getAnnotation(JsonSerialize.class);
        if (jsonSerialize == null || (as = jsonSerialize.mo71188as()) == NoClass.class) {
            return null;
        }
        return as;
    }

    public Class<?> findSerializationKeyType(Annotated annotated, JavaType javaType) {
        Class<?> keyAs;
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.getAnnotation(JsonSerialize.class);
        if (jsonSerialize == null || (keyAs = jsonSerialize.keyAs()) == NoClass.class) {
            return null;
        }
        return keyAs;
    }

    public Class<?> findSerializationContentType(Annotated annotated, JavaType javaType) {
        Class<?> contentAs;
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.getAnnotation(JsonSerialize.class);
        if (jsonSerialize == null || (contentAs = jsonSerialize.contentAs()) == NoClass.class) {
            return null;
        }
        return contentAs;
    }

    public JsonSerialize.Typing findSerializationTyping(Annotated annotated) {
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.getAnnotation(JsonSerialize.class);
        if (jsonSerialize == null) {
            return null;
        }
        return jsonSerialize.typing();
    }

    public Class<?>[] findSerializationViews(Annotated annotated) {
        JsonView jsonView = (JsonView) annotated.getAnnotation(JsonView.class);
        if (jsonView == null) {
            return null;
        }
        return jsonView.value();
    }

    public String[] findSerializationPropertyOrder(AnnotatedClass annotatedClass) {
        JsonPropertyOrder jsonPropertyOrder = (JsonPropertyOrder) annotatedClass.getAnnotation(JsonPropertyOrder.class);
        if (jsonPropertyOrder == null) {
            return null;
        }
        return jsonPropertyOrder.value();
    }

    public Boolean findSerializationSortAlphabetically(AnnotatedClass annotatedClass) {
        JsonPropertyOrder jsonPropertyOrder = (JsonPropertyOrder) annotatedClass.getAnnotation(JsonPropertyOrder.class);
        if (jsonPropertyOrder == null) {
            return null;
        }
        return Boolean.valueOf(jsonPropertyOrder.alphabetic());
    }

    public String findGettablePropertyName(AnnotatedMethod annotatedMethod) {
        JsonProperty jsonProperty = (JsonProperty) annotatedMethod.getAnnotation(JsonProperty.class);
        if (jsonProperty != null) {
            return jsonProperty.value();
        }
        JsonGetter jsonGetter = (JsonGetter) annotatedMethod.getAnnotation(JsonGetter.class);
        if (jsonGetter != null) {
            return jsonGetter.value();
        }
        if (annotatedMethod.hasAnnotation(JsonSerialize.class) || annotatedMethod.hasAnnotation(JsonView.class)) {
            return "";
        }
        return null;
    }

    public boolean hasAsValueAnnotation(AnnotatedMethod annotatedMethod) {
        JsonValue jsonValue = (JsonValue) annotatedMethod.getAnnotation(JsonValue.class);
        return jsonValue != null && jsonValue.value();
    }

    public String findSerializablePropertyName(AnnotatedField annotatedField) {
        JsonProperty jsonProperty = (JsonProperty) annotatedField.getAnnotation(JsonProperty.class);
        if (jsonProperty != null) {
            return jsonProperty.value();
        }
        if (annotatedField.hasAnnotation(JsonSerialize.class) || annotatedField.hasAnnotation(JsonView.class)) {
            return "";
        }
        return null;
    }

    public Class<? extends JsonDeserializer<?>> findDeserializer(Annotated annotated, BeanProperty beanProperty) {
        Class<? extends JsonDeserializer<?>> using;
        JsonDeserialize jsonDeserialize = (JsonDeserialize) annotated.getAnnotation(JsonDeserialize.class);
        if (jsonDeserialize == null || (using = jsonDeserialize.using()) == JsonDeserializer.None.class) {
            return null;
        }
        return using;
    }

    public Class<? extends KeyDeserializer> findKeyDeserializer(Annotated annotated) {
        Class<? extends KeyDeserializer> keyUsing;
        JsonDeserialize jsonDeserialize = (JsonDeserialize) annotated.getAnnotation(JsonDeserialize.class);
        if (jsonDeserialize == null || (keyUsing = jsonDeserialize.keyUsing()) == KeyDeserializer.None.class) {
            return null;
        }
        return keyUsing;
    }

    public Class<? extends JsonDeserializer<?>> findContentDeserializer(Annotated annotated) {
        Class<? extends JsonDeserializer<?>> contentUsing;
        JsonDeserialize jsonDeserialize = (JsonDeserialize) annotated.getAnnotation(JsonDeserialize.class);
        if (jsonDeserialize == null || (contentUsing = jsonDeserialize.contentUsing()) == JsonDeserializer.None.class) {
            return null;
        }
        return contentUsing;
    }

    public Class<?> findDeserializationType(Annotated annotated, JavaType javaType, String str) {
        Class<?> value;
        Class<?> as;
        JsonDeserialize jsonDeserialize = (JsonDeserialize) annotated.getAnnotation(JsonDeserialize.class);
        if (jsonDeserialize != null && (as = jsonDeserialize.mo71181as()) != NoClass.class) {
            return as;
        }
        JsonClass jsonClass = (JsonClass) annotated.getAnnotation(JsonClass.class);
        if (jsonClass == null || (value = jsonClass.value()) == NoClass.class) {
            return null;
        }
        return value;
    }

    public Class<?> findDeserializationKeyType(Annotated annotated, JavaType javaType, String str) {
        Class<?> value;
        Class<?> keyAs;
        JsonDeserialize jsonDeserialize = (JsonDeserialize) annotated.getAnnotation(JsonDeserialize.class);
        if (jsonDeserialize != null && (keyAs = jsonDeserialize.keyAs()) != NoClass.class) {
            return keyAs;
        }
        JsonKeyClass jsonKeyClass = (JsonKeyClass) annotated.getAnnotation(JsonKeyClass.class);
        if (jsonKeyClass == null || (value = jsonKeyClass.value()) == NoClass.class) {
            return null;
        }
        return value;
    }

    public Class<?> findDeserializationContentType(Annotated annotated, JavaType javaType, String str) {
        Class<?> value;
        Class<?> contentAs;
        JsonDeserialize jsonDeserialize = (JsonDeserialize) annotated.getAnnotation(JsonDeserialize.class);
        if (jsonDeserialize != null && (contentAs = jsonDeserialize.contentAs()) != NoClass.class) {
            return contentAs;
        }
        JsonContentClass jsonContentClass = (JsonContentClass) annotated.getAnnotation(JsonContentClass.class);
        if (jsonContentClass == null || (value = jsonContentClass.value()) == NoClass.class) {
            return null;
        }
        return value;
    }

    public String findSettablePropertyName(AnnotatedMethod annotatedMethod) {
        JsonProperty jsonProperty = (JsonProperty) annotatedMethod.getAnnotation(JsonProperty.class);
        if (jsonProperty != null) {
            return jsonProperty.value();
        }
        JsonSetter jsonSetter = (JsonSetter) annotatedMethod.getAnnotation(JsonSetter.class);
        if (jsonSetter != null) {
            return jsonSetter.value();
        }
        if (annotatedMethod.hasAnnotation(JsonDeserialize.class) || annotatedMethod.hasAnnotation(JsonView.class)) {
            return "";
        }
        return null;
    }

    public boolean hasAnySetterAnnotation(AnnotatedMethod annotatedMethod) {
        return annotatedMethod.hasAnnotation(JsonAnySetter.class);
    }

    public boolean hasAnyGetterAnnotation(AnnotatedMethod annotatedMethod) {
        return annotatedMethod.hasAnnotation(JsonAnyGetter.class);
    }

    public boolean hasCreatorAnnotation(Annotated annotated) {
        return annotated.hasAnnotation(JsonCreator.class);
    }

    public String findDeserializablePropertyName(AnnotatedField annotatedField) {
        JsonProperty jsonProperty = (JsonProperty) annotatedField.getAnnotation(JsonProperty.class);
        if (jsonProperty != null) {
            return jsonProperty.value();
        }
        if (annotatedField.hasAnnotation(JsonDeserialize.class) || annotatedField.hasAnnotation(JsonView.class)) {
            return "";
        }
        return null;
    }

    public String findPropertyNameForParam(AnnotatedParameter annotatedParameter) {
        JsonProperty jsonProperty;
        if (annotatedParameter == null || (jsonProperty = (JsonProperty) annotatedParameter.getAnnotation(JsonProperty.class)) == null) {
            return null;
        }
        return jsonProperty.value();
    }

    /* access modifiers changed from: protected */
    public boolean _isIgnorable(Annotated annotated) {
        JsonIgnore jsonIgnore = (JsonIgnore) annotated.getAnnotation(JsonIgnore.class);
        return jsonIgnore != null && jsonIgnore.value();
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [org.codehaus.jackson.map.MapperConfig, org.codehaus.jackson.map.MapperConfig<?>] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.codehaus.jackson.map.jsontype.TypeResolverBuilder<?> _findTypeResolver(org.codehaus.jackson.map.MapperConfig<?> r5, org.codehaus.jackson.map.introspect.Annotated r6, org.codehaus.jackson.type.JavaType r7) {
        /*
            r4 = this;
            java.lang.Class<org.codehaus.jackson.annotate.JsonTypeInfo> r0 = org.codehaus.jackson.annotate.JsonTypeInfo.class
            java.lang.annotation.Annotation r0 = r6.getAnnotation(r0)
            org.codehaus.jackson.annotate.JsonTypeInfo r0 = (org.codehaus.jackson.annotate.JsonTypeInfo) r0
            java.lang.Class<org.codehaus.jackson.map.annotate.JsonTypeResolver> r1 = org.codehaus.jackson.map.annotate.JsonTypeResolver.class
            java.lang.annotation.Annotation r1 = r6.getAnnotation(r1)
            org.codehaus.jackson.map.annotate.JsonTypeResolver r1 = (org.codehaus.jackson.map.annotate.JsonTypeResolver) r1
            r2 = 0
            if (r1 == 0) goto L_0x001f
            if (r0 != 0) goto L_0x0016
            return r2
        L_0x0016:
            java.lang.Class r1 = r1.value()
            org.codehaus.jackson.map.jsontype.TypeResolverBuilder r1 = r5.typeResolverBuilderInstance(r6, r1)
            goto L_0x002e
        L_0x001f:
            if (r0 == 0) goto L_0x005f
            org.codehaus.jackson.annotate.JsonTypeInfo$Id r1 = r0.use()
            org.codehaus.jackson.annotate.JsonTypeInfo$Id r3 = org.codehaus.jackson.annotate.JsonTypeInfo.C4904Id.NONE
            if (r1 != r3) goto L_0x002a
            goto L_0x005f
        L_0x002a:
            org.codehaus.jackson.map.jsontype.impl.StdTypeResolverBuilder r1 = r4._constructStdTypeResolverBuilder()
        L_0x002e:
            java.lang.Class<org.codehaus.jackson.map.annotate.JsonTypeIdResolver> r3 = org.codehaus.jackson.map.annotate.JsonTypeIdResolver.class
            java.lang.annotation.Annotation r3 = r6.getAnnotation(r3)
            org.codehaus.jackson.map.annotate.JsonTypeIdResolver r3 = (org.codehaus.jackson.map.annotate.JsonTypeIdResolver) r3
            if (r3 != 0) goto L_0x0039
            goto L_0x0041
        L_0x0039:
            java.lang.Class r2 = r3.value()
            org.codehaus.jackson.map.jsontype.TypeIdResolver r2 = r5.typeIdResolverInstance(r6, r2)
        L_0x0041:
            if (r2 == 0) goto L_0x0046
            r2.init(r7)
        L_0x0046:
            org.codehaus.jackson.annotate.JsonTypeInfo$Id r5 = r0.use()
            org.codehaus.jackson.map.jsontype.TypeResolverBuilder r5 = r1.init(r5, r2)
            org.codehaus.jackson.annotate.JsonTypeInfo$As r6 = r0.include()
            org.codehaus.jackson.map.jsontype.TypeResolverBuilder r5 = r5.inclusion(r6)
            java.lang.String r6 = r0.property()
            org.codehaus.jackson.map.jsontype.TypeResolverBuilder r5 = r5.typeProperty(r6)
            return r5
        L_0x005f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector._findTypeResolver(org.codehaus.jackson.map.MapperConfig, org.codehaus.jackson.map.introspect.Annotated, org.codehaus.jackson.type.JavaType):org.codehaus.jackson.map.jsontype.TypeResolverBuilder");
    }

    /* access modifiers changed from: protected */
    public StdTypeResolverBuilder _constructStdTypeResolverBuilder() {
        return new StdTypeResolverBuilder();
    }
}
