package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class RowItemManageBranchPrefHeaderBinding extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout clEmptyView;
    @NonNull
    public final View emptyView;
    @NonNull
    public final EditText etBranchSearch;
    @NonNull
    public final ImageView ivBranchClear;
    @NonNull
    public final TextView lblSelectBranch;
    @NonNull
    public final RelativeLayout rlBranchSearch;
    @NonNull
    public final LinearLayout searchSection;
    @NonNull
    public final View viewHeader;

    protected RowItemManageBranchPrefHeaderBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, View view2, EditText editText, ImageView imageView, TextView textView, RelativeLayout relativeLayout, LinearLayout linearLayout, View view3) {
        super(obj, view, i);
        this.clEmptyView = constraintLayout;
        this.emptyView = view2;
        this.etBranchSearch = editText;
        this.ivBranchClear = imageView;
        this.lblSelectBranch = textView;
        this.rlBranchSearch = relativeLayout;
        this.searchSection = linearLayout;
        this.viewHeader = view3;
    }

    @NonNull
    public static RowItemManageBranchPrefHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemManageBranchPrefHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemManageBranchPrefHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_manage_branch_pref_header, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemManageBranchPrefHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemManageBranchPrefHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemManageBranchPrefHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_manage_branch_pref_header, (ViewGroup) null, false, obj);
    }

    public static RowItemManageBranchPrefHeaderBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemManageBranchPrefHeaderBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemManageBranchPrefHeaderBinding) bind(obj, view, C2723R.C2728layout.row_item_manage_branch_pref_header);
    }
}
