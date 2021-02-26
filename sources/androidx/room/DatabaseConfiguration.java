package androidx.room;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.sqlite.p006db.SupportSQLiteOpenHelper;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public class DatabaseConfiguration {
    public final boolean allowMainThreadQueries;
    @Nullable
    public final List<RoomDatabase.Callback> callbacks;
    @NonNull
    public final Context context;
    public final RoomDatabase.JournalMode journalMode;
    private final Set<Integer> mMigrationNotRequiredFrom;
    @NonNull
    public final RoomDatabase.MigrationContainer migrationContainer;
    @Nullable
    public final String name;
    @NonNull
    public final Executor queryExecutor;
    public final boolean requireMigration;
    @NonNull
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public DatabaseConfiguration(@NonNull Context context2, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer2, @Nullable List<RoomDatabase.Callback> list, boolean z, RoomDatabase.JournalMode journalMode2, @NonNull Executor executor, boolean z2, @Nullable Set<Integer> set) {
        this.sqliteOpenHelperFactory = factory;
        this.context = context2;
        this.name = str;
        this.migrationContainer = migrationContainer2;
        this.callbacks = list;
        this.allowMainThreadQueries = z;
        this.journalMode = journalMode2;
        this.queryExecutor = executor;
        this.requireMigration = z2;
        this.mMigrationNotRequiredFrom = set;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.mMigrationNotRequiredFrom;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isMigrationRequiredFrom(int r2) {
        /*
            r1 = this;
            boolean r0 = r1.requireMigration
            if (r0 == 0) goto L_0x0014
            java.util.Set<java.lang.Integer> r0 = r1.mMigrationNotRequiredFrom
            if (r0 == 0) goto L_0x0012
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            boolean r2 = r0.contains(r2)
            if (r2 != 0) goto L_0x0014
        L_0x0012:
            r2 = 1
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.isMigrationRequiredFrom(int):boolean");
    }
}
