package com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.dataSource;

import androidx.paging.PageKeyedDataSource;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchResponse2;
import com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult;
import com.iaai.android.bdt.utils.NetworkState;
import java.util.List;
import kotlin.Metadata;
import p011io.reactivex.functions.Consumer;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchResponse2;", "kotlin.jvm.PlatformType", "accept"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: RefinerSearchDataSourceV2.kt */
final class RefinerSearchDataSourceV2$loadAfter$2<T> implements Consumer<FastSearchResponse2> {
    final /* synthetic */ PageKeyedDataSource.LoadCallback $callback;
    final /* synthetic */ PageKeyedDataSource.LoadParams $params;
    final /* synthetic */ RefinerSearchDataSourceV2 this$0;

    RefinerSearchDataSourceV2$loadAfter$2(RefinerSearchDataSourceV2 refinerSearchDataSourceV2, PageKeyedDataSource.LoadParams loadParams, PageKeyedDataSource.LoadCallback loadCallback) {
        this.this$0 = refinerSearchDataSourceV2;
        this.$params = loadParams;
        this.$callback = loadCallback;
    }

    public final void accept(FastSearchResponse2 fastSearchResponse2) {
        List<FormattedResult> formattedResults = fastSearchResponse2.component2().getFormattedResults();
        long longValue = ((Number) this.$params.key).longValue() - ((long) formattedResults.size());
        if (longValue == 0) {
            this.$callback.onResult(formattedResults, null);
        } else {
            this.$callback.onResult(formattedResults, Long.valueOf(longValue));
        }
        this.this$0.getNetworkState().postValue(NetworkState.LOADED);
    }
}
