package com.iaai.android.old.utils.p016ui;

import android.app.Dialog;
import android.content.Context;

/* renamed from: com.iaai.android.old.utils.ui.IDialogContainer */
public interface IDialogContainer {
    Context getContext();

    Dialog getDialog();

    boolean isDialogHandled();

    void setDialog(Dialog dialog);
}
