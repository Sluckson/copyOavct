package com.iaai.android.bdt.base;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.iaai.android.C2723R;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0004J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0016R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0014"}, mo66933d2 = {"Lcom/iaai/android/bdt/base/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Ldagger/android/support/HasSupportFragmentInjector;", "()V", "dispatchingAndroidInjector", "Ldagger/android/DispatchingAndroidInjector;", "Landroidx/fragment/app/Fragment;", "getDispatchingAndroidInjector", "()Ldagger/android/DispatchingAndroidInjector;", "setDispatchingAndroidInjector", "(Ldagger/android/DispatchingAndroidInjector;)V", "displayError", "", "errorType", "Lcom/iaai/android/bdt/base/BaseActivity$ErrorType;", "message", "", "supportFragmentInjector", "Ldagger/android/AndroidInjector;", "ErrorType", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BaseActivity.kt */
public class BaseActivity extends AppCompatActivity implements HasSupportFragmentInjector {
    private HashMap _$_findViewCache;
    @Inject
    @NotNull
    public DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @NotNull
    public final DispatchingAndroidInjector<Fragment> getDispatchingAndroidInjector() {
        DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector2 = this.dispatchingAndroidInjector;
        if (dispatchingAndroidInjector2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dispatchingAndroidInjector");
        }
        return dispatchingAndroidInjector2;
    }

    public final void setDispatchingAndroidInjector(@NotNull DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector2) {
        Intrinsics.checkParameterIsNotNull(dispatchingAndroidInjector2, "<set-?>");
        this.dispatchingAndroidInjector = dispatchingAndroidInjector2;
    }

    @NotNull
    public AndroidInjector<Fragment> supportFragmentInjector() {
        DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector2 = this.dispatchingAndroidInjector;
        if (dispatchingAndroidInjector2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dispatchingAndroidInjector");
        }
        return dispatchingAndroidInjector2;
    }

    /* access modifiers changed from: protected */
    public final void displayError(@NotNull ErrorType errorType, @NotNull String str) {
        String str2;
        Intrinsics.checkParameterIsNotNull(errorType, "errorType");
        Intrinsics.checkParameterIsNotNull(str, "message");
        switch (errorType) {
            case NO_INTERNET:
                str2 = "No internet connection found. Please connect to internet and try again.";
                break;
            case NETWORK_ERROR:
                str2 = getString(C2723R.string.msg_prd_network_error);
                Intrinsics.checkExpressionValueIsNotNull(str2, "getString(R.string.msg_prd_network_error)");
                break;
            case NO_STOCKS:
                str2 = "No stocks available";
                break;
            case NO_AUCTION_LOCATION:
                str2 = "Try searching by typing the name of a state within the U.S.";
                break;
            case NO_AUCTION:
                str2 = "";
                break;
            case NO_DATA_FOUND:
                str2 = "No Data Found";
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.emptyRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "emptyRecyclerView");
        TextView textView = (TextView) linearLayout.findViewById(C2723R.C2726id.errorTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "emptyRecyclerView.errorTitle");
        textView.setText(errorType.getValue());
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.emptyRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "emptyRecyclerView");
        TextView textView2 = (TextView) linearLayout2.findViewById(C2723R.C2726id.errorBody);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "emptyRecyclerView.errorBody");
        textView2.setText(str2);
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/base/BaseActivity$ErrorType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NO_INTERNET", "NETWORK_ERROR", "NO_STOCKS", "NO_AUCTION_LOCATION", "NO_AUCTION", "NO_DATA_FOUND", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: BaseActivity.kt */
    public enum ErrorType {
        NO_INTERNET("No Internet"),
        NETWORK_ERROR("Network Error"),
        NO_STOCKS("No Stocks"),
        NO_AUCTION_LOCATION("No auctions found near you."),
        NO_AUCTION("No auctions found"),
        NO_DATA_FOUND("No Data Found");
        
        @NotNull
        private final String value;

        private ErrorType(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }
}
