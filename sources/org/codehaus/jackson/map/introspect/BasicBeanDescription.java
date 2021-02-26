package org.codehaus.jackson.map.introspect;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.BeanDescription;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.type.TypeBindings;
import org.codehaus.jackson.map.util.Annotations;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

public class BasicBeanDescription extends BeanDescription {
    protected final AnnotationIntrospector _annotationIntrospector;
    protected TypeBindings _bindings;
    protected final AnnotatedClass _classInfo;
    protected final MapperConfig<?> _config;

    public BasicBeanDescription(MapperConfig<?> mapperConfig, JavaType javaType, AnnotatedClass annotatedClass) {
        super(javaType);
        this._config = mapperConfig;
        this._annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        this._classInfo = annotatedClass;
    }

    public boolean hasKnownClassAnnotations() {
        return this._classInfo.hasAnnotations();
    }

    public Annotations getClassAnnotations() {
        return this._classInfo.getAnnotations();
    }

    public TypeBindings bindingsForBeanType() {
        if (this._bindings == null) {
            this._bindings = new TypeBindings(this._config.getTypeFactory(), this._type);
        }
        return this._bindings;
    }

    public AnnotatedClass getClassInfo() {
        return this._classInfo;
    }

    public AnnotatedMethod findMethod(String str, Class<?>[] clsArr) {
        return this._classInfo.findMethod(str, clsArr);
    }

    public Object instantiateBean(boolean z) {
        AnnotatedConstructor defaultConstructor = this._classInfo.getDefaultConstructor();
        if (defaultConstructor == null) {
            return null;
        }
        if (z) {
            defaultConstructor.fixAccess();
        }
        try {
            return defaultConstructor.getAnnotated().newInstance(new Object[0]);
        } catch (Exception e) {
            e = e;
            while (e.getCause() != null) {
                e = e.getCause();
            }
            if (e instanceof Error) {
                throw ((Error) e);
            } else if (e instanceof RuntimeException) {
                throw ((RuntimeException) e);
            } else {
                throw new IllegalArgumentException("Failed to instantiate bean of type " + this._classInfo.getAnnotated().getName() + ": (" + e.getClass().getName() + ") " + e.getMessage(), e);
            }
        }
    }

    public LinkedHashMap<String, AnnotatedMethod> findGetters(VisibilityChecker<?> visibilityChecker, Collection<String> collection) {
        AnnotatedMethod annotatedMethod;
        String okNameForIsGetter;
        LinkedHashMap<String, AnnotatedMethod> linkedHashMap = new LinkedHashMap<>();
        PropertyNamingStrategy propertyNamingStrategy = this._config.getPropertyNamingStrategy();
        for (AnnotatedMethod next : this._classInfo.memberMethods()) {
            if (next.getParameterCount() == 0) {
                String findGettablePropertyName = this._annotationIntrospector.findGettablePropertyName(next);
                if (findGettablePropertyName == null) {
                    String name = next.getName();
                    if (name.startsWith("get")) {
                        if (!visibilityChecker.isGetterVisible(next)) {
                            continue;
                        } else {
                            okNameForIsGetter = okNameForGetter(next, name);
                        }
                    } else if (!visibilityChecker.isIsGetterVisible(next)) {
                        continue;
                    } else {
                        okNameForIsGetter = okNameForIsGetter(next, name);
                    }
                    if (findGettablePropertyName != null && !this._annotationIntrospector.hasAnyGetterAnnotation(next)) {
                        if (propertyNamingStrategy != null) {
                            findGettablePropertyName = propertyNamingStrategy.nameForGetterMethod(this._config, next, findGettablePropertyName);
                        }
                    }
                } else if (findGettablePropertyName.length() == 0) {
                    findGettablePropertyName = okNameForAnyGetter(next, next.getName());
                    if (findGettablePropertyName == null) {
                        findGettablePropertyName = next.getName();
                    }
                    if (propertyNamingStrategy != null) {
                        findGettablePropertyName = propertyNamingStrategy.nameForGetterMethod(this._config, next, findGettablePropertyName);
                    }
                }
                if ((collection == null || !collection.contains(findGettablePropertyName)) && (annotatedMethod = (AnnotatedMethod) linkedHashMap.put(findGettablePropertyName, next)) != null) {
                    String fullName = annotatedMethod.getFullName();
                    String fullName2 = next.getFullName();
                    throw new IllegalArgumentException("Conflicting getter definitions for property \"" + findGettablePropertyName + "\": " + fullName + " vs " + fullName2);
                }
            }
        }
        return linkedHashMap;
    }

    public AnnotatedMethod findJsonValueMethod() {
        AnnotatedMethod annotatedMethod = null;
        for (AnnotatedMethod next : this._classInfo.memberMethods()) {
            if (this._annotationIntrospector.hasAsValueAnnotation(next)) {
                if (annotatedMethod != null) {
                    throw new IllegalArgumentException("Multiple methods with active 'as-value' annotation (" + annotatedMethod.getName() + "(), " + next.getName() + ")");
                } else if (ClassUtil.hasGetterSignature(next.getAnnotated())) {
                    annotatedMethod = next;
                } else {
                    throw new IllegalArgumentException("Method " + next.getName() + "() marked with an 'as-value' annotation, but does not have valid getter signature (non-static, takes no args, returns a value)");
                }
            }
        }
        return annotatedMethod;
    }

    public Constructor<?> findDefaultConstructor() {
        AnnotatedConstructor defaultConstructor = this._classInfo.getDefaultConstructor();
        if (defaultConstructor == null) {
            return null;
        }
        return defaultConstructor.getAnnotated();
    }

    public List<AnnotatedConstructor> getConstructors() {
        return this._classInfo.getConstructors();
    }

    public List<AnnotatedMethod> getFactoryMethods() {
        List<AnnotatedMethod> staticMethods = this._classInfo.getStaticMethods();
        if (staticMethods.isEmpty()) {
            return staticMethods;
        }
        ArrayList arrayList = new ArrayList();
        for (AnnotatedMethod next : staticMethods) {
            if (isFactoryMethod(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public Constructor<?> findSingleArgConstructor(Class<?>... clsArr) {
        for (AnnotatedConstructor next : this._classInfo.getConstructors()) {
            if (next.getParameterCount() == 1) {
                Class<?> parameterClass = next.getParameterClass(0);
                for (Class<?> cls : clsArr) {
                    if (cls == parameterClass) {
                        return next.getAnnotated();
                    }
                }
                continue;
            }
        }
        return null;
    }

    public Method findFactoryMethod(Class<?>... clsArr) {
        for (AnnotatedMethod next : this._classInfo.getStaticMethods()) {
            if (isFactoryMethod(next)) {
                Class<?> parameterClass = next.getParameterClass(0);
                for (Class<?> isAssignableFrom : clsArr) {
                    if (parameterClass.isAssignableFrom(isAssignableFrom)) {
                        return next.getAnnotated();
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean isFactoryMethod(AnnotatedMethod annotatedMethod) {
        if (!getBeanClass().isAssignableFrom(annotatedMethod.getRawType())) {
            return false;
        }
        if (!this._annotationIntrospector.hasCreatorAnnotation(annotatedMethod) && !"valueOf".equals(annotatedMethod.getName())) {
            return false;
        }
        return true;
    }

    public List<String> findCreatorPropertyNames() {
        String findPropertyNameForParam;
        ArrayList arrayList = null;
        int i = 0;
        while (i < 2) {
            for (AnnotatedWithParams annotatedWithParams : i == 0 ? getConstructors() : getFactoryMethods()) {
                int parameterCount = annotatedWithParams.getParameterCount();
                if (parameterCount >= 1 && (findPropertyNameForParam = this._annotationIntrospector.findPropertyNameForParam(annotatedWithParams.getParameter(0))) != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(findPropertyNameForParam);
                    for (int i2 = 1; i2 < parameterCount; i2++) {
                        arrayList.add(this._annotationIntrospector.findPropertyNameForParam(annotatedWithParams.getParameter(i2)));
                    }
                }
            }
            i++;
        }
        return arrayList == null ? Collections.emptyList() : arrayList;
    }

    public LinkedHashMap<String, AnnotatedField> findSerializableFields(VisibilityChecker<?> visibilityChecker, Collection<String> collection) {
        return _findPropertyFields(visibilityChecker, collection, true);
    }

    public JsonSerialize.Inclusion findSerializationInclusion(JsonSerialize.Inclusion inclusion) {
        return this._annotationIntrospector.findSerializationInclusion(this._classInfo, inclusion);
    }

    public LinkedHashMap<String, AnnotatedMethod> findSetters(VisibilityChecker<?> visibilityChecker) {
        LinkedHashMap<String, AnnotatedMethod> linkedHashMap = new LinkedHashMap<>();
        PropertyNamingStrategy propertyNamingStrategy = this._config.getPropertyNamingStrategy();
        for (AnnotatedMethod next : this._classInfo.memberMethods()) {
            if (next.getParameterCount() == 1) {
                String findSettablePropertyName = this._annotationIntrospector.findSettablePropertyName(next);
                if (findSettablePropertyName != null) {
                    if (findSettablePropertyName.length() == 0) {
                        findSettablePropertyName = okNameForSetter(next);
                        if (findSettablePropertyName == null) {
                            findSettablePropertyName = next.getName();
                        }
                        if (propertyNamingStrategy != null) {
                            findSettablePropertyName = propertyNamingStrategy.nameForSetterMethod(this._config, next, findSettablePropertyName);
                        }
                    }
                } else if (visibilityChecker.isSetterVisible(next) && (findSettablePropertyName = okNameForSetter(next)) != null) {
                    if (propertyNamingStrategy != null) {
                        findSettablePropertyName = propertyNamingStrategy.nameForSetterMethod(this._config, next, findSettablePropertyName);
                    }
                }
                AnnotatedMethod annotatedMethod = (AnnotatedMethod) linkedHashMap.put(findSettablePropertyName, next);
                if (annotatedMethod == null) {
                    continue;
                } else if (annotatedMethod.getDeclaringClass() != next.getDeclaringClass()) {
                    linkedHashMap.put(findSettablePropertyName, annotatedMethod);
                } else {
                    String fullName = annotatedMethod.getFullName();
                    String fullName2 = next.getFullName();
                    throw new IllegalArgumentException("Conflicting setter definitions for property \"" + findSettablePropertyName + "\": " + fullName + " vs " + fullName2);
                }
            }
        }
        return linkedHashMap;
    }

    public AnnotatedMethod findAnySetter() throws IllegalArgumentException {
        AnnotatedMethod annotatedMethod = null;
        for (AnnotatedMethod next : this._classInfo.memberMethods()) {
            if (this._annotationIntrospector.hasAnySetterAnnotation(next)) {
                if (annotatedMethod == null) {
                    int parameterCount = next.getParameterCount();
                    if (parameterCount == 2) {
                        Class<?> parameterClass = next.getParameterClass(0);
                        if (parameterClass == String.class || parameterClass == Object.class) {
                            annotatedMethod = next;
                        } else {
                            throw new IllegalArgumentException("Invalid 'any-setter' annotation on method " + next.getName() + "(): first argument not of type String or Object, but " + parameterClass.getName());
                        }
                    } else {
                        throw new IllegalArgumentException("Invalid 'any-setter' annotation on method " + next.getName() + "(): takes " + parameterCount + " parameters, should take 2");
                    }
                } else {
                    throw new IllegalArgumentException("Multiple methods with 'any-setter' annotation (" + annotatedMethod.getName() + "(), " + next.getName() + ")");
                }
            }
        }
        return annotatedMethod;
    }

    public AnnotatedMethod findAnyGetter() throws IllegalArgumentException {
        AnnotatedMethod annotatedMethod = null;
        for (AnnotatedMethod next : this._classInfo.memberMethods()) {
            if (this._annotationIntrospector.hasAnyGetterAnnotation(next)) {
                if (annotatedMethod == null) {
                    if (Map.class.isAssignableFrom(next.getRawType())) {
                        annotatedMethod = next;
                    } else {
                        throw new IllegalArgumentException("Invalid 'any-getter' annotation on method " + next.getName() + "(): return type is not instance of java.util.Map");
                    }
                } else {
                    throw new IllegalArgumentException("Multiple methods with 'any-getter' annotation (" + annotatedMethod.getName() + "(), " + next.getName() + ")");
                }
            }
        }
        return annotatedMethod;
    }

    public Map<String, AnnotatedMember> findBackReferenceProperties() {
        AnnotationIntrospector.ReferenceProperty findReferenceType;
        HashMap hashMap = null;
        for (AnnotatedMethod next : this._classInfo.memberMethods()) {
            if (next.getParameterCount() == 1 && (findReferenceType = this._annotationIntrospector.findReferenceType(next)) != null && findReferenceType.isBackReference()) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                if (hashMap.put(findReferenceType.getName(), next) != null) {
                    throw new IllegalArgumentException("Multiple back-reference properties with name '" + findReferenceType.getName() + "'");
                }
            }
        }
        for (AnnotatedField next2 : this._classInfo.fields()) {
            AnnotationIntrospector.ReferenceProperty findReferenceType2 = this._annotationIntrospector.findReferenceType(next2);
            if (findReferenceType2 != null && findReferenceType2.isBackReference()) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                if (hashMap.put(findReferenceType2.getName(), next2) != null) {
                    throw new IllegalArgumentException("Multiple back-reference properties with name '" + findReferenceType2.getName() + "'");
                }
            }
        }
        return hashMap;
    }

    public LinkedHashMap<String, AnnotatedField> findDeserializableFields(VisibilityChecker<?> visibilityChecker, Collection<String> collection) {
        return _findPropertyFields(visibilityChecker, collection, false);
    }

    public String okNameForAnyGetter(AnnotatedMethod annotatedMethod, String str) {
        String okNameForIsGetter = okNameForIsGetter(annotatedMethod, str);
        return okNameForIsGetter == null ? okNameForGetter(annotatedMethod, str) : okNameForIsGetter;
    }

    public String okNameForGetter(AnnotatedMethod annotatedMethod, String str) {
        if (!str.startsWith("get")) {
            return null;
        }
        if ("getCallbacks".equals(str)) {
            if (isCglibGetCallbacks(annotatedMethod)) {
                return null;
            }
        } else if ("getMetaClass".equals(str) && isGroovyMetaClassGetter(annotatedMethod)) {
            return null;
        }
        return mangleGetterName(annotatedMethod, str.substring(3));
    }

    public String okNameForIsGetter(AnnotatedMethod annotatedMethod, String str) {
        if (!str.startsWith("is")) {
            return null;
        }
        Class<?> rawType = annotatedMethod.getRawType();
        if (rawType == Boolean.class || rawType == Boolean.TYPE) {
            return mangleGetterName(annotatedMethod, str.substring(2));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public String mangleGetterName(Annotated annotated, String str) {
        return manglePropertyName(str);
    }

    /* access modifiers changed from: protected */
    public boolean isCglibGetCallbacks(AnnotatedMethod annotatedMethod) {
        Package packageR;
        Class<?> rawType = annotatedMethod.getRawType();
        if (!(rawType == null || !rawType.isArray() || (packageR = rawType.getComponentType().getPackage()) == null)) {
            String name = packageR.getName();
            if (name.startsWith("net.sf.cglib") || name.startsWith("org.hibernate.repackage.cglib")) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isGroovyMetaClassSetter(AnnotatedMethod annotatedMethod) {
        Package packageR = annotatedMethod.getParameterClass(0).getPackage();
        if (packageR == null || !packageR.getName().startsWith("groovy.lang")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isGroovyMetaClassGetter(AnnotatedMethod annotatedMethod) {
        Package packageR;
        Class<?> rawType = annotatedMethod.getRawType();
        if (rawType == null || rawType.isArray() || (packageR = rawType.getPackage()) == null || !packageR.getName().startsWith("groovy.lang")) {
            return false;
        }
        return true;
    }

    public String okNameForSetter(AnnotatedMethod annotatedMethod) {
        String mangleSetterName;
        String name = annotatedMethod.getName();
        if (!name.startsWith("set") || (mangleSetterName = mangleSetterName(annotatedMethod, name.substring(3))) == null) {
            return null;
        }
        if (!"metaClass".equals(mangleSetterName) || !isGroovyMetaClassSetter(annotatedMethod)) {
            return mangleSetterName;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public String mangleSetterName(Annotated annotated, String str) {
        return manglePropertyName(str);
    }

    public LinkedHashMap<String, AnnotatedField> _findPropertyFields(VisibilityChecker<?> visibilityChecker, Collection<String> collection, boolean z) {
        AnnotatedField annotatedField;
        LinkedHashMap<String, AnnotatedField> linkedHashMap = new LinkedHashMap<>();
        PropertyNamingStrategy propertyNamingStrategy = this._config.getPropertyNamingStrategy();
        for (AnnotatedField next : this._classInfo.fields()) {
            String findSerializablePropertyName = z ? this._annotationIntrospector.findSerializablePropertyName(next) : this._annotationIntrospector.findDeserializablePropertyName(next);
            if (findSerializablePropertyName != null) {
                if (findSerializablePropertyName.length() == 0) {
                    findSerializablePropertyName = next.getName();
                    if (propertyNamingStrategy != null) {
                        findSerializablePropertyName = propertyNamingStrategy.nameForField(this._config, next, findSerializablePropertyName);
                    }
                }
            } else if (!visibilityChecker.isFieldVisible(next)) {
                continue;
            } else {
                findSerializablePropertyName = next.getName();
                if (propertyNamingStrategy != null) {
                    findSerializablePropertyName = propertyNamingStrategy.nameForField(this._config, next, findSerializablePropertyName);
                }
            }
            if ((collection == null || !collection.contains(findSerializablePropertyName)) && (annotatedField = (AnnotatedField) linkedHashMap.put(findSerializablePropertyName, next)) != null && annotatedField.getDeclaringClass() == next.getDeclaringClass()) {
                String fullName = annotatedField.getFullName();
                String fullName2 = next.getFullName();
                throw new IllegalArgumentException("Multiple fields representing property \"" + findSerializablePropertyName + "\": " + fullName + " vs " + fullName2);
            }
        }
        return linkedHashMap;
    }

    public static String manglePropertyName(String str) {
        int length = str.length();
        StringBuilder sb = null;
        if (length == 0) {
            return null;
        }
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            char lowerCase = Character.toLowerCase(charAt);
            if (charAt == lowerCase) {
                break;
            }
            if (sb == null) {
                sb = new StringBuilder(str);
            }
            sb.setCharAt(i, lowerCase);
        }
        return sb == null ? str : sb.toString();
    }

    public static String descFor(AnnotatedElement annotatedElement) {
        if (annotatedElement instanceof Class) {
            return "class " + ((Class) annotatedElement).getName();
        } else if (annotatedElement instanceof Method) {
            Method method = (Method) annotatedElement;
            return "method " + method.getName() + " (from class " + method.getDeclaringClass().getName() + ")";
        } else if (annotatedElement instanceof Constructor) {
            return "constructor() (from class " + ((Constructor) annotatedElement).getDeclaringClass().getName() + ")";
        } else {
            return "unknown type [" + annotatedElement.getClass() + "]";
        }
    }
}
