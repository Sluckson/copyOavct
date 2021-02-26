package com.iaai.android.old.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.database.FastSearchSuggestionsContract;
import com.iaai.android.old.database.SuggestionsContract;
import com.iaai.android.old.managers.ToBePickedUpManager;
import com.iaai.android.old.managers.UpdateAppManager;
import com.iaai.android.old.models.Auction;
import com.iaai.android.old.models.AuctionFeedBackResponse;
import com.iaai.android.old.models.CheckAppVersion;
import com.iaai.android.old.models.DefaultRefiner;
import com.iaai.android.old.models.FastSearchSuggestionsInfo;
import com.iaai.android.old.models.SuggestionsInfo;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.MDActivityHelper;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import lib.android.paypal.com.magnessdk.p058a.C4820b;
import p052cz.msebera.android.httpclient.Header;

public class AppUtils {
    static AlertDialog dialog;
    static int textCount;

    public static String getDeviceIPAddress(boolean z) {
        try {
            for (T inetAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                Iterator<T> it = Collections.list(inetAddresses.getInetAddresses()).iterator();
                while (true) {
                    if (it.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it.next();
                        if (!inetAddress.isLoopbackAddress()) {
                            String upperCase = inetAddress.getHostAddress().toUpperCase();
                            if (z) {
                                if (inetAddress instanceof Inet4Address) {
                                    return upperCase;
                                }
                            } else if (!(inetAddress instanceof Inet4Address)) {
                                int indexOf = upperCase.indexOf(37);
                                return indexOf < 0 ? upperCase : upperCase.substring(0, indexOf);
                            }
                        }
                    }
                }
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static ArrayList<Integer> getRecentAuctionsBranchIDList(Context context, Auction[] auctionArr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (auctionArr != null) {
            ArrayList arrayList2 = new ArrayList();
            if (auctionArr != null && r1 > 0) {
                for (Auction auction : auctionArr) {
                    arrayList2.add(auction.branchId);
                }
            }
            ArrayList<SuggestionsInfo> dBSuggestionsBranchList = getDBSuggestionsBranchList(context);
            for (int i = 0; i < dBSuggestionsBranchList.size(); i++) {
                SuggestionsInfo suggestionsInfo = dBSuggestionsBranchList.get(i);
                if (arrayList2.contains(String.valueOf(suggestionsInfo.getBranchNumber()))) {
                    arrayList.add(Integer.valueOf(suggestionsInfo.getBranchNumber()));
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<SuggestionsInfo> getDBSuggestionsBranchList(Context context) {
        Cursor query = context.getContentResolver().query(SuggestionsContract.Suggestions.CONTENT_URI, (String[]) null, (String) null, (String[]) null, "frequency DESC");
        ArrayList<SuggestionsInfo> arrayList = new ArrayList<>();
        if (query != null) {
            try {
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    arrayList.add(new SuggestionsInfo(query));
                    query.moveToNext();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static ArrayList<String> getRecentAuctionsBranchNameList(Context context, ArrayList<DefaultRefiner> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            int size = arrayList.size();
            ArrayList arrayList3 = new ArrayList();
            if (arrayList != null && size > 0) {
                for (int i = 0; i < size; i++) {
                    arrayList3.add(arrayList.get(i).displayName);
                }
            }
            ArrayList<FastSearchSuggestionsInfo> dBFastSearchSuggestionsBranchList = getDBFastSearchSuggestionsBranchList(context);
            for (int i2 = 0; i2 < dBFastSearchSuggestionsBranchList.size(); i2++) {
                FastSearchSuggestionsInfo fastSearchSuggestionsInfo = dBFastSearchSuggestionsBranchList.get(i2);
                if (arrayList3.contains(String.valueOf(fastSearchSuggestionsInfo.getBranchName()))) {
                    arrayList2.add(fastSearchSuggestionsInfo.getBranchName());
                }
            }
        }
        return arrayList2;
    }

    public static ArrayList<FastSearchSuggestionsInfo> getDBFastSearchSuggestionsBranchList(Context context) {
        Cursor query = context.getContentResolver().query(FastSearchSuggestionsContract.FastSearchSuggestions.CONTENT_URI, (String[]) null, (String) null, (String[]) null, "frequency DESC");
        ArrayList<FastSearchSuggestionsInfo> arrayList = new ArrayList<>();
        if (query != null) {
            try {
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    arrayList.add(new FastSearchSuggestionsInfo(query));
                    query.moveToNext();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static void saveTermsOfUseTimeStamp(Context context) {
        IAASharedPreference.saveTncTimeStampFromPrefs(context, new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIMEZONE_OFFER).format(new Date()));
    }

    public static void hideSoftkeyBoard(Context context, View view) {
        if (context != null) {
            if (view instanceof SearchView) {
                view.setVisibility(4);
                view.setVisibility(0);
                view.clearFocus();
                view.setFocusable(false);
                view.setFocusableInTouchMode(true);
            }
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void showEnablePermissionMessage(boolean z, final Activity activity, final Fragment fragment, final String str, final int i) {
        if (z) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, str)) {
                Snackbar.make(activity.findViewById(16908290), (int) C2723R.string.grant_permission_text, 0).setAction((int) C2723R.string.enable_button_txt_permission_dailog, (View.OnClickListener) new View.OnClickListener() {
                    public void onClick(View view) {
                        ActivityCompat.requestPermissions(activity, new String[]{str}, i);
                    }
                }).show();
                return;
            }
            ActivityCompat.requestPermissions(activity, new String[]{str}, i);
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(activity, str)) {
            Snackbar.make(activity.findViewById(16908290), (int) C2723R.string.grant_permission_text, 0).setAction((int) C2723R.string.enable_button_txt_permission_dailog, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    fragment.requestPermissions(new String[]{str}, i);
                }
            }).show();
        } else {
            fragment.requestPermissions(new String[]{str}, i);
        }
    }

    public static void showFeedBackDialog(final Context context, IaaiApplication iaaiApplication, View view, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(C2723R.C2728layout.dialog_feedback_layout, (ViewGroup) null);
        final EditText editText = (EditText) linearLayout.findViewById(C2723R.C2726id.text_comments);
        final TextView textView = (TextView) linearLayout.findViewById(C2723R.C2726id.lbl_feedback_counter);
        C33123 r2 = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            private void handleText() {
                Button button = AppUtils.dialog.getButton(-1);
                if (editText.getText().length() == 0) {
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                }
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppUtils.textCount = i3;
                TextView textView = textView;
                textView.setText(String.valueOf((250 - charSequence.length()) + context.getString(C2723R.string.characters_remaining)));
                handleText();
            }
        };
        final ToBePickedUpManager toBePickedUpManager = (ToBePickedUpManager) iaaiApplication.getInjector().getInstance(ToBePickedUpManager.class);
        editText.addTextChangedListener(r2);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(C2723R.string.lbl_menu_feedback);
        final Context context2 = context;
        final View view2 = view;
        final int i2 = i;
        builder.setView(linearLayout).setCancelable(true).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).setPositiveButton(C2723R.string.lbl_send, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                String obj = editText.getText().toString();
                if (obj.length() > 0) {
                    MDActivityHelper.closeSoftKeyboard(context2, editText);
                    AppUtils.sendFeedback(context2, toBePickedUpManager, obj, view2, i2);
                }
                dialogInterface.cancel();
            }
        });
        dialog = builder.create();
        dialog.show();
        dialog.getButton(-1).setEnabled(false);
        dialog.getWindow().setSoftInputMode(3);
    }

    public static void sendFeedback(final Context context, ToBePickedUpManager toBePickedUpManager, String str, final View view, int i) {
        final ProgressDialog showProgressDialog = MDActivityHelper.showProgressDialog(context, (String) null, (DialogInterface.OnCancelListener) null);
        showProgressDialog.show();
        toBePickedUpManager.sendAuctionFeedback(i, str, new AsyncHttpResponseHandler() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                AuctionFeedBackResponse auctionFeedBackResponse = (AuctionFeedBackResponse) new Gson().fromJson(new String(bArr), AuctionFeedBackResponse.class);
                showProgressDialog.dismiss();
                if (auctionFeedBackResponse.IsSuccessful) {
                    AppUtils.showFeedbackToast(context, view);
                } else {
                    Toast.makeText(context, auctionFeedBackResponse.validationMessage, 0).show();
                }
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                showProgressDialog.dismiss();
            }
        });
    }

    public static void showFeedbackToast(Context context, View view) {
        Snackbar.make(view, (CharSequence) context.getString(C2723R.string.text_auction_feedback_sent), 0).show();
    }

    public static int convertPixelToDP(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, new DisplayMetrics());
    }

    public static int convertDpToPixels(float f, Context context) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static void resetNewCountPrefsOnLogout(Context context) {
        IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_PREBID_COUNT_MYACCOUNT, 0);
        IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_AWARD_PENDING_COUNT_MYACCOUNT, 0);
        IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_TOBEPAID_COUNT_MYACCOUNT, 0);
        IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_TBPU_COUNT_MYACCOUNT, 0);
        IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_LOST_PREBID_COUNT_MYACCOUNT, 0);
        IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_MANAGE_OFFERS_MYACCOUNT, 0);
        IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_WATCHING_COUNT_MYACCOUNT, 0);
        IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_NOTIFICATION_MYACCOUNT, 0);
    }

    public static Date resetTodayDateTimeToMidNight() {
        new Date();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(11, 0);
        gregorianCalendar.set(12, 0);
        gregorianCalendar.set(13, 0);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTime();
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static void isAppOnLatestVersion(final Activity activity, UpdateAppManager updateAppManager) {
        updateAppManager.getLatestAppVersion(new AsyncHttpResponseHandler() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                CheckAppVersion checkAppVersion;
                if (!activity.isFinishing()) {
                    try {
                        checkAppVersion = (CheckAppVersion) new Gson().fromJson(new String(bArr), CheckAppVersion.class);
                    } catch (JsonParseException e) {
                        e.printStackTrace();
                        checkAppVersion = null;
                    }
                    if (checkAppVersion != null) {
                        try {
                            if (activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionCode < Integer.parseInt(checkAppVersion.play_store_appVersion) && !activity.isFinishing()) {
                                String str = "en";
                                if (!activity.getString(C2723R.string.title_update_alert).startsWith("Update Available")) {
                                    str = Constants_MVVM.EXTRA_SPANISH_CODE;
                                }
                                AppUtils.showNewAppUpdateAlert(activity, str);
                            }
                        } catch (PackageManager.NameNotFoundException e2) {
                            e2.printStackTrace();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                th.printStackTrace();
            }
        });
    }

    public static void showNewAppUpdateAlert(final Activity activity, final String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle((int) C2723R.string.title_update_alert);
        builder.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                    return false;
                }
                dialogInterface.cancel();
                activity.finish();
                return true;
            }
        });
        builder.setMessage((int) C2723R.string.msg_app_update_alert);
        builder.setCancelable(false);
        builder.setPositiveButton((int) C2723R.string.positive_button_text, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                try {
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.iaai.android&hl=" + str)));
                    activity.finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        androidx.appcompat.app.AlertDialog create = builder.create();
        if (!activity.isFinishing()) {
            create.show();
        }
    }

    public static String getDeviceId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), C4820b.f5526f);
    }
}
