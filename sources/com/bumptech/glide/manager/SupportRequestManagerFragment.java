package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SupportRequestManagerFragment extends Fragment {
    private static final String TAG = "SupportRMFragment";
    private final HashSet<SupportRequestManagerFragment> childRequestManagerFragments;
    private final ActivityFragmentLifecycle lifecycle;
    @Nullable
    private Fragment parentFragmentHint;
    @Nullable
    private RequestManager requestManager;
    private final RequestManagerTreeNode requestManagerTreeNode;
    @Nullable
    private SupportRequestManagerFragment rootRequestManagerFragment;

    public SupportRequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    @SuppressLint({"ValidFragment"})
    public SupportRequestManagerFragment(ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.requestManagerTreeNode = new SupportFragmentRequestManagerTreeNode();
        this.childRequestManagerFragments = new HashSet<>();
        this.lifecycle = activityFragmentLifecycle;
    }

    public void setRequestManager(@Nullable RequestManager requestManager2) {
        this.requestManager = requestManager2;
    }

    /* access modifiers changed from: package-private */
    public ActivityFragmentLifecycle getGlideLifecycle() {
        return this.lifecycle;
    }

    @Nullable
    public RequestManager getRequestManager() {
        return this.requestManager;
    }

    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.requestManagerTreeNode;
    }

    private void addChildRequestManagerFragment(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.childRequestManagerFragments.add(supportRequestManagerFragment);
    }

    private void removeChildRequestManagerFragment(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.childRequestManagerFragments.remove(supportRequestManagerFragment);
    }

    /* access modifiers changed from: private */
    public Set<SupportRequestManagerFragment> getDescendantRequestManagerFragments() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.rootRequestManagerFragment;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (supportRequestManagerFragment == this) {
            return Collections.unmodifiableSet(this.childRequestManagerFragments);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment next : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
            if (isDescendant(next.getParentFragmentUsingHint())) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* access modifiers changed from: package-private */
    public void setParentFragmentHint(@Nullable Fragment fragment) {
        this.parentFragmentHint = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            registerFragmentWithRoot(fragment.getActivity());
        }
    }

    private Fragment getParentFragmentUsingHint() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.parentFragmentHint;
    }

    private boolean isDescendant(Fragment fragment) {
        Fragment parentFragmentUsingHint = getParentFragmentUsingHint();
        while (fragment.getParentFragment() != null) {
            if (fragment.getParentFragment() == parentFragmentUsingHint) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
        return false;
    }

    private void registerFragmentWithRoot(FragmentActivity fragmentActivity) {
        unregisterFragmentWithRoot();
        this.rootRequestManagerFragment = Glide.get(fragmentActivity).getRequestManagerRetriever().getSupportRequestManagerFragment(fragmentActivity.getSupportFragmentManager(), (Fragment) null);
        SupportRequestManagerFragment supportRequestManagerFragment = this.rootRequestManagerFragment;
        if (supportRequestManagerFragment != this) {
            supportRequestManagerFragment.addChildRequestManagerFragment(this);
        }
    }

    private void unregisterFragmentWithRoot() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.rootRequestManagerFragment;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.removeChildRequestManagerFragment(this);
            this.rootRequestManagerFragment = null;
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            registerFragmentWithRoot(getActivity());
        } catch (IllegalStateException e) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Unable to register fragment with root", e);
            }
        }
    }

    public void onDetach() {
        super.onDetach();
        this.parentFragmentHint = null;
        unregisterFragmentWithRoot();
    }

    public void onStart() {
        super.onStart();
        this.lifecycle.onStart();
    }

    public void onStop() {
        super.onStop();
        this.lifecycle.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
        this.lifecycle.onDestroy();
        unregisterFragmentWithRoot();
    }

    public String toString() {
        return super.toString() + "{parent=" + getParentFragmentUsingHint() + "}";
    }

    private class SupportFragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        SupportFragmentRequestManagerTreeNode() {
        }

        public Set<RequestManager> getDescendants() {
            Set<SupportRequestManagerFragment> access$000 = SupportRequestManagerFragment.this.getDescendantRequestManagerFragments();
            HashSet hashSet = new HashSet(access$000.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : access$000) {
                if (supportRequestManagerFragment.getRequestManager() != null) {
                    hashSet.add(supportRequestManagerFragment.getRequestManager());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }
}
