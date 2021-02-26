package com.iaai.android.old.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.iaai.android.C2723R;
import com.iaai.android.old.models.AnnouncementsInfo;
import java.util.ArrayList;

public class AnnouncementActivity extends AppCompatActivity {
    ActionBar actionBar;
    ArrayList<AnnouncementsInfo> announcementArrayList;
    @BindView(2131296425)
    ListView announcementList;
    AnnouncementListAdapter announcementListAdapter;
    String custom_announcement;
    @BindView(2131298428)
    TextView toolbar_title;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_announcement_list);
        ButterKnife.bind((Activity) this);
        overridePendingTransition(C2723R.anim.push_left_in, C2723R.anim.no_change);
        setSupportActionBar((Toolbar) findViewById(C2723R.C2726id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        this.toolbar_title.setText(getResources().getString(C2723R.string.lbl_announcement));
        this.actionBar = getSupportActionBar();
        ActionBar actionBar2 = this.actionBar;
        if (actionBar2 != null) {
            actionBar2.setDisplayHomeAsUpEnabled(true);
        }
        this.announcementArrayList = getIntent().getParcelableArrayListExtra("announcement");
        this.custom_announcement = getIntent().getStringExtra("custom_announcement");
        this.announcementListAdapter = new AnnouncementListAdapter(this.announcementArrayList);
        this.announcementList.addHeaderView((ViewGroup) getLayoutInflater().inflate(C2723R.C2728layout.announcement_header, this.announcementList, false));
        this.announcementList.setAdapter(this.announcementListAdapter);
        TextView textView = (TextView) findViewById(C2723R.C2726id.lbl_custom_announcement);
        if (!this.custom_announcement.equalsIgnoreCase("")) {
            textView.setText(this.custom_announcement);
        } else {
            textView.setVisibility(8);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        onBackPressed();
        return true;
    }

    public class AnnouncementListAdapter extends BaseAdapter {
        private ArrayList<AnnouncementsInfo> announcementsInfos;

        public long getItemId(int i) {
            return 0;
        }

        public AnnouncementListAdapter(ArrayList<AnnouncementsInfo> arrayList) {
            this.announcementsInfos = arrayList;
            notifyDataSetChanged();
        }

        public int getCount() {
            ArrayList<AnnouncementsInfo> arrayList = this.announcementsInfos;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        public Object getItem(int i) {
            return this.announcementsInfos.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            AnnouncementHolder announcementHolder;
            if (view == null) {
                view = LayoutInflater.from(AnnouncementActivity.this.getApplication()).inflate(C2723R.C2728layout.announcement_list_content, viewGroup, false);
                announcementHolder = new AnnouncementHolder();
                announcementHolder.announcement_name = (TextView) view.findViewById(C2723R.C2726id.announcement_name);
            } else {
                announcementHolder = (AnnouncementHolder) view.getTag();
            }
            announcementHolder.announcement_name.setText(this.announcementsInfos.get(i).description);
            view.setTag(announcementHolder);
            return view;
        }
    }

    private static class AnnouncementHolder {
        TextView announcement_name;

        private AnnouncementHolder() {
        }
    }
}
