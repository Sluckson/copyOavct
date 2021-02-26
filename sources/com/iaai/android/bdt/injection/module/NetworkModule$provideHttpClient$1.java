package com.iaai.android.bdt.injection.module;

import com.iaai.android.bdt.utils.Utils;
import kotlin.Metadata;
import okhttp3.Interceptor;
import okhttp3.Response;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "Lokhttp3/Response;", "kotlin.jvm.PlatformType", "chain", "Lokhttp3/Interceptor$Chain;", "intercept"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: NetworkModule.kt */
final class NetworkModule$provideHttpClient$1 implements Interceptor {
    public static final NetworkModule$provideHttpClient$1 INSTANCE = new NetworkModule$provideHttpClient$1();

    NetworkModule$provideHttpClient$1() {
    }

    public final Response intercept(Interceptor.Chain chain) {
        return chain.proceed(chain.request().newBuilder().addHeader("User-Agent", Utils.getUserAgent()).build());
    }
}
