package com.iaai.android.bdt.feature.applaunch;

import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo66933d2 = {"com/iaai/android/bdt/feature/applaunch/SplashActivity$fetchMakeModelMasterData$timerThread$1", "Ljava/lang/Thread;", "run", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SplashActivity.kt */
public final class SplashActivity$fetchMakeModelMasterData$timerThread$1 extends Thread {
    final /* synthetic */ SplashActivity this$0;

    SplashActivity$fetchMakeModelMasterData$timerThread$1(SplashActivity splashActivity) {
        this.this$0 = splashActivity;
    }

    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            this.this$0.checkTermsOfUseNeedToDisplay();
            throw th;
        }
        this.this$0.checkTermsOfUseNeedToDisplay();
    }
}
