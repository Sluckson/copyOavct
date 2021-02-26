package com.braintreepayments.cardform.view;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import com.braintreepayments.cardform.C1011R;

public class CardholderNameEditText extends ErrorEditText {
    public CardholderNameEditText(Context context) {
        super(context);
        init();
    }

    public CardholderNameEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CardholderNameEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setInputType(1);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(255)});
    }

    public boolean isValid() {
        return isOptional() || !getText().toString().trim().isEmpty();
    }

    public String getErrorMessage() {
        return getContext().getString(C1011R.string.bt_cardholder_name_required);
    }
}
