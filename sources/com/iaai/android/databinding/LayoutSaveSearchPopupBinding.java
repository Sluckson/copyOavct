package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputLayout;
import com.iaai.android.C2723R;

public abstract class LayoutSaveSearchPopupBinding extends ViewDataBinding {
    @NonNull
    public final EditText etSaveSearch;
    @NonNull
    public final TextView tvCancel;
    @NonNull
    public final TextView tvSave;
    @NonNull
    public final TextInputLayout txtSaveSearchLayout;

    protected LayoutSaveSearchPopupBinding(Object obj, View view, int i, EditText editText, TextView textView, TextView textView2, TextInputLayout textInputLayout) {
        super(obj, view, i);
        this.etSaveSearch = editText;
        this.tvCancel = textView;
        this.tvSave = textView2;
        this.txtSaveSearchLayout = textInputLayout;
    }

    @NonNull
    public static LayoutSaveSearchPopupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutSaveSearchPopupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LayoutSaveSearchPopupBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.layout_save_search_popup, viewGroup, z, obj);
    }

    @NonNull
    public static LayoutSaveSearchPopupBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutSaveSearchPopupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LayoutSaveSearchPopupBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.layout_save_search_popup, (ViewGroup) null, false, obj);
    }

    public static LayoutSaveSearchPopupBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutSaveSearchPopupBinding bind(@NonNull View view, @Nullable Object obj) {
        return (LayoutSaveSearchPopupBinding) bind(obj, view, C2723R.C2728layout.layout_save_search_popup);
    }
}
