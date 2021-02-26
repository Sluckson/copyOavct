package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.account.MyAccountViewModel;

public abstract class ActivityBdtMyAccountLayoutBinding extends ViewDataBinding {
    @NonNull
    public final Toolbar auctionToolbar;
    @Bindable
    protected MyAccountViewModel mViewModel;
    @NonNull
    public final DrawerLayout navDrawer;
    @NonNull
    public final NavigationView navView;

    public abstract void setViewModel(@Nullable MyAccountViewModel myAccountViewModel);

    protected ActivityBdtMyAccountLayoutBinding(Object obj, View view, int i, Toolbar toolbar, DrawerLayout drawerLayout, NavigationView navigationView) {
        super(obj, view, i);
        this.auctionToolbar = toolbar;
        this.navDrawer = drawerLayout;
        this.navView = navigationView;
    }

    @Nullable
    public MyAccountViewModel getViewModel() {
        return this.mViewModel;
    }

    @NonNull
    public static ActivityBdtMyAccountLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityBdtMyAccountLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityBdtMyAccountLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_bdt_my_account_layout, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityBdtMyAccountLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityBdtMyAccountLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityBdtMyAccountLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_bdt_my_account_layout, (ViewGroup) null, false, obj);
    }

    public static ActivityBdtMyAccountLayoutBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBdtMyAccountLayoutBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityBdtMyAccountLayoutBinding) bind(obj, view, C2723R.C2728layout.activity_bdt_my_account_layout);
    }
}
