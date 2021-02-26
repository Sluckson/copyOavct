package com.medallia.digital.mobilesdk;

/* renamed from: com.medallia.digital.mobilesdk.e2 */
public class C3489e2 extends MDFormListenerV2 {

    /* renamed from: a */
    private MDFormListener f1032a;

    C3489e2(MDFormListener mDFormListener) {
        this.f1032a = mDFormListener;
    }

    /* renamed from: a */
    public MDFormListenerV2 mo55332a() {
        return this;
    }

    public void onFormClosed(long j, String str, FormTriggerType formTriggerType) {
        MDFormListener mDFormListener = this.f1032a;
        if (mDFormListener != null) {
            mDFormListener.onFormClosed(j, str, formTriggerType);
        }
    }

    public void onFormDismissed(long j, String str, FormTriggerType formTriggerType) {
        MDFormListener mDFormListener = this.f1032a;
        if (mDFormListener != null) {
            mDFormListener.onFormDismissed(j, str, formTriggerType);
        }
    }

    public void onFormDisplayed(long j, String str, FormTriggerType formTriggerType) {
        MDFormListener mDFormListener = this.f1032a;
        if (mDFormListener != null) {
            mDFormListener.onFormDisplayed(j, str, formTriggerType);
        }
    }

    public void onFormLinkSelected(long j, String str, FormTriggerType formTriggerType, String str2, boolean z) {
        MDFormListener mDFormListener;
        if (z && (mDFormListener = this.f1032a) != null) {
            mDFormListener.onFormExternalUrlBlocked(j, str, formTriggerType, str2);
        }
    }

    public void onFormSubmitted(long j, String str, FormTriggerType formTriggerType) {
        MDFormListener mDFormListener = this.f1032a;
        if (mDFormListener != null) {
            mDFormListener.onFormSubmitted(j, str, formTriggerType);
        }
    }
}
