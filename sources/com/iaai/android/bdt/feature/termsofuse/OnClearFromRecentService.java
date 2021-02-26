package com.iaai.android.bdt.feature.termsofuse;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0015"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/termsofuse/OnClearFromRecentService;", "Landroid/app/Service;", "()V", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onDestroy", "", "onStartCommand", "", "flags", "startId", "onTaskRemoved", "rootIntent", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: OnClearFromRecentService.kt */
public final class OnClearFromRecentService extends Service {
    @NotNull
    public SessionManager sessionManager;

    @Nullable
    public IBinder onBind(@NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        return null;
    }

    @NotNull
    public final SessionManager getSessionManager() {
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        return sessionManager2;
    }

    public final void setSessionManager(@NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(sessionManager2, "<set-?>");
        this.sessionManager = sessionManager2;
    }

    public int onStartCommand(@NotNull Intent intent, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        Log.d("ClearFromRecentService", "Service Started");
        IaaiApplication instance = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
        this.sessionManager = instance.getComponent().sessionManager();
        return 2;
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d("ClearFromRecentService", "Service Destroyed");
    }

    public void onTaskRemoved(@NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "rootIntent");
        Log.e("ClearFromRecentService", "END");
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        sessionManager2.logout(this);
        SessionManager sessionManager3 = this.sessionManager;
        if (sessionManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        sessionManager3.clearLoginResponseObject();
        Log.e("LogOut", "Complete");
        stopSelf();
    }
}
