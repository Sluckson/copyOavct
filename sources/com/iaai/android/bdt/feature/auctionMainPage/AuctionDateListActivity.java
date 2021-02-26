package com.iaai.android.bdt.feature.auctionMainPage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.feature.auctionMainPage.AuctionDateAdapter;
import com.iaai.android.bdt.utils.Constants_MVVM;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X.¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0013"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionDateListActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionDateAdapter$OnItemClickListener;", "()V", "auctionDateAdpater", "Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionDateAdapter;", "auctionDateList", "", "", "[Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "auctionDate", "position", "", "updateAuctionDateUI", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionDateListActivity.kt */
public final class AuctionDateListActivity extends BaseActivity implements AuctionDateAdapter.OnItemClickListener {
    private HashMap _$_findViewCache;
    private AuctionDateAdapter auctionDateAdpater;
    private String[] auctionDateList;

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

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_auction_date_layout);
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.toolbar));
        Context applicationContext = getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
        this.auctionDateAdpater = new AuctionDateAdapter(applicationContext);
        String[] stringArrayExtra = getIntent().getStringArrayExtra(Constants_MVVM.EXTRA_AUCTION_DATE_LIST);
        Intrinsics.checkExpressionValueIsNotNull(stringArrayExtra, "intent.getStringArrayExt….EXTRA_AUCTION_DATE_LIST)");
        this.auctionDateList = stringArrayExtra;
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.imgAuctionDateBack)).setOnClickListener(new AuctionDateListActivity$onCreate$1(this));
        updateAuctionDateUI();
    }

    private final void updateAuctionDateUI() {
        AuctionDateAdapter auctionDateAdapter = this.auctionDateAdpater;
        if (auctionDateAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionDateAdpater");
        }
        String[] strArr = this.auctionDateList;
        if (strArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionDateList");
        }
        auctionDateAdapter.setLaneData(strArr);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvAuctionDate);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvAuctionDate");
        AuctionDateAdapter auctionDateAdapter2 = this.auctionDateAdpater;
        if (auctionDateAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionDateAdpater");
        }
        recyclerView.setAdapter(auctionDateAdapter2);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvAuctionDate);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvAuctionDate");
        recyclerView2.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        AuctionDateAdapter auctionDateAdapter3 = this.auctionDateAdpater;
        if (auctionDateAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionDateAdpater");
        }
        auctionDateAdapter3.setClickListener(this);
    }

    public void onItemClick(@NotNull String str, int i) {
        Intrinsics.checkParameterIsNotNull(str, "auctionDate");
        Intent intent = new Intent();
        intent.putExtra(Constants_MVVM.EXTRA_AUCTION_DATE_POS, i);
        intent.putExtra(Constants_MVVM.EXTRA_SELECTED_AUCTION_DATE, str);
        setResult(3, intent);
        finish();
    }
}
