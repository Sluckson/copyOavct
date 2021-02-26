package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class AcivityAccountSettingListBinding extends ViewDataBinding {
    @NonNull
    public final View additionalBidder;
    @NonNull
    public final LinearLayout frameLayout;
    @NonNull
    public final ImageView ivAdditionalBidder;
    @NonNull
    public final ImageView ivContact;
    @NonNull
    public final ImageView ivHelp;
    @NonNull
    public final ImageView ivLicenseDoc;
    @NonNull
    public final ImageView ivMySubscriptions;
    @NonNull
    public final ImageView ivRenewal;
    @NonNull
    public final ImageView ivSettting;
    @NonNull
    public final ImageView ivUpgradeAccount;
    @NonNull
    public final View licenseAndDocumentView;
    @NonNull
    public final View mySubscriptionsView;
    @NonNull
    public final ImageView profile;
    @NonNull
    public final View profileView;
    @NonNull
    public final View renewalView;
    @NonNull
    public final RelativeLayout rlAdditionalBidder;
    @NonNull
    public final RelativeLayout rlContactUs;
    @NonNull
    public final LinearLayout rlFeedback;
    @NonNull
    public final RelativeLayout rlHelp;
    @NonNull
    public final RelativeLayout rlLicenseDocument;
    @NonNull
    public final RelativeLayout rlMySubscriptions;
    @NonNull
    public final RelativeLayout rlProfile;
    @NonNull
    public final RelativeLayout rlRenewal;
    @NonNull
    public final RelativeLayout rlSetting;
    @NonNull
    public final RelativeLayout rlUpgradeAccount;
    @NonNull
    public final NestedScrollView svDataContainer;
    @NonNull
    public final TextView tvLable;
    @NonNull
    public final View upgradeAccountView;
    @NonNull
    public final View viewHelpLineSeparator;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected AcivityAccountSettingListBinding(Object obj, View view, int i, View view2, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, View view3, View view4, ImageView imageView9, View view5, View view6, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, LinearLayout linearLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9, NestedScrollView nestedScrollView, TextView textView, View view7, View view8) {
        super(obj, view, i);
        this.additionalBidder = view2;
        this.frameLayout = linearLayout;
        this.ivAdditionalBidder = imageView;
        this.ivContact = imageView2;
        this.ivHelp = imageView3;
        this.ivLicenseDoc = imageView4;
        this.ivMySubscriptions = imageView5;
        this.ivRenewal = imageView6;
        this.ivSettting = imageView7;
        this.ivUpgradeAccount = imageView8;
        this.licenseAndDocumentView = view3;
        this.mySubscriptionsView = view4;
        this.profile = imageView9;
        this.profileView = view5;
        this.renewalView = view6;
        this.rlAdditionalBidder = relativeLayout;
        this.rlContactUs = relativeLayout2;
        this.rlFeedback = linearLayout2;
        this.rlHelp = relativeLayout3;
        this.rlLicenseDocument = relativeLayout4;
        this.rlMySubscriptions = relativeLayout5;
        this.rlProfile = relativeLayout6;
        this.rlRenewal = relativeLayout7;
        this.rlSetting = relativeLayout8;
        this.rlUpgradeAccount = relativeLayout9;
        this.svDataContainer = nestedScrollView;
        this.tvLable = textView;
        this.upgradeAccountView = view7;
        this.viewHelpLineSeparator = view8;
    }

    @NonNull
    public static AcivityAccountSettingListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcivityAccountSettingListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AcivityAccountSettingListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.acivity_account_setting_list, viewGroup, z, obj);
    }

    @NonNull
    public static AcivityAccountSettingListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcivityAccountSettingListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AcivityAccountSettingListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.acivity_account_setting_list, (ViewGroup) null, false, obj);
    }

    public static AcivityAccountSettingListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AcivityAccountSettingListBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AcivityAccountSettingListBinding) bind(obj, view, C2723R.C2728layout.acivity_account_setting_list);
    }
}
