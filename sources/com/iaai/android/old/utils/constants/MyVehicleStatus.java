package com.iaai.android.old.utils.constants;

import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;

public enum MyVehicleStatus {
    ALL((String) 0, (int) C2723R.string.lbl_all),
    WATCHING_ONLY((String) 1, (int) C2723R.string.lbl_watching),
    PREBID((String) 60, (int) C2723R.string.lbl_out_bid),
    WINNING((String) 3, (int) C2723R.string.lbl_winning),
    WON_PRE_BID((String) 5, (int) C2723R.string.lbl_won_pre_bid),
    WON((String) 6, (int) C2723R.string.lbl_won),
    LOST((String) 7, (int) C2723R.string.lbl_lost),
    WINNING_AND_WON_PRE_BID((String) 8, (int) C2723R.string.lbl_winning_pre_bids),
    OUTBID_AND_LOST_PRE_BID((String) 9, (int) C2723R.string.lbl_out_lost_bid),
    ALL_PRE_SALE((String) 10, (int) C2723R.string.lbl_all_pre_sale),
    AWARD_PENDING((String) 15, (int) C2723R.string.lbl_award_pending),
    TOTAL_TO_BE_PAID((String) 16, (int) C2723R.string.lbl_tobe_paid),
    VEHICLES_ONLY((String) 17, (int) C2723R.string.lbl_vehicle_only),
    FEES_ONLY((String) 18, (int) C2723R.string.lbl_fees_only),
    PICK_UP((String) 19, (int) C2723R.string.lbl_pick_up),
    WON_HISTORY((String) 55, (int) C2723R.string.lbl_Won_History),
    LOST_PRE_BID((String) 50, (int) C2723R.string.lbl_lost_Prebids),
    ALL_POST_SALE((String) 20, (int) C2723R.string.lbl_all_post_sale);
    
    public int code;
    public String displayedName;
    public int resource_id;

    private MyVehicleStatus(int i, String str) {
        this.resource_id = -1;
        this.code = i;
        this.displayedName = str;
    }

    private MyVehicleStatus(int i, int i2) {
        this.resource_id = -1;
        this.resource_id = i2;
        this.code = i;
        this.displayedName = IaaiApplication.mContext.getString(i2);
    }

    public static void refreshAll() {
        for (MyVehicleStatus myVehicleStatus : values()) {
            if (myVehicleStatus.resource_id != -1) {
                myVehicleStatus.displayedName = IaaiApplication.mContext.getString(myVehicleStatus.resource_id);
            }
            myVehicleStatus.code = myVehicleStatus.code;
        }
    }
}
