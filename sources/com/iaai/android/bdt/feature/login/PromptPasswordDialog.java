package com.iaai.android.bdt.feature.login;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputLayout;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.EditText_ExtensionKt;
import com.iaai.android.old.utils.AppUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001d"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/login/PromptPasswordDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "listener", "Lcom/iaai/android/bdt/feature/login/EnteredPasswordCallback;", "(Landroid/app/Activity;Lcom/iaai/android/bdt/feature/login/EnteredPasswordCallback;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "getListener", "()Lcom/iaai/android/bdt/feature/login/EnteredPasswordCallback;", "setListener", "(Lcom/iaai/android/bdt/feature/login/EnteredPasswordCallback;)V", "checkValidPassword", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setError", "errorMessage", "", "showLoadingIndicator", "loading", "", "updateLoginNameAndTimeStamp", "loginname", "timeStamp", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PromptPasswordDialog.kt */
public final class PromptPasswordDialog extends Dialog {
    @NotNull
    private Activity activity;
    @NotNull
    private EnteredPasswordCallback listener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PromptPasswordDialog(@NotNull Activity activity2, @NotNull EnteredPasswordCallback enteredPasswordCallback) {
        super(activity2);
        Intrinsics.checkParameterIsNotNull(activity2, "activity");
        Intrinsics.checkParameterIsNotNull(enteredPasswordCallback, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.activity = activity2;
        this.listener = enteredPasswordCallback;
    }

    @NotNull
    public final Activity getActivity() {
        return this.activity;
    }

    @NotNull
    public final EnteredPasswordCallback getListener() {
        return this.listener;
    }

    public final void setActivity(@NotNull Activity activity2) {
        Intrinsics.checkParameterIsNotNull(activity2, "<set-?>");
        this.activity = activity2;
    }

    public final void setListener(@NotNull EnteredPasswordCallback enteredPasswordCallback) {
        Intrinsics.checkParameterIsNotNull(enteredPasswordCallback, "<set-?>");
        this.listener = enteredPasswordCallback;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(C2723R.C2728layout.bdt_prompt_password_dialog_layout);
        ((EditText) findViewById(C2723R.C2726id.etPromptPassword)).setOnEditorActionListener(new PromptPasswordDialog$onCreate$1(this));
        EditText editText = (EditText) findViewById(C2723R.C2726id.etPromptPassword);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etPromptPassword");
        EditText_ExtensionKt.onChange(editText, new PromptPasswordDialog$onCreate$2(this));
        ((ImageView) findViewById(C2723R.C2726id.ivCloseDialog)).setOnClickListener(new PromptPasswordDialog$onCreate$3(this));
        ((TextView) findViewById(C2723R.C2726id.tvForgotPasswordLink)).setOnClickListener(new PromptPasswordDialog$onCreate$4(this));
        ((TextView) findViewById(C2723R.C2726id.tvConfirm)).setOnClickListener(new PromptPasswordDialog$onCreate$5(this));
    }

    public final void checkValidPassword() {
        AppUtils.hideSoftkeyBoard(this.activity, (EditText) findViewById(C2723R.C2726id.etPromptPassword));
        EditText editText = (EditText) findViewById(C2723R.C2726id.etPromptPassword);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etPromptPassword");
        String obj = editText.getText().toString();
        TextInputLayout textInputLayout = (TextInputLayout) findViewById(C2723R.C2726id.txtPromptPasswordLayout);
        Intrinsics.checkExpressionValueIsNotNull(textInputLayout, "txtPromptPasswordLayout");
        textInputLayout.setErrorEnabled(false);
        if (TextUtils.isEmpty(obj)) {
            String string = this.activity.getResources().getString(C2723R.string.lbl_wrong_password_message);
            TextInputLayout textInputLayout2 = (TextInputLayout) findViewById(C2723R.C2726id.txtPromptPasswordLayout);
            Intrinsics.checkExpressionValueIsNotNull(textInputLayout2, "txtPromptPasswordLayout");
            textInputLayout2.setErrorEnabled(true);
            TextInputLayout textInputLayout3 = (TextInputLayout) findViewById(C2723R.C2726id.txtPromptPasswordLayout);
            Intrinsics.checkExpressionValueIsNotNull(textInputLayout3, "txtPromptPasswordLayout");
            textInputLayout3.setError(string);
            return;
        }
        this.listener.getPassword(obj);
    }

    public final void setError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "errorMessage");
        TextInputLayout textInputLayout = (TextInputLayout) findViewById(C2723R.C2726id.txtPromptPasswordLayout);
        Intrinsics.checkExpressionValueIsNotNull(textInputLayout, "txtPromptPasswordLayout");
        textInputLayout.setErrorEnabled(true);
        TextInputLayout textInputLayout2 = (TextInputLayout) findViewById(C2723R.C2726id.txtPromptPasswordLayout);
        Intrinsics.checkExpressionValueIsNotNull(textInputLayout2, "txtPromptPasswordLayout");
        textInputLayout2.setError(str);
    }

    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) findViewById(C2723R.C2726id.pbPromptPassword);
            if (progressBar != null) {
                progressBar.setVisibility(0);
                return;
            }
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) findViewById(C2723R.C2726id.pbPromptPassword);
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
    }

    public final void updateLoginNameAndTimeStamp(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "loginname");
        Intrinsics.checkParameterIsNotNull(str2, "timeStamp");
        TextView textView = (TextView) findViewById(C2723R.C2726id.tvLoggedInUserName);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvLoggedInUserName");
        textView.setText(Html.fromHtml(this.activity.getString(C2723R.string.lbl_logged_in_username) + " <b>" + str + "</b>"));
        TextView textView2 = (TextView) findViewById(C2723R.C2726id.tvLastLoginTime);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tvLastLoginTime");
        textView2.setText(this.activity.getString(C2723R.string.lbl_last_login_timestamp, new Object[]{str2}));
    }
}
