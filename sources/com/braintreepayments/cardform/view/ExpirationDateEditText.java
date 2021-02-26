package com.braintreepayments.cardform.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import com.braintreepayments.cardform.C1011R;
import com.braintreepayments.cardform.utils.DateValidator;
import java.lang.reflect.Method;

public class ExpirationDateEditText extends ErrorEditText implements TextWatcher, View.OnClickListener {
    private boolean mChangeWasAddition;
    private View.OnClickListener mClickListener;
    private ExpirationDateDialog mExpirationDateDialog;
    private boolean mUseExpirationDateDialog = false;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public ExpirationDateEditText(Context context) {
        super(context);
        init();
    }

    public ExpirationDateEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ExpirationDateEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setInputType(2);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
        addTextChangedListener(this);
        setShowKeyboardOnFocus(!this.mUseExpirationDateDialog);
        setCursorVisible(true ^ this.mUseExpirationDateDialog);
        super.setOnClickListener(this);
    }

    public void useDialogForExpirationDateEntry(Activity activity, boolean z) {
        this.mExpirationDateDialog = ExpirationDateDialog.create(activity, this);
        this.mUseExpirationDateDialog = z;
        setShowKeyboardOnFocus(!this.mUseExpirationDateDialog);
        setCursorVisible(!this.mUseExpirationDateDialog);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void onClick(View view) {
        if (this.mUseExpirationDateDialog) {
            closeSoftKeyboard();
            this.mExpirationDateDialog.show();
        }
        View.OnClickListener onClickListener = this.mClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (this.mExpirationDateDialog != null) {
            if (z && this.mUseExpirationDateDialog) {
                closeSoftKeyboard();
                this.mExpirationDateDialog.show();
            } else if (this.mUseExpirationDateDialog) {
                this.mExpirationDateDialog.dismiss();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ExpirationDateDialog expirationDateDialog = this.mExpirationDateDialog;
        if (expirationDateDialog != null && expirationDateDialog.isShowing()) {
            this.mExpirationDateDialog.dismiss();
        }
    }

    public String getMonth() {
        if (getString().length() < 2) {
            return "";
        }
        return getString().substring(0, 2);
    }

    public String getYear() {
        String string = getString();
        if (string.length() == 4 || string.length() == 6) {
            return getString().substring(2);
        }
        return "";
    }

    public boolean isValid() {
        return isOptional() || DateValidator.isValid(getMonth(), getYear());
    }

    public String getErrorMessage() {
        if (TextUtils.isEmpty(getText())) {
            return getContext().getString(C1011R.string.bt_expiration_required);
        }
        return getContext().getString(C1011R.string.bt_expiration_invalid);
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        this.mChangeWasAddition = i3 > i2;
    }

    public void afterTextChanged(Editable editable) {
        if (this.mChangeWasAddition && editable.length() == 1 && Character.getNumericValue(editable.charAt(0)) >= 2) {
            prependLeadingZero(editable);
        }
        for (Object removeSpan : editable.getSpans(0, editable.length(), SlashSpan.class)) {
            editable.removeSpan(removeSpan);
        }
        addDateSlash(editable);
        if (((getSelectionStart() == 4 && !editable.toString().endsWith("20")) || getSelectionStart() == 6) && isValid()) {
            focusNextView();
        }
    }

    private void setShowKeyboardOnFocus(boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            setShowSoftInputOnFocus(z);
            return;
        }
        Class<EditText> cls = EditText.class;
        try {
            Method method = cls.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
            method.setAccessible(true);
            method.invoke(this, new Object[]{Boolean.valueOf(z)});
        } catch (Exception unused) {
            Class<EditText> cls2 = EditText.class;
            try {
                Method method2 = cls2.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
                method2.setAccessible(true);
                method2.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Exception unused2) {
                this.mUseExpirationDateDialog = false;
            }
        }
    }

    private void prependLeadingZero(Editable editable) {
        editable.replace(0, 1, "0").append(editable.charAt(0));
    }

    private void addDateSlash(Editable editable) {
        if (2 <= editable.length()) {
            editable.setSpan(new SlashSpan(), 1, 2, 33);
        }
    }

    private String getString() {
        Editable text = getText();
        return text != null ? text.toString() : "";
    }
}
