package com.google.inject;

import com.google.inject.internal.Annotations;
import com.google.inject.internal.BindingImpl;
import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.ExposedBindingImpl;
import com.google.inject.internal.ImmutableSet;
import com.google.inject.internal.InstanceBindingImpl;
import com.google.inject.internal.InternalFactory;
import com.google.inject.internal.LinkedBindingImpl;
import com.google.inject.internal.LinkedProviderBindingImpl;
import com.google.inject.internal.Lists;
import com.google.inject.internal.ProviderInstanceBindingImpl;
import com.google.inject.internal.ProviderMethod;
import com.google.inject.internal.Scoping;
import com.google.inject.internal.UntargettedBindingImpl;
import com.google.inject.spi.BindingTargetVisitor;
import com.google.inject.spi.ConstructorBinding;
import com.google.inject.spi.ConvertedConstantBinding;
import com.google.inject.spi.ExposedBinding;
import com.google.inject.spi.InjectionPoint;
import com.google.inject.spi.InstanceBinding;
import com.google.inject.spi.LinkedKeyBinding;
import com.google.inject.spi.PrivateElements;
import com.google.inject.spi.ProviderBinding;
import com.google.inject.spi.ProviderInstanceBinding;
import com.google.inject.spi.ProviderKeyBinding;
import com.google.inject.spi.UntargettedBinding;
import java.util.List;
import java.util.Set;

class BindingProcessor extends AbstractProcessor {
    private static final Set<Class<?>> FORBIDDEN_TYPES = ImmutableSet.m350of((E[]) new Class[]{AbstractModule.class, Binder.class, Binding.class, Injector.class, Key.class, MembersInjector.class, Module.class, Provider.class, Scope.class, TypeLiteral.class});
    /* access modifiers changed from: private */
    public final List<CreationListener> creationListeners = Lists.newArrayList();
    /* access modifiers changed from: private */
    public final Initializer initializer;
    /* access modifiers changed from: private */
    public final List<Runnable> uninitializedBindings = Lists.newArrayList();

    interface CreationListener {
        void notify(Errors errors);
    }

    BindingProcessor(Errors errors, Initializer initializer2) {
        super(errors);
        this.initializer = initializer2;
    }

    public <T> Boolean visit(Binding<T> binding) {
        final Object source = binding.getSource();
        if (Void.class.equals(binding.getKey().getRawType())) {
            if (!(binding instanceof ProviderInstanceBinding) || !(((ProviderInstanceBinding) binding).getProviderInstance() instanceof ProviderMethod)) {
                this.errors.missingConstantValues();
            } else {
                this.errors.voidProviderMethod();
            }
            return true;
        }
        final Key<T> key = binding.getKey();
        if (key.getTypeLiteral().getRawType() == Provider.class) {
            this.errors.bindingToProvider();
            return true;
        }
        validateKey(binding.getSource(), binding.getKey());
        final Scoping makeInjectable = Scopes.makeInjectable(((BindingImpl) binding).getScoping(), this.injector, this.errors);
        binding.acceptTargetVisitor(new BindingTargetVisitor<T, Void>() {
            public Void visit(InstanceBinding<? extends T> instanceBinding) {
                Set<InjectionPoint> injectionPoints = instanceBinding.getInjectionPoints();
                Object instance = instanceBinding.getInstance();
                InternalFactory scope = Scopes.scope(key, BindingProcessor.this.injector, new ConstantFactory(BindingProcessor.this.initializer.requestInjection(BindingProcessor.this.injector, instance, source, injectionPoints)), makeInjectable);
                BindingProcessor bindingProcessor = BindingProcessor.this;
                bindingProcessor.putBinding(new InstanceBindingImpl(bindingProcessor.injector, key, source, scope, injectionPoints, instance));
                return null;
            }

            public Void visit(ProviderInstanceBinding<? extends T> providerInstanceBinding) {
                Provider<? extends Object> providerInstance = providerInstanceBinding.getProviderInstance();
                Set<InjectionPoint> injectionPoints = providerInstanceBinding.getInjectionPoints();
                InternalFactory scope = Scopes.scope(key, BindingProcessor.this.injector, new InternalFactoryToProviderAdapter(BindingProcessor.this.initializer.requestInjection(BindingProcessor.this.injector, providerInstance, source, injectionPoints), source), makeInjectable);
                BindingProcessor bindingProcessor = BindingProcessor.this;
                bindingProcessor.putBinding(new ProviderInstanceBindingImpl(bindingProcessor.injector, key, source, scope, makeInjectable, providerInstance, injectionPoints));
                return null;
            }

            public Void visit(ProviderKeyBinding<? extends T> providerKeyBinding) {
                Key<? extends Provider<? extends Object>> providerKey = providerKeyBinding.getProviderKey();
                BoundProviderFactory boundProviderFactory = new BoundProviderFactory(BindingProcessor.this.injector, providerKey, source);
                BindingProcessor.this.creationListeners.add(boundProviderFactory);
                InternalFactory scope = Scopes.scope(key, BindingProcessor.this.injector, boundProviderFactory, makeInjectable);
                BindingProcessor bindingProcessor = BindingProcessor.this;
                bindingProcessor.putBinding(new LinkedProviderBindingImpl(bindingProcessor.injector, key, source, scope, makeInjectable, providerKey));
                return null;
            }

            public Void visit(LinkedKeyBinding<? extends T> linkedKeyBinding) {
                Key<? extends Object> linkedKey = linkedKeyBinding.getLinkedKey();
                if (key.equals(linkedKey)) {
                    BindingProcessor.this.errors.recursiveBinding();
                }
                FactoryProxy factoryProxy = new FactoryProxy(BindingProcessor.this.injector, key, linkedKey, source);
                BindingProcessor.this.creationListeners.add(factoryProxy);
                InternalFactory scope = Scopes.scope(key, BindingProcessor.this.injector, factoryProxy, makeInjectable);
                BindingProcessor bindingProcessor = BindingProcessor.this;
                bindingProcessor.putBinding(new LinkedBindingImpl(bindingProcessor.injector, key, source, scope, makeInjectable, linkedKey));
                return null;
            }

            public Void visit(UntargettedBinding<? extends T> untargettedBinding) {
                if (key.hasAnnotationType()) {
                    BindingProcessor.this.errors.missingImplementation(key);
                    BindingProcessor bindingProcessor = BindingProcessor.this;
                    bindingProcessor.putBinding(bindingProcessor.invalidBinding(bindingProcessor.injector, key, source));
                    return null;
                }
                try {
                    final BindingImpl createUnitializedBinding = BindingProcessor.this.injector.createUnitializedBinding(key, makeInjectable, source, BindingProcessor.this.errors);
                    BindingProcessor.this.putBinding(createUnitializedBinding);
                    BindingProcessor.this.uninitializedBindings.add(new Runnable() {
                        public void run() {
                            try {
                                ((InjectorImpl) createUnitializedBinding.getInjector()).initializeBinding(createUnitializedBinding, BindingProcessor.this.errors.withSource(source));
                            } catch (ErrorsException e) {
                                BindingProcessor.this.errors.merge(e.getErrors());
                            }
                        }
                    });
                    return null;
                } catch (ErrorsException e) {
                    BindingProcessor.this.errors.merge(e.getErrors());
                    BindingProcessor bindingProcessor2 = BindingProcessor.this;
                    bindingProcessor2.putBinding(bindingProcessor2.invalidBinding(bindingProcessor2.injector, key, source));
                    return null;
                }
            }

            public Void visit(ExposedBinding<? extends T> exposedBinding) {
                throw new IllegalArgumentException("Cannot apply a non-module element");
            }

            public Void visit(ConvertedConstantBinding<? extends T> convertedConstantBinding) {
                throw new IllegalArgumentException("Cannot apply a non-module element");
            }

            public Void visit(ConstructorBinding<? extends T> constructorBinding) {
                throw new IllegalArgumentException("Cannot apply a non-module element");
            }

            public Void visit(ProviderBinding<? extends T> providerBinding) {
                throw new IllegalArgumentException("Cannot apply a non-module element");
            }
        });
        return true;
    }

    public Boolean visit(PrivateElements privateElements) {
        for (Key<?> bindExposed : privateElements.getExposedKeys()) {
            bindExposed(privateElements, bindExposed);
        }
        return false;
    }

    private <T> void bindExposed(PrivateElements privateElements, Key<T> key) {
        ExposedKeyFactory exposedKeyFactory = new ExposedKeyFactory(key, privateElements);
        this.creationListeners.add(exposedKeyFactory);
        putBinding(new ExposedBindingImpl(this.injector, privateElements.getExposedSource(key), key, exposedKeyFactory, privateElements));
    }

    private <T> void validateKey(Object obj, Key<T> key) {
        Annotations.checkForMisplacedScopeAnnotations(key.getRawType(), obj, this.errors);
    }

    /* access modifiers changed from: package-private */
    public <T> UntargettedBindingImpl<T> invalidBinding(InjectorImpl injectorImpl, Key<T> key, Object obj) {
        return new UntargettedBindingImpl<>((Injector) injectorImpl, key, obj);
    }

    public void initializeBindings() {
        for (Runnable run : this.uninitializedBindings) {
            run.run();
        }
    }

    public void runCreationListeners() {
        for (CreationListener notify : this.creationListeners) {
            notify.notify(this.errors);
        }
    }

    /* access modifiers changed from: private */
    public void putBinding(BindingImpl<?> bindingImpl) {
        Key<?> key = bindingImpl.getKey();
        Class<? super Object> rawType = key.getRawType();
        if (FORBIDDEN_TYPES.contains(rawType)) {
            this.errors.cannotBindToGuiceType(rawType.getSimpleName());
            return;
        }
        BindingImpl<?> explicitBinding = this.injector.state.getExplicitBinding(key);
        if (explicitBinding == null || isOkayDuplicate(explicitBinding, bindingImpl)) {
            this.injector.state.parent().blacklist(key);
            this.injector.state.putBinding(key, bindingImpl);
            return;
        }
        this.errors.bindingAlreadySet(key, explicitBinding.getSource());
    }

    private boolean isOkayDuplicate(Binding<?> binding, BindingImpl<?> bindingImpl) {
        if (!(binding instanceof ExposedBindingImpl) || ((InjectorImpl) ((ExposedBindingImpl) binding).getPrivateElements().getInjector()) != bindingImpl.getInjector()) {
            return false;
        }
        return true;
    }
}
