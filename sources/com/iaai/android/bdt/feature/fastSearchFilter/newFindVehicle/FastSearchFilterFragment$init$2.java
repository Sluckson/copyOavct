package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.widget.ExpandableListView;
import com.google.android.material.tabs.TabLayout;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, mo66933d2 = {"com/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterFragment$init$2", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "onTabReselected", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchFilterFragment.kt */
public final class FastSearchFilterFragment$init$2 implements TabLayout.OnTabSelectedListener {
    final /* synthetic */ FastSearchFilterFragment this$0;

    public void onTabReselected(@Nullable TabLayout.Tab tab) {
    }

    public void onTabUnselected(@Nullable TabLayout.Tab tab) {
    }

    FastSearchFilterFragment$init$2(FastSearchFilterFragment fastSearchFilterFragment) {
        this.this$0 = fastSearchFilterFragment;
    }

    public void onTabSelected(@Nullable TabLayout.Tab tab) {
        boolean z = false;
        int position = tab != null ? tab.getPosition() : 0;
        if (position == 0) {
            FastSearchExpandableAdapter access$getExpandableListAdapterVF$p = this.this$0.expandableListAdapterVF;
            if (access$getExpandableListAdapterVF$p != null) {
                access$getExpandableListAdapterVF$p.setTabPosition(0);
            }
            this.this$0.tabPos = 0;
            ExpandableListView expandableListView = (ExpandableListView) this.this$0._$_findCachedViewById(C2723R.C2726id.expandableFilter);
            if (expandableListView != null) {
                expandableListView.setAdapter(this.this$0.expandableListAdapterVF);
            }
        } else if (position == 1) {
            FastSearchFilterFragment fastSearchFilterFragment = this.this$0;
            fastSearchFilterFragment.expandableListAdapterSF = new FastSearchExpandableAdapter(FastSearchFilterFragment.access$getFastSearchFilterActivity$p(fastSearchFilterFragment));
            FastSearchExpandableAdapter access$getExpandableListAdapterSF$p = this.this$0.expandableListAdapterSF;
            if (access$getExpandableListAdapterSF$p != null) {
                access$getExpandableListAdapterSF$p.setClickListener(this.this$0.clickListener);
            }
            FastSearchExpandableAdapter access$getExpandableListAdapterSF$p2 = this.this$0.expandableListAdapterSF;
            if (access$getExpandableListAdapterSF$p2 != null) {
                access$getExpandableListAdapterSF$p2.setTabPosition(1);
            }
            this.this$0.tabPos = 1;
            ExpandableListView expandableListView2 = (ExpandableListView) this.this$0._$_findCachedViewById(C2723R.C2726id.expandableFilter);
            if (expandableListView2 != null) {
                expandableListView2.setAdapter(this.this$0.expandableListAdapterSF);
            }
        }
        RefinerHeaderAdapter access$getHeaderAdapter$p = this.this$0.headerAdapter;
        if (access$getHeaderAdapter$p != null) {
            z = access$getHeaderAdapter$p.isNewHeaderItemAdded();
        }
        if (z) {
            this.this$0.parentPosition = -1;
            this.this$0.getFilterValueBasedSelectedRefiner(z);
        }
    }
}
