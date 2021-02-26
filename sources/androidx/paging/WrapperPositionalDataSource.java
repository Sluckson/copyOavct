package androidx.paging;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;
import java.util.List;

class WrapperPositionalDataSource<A, B> extends PositionalDataSource<B> {
    /* access modifiers changed from: private */
    public final Function<List<A>, List<B>> mListFunction;
    private final PositionalDataSource<A> mSource;

    WrapperPositionalDataSource(PositionalDataSource<A> positionalDataSource, Function<List<A>, List<B>> function) {
        this.mSource = positionalDataSource;
        this.mListFunction = function;
    }

    public void addInvalidatedCallback(@NonNull DataSource.InvalidatedCallback invalidatedCallback) {
        this.mSource.addInvalidatedCallback(invalidatedCallback);
    }

    public void removeInvalidatedCallback(@NonNull DataSource.InvalidatedCallback invalidatedCallback) {
        this.mSource.removeInvalidatedCallback(invalidatedCallback);
    }

    public void invalidate() {
        this.mSource.invalidate();
    }

    public boolean isInvalid() {
        return this.mSource.isInvalid();
    }

    public void loadInitial(@NonNull PositionalDataSource.LoadInitialParams loadInitialParams, @NonNull final PositionalDataSource.LoadInitialCallback<B> loadInitialCallback) {
        this.mSource.loadInitial(loadInitialParams, new PositionalDataSource.LoadInitialCallback<A>() {
            public void onResult(@NonNull List<A> list, int i, int i2) {
                loadInitialCallback.onResult(DataSource.convert(WrapperPositionalDataSource.this.mListFunction, list), i, i2);
            }

            public void onResult(@NonNull List<A> list, int i) {
                loadInitialCallback.onResult(DataSource.convert(WrapperPositionalDataSource.this.mListFunction, list), i);
            }
        });
    }

    public void loadRange(@NonNull PositionalDataSource.LoadRangeParams loadRangeParams, @NonNull final PositionalDataSource.LoadRangeCallback<B> loadRangeCallback) {
        this.mSource.loadRange(loadRangeParams, new PositionalDataSource.LoadRangeCallback<A>() {
            public void onResult(@NonNull List<A> list) {
                loadRangeCallback.onResult(DataSource.convert(WrapperPositionalDataSource.this.mListFunction, list));
            }
        });
    }
}
