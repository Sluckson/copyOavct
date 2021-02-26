package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class RowListItemManageBranchPrefBinding extends ViewDataBinding {
    @NonNull
    public final TextView branchSubTitle;
    @NonNull
    public final TextView branchTitle;
    @NonNull
    public final ConstraintLayout clBranchListContainer;
    @NonNull
    public final ImageView rowItemRadioBtn;

    protected RowListItemManageBranchPrefBinding(Object obj, View view, int i, TextView textView, TextView textView2, ConstraintLayout constraintLayout, ImageView imageView) {
        super(obj, view, i);
        this.branchSubTitle = textView;
        this.branchTitle = textView2;
        this.clBranchListContainer = constraintLayout;
        this.rowItemRadioBtn = imageView;
    }

    @NonNull
    public static RowListItemManageBranchPrefBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowListItemManageBranchPrefBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowListItemManageBranchPrefBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_list_item_manage_branch_pref, viewGroup, z, obj);
    }

    @NonNull
    public static RowListItemManageBranchPrefBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowListItemManageBranchPrefBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowListItemManageBranchPrefBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_list_item_manage_branch_pref, (ViewGroup) null, false, obj);
    }

    public static RowListItemManageBranchPrefBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowListItemManageBranchPrefBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowListItemManageBranchPrefBinding) bind(obj, view, C2723R.C2728layout.row_list_item_manage_branch_pref);
    }
}
