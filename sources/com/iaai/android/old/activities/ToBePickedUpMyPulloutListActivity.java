package com.iaai.android.old.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.managers.ToBePickedUpManager;
import com.iaai.android.old.models.ToBePickedUpMyPullout;
import com.iaai.android.old.utils.p016ui.MDActivityHelper;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import p052cz.msebera.android.httpclient.Header;

public class ToBePickedUpMyPulloutListActivity extends MDAbstractActivity {
    @BindView(2131297751)
    ListView pulloutlist;
    ToBePickedUpManager toBePickedUpManager;
    ArrayList<ToBePickedUpMyPullout> toBePickedUpMyPulloutArrayList = null;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_my_pullout_layout);
        ButterKnife.bind((Activity) this);
        this.toBePickedUpManager = (ToBePickedUpManager) ((IaaiApplication) getApplication()).getInjector().getInstance(ToBePickedUpManager.class);
        setSupportActionBar((Toolbar) findViewById(C2723R.C2726id.toolbar));
        getWindow().setSoftInputMode(2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle((CharSequence) getString(C2723R.string.title_my_pullout));
        this.pulloutlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent(ToBePickedUpMyPulloutListActivity.this, ToBePickedUpVPRActivity.class);
                intent.putExtra("vehiclePulloutRequestID", ToBePickedUpMyPulloutListActivity.this.toBePickedUpMyPulloutArrayList.get(i).vehiclepullOutRequestID);
                intent.putExtra("mypullout", true);
                ToBePickedUpMyPulloutListActivity.this.startActivityForResult(intent, 14);
            }
        });
        getConfirmBranchPullout();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 14 && i2 == -1) {
            getConfirmBranchPullout();
        }
    }

    private void getConfirmBranchPullout() {
        final Dialog showProgressDialog = MDActivityHelper.showProgressDialog(this, getString(C2723R.string.msg_Loading));
        this.toBePickedUpManager.loadMyPulloutList(new AsyncHttpResponseHandler() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                Gson gson = new Gson();
                String str = new String(bArr);
                Type type = new TypeToken<List<ToBePickedUpMyPullout>>() {
                }.getType();
                ToBePickedUpMyPulloutListActivity.this.toBePickedUpMyPulloutArrayList = (ArrayList) gson.fromJson(str, type);
                if (ToBePickedUpMyPulloutListActivity.this.toBePickedUpMyPulloutArrayList != null) {
                    ToBePickedUpMyPulloutListActivity toBePickedUpMyPulloutListActivity = ToBePickedUpMyPulloutListActivity.this;
                    ToBePickedUpMyPulloutListActivity.this.pulloutlist.setAdapter(new ToBePickedUpMyPulloutAdapter(toBePickedUpMyPulloutListActivity.toBePickedUpMyPulloutArrayList, ToBePickedUpMyPulloutListActivity.this.getApplicationContext()));
                }
                showProgressDialog.dismiss();
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                showProgressDialog.dismiss();
            }
        });
    }

    class ToBePickedUpMyPulloutAdapter extends BaseAdapter {
        Context context;
        private LayoutInflater inflater;
        ArrayList<ToBePickedUpMyPullout> toBePickedUpVehicles;

        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return 0;
        }

        ToBePickedUpMyPulloutAdapter(ArrayList<ToBePickedUpMyPullout> arrayList, Context context2) {
            this.context = context2;
            this.toBePickedUpVehicles = arrayList;
            this.inflater = (LayoutInflater) context2.getSystemService("layout_inflater");
        }

        public int getCount() {
            return this.toBePickedUpVehicles.size();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            ViewHolder viewHolder;
            if (view == null) {
                viewHolder = new ViewHolder();
                view2 = this.inflater.inflate(C2723R.C2728layout.custom_tobepickedup_mypullout_list, (ViewGroup) null);
                viewHolder.title_pin = (TextView) view2.findViewById(C2723R.C2726id.title_pin);
                view2.setTag(viewHolder);
            } else {
                view2 = view;
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.title_pin.setText(this.toBePickedUpVehicles.get(i).titlePIN);
            return view2;
        }
    }

    class ViewHolder {
        TextView title_pin;

        ViewHolder() {
        }
    }
}
