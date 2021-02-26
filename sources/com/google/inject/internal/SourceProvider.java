package com.google.inject.internal;

import java.util.ArrayList;
import java.util.List;

public class SourceProvider {
    public static final SourceProvider DEFAULT_INSTANCE = new SourceProvider(ImmutableSet.m349of(SourceProvider.class.getName()));
    public static final Object UNKNOWN_SOURCE = "[unknown source]";
    private final ImmutableSet<String> classNamesToSkip;

    public SourceProvider() {
        this.classNamesToSkip = ImmutableSet.m349of(SourceProvider.class.getName());
    }

    private SourceProvider(Iterable<String> iterable) {
        this.classNamesToSkip = ImmutableSet.copyOf(iterable);
    }

    public SourceProvider plusSkippedClasses(Class... clsArr) {
        return new SourceProvider(Iterables.concat(this.classNamesToSkip, asStrings(clsArr)));
    }

    private static List<String> asStrings(Class... clsArr) {
        ArrayList newArrayList = Lists.newArrayList();
        for (Class name : clsArr) {
            newArrayList.add(name.getName());
        }
        return newArrayList;
    }

    public StackTraceElement get() {
        for (StackTraceElement stackTraceElement : new Throwable().getStackTrace()) {
            if (!this.classNamesToSkip.contains(stackTraceElement.getClassName())) {
                return stackTraceElement;
            }
        }
        throw new AssertionError();
    }
}
