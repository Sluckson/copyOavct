package com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref;

import android.view.View;
import com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref.ManageBranchListAdapter;
import com.iaai.android.bdt.model.MyAccount.BranchModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ManageBranchListAdapter.kt */
final class ManageBranchListAdapter$ViewHolder$bind$1 implements View.OnClickListener {
    final /* synthetic */ int $position;
    final /* synthetic */ ManageBranchListAdapter.ViewHolder this$0;

    ManageBranchListAdapter$ViewHolder$bind$1(ManageBranchListAdapter.ViewHolder viewHolder, int i) {
        this.this$0 = viewHolder;
        this.$position = i;
    }

    public final void onClick(View view) {
        ArrayList access$getMBranchList$p = this.this$0.this$0.mBranchList;
        if (access$getMBranchList$p == null) {
            Intrinsics.throwNpe();
        }
        BranchModel branchModel = (BranchModel) access$getMBranchList$p.get(this.$position - 1);
        ArrayList access$getMBranchList$p2 = this.this$0.this$0.mBranchList;
        if (access$getMBranchList$p2 == null) {
            Intrinsics.throwNpe();
        }
        branchModel.setSelected(!((BranchModel) access$getMBranchList$p2.get(this.$position - 1)).isSelected());
        this.this$0.this$0.setSelectedPosition(this.$position);
        this.this$0.this$0.notifyItemChanged(this.this$0.this$0.getSelectedPosition());
        ArrayList arrayList = new ArrayList();
        ArrayList<BranchModel> access$getMBranchList$p3 = this.this$0.this$0.mBranchList;
        if (access$getMBranchList$p3 != null) {
            for (BranchModel branchModel2 : access$getMBranchList$p3) {
                if (branchModel2.isSelected()) {
                    arrayList.add(branchModel2);
                }
            }
        }
        this.this$0.this$0.branchPrefClickListener.onBranchSelect(arrayList);
    }
}
