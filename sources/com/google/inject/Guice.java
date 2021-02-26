package com.google.inject;

import java.util.Arrays;

public final class Guice {
    private Guice() {
    }

    public static Injector createInjector(Module... moduleArr) {
        return createInjector((Iterable<? extends Module>) Arrays.asList(moduleArr));
    }

    public static Injector createInjector(Iterable<? extends Module> iterable) {
        return createInjector(Stage.DEVELOPMENT, iterable);
    }

    public static Injector createInjector(Stage stage, Module... moduleArr) {
        return createInjector(stage, (Iterable<? extends Module>) Arrays.asList(moduleArr));
    }

    public static Injector createInjector(Stage stage, Iterable<? extends Module> iterable) {
        return new InjectorBuilder().stage(stage).addModules(iterable).build();
    }
}
