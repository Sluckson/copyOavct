package com.google.inject.internal;

import com.google.inject.ConfigurationException;
import com.google.inject.CreationException;
import com.google.inject.Key;
import com.google.inject.MembersInjector;
import com.google.inject.Provider;
import com.google.inject.ProvisionException;
import com.google.inject.Scope;
import com.google.inject.TypeLiteral;
import com.google.inject.spi.Dependency;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.InjectionPoint;
import com.google.inject.spi.Message;
import com.google.inject.spi.TypeListenerBinding;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Formatter;
import java.util.List;

public final class Errors implements Serializable {
    private static final String CONSTRUCTOR_RULES = "Classes must have either one (and only one) constructor annotated with @Inject or a zero-argument constructor that is not private.";
    private static final Collection<Converter<?>> converters = ImmutableList.m338of(new Converter<Class>(Class.class) {
        public String toString(Class cls) {
            return cls.getName();
        }
    }, new Converter<Member>(Member.class) {
        public String toString(Member member) {
            return MoreTypes.toString(member);
        }
    }, new Converter<Key>(Key.class) {
        public String toString(Key key) {
            if (key.getAnnotationType() == null) {
                return key.getTypeLiteral().toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(key.getTypeLiteral());
            sb.append(" annotated with ");
            sb.append(key.getAnnotation() != null ? key.getAnnotation() : key.getAnnotationType());
            return sb.toString();
        }
    });
    private List<Message> errors;
    private final Errors parent;
    private final Errors root;
    private final Object source;

    public Errors() {
        this.root = this;
        this.parent = null;
        this.source = SourceProvider.UNKNOWN_SOURCE;
    }

    public Errors(Object obj) {
        this.root = this;
        this.parent = null;
        this.source = obj;
    }

    private Errors(Errors errors2, Object obj) {
        this.root = errors2.root;
        this.parent = errors2;
        this.source = obj;
    }

    public Errors withSource(Object obj) {
        return obj == SourceProvider.UNKNOWN_SOURCE ? this : new Errors(this, obj);
    }

    public Errors missingImplementation(Key key) {
        return addMessage("No implementation for %s was bound.", key);
    }

    public Errors converterReturnedNull(String str, Object obj, TypeLiteral<?> typeLiteral, MatcherAndConverter matcherAndConverter) {
        return addMessage("Received null converting '%s' (bound at %s) to %s%n using %s.", str, convert(obj), typeLiteral, matcherAndConverter);
    }

    public Errors conversionTypeError(String str, Object obj, TypeLiteral<?> typeLiteral, MatcherAndConverter matcherAndConverter, Object obj2) {
        return addMessage("Type mismatch converting '%s' (bound at %s) to %s%n using %s.%n Converter returned %s.", str, convert(obj), typeLiteral, matcherAndConverter, obj2);
    }

    public Errors conversionError(String str, Object obj, TypeLiteral<?> typeLiteral, MatcherAndConverter matcherAndConverter, RuntimeException runtimeException) {
        return errorInUserCode(runtimeException, "Error converting '%s' (bound at %s) to %s%n using %s.%n Reason: %s", str, convert(obj), typeLiteral, matcherAndConverter, runtimeException);
    }

    public Errors ambiguousTypeConversion(String str, Object obj, TypeLiteral<?> typeLiteral, MatcherAndConverter matcherAndConverter, MatcherAndConverter matcherAndConverter2) {
        return addMessage("Multiple converters can convert '%s' (bound at %s) to %s:%n %s and%n %s.%n Please adjust your type converter configuration to avoid overlapping matches.", str, convert(obj), typeLiteral, matcherAndConverter, matcherAndConverter2);
    }

    public Errors bindingToProvider() {
        return addMessage("Binding to Provider is not allowed.", new Object[0]);
    }

    public Errors subtypeNotProvided(Class<? extends Provider<?>> cls, Class<?> cls2) {
        return addMessage("%s doesn't provide instances of %s.", cls, cls2);
    }

    public Errors notASubtype(Class<?> cls, Class<?> cls2) {
        return addMessage("%s doesn't extend %s.", cls, cls2);
    }

    public Errors recursiveImplementationType() {
        return addMessage("@ImplementedBy points to the same class it annotates.", new Object[0]);
    }

    public Errors recursiveProviderType() {
        return addMessage("@ProvidedBy points to the same class it annotates.", new Object[0]);
    }

    public Errors missingRuntimeRetention(Object obj) {
        return addMessage("Please annotate with @Retention(RUNTIME).%n Bound at %s.", convert(obj));
    }

    public Errors missingScopeAnnotation() {
        return addMessage("Please annotate with @ScopeAnnotation.", new Object[0]);
    }

    public Errors optionalConstructor(Constructor constructor) {
        return addMessage("%s is annotated @Inject(optional=true), but constructors cannot be optional.", constructor);
    }

    public Errors cannotBindToGuiceType(String str) {
        return addMessage("Binding to core guice framework type is not allowed: %s.", str);
    }

    public Errors scopeNotFound(Class<? extends Annotation> cls) {
        return addMessage("No scope is bound to %s.", cls);
    }

    public Errors scopeAnnotationOnAbstractType(Class<? extends Annotation> cls, Class<?> cls2, Object obj) {
        return addMessage("%s is annotated with %s, but scope annotations are not supported for abstract types.%n Bound at %s.", cls2, cls, convert(obj));
    }

    public Errors misplacedBindingAnnotation(Member member, Annotation annotation) {
        return addMessage("%s is annotated with %s, but binding annotations should be applied to its parameters instead.", member, annotation);
    }

    public Errors missingConstructor(Class<?> cls) {
        return addMessage("Could not find a suitable constructor in %s. Classes must have either one (and only one) constructor annotated with @Inject or a zero-argument constructor that is not private.", cls);
    }

    public Errors tooManyConstructors(Class<?> cls) {
        return addMessage("%s has more than one constructor annotated with @Inject. Classes must have either one (and only one) constructor annotated with @Inject or a zero-argument constructor that is not private.", cls);
    }

    public Errors duplicateScopes(Scope scope, Class<? extends Annotation> cls, Scope scope2) {
        return addMessage("Scope %s is already bound to %s. Cannot bind %s.", scope, cls, scope2);
    }

    public Errors voidProviderMethod() {
        return addMessage("Provider methods must return a value. Do not return void.", new Object[0]);
    }

    public Errors missingConstantValues() {
        return addMessage("Missing constant value. Please call to(...).", new Object[0]);
    }

    public Errors cannotInjectInnerClass(Class<?> cls) {
        return addMessage("Injecting into inner classes is not supported.  Please use a 'static' class (top-level or nested) instead of %s.", cls);
    }

    public Errors duplicateBindingAnnotations(Member member, Class<? extends Annotation> cls, Class<? extends Annotation> cls2) {
        return addMessage("%s has more than one annotation annotated with @BindingAnnotation: %s and %s", member, cls, cls2);
    }

    public Errors duplicateScopeAnnotations(Class<? extends Annotation> cls, Class<? extends Annotation> cls2) {
        return addMessage("More than one scope annotation was found: %s and %s.", cls, cls2);
    }

    public Errors recursiveBinding() {
        return addMessage("Binding points to itself.", new Object[0]);
    }

    public Errors bindingAlreadySet(Key<?> key, Object obj) {
        return addMessage("A binding to %s was already configured at %s.", key, convert(obj));
    }

    public Errors childBindingAlreadySet(Key<?> key) {
        return addMessage("A binding to %s already exists on a child injector.", key);
    }

    public Errors errorInjectingMethod(Throwable th) {
        return errorInUserCode(th, "Error injecting method, %s", th);
    }

    public Errors errorNotifyingTypeListener(TypeListenerBinding typeListenerBinding, TypeLiteral<?> typeLiteral, Throwable th) {
        return errorInUserCode(th, "Error notifying TypeListener %s (bound at %s) of %s.%n Reason: %s", typeListenerBinding.getListener(), convert(typeListenerBinding.getSource()), typeLiteral, th);
    }

    public Errors errorInjectingConstructor(Throwable th) {
        return errorInUserCode(th, "Error injecting constructor, %s", th);
    }

    public Errors errorInProvider(RuntimeException runtimeException) {
        return errorInUserCode(runtimeException, "Error in custom provider, %s", runtimeException);
    }

    public Errors errorInUserInjector(MembersInjector<?> membersInjector, TypeLiteral<?> typeLiteral, RuntimeException runtimeException) {
        return errorInUserCode(runtimeException, "Error injecting %s using %s.%n Reason: %s", typeLiteral, membersInjector, runtimeException);
    }

    public Errors errorNotifyingInjectionListener(InjectionListener<?> injectionListener, TypeLiteral<?> typeLiteral, RuntimeException runtimeException) {
        return errorInUserCode(runtimeException, "Error notifying InjectionListener %s of %s.%n Reason: %s", injectionListener, typeLiteral, runtimeException);
    }

    public void exposedButNotBound(Key<?> key) {
        addMessage("Could not expose() %s, it must be explicitly bound.", key);
    }

    public static Collection<Message> getMessagesFromThrowable(Throwable th) {
        if (th instanceof ProvisionException) {
            return ((ProvisionException) th).getErrorMessages();
        }
        if (th instanceof ConfigurationException) {
            return ((ConfigurationException) th).getErrorMessages();
        }
        if (th instanceof CreationException) {
            return ((CreationException) th).getErrorMessages();
        }
        return ImmutableSet.m348of();
    }

    public Errors errorInUserCode(Throwable th, String str, Object... objArr) {
        Collection<Message> messagesFromThrowable = getMessagesFromThrowable(th);
        if (!messagesFromThrowable.isEmpty()) {
            return merge(messagesFromThrowable);
        }
        return addMessage(th, str, objArr);
    }

    public Errors cannotInjectRawProvider() {
        return addMessage("Cannot inject a Provider that has no type parameter", new Object[0]);
    }

    public Errors cannotInjectRawMembersInjector() {
        return addMessage("Cannot inject a MembersInjector that has no type parameter", new Object[0]);
    }

    public Errors cannotInjectTypeLiteralOf(Type type) {
        return addMessage("Cannot inject a TypeLiteral of %s", type);
    }

    public Errors cannotInjectRawTypeLiteral() {
        return addMessage("Cannot inject a TypeLiteral that has no type parameter", new Object[0]);
    }

    public Errors cannotSatisfyCircularDependency(Class<?> cls) {
        return addMessage("Tried proxying %s to support a circular dependency, but it is not an interface.", cls);
    }

    public void throwCreationExceptionIfErrorsExist() {
        if (hasErrors()) {
            throw new CreationException(getMessages());
        }
    }

    public void throwConfigurationExceptionIfErrorsExist() {
        if (hasErrors()) {
            throw new ConfigurationException(getMessages());
        }
    }

    public void throwProvisionExceptionIfErrorsExist() {
        if (hasErrors()) {
            throw new ProvisionException((Iterable<Message>) getMessages());
        }
    }

    private Message merge(Message message) {
        ArrayList newArrayList = Lists.newArrayList();
        newArrayList.addAll(getSources());
        newArrayList.addAll(message.getSources());
        return new Message(newArrayList, message.getMessage(), message.getCause());
    }

    public Errors merge(Collection<Message> collection) {
        for (Message merge : collection) {
            addMessage(merge(merge));
        }
        return this;
    }

    public Errors merge(Errors errors2) {
        List<Message> list;
        Errors errors3 = errors2.root;
        if (!(errors3 == this.root || (list = errors3.errors) == null)) {
            merge((Collection<Message>) list);
        }
        return this;
    }

    public List<Object> getSources() {
        ArrayList newArrayList = Lists.newArrayList();
        for (Errors errors2 = this; errors2 != null; errors2 = errors2.parent) {
            if (errors2.source != SourceProvider.UNKNOWN_SOURCE) {
                newArrayList.add(0, errors2.source);
            }
        }
        return newArrayList;
    }

    public void throwIfNewErrors(int i) throws ErrorsException {
        if (size() != i) {
            throw toException();
        }
    }

    public ErrorsException toException() {
        return new ErrorsException(this);
    }

    public boolean hasErrors() {
        return this.root.errors != null;
    }

    public Errors addMessage(String str, Object... objArr) {
        return addMessage((Throwable) null, str, objArr);
    }

    private Errors addMessage(Throwable th, String str, Object... objArr) {
        addMessage(new Message(getSources(), format(str, objArr), th));
        return this;
    }

    public Errors addMessage(Message message) {
        Errors errors2 = this.root;
        if (errors2.errors == null) {
            errors2.errors = Lists.newArrayList();
        }
        this.root.errors.add(message);
        return this;
    }

    public static String format(String str, Object... objArr) {
        for (int i = 0; i < objArr.length; i++) {
            objArr[i] = convert(objArr[i]);
        }
        return String.format(str, objArr);
    }

    public List<Message> getMessages() {
        List<Message> list = this.root.errors;
        if (list == null) {
            return ImmutableList.m335of();
        }
        ArrayList<Message> newArrayList = Lists.newArrayList(list);
        Collections.sort(newArrayList, new Comparator<Message>() {
            public int compare(Message message, Message message2) {
                return message.getSource().compareTo(message2.getSource());
            }
        });
        return newArrayList;
    }

    public static String format(String str, Collection<Message> collection) {
        Formatter format = new Formatter().format(str, new Object[0]).format(":%n%n", new Object[0]);
        boolean z = getOnlyCause(collection) == null;
        int i = 1;
        for (Message next : collection) {
            int i2 = i + 1;
            format.format("%s) %s%n", new Object[]{Integer.valueOf(i), next.getMessage()});
            List<Object> sources = next.getSources();
            for (int size = sources.size() - 1; size >= 0; size--) {
                formatSource(format, sources.get(size));
            }
            Throwable cause = next.getCause();
            if (z && cause != null) {
                StringWriter stringWriter = new StringWriter();
                cause.printStackTrace(new PrintWriter(stringWriter));
                format.format("Caused by: %s", new Object[]{stringWriter.getBuffer()});
            }
            format.format("%n", new Object[0]);
            i = i2;
        }
        if (collection.size() == 1) {
            format.format("1 error", new Object[0]);
        } else {
            format.format("%s errors", new Object[]{Integer.valueOf(collection.size())});
        }
        return format.toString();
    }

    public <T> T checkForNull(T t, Object obj, Dependency<?> dependency) throws ErrorsException {
        String str;
        if (t != null || dependency.isNullable()) {
            return t;
        }
        int parameterIndex = dependency.getParameterIndex();
        if (parameterIndex != -1) {
            str = "parameter " + parameterIndex + " of ";
        } else {
            str = "";
        }
        addMessage("null returned by binding at %s%n but %s%s is not @Nullable", obj, str, dependency.getInjectionPoint().getMember());
        throw toException();
    }

    public static Throwable getOnlyCause(Collection<Message> collection) {
        Throwable th = null;
        for (Message cause : collection) {
            Throwable cause2 = cause.getCause();
            if (cause2 != null) {
                if (th != null) {
                    return null;
                }
                th = cause2;
            }
        }
        return th;
    }

    public int size() {
        List<Message> list = this.root.errors;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    private static abstract class Converter<T> {
        final Class<T> type;

        /* access modifiers changed from: package-private */
        public abstract String toString(T t);

        Converter(Class<T> cls) {
            this.type = cls;
        }

        /* access modifiers changed from: package-private */
        public boolean appliesTo(Object obj) {
            return this.type.isAssignableFrom(obj.getClass());
        }

        /* access modifiers changed from: package-private */
        public String convert(Object obj) {
            return toString(this.type.cast(obj));
        }
    }

    public static Object convert(Object obj) {
        for (Converter next : converters) {
            if (next.appliesTo(obj)) {
                return next.convert(obj);
            }
        }
        return obj;
    }

    public static void formatSource(Formatter formatter, Object obj) {
        if (obj instanceof Dependency) {
            Dependency dependency = (Dependency) obj;
            InjectionPoint injectionPoint = dependency.getInjectionPoint();
            if (injectionPoint != null) {
                formatInjectionPoint(formatter, dependency, injectionPoint);
            } else {
                formatSource(formatter, dependency.getKey());
            }
        } else if (obj instanceof InjectionPoint) {
            formatInjectionPoint(formatter, (Dependency<?>) null, (InjectionPoint) obj);
        } else if (obj instanceof Class) {
            formatter.format("  at %s%n", new Object[]{StackTraceElements.forType((Class) obj)});
        } else if (obj instanceof Member) {
            formatter.format("  at %s%n", new Object[]{StackTraceElements.forMember((Member) obj)});
        } else if (obj instanceof TypeLiteral) {
            formatter.format("  while locating %s%n", new Object[]{obj});
        } else if (obj instanceof Key) {
            formatter.format("  while locating %s%n", new Object[]{convert((Key) obj)});
        } else {
            formatter.format("  at %s%n", new Object[]{obj});
        }
    }

    public static void formatInjectionPoint(Formatter formatter, Dependency<?> dependency, InjectionPoint injectionPoint) {
        Member member = injectionPoint.getMember();
        if (MoreTypes.memberType(member) == Field.class) {
            formatter.format("  while locating %s%n", new Object[]{convert(injectionPoint.getDependencies().get(0).getKey())});
            formatter.format("    for field at %s%n", new Object[]{StackTraceElements.forMember(member)});
        } else if (dependency != null) {
            formatter.format("  while locating %s%n", new Object[]{convert(dependency.getKey())});
            formatter.format("    for parameter %s at %s%n", new Object[]{Integer.valueOf(dependency.getParameterIndex()), StackTraceElements.forMember(member)});
        } else {
            formatSource(formatter, injectionPoint.getMember());
        }
    }
}
