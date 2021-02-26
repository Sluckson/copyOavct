package com.iaai.android.bdt.feature.auctionSalesList;

import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import com.iaai.android.bdt.model.auctionSalesList.ResultData;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo66933d2 = {"<anonymous>", "", "pagedList", "Landroidx/paging/PagedList;", "Lcom/iaai/android/bdt/model/auctionSalesList/ResultData;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: AuctionSalesListFragment.kt */
final class AuctionSalesListFragment$subscribeToViewModel$3<T> implements Observer<PagedList<ResultData>> {
    final /* synthetic */ AuctionSalesListFragment this$0;

    AuctionSalesListFragment$subscribeToViewModel$3(AuctionSalesListFragment auctionSalesListFragment) {
        this.this$0 = auctionSalesListFragment;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0093, code lost:
        r10 = r8.isWatching();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(androidx.paging.PagedList<com.iaai.android.bdt.model.auctionSalesList.ResultData> r14) {
        /*
            r13 = this;
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r0 = r13.this$0
            r1 = 0
            r0.showLoadingIndicator(r1)
            java.lang.String r0 = "null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment"
            r2 = 2131296297(0x7f090029, float:1.8210507E38)
            r3 = 2131296449(0x7f0900c1, float:1.8210815E38)
            java.lang.String r4 = ""
            java.lang.String r5 = "itemId"
            r6 = 1
            if (r14 == 0) goto L_0x0071
            int r7 = r14.size()
            if (r7 != 0) goto L_0x0071
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r7 = r13.this$0
            com.iaai.android.bdt.base.BaseFragment$ErrorType r8 = com.iaai.android.bdt.base.BaseFragment.ErrorType.NO_STOCKS
            r7.errorType = r8
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r7 = r13.this$0
            r7.isError = r6
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r7 = r13.this$0
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListAdapter r7 = com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment.access$getAuctionSalesListAdapter$p(r7)
            r7.submitList(r14)
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r7 = r13.this$0
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListAdapter r7 = com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment.access$getAuctionSalesListAdapter$p(r7)
            r7.notifyDataSetChanged()
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r7 = r13.this$0
            r7.vehiclecount = r1
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r7 = r13.this$0
            boolean r7 = r7.isTablet()
            if (r7 == 0) goto L_0x0076
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            r7.putString(r5, r4)
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r8 = r13.this$0
            androidx.fragment.app.FragmentManager r8 = r8.getChildFragmentManager()
            androidx.fragment.app.Fragment r8 = r8.findFragmentById(r3)
            if (r8 == 0) goto L_0x006b
            androidx.navigation.fragment.NavHostFragment r8 = (androidx.navigation.fragment.NavHostFragment) r8
            androidx.navigation.NavController r9 = r8.getNavController()
            r9.popBackStack()
            androidx.navigation.NavController r8 = r8.getNavController()
            r8.navigate((int) r2, (android.os.Bundle) r7)
            goto L_0x0076
        L_0x006b:
            kotlin.TypeCastException r14 = new kotlin.TypeCastException
            r14.<init>(r0)
            throw r14
        L_0x0071:
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r7 = r13.this$0
            r7.isError = r1
        L_0x0076:
            if (r14 == 0) goto L_0x00b2
            r7 = r14
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x007f:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00b2
            java.lang.Object r8 = r7.next()
            com.iaai.android.bdt.model.auctionSalesList.ResultData r8 = (com.iaai.android.bdt.model.auctionSalesList.ResultData) r8
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r9 = r13.this$0
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListAdapter r9 = com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment.access$getAuctionSalesListAdapter$p(r9)
            if (r8 == 0) goto L_0x009e
            java.lang.Boolean r10 = r8.isWatching()
            if (r10 == 0) goto L_0x009e
            boolean r10 = r10.booleanValue()
            goto L_0x009f
        L_0x009e:
            r10 = 0
        L_0x009f:
            if (r8 == 0) goto L_0x00ac
            java.lang.Long r8 = r8.getItemId()
            if (r8 == 0) goto L_0x00ac
            long r11 = r8.longValue()
            goto L_0x00ae
        L_0x00ac:
            r11 = 0
        L_0x00ae:
            r9.setWatchingData(r10, r11)
            goto L_0x007f
        L_0x00b2:
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r7 = r13.this$0
            int r8 = r7.currentCount
            r9 = 0
            if (r14 == 0) goto L_0x00c4
            int r10 = r14.size()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            goto L_0x00c5
        L_0x00c4:
            r10 = r9
        L_0x00c5:
            if (r10 != 0) goto L_0x00ca
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00ca:
            int r10 = r10.intValue()
            int r8 = r8 + r10
            r7.currentCount = r8
            if (r14 == 0) goto L_0x00dd
            int r7 = r14.size()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x00de
        L_0x00dd:
            r7 = r9
        L_0x00de:
            int r7 = r7.intValue()
            if (r7 <= 0) goto L_0x0101
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r7 = r13.this$0
            java.lang.Object r8 = r14.get(r1)
            com.iaai.android.bdt.model.auctionSalesList.ResultData r8 = (com.iaai.android.bdt.model.auctionSalesList.ResultData) r8
            if (r8 == 0) goto L_0x00f3
            java.lang.Long r8 = r8.getResultCount()
            goto L_0x00f4
        L_0x00f3:
            r8 = r9
        L_0x00f4:
            if (r8 != 0) goto L_0x00f9
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x00f9:
            long r10 = r8.longValue()
            int r8 = (int) r10
            r7.totalCount = r8
        L_0x0101:
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r7 = r13.this$0
            r7.addHeaderToAuctionSalesList(r4)
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r4 = r13.this$0
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListViewModel r4 = com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment.access$getViewModel$p(r4)
            androidx.lifecycle.LiveData r4 = r4.getNetworkState()
            java.lang.Object r4 = r4.getValue()
            com.iaai.android.bdt.utils.NetworkState r4 = (com.iaai.android.bdt.utils.NetworkState) r4
            if (r4 == 0) goto L_0x011d
            com.iaai.android.bdt.utils.NetworkState$Status r4 = r4.getStatus()
            goto L_0x011e
        L_0x011d:
            r4 = r9
        L_0x011e:
            com.iaai.android.bdt.utils.NetworkState$Status r7 = com.iaai.android.bdt.utils.NetworkState.Status.SUCCESS
            if (r4 != r7) goto L_0x0216
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r4 = r13.this$0
            com.iaai.android.bdt.base.BaseFragment$ErrorType r7 = com.iaai.android.bdt.base.BaseFragment.ErrorType.NO_STOCKS
            r4.errorType = r7
            if (r14 != 0) goto L_0x012e
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x012e:
            int r4 = r14.size()
            if (r4 <= 0) goto L_0x019a
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r4 = r13.this$0
            java.lang.Object r7 = r14.get(r1)
            com.iaai.android.bdt.model.auctionSalesList.ResultData r7 = (com.iaai.android.bdt.model.auctionSalesList.ResultData) r7
            if (r7 == 0) goto L_0x0143
            java.lang.Long r7 = r7.getResultCount()
            goto L_0x0144
        L_0x0143:
            r7 = r9
        L_0x0144:
            if (r7 != 0) goto L_0x0149
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0149:
            long r7 = r7.longValue()
            int r8 = (int) r7
            r4.totalCount = r8
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r4 = r13.this$0
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.Object r8 = r14.get(r1)
            com.iaai.android.bdt.model.auctionSalesList.ResultData r8 = (com.iaai.android.bdt.model.auctionSalesList.ResultData) r8
            if (r8 == 0) goto L_0x0165
            java.lang.Long r8 = r8.getYear()
            goto L_0x0166
        L_0x0165:
            r8 = r9
        L_0x0166:
            r7.append(r8)
            r8 = 32
            r7.append(r8)
            java.lang.Object r10 = r14.get(r1)
            com.iaai.android.bdt.model.auctionSalesList.ResultData r10 = (com.iaai.android.bdt.model.auctionSalesList.ResultData) r10
            if (r10 == 0) goto L_0x017b
            java.lang.String r10 = r10.getMake()
            goto L_0x017c
        L_0x017b:
            r10 = r9
        L_0x017c:
            r7.append(r10)
            r7.append(r8)
            java.lang.Object r8 = r14.get(r1)
            com.iaai.android.bdt.model.auctionSalesList.ResultData r8 = (com.iaai.android.bdt.model.auctionSalesList.ResultData) r8
            if (r8 == 0) goto L_0x018f
            java.lang.String r8 = r8.getModel()
            goto L_0x0190
        L_0x018f:
            r8 = r9
        L_0x0190:
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r4.year_make_model = r7
        L_0x019a:
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r4 = r13.this$0
            r4.isError = r1
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r4 = r13.this$0
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListAdapter r4 = com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment.access$getAuctionSalesListAdapter$p(r4)
            r4.submitList(r14)
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r4 = r13.this$0
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListAdapter r4 = com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment.access$getAuctionSalesListAdapter$p(r4)
            r4.notifyDataSetChanged()
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r4 = r13.this$0
            boolean r4 = r4.isTablet()
            if (r4 == 0) goto L_0x0216
            java.lang.Object r4 = r14.get(r1)
            com.iaai.android.bdt.model.auctionSalesList.ResultData r4 = (com.iaai.android.bdt.model.auctionSalesList.ResultData) r4
            if (r4 == 0) goto L_0x01c6
            java.lang.Long r4 = r4.getItemId()
            goto L_0x01c7
        L_0x01c6:
            r4 = r9
        L_0x01c7:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            java.lang.Object r1 = r14.get(r1)
            com.iaai.android.bdt.model.auctionSalesList.ResultData r1 = (com.iaai.android.bdt.model.auctionSalesList.ResultData) r1
            if (r1 == 0) goto L_0x01dd
            java.lang.Long r1 = r1.getItemId()
            goto L_0x01de
        L_0x01dd:
            r1 = r9
        L_0x01de:
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r8 = r13.this$0
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListAdapter r8 = com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment.access$getAuctionSalesListAdapter$p(r8)
            r8.setSelectedItemForTablet(r1)
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r1 = r13.this$0
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListAdapter r1 = com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment.access$getAuctionSalesListAdapter$p(r1)
            r1.notifyDataSetChanged()
            r7.putString(r5, r4)
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r1 = r13.this$0
            androidx.fragment.app.FragmentManager r1 = r1.getChildFragmentManager()
            androidx.fragment.app.Fragment r1 = r1.findFragmentById(r3)
            if (r1 == 0) goto L_0x0210
            androidx.navigation.fragment.NavHostFragment r1 = (androidx.navigation.fragment.NavHostFragment) r1
            androidx.navigation.NavController r0 = r1.getNavController()
            r0.popBackStack()
            androidx.navigation.NavController r0 = r1.getNavController()
            r0.navigate((int) r2, (android.os.Bundle) r7)
            goto L_0x0216
        L_0x0210:
            kotlin.TypeCastException r14 = new kotlin.TypeCastException
            r14.<init>(r0)
            throw r14
        L_0x0216:
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r0 = r13.this$0
            boolean r0 = r0.isError
            if (r0 != 0) goto L_0x026d
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r0 = r13.this$0
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListViewModel r0 = com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment.access$getViewModel$p(r0)
            androidx.lifecycle.LiveData r0 = r0.getNetworkState()
            java.lang.Object r0 = r0.getValue()
            com.iaai.android.bdt.utils.NetworkState r0 = (com.iaai.android.bdt.utils.NetworkState) r0
            if (r0 == 0) goto L_0x0235
            com.iaai.android.bdt.utils.NetworkState$Status r0 = r0.getStatus()
            goto L_0x0236
        L_0x0235:
            r0 = r9
        L_0x0236:
            com.iaai.android.bdt.utils.NetworkState$Status r1 = com.iaai.android.bdt.utils.NetworkState.Status.FAILED
            if (r0 != r1) goto L_0x026d
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r0 = r13.this$0
            com.iaai.android.bdt.base.BaseFragment$ErrorType r1 = com.iaai.android.bdt.base.BaseFragment.ErrorType.NETWORK_ERROR
            r0.errorType = r1
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r0 = r13.this$0
            r0.isError = r6
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r0 = r13.this$0
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListViewModel r1 = com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment.access$getViewModel$p(r0)
            androidx.lifecycle.LiveData r1 = r1.getNetworkState()
            java.lang.Object r1 = r1.getValue()
            com.iaai.android.bdt.utils.NetworkState r1 = (com.iaai.android.bdt.utils.NetworkState) r1
            if (r1 == 0) goto L_0x025c
            java.lang.String r9 = r1.getMsg()
        L_0x025c:
            if (r9 != 0) goto L_0x0261
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0261:
            r0.addHeaderToAuctionSalesList(r9)
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r0 = r13.this$0
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListAdapter r0 = com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment.access$getAuctionSalesListAdapter$p(r0)
            r0.submitList(r14)
        L_0x026d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment$subscribeToViewModel$3.onChanged(androidx.paging.PagedList):void");
    }
}
