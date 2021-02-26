package p011io.opencensus.stats;

import java.util.Set;
import javax.annotation.Nullable;
import p011io.opencensus.stats.View;

/* renamed from: io.opencensus.stats.ViewManager */
public abstract class ViewManager {
    public abstract Set<View> getAllExportedViews();

    @Nullable
    public abstract ViewData getView(View.Name name);

    public abstract void registerView(View view);
}
