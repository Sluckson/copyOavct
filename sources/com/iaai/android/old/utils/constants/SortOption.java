package com.iaai.android.old.utils.constants;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.p016ui.UiUtils;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public enum SortOption {
    MAKE_AZ(C2723R.string.headerDefaultSortAuction, "", ExifInterface.TAG_MAKE, true),
    MAKE_ZA(C2723R.string.lbl_sort_by_make_desc, "", ExifInterface.TAG_MAKE, false),
    ODOMETER_ASC(C2723R.string.odo_meter, "↑", "Odometer", true),
    ODOMETER_DESC(C2723R.string.odo_meter, "↓", "Odometer", false),
    YEAR_ASC(C2723R.string.year, "↑", "Year", true),
    YEAR_DESC(C2723R.string.year, "↓", "Year", false),
    AUCTION_DATE_ASC(C2723R.string.lbl_Auction_Date, "↑", "Auction Date", true),
    AUCTION_DATE_DESC(C2723R.string.lbl_Auction_Date, "↓", "Auction Date", false),
    SORT_BY_CURRENT_LOCATION(C2723R.string.headerVehicleSeachGps, "", "Coordinates", true),
    SORT_BY_ZIP(C2723R.string.lbl_sort_zip, "", "Zip", true),
    SORT_BY_ITEM_NUMBER_ASC(C2723R.string.lbl_item_number, "↑", "Item#", true),
    SORT_BY_ITEM_NUMBER_DESC(C2723R.string.lbl_item_number, "↓", "Item#", false),
    SORT_BY_AUCTION_LANE_ASC(C2723R.string.lbl_auction_lane, "↑", "Lane", true),
    SORT_BY_AUCTION_LANE_DESC(C2723R.string.lbl_auction_lane, "↓", "Lane", false),
    AUCTION_DATE_ASC_MD(C2723R.string.filter_auction_date, "↑", Constants_MVVM.EXTRA_AUCTION_DATE, true),
    AUCTION_DATE_DESC_MD(C2723R.string.filter_auction_date, "↓", Constants_MVVM.EXTRA_AUCTION_DATE, false),
    SORT_BY_BRANCH_ASC(C2723R.string.lbl_srt_branch, "↑", Constants.TO_BE_PAID_SRT_BRANCH, true),
    SORT_BY_BRANCH_DSC(C2723R.string.lbl_srt_branch, "↓", Constants.TO_BE_PAID_SRT_BRANCH, false),
    SORT_BY_ITEM_ID_ASC(C2723R.string.itemID, "↑", "AuctionItem", true),
    SORT_BY_ITEM_ID_DSC(C2723R.string.itemID, "↓", "AuctionItem", false),
    SORT_BY_STOCK_ASC(C2723R.string.lbl_srt_bidder, "↑", Constants.TO_BE_PAID_SRT_BIDDER, true),
    SORT_BY_STOCK_DSC(C2723R.string.lbl_srt_bidder, "↓", Constants.TO_BE_PAID_SRT_BIDDER, false),
    SORT_BY_VIN_ASC(C2723R.string.lbl_srt_year_make_model, "↑", "Description", true),
    SORT_BY_VIN_DSC(C2723R.string.lbl_srt_year_make_model, "↓", "Description", false),
    SORT_BY_BID_AMOUNT_ASC(C2723R.string.lbl_srt_bid_amount, "↑", "BidAmount", true),
    SORT_BY_BID_AMOUNT_DSC(C2723R.string.lbl_srt_bid_amount, "↓", "BidAmount", false),
    SORT_BY_ACTION_DUE_ASC(C2723R.string.filter_option_action_due, "↑", "ActionDue", true),
    SORT_BY_ACTION_DUE_DSC(C2723R.string.filter_option_action_due, "↓", "ActionDue", false),
    SORT_BY_DATE_PAID_ASC(C2723R.string.lbl_srt_date_paid, "↑", "DatePaid", true),
    SORT_BY_DATE_PAID_DSC(C2723R.string.lbl_srt_date_paid, "↓", "DatePaid", false);
    
    public static final SortOption[] AUCTION_SALE_LIST_OPTIONS = null;
    private static final String FORMAT_SORT = "&sortby=%s&direction=%s";
    public static final SortOption[] MY_VEHICLE_HISTORY_OPTIONS = null;
    public static final SortOption[] MY_VEHICLE_OPTIONS = null;
    public static final SortOption[] VEHICLE_OPTIONS = null;
    public String append;
    public String displayedName;
    public int displayedName_id;
    public boolean isAscending;
    public String sortByParamValue;

    static {
        SortOption sortOption;
        SortOption sortOption2;
        SortOption sortOption3;
        SortOption sortOption4;
        SortOption sortOption5;
        SortOption sortOption6;
        SortOption sortOption7;
        SortOption sortOption8;
        SortOption sortOption9;
        SortOption sortOption10;
        SortOption sortOption11;
        SortOption sortOption12;
        SortOption sortOption13;
        SortOption sortOption14;
        VEHICLE_OPTIONS = new SortOption[]{sortOption, sortOption2, sortOption3, sortOption4, sortOption6, sortOption5, sortOption9, sortOption10};
        MY_VEHICLE_OPTIONS = new SortOption[]{sortOption, sortOption2, sortOption3, sortOption4, sortOption7, sortOption8, sortOption6, sortOption5};
        MY_VEHICLE_HISTORY_OPTIONS = new SortOption[]{sortOption, sortOption2, sortOption7, sortOption8, sortOption6, sortOption5};
        AUCTION_SALE_LIST_OPTIONS = new SortOption[]{sortOption, sortOption2, sortOption3, sortOption4, sortOption6, sortOption5, sortOption11, sortOption12, sortOption13, sortOption14};
    }

    private SortOption(String str, String str2, boolean z) {
        this.displayedName_id = -1;
        this.displayedName = str;
        this.sortByParamValue = str2;
        this.isAscending = z;
    }

    private SortOption(int i, String str, String str2, boolean z) {
        this.displayedName_id = -1;
        this.append = str;
        this.displayedName_id = i;
        this.displayedName = IaaiApplication.mContext.getString(i) + str;
        this.sortByParamValue = str2;
        this.isAscending = z;
    }

    public static void refreshAll() {
        for (SortOption sortOption : values()) {
            if (sortOption.displayedName_id != -1) {
                sortOption.displayedName = IaaiApplication.mContext.getString(sortOption.displayedName_id) + sortOption.append;
            } else {
                sortOption.displayedName = sortOption.displayedName;
            }
            sortOption.sortByParamValue = sortOption.sortByParamValue;
            sortOption.isAscending = sortOption.isAscending;
        }
    }

    public String toString() {
        return this.displayedName;
    }

    public String toWsParamString() {
        return String.format(FORMAT_SORT, new Object[]{UiUtils.encodeString(this.sortByParamValue), getDirectionParamValue()});
    }

    public String toWsParamString2() {
        String str = this.isAscending ? "Ascending" : "Descending";
        return this.sortByParamValue + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str;
    }

    private String getDirectionParamValue() {
        return this.isAscending ? "0" : IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
    }

    public static SortOption fromWSString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        if (split.length != 2) {
            return null;
        }
        return fromWSString(split[0], split[1]);
    }

    public static SortOption fromWSString(String str, String str2) {
        String str3;
        boolean equals = "Ascending".equals(str2);
        if (str == "Near") {
            str3 = "Coordinates";
            equals = true;
        } else {
            str3 = str;
        }
        if (str == "Sort") {
            str3 = "Zip";
            equals = true;
        }
        SortOption sortOption = null;
        for (SortOption sortOption2 : values()) {
            if (sortOption2.isAscending == equals && sortOption2.sortByParamValue.equals(str3)) {
                sortOption = sortOption2;
            }
        }
        return sortOption;
    }
}
