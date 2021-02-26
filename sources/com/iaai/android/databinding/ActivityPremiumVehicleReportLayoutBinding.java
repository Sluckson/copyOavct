package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.productDetail.reports.PremiumVehicleReportModel;

public abstract class ActivityPremiumVehicleReportLayoutBinding extends ViewDataBinding {
    @NonNull
    public final ImageButton imgPremiumReport;
    @Bindable
    protected PremiumVehicleReportModel mReports;
    @NonNull
    public final ProgressBar pvrPbLoading;
    @NonNull
    public final Toolbar pvrToolbar;
    @NonNull
    public final TextView tvPRToolbarHeader;
    @NonNull
    public final WebView wvPVR;

    public abstract void setReports(@Nullable PremiumVehicleReportModel premiumVehicleReportModel);

    protected ActivityPremiumVehicleReportLayoutBinding(Object obj, View view, int i, ImageButton imageButton, ProgressBar progressBar, Toolbar toolbar, TextView textView, WebView webView) {
        super(obj, view, i);
        this.imgPremiumReport = imageButton;
        this.pvrPbLoading = progressBar;
        this.pvrToolbar = toolbar;
        this.tvPRToolbarHeader = textView;
        this.wvPVR = webView;
    }

    @Nullable
    public PremiumVehicleReportModel getReports() {
        return this.mReports;
    }

    @NonNull
    public static ActivityPremiumVehicleReportLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityPremiumVehicleReportLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityPremiumVehicleReportLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_premium_vehicle_report_layout, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityPremiumVehicleReportLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityPremiumVehicleReportLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityPremiumVehicleReportLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_premium_vehicle_report_layout, (ViewGroup) null, false, obj);
    }

    public static ActivityPremiumVehicleReportLayoutBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPremiumVehicleReportLayoutBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityPremiumVehicleReportLayoutBinding) bind(obj, view, C2723R.C2728layout.activity_premium_vehicle_report_layout);
    }
}
