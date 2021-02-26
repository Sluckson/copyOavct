package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class FragmentTransaction {
    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SET_MAX_LIFECYCLE = 10;
    static final int OP_SET_PRIMARY_NAV = 8;
    static final int OP_SHOW = 5;
    static final int OP_UNSET_PRIMARY_NAV = 9;
    public static final int TRANSIT_ENTER_MASK = 4096;
    public static final int TRANSIT_EXIT_MASK = 8192;
    public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
    public static final int TRANSIT_FRAGMENT_FADE = 4099;
    public static final int TRANSIT_FRAGMENT_OPEN = 4097;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_UNSET = -1;
    boolean mAddToBackStack;
    boolean mAllowAddToBackStack;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    private final ClassLoader mClassLoader;
    ArrayList<Runnable> mCommitRunnables;
    int mEnterAnim;
    int mExitAnim;
    private final FragmentFactory mFragmentFactory;
    @Nullable
    String mName;
    ArrayList<C0412Op> mOps;
    int mPopEnterAnim;
    int mPopExitAnim;
    boolean mReorderingAllowed;
    ArrayList<String> mSharedElementSourceNames;
    ArrayList<String> mSharedElementTargetNames;
    int mTransition;

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract void commitNow();

    public abstract void commitNowAllowingStateLoss();

    @NonNull
    @Deprecated
    public FragmentTransaction setTransitionStyle(@StyleRes int i) {
        return this;
    }

    /* renamed from: androidx.fragment.app.FragmentTransaction$Op */
    static final class C0412Op {
        int mCmd;
        Lifecycle.State mCurrentMaxState;
        int mEnterAnim;
        int mExitAnim;
        Fragment mFragment;
        Lifecycle.State mOldMaxState;
        int mPopEnterAnim;
        int mPopExitAnim;

        C0412Op() {
        }

        C0412Op(int i, Fragment fragment) {
            this.mCmd = i;
            this.mFragment = fragment;
            this.mOldMaxState = Lifecycle.State.RESUMED;
            this.mCurrentMaxState = Lifecycle.State.RESUMED;
        }

        C0412Op(int i, @NonNull Fragment fragment, Lifecycle.State state) {
            this.mCmd = i;
            this.mFragment = fragment;
            this.mOldMaxState = fragment.mMaxState;
            this.mCurrentMaxState = state;
        }
    }

    @Deprecated
    public FragmentTransaction() {
        this.mOps = new ArrayList<>();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = null;
        this.mClassLoader = null;
    }

    FragmentTransaction(@NonNull FragmentFactory fragmentFactory, @Nullable ClassLoader classLoader) {
        this.mOps = new ArrayList<>();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = fragmentFactory;
        this.mClassLoader = classLoader;
    }

    /* access modifiers changed from: package-private */
    public void addOp(C0412Op op) {
        this.mOps.add(op);
        op.mEnterAnim = this.mEnterAnim;
        op.mExitAnim = this.mExitAnim;
        op.mPopEnterAnim = this.mPopEnterAnim;
        op.mPopExitAnim = this.mPopExitAnim;
    }

    @NonNull
    private Fragment createFragment(@NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle) {
        FragmentFactory fragmentFactory = this.mFragmentFactory;
        if (fragmentFactory != null) {
            ClassLoader classLoader = this.mClassLoader;
            if (classLoader != null) {
                Fragment instantiate = fragmentFactory.instantiate(classLoader, cls.getName());
                if (bundle != null) {
                    instantiate.setArguments(bundle);
                }
                return instantiate;
            }
            throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
        }
        throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
    }

    @NonNull
    public final FragmentTransaction add(@NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle, @Nullable String str) {
        return add(createFragment(cls, bundle), str);
    }

    @NonNull
    public FragmentTransaction add(@NonNull Fragment fragment, @Nullable String str) {
        doAddOp(0, fragment, str, 1);
        return this;
    }

    @NonNull
    public final FragmentTransaction add(@IdRes int i, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle) {
        return add(i, createFragment(cls, bundle));
    }

    @NonNull
    public FragmentTransaction add(@IdRes int i, @NonNull Fragment fragment) {
        doAddOp(i, fragment, (String) null, 1);
        return this;
    }

    @NonNull
    public final FragmentTransaction add(@IdRes int i, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle, @Nullable String str) {
        return add(i, createFragment(cls, bundle), str);
    }

    @NonNull
    public FragmentTransaction add(@IdRes int i, @NonNull Fragment fragment, @Nullable String str) {
        doAddOp(i, fragment, str, 1);
        return this;
    }

    /* access modifiers changed from: package-private */
    public FragmentTransaction add(@NonNull ViewGroup viewGroup, @NonNull Fragment fragment, @Nullable String str) {
        fragment.mContainer = viewGroup;
        return add(viewGroup.getId(), fragment, str);
    }

    /* access modifiers changed from: package-private */
    public void doAddOp(int i, Fragment fragment, @Nullable String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            if (fragment.mTag == null || str.equals(fragment.mTag)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            } else if (fragment.mFragmentId == 0 || fragment.mFragmentId == i) {
                fragment.mFragmentId = i;
                fragment.mContainerId = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
        }
        addOp(new C0412Op(i2, fragment));
    }

    @NonNull
    public final FragmentTransaction replace(@IdRes int i, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle) {
        return replace(i, cls, bundle, (String) null);
    }

    @NonNull
    public FragmentTransaction replace(@IdRes int i, @NonNull Fragment fragment) {
        return replace(i, fragment, (String) null);
    }

    @NonNull
    public final FragmentTransaction replace(@IdRes int i, @NonNull Class<? extends Fragment> cls, @Nullable Bundle bundle, @Nullable String str) {
        return replace(i, createFragment(cls, bundle), str);
    }

    @NonNull
    public FragmentTransaction replace(@IdRes int i, @NonNull Fragment fragment, @Nullable String str) {
        if (i != 0) {
            doAddOp(i, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    @NonNull
    public FragmentTransaction remove(@NonNull Fragment fragment) {
        addOp(new C0412Op(3, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction hide(@NonNull Fragment fragment) {
        addOp(new C0412Op(4, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction show(@NonNull Fragment fragment) {
        addOp(new C0412Op(5, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction detach(@NonNull Fragment fragment) {
        addOp(new C0412Op(6, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction attach(@NonNull Fragment fragment) {
        addOp(new C0412Op(7, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        addOp(new C0412Op(8, fragment));
        return this;
    }

    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        addOp(new C0412Op(10, fragment, state));
        return this;
    }

    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    @NonNull
    public FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int i, @AnimRes @AnimatorRes int i2) {
        return setCustomAnimations(i, i2, 0, 0);
    }

    @NonNull
    public FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int i, @AnimRes @AnimatorRes int i2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4) {
        this.mEnterAnim = i;
        this.mExitAnim = i2;
        this.mPopEnterAnim = i3;
        this.mPopExitAnim = i4;
        return this;
    }

    @NonNull
    public FragmentTransaction addSharedElement(@NonNull View view, @NonNull String str) {
        if (FragmentTransition.supportsTransition()) {
            String transitionName = ViewCompat.getTransitionName(view);
            if (transitionName != null) {
                if (this.mSharedElementSourceNames == null) {
                    this.mSharedElementSourceNames = new ArrayList<>();
                    this.mSharedElementTargetNames = new ArrayList<>();
                } else if (this.mSharedElementTargetNames.contains(str)) {
                    throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
                } else if (this.mSharedElementSourceNames.contains(transitionName)) {
                    throw new IllegalArgumentException("A shared element with the source name '" + transitionName + "' has already been added to the transaction.");
                }
                this.mSharedElementSourceNames.add(transitionName);
                this.mSharedElementTargetNames.add(str);
            } else {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
        }
        return this;
    }

    @NonNull
    public FragmentTransaction setTransition(int i) {
        this.mTransition = i;
        return this;
    }

    @NonNull
    public FragmentTransaction addToBackStack(@Nullable String str) {
        if (this.mAllowAddToBackStack) {
            this.mAddToBackStack = true;
            this.mName = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }

    @NonNull
    public FragmentTransaction disallowAddToBackStack() {
        if (!this.mAddToBackStack) {
            this.mAllowAddToBackStack = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(@StringRes int i) {
        this.mBreadCrumbTitleRes = i;
        this.mBreadCrumbTitleText = null;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(@Nullable CharSequence charSequence) {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = charSequence;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(@StringRes int i) {
        this.mBreadCrumbShortTitleRes = i;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(@Nullable CharSequence charSequence) {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = charSequence;
        return this;
    }

    @NonNull
    public FragmentTransaction setReorderingAllowed(boolean z) {
        this.mReorderingAllowed = z;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setAllowOptimization(boolean z) {
        return setReorderingAllowed(z);
    }

    @NonNull
    public FragmentTransaction runOnCommit(@NonNull Runnable runnable) {
        disallowAddToBackStack();
        if (this.mCommitRunnables == null) {
            this.mCommitRunnables = new ArrayList<>();
        }
        this.mCommitRunnables.add(runnable);
        return this;
    }
}
