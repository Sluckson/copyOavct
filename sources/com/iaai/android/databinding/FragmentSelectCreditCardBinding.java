package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;

public abstract class FragmentSelectCreditCardBinding extends ViewDataBinding {
    @NonNull
    public final Button btnSelectCard;
    @NonNull
    public final RelativeLayout rlAllowanceUsed;
    @NonNull
    public final RelativeLayout rlDailyAllowable;
    @NonNull
    public final RelativeLayout rlRemainingAllowance;
    @NonNull
    public final RecyclerView rvCreditCard;
    @NonNull
    public final View selectCCToolBar;
    @NonNull
    public final TextView tvAllowanceUsed;
    @NonNull
    public final TextView tvAllowanceUsedValue;
    @NonNull
    public final TextView tvCashDiscount;
    @NonNull
    public final TextView tvCreditCardOptions;
    @NonNull
    public final TextView tvDailyAllowable;
    @NonNull
    public final TextView tvDailyAllowableValue;
    @NonNull
    public final TextView tvRemainingAllowance;
    @NonNull
    public final TextView tvRemainingAllowanceValue;
    @NonNull
    public final View view1;
    @NonNull
    public final View view2;
    @NonNull
    public final View view3;
    @NonNull
    public final View view4;
    @NonNull
    public final View view5;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected FragmentSelectCreditCardBinding(Object obj, View view, int i, Button button, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RecyclerView recyclerView, View view6, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, View view7, View view8, View view9, View view10, View view11) {
        super(obj, view, i);
        this.btnSelectCard = button;
        this.rlAllowanceUsed = relativeLayout;
        this.rlDailyAllowable = relativeLayout2;
        this.rlRemainingAllowance = relativeLayout3;
        this.rvCreditCard = recyclerView;
        this.selectCCToolBar = view6;
        this.tvAllowanceUsed = textView;
        this.tvAllowanceUsedValue = textView2;
        this.tvCashDiscount = textView3;
        this.tvCreditCardOptions = textView4;
        this.tvDailyAllowable = textView5;
        this.tvDailyAllowableValue = textView6;
        this.tvRemainingAllowance = textView7;
        this.tvRemainingAllowanceValue = textView8;
        this.view1 = view7;
        this.view2 = view8;
        this.view3 = view9;
        this.view4 = view10;
        this.view5 = view11;
    }

    @NonNull
    public static FragmentSelectCreditCardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentSelectCreditCardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentSelectCreditCardBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_select_credit_card, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentSelectCreditCardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentSelectCreditCardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentSelectCreditCardBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_select_credit_card, (ViewGroup) null, false, obj);
    }

    public static FragmentSelectCreditCardBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSelectCreditCardBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentSelectCreditCardBinding) bind(obj, view, C2723R.C2728layout.fragment_select_credit_card);
    }
}
