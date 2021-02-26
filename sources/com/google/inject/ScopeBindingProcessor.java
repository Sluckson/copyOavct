package com.google.inject;

import com.google.inject.internal.Annotations;
import com.google.inject.internal.Errors;
import com.google.inject.internal.Preconditions;
import com.google.inject.spi.ScopeBinding;
import java.lang.annotation.Annotation;

class ScopeBindingProcessor extends AbstractProcessor {
    ScopeBindingProcessor(Errors errors) {
        super(errors);
    }

    public Boolean visit(ScopeBinding scopeBinding) {
        Scope scope = scopeBinding.getScope();
        Class<? extends Annotation> annotationType = scopeBinding.getAnnotationType();
        if (!Annotations.isScopeAnnotation(annotationType)) {
            this.errors.withSource(annotationType).missingScopeAnnotation();
        }
        if (!Annotations.isRetainedAtRuntime(annotationType)) {
            this.errors.withSource(annotationType).missingRuntimeRetention(scopeBinding.getSource());
        }
        Scope scope2 = this.injector.state.getScope((Class) Preconditions.checkNotNull(annotationType, "annotation type"));
        if (scope2 != null) {
            this.errors.duplicateScopes(scope2, annotationType, scope);
        } else {
            this.injector.state.putAnnotation(annotationType, (Scope) Preconditions.checkNotNull(scope, "scope"));
        }
        return true;
    }
}
