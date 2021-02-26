package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.app.Dialog;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.textfield.TextInputLayout;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import com.iaai.android.bdt.model.savedSearchList.SavedSearchListResponse;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.old.utils.AppUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchFilterFragment.kt */
final class FastSearchFilterFragment$showSaveSearchDialog$1 implements View.OnClickListener {
    final /* synthetic */ View $viewInflated;
    final /* synthetic */ FastSearchFilterFragment this$0;

    FastSearchFilterFragment$showSaveSearchDialog$1(FastSearchFilterFragment fastSearchFilterFragment, View view) {
        this.this$0 = fastSearchFilterFragment;
        this.$viewInflated = view;
    }

    public final void onClick(View view) {
        Resources resources;
        Resources resources2;
        View findViewById = this.$viewInflated.findViewById(C2723R.C2726id.etSaveSearch);
        if (findViewById != null) {
            EditText editText = (EditText) findViewById;
            View findViewById2 = this.$viewInflated.findViewById(C2723R.C2726id.txtSaveSearchLayout);
            if (findViewById2 != null) {
                TextInputLayout textInputLayout = (TextInputLayout) findViewById2;
                this.this$0.saveText = editText.getText().toString();
                boolean z = false;
                textInputLayout.setErrorEnabled(false);
                String str = null;
                if (TextUtils.isEmpty(this.this$0.saveText)) {
                    FragmentActivity activity = this.this$0.getActivity();
                    if (!(activity == null || (resources2 = activity.getResources()) == null)) {
                        str = resources2.getString(C2723R.string.lbl_save_search_error);
                    }
                    textInputLayout.setErrorEnabled(true);
                    textInputLayout.setError(str);
                    return;
                }
                List<SavedSearchListResponse> access$getSearchList$p = this.this$0.searchList;
                if (access$getSearchList$p != null) {
                    for (SavedSearchListResponse saveSearchName : access$getSearchList$p) {
                        String saveSearchName2 = saveSearchName.getSaveSearchName();
                        if (saveSearchName2 == null) {
                            Intrinsics.throwNpe();
                        }
                        if (saveSearchName2 != null) {
                            String obj = StringsKt.trim((CharSequence) saveSearchName2).toString();
                            String access$getSaveText$p = this.this$0.saveText;
                            if (access$getSaveText$p == null) {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                            } else if (StringsKt.equals(obj, StringsKt.trim((CharSequence) access$getSaveText$p).toString(), true)) {
                                z = true;
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                    }
                }
                if (z) {
                    textInputLayout.setErrorEnabled(true);
                    FragmentActivity activity2 = this.this$0.getActivity();
                    if (!(activity2 == null || (resources = activity2.getResources()) == null)) {
                        str = resources.getString(C2723R.string.lbl_save_search_error_duplicate);
                    }
                    textInputLayout.setError(str);
                    return;
                }
                textInputLayout.setErrorEnabled(true);
                textInputLayout.setError("");
                AppUtils.hideSoftkeyBoard(FastSearchFilterFragment.access$getFastSearchFilterActivity$p(this.this$0), view);
                Dialog access$getDialog$p = this.this$0.dialog;
                if (access$getDialog$p != null) {
                    access$getDialog$p.dismiss();
                }
                if (InternetUtil.INSTANCE.isInternetOn()) {
                    this.this$0.loadRefinerResult();
                } else {
                    Context_ExtensionKt.showToast(FastSearchFilterFragment.access$getFastSearchFilterActivity$p(this.this$0), BaseFragment.ErrorType.NO_INTERNET.getValue());
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.google.android.material.textfield.TextInputLayout");
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.EditText");
        }
    }
}
