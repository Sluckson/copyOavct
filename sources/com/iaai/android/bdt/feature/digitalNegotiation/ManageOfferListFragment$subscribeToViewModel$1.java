package com.iaai.android.bdt.feature.digitalNegotiation;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.digitalNegotiation.DigitalNegotiationListClass;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/digitalNegotiation/DigitalNegotiationListClass;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ManageOfferListFragment.kt */
final class ManageOfferListFragment$subscribeToViewModel$1<T> implements Observer<DigitalNegotiationListClass> {
    final /* synthetic */ ManageOfferListFragment this$0;

    ManageOfferListFragment$subscribeToViewModel$1(ManageOfferListFragment manageOfferListFragment) {
        this.this$0 = manageOfferListFragment;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004c, code lost:
        r0 = r0.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(com.iaai.android.bdt.model.digitalNegotiation.DigitalNegotiationListClass r9) {
        /*
            r8 = this;
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r0 = r8.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r0 = r0.manageOfferListAdapter
            if (r0 == 0) goto L_0x01f0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r0 = r8.this$0
            r1 = 0
            r0.showLoadingIndicator(r1)
            java.util.ArrayList r0 = r9.getMobileNegotiationsList()
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0046
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0046
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r0 = r8.this$0
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
            r0.offersList = r4
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r0 = r8.this$0
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
            r0.bidHistory = r4
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r0 = r8.this$0
            r0.showEmptyState(r2)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r0 = r8.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity r0 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListActivity$p(r0)
            android.widget.TextView r0 = r0.getToolbar_sub_title()
            r2 = 8
            r0.setVisibility(r2)
            java.lang.String r0 = ""
            goto L_0x00c1
        L_0x0046:
            java.util.ArrayList r0 = r9.getMobileNegotiationsList()
            if (r0 == 0) goto L_0x0059
            java.lang.Object r0 = r0.get(r1)
            com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList r0 = (com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList) r0
            if (r0 == 0) goto L_0x0059
            java.lang.Integer r0 = r0.getItemId()
            goto L_0x005a
        L_0x0059:
            r0 = r3
        L_0x005a:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r4 = r8.this$0
            java.util.ArrayList r5 = r9.getMobileNegotiationsList()
            java.util.List r5 = (java.util.List) r5
            r4.offersList = r5
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r4 = r8.this$0
            java.util.ArrayList r5 = r9.getNegotiationsBidHistory()
            if (r5 == 0) goto L_0x0072
            goto L_0x0077
        L_0x0072:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
        L_0x0077:
            java.util.List r5 = (java.util.List) r5
            r4.bidHistory = r5
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r4 = r8.this$0
            r4.showEmptyState(r1)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r4 = r8.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity r4 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListActivity$p(r4)
            android.widget.TextView r4 = r4.getToolbar_sub_title()
            r4.setVisibility(r1)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r4 = r8.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity r4 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListActivity$p(r4)
            android.widget.TextView r4 = r4.getToolbar_sub_title()
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r5 = r8.this$0
            android.content.res.Resources r5 = r5.getResources()
            r6 = 2131821835(0x7f11050b, float:1.9276424E38)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.util.ArrayList r7 = r9.getMobileNegotiationsList()
            if (r7 == 0) goto L_0x00b2
            int r7 = r7.size()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x00b6
        L_0x00b2:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
        L_0x00b6:
            r2[r1] = r7
            java.lang.String r2 = r5.getString(r6, r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r4.setText(r2)
        L_0x00c1:
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r2 = r8.this$0
            java.util.ArrayList r4 = r9.getMobileNegotiationsList()
            java.util.List r4 = (java.util.List) r4
            int r4 = r2.getRequireActionCount(r4)
            r2.setRequireAction(r4)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r2 = r8.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r2 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListAdapter$p(r2)
            java.util.ArrayList r4 = r9.getMobileNegotiationsList()
            if (r4 == 0) goto L_0x00df
            java.util.List r4 = (java.util.List) r4
            goto L_0x00e6
        L_0x00df:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List r4 = (java.util.List) r4
        L_0x00e6:
            r2.setNegotiationList(r4)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r2 = r8.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r2 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListAdapter$p(r2)
            java.util.ArrayList r4 = r9.getNegotiationsBidHistory()
            if (r4 == 0) goto L_0x00f8
            java.util.List r4 = (java.util.List) r4
            goto L_0x00ff
        L_0x00f8:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List r4 = (java.util.List) r4
        L_0x00ff:
            r2.setNegotiationsBidHistory(r4)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r2 = r8.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r2 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListAdapter$p(r2)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r4 = r8.this$0
            int r4 = r4.getRequireAction()
            r2.setRequireActionCount(r4)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r2 = r8.this$0
            boolean r2 = r2.isTablet()
            if (r2 == 0) goto L_0x01d5
            java.util.ArrayList r2 = r9.getMobileNegotiationsList()
            if (r2 == 0) goto L_0x012a
            int r2 = r2.size()
            if (r2 != 0) goto L_0x012a
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            goto L_0x013c
        L_0x012a:
            java.util.ArrayList r2 = r9.getMobileNegotiationsList()
            if (r2 == 0) goto L_0x013c
            java.lang.Object r2 = r2.get(r1)
            com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList r2 = (com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList) r2
            if (r2 == 0) goto L_0x013c
            java.lang.Integer r3 = r2.getItemId()
        L_0x013c:
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r4 = r8.this$0
            java.util.ArrayList r5 = r9.getMobileNegotiationsList()
            java.util.List r5 = (java.util.List) r5
            int r5 = r4.getRequireActionCount(r5)
            r4.setRequireAction(r5)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r4 = r8.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r4 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListAdapter$p(r4)
            java.util.ArrayList r5 = r9.getMobileNegotiationsList()
            if (r5 != 0) goto L_0x015f
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x015f:
            java.util.List r5 = (java.util.List) r5
            r4.setNegotiationList(r5)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r4 = r8.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r4 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListAdapter$p(r4)
            if (r3 == 0) goto L_0x016d
            goto L_0x0171
        L_0x016d:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
        L_0x0171:
            r4.setSelectedItemForTablet(r3)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r1 = r8.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r1 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListAdapter$p(r1)
            java.util.ArrayList r9 = r9.getNegotiationsBidHistory()
            if (r9 == 0) goto L_0x0183
            java.util.List r9 = (java.util.List) r9
            goto L_0x018a
        L_0x0183:
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.List r9 = (java.util.List) r9
        L_0x018a:
            r1.setNegotiationsBidHistory(r9)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r9 = r8.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r9 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListAdapter$p(r9)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r1 = r8.this$0
            int r1 = r1.getRequireAction()
            r9.setRequireActionCount(r1)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r9 = r8.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r9 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListAdapter$p(r9)
            r9.notifyDataSetChanged()
            java.lang.String r9 = "itemId"
            r2.putString(r9, r0)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r9 = r8.this$0
            androidx.fragment.app.FragmentManager r9 = r9.getChildFragmentManager()
            r0 = 2131296449(0x7f0900c1, float:1.8210815E38)
            androidx.fragment.app.Fragment r9 = r9.findFragmentById(r0)
            if (r9 == 0) goto L_0x01cd
            androidx.navigation.fragment.NavHostFragment r9 = (androidx.navigation.fragment.NavHostFragment) r9
            androidx.navigation.NavController r0 = r9.getNavController()
            r0.popBackStack()
            androidx.navigation.NavController r9 = r9.getNavController()
            r0 = 2131296297(0x7f090029, float:1.8210507E38)
            r9.navigate((int) r0, (android.os.Bundle) r2)
            goto L_0x01f0
        L_0x01cd:
            kotlin.TypeCastException r9 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment"
            r9.<init>(r0)
            throw r9
        L_0x01d5:
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r9 = r8.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity r0 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListActivity$p(r9)
            com.iaai.android.bdt.feature.digitalNegotiation.FilterSelected r0 = r0.getFilterSelected()
            java.util.List r9 = r9.filterListBasedOnSelection(r0)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r0 = r8.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity r1 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListActivity$p(r0)
            com.iaai.android.bdt.feature.digitalNegotiation.FilterSelected r1 = r1.getFilterSelected()
            r0.updateRecyclerUI(r1, r9)
        L_0x01f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment$subscribeToViewModel$1.onChanged(com.iaai.android.bdt.model.digitalNegotiation.DigitalNegotiationListClass):void");
    }
}
