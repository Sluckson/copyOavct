package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.TaskCompletionSource;
import p011io.reactivex.functions.Function;

/* compiled from: DisplayCallbacksImpl */
final /* synthetic */ class DisplayCallbacksImpl$$Lambda$12 implements Function {
    private final TaskCompletionSource arg$1;

    private DisplayCallbacksImpl$$Lambda$12(TaskCompletionSource taskCompletionSource) {
        this.arg$1 = taskCompletionSource;
    }

    public static Function lambdaFactory$(TaskCompletionSource taskCompletionSource) {
        return new DisplayCallbacksImpl$$Lambda$12(taskCompletionSource);
    }

    public Object apply(Object obj) {
        return DisplayCallbacksImpl.lambda$maybeToTask$10(this.arg$1, (Throwable) obj);
    }
}
