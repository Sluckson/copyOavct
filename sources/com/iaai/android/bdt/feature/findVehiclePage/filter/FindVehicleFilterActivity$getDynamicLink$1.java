package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.iaai.android.bdt.feature.productDetail.ProductDetailActivity;
import com.iaai.android.old.utils.constants.Constants;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "pendingDynamicLinkData", "Lcom/google/firebase/dynamiclinks/PendingDynamicLinkData;", "kotlin.jvm.PlatformType", "onSuccess"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FindVehicleFilterActivity.kt */
final class FindVehicleFilterActivity$getDynamicLink$1<TResult> implements OnSuccessListener<PendingDynamicLinkData> {
    final /* synthetic */ FindVehicleFilterActivity this$0;

    FindVehicleFilterActivity$getDynamicLink$1(FindVehicleFilterActivity findVehicleFilterActivity) {
        this.this$0 = findVehicleFilterActivity;
    }

    public final void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
        Uri link = pendingDynamicLinkData != null ? pendingDynamicLinkData.getLink() : null;
        if (link != null) {
            String tag = this.this$0.getTAG();
            Log.e(tag, "ITEM ID " + link.getQueryParameter("itemid"));
            String queryParameter = link.getQueryParameter("itemid");
            Intent intent = new Intent(this.this$0, ProductDetailActivity.class);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra(Constants.EXTRA_ITEM_ID, queryParameter);
            intent.putExtra("isFromSearchVehicle", false);
            intent.putExtra(Constants.EXTRA_YEAR_MAKE_MODEL, "");
            this.this$0.startActivity(intent);
            return;
        }
        Log.e(this.this$0.getTAG(), "getDynamicLink: no link found");
    }
}
