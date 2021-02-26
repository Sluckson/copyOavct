package com.iaai.android.old.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.old.models.ToBePickedUpBranchList;
import com.iaai.android.old.models.ToBePickedUpVehicles;
import com.squareup.picasso.Picasso;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class VPRExpandableListAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private List<ToBePickedUpBranchList> _listDataHeader;

    public long getChildId(int i, int i2) {
        return (long) i2;
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int i, int i2) {
        return false;
    }

    public VPRExpandableListAdapter(Context context, ArrayList<ToBePickedUpBranchList> arrayList) {
        this._context = context;
        this._listDataHeader = arrayList;
    }

    public Object getChild(int i, int i2) {
        return this._listDataHeader.get(i).vehicleArrayList.get(i2);
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        View view2;
        VehicleViewHolder vehicleViewHolder;
        ToBePickedUpVehicles toBePickedUpVehicles = (ToBePickedUpVehicles) getChild(i, i2);
        if (view == null) {
            vehicleViewHolder = new VehicleViewHolder();
            view2 = ((LayoutInflater) this._context.getSystemService("layout_inflater")).inflate(C2723R.C2728layout.custom_tobepickedupselection_row, (ViewGroup) null);
            vehicleViewHolder.stockID = (TextView) view2.findViewById(C2723R.C2726id.lbl_stock_id);
            vehicleViewHolder.branchName = (TextView) view2.findViewById(C2723R.C2726id.lbl_branchname);
            vehicleViewHolder.vin = (TextView) view2.findViewById(C2723R.C2726id.lbl_vin);
            vehicleViewHolder.ymm = (TextView) view2.findViewById(C2723R.C2726id.lbl_ymm);
            vehicleViewHolder.actionDue = (TextView) view2.findViewById(C2723R.C2726id.lbl_action_due);
            vehicleViewHolder.imgThumb = (ImageView) view2.findViewById(C2723R.C2726id.img_vehicle_thumb);
            vehicleViewHolder.fees = (TextView) view2.findViewById(C2723R.C2726id.lbl_fees);
            vehicleViewHolder.lane = (TextView) view2.findViewById(C2723R.C2726id.lbl_lane);
            vehicleViewHolder.offsite = (TextView) view2.findViewById(C2723R.C2726id.lbl_offsite);
            vehicleViewHolder.selectImageView = (ImageView) view2.findViewById(C2723R.C2726id.SelectImageView);
            view2.setTag(vehicleViewHolder);
        } else {
            vehicleViewHolder = (VehicleViewHolder) view.getTag();
            view2 = view;
        }
        String str = toBePickedUpVehicles.imageUrl;
        vehicleViewHolder.selectImageView.setVisibility(8);
        if (TextUtils.isEmpty(str)) {
            Picasso.get().load((int) C2723R.C2725drawable.ic_image_na).into(vehicleViewHolder.imgThumb);
        } else {
            Picasso.get().load(str).resize(96, 72).onlyScaleDown().placeholder((int) C2723R.C2725drawable.progress_animation).error((int) C2723R.C2725drawable.ic_image_na).into(vehicleViewHolder.imgThumb);
        }
        vehicleViewHolder.fees.setVisibility(0);
        vehicleViewHolder.offsite.setVisibility(0);
        vehicleViewHolder.stockID.setText(toBePickedUpVehicles.stockNumber);
        vehicleViewHolder.lane.setVisibility(8);
        vehicleViewHolder.branchName.setText(toBePickedUpVehicles.branchName);
        vehicleViewHolder.vin.setText(toBePickedUpVehicles.vin);
        vehicleViewHolder.ymm.setText(toBePickedUpVehicles.yearMakeModel);
        if (toBePickedUpVehicles.offsiteSaleIndicator.equalsIgnoreCase("true")) {
            vehicleViewHolder.offsite.setText(this._context.getString(C2723R.string.product_dtl_offsite));
        } else {
            vehicleViewHolder.offsite.setVisibility(8);
        }
        if (toBePickedUpVehicles.salvageFeeIndicator.equalsIgnoreCase("true")) {
            vehicleViewHolder.fees.setText(this._context.getString(C2723R.string.lbl_evp_fees));
        } else {
            vehicleViewHolder.fees.setVisibility(8);
        }
        String str2 = toBePickedUpVehicles.actionDate;
        if (str2 == null || TextUtils.isEmpty(str2)) {
            vehicleViewHolder.actionDue.setText("");
        } else {
            Date date = getDate(str2);
            Date date2 = new Date();
            if (date == null) {
                vehicleViewHolder.actionDue.setText("");
            } else if (date.compareTo(date2) > 0) {
                long time = (date.getTime() - date2.getTime()) / 86400000;
                if (time == 0) {
                    TextView textView = vehicleViewHolder.actionDue;
                    textView.setText(this._context.getString(C2723R.string.lbl_srt_due).trim() + "\n" + this._context.getString(C2723R.string.lbl_today) + " (0)");
                } else if (time == 1) {
                    TextView textView2 = vehicleViewHolder.actionDue;
                    textView2.setText(this._context.getString(C2723R.string.lbl_srt_due).trim() + "\n" + this._context.getString(C2723R.string.lbl_tomorrow) + " (+" + time + ")");
                } else {
                    String format = new SimpleDateFormat("EEE").format(date);
                    TextView textView3 = vehicleViewHolder.actionDue;
                    textView3.setText(this._context.getString(C2723R.string.lbl_srt_due).trim() + "\n" + format + " (+" + time + ")");
                }
            } else if (date.compareTo(date2) < 0) {
                long time2 = (date2.getTime() - date.getTime()) / 86400000;
                if (time2 != 0) {
                    TextView textView4 = vehicleViewHolder.actionDue;
                    textView4.setText(this._context.getString(C2723R.string.tobe_pickedup_passdue) + "\n (-" + time2 + ")");
                } else {
                    TextView textView5 = vehicleViewHolder.actionDue;
                    textView5.setText(this._context.getString(C2723R.string.lbl_srt_due).trim() + "\n" + this._context.getString(C2723R.string.lbl_today) + " (0)");
                }
            } else if (date.compareTo(date2) == 0) {
                TextView textView6 = vehicleViewHolder.actionDue;
                textView6.setText(this._context.getString(C2723R.string.lbl_srt_due).trim() + "\n" + this._context.getString(C2723R.string.lbl_today) + " (0)");
            }
        }
        return view2;
    }

    public int getChildrenCount(int i) {
        return this._listDataHeader.get(i).vehicleArrayList.size();
    }

    public Object getGroup(int i) {
        return this._listDataHeader.get(i);
    }

    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        View view2;
        BranchViewHolder branchViewHolder;
        ((ExpandableListView) viewGroup).expandGroup(i);
        ToBePickedUpBranchList toBePickedUpBranchList = (ToBePickedUpBranchList) getGroup(i);
        if (view == null) {
            branchViewHolder = new BranchViewHolder();
            view2 = ((LayoutInflater) this._context.getSystemService("layout_inflater")).inflate(C2723R.C2728layout.row_tobe_picked_up_vpr, (ViewGroup) null);
            branchViewHolder.branch_name = (TextView) view2.findViewById(C2723R.C2726id.branch_name);
            branchViewHolder.title_handling_instruction = (TextView) view2.findViewById(C2723R.C2726id.title_handling_instruction);
            branchViewHolder.thi_title = (TextView) view2.findViewById(C2723R.C2726id.thi_title);
            branchViewHolder.buyer_name = (TextView) view2.findViewById(C2723R.C2726id.buyer_name);
            branchViewHolder.title_vpr = (TextView) view2.findViewById(C2723R.C2726id.title_vpr);
            branchViewHolder.bold_pin = (TextView) view2.findViewById(C2723R.C2726id.bold_pin);
            branchViewHolder.pullout_vehicle_count = (TextView) view2.findViewById(C2723R.C2726id.pullout_vehicle_count);
            branchViewHolder.note_text = (TextView) view2.findViewById(C2723R.C2726id.note_text);
            branchViewHolder.text_title = (TextView) view2.findViewById(C2723R.C2726id.save_title);
            branchViewHolder.branch_separator_layout = (RelativeLayout) view2.findViewById(C2723R.C2726id.branch_separator_layout);
            view2.setTag(branchViewHolder);
        } else {
            view2 = view;
            branchViewHolder = (BranchViewHolder) view.getTag();
        }
        branchViewHolder.branch_name.setText(toBePickedUpBranchList.branch_name);
        branchViewHolder.title_handling_instruction.setText(toBePickedUpBranchList.titileHandlingInstructions);
        if (toBePickedUpBranchList.titileHandlingInstructions == null || toBePickedUpBranchList.titileHandlingInstructions.length() <= 0) {
            branchViewHolder.thi_title.setVisibility(8);
            branchViewHolder.title_handling_instruction.setVisibility(8);
        } else {
            branchViewHolder.thi_title.setVisibility(0);
            branchViewHolder.title_handling_instruction.setVisibility(0);
        }
        if (i == 0) {
            branchViewHolder.branch_separator_layout.setVisibility(8);
        } else {
            branchViewHolder.branch_separator_layout.setVisibility(0);
        }
        branchViewHolder.buyer_name.setText(toBePickedUpBranchList.buyerName);
        branchViewHolder.title_vpr.setText(toBePickedUpBranchList.title);
        TextView textView = branchViewHolder.bold_pin;
        textView.setText("" + toBePickedUpBranchList.pin);
        TextView textView2 = branchViewHolder.pullout_vehicle_count;
        textView2.setText(toBePickedUpBranchList.vehicleArrayList.size() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this._context.getString(C2723R.string.lbl_vehicle_s));
        TextView textView3 = branchViewHolder.note_text;
        textView3.setText("" + toBePickedUpBranchList.notes);
        TextView textView4 = branchViewHolder.text_title;
        textView4.setText("" + toBePickedUpBranchList.title);
        return view2;
    }

    class BranchViewHolder {
        TextView bold_pin;
        TextView branch_name;
        RelativeLayout branch_separator_layout;
        TextView buyer_name;
        TextView note_text;
        TextView pullout_vehicle_count;
        TextView text_title;
        TextView thi_title;
        TextView title_handling_instruction;
        TextView title_vpr;

        BranchViewHolder() {
        }
    }

    class VehicleViewHolder {
        TextView actionDue;
        TextView branchName;
        TextView fees;
        ImageView imgThumb;
        TextView lane;
        TextView offsite;
        ImageView selectImageView;
        TextView stockID;
        TextView vin;
        TextView ymm;

        VehicleViewHolder() {
        }
    }

    private Date getDate(String str) {
        try {
            return new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa", Locale.getDefault()).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
