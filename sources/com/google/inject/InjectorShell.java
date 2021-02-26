package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.ImmutableSet;
import com.google.inject.internal.InternalContext;
import com.google.inject.internal.InternalFactory;
import com.google.inject.internal.Lists;
import com.google.inject.internal.Preconditions;
import com.google.inject.internal.PrivateElementsImpl;
import com.google.inject.internal.ProviderInstanceBindingImpl;
import com.google.inject.internal.Scoping;
import com.google.inject.internal.SourceProvider;
import com.google.inject.internal.Stopwatch;
import com.google.inject.spi.Dependency;
import com.google.inject.spi.Element;
import com.google.inject.spi.Elements;
import com.google.inject.spi.InjectionPoint;
import com.google.inject.spi.PrivateElements;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

class InjectorShell {
    private final List<Element> elements;
    private final InjectorImpl injector;
    private final PrivateElements privateElements;

    private InjectorShell(Builder builder, List<Element> list, InjectorImpl injectorImpl) {
        this.privateElements = builder.privateElements;
        this.elements = list;
        this.injector = injectorImpl;
    }

    /* access modifiers changed from: package-private */
    public PrivateElements getPrivateElements() {
        return this.privateElements;
    }

    /* access modifiers changed from: package-private */
    public InjectorImpl getInjector() {
        return this.injector;
    }

    /* access modifiers changed from: package-private */
    public List<Element> getElements() {
        return this.elements;
    }

    static class Builder {
        private final List<Element> elements = Lists.newArrayList();
        private final List<Module> modules = Lists.newArrayList();
        private InjectorImpl parent;
        /* access modifiers changed from: private */
        public PrivateElementsImpl privateElements;
        private Stage stage;
        private State state;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public Builder parent(InjectorImpl injectorImpl) {
            this.parent = injectorImpl;
            this.state = new InheritingState(injectorImpl.state);
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder stage(Stage stage2) {
            this.stage = stage2;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder privateElements(PrivateElements privateElements2) {
            this.privateElements = (PrivateElementsImpl) privateElements2;
            this.elements.addAll(privateElements2.getElements());
            return this;
        }

        /* access modifiers changed from: package-private */
        public void addModules(Iterable<? extends Module> iterable) {
            for (Module add : iterable) {
                this.modules.add(add);
            }
        }

        /* access modifiers changed from: package-private */
        public Object lock() {
            return getState().lock();
        }

        /* access modifiers changed from: package-private */
        public List<InjectorShell> build(Initializer initializer, BindingProcessor bindingProcessor, Stopwatch stopwatch, Errors errors) {
            boolean z = true;
            Preconditions.checkState(this.stage != null, "Stage not initialized");
            Preconditions.checkState(this.privateElements == null || this.parent != null, "PrivateElements with no parent");
            if (this.state == null) {
                z = false;
            }
            Preconditions.checkState(z, "no state. Did you remember to lock() ?");
            InjectorImpl injectorImpl = new InjectorImpl(this.parent, this.state, initializer);
            PrivateElementsImpl privateElementsImpl = this.privateElements;
            if (privateElementsImpl != null) {
                privateElementsImpl.initInjector(injectorImpl);
            }
            if (this.parent == null) {
                this.modules.add(0, new RootModule(this.stage));
                new TypeConverterBindingProcessor(errors).prepareBuiltInConverters(injectorImpl);
            }
            this.elements.addAll(Elements.getElements(this.stage, (Iterable<? extends Module>) this.modules));
            stopwatch.resetAndLog("Module execution");
            new MessageProcessor(errors).process(injectorImpl, this.elements);
            new TypeListenerBindingProcessor(errors).process(injectorImpl, this.elements);
            injectorImpl.membersInjectorStore = new MembersInjectorStore(injectorImpl, injectorImpl.state.getTypeListenerBindings());
            stopwatch.resetAndLog("TypeListeners creation");
            new ScopeBindingProcessor(errors).process(injectorImpl, this.elements);
            stopwatch.resetAndLog("Scopes creation");
            new TypeConverterBindingProcessor(errors).process(injectorImpl, this.elements);
            stopwatch.resetAndLog("Converters creation");
            InjectorShell.bindInjector(injectorImpl);
            InjectorShell.bindLogger(injectorImpl);
            bindingProcessor.process(injectorImpl, this.elements);
            stopwatch.resetAndLog("Binding creation");
            ArrayList newArrayList = Lists.newArrayList();
            newArrayList.add(new InjectorShell(this, this.elements, injectorImpl));
            PrivateElementProcessor privateElementProcessor = new PrivateElementProcessor(errors, this.stage);
            privateElementProcessor.process(injectorImpl, this.elements);
            for (Builder build : privateElementProcessor.getInjectorShellBuilders()) {
                newArrayList.addAll(build.build(initializer, bindingProcessor, stopwatch, errors));
            }
            stopwatch.resetAndLog("Private environment creation");
            return newArrayList;
        }

        private State getState() {
            if (this.state == null) {
                this.state = new InheritingState(State.NONE);
            }
            return this.state;
        }
    }

    /* access modifiers changed from: private */
    public static void bindInjector(InjectorImpl injectorImpl) {
        Key<Injector> key = Key.get(Injector.class);
        InjectorFactory injectorFactory = new InjectorFactory(injectorImpl);
        injectorImpl.state.putBinding(key, new ProviderInstanceBindingImpl(injectorImpl, key, SourceProvider.UNKNOWN_SOURCE, injectorFactory, Scoping.UNSCOPED, injectorFactory, ImmutableSet.m348of()));
    }

    private static class InjectorFactory implements InternalFactory<Injector>, Provider<Injector> {
        private final Injector injector;

        public String toString() {
            return "Provider<Injector>";
        }

        private InjectorFactory(Injector injector2) {
            this.injector = injector2;
        }

        public Injector get(Errors errors, InternalContext internalContext, Dependency<?> dependency) throws ErrorsException {
            return this.injector;
        }

        public Injector get() {
            return this.injector;
        }
    }

    /* access modifiers changed from: private */
    public static void bindLogger(InjectorImpl injectorImpl) {
        Key<Logger> key = Key.get(Logger.class);
        LoggerFactory loggerFactory = new LoggerFactory();
        injectorImpl.state.putBinding(key, new ProviderInstanceBindingImpl(injectorImpl, key, SourceProvider.UNKNOWN_SOURCE, loggerFactory, Scoping.UNSCOPED, loggerFactory, ImmutableSet.m348of()));
    }

    private static class LoggerFactory implements InternalFactory<Logger>, Provider<Logger> {
        public String toString() {
            return "Provider<Logger>";
        }

        private LoggerFactory() {
        }

        public Logger get(Errors errors, InternalContext internalContext, Dependency<?> dependency) {
            InjectionPoint injectionPoint = dependency.getInjectionPoint();
            return injectionPoint == null ? Logger.getAnonymousLogger() : Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
        }

        public Logger get() {
            return Logger.getAnonymousLogger();
        }
    }

    private static class RootModule implements Module {
        final Stage stage;

        private RootModule(Stage stage2) {
            this.stage = (Stage) Preconditions.checkNotNull(stage2, "stage");
        }

        public void configure(Binder binder) {
            Binder withSource = binder.withSource(SourceProvider.UNKNOWN_SOURCE);
            withSource.bind(Stage.class).toInstance(this.stage);
            withSource.bindScope(Singleton.class, Scopes.SINGLETON);
        }
    }
}
