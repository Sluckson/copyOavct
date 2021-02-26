package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class HeaderToPaidReviewBinding extends ViewDataBinding {
    @NonNull
    public final TextView tvAmount;
    @NonNull
    public final TextView tvCount;
    @NonNull
    public final View viewSeparator2;

    protected HeaderToPaidReviewBinding(Object obj, View view, int i, TextView textView, TextView textView2, View view2) {
        super(obj, view, i);
        this.tvAmount = textView;
        this.tvCount = textView2;
        this.viewSeparator2 = view2;
    }

    @NonNull
    public static HeaderToPaidReviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HeaderToPaidReviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HeaderToPaidReviewBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.header_to_paid_review, viewGroup, z, obj);
    }

    @NonNull
    public static HeaderToPaidReviewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HeaderToPaidReviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HeaderToPaidReviewBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.header_to_paid_review, (ViewGroup) null, false, obj);
    }

    public static HeaderToPaidReviewBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HeaderToPaidReviewBinding bind(@NonNull View view, @Nullable Object obj) {
        return (HeaderToPaidReviewBinding) bind(obj, view, C2723R.C2728layout.header_to_paid_review);
    }
}
