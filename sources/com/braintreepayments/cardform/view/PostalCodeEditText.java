package com.braintreepayments.cardform.view;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import com.braintreepayments.cardform.C1011R;

public class PostalCodeEditText extends ErrorEditText {
    public PostalCodeEditText(Context context) {
        super(context);
        init();
    }

    public PostalCodeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PostalCodeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setInputType(112);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(16)});
    }

    public boolean isValid() {
        return isOptional() || getText().toString().length() > 0;
    }

    public String getErrorMessage() {
        return getContext().getString(C1011R.string.bt_postal_code_required);
    }
}
