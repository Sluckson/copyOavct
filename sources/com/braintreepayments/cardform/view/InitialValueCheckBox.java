package com.braintreepayments.cardform.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;

public class InitialValueCheckBox extends AppCompatCheckBox {
    private static final String EXTRA_CHECKED_VALUE = "com.braintreepayments.cardform.view.InitialValueCheckBox.EXTRA_CHECKED_VALUE";
    private static final String EXTRA_SUPER_STATE = "com.braintreepayments.cardform.view.InitialValueCheckBox.EXTRA_SUPER_STATE";
    private boolean mRestored;

    public InitialValueCheckBox(Context context) {
        super(context);
    }

    public InitialValueCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InitialValueCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_SUPER_STATE, onSaveInstanceState);
        bundle.putBoolean(EXTRA_CHECKED_VALUE, isChecked());
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable(EXTRA_SUPER_STATE));
        setChecked(bundle.getBoolean(EXTRA_CHECKED_VALUE));
        this.mRestored = true;
    }

    public void setInitiallyChecked(boolean z) {
        if (!this.mRestored) {
            setChecked(z);
        }
    }
}
