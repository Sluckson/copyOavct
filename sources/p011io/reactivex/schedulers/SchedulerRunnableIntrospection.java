package p011io.reactivex.schedulers;

import p011io.reactivex.annotations.Experimental;
import p011io.reactivex.annotations.NonNull;

@Experimental
/* renamed from: io.reactivex.schedulers.SchedulerRunnableIntrospection */
public interface SchedulerRunnableIntrospection {
    @NonNull
    Runnable getWrappedRunnable();
}
