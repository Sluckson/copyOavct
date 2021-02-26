package com.google.firebase.inappmessaging.internal.injection.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import p011io.reactivex.flowables.ConnectableFlowable;

/* renamed from: com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggerStreamFactory */
public final class C2363x14d57ce8 implements Factory<ConnectableFlowable<String>> {
    private final ProgrammaticContextualTriggerFlowableModule module;

    public C2363x14d57ce8(ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        this.module = programmaticContextualTriggerFlowableModule;
    }

    public ConnectableFlowable<String> get() {
        return providesProgramaticContextualTriggerStream(this.module);
    }

    public static C2363x14d57ce8 create(ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        return new C2363x14d57ce8(programmaticContextualTriggerFlowableModule);
    }

    public static ConnectableFlowable<String> providesProgramaticContextualTriggerStream(ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        return (ConnectableFlowable) Preconditions.checkNotNull(programmaticContextualTriggerFlowableModule.providesProgramaticContextualTriggerStream(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
