package com.salesforce.marketingcloud;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.app.job.JobWorkItem;
import android.content.Context;
import android.os.AsyncTask;

@SuppressLint({"UnknownNullness"})
@TargetApi(26)
public class MCJobService extends JobService {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f2145b = C4039h.m2810a((Class<?>) MCJobService.class);

    /* renamed from: a */
    C3833a f2146a;

    /* renamed from: com.salesforce.marketingcloud.MCJobService$a */
    static class C3833a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a */
        private final Context f2147a;

        /* renamed from: b */
        private final JobParameters f2148b;

        C3833a(Context context, JobParameters jobParameters) {
            this.f2147a = context;
            this.f2148b = jobParameters;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final Void doInBackground(Void... voidArr) {
            JobWorkItem dequeueWork;
            while (!isCancelled() && (dequeueWork = this.f2148b.dequeueWork()) != null) {
                try {
                    C4040i.m2831a(this.f2147a.getApplicationContext(), dequeueWork.getIntent());
                    this.f2148b.completeWork(dequeueWork);
                } catch (Exception e) {
                    C4039h.m2830e(MCJobService.f2145b, e, "doInBackground threw exception", new Object[0]);
                    return null;
                }
            }
            return null;
        }
    }

    public boolean onStartJob(JobParameters jobParameters) {
        C4039h.m2820b(f2145b, "onStartJob %d", Integer.valueOf(jobParameters.getJobId()));
        this.f2146a = new C3833a(this, jobParameters);
        this.f2146a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        C4039h.m2820b(f2145b, "onStopJob %d", Integer.valueOf(jobParameters.getJobId()));
        C3833a aVar = this.f2146a;
        if (aVar != null) {
            aVar.cancel(true);
            this.f2146a = null;
        }
        return false;
    }
}
