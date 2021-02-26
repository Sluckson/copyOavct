package com.google.inject.spi;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.inject.Binder;
import com.google.inject.TypeLiteral;
import com.google.inject.internal.Preconditions;
import com.google.inject.matcher.Matcher;

public final class TypeConverterBinding implements Element {
    private final Object source;
    private final TypeConverter typeConverter;
    private final Matcher<? super TypeLiteral<?>> typeMatcher;

    TypeConverterBinding(Object obj, Matcher<? super TypeLiteral<?>> matcher, TypeConverter typeConverter2) {
        this.source = Preconditions.checkNotNull(obj, FirebaseAnalytics.Param.SOURCE);
        this.typeMatcher = (Matcher) Preconditions.checkNotNull(matcher, "typeMatcher");
        this.typeConverter = (TypeConverter) Preconditions.checkNotNull(typeConverter2, "typeConverter");
    }

    public Object getSource() {
        return this.source;
    }

    public Matcher<? super TypeLiteral<?>> getTypeMatcher() {
        return this.typeMatcher;
    }

    public TypeConverter getTypeConverter() {
        return this.typeConverter;
    }

    public <T> T acceptVisitor(ElementVisitor<T> elementVisitor) {
        return elementVisitor.visit(this);
    }

    public void applyTo(Binder binder) {
        binder.withSource(getSource()).convertToTypes(this.typeMatcher, this.typeConverter);
    }
}
