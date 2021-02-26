package com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref.ManageBranchListAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ManageBranchListAdapter.kt */
final class ManageBranchListAdapter$ViewHolderHeader$bindHeader$2 implements View.OnClickListener {
    final /* synthetic */ ManageBranchListAdapter.ViewHolderHeader this$0;

    ManageBranchListAdapter$ViewHolderHeader$bindHeader$2(ManageBranchListAdapter.ViewHolderHeader viewHolderHeader) {
        this.this$0 = viewHolderHeader;
    }

    public final void onClick(View view) {
        EditText editText = this.this$0.getBinding().etBranchSearch;
        Intrinsics.checkExpressionValueIsNotNull(editText, "binding.etBranchSearch");
        Editable text = editText.getText();
        Intrinsics.checkExpressionValueIsNotNull(text, "binding.etBranchSearch.text");
        if (text.length() > 0) {
            this.this$0.getBinding().etBranchSearch.setText("");
            EditText editText2 = this.this$0.getBinding().etBranchSearch;
            Intrinsics.checkExpressionValueIsNotNull(editText2, "binding.etBranchSearch");
            editText2.getText().clear();
            ImageView imageView = this.this$0.getBinding().ivBranchClear;
            Intrinsics.checkExpressionValueIsNotNull(imageView, "binding.ivBranchClear");
            imageView.setVisibility(8);
            EditText editText3 = this.this$0.getBinding().etBranchSearch;
            Intrinsics.checkExpressionValueIsNotNull(editText3, "binding.etBranchSearch");
            editText3.setHint(this.this$0.this$0.getMContext().getString(C2723R.string.lbl_select_branch_search_hint));
        }
        this.this$0.this$0.branchPrefClickListener.onBranchClear();
    }
}
