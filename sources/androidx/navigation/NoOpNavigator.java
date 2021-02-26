package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.navigation.Navigator;

@Navigator.Name("NoOp")
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NoOpNavigator extends Navigator<NavDestination> {
    @Nullable
    public NavDestination navigate(@NonNull NavDestination navDestination, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        return navDestination;
    }

    public boolean popBackStack() {
        return true;
    }

    @NonNull
    public NavDestination createDestination() {
        return new NavDestination((Navigator<? extends NavDestination>) this);
    }
}
