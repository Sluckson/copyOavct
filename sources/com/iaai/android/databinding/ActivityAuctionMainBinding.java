package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.iaai.android.C2723R;

public abstract class ActivityAuctionMainBinding extends ViewDataBinding {
    @NonNull
    public final Toolbar auctionToolbar;
    @NonNull
    public final LinearLayout frameLayout;
    @NonNull
    public final DrawerLayout navDrawer;
    @NonNull
    public final NavigationView navView;

    protected ActivityAuctionMainBinding(Object obj, View view, int i, Toolbar toolbar, LinearLayout linearLayout, DrawerLayout drawerLayout, NavigationView navigationView) {
        super(obj, view, i);
        this.auctionToolbar = toolbar;
        this.frameLayout = linearLayout;
        this.navDrawer = drawerLayout;
        this.navView = navigationView;
    }

    @NonNull
    public static ActivityAuctionMainBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityAuctionMainBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityAuctionMainBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_auction_main, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityAuctionMainBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityAuctionMainBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityAuctionMainBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_auction_main, (ViewGroup) null, false, obj);
    }

    public static ActivityAuctionMainBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAuctionMainBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityAuctionMainBinding) bind(obj, view, C2723R.C2728layout.activity_auction_main);
    }
}
