package com.iaai.android.bdt.feature.productDetail.reports;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.print.PdfPrint;
import android.print.PrintAttributes;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.google.logging.type.LogSeverity;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.AppUtils;
import com.lowagie.text.xml.xmp.PdfSchema;
import dagger.android.AndroidInjection;
import java.io.File;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\u001f B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J+\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\rH\u0002J\b\u0010\u001d\u001a\u00020\rH\u0002J\b\u0010\u001e\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006!"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/reports/IAAConditionReportActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "reportPath", "", "subjectLineText", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "checkWriteStoragePermission", "", "closeICReport", "loadWebView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "savePDF", "shareIAReport", "sharePDF", "updatePDFNavigation", "IJavascriptHandler", "PdfWebViewClient", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: IAAConditionReportActivity.kt */
public final class IAAConditionReportActivity extends BaseActivity {
    private HashMap _$_findViewCache;
    private String reportPath = "";
    private String subjectLineText = "";
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

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_iaai_condition_report_layout);
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.icToolbar));
        String stringExtra = getIntent().getStringExtra(Constants_MVVM.EXTRA_IC_URL);
        Intrinsics.checkExpressionValueIsNotNull(stringExtra, "intent.getStringExtra(Constants_MVVM.EXTRA_IC_URL)");
        this.reportPath = stringExtra;
        loadWebView();
        closeICReport();
        updatePDFNavigation();
    }

    /* access modifiers changed from: private */
    public final void checkWriteStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            shareIAReport();
        } else if (Build.VERSION.SDK_INT >= 23) {
            requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3);
        }
    }

    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        if (i == 3) {
            if (!(!(iArr.length == 0)) || iArr[0] != 0) {
                AppUtils.showEnablePermissionMessage(true, this, (Fragment) null, "android.permission.WRITE_EXTERNAL_STORAGE", 3);
            } else {
                shareIAReport();
            }
        }
    }

    private final void shareIAReport() {
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.ic_pbLoading);
        Intrinsics.checkExpressionValueIsNotNull(progressBar, "ic_pbLoading");
        progressBar.setVisibility(0);
        savePDF();
    }

    private final void closeICReport() {
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.imgPremiumReport)).setOnClickListener(new IAAConditionReportActivity$closeICReport$1(this));
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.imgShareIC)).setOnClickListener(new IAAConditionReportActivity$closeICReport$2(this));
    }

    private final void loadWebView() {
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.ic_pbLoading);
        Intrinsics.checkExpressionValueIsNotNull(progressBar, "ic_pbLoading");
        progressBar.setVisibility(0);
        WebView webView = (WebView) _$_findCachedViewById(C2723R.C2726id.wvIAR);
        Intrinsics.checkExpressionValueIsNotNull(webView, "wvIAR");
        WebSettings settings = webView.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings, "settings");
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAppCacheEnabled(false);
        settings.setCacheMode(2);
        WebView webView2 = (WebView) _$_findCachedViewById(C2723R.C2726id.wvIAR);
        Intrinsics.checkExpressionValueIsNotNull(webView2, "wvIAR");
        webView2.setWebViewClient(new PdfWebViewClient());
        ((WebView) _$_findCachedViewById(C2723R.C2726id.wvIAR)).clearHistory();
        ((WebView) _$_findCachedViewById(C2723R.C2726id.wvIAR)).clearFormData();
        ((WebView) _$_findCachedViewById(C2723R.C2726id.wvIAR)).clearCache(true);
        ((WebView) _$_findCachedViewById(C2723R.C2726id.wvIAR)).addJavascriptInterface(new IJavascriptHandler(this, this), "jshandler");
        Uri parse = Uri.parse(this.reportPath);
        WebView webView3 = (WebView) _$_findCachedViewById(C2723R.C2726id.wvIAR);
        StringBuilder sb = new StringBuilder();
        sb.append("file:///android_asset/pdfviewer/index.html?file=");
        if (parse == null) {
            Intrinsics.throwNpe();
        }
        sb.append(parse);
        webView3.loadUrl(sb.toString());
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/reports/IAAConditionReportActivity$PdfWebViewClient;", "Landroid/webkit/WebViewClient;", "(Lcom/iaai/android/bdt/feature/productDetail/reports/IAAConditionReportActivity;)V", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: IAAConditionReportActivity.kt */
    private final class PdfWebViewClient extends WebViewClient {
        public PdfWebViewClient() {
        }

        public void onPageFinished(@NotNull WebView webView, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(webView, "view");
            Intrinsics.checkParameterIsNotNull(str, "url");
            super.onPageFinished(webView, str);
            ProgressBar progressBar = (ProgressBar) IAAConditionReportActivity.this._$_findCachedViewById(C2723R.C2726id.ic_pbLoading);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "ic_pbLoading");
            progressBar.setVisibility(8);
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/reports/IAAConditionReportActivity$IJavascriptHandler;", "", "activity", "Landroid/app/Activity;", "(Lcom/iaai/android/bdt/feature/productDetail/reports/IAAConditionReportActivity;Landroid/app/Activity;)V", "getActivity$app_productionRelease", "()Landroid/app/Activity;", "setActivity$app_productionRelease", "(Landroid/app/Activity;)V", "sendTotalNoOfPage", "", "noofpage", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: IAAConditionReportActivity.kt */
    private final class IJavascriptHandler {
        @NotNull
        private Activity activity;
        final /* synthetic */ IAAConditionReportActivity this$0;

        public IJavascriptHandler(@NotNull IAAConditionReportActivity iAAConditionReportActivity, Activity activity2) {
            Intrinsics.checkParameterIsNotNull(activity2, "activity");
            this.this$0 = iAAConditionReportActivity;
            this.activity = activity2;
        }

        @NotNull
        public final Activity getActivity$app_productionRelease() {
            return this.activity;
        }

        public final void setActivity$app_productionRelease(@NotNull Activity activity2) {
            Intrinsics.checkParameterIsNotNull(activity2, "<set-?>");
            this.activity = activity2;
        }

        @JavascriptInterface
        public final void sendTotalNoOfPage(int i) {
            Log.d("IJava-->", "noofpage--->" + i);
            this.activity.runOnUiThread(new C2756x63779b6f(this, i));
        }
    }

    private final void savePDF() {
        PrintAttributes build = new PrintAttributes.Builder().setMediaSize(PrintAttributes.MediaSize.ISO_A4).setResolution(new PrintAttributes.Resolution(PdfSchema.DEFAULT_XPATH_ID, PdfSchema.DEFAULT_XPATH_ID, LogSeverity.CRITICAL_VALUE, LogSeverity.CRITICAL_VALUE)).setMinMargins(PrintAttributes.Margins.NO_MARGINS).build();
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkExpressionValueIsNotNull(externalStoragePublicDirectory, "root");
        sb.append(externalStoragePublicDirectory.getAbsolutePath());
        sb.append("/IAABuyer");
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "IAACondition.pdf");
        if (file2.exists()) {
            file2.delete();
        }
        new PdfPrint(build, new IAAConditionReportActivity$savePDF$pdfPrint$1(this)).print(((WebView) _$_findCachedViewById(C2723R.C2726id.wvIAR)).createPrintDocumentAdapter("IAAConditionReport"), file, "IAACondition.pdf");
    }

    /* access modifiers changed from: private */
    public final void sharePDF() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        StringBuilder sb = new StringBuilder();
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        Intrinsics.checkExpressionValueIsNotNull(externalStorageDirectory, "Environment.getExternalStorageDirectory()");
        sb.append(externalStorageDirectory.getAbsolutePath());
        sb.append("/IAABuyer");
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "IAACondition.pdf");
        intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(this, getPackageName() + ".provider", file2));
        intent.putExtra("android.intent.extra.SUBJECT", this.subjectLineText);
        intent.setType("application/pdf");
        intent.addFlags(1);
        startActivity(Intent.createChooser(intent, getString(C2723R.string.lbl_send)));
    }

    private final void updatePDFNavigation() {
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.btnPDFNextPage)).setOnClickListener(new IAAConditionReportActivity$updatePDFNavigation$1(this));
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.btnPDFPreviousPage)).setOnClickListener(new IAAConditionReportActivity$updatePDFNavigation$2(this));
    }
}
