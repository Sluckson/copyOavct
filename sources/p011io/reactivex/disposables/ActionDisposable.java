package p011io.reactivex.disposables;

import p011io.reactivex.annotations.NonNull;
import p011io.reactivex.functions.Action;
import p011io.reactivex.internal.util.ExceptionHelper;

/* renamed from: io.reactivex.disposables.ActionDisposable */
final class ActionDisposable extends ReferenceDisposable<Action> {
    private static final long serialVersionUID = -8219729196779211169L;

    ActionDisposable(Action action) {
        super(action);
    }

    /* access modifiers changed from: protected */
    public void onDisposed(@NonNull Action action) {
        try {
            action.run();
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }
}
