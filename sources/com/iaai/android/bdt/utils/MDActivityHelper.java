package com.iaai.android.bdt.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.view.View;
import com.iaai.android.C2723R;
import com.iaai.android.old.utils.ICommand;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import roboguice.util.C5058Ln;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000e¨\u0006\u000f"}, mo66933d2 = {"Lcom/iaai/android/bdt/utils/MDActivityHelper;", "", "()V", "showAuctionDateDialog", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "view", "Landroid/view/View;", "onOk", "Lcom/iaai/android/old/utils/ICommand;", "showLocationErrorDialog", "showVINDetailToolTipDialog", "message", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MDActivityHelper.kt */
public final class MDActivityHelper {
    public static final MDActivityHelper INSTANCE = new MDActivityHelper();

    private MDActivityHelper() {
    }

    @Nullable
    public final Dialog showAuctionDateDialog(@NotNull Activity activity, @NotNull View view, @Nullable ICommand<?> iCommand) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(view, "view");
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setView(view).setCancelable(true).setNegativeButton(17039360, new MDActivityHelper$showAuctionDateDialog$1(iCommand));
            return builder.create();
        } catch (Exception e) {
            C5058Ln.m4842w(e);
            return null;
        }
    }

    @Nullable
    public final Dialog showVINDetailToolTipDialog(@NotNull Activity activity, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage(str).setCancelable(true).setNegativeButton(17039370, MDActivityHelper$showVINDetailToolTipDialog$1.INSTANCE);
            return builder.create();
        } catch (Exception e) {
            C5058Ln.m4842w(e);
            return null;
        }
    }

    @Nullable
    public final Dialog showLocationErrorDialog(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage(activity.getString(C2723R.string.location_error_msg)).setTitle(activity.getString(C2723R.string.location_error_title)).setCancelable(true).setNegativeButton(17039370, MDActivityHelper$showLocationErrorDialog$1.INSTANCE);
            return builder.create();
        } catch (Exception e) {
            C5058Ln.m4842w(e);
            return null;
        }
    }
}
