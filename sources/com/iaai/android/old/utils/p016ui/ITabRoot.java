package com.iaai.android.old.utils.p016ui;

import android.content.Context;
import android.content.Intent;

/* renamed from: com.iaai.android.old.utils.ui.ITabRoot */
public interface ITabRoot {
    Context getContext();

    void startChildActivity(String str, Intent intent);
}
