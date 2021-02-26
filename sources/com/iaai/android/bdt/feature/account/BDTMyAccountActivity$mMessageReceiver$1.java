package com.iaai.android.bdt.feature.account;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.iaai.android.bdt.utils.Constants_MVVM;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo66933d2 = {"com/iaai/android/bdt/feature/account/BDTMyAccountActivity$mMessageReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "contxt", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTMyAccountActivity.kt */
public final class BDTMyAccountActivity$mMessageReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ BDTMyAccountActivity this$0;

    BDTMyAccountActivity$mMessageReceiver$1(BDTMyAccountActivity bDTMyAccountActivity) {
        this.this$0 = bDTMyAccountActivity;
    }

    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (action != null && action.hashCode() == 1092392233 && action.equals(Constants_MVVM.BROADCAST_VEHICLE_SWITCH_CHANGED)) {
            this.this$0.handleSwitchCheckChanged(intent);
        }
    }
}
