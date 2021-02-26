package com.iaai.android.bdt.feature.digitalNegotiation;

import android.content.Intent;
import android.view.View;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain;
import com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList;
import com.iaai.android.bdt.utils.Constants_MVVM;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J*\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, mo66933d2 = {"com/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListFragment$initializeRecycler$1", "Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListAdapterMain$CustomManageItemClickListener;", "onFilterButtonClick", "", "onManageActionButtonClick", "v", "Landroid/view/View;", "data", "Lcom/iaai/android/bdt/model/digitalNegotiation/MobileNegotiationsList;", "position", "", "action", "Lcom/iaai/android/bdt/feature/digitalNegotiation/NegotiationActionEnum;", "onManageOfferListClick", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ManageOfferListFragment.kt */
public final class ManageOfferListFragment$initializeRecycler$1 implements ManageOfferListAdapterMain.CustomManageItemClickListener {
    final /* synthetic */ ManageOfferListFragment this$0;

    ManageOfferListFragment$initializeRecycler$1(ManageOfferListFragment manageOfferListFragment) {
        this.this$0 = manageOfferListFragment;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v46, resolved type: java.lang.Integer} */
    /* JADX WARNING: type inference failed for: r7v1 */
    /* JADX WARNING: type inference failed for: r7v56 */
    /* JADX WARNING: type inference failed for: r7v57 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onManageOfferListClick(@org.jetbrains.annotations.NotNull android.view.View r7, @org.jetbrains.annotations.Nullable com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList r8, int r9) {
        /*
            r6 = this;
            java.lang.String r0 = "v"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            r7 = 0
            if (r8 == 0) goto L_0x000d
            java.lang.Integer r0 = r8.getItemId()
            goto L_0x000e
        L_0x000d:
            r0 = r7
        L_0x000e:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r2 = "itemId"
            r1.putString(r2, r0)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r0 = r6.this$0
            boolean r0 = r0.isTablet()
            if (r0 == 0) goto L_0x0068
            if (r8 == 0) goto L_0x002a
            java.lang.Integer r7 = r8.getItemId()
        L_0x002a:
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r8 = r6.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r8 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListAdapter$p(r8)
            r8.setSelectedItemForTablet(r7)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r7 = r6.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r7 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListAdapter$p(r7)
            r7.notifyDataSetChanged()
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r7 = r6.this$0
            androidx.fragment.app.FragmentManager r7 = r7.getChildFragmentManager()
            r8 = 2131296449(0x7f0900c1, float:1.8210815E38)
            androidx.fragment.app.Fragment r7 = r7.findFragmentById(r8)
            if (r7 == 0) goto L_0x0060
            androidx.navigation.fragment.NavHostFragment r7 = (androidx.navigation.fragment.NavHostFragment) r7
            androidx.navigation.NavController r8 = r7.getNavController()
            r8.popBackStack()
            androidx.navigation.NavController r7 = r7.getNavController()
            r8 = 2131296297(0x7f090029, float:1.8210507E38)
            r7.navigate((int) r8, (android.os.Bundle) r1)
            goto L_0x0207
        L_0x0060:
            kotlin.TypeCastException r7 = new kotlin.TypeCastException
            java.lang.String r8 = "null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment"
            r7.<init>(r8)
            throw r7
        L_0x0068:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r2 = r6.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r2 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListAdapter$p(r2)
            java.util.List r2 = r2.getMobileNegotiationList()
            if (r2 == 0) goto L_0x0097
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x007f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0097
            java.lang.Object r3 = r2.next()
            com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList r3 = (com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList) r3
            java.lang.Integer r3 = r3.getItemId()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r0.add(r3)
            goto L_0x007f
        L_0x0097:
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r2 = r6.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r3 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListAdapter$p(r2)
            java.util.List r3 = r3.getMobileNegotiationList()
            r4 = 0
            if (r3 == 0) goto L_0x00a9
            int r3 = r3.size()
            goto L_0x00aa
        L_0x00a9:
            r3 = 0
        L_0x00aa:
            r2.totalCount = r3
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r2 = r6.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain r3 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListAdapter$p(r2)
            java.util.List r3 = r3.getMobileNegotiationList()
            if (r3 == 0) goto L_0x00bd
            int r4 = r3.size()
        L_0x00bd:
            r2.currentCount = r4
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r2 = r6.this$0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            if (r8 == 0) goto L_0x00ce
            java.lang.Integer r4 = r8.getYear()
            goto L_0x00cf
        L_0x00ce:
            r4 = r7
        L_0x00cf:
            r3.append(r4)
            r4 = 32
            r3.append(r4)
            if (r8 == 0) goto L_0x00de
            java.lang.String r5 = r8.getMake()
            goto L_0x00df
        L_0x00de:
            r5 = r7
        L_0x00df:
            r3.append(r5)
            r3.append(r4)
            if (r8 == 0) goto L_0x00eb
            java.lang.String r7 = r8.getModel()
        L_0x00eb:
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            r2.year_make_model = r7
            java.lang.String r7 = "item_ids_list"
            r1.putStringArrayList(r7, r0)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r7 = r6.this$0
            java.lang.String r7 = r7.live_date
            java.lang.String r8 = "AuctionDate"
            r1.putString(r8, r7)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r7 = r6.this$0
            java.lang.String r7 = r7.branchId
            java.lang.String r8 = "branchId"
            r1.putString(r8, r7)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r7 = r6.this$0
            int r7 = r7.currentCount
            java.lang.String r8 = "currentCount"
            r1.putInt(r8, r7)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r7 = r6.this$0
            int r7 = r7.totalCount
            java.lang.String r8 = "totalCount"
            r1.putInt(r8, r7)
            java.lang.String r7 = "position"
            r1.putInt(r7, r9)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r7 = r6.this$0
            java.lang.String r7 = r7.year_make_model
            java.lang.String r8 = "fastSearchParam"
            r1.putString(r8, r7)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r7 = r6.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity r7 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListActivity$p(r7)
            android.app.Activity r7 = (android.app.Activity) r7
            r8 = 2131297604(0x7f090544, float:1.8213158E38)
            androidx.navigation.NavController r7 = androidx.navigation.Navigation.findNavController(r7, r8)
            java.lang.String r8 = "Navigation.findNavContro…d.main_nav_host_fragment)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r8)
            r8 = 2131296365(0x7f09006d, float:1.8210645E38)
            r7.navigate((int) r8, (android.os.Bundle) r1)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r7 = r6.this$0
            int r7 = r7.totalCount
            r8 = 8
            r0 = 1
            if (r7 <= r0) goto L_0x01e5
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r7 = r6.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity r7 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListActivity$p(r7)
            int r1 = com.iaai.android.C2723R.C2726id.toolbar_relativelayout
            android.view.View r7 = r7._$_findCachedViewById(r1)
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7
            java.lang.String r1 = "manageOfferListActivity.toolbar_relativelayout"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r1)
            r2 = 8388613(0x800005, float:1.175495E-38)
            r7.setGravity(r2)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r7 = r6.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity r7 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListActivity$p(r7)
            int r2 = com.iaai.android.C2723R.C2726id.toolbar_relativelayout
            android.view.View r7 = r7._$_findCachedViewById(r2)
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r1)
            r1 = 5
            r7.setGravity(r1)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r7 = r6.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity r7 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListActivity$p(r7)
            android.widget.TextView r7 = r7.getToolbar_title()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r9 = r9 + r0
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r1.append(r9)
            java.lang.String r9 = " of "
            r1.append(r9)
            com.iaai.android.bdt.utils.NewDateHelper r9 = com.iaai.android.bdt.utils.NewDateHelper.INSTANCE
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r0 = r6.this$0
            int r0 = r0.totalCount
            java.lang.String r9 = r9.formattedVehicleCount(r0)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r7.setText(r9)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r7 = r6.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity r7 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListActivity$p(r7)
            android.widget.TextView r7 = r7.getToolbar_title()
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r9 = r6.this$0
            android.content.res.Resources r9 = r9.getResources()
            r0 = 2131099697(0x7f060031, float:1.7811755E38)
            int r9 = r9.getColor(r0)
            r7.setTextColor(r9)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r7 = r6.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity r7 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListActivity$p(r7)
            android.widget.TextView r7 = r7.getToolbar_sub_title()
            r7.setVisibility(r8)
            goto L_0x0207
        L_0x01e5:
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r7 = r6.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity r7 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListActivity$p(r7)
            android.widget.TextView r7 = r7.getToolbar_title()
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r9 = r6.this$0
            java.lang.String r9 = r9.year_make_model
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r7.setText(r9)
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment r7 = r6.this$0
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity r7 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.access$getManageOfferListActivity$p(r7)
            android.widget.TextView r7 = r7.getToolbar_sub_title()
            r7.setVisibility(r8)
        L_0x0207:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment$initializeRecycler$1.onManageOfferListClick(android.view.View, com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList, int):void");
    }

    public void onManageActionButtonClick(@NotNull View view, @Nullable MobileNegotiationsList mobileNegotiationsList, int i, @NotNull NegotiationActionEnum negotiationActionEnum) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        Intrinsics.checkParameterIsNotNull(negotiationActionEnum, "action");
        this.this$0.showDialog(mobileNegotiationsList, i, negotiationActionEnum);
    }

    public void onFilterButtonClick() {
        Intent intent = new Intent(this.this$0.getContext(), ManagerOfferFilterActivity.class);
        intent.putExtra(Constants_MVVM.SELECTED_MANAGE_OFFER_FILTER, ManageOfferListFragment.access$getManageOfferListActivity$p(this.this$0).getFilterSelected());
        List access$getOffersList$p = this.this$0.offersList;
        if (access$getOffersList$p != null) {
            intent.putExtra(Constants_MVVM.MANAGER_OFFERS_LIST, (Serializable) access$getOffersList$p);
            this.this$0.startActivityForResult(intent, 100);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.io.Serializable");
    }
}
