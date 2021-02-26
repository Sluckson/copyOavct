package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.view.View;
import android.widget.ExpandableListView;
import com.iaai.android.C2723R;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, mo66933d2 = {"<anonymous>", "", "parent", "Landroid/widget/ExpandableListView;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "groupPosition", "", "id", "", "onGroupClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchFilterFragment.kt */
final class FastSearchFilterFragment$init$3 implements ExpandableListView.OnGroupClickListener {
    final /* synthetic */ FastSearchFilterFragment this$0;

    FastSearchFilterFragment$init$3(FastSearchFilterFragment fastSearchFilterFragment) {
        this.this$0 = fastSearchFilterFragment;
    }

    public final boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        this.this$0.parentPosition = i;
        this.this$0.collapseAllFilter(i);
        boolean z = false;
        if (((ExpandableListView) this.this$0._$_findCachedViewById(C2723R.C2726id.expandableFilter)).isGroupExpanded(i)) {
            return false;
        }
        FastSearchFilterFragment fastSearchFilterFragment = this.this$0;
        if (!fastSearchFilterFragment.navigateToCustomFacetValue(fastSearchFilterFragment.parentPosition)) {
            ((ExpandableListView) this.this$0._$_findCachedViewById(C2723R.C2726id.expandableFilter)).collapseGroup(this.this$0.parentPosition);
            RefinerHeaderAdapter access$getHeaderAdapter$p = this.this$0.headerAdapter;
            if (access$getHeaderAdapter$p != null) {
                z = access$getHeaderAdapter$p.isNewHeaderItemAdded();
            }
            if (z) {
                this.this$0.getFilterValueBasedSelectedRefiner(z);
            } else {
                this.this$0.navigateToFullScreenFacets(i);
            }
        }
        return true;
    }
}
