package roboguice.activity.event;

import android.content.res.Configuration;

public class OnConfigurationChangedEvent {
    protected Configuration newConfig;
    protected Configuration oldConfig;

    public OnConfigurationChangedEvent(Configuration configuration, Configuration configuration2) {
        this.oldConfig = configuration;
        this.newConfig = configuration2;
    }

    public Configuration getOldConfig() {
        return this.oldConfig;
    }

    public Configuration getNewConfig() {
        return this.newConfig;
    }
}
