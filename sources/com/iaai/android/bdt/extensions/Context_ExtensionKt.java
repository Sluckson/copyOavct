package com.iaai.android.bdt.extensions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.onBoarding.OnBoardingActivity;
import com.iaai.android.bdt.feature.onBoarding.OnBoardingEnum;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.NewDateHelper;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003\u001a\f\u0010\t\u001a\u00020\n*\u00020\u0004H\u0007\u001a\u0012\u0010\u000b\u001a\u00020\f*\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\u000f\u001a\u00020\f*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0012\u0010\u0012\u001a\u00020\f*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0013"}, mo66933d2 = {"getDueDateInfo", "Lkotlin/Pair;", "", "", "Landroid/content/Context;", "date", "getLatLng", "Lcom/google/android/gms/maps/model/LatLng;", "zipCode", "getLatLngFromLocation", "Landroid/location/Location;", "launchOnBoardingScreen", "", "mode", "Lcom/iaai/android/bdt/feature/onBoarding/OnBoardingEnum;", "showToast", "text", "", "showToastLong", "app_productionRelease"}, mo66934k = 2, mo66935mv = {1, 1, 13})
/* compiled from: Context+Extension.kt */
public final class Context_ExtensionKt {
    public static final void showToast(@NotNull Context context, @NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        Toast.makeText(context, charSequence, 0).show();
    }

    public static final void showToastLong(@NotNull Context context, @NotNull CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "text");
        Toast.makeText(context, charSequence, 1).show();
    }

    @Nullable
    public static final LatLng getLatLng(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "zipCode");
        try {
            List<Address> fromLocationName = new Geocoder(context).getFromLocationName(str, 1);
            if (fromLocationName.size() <= 0) {
                return new LatLng(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            }
            StringBuilder sb = new StringBuilder();
            Address address = fromLocationName.get(0);
            Intrinsics.checkExpressionValueIsNotNull(address, "addresses[0]");
            sb.append(address.getLatitude());
            sb.append(' ');
            Address address2 = fromLocationName.get(0);
            Intrinsics.checkExpressionValueIsNotNull(address2, "addresses[0]");
            sb.append(address2.getLongitude());
            Log.d("CONTEXT EXTENSION", sb.toString());
            Address address3 = fromLocationName.get(0);
            Intrinsics.checkExpressionValueIsNotNull(address3, "addresses[0]");
            double latitude = address3.getLatitude();
            Address address4 = fromLocationName.get(0);
            Intrinsics.checkExpressionValueIsNotNull(address4, "addresses[0]");
            return new LatLng(latitude, address4.getLongitude());
        } catch (Exception e) {
            e.printStackTrace();
            return new LatLng(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
    }

    @NotNull
    @SuppressLint({"MissingPermission"})
    public static final Location getLatLngFromLocation(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager == null) {
            Intrinsics.throwNpe();
        }
        Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
        Intrinsics.checkExpressionValueIsNotNull(lastKnownLocation, "locationManager!!.getLas…tionManager.GPS_PROVIDER)");
        return lastKnownLocation;
    }

    public static final void launchOnBoardingScreen(@NotNull Context context, @NotNull OnBoardingEnum onBoardingEnum) {
        Intrinsics.checkParameterIsNotNull(context, "receiver$0");
        Intrinsics.checkParameterIsNotNull(onBoardingEnum, Constants.EXTRA_MODE);
        switch (onBoardingEnum) {
            case PRODUCT_DETAIL:
                IAASharedPreference.setIsFirstLaunchForProductDetail(context, false);
                break;
            case FIND_VEHICLES:
                IAASharedPreference.setIsFirstLaunchFindVehicles(context, false);
                break;
            case ENGINE_VIDEO_ONLY:
                IAASharedPreference.setIsFirstLaunchForEngineVideoProductDetail(context, false);
                break;
            case ENGINE_VIDEO_WITH_ALL_SCREEN:
                IAASharedPreference.setIsFirstLaunchForEngineVideoProductDetail(context, false);
                IAASharedPreference.setIsFirstLaunchForProductDetail(context, false);
                break;
            case MANAGE_OFFER_HOME:
                IAASharedPreference.setIsFirstLaunchForManageofferHome(context, false);
                break;
            case MANAGE_OFFER_MYACCOUNT:
                IAASharedPreference.setIsFirstLaunchForManageofferMyAccount(context, false);
                break;
            case PAYMENT_METHOD_PAYPAL:
                IAASharedPreference.setIsFirstLaunchForPaymentMethodPayPal(context, false);
                break;
            case FAST_SEARCH:
                IAASharedPreference.setIsFirstLaunchForFastSearch(context, false);
                break;
        }
        Intent intent = new Intent(context, OnBoardingActivity.class);
        intent.putExtra(Constants_MVVM.ON_BOARDING_ENUM_VALUE, onBoardingEnum);
        context.startActivity(intent);
    }

    @NotNull
    public static final Pair<Boolean, String> getDueDateInfo(@NotNull Context context, @NotNull String str) {
        boolean z;
        boolean z2;
        String sb;
        String str2;
        Context context2 = context;
        String str3 = str;
        Intrinsics.checkParameterIsNotNull(context2, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str3, Constants.EXTRA_DATE);
        String str4 = "";
        try {
            Date parse = new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIMEZONE, Locale.US).parse(str3);
            Date resetTodayDateTimeToMidNight = AppUtils.resetTodayDateTimeToMidNight();
            if (parse.compareTo(resetTodayDateTimeToMidNight) > 0) {
                Intrinsics.checkExpressionValueIsNotNull(parse, "date1");
                long time = parse.getTime();
                Intrinsics.checkExpressionValueIsNotNull(resetTodayDateTimeToMidNight, "date2");
                long time2 = (time - resetTodayDateTimeToMidNight.getTime()) / ((long) 86400000);
                if (time2 == 0) {
                    z = false;
                    StringBuilder sb2 = new StringBuilder();
                    String string = context2.getString(C2723R.string.lbl_srt_due);
                    Intrinsics.checkExpressionValueIsNotNull(string, "this.getString(R.string.lbl_srt_due)");
                    CharSequence charSequence = string;
                    int length = charSequence.length() - 1;
                    int i = 0;
                    boolean z3 = false;
                    while (true) {
                        if (i > length) {
                            break;
                        }
                        boolean z4 = charSequence.charAt(!z3 ? i : length) <= ' ';
                        if (!z3) {
                            if (!z4) {
                                z3 = true;
                            } else {
                                i++;
                            }
                        } else if (!z4) {
                            break;
                        } else {
                            length--;
                        }
                    }
                    sb2.append(charSequence.subSequence(i, length + 1).toString());
                    sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    sb2.append(context2.getString(C2723R.string.lbl_today));
                    str2 = sb2.toString();
                } else if (time2 == 1) {
                    try {
                        StringBuilder sb3 = new StringBuilder();
                        String string2 = context2.getString(C2723R.string.lbl_srt_due);
                        Intrinsics.checkExpressionValueIsNotNull(string2, "this.getString(R.string.lbl_srt_due)");
                        CharSequence charSequence2 = string2;
                        int length2 = charSequence2.length() - 1;
                        int i2 = 0;
                        boolean z5 = false;
                        while (true) {
                            if (i2 > length2) {
                                break;
                            }
                            boolean z6 = charSequence2.charAt(!z5 ? i2 : length2) <= ' ';
                            if (!z5) {
                                if (!z6) {
                                    z5 = true;
                                } else {
                                    i2++;
                                }
                            } else if (!z6) {
                                break;
                            } else {
                                length2--;
                            }
                        }
                        sb3.append(charSequence2.subSequence(i2, length2 + 1).toString());
                        sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        sb3.append(context2.getString(C2723R.string.lbl_tomorrow));
                        str4 = sb3.toString();
                        z = false;
                    } catch (Exception e) {
                        e = e;
                        z2 = false;
                        e.printStackTrace();
                        z = z2;
                        return new Pair<>(Boolean.valueOf(z), str4);
                    }
                    return new Pair<>(Boolean.valueOf(z), str4);
                } else {
                    List split$default = StringsKt.split$default((CharSequence) NewDateHelper.INSTANCE.getPaymentDueDate(str3), new String[]{MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR}, false, 0, 6, (Object) null);
                    StringBuilder sb4 = new StringBuilder();
                    String string3 = context2.getString(C2723R.string.lbl_srt_due);
                    Intrinsics.checkExpressionValueIsNotNull(string3, "this.getString(R.string.lbl_srt_due)");
                    CharSequence charSequence3 = string3;
                    int length3 = charSequence3.length() - 1;
                    int i3 = 0;
                    boolean z7 = false;
                    while (i3 <= length3) {
                        boolean z8 = charSequence3.charAt(!z7 ? i3 : length3) <= ' ';
                        if (!z7) {
                            if (!z8) {
                                z7 = true;
                            } else {
                                i3++;
                            }
                        } else if (!z8) {
                            break;
                        } else {
                            length3--;
                        }
                    }
                    sb4.append(charSequence3.subSequence(i3, length3 + 1).toString());
                    sb4.append(' ');
                    z = false;
                    sb4.append((String) split$default.get(0));
                    sb4.append(' ');
                    sb4.append(NewDateHelper.INSTANCE.ordinal(Integer.parseInt((String) split$default.get(1))));
                    str2 = sb4.toString();
                }
                str4 = str2;
                return new Pair<>(Boolean.valueOf(z), str4);
            }
            z = false;
            if (parse.compareTo(resetTodayDateTimeToMidNight) < 0) {
                try {
                    Intrinsics.checkExpressionValueIsNotNull(resetTodayDateTimeToMidNight, "date2");
                    long time3 = resetTodayDateTimeToMidNight.getTime();
                    Intrinsics.checkExpressionValueIsNotNull(parse, "date1");
                    long time4 = (time3 - parse.getTime()) / ((long) 86400000);
                    if (time4 == 0) {
                        StringBuilder sb5 = new StringBuilder();
                        String string4 = context2.getString(C2723R.string.lbl_srt_due);
                        Intrinsics.checkExpressionValueIsNotNull(string4, "this.getString(R.string.lbl_srt_due)");
                        CharSequence charSequence4 = string4;
                        int length4 = charSequence4.length() - 1;
                        int i4 = 0;
                        boolean z9 = false;
                        while (true) {
                            if (i4 > length4) {
                                break;
                            }
                            boolean z10 = charSequence4.charAt(!z9 ? i4 : length4) <= ' ';
                            if (!z9) {
                                if (!z10) {
                                    z9 = true;
                                } else {
                                    i4++;
                                }
                            } else if (!z10) {
                                break;
                            } else {
                                length4--;
                            }
                        }
                        sb5.append(charSequence4.subSequence(i4, length4 + 1).toString());
                        sb5.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        sb5.append(context2.getString(C2723R.string.lbl_today));
                        sb = sb5.toString();
                    } else if (time4 == 1) {
                        StringBuilder sb6 = new StringBuilder();
                        String string5 = context2.getString(C2723R.string.lbl_srt_due);
                        Intrinsics.checkExpressionValueIsNotNull(string5, "this.getString(R.string.lbl_srt_due)");
                        CharSequence charSequence5 = string5;
                        int length5 = charSequence5.length() - 1;
                        int i5 = 0;
                        boolean z11 = false;
                        while (true) {
                            if (i5 > length5) {
                                break;
                            }
                            boolean z12 = charSequence5.charAt(!z11 ? i5 : length5) <= ' ';
                            if (!z11) {
                                if (!z12) {
                                    z11 = true;
                                } else {
                                    i5++;
                                }
                            } else if (!z12) {
                                break;
                            } else {
                                length5--;
                            }
                        }
                        sb6.append(charSequence5.subSequence(i5, length5 + 1).toString());
                        sb6.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        sb6.append(context2.getString(C2723R.string.lbl_yesterday));
                        sb = sb6.toString();
                    } else {
                        sb = context2.getString(C2723R.string.tobe_pickedup_passdue) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + time4 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + context2.getString(C2723R.string.tobe_pickedup_days);
                    }
                    str4 = sb;
                    z = true;
                } catch (Exception e2) {
                    e = e2;
                    z2 = true;
                    e.printStackTrace();
                    z = z2;
                    return new Pair<>(Boolean.valueOf(z), str4);
                }
            } else if (parse.compareTo(resetTodayDateTimeToMidNight) == 0) {
                StringBuilder sb7 = new StringBuilder();
                String string6 = context2.getString(C2723R.string.lbl_srt_due);
                Intrinsics.checkExpressionValueIsNotNull(string6, "this.getString(R.string.lbl_srt_due)");
                CharSequence charSequence6 = string6;
                int length6 = charSequence6.length() - 1;
                int i6 = 0;
                boolean z13 = false;
                while (true) {
                    if (i6 > length6) {
                        break;
                    }
                    boolean z14 = charSequence6.charAt(!z13 ? i6 : length6) <= ' ';
                    if (!z13) {
                        if (!z14) {
                            z13 = true;
                        } else {
                            i6++;
                        }
                    } else if (!z14) {
                        break;
                    } else {
                        length6--;
                    }
                }
                sb7.append(charSequence6.subSequence(i6, length6 + 1).toString());
                sb7.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                sb7.append(context2.getString(C2723R.string.lbl_today));
                str4 = sb7.toString();
            }
            return new Pair<>(Boolean.valueOf(z), str4);
        } catch (Exception e3) {
            e = e3;
            z2 = false;
            e.printStackTrace();
            z = z2;
            return new Pair<>(Boolean.valueOf(z), str4);
        }
    }
}
