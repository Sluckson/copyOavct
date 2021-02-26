package com.iaai.android.old.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.iaai.android.C2723R;
import com.iaai.android.old.models.ToBePickedUpVehicles;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.widgets.CustomPopupWindow;
import com.lowagie.text.pdf.PdfBoolean;
import com.squareup.picasso.Picasso;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class ToBePickedUpSelectionActivity extends MDAbstractActivity {
    private ImageButton btnBack;
    @BindView(2131296619)
    TextView btnCreatePullout;
    private ImageButton btnMenu;
    private float disable_bg = 0.5f;
    private float enable_bg = 1.0f;
    private boolean isAllSelected = false;
    private boolean isSelectAllClicked = false;
    CustomPopupWindow popupWindow;
    ArrayList<ToBePickedUpVehicles> selectedItems = null;
    private int selectedPositionByLongClick = -1;
    @BindView(2131298405)
    ListView tobepickedListView;
    ArrayList<ToBePickedUpVehicles> vehicleArrayList = null;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_tobe_picked_selection_layout);
        ButterKnife.bind((Activity) this);
        setSupportActionBar((Toolbar) findViewById(C2723R.C2726id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        this.btnCreatePullout.setEnabled(false);
        this.btnCreatePullout.setAlpha(this.disable_bg);
        this.vehicleArrayList = getIntent().getParcelableArrayListExtra("vehiclesList");
        this.isAllSelected = getIntent().getBooleanExtra("all_selected", false);
        this.selectedPositionByLongClick = getIntent().getIntExtra("selected_position", -1);
        ArrayList<ToBePickedUpVehicles> arrayList = this.vehicleArrayList;
        if (arrayList != null && arrayList.size() > 0) {
            this.tobepickedListView.setAdapter(new ToBePickedAdapter(this.vehicleArrayList, getApplicationContext()));
        }
        this.btnCreatePullout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SparseBooleanArray checkedItemPositions = ToBePickedUpSelectionActivity.this.tobepickedListView.getCheckedItemPositions();
                ToBePickedUpSelectionActivity.this.selectedItems = new ArrayList<>();
                for (int i = 0; i < checkedItemPositions.size(); i++) {
                    int keyAt = checkedItemPositions.keyAt(i);
                    if (checkedItemPositions.valueAt(i)) {
                        ToBePickedUpSelectionActivity.this.selectedItems.add(ToBePickedUpSelectionActivity.this.vehicleArrayList.get(keyAt));
                    }
                }
                ArrayList arrayList = new ArrayList();
                Iterator<ToBePickedUpVehicles> it = ToBePickedUpSelectionActivity.this.selectedItems.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(it.next().salvage)));
                }
                ToBePickedUpSelectionActivity.this.finish();
                Intent intent = new Intent(ToBePickedUpSelectionActivity.this, ToBePickedUpReviewPulloutActivity.class);
                intent.putIntegerArrayListExtra("salvage_id_array", arrayList);
                ToBePickedUpSelectionActivity.this.startActivity(intent);
            }
        });
        if (this.isAllSelected) {
            selectAllItems();
        } else {
            ActionBar supportActionBar = getSupportActionBar();
            supportActionBar.setTitle((CharSequence) "0 " + getString(C2723R.string.lbl_selected));
        }
        this.tobepickedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ToBePickedUpSelectionActivity.this.updateSelectUI();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C2723R.C2729menu.menu_tobepicked_selection, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                finish();
                break;
            case C2723R.C2726id.menu_tobepickedup_clearselected:
                SparseBooleanArray checkedItemPositions = this.tobepickedListView.getCheckedItemPositions();
                for (int i = 0; i < checkedItemPositions.size(); i++) {
                    if (checkedItemPositions.valueAt(i)) {
                        this.tobepickedListView.setItemChecked(i, false);
                    }
                }
                updateSelectUI();
                break;
            case C2723R.C2726id.menu_tobepickedup_select_all:
                selectAllItems();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    private void selectAllItems() {
        ListView listView = this.tobepickedListView;
        int count = listView.getCount();
        int i = 0;
        for (int i2 = 0; i2 < count; i2++) {
            if (listView.getAdapter().isEnabled(i2)) {
                listView.setItemChecked(i2, true);
                i++;
            } else {
                listView.setItemChecked(i2, false);
            }
        }
        if (i <= 0) {
            this.btnCreatePullout.setEnabled(false);
            this.btnCreatePullout.setAlpha(this.disable_bg);
        } else {
            this.btnCreatePullout.setEnabled(true);
            this.btnCreatePullout.setAlpha(this.enable_bg);
        }
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle((CharSequence) i + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getString(C2723R.string.lbl_selected));
    }

    /* access modifiers changed from: private */
    public void updateSelectUI() {
        SparseBooleanArray checkedItemPositions = this.tobepickedListView.getCheckedItemPositions();
        int i = 0;
        for (int i2 = 0; i2 < checkedItemPositions.size(); i2++) {
            if (checkedItemPositions.valueAt(i2)) {
                i++;
            }
        }
        if (i <= 0) {
            this.btnCreatePullout.setEnabled(false);
            this.btnCreatePullout.setAlpha(this.disable_bg);
        } else {
            this.btnCreatePullout.setEnabled(true);
            this.btnCreatePullout.setAlpha(this.enable_bg);
        }
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle((CharSequence) i + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getString(C2723R.string.lbl_selected));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    class ToBePickedAdapter extends BaseAdapter {
        Context context;
        private LayoutInflater inflater;
        ArrayList<ToBePickedUpVehicles> toBePickedUpVehicles;

        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return 0;
        }

        ToBePickedAdapter(ArrayList<ToBePickedUpVehicles> arrayList, Context context2) {
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
            Date date = null;
            if (view == null) {
                viewHolder = new ViewHolder();
                view2 = this.inflater.inflate(C2723R.C2728layout.custom_tobepickedupselection_row, (ViewGroup) null);
                viewHolder.stockID = (TextView) view2.findViewById(C2723R.C2726id.lbl_stock_id);
                viewHolder.branchName = (TextView) view2.findViewById(C2723R.C2726id.lbl_branchname);
                viewHolder.vin = (TextView) view2.findViewById(C2723R.C2726id.lbl_vin);
                viewHolder.ymm = (TextView) view2.findViewById(C2723R.C2726id.lbl_ymm);
                viewHolder.actionDue = (TextView) view2.findViewById(C2723R.C2726id.lbl_action_due);
                viewHolder.imgThumb = (ImageView) view2.findViewById(C2723R.C2726id.img_vehicle_thumb);
                viewHolder.selectImageView = (ImageView) view2.findViewById(C2723R.C2726id.SelectImageView);
                viewHolder.fees = (TextView) view2.findViewById(C2723R.C2726id.lbl_fees);
                viewHolder.lane = (TextView) view2.findViewById(C2723R.C2726id.lbl_lane);
                viewHolder.lbl_action = (TextView) view2.findViewById(C2723R.C2726id.lbl_action);
                view2.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
                view2 = view;
            }
            String str = this.toBePickedUpVehicles.get(i2).imageUrl;
            if (TextUtils.isEmpty(str)) {
                Picasso.get().load((int) C2723R.C2725drawable.ic_image_na).into(viewHolder.imgThumb);
            } else {
                Picasso.get().load(str).resize(96, 72).onlyScaleDown().placeholder((int) C2723R.C2725drawable.progress_animation).error((int) C2723R.C2725drawable.ic_image_na).into(viewHolder.imgThumb);
            }
            viewHolder.stockID.setText(this.toBePickedUpVehicles.get(i2).stockNumber);
            viewHolder.branchName.setText(this.toBePickedUpVehicles.get(i2).branchName);
            viewHolder.lane.setText(this.toBePickedUpVehicles.get(i2).laneItemNumber);
            viewHolder.vin.setText(this.toBePickedUpVehicles.get(i2).vin);
            viewHolder.ymm.setText(this.toBePickedUpVehicles.get(i2).yearMakeModel);
            String str2 = this.toBePickedUpVehicles.get(i2).actionDate;
            viewHolder.lbl_action.setVisibility(8);
            viewHolder.actionDue.setBackgroundColor(this.context.getResources().getColor(C2723R.C2724color.dash_bg));
            viewHolder.actionDue.setTextColor(this.context.getResources().getColor(C2723R.C2724color.tab_black));
            Date date2 = new Date();
            if (str2 != null) {
                date = ToBePickedUpSelectionActivity.this.getDate(str2);
                date2 = new Date();
            }
            if (isEnabled(i)) {
                viewHolder.selectImageView.setVisibility(0);
            } else {
                viewHolder.selectImageView.setVisibility(4);
            }
            if (date == null) {
                viewHolder.actionDue.setText("C.O.D");
                viewHolder.actionDue.setBackgroundColor(this.context.getResources().getColor(C2723R.C2724color.dash_bg));
            } else if (date.compareTo(date2) > 0) {
                long time = (date.getTime() - date2.getTime()) / 86400000;
                if (time == 0) {
                    viewHolder.actionDue.setTextColor(this.context.getResources().getColor(C2723R.C2724color.dash_bg));
                    viewHolder.actionDue.setBackgroundResource(C2723R.C2725drawable.tomorrow_round_rect_bg);
                    TextView textView = viewHolder.actionDue;
                    textView.setText(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.context.getString(C2723R.string.lbl_today) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                } else if (time == 1) {
                    viewHolder.actionDue.setText(this.context.getString(C2723R.string.lbl_tomorrow));
                } else {
                    viewHolder.actionDue.setText(new SimpleDateFormat(Constants.DATE_PATTERN_MD_LOCATION_SHORT).format(date));
                }
            } else if (date.compareTo(date2) < 0) {
                long time2 = (date2.getTime() - date.getTime()) / 86400000;
                if (time2 != 0) {
                    viewHolder.lbl_action.setVisibility(0);
                    viewHolder.lbl_action.setText(this.context.getString(C2723R.string.tobe_pickedup_passdue));
                    viewHolder.actionDue.setTextColor(this.context.getResources().getColor(C2723R.C2724color.dash_bg));
                    viewHolder.actionDue.setBackgroundResource(C2723R.C2725drawable.pass_due_round_rect_bg);
                    if (time2 == 1) {
                        TextView textView2 = viewHolder.actionDue;
                        textView2.setText(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.context.getString(C2723R.string.lbl_yesterday) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    } else {
                        TextView textView3 = viewHolder.actionDue;
                        textView3.setText(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + time2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.context.getString(C2723R.string.tobe_pickedup_days) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    }
                } else {
                    viewHolder.actionDue.setTextColor(this.context.getResources().getColor(C2723R.C2724color.dash_bg));
                    viewHolder.actionDue.setBackgroundResource(C2723R.C2725drawable.tomorrow_round_rect_bg);
                    TextView textView4 = viewHolder.actionDue;
                    textView4.setText(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.context.getString(C2723R.string.lbl_today) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                }
            } else if (date.compareTo(date2) == 0) {
                viewHolder.actionDue.setTextColor(this.context.getResources().getColor(C2723R.C2724color.dash_bg));
                viewHolder.actionDue.setBackgroundResource(C2723R.C2725drawable.tomorrow_round_rect_bg);
                TextView textView5 = viewHolder.actionDue;
                textView5.setText(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.context.getString(C2723R.string.lbl_today) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            }
            return view2;
        }

        public boolean isEnabled(int i) {
            return !this.toBePickedUpVehicles.get(i).pullOutQualified.equals(PdfBoolean.FALSE) && Integer.parseInt(this.toBePickedUpVehicles.get(i).pin) <= 0;
        }
    }

    class ViewHolder {
        TextView actionDue;
        TextView branchName;
        TextView fees;
        ImageView imgThumb;
        TextView lane;
        TextView lbl_action;
        ImageView selectImageView;
        TextView stockID;
        TextView vin;
        TextView ymm;

        ViewHolder() {
        }
    }

    /* access modifiers changed from: private */
    public Date getDate(String str) {
        try {
            return new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa", Locale.getDefault()).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
