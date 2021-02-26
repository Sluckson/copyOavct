package com.iaai.android.old.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.old.models.ToBePickedUpVehicles;
import com.squareup.picasso.Picasso;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ToBePickedReviewPulloutAdapter extends BaseAdapter {
    Context context;
    private LayoutInflater inflater;
    ArrayList<ToBePickedUpVehicles> toBePickedUpVehicles;

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public ToBePickedReviewPulloutAdapter(ArrayList<ToBePickedUpVehicles> arrayList, Context context2) {
        this.context = context2;
        this.toBePickedUpVehicles = arrayList;
        this.inflater = (LayoutInflater) context2.getSystemService("layout_inflater");
    }

    public int getCount() {
        return this.toBePickedUpVehicles.size();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        int i2 = i;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = this.inflater.inflate(C2723R.C2728layout.custom_tobepickedupselection_row, (ViewGroup) null);
            viewHolder.stockID = (TextView) view2.findViewById(C2723R.C2726id.lbl_stock_id);
            viewHolder.branchName = (TextView) view2.findViewById(C2723R.C2726id.lbl_branchname);
            viewHolder.vin = (TextView) view2.findViewById(C2723R.C2726id.lbl_vin);
            viewHolder.ymm = (TextView) view2.findViewById(C2723R.C2726id.lbl_ymm);
            viewHolder.actionDue = (TextView) view2.findViewById(C2723R.C2726id.lbl_action_due);
            viewHolder.imgThumb = (ImageView) view2.findViewById(C2723R.C2726id.img_vehicle_thumb);
            viewHolder.fees = (TextView) view2.findViewById(C2723R.C2726id.lbl_fees);
            viewHolder.lane = (TextView) view2.findViewById(C2723R.C2726id.lbl_lane);
            viewHolder.offsite = (TextView) view2.findViewById(C2723R.C2726id.lbl_offsite);
            view2.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
            view2 = view;
        }
        viewHolder.lane.setVisibility(8);
        viewHolder.fees.setVisibility(0);
        viewHolder.offsite.setVisibility(0);
        String str = this.toBePickedUpVehicles.get(i2).imageUrl;
        if (TextUtils.isEmpty(str)) {
            Picasso.get().load((int) C2723R.C2725drawable.ic_image_na).into(viewHolder.imgThumb);
        } else {
            Picasso.get().load(str).resize(96, 72).onlyScaleDown().placeholder((int) C2723R.C2725drawable.progress_animation).error((int) C2723R.C2725drawable.ic_image_na).into(viewHolder.imgThumb);
        }
        viewHolder.stockID.setText(this.toBePickedUpVehicles.get(i2).stockNumber);
        viewHolder.branchName.setText(this.toBePickedUpVehicles.get(i2).branchName);
        viewHolder.vin.setText(this.toBePickedUpVehicles.get(i2).vin);
        viewHolder.ymm.setText(this.toBePickedUpVehicles.get(i2).yearMakeModel);
        if (this.toBePickedUpVehicles.get(i2).offsiteSaleIndicator == null || !this.toBePickedUpVehicles.get(i2).offsiteSaleIndicator.equalsIgnoreCase("true")) {
            viewHolder.offsite.setVisibility(8);
        } else {
            viewHolder.offsite.setText(this.context.getString(C2723R.string.product_dtl_offsite));
        }
        if (this.toBePickedUpVehicles.get(i2).salvageFeeIndicator == null || !this.toBePickedUpVehicles.get(i2).salvageFeeIndicator.equalsIgnoreCase("true")) {
            viewHolder.fees.setVisibility(8);
        } else {
            viewHolder.fees.setText(this.context.getString(C2723R.string.lbl_evp_fees));
        }
        Date date = getDate(this.toBePickedUpVehicles.get(i2).actionDate);
        Date date2 = new Date();
        if (date == null) {
            viewHolder.actionDue.setText("");
        } else if (date.compareTo(date2) > 0) {
            long time = (date.getTime() - date2.getTime()) / 86400000;
            if (time == 0) {
                TextView textView = viewHolder.actionDue;
                textView.setText(this.context.getString(C2723R.string.lbl_srt_due).trim() + "\n" + this.context.getString(C2723R.string.lbl_today) + " (0)");
            } else if (time == 1) {
                TextView textView2 = viewHolder.actionDue;
                textView2.setText(this.context.getString(C2723R.string.lbl_srt_due).trim() + "\n" + this.context.getString(C2723R.string.lbl_tomorrow) + " (+" + time + ")");
            } else {
                String format = new SimpleDateFormat("EEE").format(date);
                TextView textView3 = viewHolder.actionDue;
                textView3.setText(this.context.getString(C2723R.string.lbl_srt_due).trim() + "\n" + format + " (+" + time + ")");
            }
        } else if (date.compareTo(date2) < 0) {
            long time2 = (date2.getTime() - date.getTime()) / 86400000;
            if (time2 != 0) {
                TextView textView4 = viewHolder.actionDue;
                textView4.setText(this.context.getString(C2723R.string.tobe_pickedup_passdue) + "\n (-" + time2 + ")");
            } else {
                TextView textView5 = viewHolder.actionDue;
                textView5.setText(this.context.getString(C2723R.string.lbl_srt_due).trim() + "\n" + this.context.getString(C2723R.string.lbl_today) + " (0)");
            }
        } else if (date.compareTo(date2) == 0) {
            TextView textView6 = viewHolder.actionDue;
            textView6.setText(this.context.getString(C2723R.string.lbl_srt_due).trim() + "\n" + this.context.getString(C2723R.string.lbl_today) + " (0)");
        }
        return view2;
    }

    private Date getDate(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa", Locale.getDefault());
        if (str == null) {
            return null;
        }
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    class ViewHolder {
        TextView actionDue;
        TextView branchName;
        TextView fees;
        ImageView imgThumb;
        TextView lane;
        TextView offsite;
        TextView stockID;
        TextView vin;
        TextView ymm;

        ViewHolder() {
        }
    }
}
