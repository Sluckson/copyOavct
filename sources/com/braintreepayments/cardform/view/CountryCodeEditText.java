package com.braintreepayments.cardform.view;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import com.braintreepayments.cardform.C1011R;

public class CountryCodeEditText extends ErrorEditText {
    public CountryCodeEditText(Context context) {
        super(context);
        init();
    }

    public CountryCodeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CountryCodeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setInputType(3);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
    }

    public String getCountryCode() {
        return getText().toString().replaceAll("[^\\d]", "");
    }

    public boolean isValid() {
        return isOptional() || getText().toString().length() > 0;
    }

    public String getErrorMessage() {
        return getContext().getString(C1011R.string.bt_country_code_required);
    }
}
