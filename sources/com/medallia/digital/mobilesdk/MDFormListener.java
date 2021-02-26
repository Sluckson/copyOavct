package com.medallia.digital.mobilesdk;

public interface MDFormListener {
    void onFormClosed(long j, String str, FormTriggerType formTriggerType);

    void onFormDismissed(long j, String str, FormTriggerType formTriggerType);

    void onFormDisplayed(long j, String str, FormTriggerType formTriggerType);

    void onFormExternalUrlBlocked(long j, String str, FormTriggerType formTriggerType, String str2);

    void onFormSubmitted(long j, String str, FormTriggerType formTriggerType);
}
