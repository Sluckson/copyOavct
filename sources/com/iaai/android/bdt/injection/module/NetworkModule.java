package com.iaai.android.bdt.injection.module;

import com.google.gson.GsonBuilder;
import com.iaai.android.bdt.network.Service;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import p011io.reactivex.annotations.NonNull;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\u0012\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u0004H\u0007J\u0012\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\tH\u0007¨\u0006\u000e"}, mo66933d2 = {"Lcom/iaai/android/bdt/injection/module/NetworkModule;", "", "()V", "provideHttpClient", "Lokhttp3/OkHttpClient;", "customInterceptor", "Lcom/iaai/android/bdt/injection/module/CustomInterceptor;", "provideInterceptor", "provideRetrofit", "Lretrofit2/Retrofit;", "okHttpClient", "provideService", "Lcom/iaai/android/bdt/network/Service;", "retrofit", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Module
/* compiled from: NetworkModule.kt */
public final class NetworkModule {
    @Singleton
    @NotNull
    @Provides
    public final CustomInterceptor provideInterceptor() {
        return CustomInterceptor.Companion.get();
    }

    @Singleton
    @NotNull
    @Provides
    public final OkHttpClient provideHttpClient(@NotNull CustomInterceptor customInterceptor) {
        Intrinsics.checkParameterIsNotNull(customInterceptor, "customInterceptor");
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient build = new OkHttpClient.Builder().addInterceptor(customInterceptor).readTimeout(30, TimeUnit.SECONDS).connectTimeout(30, TimeUnit.SECONDS).addInterceptor(NetworkModule$provideHttpClient$1.INSTANCE).addInterceptor(httpLoggingInterceptor).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "OkHttpClient.Builder()\n …\n                .build()");
        return build;
    }

    @Singleton
    @NotNull
    @Provides
    public final Retrofit provideRetrofit(@NotNull @NonNull OkHttpClient okHttpClient) {
        Intrinsics.checkParameterIsNotNull(okHttpClient, "okHttpClient");
        Retrofit build = new Retrofit.Builder().client(okHttpClient).baseUrl("https://qamapp.iaai.com/").addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create())).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "Retrofit.Builder()\n     …e())\n            .build()");
        return build;
    }

    @Singleton
    @NotNull
    @Provides
    public final Service provideService(@NotNull @NonNull Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        Object create = retrofit.create(Service.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(Service::class.java)");
        return (Service) create;
    }
}
