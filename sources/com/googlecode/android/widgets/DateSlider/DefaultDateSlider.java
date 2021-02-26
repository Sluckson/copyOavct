package com.googlecode.android.widgets.DateSlider;

import android.content.Context;
import com.googlecode.android.widgets.DateSlider.C2716DateSlider;
import com.iaai.android.C2723R;
import java.util.Calendar;

public class DefaultDateSlider extends C2716DateSlider {
    public DefaultDateSlider(Context context, C2716DateSlider.OnDateSetListener onDateSetListener, Calendar calendar, Calendar calendar2, Calendar calendar3) {
        super(context, C2723R.C2728layout.defaultdateslider, onDateSetListener, calendar, calendar2, calendar3);
    }

    public DefaultDateSlider(Context context, C2716DateSlider.OnDateSetListener onDateSetListener, Calendar calendar) {
        super(context, C2723R.C2728layout.defaultdateslider, onDateSetListener, calendar);
    }
}
