package p011io.reactivex.internal.schedulers;

import p011io.reactivex.Scheduler;
import p011io.reactivex.annotations.Experimental;
import p011io.reactivex.annotations.NonNull;

@Experimental
/* renamed from: io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport */
public interface SchedulerMultiWorkerSupport {

    /* renamed from: io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport$WorkerCallback */
    public interface WorkerCallback {
        void onWorker(int i, @NonNull Scheduler.Worker worker);
    }

    void createWorkers(int i, @NonNull WorkerCallback workerCallback);
}
