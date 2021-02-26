package com.iaai.android.bdt.feature.fastSearchFilter.savedSearch;

import android.app.Dialog;
import android.content.res.Resources;
import android.util.Log;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import com.iaai.android.bdt.feature.fastSearchFilter.savedSearch.SavedSearchAdapter;
import com.iaai.android.bdt.model.savedSearchList.SavedSearchListResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo66933d2 = {"com/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchActivity$initializeRecycler$1", "Lcom/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchAdapter$OnClickListener;", "onRemoveClicked", "", "searchName", "", "onSavedItemClicked", "savedSearchResponse", "Lcom/iaai/android/bdt/model/savedSearchList/SavedSearchListResponse;", "position", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SavedSearchActivity.kt */
public final class SavedSearchActivity$initializeRecycler$1 implements SavedSearchAdapter.OnClickListener {
    final /* synthetic */ SavedSearchActivity this$0;

    SavedSearchActivity$initializeRecycler$1(SavedSearchActivity savedSearchActivity) {
        this.this$0 = savedSearchActivity;
    }

    public void onRemoveClicked(@Nullable String str) {
        Log.e("TEST", "Remove Clicked");
        C2741x53367ae8 savedSearchActivity$initializeRecycler$1$onRemoveClicked$onAlertButtonClick$1 = new C2741x53367ae8(this, str);
        SavedSearchActivity savedSearchActivity = this.this$0;
        Resources resources = savedSearchActivity.getResources();
        Object[] objArr = new Object[1];
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        String string = resources.getString(C2723R.string.lbl_delete_saved_search_msg, objArr);
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.st…                   ?: \"\")");
        Dialog showAlertWithTitle = Activity_ExtensionKt.showAlertWithTitle(savedSearchActivity, "", string, C2723R.string.lbl_delete, 17039360, savedSearchActivity$initializeRecycler$1$onRemoveClicked$onAlertButtonClick$1);
        if (showAlertWithTitle != null) {
            showAlertWithTitle.show();
        }
    }

    public void onSavedItemClicked(@Nullable SavedSearchListResponse savedSearchListResponse, int i) {
        this.this$0.navigateToResultPageNew(savedSearchListResponse);
    }
}
