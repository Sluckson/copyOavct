package com.iaai.android.old.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.Menu;
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

public class EmailIDConfirmationActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    public String confirmID;
    @BindView(2131296783)
    EditText confirm_id;
    @BindView(2131296806)
    LinearLayout continue_layout;
    @BindView(2131296822)
    TextView current_login_id;
    /* access modifiers changed from: private */
    public Dialog dialog;
    private EmailIDConfirmationManager emailIDConfirmationManager;
    /* access modifiers changed from: private */
    public String newID;
    @BindView(2131297770)
    EditText new_login_id;
    @BindView(2131298894)
    TextView txt_continue_btn;
    /* access modifiers changed from: private */
    public String user_id;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_login_id);
        ButterKnife.bind((Activity) this);
        setSupportActionBar((Toolbar) findViewById(C2723R.C2726id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        final String stringExtra = getIntent().getStringExtra("username");
        this.user_id = getIntent().getStringExtra(Constants.EXTRA_IAAI_USERID);
        this.emailIDConfirmationManager = (EmailIDConfirmationManager) ((IaaiApplication) getApplication()).getInjector().getInstance(EmailIDConfirmationManager.class);
        TextView textView = this.current_login_id;
        textView.setText(getString(C2723R.string.lbl_current_login_id) + stringExtra);
        overridePendingTransition(C2723R.anim.none, C2723R.anim.no_change);
        InputTextWatcherNewID inputTextWatcherNewID = new InputTextWatcherNewID();
        InputTextWatcherConfirmID inputTextWatcherConfirmID = new InputTextWatcherConfirmID();
        this.new_login_id.addTextChangedListener(inputTextWatcherNewID);
        this.confirm_id.addTextChangedListener(inputTextWatcherConfirmID);
        disableCopyFunctionOnEditText();
        this.txt_continue_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EmailIDConfirmationActivity.this.generateOTP(stringExtra);
            }
        });
    }

    private void disableCopyFunctionOnEditText() {
        this.new_login_id.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            public void onDestroyActionMode(ActionMode actionMode) {
            }

            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        this.confirm_id.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            public void onDestroyActionMode(ActionMode actionMode) {
            }

            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
    }

    /* access modifiers changed from: private */
    public void generateOTP(final String str) {
        final Dialog showProgressDialog = MDActivityHelper.showProgressDialog(this, (String) null);
        this.emailIDConfirmationManager.generateOTP(this.user_id, this.confirm_id.getText().toString(), new AsyncHttpResponseHandler() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                GenerateOTPResult generateOTPResult = (GenerateOTPResult) new Gson().fromJson(new String(bArr), GenerateOTPResult.class);
                if (generateOTPResult.Success) {
                    Intent intent = new Intent(EmailIDConfirmationActivity.this.getApplicationContext(), ValidateOTPActivity.class);
                    intent.putExtra(Constants.EXTRA_USER_EMAIL, EmailIDConfirmationActivity.this.confirm_id.getText().toString());
                    intent.putExtra("username", str);
                    intent.putExtra(Constants.EXTRA_IAAI_USERID, EmailIDConfirmationActivity.this.user_id);
                    EmailIDConfirmationActivity.this.startActivityForResult(intent, 99);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(EmailIDConfirmationActivity.this);
                    builder.setTitle((int) C2723R.string.txt_invalid_email).setMessage((CharSequence) generateOTPResult.Error).setCancelable(true).setPositiveButton((CharSequence) EmailIDConfirmationActivity.this.getString(C2723R.string.lbl_OK_lower), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    Dialog unused = EmailIDConfirmationActivity.this.dialog = builder.create();
                    EmailIDConfirmationActivity.this.dialog.show();
                }
                showProgressDialog.dismiss();
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                Toast.makeText(EmailIDConfirmationActivity.this, C2723R.string.msg_network_error, 1).show();
                showProgressDialog.dismiss();
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

    class InputTextWatcherConfirmID implements TextWatcher {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        InputTextWatcherConfirmID() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                String unused = EmailIDConfirmationActivity.this.confirmID = editable.toString();
            }
            if (EmailIDConfirmationActivity.this.newID != null && EmailIDConfirmationActivity.this.confirmID != null) {
                if (EmailIDConfirmationActivity.this.newID.equals(EmailIDConfirmationActivity.this.confirmID)) {
                    EmailIDConfirmationActivity.this.txt_continue_btn.setEnabled(true);
                } else {
                    EmailIDConfirmationActivity.this.txt_continue_btn.setEnabled(false);
                }
            }
        }
    }

    class InputTextWatcherNewID implements TextWatcher {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        InputTextWatcherNewID() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                String unused = EmailIDConfirmationActivity.this.newID = editable.toString();
            }
            if (EmailIDConfirmationActivity.this.newID != null && EmailIDConfirmationActivity.this.confirmID != null) {
                if (EmailIDConfirmationActivity.this.newID.equals(EmailIDConfirmationActivity.this.confirmID)) {
                    EmailIDConfirmationActivity.this.txt_continue_btn.setEnabled(true);
                } else {
                    EmailIDConfirmationActivity.this.txt_continue_btn.setEnabled(false);
                }
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 99 && i2 == -1) {
            setResult(-1);
            finish();
        }
    }
}
