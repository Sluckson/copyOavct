package roboguice.inject;

import android.content.res.Resources;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class StringResourceFactory implements ResourceFactory<String> {
    protected Resources resources;

    @Inject
    public StringResourceFactory(Resources resources2) {
        this.resources = resources2;
    }

    public String get(int i) {
        return this.resources.getString(i);
    }
}
