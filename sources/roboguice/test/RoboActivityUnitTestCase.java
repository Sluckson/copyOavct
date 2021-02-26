package roboguice.test;

import android.app.Activity;
import android.test.ActivityUnitTestCase;

public class RoboActivityUnitTestCase<ActivityType extends Activity> extends ActivityUnitTestCase<ActivityType> {
    public RoboActivityUnitTestCase(Class<ActivityType> cls) {
        super(cls);
    }
}
