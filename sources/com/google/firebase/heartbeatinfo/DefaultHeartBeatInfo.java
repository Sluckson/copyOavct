package com.google.firebase.heartbeatinfo;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;

public class DefaultHeartBeatInfo implements HeartBeatInfo {
    private HeartBeatInfoStorage storage;

    private DefaultHeartBeatInfo(Context context) {
        this.storage = HeartBeatInfoStorage.getInstance(context);
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.TESTS})
    DefaultHeartBeatInfo(HeartBeatInfoStorage heartBeatInfoStorage) {
        this.storage = heartBeatInfoStorage;
    }

    @NonNull
    public HeartBeatInfo.HeartBeat getHeartBeatCode(@NonNull String str) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean shouldSendSdkHeartBeat = this.storage.shouldSendSdkHeartBeat(str, currentTimeMillis);
        boolean shouldSendGlobalHeartBeat = this.storage.shouldSendGlobalHeartBeat(currentTimeMillis);
        if (shouldSendSdkHeartBeat && shouldSendGlobalHeartBeat) {
            return HeartBeatInfo.HeartBeat.COMBINED;
        }
        if (shouldSendGlobalHeartBeat) {
            return HeartBeatInfo.HeartBeat.GLOBAL;
        }
        if (shouldSendSdkHeartBeat) {
            return HeartBeatInfo.HeartBeat.SDK;
        }
        return HeartBeatInfo.HeartBeat.NONE;
    }

    @NonNull
    public static Component<HeartBeatInfo> component() {
        return Component.builder(HeartBeatInfo.class).add(Dependency.required(Context.class)).factory(DefaultHeartBeatInfo$$Lambda$1.lambdaFactory$()).build();
    }

    static /* synthetic */ HeartBeatInfo lambda$component$0(ComponentContainer componentContainer) {
        return new DefaultHeartBeatInfo((Context) componentContainer.get(Context.class));
    }
}
