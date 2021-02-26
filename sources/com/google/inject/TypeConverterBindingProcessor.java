package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.internal.MatcherAndConverter;
import com.google.inject.internal.SourceProvider;
import com.google.inject.internal.Strings;
import com.google.inject.matcher.AbstractMatcher;
import com.google.inject.matcher.Matcher;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.TypeConverter;
import com.google.inject.spi.TypeConverterBinding;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

class TypeConverterBindingProcessor extends AbstractProcessor {
    TypeConverterBindingProcessor(Errors errors) {
        super(errors);
    }

    public void prepareBuiltInConverters(InjectorImpl injectorImpl) {
        this.injector = injectorImpl;
        try {
            convertToPrimitiveType(Integer.TYPE, Integer.class);
            convertToPrimitiveType(Long.TYPE, Long.class);
            convertToPrimitiveType(Boolean.TYPE, Boolean.class);
            convertToPrimitiveType(Byte.TYPE, Byte.class);
            convertToPrimitiveType(Short.TYPE, Short.class);
            convertToPrimitiveType(Float.TYPE, Float.class);
            convertToPrimitiveType(Double.TYPE, Double.class);
            convertToClass(Character.class, new TypeConverter() {
                public String toString() {
                    return "TypeConverter<Character>";
                }

                public Object convert(String str, TypeLiteral<?> typeLiteral) {
                    String trim = str.trim();
                    if (trim.length() == 1) {
                        return Character.valueOf(trim.charAt(0));
                    }
                    throw new RuntimeException("Length != 1.");
                }
            });
            convertToClasses(Matchers.subclassesOf(Enum.class), new TypeConverter() {
                public String toString() {
                    return "TypeConverter<E extends Enum<E>>";
                }

                public Object convert(String str, TypeLiteral<?> typeLiteral) {
                    return Enum.valueOf(typeLiteral.getRawType(), str);
                }
            });
            internalConvertToTypes(new AbstractMatcher<TypeLiteral<?>>() {
                public String toString() {
                    return "Class<?>";
                }

                public boolean matches(TypeLiteral<?> typeLiteral) {
                    return typeLiteral.getRawType() == Class.class;
                }
            }, new TypeConverter() {
                public String toString() {
                    return "TypeConverter<Class<?>>";
                }

                public Object convert(String str, TypeLiteral<?> typeLiteral) {
                    try {
                        return Class.forName(str);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e.getMessage());
                    }
                }
            });
        } finally {
            this.injector = null;
        }
    }

    private <T> void convertToPrimitiveType(Class<T> cls, final Class<T> cls2) {
        try {
            final Method method = cls2.getMethod("parse" + Strings.capitalize(cls.getName()), new Class[]{String.class});
            convertToClass(cls2, new TypeConverter() {
                public Object convert(String str, TypeLiteral<?> typeLiteral) {
                    try {
                        return method.invoke((Object) null, new Object[]{str});
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException(e2.getTargetException().getMessage());
                    }
                }

                public String toString() {
                    return "TypeConverter<" + cls2.getSimpleName() + ">";
                }
            });
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    private <T> void convertToClass(Class<T> cls, TypeConverter typeConverter) {
        convertToClasses(Matchers.identicalTo(cls), typeConverter);
    }

    private void convertToClasses(final Matcher<? super Class<?>> matcher, TypeConverter typeConverter) {
        internalConvertToTypes(new AbstractMatcher<TypeLiteral<?>>() {
            public boolean matches(TypeLiteral<?> typeLiteral) {
                Type type = typeLiteral.getType();
                if (!(type instanceof Class)) {
                    return false;
                }
                return matcher.matches((Class) type);
            }

            public String toString() {
                return matcher.toString();
            }
        }, typeConverter);
    }

    private void internalConvertToTypes(Matcher<? super TypeLiteral<?>> matcher, TypeConverter typeConverter) {
        this.injector.state.addConverter(new MatcherAndConverter(matcher, typeConverter, SourceProvider.UNKNOWN_SOURCE));
    }

    public Boolean visit(TypeConverterBinding typeConverterBinding) {
        this.injector.state.addConverter(new MatcherAndConverter(typeConverterBinding.getTypeMatcher(), typeConverterBinding.getTypeConverter(), typeConverterBinding.getSource()));
        return true;
    }
}
