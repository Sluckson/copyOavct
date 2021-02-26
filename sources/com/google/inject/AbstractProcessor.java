package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.spi.Element;
import com.google.inject.spi.ElementVisitor;
import com.google.inject.spi.InjectionRequest;
import com.google.inject.spi.MembersInjectorLookup;
import com.google.inject.spi.Message;
import com.google.inject.spi.PrivateElements;
import com.google.inject.spi.ProviderLookup;
import com.google.inject.spi.ScopeBinding;
import com.google.inject.spi.StaticInjectionRequest;
import com.google.inject.spi.TypeConverterBinding;
import com.google.inject.spi.TypeListenerBinding;
import java.util.Iterator;
import java.util.List;

abstract class AbstractProcessor implements ElementVisitor<Boolean> {
    protected Errors errors;
    protected InjectorImpl injector;

    protected AbstractProcessor(Errors errors2) {
        this.errors = errors2;
    }

    public void process(Iterable<InjectorShell> iterable) {
        for (InjectorShell next : iterable) {
            process(next.getInjector(), next.getElements());
        }
    }

    public void process(InjectorImpl injectorImpl, List<Element> list) {
        Errors errors2 = this.errors;
        this.injector = injectorImpl;
        try {
            Iterator<Element> it = list.iterator();
            while (it.hasNext()) {
                Element next = it.next();
                this.errors = errors2.withSource(next.getSource());
                if (((Boolean) next.acceptVisitor(this)).booleanValue()) {
                    it.remove();
                }
            }
        } finally {
            this.errors = errors2;
            this.injector = null;
        }
    }

    public Boolean visit(Message message) {
        return false;
    }

    public Boolean visit(ScopeBinding scopeBinding) {
        return false;
    }

    public Boolean visit(InjectionRequest injectionRequest) {
        return false;
    }

    public Boolean visit(StaticInjectionRequest staticInjectionRequest) {
        return false;
    }

    public Boolean visit(TypeConverterBinding typeConverterBinding) {
        return false;
    }

    public <T> Boolean visit(Binding<T> binding) {
        return false;
    }

    public <T> Boolean visit(ProviderLookup<T> providerLookup) {
        return false;
    }

    public Boolean visit(PrivateElements privateElements) {
        return false;
    }

    public <T> Boolean visit(MembersInjectorLookup<T> membersInjectorLookup) {
        return false;
    }

    public Boolean visit(TypeListenerBinding typeListenerBinding) {
        return false;
    }
}
