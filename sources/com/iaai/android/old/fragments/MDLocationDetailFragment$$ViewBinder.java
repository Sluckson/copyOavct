package com.iaai.android.old.fragments;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.google.android.gms.maps.MapView;
import com.iaai.android.C2723R;
import com.iaai.android.old.fragments.MDLocationDetailFragment;

public class MDLocationDetailFragment$$ViewBinder<T extends MDLocationDetailFragment> implements ViewBinder<T> {
    public Unbinder bind(Finder finder, T t, Object obj) {
        return new InnerUnbinder(t, finder, obj);
    }

    /* compiled from: MDLocationDetailFragment$$ViewBinder */
    protected static class InnerUnbinder<T extends MDLocationDetailFragment> implements Unbinder {
        protected T target;

        protected InnerUnbinder(T t, Finder finder, Object obj) {
            this.target = t;
            t.txtAddress = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.md_txt_address, "field 'txtAddress'", TextView.class);
            t.txtDrivingDirection = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.md_txt_driving_direction, "field 'txtDrivingDirection'", TextView.class);
            t.txtWorkingHours = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.md_txt_working_hours_info, "field 'txtWorkingHours'", TextView.class);
            t.txtPhone = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.md_txt_phone_info, "field 'txtPhone'", TextView.class);
            t.txtBranchNote = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.md_txt_branch_note_info, "field 'txtBranchNote'", TextView.class);
            t.txtManager = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.md_txt_manager_info, "field 'txtManager'", TextView.class);
            t.txtFax = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.md_txt_fax_info, "field 'txtFax'", TextView.class);
            t.txtAuctionTime = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.md_txt_auction_time, "field 'txtAuctionTime'", TextView.class);
            t.imgBranchImage1 = (ImageView) finder.findRequiredViewAsType(obj, C2723R.C2726id.md_image1, "field 'imgBranchImage1'", ImageView.class);
            t.imgBranchImage2 = (ImageView) finder.findRequiredViewAsType(obj, C2723R.C2726id.md_image2, "field 'imgBranchImage2'", ImageView.class);
            t.txtVehiclePreview = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.md_txt_vehicle_preview_info, "field 'txtVehiclePreview'", TextView.class);
            t.txtVehiclePickup = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.md_txt_vehicle_pickup_info, "field 'txtVehiclePickup'", TextView.class);
            t.txtUpcomingAuctionTitle = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.md_txt_upcoming_auctions, "field 'txtUpcomingAuctionTitle'", TextView.class);
            t.txtPCB = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.md_txt_pcb, "field 'txtPCB'", TextView.class);
            t.txtaddstatereq = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.md_txt_add_state_req, "field 'txtaddstatereq'", TextView.class);
            t.layoutAuctions = (LinearLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.md_layout_upcoming_auctions, "field 'layoutAuctions'", LinearLayout.class);
            t.layoutItemSequence = (LinearLayout) finder.findRequiredViewAsType(obj, C2723R.C2726id.location_item_seq_layout, "field 'layoutItemSequence'", LinearLayout.class);
            t.txtDrivingDirectionInfo = (TextView) finder.findRequiredViewAsType(obj, C2723R.C2726id.md_txt_driving_direction_info, "field 'txtDrivingDirectionInfo'", TextView.class);
            t.mapView = (MapView) finder.findRequiredViewAsType(obj, C2723R.C2726id.md_mapview, "field 'mapView'", MapView.class);
        }

        public void unbind() {
            T t = this.target;
            if (t != null) {
                t.txtAddress = null;
                t.txtDrivingDirection = null;
                t.txtWorkingHours = null;
                t.txtPhone = null;
                t.txtBranchNote = null;
                t.txtManager = null;
                t.txtFax = null;
                t.txtAuctionTime = null;
                t.imgBranchImage1 = null;
                t.imgBranchImage2 = null;
                t.txtVehiclePreview = null;
                t.txtVehiclePickup = null;
                t.txtUpcomingAuctionTitle = null;
                t.txtPCB = null;
                t.txtaddstatereq = null;
                t.layoutAuctions = null;
                t.layoutItemSequence = null;
                t.txtDrivingDirectionInfo = null;
                t.mapView = null;
                this.target = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }
}
