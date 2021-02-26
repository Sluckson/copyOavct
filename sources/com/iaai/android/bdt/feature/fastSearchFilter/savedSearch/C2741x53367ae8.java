package com.iaai.android.bdt.feature.fastSearchFilter.savedSearch;

import com.iaai.android.bdt.extensions.OnAlertButtonClick;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, mo66933d2 = {"com/iaai/android/bdt/feature/fastSearchFilter/savedSearch/SavedSearchActivity$initializeRecycler$1$onRemoveClicked$onAlertButtonClick$1", "Lcom/iaai/android/bdt/extensions/OnAlertButtonClick;", "onCancelClick", "", "onOKClick", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* renamed from: com.iaai.android.bdt.feature.fastSearchFilter.savedSearch.SavedSearchActivity$initializeRecycler$1$onRemoveClicked$onAlertButtonClick$1 */
/* compiled from: SavedSearchActivity.kt */
public final class C2741x53367ae8 implements OnAlertButtonClick {
    final /* synthetic */ String $searchName;
    final /* synthetic */ SavedSearchActivity$initializeRecycler$1 this$0;

    public void onCancelClick() {
    }

    C2741x53367ae8(SavedSearchActivity$initializeRecycler$1 savedSearchActivity$initializeRecycler$1, String str) {
        this.this$0 = savedSearchActivity$initializeRecycler$1;
        this.$searchName = str;
    }

    public void onOKClick() {
        this.this$0.this$0.deleteSavedSearch(this.$searchName);
    }
}
