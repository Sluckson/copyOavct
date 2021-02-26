package com.iaai.android.bdt.feature.fastSearchFilter.savedSearch;

import android.util.Log;
import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo66933d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SavedSearchActivity.kt */
final class SavedSearchActivity$subscribeToViewModel$3<T> implements Observer<Boolean> {
    final /* synthetic */ SavedSearchActivity this$0;

    SavedSearchActivity$subscribeToViewModel$3(SavedSearchActivity savedSearchActivity) {
        this.this$0 = savedSearchActivity;
    }

    public final void onChanged(Boolean bool) {
        Log.d("deleteSavedSearch--->", "Success");
        this.this$0.fetchSavedSearchList();
    }
}
