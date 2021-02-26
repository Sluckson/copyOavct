package com.iaai.android.bdt.feature.productDetail.reports;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.Constants_MVVM;
import dagger.android.AndroidInjection;
import java.util.Arrays;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0012H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/reports/BDTPremiumVehicleReportActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "viewModel", "Lcom/iaai/android/bdt/feature/productDetail/reports/PremiunVehicleReportViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "closePVR", "", "fetchPVRReport", "loadWebView", "html", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showLoadingIndicator", "loading", "", "subscribeToViewModel", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTPremiumVehicleReportActivity.kt */
public final class BDTPremiumVehicleReportActivity extends BaseActivity {
    private HashMap _$_findViewCache;
    @Inject
    @NotNull
    public SessionManager sessionManager;
    private PremiunVehicleReportViewModel viewModel;
    @Inject
    @NotNull
    public ViewModelProvider.Factory viewModelFactory;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @NotNull
    public final ViewModelProvider.Factory getViewModelFactory() {
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return factory;
    }

    public final void setViewModelFactory(@NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkParameterIsNotNull(factory, "<set-?>");
        this.viewModelFactory = factory;
    }

    @NotNull
    public final SessionManager getSessionManager() {
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        return sessionManager2;
    }

    public final void setSessionManager(@NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(sessionManager2, "<set-?>");
        this.sessionManager = sessionManager2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_premium_vehicle_report_layout);
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.pvrToolbar));
        FragmentActivity fragmentActivity = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(PremiunVehicleReportViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…ortViewModel::class.java)");
        this.viewModel = (PremiunVehicleReportViewModel) viewModel2;
        fetchPVRReport();
        closePVR();
    }

    private final void fetchPVRReport() {
        String stringExtra = getIntent().getStringExtra(Constants_MVVM.EXTRA_PVR_URL);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[2];
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        objArr[0] = sessionManager2.getCurrentSessionUsername();
        SessionManager sessionManager3 = this.sessionManager;
        if (sessionManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        objArr[1] = sessionManager3.getCurrentSessionPassword();
        String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        PremiunVehicleReportViewModel premiunVehicleReportViewModel = this.viewModel;
        if (premiunVehicleReportViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        Intrinsics.checkExpressionValueIsNotNull(stringExtra, "url");
        premiunVehicleReportViewModel.getPremiumVehicleReport(stringExtra, format);
        subscribeToViewModel();
    }

    private final void closePVR() {
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.imgPremiumReport)).setOnClickListener(new BDTPremiumVehicleReportActivity$closePVR$1(this));
    }

    private final void subscribeToViewModel() {
        PremiunVehicleReportViewModel premiunVehicleReportViewModel = this.viewModel;
        if (premiunVehicleReportViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        premiunVehicleReportViewModel.getShowLoading().observe(lifecycleOwner, new BDTPremiumVehicleReportActivity$subscribeToViewModel$1(this));
        PremiunVehicleReportViewModel premiunVehicleReportViewModel2 = this.viewModel;
        if (premiunVehicleReportViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        premiunVehicleReportViewModel2.getPvrReportResultResponse().observe(lifecycleOwner, new BDTPremiumVehicleReportActivity$subscribeToViewModel$2(this));
        PremiunVehicleReportViewModel premiunVehicleReportViewModel3 = this.viewModel;
        if (premiunVehicleReportViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        premiunVehicleReportViewModel3.getPvrReportResultError().observe(lifecycleOwner, new BDTPremiumVehicleReportActivity$subscribeToViewModel$3(this));
    }

    /* access modifiers changed from: private */
    public final void loadWebView(String str) {
        if (str == null) {
            str = "";
        }
        ((WebView) _$_findCachedViewById(C2723R.C2726id.wvPVR)).loadData(str, "text/html", "utf-8");
        WebView webView = (WebView) _$_findCachedViewById(C2723R.C2726id.wvPVR);
        Intrinsics.checkExpressionValueIsNotNull(webView, "wvPVR");
        WebSettings settings = webView.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings, "webSettings");
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setBuiltInZoomControls(true);
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pvr_pbLoading);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "pvr_pbLoading");
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pvr_pbLoading);
        Intrinsics.checkExpressionValueIsNotNull(progressBar2, "pvr_pbLoading");
        progressBar2.setVisibility(8);
    }
}
