package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.iaai.android.C2723R;

public abstract class AcivityBdtMyAccountBinding extends ViewDataBinding {
    @NonNull
    public final LinearLayout frameLayout;
    @NonNull
    public final View layoutBorderLineDate;
    @NonNull
    public final TextView lblBuyerId;
    @NonNull
    public final LinearLayout llBuyerIdInfo;
    @NonNull
    public final ProgressBar pbMyAccount;
    @NonNull
    public final LinearLayout relativeLayoutUser;
    @NonNull
    public final SwipeRefreshLayout swipeContainer;
    @NonNull
    public final TabLayout tlMyAccount;
    @NonNull
    public final TextView tvBuyerIdInfo;
    @NonNull
    public final TextView tvLogout;
    @NonNull
    public final TextView tvUserName;
    @NonNull
    public final ImageView userPicture;
    @NonNull
    public final ViewPager viewPager2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected AcivityBdtMyAccountBinding(Object obj, View view, int i, LinearLayout linearLayout, View view2, TextView textView, LinearLayout linearLayout2, ProgressBar progressBar, LinearLayout linearLayout3, SwipeRefreshLayout swipeRefreshLayout, TabLayout tabLayout, TextView textView2, TextView textView3, TextView textView4, ImageView imageView, ViewPager viewPager) {
        super(obj, view, i);
        this.frameLayout = linearLayout;
        this.layoutBorderLineDate = view2;
        this.lblBuyerId = textView;
        this.llBuyerIdInfo = linearLayout2;
        this.pbMyAccount = progressBar;
        this.relativeLayoutUser = linearLayout3;
        this.swipeContainer = swipeRefreshLayout;
        this.tlMyAccount = tabLayout;
        this.tvBuyerIdInfo = textView2;
        this.tvLogout = textView3;
        this.tvUserName = textView4;
        this.userPicture = imageView;
        this.viewPager2 = viewPager;
    }

    @NonNull
    public static AcivityBdtMyAccountBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcivityBdtMyAccountBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AcivityBdtMyAccountBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.acivity_bdt_my_account, viewGroup, z, obj);
    }

    @NonNull
    public static AcivityBdtMyAccountBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcivityBdtMyAccountBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AcivityBdtMyAccountBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.acivity_bdt_my_account, (ViewGroup) null, false, obj);
    }

    public static AcivityBdtMyAccountBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AcivityBdtMyAccountBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AcivityBdtMyAccountBinding) bind(obj, view, C2723R.C2728layout.acivity_bdt_my_account);
    }
}
