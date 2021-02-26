package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class LayoutSortLocationZipBinding extends ViewDataBinding {
    @NonNull
    public final Button btnZipApply;
    @NonNull
    public final EditText enterZipCode;
    @NonNull
    public final LinearLayout llApplyZip;
    @NonNull
    public final TextView locationSort;
    @NonNull
    public final RelativeLayout rlZipCodeMain;
    @NonNull
    public final TextView tvEditZip;
    @NonNull
    public final TextView tvSortZip;
    @NonNull
    public final TextView tvZipCodeLabel;
    @NonNull
    public final View viewEditZipDivider;

    protected LayoutSortLocationZipBinding(Object obj, View view, int i, Button button, EditText editText, LinearLayout linearLayout, TextView textView, RelativeLayout relativeLayout, TextView textView2, TextView textView3, TextView textView4, View view2) {
        super(obj, view, i);
        this.btnZipApply = button;
        this.enterZipCode = editText;
        this.llApplyZip = linearLayout;
        this.locationSort = textView;
        this.rlZipCodeMain = relativeLayout;
        this.tvEditZip = textView2;
        this.tvSortZip = textView3;
        this.tvZipCodeLabel = textView4;
        this.viewEditZipDivider = view2;
    }

    @NonNull
    public static LayoutSortLocationZipBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutSortLocationZipBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LayoutSortLocationZipBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.layout_sort_location_zip, viewGroup, z, obj);
    }

    @NonNull
    public static LayoutSortLocationZipBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutSortLocationZipBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LayoutSortLocationZipBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.layout_sort_location_zip, (ViewGroup) null, false, obj);
    }

    public static LayoutSortLocationZipBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutSortLocationZipBinding bind(@NonNull View view, @Nullable Object obj) {
        return (LayoutSortLocationZipBinding) bind(obj, view, C2723R.C2728layout.layout_sort_location_zip);
    }
}
