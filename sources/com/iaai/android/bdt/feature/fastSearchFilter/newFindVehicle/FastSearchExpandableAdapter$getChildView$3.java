package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.widget.RadioGroup;
import com.iaai.android.bdt.model.fastSearchFilter2.FacetXX;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo66933d2 = {"<anonymous>", "", "group", "Landroid/widget/RadioGroup;", "kotlin.jvm.PlatformType", "checkedId", "", "onCheckedChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchExpandableAdapter.kt */
final class FastSearchExpandableAdapter$getChildView$3 implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ int $listPosition;
    final /* synthetic */ List $temp;
    final /* synthetic */ FastSearchExpandableAdapter this$0;

    FastSearchExpandableAdapter$getChildView$3(FastSearchExpandableAdapter fastSearchExpandableAdapter, List list, int i) {
        this.this$0 = fastSearchExpandableAdapter;
        this.$temp = list;
        this.$listPosition = i;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        List list = this.$temp;
        if (list != null && ((FacetXX) list.get(i)) != null) {
            this.this$0.updateListOnSelectItem(this.$listPosition, i, true);
            this.this$0.getOnItemClickListener().onRadioItemClick(this.$listPosition, i);
        }
    }
}
