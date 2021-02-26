package org.codehaus.jackson.map.type;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

public final class TypeFactory {
    private static final JavaType[] NO_TYPES = new JavaType[0];
    @Deprecated
    public static final TypeFactory instance = new TypeFactory();
    protected final TypeModifier[] _modifiers;
    protected final TypeParser _parser;

    private TypeFactory() {
        this._parser = new TypeParser(this);
        this._modifiers = null;
    }

    protected TypeFactory(TypeParser typeParser, TypeModifier[] typeModifierArr) {
        this._parser = typeParser;
        this._modifiers = typeModifierArr;
    }

    public TypeFactory withModifier(TypeModifier typeModifier) {
        TypeModifier[] typeModifierArr = this._modifiers;
        if (typeModifierArr != null) {
            return new TypeFactory(this._parser, (TypeModifier[]) ArrayBuilders.insertInListNoDup(typeModifierArr, typeModifier));
        }
        return new TypeFactory(this._parser, new TypeModifier[]{typeModifier});
    }

    public static TypeFactory defaultInstance() {
        return instance;
    }

    public static JavaType unknownType() {
        return defaultInstance()._unknownType();
    }

    public static Class<?> rawClass(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        return defaultInstance().constructType(type).getRawClass();
    }

    @Deprecated
    public static JavaType type(Type type) {
        return instance._constructType(type, (TypeBindings) null);
    }

    @Deprecated
    public static JavaType type(Type type, Class<?> cls) {
        return instance.constructType(type, cls);
    }

    @Deprecated
    public static JavaType type(Type type, JavaType javaType) {
        return instance.constructType(type, javaType);
    }

    @Deprecated
    public static JavaType type(Type type, TypeBindings typeBindings) {
        return instance._constructType(type, typeBindings);
    }

    @Deprecated
    public static JavaType type(TypeReference<?> typeReference) {
        return instance.constructType(typeReference.getType());
    }

    @Deprecated
    public static JavaType arrayType(Class<?> cls) {
        TypeFactory typeFactory = instance;
        return typeFactory.constructArrayType(typeFactory.constructType((Type) cls));
    }

    @Deprecated
    public static JavaType arrayType(JavaType javaType) {
        return instance.constructArrayType(javaType);
    }

    @Deprecated
    public static JavaType collectionType(Class<? extends Collection> cls, Class<?> cls2) {
        TypeFactory typeFactory = instance;
        return typeFactory.constructCollectionType(cls, typeFactory.constructType((Type) cls2));
    }

    @Deprecated
    public static JavaType collectionType(Class<? extends Collection> cls, JavaType javaType) {
        return instance.constructCollectionType(cls, javaType);
    }

    @Deprecated
    public static JavaType mapType(Class<? extends Map> cls, Class<?> cls2, Class<?> cls3) {
        return instance.constructMapType(cls, type((Type) cls2), instance.constructType((Type) cls3));
    }

    @Deprecated
    public static JavaType mapType(Class<? extends Map> cls, JavaType javaType, JavaType javaType2) {
        return instance.constructMapType(cls, javaType, javaType2);
    }

    @Deprecated
    public static JavaType parametricType(Class<?> cls, Class<?>... clsArr) {
        return instance.constructParametricType(cls, clsArr);
    }

    @Deprecated
    public static JavaType parametricType(Class<?> cls, JavaType... javaTypeArr) {
        return instance.constructParametricType(cls, javaTypeArr);
    }

    public static JavaType fromCanonical(String str) throws IllegalArgumentException {
        return instance.constructFromCanonical(str);
    }

    @Deprecated
    public static JavaType specialize(JavaType javaType, Class<?> cls) {
        return instance.constructSpecializedType(javaType, cls);
    }

    @Deprecated
    public static JavaType fastSimpleType(Class<?> cls) {
        return instance.uncheckedSimpleType(cls);
    }

    @Deprecated
    public static JavaType[] findParameterTypes(Class<?> cls, Class<?> cls2) {
        return instance.findTypeParameters(cls, cls2);
    }

    @Deprecated
    public static JavaType[] findParameterTypes(Class<?> cls, Class<?> cls2, TypeBindings typeBindings) {
        return instance.findTypeParameters(cls, cls2, typeBindings);
    }

    @Deprecated
    public static JavaType[] findParameterTypes(JavaType javaType, Class<?> cls) {
        return instance.findTypeParameters(javaType, cls);
    }

    @Deprecated
    public static JavaType fromClass(Class<?> cls) {
        return instance._fromClass(cls, (TypeBindings) null);
    }

    @Deprecated
    public static JavaType fromTypeReference(TypeReference<?> typeReference) {
        return type(typeReference.getType());
    }

    @Deprecated
    public static JavaType fromType(Type type) {
        return instance._constructType(type, (TypeBindings) null);
    }

    public JavaType constructSpecializedType(JavaType javaType, Class<?> cls) {
        if (!(javaType instanceof SimpleType) || (!cls.isArray() && !Map.class.isAssignableFrom(cls) && !Collection.class.isAssignableFrom(cls))) {
            return javaType.narrowBy(cls);
        }
        if (javaType.getRawClass().isAssignableFrom(cls)) {
            JavaType _fromClass = instance._fromClass(cls, new TypeBindings(this, javaType.getRawClass()));
            Object valueHandler = javaType.getValueHandler();
            if (valueHandler != null) {
                _fromClass.setValueHandler(valueHandler);
            }
            Object typeHandler = javaType.getTypeHandler();
            if (typeHandler != null) {
                return _fromClass.withTypeHandler(typeHandler);
            }
            return _fromClass;
        }
        throw new IllegalArgumentException("Class " + cls.getClass().getName() + " not subtype of " + javaType);
    }

    public JavaType constructFromCanonical(String str) throws IllegalArgumentException {
        return this._parser.parse(str);
    }

    public JavaType[] findTypeParameters(JavaType javaType, Class<?> cls) {
        Class<?> rawClass = javaType.getRawClass();
        if (rawClass != cls) {
            return findTypeParameters(rawClass, cls, new TypeBindings(this, javaType));
        }
        int containedTypeCount = javaType.containedTypeCount();
        if (containedTypeCount == 0) {
            return null;
        }
        JavaType[] javaTypeArr = new JavaType[containedTypeCount];
        for (int i = 0; i < containedTypeCount; i++) {
            javaTypeArr[i] = javaType.containedType(i);
        }
        return javaTypeArr;
    }

    public JavaType[] findTypeParameters(Class<?> cls, Class<?> cls2) {
        return findTypeParameters(cls, cls2, new TypeBindings(this, cls));
    }

    public JavaType[] findTypeParameters(Class<?> cls, Class<?> cls2, TypeBindings typeBindings) {
        HierarchicType _findSuperTypeChain = _findSuperTypeChain(cls, cls2);
        if (_findSuperTypeChain != null) {
            while (_findSuperTypeChain.getSuperType() != null) {
                _findSuperTypeChain = _findSuperTypeChain.getSuperType();
                Class<?> rawClass = _findSuperTypeChain.getRawClass();
                TypeBindings typeBindings2 = new TypeBindings(this, rawClass);
                if (_findSuperTypeChain.isGeneric()) {
                    Type[] actualTypeArguments = _findSuperTypeChain.asGeneric().getActualTypeArguments();
                    TypeVariable[] typeParameters = rawClass.getTypeParameters();
                    int length = actualTypeArguments.length;
                    for (int i = 0; i < length; i++) {
                        typeBindings2.addBinding(typeParameters[i].getName(), instance._constructType(actualTypeArguments[i], typeBindings));
                    }
                }
                typeBindings = typeBindings2;
            }
            if (!_findSuperTypeChain.isGeneric()) {
                return null;
            }
            return typeBindings.typesAsArray();
        }
        throw new IllegalArgumentException("Class " + cls.getName() + " is not a subtype of " + cls2.getName());
    }

    public JavaType constructType(Type type) {
        return _constructType(type, (TypeBindings) null);
    }

    public JavaType constructType(Type type, TypeBindings typeBindings) {
        return _constructType(type, typeBindings);
    }

    public JavaType constructType(TypeReference<?> typeReference) {
        return _constructType(typeReference.getType(), (TypeBindings) null);
    }

    public JavaType constructType(Type type, Class<?> cls) {
        return _constructType(type, new TypeBindings(this, cls));
    }

    public JavaType constructType(Type type, JavaType javaType) {
        return _constructType(type, new TypeBindings(this, javaType));
    }

    public JavaType _constructType(Type type, TypeBindings typeBindings) {
        JavaType javaType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (typeBindings == null) {
                typeBindings = new TypeBindings(this, (Class<?>) cls);
            }
            javaType = _fromClass(cls, typeBindings);
        } else if (type instanceof ParameterizedType) {
            javaType = _fromParamType((ParameterizedType) type, typeBindings);
        } else if (type instanceof GenericArrayType) {
            javaType = _fromArrayType((GenericArrayType) type, typeBindings);
        } else if (type instanceof TypeVariable) {
            javaType = _fromVariable((TypeVariable) type, typeBindings);
        } else if (type instanceof WildcardType) {
            javaType = _fromWildcard((WildcardType) type, typeBindings);
        } else {
            throw new IllegalArgumentException("Unrecognized Type: " + type.toString());
        }
        if (this._modifiers != null && !javaType.isContainerType()) {
            for (TypeModifier modifyType : this._modifiers) {
                javaType = modifyType.modifyType(javaType, type, typeBindings, this);
            }
        }
        return javaType;
    }

    /* access modifiers changed from: protected */
    public ArrayType constructArrayType(Class<?> cls) {
        return ArrayType.construct(_constructType(cls, (TypeBindings) null));
    }

    /* access modifiers changed from: protected */
    public ArrayType constructArrayType(JavaType javaType) {
        return ArrayType.construct(javaType);
    }

    public CollectionType constructCollectionType(Class<? extends Collection> cls, Class<?> cls2) {
        return CollectionType.construct(cls, constructType((Type) cls2));
    }

    public CollectionType constructCollectionType(Class<? extends Collection> cls, JavaType javaType) {
        return CollectionType.construct(cls, javaType);
    }

    public CollectionLikeType constructCollectionLikeType(Class<?> cls, Class<?> cls2) {
        return CollectionLikeType.construct(cls, constructType((Type) cls2));
    }

    public CollectionLikeType constructCollectionLikeType(Class<?> cls, JavaType javaType) {
        return CollectionLikeType.construct(cls, javaType);
    }

    public MapType constructMapType(Class<? extends Map> cls, JavaType javaType, JavaType javaType2) {
        return MapType.construct(cls, javaType, javaType2);
    }

    public MapType constructMapType(Class<? extends Map> cls, Class<?> cls2, Class<?> cls3) {
        return MapType.construct(cls, constructType((Type) cls2), constructType((Type) cls3));
    }

    public MapLikeType constructMapLikeType(Class<?> cls, JavaType javaType, JavaType javaType2) {
        return MapLikeType.construct(cls, javaType, javaType2);
    }

    public MapLikeType constructMapLikeType(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        return MapType.construct(cls, constructType((Type) cls2), constructType((Type) cls3));
    }

    public JavaType constructSimpleType(Class<?> cls, JavaType[] javaTypeArr) {
        TypeVariable[] typeParameters = cls.getTypeParameters();
        if (typeParameters.length == javaTypeArr.length) {
            String[] strArr = new String[typeParameters.length];
            int length = typeParameters.length;
            for (int i = 0; i < length; i++) {
                strArr[i] = typeParameters[i].getName();
            }
            return new SimpleType(cls, strArr, javaTypeArr);
        }
        throw new IllegalArgumentException("Parameter type mismatch for " + cls.getName() + ": expected " + typeParameters.length + " parameters, was given " + javaTypeArr.length);
    }

    public JavaType uncheckedSimpleType(Class<?> cls) {
        return new SimpleType(cls, (String[]) null, (JavaType[]) null);
    }

    public JavaType constructParametricType(Class<?> cls, Class<?>... clsArr) {
        int length = clsArr.length;
        JavaType[] javaTypeArr = new JavaType[length];
        for (int i = 0; i < length; i++) {
            javaTypeArr[i] = _fromClass(clsArr[i], (TypeBindings) null);
        }
        return constructParametricType(cls, javaTypeArr);
    }

    public JavaType constructParametricType(Class<?> cls, JavaType... javaTypeArr) {
        if (cls.isArray()) {
            if (javaTypeArr.length == 1) {
                return constructArrayType(javaTypeArr[0]);
            }
            throw new IllegalArgumentException("Need exactly 1 parameter type for arrays (" + cls.getName() + ")");
        } else if (Map.class.isAssignableFrom(cls)) {
            if (javaTypeArr.length == 2) {
                return constructMapType((Class<? extends Map>) cls, javaTypeArr[0], javaTypeArr[1]);
            }
            throw new IllegalArgumentException("Need exactly 2 parameter types for Map types (" + cls.getName() + ")");
        } else if (!Collection.class.isAssignableFrom(cls)) {
            return constructSimpleType(cls, javaTypeArr);
        } else {
            if (javaTypeArr.length == 1) {
                return constructCollectionType((Class<? extends Collection>) cls, javaTypeArr[0]);
            }
            throw new IllegalArgumentException("Need exactly 1 parameter type for Collection types (" + cls.getName() + ")");
        }
    }

    /* access modifiers changed from: protected */
    public JavaType _fromClass(Class<?> cls, TypeBindings typeBindings) {
        if (cls.isArray()) {
            return ArrayType.construct(_constructType(cls.getComponentType(), (TypeBindings) null));
        }
        if (cls.isEnum()) {
            return new SimpleType(cls);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return _mapType(cls);
        }
        if (Collection.class.isAssignableFrom(cls)) {
            return _collectionType(cls);
        }
        return new SimpleType(cls);
    }

    /* access modifiers changed from: protected */
    public JavaType _fromParameterizedClass(Class<?> cls, List<JavaType> list) {
        if (cls.isArray()) {
            return ArrayType.construct(_constructType(cls.getComponentType(), (TypeBindings) null));
        }
        if (cls.isEnum()) {
            return new SimpleType(cls);
        }
        if (Map.class.isAssignableFrom(cls)) {
            if (list.size() <= 0) {
                return _mapType(cls);
            }
            return MapType.construct(cls, list.get(0), list.size() >= 2 ? list.get(1) : _unknownType());
        } else if (Collection.class.isAssignableFrom(cls)) {
            if (list.size() >= 1) {
                return CollectionType.construct(cls, list.get(0));
            }
            return _collectionType(cls);
        } else if (list.size() == 0) {
            return new SimpleType(cls);
        } else {
            return constructSimpleType(cls, (JavaType[]) list.toArray(new JavaType[list.size()]));
        }
    }

    /* access modifiers changed from: protected */
    public JavaType _fromParamType(ParameterizedType parameterizedType, TypeBindings typeBindings) {
        int i;
        JavaType[] javaTypeArr;
        Class cls = (Class) parameterizedType.getRawType();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (actualTypeArguments == null) {
            i = 0;
        } else {
            i = actualTypeArguments.length;
        }
        if (i == 0) {
            javaTypeArr = NO_TYPES;
        } else {
            JavaType[] javaTypeArr2 = new JavaType[i];
            for (int i2 = 0; i2 < i; i2++) {
                javaTypeArr2[i2] = _constructType(actualTypeArguments[i2], typeBindings);
            }
            javaTypeArr = javaTypeArr2;
        }
        if (Map.class.isAssignableFrom(cls)) {
            JavaType[] findTypeParameters = findTypeParameters(constructSimpleType(cls, javaTypeArr), (Class<?>) Map.class);
            if (findTypeParameters.length == 2) {
                return MapType.construct(cls, findTypeParameters[0], findTypeParameters[1]);
            }
            throw new IllegalArgumentException("Could not find 2 type parameters for Map class " + cls.getName() + " (found " + findTypeParameters.length + ")");
        } else if (Collection.class.isAssignableFrom(cls)) {
            JavaType[] findTypeParameters2 = findTypeParameters(constructSimpleType(cls, javaTypeArr), (Class<?>) Collection.class);
            if (findTypeParameters2.length == 1) {
                return CollectionType.construct(cls, findTypeParameters2[0]);
            }
            throw new IllegalArgumentException("Could not find 1 type parameter for Collection class " + cls.getName() + " (found " + findTypeParameters2.length + ")");
        } else if (i == 0) {
            return new SimpleType(cls);
        } else {
            return constructSimpleType(cls, javaTypeArr);
        }
    }

    /* access modifiers changed from: protected */
    public JavaType _fromArrayType(GenericArrayType genericArrayType, TypeBindings typeBindings) {
        return ArrayType.construct(_constructType(genericArrayType.getGenericComponentType(), typeBindings));
    }

    /* access modifiers changed from: protected */
    public JavaType _fromVariable(TypeVariable<?> typeVariable, TypeBindings typeBindings) {
        if (typeBindings == null) {
            return _unknownType();
        }
        String name = typeVariable.getName();
        JavaType findType = typeBindings.findType(name);
        if (findType != null) {
            return findType;
        }
        Type[] bounds = typeVariable.getBounds();
        typeBindings._addPlaceholder(name);
        return _constructType(bounds[0], typeBindings);
    }

    /* access modifiers changed from: protected */
    public JavaType _fromWildcard(WildcardType wildcardType, TypeBindings typeBindings) {
        return _constructType(wildcardType.getUpperBounds()[0], typeBindings);
    }

    private JavaType _mapType(Class<?> cls) {
        JavaType[] findTypeParameters = findTypeParameters(cls, (Class<?>) Map.class);
        if (findTypeParameters == null) {
            return MapType.construct(cls, _unknownType(), _unknownType());
        }
        if (findTypeParameters.length == 2) {
            return MapType.construct(cls, findTypeParameters[0], findTypeParameters[1]);
        }
        throw new IllegalArgumentException("Strange Map type " + cls.getName() + ": can not determine type parameters");
    }

    private JavaType _collectionType(Class<?> cls) {
        JavaType[] findTypeParameters = findTypeParameters(cls, (Class<?>) Collection.class);
        if (findTypeParameters == null) {
            return CollectionType.construct(cls, _unknownType());
        }
        if (findTypeParameters.length == 1) {
            return CollectionType.construct(cls, findTypeParameters[0]);
        }
        throw new IllegalArgumentException("Strange Collection type " + cls.getName() + ": can not determine type parameters");
    }

    /* access modifiers changed from: protected */
    public JavaType _resolveVariableViaSubTypes(HierarchicType hierarchicType, String str, TypeBindings typeBindings) {
        if (hierarchicType != null && hierarchicType.isGeneric()) {
            TypeVariable[] typeParameters = hierarchicType.getRawClass().getTypeParameters();
            int length = typeParameters.length;
            for (int i = 0; i < length; i++) {
                if (str.equals(typeParameters[i].getName())) {
                    Type type = hierarchicType.asGeneric().getActualTypeArguments()[i];
                    if (type instanceof TypeVariable) {
                        return _resolveVariableViaSubTypes(hierarchicType.getSubType(), ((TypeVariable) type).getName(), typeBindings);
                    }
                    return _constructType(type, typeBindings);
                }
            }
        }
        return _unknownType();
    }

    /* access modifiers changed from: protected */
    public JavaType _unknownType() {
        return new SimpleType(Object.class, (String[]) null, (JavaType[]) null);
    }

    protected static HierarchicType _findSuperTypeChain(Class<?> cls, Class<?> cls2) {
        if (cls2.isInterface()) {
            return _findSuperInterfaceChain(cls, cls2);
        }
        return _findSuperClassChain(cls, cls2);
    }

    protected static HierarchicType _findSuperClassChain(Type type, Class<?> cls) {
        HierarchicType _findSuperClassChain;
        HierarchicType hierarchicType = new HierarchicType(type);
        Class<?> rawClass = hierarchicType.getRawClass();
        if (rawClass == cls) {
            return hierarchicType;
        }
        Type genericSuperclass = rawClass.getGenericSuperclass();
        if (genericSuperclass == null || (_findSuperClassChain = _findSuperClassChain(genericSuperclass, cls)) == null) {
            return null;
        }
        _findSuperClassChain.setSubType(hierarchicType);
        hierarchicType.setSuperType(_findSuperClassChain);
        return hierarchicType;
    }

    protected static HierarchicType _findSuperInterfaceChain(Type type, Class<?> cls) {
        HierarchicType _findSuperInterfaceChain;
        HierarchicType hierarchicType = new HierarchicType(type);
        Class<?> rawClass = hierarchicType.getRawClass();
        if (rawClass == cls) {
            return hierarchicType;
        }
        Type[] genericInterfaces = rawClass.getGenericInterfaces();
        if (genericInterfaces != null) {
            for (Type _findSuperInterfaceChain2 : genericInterfaces) {
                HierarchicType _findSuperInterfaceChain3 = _findSuperInterfaceChain(_findSuperInterfaceChain2, cls);
                if (_findSuperInterfaceChain3 != null) {
                    _findSuperInterfaceChain3.setSubType(hierarchicType);
                    hierarchicType.setSuperType(_findSuperInterfaceChain3);
                    return hierarchicType;
                }
            }
        }
        Type genericSuperclass = rawClass.getGenericSuperclass();
        if (genericSuperclass == null || (_findSuperInterfaceChain = _findSuperInterfaceChain(genericSuperclass, cls)) == null) {
            return null;
        }
        _findSuperInterfaceChain.setSubType(hierarchicType);
        hierarchicType.setSuperType(_findSuperInterfaceChain);
        return hierarchicType;
    }
}
