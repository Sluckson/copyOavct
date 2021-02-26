package com.google.inject;

import com.google.inject.InjectorShell;
import com.google.inject.internal.Errors;
import com.google.inject.internal.Lists;
import com.google.inject.spi.PrivateElements;
import java.util.List;

class PrivateElementProcessor extends AbstractProcessor {
    private final List<InjectorShell.Builder> injectorShellBuilders = Lists.newArrayList();
    private final Stage stage;

    PrivateElementProcessor(Errors errors, Stage stage2) {
        super(errors);
        this.stage = stage2;
    }

    public Boolean visit(PrivateElements privateElements) {
        this.injectorShellBuilders.add(new InjectorShell.Builder().parent(this.injector).stage(this.stage).privateElements(privateElements));
        return true;
    }

    public List<InjectorShell.Builder> getInjectorShellBuilders() {
        return this.injectorShellBuilders;
    }
}
