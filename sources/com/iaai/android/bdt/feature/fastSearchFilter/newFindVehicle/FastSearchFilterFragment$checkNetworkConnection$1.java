package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo66933d2 = {"<anonymous>", "", "status", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchFilterFragment.kt */
final class FastSearchFilterFragment$checkNetworkConnection$1<T> implements Observer<Boolean> {
    final /* synthetic */ FastSearchFilterFragment this$0;

    FastSearchFilterFragment$checkNetworkConnection$1(FastSearchFilterFragment fastSearchFilterFragment) {
        this.this$0 = fastSearchFilterFragment;
    }

    public final void onChanged(Boolean bool) {
        if (bool != null && bool.booleanValue()) {
            this.this$0.showEmptyState(false);
            this.this$0.getFastSearchFilterV2();
        }
    }
}
