package com.iaai.android.old.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.managers.EmailIDConfirmationManager;
import com.iaai.android.old.models.GenerateOTPResult;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.MDActivityHelper;
import com.loopj.android.http.AsyncHttpResponseHandler;
import p052cz.msebera.android.httpclient.Header;

public class ValidateOTPActivity extends AppCompatActivity {
    @BindView(2131296785)
    TextView confirm_pin_btn;
    /* access modifiers changed from: private */
    public Dialog dialog;
    @BindView(2131296902)
    TextView edit_email;
    @BindView(2131296906)
    EditText edt_pin;
    EmailIDConfirmationManager emailIDConfirmationManager;
    @BindView(2131296908)
    TextView email_text;
    @BindView(2131298011)
    LinearLayout resend_code_layout;
    private String user_id;
    @BindView(2131299095)
    TextView verification_msg;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_pin);
        ButterKnife.bind((Activity) this);
        setSupportActionBar((Toolbar) findViewById(C2723R.C2726id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        final String stringExtra = getIntent().getStringExtra(Constants.EXTRA_USER_EMAIL);
        final String stringExtra2 = getIntent().getStringExtra("username");
        this.user_id = getIntent().getStringExtra(Constants.EXTRA_IAAI_USERID);
        this.emailIDConfirmationManager = (EmailIDConfirmationManager) ((IaaiApplication) getApplication()).getInjector().getInstance(EmailIDConfirmationManager.class);
        overridePendingTransition(C2723R.anim.none, C2723R.anim.no_change);
        this.verification_msg.setText(getString(C2723R.string.verification_text, new Object[]{stringExtra}));
        this.email_text.setText(stringExtra);
        this.edt_pin.addTextChangedListener(new InputTextWatcher());
        this.confirm_pin_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ValidateOTPActivity.this.validateOTP(stringExtra, stringExtra2);
            }
        });
        this.edit_email.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ValidateOTPActivity.this.finish();
            }
        });
        this.resend_code_layout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ValidateOTPActivity.this.generateOTP(stringExtra);
            }
        });
    }

    /* access modifiers changed from: private */
    public void validateOTP(final String str, String str2) {
        final Dialog showProgressDialog = MDActivityHelper.showProgressDialog(this, (String) null);
        this.emailIDConfirmationManager.validateOTP(this.user_id, this.edt_pin.getText().toString(), new AsyncHttpResponseHandler() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                if (((GenerateOTPResult) new Gson().fromJson(new String(bArr), GenerateOTPResult.class)).Success) {
                    ValidateOTPActivity.this.getSharedPreferences("com.iaai.android", 0).edit().putString(Constants.USERNAME_REMEMBER, str).commit();
                    ValidateOTPActivity.this.setResult(-1);
                    ValidateOTPActivity.this.finish();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ValidateOTPActivity.this);
                    builder.setTitle((CharSequence) ValidateOTPActivity.this.getString(C2723R.string.txt_verification_failed)).setMessage((int) C2723R.string.msg_verification_failed).setCancelable(true).setPositiveButton((CharSequence) ValidateOTPActivity.this.getString(C2723R.string.lbl_OK_lower), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    Dialog unused = ValidateOTPActivity.this.dialog = builder.create();
                    ValidateOTPActivity.this.dialog.show();
                }
                showProgressDialog.dismiss();
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                Toast.makeText(ValidateOTPActivity.this, C2723R.string.msg_network_error, 1).show();
                showProgressDialog.dismiss();
            }
        });
    }

    /* access modifiers changed from: private */
    public void generateOTP(final String str) {
        final Dialog showProgressDialog = MDActivityHelper.showProgressDialog(this, (String) null);
        this.emailIDConfirmationManager.generateOTP(this.user_id, str, new AsyncHttpResponseHandler() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                GenerateOTPResult generateOTPResult = (GenerateOTPResult) new Gson().fromJson(new String(bArr), GenerateOTPResult.class);
                if (generateOTPResult.Success) {
                    ValidateOTPActivity validateOTPActivity = ValidateOTPActivity.this;
                    Toast.makeText(validateOTPActivity, validateOTPActivity.getString(C2723R.string.toast_resend_msg, new Object[]{str}), 1).show();
                } else {
                    Toast.makeText(ValidateOTPActivity.this, generateOTPResult.Error, 1).show();
                }
                showProgressDialog.dismiss();
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                showProgressDialog.dismiss();
                Toast.makeText(ValidateOTPActivity.this, C2723R.string.msg_network_error, 1).show();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            overridePendingTransition(C2723R.anim.no_change, C2723R.anim.none);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    class InputTextWatcher implements TextWatcher {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        InputTextWatcher() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                ValidateOTPActivity.this.confirm_pin_btn.setEnabled(true);
            } else {
                ValidateOTPActivity.this.confirm_pin_btn.setEnabled(false);
            }
        }
    }
}
