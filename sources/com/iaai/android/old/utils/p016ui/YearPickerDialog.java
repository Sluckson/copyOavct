package com.iaai.android.old.utils.p016ui;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.iaai.android.C2723R;
import java.util.Calendar;

/* renamed from: com.iaai.android.old.utils.ui.YearPickerDialog */
public class YearPickerDialog extends DialogFragment {
    private static final int FIRST_TIME_FROM_YEAR = 2000;
    private static final int MAX_YEAR = 2099;
    private static final int MIN_YEAR = 1900;
    boolean isFirstTimeForFromYear = false;
    boolean isFromYearSelected = false;
    boolean isToYearSelected = false;
    /* access modifiers changed from: private */
    public DatePickerDialog.OnDateSetListener listener;
    int selectedFromyear = 0;
    int selectedToYear = 0;

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.isFirstTimeForFromYear = arguments.getBoolean("isFirstTimeForFromYear");
            this.selectedFromyear = arguments.getInt("selectedFromYear");
            this.isFromYearSelected = arguments.getBoolean("isFromYearSelected");
            this.selectedToYear = arguments.getInt("selectedToYear");
            this.isToYearSelected = arguments.getBoolean("isToYearSelected");
        }
    }

    public void setListener(DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.listener = onDateSetListener;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        Calendar instance = Calendar.getInstance();
        View inflate = layoutInflater.inflate(C2723R.C2728layout.date_picker_dialog, (ViewGroup) null);
        final NumberPicker numberPicker = (NumberPicker) inflate.findViewById(C2723R.C2726id.picker_year);
        int i = instance.get(1) + 1;
        numberPicker.setMinValue(MIN_YEAR);
        numberPicker.setMaxValue(i);
        if (this.isFromYearSelected) {
            numberPicker.setValue(this.selectedFromyear);
        } else {
            numberPicker.setValue(i);
        }
        if (!this.isFromYearSelected) {
            if (this.isToYearSelected) {
                numberPicker.setValue(this.selectedToYear);
            } else if (this.isFirstTimeForFromYear) {
                numberPicker.setValue(2000);
            } else {
                numberPicker.setValue(i);
            }
        }
        builder.setView(inflate).setPositiveButton((CharSequence) getString(C2723R.string.btn_apply), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                YearPickerDialog.this.listener.onDateSet((DatePicker) null, 0, 0, numberPicker.getValue());
            }
        }).setNegativeButton((CharSequence) getString(C2723R.string.lbl_cancel), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                YearPickerDialog.this.getDialog().cancel();
            }
        });
        return builder.create();
    }
}
