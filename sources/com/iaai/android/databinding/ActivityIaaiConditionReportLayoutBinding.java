package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class ActivityIaaiConditionReportLayoutBinding extends ViewDataBinding {
    @NonNull
    public final ImageButton btnPDFNextPage;
    @NonNull
    public final ImageButton btnPDFPreviousPage;
    @NonNull
    public final ProgressBar icPbLoading;
    @NonNull
    public final Toolbar icToolbar;
    @NonNull
    public final ImageButton imgPremiumReport;
    @NonNull
    public final ImageButton imgShareIC;
    @NonNull
    public final LinearLayout llPDFNavigation;
    @NonNull
    public final TextView tvPRToolbarHeader;
    @NonNull
    public final WebView wvIAR;

    protected ActivityIaaiConditionReportLayoutBinding(Object obj, View view, int i, ImageButton imageButton, ImageButton imageButton2, ProgressBar progressBar, Toolbar toolbar, ImageButton imageButton3, ImageButton imageButton4, LinearLayout linearLayout, TextView textView, WebView webView) {
        super(obj, view, i);
        this.btnPDFNextPage = imageButton;
        this.btnPDFPreviousPage = imageButton2;
        this.icPbLoading = progressBar;
        this.icToolbar = toolbar;
        this.imgPremiumReport = imageButton3;
        this.imgShareIC = imageButton4;
        this.llPDFNavigation = linearLayout;
        this.tvPRToolbarHeader = textView;
        this.wvIAR = webView;
    }

    @NonNull
    public static ActivityIaaiConditionReportLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityIaaiConditionReportLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityIaaiConditionReportLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_iaai_condition_report_layout, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityIaaiConditionReportLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityIaaiConditionReportLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityIaaiConditionReportLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_iaai_condition_report_layout, (ViewGroup) null, false, obj);
    }

    public static ActivityIaaiConditionReportLayoutBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityIaaiConditionReportLayoutBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityIaaiConditionReportLayoutBinding) bind(obj, view, C2723R.C2728layout.activity_iaai_condition_report_layout);
    }
}
