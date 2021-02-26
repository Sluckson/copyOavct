package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.iaai.android.C2723R;

public abstract class ActivityBdtAuctionMainBinding extends ViewDataBinding {
    @NonNull
    public final Toolbar auctionToolbar;
    @NonNull
    public final FrameLayout fragmentContent;
    @NonNull
    public final LinearLayout frameLayout;
    @NonNull
    public final View layoutBorderLineDate;
    @NonNull
    public final DrawerLayout navDrawer;
    @NonNull
    public final NavigationView navView;

    protected ActivityBdtAuctionMainBinding(Object obj, View view, int i, Toolbar toolbar, FrameLayout frameLayout2, LinearLayout linearLayout, View view2, DrawerLayout drawerLayout, NavigationView navigationView) {
        super(obj, view, i);
        this.auctionToolbar = toolbar;
        this.fragmentContent = frameLayout2;
        this.frameLayout = linearLayout;
        this.layoutBorderLineDate = view2;
        this.navDrawer = drawerLayout;
        this.navView = navigationView;
    }

    @NonNull
    public static ActivityBdtAuctionMainBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityBdtAuctionMainBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityBdtAuctionMainBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_bdt_auction_main, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityBdtAuctionMainBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityBdtAuctionMainBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityBdtAuctionMainBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_bdt_auction_main, (ViewGroup) null, false, obj);
    }

    public static ActivityBdtAuctionMainBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBdtAuctionMainBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityBdtAuctionMainBinding) bind(obj, view, C2723R.C2728layout.activity_bdt_auction_main);
    }
}
