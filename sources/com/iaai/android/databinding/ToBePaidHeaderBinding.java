package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class ToBePaidHeaderBinding extends ViewDataBinding {
    @NonNull
    public final ImageView imgFilter;
    @NonNull
    public final ImageView ivAFCMsg;
    @NonNull
    public final ImageView ivSelectPayment;
    @NonNull
    public final LinearLayout llSelectAll;
    @NonNull
    public final LinearLayout llSort;
    @NonNull
    public final RelativeLayout rlPaymentMethod;
    @NonNull
    public final RelativeLayout rlStep2;
    @NonNull
    public final TextView tvAFCMsg;
    @NonNull
    public final TextView tvChangePayment;
    @NonNull
    public final TextView tvCountAndDue;
    @NonNull
    public final TextView tvFilter;
    @NonNull
    public final TextView tvPaymentMethodTitle;
    @NonNull
    public final TextView tvPaymentMode;
    @NonNull
    public final TextView tvPaymentMsg;
    @NonNull
    public final TextView tvSelectAll;
    @NonNull
    public final TextView tvSelectMsg;
    @NonNull
    public final TextView tvSelectPayment;
    @NonNull
    public final TextView tvSort;
    @NonNull
    public final TextView tvSortValue;
    @NonNull
    public final TextView tvStep1;
    @NonNull
    public final TextView tvStep2;
    @NonNull
    public final TextView tvToBePaid;
    @NonNull
    public final View viewSeparator1;
    @NonNull
    public final View viewSeparator2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ToBePaidHeaderBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, View view2, View view3) {
        super(obj, view, i);
        this.imgFilter = imageView;
        this.ivAFCMsg = imageView2;
        this.ivSelectPayment = imageView3;
        this.llSelectAll = linearLayout;
        this.llSort = linearLayout2;
        this.rlPaymentMethod = relativeLayout;
        this.rlStep2 = relativeLayout2;
        this.tvAFCMsg = textView;
        this.tvChangePayment = textView2;
        this.tvCountAndDue = textView3;
        this.tvFilter = textView4;
        this.tvPaymentMethodTitle = textView5;
        this.tvPaymentMode = textView6;
        this.tvPaymentMsg = textView7;
        this.tvSelectAll = textView8;
        this.tvSelectMsg = textView9;
        this.tvSelectPayment = textView10;
        this.tvSort = textView11;
        this.tvSortValue = textView12;
        this.tvStep1 = textView13;
        this.tvStep2 = textView14;
        this.tvToBePaid = textView15;
        this.viewSeparator1 = view2;
        this.viewSeparator2 = view3;
    }

    @NonNull
    public static ToBePaidHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ToBePaidHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ToBePaidHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.to_be_paid_header, viewGroup, z, obj);
    }

    @NonNull
    public static ToBePaidHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ToBePaidHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ToBePaidHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.to_be_paid_header, (ViewGroup) null, false, obj);
    }

    public static ToBePaidHeaderBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ToBePaidHeaderBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ToBePaidHeaderBinding) bind(obj, view, C2723R.C2728layout.to_be_paid_header);
    }
}
