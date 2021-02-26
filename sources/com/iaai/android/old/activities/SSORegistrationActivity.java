package com.iaai.android.old.activities;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.constants.Constants;
import java.io.UnsupportedEncodingException;

public class SSORegistrationActivity extends AppCompatActivity {
    private static final int FILECHOOSER_RESULTCODE = 1;
    public static final int REQUEST_SELECT_FILE = 100;
    /* access modifiers changed from: private */
    public ValueCallback<Uri> mUploadMessage;
    ProgressBar progressBar;
    SessionManager sessionManager;
    SSORegistrationWebChrome ssoWebChromeClient;
    public ValueCallback<Uri[]> uploadMessage;
    WebView webview;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_registartion_webview);
        this.sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();
        setSupportActionBar((Toolbar) findViewById(C2723R.C2726id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        this.webview = (WebView) findViewById(C2723R.C2726id.poc_webview);
        this.progressBar = (ProgressBar) findViewById(C2723R.C2726id.progress_bar);
        this.progressBar.setVisibility(0);
        loadWebView();
    }

    private void loadWebView() {
        WebSettings settings = this.webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        this.ssoWebChromeClient = new SSORegistrationWebChrome();
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.webview, true);
        }
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        this.webview.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                if (Build.VERSION.SDK_INT < 21) {
                    return true;
                }
                webView.loadUrl(webResourceRequest.getUrl().toString());
                return true;
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                SSORegistrationActivity.this.progressBar.setVisibility(0);
            }

            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                SSORegistrationActivity.this.progressBar.setVisibility(8);
            }
        });
        String replaceAll = getIntent().getStringExtra(Constants.EXTRA_SSO_URL).replaceAll("/es-mx", "");
        if (replaceAll.contains(Constants_MVVM.MY_SUBSCRIPTION_URL)) {
            getSupportActionBar().setTitle((CharSequence) getResources().getString(C2723R.string.lbl_bdt_my_subscriptions));
        } else {
            getSupportActionBar().setTitle((CharSequence) "");
        }
        String str = getString(C2723R.string.auto_registration_url) + "login/CustomLoginForm";
        byte[] bArr = new byte[0];
        try {
            bArr = (this.sessionManager.getCurrentSessionUsername() + ":" + this.sessionManager.getCurrentSessionPassword()).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.webview.postUrl(str, ("devicetype=Android&url=" + replaceAll + "&id=" + Base64.encodeToString(bArr, 0)).getBytes());
        this.webview.setWebChromeClient(new SSORegistrationWebChrome());
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            overridePendingTransition(C2723R.anim.none, C2723R.anim.push_right_out);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    class SSORegistrationWebChrome extends WebChromeClient {
        SSORegistrationWebChrome() {
        }

        /* access modifiers changed from: protected */
        public void openFileChooser(ValueCallback valueCallback, String str) {
            ValueCallback unused = SSORegistrationActivity.this.mUploadMessage = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            SSORegistrationActivity.this.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1);
        }

        @TargetApi(21)
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            if (SSORegistrationActivity.this.uploadMessage != null) {
                SSORegistrationActivity.this.uploadMessage.onReceiveValue((Object) null);
                SSORegistrationActivity.this.uploadMessage = null;
            }
            SSORegistrationActivity.this.uploadMessage = valueCallback;
            try {
                SSORegistrationActivity.this.startActivityForResult(fileChooserParams.createIntent(), 100);
                return true;
            } catch (ActivityNotFoundException unused) {
                SSORegistrationActivity sSORegistrationActivity = SSORegistrationActivity.this;
                sSORegistrationActivity.uploadMessage = null;
                Toast.makeText(sSORegistrationActivity, "Cannot Open File Chooser", 1).show();
                return false;
            }
        }

        /* access modifiers changed from: protected */
        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            ValueCallback unused = SSORegistrationActivity.this.mUploadMessage = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            SSORegistrationActivity.this.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1);
        }

        /* access modifiers changed from: protected */
        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            ValueCallback unused = SSORegistrationActivity.this.mUploadMessage = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            SSORegistrationActivity.this.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ValueCallback<Uri[]> valueCallback;
        if (Build.VERSION.SDK_INT >= 21) {
            if (i == 100 && (valueCallback = this.uploadMessage) != null) {
                valueCallback.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(i2, intent));
                this.uploadMessage = null;
            }
        } else if (i != 1) {
            Toast.makeText(this, "Failed to Upload Image", 1).show();
        } else if (this.mUploadMessage != null) {
            this.mUploadMessage.onReceiveValue((intent == null || i2 != -1) ? null : intent.getData());
            this.mUploadMessage = null;
        }
    }
}
