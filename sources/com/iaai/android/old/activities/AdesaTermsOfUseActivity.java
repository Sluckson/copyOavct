package com.iaai.android.old.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.managers.TermsOfUseBlendedSaleManager;
import com.iaai.android.old.utils.constants.Constants;

public class AdesaTermsOfUseActivity extends MDAbstractActivity {
    private String BranchCode;
    @BindView(2131296330)
    TextView accept_terms_and_condition_btn;
    TermsOfUseBlendedSaleManager blendedSaleManager;
    int come_from = -1;
    @BindView(2131298902)
    TextView txt_decline_btn;
    @BindView(2131299018)
    WebView txt_terms_and_condition;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_adesa_terms_and_condition);
        ButterKnife.bind((Activity) this);
        Toolbar toolbar = (Toolbar) findViewById(C2723R.C2726id.toolbar);
        setSupportActionBar(toolbar);
        this.BranchCode = getIntent().getStringExtra(Constants.EXTRA_BRANCH_CODE_FOR_ADESA_TERMS_OF_USE);
        StringBuilder sb = new StringBuilder();
        sb.append(getString(C2723R.string.base_https_url_blended_sale));
        sb.append(getString(C2723R.string.belended_sale_terms_of_use_url, new Object[]{"" + this.BranchCode}));
        this.txt_terms_and_condition.loadUrl(sb.toString());
        this.blendedSaleManager = (TermsOfUseBlendedSaleManager) ((IaaiApplication) getApplication()).getInjector().getInstance(TermsOfUseBlendedSaleManager.class);
        ((ImageButton) toolbar.findViewById(C2723R.C2726id.img_back)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AdesaTermsOfUseActivity.this.finish();
                AdesaTermsOfUseActivity.this.overridePendingTransition(C2723R.anim.no_change, C2723R.anim.slide_down_new);
            }
        });
        this.txt_decline_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AdesaTermsOfUseActivity.this.finish();
                AdesaTermsOfUseActivity.this.overridePendingTransition(C2723R.anim.no_change, C2723R.anim.slide_down_new);
            }
        });
        this.accept_terms_and_condition_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        ((TextView) toolbar.findViewById(C2723R.C2726id.toolbar_header)).setText(getString(C2723R.string.adesa_terms_of_use));
        ((ImageButton) toolbar.findViewById(C2723R.C2726id.btn_edit)).setVisibility(8);
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
