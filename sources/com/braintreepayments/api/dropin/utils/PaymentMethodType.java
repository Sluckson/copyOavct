package com.braintreepayments.api.dropin.utils;

import androidx.annotation.Nullable;
import com.braintreepayments.api.dropin.C0944R;
import com.braintreepayments.api.models.BinData;
import com.braintreepayments.api.models.PaymentMethodNonce;
import com.braintreepayments.cardform.utils.CardType;
import java.util.ArrayList;
import java.util.Set;

public enum PaymentMethodType {
    AMEX(CardType.AMEX.getFrontResource(), C0944R.C0946drawable.bt_ic_vaulted_amex, C0944R.string.bt_descriptor_amex, "American Express", CardType.AMEX),
    GOOGLE_PAYMENT(C0944R.C0946drawable.bt_ic_google_pay, 0, C0944R.string.bt_descriptor_google_pay, "Google Pay", (int) null),
    DINERS(CardType.DINERS_CLUB.getFrontResource(), C0944R.C0946drawable.bt_ic_vaulted_diners_club, C0944R.string.bt_descriptor_diners, "Diners", CardType.DINERS_CLUB),
    DISCOVER(CardType.DISCOVER.getFrontResource(), C0944R.C0946drawable.bt_ic_vaulted_discover, C0944R.string.bt_descriptor_discover, "Discover", CardType.DISCOVER),
    JCB(CardType.JCB.getFrontResource(), C0944R.C0946drawable.bt_ic_vaulted_jcb, C0944R.string.bt_descriptor_jcb, "JCB", CardType.JCB),
    MAESTRO(CardType.MAESTRO.getFrontResource(), C0944R.C0946drawable.bt_ic_vaulted_maestro, C0944R.string.bt_descriptor_maestro, "Maestro", CardType.MAESTRO),
    MASTERCARD(CardType.MASTERCARD.getFrontResource(), C0944R.C0946drawable.bt_ic_vaulted_mastercard, C0944R.string.bt_descriptor_mastercard, "MasterCard", CardType.MASTERCARD),
    PAYPAL(C0944R.C0946drawable.bt_ic_paypal, C0944R.C0946drawable.bt_ic_vaulted_paypal, C0944R.string.bt_descriptor_paypal, "PayPal", (int) null),
    VISA(CardType.VISA.getFrontResource(), C0944R.C0946drawable.bt_ic_vaulted_visa, C0944R.string.bt_descriptor_visa, "Visa", CardType.VISA),
    PAY_WITH_VENMO(C0944R.C0946drawable.bt_ic_venmo, C0944R.C0946drawable.bt_ic_vaulted_venmo, C0944R.string.bt_descriptor_pay_with_venmo, "Venmo", (int) null),
    UNIONPAY(CardType.UNIONPAY.getFrontResource(), C0944R.C0946drawable.bt_ic_vaulted_unionpay, C0944R.string.bt_descriptor_unionpay, "UnionPay", CardType.UNIONPAY),
    HIPER(CardType.HIPER.getFrontResource(), C0944R.C0946drawable.bt_ic_vaulted_hiper, C0944R.string.bt_descriptor_hiper, "Hiper", CardType.HIPER),
    HIPERCARD(CardType.HIPERCARD.getFrontResource(), C0944R.C0946drawable.bt_ic_vaulted_hipercard, C0944R.string.bt_descriptor_hipercard, "Hipercard", CardType.HIPERCARD),
    UNKNOWN(CardType.UNKNOWN.getFrontResource(), C0944R.C0946drawable.bt_ic_vaulted_unknown, C0944R.string.bt_descriptor_unknown, BinData.UNKNOWN, CardType.UNKNOWN);
    
    private String mCanonicalName;
    private CardType mCardType;
    private final int mIconDrawable;
    private final int mLocalizedName;
    private final int mVaultedDrawable;

    private PaymentMethodType(int i, int i2, int i3, String str, CardType cardType) {
        this.mIconDrawable = i;
        this.mVaultedDrawable = i2;
        this.mLocalizedName = i3;
        this.mCanonicalName = str;
        this.mCardType = cardType;
    }

    public static PaymentMethodType forType(@Nullable String str) {
        for (PaymentMethodType paymentMethodType : values()) {
            if (paymentMethodType.mCanonicalName.equals(str)) {
                return paymentMethodType;
            }
        }
        return UNKNOWN;
    }

    public static PaymentMethodType forType(PaymentMethodNonce paymentMethodNonce) {
        return forType(paymentMethodNonce.getTypeLabel());
    }

    public static CardType[] getCardsTypes(Set<String> set) {
        CardType cardType;
        ArrayList arrayList = new ArrayList();
        for (String forType : set) {
            PaymentMethodType forType2 = forType(forType);
            if (!(forType2 == UNKNOWN || (cardType = forType2.mCardType) == null)) {
                arrayList.add(cardType);
            }
        }
        return (CardType[]) arrayList.toArray(new CardType[arrayList.size()]);
    }

    public int getDrawable() {
        return this.mIconDrawable;
    }

    public int getVaultedDrawable() {
        return this.mVaultedDrawable;
    }

    public int getLocalizedName() {
        return this.mLocalizedName;
    }

    public String getCanonicalName() {
        return this.mCanonicalName;
    }
}
