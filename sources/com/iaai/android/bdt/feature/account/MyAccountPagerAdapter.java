package com.iaai.android.bdt.feature.account;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.google.gson.Gson;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.MyAccount.BDTDashboardResponse;
import com.iaai.android.bdt.utils.Constants_MVVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\bH\u0016J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bJ\u0016\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\nR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/MyAccountPagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "context", "Landroid/content/Context;", "(Landroidx/fragment/app/FragmentManager;Landroid/content/Context;)V", "buyNowOfferCount", "", "isShowMyVehicle", "", "jsonDashBoardString", "", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "getCount", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getPageTitle", "", "setBuyNowOfferData", "", "mBuyNowOfferCount", "setDashBoardData", "bdtDashboardResponse", "Lcom/iaai/android/bdt/model/MyAccount/BDTDashboardResponse;", "showMyVehicle", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MyAccountPagerAdapter.kt */
public final class MyAccountPagerAdapter extends FragmentStatePagerAdapter {
    private int buyNowOfferCount;
    private boolean isShowMyVehicle;
    private String jsonDashBoardString = "";
    @NotNull
    private Context mContext;

    public int getCount() {
        return 2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MyAccountPagerAdapter(@NotNull FragmentManager fragmentManager, @NotNull Context context) {
        super(fragmentManager);
        Intrinsics.checkParameterIsNotNull(fragmentManager, "fm");
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mContext = context;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
    }

    public final void setMContext(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "<set-?>");
        this.mContext = context;
    }

    @NotNull
    public Fragment getItem(int i) {
        if (i == 0) {
            Fragment myListFragment = new MyListFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(Constants_MVVM.BDT_BUY_NOW_OFFER_COUNT, this.buyNowOfferCount);
            bundle.putString(Constants_MVVM.BDT_DASHBOARD_RESPONSE, this.jsonDashBoardString);
            bundle.putBoolean(Constants_MVVM.BDT_SHOW_MY_VEHICLE, this.isShowMyVehicle);
            ((MyListFragment) myListFragment).setArguments(bundle);
            return myListFragment;
        }
        Fragment accountSettingFragment = new AccountSettingFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString(Constants_MVVM.BDT_DASHBOARD_RESPONSE, this.jsonDashBoardString);
        ((AccountSettingFragment) accountSettingFragment).setArguments(bundle2);
        return accountSettingFragment;
    }

    public final void setBuyNowOfferData(int i) {
        this.buyNowOfferCount = i;
    }

    public final void setDashBoardData(@NotNull BDTDashboardResponse bDTDashboardResponse, boolean z) {
        Intrinsics.checkParameterIsNotNull(bDTDashboardResponse, "bdtDashboardResponse");
        this.jsonDashBoardString = new Gson().toJson((Object) bDTDashboardResponse);
        this.isShowMyVehicle = z;
    }

    @Nullable
    public CharSequence getPageTitle(int i) {
        String str = null;
        if (i == 0) {
            str = this.mContext.getString(C2723R.string.lbl_my_list);
        } else if (i == 1) {
            str = this.mContext.getString(C2723R.string.lbl_my_accounnt_setting);
        }
        return str;
    }
}
