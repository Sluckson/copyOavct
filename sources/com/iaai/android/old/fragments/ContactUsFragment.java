package com.iaai.android.old.fragments;

import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.adapter.ContactUsSpinnerAdapter;
import com.iaai.android.old.managers.ContactUsManager;
import com.iaai.android.old.models.ContactUsBranch;
import com.iaai.android.old.utils.constants.Constants;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import p052cz.msebera.android.httpclient.Header;

public class ContactUsFragment extends Fragment {
    ArrayList<ContactUsBranch> branches = null;
    @BindView(2131296618)
    TextView btnSubmit;
    @BindView(2131298886)
    TextView charLeft;
    ContactUsManager contactUsManager;
    @BindView(2131298265)
    Spinner spnBranch;
    @BindView(2131298270)
    Spinner spnCategory;
    @BindView(2131298906)
    EditText txtEmail;
    @BindView(2131298922)
    EditText txtFirstName;
    @BindView(2131298946)
    EditText txtLastName;
    @BindView(2131298959)
    EditText txtMsg;
    @BindView(2131298983)
    EditText txtPhone;
    @BindView(2131299011)
    EditText txtStock;
    View view;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.view = layoutInflater.inflate(C2723R.C2728layout.fragment_contact_us_page, viewGroup, false);
        ButterKnife.bind((Object) this, this.view);
        return this.view;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.contactUsManager = (ContactUsManager) ((IaaiApplication) getActivity().getApplication()).getInjector().getInstance(ContactUsManager.class);
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        new ArrayList();
        final ContactUsSpinnerAdapter contactUsSpinnerAdapter = new ContactUsSpinnerAdapter(getActivity(), Arrays.asList(getResources().getStringArray(C2723R.array.service_category_array)));
        contactUsSpinnerAdapter.setSelection(0);
        this.spnCategory.setAdapter(contactUsSpinnerAdapter);
        this.spnCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                contactUsSpinnerAdapter.setSelection(i);
                ContactUsFragment.this.btnSubmit.setEnabled(ContactUsFragment.this.hasAllRequiredField());
            }
        });
        getContactUsBranch();
        InputTextWatcher inputTextWatcher = new InputTextWatcher();
        this.txtMsg.addTextChangedListener(inputTextWatcher);
        this.txtFirstName.addTextChangedListener(inputTextWatcher);
        this.txtLastName.addTextChangedListener(inputTextWatcher);
        this.txtPhone.addTextChangedListener(inputTextWatcher);
        this.txtEmail.addTextChangedListener(inputTextWatcher);
        this.btnSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ContactUsFragment.this.sendEmail();
            }
        });
        this.charLeft.setText("0/2000");
        this.txtMsg.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Log.d("ContactUs", i + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + i2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + i3);
            }

            public void afterTextChanged(Editable editable) {
                Log.d("After Text Change", editable.toString().length() + "");
                TextView textView = ContactUsFragment.this.charLeft;
                textView.setText((editable.toString().length() + 0) + "/2000");
            }
        });
    }

    /* access modifiers changed from: package-private */
    public boolean validateForm() {
        if (!this.txtFirstName.getText().toString().equalsIgnoreCase("") && !this.txtLastName.getText().toString().equalsIgnoreCase("") && !this.txtEmail.getText().toString().equalsIgnoreCase("") && !this.txtPhone.getText().toString().equalsIgnoreCase("") && !this.txtMsg.getText().toString().equalsIgnoreCase("") && !this.spnBranch.getSelectedItem().toString().equalsIgnoreCase(getString(C2723R.string.contact_us_branch)) && !this.spnCategory.getSelectedItem().toString().equalsIgnoreCase(getString(C2723R.string.lbl_select_service_category))) {
            return true;
        }
        Toast.makeText(getActivity(), "All Fields Required.", 0).show();
        return false;
    }

    /* access modifiers changed from: package-private */
    public void sendEmail() {
        String str;
        try {
            str = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            str = Constants.STR_NA;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc822");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{getResources().getString(C2723R.string.buyer_service_email)});
        intent.putExtra("android.intent.extra.SUBJECT", getResources().getString(C2723R.string.contact_us_email_subject));
        intent.putExtra("android.intent.extra.TEXT", Html.fromHtml("<html><body><strong>Inquiry Type:</strong>" + getNonEmptyString(this.spnCategory.getSelectedItem().toString()) + "<br /><br /><strong>Contact Info:</strong><br /> Name:   " + getNonEmptyString(this.txtFirstName.getText().toString()) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getNonEmptyString(this.txtLastName.getText().toString()) + "  <br />Email:  " + getNonEmptyString(this.txtEmail.getText().toString()) + "  <br />Phone:  " + getNonEmptyString(this.txtPhone.getText().toString()) + " <br /> <br /> <strong>Stock Number & Branch:</strong> <br />Stock Number:  " + getNonEmptyString(this.txtStock.getText().toString()) + "   <br /> Branch Name: " + getNonEmptyString(this.spnBranch.getSelectedItem().toString()) + "  <br /> <br /><strong>Device Information:</strong> <br />Device Type: Android   <br />OS Version:  " + Build.VERSION.RELEASE + "<br />App Version: " + str + "<br /> <br /><strong>Questions: </strong> <br />" + getNonEmptyString(this.txtMsg.getText().toString()) + "</body></html>"));
        try {
            startActivity(Intent.createChooser(intent, "Send mail..."));
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(getActivity(), "There are no email clients installed.", 0).show();
        }
    }

    private String getNonEmptyString(String str) {
        return !TextUtils.isEmpty(str) ? str : "";
    }

    /* access modifiers changed from: package-private */
    public void updateView(ArrayList<ContactUsBranch> arrayList) {
        if (isAdded()) {
            this.branches = arrayList;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(getString(C2723R.string.contact_us_branch));
            Iterator<ContactUsBranch> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().name);
            }
            final ContactUsSpinnerAdapter contactUsSpinnerAdapter = new ContactUsSpinnerAdapter(getActivity(), arrayList2);
            contactUsSpinnerAdapter.setSelection(0);
            this.spnBranch.setAdapter(contactUsSpinnerAdapter);
            this.spnBranch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    contactUsSpinnerAdapter.setSelection(i);
                }
            });
        }
    }

    private void getContactUsBranch() {
        this.contactUsManager.getContactUsBranch(new AsyncHttpResponseHandler() {
            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
            }

            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                Gson gson = new Gson();
                String str = new String(bArr);
                Type type = new TypeToken<List<ContactUsBranch>>() {
                }.getType();
                ContactUsFragment.this.branches = (ArrayList) gson.fromJson(str, type);
                ContactUsFragment contactUsFragment = ContactUsFragment.this;
                contactUsFragment.updateView(contactUsFragment.branches);
            }
        });
    }

    class InputTextWatcher implements TextWatcher {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        InputTextWatcher() {
        }

        public void afterTextChanged(Editable editable) {
            ContactUsFragment.this.btnSubmit.setEnabled(ContactUsFragment.this.hasAllRequiredField());
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasAllRequiredField() {
        return !TextUtils.isEmpty(this.txtFirstName.getText().toString().trim()) && !TextUtils.isEmpty(this.txtLastName.getText().toString().trim()) && !TextUtils.isEmpty(this.txtEmail.getText().toString().trim()) && !TextUtils.isEmpty(this.txtPhone.getText().toString().trim()) && !TextUtils.isEmpty(this.txtMsg.getText().toString().trim()) && !this.spnCategory.getSelectedItem().toString().equalsIgnoreCase(getString(C2723R.string.lbl_select_service_category));
    }
}
