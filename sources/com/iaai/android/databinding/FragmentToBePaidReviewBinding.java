package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;

public abstract class FragmentToBePaidReviewBinding extends ViewDataBinding {
    @NonNull
    public final Button btnSubmit;
    @NonNull
    public final ProgressBar pbToBePaidReview;
    @NonNull
    public final RelativeLayout rlHeader;
    @NonNull
    public final RecyclerView rvSelectedVehicle;
    @NonNull
    public final TextView tvAmount;
    @NonNull
    public final TextView tvCDFAmount;
    @NonNull
    public final TextView tvCount;
    @NonNull
    public final TextView tvTotalLabel;
    @NonNull
    public final View viewSeparator1;
    @NonNull
    public final View viewSeparator2;

    protected FragmentToBePaidReviewBinding(Object obj, View view, int i, Button button, ProgressBar progressBar, RelativeLayout relativeLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view2, View view3) {
        super(obj, view, i);
        this.btnSubmit = button;
        this.pbToBePaidReview = progressBar;
        this.rlHeader = relativeLayout;
        this.rvSelectedVehicle = recyclerView;
        this.tvAmount = textView;
        this.tvCDFAmount = textView2;
        this.tvCount = textView3;
        this.tvTotalLabel = textView4;
        this.viewSeparator1 = view2;
        this.viewSeparator2 = view3;
    }

    @NonNull
    public static FragmentToBePaidReviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentToBePaidReviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentToBePaidReviewBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_to_be_paid_review, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentToBePaidReviewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentToBePaidReviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentToBePaidReviewBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_to_be_paid_review, (ViewGroup) null, false, obj);
    }

    public static FragmentToBePaidReviewBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentToBePaidReviewBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentToBePaidReviewBinding) bind(obj, view, C2723R.C2728layout.fragment_to_be_paid_review);
    }
}
