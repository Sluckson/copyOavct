package com.iaai.android.bdt.feature.auctionMainPage;

import android.view.View;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: AuctionMainListFragment.kt */
final class AuctionMainListFragment$openAuctionCalender$1 implements View.OnClickListener {
    final /* synthetic */ AuctionMainListFragment this$0;

    AuctionMainListFragment$openAuctionCalender$1(AuctionMainListFragment auctionMainListFragment) {
        this.this$0 = auctionMainListFragment;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        r8 = (r8 = r8.getAuctionCalender()).getAuctionCalendarInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r8) {
        /*
            r7 = this;
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r8 = r7.this$0
            com.iaai.android.bdt.model.auctionmainlist.AuctionMainListResponse r8 = r8.getAuctionMainListResponse()
            if (r8 == 0) goto L_0x00a4
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r8 = r7.this$0
            com.iaai.android.bdt.model.auctionmainlist.AuctionMainListResponse r8 = r8.getAuctionMainListResponse()
            r0 = 0
            if (r8 == 0) goto L_0x0022
            com.iaai.android.bdt.model.auctionmainlist.AuctionCalender r8 = r8.getAuctionCalender()
            if (r8 == 0) goto L_0x0022
            java.util.List r8 = r8.getAuctionCalendarInfo()
            if (r8 == 0) goto L_0x0022
            int r8 = r8.size()
            goto L_0x0023
        L_0x0022:
            r8 = 0
        L_0x0023:
            java.lang.String[] r8 = new java.lang.String[r8]
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r1 = r7.this$0
            com.iaai.android.bdt.model.auctionmainlist.AuctionMainListResponse r1 = r1.getAuctionMainListResponse()
            if (r1 != 0) goto L_0x0030
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0030:
            com.iaai.android.bdt.model.auctionmainlist.AuctionCalender r1 = r1.getAuctionCalender()
            java.util.List r1 = r1.getAuctionCalendarInfo()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
        L_0x003f:
            boolean r3 = r1.hasNext()
            r4 = 1
            if (r3 == 0) goto L_0x0060
            java.lang.Object r3 = r1.next()
            com.iaai.android.bdt.model.auctionmainlist.AuctionCalendarInfo r3 = (com.iaai.android.bdt.model.auctionmainlist.AuctionCalendarInfo) r3
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r5 = r7.this$0
            java.lang.String r3 = r3.getAuctionDate()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r6 = "EEEE, MMM. d"
            java.lang.String r3 = r5.getServerFormatDate(r3, r6)
            r8[r2] = r3
            int r2 = r2 + r4
            goto L_0x003f
        L_0x0060:
            int r1 = r8.length
            if (r1 != 0) goto L_0x0064
            goto L_0x0065
        L_0x0064:
            r4 = 0
        L_0x0065:
            if (r4 != 0) goto L_0x008a
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r1 = r7.this$0
            com.iaai.android.bdt.model.auctionmainlist.AuctionMainListResponse r2 = r1.getAuctionMainListResponse()
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x007e
            com.iaai.android.bdt.model.auctionmainlist.AuctionCalender r2 = r2.getAuctionCalender()
            if (r2 == 0) goto L_0x007e
            java.lang.String r2 = r2.getCurrentAuctionLable()
            if (r2 == 0) goto L_0x007e
            goto L_0x007f
        L_0x007e:
            r2 = r3
        L_0x007f:
            r4 = r8[r0]
            if (r4 == 0) goto L_0x0084
            r3 = r4
        L_0x0084:
            java.lang.String r1 = r1.updateAuctionDateLabel(r2, r3)
            r8[r0] = r1
        L_0x008a:
            android.content.Intent r0 = new android.content.Intent
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r1 = r7.this$0
            com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListActivity r1 = com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment.access$getAuctionMainListActivity$p(r1)
            android.content.Context r1 = (android.content.Context) r1
            java.lang.Class<com.iaai.android.bdt.feature.auctionMainPage.AuctionDateListActivity> r2 = com.iaai.android.bdt.feature.auctionMainPage.AuctionDateListActivity.class
            r0.<init>(r1, r2)
            java.lang.String r1 = "auction_date_list"
            r0.putExtra(r1, r8)
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r8 = r7.this$0
            r1 = 3
            r8.startActivityForResult(r0, r1)
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment$openAuctionCalender$1.onClick(android.view.View):void");
    }
}
