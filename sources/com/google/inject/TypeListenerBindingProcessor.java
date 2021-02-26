package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.spi.TypeListenerBinding;

class TypeListenerBindingProcessor extends AbstractProcessor {
    TypeListenerBindingProcessor(Errors errors) {
        super(errors);
    }

    public Boolean visit(TypeListenerBinding typeListenerBinding) {
        this.injector.state.addTypeListener(typeListenerBinding);
        return true;
    }
}
