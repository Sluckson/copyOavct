package com.google.inject;

import com.google.inject.internal.ImmutableList;
import com.google.inject.internal.MoreTypes;
import com.google.inject.internal.Preconditions;
import com.google.inject.util.Types;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class TypeLiteral<T> {
    final int hashCode;
    final Class<? super T> rawType;
    final Type type;

    protected TypeLiteral() {
        this.type = getSuperclassTypeParameter(getClass());
        this.rawType = MoreTypes.getRawType(this.type);
        this.hashCode = MoreTypes.hashCode(this.type);
    }

    TypeLiteral(Type type2) {
        this.type = MoreTypes.canonicalize((Type) Preconditions.checkNotNull(type2, "type"));
        this.rawType = MoreTypes.getRawType(this.type);
        this.hashCode = MoreTypes.hashCode(this.type);
    }

    static Type getSuperclassTypeParameter(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return MoreTypes.canonicalize(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    static TypeLiteral<?> fromSuperclassTypeParameter(Class<?> cls) {
        return new TypeLiteral<>(getSuperclassTypeParameter(cls));
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    /* access modifiers changed from: package-private */
    public final TypeLiteral<Provider<T>> providerType() {
        return get((Type) Types.providerOf(getType()));
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof TypeLiteral) && MoreTypes.equals(this.type, ((TypeLiteral) obj).type);
    }

    public final String toString() {
        return MoreTypes.toString(this.type);
    }

    public static TypeLiteral<?> get(Type type2) {
        return new TypeLiteral<>(type2);
    }

    public static <T> TypeLiteral<T> get(Class<T> cls) {
        return new TypeLiteral<>(cls);
    }

    private List<TypeLiteral<?>> resolveAll(Type[] typeArr) {
        TypeLiteral[] typeLiteralArr = new TypeLiteral[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeLiteralArr[i] = resolve(typeArr[i]);
        }
        return ImmutableList.m341of((E[]) typeLiteralArr);
    }

    /* access modifiers changed from: package-private */
    public TypeLiteral<?> resolve(Type type2) {
        return get(resolveType(type2));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.reflect.Type[]} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.reflect.Type resolveType(java.lang.reflect.Type r9) {
        /*
            r8 = this;
        L_0x0000:
            boolean r0 = r9 instanceof java.lang.reflect.TypeVariable
            if (r0 == 0) goto L_0x0013
            java.lang.reflect.TypeVariable r9 = (java.lang.reflect.TypeVariable) r9
            java.lang.reflect.Type r0 = r8.type
            java.lang.Class<? super T> r1 = r8.rawType
            java.lang.reflect.Type r0 = com.google.inject.internal.MoreTypes.resolveTypeVariable(r0, r1, r9)
            if (r0 != r9) goto L_0x0011
            return r0
        L_0x0011:
            r9 = r0
            goto L_0x0000
        L_0x0013:
            boolean r0 = r9 instanceof java.lang.reflect.GenericArrayType
            if (r0 == 0) goto L_0x0029
            java.lang.reflect.GenericArrayType r9 = (java.lang.reflect.GenericArrayType) r9
            java.lang.reflect.Type r0 = r9.getGenericComponentType()
            java.lang.reflect.Type r1 = r8.resolveType(r0)
            if (r0 != r1) goto L_0x0024
            goto L_0x0028
        L_0x0024:
            java.lang.reflect.GenericArrayType r9 = com.google.inject.util.Types.arrayOf(r1)
        L_0x0028:
            return r9
        L_0x0029:
            boolean r0 = r9 instanceof java.lang.reflect.ParameterizedType
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0069
            java.lang.reflect.ParameterizedType r9 = (java.lang.reflect.ParameterizedType) r9
            java.lang.reflect.Type r0 = r9.getOwnerType()
            java.lang.reflect.Type r3 = r8.resolveType(r0)
            if (r3 == r0) goto L_0x003d
            r0 = 1
            goto L_0x003e
        L_0x003d:
            r0 = 0
        L_0x003e:
            java.lang.reflect.Type[] r4 = r9.getActualTypeArguments()
            int r5 = r4.length
        L_0x0043:
            if (r2 >= r5) goto L_0x005e
            r6 = r4[r2]
            java.lang.reflect.Type r6 = r8.resolveType(r6)
            r7 = r4[r2]
            if (r6 == r7) goto L_0x005b
            if (r0 != 0) goto L_0x0059
            java.lang.Object r0 = r4.clone()
            r4 = r0
            java.lang.reflect.Type[] r4 = (java.lang.reflect.Type[]) r4
            r0 = 1
        L_0x0059:
            r4[r2] = r6
        L_0x005b:
            int r2 = r2 + 1
            goto L_0x0043
        L_0x005e:
            if (r0 == 0) goto L_0x0068
            java.lang.reflect.Type r9 = r9.getRawType()
            java.lang.reflect.ParameterizedType r9 = com.google.inject.util.Types.newParameterizedTypeWithOwner(r3, r9, r4)
        L_0x0068:
            return r9
        L_0x0069:
            boolean r0 = r9 instanceof java.lang.reflect.WildcardType
            if (r0 == 0) goto L_0x009a
            java.lang.reflect.WildcardType r9 = (java.lang.reflect.WildcardType) r9
            java.lang.reflect.Type[] r0 = r9.getLowerBounds()
            java.lang.reflect.Type[] r3 = r9.getUpperBounds()
            int r4 = r0.length
            if (r4 != r1) goto L_0x0089
            r1 = r0[r2]
            java.lang.reflect.Type r1 = r8.resolveType(r1)
            r0 = r0[r2]
            if (r1 == r0) goto L_0x009a
            java.lang.reflect.WildcardType r9 = com.google.inject.util.Types.supertypeOf(r1)
            return r9
        L_0x0089:
            int r0 = r3.length
            if (r0 != r1) goto L_0x009a
            r0 = r3[r2]
            java.lang.reflect.Type r0 = r8.resolveType(r0)     // Catch:{ Throwable -> 0x009b }
            r1 = r3[r2]
            if (r0 == r1) goto L_0x009a
            java.lang.reflect.WildcardType r9 = com.google.inject.util.Types.subtypeOf(r0)
        L_0x009a:
            return r9
        L_0x009b:
            r9 = move-exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.inject.TypeLiteral.resolveType(java.lang.reflect.Type):java.lang.reflect.Type");
    }

    public TypeLiteral<?> getSupertype(Class<?> cls) {
        Preconditions.checkArgument(cls.isAssignableFrom(this.rawType), "%s is not a supertype of %s", cls, this.type);
        return resolve(MoreTypes.getGenericSupertype(this.type, this.rawType, cls));
    }

    public TypeLiteral<?> getFieldType(Field field) {
        Preconditions.checkArgument(field.getDeclaringClass().isAssignableFrom(this.rawType), "%s is not defined by a supertype of %s", field, this.type);
        return resolve(field.getGenericType());
    }

    public List<TypeLiteral<?>> getParameterTypes(Member member) {
        Type[] typeArr;
        if (member instanceof Method) {
            Method method = (Method) member;
            Preconditions.checkArgument(method.getDeclaringClass().isAssignableFrom(this.rawType), "%s is not defined by a supertype of %s", method, this.type);
            typeArr = method.getGenericParameterTypes();
        } else if (member instanceof Constructor) {
            Constructor constructor = (Constructor) member;
            Preconditions.checkArgument(constructor.getDeclaringClass().isAssignableFrom(this.rawType), "%s does not construct a supertype of %s", constructor, this.type);
            typeArr = constructor.getGenericParameterTypes();
        } else {
            throw new IllegalArgumentException("Not a method or a constructor: " + member);
        }
        return resolveAll(typeArr);
    }

    public List<TypeLiteral<?>> getExceptionTypes(Member member) {
        Type[] typeArr;
        if (member instanceof Method) {
            Method method = (Method) member;
            Preconditions.checkArgument(method.getDeclaringClass().isAssignableFrom(this.rawType), "%s is not defined by a supertype of %s", method, this.type);
            typeArr = method.getGenericExceptionTypes();
        } else if (member instanceof Constructor) {
            Constructor constructor = (Constructor) member;
            Preconditions.checkArgument(constructor.getDeclaringClass().isAssignableFrom(this.rawType), "%s does not construct a supertype of %s", constructor, this.type);
            typeArr = constructor.getGenericExceptionTypes();
        } else {
            throw new IllegalArgumentException("Not a method or a constructor: " + member);
        }
        return resolveAll(typeArr);
    }

    public TypeLiteral<?> getReturnType(Method method) {
        Preconditions.checkArgument(method.getDeclaringClass().isAssignableFrom(this.rawType), "%s is not defined by a supertype of %s", method, this.type);
        return resolve(method.getGenericReturnType());
    }
}
