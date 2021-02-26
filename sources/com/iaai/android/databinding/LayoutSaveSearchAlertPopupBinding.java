package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class LayoutSaveSearchAlertPopupBinding extends ViewDataBinding {
    @NonNull
    public final TextView tvOK;
    @NonNull
    public final TextView tvRegister;

    protected LayoutSaveSearchAlertPopupBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.tvOK = textView;
        this.tvRegister = textView2;
    }

    @NonNull
    public static LayoutSaveSearchAlertPopupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutSaveSearchAlertPopupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LayoutSaveSearchAlertPopupBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.layout_save_search_alert_popup, viewGroup, z, obj);
    }

    @NonNull
    public static LayoutSaveSearchAlertPopupBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutSaveSearchAlertPopupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LayoutSaveSearchAlertPopupBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.layout_save_search_alert_popup, (ViewGroup) null, false, obj);
    }

    public static LayoutSaveSearchAlertPopupBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutSaveSearchAlertPopupBinding bind(@NonNull View view, @Nullable Object obj) {
        return (LayoutSaveSearchAlertPopupBinding) bind(obj, view, C2723R.C2728layout.layout_save_search_alert_popup);
    }
}
