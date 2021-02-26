package com.iaai.android.old.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.gson.Gson;
import com.iaai.android.C2723R;
import com.iaai.android.old.adapter.ToBePickedReviewPulloutAdapter;
import com.iaai.android.old.managers.ToBePickedUpManager;
import com.iaai.android.old.models.ReviewPullOutRequest;
import com.iaai.android.old.models.ToBePickedUpList;
import com.iaai.android.old.models.ToBePickedUpVehicles;
import com.iaai.android.old.models.VPRRequestModel;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.MDActivityHelper;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.util.ArrayList;
import java.util.Iterator;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import p052cz.msebera.android.httpclient.Header;
import roboguice.application.RoboApplication;

public class ToBePickedUpReviewPulloutActivity extends AppCompatActivity {
    public static int CONFIRM_MODE = 1;
    public static int SAVE_MODE = 2;
    TextView btn_save_pullout;
    ImageButton closeReviewPullout;
    TextView delete_pullout;
    /* access modifiers changed from: private */
    public float disable_bg = 0.5f;
    EditText ed_note;
    EditText ed_pullout;
    /* access modifiers changed from: private */
    public float enable_bg = 1.0f;
    RelativeLayout layout_save_pullout;
    ListView listView;
    String notes_check;
    int pin = 0;
    String pullout_check;
    ArrayList<Integer> salvage_id_array;
    ArrayList<ToBePickedUpVehicles> selectedItems = null;
    ToBePickedUpManager toBePickedUpManager;
    TextView tv_vehicle_count;
    ArrayList<ToBePickedUpVehicles> vehicleArrayList = null;
    int vehiclePulloutRequestID = -1;
    int view_mode;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_tobe_picked_up_review_pullout);
        this.toBePickedUpManager = (ToBePickedUpManager) ((RoboApplication) getApplicationContext()).getInjector().getInstance(ToBePickedUpManager.class);
        Toolbar toolbar = (Toolbar) findViewById(C2723R.C2726id.toolbar);
        setSupportActionBar(toolbar);
        this.ed_pullout = (EditText) findViewById(C2723R.C2726id.ed_pullout);
        this.layout_save_pullout = (RelativeLayout) findViewById(C2723R.C2726id.layout_save_pullout);
        this.btn_save_pullout = (TextView) findViewById(C2723R.C2726id.btn_save_pullout);
        this.ed_note = (EditText) findViewById(C2723R.C2726id.ed_note);
        this.ed_pullout.setInputType(16384);
        this.ed_note.setInputType(16384);
        this.tv_vehicle_count = (TextView) findViewById(C2723R.C2726id.pullout_vehicle_count);
        this.closeReviewPullout = (ImageButton) toolbar.findViewById(C2723R.C2726id.img_back);
        this.delete_pullout = (TextView) toolbar.findViewById(C2723R.C2726id.delete_pullout);
        this.closeReviewPullout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ToBePickedUpReviewPulloutActivity.this.closeReviewPullout();
            }
        });
        this.layout_save_pullout.setEnabled(false);
        this.layout_save_pullout.setAlpha(this.disable_bg);
        this.delete_pullout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ToBePickedUpReviewPulloutActivity.this.showDeletePulloutDialog(view.getContext());
            }
        });
        this.listView = (ListView) findViewById(C2723R.C2726id.selected_pullout_list);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                SparseBooleanArray checkedItemPositions = ToBePickedUpReviewPulloutActivity.this.listView.getCheckedItemPositions();
                int i2 = 0;
                for (int i3 = 0; i3 < checkedItemPositions.size(); i3++) {
                    if (checkedItemPositions.valueAt(i3)) {
                        i2++;
                    }
                }
                if (i2 > 0) {
                    ToBePickedUpReviewPulloutActivity.this.layout_save_pullout.setEnabled(true);
                    ToBePickedUpReviewPulloutActivity.this.layout_save_pullout.setAlpha(ToBePickedUpReviewPulloutActivity.this.enable_bg);
                } else {
                    ToBePickedUpReviewPulloutActivity.this.layout_save_pullout.setEnabled(false);
                    ToBePickedUpReviewPulloutActivity.this.layout_save_pullout.setAlpha(ToBePickedUpReviewPulloutActivity.this.disable_bg);
                }
                TextView textView = ToBePickedUpReviewPulloutActivity.this.tv_vehicle_count;
                textView.setText(i2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + ToBePickedUpReviewPulloutActivity.this.getString(C2723R.string.lbl_vehicle_s));
                if (ToBePickedUpReviewPulloutActivity.this.view_mode != ToBePickedUpReviewPulloutActivity.SAVE_MODE) {
                    return;
                }
                if (ToBePickedUpReviewPulloutActivity.this.detectChangeInReviewFields()) {
                    ToBePickedUpReviewPulloutActivity.this.layout_save_pullout.setEnabled(true);
                    ToBePickedUpReviewPulloutActivity.this.layout_save_pullout.setAlpha(ToBePickedUpReviewPulloutActivity.this.enable_bg);
                    return;
                }
                ToBePickedUpReviewPulloutActivity.this.layout_save_pullout.setEnabled(false);
                ToBePickedUpReviewPulloutActivity.this.layout_save_pullout.setAlpha(ToBePickedUpReviewPulloutActivity.this.disable_bg);
            }
        });
        this.layout_save_pullout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ToBePickedUpReviewPulloutActivity.this.navigateToVPRPage();
            }
        });
        Intent intent = getIntent();
        this.salvage_id_array = intent.getIntegerArrayListExtra("salvage_id_array");
        if (this.salvage_id_array != null) {
            this.view_mode = CONFIRM_MODE;
            getReviewPullOutList();
            this.btn_save_pullout.setText(getString(C2723R.string.confirm_pullout_text).toUpperCase());
            this.delete_pullout.setVisibility(8);
        } else {
            this.view_mode = SAVE_MODE;
            this.vehicleArrayList = intent.getParcelableArrayListExtra("vehicle_array");
            this.pullout_check = intent.getStringExtra("title");
            this.notes_check = intent.getStringExtra("note");
            this.ed_pullout.setText(this.pullout_check);
            this.ed_note.setText(this.notes_check);
            this.vehiclePulloutRequestID = intent.getIntExtra("vehiclePulloutRequestID", -1);
            this.pin = intent.getIntExtra(Constants.EXTRA_PIN, 0);
            this.btn_save_pullout.setText(getString(C2723R.string.to_be_picked_up_save).toUpperCase());
            this.delete_pullout.setVisibility(0);
            updateUI();
            this.layout_save_pullout.setEnabled(false);
            this.layout_save_pullout.setAlpha(this.disable_bg);
        }
        this.ed_note.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ToBePickedUpReviewPulloutActivity.this.view_mode != ToBePickedUpReviewPulloutActivity.SAVE_MODE) {
                    return;
                }
                if (ToBePickedUpReviewPulloutActivity.this.detectChangeInReviewFields()) {
                    ToBePickedUpReviewPulloutActivity.this.layout_save_pullout.setEnabled(true);
                    ToBePickedUpReviewPulloutActivity.this.layout_save_pullout.setAlpha(ToBePickedUpReviewPulloutActivity.this.enable_bg);
                    return;
                }
                ToBePickedUpReviewPulloutActivity.this.layout_save_pullout.setEnabled(false);
                ToBePickedUpReviewPulloutActivity.this.layout_save_pullout.setAlpha(ToBePickedUpReviewPulloutActivity.this.disable_bg);
            }
        });
        this.ed_pullout.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ToBePickedUpReviewPulloutActivity.this.view_mode != ToBePickedUpReviewPulloutActivity.SAVE_MODE) {
                    return;
                }
                if (ToBePickedUpReviewPulloutActivity.this.detectChangeInReviewFields()) {
                    ToBePickedUpReviewPulloutActivity.this.layout_save_pullout.setEnabled(true);
                    ToBePickedUpReviewPulloutActivity.this.layout_save_pullout.setAlpha(ToBePickedUpReviewPulloutActivity.this.enable_bg);
                    return;
                }
                ToBePickedUpReviewPulloutActivity.this.layout_save_pullout.setEnabled(false);
                ToBePickedUpReviewPulloutActivity.this.layout_save_pullout.setAlpha(ToBePickedUpReviewPulloutActivity.this.disable_bg);
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean detectChangeInReviewFields() {
        SparseBooleanArray checkedItemPositions = this.listView.getCheckedItemPositions();
        int i = 0;
        boolean z = false;
        for (int i2 = 0; i2 < checkedItemPositions.size(); i2++) {
            if (!checkedItemPositions.valueAt(i2)) {
                i++;
                z = true;
            }
        }
        if (i == checkedItemPositions.size()) {
            return false;
        }
        if (!z && this.ed_note.getText().toString().equalsIgnoreCase(this.notes_check) && this.ed_pullout.getText().toString().equalsIgnoreCase(this.pullout_check)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void navigateToVPRPage() {
        SparseBooleanArray checkedItemPositions = this.listView.getCheckedItemPositions();
        this.selectedItems = new ArrayList<>();
        boolean z = false;
        for (int i = 0; i < checkedItemPositions.size(); i++) {
            int keyAt = checkedItemPositions.keyAt(i);
            if (checkedItemPositions.valueAt(i)) {
                this.selectedItems.add(this.vehicleArrayList.get(keyAt));
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ToBePickedUpVehicles> it = this.selectedItems.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(Integer.parseInt(it.next().salvage)));
        }
        finish();
        Intent intent = new Intent(this, ToBePickedUpVPRActivity.class);
        intent.setFlags(67108864);
        intent.putIntegerArrayListExtra("salvage_id_array", arrayList);
        intent.putExtra("title", this.ed_pullout.getText().toString());
        intent.putExtra("note", this.ed_note.getText().toString());
        if (checkedItemPositions.size() != this.selectedItems.size()) {
            z = true;
        }
        intent.putExtra("stockModified", z);
        intent.putExtra("vehiclePulloutRequestID", this.vehiclePulloutRequestID);
        intent.putExtra(Constants.EXTRA_PIN, this.pin);
        startActivity(intent);
    }

    private void getReviewPullOutList() {
        final Dialog showProgressDialog = MDActivityHelper.showProgressDialog(this, getString(C2723R.string.msg_Loading));
        ReviewPullOutRequest reviewPullOutRequest = new ReviewPullOutRequest();
        reviewPullOutRequest.pullout_list = this.salvage_id_array;
        this.toBePickedUpManager.loadReviewPullOutList(this, new Gson().toJson((Object) reviewPullOutRequest), new AsyncHttpResponseHandler() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                ToBePickedUpReviewPulloutActivity.this.vehicleArrayList = ((ToBePickedUpList) new Gson().fromJson(new String(bArr), ToBePickedUpList.class)).vehicleArrayList;
                ToBePickedUpReviewPulloutActivity.this.updateUI();
                showProgressDialog.dismiss();
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                showProgressDialog.dismiss();
            }
        });
    }

    /* access modifiers changed from: private */
    public void updateUI() {
        ArrayList<ToBePickedUpVehicles> arrayList = this.vehicleArrayList;
        if (arrayList != null && arrayList.size() > 0) {
            this.listView.setAdapter(new ToBePickedReviewPulloutAdapter(this.vehicleArrayList, getApplicationContext()));
            for (int i = 0; i < this.listView.getCount(); i++) {
                this.listView.setItemChecked(i, true);
            }
            int size = this.vehicleArrayList.size();
            TextView textView = this.tv_vehicle_count;
            textView.setText(size + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getString(C2723R.string.lbl_vehicle_s));
            this.layout_save_pullout.setEnabled(true);
            this.layout_save_pullout.setAlpha(this.enable_bg);
        }
    }

    public void closeReviewPullout() {
        AppUtils.hideSoftkeyBoard(this, this.ed_pullout);
        AppUtils.hideSoftkeyBoard(this, this.ed_note);
        finish();
    }

    /* access modifiers changed from: private */
    public void showDeletePulloutDialog(Context context) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= 21) {
            builder = new AlertDialog.Builder(context, 16974394);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setTitle(C2723R.string.lbl_menu_delete);
        builder.setMessage(C2723R.string.tobe_picked_up_vehicle_pullout_delete_msg);
        builder.setCancelable(true);
        builder.setPositiveButton(getString(C2723R.string.lbl_OK_lower).toUpperCase(), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                ToBePickedUpReviewPulloutActivity.this.getDeletePullout();
            }
        });
        builder.setNegativeButton(getString(C2723R.string.lbl_cancel).toUpperCase(), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    /* access modifiers changed from: private */
    public void getDeletePullout() {
        final Dialog showProgressDialog = MDActivityHelper.showProgressDialog(this, getString(C2723R.string.msg_Loading));
        VPRRequestModel vPRRequestModel = new VPRRequestModel();
        vPRRequestModel.pullout_list = new ArrayList<>();
        vPRRequestModel.notes = this.ed_pullout.getText().toString();
        vPRRequestModel.title = this.ed_note.getText().toString();
        vPRRequestModel.stocksModified = true;
        vPRRequestModel.vehiclePulloutRequestID = "" + this.vehiclePulloutRequestID;
        vPRRequestModel.pin = "" + this.pin;
        this.toBePickedUpManager.loadBrachPulloutList(this, new Gson().toJson((Object) vPRRequestModel), new AsyncHttpResponseHandler() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                showProgressDialog.dismiss();
                ToBePickedUpReviewPulloutActivity.this.sendBroadcast(new Intent().setAction(Constants.INTENT_ACTION_REFRESH_TOBE_PICKEDUP_LIST));
                ToBePickedUpReviewPulloutActivity.this.setResult(-1, (Intent) null);
                ToBePickedUpReviewPulloutActivity.this.finish();
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                showProgressDialog.dismiss();
            }
        });
    }
}
