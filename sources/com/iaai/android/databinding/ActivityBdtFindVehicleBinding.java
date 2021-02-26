package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.iaai.android.C2723R;

public abstract class ActivityBdtFindVehicleBinding extends ViewDataBinding {
    @NonNull
    public final Toolbar auctionToolbar;
    @NonNull
    public final Button btnCreateOrSignIn;
    @NonNull
    public final ConstraintLayout clFlagConatiner;
    @NonNull
    public final FrameLayout frSignInCreateAccount;
    @NonNull
    public final FrameLayout fragmentContent;
    @NonNull
    public final LinearLayout frameLayout;
    @NonNull
    public final ImageView imgFlag;
    @NonNull
    public final ImageView ivIaaAds;
    @NonNull
    public final View layoutBorderLineDate;
    @NonNull
    public final LinearLayout llAds;
    @NonNull
    public final LinearLayout llAnnouncement;
    @NonNull
    public final View llDashBoardLayout;
    @NonNull
    public final LinearLayout llRecommendedVehicleLayout;
    @NonNull
    public final DrawerLayout navDrawer;
    @NonNull
    public final NavigationView navView;
    @NonNull
    public final TextView tvAnnouncementMessage;
    @NonNull
    public final TextView tvFlaglabel;
    @NonNull
    public final TextView tvGethelp;
    @NonNull
    public final View vwAnnouncementBorder;
    @NonNull
    public final View vwSignInBorder;
    @NonNull
    public final WebView webViewAds;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ActivityBdtFindVehicleBinding(Object obj, View view, int i, Toolbar toolbar, Button button, ConstraintLayout constraintLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, View view2, LinearLayout linearLayout2, LinearLayout linearLayout3, View view3, LinearLayout linearLayout4, DrawerLayout drawerLayout, NavigationView navigationView, TextView textView, TextView textView2, TextView textView3, View view4, View view5, WebView webView) {
        super(obj, view, i);
        this.auctionToolbar = toolbar;
        this.btnCreateOrSignIn = button;
        this.clFlagConatiner = constraintLayout;
        this.frSignInCreateAccount = frameLayout2;
        this.fragmentContent = frameLayout3;
        this.frameLayout = linearLayout;
        this.imgFlag = imageView;
        this.ivIaaAds = imageView2;
        this.layoutBorderLineDate = view2;
        this.llAds = linearLayout2;
        this.llAnnouncement = linearLayout3;
        this.llDashBoardLayout = view3;
        this.llRecommendedVehicleLayout = linearLayout4;
        this.navDrawer = drawerLayout;
        this.navView = navigationView;
        this.tvAnnouncementMessage = textView;
        this.tvFlaglabel = textView2;
        this.tvGethelp = textView3;
        this.vwAnnouncementBorder = view4;
        this.vwSignInBorder = view5;
        this.webViewAds = webView;
    }

    @NonNull
    public static ActivityBdtFindVehicleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityBdtFindVehicleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityBdtFindVehicleBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_bdt_find_vehicle, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityBdtFindVehicleBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityBdtFindVehicleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityBdtFindVehicleBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_bdt_find_vehicle, (ViewGroup) null, false, obj);
    }

    public static ActivityBdtFindVehicleBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBdtFindVehicleBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityBdtFindVehicleBinding) bind(obj, view, C2723R.C2728layout.activity_bdt_find_vehicle);
    }
}
