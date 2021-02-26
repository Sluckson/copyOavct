package com.iaai.android.old.activities;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.iaai.android.C2723R;
import com.iaai.android.old.models.DZImageURLKeyData;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class VehicleDeepZoomImageActivity extends MDAbstractActivity {
    int come_from = -1;
    ArrayList<DZImageURLKeyData> deep_image_url_array;
    @BindView(2131296847)
    WebView deep_zoom_webview;
    @BindView(2131297155)
    ImageButton img_close;
    int index = 0;
    @BindView(2131297413)
    ImageButton left_button;
    @BindView(2131298018)
    ImageButton right_button;
    String text;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_deep_zoom_image_view);
        ButterKnife.bind((Activity) this);
        this.deep_image_url_array = getIntent().getParcelableArrayListExtra("deepZoomImages");
        this.deep_zoom_webview.getSettings().setJavaScriptEnabled(true);
        ArrayList<DZImageURLKeyData> arrayList = this.deep_image_url_array;
        if (arrayList != null && arrayList.size() >= 1) {
            loadWebView(this.deep_image_url_array.get(0));
        }
        this.left_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (VehicleDeepZoomImageActivity.this.index > 0) {
                    VehicleDeepZoomImageActivity vehicleDeepZoomImageActivity = VehicleDeepZoomImageActivity.this;
                    vehicleDeepZoomImageActivity.index--;
                    VehicleDeepZoomImageActivity vehicleDeepZoomImageActivity2 = VehicleDeepZoomImageActivity.this;
                    vehicleDeepZoomImageActivity2.loadWebView(vehicleDeepZoomImageActivity2.deep_image_url_array.get(VehicleDeepZoomImageActivity.this.index));
                }
            }
        });
        this.right_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (VehicleDeepZoomImageActivity.this.index < VehicleDeepZoomImageActivity.this.deep_image_url_array.size() - 1) {
                    VehicleDeepZoomImageActivity.this.index++;
                    VehicleDeepZoomImageActivity vehicleDeepZoomImageActivity = VehicleDeepZoomImageActivity.this;
                    vehicleDeepZoomImageActivity.loadWebView(vehicleDeepZoomImageActivity.deep_image_url_array.get(VehicleDeepZoomImageActivity.this.index));
                }
            }
        });
        this.img_close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VehicleDeepZoomImageActivity.this.finish();
                VehicleDeepZoomImageActivity.this.overridePendingTransition(C2723R.anim.no_change, C2723R.anim.slide_down_new);
            }
        });
    }

    public void createHTMLFile(Context context, String str, String str2, String str3) {
        File file = new File(context.getFilesDir().getPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            FileWriter fileWriter = new FileWriter(new File(file, "DeepZoomImage.html"));
            fileWriter.write(readFromFile("DeepZoom/header.txt", context) + replaceFromHtmlFile(readFromFile("DeepZoom/deepzoom.txt", context), str, str2, str3) + readFromFile("DeepZoom/footer.txt", context));
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.deep_zoom_webview.getSettings().setLoadWithOverviewMode(true);
        WebView webView = this.deep_zoom_webview;
        webView.loadUrl("file://" + getFilesDir().getPath() + "/DeepZoomImage.html");
    }

    /* access modifiers changed from: private */
    public void loadWebView(DZImageURLKeyData dZImageURLKeyData) {
        this.text = "";
        try {
            InputStream open = getAssets().open("DeepZoomImage.html");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            this.text = new String(bArr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.text = this.text.replace("$imageURL", dZImageURLKeyData.url);
        this.text = this.text.replace("$imageWidth", dZImageURLKeyData.width);
        this.text = this.text.replace("$imageHeight", dZImageURLKeyData.height);
        WebSettings settings = this.deep_zoom_webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setBuiltInZoomControls(true);
        this.deep_zoom_webview.loadData(this.text, "text/html", "utf-8");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            this.deep_zoom_webview.loadData(this.text, "text/html", "utf-8");
        } else if (configuration.orientation == 1) {
            this.deep_zoom_webview.loadData(this.text, "text/html", "utf-8");
        }
    }

    public void onBackPressed() {
        if (this.come_from == -1) {
            finish();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            overridePendingTransition(C2723R.anim.none, C2723R.anim.push_right_out);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x005a A[SYNTHETIC, Splitter:B:36:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0062 A[Catch:{ Exception -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0067 A[Catch:{ Exception -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0073 A[SYNTHETIC, Splitter:B:49:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x007b A[Catch:{ Exception -> 0x0077 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0080 A[Catch:{ Exception -> 0x0077 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.StringBuilder readFromFile(java.lang.String r4, android.content.Context r5) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            r2 = 0
            java.io.InputStream r4 = r5.open(r4, r2)     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0048, all -> 0x0045 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x0048, all -> 0x0045 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x003e, all -> 0x003a }
            r2.<init>(r5)     // Catch:{ Exception -> 0x003e, all -> 0x003a }
        L_0x001d:
            java.lang.String r1 = r2.readLine()     // Catch:{ Exception -> 0x0035, all -> 0x0033 }
            if (r1 == 0) goto L_0x0027
            r0.append(r1)     // Catch:{ Exception -> 0x0035, all -> 0x0033 }
            goto L_0x001d
        L_0x0027:
            r5.close()     // Catch:{ Exception -> 0x005e }
            if (r4 == 0) goto L_0x002f
            r4.close()     // Catch:{ Exception -> 0x005e }
        L_0x002f:
            r2.close()     // Catch:{ Exception -> 0x005e }
            goto L_0x006e
        L_0x0033:
            r0 = move-exception
            goto L_0x003c
        L_0x0035:
            r1 = move-exception
            r3 = r5
            r5 = r4
            r4 = r1
            goto L_0x0043
        L_0x003a:
            r0 = move-exception
            r2 = r1
        L_0x003c:
            r1 = r5
            goto L_0x0071
        L_0x003e:
            r2 = move-exception
            r3 = r5
            r5 = r4
            r4 = r2
            r2 = r1
        L_0x0043:
            r1 = r3
            goto L_0x0055
        L_0x0045:
            r0 = move-exception
            r2 = r1
            goto L_0x0071
        L_0x0048:
            r5 = move-exception
            r2 = r1
            r3 = r5
            r5 = r4
            r4 = r3
            goto L_0x0055
        L_0x004e:
            r0 = move-exception
            r4 = r1
            r2 = r4
            goto L_0x0071
        L_0x0052:
            r4 = move-exception
            r5 = r1
            r2 = r5
        L_0x0055:
            r4.printStackTrace()     // Catch:{ all -> 0x006f }
            if (r1 == 0) goto L_0x0060
            r1.close()     // Catch:{ Exception -> 0x005e }
            goto L_0x0060
        L_0x005e:
            r4 = move-exception
            goto L_0x006b
        L_0x0060:
            if (r5 == 0) goto L_0x0065
            r5.close()     // Catch:{ Exception -> 0x005e }
        L_0x0065:
            if (r2 == 0) goto L_0x006e
            r2.close()     // Catch:{ Exception -> 0x005e }
            goto L_0x006e
        L_0x006b:
            r4.printStackTrace()
        L_0x006e:
            return r0
        L_0x006f:
            r0 = move-exception
            r4 = r5
        L_0x0071:
            if (r1 == 0) goto L_0x0079
            r1.close()     // Catch:{ Exception -> 0x0077 }
            goto L_0x0079
        L_0x0077:
            r4 = move-exception
            goto L_0x0084
        L_0x0079:
            if (r4 == 0) goto L_0x007e
            r4.close()     // Catch:{ Exception -> 0x0077 }
        L_0x007e:
            if (r2 == 0) goto L_0x0087
            r2.close()     // Catch:{ Exception -> 0x0077 }
            goto L_0x0087
        L_0x0084:
            r4.printStackTrace()
        L_0x0087:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.old.activities.VehicleDeepZoomImageActivity.readFromFile(java.lang.String, android.content.Context):java.lang.StringBuilder");
    }

    public static String replaceFromHtmlFile(StringBuilder sb, String str, String str2, String str3) {
        int indexOf = sb.indexOf("$imageWidth");
        sb.replace(indexOf, indexOf + 11, "" + str2);
        int indexOf2 = sb.indexOf("$imageHeight");
        sb.replace(indexOf2, indexOf2 + 12, str3);
        int indexOf3 = sb.indexOf("$imageURL");
        sb.replace(indexOf3, indexOf3 + 9, str);
        return sb.toString();
    }
}
