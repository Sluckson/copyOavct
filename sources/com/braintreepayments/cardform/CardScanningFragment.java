package com.braintreepayments.cardform;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.braintreepayments.cardform.utils.ColorUtils;
import com.braintreepayments.cardform.view.CardForm;
import io.card.payment.CardIOActivity;

public class CardScanningFragment extends Fragment {
    private static final int CARD_IO_REQUEST_CODE = 12398;
    public static final String TAG = "com.braintreepayments.cardform.CardScanningFragment";
    private CardForm mCardForm;

    public static CardScanningFragment requestScan(AppCompatActivity appCompatActivity, CardForm cardForm) {
        CardScanningFragment cardScanningFragment = (CardScanningFragment) appCompatActivity.getSupportFragmentManager().findFragmentByTag(TAG);
        if (cardScanningFragment != null) {
            appCompatActivity.getSupportFragmentManager().beginTransaction().remove(cardScanningFragment).commit();
        }
        CardScanningFragment cardScanningFragment2 = new CardScanningFragment();
        cardScanningFragment2.mCardForm = cardForm;
        appCompatActivity.getSupportFragmentManager().beginTransaction().add((Fragment) cardScanningFragment2, TAG).commit();
        return cardScanningFragment2;
    }

    public void setCardForm(CardForm cardForm) {
        this.mCardForm = cardForm;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resuming", false);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (bundle == null || !bundle.getBoolean("resuming")) {
            startActivityForResult(new Intent(getActivity(), CardIOActivity.class).putExtra("io.card.payment.hideLogo", true).putExtra("io.card.payment.intentSenderIsPayPal", false).putExtra("io.card.payment.suppressManual", true).putExtra("io.card.payment.suppressConfirmation", true).putExtra("io.card.payment.scanExpiry", true).putExtra("io.card.payment.requireCVV", false).putExtra("io.card.payment.requirePostalCode", false).putExtra("io.card.payment.guideColor", ColorUtils.getColor(getActivity(), "colorAccent", C1011R.C1012color.bt_blue)), CARD_IO_REQUEST_CODE);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == CARD_IO_REQUEST_CODE) {
            this.mCardForm.handleCardIOResponse(i2, intent);
            if (getActivity() != null) {
                getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
            }
        }
    }
}
