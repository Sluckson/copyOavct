package com.braintreepayments.cardform.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.braintreepayments.cardform.C1011R;
import com.braintreepayments.cardform.utils.CardType;

public class CvvEditText extends ErrorEditText implements TextWatcher {
    private static final int DEFAULT_MAX_LENGTH = 3;
    private CardType mCardType;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public CvvEditText(Context context) {
        super(context);
        init();
    }

    public CvvEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CvvEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setInputType(2);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
        addTextChangedListener(this);
    }

    public void setCardType(CardType cardType) {
        this.mCardType = cardType;
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(cardType.getSecurityCodeLength())});
        setContentDescription(getContext().getString(cardType.getSecurityCodeName()));
        setFieldHint(cardType.getSecurityCodeName());
        invalidate();
    }

    public void setMask(boolean z) {
        if (z) {
            setInputType(18);
        } else {
            setInputType(2);
        }
    }

    public void afterTextChanged(Editable editable) {
        CardType cardType = this.mCardType;
        if (cardType != null && cardType.getSecurityCodeLength() == editable.length() && getSelectionStart() == editable.length()) {
            validate();
            if (isValid()) {
                focusNextView();
            }
        }
    }

    public boolean isValid() {
        return isOptional() || getText().toString().length() == getSecurityCodeLength();
    }

    public String getErrorMessage() {
        String str;
        if (this.mCardType == null) {
            str = getContext().getString(C1011R.string.bt_cvv);
        } else {
            str = getContext().getString(this.mCardType.getSecurityCodeName());
        }
        if (TextUtils.isEmpty(getText())) {
            return getContext().getString(C1011R.string.bt_cvv_required, new Object[]{str});
        }
        return getContext().getString(C1011R.string.bt_cvv_invalid, new Object[]{str});
    }

    private int getSecurityCodeLength() {
        CardType cardType = this.mCardType;
        if (cardType == null) {
            return 3;
        }
        return cardType.getSecurityCodeLength();
    }
}
