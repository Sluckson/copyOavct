package com.iaai.android.bdt.extensions;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.p002pm.PackageInfoCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.base.DynamicLinkCallback;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.feature.utilsActivity.WebViewActivity;
import com.iaai.android.bdt.remoteconfig.FetchRemoteConfigCallback;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.activities.ContactUsActivity;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import com.lowagie.text.html.HtmlTags;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a2\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003\u001a\u0012\u0010\r\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\n\u001a\u00020\u000e\u001a\n\u0010\u000f\u001a\u00020\u0005*\u00020\u0006\u001a\n\u0010\u0010\u001a\u00020\u0011*\u00020\u0006\u001a\n\u0010\u0012\u001a\u00020\u0011*\u00020\u0006\u001a\n\u0010\u0013\u001a\u00020\u0011*\u00020\u0006\u001a\n\u0010\u0014\u001a\u00020\u0005*\u00020\u0006\u001a\n\u0010\u0015\u001a\u00020\u0011*\u00020\u0006\u001a\u0012\u0010\u0016\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006\u001a\u0012\u0010\u0018\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006\u001a\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003\u001a,\u0010\u001d\u001a\u0004\u0018\u00010\u001a*\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"\u001a\u001c\u0010#\u001a\u0004\u0018\u00010\u001a*\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"\u001a\u0014\u0010$\u001a\u0004\u0018\u00010\u001a*\u00020\u00062\u0006\u0010%\u001a\u00020&\u001a4\u0010'\u001a\u0004\u0018\u00010\u001a*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"\u001a\u0014\u0010)\u001a\u0004\u0018\u00010\u001a*\u00020\u00062\u0006\u0010*\u001a\u00020\u0011\u001a\u0016\u0010+\u001a\u0004\u0018\u00010\u001a*\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u001a\u0016\u0010,\u001a\u0004\u0018\u00010\u001a*\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u001a\"\u0010-\u001a\u00020\u0005*\u00020\u00062\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u000201¨\u00062"}, mo66933d2 = {"setTextHTML", "Landroid/text/Spanned;", "html", "", "createDynamicLinkForProduct", "", "Landroidx/appcompat/app/AppCompatActivity;", "itemId", "verbiage", "imageUrl", "callback", "Lcom/iaai/android/bdt/base/DynamicLinkCallback;", "tenant", "fetchRemoteConfigValue", "Lcom/iaai/android/bdt/remoteconfig/FetchRemoteConfigCallback;", "hideSoftKeyboard", "isDayOverForRefiner", "", "isHourOverForFacets", "isHourOverForRefiner", "isLatestAppInstalled", "isLoginExpire", "navigateToContactUsPage", "activity", "navigateToHelpPage", "showAlert", "Landroid/app/Dialog;", "title", "message", "showAlertWithButton", "btnPositiveText", "", "btnNagativeText", "onAlertButtonClick", "Lcom/iaai/android/bdt/extensions/OnAlertButtonClick;", "showAlertWithCallback", "showAlertWithCustomView", "view", "Landroid/view/View;", "showAlertWithTitle", "btnNegativeText", "showAppUpdateAlert", "isForceUpdate", "showToolTip", "showToolTipHtml", "vehicleImageUrl", "fromNetwork", "url", "imageView", "Landroid/widget/ImageView;", "app_productionRelease"}, mo66934k = 2, mo66935mv = {1, 1, 13})
/* compiled from: Activity+Extension.kt */
public final class Activity_ExtensionKt {
    public static final void vehicleImageUrl(@NotNull AppCompatActivity appCompatActivity, boolean z, @NotNull String str, @NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "url");
        Intrinsics.checkParameterIsNotNull(imageView, "imageView");
        RequestOptions placeholder = new RequestOptions().centerCrop().error((int) C2723R.C2725drawable.ic_image_na).diskCacheStrategy(DiskCacheStrategy.ALL).priority(Priority.HIGH).placeholder((int) C2723R.C2725drawable.progress_animation);
        if (z) {
            Glide.with((FragmentActivity) appCompatActivity).load(str).apply(placeholder).into(imageView);
        } else {
            Glide.with((FragmentActivity) appCompatActivity).load(Integer.valueOf(appCompatActivity.getResources().getIdentifier("ic_image_na", "drawable", appCompatActivity.getPackageName()))).apply(placeholder).into(imageView);
        }
    }

    @Nullable
    public static final Dialog showToolTip(@NotNull AppCompatActivity appCompatActivity, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(appCompatActivity);
            builder.setMessage((CharSequence) str).setCancelable(true).setPositiveButton(17039370, (DialogInterface.OnClickListener) Activity_ExtensionKt$showToolTip$1.INSTANCE);
            return builder.create();
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    public static final Dialog showToolTipHtml(@NotNull AppCompatActivity appCompatActivity, @Nullable String str) {
        Spanned spanned;
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        if (Build.VERSION.SDK_INT >= 24) {
            spanned = Html.fromHtml(str, 0);
            Intrinsics.checkExpressionValueIsNotNull(spanned, "Html.fromHtml(message, Html.FROM_HTML_MODE_LEGACY)");
        } else {
            spanned = Html.fromHtml(str);
            Intrinsics.checkExpressionValueIsNotNull(spanned, "Html.fromHtml(message)");
        }
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(appCompatActivity);
            builder.setMessage((CharSequence) spanned).setCancelable(true).setPositiveButton(17039370, (DialogInterface.OnClickListener) Activity_ExtensionKt$showToolTipHtml$1.INSTANCE);
            return builder.create();
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    public static final Dialog showAlertWithTitle(@NotNull AppCompatActivity appCompatActivity, @NotNull String str, @NotNull String str2, int i, int i2, @NotNull OnAlertButtonClick onAlertButtonClick) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(str2, "message");
        Intrinsics.checkParameterIsNotNull(onAlertButtonClick, "onAlertButtonClick");
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(appCompatActivity);
            builder.setMessage((CharSequence) str2).setCancelable(true).setTitle((CharSequence) str).setPositiveButton(i, (DialogInterface.OnClickListener) new Activity_ExtensionKt$showAlertWithTitle$1(onAlertButtonClick)).setNegativeButton(i2, (DialogInterface.OnClickListener) new Activity_ExtensionKt$showAlertWithTitle$2(onAlertButtonClick));
            return builder.create();
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    public static final Dialog showAlertWithButton(@NotNull AppCompatActivity appCompatActivity, int i, int i2, @NotNull String str, @NotNull OnAlertButtonClick onAlertButtonClick) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "message");
        Intrinsics.checkParameterIsNotNull(onAlertButtonClick, "onAlertButtonClick");
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(appCompatActivity);
            builder.setMessage((CharSequence) str).setCancelable(true).setPositiveButton(i, (DialogInterface.OnClickListener) new Activity_ExtensionKt$showAlertWithButton$1(onAlertButtonClick)).setNegativeButton(i2, (DialogInterface.OnClickListener) new Activity_ExtensionKt$showAlertWithButton$2(onAlertButtonClick));
            return builder.create();
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    public static final Dialog showAlert(@NotNull AppCompatActivity appCompatActivity, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(str2, "message");
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(appCompatActivity);
            builder.setTitle((CharSequence) str).setMessage((CharSequence) str2).setCancelable(true).setPositiveButton(17039370, (DialogInterface.OnClickListener) Activity_ExtensionKt$showAlert$1.INSTANCE);
            return builder.create();
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    public static final Dialog showAlertWithCallback(@NotNull AppCompatActivity appCompatActivity, @NotNull String str, @NotNull OnAlertButtonClick onAlertButtonClick) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "message");
        Intrinsics.checkParameterIsNotNull(onAlertButtonClick, "onAlertButtonClick");
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(appCompatActivity);
            builder.setMessage((CharSequence) str).setCancelable(true).setPositiveButton(17039370, (DialogInterface.OnClickListener) new Activity_ExtensionKt$showAlertWithCallback$1(onAlertButtonClick));
            return builder.create();
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    public static final Dialog showAlertWithCustomView(@NotNull AppCompatActivity appCompatActivity, @NotNull View view) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(view, "view");
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(appCompatActivity);
            builder.setView(view);
            return builder.create();
        } catch (Exception unused) {
            return null;
        }
    }

    public static final boolean isDayOverForRefiner(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        return (System.currentTimeMillis() - IAASharedPreference.getMakeModelMasterDataTimeStamp(appCompatActivity.getApplicationContext())) / ((long) 86400000) > 0;
    }

    public static final boolean isHourOverForRefiner(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        return (System.currentTimeMillis() - IAASharedPreference.getRefinerTimeStamp(appCompatActivity.getApplicationContext())) / ((long) 3600000) > 0;
    }

    public static final boolean isHourOverForFacets(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        return (System.currentTimeMillis() - IAASharedPreference.getNewFacetTimeStamp(appCompatActivity.getApplicationContext())) / ((long) 3600000) > 0;
    }

    public static final void createDynamicLinkForProduct(@NotNull AppCompatActivity appCompatActivity, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull DynamicLinkCallback dynamicLinkCallback, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_ITEM_ID);
        Intrinsics.checkParameterIsNotNull(str2, "verbiage");
        Intrinsics.checkParameterIsNotNull(str3, "imageUrl");
        Intrinsics.checkParameterIsNotNull(dynamicLinkCallback, "callback");
        Intrinsics.checkParameterIsNotNull(str4, "tenant");
        String string = appCompatActivity.getString(C2723R.string.ios_buyer_app_bundle_identifier);
        String string2 = appCompatActivity.getString(C2723R.string.web_link_url);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        boolean z = true;
        Object[] objArr = {string2 + "/VehicleDetails", str};
        String format = String.format("%s?itemid=%s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        if (Intrinsics.areEqual((Object) str4, (Object) "UK") || Intrinsics.areEqual((Object) str4, (Object) "CA")) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            Object[] objArr2 = {string2 + "/VehicleDetails", str, str4};
            format = String.format("%s?itemid=%s&tenant=%s", Arrays.copyOf(objArr2, objArr2.length));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        }
        Log.e("createDynamicLink:", "Complete URL: " + format);
        DynamicLink.Builder iosParameters = FirebaseDynamicLinks.getInstance().createDynamicLink().setLink(Uri.parse(format)).setDomainUriPrefix(appCompatActivity.getString(C2723R.string.dynamic_link_prefix_url)).setAndroidParameters(new DynamicLink.AndroidParameters.Builder(appCompatActivity.getPackageName()).build()).setIosParameters(new DynamicLink.IosParameters.Builder(string).setAppStoreId(appCompatActivity.getString(C2723R.string.ios_app_store_id)).build());
        if (str3.length() <= 0) {
            z = false;
        }
        if (z) {
            iosParameters.setSocialMetaTagParameters(new DynamicLink.SocialMetaTagParameters.Builder().setTitle("Vehicle Detail").setDescription(str2).setImageUrl(Uri.parse(str3)).build());
        } else {
            iosParameters.setSocialMetaTagParameters(new DynamicLink.SocialMetaTagParameters.Builder().setTitle("Vehicle Detail").setDescription(str2).build());
        }
        DynamicLink buildDynamicLink = iosParameters.buildDynamicLink();
        Intrinsics.checkExpressionValueIsNotNull(buildDynamicLink, "dynamicLink.buildDynamicLink()");
        Uri uri = buildDynamicLink.getUri();
        Log.e("createDynamicLink:", "Generated dynamic link: " + uri);
        iosParameters.buildShortDynamicLink().addOnSuccessListener(new Activity_ExtensionKt$createDynamicLinkForProduct$1(str2, dynamicLinkCallback)).addOnFailureListener(Activity_ExtensionKt$createDynamicLinkForProduct$2.INSTANCE);
    }

    public static final void fetchRemoteConfigValue(@NotNull AppCompatActivity appCompatActivity, @NotNull FetchRemoteConfigCallback fetchRemoteConfigCallback) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(fetchRemoteConfigCallback, "callback");
        IaaiApplication.getInstance().getmFirebaseRemoteConfig().fetchAndActivate().addOnCompleteListener((Activity) appCompatActivity, new Activity_ExtensionKt$fetchRemoteConfigValue$1(fetchRemoteConfigCallback));
    }

    public static final void hideSoftKeyboard(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        if (appCompatActivity.getCurrentFocus() != null) {
            Object systemService = appCompatActivity.getSystemService("input_method");
            if (systemService != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                View currentFocus = appCompatActivity.getCurrentFocus();
                if (currentFocus == null) {
                    Intrinsics.throwNpe();
                }
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    public static final void isLatestAppInstalled(@NotNull AppCompatActivity appCompatActivity) {
        Dialog showAppUpdateAlert;
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        IaaiApplication instance = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
        long googlePlayBuyerAppVersion = instance.getIAARemoteConfig().getGooglePlayBuyerAppVersion();
        long longVersionCode = PackageInfoCompat.getLongVersionCode(appCompatActivity.getPackageManager().getPackageInfo(appCompatActivity.getPackageName(), 0));
        IaaiApplication instance2 = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance2, "IaaiApplication.getInstance()");
        if (instance2.getIAARemoteConfig().getMinimumBuyerAppVersion() > longVersionCode) {
            Dialog showAppUpdateAlert2 = showAppUpdateAlert(appCompatActivity, true);
            if (showAppUpdateAlert2 != null) {
                showAppUpdateAlert2.show();
            }
        } else if (googlePlayBuyerAppVersion > longVersionCode && (showAppUpdateAlert = showAppUpdateAlert(appCompatActivity, false)) != null) {
            showAppUpdateAlert.show();
        }
    }

    public static final boolean isLoginExpire(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        IaaiApplication instance = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
        SessionManager sessionManager = instance.getComponent().sessionManager();
        if (sessionManager.isLoggedIn()) {
            return sessionManager.isLoginTimeout(appCompatActivity);
        }
        return false;
    }

    public static final void navigateToHelpPage(@NotNull AppCompatActivity appCompatActivity, @NotNull AppCompatActivity appCompatActivity2) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(appCompatActivity2, "activity");
        IaaiApplication instance = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
        if (instance.getIAARemoteConfig().getBorkerCommunityFlag()) {
            String string = appCompatActivity.getString(C2723R.string.url_broker_community_menu_help, new Object[]{Constants_MVVM.EXTRA_ENGLISH_CODE});
            if (Intrinsics.areEqual((Object) Utils.getLanguage(), (Object) Constants_MVVM.EXTRA_SPANISH_CODE)) {
                string = appCompatActivity.getString(C2723R.string.url_broker_community_menu_help, new Object[]{Constants_MVVM.EXTRA_SPANISH_CODE});
            }
            appCompatActivity.setIntent(new Intent(appCompatActivity2, WebViewActivity.class));
            appCompatActivity.getIntent().putExtra(Constants_MVVM.EXTRA_BROKER_HELP_LINK_URL, appCompatActivity.getString(C2723R.string.base_broker_community_url) + string);
            appCompatActivity.getIntent().putExtra(Constants_MVVM.EXTRA_BROKER_TITLE, appCompatActivity2.getResources().getString(C2723R.string.lbl_menu_help));
            appCompatActivity.startActivity(appCompatActivity.getIntent());
            return;
        }
        appCompatActivity.setIntent(new Intent(appCompatActivity2, WebViewActivity.class));
        appCompatActivity.getIntent().putExtra(Constants_MVVM.EXTRA_BROKER_HELP_LINK_URL, "https://levbox-iaa.cs7.force.com/BrokerCommunity/s/i-need-a-broker?BrokerId=001M000001ClIFV&language=en_US");
        appCompatActivity.getIntent().putExtra(Constants_MVVM.EXTRA_BROKER_TITLE, appCompatActivity2.getResources().getString(C2723R.string.lbl_menu_help));
        appCompatActivity.startActivity(appCompatActivity.getIntent());
    }

    public static final void navigateToContactUsPage(@NotNull AppCompatActivity appCompatActivity, @NotNull AppCompatActivity appCompatActivity2) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        Intrinsics.checkParameterIsNotNull(appCompatActivity2, "activity");
        IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_contact_us;
        IaaiApplication instance = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
        if (instance.getIAARemoteConfig().getBorkerCommunityFlag()) {
            String string = appCompatActivity.getString(C2723R.string.url_broker_community_contact_us, new Object[]{Constants_MVVM.EXTRA_ENGLISH_CODE});
            if (Intrinsics.areEqual((Object) Utils.getLanguage(), (Object) Constants_MVVM.EXTRA_SPANISH_CODE)) {
                string = appCompatActivity.getString(C2723R.string.url_broker_community_contact_us, new Object[]{Constants_MVVM.EXTRA_SPANISH_CODE});
            }
            appCompatActivity.setIntent(new Intent(appCompatActivity2, WebViewActivity.class));
            appCompatActivity.getIntent().putExtra(Constants_MVVM.EXTRA_BROKER_HELP_LINK_URL, appCompatActivity.getString(C2723R.string.base_broker_community_url) + string);
            appCompatActivity.getIntent().putExtra(Constants_MVVM.EXTRA_BROKER_TITLE, appCompatActivity2.getResources().getString(C2723R.string.lbl_bdt_contact_us));
            appCompatActivity.startActivity(appCompatActivity.getIntent());
            return;
        }
        ((DrawerLayout) appCompatActivity.findViewById(C2723R.C2726id.nav_drawer)).closeDrawer((int) GravityCompat.START);
        appCompatActivity.setIntent(new Intent(appCompatActivity2, ContactUsActivity.class));
        appCompatActivity.startActivity(appCompatActivity.getIntent());
    }

    @Nullable
    public static final Dialog showAppUpdateAlert(@NotNull AppCompatActivity appCompatActivity, boolean z) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "receiver$0");
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(appCompatActivity);
            builder.setMessage((CharSequence) appCompatActivity.getResources().getString(C2723R.string.lbl_app_update_message)).setCancelable(false).setTitle((CharSequence) appCompatActivity.getResources().getString(C2723R.string.title_update_alert)).setPositiveButton((int) C2723R.string.positive_button_text, (DialogInterface.OnClickListener) new Activity_ExtensionKt$showAppUpdateAlert$1(appCompatActivity));
            if (!z) {
                builder.setNegativeButton((CharSequence) appCompatActivity.getResources().getString(C2723R.string.lbl_bdt_cancel), (DialogInterface.OnClickListener) Activity_ExtensionKt$showAppUpdateAlert$2.INSTANCE);
            }
            return builder.create();
        } catch (Exception unused) {
            return null;
        }
    }

    @NotNull
    public static final Spanned setTextHTML(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, HtmlTags.HTML);
        if (Build.VERSION.SDK_INT >= 24) {
            Spanned fromHtml = Html.fromHtml(str, 0);
            Intrinsics.checkExpressionValueIsNotNull(fromHtml, "Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)");
            return fromHtml;
        }
        Spanned fromHtml2 = Html.fromHtml(str);
        Intrinsics.checkExpressionValueIsNotNull(fromHtml2, "Html.fromHtml(html)");
        return fromHtml2;
    }
}
