package com.iaai.android.old.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.inject.Inject;
import com.iaai.android.C2723R;
import com.iaai.android.old.managers.BidManager;
import com.iaai.android.old.managers.LoginStateChangeEventListener;
import com.iaai.android.old.managers.OnLoginStateChangeEvent;
import com.iaai.android.old.models.Bid;
import com.iaai.android.old.models.BidResult;
import com.iaai.android.old.models.Vehicle;
import com.iaai.android.old.service.ActivityBaseResultReceiver;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.ICommand;
import com.iaai.android.old.utils.Validator;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.ActivityHelper;
import com.iaai.android.old.utils.p016ui.CloseSoftKeyboardEnforcer;
import com.iaai.android.old.utils.p016ui.UiUtils;
import java.math.BigDecimal;
import java.util.Date;
import roboguice.event.Observes;
import roboguice.inject.InjectExtra;
import roboguice.inject.InjectResource;
import roboguice.inject.InjectView;

public class SealedBidEntryActivity extends AbstractActivity {
    @Inject
    BidManager bidManager;
    @InjectView(2131296623)
    private Button btnDeleteBid;
    /* access modifiers changed from: private */
    @InjectView(2131296640)
    public Button btnPlaceBid;
    @Inject
    private CloseSoftKeyboardEnforcer closeSoftKeyboardEnforcer;
    DeleteBidResultReceiver deleteBidResultReceiver;
    ICommand<DialogInterface> finishActivityCommand;
    @InjectResource(2131820865)
    private String labelBidDeleted;
    @InjectResource(2131820886)
    private String labelBidSubmitted;
    @Inject
    private LoginStateChangeEventListener loginStateChangeEventListener;
    PlaceBidResultReceiver placeBidResultReceiver;
    @InjectView(2131298876)
    private TextView txtBid;
    @InjectView(2131299020)
    private TextView txtTimeLeft;
    @InjectExtra("vehicle")
    private Vehicle vehicle;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.sealed_bid_entry);
        this.txtBid.addTextChangedListener(new Validator.DecimalFormatTextWatcher(9, 2));
        this.txtBid.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                ActivityHelper.closeSoftKeyboard(SealedBidEntryActivity.this, textView);
                return i == 6;
            }
        });
        Handler handler = new Handler();
        this.placeBidResultReceiver = new PlaceBidResultReceiver(this, handler);
        this.deleteBidResultReceiver = new DeleteBidResultReceiver(this, handler);
        commitIntentData(getIntent());
        this.btnPlaceBid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SealedBidEntryActivity.this.placeBid();
            }
        });
        this.btnDeleteBid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SealedBidEntryActivity.this.deleteBid();
            }
        });
        this.finishActivityCommand = new ICommand<DialogInterface>() {
            public void execute(DialogInterface dialogInterface) {
                SealedBidEntryActivity.this.broadcastChanges();
                SealedBidEntryActivity sealedBidEntryActivity = SealedBidEntryActivity.this;
                ActivityHelper.closeSoftKeyboard(sealedBidEntryActivity, sealedBidEntryActivity.btnPlaceBid);
                SealedBidEntryActivity.this.finish();
            }
        };
    }

    private void handleLoginStateChange(@Observes OnLoginStateChangeEvent onLoginStateChangeEvent) {
        finish();
    }

    /* access modifiers changed from: package-private */
    public void placeBid() {
        String replaceAll = this.txtBid.getText().toString().replaceAll(",", "");
        if (TextUtils.isEmpty(replaceAll)) {
            Toast.makeText(this, getString(C2723R.string.msg_cannot_be_blank, new Object[]{getString(C2723R.string.lbl_sealed_bid)}), 0).show();
            return;
        }
        this.bidManager.placeBid(this.vehicle.itemId, this.vehicle.auctionId, new Bid(new BigDecimal(replaceAll), BigDecimal.ZERO), this.placeBidResultReceiver);
    }

    /* access modifiers changed from: package-private */
    public void deleteBid() {
        this.bidManager.deleteBid(this.vehicle.itemId, this.vehicle.auctionId, this.deleteBidResultReceiver);
    }

    private void commitIntentData(Intent intent) {
        this.vehicle = (Vehicle) intent.getParcelableExtra(Constants.EXTRA_VEHICLE);
        this.txtBid.setText((this.vehicle.userCurrentBidAmount == null ? IdManager.DEFAULT_VERSION_NAME : this.vehicle.userCurrentBidAmount).toString());
        if (this.vehicle.hasUserPlacedBidBefore) {
            this.btnPlaceBid.setText(C2723R.string.lbl_btn_change_bid);
            this.btnDeleteBid.setVisibility(0);
        } else {
            this.btnPlaceBid.setText(C2723R.string.lbl_btn_bid);
            this.btnDeleteBid.setVisibility(8);
        }
        this.txtTimeLeft.setText(DateHelper.calculateDateTimeDiff(new Date(), this.vehicle.preBidEndTime).toString());
    }

    /* access modifiers changed from: package-private */
    public void handlePlaceBidResult(BidResult bidResult) {
        if (bidResult.isSuccessful) {
            ActivityHelper.showAlert((Activity) this, this.labelBidSubmitted, getString(C2723R.string.msg_bid_placed_successfully, new Object[]{UiUtils.formatCurrency(UiUtils.toBigDecimal(this.txtBid.getText().toString())), this.vehicle.toString(), bidResult.confirmationNo}), this.finishActivityCommand);
            return;
        }
        ActivityHelper.showAlert((Activity) this, getString(C2723R.string.dial_title_cannot_place_bid), bidResult.getErrorMessage(), this.finishActivityCommand);
    }

    /* access modifiers changed from: package-private */
    public void handleDeleteBidResult(BidResult bidResult) {
        if (bidResult.isSuccessful) {
            ActivityHelper.showAlert((Activity) this, this.labelBidDeleted, (String) null, this.finishActivityCommand);
        } else {
            ActivityHelper.showAlert((Activity) this, getString(C2723R.string.dial_title_cannot_delete_bid), bidResult.getErrorMessage(), this.finishActivityCommand);
        }
    }

    /* access modifiers changed from: package-private */
    public void broadcastChanges() {
        Intent intent = new Intent(Constants.INTENT_VEHICLE_UPDATE);
        intent.putExtra(Constants.EXTRA_ITEM_ID, this.vehicle.itemId);
        sendBroadcast(intent);
    }

    static class PlaceBidResultReceiver extends ActivityBaseResultReceiver<SealedBidEntryActivity, BidResult> {
        public PlaceBidResultReceiver(SealedBidEntryActivity sealedBidEntryActivity, Handler handler) {
            super(sealedBidEntryActivity, handler);
        }

        /* access modifiers changed from: protected */
        public void onSuccess(SealedBidEntryActivity sealedBidEntryActivity, BidResult bidResult) {
            sealedBidEntryActivity.handlePlaceBidResult(bidResult);
        }
    }

    static class DeleteBidResultReceiver extends ActivityBaseResultReceiver<SealedBidEntryActivity, BidResult> {
        public DeleteBidResultReceiver(SealedBidEntryActivity sealedBidEntryActivity, Handler handler) {
            super(sealedBidEntryActivity, handler);
        }

        /* access modifiers changed from: protected */
        public void onSuccess(SealedBidEntryActivity sealedBidEntryActivity, BidResult bidResult) {
            sealedBidEntryActivity.handleDeleteBidResult(bidResult);
        }
    }
}
