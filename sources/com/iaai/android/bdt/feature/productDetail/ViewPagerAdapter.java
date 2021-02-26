package com.iaai.android.bdt.feature.productDetail;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.constants.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B5\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\b¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010\u0013\u001a\u00020\u00142\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\bR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/ViewPagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "itemIdList", "Ljava/util/ArrayList;", "", "tenantList", "Lkotlin/collections/ArrayList;", "(Landroidx/fragment/app/FragmentManager;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "count", "", "getCount", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getItemPosition", "object", "", "setItemIdList", "", "idList", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ViewPagerAdapter.kt */
public final class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private int count;
    private final ArrayList<String> itemIdList;
    private final ArrayList<String> tenantList;

    public int getItemPosition(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "object");
        return -1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewPagerAdapter(@NotNull FragmentManager fragmentManager, @NotNull ArrayList<String> arrayList, @NotNull ArrayList<String> arrayList2) {
        super(fragmentManager);
        Intrinsics.checkParameterIsNotNull(fragmentManager, "fm");
        Intrinsics.checkParameterIsNotNull(arrayList, "itemIdList");
        Intrinsics.checkParameterIsNotNull(arrayList2, "tenantList");
        this.itemIdList = arrayList;
        this.tenantList = arrayList2;
        ArrayList<String> arrayList3 = this.itemIdList;
        this.count = (arrayList3 != null ? Integer.valueOf(arrayList3.size()) : null).intValue();
    }

    @NotNull
    public Fragment getItem(int i) {
        Fragment fragment = null;
        Bundle bundle = new Bundle();
        bundle.putString(Constants.EXTRA_ITEM_ID, this.itemIdList.get(i));
        bundle.putInt(Constants_MVVM.EXTRA_TOTAL_COUNT, this.itemIdList.size());
        if (!this.tenantList.isEmpty()) {
            bundle.putString("countryCode", this.tenantList.get(i));
        }
        Fragment productDetailFragment = new ProductDetailFragment();
        ((ProductDetailFragment) productDetailFragment).setArguments(bundle);
        return productDetailFragment;
    }

    public int getCount() {
        return this.count;
    }

    public final void setItemIdList(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "idList");
        Log.e("TEST", "COUNT BEFORE " + this.itemIdList.size());
        this.itemIdList.addAll(arrayList);
        Log.e("TEST", "COUNT AFTER " + this.itemIdList.size());
    }
}
