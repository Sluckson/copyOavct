package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.iaai.android.C2723R;

public abstract class ActivityFastSearchFilterBinding extends ViewDataBinding {
    @NonNull
    public final Toolbar auctionToolbar;
    @NonNull
    public final FrameLayout fragmentContent;
    @NonNull
    public final LinearLayout frameLayout;
    @NonNull
    public final ImageView imgClose;
    @NonNull
    public final View layoutBorderLineDate;
    @NonNull
    public final DrawerLayout navDrawer;
    @NonNull
    public final NavigationView navView;
    @NonNull
    public final TextView tvClearFastSearch;
    @NonNull
    public final TextView tvTitleFilter;

    protected ActivityFastSearchFilterBinding(Object obj, View view, int i, Toolbar toolbar, FrameLayout frameLayout2, LinearLayout linearLayout, ImageView imageView, View view2, DrawerLayout drawerLayout, NavigationView navigationView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.auctionToolbar = toolbar;
        this.fragmentContent = frameLayout2;
        this.frameLayout = linearLayout;
        this.imgClose = imageView;
        this.layoutBorderLineDate = view2;
        this.navDrawer = drawerLayout;
        this.navView = navigationView;
        this.tvClearFastSearch = textView;
        this.tvTitleFilter = textView2;
    }

    @NonNull
    public static ActivityFastSearchFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityFastSearchFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityFastSearchFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_fast_search_filter, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityFastSearchFilterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityFastSearchFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityFastSearchFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_fast_search_filter, (ViewGroup) null, false, obj);
    }

    public static ActivityFastSearchFilterBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityFastSearchFilterBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityFastSearchFilterBinding) bind(obj, view, C2723R.C2728layout.activity_fast_search_filter);
    }
}
