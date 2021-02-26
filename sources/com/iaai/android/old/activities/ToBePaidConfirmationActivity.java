package com.iaai.android.old.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.gson.Gson;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.old.adapter.ToBePaidListAdapter;
import com.iaai.android.old.adapter.ToBePaidReviewAdapter;
import com.iaai.android.old.analytics.AnalyticUtils;
import com.iaai.android.old.analytics.classes.AnalyticInfo;
import com.iaai.android.old.managers.ToBePaidManager;
import com.iaai.android.old.models.ToBePaidConfirmation;
import com.iaai.android.old.models.ToBePaidItemPaymentList;
import com.iaai.android.old.models.ToBePaidVehicle;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.ICommand;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.ActivityHelper;
import com.iaai.android.old.utils.p016ui.MDActivityHelper;
import com.iaai.android.old.utils.p016ui.UiUtils;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import p052cz.msebera.android.httpclient.Header;
import roboguice.application.RoboApplication;

public class ToBePaidConfirmationActivity extends AppCompatActivity {
    String DealerPhoneNumber = "";
    ToBePaidListAdapter adapter;
    ToBePaidReviewAdapter adapterNew;
    TextView afcDealerPhone;
    String afcHeader;
    @BindView(2131296407)
    TextView afcHeaderView;
    LinearLayout afcHelpLine;
    TextView afcNumber;
    ConfirmationAdapter confirmationAdapter;
    @BindView(2131298904)
    TextView doneTxt;
    TextView failureCountView;
    BigDecimal finalAmountDecimal = new BigDecimal(0);
    TextView finalAmountView;
    @BindView(2131298889)
    TextView finalSuccessCount;
    String finance;
    @BindView(2131298920)
    TextView financeAmount;
    String guidIdentifier;
    View headerView;
    private boolean isActivityInFront;
    boolean isFailed = false;
    String isMyItemOnlyString;
    Dialog mDialog;
    @BindView(2131298901)
    TextView paymentData;
    @BindView(2131297552)
    LinearLayout paymentInfo;
    TextView paymentMehodView;
    ImageView paymentMethdIcon;
    String paymentMethodType;
    public String paymentOption;
    @BindView(2131298918)
    TextView paymentReceived;
    LinearLayout paymentTermParent;
    TextView paymentTermView;
    @BindView(2131297845)
    TextView paymentType;
    @BindView(2131298223)
    ListView selectionList;
    ArrayList<String> selectionRowNumbers;
    SessionManager sessionManager;
    @BindView(2131296653)
    ImageButton shareBtn;
    @BindView(2131297557)
    LinearLayout shareParent;
    int successCount = 0;
    TextView successCountView;
    TextView sumittedDateView;
    ToBePaidConfirmation toBePaidConfirmation;
    ToBePaidManager toBePaidManager;
    BigDecimal unsuccessAmount = new BigDecimal(0);
    ArrayList<ToBePaidVehicle> vehicles;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.main_tbp_confirmation_layout);
        ButterKnife.bind((Activity) this);
        this.sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();
        getIntentData(getIntent());
        setSupportActionBar((Toolbar) findViewById(C2723R.C2726id.toolbar));
        getWindow().setSoftInputMode(2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        initialize();
        loadData();
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

    /* access modifiers changed from: private */
    public void checkWriteStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3);
        } else {
            saveScreen();
        }
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i != 3) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            AppUtils.showEnablePermissionMessage(true, this, (Fragment) null, "android.permission.WRITE_EXTERNAL_STORAGE", 3);
        } else {
            saveScreen();
        }
    }

    /* access modifiers changed from: package-private */
    public void getIntentData(Intent intent) {
        this.paymentOption = intent.getStringExtra(Constants.EXTRA_PAYMENT_OPTION);
        this.selectionRowNumbers = intent.getStringArrayListExtra(Constants.EXTRA_ROW_SELECTION);
        this.guidIdentifier = intent.getStringExtra(Constants.EXTRA_GUID_IDENTIFIER);
        this.isMyItemOnlyString = intent.getStringExtra(Constants.MY_VEHICLES_ONLY_ARG);
        this.finance = intent.getStringExtra(Constants.FINANCE_AMOUNT);
        this.paymentMethodType = intent.getStringExtra(Constants.PAYMENT_METHOD_SELECTION_TYPE);
        this.vehicles = intent.getParcelableArrayListExtra(Constants.VEHICLE_LIST_CONFIRMATION);
        this.afcHeader = intent.getStringExtra(Constants.AFC_PAYMENT_METHOD_SELCTION);
        this.DealerPhoneNumber = intent.getStringExtra(Constants.AFC_DEALER_PHONE);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            overridePendingTransition(C2723R.anim.none, C2723R.anim.push_right_out);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void initialize() {
        this.toBePaidManager = (ToBePaidManager) ((RoboApplication) getApplication()).getInjector().getInstance(ToBePaidManager.class);
        if (!this.paymentOption.equals(Constants.PAYMENT_OPTION_ACH) && this.paymentOption.equals(Constants.PAYMENT_OPTION_AFC)) {
            this.afcHeaderView.setVisibility(0);
            this.afcHeaderView.setText(this.afcHeader);
            this.paymentType.setText(C2723R.string.lbl_finance_count);
        }
        this.financeAmount.setText(this.finance);
        this.shareBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ToBePaidConfirmationActivity.this.checkWriteStoragePermission();
            }
        });
        this.doneTxt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ToBePaidConfirmationActivity.this.setResult(300);
                MDToBePaidListActivity.isConfirmationDone = true;
                ToBePaidConfirmationActivity.this.finish();
                ToBePaidConfirmationActivity.this.overridePendingTransition(C2723R.anim.none, C2723R.anim.push_right_out);
            }
        });
        this.confirmationAdapter = new ConfirmationAdapter();
    }

    private void openInCloudPrinting() {
        if (ActivityHelper.isNetworkConnected(this)) {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/IaaBuyer/PaymentConfirmation.jpeg");
            Intent intent = new Intent(this, PrintDialogActivity.class);
            intent.setDataAndType(Uri.fromFile(file), "image/jpeg");
            intent.putExtra("android.intent.extra.TITLE", "Android print demo");
            startActivity(intent);
        }
    }

    private void getCloudPrint() {
        boolean z;
        try {
            getPackageManager().getPackageInfo("com.google.android.apps.cloudprint", 0);
            z = true;
        } catch (PackageManager.NameNotFoundException unused) {
            z = false;
        }
        if (z) {
            Uri parse = Uri.parse("file://" + Environment.getExternalStorageDirectory().getAbsolutePath() + "/IaaBuyer/PaymentConfirmation.jpeg");
            Intent intent = new Intent("com.google.android.apps.cloudprint");
            intent.setType("image/jpeg");
            intent.putExtra("android.intent.extra.TITLE", "Print Test Title");
            intent.putExtra("android.intent.extra.STREAM", parse);
            startActivityForResult(intent, 0);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005d A[SYNTHETIC, Splitter:B:19:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c2 A[SYNTHETIC, Splitter:B:26:0x00c2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void saveScreen() {
        /*
            r7 = this;
            java.lang.String r0 = "PaymentConfirmation.jpeg"
            android.widget.ListView r1 = r7.selectionList
            r2 = 1
            r1.setDrawingCacheEnabled(r2)
            android.widget.ListView r1 = r7.selectionList
            r3 = 0
            r1.buildDrawingCache(r3)
            android.graphics.Bitmap r1 = r7.getWholeListViewItemsToBitmap()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r4 = r4.getAbsolutePath()
            r3.append(r4)
            java.lang.String r4 = "/IaaBuyer"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.io.File r5 = new java.io.File
            r5.<init>(r3)
            boolean r6 = r5.exists()
            if (r6 != 0) goto L_0x0039
            r5.mkdir()
        L_0x0039:
            r5 = 0
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0057 }
            r6.<init>(r3, r0)     // Catch:{ Exception -> 0x0057 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0057 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0057 }
            android.graphics.Bitmap$CompressFormat r5 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x0052, all -> 0x004f }
            r6 = 100
            r1.compress(r5, r6, r3)     // Catch:{ Exception -> 0x0052, all -> 0x004f }
            r3.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0065
        L_0x004f:
            r0 = move-exception
            r5 = r3
            goto L_0x00c0
        L_0x0052:
            r1 = move-exception
            r5 = r3
            goto L_0x0058
        L_0x0055:
            r0 = move-exception
            goto L_0x00c0
        L_0x0057:
            r1 = move-exception
        L_0x0058:
            r1.printStackTrace()     // Catch:{ all -> 0x0055 }
            if (r5 == 0) goto L_0x0065
            r5.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0065
        L_0x0061:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0065:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r3 = r3.getAbsolutePath()
            r1.append(r3)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.io.File r3 = new java.io.File
            r3.<init>(r1, r0)
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            java.lang.String r1 = "android.intent.action.SEND"
            r0.setAction(r1)
            java.lang.String r1 = "image/jpeg"
            r0.setType(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = r7.getPackageName()
            r1.append(r4)
            java.lang.String r4 = ".provider"
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            android.net.Uri r1 = androidx.core.content.FileProvider.getUriForFile(r7, r1, r3)
            java.lang.String r3 = "android.intent.extra.STREAM"
            r0.putExtra(r3, r1)
            r0.addFlags(r2)
            r1 = 2131821743(0x7f1104af, float:1.9276238E38)
            java.lang.String r1 = r7.getString(r1)
            android.content.Intent r0 = android.content.Intent.createChooser(r0, r1)
            r7.startActivity(r0)
            return
        L_0x00c0:
            if (r5 == 0) goto L_0x00ca
            r5.close()     // Catch:{ IOException -> 0x00c6 }
            goto L_0x00ca
        L_0x00c6:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00ca:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.old.activities.ToBePaidConfirmationActivity.saveScreen():void");
    }

    public Bitmap getWholeListViewItemsToBitmap() {
        ListView listView = this.selectionList;
        ListAdapter adapter2 = listView.getAdapter();
        int count = adapter2.getCount();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < count; i2++) {
            View view = adapter2.getView(i2, (View) null, listView);
            view.measure(View.MeasureSpec.makeMeasureSpec(listView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            arrayList.add(view.getDrawingCache());
            i += view.getMeasuredHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(listView.getMeasuredWidth(), i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            Bitmap bitmap = (Bitmap) arrayList.get(i4);
            canvas.drawBitmap(bitmap, 0.0f, (float) i3, paint);
            i3 += bitmap.getHeight();
            bitmap.recycle();
        }
        return createBitmap;
    }

    public void onBackPressed() {
        setResult(300);
        ToBePaidActivity.isConfirmationDone = true;
        finish();
    }

    private void loadData() {
        StringBuilder sb = new StringBuilder();
        final int i = 0;
        for (int i2 = 0; i2 < this.selectionRowNumbers.size(); i2++) {
            if (i2 == this.selectionRowNumbers.size() - 1) {
                sb.append(this.selectionRowNumbers.get(i2));
            } else {
                sb.append(this.selectionRowNumbers.get(i2) + ",");
            }
        }
        final Dialog showLoadingDialog = MDActivityHelper.showLoadingDialog(this);
        if (this.sessionManager.getCurrentSessionUserId() != null) {
            i = Integer.parseInt(this.sessionManager.getCurrentSessionUserId());
        }
        this.toBePaidManager.getIpayConfirmation(sb.toString(), this.guidIdentifier, this.paymentMethodType, new AsyncHttpResponseHandler() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                Gson gson = new Gson();
                String str = new String(bArr);
                Log.d("Responce", str);
                ToBePaidConfirmationActivity.this.toBePaidConfirmation = (ToBePaidConfirmation) gson.fromJson(str, ToBePaidConfirmation.class);
                ToBePaidConfirmationActivity toBePaidConfirmationActivity = ToBePaidConfirmationActivity.this;
                toBePaidConfirmationActivity.successCount = 0;
                toBePaidConfirmationActivity.isFailed = false;
                toBePaidConfirmationActivity.addHeaderView();
                if (ToBePaidConfirmationActivity.this.paymentMethodType.equals(Constants.PAYMENT_OPTION_ACH)) {
                    if (!ToBePaidConfirmationActivity.this.checkPaymentReferenceNumber()) {
                        ToBePaidConfirmationActivity.this.recreateListIpay();
                        ToBePaidConfirmationActivity.this.updateIpayValueNew();
                        ToBePaidConfirmationActivity.this.displaySearchResult();
                        AnalyticUtils.logAnalytics(ToBePaidConfirmationActivity.this, new AnalyticInfo(i, 0, 0, 8, System.currentTimeMillis(), ""));
                        ToBePaidConfirmationActivity.this.logIAAPaymentEvents();
                    }
                } else if (!ToBePaidConfirmationActivity.this.checkAFCErroFlag()) {
                    ToBePaidConfirmationActivity.this.recreateListAFC();
                    ToBePaidConfirmationActivity.this.updateAFCValueNew();
                    ToBePaidConfirmationActivity.this.displaySearchResult();
                    AnalyticUtils.logAnalytics(ToBePaidConfirmationActivity.this, new AnalyticInfo(i, 0, 0, 6, System.currentTimeMillis(), ""));
                    ToBePaidConfirmationActivity.this.logIAAPaymentEvents();
                }
                showLoadingDialog.dismiss();
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                Toast.makeText(ToBePaidConfirmationActivity.this.getApplicationContext(), C2723R.string.msg_network_error, 0).show();
                showLoadingDialog.dismiss();
            }
        });
    }

    /* access modifiers changed from: private */
    public void logIAAPaymentEvents() {
        double parseDouble = Double.parseDouble(this.finance.substring(1).replaceAll(",", ""));
        Bundle bundle = new Bundle();
        bundle.putDouble(IAAAnalytics.FireBaseKeyNames.VALUE.getId(), parseDouble);
        bundle.putString(IAAAnalytics.FireBaseKeyNames.CURRENCY.getId(), IAAAnalytics.FireBaseValueNames.USD.getId());
        if (this.paymentOption.equals(Constants.PAYMENT_OPTION_ACH)) {
            bundle.putString(IAAAnalytics.FireBaseKeyNames.SOURCE.getId(), IAAAnalytics.FireBaseValueNames.IPay.getId());
        } else if (this.paymentOption.equals(Constants.PAYMENT_OPTION_AFC)) {
            bundle.putString(IAAAnalytics.FireBaseKeyNames.SOURCE.getId(), IAAAnalytics.FireBaseValueNames.AFC.getId());
        }
        Log.e("FIRE_BASE_ANALYTICS", "Sending Event: " + IAAAnalytics.IAAEvents.PAYMENT.getId() + " :" + bundle);
        IAAAnalytics.INSTANCE.logIAAEvent(IAAAnalytics.IAAEvents.PAYMENT, bundle, this.sessionManager);
    }

    /* access modifiers changed from: private */
    public void addHeaderView() {
        this.headerView = LayoutInflater.from(this).inflate(C2723R.C2728layout.include_confirmation_header, (ViewGroup) null, false);
        this.paymentMethdIcon = (ImageView) this.headerView.findViewById(C2723R.C2726id.payment_method_logo);
        this.finalAmountView = (TextView) this.headerView.findViewById(C2723R.C2726id.txt_final_amount);
        this.sumittedDateView = (TextView) this.headerView.findViewById(C2723R.C2726id.txt_submitted_date);
        this.successCountView = (TextView) this.headerView.findViewById(C2723R.C2726id.txt_success_count);
        this.failureCountView = (TextView) this.headerView.findViewById(C2723R.C2726id.txt_failure_count);
        this.paymentMehodView = (TextView) this.headerView.findViewById(C2723R.C2726id.txt_payment_method);
        this.paymentTermView = (TextView) this.headerView.findViewById(C2723R.C2726id.txt_payment_term);
        this.paymentTermParent = (LinearLayout) this.headerView.findViewById(C2723R.C2726id.ll_payment_term);
        this.afcHelpLine = (LinearLayout) this.headerView.findViewById(C2723R.C2726id.afc_question_parent);
        this.afcDealerPhone = (TextView) this.headerView.findViewById(C2723R.C2726id.afc_questions);
    }

    public void updateIpayValueNew() {
        this.shareParent.setVisibility(0);
        this.paymentMethdIcon.setImageResource(C2723R.C2725drawable.ipay_logo);
        this.finalAmountDecimal = this.toBePaidConfirmation.TotalSelectedAmount;
        this.finalAmountDecimal = this.finalAmountDecimal.subtract(this.unsuccessAmount);
        this.finalAmountView.setText(UiUtils.formatCurrency(this.finalAmountDecimal));
        String convertFormat = DateHelper.convertFormat(this.toBePaidConfirmation.SubmitDateTime, Constants.DATE_PATTERN_DATE_TIME, Constants.DATE_PATTERN_CONFIRMATION_HEADER);
        this.sumittedDateView.setText(getString(C2723R.string.lbl_confirmation_date, new Object[]{convertFormat}));
        TextView textView = this.successCountView;
        textView.setText(this.successCount + "");
        this.failureCountView.setText(getString(C2723R.string.lbl_fail_item_message, new Object[]{UiUtils.formatCurrency(this.toBePaidConfirmation.TotalSelectedAmount), Integer.valueOf(this.vehicles.size() - this.successCount)}));
        this.paymentTermParent.setVisibility(8);
        this.paymentMehodView.setText(C2723R.string.btn_lbl_ipay);
        this.selectionList.addHeaderView(this.headerView);
        if (this.successCount == this.vehicles.size() || this.successCount == 0) {
            this.failureCountView.setVisibility(8);
        } else {
            this.failureCountView.setVisibility(0);
        }
        this.afcHelpLine.setVisibility(8);
    }

    public void updateAFCValueNew() {
        this.shareParent.setVisibility(0);
        this.paymentMethdIcon.setImageResource(C2723R.C2725drawable.afc_logo);
        this.finalAmountDecimal = this.toBePaidConfirmation.AFCResponseList.TotalAmountToBeFloored;
        this.finalAmountDecimal = this.finalAmountDecimal.subtract(this.unsuccessAmount);
        this.finalAmountView.setText(UiUtils.formatCurrency(this.finalAmountDecimal));
        String convertFormat = DateHelper.convertFormat(this.toBePaidConfirmation.SubmitDateTime, Constants.DATE_PATTERN_DATE_TIME, Constants.DATE_PATTERN_CONFIRMATION_HEADER);
        this.sumittedDateView.setText(getString(C2723R.string.lbl_confirmation_date, new Object[]{convertFormat}));
        this.successCountView.setText(Integer.toString(this.vehicles.size()));
        this.failureCountView.setText(getString(C2723R.string.lbl_fail_item_message, new Object[]{UiUtils.formatCurrency(this.toBePaidConfirmation.AFCResponseList.TotalAmountToBeFloored), Integer.valueOf(this.vehicles.size() - this.successCount)}));
        this.paymentTermParent.setVisibility(0);
        this.paymentMehodView.setText(C2723R.string.btn_lbl_afc);
        this.paymentTermView.setText(this.afcHeader);
        this.selectionList.addHeaderView(this.headerView);
        if (this.successCount == this.vehicles.size() || this.successCount == 0) {
            this.failureCountView.setVisibility(8);
        } else {
            this.failureCountView.setVisibility(0);
        }
        this.afcDealerPhone.setText(getString(C2723R.string.lbl_afc_dealer_phone, new Object[]{this.DealerPhoneNumber}));
    }

    public void recreateListAFC() {
        ArrayList<ToBePaidVehicle> arrayList = new ArrayList<>();
        for (int i = 0; i < this.toBePaidConfirmation.AFCResponseList.VehicleList.size(); i++) {
            if (this.toBePaidConfirmation.PaymentRefenceNumber > 0) {
                this.successCount++;
            }
            arrayList.add(getVehicleDetailsUsingSalvageId(this.toBePaidConfirmation.AFCResponseList.VehicleList.get(i).SalvageID));
        }
        this.vehicles = arrayList;
    }

    public void recreateListIpay() {
        ArrayList<ToBePaidVehicle> arrayList = new ArrayList<>();
        int i = 0;
        for (int i2 = 0; i2 < this.toBePaidConfirmation.ItemPaymentDetailsList.size(); i2++) {
            ToBePaidItemPaymentList toBePaidItemPaymentList = this.toBePaidConfirmation.ItemPaymentDetailsList.get(i2);
            if (toBePaidItemPaymentList.IpayReferenceNo < 0) {
                ToBePaidVehicle vehicleDetails = getVehicleDetails(toBePaidItemPaymentList.RowNumber);
                this.unsuccessAmount = this.unsuccessAmount.add(vehicleDetails.getTotalDue());
                arrayList.add(0, vehicleDetails);
                this.isFailed = true;
            } else {
                if (i == 0) {
                    i = toBePaidItemPaymentList.RowNumber;
                }
                arrayList.add(getVehicleDetails(toBePaidItemPaymentList.RowNumber));
                this.successCount++;
            }
        }
        this.vehicles = arrayList;
        this.confirmationAdapter.changePosition = getChangePosition(i);
    }

    private int getChangePosition(int i) {
        for (int i2 = 0; i2 < this.vehicles.size(); i2++) {
            if (this.vehicles.get(i2).RowNumber == i) {
                return i2;
            }
        }
        return 0;
    }

    public boolean checkPaymentReferenceNumber() {
        int i = (int) this.toBePaidConfirmation.PaymentRefenceNumber;
        if (i != 0 && i != -2 && i != -99 && i != -1 && i != -3) {
            return false;
        }
        MDActivityHelper.showAlert((Activity) this, getString(C2723R.string.lbl_ipay_error_header), getErrorCodes((int) this.toBePaidConfirmation.PaymentRefenceNumber), (ICommand<DialogInterface>) new ICommand<DialogInterface>() {
            public void execute(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
                ToBePaidConfirmationActivity.this.setResult(300);
                ToBePaidActivity.isConfirmationDone = true;
                ToBePaidConfirmationActivity.this.finish();
            }
        });
        return true;
    }

    public boolean checkAFCErroFlag() {
        String errorCodes = getErrorCodes((int) this.toBePaidConfirmation.PaymentRefenceNumber);
        if (TextUtils.isEmpty(errorCodes)) {
            return false;
        }
        MDActivityHelper.showAlert((Activity) this, getString(C2723R.string.lbl_afc_error_header), errorCodes, (ICommand<DialogInterface>) new ICommand<DialogInterface>() {
            public void execute(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
                ToBePaidConfirmationActivity.this.setResult(300);
                ToBePaidActivity.isConfirmationDone = true;
                ToBePaidConfirmationActivity.this.finish();
            }
        });
        return true;
    }

    public ToBePaidVehicle getVehicleDetails(int i) {
        for (int i2 = 0; i2 < this.vehicles.size(); i2++) {
            if (this.vehicles.get(i2).RowNumber == i) {
                return this.vehicles.get(i2);
            }
        }
        return null;
    }

    public ToBePaidVehicle getVehicleDetailsUsingSalvageId(String str) {
        for (int i = 0; i < this.vehicles.size(); i++) {
            if (this.vehicles.get(i).SalvageId.equals(str)) {
                return this.vehicles.get(i);
            }
        }
        return null;
    }

    private void updateValueIPay() {
        int i = this.successCount;
        if (i > 0) {
            this.finalSuccessCount.setText(getString(C2723R.string.lbl_success_count, new Object[]{Integer.valueOf(i), Integer.valueOf(this.vehicles.size())}));
            this.finalAmountDecimal = this.toBePaidConfirmation.TotalSelectedAmount;
            this.finalAmountDecimal = this.finalAmountDecimal.subtract(this.unsuccessAmount);
            this.paymentReceived.setText(getString(C2723R.string.lbl_payment_received, new Object[]{UiUtils.formatCurrency(this.finalAmountDecimal)}));
            this.paymentData.setText(this.toBePaidConfirmation.SubmitDateTime);
            return;
        }
        this.finalSuccessCount.setText(getString(C2723R.string.lbl_unsuccess_count, new Object[]{Integer.valueOf(this.vehicles.size()), Integer.valueOf(this.vehicles.size())}));
        this.paymentReceived.setVisibility(8);
        this.paymentData.setVisibility(8);
    }

    private void updateValueAFC() {
        int i = this.successCount;
        if (i > 0) {
            this.finalSuccessCount.setText(getString(C2723R.string.lbl_success_count, new Object[]{Integer.valueOf(i), Integer.valueOf(this.vehicles.size())}));
            this.finalAmountDecimal = this.toBePaidConfirmation.AFCResponseList.TotalAmountToBeFloored;
            this.finalAmountDecimal = this.finalAmountDecimal.subtract(this.unsuccessAmount);
            this.paymentReceived.setText(getString(C2723R.string.lbl_payment_received, new Object[]{UiUtils.formatCurrency(this.finalAmountDecimal)}));
            this.paymentData.setText(this.toBePaidConfirmation.SubmitDateTime);
            return;
        }
        this.finalSuccessCount.setText(getString(C2723R.string.lbl_unsuccess_count, new Object[]{Integer.valueOf(this.vehicles.size()), Integer.valueOf(this.vehicles.size())}));
        this.paymentReceived.setVisibility(8);
        this.paymentData.setVisibility(8);
    }

    public void displaySearchResult() {
        ActivityHelper.dismissDialog(this);
        this.selectionList.setAdapter(this.confirmationAdapter);
    }

    public String getErrorCodes(int i) {
        if (i == -99) {
            return getString(this.paymentMethodType.equals(Constants.PAYMENT_OPTION_ACH) ? C2723R.string.error_ipay_code_99 : C2723R.string.error_afc_code_99);
        } else if (i == -5) {
            return getString(C2723R.string.afc_generic_error);
        } else {
            if (i == 15) {
                return getString(C2723R.string.afc_finance_pending);
            }
            if (i == 20) {
                return getString(C2723R.string.afc_no_credit_available);
            }
            switch (i) {
                case -11:
                    return getString(C2723R.string.afc_delear_not_found);
                case -10:
                    return getString(C2723R.string.afc_stock_limit_exceeds);
                case -9:
                    return getString(C2723R.string.afc_generic_error);
                case -8:
                    return getString(C2723R.string.msg_afc_error, new Object[]{this.toBePaidConfirmation.AFCResponseList.DealerPhone});
                case -7:
                    return getString(C2723R.string.afc_generic_error);
                default:
                    switch (i) {
                        case -3:
                            return this.paymentMethodType.equals(Constants.PAYMENT_OPTION_ACH) ? getString(C2723R.string.error_ipay_code_3) : getString(C2723R.string.afc_generic_error);
                        case -2:
                            return getString(C2723R.string.error_ipay_code_2);
                        case -1:
                            return getString(C2723R.string.error_ipay_code_1);
                        case 0:
                            return getString(C2723R.string.error_ipay_code_0);
                        case 1:
                            return getString(C2723R.string.afc_no_responce);
                        case 2:
                            return getString(C2723R.string.afc_delear_not_found);
                        case 3:
                            return getString(C2723R.string.msg_afc_error, new Object[]{this.toBePaidConfirmation.AFCResponseList.DealerPhone});
                        case 4:
                            return getString(C2723R.string.afc_generic_error);
                        case 5:
                            return getString(C2723R.string.afc_generic_error);
                        case 6:
                            return getString(C2723R.string.afc_generic_error);
                        default:
                            return "";
                    }
            }
        }
    }

    public String getAFCErrorMessage1(int i) {
        if (i == -3) {
            return getString(C2723R.string.error_ipay_code_3);
        }
        if (i == 15) {
            return getString(C2723R.string.afc_finance_pending);
        }
        if (i == 20) {
            return getString(C2723R.string.afc_no_credit_available);
        }
        if (i == 1) {
            return getString(C2723R.string.afc_no_responce);
        }
        if (i == 2) {
            return getString(C2723R.string.afc_delear_not_found);
        }
        if (i == 3) {
            return getString(C2723R.string.afc_no_credit_available);
        }
        if (i != 5) {
            return i != 6 ? "" : getString(C2723R.string.afc_no_responce);
        }
        return getString(C2723R.string.afc_no_responce);
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

    public class ConfirmationAdapter extends BaseAdapter {
        int changePosition = 0;
        ArrayList<String> refrenceNumbers = new ArrayList<>();

        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return 0;
        }

        public ConfirmationAdapter() {
        }

        public int getCount() {
            return ToBePaidConfirmationActivity.this.vehicles.size();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            ConfirmationHolder confirmationHolder;
            if (view == null) {
                confirmationHolder = new ConfirmationHolder();
                view2 = LayoutInflater.from(ToBePaidConfirmationActivity.this).inflate(C2723R.C2728layout.tobepaid_confirmation_row, viewGroup, false);
                confirmationHolder.parent = (LinearLayout) view2.findViewById(C2723R.C2726id.parent);
                confirmationHolder.space = view2.findViewById(C2723R.C2726id.space);
                confirmationHolder.ymm = (TextView) view2.findViewById(C2723R.C2726id.txt_year_make_model_tbp);
                confirmationHolder.stockNo = (TextView) view2.findViewById(C2723R.C2726id.txt_stock_no);
                confirmationHolder.vin = (TextView) view2.findViewById(C2723R.C2726id.txt_vin_tbp);
                confirmationHolder.branch = (TextView) view2.findViewById(C2723R.C2726id.txt_branch_tbp);
                confirmationHolder.amount = (TextView) view2.findViewById(C2723R.C2726id.txt_amount);
                confirmationHolder.referenceNumber = (TextView) view2.findViewById(C2723R.C2726id.txt_ref_number);
                confirmationHolder.pickUpDetail = (TextView) view2.findViewById(C2723R.C2726id.pick_up_date);
                confirmationHolder.branchLocation = (TextView) view2.findViewById(C2723R.C2726id.txt_branch);
                confirmationHolder.errorView = (TextView) view2.findViewById(C2723R.C2726id.txt_section_message);
                confirmationHolder.errorText = (TextView) view2.findViewById(C2723R.C2726id.error_text);
                confirmationHolder.offSite = (TextView) view2.findViewById(C2723R.C2726id.txt_off_site);
                view2.setTag(confirmationHolder);
            } else {
                view2 = view;
                confirmationHolder = (ConfirmationHolder) view.getTag();
            }
            ToBePaidVehicle toBePaidVehicle = ToBePaidConfirmationActivity.this.vehicles.get(i);
            confirmationHolder.parent.setBackgroundResource(C2723R.C2725drawable.confirmtable_bgshadow);
            if (i != 0 && (this.changePosition != i || !ToBePaidConfirmationActivity.this.isFailed)) {
                confirmationHolder.errorView.setVisibility(8);
            } else if (ToBePaidConfirmationActivity.this.toBePaidConfirmation.ItemPaymentDetailsList == null) {
                ArrayList<String> arrayList = this.refrenceNumbers;
                if (arrayList.contains(ToBePaidConfirmationActivity.this.toBePaidConfirmation.PaymentRefenceNumber + "")) {
                    confirmationHolder.errorView.setVisibility(8);
                } else {
                    ArrayList<String> arrayList2 = this.refrenceNumbers;
                    arrayList2.add(ToBePaidConfirmationActivity.this.toBePaidConfirmation.PaymentRefenceNumber + "");
                    confirmationHolder.errorView.setVisibility(0);
                    TextView textView = confirmationHolder.errorView;
                    ToBePaidConfirmationActivity toBePaidConfirmationActivity = ToBePaidConfirmationActivity.this;
                    textView.setText(toBePaidConfirmationActivity.getString(C2723R.string.lbl_success_item_message_short, new Object[]{Integer.valueOf(toBePaidConfirmationActivity.successCount)}));
                    confirmationHolder.errorView.setTextColor(ToBePaidConfirmationActivity.this.getResources().getColor(C2723R.C2724color.iaa_txt_green));
                    confirmationHolder.space.setVisibility(0);
                }
            } else if (getToBePaidItemPayment(toBePaidVehicle).SuccessInd) {
                confirmationHolder.errorView.setVisibility(0);
                confirmationHolder.errorView.setTextColor(ToBePaidConfirmationActivity.this.getResources().getColor(C2723R.C2724color.iaa_txt_green));
                TextView textView2 = confirmationHolder.errorView;
                ToBePaidConfirmationActivity toBePaidConfirmationActivity2 = ToBePaidConfirmationActivity.this;
                textView2.setText(toBePaidConfirmationActivity2.getString(C2723R.string.lbl_success_item_message_short, new Object[]{Integer.valueOf(toBePaidConfirmationActivity2.successCount)}));
                confirmationHolder.space.setVisibility(0);
            } else {
                confirmationHolder.errorView.setVisibility(0);
                confirmationHolder.errorView.setTextColor(ToBePaidConfirmationActivity.this.getResources().getColor(C2723R.C2724color.iaa_txt_red));
                TextView textView3 = confirmationHolder.errorView;
                ToBePaidConfirmationActivity toBePaidConfirmationActivity3 = ToBePaidConfirmationActivity.this;
                textView3.setText(toBePaidConfirmationActivity3.getString(C2723R.string.lbl_payment_issue, new Object[]{Integer.valueOf(toBePaidConfirmationActivity3.vehicles.size() - ToBePaidConfirmationActivity.this.successCount)}));
                confirmationHolder.space.setVisibility(0);
            }
            confirmationHolder.ymm.setText(toBePaidVehicle.getMake());
            confirmationHolder.stockNo.setText(toBePaidVehicle.getStockNumber());
            confirmationHolder.vin.setText(toBePaidVehicle.getVIN());
            if (toBePaidVehicle.OffSiteIndicator == null || !toBePaidVehicle.OffSiteIndicator.booleanValue()) {
                confirmationHolder.offSite.setVisibility(8);
            } else {
                confirmationHolder.offSite.setVisibility(0);
            }
            if (toBePaidVehicle.isPartialPaymentInd()) {
                TextView textView4 = confirmationHolder.amount;
                textView4.setText(ToBePaidConfirmationActivity.this.getString(C2723R.string.lbl_balance_due) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + toBePaidVehicle.getTotalDueString());
            } else {
                TextView textView5 = confirmationHolder.amount;
                textView5.setText(ToBePaidConfirmationActivity.this.getString(C2723R.string.lbl_total_due) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + toBePaidVehicle.getTotalDueString());
            }
            if (ToBePaidConfirmationActivity.this.paymentMethodType.equals(Constants.PAYMENT_OPTION_ACH)) {
                String errorCodes = ToBePaidConfirmationActivity.this.getErrorCodes((int) getToBePaidItemPayment(toBePaidVehicle).IpayReferenceNo);
                if (!TextUtils.isEmpty(errorCodes)) {
                    confirmationHolder.errorText.setVisibility(0);
                    confirmationHolder.errorText.setText(errorCodes);
                    confirmationHolder.pickUpDetail.setVisibility(8);
                } else {
                    confirmationHolder.errorText.setVisibility(8);
                    if (!TextUtils.isEmpty(toBePaidVehicle.PickUpduedate)) {
                        String convertFormat = DateHelper.convertFormat(toBePaidVehicle.PickUpduedate, Constants.DATE_PATTERN_DATE_TIME, Constants.DATE_PATTERN_CONFIRMATION_HEADER);
                        confirmationHolder.pickUpDetail.setText(Html.fromHtml(ToBePaidConfirmationActivity.this.getString(C2723R.string.lbl_pick_up_confirmaton, new Object[]{convertFormat})));
                    } else {
                        confirmationHolder.pickUpDetail.setVisibility(8);
                    }
                }
            } else {
                ToBePaidConfirmationActivity toBePaidConfirmationActivity4 = ToBePaidConfirmationActivity.this;
                String errorCodes2 = toBePaidConfirmationActivity4.getErrorCodes((int) toBePaidConfirmationActivity4.toBePaidConfirmation.PaymentRefenceNumber);
                if (!TextUtils.isEmpty(errorCodes2)) {
                    confirmationHolder.errorText.setVisibility(0);
                    confirmationHolder.errorText.setText(errorCodes2);
                    confirmationHolder.pickUpDetail.setVisibility(8);
                } else {
                    confirmationHolder.errorText.setVisibility(8);
                    if (!TextUtils.isEmpty(toBePaidVehicle.PickUpduedate)) {
                        String convertFormat2 = DateHelper.convertFormat(toBePaidVehicle.PickUpduedate, Constants.DATE_PATTERN_DATE_TIME, Constants.DATE_PATTERN_CONFIRMATION_HEADER);
                        confirmationHolder.pickUpDetail.setText(Html.fromHtml(ToBePaidConfirmationActivity.this.getString(C2723R.string.lbl_pick_up_confirmaton, new Object[]{convertFormat2})));
                    } else {
                        confirmationHolder.pickUpDetail.setVisibility(8);
                    }
                }
            }
            confirmationHolder.branchLocation.setText(toBePaidVehicle.getBranchnameNoComma(ToBePaidConfirmationActivity.this));
            if (ToBePaidConfirmationActivity.this.toBePaidConfirmation.ItemPaymentDetailsList != null && getToBePaidItemPayment(toBePaidVehicle).SuccessInd) {
                confirmationHolder.referenceNumber.setVisibility(0);
                TextView textView6 = confirmationHolder.referenceNumber;
                ToBePaidConfirmationActivity toBePaidConfirmationActivity5 = ToBePaidConfirmationActivity.this;
                textView6.setText(toBePaidConfirmationActivity5.getString(C2723R.string.lbl_confirmation_ref, new Object[]{getToBePaidItemPayment(toBePaidVehicle).IpayReferenceNo + ""}));
            } else if (ToBePaidConfirmationActivity.this.toBePaidConfirmation.AFCResponseList != null) {
                confirmationHolder.referenceNumber.setVisibility(0);
                TextView textView7 = confirmationHolder.referenceNumber;
                ToBePaidConfirmationActivity toBePaidConfirmationActivity6 = ToBePaidConfirmationActivity.this;
                textView7.setText(toBePaidConfirmationActivity6.getString(C2723R.string.lbl_confirmation_ref, new Object[]{ToBePaidConfirmationActivity.this.toBePaidConfirmation.PaymentRefenceNumber + ""}));
            } else {
                confirmationHolder.referenceNumber.setVisibility(8);
            }
            return view2;
        }

        private ToBePaidItemPaymentList getToBePaidItemPayment(ToBePaidVehicle toBePaidVehicle) {
            for (int i = 0; i < ToBePaidConfirmationActivity.this.toBePaidConfirmation.ItemPaymentDetailsList.size(); i++) {
                ToBePaidItemPaymentList toBePaidItemPaymentList = ToBePaidConfirmationActivity.this.toBePaidConfirmation.ItemPaymentDetailsList.get(i);
                if (toBePaidItemPaymentList.RowNumber == toBePaidVehicle.RowNumber) {
                    return toBePaidItemPaymentList;
                }
            }
            return null;
        }
    }

    private static class ConfirmationHolder {
        TextView amount;
        TextView branch;
        TextView branchLocation;
        TextView errorText;
        TextView errorView;
        TextView offSite;
        LinearLayout parent;
        TextView pickUpDetail;
        TextView referenceNumber;
        View space;
        TextView stockNo;
        TextView vin;
        TextView ymm;

        private ConfirmationHolder() {
        }
    }
}
