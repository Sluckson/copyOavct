package com.iaai.android.old.fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.models.FilterSelect;
import com.iaai.android.old.utils.p016ui.YearPickerDialog;
import com.lowagie.text.pdf.PdfBoolean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateFilterFragment extends Fragment implements DatePickerDialog.OnDateSetListener {
    public List<FilterSelect> filterSelects;
    boolean isForFromYear = false;
    TextView lblFilterFrom;
    TextView lblFilterFromValue;
    TextView lblFilterTo;
    TextView lblFilterToValue;
    private OnDateInteractionListener mListener;

    public interface OnDateInteractionListener {
        void onDateInteraction();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C2723R.C2728layout.fragment_date_filter, viewGroup, false);
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        IaaiApplication.isDateFragmentSelected = true;
        this.lblFilterFrom = (TextView) getActivity().findViewById(C2723R.C2726id.lbl_filter_from_date);
        this.lblFilterFromValue = (TextView) getActivity().findViewById(C2723R.C2726id.lbl_filter_from_date_value);
        this.lblFilterTo = (TextView) getActivity().findViewById(C2723R.C2726id.lbl_filter_to_date);
        this.lblFilterToValue = (TextView) getActivity().findViewById(C2723R.C2726id.lbl_filter_to_date_value);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.filterSelects = arguments.getParcelableArrayList("arraylist");
        }
        if (IaaiApplication.isResetApplied) {
            this.filterSelects.get(0).setSel_isSelected(PdfBoolean.FALSE);
            this.filterSelects.get(0).setValue("");
            this.filterSelects.get(1).setSel_isSelected(PdfBoolean.FALSE);
            this.filterSelects.get(1).setValue("");
        }
        for (Map.Entry next : IaaiApplication.selectedFilters.entrySet()) {
            if (next.getKey().equals("fromYear")) {
                IaaiApplication.isDateModified = true;
                this.lblFilterFromValue.setText((String) next.getValue());
            }
            if (next.getKey().equals("toYear")) {
                IaaiApplication.isDateModified = true;
                this.lblFilterToValue.setText((String) next.getValue());
            }
        }
        if (this.filterSelects.get(0).getValue() != null && !this.filterSelects.get(0).getValue().equals("")) {
            this.lblFilterFromValue.setText(this.filterSelects.get(0).getValue());
        }
        if (this.filterSelects.get(1).getValue() != null && !this.filterSelects.get(1).getValue().equals("")) {
            this.lblFilterToValue.setText(this.filterSelects.get(1).getValue());
        }
        this.lblFilterFrom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DateFilterFragment.this.isForFromYear = true;
                YearPickerDialog yearPickerDialog = new YearPickerDialog();
                if (!DateFilterFragment.this.lblFilterFromValue.getText().toString().equals("")) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("selectedFromYear", Integer.parseInt(DateFilterFragment.this.lblFilterFromValue.getText().toString()));
                    bundle.putBoolean("isFromYearSelected", true);
                    yearPickerDialog.setArguments(bundle);
                } else {
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("isFirstTimeForFromYear", true);
                    yearPickerDialog.setArguments(bundle2);
                }
                yearPickerDialog.setListener(DateFilterFragment.this);
                yearPickerDialog.show(DateFilterFragment.this.getFragmentManager(), "FromYearPickerDialog");
            }
        });
        this.lblFilterTo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DateFilterFragment.this.isForFromYear = false;
                YearPickerDialog yearPickerDialog = new YearPickerDialog();
                if (!DateFilterFragment.this.lblFilterToValue.getText().toString().equals("")) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("selectedToYear", Integer.parseInt(DateFilterFragment.this.lblFilterToValue.getText().toString()));
                    bundle.putBoolean("isToYearSelected", true);
                    yearPickerDialog.setArguments(bundle);
                }
                yearPickerDialog.setListener(DateFilterFragment.this);
                yearPickerDialog.show(DateFilterFragment.this.getFragmentManager(), "ToYearPickerDialog");
            }
        });
    }

    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        if (this.isForFromYear) {
            IaaiApplication.isfromDateSelected = true;
            TextView textView = this.lblFilterFromValue;
            textView.setText("" + i3);
            this.filterSelects.get(0).setSel_isSelected("true");
            this.filterSelects.get(0).setValue("" + i3);
            HashMap<String, String> hashMap = IaaiApplication.selectedFilters;
            hashMap.put("fromYear", "" + i3);
            this.mListener.onDateInteraction();
            return;
        }
        IaaiApplication.isToDateSelected = true;
        TextView textView2 = this.lblFilterToValue;
        textView2.setText("" + i3);
        this.filterSelects.get(1).setSel_isSelected("true");
        this.filterSelects.get(1).setValue("" + i3);
        HashMap<String, String> hashMap2 = IaaiApplication.selectedFilters;
        hashMap2.put("toYear", "" + i3);
        this.mListener.onDateInteraction();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.mListener = (OnDateInteractionListener) context;
        } catch (ClassCastException unused) {
            throw new ClassCastException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }
}
