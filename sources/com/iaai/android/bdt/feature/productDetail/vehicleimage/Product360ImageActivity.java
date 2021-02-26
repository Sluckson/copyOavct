package com.iaai.android.bdt.feature.productDetail.vehicleimage;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.utils.Constants_MVVM;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0014J\b\u0010\u000f\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/vehicleimage/Product360ImageActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "image360Url", "", "initializeBtnActions", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onResume", "updateUI", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: Product360ImageActivity.kt */
public final class Product360ImageActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    private String image360Url;

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
        setContentView((int) C2723R.C2728layout.activity_product_360_image_main);
        String stringExtra = getIntent().getStringExtra(Constants_MVVM.VEHICLE_IMAGES_360);
        Intrinsics.checkExpressionValueIsNotNull(stringExtra, "intent.getStringExtra(Co…_MVVM.VEHICLE_IMAGES_360)");
        this.image360Url = stringExtra;
        updateUI();
        initializeBtnActions();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IAAAnalytics.INSTANCE.logScreenName(IAAAnalytics.IAAScreenName.IMAGE_360_VIEW.getValue(), this);
    }

    private final void updateUI() {
        WebView webView = (WebView) _$_findCachedViewById(C2723R.C2726id.product_image_360_view);
        Intrinsics.checkExpressionValueIsNotNull(webView, "product_image_360_view");
        WebSettings settings = webView.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings, "product_image_360_view.settings");
        settings.setJavaScriptEnabled(true);
        WebView webView2 = (WebView) _$_findCachedViewById(C2723R.C2726id.product_image_360_view);
        String str = this.image360Url;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image360Url");
        }
        webView2.loadUrl(str);
    }

    private final void initializeBtnActions() {
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.product_360_img_close)).setOnClickListener(new Product360ImageActivity$initializeBtnActions$1(this));
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
