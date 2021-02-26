package com.iaai.android.old.utils.constants;

import android.text.TextUtils;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.utils.p016ui.UiUtils;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public enum ToBePaidSortOptions {
    SORT_BY_DEFAULTC(C2723R.string.lbl_srt_due_date, C2723R.string.up_arrow, Constants.TO_BE_PAID_SRT_DUE, true),
    SORT_BY_DUE_DATE_ASC(C2723R.string.lbl_srt_due_date, C2723R.string.up_arrow, Constants.TO_BE_PAID_SRT_DUE, true),
    SORT_BY_DUE_DATE_DESC(C2723R.string.lbl_srt_due_date, C2723R.string.down_arrow, Constants.TO_BE_PAID_SRT_DUE, false),
    SORT_BY_PRICE_ASC(C2723R.string.lbl_srt_total_price, C2723R.string.price_ascending, Constants.TO_BE_PAID_SRT_PRICE, true),
    SORT_BY_PRICE_DESC(C2723R.string.lbl_srt_total_price, C2723R.string.price_descending, Constants.TO_BE_PAID_SRT_PRICE, false),
    SORT_BY_BIDDER_ASC(C2723R.string.lbl_srt_bidder, C2723R.string.up_arrow, Constants.TO_BE_PAID_SRT_BIDDER, true),
    SORT_BY_BIDDER_DSC(C2723R.string.lbl_srt_bidder, C2723R.string.down_arrow, Constants.TO_BE_PAID_SRT_BIDDER, false),
    SORT_BY_BRANCH_ASC(C2723R.string.lbl_srt_branch, C2723R.string.up_arrow, Constants.TO_BE_PAID_SRT_BRANCH, true),
    SORT_BY_BRANCH_DESC(C2723R.string.lbl_srt_branch, C2723R.string.down_arrow, Constants.TO_BE_PAID_SRT_BRANCH, false);
    
    private static final String FORMAT_SORT = "&sortby=%s&direction=%s";
    public static ToBePaidSortOptions[] TOBEPAID_SORT_OPTION;
    public String displayedName;
    public int displayedName_Id;
    public boolean isAscending;
    public String sortByParamValue;
    public int supportname_Id;

    static {
        ToBePaidSortOptions toBePaidSortOptions;
        ToBePaidSortOptions toBePaidSortOptions2;
        ToBePaidSortOptions toBePaidSortOptions3;
        ToBePaidSortOptions toBePaidSortOptions4;
        ToBePaidSortOptions toBePaidSortOptions5;
        ToBePaidSortOptions toBePaidSortOptions6;
        ToBePaidSortOptions toBePaidSortOptions7;
        ToBePaidSortOptions toBePaidSortOptions8;
        TOBEPAID_SORT_OPTION = new ToBePaidSortOptions[]{toBePaidSortOptions, toBePaidSortOptions2, toBePaidSortOptions3, toBePaidSortOptions4, toBePaidSortOptions5, toBePaidSortOptions6, toBePaidSortOptions7, toBePaidSortOptions8};
    }

    private ToBePaidSortOptions(String str, String str2, boolean z) {
        this.displayedName = str;
        this.sortByParamValue = str2;
        this.isAscending = z;
    }

    private ToBePaidSortOptions(int i, String str, boolean z) {
        this.displayedName = IaaiApplication.mContext.getString(i);
        this.sortByParamValue = str;
        this.isAscending = z;
    }

    private ToBePaidSortOptions(int i, int i2, String str, boolean z) {
        this.displayedName_Id = i;
        this.supportname_Id = i2;
        StringBuilder sb = new StringBuilder();
        sb.append(IaaiApplication.mContext.getString(i) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(IaaiApplication.mContext.getString(i2));
        this.displayedName = sb.toString();
        this.sortByParamValue = str;
        this.isAscending = z;
    }

    public String toString() {
        return this.displayedName;
    }

    public String toWsParamString() {
        return String.format(FORMAT_SORT, new Object[]{UiUtils.encodeString(this.sortByParamValue), getDirectionParamValue()});
    }

    private String getDirectionParamValue() {
        return this.isAscending ? "0" : IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
    }

    public static void refreshAll() {
        for (ToBePaidSortOptions toBePaidSortOptions : values()) {
            StringBuilder sb = new StringBuilder();
            sb.append(IaaiApplication.mContext.getString(toBePaidSortOptions.displayedName_Id) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(IaaiApplication.mContext.getString(toBePaidSortOptions.supportname_Id));
            toBePaidSortOptions.displayedName = sb.toString();
        }
    }

    public static ToBePaidSortOptions fromWSString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        if (split.length != 2) {
            return null;
        }
        return fromWSString(split[0], split[1]);
    }

    public static ToBePaidSortOptions fromWSString(String str, String str2) {
        boolean equals = "Ascending".equals(str2);
        ToBePaidSortOptions toBePaidSortOptions = null;
        for (ToBePaidSortOptions toBePaidSortOptions2 : values()) {
            if (toBePaidSortOptions2.isAscending == equals && toBePaidSortOptions2.sortByParamValue.equals(str)) {
                toBePaidSortOptions = toBePaidSortOptions2;
            }
        }
        return toBePaidSortOptions;
    }
}
