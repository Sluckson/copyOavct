package com.iaai.android.bdt.injection.module;

import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@Singleton
@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo66933d2 = {"Lcom/iaai/android/bdt/injection/module/CustomInterceptor;", "Lokhttp3/Interceptor;", "()V", "mHost", "", "mScheme", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "setInterceptor", "", "url", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: CustomInterceptor.kt */
public final class CustomInterceptor implements Interceptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static CustomInterceptor sInterceptor;
    private String mHost;
    private String mScheme;

    private CustomInterceptor() {
    }

    public /* synthetic */ CustomInterceptor(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void setInterceptor(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        HttpUrl parse = HttpUrl.parse(str);
        if (parse == null) {
            Intrinsics.throwNpe();
        }
        this.mScheme = parse.scheme();
        this.mHost = parse.host();
    }

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        Intrinsics.checkParameterIsNotNull(chain, "chain");
        Request request = chain.request();
        if (!(this.mScheme == null || this.mHost == null)) {
            request = request.newBuilder().url(request.url().newBuilder().scheme(this.mScheme).host(this.mHost).build()).build();
        }
        Response proceed = chain.proceed(request);
        Intrinsics.checkExpressionValueIsNotNull(proceed, "chain.proceed(original)");
        return proceed;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo66933d2 = {"Lcom/iaai/android/bdt/injection/module/CustomInterceptor$Companion;", "", "()V", "sInterceptor", "Lcom/iaai/android/bdt/injection/module/CustomInterceptor;", "get", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: CustomInterceptor.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Inject
        @NotNull
        public final CustomInterceptor get() {
            if (CustomInterceptor.sInterceptor == null) {
                CustomInterceptor.sInterceptor = new CustomInterceptor((DefaultConstructorMarker) null);
            }
            CustomInterceptor access$getSInterceptor$cp = CustomInterceptor.sInterceptor;
            if (access$getSInterceptor$cp != null) {
                return access$getSInterceptor$cp;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.injection.module.CustomInterceptor");
        }
    }
}
