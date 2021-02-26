package com.iaai.android.old.utils.p016ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.activities.ContactUsActivity;
import com.iaai.android.old.utils.ICommand;
import java.util.List;
import roboguice.util.C5058Ln;

/* renamed from: com.iaai.android.old.utils.ui.MDActivityHelper */
public class MDActivityHelper {
    public static final int[] DEFAULT_MENU_IDS = {C2723R.C2726id.menu_id_preference, C2723R.C2726id.menu_id_contact_us};
    public static final String ERROR_DIALOG_TITLE_RESOURCE = "droidfu_error_dialog_title";
    private static final String PROGRESS_DIALOG_MESSAGE_RESOURCE = "droidfu_progress_dialog_message";
    private static final String PROGRESS_DIALOG_TITLE_RESOURCE = "droidfu_progress_dialog_title";

    public static ProgressDialog createProgressDialog(final Activity activity, int i, int i2) {
        ProgressDialog progressDialog = new ProgressDialog(activity);
        if (i <= 0) {
            i = activity.getResources().getIdentifier(PROGRESS_DIALOG_TITLE_RESOURCE, "string", activity.getPackageName());
        }
        progressDialog.setTitle(i);
        if (i2 <= 0) {
            i2 = activity.getResources().getIdentifier(PROGRESS_DIALOG_MESSAGE_RESOURCE, "string", activity.getPackageName());
        }
        progressDialog.setMessage(activity.getString(i2));
        progressDialog.setIndeterminate(true);
        progressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                activity.onKeyDown(i, keyEvent);
                return false;
            }
        });
        return progressDialog;
    }

    public static Dialog showLoadingDialog(Activity activity) {
        return showProgressDialog(activity, IaaiApplication.mContext.getString(C2723R.string.msg_Loading));
    }

    public static Dialog showProgressDialog(Activity activity, String str) {
        return showProgressDialog(activity, str, (DialogInterface.OnCancelListener) null);
    }

    public static ProgressDialog showProgressDialog(Activity activity, String str, DialogInterface.OnCancelListener onCancelListener) {
        ProgressDialog progressDialog = null;
        if (activity != null && !activity.isFinishing()) {
            progressDialog = ProgressDialog.show(activity, (CharSequence) null, (CharSequence) null);
            progressDialog.setContentView(C2723R.C2728layout.custom_progres_dlaiog_layout);
            if (str != null && str.length() > 0 && !str.equalsIgnoreCase(activity.getString(C2723R.string.msg_Loading))) {
                TextView textView = (TextView) progressDialog.findViewById(C2723R.C2726id.loading_msg);
                textView.setVisibility(0);
                textView.setText(str);
            }
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        return progressDialog;
    }

    public static ProgressDialog showProgressDialog(Context context, String str, DialogInterface.OnCancelListener onCancelListener) {
        ProgressDialog show = ProgressDialog.show(context, (CharSequence) null, (CharSequence) null);
        show.setContentView(C2723R.C2728layout.custom_progres_dlaiog_layout);
        if (str != null && str.length() > 0 && !str.equalsIgnoreCase(context.getString(C2723R.string.msg_Loading))) {
            TextView textView = (TextView) show.findViewById(C2723R.C2726id.loading_msg);
            textView.setVisibility(0);
            textView.setText(str);
        }
        show.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return show;
    }

    public static Dialog showLocationProgressDialog(Activity activity, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            ProgressDialog show = ProgressDialog.show(activity, "", str, true);
            if (onCancelListener == null) {
                return show;
            }
            show.setCancelable(true);
            show.setOnCancelListener(onCancelListener);
            return show;
        } catch (Throwable th) {
            C5058Ln.m4842w(th);
            return null;
        }
    }

    public static Dialog showAlert(Activity activity, int i, String str, ICommand<DialogInterface> iCommand) {
        return showAlert(activity, IaaiApplication.mContext.getString(i), str, iCommand);
    }

    public static Dialog showAlert(Activity activity, String str, String str2, final ICommand<DialogInterface> iCommand) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle(str).setMessage(str2).setCancelable(false).setPositiveButton(C2723R.string.lbl_OK_lower, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    ICommand iCommand = iCommand;
                    if (iCommand != null) {
                        iCommand.execute(dialogInterface);
                    }
                    dialogInterface.cancel();
                }
            });
            AlertDialog create = builder.create();
            create.show();
            return create;
        } catch (Exception e) {
            C5058Ln.m4842w(e);
            return null;
        }
    }

    public static Dialog showConfirmationDialog(Activity activity, String str, String str2, DialogInterface.OnClickListener onClickListener) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setCancelable(false);
            builder.setPositiveButton(17039370, onClickListener);
            builder.setNegativeButton(17039360, onClickListener);
            builder.setTitle(str);
            builder.setMessage(str2);
            AlertDialog create = builder.create();
            create.show();
            return create;
        } catch (Exception e) {
            C5058Ln.m4842w(e);
            return null;
        }
    }

    public static Dialog showCustomDialog(Activity activity, View view, final ICommand<?> iCommand) {
        AlertDialog alertDialog;
        IDialogContainer dialogContainer = getDialogContainer(activity);
        if (dialogContainer == null) {
            return null;
        }
        Dialog dialog = dialogContainer.getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(dialogContainer.getContext());
            builder.setView(view).setCancelable(true).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            }).setPositiveButton(C2723R.string.lbl_OK_lower, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    ICommand iCommand = iCommand;
                    if (iCommand != null) {
                        iCommand.execute(null);
                    }
                    dialogInterface.cancel();
                }
            });
            alertDialog = builder.create();
            alertDialog.show();
        } catch (Exception e) {
            C5058Ln.m4842w(e);
            alertDialog = null;
        }
        dialogContainer.setDialog(alertDialog);
        return alertDialog;
    }

    public static Dialog showAuctionDateDialog(Activity activity, View view, final ICommand<?> iCommand) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setView(view).setCancelable(true).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    ICommand iCommand = iCommand;
                    if (iCommand != null) {
                        iCommand.execute(null);
                    }
                    dialogInterface.cancel();
                }
            });
            return builder.create();
        } catch (Exception e) {
            C5058Ln.m4842w(e);
            return null;
        }
    }

    public static Dialog showRateMyAppDialog(final Context context, Activity activity, View view, final SharedPreferences.Editor editor) {
        AlertDialog alertDialog;
        IDialogContainer dialogContainer = getDialogContainer(activity);
        if (dialogContainer == null) {
            return null;
        }
        Dialog dialog = dialogContainer.getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(dialogContainer.getContext());
            builder.setView(view).setNeutralButton("Rate IAA Buyer", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.iaai.android")));
                    dialogInterface.dismiss();
                }
            }).setPositiveButton("Remind me later", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).setNegativeButton("No, thanks", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    SharedPreferences.Editor editor = editor;
                    if (editor != null) {
                        editor.putBoolean("dontshowagain", true);
                        editor.commit();
                    }
                    dialogInterface.dismiss();
                }
            });
            alertDialog = builder.create();
            alertDialog.show();
        } catch (Exception e) {
            C5058Ln.m4842w(e);
            alertDialog = null;
        }
        dialogContainer.setDialog(alertDialog);
        return alertDialog;
    }

    public static IDialogContainer getDialogContainer(Activity activity) {
        if (activity == null) {
            return null;
        }
        if (activity instanceof IDialogContainer) {
            IDialogContainer iDialogContainer = (IDialogContainer) activity;
            if (iDialogContainer.isDialogHandled()) {
                return iDialogContainer;
            }
        }
        Activity parent = activity.getParent();
        if (parent != null) {
            return getDialogContainer(parent);
        }
        return null;
    }

    public static void dismissDialog(Activity activity) {
        IDialogContainer dialogContainer = getDialogContainer(activity);
        if (dialogContainer != null) {
            Dialog dialog = dialogContainer.getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
            dialogContainer.setDialog((Dialog) null);
        }
    }

    public static void pushActivityToGroup(Activity activity, Intent intent) {
        String str;
        ComponentName component = intent.getComponent();
        if (component != null) {
            str = component.getShortClassName();
        } else if (!TextUtils.isEmpty(intent.getAction())) {
            str = intent.getAction();
        } else {
            throw new RuntimeException("Not Id found for pushing activity to group");
        }
        pushActivityToGroup(activity, str, intent);
    }

    public static void pushActivityToGroup(Activity activity, String str, Intent intent) {
        getTabRootActivityOrError(activity).startChildActivity(str, intent);
    }

    private static ITabRoot getTabRootActivityOrError(Activity activity) {
        ITabRoot tabRootActivity = getTabRootActivity(activity);
        if (tabRootActivity != null) {
            return tabRootActivity;
        }
        throw new RuntimeException("Unable to find tab root activity for displaying dialog");
    }

    public static ITabRoot getTabRootActivity(Activity activity) {
        if (activity == null) {
            return null;
        }
        Activity parent = activity.getParent();
        if (parent instanceof ITabRoot) {
            return (ITabRoot) parent;
        }
        return getTabRootActivity(parent);
    }

    public static void showSoftKeyboard(Activity activity, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(view, 2);
        }
    }

    public static void closeSoftKeyboard(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void closeSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    public static <T> void promptSelection(Activity activity, String str, List<T> list, ICommand<T> iCommand) {
        promptSelection(activity, str, (T[]) list.toArray(), iCommand);
    }

    public static <T> void promptSelection(Activity activity, int i, List<T> list, ICommand<T> iCommand) {
        promptSelection(activity, activity.getString(i), (T[]) list.toArray(), iCommand);
    }

    public static boolean isCorrectMenu(Menu menu, int[] iArr) {
        if (iArr == null || iArr.length != menu.size()) {
            return false;
        }
        int length = iArr.length;
        for (int findItem : iArr) {
            if (menu.findItem(findItem) == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean createOptionMenu(Menu menu, int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return true;
        }
        for (int i : iArr) {
        }
        return false;
    }

    public static boolean onMenuItemSelected(Activity activity, MenuItem menuItem) {
        if (menuItem.getItemId() != C2723R.C2726id.menu_id_contact_us) {
            return false;
        }
        activity.startActivity(new Intent(activity, ContactUsActivity.class));
        return true;
    }

    public static <T> void promptSelection(Activity activity, int i, T[] tArr, ICommand<T> iCommand) {
        promptSelection(activity, activity.getString(i), tArr, iCommand);
    }

    public static <T> void promptSelection(Activity activity, String str, T[] tArr, final ICommand<T> iCommand) {
        if (activity != null && !activity.isFinishing()) {
            final ArrayAdapter arrayAdapter = new ArrayAdapter(activity, C2723R.C2728layout.simple_text_row, 16908308, tArr);
            new AlertDialog.Builder(activity).setTitle(str).setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    iCommand.execute(arrayAdapter.getItem(i));
                }
            }).create().show();
        }
    }

    public static <T> void promptSelection(Activity activity, int i, T[] tArr, final ICommand<T> iCommand, int i2) {
        IDialogContainer dialogContainer = getDialogContainer(activity);
        if (dialogContainer != null) {
            final ArrayAdapter arrayAdapter = new ArrayAdapter(dialogContainer.getContext(), C2723R.C2728layout.simple_text_row, 16908308, tArr);
            new AlertDialog.Builder(dialogContainer.getContext()).setTitle(i).setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    iCommand.execute(arrayAdapter.getItem(i));
                }
            }).setNegativeButton(i2, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).create().show();
        }
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
