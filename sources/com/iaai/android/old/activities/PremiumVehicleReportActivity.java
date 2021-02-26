package com.iaai.android.old.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import com.google.inject.Inject;
import com.iaai.android.C2723R;
import com.iaai.android.old.managers.PremiumVehicleReportManager;
import com.iaai.android.old.utils.constants.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import roboguice.inject.InjectView;

public class PremiumVehicleReportActivity extends AbstractActivity {
    @InjectView(2131296773)
    ImageButton close_button;
    @InjectView(2131297413)
    ImageButton left_button;
    @Inject
    PremiumVehicleReportManager premiumVehicleReportManager;
    @InjectView(2131297940)
    WebView pv_report_webview;
    @InjectView(2131298018)
    ImageButton right_button;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.premium_vehicle_report_layout);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(Constants.PV_REPORT_HTML_CONTENT);
        String stringExtra2 = intent.getStringExtra(Constants.PVR_INSTA_VIN_PDF_URL);
        if (stringExtra == null || stringExtra.length() <= 0) {
            loadInstaVINPDF(stringExtra2);
            return;
        }
        try {
            LoadReport(stringExtra);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void loadInstaVINPDF(String str) {
        this.pv_report_webview.loadUrl(str);
        WebSettings settings = this.pv_report_webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        this.close_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PremiumVehicleReportActivity.this.finish();
            }
        });
        this.left_button.setVisibility(8);
        this.right_button.setVisibility(8);
    }

    private void LoadReport(String str) throws UnsupportedEncodingException {
        loadWebView(str);
        this.close_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PremiumVehicleReportActivity.this.finish();
            }
        });
        this.left_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (PremiumVehicleReportActivity.this.pv_report_webview.canGoBack()) {
                    PremiumVehicleReportActivity.this.pv_report_webview.goBack();
                }
            }
        });
        this.right_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (PremiumVehicleReportActivity.this.pv_report_webview.canGoForward()) {
                    PremiumVehicleReportActivity.this.pv_report_webview.goForward();
                }
            }
        });
    }

    private void loadWebView(String str) {
        String str2;
        try {
            InputStream open = getAssets().open("AutoVinHtml");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            str2 = new String(bArr);
        } catch (IOException e) {
            e.printStackTrace();
            str2 = "";
        }
        this.pv_report_webview.loadData(str2.replace("$autovinhtml", str), "text/html", "utf-8");
        WebSettings settings = this.pv_report_webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setBuiltInZoomControls(true);
        this.pv_report_webview.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return false;
            }

            public void onPageFinished(WebView webView, String str) {
                boolean z;
                Log.d("onPageFinished------>", "called");
                boolean z2 = true;
                if (PremiumVehicleReportActivity.this.pv_report_webview.canGoBack()) {
                    PremiumVehicleReportActivity.this.left_button.setImageResource(C2723R.C2725drawable.back);
                    z = false;
                } else {
                    PremiumVehicleReportActivity.this.left_button.setImageResource(C2723R.C2725drawable.back_disable);
                    z = true;
                }
                if (PremiumVehicleReportActivity.this.pv_report_webview.canGoForward()) {
                    PremiumVehicleReportActivity.this.right_button.setImageResource(C2723R.C2725drawable.next);
                    z2 = false;
                } else {
                    PremiumVehicleReportActivity.this.right_button.setImageResource(C2723R.C2725drawable.next_disable);
                }
                if (z && z2) {
                    PremiumVehicleReportActivity.this.left_button.setVisibility(8);
                    PremiumVehicleReportActivity.this.right_button.setVisibility(8);
                }
                super.onPageFinished(webView, str);
            }
        });
    }
}
