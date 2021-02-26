package com.iaai.android.old.managers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.format.DateUtils;
import android.util.Log;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.models.AuctionDate;
import com.iaai.android.old.models.AuctionMain;
import com.iaai.android.old.service.ActivityBaseResultReceiver;
import com.iaai.android.old.service.CommandService;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.constants.Constants;
import java.util.Date;
import roboguice.inject.InjectResource;
import roboguice.util.C5058Ln;

@Singleton
public class AuctionManager {
    final IaaiApplication application;
    AuctionDate[] cachedAuctionDates;
    volatile long lastAuctionDatesLoadedInMillis = 0;
    @InjectResource(2131820609)
    private String servicePathActionDates;

    @Inject
    private AuctionManager(Provider<IaaiApplication> provider) {
        this.application = provider.get();
    }

    public void clearCache() {
        this.cachedAuctionDates = null;
    }

    public boolean isAuctionDatesOutdated(Date[] dateArr) {
        AuctionDate[] auctionDateArr;
        if (!DateUtils.isToday(this.lastAuctionDatesLoadedInMillis) || (auctionDateArr = this.cachedAuctionDates) == null || dateArr == null || auctionDateArr.length != dateArr.length) {
            return true;
        }
        int length = dateArr.length;
        for (int i = 0; i < length; i++) {
            if (!DateHelper.isSameDay(this.cachedAuctionDates[i].date, dateArr[i])) {
                return true;
            }
        }
        return false;
    }

    public void loadNextAuctionDates(final NextAuctionDatesResultReceiver nextAuctionDatesResultReceiver, boolean z) {
        if (z || !DateHelper.isSameDayInServerTimezone(this.lastAuctionDatesLoadedInMillis, System.currentTimeMillis()) || this.cachedAuctionDates == null) {
            CommandService.start((Context) this.application, this.servicePathActionDates, (ResultReceiver) new ResultReceiver(nextAuctionDatesResultReceiver.getHandler()) {
                /* access modifiers changed from: protected */
                public void onReceiveResult(int i, Bundle bundle) {
                    if (i == 1) {
                        AuctionManager.this.lastAuctionDatesLoadedInMillis = System.currentTimeMillis();
                        AuctionManager.this.cachedAuctionDates = (AuctionDate[]) bundle.getParcelableArray(Constants.EXTRA_RESULT);
                    }
                    nextAuctionDatesResultReceiver.send(i, bundle);
                }
            }, (Class<?>) AuctionDate[].class, false);
            return;
        }
        C5058Ln.m4829d("Return cached auction date", new Object[0]);
        sendCachedAuctionDatesResult(nextAuctionDatesResultReceiver);
    }

    private void sendCachedAuctionDatesResult(ResultReceiver resultReceiver) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelableArray(Constants.EXTRA_RESULT, this.cachedAuctionDates);
            resultReceiver.send(1, bundle);
        }
    }

    public void loadAuctionsByDate(Date date, ResultReceiver resultReceiver) {
        String string = this.application.getResources().getString(C2723R.string.auction_service);
        if (date != null) {
            string = string + "&Date=" + DateHelper.format(date, Constants.DATE_PATTERN_CONFIRMATION_PAGE);
        }
        CommandService.start((Context) this.application, string, resultReceiver, (Class<?>) AuctionMain.class, false);
    }

    public void loadAuctionsByKeyWord(String str, ResultReceiver resultReceiver) {
        String string = this.application.getResources().getString(C2723R.string.auction_service);
        CommandService.start((Context) this.application, string + "&query=" + str, resultReceiver, (Class<?>) AuctionMain.class, false);
    }

    public void loadAuctionsByLocation(Location location, ResultReceiver resultReceiver) {
        String d = Double.toString(location.getLatitude());
        String d2 = Double.toString(location.getLongitude());
        String string = this.application.getResources().getString(C2723R.string.auction_service);
        CommandService.start((Context) this.application, string + "Latitude=" + d + "&Longitude=" + d2, resultReceiver, (Class<?>) AuctionMain.class, false);
    }

    public void loadAuctions(String str, Date date, Location location, ResultReceiver resultReceiver) {
        String string = this.application.getResources().getString(C2723R.string.auction_service);
        if (str != null && str.length() > 0) {
            string = string + "&query=" + str;
        }
        if (date != null) {
            string = string + "&Date=" + DateHelper.format(date, Constants.DATE_PATTERN_CONFIRMATION_PAGE);
        }
        if (location != null) {
            string = string + "&Latitude=" + Double.toString(location.getLatitude()) + "&Longitude=" + Double.toString(location.getLongitude());
        }
        CommandService.start((Context) this.application, string, resultReceiver, (Class<?>) AuctionMain.class, false);
    }

    public static class NextAuctionDatesResultReceiver extends ActivityBaseResultReceiver<Activity, AuctionDate[]> {
        boolean isLoadingConstructor = false;

        public NextAuctionDatesResultReceiver(Activity activity, Handler handler, boolean z) {
            super(activity, handler);
            this.isLoadingConstructor = z;
            Log.d("isLoadingConstructor", String.valueOf(this.isLoadingConstructor));
        }

        /* access modifiers changed from: protected */
        public void onSuccess(Activity activity, AuctionDate[] auctionDateArr) {
            long j;
            int length = auctionDateArr == null ? 0 : auctionDateArr.length;
            if (length > 0) {
                long[] jArr = new long[length];
                for (int i = 0; i < length; i++) {
                    Date date = auctionDateArr[i].date;
                    if (date == null) {
                        j = 0;
                    } else {
                        j = date.getTime();
                    }
                    jArr[i] = j;
                }
                Intent intent = new Intent(Constants.INTENT_AUCTION_DATES_CHANGE);
                intent.putExtra(Constants.EXTRA_DATE, jArr);
                intent.putExtra(Constants.EXTRA_LOADING_INDICATOR, this.isLoadingConstructor);
                activity.sendBroadcast(intent);
            }
        }
    }
}
