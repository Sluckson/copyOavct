package com.iaai.android.old.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.old.models.EmptyPost;
import com.iaai.android.old.models.IBuyFastResult;
import com.iaai.android.old.models.Vehicle;
import com.iaai.android.old.service.ActivityBaseResultReceiver;
import com.iaai.android.old.service.CommandService;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.ICommand;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.ActivityHelper;
import com.iaai.android.old.utils.p016ui.UiUtils;
import java.util.Date;
import roboguice.inject.InjectView;

public class IBuyFastActivity extends AbstractActivity {
    @InjectView(2131296614)
    private Button btnCancel;
    @InjectView(2131296655)
    private Button btnSubmit;
    /* access modifiers changed from: private */
    public SessionManager sessionManager;
    SubmitIBuyFastResultReceiver submitIBuyFastResultReceiver;
    @InjectView(2131298928)
    private TextView txtAdditionalInfo;
    @InjectView(2131298991)
    private TextView txtPrice;
    @InjectView(2131299020)
    private TextView txtTimeLeft;
    @InjectView(2131299030)
    private TextView txtVehicleName;
    /* access modifiers changed from: private */
    public Vehicle vehicle;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.ibuy_fast);
        this.sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();
        this.btnSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                IBuyFastActivity.this.submitIBuyFast();
            }
        });
        this.btnCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                IBuyFastActivity.this.finish();
            }
        });
        this.submitIBuyFastResultReceiver = new SubmitIBuyFastResultReceiver(this, new Handler());
        applyIntentData(getIntent());
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        applyIntentData(intent);
    }

    private void applyIntentData(Intent intent) {
        this.vehicle = (Vehicle) intent.getParcelableExtra(Constants.EXTRA_VEHICLE);
        this.txtVehicleName.setText(this.vehicle.toString());
        this.txtPrice.setText(UiUtils.formatCurrency(this.vehicle.ibuyFastAmount));
        this.txtTimeLeft.setText(DateHelper.calculateDateTimeDiff(this.vehicle.ibuyFastEndTime, new Date()).toString());
        this.txtAdditionalInfo.setText(String.format("%s | %s\n" + getString(C2723R.string.stock) + " %s | " + getString(C2723R.string.itemID) + " %s", new Object[]{this.vehicle.branchName, UiUtils.formatIBuyFastDate(this.vehicle.ibidLiveStartTime), this.vehicle.stockNo, this.vehicle.itemNumber}));
    }

    /* access modifiers changed from: package-private */
    public void submitIBuyFast() {
        C29723 r0 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == -1) {
                    CommandService.start(IBuyFastActivity.this, IBuyFastActivity.this.getResources().getString(C2723R.string.service_path_ibuy_fast, new Object[]{IBuyFastActivity.this.vehicle.itemId, IBuyFastActivity.this.sessionManager.getCurrentSessionUserId(), IBuyFastActivity.this.vehicle.auctionId}), new EmptyPost(), IBuyFastActivity.this.submitIBuyFastResultReceiver, IBuyFastResult.class, true);
                }
                dialogInterface.dismiss();
            }
        };
        ActivityHelper.showConfirmationDialog(this, getString(C2723R.string.dail_title_confirm_ibuy_fast), getString(C2723R.string.msg_please_confirm_your_purchase_android, new Object[]{this.vehicle.toString(), UiUtils.formatCurrency(this.vehicle.ibuyFastAmount)}), r0);
    }

    /* access modifiers changed from: package-private */
    public void handleIBuyFastResult(IBuyFastResult iBuyFastResult) {
        if (iBuyFastResult.isSuccessful) {
            C29734 r5 = new ICommand<DialogInterface>() {
                public void execute(DialogInterface dialogInterface) {
                    IBuyFastActivity.this.broadcastChanges();
                    IBuyFastActivity.this.finish();
                }
            };
            ActivityHelper.showAlert((Activity) this, getString(C2723R.string.dial_title_ibuy_fast_submitted), getString(C2723R.string.msg_ibuy_fast_placed_successfully, new Object[]{this.vehicle.toString(), UiUtils.formatCurrency(this.vehicle.ibuyFastAmount)}), (ICommand<DialogInterface>) r5);
            return;
        }
        ActivityHelper.showAlert((Activity) this, getString(C2723R.string.dial_title_cannot_place_ibuy_fast), iBuyFastResult.message, (ICommand<DialogInterface>) new ICommand<DialogInterface>() {
            public void execute(DialogInterface dialogInterface) {
                IBuyFastActivity.this.broadcastChanges();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void broadcastChanges() {
        Intent intent = new Intent(Constants.INTENT_VEHICLE_UPDATE);
        intent.putExtra(Constants.EXTRA_ITEM_ID, this.vehicle.itemId);
        sendBroadcast(intent);
    }

    static class SubmitIBuyFastResultReceiver extends ActivityBaseResultReceiver<IBuyFastActivity, IBuyFastResult> {
        public SubmitIBuyFastResultReceiver(IBuyFastActivity iBuyFastActivity, Handler handler) {
            super(iBuyFastActivity, handler);
        }

        /* access modifiers changed from: protected */
        public void onSuccess(IBuyFastActivity iBuyFastActivity, IBuyFastResult iBuyFastResult) {
            iBuyFastActivity.handleIBuyFastResult(iBuyFastResult);
        }
    }
}
