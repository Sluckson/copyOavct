package com.braintreepayments.cardform.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.braintreepayments.cardform.C1011R;
import com.braintreepayments.cardform.utils.CardNumberTransformation;
import com.braintreepayments.cardform.utils.CardType;

public class CardEditText extends ErrorEditText implements TextWatcher {
    private CardType mCardType;
    private boolean mDisplayCardIcon = true;
    private boolean mMask = false;
    private OnCardTypeChangedListener mOnCardTypeChangedListener;
    private TransformationMethod mSavedTranformationMethod;

    public interface OnCardTypeChangedListener {
        void onCardTypeChanged(CardType cardType);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public CardEditText(Context context) {
        super(context);
        init();
    }

    public CardEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CardEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setInputType(2);
        setCardIcon(C1011R.C1013drawable.bt_ic_unknown);
        addTextChangedListener(this);
        updateCardType();
        this.mSavedTranformationMethod = getTransformationMethod();
    }

    public void displayCardTypeIcon(boolean z) {
        this.mDisplayCardIcon = z;
        if (!this.mDisplayCardIcon) {
            setCardIcon(-1);
        }
    }

    public CardType getCardType() {
        return this.mCardType;
    }

    public void setMask(boolean z) {
        this.mMask = z;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z) {
            unmaskNumber();
            if (getText().toString().length() > 0) {
                setSelection(getText().toString().length());
            }
        } else if (this.mMask && isValid()) {
            maskNumber();
        }
    }

    public void setOnCardTypeChangedListener(OnCardTypeChangedListener onCardTypeChangedListener) {
        this.mOnCardTypeChangedListener = onCardTypeChangedListener;
    }

    public void afterTextChanged(Editable editable) {
        for (Object removeSpan : editable.getSpans(0, editable.length(), SpaceSpan.class)) {
            editable.removeSpan(removeSpan);
        }
        updateCardType();
        setCardIcon(this.mCardType.getFrontResource());
        addSpans(editable, this.mCardType.getSpaceIndices());
        if (this.mCardType.getMaxCardLength() == getSelectionStart()) {
            validate();
            if (isValid()) {
                focusNextView();
            } else {
                unmaskNumber();
            }
        } else if (!hasFocus() && this.mMask) {
            maskNumber();
        }
    }

    public boolean isValid() {
        return isOptional() || this.mCardType.validate(getText().toString());
    }

    public String getErrorMessage() {
        if (TextUtils.isEmpty(getText())) {
            return getContext().getString(C1011R.string.bt_card_number_required);
        }
        return getContext().getString(C1011R.string.bt_card_number_invalid);
    }

    private void maskNumber() {
        if (!(getTransformationMethod() instanceof CardNumberTransformation)) {
            this.mSavedTranformationMethod = getTransformationMethod();
            setTransformationMethod(new CardNumberTransformation());
        }
    }

    private void unmaskNumber() {
        TransformationMethod transformationMethod = getTransformationMethod();
        TransformationMethod transformationMethod2 = this.mSavedTranformationMethod;
        if (transformationMethod != transformationMethod2) {
            setTransformationMethod(transformationMethod2);
        }
    }

    private void updateCardType() {
        CardType forCardNumber = CardType.forCardNumber(getText().toString());
        if (this.mCardType != forCardNumber) {
            this.mCardType = forCardNumber;
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.mCardType.getMaxCardLength())});
            invalidate();
            OnCardTypeChangedListener onCardTypeChangedListener = this.mOnCardTypeChangedListener;
            if (onCardTypeChangedListener != null) {
                onCardTypeChangedListener.onCardTypeChanged(this.mCardType);
            }
        }
    }

    private void addSpans(Editable editable, int[] iArr) {
        int length = editable.length();
        for (int i : iArr) {
            if (i <= length) {
                editable.setSpan(new SpaceSpan(), i - 1, i, 33);
            }
        }
    }

    private void setCardIcon(int i) {
        if (!this.mDisplayCardIcon || getText().length() == 0) {
            TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds((TextView) this, 0, 0, 0, 0);
        } else {
            TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds((TextView) this, 0, 0, i, 0);
        }
    }
}
