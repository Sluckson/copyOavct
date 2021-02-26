package com.iaai.android.bdt.feature.login;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.lifecycle.Observer;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.login.BDTForgotPasswordResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/login/BDTForgotPasswordResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTForgotPasswordActivity.kt */
final class BDTForgotPasswordActivity$subscribeToViewModel$1<T> implements Observer<BDTForgotPasswordResponse> {
    final /* synthetic */ BDTForgotPasswordActivity this$0;

    BDTForgotPasswordActivity$subscribeToViewModel$1(BDTForgotPasswordActivity bDTForgotPasswordActivity) {
        this.this$0 = bDTForgotPasswordActivity;
    }

    public final void onChanged(BDTForgotPasswordResponse bDTForgotPasswordResponse) {
        if (bDTForgotPasswordResponse.getSuccess()) {
            WebView webView = (WebView) this.this$0._$_findCachedViewById(C2723R.C2726id.wvForgotPassword);
            Intrinsics.checkExpressionValueIsNotNull(webView, "wvForgotPassword");
            WebSettings settings = webView.getSettings();
            Intrinsics.checkExpressionValueIsNotNull(settings, "wvForgotPassword.settings");
            settings.setJavaScriptEnabled(true);
            WebView webView2 = (WebView) this.this$0._$_findCachedViewById(C2723R.C2726id.wvForgotPassword);
            Intrinsics.checkExpressionValueIsNotNull(webView2, "wvForgotPassword");
            WebSettings settings2 = webView2.getSettings();
            Intrinsics.checkExpressionValueIsNotNull(settings2, "wvForgotPassword.settings");
            settings2.setLoadWithOverviewMode(true);
            WebView webView3 = (WebView) this.this$0._$_findCachedViewById(C2723R.C2726id.wvForgotPassword);
            Intrinsics.checkExpressionValueIsNotNull(webView3, "wvForgotPassword");
            WebSettings settings3 = webView3.getSettings();
            Intrinsics.checkExpressionValueIsNotNull(settings3, "wvForgotPassword.settings");
            settings3.setUseWideViewPort(true);
            WebView webView4 = (WebView) this.this$0._$_findCachedViewById(C2723R.C2726id.wvForgotPassword);
            Intrinsics.checkExpressionValueIsNotNull(webView4, "wvForgotPassword");
            WebSettings settings4 = webView4.getSettings();
            Intrinsics.checkExpressionValueIsNotNull(settings4, "wvForgotPassword.settings");
            settings4.setUserAgentString("Mozilla/5.0 (Linux; U; Android 2.2.1; en-us; Nexus One Build/FRG83) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
            WebView webView5 = (WebView) this.this$0._$_findCachedViewById(C2723R.C2726id.wvForgotPassword);
            Intrinsics.checkExpressionValueIsNotNull(webView5, "wvForgotPassword");
            webView5.setWebViewClient(new WebViewClient(this) {
                final /* synthetic */ BDTForgotPasswordActivity$subscribeToViewModel$1 this$0;

                {
                    this.this$0 = r1;
                }

                public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull String str) {
                    Intrinsics.checkParameterIsNotNull(webView, "view");
                    Intrinsics.checkParameterIsNotNull(str, "url");
                    webView.loadUrl(str);
                    return true;
                }

                public void onPageFinished(@NotNull WebView webView, @NotNull String str) {
                    Intrinsics.checkParameterIsNotNull(webView, "view");
                    Intrinsics.checkParameterIsNotNull(str, "url");
                    this.this$0.this$0.showLoadingIndicator(false);
                }
            });
            ((WebView) this.this$0._$_findCachedViewById(C2723R.C2726id.wvForgotPassword)).loadUrl(bDTForgotPasswordResponse.getUrl());
            return;
        }
        this.this$0.showErrorMessageDialog(bDTForgotPasswordResponse.getErrorMessage());
    }
}
