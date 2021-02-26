package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigator;

@Navigator.Name("navigation")
public class NavGraphNavigator extends Navigator<NavGraph> {
    private final NavigatorProvider mNavigatorProvider;

    public boolean popBackStack() {
        return true;
    }

    public NavGraphNavigator(@NonNull NavigatorProvider navigatorProvider) {
        this.mNavigatorProvider = navigatorProvider;
    }

    @NonNull
    public NavGraph createDestination() {
        return new NavGraph(this);
    }

    @Nullable
    public NavDestination navigate(@NonNull NavGraph navGraph, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        int startDestination = navGraph.getStartDestination();
        if (startDestination != 0) {
            NavDestination findNode = navGraph.findNode(startDestination, false);
            if (findNode != null) {
                return this.mNavigatorProvider.getNavigator(findNode.getNavigatorName()).navigate(findNode, findNode.addInDefaultArgs(bundle), navOptions, extras);
            }
            String startDestDisplayName = navGraph.getStartDestDisplayName();
            throw new IllegalArgumentException("navigation destination " + startDestDisplayName + " is not a direct child of this NavGraph");
        }
        throw new IllegalStateException("no start destination defined via app:startDestination for " + navGraph.getDisplayName());
    }
}
