package com.braintreepayments.api.dropin.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.braintreepayments.api.dropin.C0944R;
import com.braintreepayments.api.dropin.interfaces.AddPaymentUpdateListener;
import com.braintreepayments.api.dropin.utils.PaymentMethodType;
import com.braintreepayments.api.exceptions.BraintreeError;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import com.braintreepayments.api.models.Configuration;
import com.braintreepayments.cardform.OnCardFormSubmitListener;
import com.braintreepayments.cardform.OnCardFormValidListener;
import com.braintreepayments.cardform.utils.CardType;
import com.braintreepayments.cardform.view.CardEditText;
import com.braintreepayments.cardform.view.CardForm;
import com.braintreepayments.cardform.view.SupportedCardTypesView;
import com.lowagie.text.ElementTags;
import java.util.Arrays;
import java.util.HashSet;

public class AddCardView extends LinearLayout implements OnCardFormSubmitListener, OnCardFormValidListener, View.OnClickListener, CardEditText.OnCardTypeChangedListener {
    private static final String CARD_NUMBER = "com.braintreepayments.api.dropin.view.CARD_NUMBER";
    private static final String PARENT_STATE = "com.braintreepayments.api.dropin.view.PARENT_STATE";
    private AnimatedButtonView mAnimatedButtonView;
    private CardForm mCardForm;
    private String mCardNumber;
    private AddPaymentUpdateListener mListener;
    private CardType[] mSupportedCardTypes;
    private SupportedCardTypesView mSupportedCardTypesView;

    public AddCardView(Context context) {
        super(context);
        init();
    }

    public AddCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public AddCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    @TargetApi(21)
    public AddCardView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            setOrientation(1);
            LayoutInflater.from(getContext()).inflate(C0944R.C0949layout.bt_add_card, this, true);
            this.mCardForm = (CardForm) findViewById(C0944R.C0947id.bt_card_form);
            this.mSupportedCardTypesView = (SupportedCardTypesView) findViewById(C0944R.C0947id.bt_supported_card_types);
            this.mAnimatedButtonView = (AnimatedButtonView) findViewById(C0944R.C0947id.bt_animated_button_view);
        }
    }

    public void setup(AppCompatActivity appCompatActivity, Configuration configuration, boolean z) {
        int i = 0;
        this.mCardForm.getCardEditText().displayCardTypeIcon(false);
        this.mCardForm.cardRequired(true).setup(appCompatActivity);
        this.mCardForm.setOnCardTypeChangedListener(this);
        this.mCardForm.setOnCardFormValidListener(this);
        this.mCardForm.setOnCardFormSubmitListener(this);
        HashSet hashSet = new HashSet(configuration.getCardConfiguration().getSupportedCardTypes());
        if (!z) {
            hashSet.remove(PaymentMethodType.UNIONPAY.getCanonicalName());
        }
        this.mSupportedCardTypes = PaymentMethodType.getCardsTypes(hashSet);
        this.mSupportedCardTypesView.setSupportedCardTypes(this.mSupportedCardTypes);
        AnimatedButtonView animatedButtonView = this.mAnimatedButtonView;
        if (!configuration.getUnionPay().isEnabled()) {
            i = 8;
        }
        animatedButtonView.setVisibility(i);
        this.mAnimatedButtonView.setClickListener(this);
        if (this.mCardNumber != null) {
            this.mCardForm.getCardEditText().setText(this.mCardNumber);
            this.mCardNumber = null;
        }
    }

    public void setAddPaymentUpdatedListener(AddPaymentUpdateListener addPaymentUpdateListener) {
        this.mListener = addPaymentUpdateListener;
    }

    public CardForm getCardForm() {
        return this.mCardForm;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        this.mAnimatedButtonView.showButton();
        if (i == 0) {
            this.mCardForm.getCardEditText().requestFocus();
        }
    }

    public void showCardNotSupportedError() {
        this.mCardForm.getCardEditText().setError(getContext().getString(C0944R.string.bt_card_not_accepted));
        this.mAnimatedButtonView.showButton();
    }

    public boolean isCardNumberError(ErrorWithResponse errorWithResponse) {
        BraintreeError errorFor = errorWithResponse.errorFor("creditCard");
        return (errorFor == null || errorFor.errorFor(ElementTags.NUMBER) == null) ? false : true;
    }

    public void setErrors(ErrorWithResponse errorWithResponse) {
        BraintreeError errorFor = errorWithResponse.errorFor("creditCard");
        if (!(errorFor == null || errorFor.errorFor(ElementTags.NUMBER) == null)) {
            this.mCardForm.setCardNumberError(getContext().getString(C0944R.string.bt_card_number_invalid));
        }
        this.mAnimatedButtonView.showButton();
    }

    public void onCardTypeChanged(CardType cardType) {
        if (cardType == CardType.EMPTY) {
            this.mSupportedCardTypesView.setSupportedCardTypes(this.mSupportedCardTypes);
            return;
        }
        this.mSupportedCardTypesView.setSelected(cardType);
    }

    public void onClick(View view) {
        if (isValid()) {
            callAddPaymentUpdateListener();
            return;
        }
        this.mAnimatedButtonView.showButton();
        if (!this.mCardForm.isValid()) {
            this.mCardForm.validate();
        } else if (!isCardTypeValid()) {
            showCardNotSupportedError();
        }
    }

    public void onCardFormSubmit() {
        if (isValid()) {
            this.mAnimatedButtonView.showLoading();
            callAddPaymentUpdateListener();
        } else if (!this.mCardForm.isValid()) {
            this.mCardForm.validate();
        } else if (!isCardTypeValid()) {
            showCardNotSupportedError();
        }
    }

    public void onCardFormValid(boolean z) {
        if (isValid()) {
            this.mAnimatedButtonView.showLoading();
            callAddPaymentUpdateListener();
        }
    }

    private boolean isValid() {
        return this.mCardForm.isValid() && isCardTypeValid();
    }

    private boolean isCardTypeValid() {
        return Arrays.asList(this.mSupportedCardTypes).contains(this.mCardForm.getCardEditText().getCardType());
    }

    private void callAddPaymentUpdateListener() {
        AddPaymentUpdateListener addPaymentUpdateListener = this.mListener;
        if (addPaymentUpdateListener != null) {
            addPaymentUpdateListener.onPaymentUpdated(this);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(PARENT_STATE, super.onSaveInstanceState());
        bundle.putString(CARD_NUMBER, this.mCardForm.getCardNumber());
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mCardNumber = bundle.getString(CARD_NUMBER);
            parcelable = bundle.getParcelable(PARENT_STATE);
        }
        super.onRestoreInstanceState(parcelable);
    }
}
