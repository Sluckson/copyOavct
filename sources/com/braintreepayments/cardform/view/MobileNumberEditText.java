package com.braintreepayments.cardform.view;

import android.content.Context;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
import android.text.InputFilter;
import android.util.AttributeSet;
import com.braintreepayments.cardform.C1011R;

public class MobileNumberEditText extends ErrorEditText {
    public MobileNumberEditText(Context context) {
        super(context);
        init();
    }

    public MobileNumberEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MobileNumberEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            setInputType(3);
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(14)});
            addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        }
    }

    public String getMobileNumber() {
        return PhoneNumberUtils.stripSeparators(getText().toString());
    }

    public boolean isValid() {
        return isOptional() || getText().toString().length() >= 8;
    }

    public String getErrorMessage() {
        return getContext().getString(C1011R.string.bt_mobile_number_required);
    }
}
