package com.iaai.android.bdt.feature.auctionMainPage;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.auctionmainlist.AuctionMainListResponse;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/auctionmainlist/AuctionMainListResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: AuctionMainListFragment.kt */
final class AuctionMainListFragment$subscribeToViewModel$1<T> implements Observer<AuctionMainListResponse> {
    final /* synthetic */ AuctionMainListFragment this$0;

    AuctionMainListFragment$subscribeToViewModel$1(AuctionMainListFragment auctionMainListFragment) {
        this.this$0 = auctionMainListFragment;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(com.iaai.android.bdt.model.auctionmainlist.AuctionMainListResponse r10) {
        /*
            r9 = this;
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r0 = r9.this$0
            r1 = 0
            r0.showLoadingIndicator(r1)
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r0 = r9.this$0
            r2 = 0
            if (r10 == 0) goto L_0x0010
            java.util.List r3 = r10.getAuctionLocations()
            goto L_0x0011
        L_0x0010:
            r3 = r2
        L_0x0011:
            java.util.Collection r3 = (java.util.Collection) r3
            r4 = 1
            if (r3 == 0) goto L_0x001f
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r3 = 0
            goto L_0x0020
        L_0x001f:
            r3 = 1
        L_0x0020:
            r0.showEmptyState(r3)
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r0 = r9.this$0
            int r3 = com.iaai.android.C2723R.C2726id.faAuctionMainUpScroll
            android.view.View r0 = r0._$_findCachedViewById(r3)
            com.google.android.material.floatingactionbutton.FloatingActionButton r0 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r0
            java.lang.String r3 = "faAuctionMainUpScroll"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            r3 = 8
            r0.setVisibility(r3)
            com.iaai.android.bdt.model.auctionmainlist.AuctionCalender r0 = r10.getAuctionCalender()
            java.util.List r0 = r0.getAuctionCalendarInfo()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L_0x0050
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0050
        L_0x004e:
            r0 = 0
            goto L_0x0071
        L_0x0050:
            java.util.Iterator r0 = r0.iterator()
        L_0x0054:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x004e
            java.lang.Object r3 = r0.next()
            com.iaai.android.bdt.model.auctionmainlist.AuctionCalendarInfo r3 = (com.iaai.android.bdt.model.auctionmainlist.AuctionCalendarInfo) r3
            java.lang.String r3 = r3.getAuctionDate()
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r5 = r9.this$0
            java.lang.String r5 = r5.currentSelectedAuctionDate
            boolean r3 = kotlin.text.StringsKt.equals(r3, r5, r4)
            if (r3 == 0) goto L_0x0054
            r0 = 1
        L_0x0071:
            r0 = r0 ^ r4
            if (r0 != 0) goto L_0x008c
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r0 = r9.this$0
            boolean r0 = r0.isCalederDateSelect
            if (r0 != 0) goto L_0x008c
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r0 = r9.this$0
            boolean r0 = r0.isFromSearchKeyword
            if (r0 == 0) goto L_0x0085
            goto L_0x008c
        L_0x0085:
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r10 = r9.this$0
            r10.updateAuctionSegments()
            goto L_0x0152
        L_0x008c:
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r0 = r9.this$0
            r0.setAuctionMainListResponse(r10)
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r0 = r9.this$0
            boolean r0 = r0.isCalederDateSelect
            java.lang.String r3 = "EEE, MMM d"
            java.lang.String r5 = "tvAuctionDate"
            java.lang.String r6 = ""
            if (r0 != 0) goto L_0x00d0
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r0 = r9.this$0
            if (r10 == 0) goto L_0x00b0
            com.iaai.android.bdt.model.auctionmainlist.AuctionCalender r7 = r10.getAuctionCalender()
            if (r7 == 0) goto L_0x00b0
            java.lang.String r7 = r7.getCurrentAuction()
            if (r7 == 0) goto L_0x00b0
            goto L_0x00b1
        L_0x00b0:
            r7 = r6
        L_0x00b1:
            r0.currentSelectedAuctionDate = r7
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r0 = r9.this$0
            int r7 = com.iaai.android.C2723R.C2726id.tvAuctionDate
            android.view.View r0 = r0._$_findCachedViewById(r7)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r7 = r9.this$0
            java.lang.String r8 = r7.currentSelectedAuctionDate
            java.lang.String r7 = r7.getServerFormatDate(r8, r3)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r0.setText(r7)
        L_0x00d0:
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r0 = r9.this$0
            java.lang.String r0 = r0.searchDate
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r6)
            r0 = r0 ^ r4
            if (r0 == 0) goto L_0x0101
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r0 = r9.this$0
            int r4 = com.iaai.android.C2723R.C2726id.tvAuctionDate
            android.view.View r0 = r0._$_findCachedViewById(r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
            com.iaai.android.bdt.utils.NewDateHelper r4 = com.iaai.android.bdt.utils.NewDateHelper.INSTANCE
            com.iaai.android.bdt.utils.NewDateHelper r5 = com.iaai.android.bdt.utils.NewDateHelper.INSTANCE
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r6 = r9.this$0
            java.lang.String r6 = r6.searchDate
            java.util.Date r5 = r5.getFormattedSearchDate(r6)
            java.lang.String r3 = r4.format((java.util.Date) r5, (java.lang.String) r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
        L_0x0101:
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r0 = r9.this$0
            r0.isCalederDateSelect = r1
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r0 = r9.this$0
            r0.isFromSearchKeyword = r1
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r0 = r9.this$0
            if (r10 == 0) goto L_0x0113
            java.util.List r2 = r10.getAuctionLocations()
        L_0x0113:
            r0.auctionLocations = r2
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r10 = r9.this$0
            java.util.List unused = r10.getAuctionDataList()
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r10 = r9.this$0
            com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter r10 = com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment.access$getAuctionMainListAdapter$p(r10)
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r0 = r9.this$0
            java.util.List r0 = r0.auctionList
            r10.setData(r0)
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r10 = r9.this$0
            int r0 = com.iaai.android.C2723R.C2726id.rvAuctionList
            android.view.View r10 = r10._$_findCachedViewById(r0)
            androidx.recyclerview.widget.RecyclerView r10 = (androidx.recyclerview.widget.RecyclerView) r10
            java.lang.String r0 = "rvAuctionList"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r0)
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r0 = r9.this$0
            com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter r0 = com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment.access$getAuctionMainListAdapter$p(r0)
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = (androidx.recyclerview.widget.RecyclerView.Adapter) r0
            r10.setAdapter(r0)
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r10 = r9.this$0
            androidx.databinding.ViewDataBinding r10 = com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment.access$getMBinding$p(r10)
            r10.executePendingBindings()
            com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment r10 = r9.this$0
            r10.updateAuctionSegments()
        L_0x0152:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment$subscribeToViewModel$1.onChanged(com.iaai.android.bdt.model.auctionmainlist.AuctionMainListResponse):void");
    }
}
