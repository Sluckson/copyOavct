package com.google.inject;

import com.google.inject.internal.Annotations;
import com.google.inject.internal.BindingImpl;
import com.google.inject.internal.Classes;
import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.ImmutableList;
import com.google.inject.internal.ImmutableSet;
import com.google.inject.internal.InstanceBindingImpl;
import com.google.inject.internal.InternalContext;
import com.google.inject.internal.InternalFactory;
import com.google.inject.internal.LinkedBindingImpl;
import com.google.inject.internal.LinkedProviderBindingImpl;
import com.google.inject.internal.Lists;
import com.google.inject.internal.Maps;
import com.google.inject.internal.Nullable;
import com.google.inject.internal.Scoping;
import com.google.inject.internal.SourceProvider;
import com.google.inject.internal.ToStringBuilder;
import com.google.inject.spi.BindingTargetVisitor;
import com.google.inject.spi.ConvertedConstantBinding;
import com.google.inject.spi.Dependency;
import com.google.inject.spi.Message;
import com.google.inject.spi.ProviderBinding;
import com.google.inject.spi.ProviderKeyBinding;
import com.google.inject.util.Providers;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

class InjectorImpl implements Injector, Lookups {
    final BindingsMultimap bindingsMultimap = new BindingsMultimap();
    final ConstructorInjectorStore constructors = new ConstructorInjectorStore(this);
    final Initializer initializer;
    final Map<Key<?>, BindingImpl<?>> jitBindings = Maps.newHashMap();
    final ThreadLocal<Object[]> localContext;
    Lookups lookups = new DeferredLookups(this);
    MembersInjectorStore membersInjectorStore;
    final InjectorImpl parent;
    final State state;

    interface MethodInvoker {
        Object invoke(Object obj, Object... objArr) throws IllegalAccessException, InvocationTargetException;
    }

    InjectorImpl(@Nullable InjectorImpl injectorImpl, State state2, Initializer initializer2) {
        this.parent = injectorImpl;
        this.state = state2;
        this.initializer = initializer2;
        if (injectorImpl != null) {
            this.localContext = injectorImpl.localContext;
        } else {
            this.localContext = new ThreadLocal<Object[]>() {
                /* access modifiers changed from: protected */
                public Object[] initialValue() {
                    return new Object[1];
                }
            };
        }
    }

    /* access modifiers changed from: package-private */
    public void index() {
        for (Binding<?> index : this.state.getExplicitBindingsThisLevel().values()) {
            index(index);
        }
    }

    /* access modifiers changed from: package-private */
    public <T> void index(Binding<T> binding) {
        this.bindingsMultimap.put(binding.getKey().getTypeLiteral(), binding);
    }

    public <T> List<Binding<T>> findBindingsByType(TypeLiteral<T> typeLiteral) {
        return this.bindingsMultimap.getAll(typeLiteral);
    }

    public <T> BindingImpl<T> getBinding(Key<T> key) {
        Errors errors = new Errors(key);
        try {
            BindingImpl<T> bindingOrThrow = getBindingOrThrow(key, errors);
            errors.throwConfigurationExceptionIfErrorsExist();
            return bindingOrThrow;
        } catch (ErrorsException e) {
            throw new ConfigurationException(errors.merge(e.getErrors()).getMessages());
        }
    }

    public <T> BindingImpl<T> getBindingOrThrow(Key<T> key, Errors errors) throws ErrorsException {
        BindingImpl<T> explicitBinding = this.state.getExplicitBinding(key);
        if (explicitBinding != null) {
            return explicitBinding;
        }
        return getJustInTimeBinding(key, errors);
    }

    public <T> Binding<T> getBinding(Class<T> cls) {
        return getBinding((Key) Key.get(cls));
    }

    public Injector getParent() {
        return this.parent;
    }

    public Injector createChildInjector(Iterable<? extends Module> iterable) {
        return new InjectorBuilder().parentInjector(this).addModules(iterable).build();
    }

    public Injector createChildInjector(Module... moduleArr) {
        return createChildInjector((Iterable<? extends Module>) ImmutableList.m341of((E[]) moduleArr));
    }

    private <T> BindingImpl<T> getJustInTimeBinding(Key<T> key, Errors errors) throws ErrorsException {
        synchronized (this.state.lock()) {
            for (InjectorImpl injectorImpl = this; injectorImpl != null; injectorImpl = injectorImpl.parent) {
                BindingImpl<T> bindingImpl = injectorImpl.jitBindings.get(key);
                if (bindingImpl != null) {
                    return bindingImpl;
                }
            }
            BindingImpl<T> createJustInTimeBindingRecursive = createJustInTimeBindingRecursive(key, errors);
            return createJustInTimeBindingRecursive;
        }
    }

    static boolean isProvider(Key<?> key) {
        return key.getTypeLiteral().getRawType().equals(Provider.class);
    }

    static boolean isMembersInjector(Key<?> key) {
        return key.getTypeLiteral().getRawType().equals(MembersInjector.class) && !key.hasAnnotationType();
    }

    private <T> BindingImpl<MembersInjector<T>> createMembersInjectorBinding(Key<MembersInjector<T>> key, Errors errors) throws ErrorsException {
        Type type = key.getTypeLiteral().getType();
        if (type instanceof ParameterizedType) {
            MembersInjectorImpl<?> membersInjectorImpl = this.membersInjectorStore.get(TypeLiteral.get(((ParameterizedType) type).getActualTypeArguments()[0]), errors);
            return new InstanceBindingImpl(this, key, SourceProvider.UNKNOWN_SOURCE, new ConstantFactory(Initializables.m301of(membersInjectorImpl)), ImmutableSet.m348of(), membersInjectorImpl);
        }
        throw errors.cannotInjectRawMembersInjector().toException();
    }

    private <T> BindingImpl<Provider<T>> createProviderBinding(Key<Provider<T>> key, Errors errors) throws ErrorsException {
        Type type = key.getTypeLiteral().getType();
        if (type instanceof ParameterizedType) {
            return new ProviderBindingImpl(this, key, getBindingOrThrow(key.ofType(((ParameterizedType) type).getActualTypeArguments()[0]), errors));
        }
        throw errors.cannotInjectRawProvider().toException();
    }

    static class ProviderBindingImpl<T> extends BindingImpl<Provider<T>> implements ProviderBinding<Provider<T>> {
        final BindingImpl<T> providedBinding;

        ProviderBindingImpl(InjectorImpl injectorImpl, Key<Provider<T>> key, Binding<T> binding) {
            super(injectorImpl, key, binding.getSource(), createInternalFactory(binding), Scoping.UNSCOPED);
            this.providedBinding = (BindingImpl) binding;
        }

        static <T> InternalFactory<Provider<T>> createInternalFactory(Binding<T> binding) {
            final Provider<T> provider = binding.getProvider();
            return new InternalFactory<Provider<T>>() {
                public Provider<T> get(Errors errors, InternalContext internalContext, Dependency dependency) {
                    return provider;
                }
            };
        }

        public Key<? extends T> getProvidedKey() {
            return this.providedBinding.getKey();
        }

        public <V> V acceptTargetVisitor(BindingTargetVisitor<? super Provider<T>, V> bindingTargetVisitor) {
            return bindingTargetVisitor.visit((ProviderBinding<? extends Object>) this);
        }

        public void applyTo(Binder binder) {
            throw new UnsupportedOperationException("This element represents a synthetic binding.");
        }

        public String toString() {
            return new ToStringBuilder(ProviderKeyBinding.class).add("key", getKey()).add("providedKey", getProvidedKey()).toString();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r2 = (java.lang.String) r0.getProvider().get();
        r9 = r0.getSource();
        r10 = r13.getTypeLiteral();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> com.google.inject.internal.BindingImpl<T> convertConstantStringBinding(com.google.inject.Key<T> r13, com.google.inject.internal.Errors r14) throws com.google.inject.internal.ErrorsException {
        /*
            r12 = this;
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            com.google.inject.Key r0 = r13.ofType(r0)
            com.google.inject.State r1 = r12.state
            com.google.inject.internal.BindingImpl r0 = r1.getExplicitBinding(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0074
            boolean r2 = r0.isConstant()
            if (r2 != 0) goto L_0x0016
            goto L_0x0074
        L_0x0016:
            com.google.inject.Provider r2 = r0.getProvider()
            java.lang.Object r2 = r2.get()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r9 = r0.getSource()
            com.google.inject.TypeLiteral r10 = r13.getTypeLiteral()
            com.google.inject.State r3 = r12.state
            com.google.inject.internal.MatcherAndConverter r11 = r3.getConverter(r2, r10, r14, r9)
            if (r11 != 0) goto L_0x0031
            return r1
        L_0x0031:
            com.google.inject.spi.TypeConverter r1 = r11.getTypeConverter()     // Catch:{ ErrorsException -> 0x0072, RuntimeException -> 0x0062 }
            java.lang.Object r8 = r1.convert(r2, r10)     // Catch:{ ErrorsException -> 0x0072, RuntimeException -> 0x0062 }
            if (r8 == 0) goto L_0x0059
            java.lang.Class r1 = r10.getRawType()     // Catch:{ ErrorsException -> 0x0072, RuntimeException -> 0x0062 }
            boolean r1 = r1.isInstance(r8)     // Catch:{ ErrorsException -> 0x0072, RuntimeException -> 0x0062 }
            if (r1 == 0) goto L_0x004b
            com.google.inject.InjectorImpl$ConvertedConstantBindingImpl r1 = new com.google.inject.InjectorImpl$ConvertedConstantBindingImpl     // Catch:{ ErrorsException -> 0x0072, RuntimeException -> 0x0062 }
            r1.<init>(r12, r13, r8, r0)     // Catch:{ ErrorsException -> 0x0072, RuntimeException -> 0x0062 }
            return r1
        L_0x004b:
            r3 = r14
            r4 = r2
            r5 = r9
            r6 = r10
            r7 = r11
            com.google.inject.internal.Errors r13 = r3.conversionTypeError(r4, r5, r6, r7, r8)     // Catch:{ ErrorsException -> 0x0072, RuntimeException -> 0x0062 }
            com.google.inject.internal.ErrorsException r13 = r13.toException()     // Catch:{ ErrorsException -> 0x0072, RuntimeException -> 0x0062 }
            throw r13     // Catch:{ ErrorsException -> 0x0072, RuntimeException -> 0x0062 }
        L_0x0059:
            com.google.inject.internal.Errors r13 = r14.converterReturnedNull(r2, r9, r10, r11)     // Catch:{ ErrorsException -> 0x0072, RuntimeException -> 0x0062 }
            com.google.inject.internal.ErrorsException r13 = r13.toException()     // Catch:{ ErrorsException -> 0x0072, RuntimeException -> 0x0062 }
            throw r13     // Catch:{ ErrorsException -> 0x0072, RuntimeException -> 0x0062 }
        L_0x0062:
            r13 = move-exception
            r8 = r13
            r3 = r14
            r4 = r2
            r5 = r9
            r6 = r10
            r7 = r11
            com.google.inject.internal.Errors r13 = r3.conversionError(r4, r5, r6, r7, r8)
            com.google.inject.internal.ErrorsException r13 = r13.toException()
            throw r13
        L_0x0072:
            r13 = move-exception
            throw r13
        L_0x0074:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.inject.InjectorImpl.convertConstantStringBinding(com.google.inject.Key, com.google.inject.internal.Errors):com.google.inject.internal.BindingImpl");
    }

    private static class ConvertedConstantBindingImpl<T> extends BindingImpl<T> implements ConvertedConstantBinding<T> {
        final Binding<String> originalBinding;
        final Provider<T> provider;
        final T value;

        ConvertedConstantBindingImpl(Injector injector, Key<T> key, T t, Binding<String> binding) {
            super(injector, key, binding.getSource(), new ConstantFactory(Initializables.m301of(t)), Scoping.UNSCOPED);
            this.value = t;
            this.provider = Providers.m353of(t);
            this.originalBinding = binding;
        }

        public Provider<T> getProvider() {
            return this.provider;
        }

        public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> bindingTargetVisitor) {
            return bindingTargetVisitor.visit((ConvertedConstantBinding<? extends Object>) this);
        }

        public T getValue() {
            return this.value;
        }

        public Key<String> getSourceKey() {
            return this.originalBinding.getKey();
        }

        public Set<Dependency<?>> getDependencies() {
            return ImmutableSet.m349of(Dependency.get(getSourceKey()));
        }

        public void applyTo(Binder binder) {
            throw new UnsupportedOperationException("This element represents a synthetic binding.");
        }

        public String toString() {
            return new ToStringBuilder(ConvertedConstantBinding.class).add("key", getKey()).add("sourceKey", getSourceKey()).add("value", this.value).toString();
        }
    }

    /* access modifiers changed from: package-private */
    public <T> void initializeBinding(BindingImpl<T> bindingImpl, Errors errors) throws ErrorsException {
        if (bindingImpl instanceof ConstructorBindingImpl) {
            Key<T> key = bindingImpl.getKey();
            this.jitBindings.put(key, bindingImpl);
            try {
                ((ConstructorBindingImpl) bindingImpl).initialize(this, errors);
            } catch (Throwable th) {
                this.jitBindings.remove(key);
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public <T> BindingImpl<T> createUnitializedBinding(Key<T> key, Scoping scoping, Object obj, Errors errors) throws ErrorsException {
        Class<? extends Annotation> findScopeAnnotation;
        Class<? super T> rawType = key.getTypeLiteral().getRawType();
        if (rawType.isArray() || rawType.isEnum()) {
            throw errors.missingImplementation(key).toException();
        } else if (rawType == TypeLiteral.class) {
            return createTypeLiteralBinding(key, errors);
        } else {
            ImplementedBy implementedBy = (ImplementedBy) rawType.getAnnotation(ImplementedBy.class);
            if (implementedBy != null) {
                Annotations.checkForMisplacedScopeAnnotations(rawType, obj, errors);
                return createImplementedByBinding(key, scoping, implementedBy, errors);
            }
            ProvidedBy providedBy = (ProvidedBy) rawType.getAnnotation(ProvidedBy.class);
            if (providedBy != null) {
                Annotations.checkForMisplacedScopeAnnotations(rawType, obj, errors);
                return createProvidedByBinding(key, scoping, providedBy, errors);
            } else if (Modifier.isAbstract(rawType.getModifiers())) {
                throw errors.missingImplementation(key).toException();
            } else if (!Classes.isInnerClass(rawType)) {
                if (!scoping.isExplicitlyScoped() && (findScopeAnnotation = Annotations.findScopeAnnotation(errors, (Class<?>) rawType)) != null) {
                    scoping = Scopes.makeInjectable(Scoping.forAnnotation(findScopeAnnotation), this, errors.withSource(rawType));
                }
                return ConstructorBindingImpl.create(this, key, obj, scoping);
            } else {
                throw errors.cannotInjectInnerClass(rawType).toException();
            }
        }
    }

    private <T> BindingImpl<TypeLiteral<T>> createTypeLiteralBinding(Key<TypeLiteral<T>> key, Errors errors) throws ErrorsException {
        Type type = key.getTypeLiteral().getType();
        if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if ((type2 instanceof Class) || (type2 instanceof GenericArrayType) || (type2 instanceof ParameterizedType)) {
                TypeLiteral<?> typeLiteral = TypeLiteral.get(type2);
                return new InstanceBindingImpl(this, key, SourceProvider.UNKNOWN_SOURCE, new ConstantFactory(Initializables.m301of(typeLiteral)), ImmutableSet.m348of(), typeLiteral);
            }
            throw errors.cannotInjectTypeLiteralOf(type2).toException();
        }
        throw errors.cannotInjectRawTypeLiteral().toException();
    }

    /* access modifiers changed from: package-private */
    public <T> BindingImpl<T> createProvidedByBinding(Key<T> key, Scoping scoping, ProvidedBy providedBy, Errors errors) throws ErrorsException {
        Class<? super T> rawType = key.getTypeLiteral().getRawType();
        final Class<? extends Provider<?>> value = providedBy.value();
        if (value != rawType) {
            Key<? extends Provider<?>> key2 = Key.get(value);
            final BindingImpl<? extends Provider<?>> bindingOrThrow = getBindingOrThrow(key2, errors);
            final Key<? extends Provider<?>> key3 = key2;
            final Class<? super T> cls = rawType;
            return new LinkedProviderBindingImpl(this, key, rawType, Scopes.scope(key, this, new InternalFactory<T>() {
                public T get(Errors errors, InternalContext internalContext, Dependency dependency) throws ErrorsException {
                    Errors withSource = errors.withSource(key3);
                    try {
                        T t = ((Provider) bindingOrThrow.getInternalFactory().get(withSource, internalContext, dependency)).get();
                        if (t != null) {
                            if (!cls.isInstance(t)) {
                                throw withSource.subtypeNotProvided(value, cls).toException();
                            }
                        }
                        return t;
                    } catch (RuntimeException e) {
                        throw withSource.errorInProvider(e).toException();
                    }
                }
            }, scoping), scoping, key2);
        }
        throw errors.recursiveProviderType().toException();
    }

    /* access modifiers changed from: package-private */
    public <T> BindingImpl<T> createImplementedByBinding(Key<T> key, Scoping scoping, ImplementedBy implementedBy, Errors errors) throws ErrorsException {
        Class<? super T> rawType = key.getTypeLiteral().getRawType();
        Class<?> value = implementedBy.value();
        if (value == rawType) {
            throw errors.recursiveImplementationType().toException();
        } else if (rawType.isAssignableFrom(value)) {
            final Key<?> key2 = Key.get(value);
            final BindingImpl<?> bindingOrThrow = getBindingOrThrow(key2, errors);
            return new LinkedBindingImpl(this, key, rawType, Scopes.scope(key, this, new InternalFactory<T>() {
                public T get(Errors errors, InternalContext internalContext, Dependency<?> dependency) throws ErrorsException {
                    return bindingOrThrow.getInternalFactory().get(errors.withSource(key2), internalContext, dependency);
                }
            }, scoping), scoping, key2);
        } else {
            throw errors.notASubtype(value, rawType).toException();
        }
    }

    private <T> BindingImpl<T> createJustInTimeBindingRecursive(Key<T> key, Errors errors) throws ErrorsException {
        InjectorImpl injectorImpl = this.parent;
        if (injectorImpl != null) {
            try {
                return injectorImpl.createJustInTimeBindingRecursive(key, new Errors());
            } catch (ErrorsException unused) {
            }
        }
        if (!this.state.isBlacklisted(key)) {
            BindingImpl<T> createJustInTimeBinding = createJustInTimeBinding(key, errors);
            this.state.parent().blacklist(key);
            this.jitBindings.put(key, createJustInTimeBinding);
            return createJustInTimeBinding;
        }
        throw errors.childBindingAlreadySet(key).toException();
    }

    /* access modifiers changed from: package-private */
    public <T> BindingImpl<T> createJustInTimeBinding(Key<T> key, Errors errors) throws ErrorsException {
        if (this.state.isBlacklisted(key)) {
            throw errors.childBindingAlreadySet(key).toException();
        } else if (isProvider(key)) {
            return createProviderBinding(key, errors);
        } else {
            if (isMembersInjector(key)) {
                return createMembersInjectorBinding(key, errors);
            }
            BindingImpl<T> convertConstantStringBinding = convertConstantStringBinding(key, errors);
            if (convertConstantStringBinding != null) {
                return convertConstantStringBinding;
            }
            if (key.hasAnnotationType()) {
                if (key.hasAttributes()) {
                    try {
                        return getBindingOrThrow(key.withoutAttributes(), new Errors());
                    } catch (ErrorsException unused) {
                    }
                }
                throw errors.missingImplementation(key).toException();
            }
            BindingImpl<T> createUnitializedBinding = createUnitializedBinding(key, Scoping.UNSCOPED, key.getTypeLiteral().getRawType(), errors);
            initializeBinding(createUnitializedBinding, errors);
            return createUnitializedBinding;
        }
    }

    /* access modifiers changed from: package-private */
    public <T> InternalFactory<? extends T> getInternalFactory(Key<T> key, Errors errors) throws ErrorsException {
        return getBindingOrThrow(key, errors).getInternalFactory();
    }

    public Map<Key<?>, Binding<?>> getBindings() {
        return this.state.getExplicitBindingsThisLevel();
    }

    private static class BindingsMultimap {
        final Map<TypeLiteral<?>, List<Binding<?>>> multimap;

        private BindingsMultimap() {
            this.multimap = Maps.newHashMap();
        }

        /* access modifiers changed from: package-private */
        public <T> void put(TypeLiteral<T> typeLiteral, Binding<T> binding) {
            List list = this.multimap.get(typeLiteral);
            if (list == null) {
                list = Lists.newArrayList();
                this.multimap.put(typeLiteral, list);
            }
            list.add(binding);
        }

        /* access modifiers changed from: package-private */
        public <T> List<Binding<T>> getAll(TypeLiteral<T> typeLiteral) {
            return this.multimap.get(typeLiteral) != null ? Collections.unmodifiableList(this.multimap.get(typeLiteral)) : ImmutableList.m335of();
        }
    }

    /* access modifiers changed from: package-private */
    public SingleParameterInjector<?>[] getParametersInjectors(List<Dependency<?>> list, Errors errors) throws ErrorsException {
        if (list.isEmpty()) {
            return null;
        }
        int size = errors.size();
        SingleParameterInjector<?>[] singleParameterInjectorArr = new SingleParameterInjector[list.size()];
        int i = 0;
        for (Dependency next : list) {
            int i2 = i + 1;
            try {
                singleParameterInjectorArr[i] = createParameterInjector(next, errors.withSource(next));
            } catch (ErrorsException unused) {
            }
            i = i2;
        }
        errors.throwIfNewErrors(size);
        return singleParameterInjectorArr;
    }

    /* access modifiers changed from: package-private */
    public <T> SingleParameterInjector<T> createParameterInjector(Dependency<T> dependency, Errors errors) throws ErrorsException {
        return new SingleParameterInjector<>(dependency, getInternalFactory(dependency.getKey(), errors));
    }

    public void injectMembers(Object obj) {
        getMembersInjector(obj.getClass()).injectMembers(obj);
    }

    public <T> MembersInjector<T> getMembersInjector(TypeLiteral<T> typeLiteral) {
        Errors errors = new Errors(typeLiteral);
        try {
            return this.membersInjectorStore.get(typeLiteral, errors);
        } catch (ErrorsException e) {
            throw new ConfigurationException(errors.merge(e.getErrors()).getMessages());
        }
    }

    public <T> MembersInjector<T> getMembersInjector(Class<T> cls) {
        return getMembersInjector(TypeLiteral.get(cls));
    }

    public <T> Provider<T> getProvider(Class<T> cls) {
        return getProvider(Key.get(cls));
    }

    /* access modifiers changed from: package-private */
    public <T> Provider<T> getProviderOrThrow(Key<T> key, Errors errors) throws ErrorsException {
        final InternalFactory<? extends T> internalFactory = getInternalFactory(key, errors);
        final Dependency<T> dependency = Dependency.get(key);
        return new Provider<T>() {
            public T get() {
                final Errors errors = new Errors(dependency);
                try {
                    T callInContext = InjectorImpl.this.callInContext(new ContextualCallable<T>() {
                        public T call(InternalContext internalContext) throws ErrorsException {
                            internalContext.setDependency(dependency);
                            try {
                                return internalFactory.get(errors, internalContext, dependency);
                            } finally {
                                internalContext.setDependency((Dependency) null);
                            }
                        }
                    });
                    errors.throwIfNewErrors(0);
                    return callInContext;
                } catch (ErrorsException e) {
                    throw new ProvisionException((Iterable<Message>) errors.merge(e.getErrors()).getMessages());
                }
            }

            public String toString() {
                return internalFactory.toString();
            }
        };
    }

    public <T> Provider<T> getProvider(Key<T> key) {
        Errors errors = new Errors(key);
        try {
            Provider<T> providerOrThrow = getProviderOrThrow(key, errors);
            errors.throwIfNewErrors(0);
            return providerOrThrow;
        } catch (ErrorsException e) {
            throw new ConfigurationException(errors.merge(e.getErrors()).getMessages());
        }
    }

    public <T> T getInstance(Key<T> key) {
        return getProvider(key).get();
    }

    public <T> T getInstance(Class<T> cls) {
        return getProvider(cls).get();
    }

    /* access modifiers changed from: package-private */
    public <T> T callInContext(ContextualCallable<T> contextualCallable) throws ErrorsException {
        Object[] objArr = this.localContext.get();
        if (objArr[0] != null) {
            return contextualCallable.call((InternalContext) objArr[0]);
        }
        objArr[0] = new InternalContext();
        try {
            return contextualCallable.call((InternalContext) objArr[0]);
        } finally {
            objArr[0] = null;
        }
    }

    public String toString() {
        return new ToStringBuilder(Injector.class).add("bindings", this.state.getExplicitBindingsThisLevel().values()).toString();
    }
}
