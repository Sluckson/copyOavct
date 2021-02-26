package com.iaai.android.old.activities;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.iaai.android.C2723R;

public class TipsActivity extends AppCompatActivity {
    WebView webViewTips;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_tips);
        this.webViewTips = (WebView) findViewById(C2723R.C2726id.webview_tips);
        WebSettings settings = this.webViewTips.getSettings();
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
        this.webViewTips.clearHistory();
        this.webViewTips.clearFormData();
        this.webViewTips.clearCache(true);
        Uri parse = Uri.parse("file:///android_asset/evp/pullout-tutorial.pdf");
        WebView webView = this.webViewTips;
        webView.loadUrl("file:///android_asset/pdfviewer/index.html?file=" + parse);
        ((ImageButton) findViewById(C2723R.C2726id.img_back)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TipsActivity.this.finish();
            }
        });
    }
}
