package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.bdt.feature.findVehiclePage.filter.MakeModelFilterAdapter;
import com.iaai.android.bdt.model.filter.MakeModelValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: MakeModelFilterAdapter.kt */
final class MakeModelFilterAdapter$onBindViewHolder$1 implements View.OnClickListener {
    final /* synthetic */ RecyclerView.ViewHolder $holder;
    final /* synthetic */ boolean $isMake;
    final /* synthetic */ MakeModelFilterAdapter this$0;

    MakeModelFilterAdapter$onBindViewHolder$1(MakeModelFilterAdapter makeModelFilterAdapter, boolean z, RecyclerView.ViewHolder viewHolder) {
        this.this$0 = makeModelFilterAdapter;
        this.$isMake = z;
        this.$holder = viewHolder;
    }

    public final void onClick(View view) {
        if (!this.$isMake) {
            this.this$0.setSelectedPosition(((MakeModelFilterAdapter.MakeViewHolder) this.$holder).getAdapterPosition());
            boolean isSelected = ((MakeModelValues) MakeModelFilterAdapter.access$getFilterValues$p(this.this$0).get(this.this$0.getSelectedPosition())).isSelected();
            String str = null;
            if (MakeModelFilterAdapter.access$getOnItemClickListener$p(this.this$0).getMakeSelectedCount() <= 9 || isSelected) {
                String displayText = ((MakeModelValues) MakeModelFilterAdapter.access$getFilterValues$p(this.this$0).get(this.this$0.getSelectedPosition())).getDisplayText();
                if (displayText == null) {
                    Intrinsics.throwNpe();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("All ");
                MakeModelValues makeInfo = ((MakeModelValues) MakeModelFilterAdapter.access$getFilterValues$p(this.this$0).get(this.this$0.getSelectedPosition())).getMakeInfo();
                if (makeInfo != null) {
                    str = makeInfo.getDisplayText();
                }
                sb.append(str);
                if (StringsKt.startsWith(displayText, sb.toString(), true)) {
                    MakeModelFilterAdapter makeModelFilterAdapter = this.this$0;
                    makeModelFilterAdapter.onClickAllMake(makeModelFilterAdapter.getSelectedPosition());
                } else {
                    MakeModelFilterAdapter makeModelFilterAdapter2 = this.this$0;
                    makeModelFilterAdapter2.onClickModel(makeModelFilterAdapter2.getSelectedPosition());
                }
                if (isSelected) {
                    MakeModelFilterAdapter.access$getOnItemClickListener$p(this.this$0).removeSelectedFilter((MakeModelValues) MakeModelFilterAdapter.access$getFilterValues$p(this.this$0).get(this.this$0.getSelectedPosition()), "");
                } else {
                    MakeModelFilterAdapter.access$getOnItemClickListener$p(this.this$0).onItemClick((MakeModelValues) MakeModelFilterAdapter.access$getFilterValues$p(this.this$0).get(this.this$0.getSelectedPosition()), this.this$0.getSelectedPosition());
                }
            } else {
                MakeModelFilterAdapter makeModelFilterAdapter3 = this.this$0;
                if (makeModelFilterAdapter3.checkMakeExistAfterLimitExceed((MakeModelValues) MakeModelFilterAdapter.access$getFilterValues$p(makeModelFilterAdapter3).get(this.this$0.getSelectedPosition()))) {
                    String displayText2 = ((MakeModelValues) MakeModelFilterAdapter.access$getFilterValues$p(this.this$0).get(this.this$0.getSelectedPosition())).getDisplayText();
                    if (displayText2 == null) {
                        Intrinsics.throwNpe();
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("All ");
                    MakeModelValues makeInfo2 = ((MakeModelValues) MakeModelFilterAdapter.access$getFilterValues$p(this.this$0).get(this.this$0.getSelectedPosition())).getMakeInfo();
                    if (makeInfo2 != null) {
                        str = makeInfo2.getDisplayText();
                    }
                    sb2.append(str);
                    if (StringsKt.startsWith(displayText2, sb2.toString(), true)) {
                        MakeModelFilterAdapter makeModelFilterAdapter4 = this.this$0;
                        makeModelFilterAdapter4.onClickAllMake(makeModelFilterAdapter4.getSelectedPosition());
                    } else {
                        MakeModelFilterAdapter makeModelFilterAdapter5 = this.this$0;
                        makeModelFilterAdapter5.onClickModel(makeModelFilterAdapter5.getSelectedPosition());
                    }
                    if (isSelected) {
                        MakeModelFilterAdapter.access$getOnItemClickListener$p(this.this$0).removeSelectedFilter((MakeModelValues) MakeModelFilterAdapter.access$getFilterValues$p(this.this$0).get(this.this$0.getSelectedPosition()), "");
                    } else {
                        MakeModelFilterAdapter.access$getOnItemClickListener$p(this.this$0).onItemClick((MakeModelValues) MakeModelFilterAdapter.access$getFilterValues$p(this.this$0).get(this.this$0.getSelectedPosition()), this.this$0.getSelectedPosition());
                    }
                } else {
                    MakeModelFilterAdapter.access$getOnItemClickListener$p(this.this$0).showErrorMsg();
                }
            }
        }
    }
}
