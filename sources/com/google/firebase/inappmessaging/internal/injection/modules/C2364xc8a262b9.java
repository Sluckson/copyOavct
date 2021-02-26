package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* renamed from: com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggersFactory */
public final class C2364xc8a262b9 implements Factory<ProgramaticContextualTriggers> {
    private final ProgrammaticContextualTriggerFlowableModule module;

    public C2364xc8a262b9(ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        this.module = programmaticContextualTriggerFlowableModule;
    }

    public ProgramaticContextualTriggers get() {
        return providesProgramaticContextualTriggers(this.module);
    }

    public static C2364xc8a262b9 create(ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        return new C2364xc8a262b9(programmaticContextualTriggerFlowableModule);
    }

    public static ProgramaticContextualTriggers providesProgramaticContextualTriggers(ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        return (ProgramaticContextualTriggers) Preconditions.checkNotNull(programmaticContextualTriggerFlowableModule.providesProgramaticContextualTriggers(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
