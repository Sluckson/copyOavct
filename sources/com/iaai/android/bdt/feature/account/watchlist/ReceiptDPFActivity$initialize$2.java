package com.iaai.android.bdt.feature.account.watchlist;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo66933d2 = {"com/iaai/android/bdt/feature/account/watchlist/ReceiptDPFActivity$initialize$2", "Landroid/webkit/WebViewClient;", "shouldOverrideUrlLoading", "", "view", "Landroid/webkit/WebView;", "url", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ReceiptDPFActivity.kt */
public final class ReceiptDPFActivity$initialize$2 extends WebViewClient {
    ReceiptDPFActivity$initialize$2() {
    }

    public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(webView, "view");
        Intrinsics.checkParameterIsNotNull(str, "url");
        webView.loadUrl(str);
        return true;
    }
}
