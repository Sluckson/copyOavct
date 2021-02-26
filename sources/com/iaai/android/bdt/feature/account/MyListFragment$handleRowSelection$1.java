package com.iaai.android.bdt.feature.account;

import android.content.Intent;
import android.view.View;
import android.widget.Switch;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.utils.Constants_MVVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: MyListFragment.kt */
final class MyListFragment$handleRowSelection$1 implements View.OnClickListener {
    final /* synthetic */ MyListFragment this$0;

    MyListFragment$handleRowSelection$1(MyListFragment myListFragment) {
        this.this$0 = myListFragment;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(Constants_MVVM.BROADCAST_VEHICLE_SWITCH_CHANGED);
        Switch switchR = (Switch) this.this$0._$_findCachedViewById(C2723R.C2726id.show_vehicle_switch);
        Intrinsics.checkExpressionValueIsNotNull(switchR, Constants_MVVM.BROADCAST_VEHICLE_SWITCH_CHANGED);
        intent.putExtra("isShowMyVehicle", switchR.isChecked());
        LocalBroadcastManager.getInstance(MyListFragment.access$getBaseActivity$p(this.this$0)).sendBroadcast(intent);
    }
}
