package com.iaai.android.bdt.feature.account.tobepickedup;

import android.view.View;
import com.iaai.android.bdt.model.MyAccount.ToBePickedUpVehiclesModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/tobepickedup/OnItemClickListener;", "", "onItemClickListener", "", "v", "Landroid/view/View;", "toBePickedUpVehiclesModel", "Lcom/iaai/android/bdt/model/MyAccount/ToBePickedUpVehiclesModel;", "position", "", "onSortItemClick", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: OnItemClickListener.kt */
public interface OnItemClickListener {
    void onItemClickListener(@NotNull View view, @Nullable ToBePickedUpVehiclesModel toBePickedUpVehiclesModel, int i);

    void onSortItemClick(int i);
}
