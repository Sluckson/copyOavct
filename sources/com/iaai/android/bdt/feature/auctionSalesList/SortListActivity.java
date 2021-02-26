package com.iaai.android.bdt.feature.auctionSalesList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.base.PermissionHelper;
import com.iaai.android.bdt.feature.auctionSalesList.SortAdapter;
import com.iaai.android.bdt.model.sort.SortOptionData;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.NewDateHelper;
import com.iaai.android.old.utils.IAASharedPreference;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J+\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u000b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001f2\u0006\u0010 \u001a\u00020!H\u0016¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u0011H\u0014J\b\u0010$\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionSalesList/SortListActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "Lcom/iaai/android/bdt/feature/auctionSalesList/SortAdapter$OnItemClickListener;", "()V", "permissionHelper", "Lcom/iaai/android/bdt/base/PermissionHelper;", "screenName", "", "sortAdpater", "Lcom/iaai/android/bdt/feature/auctionSalesList/SortAdapter;", "sortForm", "", "sortItemList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/sort/SortOptionData;", "Lkotlin/collections/ArrayList;", "getSelectedSortForSalesList", "", "sortItem", "position", "getSelectedSortForToBePaidList", "getSelectedSortForWatchList", "handlePermissionCallbacksForLocation", "navigateToSearchResult", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "updateSortUI", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SortListActivity.kt */
public final class SortListActivity extends BaseActivity implements SortAdapter.OnItemClickListener {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public PermissionHelper permissionHelper;
    private String screenName = "";
    private SortAdapter sortAdpater;
    private int sortForm = 1;
    private ArrayList<SortOptionData> sortItemList = new ArrayList<>();

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

    public static final /* synthetic */ PermissionHelper access$getPermissionHelper$p(SortListActivity sortListActivity) {
        PermissionHelper permissionHelper2 = sortListActivity.permissionHelper;
        if (permissionHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionHelper");
        }
        return permissionHelper2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_sort_sales_list);
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.toolbar));
        Context applicationContext = getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
        this.sortAdpater = new SortAdapter(applicationContext);
        Intent intent = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent, "intent");
        ArrayList<SortOptionData> parcelableArrayList = intent.getExtras().getParcelableArrayList(Constants_MVVM.EXTRA_SORT_LIST);
        Intrinsics.checkExpressionValueIsNotNull(parcelableArrayList, "intent.extras.getParcela…nts_MVVM.EXTRA_SORT_LIST)");
        this.sortItemList = parcelableArrayList;
        Intent intent2 = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent2, "intent");
        this.sortForm = intent2.getExtras().getInt(Constants_MVVM.EXTRA_SORT_FROM);
        Intent intent3 = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent3, "intent");
        String string = intent3.getExtras().getString("screen_name");
        if (string == null) {
            string = "";
        }
        this.screenName = string;
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.img_back)).setOnClickListener(new SortListActivity$onCreate$1(this));
        updateSortUI();
        this.permissionHelper = new PermissionHelper((Activity) this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 100);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IAAAnalytics.INSTANCE.logScreenName(this.screenName, this);
    }

    private final void updateSortUI() {
        if (this.sortForm == 2) {
            SortAdapter sortAdapter = this.sortAdpater;
            if (sortAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sortAdpater");
            }
            sortAdapter.setSortOptionData(this.sortItemList, true);
        } else {
            SortAdapter sortAdapter2 = this.sortAdpater;
            if (sortAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sortAdpater");
            }
            sortAdapter2.setSortOptionData(this.sortItemList, false);
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rv_sort);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rv_sort");
        SortAdapter sortAdapter3 = this.sortAdpater;
        if (sortAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortAdpater");
        }
        recyclerView.setAdapter(sortAdapter3);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rv_sort);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rv_sort");
        recyclerView2.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rv_sort)).addItemDecoration(new DividerItemDecoration(this, 1));
        SortAdapter sortAdapter4 = this.sortAdpater;
        if (sortAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortAdpater");
        }
        sortAdapter4.setClickListener(this);
        SortAdapter sortAdapter5 = this.sortAdpater;
        if (sortAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortAdpater");
        }
        Intent intent = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent, "intent");
        sortAdapter5.setSelectedPosition(intent.getExtras().getInt(Constants_MVVM.EXTRA_SORT_LIST_POSTION));
    }

    public void onItemClick(@NotNull SortOptionData sortOptionData, int i) {
        Intrinsics.checkParameterIsNotNull(sortOptionData, "sortItem");
        int i2 = this.sortForm;
        if (i2 == 1) {
            getSelectedSortForSalesList(sortOptionData, i);
        } else if (i2 == 2) {
            if (i != 0 || !Intrinsics.areEqual((Object) sortOptionData.getDisplayText(), (Object) Constants_MVVM.SORT_MY_LOCATION_KEY)) {
                if (i == 0 && Intrinsics.areEqual((Object) sortOptionData.getDisplayText(), (Object) Constants_MVVM.SORT_ZIPCODE_KEY)) {
                    IAASharedPreference.setLastUsedZipCode(this, sortOptionData.getSortKey());
                }
                navigateToSearchResult(sortOptionData, i);
                return;
            }
            handlePermissionCallbacksForLocation(sortOptionData, i);
        } else if (i2 == 3) {
            getSelectedSortForWatchList(sortOptionData, i);
        } else if (i2 == 15) {
            getSelectedSortForToBePaidList(sortOptionData, i);
        }
    }

    private final void getSelectedSortForSalesList(SortOptionData sortOptionData, int i) {
        IAASharedPreference.setSortItemPreferencesMVVM(getApplicationContext(), sortOptionData.getSortKey());
        IAASharedPreference.setSortDirectionPreferencesMVVM(getApplicationContext(), sortOptionData.getSortDirection());
        IAASharedPreference.setLastUpdateSortPreferencesMVVM(getApplicationContext(), NewDateHelper.INSTANCE.getSortCurrentDateAndTime());
        IAASharedPreference.setSortItemPositionPreferencesMVVM(getApplicationContext(), i);
        Intent intent = new Intent();
        intent.putExtra(Constants_MVVM.EXTRA_IS_SORT_APPLIED, true);
        setResult(2, intent);
        finish();
    }

    private final void getSelectedSortForWatchList(SortOptionData sortOptionData, int i) {
        Intent intent = new Intent();
        intent.putExtra(Constants_MVVM.EXTRA_IS_SORT_APPLIED, true);
        intent.putExtra(Constants_MVVM.EXTRA_SORT_BY, sortOptionData.getSortKey());
        intent.putExtra(Constants_MVVM.EXTRA_SORT_DIRECTION, sortOptionData.getSortDirection());
        intent.putExtra(Constants_MVVM.EXTRA_SEARCH_SELECTED_SORT_POSITION, i);
        setResult(2, intent);
        finish();
    }

    /* access modifiers changed from: private */
    public final void navigateToSearchResult(SortOptionData sortOptionData, int i) {
        Intent intent = new Intent();
        intent.putExtra(Constants_MVVM.EXTRA_SEARCH_SELECTED_SORT, sortOptionData);
        intent.putExtra(Constants_MVVM.EXTRA_SEARCH_SELECTED_SORT_POSITION, i);
        setResult(105, intent);
        finish();
    }

    private final void handlePermissionCallbacksForLocation(SortOptionData sortOptionData, int i) {
        PermissionHelper permissionHelper2 = this.permissionHelper;
        if (permissionHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionHelper");
        }
        permissionHelper2.denied(new SortListActivity$handlePermissionCallbacksForLocation$1(this));
        PermissionHelper permissionHelper3 = this.permissionHelper;
        if (permissionHelper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionHelper");
        }
        permissionHelper3.requestIndividual(SortListActivity$handlePermissionCallbacksForLocation$2.INSTANCE);
        PermissionHelper permissionHelper4 = this.permissionHelper;
        if (permissionHelper4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionHelper");
        }
        permissionHelper4.requestAll(new SortListActivity$handlePermissionCallbacksForLocation$3(this, sortOptionData, i));
    }

    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        PermissionHelper permissionHelper2 = this.permissionHelper;
        if (permissionHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionHelper");
        }
        permissionHelper2.onRequestPermissionsResult(i, strArr, iArr);
    }

    private final void getSelectedSortForToBePaidList(SortOptionData sortOptionData, int i) {
        Intent intent = new Intent();
        intent.putExtra(Constants_MVVM.EXTRA_IS_SORT_APPLIED, true);
        intent.putExtra(Constants_MVVM.EXTRA_SEARCH_SELECTED_SORT, sortOptionData);
        intent.putExtra(Constants_MVVM.EXTRA_SEARCH_SELECTED_SORT_POSITION, i);
        IAASharedPreference.setToBePaidSortSelction(getApplicationContext(), i);
        setResult(-1, intent);
        finish();
    }
}
