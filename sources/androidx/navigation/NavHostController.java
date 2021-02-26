package androidx.navigation;

import android.content.Context;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;

public class NavHostController extends NavController {
    public NavHostController(@NonNull Context context) {
        super(context);
    }

    public final void setLifecycleOwner(@NonNull LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
    }

    public final void setOnBackPressedDispatcher(@NonNull OnBackPressedDispatcher onBackPressedDispatcher) {
        super.setOnBackPressedDispatcher(onBackPressedDispatcher);
    }

    public final void enableOnBackPressed(boolean z) {
        super.enableOnBackPressed(z);
    }

    public final void setViewModelStore(@NonNull ViewModelStore viewModelStore) {
        super.setViewModelStore(viewModelStore);
    }
}
