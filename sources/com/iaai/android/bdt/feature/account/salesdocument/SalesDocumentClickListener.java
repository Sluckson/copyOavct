package com.iaai.android.bdt.feature.account.salesdocument;

import androidx.paging.PagedList;
import com.iaai.android.bdt.model.MyAccount.SaleDocumentListModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&J\b\u0010\t\u001a\u00020\u0003H&J\u001a\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H&¨\u0006\u0014"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/salesdocument/SalesDocumentClickListener;", "", "onBranchPrefClick", "", "onChangeMethodClick", "onDocumentSelect", "vehicleList", "Landroidx/paging/PagedList;", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocumentListModel;", "onFilterClick", "onSalesDocumentClick", "salesDocument", "position", "", "onSortClick", "onTabStatusClick", "status", "", "onTrackingIdClick", "trackingNumber", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SalesDocumentClickListener.kt */
public interface SalesDocumentClickListener {
    void onBranchPrefClick();

    void onChangeMethodClick();

    void onDocumentSelect(@Nullable PagedList<SaleDocumentListModel> pagedList);

    void onFilterClick();

    void onSalesDocumentClick(@Nullable SaleDocumentListModel saleDocumentListModel, int i);

    void onSortClick();

    void onTabStatusClick(@NotNull String str);

    void onTrackingIdClick(@Nullable String str);
}
