package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.internal.Lists;
import com.google.inject.spi.Element;
import com.google.inject.spi.MembersInjectorLookup;
import com.google.inject.spi.ProviderLookup;
import java.util.List;

class DeferredLookups implements Lookups {
    private final InjectorImpl injector;
    private final List<Element> lookups = Lists.newArrayList();

    public DeferredLookups(InjectorImpl injectorImpl) {
        this.injector = injectorImpl;
    }

    public void initialize(Errors errors) {
        InjectorImpl injectorImpl = this.injector;
        injectorImpl.lookups = injectorImpl;
        new LookupProcessor(errors).process(this.injector, this.lookups);
    }

    public <T> Provider<T> getProvider(Key<T> key) {
        ProviderLookup providerLookup = new ProviderLookup(key, key);
        this.lookups.add(providerLookup);
        return providerLookup.getProvider();
    }

    public <T> MembersInjector<T> getMembersInjector(TypeLiteral<T> typeLiteral) {
        MembersInjectorLookup membersInjectorLookup = new MembersInjectorLookup(typeLiteral, typeLiteral);
        this.lookups.add(membersInjectorLookup);
        return membersInjectorLookup.getMembersInjector();
    }
}
