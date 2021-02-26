package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.Constructor;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000@\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0011\u0010\b\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0002\u001a\u0016\u0010\u000e\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0002\u001a\u001d\u0010\u000f\u001a\u00020\u0003*\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\b\u0013\u001a\u0014\u0010\u0014\u001a\u00020\u0010*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, mo66933d2 = {"MAX_DELAY", "", "Main", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Main$annotations", "()V", "choreographer", "Landroid/view/Choreographer;", "awaitFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postFrameCallback", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "updateChoreographerAndPostFrameCallback", "asCoroutineDispatcher", "Landroid/os/Handler;", "name", "", "from", "asHandler", "Landroid/os/Looper;", "async", "", "kotlinx-coroutines-android"}, mo66934k = 2, mo66935mv = {1, 1, 15})
/* compiled from: HandlerDispatcher.kt */
public final class HandlerDispatcherKt {
    private static final long MAX_DELAY = 4611686018427387903L;
    @Nullable
    @JvmField
    public static final HandlerDispatcher Main;
    private static volatile Choreographer choreographer;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use Dispatchers.Main instead")
    public static /* synthetic */ void Main$annotations() {
    }

    @NotNull
    @JvmOverloads
    @JvmName(name = "from")
    public static final HandlerDispatcher from(@NotNull Handler handler) {
        return from$default(handler, (String) null, 1, (Object) null);
    }

    public static /* synthetic */ HandlerDispatcher from$default(Handler handler, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return from(handler, str);
    }

    @NotNull
    @JvmOverloads
    @JvmName(name = "from")
    public static final HandlerDispatcher from(@NotNull Handler handler, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(handler, "$this$asCoroutineDispatcher");
        return new HandlerContext(handler, str);
    }

    @NotNull
    @VisibleForTesting
    public static final Handler asHandler(@NotNull Looper looper, boolean z) {
        Intrinsics.checkParameterIsNotNull(looper, "$this$asHandler");
        if (!z || Build.VERSION.SDK_INT < 16) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Object invoke = Handler.class.getDeclaredMethod("createAsync", new Class[]{Looper.class}).invoke((Object) null, new Object[]{looper});
            if (invoke != null) {
                return (Handler) invoke;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.os.Handler");
        }
        Class<Handler> cls = Handler.class;
        try {
            Constructor<Handler> declaredConstructor = cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE});
            Intrinsics.checkExpressionValueIsNotNull(declaredConstructor, "Handler::class.java.getD…:class.javaPrimitiveType)");
            Handler newInstance = declaredConstructor.newInstance(new Object[]{looper, null, true});
            Intrinsics.checkExpressionValueIsNotNull(newInstance, "constructor.newInstance(this, null, true)");
            return newInstance;
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }

    static {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Looper mainLooper = Looper.getMainLooper();
            Intrinsics.checkExpressionValueIsNotNull(mainLooper, "Looper.getMainLooper()");
            obj = Result.m4853constructorimpl(new HandlerContext(asHandler(mainLooper, true), "Main"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4853constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m4859isFailureimpl(obj)) {
            obj = null;
        }
        Main = (HandlerDispatcher) obj;
    }

    @Nullable
    public static final Object awaitFrame(@NotNull Continuation<? super Long> continuation) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 != null) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            postFrameCallback(choreographer2, cancellableContinuationImpl);
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        Dispatchers.getMain().dispatch(EmptyCoroutineContext.INSTANCE, new HandlerDispatcherKt$$special$$inlined$Runnable$1(cancellableContinuationImpl2));
        Object result2 = cancellableContinuationImpl2.getResult();
        if (result2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result2;
    }

    /* access modifiers changed from: private */
    public static final void updateChoreographerAndPostFrameCallback(CancellableContinuation<? super Long> cancellableContinuation) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            choreographer2 = Choreographer.getInstance();
            if (choreographer2 == null) {
                Intrinsics.throwNpe();
            }
            choreographer = choreographer2;
        }
        postFrameCallback(choreographer2, cancellableContinuation);
    }

    /* access modifiers changed from: private */
    public static final void postFrameCallback(Choreographer choreographer2, CancellableContinuation<? super Long> cancellableContinuation) {
        choreographer2.postFrameCallback(new HandlerDispatcherKt$postFrameCallback$1(cancellableContinuation));
    }
}
