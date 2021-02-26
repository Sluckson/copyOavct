package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult;

public abstract class RowItemFastSearchRefinerHeaderBinding extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout clEmptyView;
    @NonNull
    public final View emptyView;
    @NonNull
    public final ImageView imgFilter;
    @NonNull
    public final ImageView ivSort;
    @NonNull
    public final ConstraintLayout layoutSortContainer;
    @Bindable
    protected FormattedResult mFormattedResult;
    @NonNull
    public final RelativeLayout rlSearchSelectedRefiner;
    @NonNull
    public final RecyclerView rvSearchSelectedRefiner;
    @NonNull
    public final TextView tvFilterCount;
    @NonNull
    public final TextView tvFilterLabel;
    @NonNull
    public final TextView tvSortLabel;

    public abstract void setFormattedResult(@Nullable FormattedResult formattedResult);

    protected RowItemFastSearchRefinerHeaderBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, View view2, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, RelativeLayout relativeLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.clEmptyView = constraintLayout;
        this.emptyView = view2;
        this.imgFilter = imageView;
        this.ivSort = imageView2;
        this.layoutSortContainer = constraintLayout2;
        this.rlSearchSelectedRefiner = relativeLayout;
        this.rvSearchSelectedRefiner = recyclerView;
        this.tvFilterCount = textView;
        this.tvFilterLabel = textView2;
        this.tvSortLabel = textView3;
    }

    @Nullable
    public FormattedResult getFormattedResult() {
        return this.mFormattedResult;
    }

    @NonNull
    public static RowItemFastSearchRefinerHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemFastSearchRefinerHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemFastSearchRefinerHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_fast_search_refiner_header, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemFastSearchRefinerHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemFastSearchRefinerHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemFastSearchRefinerHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_fast_search_refiner_header, (ViewGroup) null, false, obj);
    }

    public static RowItemFastSearchRefinerHeaderBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemFastSearchRefinerHeaderBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemFastSearchRefinerHeaderBinding) bind(obj, view, C2723R.C2728layout.row_item_fast_search_refiner_header);
    }
}
