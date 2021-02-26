package p011io.reactivex.internal.operators.observable;

import p011io.reactivex.ObservableSource;
import p011io.reactivex.Observer;
import p011io.reactivex.annotations.Nullable;
import p011io.reactivex.functions.Function;
import p011io.reactivex.internal.functions.ObjectHelper;
import p011io.reactivex.internal.observers.BasicFuseableObserver;

/* renamed from: io.reactivex.internal.operators.observable.ObservableMap */
public final class ObservableMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    final Function<? super T, ? extends U> function;

    public ObservableMap(ObservableSource<T> observableSource, Function<? super T, ? extends U> function2) {
        super(observableSource);
        this.function = function2;
    }

    public void subscribeActual(Observer<? super U> observer) {
        this.source.subscribe(new MapObserver(observer, this.function));
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableMap$MapObserver */
    static final class MapObserver<T, U> extends BasicFuseableObserver<T, U> {
        final Function<? super T, ? extends U> mapper;

        MapObserver(Observer<? super U> observer, Function<? super T, ? extends U> function) {
            super(observer);
            this.mapper = function;
        }

        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 0) {
                    this.actual.onNext(null);
                    return;
                }
                try {
                    this.actual.onNext(ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper function returned a null value."));
                } catch (Throwable th) {
                    fail(th);
                }
            }
        }

        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }

        @Nullable
        public U poll() throws Exception {
            Object poll = this.f5001qs.poll();
            if (poll != null) {
                return ObjectHelper.requireNonNull(this.mapper.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }
}
