package com.iaai.android.bdt.feature.auctionSalesList;

import android.util.Log;
import com.iaai.android.bdt.model.sort.SortOptionData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo66933d2 = {"<anonymous>", "", "invoke"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SortListActivity.kt */
final class SortListActivity$handlePermissionCallbacksForLocation$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $position;
    final /* synthetic */ SortOptionData $sortItem;
    final /* synthetic */ SortListActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SortListActivity$handlePermissionCallbacksForLocation$3(SortListActivity sortListActivity, SortOptionData sortOptionData, int i) {
        super(0);
        this.this$0 = sortListActivity;
        this.$sortItem = sortOptionData;
        this.$position = i;
    }

    public final void invoke() {
        Log.e("TEST", "All permission granted");
        if (SortListActivity.access$getPermissionHelper$p(this.this$0).hasPermission()) {
            this.this$0.navigateToSearchResult(this.$sortItem, this.$position);
        }
    }
}
