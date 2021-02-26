package com.iaai.android.bdt.feature.utilsActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.constants.Constants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/utilsActivity/WebViewActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "brokerHelpLinkURL", "", "title", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "updateUI", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: WebViewActivity.kt */
public final class WebViewActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    private String brokerHelpLinkURL;
    private String title;

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

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_webview);
        String stringExtra = getIntent().getStringExtra(Constants_MVVM.EXTRA_BROKER_HELP_LINK_URL);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.brokerHelpLinkURL = stringExtra;
        String stringExtra2 = getIntent().getStringExtra(Constants_MVVM.EXTRA_BROKER_TITLE);
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.title = stringExtra2;
        View findViewById = findViewById(C2723R.C2726id.toolbar);
        if (findViewById != null) {
            setSupportActionBar((Toolbar) findViewById);
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(supportActionBar, "supportActionBar!!");
            supportActionBar.setTitle((CharSequence) this.title);
            ActionBar supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 == null) {
                Intrinsics.throwNpe();
            }
            supportActionBar2.setDisplayHomeAsUpEnabled(true);
            ActionBar supportActionBar3 = getSupportActionBar();
            if (supportActionBar3 == null) {
                Intrinsics.throwNpe();
            }
            supportActionBar3.setDisplayShowTitleEnabled(true);
            updateUI();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
    }

    private final void updateUI() {
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.progress_bar);
        Intrinsics.checkExpressionValueIsNotNull(progressBar, Constants.EXTRA_LOADING_INDICATOR);
        progressBar.setVisibility(0);
        WebView webView = (WebView) _$_findCachedViewById(C2723R.C2726id.webview);
        Intrinsics.checkExpressionValueIsNotNull(webView, "webview");
        WebSettings settings = webView.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings, "webview.settings");
        settings.setJavaScriptEnabled(true);
        WebView webView2 = (WebView) _$_findCachedViewById(C2723R.C2726id.webview);
        Intrinsics.checkExpressionValueIsNotNull(webView2, "webview");
        WebSettings settings2 = webView2.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings2, "webview.settings");
        settings2.setLoadWithOverviewMode(true);
        WebView webView3 = (WebView) _$_findCachedViewById(C2723R.C2726id.webview);
        Intrinsics.checkExpressionValueIsNotNull(webView3, "webview");
        WebSettings settings3 = webView3.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings3, "webview.settings");
        settings3.setUseWideViewPort(true);
        WebSettings settings4 = ((WebView) _$_findCachedViewById(C2723R.C2726id.webview)).getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings4, "webview.getSettings()");
        settings4.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 16) {
            settings4.setAllowFileAccessFromFileURLs(true);
            settings4.setAllowUniversalAccessFromFileURLs(true);
        }
        settings4.setBuiltInZoomControls(true);
        settings4.setDisplayZoomControls(false);
        settings4.setLoadWithOverviewMode(true);
        settings4.setUseWideViewPort(true);
        settings4.setDomStorageEnabled(true);
        settings4.setAppCacheEnabled(false);
        settings4.setCacheMode(2);
        WebView webView4 = (WebView) _$_findCachedViewById(C2723R.C2726id.webview);
        Intrinsics.checkExpressionValueIsNotNull(webView4, "webview");
        webView4.setWebViewClient(new WebViewActivity$updateUI$1(this));
        ((WebView) _$_findCachedViewById(C2723R.C2726id.webview)).loadUrl(this.brokerHelpLinkURL);
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            finish();
            overridePendingTransition(C2723R.anim.none, C2723R.anim.push_right_out);
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
