package com.iaai.android.old.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import com.google.gson.Gson;
import com.google.inject.Inject;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.managers.VehicleReceiptManager;
import com.iaai.android.old.models.VehicleReceipt;
import com.iaai.android.old.utils.ICommand;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.ActivityHelper;
import com.iaai.android.old.utils.p016ui.MDActivityHelper;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import p052cz.msebera.android.httpclient.Header;
import roboguice.inject.InjectView;

public class AFCTermsPage extends AbstractActivity {
    @InjectView(2131296411)
    WebView afcTerms;
    @InjectView(2131296773)
    ImageButton closeButton;
    @InjectView(2131297010)
    ImageButton finish_btn;
    @InjectView(2131297075)
    RelativeLayout header_layout;
    @InjectView(2131297077)
    TextView header_title;
    private boolean isActivityInFront;
    boolean isPdfDisplay;
    /* access modifiers changed from: private */
    public boolean isReceipt;
    private boolean isVehicleReceipt;
    boolean isVehicleReport;
    @InjectView(2131297548)
    LinearLayout navigationView;
    @InjectView(2131296636)
    ImageButton next;
    @InjectView(2131296645)
    ImageView previous;
    String receipt_file_path;
    String reportPath;
    SessionManager sessionManager;
    @InjectView(2131296873)
    ImageButton share_btn;
    String subject_line_text;
    @Inject
    VehicleReceiptManager vehicleReceiptManager;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.afc_finanace_terms);
        this.sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();
        this.isPdfDisplay = getIntent().getBooleanExtra(Constants.AFC_SELECTION_FOR_DISPLAY, false);
        this.isVehicleReport = getIntent().getBooleanExtra(Constants.VEHICLE_DETAIL_PDF_REPORT, false);
        this.isVehicleReceipt = getIntent().getBooleanExtra("pdf_receipt", false);
        this.subject_line_text = getIntent().getStringExtra("receipt_email_subject_line");
        String stringExtra = getIntent().getStringExtra("report_title");
        String stringExtra2 = getIntent().getStringExtra("asap_salvage_id");
        if (this.isVehicleReport) {
            this.reportPath = getIntent().getStringExtra(Constants.REPORT_PATH);
            loadPDF(stringExtra, false, "");
        } else if (this.isVehicleReceipt) {
            this.isReceipt = getIntent().getBooleanExtra("receipt_type", false);
            this.receipt_file_path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/IAABuyerApps/" + getString(C2723R.string.stock_receipt_title) + "_" + stringExtra + "_" + stringExtra2 + ".pdf";
            if (this.isReceipt) {
                this.receipt_file_path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/IAABuyerApps/" + getString(C2723R.string.receipt_page_title) + "_" + stringExtra + "_" + stringExtra2 + ".pdf";
            }
            if (new File(this.receipt_file_path).exists()) {
                initializeReportReceiptUI(stringExtra, true);
                loadPDF(stringExtra, true, this.receipt_file_path);
                return;
            }
            this.reportPath = getIntent().getStringExtra("receipt_url");
            loadReceiptPDF(this.reportPath, stringExtra, stringExtra2);
        } else {
            initialize();
        }
    }

    private void loadReceiptPDF(String str, final String str2, final String str3) {
        final Dialog showProgressDialog = MDActivityHelper.showProgressDialog(this, getString(C2723R.string.downloading_receipt));
        initializeReportReceiptUI(str2, true);
        this.vehicleReceiptManager.loadReceiptData(str, new AsyncHttpResponseHandler() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                String str;
                byte[] bArr2;
                VehicleReceipt vehicleReceipt = (VehicleReceipt) new Gson().fromJson(new String(bArr), VehicleReceipt.class);
                if (vehicleReceipt.errorMessage != null) {
                    showProgressDialog.dismiss();
                    if (!AFCTermsPage.this.isFinishing()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(AFCTermsPage.this);
                        builder.setMessage(vehicleReceipt.errorMessage);
                        builder.setPositiveButton(C2723R.string.lbl_OK_lower, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                AFCTermsPage.this.finish();
                            }
                        });
                        builder.create().show();
                        return;
                    }
                    return;
                }
                if (AFCTermsPage.this.isReceipt) {
                    str = AFCTermsPage.this.getString(C2723R.string.receipt_page_title);
                    bArr2 = vehicleReceipt.getOrderReceiptImage();
                } else {
                    str = AFCTermsPage.this.getString(C2723R.string.stock_receipt_title);
                    bArr2 = vehicleReceipt.getStockReceiptImage();
                }
                if (bArr2 != null) {
                    AFCTermsPage aFCTermsPage = AFCTermsPage.this;
                    if (aFCTermsPage.createReceiptPDF(bArr2, str + "_" + str2 + "_" + str3 + ".pdf")) {
                        AFCTermsPage aFCTermsPage2 = AFCTermsPage.this;
                        aFCTermsPage2.loadPDF(str2, true, aFCTermsPage2.receipt_file_path);
                        showProgressDialog.dismiss();
                        return;
                    }
                }
                showProgressDialog.dismiss();
                if (!AFCTermsPage.this.isFinishing()) {
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(AFCTermsPage.this);
                    builder2.setMessage(C2723R.string.no_receipt_avaliable_at_this_time);
                    builder2.setPositiveButton(C2723R.string.lbl_OK_lower, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            AFCTermsPage.this.finish();
                        }
                    });
                    builder2.create().show();
                }
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                showProgressDialog.dismiss();
            }
        });
    }

    public boolean createReceiptPDF(byte[] bArr, String str) {
        try {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(externalStoragePublicDirectory.getAbsolutePath() + "/IAABuyerApps");
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
    public void loadPDF(final String str, final boolean z, final String str2) {
        Uri uri;
        if (!z) {
            initializeReportReceiptUI(str, z);
        }
        this.share_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                File file;
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                StringBuilder sb = new StringBuilder();
                if (z) {
                    file = new File(str2);
                    if (AFCTermsPage.this.subject_line_text == null) {
                        AFCTermsPage.this.subject_line_text = "";
                    }
                    sb.append(AFCTermsPage.this.getString(C2723R.string.receipt_page_title));
                    sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    sb.append(str);
                    sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    sb.append(AFCTermsPage.this.getString(C2723R.string.for_email_subject_line));
                    sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    sb.append(AFCTermsPage.this.subject_line_text);
                } else {
                    file = new File(AFCTermsPage.this.reportPath);
                    sb.append(AFCTermsPage.this.subject_line_text);
                }
                AFCTermsPage aFCTermsPage = AFCTermsPage.this;
                intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(aFCTermsPage, AFCTermsPage.this.getPackageName() + ".provider", file));
                intent.putExtra("android.intent.extra.SUBJECT", sb.toString());
                intent.setType("application/pdf");
                intent.addFlags(1);
                AFCTermsPage aFCTermsPage2 = AFCTermsPage.this;
                aFCTermsPage2.startActivity(Intent.createChooser(intent, aFCTermsPage2.getString(C2723R.string.lbl_send)));
            }
        });
        WebSettings settings = this.afcTerms.getSettings();
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
        this.afcTerms.clearHistory();
        this.afcTerms.clearFormData();
        this.afcTerms.clearCache(true);
        this.afcTerms.addJavascriptInterface(new IJavascriptHandler(this), "jshandler");
        if (z) {
            uri = Uri.parse(str2);
        } else {
            uri = Uri.parse(this.reportPath);
        }
        Log.d("path--------->", "path--->" + uri);
        WebView webView = this.afcTerms;
        webView.loadUrl("file:///android_asset/pdfviewer/index.html?file=" + uri);
    }

    private void initialize() {
        this.navigationView.setVisibility(8);
        this.header_layout.setVisibility(8);
        if (!this.isPdfDisplay) {
            this.closeButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AFCTermsPage.this.finish();
                }
            });
            this.afcTerms.loadUrl("file:///android_asset/AFC_Terms.html");
            if (Locale.getDefault().getLanguage().equals(Constants_MVVM.EXTRA_SPANISH_CODE)) {
                this.afcTerms.loadUrl("file:///android_asset/AFC_Terms_es.html");
            } else {
                this.afcTerms.loadUrl("file:///android_asset/AFC_Terms.html");
            }
            this.afcTerms.setWebViewClient(new WebViewClient() {
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    webView.loadUrl(str);
                    return true;
                }
            });
            return;
        }
        this.closeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AFCTermsPage.this.finish();
            }
        });
        WebSettings settings = this.afcTerms.getSettings();
        settings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(true);
            settings.setAllowUniversalAccessFromFileURLs(true);
        }
        settings.setBuiltInZoomControls(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        this.afcTerms.setWebChromeClient(new WebChromeClient());
        Uri parse = Uri.parse("file:///android_asset/012513 Buy and Go US49.pdf");
        WebView webView = this.afcTerms;
        webView.loadUrl("file:///android_asset/pdfviewer/index.html?file=" + parse);
    }

    private void initializeReportReceiptUI(String str, boolean z) {
        this.share_btn.setVisibility(0);
        this.header_layout.setVisibility(0);
        this.closeButton.setVisibility(8);
        if (z) {
            TextView textView = this.header_title;
            textView.setText(getString(C2723R.string.receipt_page_title) + " #" + str);
        } else {
            this.header_title.setText(str);
        }
        this.finish_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AFCTermsPage.this.finish();
            }
        });
        this.next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AFCTermsPage.this.afcTerms.loadUrl("javascript:onNextPage()");
            }
        });
        this.previous.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AFCTermsPage.this.afcTerms.loadUrl("javascript:onPrevPage()");
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void handleTimeout() {
        if (this.isActivityInFront) {
            ActivityHelper.showAlert((Activity) this, getString(C2723R.string.timeout_header), getString(C2723R.string.timeout_message), (ICommand<DialogInterface>) new ICommand<DialogInterface>() {
                public void execute(DialogInterface dialogInterface) {
                    this.finish();
                }
            });
        } else {
            finish();
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

    private class IJavascriptHandler {
        Activity activity;

        IJavascriptHandler(Activity activity2) {
            this.activity = activity2;
        }

        @JavascriptInterface
        public void sendTotalNoOfPage(final int i) {
            Log.d("IJava-->", "noofpage--->" + i);
            this.activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (i <= 1) {
                        AFCTermsPage.this.navigationView.setVisibility(8);
                    } else {
                        AFCTermsPage.this.navigationView.setVisibility(0);
                    }
                }
            });
        }
    }
}
