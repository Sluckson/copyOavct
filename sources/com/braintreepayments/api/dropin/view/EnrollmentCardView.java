package com.braintreepayments.api.dropin.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.braintreepayments.api.dropin.C0944R;
import com.braintreepayments.api.dropin.interfaces.AddPaymentUpdateListener;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import com.braintreepayments.cardform.utils.ViewUtils;
import com.braintreepayments.cardform.view.ErrorEditText;

public class EnrollmentCardView extends LinearLayout implements View.OnClickListener, TextView.OnEditorActionListener {
    private AnimatedButtonView mAnimatedButtonView;
    private boolean mEnrollmentFailed;
    private AddPaymentUpdateListener mListener;
    private ErrorEditText mSmsCode;
    private Button mSmsHelpButton;
    private TextView mSmsSentTextView;

    public EnrollmentCardView(Context context) {
        super(context);
        init();
    }

    public EnrollmentCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public EnrollmentCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    @TargetApi(21)
    public EnrollmentCardView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            setOrientation(1);
            LayoutInflater.from(getContext()).inflate(C0944R.C0949layout.bt_enrollment_card, this, true);
            this.mSmsCode = (ErrorEditText) findViewById(C0944R.C0947id.bt_sms_code);
            this.mSmsCode.setImeOptions(2);
            this.mSmsCode.setImeActionLabel(getContext().getString(C0944R.string.bt_confirm), 2);
            this.mSmsCode.setOnEditorActionListener(this);
            this.mSmsSentTextView = (TextView) findViewById(C0944R.C0947id.bt_sms_sent_text);
            this.mSmsHelpButton = (Button) findViewById(C0944R.C0947id.bt_sms_help_button);
            this.mAnimatedButtonView = (AnimatedButtonView) findViewById(C0944R.C0947id.bt_animated_button_view);
            this.mAnimatedButtonView.setClickListener(this);
            this.mSmsHelpButton.setOnClickListener(this);
        }
    }

    public void setup(AppCompatActivity appCompatActivity) {
        ((ImageView) findViewById(C0944R.C0947id.bt_sms_code_icon)).setImageResource(ViewUtils.isDarkBackground(appCompatActivity) ? C0944R.C0946drawable.bt_ic_sms_code_dark : C0944R.C0946drawable.bt_ic_sms_code);
    }

    public void setAddPaymentUpdatedListener(AddPaymentUpdateListener addPaymentUpdateListener) {
        this.mListener = addPaymentUpdateListener;
    }

    public void setPhoneNumber(String str) {
        this.mSmsSentTextView.setText(getContext().getString(C0944R.string.bt_sms_code_sent_to, new Object[]{str}));
    }

    public String getSmsCode() {
        return this.mSmsCode.getText().toString();
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        this.mAnimatedButtonView.showLoading();
        onClick(this.mAnimatedButtonView);
        return true;
    }

    public boolean hasFailedEnrollment() {
        return this.mEnrollmentFailed;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r2 = r2.errorFor("unionPayEnrollment");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isEnrollmentError(com.braintreepayments.api.exceptions.ErrorWithResponse r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0014
            java.lang.String r0 = "unionPayEnrollment"
            com.braintreepayments.api.exceptions.BraintreeError r2 = r2.errorFor(r0)
            if (r2 == 0) goto L_0x0014
            java.lang.String r0 = "base"
            com.braintreepayments.api.exceptions.BraintreeError r2 = r2.errorFor(r0)
            if (r2 == 0) goto L_0x0014
            r2 = 1
            return r2
        L_0x0014:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.dropin.view.EnrollmentCardView.isEnrollmentError(com.braintreepayments.api.exceptions.ErrorWithResponse):boolean");
    }

    public void setErrors(ErrorWithResponse errorWithResponse) {
        if (errorWithResponse.errorFor("unionPayEnrollment") != null) {
            this.mSmsCode.setError(getContext().getString(C0944R.string.bt_unionpay_sms_code_invalid));
            this.mEnrollmentFailed = true;
        }
        this.mAnimatedButtonView.showButton();
    }

    public void onClick(View view) {
        if (view != this.mAnimatedButtonView || !TextUtils.isEmpty(this.mSmsCode.getText())) {
            AddPaymentUpdateListener addPaymentUpdateListener = this.mListener;
            if (addPaymentUpdateListener != null) {
                if (view == this.mAnimatedButtonView) {
                    addPaymentUpdateListener.onPaymentUpdated(this);
                } else if (view == this.mSmsHelpButton) {
                    addPaymentUpdateListener.onBackRequested(this);
                }
            }
        } else {
            this.mAnimatedButtonView.showButton();
            this.mSmsCode.setError(getContext().getString(C0944R.string.bt_sms_code_required));
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        this.mAnimatedButtonView.showButton();
        this.mEnrollmentFailed = false;
        if (i == 0) {
            this.mSmsCode.requestFocus();
        }
    }
}
