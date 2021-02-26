package com.iaai.android.old.utils.p016ui;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.iaai.android.C2723R;
import com.iaai.android.old.activities.ToBePaidActivity;
import com.iaai.android.old.utils.constants.Constants;
import java.util.ArrayList;
import java.util.List;
import roboguice.activity.RoboActivityGroup;
import roboguice.util.C5058Ln;

/* renamed from: com.iaai.android.old.utils.ui.TabActivityGroup */
public abstract class TabActivityGroup extends RoboActivityGroup {
    private static final int ANIMATION_MODE_BACKWARD = 2;
    private static final int ANIMATION_MODE_FORWARD = 1;
    private static final int ANIMATION_MODE_NONE = 0;
    private List<ActivityHistory> activityHistoryList;
    private RpViewFlipper viewFlipper;

    public Context getContext() {
        return this;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.activityHistoryList == null) {
            this.activityHistoryList = new ArrayList();
        }
        this.viewFlipper = new RpViewFlipper(this);
        setContentView(this.viewFlipper, new ViewGroup.LayoutParams(-1, -1));
    }

    public void finishFromChild(Activity activity) {
        try {
            if (this.activityHistoryList.size() <= 1) {
                finish();
                return;
            }
            LocalActivityManager localActivityManager = getLocalActivityManager();
            int findIndexByIntent = ActivityHistory.findIndexByIntent(this.activityHistoryList, activity.getIntent());
            boolean z = findIndexByIntent == this.activityHistoryList.size() - 1;
            ActivityHistory remove = this.activityHistoryList.remove(findIndexByIntent);
            setInOutAnimation(2);
            ActivityHistory activityHistory = this.activityHistoryList.get(this.activityHistoryList.size() - 1);
            if (localActivityManager.getActivity(activityHistory.f566id) == null || z) {
                View decorView = localActivityManager.startActivity(activityHistory.f566id, activityHistory.intent).getDecorView();
                if (decorView.getParent() == null) {
                    this.viewFlipper.addView(decorView, new ViewGroup.LayoutParams(-1, -1));
                }
                displayChild(decorView);
            }
            this.viewFlipper.removeView(activity.getWindow().getDecorView());
            localActivityManager.destroyActivity(remove.f566id, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startChildActivity(String str, Intent intent) {
        int i = 0;
        int i2 = 1;
        if (intent.getBooleanExtra(Constants.EXTRA_ALLOW_RETURN_FROM_CALLEE, false) && !this.activityHistoryList.isEmpty() && !intent.hasExtra(Constants.EXTRA_FROM_CALLER)) {
            List<ActivityHistory> list = this.activityHistoryList;
            intent.putExtra(Constants.EXTRA_FROM_CALLER, list.get(list.size() - 1));
            intent.removeExtra(Constants.EXTRA_ALLOW_RETURN_FROM_CALLEE);
        }
        Window startActivity = getLocalActivityManager().startActivity(str, intent);
        if (startActivity != null) {
            if (intent.getBooleanExtra(Constants.EXTRA_RETURN_TO_CALLER, false)) {
                i2 = 2;
                List<ActivityHistory> list2 = this.activityHistoryList;
                list2.remove(ActivityHistory.findIndexById(list2, str));
                intent.removeExtra(Constants.EXTRA_RETURN_TO_CALLER);
            }
            int findIndexById = ActivityHistory.findIndexById(this.activityHistoryList, str);
            if (findIndexById > -1) {
                this.activityHistoryList.remove(findIndexById);
            }
            if (!this.activityHistoryList.isEmpty()) {
                i = i2;
            }
            this.activityHistoryList.add(new ActivityHistory(str, intent));
            View decorView = startActivity.getDecorView();
            if (decorView.getParent() == null) {
                this.viewFlipper.addView(decorView, new ViewGroup.LayoutParams(-1, -1));
            }
            setInOutAnimation(i);
            displayChild(decorView);
        }
    }

    private void displayChild(View view) {
        this.viewFlipper.setDisplayedChild(this.viewFlipper.indexOfChild(view));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        int size = this.activityHistoryList.size();
        if (size > 1) {
            Activity activity = getLocalActivityManager().getActivity(this.activityHistoryList.get(size - 1).f566id);
            if (activity == null) {
                C5058Ln.m4832e("Current Activity is null", new Object[0]);
            } else if (activity instanceof ToBePaidActivity) {
                activity.onBackPressed();
            } else {
                activity.finish();
            }
        }
    }

    public boolean hasId(String str) {
        return getLocalActivityManager().getActivity(str) != null;
    }

    public void popToRoot() {
        if (this.activityHistoryList.size() > 1) {
            popAllButThis(this.activityHistoryList.get(0).f566id);
        }
    }

    public void popAllButThis(String str) {
        LocalActivityManager localActivityManager = getLocalActivityManager();
        ArrayList<String> arrayList = null;
        for (ActivityHistory next : this.activityHistoryList) {
            if (!next.f566id.equals(str)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(next.f566id);
            }
        }
        if (arrayList != null) {
            for (String activity : arrayList) {
                localActivityManager.getActivity(activity).finish();
            }
        }
    }

    private void setInOutAnimation(int i) {
        if (i == 1) {
            RpViewFlipper rpViewFlipper = this.viewFlipper;
            rpViewFlipper.setInAnimation(rpViewFlipper.getContext(), C2723R.anim.push_left_in);
            RpViewFlipper rpViewFlipper2 = this.viewFlipper;
            rpViewFlipper2.setOutAnimation(rpViewFlipper2.getContext(), C2723R.anim.push_left_out);
        } else if (i != 2) {
            RpViewFlipper rpViewFlipper3 = this.viewFlipper;
            rpViewFlipper3.setInAnimation(rpViewFlipper3.getContext(), C2723R.anim.none);
            RpViewFlipper rpViewFlipper4 = this.viewFlipper;
            rpViewFlipper4.setOutAnimation(rpViewFlipper4.getContext(), C2723R.anim.none);
        } else {
            RpViewFlipper rpViewFlipper5 = this.viewFlipper;
            rpViewFlipper5.setInAnimation(rpViewFlipper5.getContext(), C2723R.anim.push_right_in);
            RpViewFlipper rpViewFlipper6 = this.viewFlipper;
            rpViewFlipper6.setOutAnimation(rpViewFlipper6.getContext(), C2723R.anim.push_right_out);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        Activity currentActivity = getLocalActivityManager().getCurrentActivity();
        if (currentActivity == null) {
            return false;
        }
        currentActivity.onCreateOptionsMenu(menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        Activity currentActivity = getLocalActivityManager().getCurrentActivity();
        if (currentActivity == null) {
            return false;
        }
        return currentActivity.onPrepareOptionsMenu(menu);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        Activity currentActivity = getLocalActivityManager().getCurrentActivity();
        if (currentActivity == null) {
            return false;
        }
        currentActivity.onMenuItemSelected(i, menuItem);
        return true;
    }

    /* renamed from: com.iaai.android.old.utils.ui.TabActivityGroup$ActivityHistory */
    public static class ActivityHistory implements Parcelable {
        public static final Parcelable.Creator<ActivityHistory> CREATOR = new Parcelable.Creator<ActivityHistory>() {
            public ActivityHistory createFromParcel(Parcel parcel) {
                return new ActivityHistory(parcel);
            }

            public ActivityHistory[] newArray(int i) {
                return new ActivityHistory[i];
            }
        };

        /* renamed from: id */
        public final String f566id;
        public final Intent intent;

        public int describeContents() {
            return 0;
        }

        public ActivityHistory(String str, Intent intent2) {
            this.f566id = str;
            this.intent = intent2;
        }

        public ActivityHistory(Parcel parcel) {
            this.f566id = parcel.readString();
            this.intent = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActivityHistory)) {
                return false;
            }
            ActivityHistory activityHistory = (ActivityHistory) obj;
            String str = this.f566id;
            String str2 = activityHistory.f566id;
            if (str == str2 || (str != null && str.equals(str2))) {
                Intent intent2 = this.intent;
                Intent intent3 = activityHistory.intent;
                if (intent2 == intent3) {
                    return true;
                }
                if (intent2 == null || !intent2.equals(intent3)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            String str = this.f566id;
            int i = 0;
            int hashCode = (217 + (str == null ? 0 : str.hashCode())) * 31;
            Intent intent2 = this.intent;
            if (intent2 != null) {
                i = intent2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return this.f566id;
        }

        public static int findIndexByIntent(List<ActivityHistory> list, Intent intent2) {
            if (list != null && !list.isEmpty()) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (list.get(size).intent.equals(intent2)) {
                        return size;
                    }
                }
            }
            return -1;
        }

        public static int findIndexById(List<ActivityHistory> list, String str) {
            if (list != null && !list.isEmpty()) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (list.get(size).f566id.equals(str)) {
                        return size;
                    }
                }
            }
            return -1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f566id);
            parcel.writeParcelable(this.intent, 0);
        }
    }
}
