package com.google.inject.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.inject.Binder;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.PrivateBinder;
import com.google.inject.spi.Element;
import com.google.inject.spi.ElementVisitor;
import com.google.inject.spi.PrivateElements;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class PrivateElementsImpl implements PrivateElements {
    private ImmutableList<Element> elements;
    private List<Element> elementsMutable = Lists.newArrayList();
    private ImmutableMap<Key<?>, Object> exposedKeysToSources;
    private List<ExposureBuilder<?>> exposureBuilders = Lists.newArrayList();
    private Injector injector;
    private final Object source;

    public PrivateElementsImpl(Object obj) {
        this.source = Preconditions.checkNotNull(obj, FirebaseAnalytics.Param.SOURCE);
    }

    public Object getSource() {
        return this.source;
    }

    public List<Element> getElements() {
        if (this.elements == null) {
            this.elements = ImmutableList.copyOf(this.elementsMutable);
            this.elementsMutable = null;
        }
        return this.elements;
    }

    public Injector getInjector() {
        return this.injector;
    }

    public void initInjector(Injector injector2) {
        Preconditions.checkState(this.injector == null, "injector already initialized");
        this.injector = (Injector) Preconditions.checkNotNull(injector2, "injector");
    }

    public Set<Key<?>> getExposedKeys() {
        if (this.exposedKeysToSources == null) {
            LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
            for (ExposureBuilder next : this.exposureBuilders) {
                newLinkedHashMap.put(next.getKey(), next.getSource());
            }
            this.exposedKeysToSources = ImmutableMap.copyOf(newLinkedHashMap);
            this.exposureBuilders = null;
        }
        return this.exposedKeysToSources.keySet();
    }

    public <T> T acceptVisitor(ElementVisitor<T> elementVisitor) {
        return elementVisitor.visit((PrivateElements) this);
    }

    public List<Element> getElementsMutable() {
        return this.elementsMutable;
    }

    public void addExposureBuilder(ExposureBuilder<?> exposureBuilder) {
        this.exposureBuilders.add(exposureBuilder);
    }

    public void applyTo(Binder binder) {
        PrivateBinder newPrivateBinder = binder.withSource(this.source).newPrivateBinder();
        for (Element applyTo : getElements()) {
            applyTo.applyTo(newPrivateBinder);
        }
        getExposedKeys();
        UnmodifiableIterator<Map.Entry<Key<?>, Object>> it = this.exposedKeysToSources.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            newPrivateBinder.withSource(next.getValue()).expose((Key<?>) (Key) next.getKey());
        }
    }

    public Object getExposedSource(Key<?> key) {
        getExposedKeys();
        Object obj = this.exposedKeysToSources.get(key);
        Preconditions.checkArgument(obj != null, "%s not exposed by %s.", key, this);
        return obj;
    }

    public String toString() {
        return new ToStringBuilder(PrivateElements.class).add("exposedKeys", getExposedKeys()).add(FirebaseAnalytics.Param.SOURCE, getSource()).toString();
    }
}
