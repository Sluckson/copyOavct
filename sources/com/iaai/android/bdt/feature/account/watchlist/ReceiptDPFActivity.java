package com.iaai.android.bdt.feature.account.watchlist;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.ICommand;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.ActivityHelper;
import dagger.android.AndroidInjection;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001@B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010-\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u00010\u000eJ\u0006\u00101\u001a\u000202J\b\u00103\u001a\u000202H\u0002J\u0018\u00104\u001a\u0002022\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\"\u00105\u001a\u0002022\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u00010\u000eH\u0002J \u00107\u001a\u0002022\u0006\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0002J\u0012\u0010:\u001a\u0002022\b\u0010;\u001a\u0004\u0018\u00010<H\u0014J\b\u0010=\u001a\u000202H\u0014J\b\u0010>\u001a\u000202H\u0014J\b\u0010?\u001a\u000202H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u000e\u0010\u0016\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001a\u0010!\u001a\u00020\"X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020(8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006A"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/watchlist/ReceiptDPFActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "isActivityInFront", "", "isPdfDisplay", "()Z", "setPdfDisplay", "(Z)V", "isReceipt", "isVehicleReceipt", "isVehicleReport", "setVehicleReport", "receipt_file_path", "", "getReceipt_file_path", "()Ljava/lang/String;", "setReceipt_file_path", "(Ljava/lang/String;)V", "reportPath", "getReportPath", "setReportPath", "report_title", "salavgeID", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "subject_line_text", "getSubject_line_text", "setSubject_line_text", "viewModel", "Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListViewModel;", "getViewModel", "()Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListViewModel;", "setViewModel", "(Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "createReceiptPDF", "content", "", "fileName", "handleTimeout", "", "initialize", "initializeReportReceiptUI", "loadPDF", "filePath", "loadReceiptStockPDF", "receipttype", "reportTitle", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "subscribeToViewModel", "IJavascriptHandler", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ReceiptDPFActivity.kt */
public final class ReceiptDPFActivity extends BaseActivity {
    private HashMap _$_findViewCache;
    private boolean isActivityInFront;
    private boolean isPdfDisplay;
    /* access modifiers changed from: private */
    public boolean isReceipt;
    private boolean isVehicleReceipt;
    private boolean isVehicleReport;
    @NotNull
    private String receipt_file_path = "";
    @NotNull
    private String reportPath = "";
    /* access modifiers changed from: private */
    public String report_title = "";
    /* access modifiers changed from: private */
    public String salavgeID = "";
    @Inject
    @NotNull
    public SessionManager sessionManager;
    @NotNull
    private String subject_line_text = "";
    @NotNull
    public PreSaleListViewModel viewModel;
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
    public final PreSaleListViewModel getViewModel() {
        PreSaleListViewModel preSaleListViewModel = this.viewModel;
        if (preSaleListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return preSaleListViewModel;
    }

    public final void setViewModel(@NotNull PreSaleListViewModel preSaleListViewModel) {
        Intrinsics.checkParameterIsNotNull(preSaleListViewModel, "<set-?>");
        this.viewModel = preSaleListViewModel;
    }

    public final boolean isPdfDisplay() {
        return this.isPdfDisplay;
    }

    public final void setPdfDisplay(boolean z) {
        this.isPdfDisplay = z;
    }

    public final boolean isVehicleReport() {
        return this.isVehicleReport;
    }

    public final void setVehicleReport(boolean z) {
        this.isVehicleReport = z;
    }

    @NotNull
    public final String getReportPath() {
        return this.reportPath;
    }

    public final void setReportPath(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.reportPath = str;
    }

    @NotNull
    public final String getSubject_line_text() {
        return this.subject_line_text;
    }

    public final void setSubject_line_text(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.subject_line_text = str;
    }

    @NotNull
    public final String getReceipt_file_path() {
        return this.receipt_file_path;
    }

    public final void setReceipt_file_path(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.receipt_file_path = str;
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
        setContentView((int) C2723R.C2728layout.activity_afc_finanace_terms);
        FragmentActivity fragmentActivity = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(PreSaleListViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…istViewModel::class.java)");
        this.viewModel = (PreSaleListViewModel) viewModel2;
        IaaiApplication instance = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
        this.sessionManager = instance.getComponent().sessionManager();
        this.isPdfDisplay = getIntent().getBooleanExtra(Constants.AFC_SELECTION_FOR_DISPLAY, false);
        this.isVehicleReport = getIntent().getBooleanExtra(Constants.VEHICLE_DETAIL_PDF_REPORT, false);
        this.isVehicleReceipt = getIntent().getBooleanExtra("pdf_receipt", false);
        String stringExtra = getIntent().getStringExtra("receipt_email_subject_line");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.subject_line_text = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("report_title");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.report_title = stringExtra2;
        String stringExtra3 = getIntent().getStringExtra("asap_salvage_id");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        this.salavgeID = stringExtra3;
        String stringExtra4 = getIntent().getStringExtra("receipt_type");
        if (stringExtra4 == null) {
            stringExtra4 = "";
        }
        if (this.isVehicleReport) {
            String stringExtra5 = getIntent().getStringExtra(Constants.REPORT_PATH);
            if (stringExtra5 == null) {
                stringExtra5 = "";
            }
            this.reportPath = stringExtra5;
            loadPDF(this.report_title, false, "");
        } else if (this.isVehicleReceipt) {
            this.isReceipt = getIntent().getBooleanExtra(Constants_MVVM.IS_RECEIPT, false);
            StringBuilder sb = new StringBuilder();
            File externalFilesDir = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            String str = null;
            sb.append(externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null);
            sb.append("/IAABuyerApps/");
            sb.append(getString(C2723R.string.stock_receipt_title));
            sb.append("_");
            sb.append(this.report_title);
            sb.append("_");
            sb.append(this.salavgeID);
            sb.append(".pdf");
            this.receipt_file_path = sb.toString();
            if (this.isReceipt) {
                StringBuilder sb2 = new StringBuilder();
                File externalFilesDir2 = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
                if (externalFilesDir2 != null) {
                    str = externalFilesDir2.getAbsolutePath();
                }
                sb2.append(str);
                sb2.append("/IAABuyerApps/");
                sb2.append(getString(C2723R.string.receipt_page_title));
                sb2.append("_");
                sb2.append(this.report_title);
                sb2.append("_");
                sb2.append(this.salavgeID);
                sb2.append(".pdf");
                this.receipt_file_path = sb2.toString();
            }
            if (new File(this.receipt_file_path).exists()) {
                LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.pd_receipt);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout, "pd_receipt");
                linearLayout.setVisibility(8);
                initializeReportReceiptUI(this.report_title, true);
                loadPDF(this.report_title, true, this.receipt_file_path);
                return;
            }
            String stringExtra6 = getIntent().getStringExtra("receipt_url");
            Intrinsics.checkExpressionValueIsNotNull(stringExtra6, "intent.getStringExtra(Constants.RECEIPT_URL)");
            this.reportPath = stringExtra6;
            loadReceiptStockPDF(stringExtra4, this.report_title, this.salavgeID);
        } else {
            initialize();
        }
    }

    private final void loadReceiptStockPDF(String str, String str2, String str3) {
        PreSaleListViewModel preSaleListViewModel = this.viewModel;
        if (preSaleListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        String str4 = null;
        String valueOf = String.valueOf(sessionManager2 != null ? sessionManager2.getCurrentSessionUsername() : null);
        SessionManager sessionManager3 = this.sessionManager;
        if (sessionManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        if (sessionManager3 != null) {
            str4 = sessionManager3.getCurrentSessionPassword();
        }
        preSaleListViewModel.loadReceiptPDF(valueOf, String.valueOf(str4), str2, str, str3);
        subscribeToViewModel();
    }

    private final void subscribeToViewModel() {
        initializeReportReceiptUI(this.report_title, true);
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.pd_receipt);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "pd_receipt");
        linearLayout.setVisibility(0);
        PreSaleListViewModel preSaleListViewModel = this.viewModel;
        if (preSaleListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        preSaleListViewModel.getReceiptPDFResult().observe(lifecycleOwner, new ReceiptDPFActivity$subscribeToViewModel$1(this));
        PreSaleListViewModel preSaleListViewModel2 = this.viewModel;
        if (preSaleListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        preSaleListViewModel2.getReceiptPDFResultError().observe(lifecycleOwner, new ReceiptDPFActivity$subscribeToViewModel$2(this));
    }

    public final boolean createReceiptPDF(@Nullable byte[] bArr, @Nullable String str) {
        try {
            File externalFilesDir = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(Intrinsics.stringPlus(externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null, "/IAABuyerApps"));
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str);
            if (file2.exists()) {
                file2.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            Log.d("DownloadManager", "Error: " + e);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void loadPDF(String str, boolean z, String str2) {
        Uri uri;
        if (!z) {
            initializeReportReceiptUI(str, z);
        }
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.bdtShare)).setOnClickListener(new ReceiptDPFActivity$loadPDF$1(this, z, str2, str));
        WebView webView = (WebView) _$_findCachedViewById(C2723R.C2726id.receipt_webview);
        Intrinsics.checkExpressionValueIsNotNull(webView, "receipt_webview");
        WebSettings settings = webView.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings, "settings");
        settings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(true);
            settings.setAllowUniversalAccessFromFileURLs(true);
        }
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAppCacheEnabled(false);
        settings.setCacheMode(2);
        ((WebView) _$_findCachedViewById(C2723R.C2726id.receipt_webview)).clearHistory();
        ((WebView) _$_findCachedViewById(C2723R.C2726id.receipt_webview)).clearFormData();
        ((WebView) _$_findCachedViewById(C2723R.C2726id.receipt_webview)).clearCache(true);
        ((WebView) _$_findCachedViewById(C2723R.C2726id.receipt_webview)).addJavascriptInterface(new IJavascriptHandler(this, this), "jshandler");
        Uri uri2 = null;
        if (z) {
            uri = Uri.parse(str2);
        } else {
            uri = Uri.parse(this.reportPath);
        }
        Log.d("path--------->", "path--->" + uri);
        ((WebView) _$_findCachedViewById(C2723R.C2726id.receipt_webview)).loadUrl("file:///android_asset/pdfviewer/index.html?file=" + uri);
    }

    private final void initialize() {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.ll_navigation);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "ll_navigation");
        linearLayout.setVisibility(8);
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.header_layout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "header_layout");
        relativeLayout.setVisibility(8);
        if (!this.isPdfDisplay) {
            ((ImageButton) _$_findCachedViewById(C2723R.C2726id.close_button)).setOnClickListener(new ReceiptDPFActivity$initialize$1(this));
            ((WebView) _$_findCachedViewById(C2723R.C2726id.receipt_webview)).loadUrl("file:///android_asset/AFC_Terms.html");
            Locale locale = Locale.getDefault();
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.getDefault()");
            if (Intrinsics.areEqual((Object) locale.getLanguage(), (Object) Constants_MVVM.EXTRA_SPANISH_CODE)) {
                ((WebView) _$_findCachedViewById(C2723R.C2726id.receipt_webview)).loadUrl("file:///android_asset/AFC_Terms_es.html");
            } else {
                ((WebView) _$_findCachedViewById(C2723R.C2726id.receipt_webview)).loadUrl("file:///android_asset/AFC_Terms.html");
            }
            WebView webView = (WebView) _$_findCachedViewById(C2723R.C2726id.receipt_webview);
            Intrinsics.checkExpressionValueIsNotNull(webView, "receipt_webview");
            webView.setWebViewClient(new ReceiptDPFActivity$initialize$2());
            return;
        }
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.close_button)).setOnClickListener(new ReceiptDPFActivity$initialize$3(this));
        WebView webView2 = (WebView) _$_findCachedViewById(C2723R.C2726id.receipt_webview);
        Intrinsics.checkExpressionValueIsNotNull(webView2, "receipt_webview");
        WebSettings settings = webView2.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings, "settings");
        settings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(true);
            settings.setAllowUniversalAccessFromFileURLs(true);
        }
        settings.setBuiltInZoomControls(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        WebView webView3 = (WebView) _$_findCachedViewById(C2723R.C2726id.receipt_webview);
        Intrinsics.checkExpressionValueIsNotNull(webView3, "receipt_webview");
        webView3.setWebChromeClient(new WebChromeClient());
        Uri parse = Uri.parse("file:///android_asset/012513 Buy and Go US49.pdf");
        ((WebView) _$_findCachedViewById(C2723R.C2726id.receipt_webview)).loadUrl("file:///android_asset/pdfviewer/index.html?file=" + parse);
    }

    private final void initializeReportReceiptUI(String str, boolean z) {
        ImageButton imageButton = (ImageButton) _$_findCachedViewById(C2723R.C2726id.bdtShare);
        Intrinsics.checkExpressionValueIsNotNull(imageButton, "bdtShare");
        imageButton.setVisibility(0);
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.header_layout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "header_layout");
        relativeLayout.setVisibility(0);
        ImageButton imageButton2 = (ImageButton) _$_findCachedViewById(C2723R.C2726id.close_button);
        Intrinsics.checkExpressionValueIsNotNull(imageButton2, "close_button");
        imageButton2.setVisibility(8);
        if (z) {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.header_title);
            Intrinsics.checkExpressionValueIsNotNull(textView, "header_title");
            textView.setText(getString(C2723R.string.receipt_page_title) + " #" + str);
        } else {
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.header_title);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "header_title");
            textView2.setText(str);
        }
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.finish_button)).setOnClickListener(new ReceiptDPFActivity$initializeReportReceiptUI$1(this));
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.btn_next)).setOnClickListener(new ReceiptDPFActivity$initializeReportReceiptUI$2(this));
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.btn_previous)).setOnClickListener(new ReceiptDPFActivity$initializeReportReceiptUI$3(this));
    }

    public final void handleTimeout() {
        Activity activity = this;
        if (this.isActivityInFront) {
            ActivityHelper.showAlert(activity, getString(C2723R.string.timeout_header), getString(C2723R.string.timeout_message), (ICommand<DialogInterface>) new ReceiptDPFActivity$handleTimeout$1());
        } else {
            activity.finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        new IntentFilter(Constants.INTENT_TIMEOUT);
        this.isActivityInFront = true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.isActivityInFront = false;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/watchlist/ReceiptDPFActivity$IJavascriptHandler;", "", "activity", "Landroid/app/Activity;", "(Lcom/iaai/android/bdt/feature/account/watchlist/ReceiptDPFActivity;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "sendTotalNoOfPage", "", "noofpage", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ReceiptDPFActivity.kt */
    private final class IJavascriptHandler {
        @NotNull
        private Activity activity;
        final /* synthetic */ ReceiptDPFActivity this$0;

        public IJavascriptHandler(@NotNull ReceiptDPFActivity receiptDPFActivity, Activity activity2) {
            Intrinsics.checkParameterIsNotNull(activity2, "activity");
            this.this$0 = receiptDPFActivity;
            this.activity = activity2;
        }

        @NotNull
        public final Activity getActivity() {
            return this.activity;
        }

        public final void setActivity(@NotNull Activity activity2) {
            Intrinsics.checkParameterIsNotNull(activity2, "<set-?>");
            this.activity = activity2;
        }

        @JavascriptInterface
        public final void sendTotalNoOfPage(int i) {
            Log.d("IJava-->", "noofpage--->" + i);
            this.activity.runOnUiThread(new ReceiptDPFActivity$IJavascriptHandler$sendTotalNoOfPage$1(this, i));
        }
    }
}
