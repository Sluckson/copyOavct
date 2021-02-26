package com.iaai.android.bdt.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.iaai.android.BuildConfig;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.database.RecentViewContract;
import com.iaai.android.bdt.model.auctionmainlist.AuctionLocations;
import com.iaai.android.bdt.model.auctionmainlist.RecentlyViewedInfo;
import com.iaai.android.bdt.model.productDetail.biddingInfo.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class Utils {
    public static String unMaskVinNumber(String str) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i = 0;
        while (i < str.length() - 1) {
            int i2 = i + 2;
            int parseInt = Integer.parseInt(str.substring(i, i2), 16);
            sb.append((char) parseInt);
            sb2.append(parseInt);
            i = i2;
        }
        return sb.toString();
    }

    public static ArrayList<Integer> getRecentAuctionsBranchIDList(Context context, List<AuctionLocations> list, String str) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (list != null) {
            int size = list.size();
            ArrayList arrayList2 = new ArrayList();
            if (list != null && size > 0) {
                for (int i = 0; i < size; i++) {
                    arrayList2.add(list.get(i).getBranchid());
                }
            }
            ArrayList<RecentlyViewedInfo> dBSuggestionsBranchList = getDBSuggestionsBranchList(context, str);
            for (int i2 = 0; i2 < dBSuggestionsBranchList.size(); i2++) {
                RecentlyViewedInfo recentlyViewedInfo = dBSuggestionsBranchList.get(i2);
                if (arrayList2.contains(String.valueOf(recentlyViewedInfo.getBranchNumber()))) {
                    arrayList.add(Integer.valueOf(recentlyViewedInfo.getBranchNumber()));
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<RecentlyViewedInfo> getDBSuggestionsBranchList(Context context, String str) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri content_uri = RecentViewContract.Suggestions.Companion.getCONTENT_URI();
        Cursor query = contentResolver.query(content_uri, (String[]) null, RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_AUCTION_DATE() + "=?", new String[]{str}, RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_UTC_DATE() + " DESC");
        ArrayList<RecentlyViewedInfo> arrayList = new ArrayList<>();
        if (query != null) {
            try {
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    arrayList.add(new RecentlyViewedInfo(query));
                    query.moveToNext();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static Boolean checkIfItemExistsInWatchList(int i, List<Integer> list) {
        if (list != null) {
            return Boolean.valueOf(list.contains(Integer.valueOf(i)));
        }
        return false;
    }

    public static String getLanguage() {
        String language = Locale.getDefault().getLanguage();
        return language.equals(Constants_MVVM.EXTRA_SPANISH_CODE) ? language : "en";
    }

    public static String getUserAgent() {
        return IaaiApplication.mContext.getString(C2723R.string.app_name) + "/" + BuildConfig.VERSION_NAME + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + System.getProperty("http.agent");
    }

    public static int getKeyIndex(String str, List<Image> list) {
        if (list == null) {
            return 0;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUrl().equalsIgnoreCase(str)) {
                Log.e("KEY INDEX:", "FOUND AT:" + i);
                return i;
            }
        }
        Log.e("KEY INDEX:", "NOT FOUND");
        return 0;
    }
}
