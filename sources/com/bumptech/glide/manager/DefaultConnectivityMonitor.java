package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.Preconditions;

final class DefaultConnectivityMonitor implements ConnectivityMonitor {
    private static final String TAG = "ConnectivityMonitor";
    private final BroadcastReceiver connectivityReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            boolean z = DefaultConnectivityMonitor.this.isConnected;
            try {
                DefaultConnectivityMonitor.this.isConnected = DefaultConnectivityMonitor.this.isConnected(context);
            } catch (SecurityException e) {
                if (Log.isLoggable(DefaultConnectivityMonitor.TAG, 5)) {
                    Log.w(DefaultConnectivityMonitor.TAG, "Failed to determine connectivity status when connectivity changed", e);
                }
                DefaultConnectivityMonitor.this.isConnected = true;
            }
            if (z != DefaultConnectivityMonitor.this.isConnected) {
                if (Log.isLoggable(DefaultConnectivityMonitor.TAG, 3)) {
                    Log.d(DefaultConnectivityMonitor.TAG, "connectivity changed, isConnected: " + DefaultConnectivityMonitor.this.isConnected);
                }
                DefaultConnectivityMonitor.this.listener.onConnectivityChanged(DefaultConnectivityMonitor.this.isConnected);
            }
        }
    };
    private final Context context;
    boolean isConnected;
    private boolean isRegistered;
    final ConnectivityMonitor.ConnectivityListener listener;

    public void onDestroy() {
    }

    DefaultConnectivityMonitor(Context context2, ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.context = context2.getApplicationContext();
        this.listener = connectivityListener;
    }

    private void register() {
        if (!this.isRegistered) {
            try {
                this.isConnected = isConnected(this.context);
                this.context.registerReceiver(this.connectivityReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.isRegistered = true;
            } catch (SecurityException e) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Failed to register", e);
                }
            }
        }
    }

    private void unregister() {
        if (this.isRegistered) {
            this.context.unregisterReceiver(this.connectivityReceiver);
            this.isRegistered = false;
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    public boolean isConnected(Context context2) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) Preconditions.checkNotNull((ConnectivityManager) context2.getSystemService("connectivity"))).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void onStart() {
        register();
    }

    public void onStop() {
        unregister();
    }
}
