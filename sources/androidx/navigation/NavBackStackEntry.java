package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.UUID;

public final class NavBackStackEntry implements LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner {
    private Bundle mArgs;
    private final Context mContext;
    private ViewModelProvider.Factory mDefaultFactory;
    private final NavDestination mDestination;
    private Lifecycle.State mHostLifecycle;
    @NonNull
    final UUID mId;
    private final LifecycleRegistry mLifecycle;
    private Lifecycle.State mMaxLifecycle;
    private NavControllerViewModel mNavControllerViewModel;
    private SavedStateHandle mSavedStateHandle;
    private final SavedStateRegistryController mSavedStateRegistryController;

    NavBackStackEntry(@NonNull Context context, @NonNull NavDestination navDestination, @Nullable Bundle bundle, @Nullable LifecycleOwner lifecycleOwner, @Nullable NavControllerViewModel navControllerViewModel) {
        this(context, navDestination, bundle, lifecycleOwner, navControllerViewModel, UUID.randomUUID(), (Bundle) null);
    }

    NavBackStackEntry(@NonNull Context context, @NonNull NavDestination navDestination, @Nullable Bundle bundle, @Nullable LifecycleOwner lifecycleOwner, @Nullable NavControllerViewModel navControllerViewModel, @NonNull UUID uuid, @Nullable Bundle bundle2) {
        this.mLifecycle = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = SavedStateRegistryController.create(this);
        this.mHostLifecycle = Lifecycle.State.CREATED;
        this.mMaxLifecycle = Lifecycle.State.RESUMED;
        this.mContext = context;
        this.mId = uuid;
        this.mDestination = navDestination;
        this.mArgs = bundle;
        this.mNavControllerViewModel = navControllerViewModel;
        this.mSavedStateRegistryController.performRestore(bundle2);
        if (lifecycleOwner != null) {
            this.mHostLifecycle = lifecycleOwner.getLifecycle().getCurrentState();
        }
    }

    @NonNull
    public NavDestination getDestination() {
        return this.mDestination;
    }

    @Nullable
    public Bundle getArguments() {
        return this.mArgs;
    }

    /* access modifiers changed from: package-private */
    public void replaceArguments(@Nullable Bundle bundle) {
        this.mArgs = bundle;
    }

    @NonNull
    public Lifecycle getLifecycle() {
        return this.mLifecycle;
    }

    /* access modifiers changed from: package-private */
    public void setMaxLifecycle(@NonNull Lifecycle.State state) {
        this.mMaxLifecycle = state;
        updateState();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Lifecycle.State getMaxLifecycle() {
        return this.mMaxLifecycle;
    }

    /* access modifiers changed from: package-private */
    public void handleLifecycleEvent(@NonNull Lifecycle.Event event) {
        this.mHostLifecycle = getStateAfter(event);
        updateState();
    }

    /* access modifiers changed from: package-private */
    public void updateState() {
        if (this.mHostLifecycle.ordinal() < this.mMaxLifecycle.ordinal()) {
            this.mLifecycle.setCurrentState(this.mHostLifecycle);
        } else {
            this.mLifecycle.setCurrentState(this.mMaxLifecycle);
        }
    }

    @NonNull
    public ViewModelStore getViewModelStore() {
        NavControllerViewModel navControllerViewModel = this.mNavControllerViewModel;
        if (navControllerViewModel != null) {
            return navControllerViewModel.getViewModelStore(this.mId);
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
    }

    @NonNull
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new SavedStateViewModelFactory((Application) this.mContext.getApplicationContext(), this, this.mArgs);
        }
        return this.mDefaultFactory;
    }

    @NonNull
    public SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    /* access modifiers changed from: package-private */
    public void saveState(@NonNull Bundle bundle) {
        this.mSavedStateRegistryController.performSave(bundle);
    }

    @NonNull
    public SavedStateHandle getSavedStateHandle() {
        if (this.mSavedStateHandle == null) {
            this.mSavedStateHandle = ((SavedStateViewModel) new ViewModelProvider((ViewModelStoreOwner) this, (ViewModelProvider.Factory) new NavResultSavedStateFactory(this, (Bundle) null)).get(SavedStateViewModel.class)).getHandle();
        }
        return this.mSavedStateHandle;
    }

    @NonNull
    private static Lifecycle.State getStateAfter(@NonNull Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
            case ON_STOP:
                return Lifecycle.State.CREATED;
            case ON_START:
            case ON_PAUSE:
                return Lifecycle.State.STARTED;
            case ON_RESUME:
                return Lifecycle.State.RESUMED;
            case ON_DESTROY:
                return Lifecycle.State.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + event);
        }
    }

    private static class NavResultSavedStateFactory extends AbstractSavedStateViewModelFactory {
        NavResultSavedStateFactory(@NonNull SavedStateRegistryOwner savedStateRegistryOwner, @Nullable Bundle bundle) {
            super(savedStateRegistryOwner, bundle);
        }

        /* access modifiers changed from: protected */
        @NonNull
        public <T extends ViewModel> T create(@NonNull String str, @NonNull Class<T> cls, @NonNull SavedStateHandle savedStateHandle) {
            return new SavedStateViewModel(savedStateHandle);
        }
    }

    private static class SavedStateViewModel extends ViewModel {
        private SavedStateHandle mHandle;

        SavedStateViewModel(SavedStateHandle savedStateHandle) {
            this.mHandle = savedStateHandle;
        }

        public SavedStateHandle getHandle() {
            return this.mHandle;
        }
    }
}
