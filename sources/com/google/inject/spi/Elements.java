package com.google.inject.spi;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Binding;
import com.google.inject.Key;
import com.google.inject.MembersInjector;
import com.google.inject.Module;
import com.google.inject.PrivateBinder;
import com.google.inject.PrivateModule;
import com.google.inject.Provider;
import com.google.inject.Scope;
import com.google.inject.Stage;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.AnnotatedConstantBindingBuilder;
import com.google.inject.binder.AnnotatedElementBuilder;
import com.google.inject.internal.AbstractBindingBuilder;
import com.google.inject.internal.BindingBuilder;
import com.google.inject.internal.ConstantBindingBuilderImpl;
import com.google.inject.internal.Errors;
import com.google.inject.internal.ExposureBuilder;
import com.google.inject.internal.ImmutableList;
import com.google.inject.internal.Lists;
import com.google.inject.internal.Preconditions;
import com.google.inject.internal.PrivateElementsImpl;
import com.google.inject.internal.ProviderMethodsModule;
import com.google.inject.internal.Sets;
import com.google.inject.internal.SourceProvider;
import com.google.inject.matcher.Matcher;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Elements {
    private static final BindingTargetVisitor<Object, Object> GET_INSTANCE_VISITOR = new DefaultBindingTargetVisitor<Object, Object>() {
        public Object visit(InstanceBinding<?> instanceBinding) {
            return instanceBinding.getInstance();
        }

        /* access modifiers changed from: protected */
        public Object visitOther(Binding<?> binding) {
            throw new IllegalArgumentException();
        }
    };

    public static List<Element> getElements(Module... moduleArr) {
        return getElements(Stage.DEVELOPMENT, (Iterable<? extends Module>) Arrays.asList(moduleArr));
    }

    public static List<Element> getElements(Stage stage, Module... moduleArr) {
        return getElements(stage, (Iterable<? extends Module>) Arrays.asList(moduleArr));
    }

    public static List<Element> getElements(Iterable<? extends Module> iterable) {
        return getElements(Stage.DEVELOPMENT, iterable);
    }

    public static List<Element> getElements(Stage stage, Iterable<? extends Module> iterable) {
        RecordingBinder recordingBinder = new RecordingBinder(stage);
        for (Module install : iterable) {
            recordingBinder.install(install);
        }
        return Collections.unmodifiableList(recordingBinder.elements);
    }

    public static Module getModule(final Iterable<? extends Element> iterable) {
        return new Module() {
            public void configure(Binder binder) {
                for (Element applyTo : iterable) {
                    applyTo.applyTo(binder);
                }
            }
        };
    }

    static <T> BindingTargetVisitor<T, T> getInstanceVisitor() {
        return GET_INSTANCE_VISITOR;
    }

    private static class RecordingBinder implements Binder, PrivateBinder {
        /* access modifiers changed from: private */
        public final List<Element> elements;
        private final Set<Module> modules;
        private final RecordingBinder parent;
        private final PrivateElementsImpl privateElements;
        private final Object source;
        private final SourceProvider sourceProvider;
        private final Stage stage;

        public String toString() {
            return "Binder";
        }

        private RecordingBinder(Stage stage2) {
            this.stage = stage2;
            this.modules = Sets.newHashSet();
            this.elements = Lists.newArrayList();
            this.source = null;
            this.sourceProvider = new SourceProvider().plusSkippedClasses(Elements.class, RecordingBinder.class, AbstractModule.class, ConstantBindingBuilderImpl.class, AbstractBindingBuilder.class, BindingBuilder.class);
            this.parent = null;
            this.privateElements = null;
        }

        private RecordingBinder(RecordingBinder recordingBinder, Object obj, SourceProvider sourceProvider2) {
            boolean z = true;
            Preconditions.checkArgument((sourceProvider2 != null ? false : z) ^ (obj == null));
            this.stage = recordingBinder.stage;
            this.modules = recordingBinder.modules;
            this.elements = recordingBinder.elements;
            this.source = obj;
            this.sourceProvider = sourceProvider2;
            this.parent = recordingBinder.parent;
            this.privateElements = recordingBinder.privateElements;
        }

        private RecordingBinder(RecordingBinder recordingBinder, PrivateElementsImpl privateElementsImpl) {
            this.stage = recordingBinder.stage;
            this.modules = Sets.newHashSet();
            this.elements = privateElementsImpl.getElementsMutable();
            this.source = recordingBinder.source;
            this.sourceProvider = recordingBinder.sourceProvider;
            this.parent = recordingBinder;
            this.privateElements = privateElementsImpl;
        }

        public void bindScope(Class<? extends Annotation> cls, Scope scope) {
            this.elements.add(new ScopeBinding(getSource(), cls, scope));
        }

        public void requestInjection(Object obj) {
            requestInjection(TypeLiteral.get(obj.getClass()), obj);
        }

        public <T> void requestInjection(TypeLiteral<T> typeLiteral, T t) {
            this.elements.add(new InjectionRequest(getSource(), typeLiteral, t));
        }

        public <T> MembersInjector<T> getMembersInjector(TypeLiteral<T> typeLiteral) {
            MembersInjectorLookup membersInjectorLookup = new MembersInjectorLookup(getSource(), typeLiteral);
            this.elements.add(membersInjectorLookup);
            return membersInjectorLookup.getMembersInjector();
        }

        public <T> MembersInjector<T> getMembersInjector(Class<T> cls) {
            return getMembersInjector(TypeLiteral.get(cls));
        }

        public void bindListener(Matcher<? super TypeLiteral<?>> matcher, TypeListener typeListener) {
            this.elements.add(new TypeListenerBinding(getSource(), typeListener, matcher));
        }

        public void requestStaticInjection(Class<?>... clsArr) {
            for (Class<?> staticInjectionRequest : clsArr) {
                this.elements.add(new StaticInjectionRequest(getSource(), staticInjectionRequest));
            }
        }

        public void install(Module module) {
            if (this.modules.add(module)) {
                PrivateBinder newPrivateBinder = module instanceof PrivateModule ? newPrivateBinder() : this;
                try {
                    module.configure(newPrivateBinder);
                } catch (RuntimeException e) {
                    Collection<Message> messagesFromThrowable = Errors.getMessagesFromThrowable(e);
                    if (!messagesFromThrowable.isEmpty()) {
                        this.elements.addAll(messagesFromThrowable);
                    } else {
                        addError((Throwable) e);
                    }
                }
                newPrivateBinder.install(ProviderMethodsModule.forModule(module));
            }
        }

        public Stage currentStage() {
            return this.stage;
        }

        public void addError(String str, Object... objArr) {
            this.elements.add(new Message(getSource(), Errors.format(str, objArr)));
        }

        public void addError(Throwable th) {
            this.elements.add(new Message(ImmutableList.m336of(getSource()), "An exception was caught and reported. Message: " + th.getMessage(), th));
        }

        public void addError(Message message) {
            this.elements.add(message);
        }

        public <T> AnnotatedBindingBuilder<T> bind(Key<T> key) {
            return new BindingBuilder(this, this.elements, getSource(), key);
        }

        public <T> AnnotatedBindingBuilder<T> bind(TypeLiteral<T> typeLiteral) {
            return bind(Key.get(typeLiteral));
        }

        public <T> AnnotatedBindingBuilder<T> bind(Class<T> cls) {
            return bind(Key.get(cls));
        }

        public AnnotatedConstantBindingBuilder bindConstant() {
            return new ConstantBindingBuilderImpl(this, this.elements, getSource());
        }

        public <T> Provider<T> getProvider(Key<T> key) {
            ProviderLookup providerLookup = new ProviderLookup(getSource(), key);
            this.elements.add(providerLookup);
            return providerLookup.getProvider();
        }

        public <T> Provider<T> getProvider(Class<T> cls) {
            return getProvider(Key.get(cls));
        }

        public void convertToTypes(Matcher<? super TypeLiteral<?>> matcher, TypeConverter typeConverter) {
            this.elements.add(new TypeConverterBinding(getSource(), matcher, typeConverter));
        }

        public RecordingBinder withSource(Object obj) {
            return new RecordingBinder(this, obj, (SourceProvider) null);
        }

        public RecordingBinder skipSources(Class... clsArr) {
            if (this.source != null) {
                return this;
            }
            return new RecordingBinder(this, (Object) null, this.sourceProvider.plusSkippedClasses(clsArr));
        }

        public PrivateBinder newPrivateBinder() {
            PrivateElementsImpl privateElementsImpl = new PrivateElementsImpl(getSource());
            this.elements.add(privateElementsImpl);
            return new RecordingBinder(this, privateElementsImpl);
        }

        public void expose(Key<?> key) {
            exposeInternal(key);
        }

        public AnnotatedElementBuilder expose(Class<?> cls) {
            return exposeInternal(Key.get(cls));
        }

        public AnnotatedElementBuilder expose(TypeLiteral<?> typeLiteral) {
            return exposeInternal(Key.get(typeLiteral));
        }

        private <T> AnnotatedElementBuilder exposeInternal(Key<T> key) {
            if (this.privateElements == null) {
                addError("Cannot expose %s on a standard binder. Exposed bindings are only applicable to private binders.", key);
                return new AnnotatedElementBuilder() {
                    public void annotatedWith(Class<? extends Annotation> cls) {
                    }

                    public void annotatedWith(Annotation annotation) {
                    }
                };
            }
            ExposureBuilder exposureBuilder = new ExposureBuilder(this, getSource(), key);
            this.privateElements.addExposureBuilder(exposureBuilder);
            return exposureBuilder;
        }

        /* access modifiers changed from: protected */
        public Object getSource() {
            SourceProvider sourceProvider2 = this.sourceProvider;
            return sourceProvider2 != null ? sourceProvider2.get() : this.source;
        }
    }
}
