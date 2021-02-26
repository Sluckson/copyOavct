package com.iaai.android.old.fragments;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;

public abstract class AbstractFragment extends Fragment {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void onStart() {
        super.onStart();
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        super.onStop();
    }
}
