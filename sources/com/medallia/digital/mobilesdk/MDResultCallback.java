package com.medallia.digital.mobilesdk;

public interface MDResultCallback {
    void onError(MDExternalError mDExternalError);

    void onSuccess();
}
