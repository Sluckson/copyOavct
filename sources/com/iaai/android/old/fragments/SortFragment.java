package com.iaai.android.old.fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.adapter.CustomSortAdapter;
import com.iaai.android.old.models.FilterSelect;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import com.lowagie.text.pdf.PdfBoolean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortFragment extends Fragment {
    public CustomSortAdapter adapter;
    /* access modifiers changed from: private */
    public ImageView btnDone;
    public List<FilterSelect> filterSelects;
    private ListView listSort;
    /* access modifiers changed from: private */
    public int listType = 0;
    /* access modifiers changed from: private */
    public OnSortFilterInteractionListener mListener;
    public EditText zipCode;

    public interface OnSortFilterInteractionListener {
        void onSortInteraction(int i);

        void onZIPCodeEnter();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C2723R.C2728layout.fragment_sort, viewGroup, false);
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        String enteredZIPCode;
        super.onActivityCreated(bundle);
        this.filterSelects = new ArrayList();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.filterSelects = arguments.getParcelableArrayList("arraylist");
            this.listType = arguments.getInt(Constants.LISTING_TYPE, -1);
            if (IaaiApplication.selectedFilters.size() > 0) {
                for (int i = 0; i < this.filterSelects.size(); i++) {
                    if (this.filterSelects.get(i).getSel_isSelected().equals("true")) {
                        IaaiApplication.selectedSortPosition = i;
                        this.filterSelects.get(i).setSel_isSelected("true");
                    }
                }
            } else if (this.listType == Constants.LIST_WATCHING || this.listType == Constants.LIST_PREBID) {
                IaaiApplication.selectedSortPosition = Constants.DEFAULT_SORT_OPTION_FOR_PRESALE;
                this.filterSelects.get(Constants.DEFAULT_SORT_OPTION_FOR_PRESALE).setSel_isSelected("true");
                HashMap<String, String> hashMap = IaaiApplication.selectedFilters;
                hashMap.put("sort", "" + Constants.DEFAULT_SORT_OPTION_FOR_PRESALE);
            } else if (this.listType == Constants.LIST_AWARD_PENDING) {
                IaaiApplication.selectedSortPosition = Constants.DEFAULT_SORT_OPTION_FOR_AWARDPENDING;
                this.filterSelects.get(Constants.DEFAULT_SORT_OPTION_FOR_AWARDPENDING).setSel_isSelected("true");
                HashMap<String, String> hashMap2 = IaaiApplication.selectedFilters;
                hashMap2.put("sort", "" + Constants.DEFAULT_SORT_OPTION_FOR_AWARDPENDING);
            } else if (this.listType == Constants.LIST_AUCTION_SALES) {
                IaaiApplication.selectedSortPosition = Constants.DEFAULT_SORT_OPTION_FOR_AUCTION_SALES;
                this.filterSelects.get(Constants.DEFAULT_SORT_OPTION_FOR_AUCTION_SALES).setSel_isSelected("true");
                HashMap<String, String> hashMap3 = IaaiApplication.selectedFilters;
                hashMap3.put("sort", "" + Constants.DEFAULT_SORT_OPTION_FOR_AUCTION_SALES);
            } else if (this.listType == Constants.LIST_LOST_PREBID) {
                IaaiApplication.selectedSortPosition = Constants.DEFAULT_SORT_OPTION_FOR_LOSTPREBID;
                this.filterSelects.get(Constants.DEFAULT_SORT_OPTION_FOR_LOSTPREBID).setSel_isSelected("true");
                HashMap<String, String> hashMap4 = IaaiApplication.selectedFilters;
                hashMap4.put("sort", "" + Constants.DEFAULT_SORT_OPTION_FOR_LOSTPREBID);
            } else if (this.listType == Constants.LIST_TOBE_PAID) {
                IaaiApplication.selectedSortPosition = Constants.DEFAULT_SORT_OPTION_FOR_TOBEPAID;
                this.filterSelects.get(Constants.DEFAULT_SORT_OPTION_FOR_TOBEPAID).setSel_isSelected("true");
                HashMap<String, String> hashMap5 = IaaiApplication.selectedFilters;
                hashMap5.put("sort", "" + Constants.DEFAULT_SORT_OPTION_FOR_TOBEPAID);
            } else if (this.listType == Constants.LIST_WON_HISTORY) {
                IaaiApplication.selectedSortPosition = Constants.DEFAULT_SORT_OPTION_FOR_WONHISTORY;
                this.filterSelects.get(Constants.DEFAULT_SORT_OPTION_FOR_WONHISTORY).setSel_isSelected("true");
                HashMap<String, String> hashMap6 = IaaiApplication.selectedFilters;
                hashMap6.put("sort", "" + Constants.DEFAULT_SORT_OPTION_FOR_WONHISTORY);
            } else if (this.listType == Constants.LIST_TOBE_PICKED) {
                IaaiApplication.selectedSortPosition = Constants.DEFAULT_SORT_OPTION_FOR_POSTSALE;
                this.filterSelects.get(Constants.DEFAULT_SORT_OPTION_FOR_POSTSALE).setSel_isSelected("true");
                HashMap<String, String> hashMap7 = IaaiApplication.selectedFilters;
                hashMap7.put("sort", "" + Constants.DEFAULT_SORT_OPTION_FOR_POSTSALE);
            } else if (this.listType == Constants.LIST_FAST_SEARCH_AUCTION) {
                IaaiApplication.selectedSortPosition = Constants.DEFAULT_SORT_OPTION_FOR_FAST_SEARCH_AUCTION;
                this.filterSelects.get(Constants.DEFAULT_SORT_OPTION_FOR_FAST_SEARCH_AUCTION).setSel_isSelected("true");
                HashMap<String, String> hashMap8 = IaaiApplication.selectedFilters;
                hashMap8.put("sort", "" + Constants.DEFAULT_SORT_OPTION_FOR_FAST_SEARCH_AUCTION);
            } else if (this.listType == Constants.LIST_FAST_SEARCH_VEHICLE && (enteredZIPCode = IAASharedPreference.getEnteredZIPCode(getContext())) != null && enteredZIPCode.length() == 0) {
                IaaiApplication.selectedSortPosition = Constants.DEFAULT_SORT_OPTION_FOR_FAST_SEARCH_VEHICLE;
                this.filterSelects.get(Constants.DEFAULT_SORT_OPTION_FOR_FAST_SEARCH_VEHICLE).setSel_isSelected("true");
                HashMap<String, String> hashMap9 = IaaiApplication.selectedFilters;
                hashMap9.put("sort", "" + Constants.DEFAULT_SORT_OPTION_FOR_FAST_SEARCH_VEHICLE);
            }
        }
        for (Map.Entry next : IaaiApplication.selectedFilters.entrySet()) {
            if (next.getKey().equals("sort")) {
                this.filterSelects.get(Integer.parseInt((String) next.getValue())).setSel_isSelected("true");
            }
        }
        this.listSort = (ListView) getActivity().findViewById(C2723R.C2726id.fragment_list_sort);
        if (this.listType == Constants.LIST_FAST_SEARCH_VEHICLE) {
            setZIPcode();
        }
        this.adapter = new CustomSortAdapter(getActivity(), this.filterSelects);
        this.listSort.setAdapter(this.adapter);
        this.listSort.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (SortFragment.this.listType == Constants.LIST_FAST_SEARCH_VEHICLE) {
                    i--;
                }
                SortFragment.this.mListener.onSortInteraction(i);
                IaaiApplication.isSortFilterSelected = true;
                for (int i2 = 0; i2 < SortFragment.this.filterSelects.size(); i2++) {
                    if (i2 == i) {
                        SortFragment.this.filterSelects.get(i2).setSel_isSelected("true");
                        IaaiApplication.selectedFilters.put("sort", "" + i);
                        IaaiApplication.selectedFilters.put("sortValue", ((TextView) view.findViewById(C2723R.C2726id.sort_name)).getText().toString());
                        if (SortFragment.this.listType == Constants.LIST_FAST_SEARCH_VEHICLE) {
                            if (SortFragment.this.btnDone != null) {
                                SortFragment.this.btnDone.setVisibility(8);
                            }
                            if (SortFragment.this.zipCode != null) {
                                SortFragment.this.zipCode.setText("");
                            }
                            IAASharedPreference.setEnteredZIPCode(SortFragment.this.getContext(), "");
                        }
                    } else {
                        SortFragment.this.filterSelects.get(i2).setSel_isSelected(PdfBoolean.FALSE);
                    }
                }
                SortFragment.this.adapter.notifyDataSetChanged();
            }
        });
    }

    private void setZIPcode() {
        View inflate = getLayoutInflater(getArguments()).inflate(C2723R.C2728layout.fast_search_sort_header, (ViewGroup) null);
        this.listSort.addHeaderView(inflate);
        this.zipCode = (EditText) inflate.findViewById(C2723R.C2726id.keyword_search);
        this.btnDone = (ImageView) inflate.findViewById(C2723R.C2726id.search_button);
        String enteredZIPCode = IAASharedPreference.getEnteredZIPCode(getContext());
        if (enteredZIPCode != null && enteredZIPCode.length() > 0) {
            this.zipCode.setText(enteredZIPCode);
            this.btnDone.setVisibility(0);
        }
        this.zipCode.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                int i = 0;
                if (editable.length() == 5) {
                    if (SortFragment.this.btnDone != null) {
                        SortFragment.this.btnDone.setVisibility(0);
                    }
                    SortFragment.this.mListener.onZIPCodeEnter();
                    while (i < SortFragment.this.filterSelects.size()) {
                        SortFragment.this.filterSelects.get(i).setSel_isSelected(PdfBoolean.FALSE);
                        i++;
                    }
                    IaaiApplication.selectedSortPosition = -1;
                    IAASharedPreference.setEnteredZIPCode(SortFragment.this.getContext(), editable.toString());
                    IaaiApplication.isFirstTimeForFilterDone = true;
                    IaaiApplication.selectedFilters.clear();
                    AppUtils.hideSoftkeyBoard(SortFragment.this.getActivity(), SortFragment.this.zipCode);
                    return;
                }
                SortFragment.this.btnDone.setVisibility(8);
                while (i < SortFragment.this.filterSelects.size()) {
                    if (SortFragment.this.filterSelects.get(i).getSel_isSelected().equals("true")) {
                        IaaiApplication.selectedSortPosition = i;
                        SortFragment.this.filterSelects.get(i).setSel_isSelected("true");
                    }
                    i++;
                }
                IAASharedPreference.setEnteredZIPCode(SortFragment.this.getContext(), "");
            }
        });
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.mListener = (OnSortFilterInteractionListener) context;
        } catch (ClassCastException unused) {
            throw new ClassCastException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = null;
    }
}
