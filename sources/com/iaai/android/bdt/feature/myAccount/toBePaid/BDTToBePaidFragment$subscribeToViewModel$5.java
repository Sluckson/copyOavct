package com.iaai.android.bdt.feature.myAccount.toBePaid;

import androidx.lifecycle.Observer;
import com.google.gson.Gson;
import com.iaai.android.bdt.utils.NetworkState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/utils/NetworkState;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTToBePaidFragment.kt */
final class BDTToBePaidFragment$subscribeToViewModel$5<T> implements Observer<NetworkState> {
    final /* synthetic */ BDTToBePaidFragment this$0;

    BDTToBePaidFragment$subscribeToViewModel$5(BDTToBePaidFragment bDTToBePaidFragment) {
        this.this$0 = bDTToBePaidFragment;
    }

    public final void onChanged(NetworkState networkState) {
        NetworkState value = this.this$0.getViewModel().getNetworkState().getValue();
        if ((value != null ? value.getStatus() : null) == NetworkState.Status.FAILED) {
            try {
                String json = new Gson().toJson((Object) new TempRequestBody(1, 25, BDTToBePaidFragment.access$getPaymentMode$p(this.this$0), BDTToBePaidFragment.access$getSortItem$p(this.this$0).getSortKey(), BDTToBePaidFragment.access$getSortItem$p(this.this$0).getSortDirection(), BDTToBePaidFragment.access$getOnlyMyItem$p(this.this$0)));
                String json2 = new Gson().toJson((Object) networkState);
                BDTToBePaidFragment bDTToBePaidFragment = this.this$0;
                String currentSessionUserId = this.this$0.getSessionManager().getCurrentSessionUserId();
                Intrinsics.checkExpressionValueIsNotNull(json, "requestString");
                Intrinsics.checkExpressionValueIsNotNull(json2, "responseString");
                bDTToBePaidFragment.logIAAError(currentSessionUserId, "acserviceswebapi/api/GetPaymentDueList/", json, json2, "Network Faliure");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
