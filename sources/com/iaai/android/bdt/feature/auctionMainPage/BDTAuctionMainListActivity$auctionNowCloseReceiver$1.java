package com.iaai.android.bdt.feature.auctionMainPage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.utils.Constants_MVVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo66933d2 = {"com/iaai/android/bdt/feature/auctionMainPage/BDTAuctionMainListActivity$auctionNowCloseReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "contxt", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTAuctionMainListActivity.kt */
public final class BDTAuctionMainListActivity$auctionNowCloseReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ BDTAuctionMainListActivity this$0;

    BDTAuctionMainListActivity$auctionNowCloseReceiver$1(BDTAuctionMainListActivity bDTAuctionMainListActivity) {
        this.this$0 = bDTAuctionMainListActivity;
    }

    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        if (Intrinsics.areEqual((Object) Constants_MVVM.ACTION_AUCTION_NOW_EXIT, (Object) intent != null ? intent.getAction() : null)) {
            IAAAnalytics.INSTANCE.logIAAEvent(IAAAnalytics.IAAEvents.CLOSE_AUCTION_NOW, (Bundle) null, this.this$0.getSessionManager());
        }
    }
}
