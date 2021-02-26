package com.iaai.android.bdt.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.google.android.exoplayer2.C1119C;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\t\u0018\u00002\u00020\u0001:\u00017B-\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\fB'\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\rJ\b\u0010\u001f\u001a\u00020\u0016H\u0002J\u001b\u0010 \u001a\u00020\u00122\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010!J)\u0010\"\u001a\u00020\u00162!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0011J!\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0002\u0010%J\u0019\u0010&\u001a\u0004\u0018\u0001H'\"\b\b\u0000\u0010'*\u00020(H\u0002¢\u0006\u0002\u0010)J\u0006\u0010*\u001a\u00020\u0012J\u0010\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\bH\u0002J)\u0010-\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010.\u001a\u00020/¢\u0006\u0002\u00100J\u0006\u00101\u001a\u00020\u0016J\u0010\u00102\u001a\u00020\u00162\b\u00103\u001a\u0004\u0018\u00010\u0018J\u0014\u00104\u001a\u00020\u00162\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00160\u001bJ/\u00105\u001a\u00020\u00162'\u0010#\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00160\u0011J\u001b\u00106\u001a\u00020\u00122\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0002\u0010!R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\u0019R\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u001bX\u000e¢\u0006\u0002\n\u0000R1\u0010\u001c\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u00068"}, mo66933d2 = {"Lcom/iaai/android/bdt/base/PermissionHelper;", "", "activity", "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "permissions", "", "", "requestCode", "", "(Landroid/app/Activity;Landroidx/fragment/app/Fragment;[Ljava/lang/String;I)V", "(Landroid/app/Activity;[Ljava/lang/String;I)V", "(Landroidx/fragment/app/Fragment;[Ljava/lang/String;I)V", "REQUEST_CODE", "TAG", "deniedCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSystem", "", "mPermissionCallback", "Lcom/iaai/android/bdt/base/PermissionHelper$PermissionCallback;", "[Ljava/lang/String;", "requestAllCallback", "Lkotlin/Function0;", "requestIndividualCallback", "grantedPermission", "showRational", "checkIfPermissionPresentInAndroidManifest", "checkSelfPermission", "([Ljava/lang/String;)Z", "denied", "callback", "filterNotGrantedPermission", "([Ljava/lang/String;)[Ljava/lang/String;", "getContext", "T", "Landroid/content/Context;", "()Landroid/content/Context;", "hasPermission", "hasPermissionInManifest", "permission", "onRequestPermissionsResult", "grantResults", "", "(I[Ljava/lang/String;[I)V", "openAppDetailsActivity", "request", "permissionCallback", "requestAll", "requestIndividual", "shouldShowRational", "PermissionCallback", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PermissionHelper.kt */
public final class PermissionHelper {
    private int REQUEST_CODE;
    private final String TAG;
    private Activity activity;
    private Function1<? super Boolean, Unit> deniedCallback;
    private Fragment fragment;
    private PermissionCallback mPermissionCallback;
    private String[] permissions;
    private Function0<Unit> requestAllCallback;
    private Function1<? super String[], Unit> requestIndividualCallback;
    private boolean showRational;

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, mo66933d2 = {"Lcom/iaai/android/bdt/base/PermissionHelper$PermissionCallback;", "", "onIndividualPermissionGranted", "", "grantedPermission", "", "", "([Ljava/lang/String;)V", "onPermissionDenied", "onPermissionDeniedBySystem", "onPermissionGranted", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: PermissionHelper.kt */
    public interface PermissionCallback {
        void onIndividualPermissionGranted(@NotNull String[] strArr);

        void onPermissionDenied();

        void onPermissionDeniedBySystem();

        void onPermissionGranted();
    }

    public PermissionHelper(@NotNull Activity activity2, @NotNull Fragment fragment2, @NotNull String[] strArr, int i) {
        Intrinsics.checkParameterIsNotNull(activity2, "activity");
        Intrinsics.checkParameterIsNotNull(fragment2, "fragment");
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        this.TAG = "PermissionHelper";
        this.requestAllCallback = PermissionHelper$requestAllCallback$1.INSTANCE;
        this.requestIndividualCallback = PermissionHelper$requestIndividualCallback$1.INSTANCE;
        this.deniedCallback = PermissionHelper$deniedCallback$1.INSTANCE;
        this.activity = activity2;
        this.fragment = fragment2;
        this.permissions = strArr;
        this.REQUEST_CODE = i;
        checkIfPermissionPresentInAndroidManifest();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PermissionHelper(Activity activity2, String[] strArr, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity2, strArr, (i2 & 4) != 0 ? 100 : i);
    }

    public PermissionHelper(@NotNull Activity activity2, @NotNull String[] strArr, int i) {
        Intrinsics.checkParameterIsNotNull(activity2, "activity");
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        this.TAG = "PermissionHelper";
        this.requestAllCallback = PermissionHelper$requestAllCallback$1.INSTANCE;
        this.requestIndividualCallback = PermissionHelper$requestIndividualCallback$1.INSTANCE;
        this.deniedCallback = PermissionHelper$deniedCallback$1.INSTANCE;
        this.activity = activity2;
        this.permissions = strArr;
        this.REQUEST_CODE = i;
        checkIfPermissionPresentInAndroidManifest();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PermissionHelper(Fragment fragment2, String[] strArr, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment2, strArr, (i2 & 4) != 0 ? 100 : i);
    }

    public PermissionHelper(@NotNull Fragment fragment2, @NotNull String[] strArr, int i) {
        Intrinsics.checkParameterIsNotNull(fragment2, "fragment");
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        this.TAG = "PermissionHelper";
        this.requestAllCallback = PermissionHelper$requestAllCallback$1.INSTANCE;
        this.requestIndividualCallback = PermissionHelper$requestIndividualCallback$1.INSTANCE;
        this.deniedCallback = PermissionHelper$deniedCallback$1.INSTANCE;
        this.fragment = fragment2;
        this.permissions = strArr;
        this.REQUEST_CODE = i;
        checkIfPermissionPresentInAndroidManifest();
    }

    private final void checkIfPermissionPresentInAndroidManifest() {
        String[] strArr = this.permissions;
        if (strArr == null) {
            Intrinsics.throwNpe();
        }
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            if (hasPermissionInManifest(str)) {
                i++;
            } else {
                throw new RuntimeException("Permission (" + str + ") Not Declared in manifest");
            }
        }
    }

    public final void request(@Nullable PermissionCallback permissionCallback) {
        this.mPermissionCallback = permissionCallback;
        if (!hasPermission()) {
            String[] strArr = this.permissions;
            if (strArr == null) {
                Intrinsics.throwNpe();
            }
            this.showRational = shouldShowRational(strArr);
            Activity activity2 = this.activity;
            if (activity2 != null) {
                if (activity2 == null) {
                    Intrinsics.throwNpe();
                }
                String[] strArr2 = this.permissions;
                if (strArr2 == null) {
                    Intrinsics.throwNpe();
                }
                ActivityCompat.requestPermissions(activity2, filterNotGrantedPermission(strArr2), this.REQUEST_CODE);
                return;
            }
            Fragment fragment2 = this.fragment;
            if (fragment2 == null) {
                Intrinsics.throwNpe();
            }
            String[] strArr3 = this.permissions;
            if (strArr3 == null) {
                Intrinsics.throwNpe();
            }
            fragment2.requestPermissions(filterNotGrantedPermission(strArr3), this.REQUEST_CODE);
            return;
        }
        Log.i(this.TAG, "PERMISSION: Permission Granted");
        PermissionCallback permissionCallback2 = this.mPermissionCallback;
        if (permissionCallback2 != null) {
            permissionCallback2.onPermissionGranted();
        }
        this.requestAllCallback.invoke();
    }

    public final void requestAll(@NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "callback");
        this.requestAllCallback = function0;
        request((PermissionCallback) null);
    }

    public final void requestIndividual(@NotNull Function1<? super String[], Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        this.requestIndividualCallback = function1;
        request((PermissionCallback) null);
    }

    public final void denied(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "callback");
        this.deniedCallback = function1;
    }

    public final void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        if (i == this.REQUEST_CODE) {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            int i2 = 0;
            for (int i3 : iArr) {
                if (i3 != 0) {
                    z = true;
                } else {
                    arrayList.add(strArr[i2]);
                }
                i2++;
            }
            if (z) {
                boolean shouldShowRational = shouldShowRational(strArr);
                if (this.showRational || shouldShowRational) {
                    Log.i(this.TAG, "PERMISSION: Permission Denied");
                    Collection collection = arrayList;
                    if (!collection.isEmpty()) {
                        PermissionCallback permissionCallback = this.mPermissionCallback;
                        if (permissionCallback != null) {
                            Object[] array = collection.toArray(new String[0]);
                            if (array != null) {
                                permissionCallback.onIndividualPermissionGranted((String[]) array);
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        }
                        Function1<? super String[], Unit> function1 = this.requestIndividualCallback;
                        Object[] array2 = collection.toArray(new String[0]);
                        if (array2 != null) {
                            function1.invoke(array2);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                    PermissionCallback permissionCallback2 = this.mPermissionCallback;
                    if (permissionCallback2 != null) {
                        permissionCallback2.onPermissionDenied();
                    }
                    this.deniedCallback.invoke(false);
                    return;
                }
                Log.d(this.TAG, "PERMISSION: Permission Denied By System");
                PermissionCallback permissionCallback3 = this.mPermissionCallback;
                if (permissionCallback3 != null) {
                    permissionCallback3.onPermissionDeniedBySystem();
                }
                this.deniedCallback.invoke(true);
                return;
            }
            Log.i(this.TAG, "PERMISSION: Permission Granted");
            PermissionCallback permissionCallback4 = this.mPermissionCallback;
            if (permissionCallback4 != null) {
                permissionCallback4.onPermissionGranted();
            }
            this.requestAllCallback.invoke();
        }
    }

    private final <T extends Context> T getContext() {
        T t = this.activity;
        if (t != null) {
            return (Context) t;
        }
        Fragment fragment2 = this.fragment;
        if (fragment2 == null) {
            Intrinsics.throwNpe();
        }
        T context = fragment2.getContext();
        if (context != null) {
            return context;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
    }

    private final String[] filterNotGrantedPermission(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Context context = getContext();
            if (context == null) {
                Intrinsics.throwNpe();
            }
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                arrayList.add(str);
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final boolean hasPermission() {
        String[] strArr = this.permissions;
        if (strArr == null) {
            Intrinsics.throwNpe();
        }
        for (String str : strArr) {
            Context context = getContext();
            if (context == null) {
                Intrinsics.throwNpe();
            }
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean checkSelfPermission(@Nullable String[] strArr) {
        if (strArr == null) {
            Intrinsics.throwNpe();
        }
        for (String str : strArr) {
            Context context = getContext();
            if (context == null) {
                Intrinsics.throwNpe();
            }
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                return false;
            }
        }
        return true;
    }

    private final boolean shouldShowRational(String[] strArr) {
        for (String str : strArr) {
            Activity activity2 = this.activity;
            if (activity2 != null) {
                if (activity2 == null) {
                    Intrinsics.throwNpe();
                }
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity2, str)) {
                    return true;
                }
            } else {
                Fragment fragment2 = this.fragment;
                if (fragment2 == null) {
                    Intrinsics.throwNpe();
                }
                if (fragment2.shouldShowRequestPermissionRationale(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        r3 = r1.getPackageManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean hasPermissionInManifest(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            android.app.Activity r1 = r5.activity     // Catch:{ Exception -> 0x0047 }
            if (r1 == 0) goto L_0x0008
            android.app.Activity r1 = r5.activity     // Catch:{ Exception -> 0x0047 }
            goto L_0x0015
        L_0x0008:
            androidx.fragment.app.Fragment r1 = r5.fragment     // Catch:{ Exception -> 0x0047 }
            if (r1 != 0) goto L_0x000f
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ Exception -> 0x0047 }
        L_0x000f:
            androidx.fragment.app.FragmentActivity r1 = r1.getActivity()     // Catch:{ Exception -> 0x0047 }
            android.app.Activity r1 = (android.app.Activity) r1     // Catch:{ Exception -> 0x0047 }
        L_0x0015:
            r2 = 0
            if (r1 == 0) goto L_0x0029
            android.content.pm.PackageManager r3 = r1.getPackageManager()     // Catch:{ Exception -> 0x0047 }
            if (r3 == 0) goto L_0x0029
            java.lang.String r1 = r1.getPackageName()     // Catch:{ Exception -> 0x0047 }
            r4 = 4096(0x1000, float:5.74E-42)
            android.content.pm.PackageInfo r1 = r3.getPackageInfo(r1, r4)     // Catch:{ Exception -> 0x0047 }
            goto L_0x002a
        L_0x0029:
            r1 = r2
        L_0x002a:
            if (r1 == 0) goto L_0x002f
            java.lang.String[] r3 = r1.requestedPermissions     // Catch:{ Exception -> 0x0047 }
            goto L_0x0030
        L_0x002f:
            r3 = r2
        L_0x0030:
            if (r3 == 0) goto L_0x004b
            if (r1 == 0) goto L_0x0036
            java.lang.String[] r2 = r1.requestedPermissions     // Catch:{ Exception -> 0x0047 }
        L_0x0036:
            int r1 = r2.length     // Catch:{ Exception -> 0x0047 }
            r3 = 0
        L_0x0038:
            if (r3 >= r1) goto L_0x004b
            r4 = r2[r3]     // Catch:{ Exception -> 0x0047 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)     // Catch:{ Exception -> 0x0047 }
            if (r4 == 0) goto L_0x0044
            r6 = 1
            return r6
        L_0x0044:
            int r3 = r3 + 1
            goto L_0x0038
        L_0x0047:
            r6 = move-exception
            r6.printStackTrace()
        L_0x004b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.base.PermissionHelper.hasPermissionInManifest(java.lang.String):boolean");
    }

    public final void openAppDetailsActivity() {
        if (getContext() != null) {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            StringBuilder sb = new StringBuilder();
            sb.append("package:");
            Context context = getContext();
            if (context == null) {
                Intrinsics.throwNpe();
            }
            sb.append(context.getPackageName());
            intent.setData(Uri.parse(sb.toString()));
            intent.addFlags(C1119C.ENCODING_PCM_MU_LAW);
            intent.addFlags(1073741824);
            intent.addFlags(8388608);
            Context context2 = getContext();
            if (context2 == null) {
                Intrinsics.throwNpe();
            }
            context2.startActivity(intent);
        }
    }
}
