package com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref;

import android.widget.Button;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import com.iaai.android.bdt.model.MyAccount.BranchModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016¨\u0006\u000b"}, mo66933d2 = {"com/iaai/android/bdt/feature/account/salesdocument/manageBranchPref/ManageBranchPrefActivity$initializeRecycler$1", "Lcom/iaai/android/bdt/feature/account/salesdocument/manageBranchPref/BranchPrefClickListener;", "onBranchClear", "", "onBranchFilter", "FilteredValue", "", "onBranchSelect", "branchList", "", "Lcom/iaai/android/bdt/model/MyAccount/BranchModel;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ManageBranchPrefActivity.kt */
public final class ManageBranchPrefActivity$initializeRecycler$1 implements BranchPrefClickListener {
    final /* synthetic */ ManageBranchPrefActivity this$0;

    ManageBranchPrefActivity$initializeRecycler$1(ManageBranchPrefActivity manageBranchPrefActivity) {
        this.this$0 = manageBranchPrefActivity;
    }

    public void onBranchSelect(@Nullable List<BranchModel> list) {
        this.this$0.selectedBranchList = (ArrayList) list;
        Collection collection = list;
        if (!(collection == null || collection.isEmpty())) {
            Button button = (Button) this.this$0._$_findCachedViewById(C2723R.C2726id.btnCheckOut);
            Intrinsics.checkExpressionValueIsNotNull(button, "btnCheckOut");
            button.setClickable(true);
            Button button2 = (Button) this.this$0._$_findCachedViewById(C2723R.C2726id.btnCheckOut);
            Intrinsics.checkExpressionValueIsNotNull(button2, "btnCheckOut");
            button2.setAlpha(1.0f);
            return;
        }
        this.this$0.resetUI();
    }

    public void onBranchFilter(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "FilteredValue");
        this.this$0.filter(str);
    }

    public void onBranchClear() {
        ArrayList access$getSelectedBranchList$p;
        Activity_ExtensionKt.hideSoftKeyboard(this.this$0);
        ArrayList access$getSelectedBranchList$p2 = this.this$0.selectedBranchList;
        if (access$getSelectedBranchList$p2 != null) {
            access$getSelectedBranchList$p2.clear();
        }
        ArrayList<BranchModel> access$getBranchList$p = this.this$0.branchList;
        if (access$getBranchList$p != null) {
            for (BranchModel branchModel : access$getBranchList$p) {
                if (branchModel.isSelected() && (access$getSelectedBranchList$p = this.this$0.selectedBranchList) != null) {
                    access$getSelectedBranchList$p.add(branchModel);
                }
                if (branchModel.isSelected()) {
                    Button button = (Button) this.this$0._$_findCachedViewById(C2723R.C2726id.btnCheckOut);
                    Intrinsics.checkExpressionValueIsNotNull(button, "btnCheckOut");
                    button.setClickable(true);
                    Button button2 = (Button) this.this$0._$_findCachedViewById(C2723R.C2726id.btnCheckOut);
                    Intrinsics.checkExpressionValueIsNotNull(button2, "btnCheckOut");
                    button2.setAlpha(1.0f);
                }
            }
        }
        ManageBranchPrefActivity.access$getManageBranchListAdapter$p(this.this$0).setBranchListData(this.this$0.branchList);
    }
}
