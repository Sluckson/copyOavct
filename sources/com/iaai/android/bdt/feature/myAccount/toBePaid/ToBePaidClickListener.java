package com.iaai.android.bdt.feature.myAccount.toBePaid;

import androidx.paging.PagedList;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0018\u0010\n\u001a\u00020\u00032\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/ToBePaidClickListener;", "", "onChangePaymentClick", "", "onSelectPaymentClick", "onSelectPaymentInfoClick", "onSortClick", "onVehicleClick", "vehicle", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "onVehicleSelect", "vehicleList", "Landroidx/paging/PagedList;", "onVehicleSelectAll", "isSelected", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ToBePaidClickListener.kt */
public interface ToBePaidClickListener {
    void onChangePaymentClick();

    void onSelectPaymentClick();

    void onSelectPaymentInfoClick();

    void onSortClick();

    void onVehicleClick(@Nullable PaymentDue paymentDue);

    void onVehicleSelect(@Nullable PagedList<PaymentDue> pagedList);

    void onVehicleSelectAll(boolean z);
}
