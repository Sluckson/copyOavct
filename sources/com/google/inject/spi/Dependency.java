package com.google.inject.spi;

import com.google.inject.Key;
import com.google.inject.internal.ImmutableSet;
import com.google.inject.internal.Lists;
import com.google.inject.internal.Objects;
import java.util.ArrayList;
import java.util.Set;

public final class Dependency<T> {
    private final InjectionPoint injectionPoint;
    private final Key<T> key;
    private final boolean nullable;
    private final int parameterIndex;

    Dependency(InjectionPoint injectionPoint2, Key<T> key2, boolean z, int i) {
        this.injectionPoint = injectionPoint2;
        this.key = key2;
        this.nullable = z;
        this.parameterIndex = i;
    }

    public static <T> Dependency<T> get(Key<T> key2) {
        return new Dependency<>((InjectionPoint) null, key2, true, -1);
    }

    public static Set<Dependency<?>> forInjectionPoints(Set<InjectionPoint> set) {
        ArrayList newArrayList = Lists.newArrayList();
        for (InjectionPoint dependencies : set) {
            newArrayList.addAll(dependencies.getDependencies());
        }
        return ImmutableSet.copyOf(newArrayList);
    }

    public Key<T> getKey() {
        return this.key;
    }

    public boolean isNullable() {
        return this.nullable;
    }

    public InjectionPoint getInjectionPoint() {
        return this.injectionPoint;
    }

    public int getParameterIndex() {
        return this.parameterIndex;
    }

    public int hashCode() {
        return Objects.hashCode(this.injectionPoint, Integer.valueOf(this.parameterIndex), this.key);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Dependency)) {
            return false;
        }
        Dependency dependency = (Dependency) obj;
        if (!Objects.equal(this.injectionPoint, dependency.injectionPoint) || !Objects.equal(Integer.valueOf(this.parameterIndex), Integer.valueOf(dependency.parameterIndex)) || !Objects.equal(this.key, dependency.key)) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.key);
        if (this.injectionPoint != null) {
            sb.append("@");
            sb.append(this.injectionPoint);
            if (this.parameterIndex != -1) {
                sb.append("[");
                sb.append(this.parameterIndex);
                sb.append("]");
            }
        }
        return sb.toString();
    }
}
