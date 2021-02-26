package com.iaai.android.bdt.model.findvehicles;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/findvehicles/LoggedUserMenu;", "", "menuIcon", "", "menuTitle", "", "menuCount", "(ILjava/lang/String;I)V", "getMenuCount", "()I", "getMenuIcon", "getMenuTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: LoggedUserMenu.kt */
public final class LoggedUserMenu {
    private final int menuCount;
    private final int menuIcon;
    @NotNull
    private final String menuTitle;

    @NotNull
    public static /* synthetic */ LoggedUserMenu copy$default(LoggedUserMenu loggedUserMenu, int i, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = loggedUserMenu.menuIcon;
        }
        if ((i3 & 2) != 0) {
            str = loggedUserMenu.menuTitle;
        }
        if ((i3 & 4) != 0) {
            i2 = loggedUserMenu.menuCount;
        }
        return loggedUserMenu.copy(i, str, i2);
    }

    public final int component1() {
        return this.menuIcon;
    }

    @NotNull
    public final String component2() {
        return this.menuTitle;
    }

    public final int component3() {
        return this.menuCount;
    }

    @NotNull
    public final LoggedUserMenu copy(int i, @NotNull String str, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "menuTitle");
        return new LoggedUserMenu(i, str, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof LoggedUserMenu) {
                LoggedUserMenu loggedUserMenu = (LoggedUserMenu) obj;
                if ((this.menuIcon == loggedUserMenu.menuIcon) && Intrinsics.areEqual((Object) this.menuTitle, (Object) loggedUserMenu.menuTitle)) {
                    if (this.menuCount == loggedUserMenu.menuCount) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = Integer.valueOf(this.menuIcon).hashCode() * 31;
        String str = this.menuTitle;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + Integer.valueOf(this.menuCount).hashCode();
    }

    @NotNull
    public String toString() {
        return "LoggedUserMenu(menuIcon=" + this.menuIcon + ", menuTitle=" + this.menuTitle + ", menuCount=" + this.menuCount + ")";
    }

    public LoggedUserMenu(int i, @NotNull String str, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "menuTitle");
        this.menuIcon = i;
        this.menuTitle = str;
        this.menuCount = i2;
    }

    public final int getMenuIcon() {
        return this.menuIcon;
    }

    @NotNull
    public final String getMenuTitle() {
        return this.menuTitle;
    }

    public final int getMenuCount() {
        return this.menuCount;
    }
}
