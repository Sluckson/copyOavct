package org.codehaus.jackson.map;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.introspect.Annotated;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.AnnotatedParameter;
import org.codehaus.jackson.map.introspect.NopAnnotationIntrospector;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.jsontype.NamedType;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.type.JavaType;

public abstract class AnnotationIntrospector {
    public VisibilityChecker<?> findAutoDetectVisibility(AnnotatedClass annotatedClass, VisibilityChecker<?> visibilityChecker) {
        return visibilityChecker;
    }

    public abstract Boolean findCachability(AnnotatedClass annotatedClass);

    public abstract Class<? extends JsonDeserializer<?>> findContentDeserializer(Annotated annotated);

    public Class<? extends JsonSerializer<?>> findContentSerializer(Annotated annotated) {
        return null;
    }

    public abstract String findDeserializablePropertyName(AnnotatedField annotatedField);

    public abstract Class<?> findDeserializationContentType(Annotated annotated, JavaType javaType, String str);

    public abstract Class<?> findDeserializationKeyType(Annotated annotated, JavaType javaType, String str);

    public abstract Class<?> findDeserializationType(Annotated annotated, JavaType javaType, String str);

    public abstract String findEnumValue(Enum<?> enumR);

    public Object findFilterId(AnnotatedClass annotatedClass) {
        return null;
    }

    public abstract String findGettablePropertyName(AnnotatedMethod annotatedMethod);

    public abstract Boolean findIgnoreUnknownProperties(AnnotatedClass annotatedClass);

    public abstract Class<? extends KeyDeserializer> findKeyDeserializer(Annotated annotated);

    public Class<? extends JsonSerializer<?>> findKeySerializer(Annotated annotated) {
        return null;
    }

    public abstract String[] findPropertiesToIgnore(AnnotatedClass annotatedClass);

    public TypeResolverBuilder<?> findPropertyContentTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        return null;
    }

    public abstract String findPropertyNameForParam(AnnotatedParameter annotatedParameter);

    public TypeResolverBuilder<?> findPropertyTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        return null;
    }

    public ReferenceProperty findReferenceType(AnnotatedMember annotatedMember) {
        return null;
    }

    public abstract String findRootName(AnnotatedClass annotatedClass);

    public abstract String findSerializablePropertyName(AnnotatedField annotatedField);

    public Class<?> findSerializationContentType(Annotated annotated, JavaType javaType) {
        return null;
    }

    public JsonSerialize.Inclusion findSerializationInclusion(Annotated annotated, JsonSerialize.Inclusion inclusion) {
        return inclusion;
    }

    public Class<?> findSerializationKeyType(Annotated annotated, JavaType javaType) {
        return null;
    }

    public abstract String[] findSerializationPropertyOrder(AnnotatedClass annotatedClass);

    public abstract Boolean findSerializationSortAlphabetically(AnnotatedClass annotatedClass);

    public abstract Class<?> findSerializationType(Annotated annotated);

    public abstract JsonSerialize.Typing findSerializationTyping(Annotated annotated);

    public abstract Class<?>[] findSerializationViews(Annotated annotated);

    public abstract String findSettablePropertyName(AnnotatedMethod annotatedMethod);

    public List<NamedType> findSubtypes(Annotated annotated) {
        return null;
    }

    public String findTypeName(AnnotatedClass annotatedClass) {
        return null;
    }

    public TypeResolverBuilder<?> findTypeResolver(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, JavaType javaType) {
        return null;
    }

    public boolean hasAnyGetterAnnotation(AnnotatedMethod annotatedMethod) {
        return false;
    }

    public boolean hasAnySetterAnnotation(AnnotatedMethod annotatedMethod) {
        return false;
    }

    public abstract boolean hasAsValueAnnotation(AnnotatedMethod annotatedMethod);

    public boolean hasCreatorAnnotation(Annotated annotated) {
        return false;
    }

    public abstract boolean isHandled(Annotation annotation);

    public abstract boolean isIgnorableConstructor(AnnotatedConstructor annotatedConstructor);

    public abstract boolean isIgnorableField(AnnotatedField annotatedField);

    public abstract boolean isIgnorableMethod(AnnotatedMethod annotatedMethod);

    public Boolean isIgnorableType(AnnotatedClass annotatedClass) {
        return null;
    }

    public static class ReferenceProperty {
        private final String _name;
        private final Type _type;

        public enum Type {
            MANAGED_REFERENCE,
            BACK_REFERENCE
        }

        public ReferenceProperty(Type type, String str) {
            this._type = type;
            this._name = str;
        }

        public static ReferenceProperty managed(String str) {
            return new ReferenceProperty(Type.MANAGED_REFERENCE, str);
        }

        public static ReferenceProperty back(String str) {
            return new ReferenceProperty(Type.BACK_REFERENCE, str);
        }

        public Type getType() {
            return this._type;
        }

        public String getName() {
            return this._name;
        }

        public boolean isManagedReference() {
            return this._type == Type.MANAGED_REFERENCE;
        }

        public boolean isBackReference() {
            return this._type == Type.BACK_REFERENCE;
        }
    }

    public static AnnotationIntrospector nopInstance() {
        return NopAnnotationIntrospector.instance;
    }

    public static AnnotationIntrospector pair(AnnotationIntrospector annotationIntrospector, AnnotationIntrospector annotationIntrospector2) {
        return new Pair(annotationIntrospector, annotationIntrospector2);
    }

    public Collection<AnnotationIntrospector> allIntrospectors() {
        return Collections.singletonList(this);
    }

    public Collection<AnnotationIntrospector> allIntrospectors(Collection<AnnotationIntrospector> collection) {
        collection.add(this);
        return collection;
    }

    public Object findSerializer(Annotated annotated) {
        return findSerializer(annotated, (BeanProperty) null);
    }

    @Deprecated
    public Object findSerializer(Annotated annotated, BeanProperty beanProperty) {
        if (beanProperty != null) {
            return findSerializer(annotated);
        }
        return null;
    }

    public Object findDeserializer(Annotated annotated) {
        return findDeserializer(annotated, (BeanProperty) null);
    }

    @Deprecated
    public Object findDeserializer(Annotated annotated, BeanProperty beanProperty) {
        if (beanProperty != null) {
            return findDeserializer(annotated);
        }
        return null;
    }

    public static class Pair extends AnnotationIntrospector {
        protected final AnnotationIntrospector _primary;
        protected final AnnotationIntrospector _secondary;

        public Pair(AnnotationIntrospector annotationIntrospector, AnnotationIntrospector annotationIntrospector2) {
            this._primary = annotationIntrospector;
            this._secondary = annotationIntrospector2;
        }

        public static AnnotationIntrospector create(AnnotationIntrospector annotationIntrospector, AnnotationIntrospector annotationIntrospector2) {
            if (annotationIntrospector == null) {
                return annotationIntrospector2;
            }
            return annotationIntrospector2 == null ? annotationIntrospector : new Pair(annotationIntrospector, annotationIntrospector2);
        }

        public Collection<AnnotationIntrospector> allIntrospectors() {
            return allIntrospectors(new ArrayList());
        }

        public Collection<AnnotationIntrospector> allIntrospectors(Collection<AnnotationIntrospector> collection) {
            this._primary.allIntrospectors(collection);
            this._secondary.allIntrospectors(collection);
            return collection;
        }

        public boolean isHandled(Annotation annotation) {
            return this._primary.isHandled(annotation) || this._secondary.isHandled(annotation);
        }

        public Boolean findCachability(AnnotatedClass annotatedClass) {
            Boolean findCachability = this._primary.findCachability(annotatedClass);
            return findCachability == null ? this._secondary.findCachability(annotatedClass) : findCachability;
        }

        public String findRootName(AnnotatedClass annotatedClass) {
            String findRootName = this._primary.findRootName(annotatedClass);
            if (findRootName == null) {
                return this._secondary.findRootName(annotatedClass);
            }
            if (findRootName.length() > 0) {
                return findRootName;
            }
            String findRootName2 = this._secondary.findRootName(annotatedClass);
            return findRootName2 == null ? findRootName : findRootName2;
        }

        public String[] findPropertiesToIgnore(AnnotatedClass annotatedClass) {
            String[] findPropertiesToIgnore = this._primary.findPropertiesToIgnore(annotatedClass);
            return findPropertiesToIgnore == null ? this._secondary.findPropertiesToIgnore(annotatedClass) : findPropertiesToIgnore;
        }

        public Boolean findIgnoreUnknownProperties(AnnotatedClass annotatedClass) {
            Boolean findIgnoreUnknownProperties = this._primary.findIgnoreUnknownProperties(annotatedClass);
            return findIgnoreUnknownProperties == null ? this._secondary.findIgnoreUnknownProperties(annotatedClass) : findIgnoreUnknownProperties;
        }

        public Boolean isIgnorableType(AnnotatedClass annotatedClass) {
            Boolean isIgnorableType = this._primary.isIgnorableType(annotatedClass);
            return isIgnorableType == null ? this._secondary.isIgnorableType(annotatedClass) : isIgnorableType;
        }

        public Object findFilterId(AnnotatedClass annotatedClass) {
            Object findFilterId = this._primary.findFilterId(annotatedClass);
            return findFilterId == null ? this._secondary.findFilterId(annotatedClass) : findFilterId;
        }

        public VisibilityChecker<?> findAutoDetectVisibility(AnnotatedClass annotatedClass, VisibilityChecker<?> visibilityChecker) {
            return this._primary.findAutoDetectVisibility(annotatedClass, this._secondary.findAutoDetectVisibility(annotatedClass, visibilityChecker));
        }

        public TypeResolverBuilder<?> findTypeResolver(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, JavaType javaType) {
            TypeResolverBuilder<?> findTypeResolver = this._primary.findTypeResolver(mapperConfig, annotatedClass, javaType);
            return findTypeResolver == null ? this._secondary.findTypeResolver(mapperConfig, annotatedClass, javaType) : findTypeResolver;
        }

        public TypeResolverBuilder<?> findPropertyTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
            TypeResolverBuilder<?> findPropertyTypeResolver = this._primary.findPropertyTypeResolver(mapperConfig, annotatedMember, javaType);
            return findPropertyTypeResolver == null ? this._secondary.findPropertyTypeResolver(mapperConfig, annotatedMember, javaType) : findPropertyTypeResolver;
        }

        public TypeResolverBuilder<?> findPropertyContentTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
            TypeResolverBuilder<?> findPropertyContentTypeResolver = this._primary.findPropertyContentTypeResolver(mapperConfig, annotatedMember, javaType);
            return findPropertyContentTypeResolver == null ? this._secondary.findPropertyContentTypeResolver(mapperConfig, annotatedMember, javaType) : findPropertyContentTypeResolver;
        }

        public List<NamedType> findSubtypes(Annotated annotated) {
            List<NamedType> findSubtypes = this._primary.findSubtypes(annotated);
            List<NamedType> findSubtypes2 = this._secondary.findSubtypes(annotated);
            if (findSubtypes == null || findSubtypes.isEmpty()) {
                return findSubtypes2;
            }
            if (findSubtypes2 == null || findSubtypes2.isEmpty()) {
                return findSubtypes;
            }
            ArrayList arrayList = new ArrayList(findSubtypes.size() + findSubtypes2.size());
            arrayList.addAll(findSubtypes);
            arrayList.addAll(findSubtypes2);
            return arrayList;
        }

        public String findTypeName(AnnotatedClass annotatedClass) {
            String findTypeName = this._primary.findTypeName(annotatedClass);
            return (findTypeName == null || findTypeName.length() == 0) ? this._secondary.findTypeName(annotatedClass) : findTypeName;
        }

        public ReferenceProperty findReferenceType(AnnotatedMember annotatedMember) {
            ReferenceProperty findReferenceType = this._primary.findReferenceType(annotatedMember);
            return findReferenceType == null ? this._secondary.findReferenceType(annotatedMember) : findReferenceType;
        }

        public boolean isIgnorableMethod(AnnotatedMethod annotatedMethod) {
            return this._primary.isIgnorableMethod(annotatedMethod) || this._secondary.isIgnorableMethod(annotatedMethod);
        }

        public boolean isIgnorableConstructor(AnnotatedConstructor annotatedConstructor) {
            return this._primary.isIgnorableConstructor(annotatedConstructor) || this._secondary.isIgnorableConstructor(annotatedConstructor);
        }

        public boolean isIgnorableField(AnnotatedField annotatedField) {
            return this._primary.isIgnorableField(annotatedField) || this._secondary.isIgnorableField(annotatedField);
        }

        public Object findSerializer(Annotated annotated, BeanProperty beanProperty) {
            Object findSerializer = this._primary.findSerializer(annotated, beanProperty);
            return findSerializer == null ? this._secondary.findSerializer(annotated, beanProperty) : findSerializer;
        }

        public Object findSerializer(Annotated annotated) {
            Object findSerializer = this._primary.findSerializer(annotated);
            return findSerializer == null ? this._secondary.findSerializer(annotated) : findSerializer;
        }

        public Class<? extends JsonSerializer<?>> findKeySerializer(Annotated annotated) {
            Class<? extends JsonSerializer<?>> findKeySerializer = this._primary.findKeySerializer(annotated);
            return (findKeySerializer == null || findKeySerializer == JsonSerializer.None.class) ? this._secondary.findKeySerializer(annotated) : findKeySerializer;
        }

        public Class<? extends JsonSerializer<?>> findContentSerializer(Annotated annotated) {
            Class<? extends JsonSerializer<?>> findContentSerializer = this._primary.findContentSerializer(annotated);
            return (findContentSerializer == null || findContentSerializer == JsonSerializer.None.class) ? this._secondary.findContentSerializer(annotated) : findContentSerializer;
        }

        public JsonSerialize.Inclusion findSerializationInclusion(Annotated annotated, JsonSerialize.Inclusion inclusion) {
            return this._primary.findSerializationInclusion(annotated, this._secondary.findSerializationInclusion(annotated, inclusion));
        }

        public Class<?> findSerializationType(Annotated annotated) {
            Class<?> findSerializationType = this._primary.findSerializationType(annotated);
            return findSerializationType == null ? this._secondary.findSerializationType(annotated) : findSerializationType;
        }

        public Class<?> findSerializationKeyType(Annotated annotated, JavaType javaType) {
            Class<?> findSerializationKeyType = this._primary.findSerializationKeyType(annotated, javaType);
            return findSerializationKeyType == null ? this._secondary.findSerializationKeyType(annotated, javaType) : findSerializationKeyType;
        }

        public Class<?> findSerializationContentType(Annotated annotated, JavaType javaType) {
            Class<?> findSerializationContentType = this._primary.findSerializationContentType(annotated, javaType);
            return findSerializationContentType == null ? this._secondary.findSerializationContentType(annotated, javaType) : findSerializationContentType;
        }

        public JsonSerialize.Typing findSerializationTyping(Annotated annotated) {
            JsonSerialize.Typing findSerializationTyping = this._primary.findSerializationTyping(annotated);
            return findSerializationTyping == null ? this._secondary.findSerializationTyping(annotated) : findSerializationTyping;
        }

        public Class<?>[] findSerializationViews(Annotated annotated) {
            Class<?>[] findSerializationViews = this._primary.findSerializationViews(annotated);
            return findSerializationViews == null ? this._secondary.findSerializationViews(annotated) : findSerializationViews;
        }

        public String[] findSerializationPropertyOrder(AnnotatedClass annotatedClass) {
            String[] findSerializationPropertyOrder = this._primary.findSerializationPropertyOrder(annotatedClass);
            return findSerializationPropertyOrder == null ? this._secondary.findSerializationPropertyOrder(annotatedClass) : findSerializationPropertyOrder;
        }

        public Boolean findSerializationSortAlphabetically(AnnotatedClass annotatedClass) {
            Boolean findSerializationSortAlphabetically = this._primary.findSerializationSortAlphabetically(annotatedClass);
            return findSerializationSortAlphabetically == null ? this._secondary.findSerializationSortAlphabetically(annotatedClass) : findSerializationSortAlphabetically;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
            r3 = r2._secondary.findGettablePropertyName(r3);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String findGettablePropertyName(org.codehaus.jackson.map.introspect.AnnotatedMethod r3) {
            /*
                r2 = this;
                org.codehaus.jackson.map.AnnotationIntrospector r0 = r2._primary
                java.lang.String r0 = r0.findGettablePropertyName(r3)
                if (r0 != 0) goto L_0x000f
                org.codehaus.jackson.map.AnnotationIntrospector r0 = r2._secondary
                java.lang.String r0 = r0.findGettablePropertyName(r3)
                goto L_0x001e
            L_0x000f:
                int r1 = r0.length()
                if (r1 != 0) goto L_0x001e
                org.codehaus.jackson.map.AnnotationIntrospector r1 = r2._secondary
                java.lang.String r3 = r1.findGettablePropertyName(r3)
                if (r3 == 0) goto L_0x001e
                r0 = r3
            L_0x001e:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.AnnotationIntrospector.Pair.findGettablePropertyName(org.codehaus.jackson.map.introspect.AnnotatedMethod):java.lang.String");
        }

        public boolean hasAsValueAnnotation(AnnotatedMethod annotatedMethod) {
            return this._primary.hasAsValueAnnotation(annotatedMethod) || this._secondary.hasAsValueAnnotation(annotatedMethod);
        }

        public String findEnumValue(Enum<?> enumR) {
            String findEnumValue = this._primary.findEnumValue(enumR);
            return findEnumValue == null ? this._secondary.findEnumValue(enumR) : findEnumValue;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
            r3 = r2._secondary.findSerializablePropertyName(r3);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String findSerializablePropertyName(org.codehaus.jackson.map.introspect.AnnotatedField r3) {
            /*
                r2 = this;
                org.codehaus.jackson.map.AnnotationIntrospector r0 = r2._primary
                java.lang.String r0 = r0.findSerializablePropertyName(r3)
                if (r0 != 0) goto L_0x000f
                org.codehaus.jackson.map.AnnotationIntrospector r0 = r2._secondary
                java.lang.String r0 = r0.findSerializablePropertyName(r3)
                goto L_0x001e
            L_0x000f:
                int r1 = r0.length()
                if (r1 != 0) goto L_0x001e
                org.codehaus.jackson.map.AnnotationIntrospector r1 = r2._secondary
                java.lang.String r3 = r1.findSerializablePropertyName(r3)
                if (r3 == 0) goto L_0x001e
                r0 = r3
            L_0x001e:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.AnnotationIntrospector.Pair.findSerializablePropertyName(org.codehaus.jackson.map.introspect.AnnotatedField):java.lang.String");
        }

        public Object findDeserializer(Annotated annotated) {
            Object findDeserializer = this._primary.findDeserializer(annotated);
            return findDeserializer == null ? this._secondary.findDeserializer(annotated) : findDeserializer;
        }

        public Object findDeserializer(Annotated annotated, BeanProperty beanProperty) {
            Object findDeserializer = this._primary.findDeserializer(annotated, beanProperty);
            return findDeserializer == null ? this._secondary.findDeserializer(annotated, beanProperty) : findDeserializer;
        }

        public Class<? extends KeyDeserializer> findKeyDeserializer(Annotated annotated) {
            Class<? extends KeyDeserializer> findKeyDeserializer = this._primary.findKeyDeserializer(annotated);
            return (findKeyDeserializer == null || findKeyDeserializer == KeyDeserializer.None.class) ? this._secondary.findKeyDeserializer(annotated) : findKeyDeserializer;
        }

        public Class<? extends JsonDeserializer<?>> findContentDeserializer(Annotated annotated) {
            Class<? extends JsonDeserializer<?>> findContentDeserializer = this._primary.findContentDeserializer(annotated);
            return (findContentDeserializer == null || findContentDeserializer == JsonDeserializer.None.class) ? this._secondary.findContentDeserializer(annotated) : findContentDeserializer;
        }

        public Class<?> findDeserializationType(Annotated annotated, JavaType javaType, String str) {
            Class<?> findDeserializationType = this._primary.findDeserializationType(annotated, javaType, str);
            return findDeserializationType == null ? this._secondary.findDeserializationType(annotated, javaType, str) : findDeserializationType;
        }

        public Class<?> findDeserializationKeyType(Annotated annotated, JavaType javaType, String str) {
            Class<?> findDeserializationKeyType = this._primary.findDeserializationKeyType(annotated, javaType, str);
            return findDeserializationKeyType == null ? this._secondary.findDeserializationKeyType(annotated, javaType, str) : findDeserializationKeyType;
        }

        public Class<?> findDeserializationContentType(Annotated annotated, JavaType javaType, String str) {
            Class<?> findDeserializationContentType = this._primary.findDeserializationContentType(annotated, javaType, str);
            return findDeserializationContentType == null ? this._secondary.findDeserializationContentType(annotated, javaType, str) : findDeserializationContentType;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
            r3 = r2._secondary.findSettablePropertyName(r3);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String findSettablePropertyName(org.codehaus.jackson.map.introspect.AnnotatedMethod r3) {
            /*
                r2 = this;
                org.codehaus.jackson.map.AnnotationIntrospector r0 = r2._primary
                java.lang.String r0 = r0.findSettablePropertyName(r3)
                if (r0 != 0) goto L_0x000f
                org.codehaus.jackson.map.AnnotationIntrospector r0 = r2._secondary
                java.lang.String r0 = r0.findSettablePropertyName(r3)
                goto L_0x001e
            L_0x000f:
                int r1 = r0.length()
                if (r1 != 0) goto L_0x001e
                org.codehaus.jackson.map.AnnotationIntrospector r1 = r2._secondary
                java.lang.String r3 = r1.findSettablePropertyName(r3)
                if (r3 == 0) goto L_0x001e
                r0 = r3
            L_0x001e:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.AnnotationIntrospector.Pair.findSettablePropertyName(org.codehaus.jackson.map.introspect.AnnotatedMethod):java.lang.String");
        }

        public boolean hasAnySetterAnnotation(AnnotatedMethod annotatedMethod) {
            return this._primary.hasAnySetterAnnotation(annotatedMethod) || this._secondary.hasAnySetterAnnotation(annotatedMethod);
        }

        public boolean hasAnyGetterAnnotation(AnnotatedMethod annotatedMethod) {
            return this._primary.hasAnyGetterAnnotation(annotatedMethod) || this._secondary.hasAnyGetterAnnotation(annotatedMethod);
        }

        public boolean hasCreatorAnnotation(Annotated annotated) {
            return this._primary.hasCreatorAnnotation(annotated) || this._secondary.hasCreatorAnnotation(annotated);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
            r3 = r2._secondary.findDeserializablePropertyName(r3);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String findDeserializablePropertyName(org.codehaus.jackson.map.introspect.AnnotatedField r3) {
            /*
                r2 = this;
                org.codehaus.jackson.map.AnnotationIntrospector r0 = r2._primary
                java.lang.String r0 = r0.findDeserializablePropertyName(r3)
                if (r0 != 0) goto L_0x000f
                org.codehaus.jackson.map.AnnotationIntrospector r0 = r2._secondary
                java.lang.String r0 = r0.findDeserializablePropertyName(r3)
                goto L_0x001e
            L_0x000f:
                int r1 = r0.length()
                if (r1 != 0) goto L_0x001e
                org.codehaus.jackson.map.AnnotationIntrospector r1 = r2._secondary
                java.lang.String r3 = r1.findDeserializablePropertyName(r3)
                if (r3 == 0) goto L_0x001e
                r0 = r3
            L_0x001e:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.AnnotationIntrospector.Pair.findDeserializablePropertyName(org.codehaus.jackson.map.introspect.AnnotatedField):java.lang.String");
        }

        public String findPropertyNameForParam(AnnotatedParameter annotatedParameter) {
            String findPropertyNameForParam = this._primary.findPropertyNameForParam(annotatedParameter);
            return findPropertyNameForParam == null ? this._secondary.findPropertyNameForParam(annotatedParameter) : findPropertyNameForParam;
        }
    }
}
