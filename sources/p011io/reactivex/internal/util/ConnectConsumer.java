package p011io.reactivex.internal.util;

import p011io.reactivex.disposables.Disposable;
import p011io.reactivex.functions.Consumer;

/* renamed from: io.reactivex.internal.util.ConnectConsumer */
public final class ConnectConsumer implements Consumer<Disposable> {
    public Disposable disposable;

    public void accept(Disposable disposable2) throws Exception {
        this.disposable = disposable2;
    }
}
