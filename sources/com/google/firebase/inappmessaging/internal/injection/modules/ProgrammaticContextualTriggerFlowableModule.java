package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.ProgrammaticTrigger;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import p011io.reactivex.BackpressureStrategy;
import p011io.reactivex.Flowable;
import p011io.reactivex.flowables.ConnectableFlowable;

@Module
public class ProgrammaticContextualTriggerFlowableModule {
    private ProgramaticContextualTriggers triggers;

    public ProgrammaticContextualTriggerFlowableModule(ProgramaticContextualTriggers programaticContextualTriggers) {
        this.triggers = programaticContextualTriggers;
    }

    @Singleton
    @ProgrammaticTrigger
    @Provides
    public ProgramaticContextualTriggers providesProgramaticContextualTriggers() {
        return this.triggers;
    }

    @Singleton
    @ProgrammaticTrigger
    @Provides
    public ConnectableFlowable<String> providesProgramaticContextualTriggerStream() {
        ConnectableFlowable<String> publish = Flowable.create(ProgrammaticContextualTriggerFlowableModule$$Lambda$1.lambdaFactory$(this), BackpressureStrategy.BUFFER).publish();
        publish.connect();
        return publish;
    }
}
