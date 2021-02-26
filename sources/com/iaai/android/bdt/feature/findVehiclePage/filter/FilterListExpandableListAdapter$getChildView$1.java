package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.util.Log;
import android.view.View;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FilterListExpandableListAdapter.kt */
final class FilterListExpandableListAdapter$getChildView$1 implements View.OnClickListener {
    final /* synthetic */ int $expandedListPosition;
    final /* synthetic */ int $listPosition;
    final /* synthetic */ FilterListExpandableListAdapter this$0;

    FilterListExpandableListAdapter$getChildView$1(FilterListExpandableListAdapter filterListExpandableListAdapter, int i, int i2) {
        this.this$0 = filterListExpandableListAdapter;
        this.$expandedListPosition = i;
        this.$listPosition = i2;
    }

    public final void onClick(View view) {
        Log.d("Pos", this.$expandedListPosition + " child " + this.$listPosition);
        this.this$0.setGroupPosition(this.$listPosition);
        FilterListExpandableListAdapter.updateListOnSelectItem$default(this.this$0, this.$listPosition, this.$expandedListPosition, "", 0, 8, (Object) null);
        this.this$0.getOnItemClickListener().onChildItemClick(this.$listPosition, this.$expandedListPosition, "");
    }
}
