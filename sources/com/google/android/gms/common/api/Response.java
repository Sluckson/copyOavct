package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public class Response<T extends Result> {
    private T zzba;

    public Response() {
    }

    protected Response(@NonNull T t) {
        this.zzba = t;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public T getResult() {
        return this.zzba;
    }

    public void setResult(@NonNull T t) {
        this.zzba = t;
    }
}
