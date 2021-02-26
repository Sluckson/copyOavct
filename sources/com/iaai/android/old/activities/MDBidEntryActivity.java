package com.iaai.android.old.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.inject.Injector;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.managers.BidManager;
import com.iaai.android.old.managers.LoginStateChangeEventListener;
import com.iaai.android.old.managers.OnLoginStateChangeEvent;
import com.iaai.android.old.models.Bid;
import com.iaai.android.old.models.BidHistory;
import com.iaai.android.old.models.BidResult;
import com.iaai.android.old.models.MDVehicle;
import com.iaai.android.old.service.ActivityBaseResultReceiver;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.ICommand;
import com.iaai.android.old.utils.Validator;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.ActivityHelper;
import com.iaai.android.old.utils.p016ui.MDActivityHelper;
import com.iaai.android.old.utils.p016ui.UiUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import roboguice.event.Observes;
import roboguice.util.C5058Ln;

public class MDBidEntryActivity extends AppCompatActivity {
    private BidHistory[] bidHistories;
    private LoadBidHistoryResultReceiver bidHistoryResultReceiver;
    BidManager bidManager;
    @BindView(2131296655)
    Button btnSubmit;
    private ColorStateList colorStateListLosing;
    private ColorStateList colorStateListNoBid;
    private ColorStateList colorStateListWinning;
    private LoginStateChangeEventListener loginStateChangeEventListener;
    /* access modifiers changed from: private */
    public PlaceBidResultReceiver placeBidResultReceiver;
    @BindView(2131298202)
    View sectionNoOfBid;
    @BindView(2131298895)
    TextView txtCurrentHighAmount;
    @BindView(2131298897)
    TextView txtCurrentHighAmountLabel;
    @BindView(2131298898)
    TextView txtCurrentHighBidder;
    @BindView(2131298953)
    EditText txtMaxBid;
    @BindView(2131299020)
    TextView txtTimeLeft;
    /* access modifiers changed from: private */
    public MDVehicle vehicle;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.pre_bid_entry);
        ButterKnife.bind((Activity) this);
        Handler handler = new Handler();
        this.bidHistoryResultReceiver = new LoadBidHistoryResultReceiver(this, handler);
        this.placeBidResultReceiver = new PlaceBidResultReceiver(this, handler);
        Injector injector = ((IaaiApplication) getApplication()).getInjector();
        this.loginStateChangeEventListener = (LoginStateChangeEventListener) injector.getInstance(LoginStateChangeEventListener.class);
        this.bidManager = (BidManager) injector.getInstance(BidManager.class);
        this.vehicle = (MDVehicle) getIntent().getExtras().getParcelable(Constants.EXTRA_VEHICLE);
        this.colorStateListNoBid = getResources().getColorStateList(C2723R.C2724color.auction_no_bid);
        this.colorStateListLosing = getResources().getColorStateList(C2723R.C2724color.auction_losing);
        this.colorStateListWinning = getResources().getColorStateList(C2723R.C2724color.auction_winning);
        this.btnSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MDBidEntryActivity.this.handleSubmitClicked();
            }
        });
        this.sectionNoOfBid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MDBidEntryActivity.this.handleBidHistoryClicked();
            }
        });
        this.sectionNoOfBid.setClickable(false);
        this.txtMaxBid.addTextChangedListener(new Validator.NumberFormatTextWatcher());
        this.txtMaxBid.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                ActivityHelper.closeSoftKeyboard(MDBidEntryActivity.this, textView);
                return i == 6;
            }
        });
        applyIntentData(getIntent());
    }

    private void handleLoginStateChange(@Observes OnLoginStateChangeEvent onLoginStateChangeEvent) {
        finish();
    }

    /* access modifiers changed from: package-private */
    public void handleSubmitClicked() {
        String str;
        ActivityHelper.closeSoftKeyboard(this);
        String obj = this.txtMaxBid.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            showValidationError(C2723R.string.msg_cannot_be_blank, getString(C2723R.string.lbl_pre_bid_max));
            return;
        }
        String replaceAll = obj.replaceAll(",", "");
        try {
            final BigDecimal bigDecimal = new BigDecimal("0");
            final BigDecimal bigDecimal2 = new BigDecimal(replaceAll);
            C29884 r1 = new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (i == -1) {
                        MDBidEntryActivity.this.bidManager.placeBid(MDBidEntryActivity.this.vehicle.itemId, MDBidEntryActivity.this.vehicle.auctionId, new Bid(bigDecimal, bigDecimal2), MDBidEntryActivity.this.placeBidResultReceiver);
                    } else if (i == -2) {
                        MDBidEntryActivity.this.resetInputFields();
                    }
                    dialogInterface.dismiss();
                }
            };
            if (this.vehicle.hasUserPlacedBidBefore) {
                str = getString(C2723R.string.msg_change_prebid_confirmation, new Object[]{UiUtils.formatCurrency(bigDecimal2, false), this.vehicle.toString()});
            } else {
                str = getString(C2723R.string.msg_change_prebid_confirmation, new Object[]{UiUtils.formatCurrency(bigDecimal2, false), this.vehicle.toString()});
            }
            MDActivityHelper.showConfirmationDialog(this, getString(C2723R.string.dail_title_confirm_prebid), str, r1);
        } catch (Exception unused) {
            showValidationError(C2723R.string.msg_bid_not_numeric);
        }
    }

    private void showValidationError(int i) {
        Toast.makeText(this, C2723R.string.msg_bid_not_numeric, 0).show();
    }

    private void showValidationError(int i, Object... objArr) {
        Toast.makeText(this, getString(i, objArr), 0).show();
    }

    /* access modifiers changed from: package-private */
    public void handleBidHistoryClicked() {
        ActivityHelper.closeSoftKeyboard(this, this.txtMaxBid);
        BidHistory[] bidHistoryArr = this.bidHistories;
        if (bidHistoryArr != null && bidHistoryArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (BidHistory add : this.bidHistories) {
                arrayList.add(add);
            }
            Intent intent = new Intent(this, BidHistoryListActivity.class);
            intent.putParcelableArrayListExtra(Constants.EXTRA_RESULT, arrayList);
            ActivityHelper.pushActivityToGroup(this, intent);
        }
    }

    private void applyIntentData(Intent intent) {
        this.vehicle = (MDVehicle) intent.getParcelableExtra(Constants.EXTRA_VEHICLE);
        Date date = this.vehicle.preBidEndTime;
        if (date != null) {
            this.txtTimeLeft.setText(DateHelper.calculateDateTimeDiff(date, new Date()).toString());
        }
        if (this.vehicle.hasUserPlacedBidBefore) {
            this.btnSubmit.setText(C2723R.string.lbl_change_pre_bid);
            if (this.vehicle.currentHighAmount != null) {
                this.vehicle.currentHighAmount.intValue();
            }
            this.txtMaxBid.setText(Integer.toString(this.vehicle.userPreBidMaxAmount != null ? (int) Double.parseDouble(this.vehicle.userPreBidMaxAmount) : 0));
            if (this.vehicle.isCurrentUserHighBidder) {
                this.txtCurrentHighBidder.setText(C2723R.string.lbl_high_bidder_you);
                this.txtCurrentHighAmountLabel.setTextColor(this.colorStateListWinning);
                this.txtCurrentHighAmount.setTextColor(this.colorStateListWinning);
                this.txtCurrentHighBidder.setTextColor(this.colorStateListWinning);
            } else {
                this.txtCurrentHighBidder.setText(C2723R.string.lbl_high_bidder_not_you);
                this.txtCurrentHighAmountLabel.setTextColor(this.colorStateListLosing);
                this.txtCurrentHighAmount.setTextColor(this.colorStateListLosing);
                this.txtCurrentHighBidder.setTextColor(this.colorStateListLosing);
            }
        } else {
            this.btnSubmit.setText(C2723R.string.lbl_submit);
            this.txtMaxBid.setText("");
            this.txtCurrentHighBidder.setText("");
            this.txtCurrentHighAmountLabel.setTextColor(this.colorStateListNoBid);
            this.txtCurrentHighAmount.setTextColor(this.colorStateListNoBid);
            this.txtCurrentHighBidder.setTextColor(this.colorStateListNoBid);
        }
        this.txtCurrentHighAmount.setText(UiUtils.formatCurrency(this.vehicle.currentHighAmount, false));
        this.bidManager.loadBidHistory(this.vehicle.itemId, this.vehicle.auctionId, this.bidHistoryResultReceiver);
    }

    /* access modifiers changed from: package-private */
    public void resetInputFields() {
        if (this.vehicle.hasUserPlacedBidBefore) {
            int i = 0;
            if (this.vehicle.userPreBidMaxAmount != null) {
                i = (int) Double.parseDouble(this.vehicle.userPreBidMaxAmount);
            }
            this.txtMaxBid.setText(Integer.toString(i));
            return;
        }
        this.txtMaxBid.setText("");
    }

    /* access modifiers changed from: package-private */
    public void updateViewWithBidHistory(BidHistory[] bidHistoryArr) {
        this.bidHistories = bidHistoryArr;
        this.sectionNoOfBid.setClickable(true);
    }

    /* access modifiers changed from: package-private */
    public void handlePlaceBidResult(BidResult bidResult) {
        String str;
        C5058Ln.m4829d("BidResult bidding[%s] message[%s]", bidResult.bidding, bidResult.message);
        if (bidResult.isSuccessful) {
            C29895 r1 = new ICommand<DialogInterface>() {
                public void execute(DialogInterface dialogInterface) {
                    MDBidEntryActivity.this.broadcastChanges();
                    MDBidEntryActivity.this.finish();
                }
            };
            String string = getString(C2723R.string.dial_title_bid_submitted);
            if (this.vehicle.hasUserPlacedBidBefore) {
                str = getString(C2723R.string.msg_bid_placed_successfully, new Object[]{UiUtils.formatCurrency(UiUtils.toBigDecimal(this.txtMaxBid.getText().toString()), false), this.vehicle.toString(), bidResult.confirmationNo});
            } else {
                UiUtils.toBigDecimal("0");
                str = getString(C2723R.string.msg_min_n_max_bid_placed_successfully, new Object[]{UiUtils.formatCurrency(UiUtils.toBigDecimal(this.txtMaxBid.getText().toString()), false), this.vehicle.toString(), bidResult.confirmationNo});
            }
            MDActivityHelper.showAlert((Activity) this, string, str, (ICommand<DialogInterface>) r1);
            return;
        }
        MDActivityHelper.showAlert((Activity) this, getString(C2723R.string.dial_title_cannot_place_bid), bidResult.getErrorMessage(), (ICommand<DialogInterface>) null);
    }

    /* access modifiers changed from: package-private */
    public void broadcastChanges() {
        Intent intent = new Intent(Constants.INTENT_VEHICLE_UPDATE);
        intent.putExtra(Constants.EXTRA_ITEM_ID, this.vehicle.itemId);
        sendBroadcast(intent);
    }

    static class LoadBidHistoryResultReceiver extends ActivityBaseResultReceiver<MDBidEntryActivity, BidHistory[]> {
        /* access modifiers changed from: protected */
        public void onPreExecute(MDBidEntryActivity mDBidEntryActivity) {
        }

        public LoadBidHistoryResultReceiver(MDBidEntryActivity mDBidEntryActivity, Handler handler) {
            super(mDBidEntryActivity, handler);
        }

        /* access modifiers changed from: protected */
        public void onSuccess(MDBidEntryActivity mDBidEntryActivity, BidHistory[] bidHistoryArr) {
            mDBidEntryActivity.updateViewWithBidHistory(bidHistoryArr);
        }
    }

    static class PlaceBidResultReceiver extends ActivityBaseResultReceiver<MDBidEntryActivity, BidResult> {
        public PlaceBidResultReceiver(MDBidEntryActivity mDBidEntryActivity, Handler handler) {
            super(mDBidEntryActivity, handler);
        }

        /* access modifiers changed from: protected */
        public void onSuccess(MDBidEntryActivity mDBidEntryActivity, BidResult bidResult) {
            mDBidEntryActivity.handlePlaceBidResult(bidResult);
        }
    }
}