package com.iaai.android.old.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.old.utils.ICommand;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.ActivityHelper;
import java.util.ArrayList;
import roboguice.inject.InjectView;

public class AFCMethodsActivity extends AbstractActivity {
    @InjectView(2131298865)
    TextView afcMethod;
    @InjectView(2131296606)
    Button agreeTerms;
    @InjectView(2131296464)
    ImageButton backButton;
    @InjectView(2131298885)
    TextView buynGo;
    @InjectView(2131296731)
    CheckBox checkAfcStandard;
    @InjectView(2131296733)
    CheckBox checkBuynGo;
    String finance;
    @InjectView(2131298920)
    TextView financeCount;
    String guidIdentifier;
    private boolean isActivityInFront;
    String isMyItemOnlyString;
    @InjectView(2131298958)
    TextView moreInfo;
    CompoundButton.OnCheckedChangeListener paymentSelection = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton.getId() == AFCMethodsActivity.this.checkBuynGo.getId()) {
                if (z) {
                    if (AFCMethodsActivity.this.checkAfcStandard.isChecked()) {
                        AFCMethodsActivity.this.checkAfcStandard.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                        AFCMethodsActivity.this.checkAfcStandard.setChecked(false);
                        AFCMethodsActivity.this.checkAfcStandard.setOnCheckedChangeListener(AFCMethodsActivity.this.paymentSelection);
                    }
                    AFCMethodsActivity.this.agreeTerms.setBackgroundResource(C2723R.C2725drawable.btn_green_normal);
                    AFCMethodsActivity.this.agreeTerms.setEnabled(true);
                } else if (!AFCMethodsActivity.this.checkAfcStandard.isChecked()) {
                    AFCMethodsActivity.this.agreeTerms.setBackgroundResource(C2723R.C2725drawable.btn_green_disabled);
                    AFCMethodsActivity.this.agreeTerms.setEnabled(false);
                }
            } else if (compoundButton.getId() != AFCMethodsActivity.this.checkAfcStandard.getId()) {
            } else {
                if (z) {
                    if (AFCMethodsActivity.this.checkBuynGo.isChecked()) {
                        AFCMethodsActivity.this.checkBuynGo.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                        AFCMethodsActivity.this.checkBuynGo.setChecked(false);
                        AFCMethodsActivity.this.checkBuynGo.setOnCheckedChangeListener(AFCMethodsActivity.this.paymentSelection);
                    }
                    AFCMethodsActivity.this.agreeTerms.setBackgroundResource(C2723R.C2725drawable.btn_green_normal);
                    AFCMethodsActivity.this.agreeTerms.setEnabled(true);
                } else if (!AFCMethodsActivity.this.checkBuynGo.isChecked()) {
                    AFCMethodsActivity.this.agreeTerms.setBackgroundResource(C2723R.C2725drawable.btn_green_disabled);
                    AFCMethodsActivity.this.agreeTerms.setEnabled(false);
                }
            }
        }
    };
    ArrayList<String> selectionRowNumbers;
    SessionManager sessionManager;
    String stock;
    @InjectView(2131299012)
    TextView stockCount;
    @InjectView(2131299019)
    TextView termsOfUse;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.afc_method);
        this.sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();
        getIntentData(getIntent());
        overridePendingTransition(C2723R.anim.push_left_in, C2723R.anim.none);
        TextView textView = this.stockCount;
        textView.setText(this.stock + "");
        this.financeCount.setText(this.finance);
        this.moreInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String string = AFCMethodsActivity.this.getString(C2723R.string.afc_url_for_more_info);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(string));
                AFCMethodsActivity.this.startActivity(intent);
            }
        });
        initialize();
    }

    /* access modifiers changed from: package-private */
    public void getIntentData(Intent intent) {
        this.stock = intent.getStringExtra(Constants.STOCKS_COUNT);
        this.finance = intent.getStringExtra(Constants.FINANCE_AMOUNT);
        this.isMyItemOnlyString = intent.getStringExtra(Constants.MY_VEHICLES_ONLY_ARG);
        this.selectionRowNumbers = intent.getStringArrayListExtra(Constants.EXTRA_ROW_SELECTION);
        this.guidIdentifier = intent.getStringExtra(Constants.EXTRA_GUID_IDENTIFIER);
    }

    private void initialize() {
        this.afcMethod.setText(Html.fromHtml(getString(C2723R.string.msg_afc_standard)));
        this.buynGo.setText(Html.fromHtml(getString(C2723R.string.msg_buy_n_go)));
        this.buynGo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(AFCMethodsActivity.this, AFCTermsPage.class);
                intent.putExtra(Constants.AFC_SELECTION_FOR_DISPLAY, true);
                AFCMethodsActivity.this.startActivity(intent);
            }
        });
        this.checkAfcStandard.setOnCheckedChangeListener(this.paymentSelection);
        this.checkBuynGo.setOnCheckedChangeListener(this.paymentSelection);
        this.agreeTerms.setEnabled(false);
        this.agreeTerms.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(AFCMethodsActivity.this, ToBePaidReviewActivity.class);
                intent.putExtra(Constants.EXTRA_PAYMENT_OPTION, Constants.PAYMENT_OPTION_AFC);
                intent.putStringArrayListExtra(Constants.EXTRA_ROW_SELECTION, AFCMethodsActivity.this.selectionRowNumbers);
                intent.putExtra(Constants.EXTRA_GUID_IDENTIFIER, AFCMethodsActivity.this.guidIdentifier);
                intent.putExtra(Constants.MY_VEHICLES_ONLY_ARG, AFCMethodsActivity.this.isMyItemOnlyString);
                intent.putExtra(Constants.AFC_PAYMENT_METHOD_SELCTION, AFCMethodsActivity.this.checkSelection());
                intent.putExtra(Constants.FINANCE_AMOUNT, AFCMethodsActivity.this.finance);
                if (AFCMethodsActivity.this.checkBuynGo.isChecked()) {
                    intent.putExtra(Constants.PAYMENT_METHOD_SELECTION_TYPE, Constants.PAYMENT_OPTION_AFB);
                } else {
                    intent.putExtra(Constants.PAYMENT_METHOD_SELECTION_TYPE, Constants.PAYMENT_OPTION_AFC);
                }
                AFCMethodsActivity.this.startActivityForResult(intent, 1);
            }
        });
        this.backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AFCMethodsActivity.this.finish();
                AFCMethodsActivity.this.overridePendingTransition(C2723R.anim.none, C2723R.anim.push_right_out);
            }
        });
        this.termsOfUse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AFCMethodsActivity.this.startActivity(new Intent(AFCMethodsActivity.this, AFCTermsPage.class));
            }
        });
    }

    public String checkSelection() {
        if (this.checkAfcStandard.isChecked()) {
            return getString(C2723R.string.lbl_standard_short);
        }
        return getString(C2723R.string.lbl_buy_n_go_short);
    }

    /* access modifiers changed from: package-private */
    public void handleTimeout() {
        if (this.isActivityInFront) {
            ActivityHelper.showAlert((Activity) this, getString(C2723R.string.timeout_header), getString(C2723R.string.timeout_message), (ICommand<DialogInterface>) new ICommand<DialogInterface>() {
                public void execute(DialogInterface dialogInterface) {
                    this.finish();
                }
            });
        } else {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.isActivityInFront = true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.isActivityInFront = false;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == 300) {
            setResult(300);
            finish();
        }
    }
}
