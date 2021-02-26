package com.iaai.android.bdt.feature.auctionMainPage;

import android.widget.CompoundButton;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo66933d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onCheckedChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: AuctionMainListFragment.kt */
final class AuctionMainListFragment$onActivityCreated$1 implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ AuctionMainListFragment this$0;

    AuctionMainListFragment$onActivityCreated$1(AuctionMainListFragment auctionMainListFragment) {
        this.this$0 = auctionMainListFragment;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        List unused = this.this$0.getAuctionDataList();
        Collection access$getAuctionList$p = this.this$0.auctionList;
        boolean z2 = false;
        if (access$getAuctionList$p == null || access$getAuctionList$p.isEmpty()) {
            String access$getNetPublicAuctionDate = this.this$0.getNetPublicAuctionDate();
            if (access$getNetPublicAuctionDate.length() > 0) {
                z2 = true;
            }
            if (z2) {
                this.this$0.fetchAuctionMainList("", access$getNetPublicAuctionDate, "", "");
            } else {
                this.this$0.updateAuctionSegments();
            }
        } else {
            this.this$0.updateAuctionSegments();
        }
    }
}
