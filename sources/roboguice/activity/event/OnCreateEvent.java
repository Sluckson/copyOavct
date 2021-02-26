package roboguice.activity.event;

import android.os.Bundle;

public class OnCreateEvent {
    protected Bundle savedInstanceState;

    public OnCreateEvent(Bundle bundle) {
        this.savedInstanceState = bundle;
    }

    public Bundle getSavedInstanceState() {
        return this.savedInstanceState;
    }
}
