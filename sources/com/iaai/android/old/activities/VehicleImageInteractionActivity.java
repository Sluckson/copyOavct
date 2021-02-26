package com.iaai.android.old.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.iaai.android.C2723R;
import com.iaai.android.old.utils.constants.Constants;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import roboguice.inject.InjectView;

public class VehicleImageInteractionActivity extends AbstractActivity {
    @InjectView(2131296462)
    ImageView back_arrow;
    @InjectView(2131296466)
    RelativeLayout back_arrow_layout;
    ImageGridAdapter imageGridAdapter;
    ImageListAdapter imageListAdapter;
    @InjectView(2131297136)
    ListView image_listview;
    List<String> image_url_list;
    @InjectView(2131297168)
    ImageView img_gridview;
    @InjectView(2131297173)
    ImageView img_listview;
    int index;
    String[] urls;
    /* access modifiers changed from: private */
    public int view_type;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.layout_image_interaction);
        this.urls = getIntent().getStringArrayExtra("url");
        this.index = getIntent().getIntExtra(Constants.EXTRA_IMAGE_INDEX, 0);
        this.view_type = getIntent().getIntExtra(Constants.EXTRA_VIEW_TYPE, 0);
        this.image_url_list = new ArrayList();
        String[] strArr = this.urls;
        if (strArr != null) {
            Collections.addAll(this.image_url_list, strArr);
        }
        this.back_arrow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                VehicleImageInteractionActivity.this.finish();
            }
        });
        this.img_gridview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int unused = VehicleImageInteractionActivity.this.view_type = Constants.VIEW_TYPE_GRID_IMAGE;
                VehicleImageInteractionActivity.this.updateSegmentedColor();
            }
        });
        this.img_listview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int unused = VehicleImageInteractionActivity.this.view_type = Constants.VIEW_TYPE_LIST_IMAGE;
                VehicleImageInteractionActivity.this.updateSegmentedColor();
            }
        });
        updateSegmentedColor();
    }

    /* access modifiers changed from: private */
    public void updateSegmentedColor() {
        if (this.view_type == Constants.VIEW_TYPE_GRID_IMAGE) {
            this.img_gridview.setImageResource(C2723R.C2725drawable.ic_img_gridview_black);
            this.img_gridview.setBackgroundColor(getResources().getColor(C2723R.C2724color.vehicle_segmented_control_border));
            this.img_listview.setImageResource(C2723R.C2725drawable.ic_img_listview_gray);
            this.img_listview.setBackgroundColor(getResources().getColor(C2723R.C2724color.vehicle_enlarge_img_color));
            this.imageGridAdapter = new ImageGridAdapter(this, this.image_url_list);
            this.image_listview.setAdapter(this.imageGridAdapter);
            return;
        }
        this.img_gridview.setImageResource(C2723R.C2725drawable.ic_img_gridview_gray);
        this.img_gridview.setBackgroundColor(getResources().getColor(C2723R.C2724color.vehicle_enlarge_img_color));
        this.img_listview.setImageResource(C2723R.C2725drawable.ic_img_listview_black);
        this.img_listview.setBackgroundColor(getResources().getColor(C2723R.C2724color.vehicle_segmented_control_border));
        this.imageListAdapter = new ImageListAdapter(this, this.image_url_list);
        this.image_listview.setAdapter(this.imageListAdapter);
    }

    class ImageListAdapter extends BaseAdapter {
        Context context;
        List<String> image_urls;

        public long getItemId(int i) {
            return (long) i;
        }

        public ImageListAdapter(Context context2, List<String> list) {
            this.image_urls = list;
            this.context = context2;
        }

        public int getCount() {
            return this.image_urls.size();
        }

        public Object getItem(int i) {
            return this.image_urls.get(i);
        }

        public View getView(final int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(this.context).inflate(C2723R.C2728layout.list_vehicle_image_layout, (ViewGroup) null);
                viewHolder = new ViewHolder();
                viewHolder.singleImage = (ImageView) view.findViewById(C2723R.C2726id.listimageview);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            Picasso.get().load(getItem(i).toString()).placeholder((int) C2723R.C2725drawable.progress_animation).fit().error((int) C2723R.C2725drawable.no_image_hd).into(viewHolder.singleImage);
            viewHolder.singleImage.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(VehicleImageInteractionActivity.this, VehicleNonHDFullImages.class);
                    intent.putExtra("url", (String[]) ImageListAdapter.this.image_urls.toArray(new String[0]));
                    intent.putExtra(Constants.EXTRA_IMAGE_INDEX, i);
                    intent.putExtra(Constants.EXTRA_VIEW_TYPE, Constants.VIEW_TYPE_ENLARGE_IMAGE);
                    intent.addFlags(67108864);
                    VehicleImageInteractionActivity.this.startActivity(intent);
                }
            });
            return view;
        }
    }

    class ImageGridAdapter extends BaseAdapter {
        Context context;
        List<String> image_urls;

        public long getItemId(int i) {
            return (long) i;
        }

        public ImageGridAdapter(Context context2, List<String> list) {
            this.image_urls = list;
            this.context = context2;
        }

        public int getCount() {
            double d;
            List<String> list = this.image_urls;
            if (list == null || list.size() == 0) {
                return 0;
            }
            if (this.image_urls.size() % 2 == 0) {
                d = (double) (this.image_urls.size() / 2);
            } else {
                d = Math.ceil(((double) this.image_urls.size()) / 2.0d);
            }
            return (int) d;
        }

        public Object getItem(int i) {
            if (i < this.image_urls.size()) {
                return this.image_urls.get(i);
            }
            return null;
        }

        public View getView(final int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            String str = null;
            if (view == null) {
                view = LayoutInflater.from(this.context).inflate(C2723R.C2728layout.grid_vehicle_image_layout, (ViewGroup) null);
                viewHolder = new ViewHolder();
                viewHolder.singleImage = (ImageView) view.findViewById(C2723R.C2726id.listimageview);
                viewHolder.secondImage = (ImageView) view.findViewById(C2723R.C2726id.second_image_view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            int i2 = i * 2;
            int i3 = i2 + 1;
            Picasso.get().load(getItem(i2) != null ? getItem(i2).toString() : null).placeholder((int) C2723R.C2725drawable.progress_animation).fit().error((int) C2723R.C2725drawable.no_image_hd).into(viewHolder.singleImage);
            if (getItem(i3) != null) {
                str = getItem(i3).toString();
            }
            if (str != null) {
                viewHolder.secondImage.setVisibility(0);
                Picasso.get().load(str).placeholder((int) C2723R.C2725drawable.progress_animation).fit().error((int) C2723R.C2725drawable.no_image_hd).into(viewHolder.secondImage);
            } else {
                viewHolder.secondImage.setVisibility(4);
            }
            viewHolder.singleImage.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(VehicleImageInteractionActivity.this, VehicleNonHDFullImages.class);
                    intent.putExtra("url", (String[]) ImageGridAdapter.this.image_urls.toArray(new String[0]));
                    intent.putExtra(Constants.EXTRA_IMAGE_INDEX, i * 2);
                    intent.putExtra(Constants.EXTRA_VIEW_TYPE, Constants.VIEW_TYPE_ENLARGE_IMAGE);
                    intent.addFlags(67108864);
                    VehicleImageInteractionActivity.this.startActivity(intent);
                }
            });
            viewHolder.secondImage.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(VehicleImageInteractionActivity.this, VehicleNonHDFullImages.class);
                    intent.putExtra("url", (String[]) ImageGridAdapter.this.image_urls.toArray(new String[0]));
                    intent.putExtra(Constants.EXTRA_IMAGE_INDEX, (i * 2) + 1);
                    intent.putExtra(Constants.EXTRA_VIEW_TYPE, Constants.VIEW_TYPE_ENLARGE_IMAGE);
                    intent.addFlags(67108864);
                    VehicleImageInteractionActivity.this.startActivity(intent);
                }
            });
            return view;
        }
    }

    class ViewHolder {
        ImageView secondImage;
        ImageView singleImage;

        ViewHolder() {
        }
    }
}
