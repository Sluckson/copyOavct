package com.iaai.android.old.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.managers.ForgotPasswordManager;
import com.iaai.android.old.models.ForgotPasswordResponse;
import com.iaai.android.old.utils.ICommand;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.MDActivityHelper;
import com.loopj.android.http.AsyncHttpResponseHandler;
import p052cz.msebera.android.httpclient.Header;

public class ForgotPasswordActivity extends MDAbstractActivity {
    @BindView(2131296616)
    Button btnClose;
    ForgotPasswordManager forgotPasswordManager;
    @BindView(2131297033)
    WebView forgotPasswordView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_forgot_password);
        ButterKnife.bind((Activity) this);
        setSupportActionBar((Toolbar) findViewById(C2723R.C2726id.toolbar));
        getWindow().setSoftInputMode(2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        String stringExtra = getIntent().getStringExtra(Constants.EXTRA_USERNAME);
        this.forgotPasswordManager = (ForgotPasswordManager) ((IaaiApplication) getApplication()).getInjector().getInstance(ForgotPasswordManager.class);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        loadForgotPasswordView(stringExtra);
        this.btnClose.setVisibility(0);
        this.btnClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ForgotPasswordActivity.this.finish();
            }
        });
    }

    private void loadForgotPasswordView(String str) {
        final Dialog showLoadingDialog = MDActivityHelper.showLoadingDialog(this);
        showLoadingDialog.show();
        this.forgotPasswordManager.getForgotPasswordLink(str, new AsyncHttpResponseHandler() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                ForgotPasswordResponse forgotPasswordResponse = (ForgotPasswordResponse) new Gson().fromJson(new String(bArr), ForgotPasswordResponse.class);
                if (forgotPasswordResponse.isSuccess) {
                    ForgotPasswordActivity.this.forgotPasswordView.getSettings().setJavaScriptEnabled(true);
                    ForgotPasswordActivity.this.forgotPasswordView.getSettings().setLoadWithOverviewMode(true);
                    ForgotPasswordActivity.this.forgotPasswordView.getSettings().setUseWideViewPort(true);
                    ForgotPasswordActivity.this.forgotPasswordView.getSettings().setUserAgentString("Mozilla/5.0 (Linux; U; Android 2.2.1; en-us; Nexus One Build/FRG83) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
                    ForgotPasswordActivity.this.forgotPasswordView.setWebViewClient(new WebViewClient() {
                        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                            webView.loadUrl(str);
                            return true;
                        }

                        public void onPageFinished(WebView webView, String str) {
                            showLoadingDialog.dismiss();
                        }
                    });
                    ForgotPasswordActivity.this.forgotPasswordView.loadUrl(forgotPasswordResponse.forgot_password_url);
                    return;
                }
                ForgotPasswordActivity.this.showErrorMessageDialog(forgotPasswordResponse.errorMessage);
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                showLoadingDialog.dismiss();
                ForgotPasswordActivity.this.showErrorMessageDialog(th.getMessage());
            }
        });
    }

    /* access modifiers changed from: private */
    public void showErrorMessageDialog(String str) {
        MDActivityHelper.showAlert((Activity) this, "", str, (ICommand<DialogInterface>) new ICommand<DialogInterface>() {
            public void execute(DialogInterface dialogInterface) {
                ForgotPasswordActivity.this.finish();
            }
        });
    }
}
