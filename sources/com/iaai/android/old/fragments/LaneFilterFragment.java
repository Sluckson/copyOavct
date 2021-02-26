package com.iaai.android.old.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.adapter.CustomLaneAdapter;
import com.iaai.android.old.models.FilterSelect;
import com.lowagie.text.pdf.PdfBoolean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LaneFilterFragment extends Fragment {
    public CustomLaneAdapter adapter;
    public List<FilterSelect> filterSelects;
    private ListView listLane;
    /* access modifiers changed from: private */
    public OnLaneFilterInteractionListener mListener;

    public interface OnLaneFilterInteractionListener {
        void onLaneInteraction(int i);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C2723R.C2728layout.fragment_lane_filter, viewGroup, false);
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        IaaiApplication.isLaneFragmentSelected = true;
        this.filterSelects = new ArrayList();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.filterSelects = arguments.getParcelableArrayList("arraylist");
            boolean z = false;
            for (Map.Entry next : IaaiApplication.selectedFilters.entrySet()) {
                if (next.getKey().equals(Constants_MVVM.EXTRA_LANE)) {
                    int parseInt = Integer.parseInt((String) next.getValue());
                    this.filterSelects.get(parseInt).setSel_isSelected("true");
                    IaaiApplication.selectedLanePosition = parseInt;
                    z = true;
                }
                next.getKey().equals("laneValue");
                next.getKey().equals("sort");
                next.getKey().equals("sortValue");
                next.getKey().equals("fromYear");
                next.getKey().equals("toYear");
            }
            if (!z) {
                IaaiApplication.selectedLanePosition = 0;
                this.filterSelects.get(0).setSel_isSelected("true");
                IaaiApplication.selectedFilters.put(Constants_MVVM.EXTRA_LANE, "0");
            }
        }
        if (IaaiApplication.isResetApplied) {
            for (int i = 0; i < this.filterSelects.size(); i++) {
                this.filterSelects.get(i).setSel_isSelected(PdfBoolean.FALSE);
            }
        }
        for (Map.Entry next2 : IaaiApplication.selectedFilters.entrySet()) {
            if (next2.getKey().equals(Constants_MVVM.EXTRA_LANE)) {
                int parseInt2 = Integer.parseInt((String) next2.getValue());
                this.filterSelects.get(parseInt2).setSel_isSelected("true");
                IaaiApplication.selectedLanePosition = parseInt2;
            }
        }
        this.listLane = (ListView) getActivity().findViewById(C2723R.C2726id.fragment_list_lane);
        this.adapter = new CustomLaneAdapter(getActivity(), this.filterSelects);
        this.listLane.setAdapter(this.adapter);
        this.listLane.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                LaneFilterFragment.this.mListener.onLaneInteraction(i);
                IaaiApplication.isLaneFilterSelected = true;
                for (int i2 = 0; i2 < LaneFilterFragment.this.filterSelects.size(); i2++) {
                    if (i2 == i) {
                        LaneFilterFragment.this.filterSelects.get(i2).setSel_isSelected("true");
                        HashMap<String, String> hashMap = IaaiApplication.selectedFilters;
                        hashMap.put(Constants_MVVM.EXTRA_LANE, "" + i);
                        IaaiApplication.selectedFilters.put("laneValue", ((TextView) view.findViewById(C2723R.C2726id.sort_name)).getText().toString());
                    } else {
                        LaneFilterFragment.this.filterSelects.get(i2).setSel_isSelected(PdfBoolean.FALSE);
                    }
                }
                LaneFilterFragment.this.adapter.notifyDataSetChanged();
            }
        });
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.mListener = (OnLaneFilterInteractionListener) context;
        } catch (ClassCastException unused) {
            throw new ClassCastException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }
}
