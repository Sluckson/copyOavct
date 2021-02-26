package com.googlecode.android.widgets.DateSlider;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.googlecode.android.widgets.DateSlider.SliderContainer;
import com.iaai.android.C2723R;
import java.util.Calendar;

/* renamed from: com.googlecode.android.widgets.DateSlider.DateSlider */
public class C2716DateSlider extends Dialog {
    private View.OnClickListener cancelButtonClickListener;
    protected SliderContainer mContainer;
    protected Calendar mInitialTime;
    protected int mLayoutID;
    protected TextView mTitleText;
    protected Calendar maxTime;
    protected Calendar minTime;
    protected int minuteInterval;
    private View.OnClickListener okButtonClickListener;
    protected OnDateSetListener onDateSetListener;
    private SliderContainer.OnTimeChangeListener onTimeChangeListener;

    /* renamed from: com.googlecode.android.widgets.DateSlider.DateSlider$OnDateSetListener */
    public interface OnDateSetListener {
        void onDateSet(C2716DateSlider dateSlider, Calendar calendar);
    }

    public C2716DateSlider(Context context, int i, OnDateSetListener onDateSetListener2, Calendar calendar) {
        this(context, i, onDateSetListener2, calendar, (Calendar) null, (Calendar) null, 1);
    }

    public C2716DateSlider(Context context, int i, OnDateSetListener onDateSetListener2, Calendar calendar, int i2) {
        this(context, i, onDateSetListener2, calendar, (Calendar) null, (Calendar) null, i2);
    }

    public C2716DateSlider(Context context, int i, OnDateSetListener onDateSetListener2, Calendar calendar, Calendar calendar2, Calendar calendar3) {
        this(context, i, onDateSetListener2, calendar, calendar2, calendar3, 1);
    }

    public C2716DateSlider(Context context, int i, OnDateSetListener onDateSetListener2, Calendar calendar, Calendar calendar2, Calendar calendar3, int i2) {
        super(context);
        this.okButtonClickListener = new View.OnClickListener() {
            public void onClick(View view) {
                if (C2716DateSlider.this.onDateSetListener != null) {
                    OnDateSetListener onDateSetListener = C2716DateSlider.this.onDateSetListener;
                    C2716DateSlider dateSlider = C2716DateSlider.this;
                    onDateSetListener.onDateSet(dateSlider, dateSlider.getTime());
                }
                C2716DateSlider.this.dismiss();
            }
        };
        this.cancelButtonClickListener = new View.OnClickListener() {
            public void onClick(View view) {
                C2716DateSlider.this.dismiss();
            }
        };
        this.onTimeChangeListener = new SliderContainer.OnTimeChangeListener() {
            public void onTimeChange(Calendar calendar) {
                C2716DateSlider.this.setTitle();
            }
        };
        this.onDateSetListener = onDateSetListener2;
        this.minTime = calendar2;
        this.maxTime = calendar3;
        this.mInitialTime = Calendar.getInstance(calendar.getTimeZone());
        this.mInitialTime.setTimeInMillis(calendar.getTimeInMillis());
        this.mLayoutID = i;
        this.minuteInterval = i2;
        if (i2 > 1) {
            int i3 = this.mInitialTime.get(12);
            int i4 = this.minuteInterval;
            this.mInitialTime.add(12, ((((i4 / 2) + i3) / i4) * i4) - i3);
        }
    }

    public void onCreate(Bundle bundle) {
        Calendar calendar;
        super.onCreate(bundle);
        if (!(bundle == null || (calendar = (Calendar) bundle.getSerializable("time")) == null)) {
            this.mInitialTime = calendar;
        }
        requestWindowFeature(1);
        setContentView(this.mLayoutID);
        getWindow().setFeatureInt(7, C2723R.C2728layout.dialogtitle);
        this.mTitleText = (TextView) findViewById(C2723R.C2726id.dateSliderTitleText);
        this.mContainer = (SliderContainer) findViewById(C2723R.C2726id.dateSliderContainer);
        this.mContainer.setOnTimeChangeListener(this.onTimeChangeListener);
        this.mContainer.setMinuteInterval(this.minuteInterval);
        this.mContainer.setTime(this.mInitialTime);
        Calendar calendar2 = this.minTime;
        if (calendar2 != null) {
            this.mContainer.setMinTime(calendar2);
        }
        Calendar calendar3 = this.maxTime;
        if (calendar3 != null) {
            this.mContainer.setMaxTime(calendar3);
        }
        ((Button) findViewById(C2723R.C2726id.dateSliderOkButton)).setOnClickListener(this.okButtonClickListener);
        ((Button) findViewById(C2723R.C2726id.dateSliderCancelButton)).setOnClickListener(this.cancelButtonClickListener);
    }

    public void setTime(Calendar calendar) {
        this.mContainer.setTime(calendar);
    }

    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        onSaveInstanceState.putSerializable("time", getTime());
        return onSaveInstanceState;
    }

    /* access modifiers changed from: protected */
    public Calendar getTime() {
        return this.mContainer.getTime();
    }

    /* access modifiers changed from: protected */
    public void setTitle() {
        if (this.mTitleText != null) {
            Calendar time = getTime();
            TextView textView = this.mTitleText;
            textView.setText(getContext().getString(C2723R.string.dateSliderTitle) + String.format(": %te. %tB %tY", new Object[]{time, time, time}));
        }
    }
}
