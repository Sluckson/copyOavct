package com.google.inject.internal;

import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matcher;
import com.google.inject.spi.TypeConverter;

public final class MatcherAndConverter {
    private final Object source;
    private final TypeConverter typeConverter;
    private final Matcher<? super TypeLiteral<?>> typeMatcher;

    public MatcherAndConverter(Matcher<? super TypeLiteral<?>> matcher, TypeConverter typeConverter2, Object obj) {
        this.typeMatcher = (Matcher) Preconditions.checkNotNull(matcher, "type matcher");
        this.typeConverter = (TypeConverter) Preconditions.checkNotNull(typeConverter2, "converter");
        this.source = obj;
    }

    public TypeConverter getTypeConverter() {
        return this.typeConverter;
    }

    public Matcher<? super TypeLiteral<?>> getTypeMatcher() {
        return this.typeMatcher;
    }

    public Object getSource() {
        return this.source;
    }

    public String toString() {
        return this.typeConverter + " which matches " + this.typeMatcher + " (bound at " + this.source + ")";
    }
}
