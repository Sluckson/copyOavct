package com.iaai.android.old.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.iaai.android.C2723R;

public class Vehicle360ImageActivity extends MDAbstractActivity {
    int come_from = -1;
    private String image360Url;
    @BindView(2131297133)
    WebView image_360_webview;
    @BindView(2131297155)
    ImageButton img_close;
    public boolean isLandScape = false;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_360_image_view);
        ButterKnife.bind((Activity) this);
        this.image360Url = getIntent().getStringExtra("imageurl");
        this.image_360_webview.getSettings().setJavaScriptEnabled(true);
        this.image_360_webview.loadUrl(this.image360Url);
        this.img_close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Vehicle360ImageActivity.this.finish();
                Vehicle360ImageActivity.this.overridePendingTransition(C2723R.anim.no_change, C2723R.anim.slide_down_new);
            }
        });
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
}
