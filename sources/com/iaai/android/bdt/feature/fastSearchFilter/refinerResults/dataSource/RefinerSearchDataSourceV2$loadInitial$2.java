package com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.dataSource;

import androidx.paging.PageKeyedDataSource;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchResponse2;
import com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult;
import com.iaai.android.bdt.model.fastSearchFilter2.SavedSearch;
import com.iaai.android.bdt.model.fastSearchFilter2.Search;
import com.iaai.android.bdt.utils.NetworkState;
import java.util.List;
import kotlin.Metadata;
import p011io.reactivex.functions.Consumer;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchResponse2;", "kotlin.jvm.PlatformType", "accept"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: RefinerSearchDataSourceV2.kt */
final class RefinerSearchDataSourceV2$loadInitial$2<T> implements Consumer<FastSearchResponse2> {
    final /* synthetic */ PageKeyedDataSource.LoadInitialCallback $callback;
    final /* synthetic */ RefinerSearchDataSourceV2 this$0;

    RefinerSearchDataSourceV2$loadInitial$2(RefinerSearchDataSourceV2 refinerSearchDataSourceV2, PageKeyedDataSource.LoadInitialCallback loadInitialCallback) {
        this.this$0 = refinerSearchDataSourceV2;
        this.$callback = loadInitialCallback;
    }

    public final void accept(FastSearchResponse2 fastSearchResponse2) {
        Search component2 = fastSearchResponse2.component2();
        List<FormattedResult> formattedResults = component2.getFormattedResults();
        int size = formattedResults.size();
        this.this$0.getSelectedFacetsRequest().postValue(component2.getRequest());
        if (size > 0) {
            this.$callback.onResult(formattedResults, null, Long.valueOf((long) (component2.getResult().getCount() - this.this$0.end)));
            this.this$0.vehicleTotalCount.postValue(Integer.valueOf(component2.getResult().getCount()));
            this.this$0.setBody(component2.getRequest());
            this.this$0.getBody().setSavedsearch((SavedSearch) null);
            this.this$0.getNetworkState().postValue(NetworkState.LOADED);
        }
    }
}
