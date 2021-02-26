package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.ImmutableList;
import com.google.inject.internal.InternalContext;
import com.google.inject.internal.Lists;
import com.google.inject.internal.UnmodifiableIterator;
import com.google.inject.spi.InjectionPoint;
import com.google.inject.spi.InjectionRequest;
import com.google.inject.spi.StaticInjectionRequest;
import java.util.List;
import java.util.Set;

class InjectionRequestProcessor extends AbstractProcessor {
    private final Initializer initializer;
    private final List<StaticInjection> staticInjections = Lists.newArrayList();

    InjectionRequestProcessor(Errors errors, Initializer initializer2) {
        super(errors);
        this.initializer = initializer2;
    }

    public Boolean visit(StaticInjectionRequest staticInjectionRequest) {
        this.staticInjections.add(new StaticInjection(this.injector, staticInjectionRequest));
        return true;
    }

    public Boolean visit(InjectionRequest injectionRequest) {
        Set<InjectionPoint> set;
        try {
            set = injectionRequest.getInjectionPoints();
        } catch (ConfigurationException e) {
            this.errors.merge(e.getErrorMessages());
            set = (Set) e.getPartialValue();
        }
        this.initializer.requestInjection(this.injector, injectionRequest.getInstance(), injectionRequest.getSource(), set);
        return true;
    }

    public void validate() {
        for (StaticInjection validate : this.staticInjections) {
            validate.validate();
        }
    }

    public void injectMembers() {
        for (StaticInjection injectMembers : this.staticInjections) {
            injectMembers.injectMembers();
        }
    }

    private class StaticInjection {
        final InjectorImpl injector;
        ImmutableList<SingleMemberInjector> memberInjectors;
        final StaticInjectionRequest request;
        final Object source;

        public StaticInjection(InjectorImpl injectorImpl, StaticInjectionRequest staticInjectionRequest) {
            this.injector = injectorImpl;
            this.source = staticInjectionRequest.getSource();
            this.request = staticInjectionRequest;
        }

        /* access modifiers changed from: package-private */
        public void validate() {
            Set<InjectionPoint> set;
            Errors withSource = InjectionRequestProcessor.this.errors.withSource(this.source);
            try {
                set = this.request.getInjectionPoints();
            } catch (ConfigurationException e) {
                InjectionRequestProcessor.this.errors.merge(e.getErrorMessages());
                set = (Set) e.getPartialValue();
            }
            this.memberInjectors = this.injector.membersInjectorStore.getInjectors(set, withSource);
        }

        /* access modifiers changed from: package-private */
        public void injectMembers() {
            try {
                this.injector.callInContext(new ContextualCallable<Void>() {
                    public Void call(InternalContext internalContext) {
                        UnmodifiableIterator<SingleMemberInjector> it = StaticInjection.this.memberInjectors.iterator();
                        while (it.hasNext()) {
                            it.next().inject(InjectionRequestProcessor.this.errors, internalContext, (Object) null);
                        }
                        return null;
                    }
                });
            } catch (ErrorsException unused) {
                throw new AssertionError();
            }
        }
    }
}
