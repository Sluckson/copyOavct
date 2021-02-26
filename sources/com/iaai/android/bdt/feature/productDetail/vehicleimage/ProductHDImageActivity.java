package com.iaai.android.bdt.feature.productDetail.vehicleimage;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.model.productDetail.biddingInfo.Image;
import com.iaai.android.bdt.utils.Constants_MVVM;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\tH\u0014J\b\u0010\u0010\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/vehicleimage/ProductHDImageActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "index", "", "vehicleImages", "", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/Image;", "initializeBtnActions", "", "loadWebView", "image", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "updateUI", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ProductHDImageActivity.kt */
public final class ProductHDImageActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public int index;
    /* access modifiers changed from: private */
    public List<Image> vehicleImages = CollectionsKt.emptyList();

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
        setContentView((int) C2723R.C2728layout.activity_product_hd_image_main);
        Serializable serializableExtra = getIntent().getSerializableExtra(Constants_MVVM.VEHICLE_IMAGES_INFO);
        if (serializableExtra != null) {
            this.vehicleImages = (List) serializableExtra;
            updateUI();
            initializeBtnActions();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.iaai.android.bdt.model.productDetail.biddingInfo.Image>");
    }

    private final void updateUI() {
        loadWebView(this.vehicleImages.get(0));
    }

    private final void initializeBtnActions() {
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.hd_img_close)).setOnClickListener(new ProductHDImageActivity$initializeBtnActions$1(this));
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.hd_left_button)).setOnClickListener(new ProductHDImageActivity$initializeBtnActions$2(this));
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.hd_right_button)).setOnClickListener(new ProductHDImageActivity$initializeBtnActions$3(this));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IAAAnalytics.INSTANCE.logScreenName(IAAAnalytics.IAAScreenName.IMAGE_HD_VIEW.getValue(), this);
    }

    /* access modifiers changed from: private */
    public final void loadWebView(Image image) {
        String str;
        InputStream inputStream = null;
        try {
            InputStream open = getAssets().open("DeepZoomImage.html");
            if (open == null) {
                Intrinsics.throwNpe();
            }
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            str = new String(bArr, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            str = "";
        }
        String replace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str, "$imageURL", image.getDeapZoomUrl(), false, 4, (Object) null), "$imageWidth", "" + image.getWidth(), false, 4, (Object) null), "$imageHeight", "" + image.getHeight(), false, 4, (Object) null);
        WebView webView = (WebView) _$_findCachedViewById(C2723R.C2726id.hd_webview);
        Intrinsics.checkExpressionValueIsNotNull(webView, "hd_webview");
        WebSettings settings = webView.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings, "webSettings");
        settings.setJavaScriptEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setBuiltInZoomControls(true);
        ((WebView) _$_findCachedViewById(C2723R.C2726id.hd_webview)).loadData(replace$default, "text/html", "utf-8");
    }
}
