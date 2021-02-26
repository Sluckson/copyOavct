package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;

public abstract class FragmentToBePaidConfirmationBinding extends ViewDataBinding {
    @NonNull
    public final Button btnMakeAnotherPayment;
    @NonNull
    public final ImageView ivCheck;
    @NonNull
    public final LinearLayout llPartiallyPaid;
    @NonNull
    public final LinearLayout llPaymentInfo;
    @NonNull
    public final RelativeLayout rlHeader;
    @NonNull
    public final RecyclerView rvConfirmVehicle;
    @NonNull
    public final RecyclerView rvFailureVehicle;
    @NonNull
    public final ScrollView svContainer;
    @NonNull
    public final TextView tvErrorMessage;
    @NonNull
    public final TextView tvItemPaid;
    @NonNull
    public final TextView tvItemToPaid;
    @NonNull
    public final TextView tvPartialInfo;
    @NonNull
    public final TextView tvPaymentMethod;
    @NonNull
    public final TextView tvThankYou;
    @NonNull
    public final TextView tvTotalAmount;
    @NonNull
    public final TextView tvTransportText;
    @NonNull
    public final TextView tvViewAll;
    @NonNull
    public final TextView tvViewAllFailure;
    @NonNull
    public final View viewSeparator1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected FragmentToBePaidConfirmationBinding(Object obj, View view, int i, Button button, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout, RecyclerView recyclerView, RecyclerView recyclerView2, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, View view2) {
        super(obj, view, i);
        this.btnMakeAnotherPayment = button;
        this.ivCheck = imageView;
        this.llPartiallyPaid = linearLayout;
        this.llPaymentInfo = linearLayout2;
        this.rlHeader = relativeLayout;
        this.rvConfirmVehicle = recyclerView;
        this.rvFailureVehicle = recyclerView2;
        this.svContainer = scrollView;
        this.tvErrorMessage = textView;
        this.tvItemPaid = textView2;
        this.tvItemToPaid = textView3;
        this.tvPartialInfo = textView4;
        this.tvPaymentMethod = textView5;
        this.tvThankYou = textView6;
        this.tvTotalAmount = textView7;
        this.tvTransportText = textView8;
        this.tvViewAll = textView9;
        this.tvViewAllFailure = textView10;
        this.viewSeparator1 = view2;
    }

    @NonNull
    public static FragmentToBePaidConfirmationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentToBePaidConfirmationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentToBePaidConfirmationBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_to_be_paid_confirmation, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentToBePaidConfirmationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentToBePaidConfirmationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentToBePaidConfirmationBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_to_be_paid_confirmation, (ViewGroup) null, false, obj);
    }

    public static FragmentToBePaidConfirmationBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentToBePaidConfirmationBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentToBePaidConfirmationBinding) bind(obj, view, C2723R.C2728layout.fragment_to_be_paid_confirmation);
    }
}
