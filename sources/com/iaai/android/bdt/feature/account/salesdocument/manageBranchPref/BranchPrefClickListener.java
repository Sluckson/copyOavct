package com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref;

import com.iaai.android.bdt.model.MyAccount.BranchModel;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0007\u001a\u00020\u00032\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&¨\u0006\u000b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/salesdocument/manageBranchPref/BranchPrefClickListener;", "", "onBranchClear", "", "onBranchFilter", "filterValue", "", "onBranchSelect", "branchList", "", "Lcom/iaai/android/bdt/model/MyAccount/BranchModel;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BranchPrefClickListener.kt */
public interface BranchPrefClickListener {
    void onBranchClear();

    void onBranchFilter(@NotNull String str);

    void onBranchSelect(@Nullable List<BranchModel> list);
}
