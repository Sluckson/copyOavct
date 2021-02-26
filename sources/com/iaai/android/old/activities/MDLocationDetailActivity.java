package com.iaai.android.old.activities;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.iaai.android.C2723R;
import com.iaai.android.old.fragments.AdditionalStateReqPDFFragment;
import com.iaai.android.old.fragments.MDLocationDetailFragment;

public class MDLocationDetailActivity extends AppCompatActivity implements MDLocationDetailFragment.OnAdditionalStatePDF {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_mdlocation_detail);
        overridePendingTransition(C2723R.anim.push_left_in, C2723R.anim.no_change);
        setSupportActionBar((Toolbar) findViewById(C2723R.C2726id.detail_toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setTitle((CharSequence) "");
        }
        if (bundle == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("item_id", getIntent().getStringExtra("item_id"));
            bundle2.putString(MDLocationDetailFragment.ARG_BRANCH_NAME, getIntent().getStringExtra(MDLocationDetailFragment.ARG_BRANCH_NAME));
            MDLocationDetailFragment mDLocationDetailFragment = new MDLocationDetailFragment();
            mDLocationDetailFragment.setArguments(bundle2);
            getSupportFragmentManager().beginTransaction().add((int) C2723R.C2726id.mdlocation_detail_fragment_container, (Fragment) mDLocationDetailFragment).commit();
            if (supportActionBar != null) {
                supportActionBar.setTitle((CharSequence) getIntent().getStringExtra(MDLocationDetailFragment.ARG_BRANCH_NAME));
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        super.onBackPressed();
        overridePendingTransition(C2723R.anim.none, C2723R.anim.push_right_out);
        return true;
    }

    public void OnAdditionalStatePDFListener(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(AdditionalStateReqPDFFragment.ARG_PDF_URL, str);
        AdditionalStateReqPDFFragment additionalStateReqPDFFragment = new AdditionalStateReqPDFFragment();
        additionalStateReqPDFFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add((int) C2723R.C2726id.mdlocation_detail_fragment_container, (Fragment) additionalStateReqPDFFragment).addToBackStack((String) null).commit();
    }
}
