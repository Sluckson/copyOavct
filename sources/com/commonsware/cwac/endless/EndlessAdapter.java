package com.commonsware.cwac.endless;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.commonsware.cwac.adapter.AdapterWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class EndlessAdapter extends AdapterWrapper {
    private Context context;
    private boolean isSerialized = false;
    private AtomicBoolean keepOnAppending = new AtomicBoolean(true);
    private int pendingResource = -1;
    /* access modifiers changed from: private */
    public View pendingView = null;
    private boolean runInBackground = true;

    /* access modifiers changed from: protected */
    public abstract void appendCachedData();

    public boolean areAllItemsEnabled() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean cacheInBackground() throws Exception;

    public EndlessAdapter(ListAdapter listAdapter) {
        super(listAdapter);
    }

    public EndlessAdapter(ListAdapter listAdapter, boolean z) {
        super(listAdapter);
        setKeepOnAppending(z);
    }

    public EndlessAdapter(Context context2, ListAdapter listAdapter, int i) {
        super(listAdapter);
        this.context = context2;
        this.pendingResource = i;
    }

    public EndlessAdapter(Context context2, ListAdapter listAdapter, int i, boolean z) {
        super(listAdapter);
        this.context = context2;
        this.pendingResource = i;
        setKeepOnAppending(z);
    }

    public boolean isSerialized() {
        return this.isSerialized;
    }

    public void setSerialized(boolean z) {
        this.isSerialized = z;
    }

    public void stopAppending() {
        setKeepOnAppending(false);
    }

    public void restartAppending() {
        setKeepOnAppending(true);
    }

    public void setRunInBackground(boolean z) {
        this.runInBackground = z;
    }

    public void onDataReady() {
        this.pendingView = null;
        notifyDataSetChanged();
    }

    public int getCount() {
        if (this.keepOnAppending.get()) {
            return super.getCount() + 1;
        }
        return super.getCount();
    }

    public int getItemViewType(int i) {
        if (i == getWrappedAdapter().getCount()) {
            return -1;
        }
        return super.getItemViewType(i);
    }

    public int getViewTypeCount() {
        return super.getViewTypeCount() + 1;
    }

    public Object getItem(int i) {
        if (i >= super.getCount()) {
            return null;
        }
        return super.getItem(i);
    }

    public boolean isEnabled(int i) {
        if (i >= super.getCount()) {
            return false;
        }
        return super.isEnabled(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (i != super.getCount() || !this.keepOnAppending.get()) {
            return super.getView(i, view, viewGroup);
        }
        if (this.pendingView == null) {
            this.pendingView = getPendingView(viewGroup);
            if (this.runInBackground) {
                executeAsyncTask(buildTask(), new Void[0]);
            } else {
                try {
                    setKeepOnAppending(cacheInBackground());
                } catch (Exception e) {
                    setKeepOnAppending(onException(this.pendingView, e));
                }
            }
        }
        return this.pendingView;
    }

    /* access modifiers changed from: protected */
    public boolean onException(View view, Exception exc) {
        Log.e("EndlessAdapter", "Exception in cacheInBackground()", exc);
        return false;
    }

    /* access modifiers changed from: protected */
    public AppendTask buildTask() {
        return new AppendTask(this);
    }

    @TargetApi(11)
    private <T> void executeAsyncTask(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        if (this.isSerialized || Build.VERSION.SDK_INT < 11) {
            asyncTask.execute(tArr);
        } else {
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
        }
    }

    /* access modifiers changed from: private */
    public void setKeepOnAppending(boolean z) {
        boolean z2 = z == this.keepOnAppending.get();
        this.keepOnAppending.set(z);
        if (!z2) {
            notifyDataSetChanged();
        }
    }

    protected static class AppendTask extends AsyncTask<Void, Void, Exception> {
        EndlessAdapter adapter = null;
        boolean tempKeep;

        protected AppendTask(EndlessAdapter endlessAdapter) {
            this.adapter = endlessAdapter;
        }

        /* access modifiers changed from: protected */
        public Exception doInBackground(Void... voidArr) {
            try {
                this.tempKeep = this.adapter.cacheInBackground();
                return null;
            } catch (Exception e) {
                return e;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Exception exc) {
            this.adapter.setKeepOnAppending(this.tempKeep);
            if (exc == null) {
                this.adapter.appendCachedData();
            } else {
                EndlessAdapter endlessAdapter = this.adapter;
                endlessAdapter.setKeepOnAppending(endlessAdapter.onException(endlessAdapter.pendingView, exc));
            }
            this.adapter.onDataReady();
        }
    }

    /* access modifiers changed from: protected */
    public View getPendingView(ViewGroup viewGroup) {
        Context context2 = this.context;
        if (context2 != null) {
            return ((LayoutInflater) context2.getSystemService("layout_inflater")).inflate(this.pendingResource, viewGroup, false);
        }
        throw new RuntimeException("You must either override getPendingView() or supply a pending View resource via the constructor");
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        return this.context;
    }
}
