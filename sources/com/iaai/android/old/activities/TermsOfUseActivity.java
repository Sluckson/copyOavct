package com.iaai.android.old.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.inject.Injector;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListActivity;
import com.iaai.android.bdt.feature.landing.BDTLandingPageActivity;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.old.managers.TermsOfUseManager;
import com.iaai.android.old.managers.UpdateAppManager;
import com.iaai.android.old.managers.VehicleSearchManager;
import com.iaai.android.old.models.SaveTermsOfUse;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.IAASharedPreference;
import com.loopj.android.http.AsyncHttpResponseHandler;
import p052cz.msebera.android.httpclient.Header;

public class TermsOfUseActivity extends MDAbstractActivity {
    @BindView(2131296605)
    Button accept;
    int come_from = -1;
    String deviceID = "";
    SessionManager sessionManager;
    TermsOfUseManager termsOfUseManager;
    @BindView(2131298315)
    WebView terms_of_use_webview;
    UpdateAppManager updateAppManager;
    VehicleSearchManager vehicleSearchManager;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_terms_and_condition);
        ButterKnife.bind((Activity) this);
        setSupportActionBar((Toolbar) findViewById(C2723R.C2726id.toolbar));
        getWindow().setSoftInputMode(2);
        this.come_from = getIntent().getIntExtra("come_from", -1);
        final IaaiApplication iaaiApplication = (IaaiApplication) getApplication();
        Injector injector = iaaiApplication.getInjector();
        this.termsOfUseManager = (TermsOfUseManager) injector.getInstance(TermsOfUseManager.class);
        this.vehicleSearchManager = (VehicleSearchManager) injector.getInstance(VehicleSearchManager.class);
        this.updateAppManager = (UpdateAppManager) injector.getInstance(UpdateAppManager.class);
        this.sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();
        int i = this.come_from;
        if (i == 100 || i == 101) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        } else {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
        this.terms_of_use_webview.loadUrl(getString(C2723R.string.terms_of_use_file_path));
        if (this.come_from == -1) {
            this.accept.setVisibility(8);
        }
        AppUtils.isAppOnLatestVersion(this, this.updateAppManager);
        this.deviceID = AppUtils.getDeviceId(getApplicationContext());
        this.accept.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AppUtils.saveTermsOfUseTimeStamp(TermsOfUseActivity.this);
                TermsOfUseActivity.this.termsOfUseManager.saveTermsOfUse(AppUtils.getDeviceIPAddress(true), TermsOfUseActivity.this.deviceID, new AsyncHttpResponseHandler() {
                    public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                        try {
                            if (((SaveTermsOfUse) new Gson().fromJson(new String(bArr), SaveTermsOfUse.class)) != null) {
                                IAASharedPreference.saveTncInPrefs(TermsOfUseActivity.this);
                            }
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (JsonSyntaxException e2) {
                            e2.printStackTrace();
                        }
                    }

                    public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                        Log.e("onFailure called", "Save terms of use");
                    }
                });
                if (TermsOfUseActivity.this.come_from != 101) {
                    IaaiApplication iaaiApplication = iaaiApplication;
                    if (IaaiApplication.is_new_landing) {
                        Intent intent = new Intent(TermsOfUseActivity.this, BDTLandingPageActivity.class);
                        intent.addFlags(536870912);
                        TermsOfUseActivity.this.startActivity(intent);
                        TermsOfUseActivity.this.finish();
                        return;
                    }
                    Intent intent2 = new Intent(TermsOfUseActivity.this, BDTAuctionMainListActivity.class);
                    intent2.addFlags(536870912);
                    TermsOfUseActivity.this.startActivity(intent2);
                    TermsOfUseActivity.this.finish();
                    return;
                }
                TermsOfUseActivity.this.setResult(-1);
                Toast.makeText(TermsOfUseActivity.this.getApplicationContext(), C2723R.string.msg_login_successful, 1).show();
                TermsOfUseActivity.this.finish();
            }
        });
    }

    public void onBackPressed() {
        if (this.come_from == 101) {
            moveTaskToBack(false);
            return;
        }
        finish();
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
