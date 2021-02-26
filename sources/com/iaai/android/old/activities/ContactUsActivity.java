package com.iaai.android.old.activities;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.iaai.android.C2723R;
import com.iaai.android.old.fragments.ContactUsFragment;

public class ContactUsActivity extends MDAbstractActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_contact_us);
        setSupportActionBar((Toolbar) findViewById(C2723R.C2726id.toolbar));
        getWindow().setSoftInputMode(2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getFragmentManager().beginTransaction().replace(C2723R.C2726id.framelayout_container, new ContactUsFragment()).commit();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            overridePendingTransition(C2723R.anim.none, C2723R.anim.push_right_out);
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
