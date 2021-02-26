package com.iaai.android.bdt.extensions;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000e"}, mo66933d2 = {"com/iaai/android/bdt/extensions/EditText_ExtensionKt$disableCopyPaste$1", "Landroid/view/ActionMode$Callback;", "onActionItemClicked", "", "mode", "Landroid/view/ActionMode;", "item", "Landroid/view/MenuItem;", "onCreateActionMode", "menu", "Landroid/view/Menu;", "onDestroyActionMode", "", "onPrepareActionMode", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: EditText+Extension.kt */
public final class EditText_ExtensionKt$disableCopyPaste$1 implements ActionMode.Callback {
    public boolean onActionItemClicked(@Nullable ActionMode actionMode, @Nullable MenuItem menuItem) {
        return false;
    }

    public boolean onCreateActionMode(@Nullable ActionMode actionMode, @Nullable Menu menu) {
        return false;
    }

    public void onDestroyActionMode(@Nullable ActionMode actionMode) {
    }

    public boolean onPrepareActionMode(@Nullable ActionMode actionMode, @Nullable Menu menu) {
        return false;
    }

    EditText_ExtensionKt$disableCopyPaste$1() {
    }
}
