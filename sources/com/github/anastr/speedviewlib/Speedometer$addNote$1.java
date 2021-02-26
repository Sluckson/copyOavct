package com.github.anastr.speedviewlib;

import com.github.anastr.speedviewlib.components.note.Note;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo66933d2 = {"<anonymous>", "", "run"}, mo66934k = 3, mo66935mv = {1, 1, 16})
/* compiled from: Speedometer.kt */
final class Speedometer$addNote$1 implements Runnable {
    final /* synthetic */ Note $note;
    final /* synthetic */ Speedometer this$0;

    Speedometer$addNote$1(Speedometer speedometer, Note note) {
        this.this$0 = speedometer;
        this.$note = note;
    }

    public final void run() {
        if (this.this$0.isAttachedToWindow()) {
            this.this$0.notes.remove(this.$note);
            this.this$0.postInvalidate();
        }
    }
}
