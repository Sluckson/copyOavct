package com.google.inject.internal;

import com.google.inject.Scope;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.google.inject.Stage;
import com.google.inject.binder.ScopedBindingBuilder;
import com.google.inject.spi.BindingScopingVisitor;
import java.lang.annotation.Annotation;

public abstract class Scoping {
    public static final Scoping EAGER_SINGLETON = new Scoping() {
        public String toString() {
            return "eager singleton";
        }

        public <V> V acceptVisitor(BindingScopingVisitor<V> bindingScopingVisitor) {
            return bindingScopingVisitor.visitEagerSingleton();
        }

        public Scope getScopeInstance() {
            return Scopes.SINGLETON;
        }

        public void applyTo(ScopedBindingBuilder scopedBindingBuilder) {
            scopedBindingBuilder.asEagerSingleton();
        }
    };
    public static final Scoping SINGLETON_ANNOTATION = new Scoping() {
        public <V> V acceptVisitor(BindingScopingVisitor<V> bindingScopingVisitor) {
            return bindingScopingVisitor.visitScopeAnnotation(Singleton.class);
        }

        public Class<? extends Annotation> getScopeAnnotation() {
            return Singleton.class;
        }

        public String toString() {
            return Singleton.class.getName();
        }

        public void applyTo(ScopedBindingBuilder scopedBindingBuilder) {
            scopedBindingBuilder.mo36522in((Class<? extends Annotation>) Singleton.class);
        }
    };
    public static final Scoping SINGLETON_INSTANCE = new Scoping() {
        public <V> V acceptVisitor(BindingScopingVisitor<V> bindingScopingVisitor) {
            return bindingScopingVisitor.visitScope(Scopes.SINGLETON);
        }

        public Scope getScopeInstance() {
            return Scopes.SINGLETON;
        }

        public String toString() {
            return Scopes.SINGLETON.toString();
        }

        public void applyTo(ScopedBindingBuilder scopedBindingBuilder) {
            scopedBindingBuilder.mo36521in(Scopes.SINGLETON);
        }
    };
    public static final Scoping UNSCOPED = new Scoping() {
        public void applyTo(ScopedBindingBuilder scopedBindingBuilder) {
        }

        public <V> V acceptVisitor(BindingScopingVisitor<V> bindingScopingVisitor) {
            return bindingScopingVisitor.visitNoScoping();
        }

        public Scope getScopeInstance() {
            return Scopes.NO_SCOPE;
        }

        public String toString() {
            return Scopes.NO_SCOPE.toString();
        }
    };

    public abstract <V> V acceptVisitor(BindingScopingVisitor<V> bindingScopingVisitor);

    public abstract void applyTo(ScopedBindingBuilder scopedBindingBuilder);

    public Class<? extends Annotation> getScopeAnnotation() {
        return null;
    }

    public Scope getScopeInstance() {
        return null;
    }

    public static Scoping forAnnotation(final Class<? extends Annotation> cls) {
        if (cls == Singleton.class) {
            return SINGLETON_ANNOTATION;
        }
        return new Scoping() {
            public <V> V acceptVisitor(BindingScopingVisitor<V> bindingScopingVisitor) {
                return bindingScopingVisitor.visitScopeAnnotation(cls);
            }

            public Class<? extends Annotation> getScopeAnnotation() {
                return cls;
            }

            public String toString() {
                return cls.getName();
            }

            public void applyTo(ScopedBindingBuilder scopedBindingBuilder) {
                scopedBindingBuilder.mo36522in((Class<? extends Annotation>) cls);
            }
        };
    }

    public static Scoping forInstance(final Scope scope) {
        if (scope == Scopes.SINGLETON) {
            return SINGLETON_INSTANCE;
        }
        return new Scoping() {
            public <V> V acceptVisitor(BindingScopingVisitor<V> bindingScopingVisitor) {
                return bindingScopingVisitor.visitScope(scope);
            }

            public Scope getScopeInstance() {
                return scope;
            }

            public String toString() {
                return scope.toString();
            }

            public void applyTo(ScopedBindingBuilder scopedBindingBuilder) {
                scopedBindingBuilder.mo36521in(scope);
            }
        };
    }

    public boolean isExplicitlyScoped() {
        return this != UNSCOPED;
    }

    public boolean isNoScope() {
        return getScopeInstance() == Scopes.NO_SCOPE;
    }

    public boolean isEagerSingleton(Stage stage) {
        if (this == EAGER_SINGLETON) {
            return true;
        }
        if (stage != Stage.PRODUCTION) {
            return false;
        }
        if (this == SINGLETON_ANNOTATION || this == SINGLETON_INSTANCE) {
            return true;
        }
        return false;
    }

    private Scoping() {
    }
}
