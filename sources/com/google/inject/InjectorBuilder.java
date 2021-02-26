package com.google.inject;

import com.google.inject.InjectorShell;
import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.ImmutableSet;
import com.google.inject.internal.InternalContext;
import com.google.inject.internal.Iterables;
import com.google.inject.internal.Stopwatch;
import com.google.inject.spi.Dependency;
import java.util.List;
import java.util.Map;

class InjectorBuilder {
    private final BindingProcessor bindingProcesor = new BindingProcessor(this.errors, this.initializer);
    private final Errors errors = new Errors();
    private final Initializer initializer = new Initializer();
    private final InjectionRequestProcessor injectionRequestProcessor = new InjectionRequestProcessor(this.errors, this.initializer);
    private final InjectorShell.Builder shellBuilder = new InjectorShell.Builder();
    private List<InjectorShell> shells;
    private Stage stage;
    private final Stopwatch stopwatch = new Stopwatch();

    InjectorBuilder() {
    }

    /* access modifiers changed from: package-private */
    public InjectorBuilder stage(Stage stage2) {
        this.shellBuilder.stage(stage2);
        this.stage = stage2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public InjectorBuilder parentInjector(InjectorImpl injectorImpl) {
        this.shellBuilder.parent(injectorImpl);
        return stage((Stage) injectorImpl.getInstance(Stage.class));
    }

    /* access modifiers changed from: package-private */
    public InjectorBuilder addModules(Iterable<? extends Module> iterable) {
        this.shellBuilder.addModules(iterable);
        return this;
    }

    /* access modifiers changed from: package-private */
    public Injector build() {
        InjectorShell.Builder builder = this.shellBuilder;
        if (builder != null) {
            synchronized (builder.lock()) {
                this.shells = this.shellBuilder.build(this.initializer, this.bindingProcesor, this.stopwatch, this.errors);
                this.stopwatch.resetAndLog("Injector construction");
                initializeStatically();
            }
            if (this.stage == Stage.TOOL) {
                return new ToolStageInjector(primaryInjector());
            }
            injectDynamically();
            return primaryInjector();
        }
        throw new AssertionError("Already built, builders are not reusable.");
    }

    private void initializeStatically() {
        this.bindingProcesor.initializeBindings();
        this.stopwatch.resetAndLog("Binding initialization");
        for (InjectorShell injector : this.shells) {
            injector.getInjector().index();
        }
        this.stopwatch.resetAndLog("Binding indexing");
        this.injectionRequestProcessor.process(this.shells);
        this.stopwatch.resetAndLog("Collecting injection requests");
        this.bindingProcesor.runCreationListeners();
        this.stopwatch.resetAndLog("Binding validation");
        this.injectionRequestProcessor.validate();
        this.stopwatch.resetAndLog("Static validation");
        this.initializer.validateOustandingInjections(this.errors);
        this.stopwatch.resetAndLog("Instance member validation");
        new LookupProcessor(this.errors).process(this.shells);
        for (InjectorShell injector2 : this.shells) {
            ((DeferredLookups) injector2.getInjector().lookups).initialize(this.errors);
        }
        this.stopwatch.resetAndLog("Provider verification");
        for (InjectorShell next : this.shells) {
            if (!next.getElements().isEmpty()) {
                throw new AssertionError("Failed to execute " + next.getElements());
            }
        }
        this.errors.throwCreationExceptionIfErrorsExist();
    }

    private Injector primaryInjector() {
        return this.shells.get(0).getInjector();
    }

    private void injectDynamically() {
        this.injectionRequestProcessor.injectMembers();
        this.stopwatch.resetAndLog("Static member injection");
        this.initializer.injectAll(this.errors);
        this.stopwatch.resetAndLog("Instance injection");
        this.errors.throwCreationExceptionIfErrorsExist();
        for (InjectorShell injector : this.shells) {
            loadEagerSingletons(injector.getInjector(), this.stage, this.errors);
        }
        this.stopwatch.resetAndLog("Preloading singletons");
        this.errors.throwCreationExceptionIfErrorsExist();
    }

    public void loadEagerSingletons(InjectorImpl injectorImpl, Stage stage2, final Errors errors2) {
        for (final E e : ImmutableSet.copyOf(Iterables.concat(injectorImpl.state.getExplicitBindingsThisLevel().values(), injectorImpl.jitBindings.values()))) {
            if (e.getScoping().isEagerSingleton(stage2)) {
                try {
                    injectorImpl.callInContext(new ContextualCallable<Void>() {
                        Dependency<?> dependency = Dependency.get(e.getKey());

                        public Void call(InternalContext internalContext) {
                            internalContext.setDependency(this.dependency);
                            Errors withSource = errors2.withSource(this.dependency);
                            try {
                                e.getInternalFactory().get(withSource, internalContext, this.dependency);
                            } catch (ErrorsException e) {
                                withSource.merge(e.getErrors());
                            } catch (Throwable th) {
                                internalContext.setDependency((Dependency) null);
                                throw th;
                            }
                            internalContext.setDependency((Dependency) null);
                            return null;
                        }
                    });
                } catch (ErrorsException unused) {
                    throw new AssertionError();
                }
            }
        }
    }

    static class ToolStageInjector implements Injector {
        private final Injector delegateInjector;

        ToolStageInjector(Injector injector) {
            this.delegateInjector = injector;
        }

        public void injectMembers(Object obj) {
            throw new UnsupportedOperationException("Injector.injectMembers(Object) is not supported in Stage.TOOL");
        }

        public Map<Key<?>, Binding<?>> getBindings() {
            return this.delegateInjector.getBindings();
        }

        public <T> Binding<T> getBinding(Key<T> key) {
            return this.delegateInjector.getBinding(key);
        }

        public <T> Binding<T> getBinding(Class<T> cls) {
            return this.delegateInjector.getBinding(cls);
        }

        public <T> List<Binding<T>> findBindingsByType(TypeLiteral<T> typeLiteral) {
            return this.delegateInjector.findBindingsByType(typeLiteral);
        }

        public Injector getParent() {
            return this.delegateInjector.getParent();
        }

        public Injector createChildInjector(Iterable<? extends Module> iterable) {
            return this.delegateInjector.createChildInjector(iterable);
        }

        public Injector createChildInjector(Module... moduleArr) {
            return this.delegateInjector.createChildInjector(moduleArr);
        }

        public <T> Provider<T> getProvider(Key<T> key) {
            throw new UnsupportedOperationException("Injector.getProvider(Key<T>) is not supported in Stage.TOOL");
        }

        public <T> Provider<T> getProvider(Class<T> cls) {
            throw new UnsupportedOperationException("Injector.getProvider(Class<T>) is not supported in Stage.TOOL");
        }

        public <T> MembersInjector<T> getMembersInjector(TypeLiteral<T> typeLiteral) {
            throw new UnsupportedOperationException("Injector.getMembersInjector(TypeLiteral<T>) is not supported in Stage.TOOL");
        }

        public <T> MembersInjector<T> getMembersInjector(Class<T> cls) {
            throw new UnsupportedOperationException("Injector.getMembersInjector(Class<T>) is not supported in Stage.TOOL");
        }

        public <T> T getInstance(Key<T> key) {
            throw new UnsupportedOperationException("Injector.getInstance(Key<T>) is not supported in Stage.TOOL");
        }

        public <T> T getInstance(Class<T> cls) {
            throw new UnsupportedOperationException("Injector.getInstance(Class<T>) is not supported in Stage.TOOL");
        }
    }
}
