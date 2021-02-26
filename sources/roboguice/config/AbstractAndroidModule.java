package roboguice.config;

import com.google.inject.AbstractModule;
import java.util.List;
import roboguice.inject.StaticTypeListener;

public abstract class AbstractAndroidModule extends AbstractModule {
    protected List<StaticTypeListener> listeners;

    /* access modifiers changed from: protected */
    public void requestStaticInjection(Class<?>... clsArr) {
        super.requestStaticInjection(clsArr);
        List<StaticTypeListener> list = this.listeners;
        if (list != null) {
            for (StaticTypeListener requestStaticInjection : list) {
                requestStaticInjection.requestStaticInjection(clsArr);
            }
        }
    }

    public void setStaticTypeListeners(List<StaticTypeListener> list) {
        this.listeners = list;
    }
}
