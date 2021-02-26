package androidx.navigation.p005ui;

import android.annotation.SuppressLint;
import android.view.Menu;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.customview.widget.Openable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavGraph;
import java.util.HashSet;
import java.util.Set;

/* renamed from: androidx.navigation.ui.AppBarConfiguration */
public final class AppBarConfiguration {
    @Nullable
    private final OnNavigateUpListener mFallbackOnNavigateUpListener;
    @Nullable
    private final Openable mOpenableLayout;
    @NonNull
    private final Set<Integer> mTopLevelDestinations;

    /* renamed from: androidx.navigation.ui.AppBarConfiguration$OnNavigateUpListener */
    public interface OnNavigateUpListener {
        boolean onNavigateUp();
    }

    private AppBarConfiguration(@NonNull Set<Integer> set, @Nullable Openable openable, @Nullable OnNavigateUpListener onNavigateUpListener) {
        this.mTopLevelDestinations = set;
        this.mOpenableLayout = openable;
        this.mFallbackOnNavigateUpListener = onNavigateUpListener;
    }

    @NonNull
    public Set<Integer> getTopLevelDestinations() {
        return this.mTopLevelDestinations;
    }

    @Nullable
    public Openable getOpenableLayout() {
        return this.mOpenableLayout;
    }

    @Deprecated
    @Nullable
    public DrawerLayout getDrawerLayout() {
        Openable openable = this.mOpenableLayout;
        if (openable instanceof DrawerLayout) {
            return (DrawerLayout) openable;
        }
        return null;
    }

    @Nullable
    public OnNavigateUpListener getFallbackOnNavigateUpListener() {
        return this.mFallbackOnNavigateUpListener;
    }

    /* renamed from: androidx.navigation.ui.AppBarConfiguration$Builder */
    public static final class Builder {
        @Nullable
        private OnNavigateUpListener mFallbackOnNavigateUpListener;
        @Nullable
        private Openable mOpenableLayout;
        @NonNull
        private final Set<Integer> mTopLevelDestinations = new HashSet();

        public Builder(@NonNull NavGraph navGraph) {
            this.mTopLevelDestinations.add(Integer.valueOf(NavigationUI.findStartDestination(navGraph).getId()));
        }

        public Builder(@NonNull Menu menu) {
            int size = menu.size();
            for (int i = 0; i < size; i++) {
                this.mTopLevelDestinations.add(Integer.valueOf(menu.getItem(i).getItemId()));
            }
        }

        public Builder(@NonNull int... iArr) {
            for (int valueOf : iArr) {
                this.mTopLevelDestinations.add(Integer.valueOf(valueOf));
            }
        }

        public Builder(@NonNull Set<Integer> set) {
            this.mTopLevelDestinations.addAll(set);
        }

        @NonNull
        @Deprecated
        public Builder setDrawerLayout(@Nullable DrawerLayout drawerLayout) {
            this.mOpenableLayout = drawerLayout;
            return this;
        }

        @NonNull
        public Builder setOpenableLayout(@Nullable Openable openable) {
            this.mOpenableLayout = openable;
            return this;
        }

        @NonNull
        public Builder setFallbackOnNavigateUpListener(@Nullable OnNavigateUpListener onNavigateUpListener) {
            this.mFallbackOnNavigateUpListener = onNavigateUpListener;
            return this;
        }

        @SuppressLint({"SyntheticAccessor"})
        @NonNull
        public AppBarConfiguration build() {
            return new AppBarConfiguration(this.mTopLevelDestinations, this.mOpenableLayout, this.mFallbackOnNavigateUpListener);
        }
    }
}
