package com.iaai.android.bdt.feature.utilsActivity;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.iaai.android.C2723R;
import com.iaai.android.old.utils.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\r"}, mo66933d2 = {"com/iaai/android/bdt/feature/utilsActivity/WebViewActivity$updateUI$1", "Landroid/webkit/WebViewClient;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "shouldOverrideUrlLoading", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: WebViewActivity.kt */
public final class WebViewActivity$updateUI$1 extends WebViewClient {
    final /* synthetic */ WebViewActivity this$0;

    WebViewActivity$updateUI$1(WebViewActivity webViewActivity) {
        this.this$0 = webViewActivity;
    }

    public boolean shouldOverrideUrlLoading(@Nullable WebView webView, @Nullable String str) {
        if (webView == null) {
            return true;
        }
        webView.loadUrl(str);
        return true;
    }

    public void onPageStarted(@Nullable WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        ProgressBar progressBar = (ProgressBar) this.this$0._$_findCachedViewById(C2723R.C2726id.progress_bar);
        Intrinsics.checkExpressionValueIsNotNull(progressBar, Constants.EXTRA_LOADING_INDICATOR);
        progressBar.setVisibility(0);
    }

    public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        super.onPageFinished(webView, str);
        ProgressBar progressBar = (ProgressBar) this.this$0._$_findCachedViewById(C2723R.C2726id.progress_bar);
        Intrinsics.checkExpressionValueIsNotNull(progressBar, Constants.EXTRA_LOADING_INDICATOR);
        progressBar.setVisibility(8);
    }
}
