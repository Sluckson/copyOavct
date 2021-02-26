package com.iaai.android.bdt.utils;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0002J\b\u0010\u000b\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\tH\u0014J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo66933d2 = {"Lcom/iaai/android/bdt/utils/InternetUtil;", "Landroidx/lifecycle/LiveData;", "", "()V", "application", "Landroid/app/Application;", "broadcastReceiver", "Landroid/content/BroadcastReceiver;", "init", "", "isInternetOn", "onActive", "onInactive", "registerBroadCastReceiver", "unRegisterBroadCastReceiver", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: InternetUtil.kt */
public final class InternetUtil extends LiveData<Boolean> {
    public static final InternetUtil INSTANCE = new InternetUtil();
    private static Application application;
    private static BroadcastReceiver broadcastReceiver;

    private InternetUtil() {
    }

    public final void init(@NotNull Application application2) {
        Intrinsics.checkParameterIsNotNull(application2, "application");
        application = application2;
    }

    public final boolean isInternetOn() {
        Application application2 = application;
        if (application2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("application");
        }
        Object systemService = application2.getSystemService("connectivity");
        if (systemService != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    /* access modifiers changed from: protected */
    public void onActive() {
        registerBroadCastReceiver();
    }

    /* access modifiers changed from: protected */
    public void onInactive() {
        unRegisterBroadCastReceiver();
    }

    private final void registerBroadCastReceiver() {
        if (broadcastReceiver == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            broadcastReceiver = new InternetUtil$registerBroadCastReceiver$1();
            Application application2 = application;
            if (application2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("application");
            }
            application2.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    private final void unRegisterBroadCastReceiver() {
        if (broadcastReceiver != null) {
            Application application2 = application;
            if (application2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("application");
            }
            application2.unregisterReceiver(broadcastReceiver);
            broadcastReceiver = null;
            setValue(false);
        }
    }
}
