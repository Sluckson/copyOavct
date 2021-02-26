package com.braintreepayments.cardform.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.braintreepayments.cardform.utils.CardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressLint({"AppCompatCustomView"})
public class SupportedCardTypesView extends TextView {
    private List<CardType> mSupportedCardTypes = new ArrayList();

    public SupportedCardTypesView(Context context) {
        super(context);
    }

    public SupportedCardTypesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SupportedCardTypesView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public SupportedCardTypesView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setSupportedCardTypes(@Nullable CardType... cardTypeArr) {
        if (cardTypeArr == null) {
            cardTypeArr = new CardType[0];
        }
        this.mSupportedCardTypes.clear();
        this.mSupportedCardTypes.addAll(Arrays.asList(cardTypeArr));
        setSelected(cardTypeArr);
    }

    public void setSelected(@Nullable CardType... cardTypeArr) {
        int i = 0;
        if (cardTypeArr == null) {
            cardTypeArr = new CardType[0];
        }
        SpannableString spannableString = new SpannableString(new String(new char[this.mSupportedCardTypes.size()]));
        while (i < this.mSupportedCardTypes.size()) {
            PaddedImageSpan paddedImageSpan = new PaddedImageSpan(getContext(), this.mSupportedCardTypes.get(i).getFrontResource());
            paddedImageSpan.setDisabled(!Arrays.asList(cardTypeArr).contains(this.mSupportedCardTypes.get(i)));
            int i2 = i + 1;
            spannableString.setSpan(paddedImageSpan, i, i2, 33);
            i = i2;
        }
        setText(spannableString);
    }
}
