package com.google.inject.internal;

import com.google.inject.spi.Dependency;
import java.util.Map;

public final class InternalContext {
    private Map<Object, ConstructionContext<?>> constructionContexts = Maps.newHashMap();
    private Dependency dependency;

    public <T> ConstructionContext<T> getConstructionContext(Object obj) {
        ConstructionContext<T> constructionContext = this.constructionContexts.get(obj);
        if (constructionContext != null) {
            return constructionContext;
        }
        ConstructionContext<T> constructionContext2 = new ConstructionContext<>();
        this.constructionContexts.put(obj, constructionContext2);
        return constructionContext2;
    }

    public Dependency getDependency() {
        return this.dependency;
    }

    public void setDependency(Dependency dependency2) {
        this.dependency = dependency2;
    }
}
