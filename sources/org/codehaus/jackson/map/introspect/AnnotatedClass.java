package org.codehaus.jackson.map.introspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ClassIntrospector;
import org.codehaus.jackson.map.util.Annotations;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ClassUtil;

public final class AnnotatedClass extends Annotated {
    private static final AnnotationMap[] NO_ANNOTATION_MAPS = new AnnotationMap[0];
    protected final AnnotationIntrospector _annotationIntrospector;
    protected final Class<?> _class;
    protected AnnotationMap _classAnnotations;
    protected List<AnnotatedConstructor> _constructors;
    protected List<AnnotatedMethod> _creatorMethods;
    protected AnnotatedConstructor _defaultConstructor;
    protected List<AnnotatedField> _fields;
    protected List<AnnotatedField> _ignoredFields;
    protected List<AnnotatedMethod> _ignoredMethods;
    protected AnnotatedMethodMap _memberMethods;
    protected final ClassIntrospector.MixInResolver _mixInResolver;
    protected final Class<?> _primaryMixIn;
    protected final Collection<Class<?>> _superTypes;

    private AnnotatedClass(Class<?> cls, List<Class<?>> list, AnnotationIntrospector annotationIntrospector, ClassIntrospector.MixInResolver mixInResolver) {
        this._class = cls;
        this._superTypes = list;
        this._annotationIntrospector = annotationIntrospector;
        this._mixInResolver = mixInResolver;
        ClassIntrospector.MixInResolver mixInResolver2 = this._mixInResolver;
        this._primaryMixIn = mixInResolver2 == null ? null : mixInResolver2.findMixInClassFor(this._class);
    }

    public static AnnotatedClass construct(Class<?> cls, AnnotationIntrospector annotationIntrospector, ClassIntrospector.MixInResolver mixInResolver) {
        AnnotatedClass annotatedClass = new AnnotatedClass(cls, ClassUtil.findSuperTypes(cls, (Class<?>) null), annotationIntrospector, mixInResolver);
        annotatedClass.resolveClassAnnotations();
        return annotatedClass;
    }

    public static AnnotatedClass constructWithoutSuperTypes(Class<?> cls, AnnotationIntrospector annotationIntrospector, ClassIntrospector.MixInResolver mixInResolver) {
        AnnotatedClass annotatedClass = new AnnotatedClass(cls, Collections.emptyList(), annotationIntrospector, mixInResolver);
        annotatedClass.resolveClassAnnotations();
        return annotatedClass;
    }

    public Class<?> getAnnotated() {
        return this._class;
    }

    public int getModifiers() {
        return this._class.getModifiers();
    }

    public String getName() {
        return this._class.getName();
    }

    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        AnnotationMap annotationMap = this._classAnnotations;
        if (annotationMap == null) {
            return null;
        }
        return annotationMap.get(cls);
    }

    public Type getGenericType() {
        return this._class;
    }

    public Class<?> getRawType() {
        return this._class;
    }

    public Annotations getAnnotations() {
        return this._classAnnotations;
    }

    public boolean hasAnnotations() {
        return this._classAnnotations.size() > 0;
    }

    public AnnotatedConstructor getDefaultConstructor() {
        return this._defaultConstructor;
    }

    public List<AnnotatedConstructor> getConstructors() {
        List<AnnotatedConstructor> list = this._constructors;
        return list == null ? Collections.emptyList() : list;
    }

    public List<AnnotatedMethod> getStaticMethods() {
        List<AnnotatedMethod> list = this._creatorMethods;
        return list == null ? Collections.emptyList() : list;
    }

    public Iterable<AnnotatedMethod> memberMethods() {
        return this._memberMethods;
    }

    public Iterable<AnnotatedMethod> ignoredMemberMethods() {
        List<AnnotatedMethod> list = this._ignoredMethods;
        return list == null ? Collections.emptyList() : list;
    }

    public int getMemberMethodCount() {
        return this._memberMethods.size();
    }

    public AnnotatedMethod findMethod(String str, Class<?>[] clsArr) {
        return this._memberMethods.find(str, clsArr);
    }

    public int getFieldCount() {
        List<AnnotatedField> list = this._fields;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Iterable<AnnotatedField> fields() {
        List<AnnotatedField> list = this._fields;
        return list == null ? Collections.emptyList() : list;
    }

    public Iterable<AnnotatedField> ignoredFields() {
        List<AnnotatedField> list = this._ignoredFields;
        return list == null ? Collections.emptyList() : list;
    }

    /* access modifiers changed from: protected */
    public void resolveClassAnnotations() {
        this._classAnnotations = new AnnotationMap();
        Class<?> cls = this._primaryMixIn;
        if (cls != null) {
            _addClassMixIns(this._classAnnotations, this._class, cls);
        }
        for (Annotation annotation : this._class.getDeclaredAnnotations()) {
            if (this._annotationIntrospector.isHandled(annotation)) {
                this._classAnnotations.addIfNotPresent(annotation);
            }
        }
        for (Class next : this._superTypes) {
            _addClassMixIns(this._classAnnotations, next);
            for (Annotation annotation2 : next.getDeclaredAnnotations()) {
                if (this._annotationIntrospector.isHandled(annotation2)) {
                    this._classAnnotations.addIfNotPresent(annotation2);
                }
            }
        }
        _addClassMixIns(this._classAnnotations, Object.class);
    }

    /* access modifiers changed from: protected */
    public void _addClassMixIns(AnnotationMap annotationMap, Class<?> cls) {
        ClassIntrospector.MixInResolver mixInResolver = this._mixInResolver;
        if (mixInResolver != null) {
            _addClassMixIns(annotationMap, cls, mixInResolver.findMixInClassFor(cls));
        }
    }

    /* access modifiers changed from: protected */
    public void _addClassMixIns(AnnotationMap annotationMap, Class<?> cls, Class<?> cls2) {
        if (cls2 != null) {
            for (Annotation annotation : cls2.getDeclaredAnnotations()) {
                if (this._annotationIntrospector.isHandled(annotation)) {
                    annotationMap.addIfNotPresent(annotation);
                }
            }
            for (Class<?> declaredAnnotations : ClassUtil.findSuperTypes(cls2, cls)) {
                for (Annotation annotation2 : declaredAnnotations.getDeclaredAnnotations()) {
                    if (this._annotationIntrospector.isHandled(annotation2)) {
                        annotationMap.addIfNotPresent(annotation2);
                    }
                }
            }
        }
    }

    public void resolveCreators(boolean z) {
        List<AnnotatedMethod> list;
        this._constructors = null;
        for (Constructor constructor : this._class.getDeclaredConstructors()) {
            if (constructor.getParameterTypes().length == 0) {
                this._defaultConstructor = _constructConstructor(constructor, true);
            } else if (z) {
                if (this._constructors == null) {
                    this._constructors = new ArrayList();
                }
                this._constructors.add(_constructConstructor(constructor, false));
            }
        }
        if (!(this._primaryMixIn == null || (this._defaultConstructor == null && this._constructors == null))) {
            _addConstructorMixIns(this._primaryMixIn);
        }
        AnnotationIntrospector annotationIntrospector = this._annotationIntrospector;
        if (annotationIntrospector != null) {
            AnnotatedConstructor annotatedConstructor = this._defaultConstructor;
            if (annotatedConstructor != null && annotationIntrospector.isIgnorableConstructor(annotatedConstructor)) {
                this._defaultConstructor = null;
            }
            List<AnnotatedConstructor> list2 = this._constructors;
            if (list2 != null) {
                int size = list2.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    } else if (this._annotationIntrospector.isIgnorableConstructor(this._constructors.get(size))) {
                        this._constructors.remove(size);
                    }
                }
            }
        }
        this._creatorMethods = null;
        if (z) {
            for (Method method : this._class.getDeclaredMethods()) {
                if (Modifier.isStatic(method.getModifiers()) && method.getParameterTypes().length >= 1) {
                    if (this._creatorMethods == null) {
                        this._creatorMethods = new ArrayList();
                    }
                    this._creatorMethods.add(_constructCreatorMethod(method));
                }
            }
            Class<?> cls = this._primaryMixIn;
            if (!(cls == null || this._creatorMethods == null)) {
                _addFactoryMixIns(cls);
            }
            if (this._annotationIntrospector != null && (list = this._creatorMethods) != null) {
                int size2 = list.size();
                while (true) {
                    size2--;
                    if (size2 < 0) {
                        return;
                    }
                    if (this._annotationIntrospector.isIgnorableMethod(this._creatorMethods.get(size2))) {
                        this._creatorMethods.remove(size2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _addConstructorMixIns(Class<?> cls) {
        List<AnnotatedConstructor> list = this._constructors;
        int size = list == null ? 0 : list.size();
        MemberKey[] memberKeyArr = null;
        for (Constructor constructor : cls.getDeclaredConstructors()) {
            if (constructor.getParameterTypes().length != 0) {
                if (memberKeyArr == null) {
                    memberKeyArr = new MemberKey[size];
                    for (int i = 0; i < size; i++) {
                        memberKeyArr[i] = new MemberKey((Constructor<?>) this._constructors.get(i).getAnnotated());
                    }
                }
                MemberKey memberKey = new MemberKey((Constructor<?>) constructor);
                int i2 = 0;
                while (true) {
                    if (i2 < size) {
                        if (memberKey.equals(memberKeyArr[i2])) {
                            _addMixOvers((Constructor<?>) constructor, this._constructors.get(i2), true);
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            } else {
                AnnotatedConstructor annotatedConstructor = this._defaultConstructor;
                if (annotatedConstructor != null) {
                    _addMixOvers((Constructor<?>) constructor, annotatedConstructor, false);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _addFactoryMixIns(Class<?> cls) {
        int size = this._creatorMethods.size();
        MemberKey[] memberKeyArr = null;
        for (Method method : cls.getDeclaredMethods()) {
            if (Modifier.isStatic(method.getModifiers()) && method.getParameterTypes().length != 0) {
                if (memberKeyArr == null) {
                    memberKeyArr = new MemberKey[size];
                    for (int i = 0; i < size; i++) {
                        memberKeyArr[i] = new MemberKey(this._creatorMethods.get(i).getAnnotated());
                    }
                }
                MemberKey memberKey = new MemberKey(method);
                int i2 = 0;
                while (true) {
                    if (i2 < size) {
                        if (memberKey.equals(memberKeyArr[i2])) {
                            _addMixOvers(method, this._creatorMethods.get(i2), true);
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public void resolveMemberMethods(MethodFilter methodFilter, boolean z) {
        Class<?> findMixInClassFor;
        this._memberMethods = new AnnotatedMethodMap();
        AnnotatedMethodMap annotatedMethodMap = new AnnotatedMethodMap();
        _addMemberMethods(this._class, methodFilter, this._memberMethods, this._primaryMixIn, annotatedMethodMap);
        for (Class next : this._superTypes) {
            ClassIntrospector.MixInResolver mixInResolver = this._mixInResolver;
            _addMemberMethods(next, methodFilter, this._memberMethods, mixInResolver == null ? null : mixInResolver.findMixInClassFor(next), annotatedMethodMap);
        }
        ClassIntrospector.MixInResolver mixInResolver2 = this._mixInResolver;
        if (!(mixInResolver2 == null || (findMixInClassFor = mixInResolver2.findMixInClassFor(Object.class)) == null)) {
            _addMethodMixIns(methodFilter, this._memberMethods, findMixInClassFor, annotatedMethodMap);
        }
        if (this._annotationIntrospector != null) {
            if (!annotatedMethodMap.isEmpty()) {
                Iterator<AnnotatedMethod> it = annotatedMethodMap.iterator();
                while (it.hasNext()) {
                    AnnotatedMethod next2 = it.next();
                    try {
                        Method declaredMethod = Object.class.getDeclaredMethod(next2.getName(), next2.getParameterClasses());
                        if (declaredMethod != null) {
                            AnnotatedMethod _constructMethod = _constructMethod(declaredMethod);
                            _addMixOvers(next2.getAnnotated(), _constructMethod, false);
                            this._memberMethods.add(_constructMethod);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            Iterator<AnnotatedMethod> it2 = this._memberMethods.iterator();
            while (it2.hasNext()) {
                AnnotatedMethod next3 = it2.next();
                if (this._annotationIntrospector.isIgnorableMethod(next3)) {
                    it2.remove();
                    if (z) {
                        this._ignoredMethods = ArrayBuilders.addToList(this._ignoredMethods, next3);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _addMemberMethods(Class<?> cls, MethodFilter methodFilter, AnnotatedMethodMap annotatedMethodMap, Class<?> cls2, AnnotatedMethodMap annotatedMethodMap2) {
        if (cls2 != null) {
            _addMethodMixIns(methodFilter, annotatedMethodMap, cls2, annotatedMethodMap2);
        }
        if (cls != null) {
            for (Method method : cls.getDeclaredMethods()) {
                if (_isIncludableMethod(method, methodFilter)) {
                    AnnotatedMethod find = annotatedMethodMap.find(method);
                    if (find == null) {
                        AnnotatedMethod _constructMethod = _constructMethod(method);
                        annotatedMethodMap.add(_constructMethod);
                        AnnotatedMethod remove = annotatedMethodMap2.remove(method);
                        if (remove != null) {
                            _addMixOvers(remove.getAnnotated(), _constructMethod, false);
                        }
                    } else {
                        _addMixUnders(method, find);
                        if (find.getDeclaringClass().isInterface() && !method.getDeclaringClass().isInterface()) {
                            annotatedMethodMap.add(find.withMethod(method));
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _addMethodMixIns(MethodFilter methodFilter, AnnotatedMethodMap annotatedMethodMap, Class<?> cls, AnnotatedMethodMap annotatedMethodMap2) {
        for (Method method : cls.getDeclaredMethods()) {
            if (_isIncludableMethod(method, methodFilter)) {
                AnnotatedMethod find = annotatedMethodMap.find(method);
                if (find != null) {
                    _addMixUnders(method, find);
                } else {
                    annotatedMethodMap2.add(_constructMethod(method));
                }
            }
        }
    }

    public void resolveFields(boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        _addFields(linkedHashMap, this._class);
        if (this._annotationIntrospector != null) {
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                AnnotatedField annotatedField = (AnnotatedField) ((Map.Entry) it.next()).getValue();
                if (this._annotationIntrospector.isIgnorableField(annotatedField)) {
                    it.remove();
                    if (z) {
                        this._ignoredFields = ArrayBuilders.addToList(this._ignoredFields, annotatedField);
                    }
                }
            }
        }
        if (linkedHashMap.isEmpty()) {
            this._fields = Collections.emptyList();
            return;
        }
        this._fields = new ArrayList(linkedHashMap.size());
        this._fields.addAll(linkedHashMap.values());
    }

    /* access modifiers changed from: protected */
    public void _addFields(Map<String, AnnotatedField> map, Class<?> cls) {
        Class<?> findMixInClassFor;
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            _addFields(map, superclass);
            for (Field field : cls.getDeclaredFields()) {
                if (_isIncludableField(field)) {
                    map.put(field.getName(), _constructField(field));
                }
            }
            ClassIntrospector.MixInResolver mixInResolver = this._mixInResolver;
            if (mixInResolver != null && (findMixInClassFor = mixInResolver.findMixInClassFor(cls)) != null) {
                _addFieldMixIns(findMixInClassFor, map);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _addFieldMixIns(Class<?> cls, Map<String, AnnotatedField> map) {
        AnnotatedField annotatedField;
        for (Field field : cls.getDeclaredFields()) {
            if (_isIncludableField(field) && (annotatedField = map.get(field.getName())) != null) {
                for (Annotation annotation : field.getDeclaredAnnotations()) {
                    if (this._annotationIntrospector.isHandled(annotation)) {
                        annotatedField.addOrOverride(annotation);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public AnnotatedMethod _constructMethod(Method method) {
        if (this._annotationIntrospector == null) {
            return new AnnotatedMethod(method, _emptyAnnotationMap(), (AnnotationMap[]) null);
        }
        return new AnnotatedMethod(method, _collectRelevantAnnotations(method.getDeclaredAnnotations()), (AnnotationMap[]) null);
    }

    /* access modifiers changed from: protected */
    public AnnotatedConstructor _constructConstructor(Constructor<?> constructor, boolean z) {
        if (this._annotationIntrospector == null) {
            return new AnnotatedConstructor(constructor, _emptyAnnotationMap(), _emptyAnnotationMaps(constructor.getParameterTypes().length));
        }
        return new AnnotatedConstructor(constructor, _collectRelevantAnnotations(constructor.getDeclaredAnnotations()), z ? null : _collectRelevantAnnotations(constructor.getParameterAnnotations()));
    }

    /* access modifiers changed from: protected */
    public AnnotatedMethod _constructCreatorMethod(Method method) {
        if (this._annotationIntrospector == null) {
            return new AnnotatedMethod(method, _emptyAnnotationMap(), _emptyAnnotationMaps(method.getParameterTypes().length));
        }
        return new AnnotatedMethod(method, _collectRelevantAnnotations(method.getDeclaredAnnotations()), _collectRelevantAnnotations(method.getParameterAnnotations()));
    }

    /* access modifiers changed from: protected */
    public AnnotatedField _constructField(Field field) {
        if (this._annotationIntrospector == null) {
            return new AnnotatedField(field, _emptyAnnotationMap());
        }
        return new AnnotatedField(field, _collectRelevantAnnotations(field.getDeclaredAnnotations()));
    }

    /* access modifiers changed from: protected */
    public AnnotationMap[] _collectRelevantAnnotations(Annotation[][] annotationArr) {
        int length = annotationArr.length;
        AnnotationMap[] annotationMapArr = new AnnotationMap[length];
        for (int i = 0; i < length; i++) {
            annotationMapArr[i] = _collectRelevantAnnotations(annotationArr[i]);
        }
        return annotationMapArr;
    }

    /* access modifiers changed from: protected */
    public AnnotationMap _collectRelevantAnnotations(Annotation[] annotationArr) {
        AnnotationMap annotationMap = new AnnotationMap();
        if (annotationArr != null) {
            for (Annotation annotation : annotationArr) {
                if (this._annotationIntrospector.isHandled(annotation)) {
                    annotationMap.add(annotation);
                }
            }
        }
        return annotationMap;
    }

    private AnnotationMap _emptyAnnotationMap() {
        return new AnnotationMap();
    }

    private AnnotationMap[] _emptyAnnotationMaps(int i) {
        if (i == 0) {
            return NO_ANNOTATION_MAPS;
        }
        AnnotationMap[] annotationMapArr = new AnnotationMap[i];
        for (int i2 = 0; i2 < i; i2++) {
            annotationMapArr[i2] = _emptyAnnotationMap();
        }
        return annotationMapArr;
    }

    /* access modifiers changed from: protected */
    public boolean _isIncludableMethod(Method method, MethodFilter methodFilter) {
        if ((methodFilter == null || methodFilter.includeMethod(method)) && !method.isSynthetic() && !method.isBridge()) {
            return true;
        }
        return false;
    }

    private boolean _isIncludableField(Field field) {
        if (field.isSynthetic()) {
            return false;
        }
        int modifiers = field.getModifiers();
        if (Modifier.isStatic(modifiers) || Modifier.isTransient(modifiers)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void _addMixOvers(Constructor<?> constructor, AnnotatedConstructor annotatedConstructor, boolean z) {
        for (Annotation annotation : constructor.getDeclaredAnnotations()) {
            if (this._annotationIntrospector.isHandled(annotation)) {
                annotatedConstructor.addOrOverride(annotation);
            }
        }
        if (z) {
            Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
            int length = parameterAnnotations.length;
            for (int i = 0; i < length; i++) {
                for (Annotation addOrOverrideParam : parameterAnnotations[i]) {
                    annotatedConstructor.addOrOverrideParam(i, addOrOverrideParam);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _addMixOvers(Method method, AnnotatedMethod annotatedMethod, boolean z) {
        for (Annotation annotation : method.getDeclaredAnnotations()) {
            if (this._annotationIntrospector.isHandled(annotation)) {
                annotatedMethod.addOrOverride(annotation);
            }
        }
        if (z) {
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            int length = parameterAnnotations.length;
            for (int i = 0; i < length; i++) {
                for (Annotation addOrOverrideParam : parameterAnnotations[i]) {
                    annotatedMethod.addOrOverrideParam(i, addOrOverrideParam);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _addMixUnders(Method method, AnnotatedMethod annotatedMethod) {
        for (Annotation annotation : method.getDeclaredAnnotations()) {
            if (this._annotationIntrospector.isHandled(annotation)) {
                annotatedMethod.addIfNotPresent(annotation);
            }
        }
    }

    public String toString() {
        return "[AnnotedClass " + this._class.getName() + "]";
    }
}
